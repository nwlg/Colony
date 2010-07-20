/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.negocio.cambios;

import java.io.File;

//import org.acegisecurity.userdetails.ldap.LdapUserDetails;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import es.pode.modificador.ServiceLocator;
import es.pode.modificador.negocio.cambios.configuracion.ModificadorProperties;
import es.pode.modificador.negocio.servicio.ModificacionVO;
import es.pode.modificador.negocio.servicio.ResultadoModificacionVO;
import es.pode.modificador.negocio.utilidades.EstadosTarea;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.SCORM2004Dao;
import es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega;
import es.pode.parseadorXML.castor.Manifest;
import es.pode.parseadorXML.scorm2004.agrega.ManifestAgrega;
//import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;
import es.pode.soporte.zip.ZipDao;



public class TareaCambios {
	

	
	private Logger logger = Logger.getLogger(TareaCambios.class);
	
	private Cambio[] cambios = null;
	
	private ODE[] odes = null;
	
	private ZipDao zipDao=null; 
	private SCORM2004Dao scormDao=null;
	private String MANIFEST_NAME="imsmanifest.xml";
	private ModificadorProperties props = null;
	private Appender apender = null;
	
	private boolean destructiva = false;
	
	private static String VACIA ="";
	
	
	/**
	 * Visibilidad package para evitar que se instancie directamente desde el
	 * servicio. Debe ser instanciada por la FactoriaCambios
	 * 
	 * @param cambios
	 * @param odes
	 */
	TareaCambios(Cambio[] cambios, ODE[] odes) {
		this.setCambios(cambios);
		this.setOdes(odes);
	}
	
	
	/**
	 * @see ejecutarTarea(true)
	 * 
	 * @return El retorno es un array con el resultado de la modificacion de
	 *         cada ODE.
	 */
	public ResultadoModificacionVO[] ejecutarTarea() {
		return ejecutarTarea(false);
	}
	
	/**
	 * <p>
	 * Metodo para iniciar la tarea de modificacion. Recorre el array de odes y
	 * por cada ODE ejecuta el array de cambios solicitados.
	 * </p>
	 * <p>
	 * Previamente a la ejecucion de los cambios, se debe:
	 * </p>
	 * 
	 * <ul>
	 * <li>Preparar el fichero de traza para el ode a modificar</li>
	 * <li>generar un backup del ODE</li>
	 * <li>copiar el ODE original a la localizacion de taller, donde se aplican
	 * los cambios</li>
	 * </ul>
	 * <p>
	 * Al finalizar las modificaciones, se debe validar el manifest resultante,
	 * generar el fichero de traza correspondiente y eliminar la localizacion de
	 * taller.
	 * </p>
	 * 
	 * @param simulacion
	 *            Determina si es una ejecucion real o una simulacion para
	 *            validar la tarea. La simulacion no aplica los cambios sobre el
	 *            ODE original.
	 * @return El retorno es un array con el resultado de la modificacion de
	 *         cada ODE.
	 * @throws AlmacenamientoException
	 * @throws ParseadorException
	 */
	public ResultadoModificacionVO[] ejecutarTarea(boolean simulacion)  
	{
	
		Manifest manifestImportado = null;
		EstadosTarea estado=null;
		/*
		 * Si existe el array de odes y al menos tiene un elemento
		 * Si hay al menos un cambio
		 */
		ResultadoModificacionVO[] resultModificacion;
		if(odes!=null && odes.length>0 && cambios!=null && cambios.length>0)
		{
			resultModificacion= new ResultadoModificacionVO[odes.length];
			for(int i=0; i<odes.length;i++)
			{
				//Relleno los datos del ODE para el registro de la tarea
				resultModificacion[i] = new ResultadoModificacionVO();
				resultModificacion[i].setIdOde(odes[i].getPathOriginal());
				resultModificacion[i].setPathTraza(odes[i].getTraza());
				resultModificacion[i].setPathOriginal(odes[i].getPathOriginal());
				resultModificacion[i].setPathBackup(odes[i].getBackup()!=null?odes[i].getBackup():VACIA);
				resultModificacion[i].setPublicado(Boolean.valueOf(odes[i].isPublicado()));
				try
				{
					prepararTarea(odes[i],simulacion);
				}
				catch (Exception e) 
				{
					logger.error("No se ha podido preparar la tarea del ode "+odes[i].getPathOriginal(),e);
					if(logger.isDebugEnabled()) logger.debug(e);
					resultModificacion[i].setStatus(EstadosTarea.ERROR);
					resultModificacion[i].setMsgError(CodigosMensajesError.ERROR_PREPARACION_ODE);
					finalizarTarea(odes[i], false, simulacion, null);
					continue;
				}
				String rutaManifest=null;
				if(odes[i].getPathTaller().charAt(odes[i].getPathTaller().length()-1)=='/')
				{
					rutaManifest=odes[i].getPathTaller() + MANIFEST_NAME;
				}
				else
				{
					rutaManifest=odes[i].getPathTaller() + "/" + MANIFEST_NAME;
				}
				
				//parseo el manifest
				File rutaXml = new File(rutaManifest);
				try {
					manifestImportado = this.scormDao.parsearODELazy(rutaXml);
					ManifestAgrega manAgrega = new ManifestAgrega(manifestImportado);
					LomAgrega lomAgrega= new LomAgrega(manAgrega.obtenerLom(manifestImportado.getIdentifier(), null));
					// Si he consegido el manifest, recupero el identificador del ODE para registrarlo
					resultModificacion[i].setIdOde(lomAgrega.getGeneralAgrega().getPrimerIdentificador());
					//Título en idioma de navegación 
					
					String idioma = null;
					if(LdapUserDetailsUtils.estaAutenticado()) {
						idioma = LdapUserDetailsUtils.getIdioma()!=null?LdapUserDetailsUtils.getIdioma():"es";
					}
					
					resultModificacion[i].setTitulo(lomAgrega.getGeneralAgrega().getTitulo(idioma));
				} catch (Exception e) {
					logger.error("No se ha podido parsear el ode "+odes[i].getPathOriginal(),e);
					if(logger.isDebugEnabled()) logger.debug(e);
					resultModificacion[i].setStatus(EstadosTarea.ERROR);
					resultModificacion[i].setMsgError(CodigosMensajesError.ERROR_PARSEO_ODE);
					finalizarTarea(odes[i], false, simulacion, null);
					continue;
				}
				
				// Compruebo que el ODE que va a ser modificado no ha sido
				// modificado previamente por una tarea que todavia puede
				// restaurar el backup de ese ODE.
				if(checkearOde(resultModificacion[i].getPathOriginal())) {
					logger.error("El ode " + odes[i].getPathOriginal() + " ha sido modificado por una tarea anterior. Los cambios no se pueden aplicar hasta que se elimine dicha tarea o se restaure la copia de seguridad.");
					resultModificacion[i].setStatus(EstadosTarea.ERROR);
					resultModificacion[i].setMsgError(CodigosMensajesError.ODE_MODIFICADO_POR_OTRA_TAREA);
					finalizarTarea(odes[i], false, simulacion, null);
					continue;
				}
				
				logger.info("Se ha parseado el ode "+odes[i].getPathOriginal());
				boolean resultadoCambios = true;
				for(int j=0; j<cambios.length;j++)
				{
					// Ejecuto el cambio individual. Si no se ejecuta con exito, pongo el resultado global a false.
					if(!cambios[j].ejecutar(manifestImportado,apender,new File(odes[i].getPathTaller()).getAbsolutePath())) resultadoCambios=false;
				}
				
				boolean resultadoValidacion;
				
				if (isDestructiva()) {
					try {
						this.scormDao.escribirODE(manifestImportado, rutaXml);
					} catch (Exception e) {
						logger.error("No se ha podido escribir el ode "
								+ odes[i].getPathOriginal());
						if (logger.isDebugEnabled())
							logger.debug(e);
						resultModificacion[i].setStatus(EstadosTarea.ERROR);
						resultModificacion[i]
								.setMsgError(CodigosMensajesError.ERROR_ESCRITURA_ODE);
						finalizarTarea(odes[i], false, simulacion, null);
						continue;
					}
					/*
					 * Ejecuto una validacion para comprobar que los cambios han
					 * generado un ODE valido
					 */
					ValidacionManifest validacion = new ValidacionManifest();
					resultadoValidacion = validacion
							.ejecutar(null, apender, new File(odes[i]
									.getPathTaller()).getAbsolutePath());
				} else {
					resultadoValidacion=true;
					logger.debug("Como no es destructiva, no escribimos cambios ni validamos.");
				}
				/*
				 * Finalizo la tarea en funcion del resultado y de si es simulada
				 */
				boolean resultadoFinalizar = finalizarTarea(odes[i], resultadoValidacion, simulacion, resultModificacion[i].getIdOde());
				/*
				 * ESTADO DE LA MODIFICACION:
				 * ERROR - resultadoValidacion = false || resultadoFinalizar = false
				 * WARNING - resultadoValidacion = true && resultadoFinalizar = true && resultadoCambios = false
				 * FINALIZADO - resultadoValidacion = true && resultadoFinalizar = true && resultadoCambios = true
				 */
				if(resultadoValidacion && resultadoFinalizar) {
					if(resultadoCambios) {
						estado = EstadosTarea.FINALIZADA;
					} else {
						estado = EstadosTarea.WARNING;
						resultModificacion[i].setMsgError(CodigosMensajesError.WARNING);
					}
				} else {
					estado = EstadosTarea.ERROR;
					resultModificacion[i].setMsgError((resultadoValidacion?CodigosMensajesError.ERROR_FINALIZACION_ODE:CodigosMensajesError.ERROR_VALIDACION_ODE));
				}
				
				resultModificacion[i].setStatus(estado);
			}
		} else {
			resultModificacion=new ResultadoModificacionVO[]{};
		}
		return resultModificacion;
	}
	
	private boolean checkearOde(String pathOriginal) {
		boolean result = false;
		ModificacionVO[] modificaciones = ServiceLocator.instance().getSrvHerramientaModificacion().chequearResultadosODE(pathOriginal);
		if(modificaciones!=null && modificaciones.length>0) {
			result = true;
		}
		return result;
	}
	
	private boolean finalizarTarea(ODE ode, boolean resultadoValidacion, boolean simulacion, String identificador) {
		boolean result = false;
		if(resultadoValidacion && !simulacion &&isDestructiva()) {
			logger.info("Aplicando los cambios a la localización original");
			try {
				boolean borrado=true;
				if(ode.isComprimido()) {
					borrado=new File(ode.getPathOriginal()).delete();
					if(!borrado) {
						logger.error("No se pudo borrar el zip original en "+ode.getPathOriginal());
					} else {
						logger.debug("Comprimo "+ode.getPathOriginal()+" en "+ode.getPathTaller());
						getZipDao().comprimir(ode.getPathOriginal(), ode.getPathTaller());
					}
				} else {
					File origen = new File(ode.getPathTaller());
					File destino = new File(ode.getPathOriginal());
					logger.debug("Copio "+ode.getPathTaller()+" en "+ode.getPathOriginal());
					UtilesFicheros.copiar(origen, destino);
				}
				result = borrado;
			} catch (Exception e) {
				logger.error("No se han aplicado los cambios con exito. Restaurando copia de seguridad");
				if(logger.isDebugEnabled()) logger.debug(e);
				restaurar(ode);
			}
		} else {
			if (StringUtils.isNotEmpty(ode.getBackup())) {
				logger.info("Eliminando copia de seguridad");
				borrarLocalizacion(ode.getBackup());
			}
			if(simulacion && resultadoValidacion) result=true;
			if(!isDestructiva() && resultadoValidacion) result=true;
		}
		//Borrar taller
		logger.info("Eliminando los ficheros temporales");
		borrarLocalizacion(ode.getPathTaller());
		apender.close();
		logger.removeAppender(apender);
		return result;
	}
	
	private void restaurar(ODE ode) {
		try {
			if(ode.isComprimido()) {
				if(logger.isDebugEnabled()) logger.debug("Copiando backup de " + ode.getBackup() + " a " + ode.getPathOriginal());
				File origen = new File(ode.getBackup());
				File destino = new File(ode.getPathOriginal());
				UtilesFicheros.copiar(origen, destino);
			} else {
				if(logger.isDebugEnabled()) logger.debug("Descomprimiendo backup " + ode.getBackup() + " en " + ode.getPathOriginal());
				getZipDao().descomprimir(ode.getBackup(), ode.getPathOriginal());
			}
		} catch (Exception e) {
			logger.fatal("No se ha podido restaurar la copia de seguridad");
			if(logger.isDebugEnabled()) logger.debug(e);
		}
	}

	private void borrarLocalizacion(String path) {
		File taller = new File(path);
		try {
			UtilesFicheros.eliminar(taller);
		} catch (Exception e) {
			logger.debug("No se ha podido eliminar la localizaci&oacute;n " + path, e);
		}
	}
	

	
	//Este método configura la información de los logger
	private Appender configurarAppender(String file) throws Exception
	{
		PatternLayout layout = new PatternLayout("%d{dd/MM/yyyy HH:mm:ss} - %p - %m%n");
		FileAppender app = new FileAppender(layout,file);
		app.setThreshold(Level.INFO);
		app.setAppend(true);
		app.setName("informe");
		
		return app;
	}
	
	/**
	 *  <p>Prepara el ODE para ser modificado. Esto incluye las siguientes tareas:</p>
	 *  <ul>
	 *  <li>Copiar el ODE original a la localizacion de taller. Si el ODE esta comprimido, debera descomprimirse</li>
	 *  <li>Generar un backup del ODE original (copiar el original cuando esta comprimido</p>
	 *  </ul>
	 * 
	 * @param ode
	 * @throws Exception 
	 */
	private void prepararTarea(ODE ode,boolean simulacion) throws Exception 
	{
		//		Creo la carpeta Taller
		File taller = new File(ode.getPathTaller()); 
		if (taller.mkdirs()){
			if(logger.isDebugEnabled()) logger.debug("La carpeta taller fue creada");
        }
        else 
        {
        	if(logger.isDebugEnabled()) logger.debug("La carpeta taller no fue creada");
        } 
		apender=configurarAppender(ode.getTraza());
		logger.addAppender(apender);
		//creo la carpeta de bakup y del pathOriginal
		File backup=null;
		if(ode.getBackup()!=null&&!ode.getBackup().equals(VACIA)){
			backup = new File(ode.getBackup()); 
		}
		File pathOriginal=new File(ode.getPathOriginal());
		if(!simulacion) {
	        if (backup!=null&&backup.getParentFile().mkdirs())
	        {
	            if(logger.isDebugEnabled()) logger.debug(" La carpeta backup fue creada");
	        }
	        else 
	        {
	        	if(logger.isDebugEnabled()) logger.debug("La carpeta backup no fue creada");
	        } 
	        /*
	         * Si el ode está comprimido lo copio en el 
	         * backup si no lo comprimo en el backup
	         */
	        String nombreZip = ode.getBackup();
			if (backup!=null&&nombreZip!=null) {
				if (ode.isComprimido()) {
					UtilesFicheros.copiar(pathOriginal, backup);
				} else {
					zipDao.comprimir(nombreZip, ode.getPathOriginal());
				}
			}
			logger.info("Se ha creado copia de seguridad de ode "+ode.getPathOriginal());
		}
		
		
		/*
		 * Copio el ode original en la carpeta taller
		 * si está comprimido lo descomprimo y si no
		 * lo copio directamente
		 */
		
		if(ode.isComprimido())
		{
			zipDao.descomprimir(ode.getPathOriginal(), ode.getPathTaller());
		}
		else
		{
			UtilesFicheros.copiar(pathOriginal, taller);
		}
		
		
	}
	

	/**
	 * @return the cambios
	 */
	public Cambio[] getCambios() {
		return cambios;
	}

	/**
	 * @param cambios the cambios to set
	 */
	public void setCambios(Cambio[] cambios) {
		this.cambios = cambios;
	}

	/**
	 * @return the odes
	 */
	public ODE[] getOdes() {
		return odes;
	}

	/**
	 * @param odes the odes to set
	 */
	public void setOdes(ODE[] odes) {
		this.odes = odes;
	}

	/**
	 * @return the props
	 */
	public ModificadorProperties getProps() {
		return props;
	}

	/**
	 * @param props the props to set
	 */
	public void setProps(ModificadorProperties props) {
		this.props = props;
	}

	/**
	 * @return the scormDao
	 */
	public SCORM2004Dao getScormDao() {
		return scormDao;
	}

	/**
	 * @param scormDao the scormDao to set
	 */
	public void setScormDao(SCORM2004Dao scormDao) {
		this.scormDao = scormDao;
	}

	/**
	 * @return the zipDao
	 */
	public ZipDao getZipDao() {
		return zipDao;
	}

	/**
	 * @param zipDao the zipDao to set
	 */
	public void setZipDao(ZipDao zipDao) {
		this.zipDao = zipDao;
	}

	public boolean isDestructiva() {
		return destructiva;
	}


	public void setDestructiva(boolean destructiva) {
		this.destructiva = destructiva;
	}

}

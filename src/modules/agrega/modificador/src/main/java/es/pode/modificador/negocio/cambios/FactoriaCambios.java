/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.negocio.cambios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import es.pode.modificador.negocio.cambios.configuracion.ModificadorProperties;
import es.pode.modificador.negocio.servicio.vo.CambioTypes;
import es.pode.modificador.negocio.servicio.vo.Change;
import es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea;
import es.pode.modificador.negocio.servicio.vo.Folder;
import es.pode.modificador.negocio.servicio.vo.Objects;
import es.pode.parseadorXML.LomESDao;
import es.pode.parseadorXML.SCORM2004Dao;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;
import es.pode.soporte.zip.ZipDao;
import es.pode.soporte.zip.ZipDaoException;

public class FactoriaCambios {

	private static final Logger logger = Logger.getLogger(FactoriaCambios.class);
	
	private ZipDao zipDao = null;
	
	private SCORM2004Dao scormDao = null;
	
	private LomESDao lomesDao = null;
	
	private ModificadorProperties props = null;
	
	/**
	 * 
	 * A partir del VO de configuracion de la tarea, instancia el objeto
	 * TareaCambios que realizara las modificaciones solicitadas sobre cada ODE.
	 * 
	 * @param xmlConfiguracion Path al XML de configuracion de la tarea.
	 * @return Conjunto de objetos que realizaran la tarea de modificacion.
	 * @throws ZipDaoException 
	 */
	public TareaCambios generarTareaCambios(final ConfiguracionTarea configuracion, final String pathTarea) throws FactoriaCambiosException, ZipDaoException {
		if(configuracion==null) throw new NullPointerException("configuracion=null");
		if( configuracion.getCambios()==null || configuracion.getCambios().getCambios()==null ||configuracion.getCambios().getCambios().length==0) {
			String msg = "No hay cambios configurados";
			logger.error(msg);
			throw new FactoriaCambiosException(msg);
		}
		
		Cambio[] cambios = null;
		// Instancia los objetos de cambio
		Change[] cambiosVO = configuracion.getCambios().getCambios();
		ArrayList<Cambio> listaCambios = new ArrayList<Cambio>();
		boolean cambioModifica = false;
		for(int i=0; i<cambiosVO.length;i++) 
		{
			Change change = cambiosVO[i];
			Cambio cambio = null;
			if(CambioTypes.VALIDAR.equals(change.getType())) 
			{
				cambio = new ValidacionManifest();
			} 
			else if(CambioTypes.MODIFICAR_LOMES.equals(change.getType())) 
			{
				ModificacionValor mod =new ModificacionValor(); 
				mod.setTerminoLom(cambiosVO[i].getLomTerm());
				mod.setLenguaje(cambiosVO[i].getLanguage());
				mod.setNuevoValor(cambiosVO[i].getNewValue());
				mod.setReemplazarTodos(cambiosVO[i].getReplaceAll().booleanValue());
				mod.setRegExp(cambiosVO[i].getRegExp().booleanValue());
				mod.setValor(cambiosVO[i].getValue());
				mod.setLomesPrincipalSolo(cambiosVO[i].getMainLomOnly().booleanValue());
				mod.setLomesDao(lomesDao);
				cambio = mod;
				cambioModifica=true;
				logger.debug("Encontramos un cambio "+change +" que modifica los objetos");
			
			}
			else if(CambioTypes.ADD_LOMES.equals(change.getType())) 
			{
				AdicionTermino ad = new AdicionTermino();
				ad.setTerminoLom(cambiosVO[i].getLomTerm());
				ad.setLomesPrincipalSolo(cambiosVO[i].getMainLomOnly().booleanValue());
				ad.setNuevoValor(cambiosVO[i].getNewValue());
				ad.setTipoTermino(cambiosVO[i].getTermType());
				ad.setLomesDao(lomesDao);
				cambio=ad;
				cambioModifica=true;
				logger.debug("Encontramos un cambio "+change +" que modifica los objetos");
				
			}
			else if(CambioTypes.CHECK_LOMES.equals(change.getType())) 
			{
				ComprobacionTermino comp= new ComprobacionTermino();
				comp.setTerminoLom(cambiosVO[i].getLomTerm());
				comp.setLenguaje(cambiosVO[i].getLanguage());
				comp.setLomesPrincipalSolo(cambiosVO[i].getMainLomOnly().booleanValue());
				comp.setRegExp(cambiosVO[i].getRegExp().booleanValue());
				comp.setValor(cambiosVO[i].getValue());
				comp.setLomesDao(lomesDao);
				cambio = comp;
				
			}
			else if(CambioTypes.ELIMINAR_LOMES.equals(change.getType())) 
			{
				EliminacionTermino elim= new EliminacionTermino();
				elim.setTerminoLom(cambiosVO[i].getLomTerm());
				elim.setLenguaje(cambiosVO[i].getLanguage());
				elim.setLomesPrincipalSolo(cambiosVO[i].getMainLomOnly().booleanValue());
				elim.setRegExp(cambiosVO[i].getRegExp().booleanValue());
				elim.setValor(cambiosVO[i].getValue());
				elim.setLomesDao(lomesDao);
				cambio = elim;
				cambioModifica=true;
				logger.debug("Encontramos un cambio "+change +" que modifica los objetos");
				
			} 
			else 
			{
				logger.error("Se ha encontrado un cambio no soportado por la herramienta:"+change.getType());
			}
			if(cambio!=null) 
			{
				listaCambios.add(cambio);
			}
		}
		cambios = (Cambio[])listaCambios.toArray(new Cambio[listaCambios.size()]);
		
		ODE[] odes = obtenerODEs(configuracion.getObjetos(), pathTarea, cambioModifica);
		TareaCambios tc = new TareaCambios(cambios,odes);
		if(cambioModifica) {
			tc.setDestructiva(true);
		}
		
		// Inserto referencias a los singletons recuperados de Spring
		tc.setScormDao(scormDao);
		tc.setProps(props);
		tc.setZipDao(zipDao);
		return tc;
	}
	
	/**
	 * 
	 * A partir de la seccion Objects de la configuracion de la tarea, obtiene
	 * la lista de ODEs que se han configurado para modificar. La lista incluye
	 * los paths necesarios para la modificacion (taller, backup y path
	 * original), comprueba si es un ODE comprimido o no, e informa de cualquier
	 * error que pudiera haber (ODEs que han dejado de existir, ODEs sin
	 * imsmanifest.xml, ...).
	 * 
	 * @param objetos
	 * @return
	 * @throws ZipDaoException 
	 */
	public ODE[] obtenerODEs(final Objects objetos, final String pathTarea, boolean enableBackup) throws FactoriaCambiosException, ZipDaoException {

		ODE ode = null;
		ArrayList lista = new ArrayList();
		if(objetos ==null || (objetos.getObjetos()==null && objetos.getPaths()==null)) {
			String msg = "La tarea configurada no tiene ODEs para modificar";
			logger.error(msg);
			throw new FactoriaCambiosException(msg);
		}
		
		// Recorro los objetos individuales
		es.pode.modificador.negocio.servicio.vo.ODE[] odesXml = objetos.getObjetos();
		if (odesXml!=null) {
			for (int i = 0; i < odesXml.length; i++) {
				ode = generaODE(odesXml[i], pathTarea, enableBackup);
				if (ode != null)
					lista.add(ode);
			}
		}	
		// Recorro las carpetas
		Folder[] paths = objetos.getPaths();
		if(paths!=null) {
			for(int i=0;i<paths.length;i++) {
				ODE[] contenidos = exploraFolder(paths[i], pathTarea, enableBackup);
				if(contenidos.length>0) lista.addAll(Arrays.asList(contenidos));
			}
		}
		if(logger.isDebugEnabled()) logger.debug("Se han localizado un total de " + lista.size() + " ODEs para modificar");
		return (ODE[])lista.toArray(new ODE[lista.size()]);
	}

	private ODE[] exploraFolder(final Folder folder, final String pathTarea, boolean enableBackup) throws ZipDaoException {
		java.io.File path = new java.io.File(folder.getPath());
		java.util.ArrayList lista = new java.util.ArrayList();
		
		if(!path.isDirectory()) {
			logger.warn("La carpeta " + path.getPath() + " no existe o no es un directorio. Ignorando");
		} else {
			String[] children = UtilesFicheros.obtenerOdesDePath(path.getPath(), true, false);
			if(logger.isDebugEnabled()) logger.debug("Explorando los " + children.length + " hijos de " + path.getPath());
			for(int i=0;i<children.length;i++) {
					es.pode.modificador.negocio.servicio.vo.ODE odeXml = new es.pode.modificador.negocio.servicio.vo.ODE();
					odeXml.setPath(children[i]);
					odeXml.setPublished(Boolean.FALSE);
					ODE ode = generaODE(odeXml, pathTarea, enableBackup);
					if(ode!=null) lista.add(ode);
			}
		}
		if(logger.isDebugEnabled()) logger.debug("Se han encontrado " + lista.size() + " bajo la carpeta " + folder.getPath());
		return (ODE[])lista.toArray(new ODE[lista.size()]);
	}
	
	private ODE generaODE(final es.pode.modificador.negocio.servicio.vo.ODE odeXml, final String pathTarea, boolean enableBackup) throws ZipDaoException {
		java.io.File path = new java.io.File(odeXml.getPath());
		String manifestFile = props.getProperty("manifest.file");
		ODE result = null;
		String errMsg = "El ODE " + path.getPath() + " no contiene un imsmanifest.xml. Se descarta de la modificaci&oacute;n"; 
		if(path.isDirectory()) {
			// Comprueba que existe el imsmanifest.xml en el raiz del ODE
			List children = Arrays.asList(path.list());
			if(!children.contains(manifestFile)) {
				logger.warn(errMsg); 
			} else {
				result = new ODE();
				result.setComprimido(false);
				result.setPathOriginal(odeXml.getPath());
				result.setPublicado(odeXml.getPublished().booleanValue());
				completaODE(result, pathTarea, path, enableBackup);
			}
		} else if (path.isFile() && zipDao.esZip(path.getPath())) {
			// Comprueba que existe el imsmanifest.xml en el raiz del ODE
			if(!zipDao.chequearEntrada(manifestFile, path.getPath())) {
				logger.warn(errMsg); 
			} else {
				result = new ODE();
				result.setComprimido(true);
				result.setPathOriginal(odeXml.getPath());
				result.setPublicado(odeXml.getPublished().booleanValue());
				completaODE(result, pathTarea, path, enableBackup);
			}
		} else {
			logger.warn("El path " + path.getPath() + " no contiene ningun ODE. No se incluye para la modificacion");
		}
		if (logger.isDebugEnabled() && result != null)
			logger.debug("ODE localizado para modificacion: "
					+ result.getPathOriginal() + " ( publicado = "
					+ result.isPublicado() + " , comprimido = "
					+ result.isComprimido() + " )");
		return result;
	}

	private void completaODE(ODE ode, String tareaPath, final java.io.File pathOde, boolean enableBackup) {
		String backup = props.getProperty("backup.folder");
		String taller = props.getProperty("taller.folder");
		String traza = props.getProperty("report.folder");
		
		String nombre = null;
		if (ode.isComprimido() && pathOde.getName().indexOf('.') > 0)
			nombre = pathOde.getName().substring(0,
					pathOde.getName().lastIndexOf('.'));
		else nombre = pathOde.getName();
		
		String baseOde = tareaPath+ "/" + nombre+"/";
		ode.setPathTaller(baseOde+taller+"/");
		
		if (enableBackup) {
			if (ode.isComprimido()) {
				ode.setBackup(baseOde + backup + "/" + pathOde.getName());
			} else {
				ode.setBackup(baseOde + backup + "/" + pathOde.getName()
						+ ".zip");
			}
		} else {
			ode.setBackup("");
		}
		ode.setTraza(baseOde+traza);
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
	 * @return the lomesDao
	 */
	public LomESDao getLomesDao() {
		return lomesDao;
	}

	/**
	 * @param lomesDao the lomesDao to set
	 */
	public void setLomesDao(LomESDao lomesDao) {
		this.lomesDao = lomesDao;
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
	
}

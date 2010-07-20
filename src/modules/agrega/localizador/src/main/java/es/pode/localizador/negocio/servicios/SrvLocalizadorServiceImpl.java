/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.localizador.negocio.servicios;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import es.pode.localizador.negocio.dominio.IdentificadoresCriteria;
import es.pode.localizador.negocio.dominio.Localizador;
import es.pode.localizador.negocio.dominio.LocalizadorDao;
import es.pode.soporte.seguridad.encriptacion.EncriptacionUtiles;


/**
 * @see es.pode.localizador.negocio.servicios.SrvLocalizadorService
 */

public class SrvLocalizadorServiceImpl
    extends es.pode.localizador.negocio.servicios.SrvLocalizadorServiceBase
{ 
	private Logger logger = Logger.getLogger(this.getClass());
	private Properties props = null;
	private static final String PATH_SEPARATOR="/";
	
	public SrvLocalizadorServiceImpl(){
		super();
		
		InputStream is = null;
		try {
			is = this.getClass().getResourceAsStream("/localizador.properties");
			props = new Properties();
			props.load(is);
		} catch (IOException e) {
			logger.error("ERROR: fichero no encontrado: localizador.properties",e);
			throw new RuntimeException(e);
		} finally {
			if( is != null ) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e);
				}
				
			}
		}
	}
	
	/**
	 * Recupera el localizador asociado al identificador suministrado.     
     * @param identificador Identificador del localizador del que se esta interesado.
     * @return se retorna un VO del localizador.
     * @throws Exception
     * 
     */
	protected LocalizadorVO handleConsultaLocalizador(String identificador) throws Exception {
		try {
			LocalizadorDao localizadorDao = this.getLocalizadorDao();
			Localizador localizador = localizadorDao.buscarLocalizadorPorIdentificador(identificador);
			if (localizador!= null) {
				return localizadorDao.toLocalizadorVO(localizador);
			} else {
				ConsultaLocalizadorException e = new ConsultaLocalizadorException("ERROR: localizador no encontrado: "+identificador);
				logger.warn(e);
				throw e;
			}
		} catch (ConsultaLocalizadorException e) {
			logger.warn(e); 
			throw e;
		} catch (Exception e) {
			ConsultaLocalizadorException localizadorException = 
				new ConsultaLocalizadorException("ERROR: consulta de localizador "+identificador, e);
			logger.error(localizadorException);
			throw localizadorException;
		}
	}

	/**
	 * Metodo para crear el localizador de un ODE no publicado.
	 * El metodo crea una nueva entrada de localizacion en la tabla de localizadores. 
	 * El localizador esta compuesto por una ruta en disco PATH, una ruta URL de acceso remoto al ODE y un identificador.
	 * El PATH se construye a partir de la ruta-base del fichero de configuracion para ODE's de taller. 
	 * Se le concatena el nombre del usuario mas el uuid.
	 * La URL se construye a partir de la ruta-base-remota del fichero de configuracion para ODE's de taller. 
	 * Se le concatena el nombre del usuario mas el uuid.
	 * El valor del campo identificador toma el valor del parametro uuid.
	 * El MEC se deja a 0.    
     * @param usuario Nombre del usuario.
     * @param uuid Numero identificador UUID
     * @return se retorna el VO del localizador creado.
     * @throws Exception
     * 
     * El metodo ha de ser enteramente transaccional, de forma que si se produce cualquier error creando 
     * los directorios u operando en la BD se ha de deshacer cualquier operacion ya realizada.
     * Si ya existe un localizador con el campo "identificador" igual, no se realiza el alta y se genera una excepcion.
     */
	protected LocalizadorVO handleCrearLocalizadorNoPublicado(String usuario, String uuid) throws Exception {
		try {
			String dirBase = props.getProperty("tallerPathBase");
			String urlBase = props.getProperty("tallerUrlBase");
			// Se va a localizar por fecha
			String sFecha = this.getDirectorioFecha(PATH_SEPARATOR);
			
			
			LocalizadorDao localizadorDao = this.getLocalizadorDao();
			Localizador localizador = localizadorDao.buscarLocalizadorPorIdentificador(uuid);
			LocalizadorVO localizadorVO;
			if (localizador == null){  //no existe, lo poblamos
				String path=dirBase + usuario + sFecha + PATH_SEPARATOR + uuid;
//				long consumoEspacio=calculaEspacio(new File(path));Si estamos generando el ODE el tamaño es 0
				long consumoEspacio=0;
				localizadorVO= this.crearLocalizador("", path, urlBase + usuario + sFecha + PATH_SEPARATOR + uuid, uuid, usuario,consumoEspacio);
				
				if( logger.isDebugEnabled() )
					logger.debug("Creado localizador con id: " + uuid );
				
				File file = new File(localizadorVO.getPath());
				if (file.exists()) {
					throw new CreaLocalizadorNoPublicadoException("ERROR: el fichero ya existe");
				} 
					
				if( logger.isDebugEnabled() )
					logger.debug("Creando carpeta " + file.getAbsolutePath() );
				
				file.mkdirs();
				localizadorDao.create(localizadorDao.fromLocalizadorVO(localizadorVO));
				
			} else {  //ya existe en la db!
				if (localizador.getPath().equals(dirBase + usuario + sFecha + PATH_SEPARATOR + uuid)) {
					CreaLocalizadorNoPublicadoException e = new CreaLocalizadorNoPublicadoException("ERROR: el registro " + uuid + " ya existe en la base de datos");
					logger.warn(e);
					throw e;
				}
				
				if( logger.isDebugEnabled() )
					logger.debug("Actualizando localizador con id: " + uuid );
				
				localizador.setPath(dirBase + usuario + sFecha + PATH_SEPARATOR + uuid);
				localizador.setUrl(urlBase + usuario + sFecha + PATH_SEPARATOR + uuid);
				localizadorDao.update(localizador);
				localizadorVO = localizadorDao.toLocalizadorVO(localizador);
		
			}
			return localizadorVO;
		} catch (CreaLocalizadorNoPublicadoException e) {
			logger.warn(e);
			throw e;
		} catch (Exception e) {
			logger.error(e);
			CreaLocalizadorNoPublicadoException noPublicadoException = 
				new CreaLocalizadorNoPublicadoException("ERROR: fallo al crear localizador", e);
			logger.warn(noPublicadoException);
			throw noPublicadoException;
		}
	}
	
	/**
	 * Metodo para crear el localizador de un ODE publicado.
	 * El metodo crea una nueva entrada de localizacion en la tabla de localizadores.
	 * El nuevo localizador esta compuesto por una ruta en disco PATH, una ruta URL de acceso remoto al ODE y un identificador MEC.
	 * El PATH se construye a partir de la ruta-base del fichero de configuracion 
	 * para ODE's publicados al que se concatena el identificador MEC.
	 * La URL se construye a partir de la ruta-base-remota del fichero de configuracion 
	 * para ODE's publicados a la que se le concatena el identificador MEC.
	 * El identificador toma el valor del parametro mec.
	 * El MEC se deja a 0. 
     * @param uuid Localizador de un ODE no publicado.
     * @param mec Numero identificador del MEC.
     * @return se retorna el VO del localizador creado.
     * @throws Exception
     * 
     * Si el identificador uuid suministrado corresponde con un localizador no publicado en la BD 
     * (el campo "identificador" coincide con "uuid"):
     * - Si el localizador del ODE no publicado ya tiene valor en el campo MEC, devolvemos una excepcion y no hacemos nada. (ese ODE no publicado ya tiene un ODE publicado asociado).
     * - Si el localizador del ODE no publicado no tiene valor en el campo MEC, actualizamos dicho localizador aniadiendole el valor de la variable mec suministrada al campo MEC del registro de la BD y creamos un nuevo localizador para el ODE publicado como se define mas arriba.
     * Si el localizador no publicado no existe en la BD 
     * (no existen registros en la BD con el campo "idenficador" coincidentes con la variable "uuid"): Lanzamos una excepcion.
     * El metodo ha de ser enteramente transaccional, de forma que si se produce cualquier error creando los directorios u operando en la BD se ha de deshacer cualquier operacion ya realizada.
     */
	protected LocalizadorVO handleCrearLocalizadorPublicado(String uuid, String mec) throws Exception {

		try {
			String dirBase = props.getProperty("publicacionPathBase");
			String urlBase = props.getProperty("publicacionUrlBase");
			// Se va a localizar por fecha
			String sFecha = this.getDirectorioFecha("");
			
			
			LocalizadorDao localizadorDao = this.getLocalizadorDao();
			Localizador localizador = localizadorDao.buscarLocalizadorPorIdentificador(uuid);
			LocalizadorVO mecLocalizadorVO = null;
			if (localizador!=null) {  //el registro ya está en la db
				logger.debug("El registro existe en la base de datos"+localizador.getMec());
				if (localizador.getMec()==null ||StringUtils.isEmpty(localizador.getMec())) {
					logger.debug("El mec es vacío");
					localizador.setMec(mec);
					logger.debug("El mec insertado es "+localizador.getMec());
//					Creamos un identificador MD5 a partir del id mec para que una carga de ODEs no meta en el directorio de una sola fecha más subdirectorios
//					de los que es capaz de absorber un sistema de ficheros.
					String md5 = EncriptacionUtiles.md5String(mec).substring(0, 2);
					logger.debug("El md5"+md5);
					String path=dirBase + sFecha + PATH_SEPARATOR+ md5+ PATH_SEPARATOR + mec;
					logger.debug("El path"+path);
					String url = urlBase+ sFecha + PATH_SEPARATOR + md5 + PATH_SEPARATOR +mec;
					logger.debug("El url"+url);
					long consumoEspacio=calculaEspacio(new File(path));
					logger.debug("El consumo de espacio"+consumoEspacio);
					mecLocalizadorVO = this.crearLocalizador("",path, url, mec,localizador.getIdUsuario(),consumoEspacio);
					logger.debug("Creado localizador"+localizador);
					localizadorDao.update(localizador);
					localizadorDao.create(localizadorDao.fromLocalizadorVO(mecLocalizadorVO));
				} else { // El objeto ya tiene identificador MEC
					logger.debug("El objeto ya tiene mec");
					if (localizador.getMec().equals(mec)) { //si intenta crearlo con el mismo mec
						return localizadorDao.toLocalizadorVO(localizador);
					}else { //si intenta crearlo con distinto mec
						CreaLocalizadorPublicadoException e = new CreaLocalizadorPublicadoException("ERROR: el registro existe previamente con MEC "+localizador.getMec()+" y se ha intentado crear con MEC "+mec);
						logger.warn(e);
						throw e;
					}
				}
			} else 	{  //el registro no está en la db, se lanza excepcion
				CreaLocalizadorPublicadoException e = new CreaLocalizadorPublicadoException("ERROR: el objeto no ha sido creado previamente");
				logger.warn(e);
				throw e;
			}
			return mecLocalizadorVO;
    	} catch (CreaLocalizadorPublicadoException e) {
    		logger.warn(e);
    		throw e;
		} catch (Exception e) {
			CreaLocalizadorPublicadoException publicadoException = new CreaLocalizadorPublicadoException("Fallo en la creación de localizador", e);
			logger.warn(publicadoException);
			throw publicadoException;
		} 
	}
	
	/**
	 * Se elimina la localizacion, esto ocurrira en dos ocasiones:
	 * a) Eliminacion fisica del ODE cuando este esta en estado "Despublicado"
	 * b) El ODE esta en creacion pero no se guarda.
     * @param identificador Localizador del ODE.     
     * @return se retorna un boolean: True, si todo ha ido bien y False, en caso contrario.
     * @throws Exception
     * 
     * La eliminacion implica, la eliminacion de todos los registros que tengan que ver con el identificador introducido.
	 * Se elimina cualquier ODE que tenga como identificador el ID 
	 * introducido por parametro O que tenga como MEC el id introducido por parametro.
	 * Eliminamos tambien el directorio que indique la/s localizaciones que vamos a eliminar.
     */
	protected Boolean handleEliminarLocalizador(String identificador) throws Exception {
		try {
			LocalizadorDao localizadorDao = this.getLocalizadorDao();
			Localizador localizador = localizadorDao.buscarLocalizadorPorIdentificador(identificador);
			if( logger.isDebugEnabled() )logger.debug("Eliminamos del localizador el identificador ["+identificador+"]");
			if (borrarLocalizador(localizador.getPath())) {
				localizadorDao.remove(localizador);
//				Tenemos que comprobar si el identificador que nos pasan es de un ode publicado, ya que tenemos que poner a vacio la casilla con el mec
//				de su localizador no publicado.
                Localizador localizadorMec = (Localizador)this.getLocalizadorDao().buscarLocalizadorDeTallerPorMEC(identificador);
                if( logger.isDebugEnabled() )logger.debug("Comprobamos el mec["+identificador+"] del identificador["+identificador+"] para limpiar la entrada de taller.");
                if (localizadorMec!=null)
                {
                	if( logger.isDebugEnabled() )logger.debug("El localizador de taller["+identificador+"] tiene marca con el MEC, borramos del registro[" + localizadorMec.getMec()+"]");
                        localizadorMec.setMec("");
                        localizadorDao.update(localizadorMec);
                } 
				return new Boolean(true);
			} else {
				EliminaLocalizadorException e = new EliminaLocalizadorException();
				logger.warn(e);
				throw e;
			}
		} catch (EliminaLocalizadorException e) {
			logger.warn(e);
			throw e;
		} catch (Exception e) {
			EliminaLocalizadorException localizadorException = new EliminaLocalizadorException("Fallo en la eliminación de localizador", e);
			logger.warn(localizadorException);
			throw localizadorException;
		}
	}
	
	/**
	 * Este metodo devuelve un array de localizadores de todos los identificadores de ODEs que le pasan.
     * @param ids Lista de identificadores de los ODEs.     
     * @return Lista de localizadores.
     * @throws Exception
     *      
     */
	protected LocalizadorVO[] handleBuscarLocalizadoresPorId(String[] ids) throws Exception {
		LocalizadorDao localizadorDao = this.getLocalizadorDao();
		if(logger.isDebugEnabled()&& ids!=null) logger.debug("Obteniendo localizadores de '" + ids.length + "' ODEs");
		LocalizadorVO[] localizadorArray = new LocalizadorVO[ids.length];
		for (int i = 0; i<ids.length; i++) {
			LocalizadorVO localizadorVO = (LocalizadorVO) localizadorDao.buscarLocalizadorPorIdentificador(LocalizadorDao.TRANSFORM_LOCALIZADORVO, ids[i]);
			if (localizadorVO!=null) {
				localizadorArray[i] = localizadorVO;
			} else {
				logger.warn("El id '" + ids[i] + "' ha devuelto un localizador null");
			}
		}
		return localizadorArray;
	}

	/**
	 * Este metodo toma como parametro un identificador MEC y devuelve la localizacion.
	 * de este MEC cuando estaba en el taller.
     * @param mec Identificador del MEC.     
     * @return retorna la localizacion.
     * @throws Exception
     *      
     */
	protected LocalizadorVO handleConsultaLocalizadorNoPublicado(String mec) throws Exception {
		return (LocalizadorVO)this.getLocalizadorDao().buscarLocalizadorDeTallerPorMEC(this.getLocalizadorDao().TRANSFORM_LOCALIZADORVO, mec);
	}
	
	private boolean borrarLocalizador(String localizador) {
    	File current = new File(localizador);
    	if (current.isDirectory()) {
    		File[] files = current.listFiles();
			if (files!=null) {
				for (int i = 0; i < files.length; i++) {
					borrarLocalizador(files[i].getPath());
				}
			}
    	}
    	current.delete();
    	return !(current.exists());
    }
    
    private String getDirectorioFecha(String pathSeparator)
    {
    	String sFecha = "";
    	try
    	{
	    	// Se va a localizar por fecha
			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
			Date fecha = new Date();
			sFecha = sdf.format(fecha);
			sFecha = pathSeparator + sFecha;
    	}
    	catch (Exception ex)
    	{
    		logger.error(ex);
    	}
    	return sFecha;    	
    }
    
	private LocalizadorVO crearLocalizador(String sMec, String sPath, 
			String sURL, String sIdentificador, String idUsuario, long consumoEspacio)
	{
    	LocalizadorVO localizadorVO = new LocalizadorVO();
		localizadorVO.setPath(sPath);
		localizadorVO.setUrl(sURL);
		localizadorVO.setIdentificador(sIdentificador);
		localizadorVO.setMec(sMec);
		localizadorVO.setIdUsuario(idUsuario);
		localizadorVO.setConsumoEspacio(consumoEspacio);
		
		return localizadorVO;
	}
	
	/*
	  Este metodo calcula el espacio ocupado por el ODE. Se trata de la suma del tamanio de los contenidos del ODE en bytes(creo).
	  */
	 private long calculaEspacio(File localizacion)
	 {
		 try{
			 return FileUtils.sizeOfDirectory(localizacion);
		 }catch(Exception e){
			 logger.error("Error al calcular el espacio del fichero "+e);
			 long vuelta=0;
			 return vuelta;
		 }
//	  if (localizacion.isFile())
//	      return localizacion.length();
//	    File[] files = localizacion.listFiles();
//	    long size = 0;
//	    if (files != null) {
//	      for (int i = 0; i < files.length; i++)
//	        size += calculaEspacio(files[i]);
//	    }
//	    return size;
	 }

	

	 /**
		 * Consulta de espacio ocupado por un identificador de localización de un ODE.
	     * @param idLocalizador Identificador de localización del que se quiere consultar el espacio ocupado en disco.     
	     * @return devuelve el espacio ocupado en disco por el localizador. Devuelve 0 en el caso de que el localizador no sea válido.
	     * @throws Exception
	     *      
	     */
	protected Long handleConsultaEspacioLocalizador(String idLocalizador) throws Exception {
		long consumo=0;
		try{
			LocalizadorDao localizadorDao = this.getLocalizadorDao();
			LocalizadorVO localizadorVO=(LocalizadorVO)localizadorDao.buscarLocalizadorPorIdentificador(LocalizadorDao.TRANSFORM_LOCALIZADORVO, idLocalizador);
			
			if(localizadorVO!=null){
				if(localizadorVO.getConsumoEspacio()!=null && localizadorVO.getConsumoEspacio().longValue()!=0){
					if( logger.isDebugEnabled() )logger.debug("El tamaino:["+localizadorVO.getConsumoEspacio().longValue()+"]del ODE:["+idLocalizador+"]");
					consumo=localizadorVO.getConsumoEspacio().longValue();
				}else{//Si el tamiano del ODE no está clacula todavía, lo calculamos y lo insertamos en la tabla
					if( logger.isDebugEnabled() )logger.debug("El tamaino de la localizacion ["+localizadorVO.getPath()+"] no esta en la tabla, lo calculamos y lo insertamos");
					Long tamai=this.calculaEspacio(new File(localizadorVO.getPath()));
					localizadorVO.setConsumoEspacio(tamai);
					if( logger.isDebugEnabled() )logger.debug("La transformacion de :["+localizadorDao.fromLocalizadorVO(localizadorVO).getIdentificador()+"]");
					Localizador localizador=localizadorDao.buscarLocalizadorPorIdentificador(localizadorVO.getIdentificador());
					localizadorDao.fromLocalizadorVO(localizadorVO,localizador);
					logger.debug("Modifico el entity con el VO con identificador["+localizador.getIdentificador()+"]y consumo["+localizador.getConsumoEspacio().longValue()+"]");
//					Localizador localizador=localizadorDao.load(new Long(localizadorVO.getIdentificador()));
					localizadorDao.update(localizador);
					consumo=tamai;
				}
			}
		}catch(Exception e){
			logger.error("Error al realizar la consulta de espacio del localizador["+idLocalizador+"]: " + e.getMessage());
			throw new Exception("Error al realizar la consulta de espacio del localizador ["+idLocalizador+"]");
		}
		return consumo;
	}

	/**
	 * Consulta de espacio ocupado por una lista de identificadores
     * @param identificadores Lista de identificadores de localizaciones de las que se quiere consultar el espacio ocupado en disco.     
     * @return devuelve el espacio ocupado en disco por la lista de localizaciones en el mismo orden que se le pasa. Si alguno de los localizadores
     * no es valido, devuelve 0 en su posición.
     * @throws Exception
     *      
     */
	protected Long[] handleConsultaEspacioLocalizadores(String[] identificadores) throws Exception {
		Long[] listaConsumo=null;
		Collection coleccion=null;
		if(identificadores!=null && identificadores.length>0){
			HashMap hashMap=new HashMap();
			listaConsumo = new Long[identificadores.length];
			try{
				LocalizadorDao localizadorDao = this.getLocalizadorDao();
				IdentificadoresCriteria identificadoresCriteria=new IdentificadoresCriteria();
				identificadoresCriteria.setIdentificadores(identificadores);
				if( logger.isDebugEnabled() ) {
					for(int i=0;i<identificadores.length;i++ ){
						logger.debug("Iedentificador"+i+":["+identificadores[i]);
					}
				}
				String[] identifCr=identificadoresCriteria.getIdentificadores();
				List localizadores = (List) localizadorDao.buscarLocalizadoresPorIdentificadores(LocalizadorDao.TRANSFORM_LOCALIZADORVO, identificadoresCriteria);
				for(int i=0;i<localizadores.size();i++){
					long consumo=0;
					LocalizadorVO localizadorVO=(LocalizadorVO)localizadores.get(i);
					boolean encontrado=false;
					if (localizadorVO!=null && !encontrado) {
						String identifVuelta=localizadorVO.getIdentificador();
						for(int j=0;j<identificadores.length && !encontrado;j++){
							logger.debug("El identificador de entrada:["+identificadores[j]+"Y el identificador de vuelta:["+identifVuelta);
							if(identificadores[j].equals(identifVuelta) && !encontrado){
								encontrado=true;
								logger.debug("El identificador de entrada:["+identificadores[j]+"Y el identificador de vuelta:["+identifVuelta+"ha sido encontrado");
								if(localizadorVO.getConsumoEspacio()!=null && !localizadorVO.getConsumoEspacio().equals("0")){
									logger.debug("El tamaino:["+localizadorVO.getConsumoEspacio().longValue()+" del identificador:"+localizadorVO.getIdentificador());
									consumo=localizadorVO.getConsumoEspacio();
		//							hashMap.put(localizadorVO.getIdentificador(), localizadorVO.getConsumoEspacio());
								}else{//Si el tamiano del ODE no está clacula todavía, lo calculamos y lo insertamos en la tabla
									logger.debug("El tamaino no esta en la tabla, lo calculamos y lo insertamos con el PATH:["+localizadorVO.getPath());
									Long tamai=this.calculaEspacio(new File(localizadorVO.getPath()));
									logger.debug("Hemos calculado el tamaino:["+tamai.longValue() +"]del ODE con identificador:["+localizadorVO.getIdentificador()+"]");
									localizadorVO.setConsumoEspacio(tamai);
									logger.debug("La transformacion:["+localizadorVO.getIdentificador());
									logger.debug("El identificador para buscar el entity:"+localizadorVO.getIdentificador());
									Localizador localizador=localizadorDao.buscarLocalizadorPorIdentificador(localizadorVO.getIdentificador());
									localizadorDao.fromLocalizadorVO(localizadorVO,localizador);
									logger.debug("Modifico el entity con el VO con : identificador["+localizador.getIdentificador()+"]y consumo["+localizador.getConsumoEspacio().longValue()+"]");
									localizadorDao.update(localizador);
									consumo=tamai;
									logger.debug("El tamaino:["+consumo+"]");
		//							hashMap.put(localizadorVO.getIdentificador(), tamai);
								}
								listaConsumo[j]=consumo;
							}
							
						}
					}
//					listaConsumo[i]=consumo;
//					coleccion.add(hashMap);
				}
			}catch(Exception e){
				logger.debug("Error al realizar la consulta de espacio de localizadores: " + e.getMessage());
				throw new Exception("Error al realizar la consulta de espacio de localizadores con identificadores");
			}
		}
			
		return listaConsumo;
	}

	/**
	 * Para el localizador que se le pasa, recalcula el espacio que ocupa la localización en disco si difiere
     * de la cifra almacenada en BBDD. Si no hay localizador asociado al id, se devuelve un 0.
     * @param idLocalizador Identificador del localizador del que se quiere recalcular el espacio ocupado en disco.     
     * @return devuelve el espacio ocupado en disco por la localizacion que se le pasa.
     * @throws Exception
     *      
     */
	protected Long handleActualizaEspacioLocalizador(String idLocalizador) throws Exception {
		long consumo=0;
		try{
			LocalizadorDao localizadorDao = this.getLocalizadorDao();
			Localizador localizador=(Localizador)localizadorDao.buscarLocalizadorPorIdentificador(LocalizadorDao.TRANSFORM_NONE, idLocalizador);
			if(localizador!=null){ // hay localizador
				consumo=calculaEspacio(new File(localizador.getPath()));;
				logger.info("Actualizando el tamanio del localizador. El tamanio actual del ODE:["+idLocalizador+"] path["+localizador.getPath()+"] en disco es ["+consumo+"]");
				if(localizador.getConsumoEspacio()==null || localizador.getConsumoEspacio().longValue()==0 || localizador.getConsumoEspacio().longValue()!= consumo){
					localizador.setConsumoEspacio(new Long(consumo));
					logger.info("Actualizando el tamanio del localizador. Actualizamos el tamaino del ODE:["+idLocalizador+"] en ["+localizador.getPath()+"] a ["+localizador.getConsumoEspacio().longValue()+"]");
					this.getLocalizadorDao().update(localizador);
				}
				return new Long(consumo);
			}
			else // no hay localizador
			{
				logger.error("Actualizando el tamanio del localizador. Error consultando localizador con id["+idLocalizador+"]. No existe localizador para este identificador.");
				return new Long(0);
			}
		}catch(Exception e){
			logger.error("Actualizando el tamanio del localizador. Error al realizar actualizacion de espacio del localizador["+idLocalizador+"].",e);
			throw new Exception("Actualizando el tamanio del localizador. Error al realizar actualizacion de espacio del localizador ["+idLocalizador+"]",e);
		}
	}
	
	/**
	 * Este metodo calcula el espacio que ocupa en disco en el momento de la invocación el localizador que se le pasa.
     * @param idLocalizador Identificador del localizador del que se quiere saber el espacio ocupado en disco actualmente.     
     * @return devuelve el espacio ocupado en disco por la localizacion que se le pasa.
     * @throws Exception
     *      
     */
	protected Long handleCalculaEspacioLocalizador(String idLocalizador) throws Exception
	{
		long consumo=0;
		try{
			LocalizadorDao localizadorDao = this.getLocalizadorDao();
			Localizador localizador=(Localizador)localizadorDao.buscarLocalizadorPorIdentificador(LocalizadorDao.TRANSFORM_NONE, idLocalizador);
			if(localizador!=null){ // hay localizador
				consumo=calculaEspacio(new File(localizador.getPath()));;
				if (logger.isDebugEnabled())logger.debug("Calculando espacio ocupado por localizador. El tamanio actual del ODE:["+idLocalizador+"] path["+localizador.getPath()+"] en disco es ["+consumo+"]");
				return new Long(consumo);
			}
			else // no hay localizador
			{
				logger.error("Calculando espacio ocupado por localizador. Error calculando espacio consumido por localizador con id["+idLocalizador+"]. No existe localizador para este identificador.");
				return new Long(0);
			}
		}catch(Exception e){
			logger.error("Calculando espacio ocupado por localizador. Error al realizar calculo de espacio del localizador["+idLocalizador+"].",e);
			throw new Exception("Calculando espacio ocupado por localizador. Error al realizar calculo de espacio del localizador ["+idLocalizador+"]",e);
		}
	}
	
}
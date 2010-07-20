/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.dri.negocio.servicios.DRI;

import java.util.Date;

import javax.activation.DataHandler;

import org.apache.log4j.Logger;

import es.pode.dri.negocio.servicios.SesionVO;
import es.pode.entregar.negocio.servicios.PaquetePifDriVO;
import es.pode.publicacion.negocio.servicios.ResultadoOperacionVO;
import es.pode.soporte.seguridad.encriptacion.Autenticar;
import es.pode.soporte.seguridad.encriptacion.EncriptacionUtiles;
import es.pode.soporte.utiles.date.DateManager;


/**
 * @see es.pode.dri.negocio.servicios.DRI.SrvDRIService
 */

public class SrvDRIServiceImpl
    extends es.pode.dri.negocio.servicios.DRI.SrvDRIServiceBase
{

	private Logger logger = Logger.getLogger(this.getClass());

	private final String CARGA_DRI = "Carga DRI";
	private final String CATALOGA_DRI = "Cataloga DRI";
	private final String SIN_ERRORES = "0.0";
	private final String ZIP=".zip";
	/**
	 * Este metodo invoca el publicarPIF del servicio de publicacion.
     * @param usuario Usuario perteneciente a la plataforma. 
     * @param clave Clave del usuario dentro de la platafoma.
     * @param pif Fichero del ODE en formato zip.   
     * @return En caso de exito, no se retorna nada.
     * @throws Exception
     *      
     */
	protected void handlePresentarAlmacenar(String usuario, String clave, DataHandler pif) throws Exception {
//		Higiene de datos
		if (usuario == null || usuario.equals(""))
		{
			ServicioDRIException e = new ServicioDRIException("Error almacenando pif["+(pif!= null? pif.getName():null)+"] con usuario vacio.");
        	logger.error(e);
        	throw e;
		}
		if (clave == null || clave.equals(""))
		{
			ServicioDRIException e = new ServicioDRIException("Error almacenando pif["+(pif!= null? pif.getName():null)+"] con usuario ["+usuario+"] clave vacia.");
        	logger.error(e);
        	throw e;
		}
		if (pif == null || pif.getInputStream() == null)
		{
			ServicioDRIException e = new ServicioDRIException("Error almacenando pif["+(pif!= null? pif.getName():null)+"] con usuario ["+usuario+"] y fichero vacio["+pif.getName()+"].");
        	logger.error(e);
        	throw e;
		}
    	//Comprobamos si existe el usuario
		if (!Autenticar.validarUsuario(usuario))
		{
			ServicioDRIException e = new ServicioDRIException("Error almacenando pif["+pif.getName()+"] con usuario ["+usuario+"] ]. El usuario no esta autenticado en el sistema.");
			logger.error(e);
			throw e;
		}
		ResultadoOperacionVO res;
		String titulo=null;
		try {
//			Añadimos seguridad a la transaccion
			logger.info("Presentamos-Almacenamos antes de meter la mochila");
			Autenticar.anadirSeguridad(usuario, clave);
			logger.info("Presentamos-Almacenamos fichero pif["+pif.getName()+"] al repositorio con usuario["+usuario+"]  ");
			titulo=obtenerNombre(usuario);
			res = this.getSrvPublicacionService().publicarPIF(pif, usuario, CARGA_DRI,"n",titulo);
		} catch (RuntimeException e1) {
			ServicioDRIException e =new ServicioDRIException("Excepcion almacenando pif["+pif.getName()+"] con usuario ["+usuario+"] y titulo ["+titulo+"] desde interfaz DRI.",e1);
    		logger.warn(e);
    		throw e;
		}
    	if (!res.getIdResultado().equals(SIN_ERRORES))
    	{
    		ServicioDRIException e =new ServicioDRIException("Error almacenando pif["+pif.getName()+"] con usuario ["+usuario+"] y titulo ["+titulo+"] desde interfaz DRI["+res.getIdResultado()+"]->["+res.getDescripcion()+"]");
    		logger.warn(e);
    		throw e;
    	}
    	logger.info("Almacenado pif["+pif.getName()+"] con exito con usuario ["+usuario+"] y titulo ["+titulo+"]");
	}

	/**
	 * Este metodo invoca el publicarPIF del servicio de publicacion.
     * @param sesionId Identificador de la sesion que hay que haber inicializado. 
     * @param pif contenido del ODE en formato PIF.   
     * @return En el caso de exito no se retorna nada.
     * @throws Exception
     *      
     */
	protected void handlePresentarAlmacenarSesion(String sesionId, DataHandler pif) throws Exception {
        //TODO: No usar hasta que se valide el usuario y la clave contra el LDAP en la creación de la sesión: SrvSesionesServiceImpl.handleCreateSession(...)
        SesionVO sesion = this.getSrvSesionesService().consultaSesion(sesionId);
        if (sesion==null) 
        { 
        	ServicioDRIException e = new ServicioDRIException("Error almacenando pif["+(pif!= null? pif.getName():null)+"]. No existe sesión con el id["+sesionId+"].");
        	logger.warn(e);
        	throw e;
        } 
        if (sesion.getFechaExpiracion().before(new Date())) 
        {
        	ServicioDRIException e = new ServicioDRIException("Error almacenando pif["+(pif!= null? pif.getName():null)+"]. La sesión con el id["+sesionId+"] ha expirado.");
        	logger.warn(e);
        	throw e;
        } 
        ResultadoOperacionVO res;
        try {
//			Delegamos en el metodo seguro con usuario y clave la resolucion de tema
        	logger.info("Presentamos-Almacenamos fichero pif["+pif.getName()+"] al repositorio con id sesion["+sesionId+"] usuario["+sesion.getUsuario()+"]");
            // TODO: Hay que cambiar por un método similar que no haga falta la clave ya que la sesion ya ha sido validada con usuario y clave
        	handlePresentarAlmacenar(sesion.getUsuario(), EncriptacionUtiles.desencriptar(sesion.getClave()),pif);
        } catch (RuntimeException e1) {
        	ServicioDRIException e =new ServicioDRIException("Excepcion almacenando pif["+(pif!= null? pif.getName():null)+"] con id sesion["+sesionId+"] desde interfaz DRI.",e1);
        	logger.warn(e);
        	throw e;
        }
        logger.info("Almacenado pif con exito con id sesion["+sesionId+"]");
	}

    /**
	 * Este metodo devuelve un ODE en formato PIF. 
     * @param usuario Usuario perteneciente a la plataforma. 
     * @param clave Clave del usuario dentro de la platafoma.
     * @param mec Identificador del ODE que se quiere obtener.   
     * @return se retorna el ODE.
     * @throws Exception
     *      
     */
	private DataHandler solicitarEntregar( String mec) throws Exception {

//		Higiene de datos

		if (mec == null || mec.equals(""))
		{
			ServicioDRIException e = new ServicioDRIException("Error, mec vacio.");
        	logger.error(e);
        	throw e;
		}
    	
		try {
			//		Añadimos seguridad a la transaccion
			logger.info("Solicitando ODE con mec"+mec+"]");
			PaquetePifDriVO respuestaDri= this.getSrvEntregarService().generarPaquetePIF(mec);
			DataHandler respuesta = respuestaDri.getPaquetePIF();
			if (respuesta == null)
			{
				logger.error("Error solicitando con  mec["+mec+"] "+ respuestaDri.getResultadoValidacion().getResultadoValidacion());
				throw new Exception(respuestaDri.getResultadoValidacion().getResultadoValidacion());
			}
			return respuesta;
		} catch (RuntimeException e) {
			ServicioDRIException e1 = new ServicioDRIException("Excepcion solicitando con mec ["+mec+"].", e);
        	logger.error(e1);
        	throw e1;
		}
	}

    /**
	 * Este metodo devuelve un ODE en formato PIF. 
     * @param sesionId Identificador de la sesion que hay que haber inicializado. 
     * @param mec Identificador del ODE que se quiere obtener.   
     * @return se retorna el ODE.
     * @throws Exception
     *      
     */
	protected DataHandler handleSolicitarEntregarSesion(String sesionId, String mec) throws Exception {
		
        SesionVO sesion = this.getSrvSesionesService().consultaSesion(sesionId);
        if (sesion==null) 
        { 
        	ServicioDRIException e = new ServicioDRIException("Error solicitando mec["+mec+"]. No existe sesión con el id["+sesionId+"]");
        	logger.warn(e);
        	throw e;
        } 

        if (sesion.getFechaExpiracion().before(DateManager.dateToCalendar(new Date()))) 
        {
        	ServicioDRIException e = new ServicioDRIException("Error solicitando mec["+mec+"]. La sesión con el id["+sesionId+"] ha expirado");
        	logger.warn(e);
        	throw e;
        } 
        try {
        	logger.info("Solicitando paquete pif "+mec);
        	return solicitarEntregar(mec);
        }  catch (RuntimeException e) {
			ServicioDRIException e1 = new ServicioDRIException("Excepcion solicitando con sesion["+sesionId+"] usuario["+sesion.getUsuario()+"] y mec ["+mec+"].", e);
        	logger.error(e1);
        	throw e1;
		}

	}

	/** Para saber si el servicio está operativo
	 * 
	 * @return Boolean
	 * @throws Exception
	 * */
	protected Boolean handleEstasActivo() throws Exception {
		// TODO Auto-generated method stub
		return new Boolean(true);
	}

	/**
	 * Este metodo recoge un ODE y lo introduce en el ciclo de vida de la plataforma en el estado catalogar en el que un catalogador ha de realizar su labor sobre el ODE.
     * @param usuario Usuario perteneciente a la plataforma. 
     * @param clave Clave del usuario dentro de la platafoma.
     * @param pif Fichero del ODE en formato zip.   
     * @return En caso de exito, no se retorna nada.
     * @throws Exception
     *      
     */
	protected void handlePresentarCatalogar(String usuario, String clave, DataHandler pif) throws Exception {
		// //		Higiene de datos
		if (usuario == null || usuario.equals(""))
		{
			ServicioDRIException e = new ServicioDRIException("Error presentado catalogando pif["+(pif!= null? pif.getName():null)+"] con usuario vacio.");
        	logger.error(e);
        	throw e;
		}
		if (clave == null || clave.equals(""))
		{
			ServicioDRIException e = new ServicioDRIException("Error presentado catalogando pif["+(pif!= null? pif.getName():null)+"] con usuario ["+usuario+"] clave vacia.");
        	logger.error(e);
        	throw e;
		}
		if (pif == null || pif.getInputStream() == null)
		{
			ServicioDRIException e = new ServicioDRIException("Error presentado catalogando pif["+(pif!= null? pif.getName():null)+"] con usuario ["+usuario+"] y fichero vacio["+pif.getName()+"].");
        	logger.error(e);
        	throw e;
		}
    	//Comprobamos si existe el usuario
		if (!Autenticar.validarUsuario(usuario))
		{
			ServicioDRIException e = new ServicioDRIException("Error presentado catalogando pif["+pif.getName()+"] con usuario ["+usuario+"] . El usuario no esta autenticado en el sistema.");
			logger.error(e);
			throw e;
		}
		ResultadoOperacionVO res;
		String titulo=null;
		try {
//			Añadimos seguridad a la transaccion
			logger.info("Presentamos-Catalogamos antes de meter la mochila");
			Autenticar.anadirSeguridad(usuario, clave);
			logger.info("Presentamos-Catalogamos fichero pif["+pif.getName()+"] al repositorio con usuario["+usuario+"] ");
			titulo=this.obtenerNombre(usuario);
			res = this.getSrvPublicacionService().crearPIFCatalogado(pif, usuario, CATALOGA_DRI, titulo);
		} catch (RuntimeException e1) {
			ServicioDRIException e =new ServicioDRIException("Excepcion presentado catalogando pif["+pif.getName()+"] con usuario ["+usuario+"] y titulo ["+titulo+"] desde interfaz DRI.",e1);
    		logger.warn(e);
    		throw e;
		}
    	if (!res.getIdResultado().equals(SIN_ERRORES))
    	{
    		ServicioDRIException e =new ServicioDRIException("Error presentado catalogando pif["+pif.getName()+"] con usuario ["+usuario+"] y titulo ["+titulo+"] desde interfaz DRI["+res.getIdResultado()+"]->["+res.getDescripcion()+"]");
    		logger.warn(e);
    		throw e;
    	}
    	logger.info("Catalogado pif["+pif.getName()+"] con exito con usuario ["+usuario+"] y titulo "+titulo+"]");
		
	}

	/**
	 * Este metodo recoge un ODE y lo introduce en el ciclo de vida de la plataforma en el estado catalogar en el que un catalogador ha de realizar su labor sobre el ODE.
     * @param sesionId Identificador de la sesion que hay que haber inicializado. 
     * @param pif contenido del ODE en formato ZIP.   
     * @return En el caso de exito no se retorna nada.
     * @throws Exception
     *      
     */
	protected void handlePresentarCatalogarSesion(String sesionId, DataHandler pif) throws Exception {

        //TODO: No usar hasta que se valide el usuario y la clave contra el LDAP en la creación de la sesión: SrvSesionesServiceImpl.handleCreateSession(...)

        SesionVO sesion = this.getSrvSesionesService().consultaSesion(sesionId);
        if (sesion==null) 
        { 
        	ServicioDRIException e = new ServicioDRIException("Error presentado catalogando pif["+(pif!= null? pif.getName():null)+"]. No existe sesión con el id["+sesionId+"].");
        	logger.warn(e);
        	throw e;
        } 
        if (sesion.getFechaExpiracion().before(new Date())) 
        {
        	ServicioDRIException e = new ServicioDRIException("Error presentado catalogando pif["+(pif!= null? pif.getName():null)+"]. La sesión con el id["+sesionId+"] ha expirado.");
        	logger.warn(e);
        	throw e;
        } 
        ResultadoOperacionVO res;
        try {
//			Delegamos en el metodo seguro con usuario y clave la resolucion de tema
        	logger.info("Presentamos-Catalogamos fichero pif["+pif.getName()+"] al repositorio con id sesion["+sesionId+"] usuario["+sesion.getUsuario()+"]");
            // TODO: Hay que cambiar por un método similar que no haga falta la clave ya que la sesion ya ha sido validada con usuario y clave
        	handlePresentarCatalogar(sesion.getUsuario(), EncriptacionUtiles.desencriptar(sesion.getClave()),pif);
        } catch (RuntimeException e1) {
        	ServicioDRIException e =new ServicioDRIException("Excepcion presentado catalogando pif["+(pif!= null? pif.getName():null)+"] con id sesion["+sesionId+"] desde interfaz DRI.",e1);
        	logger.warn(e);
        	throw e;
        }
        logger.info("Catalogado pif con exito con id sesion["+sesionId+"]");
	}
	
	private String obtenerNombre(String usuario){
		
		String valor=String.valueOf(System.currentTimeMillis());
		String nombre=usuario+valor+ZIP;
		return nombre;
	}

	
}

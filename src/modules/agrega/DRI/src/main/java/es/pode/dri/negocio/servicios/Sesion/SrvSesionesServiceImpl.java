/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.dri.negocio.servicios.Sesion;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.dri.negocio.dominio.Sesion;
import es.pode.dri.negocio.dominio.SesionDao;
import es.pode.dri.negocio.servicios.DRI.SesionNoValidaException;
import es.pode.dri.negocio.servicios.SesionVO;
import es.pode.soporte.seguridad.encriptacion.EncriptacionUtiles;
import es.pode.soporte.utiles.date.DateManager;

/**
 * @see es.pode.dri.negocio.servicios.Sesion.SrvSesionesService
 */

public class SrvSesionesServiceImpl
    extends es.pode.dri.negocio.servicios.Sesion.SrvSesionesServiceBase
{
	private Logger logger = Logger.getLogger(this.getClass());
	
	private final String CLAVE_SESION_ANONIMA = "anonymous";

	private final long tiempoExpirar = 300000;

	 /**
	 * Crea una nueva sesion asociada al usuario.
	 * Chequea contra el autenticador la identidad del usuario que intenta crear una conexion.
     * @param userID Identificador del usuario. 
     * @param password Contrase�a del usuario.   
     * @return se retorna el identificador de la sesi�n creada.
     * @throws Exception
     *      
     */
    protected java.lang.String handleCreateSession(java.lang.String userID, java.lang.String password)
        throws java.lang.Exception
    {
        //TODO Validar el usuario y la clave contra el LDAP sin utilizar la encriptaci�n
    	//Validamos al usuaro contra el sistema.
    	String claveEncriptada = EncriptacionUtiles.encriptar(password);

        try {
            if (authenticate(userID, password))
            {
                SesionDao sesionDao = this.getSesionDao();
                SesionVO sesionVO = new SesionVO();
                sesionVO.setAnonima(new Boolean(false));
                sesionVO.setFechaCreacion(DateManager.dateToCalendar(new Date(System.currentTimeMillis())));
                sesionVO.setFechaExpiracion(DateManager.dateToCalendar(new Date(System.currentTimeMillis()+tiempoExpirar)));
                sesionVO.setUsuario(userID);
                sesionVO.setClave(claveEncriptada);
                Sesion sesion = sesionDao.fromSesionVO(sesionVO);
                sesionDao.create(sesion);
                logger.info("Sesi�n creada para usuario["+userID+"] autenticado en la plataforma.");
                return sesion.getIdSesion();
            }
            else // el usuario no esta autenticado en la plataforma.
            {
                logger.info("Sesi�n no creada para usuario["+userID+"] y clave["+password+"]. No esta autenticado en la plataforma.");
                return null;
            }
        } catch (NamingException ne) {
            return handleThrowableAndReturnRef(ne);
        } catch (RuntimeException re) {
            return handleThrowableAndReturnRef(re);
        }
    }

    private String handleThrowableAndReturnRef(Throwable t) {
        // This WS API has historically returned null on commonly occurring
        // failures so we do not break that contract.
        logger.error(t);
        return null;
    }

	private boolean authenticate(String userID, String password)
        throws NamingException {
        DirContext ctx = null;
		try {
			//
			// We cannot directly load a properties file as the "JNDI environment";
			// configuring from agrega.properties is a requirement.
			//
			AgregaProperties		 props   = AgregaPropertiesImpl.getInstance();
			Hashtable<String,String> jndiEnv = getJNDIEnvFromConf(props);

			ctx = new InitialDirContext(jndiEnv);
			logger.debug("LDAP bind for the agent user succeeded.");
			String userDN = getDNForUser(userID, props, ctx);
			logger.debug("Retrieved \"" + userDN + "\" for userID: " + userID);
			ctx = bindWithUserCredentials(jndiEnv, userDN, password);
			logger.debug("Authentication for user " + userID + " succeeded.");

			return true;
		} finally {
			if (ctx != null) ctx.close();
		}
    }

	private Hashtable<String, String> getJNDIEnvFromConf(AgregaProperties props) {
		Hashtable<String, String> env = new Hashtable<String, String>();

		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL,
				props.getProperty("driLdapUrl"));
		env.put(Context.SECURITY_PROTOCOL,
				props.getProperty("driLdapProtocol"));
		env.put(Context.SECURITY_PRINCIPAL,
				props.getProperty("driLdapPrincipal"));
		env.put(Context.SECURITY_CREDENTIALS,
				props.getProperty("driLdapCredentials"));

		return env;
	}

	private String getDNForUser(
		String userID, AgregaProperties props, DirContext ctx)
        throws NamingException {

		String			userDN			 = null;
		SearchControls	subtreeSrchCtrls = new SearchControls();

		subtreeSrchCtrls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		String srchFilter = props.getProperty("driLdapUsernameSearchAttribute") +
			"=" + userID;

		NamingEnumeration users = ctx.search(
			props.getProperty("driLdapSearchBase"),
			srchFilter,
			subtreeSrchCtrls);

		if (users.hasMoreElements()) {
			SearchResult res = (SearchResult) users.nextElement();
			userDN = res.getNameInNamespace();
		}

		// This unlikely scenario will require administrator's attention
		if (users.hasMoreElements()) {
			throw new RuntimeException(
				"More than one users retrieved for \"" + srchFilter + "\"");
		}

		return userDN;
	}

	private DirContext bindWithUserCredentials(
		Hashtable<String,String> jndiEnv, String userDN, String password)
        throws NamingException {
		jndiEnv.put(Context.SECURITY_PRINCIPAL, userDN);
		jndiEnv.put(Context.SECURITY_CREDENTIALS, password);
		return new InitialDirContext(jndiEnv);
	}

    /**
	 * Crea una sesion sin usuario definido o con usuario anonimo.
     * @param no hay par�metros de entrada.      
     * @return se retorna el identificador de la sesi�n creada.
     * @throws Exception
     *      
     */
    protected java.lang.String handleCreateAnonymousSession()
        throws java.lang.Exception
    {
    	String anonName = "anonimo";
        SesionDao sesionDao = this.getSesionDao();
        SesionVO sesionVO = new SesionVO();
        sesionVO.setAnonima(new Boolean(true));
        sesionVO.setFechaCreacion(DateManager.dateToCalendar(new Date(System.currentTimeMillis())));
        sesionVO.setFechaExpiracion(DateManager.dateToCalendar(new Date(System.currentTimeMillis()+tiempoExpirar)));
        sesionVO.setUsuario(anonName);
        sesionVO.setClave(this.CLAVE_SESION_ANONIMA);
        Sesion sesion = sesionDao.fromSesionVO(sesionVO);
        sesionDao.create(sesion);
        logger.info("Sesi�n anonima creada.");
        return sesion.getIdSesion();
    }

    /**
	 * Este metodo limpia las sesiones caducadas almacenadas en la tabla de sesiones.
     * @param no hay par�metros de entrada.      
     * @return no se retorna nada.
     * @throws Exception
     *      
     */
    protected void handleLimpiarSesiones()
        throws java.lang.Exception
    {
    	SesionDao sesionDao = this.getSesionDao();
    	ArrayList allSesions = (ArrayList) sesionDao.loadAll(SesionDao.TRANSFORM_NONE);
    	for (int i=0; i<allSesions.size(); i++) {
    		Sesion sesion = (Sesion) allSesions.get(i);
    		if (sesion.getFechaExpiracion().after(new Date(System.currentTimeMillis()))) {
    			if (logger.isDebugEnabled())
    				logger.debug("Eliminado sesion caducada con fecha expiracion["+sesion.getFechaExpiracion()+"] usuario["+sesion.getUsuario()+"]");
    			sesionDao.remove(sesion);
    		}
    	}
    }

    /**
	 * Borra una sesion del sistema.
     * @param sessionID Identificador de la sesion que se quiere eliminar.     
     * @return no se retorna nada.
     * @throws Exception
     *      
     */
    protected void handleDestroySession(java.lang.String sessionID)
        throws java.lang.Exception
    {
    	SesionDao sesionDao = this.getSesionDao();
    	logger.info("Eliminando sesion con id["+sessionID+"]");
        sesionDao.remove(sessionID);
    }

    /**
	 * Este metodo devuelve una sesion.
     * @param id Identificador de la sesion.     
     * @return se retorna la sesion con el identificador.
     * @throws Exception
     *      
     */
    protected es.pode.dri.negocio.servicios.SesionVO handleConsultaSesion(java.lang.String id)
        throws java.lang.Exception
    {
        SesionDao sesionDao = this.getSesionDao();
        Sesion sesion = sesionDao.load(String.valueOf(id));
		if (sesion!=null) {
			SesionVO sesionVO = (SesionVO) sesionDao.toSesionVO(sesion);
			if (sesionVO.getFechaExpiracion().after(DateManager.dateToCalendar(new Date(System.currentTimeMillis())))) {
				sesion.setFechaExpiracion(DateManager.dateToCalendar(new Date(System.currentTimeMillis()+ tiempoExpirar)));
				sesionDao.update(sesion);
				return sesionVO;
			} else {
				SesionNoValidaException e = new SesionNoValidaException("La sesi�n ha expirado. ID[" + id+"]");
				logger.warn("Intento de acceso a sesi�n expirada id["+id+"]",e);
				throw e;
			}	
		} else {
			SesionNoValidaException e = new SesionNoValidaException("No se ha encontrado la sesi�n con id[" + id+"]");
			logger.warn("No se ha encontrado la sesi�n con id["+ id+"]", e);
			throw e;
		}
    }

    /**
	 * Este metodo modifica una sesion.
	 * Se tiene que comprobar que dicha sesion existe antes de modificarla.
     * @param sesion Sesion que se tiene que modificar con los parametros modificados.   
     * @return se retorna la sesion modificada.
     * @throws Exception
     *      
     */
    protected es.pode.dri.negocio.servicios.SesionVO handleModificarSesion(es.pode.dri.negocio.servicios.SesionVO sesion)
        throws java.lang.Exception
    {
        SesionDao sesionDao = this.getSesionDao();
        Sesion ses = sesionDao.load(sesion.getIdSesion());
        if(sesion == null)
        {
        	logger.warn("Error intentando modificar sesion con id["+sesion.getIdSesion()+"] de usuario["+sesion.getUsuario()+"]");
        	throw new SesionNoValidaException("Error intentando modificar sesion con id["+sesion.getIdSesion()+"] de usuario["+sesion.getUsuario()+"]");
        }
//        Comprobamos que existen todos los parametros que exigimos para la actualizacion de sesion
        if (sesion.getAnonima() != null && sesion.getFechaCreacion() != null && sesion.getFechaExpiracion() != null &&
        		sesion.getUsuario() != null && sesion.getClave() != null)
        {
        	ses.setAnonima(sesion.getAnonima());
        	ses.setFechaCreacion(sesion.getFechaCreacion());
        	ses.setFechaExpiracion(sesion.getFechaExpiracion());
        	ses.setUsuario(sesion.getUsuario());
        	ses.setClave(EncriptacionUtiles.encriptar(sesion.getClave()));
        	sesionDao.update(ses);
        	logger.info("Error modificando sesion con id["+sesion.getIdSesion()+"]. Algun campo requerido es vacio:anonima["+sesion.getAnonima()
        			+"], fecha creacion["+ sesion.getFechaCreacion()+"] fecha expiracion["+sesion.getFechaExpiracion()
        			+"] usuario["+sesion.getUsuario()+"] clave["+sesion.getClave()+"]");
        	return sesion;
        }
        else
        {
        	String texto = "Error modificando sesion con id["+sesion.getIdSesion()+"]. Algun campo requerido es vacio:anonima["+(sesion.getAnonima()!=null?sesion.getAnonima():null)
			+"], fecha creacion["+ (sesion.getFechaCreacion()!=null?sesion.getFechaCreacion():null)
			+"] fecha expiracion["+(sesion.getFechaExpiracion()!=null?sesion.getFechaExpiracion():null)
			+"] usuario["+(sesion.getUsuario()!=null?sesion.getUsuario():null)
			+"] clave["+(sesion.getClave()!=null?sesion.getClave():null)
			+"]";
        	logger.warn(texto);
        	throw new SesionNoValidaException(texto);
        }
        
    }
}

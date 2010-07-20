/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.seguridad.ldap;

import org.acegisecurity.GrantedAuthority;
import org.apache.log4j.Logger;

/**
 * Clase de utilidades para el user details propio
 * */
public class LdapUserDetailsUtils {
	
	private static Logger log = Logger.getLogger(LdapUserDetailsUtils.class);
	private static String HOST = "localhost:8080";
	private static String PUERTO = "";
	private static String SUBDOMINIO = "";
	private static String HOST_SERVICES="localhost";
	private static String PUERTO_SERVICES="8080";
	private static String SUBDOMINIO_SERVICES="";
	public static String getHost()
	{
		return HOST;
	}
	
	public static String getPort()
	{
		return PUERTO;
	}
	
	public static String getSubdominio() {
		return SUBDOMINIO;
	}
	
	public static String getHostServices()
	{
		return HOST_SERVICES;
	}
	
	public static String getPortServices()
	{
		return PUERTO_SERVICES;
	}
	
	public static String getSubdominioServices()
	{
		return SUBDOMINIO_SERVICES;
	}
	
	/**
	 * Extrae del userDetails el idioma
	 * 
	 * @return string idioma
	 * */	
	public static String getIdioma(){
		es.pode.soporte.offline.configuracion.ConfiguracionDao config = es.pode.soporte.offline.configuracion.ConfiguracionDao.instance(); 
		return config.getProperty(es.pode.soporte.offline.configuracion.ConfiguracionDao.IDIOMA);
	}	

	/**
	 * Extrae del userDetails el idioma predeterminado de búsqueda
	 * 
	 * @return string idioma de consulta
	 * */	
	public static String getIdiomaBusqueda(){
		//TODO idioma busqueda?
		es.pode.soporte.offline.configuracion.ConfiguracionDao config = es.pode.soporte.offline.configuracion.ConfiguracionDao.instance(); 
		return config.getProperty(es.pode.soporte.offline.configuracion.ConfiguracionDao.IDIOMA);
	}	
	
	/**
	 * Extra del userDetails el nombreCompleto del usuario
	 * 
	 * @return string nombre completo
	 * */
	public static String getNombreCompleto(){
		es.pode.soporte.offline.configuracion.ConfiguracionDao config = es.pode.soporte.offline.configuracion.ConfiguracionDao.instance(); 
		return config.getProperty(es.pode.soporte.offline.configuracion.ConfiguracionDao.NOMBRE);
	}	
		
	/**
	 * Extrae del userDetails el nombre del usuario
	 * 
	 * @return string nombre del usuario
	 * */	
	public static String getUsuario(){
		es.pode.soporte.offline.configuracion.ConfiguracionDao config = es.pode.soporte.offline.configuracion.ConfiguracionDao.instance(); 
		return config.getProperty(es.pode.soporte.offline.configuracion.ConfiguracionDao.USER);
	}		
	
	/**
	 * Extrae del userDetails el correo electrónico
	 * 
	 * @return string correo electronico
	 **/ 	
	public static String getMail(){
		es.pode.soporte.offline.configuracion.ConfiguracionDao config = es.pode.soporte.offline.configuracion.ConfiguracionDao.instance(); 
		return config.getProperty(es.pode.soporte.offline.configuracion.ConfiguracionDao.EMAIL);
	}	
	
	/**
	 * Extrae del userDetails el empaquetador
	 * 
	 * @return string empaquetador
	 **/ 	
	public static String getEmpaquetador(){
		es.pode.soporte.offline.configuracion.ConfiguracionDao config = es.pode.soporte.offline.configuracion.ConfiguracionDao.instance(); 
		return config.getProperty(es.pode.soporte.offline.configuracion.ConfiguracionDao.EMPAQUETADOR);
	}
	
	/**
	 * Extrae del userDetails el catalogador
	 * 
	 * @return string catalogador
	 **/ 	
	public static String getCatalogador(){
		es.pode.soporte.offline.configuracion.ConfiguracionDao config = es.pode.soporte.offline.configuracion.ConfiguracionDao.instance(); 
		return config.getProperty(es.pode.soporte.offline.configuracion.ConfiguracionDao.CATALOGADOR);
	}
	
	
	/**
	 * Extrae del userDetails el login del usuario
	 * 
	 * @return string login del usuario
	 **/ 	
	public static String getLogin(){
		//TODO login?
		es.pode.soporte.offline.configuracion.ConfiguracionDao config = es.pode.soporte.offline.configuracion.ConfiguracionDao.instance(); 
		return config.getProperty(es.pode.soporte.offline.configuracion.ConfiguracionDao.USER);
	}
	
	/**
	 * Extrae las autorizaciones de un usuario (array vacio en offline)
	 * 
	 * @return GrantedAuthority[] permisos
	 **/ 	
	public static GrantedAuthority[] getRoles(){
		return new GrantedAuthority[]{};
	}

	/**
	 * Version offline. Siempre usar funcionalidad de usuario autenticado.
	 * 
	 * @return boolean true si esta autenticado y false de lo contrario
	 **/ 	
	public static boolean estaAutenticado(){		 
        return true;
    }
	
	/**
	 * Version offline. No hay funcionalidad especifica del administrador.
	 * 
	 * @return boolean true si es administrador y false de lo contrario
	 **/ 	
	public static boolean esAdministrador(){
        return false;
	}

}
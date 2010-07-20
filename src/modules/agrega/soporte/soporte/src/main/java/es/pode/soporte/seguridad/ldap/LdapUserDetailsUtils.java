/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.seguridad.ldap;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.log4j.Logger;

/**
 * Clase de utilidades para el user details propio
 * */
public class LdapUserDetailsUtils {
	
	private static String HOST; //la url y puerto vendrá en la variable admin.ws.host
	private static String PUERTO;
	private static String SUBDOMINIO;
	private static String HOST_SERVICES; //la url y puerto vendrá en la variable admin.ws.host
	private static String PUERTO_SERVICES;
	private static String SUBDOMINIO_SERVICES;
	private static Logger log = Logger.getLogger(LdapUserDetailsUtils.class);
	
	static{
		Properties prop=new Properties();
		ClassLoader loader = LdapUserDetailsUtils.class.getClassLoader();
		InputStream in = loader.getResourceAsStream("agrega.properties");
		try {
			prop.load(in);
			HOST = prop.getProperty("admin.host");
			PUERTO = prop.getProperty("admin.puerto");
			SUBDOMINIO = prop.getProperty("admin.subdominio");
			if(SUBDOMINIO==null)SUBDOMINIO="";
			HOST_SERVICES = prop.getProperty("admin.ws.host");
			PUERTO_SERVICES = prop.getProperty("admin.ws.puerto");
			SUBDOMINIO_SERVICES = prop.getProperty("admin.ws.subdominio");
		} catch (IOException e) {
			log.error(e);
			if(HOST==null)SUBDOMINIO="localhost";
			if(PUERTO==null)SUBDOMINIO="8080";
			if(SUBDOMINIO==null)SUBDOMINIO="";
			if(HOST_SERVICES==null)SUBDOMINIO="localhost";
			if(PUERTO_SERVICES==null)SUBDOMINIO="8080";
			if(SUBDOMINIO_SERVICES==null)SUBDOMINIO="";
		}		
	}
	
	public static String getHost()
	{
		return HOST;
	}
	
	public static String getPort()
	{
		return PUERTO;
	}
	
	public static String getSubdominio()
	{
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails ud = (UserDetails)auth.getPrincipal();		
		return ((LdapUserDetailsAgrega)ud).getIdioma();
	}	

	/**
	 * Extrae del userDetails el idioma predeterminado de búsqueda
	 * 
	 * @return string idioma de consulta
	 * */	
	public static String getIdiomaBusqueda(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails ud =(UserDetails)auth.getPrincipal();		
		return ((LdapUserDetailsAgrega)ud).getIdiomaBusqueda();
	}	
	
	/**
	 * Extra del userDetails el nombreCompleto del usuario
	 * 
	 * @return string nombre completo
	 * */
	public static String getNombreCompleto(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails ud = (UserDetails)auth.getPrincipal();		
		return ((LdapUserDetailsAgrega)ud).getNombreCompleto();		
	}	
		
	/**
	 * Extrae del userDetails el nombre del usuario
	 * 
	 * @return string nombre del usuario
	 * */	
	public static String getUsuario(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails ud=(UserDetails)auth.getPrincipal();		
		return ud.getUsername();
	}		
	
	/**
	 * Extrae del userDetails el correo electrónico
	 * 
	 * @return string correo electronico
	 **/ 	
	public static String getMail(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails ud = (UserDetails)auth.getPrincipal();		
		return ((LdapUserDetailsAgrega)ud).getMail();
	}	
	
	/**
	 * Extrae del userDetails el empaquetador
	 * 
	 * @return string empaquetador
	 **/ 	
	public static String getEmpaquetador(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails ud = (UserDetails)auth.getPrincipal();		
		return ((LdapUserDetailsAgrega)ud).getEmpaquetador();
	}
	
	/**
	 * Extrae del userDetails el login del usuario
	 * 
	 * @return string login del usuario
	 **/ 	
	public static String getLogin(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails ud = (UserDetails)auth.getPrincipal();		
		return ((LdapUserDetailsAgrega)ud).getLogin();
	}
	
	/**
	 * Extrae las autorizaciones de un usuario
	 * 
	 * @return GrantedAuthority[] permisos
	 **/ 	
	public static GrantedAuthority[] getRoles(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails ud = (UserDetails)auth.getPrincipal();
		return ((LdapUserDetailsAgrega)ud).getAuthorities();
	}
	
	/**
	 * Extrae el tipo de catalogador de un usuario
	 * 
	 * @return String catalogador
	 **/ 	
	public static String getCatalogador(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails ud = (UserDetails)auth.getPrincipal();
		return ((LdapUserDetailsAgrega)ud).getCatalogador();
	}
	
	/**
	 * Extrae del userDetails la cuota de almacenamiento
	 * 
	 * @return Long cuota
	 **/ 	
	public static Long getCuota(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails ud = (UserDetails)auth.getPrincipal();		
		return ((LdapUserDetailsAgrega)ud).getCuota();
	}

	/**
	 * Se informa si esta o no logado
	 * 
	 * @return boolean true si esta autenticado y false de lo contrario
	 **/ 	
	public static boolean estaAutenticado(){		 
        try {
        
        	if (SecurityContextHolder.getContext() != null && 
        		SecurityContextHolder.getContext().getAuthentication() != null && 
        		SecurityContextHolder.getContext().getAuthentication().getPrincipal() != null && 
        		SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails)
        		return true;
        	else
        		return false;
        }
        catch (Exception e) {
        	log.error("Error: " + e);
        	return false;
        }
    }
	
	/**
	 * Se informa si el usuario es Administrador o no
	 * 
	 * @return boolean true si es administrador y false de lo contrario
	 **/ 	
	public static boolean esAdministrador(){
        try {
            if (estaAutenticado()){
            	GrantedAuthority[] roles = LdapUserDetailsUtils.getRoles();
        		for (int i=0; i<roles.length; i++){
        			GrantedAuthority rol = (GrantedAuthority)roles[i];
        			if (rol.getAuthority().equalsIgnoreCase("ROLE_ADMINISTRADOR")){
        				return true;
        			}
        		}
            }
            return false;
        }
        catch (Exception e) {
        	log.error("Error: " + e);
        	return false;
        }
	}

}
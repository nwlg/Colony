/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.seguridad.encriptacion;

import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
//import org.acegisecurity.userdetails.UserDetails;
//import org.acegisecurity.userdetails.ldap.LdapUserDetails;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.pode.soporte.seguridad.ldap.LdapUserDetailsAgrega;
import es.pode.soporte.seguridad.ldap.WrapperSrvAdminUsuarios;
import es.pode.soporte.seguridad.servicios.UsuarioVO;
import uk.co.siriusit.acegi.shibboleth.ShibbolethPassThroughAuthenticationProvider;

public class Autenticar 
{
	private static Log log = LogFactory.getLog(Autenticar.class);
	private final static String ROLE_ANONYMOUS = "ANONYMOUS";
	
	
    /**
     * Se añade en el contexto de seguridad el usuario y los datos asociados a él sin la clave de usuario
     *
     * @param usuario El usuario que se va a añadir al contexto  
     *
     * @return boolean true: Si se han añadido los datos al contexto de seguridad 
     * 		           false: Si no se ha podido añadir los datos al contexto de seguridad 
     */
	public static boolean cargarContextoSeguridad(String usuario)
	{
		LdapUserDetailsAgrega.Essence user = null;
		try
		{			
			if (log.isDebugEnabled()) 
				log.debug("Se obtienen los datos del usuario: " + usuario);		
			
			UsuarioVO datosUsuario = WrapperSrvAdminUsuarios.obtenerDatosUsuario(usuario);
			
			if (log.isDebugEnabled()) 
				log.debug("Se prepara el UserDetails");
			
			user = new LdapUserDetailsAgrega.Essence();							
			user.setUsername(usuario);
			user.setDatosUsuario(usuario);
						
			if (log.isDebugEnabled()) 
				log.debug("Se añade el rol anónimo");
			
			/* Añadimos el rol anónimo */
			GrantedAuthority permisosAnadir[] = new GrantedAuthority[1];
			permisosAnadir[0] = new GrantedAuthorityImpl(ROLE_ANONYMOUS);
			if (log.isDebugEnabled()) 
				log.debug("Se recuperan los roles del usuario en la BBDD");
	
			/* Obtenemos los roles del usuario */
			GrantedAuthority permisosUsuario[] = null;
			permisosUsuario = WrapperSrvAdminUsuarios.obtenerAnadirRoles(permisosAnadir, usuario, null);
			
			if (log.isDebugEnabled()) 
				log.debug("Se le añade la seguridad al proceso");
			
			/* Auntenticamos el usuario y lo ponemos en el contexto de seguridad del usuario */
			Authentication currentAuth = new UsernamePasswordAuthenticationToken(user.createUserDetails(), ShibbolethPassThroughAuthenticationProvider.PASS_THROUGH_AUTH_TOKEN, permisosUsuario);
			SecurityContextHolder.getContext().setAuthentication(currentAuth);
		}
		catch (Exception e)
		{
			log.error("Error al autenticar y añadir la seguridad al proceso", e);
			return false;
		}
		
		return true;
	}
	
    /**
     * Se comprueba si el usuario y la clave son correctas y 
     * si es así se añade el usuario en el contexto de seguridad y los datos asociados a él
     *
     * @param usuario El usuario que se va a añadir al contexto  
     * @param clave La clave del usuario
     *
     * @return boolean true: Si se ha añadido la seguridad 
     * 		           false: Si no se ha podido añadir la seguridad 
     */
	public static boolean anadirSeguridad(String usuario, String claveEncriptada) {
		LdapUserDetailsAgrega.Essence user = null;
		try
		{
			user = new LdapUserDetailsAgrega.Essence();			
			user.setUsername(usuario);
			user.setDatosUsuario(usuario);			
			user.setPassword(null);
						
			if (log.isDebugEnabled()) 
				log.debug("Se añade el rol anónimo");
			
			/* Añadimos el rol anónimo */
			GrantedAuthority permisosAnadir[] = new GrantedAuthority[1];
			permisosAnadir[0] = new GrantedAuthorityImpl(ROLE_ANONYMOUS);
			if (log.isDebugEnabled()) 
				log.debug("Se recuperan los roles del usuario en la BBDD");
	
			/* Obtenemos los roles del usuario */
			GrantedAuthority permisosUsuario[] = null;
			permisosUsuario = WrapperSrvAdminUsuarios.obtenerAnadirRoles(permisosAnadir, usuario, null);
			
			if (log.isDebugEnabled()) 
				log.debug("Se le añade la seguridad al proceso");
			
			/* Auntenticamos el usuario y lo ponemos en el contexto de seguridad del usuario */
			Authentication currentAuth = new UsernamePasswordAuthenticationToken(user.createUserDetails(), ShibbolethPassThroughAuthenticationProvider.PASS_THROUGH_AUTH_TOKEN, permisosUsuario);
			SecurityContextHolder.getContext().setAuthentication(currentAuth);
		}
		catch (Exception e) {
			log.error("Error al autenticar y añadir la seguridad al proceso", e);
			return false;
		}
		
		return true;
	}
	
    /**
     * Se comprueba si el usuario y la claveEncriptada son correctas 
     *
     * @deprecated No usar. La clave encriptada no debe residir en el base de datos.
     *
     * @param usuario El usuario que se va a añadir al contexto  
     * @param claveEncriptada La clave encriptada del usuario
     *
     * @return boolean true: Si es válido 
     * 		           false: Si no es válido
     */
	public static boolean validarUsuarioClave(String usuario, String claveEncriptada)
	{
		try
		{
			if (log.isDebugEnabled()) 
				log.debug("Se obtienen los datos del usuario " + usuario);		
			
			UsuarioVO datosUsuario = WrapperSrvAdminUsuarios.obtenerDatosUsuario(usuario);
			
			/* Validamos si la clave es correcta */
			if (!claveEncriptada.equals(datosUsuario.getClaveEncriptada())) {
				log.info("Clave incorrecta. Usuario: " + usuario);
				return false;				
			}
		}
		catch (Exception e)
		{
			log.error("Error en el proceso de autenticación", e);
			return false;
		}
		
		return true;
	}
	
    /**
     * Se comprueba si el usuario y la claveEncriptada son correctas 
     *
     * @param usuario El usuario que se va a añadir al contexto  
     *
     * @return boolean true: Si es existe 
     * 		           false: Si no es válido
     */
	public static boolean validarUsuario(String usuario) {
		
		try {
			if (log.isDebugEnabled()) 
				log.debug("Se obtienen los datos del usuario " + usuario);		
			
			UsuarioVO datosUsuario = WrapperSrvAdminUsuarios.obtenerDatosUsuario(usuario);
			
			if (datosUsuario == null || datosUsuario.getUsuario() == null) {
				log.info("El usuario: " + usuario + " no existe en la BBDD");
				return false;
			}
		}
		catch (Exception e)
		{
			log.error("Error en el proceso de autenticación", e);
			return false;
		}
		
		return true;
	}
}

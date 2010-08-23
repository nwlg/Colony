/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.seguridad.ldap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.userdetails.User;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.log4j.Logger;

import es.pode.soporte.seguridad.servicios.SrvAdminUsuariosService;
import es.pode.soporte.seguridad.servicios.SrvAdminUsuariosServiceServiceLocator;
import es.pode.soporte.seguridad.servicios.UsuarioVO;

/**
 * Wrapper para la invocacion del web service de got para obtener dado una coleccion de nombres de roles,
 * los roles de sistema asociados.Estos roles los meteremos como GrantedAuthority en el contexto de acegi
 *  
 * */
public class WrapperSrvAdminUsuarios {

	private static String PREFIJO_ROL_ACEGI="ROLE_";
	private static Logger log = Logger.getLogger(WrapperSrvAdminUsuarios.class);
	
	/**
	 * Obtención de los roles del usuario e inserción en el contexto de seguridad de Acegi
	 * 
	 * @param authorities[] GrantedAuthority con las autorizaciones del usuario
	 * @param usuario string con el login del usuario
	 * @param password string con la clave del usuario
	 * @return GrantedAuthority[] array de GrantedAuthority
	 * */
	public static GrantedAuthority[] obtenerRoles(GrantedAuthority authorities[],String usuario,String password)
	{
		Collection rolesAcceso = new ArrayList();
		Collection resultadoNombres = null;
		boolean excepcion = false;

		log("Obtenemos los nombres de los roles de acceso recuperados de ldap");
		for(int i=0;i<authorities.length;i++){
			rolesAcceso.add(authorities[i].getAuthority());
			log("ROL del LDAP: " + authorities[i].getAuthority());
		}	
		
		if (!rolesAcceso.isEmpty())
		{
			transformarRolesAcceso(rolesAcceso);
			
			SrvAdminUsuariosServiceServiceLocator serviceLocator = new SrvAdminUsuariosServiceServiceLocator();						
			SrvAdminUsuariosService servicio = null;
			
			try
			{
				/* Para la invocacion del ws con seguridad*/
				if (password == null) password = ""; // ms active directory no rellena el campo password al autenticar
                UserDetails user = new User(usuario,password,true,false,true,true,new GrantedAuthority[0]);
                log("Se ha creado el UserDetails " + user);
                Authentication currentAuth = new UsernamePasswordAuthenticationToken(user,null);
                log("Se ha creado el Authentication " + currentAuth);
                SecurityContextHolder.getContext().setAuthentication(currentAuth);        
                servicio = serviceLocator.getSrvAdminUsuariosService();
                log("Referencia al servicio web " + servicio);
                log("Recuperamos los roles del usuario del web service");
                String[] rolesUsuarios = servicio.listarRolesUsuario(usuario);
                log("Roles del usuario: " + rolesUsuarios.toString());
                resultadoNombres = Arrays.asList(rolesUsuarios);
                		
                /* Reseteamos el contexto de Acegi */				
				SecurityContextHolder.getContext().setAuthentication(null);
			}
			catch (Exception e) {
				log.error("Se ha producido un error al invocar al web service Administración de usuarios:" + e);
				excepcion = true;				
			}			
		}
		
		if (resultadoNombres != null && !resultadoNombres.isEmpty())
		{
			Collection resultado = new ArrayList();
			String nombre = null;
			GrantedAuthority ga = null;
			
			for(Iterator it = resultadoNombres.iterator(); it.hasNext(); )
			{
				nombre = (String)it.next();
				ga = new GrantedAuthorityImpl(PREFIJO_ROL_ACEGI + nombre.toUpperCase());
				log("ROL añadido: " + PREFIJO_ROL_ACEGI + nombre.toUpperCase());
				resultado.add(ga);
			}
			
			return (GrantedAuthority[])resultado.toArray(new GrantedAuthority[resultado.size()]);			
		}
		else
		{
			if (excepcion)
			{
				excepcion = false;
				GrantedAuthority ga = new GrantedAuthorityImpl("error");	
				GrantedAuthority[] gas = {ga};
				return gas;
			}
			else
				return new GrantedAuthority[0];
		}
	}

	/**
	 * Obtención de los roles del usuario a partir unicamente del usuario (para validación openID) e inserción en el contexto de seguridad de Acegi
	 * 
	 * @param authorities[] GrantedAuthority con las autorizaciones del usuario
	 * @param usuario string con el login del usuario
	 * @param password string con la clave del usuario
	 * @return GrantedAuthority[] array de GrantedAuthority
	 * */
	public static GrantedAuthority[] obtenerRolesOpenId(String usuario)
	{
		System.out.println("obtenerRolesOpenID");
		Collection resultadoNombres = new ArrayList();
		Collection resultado = new ArrayList();		
		SrvAdminUsuariosServiceServiceLocator serviceLocator = new SrvAdminUsuariosServiceServiceLocator();
		System.out.println("serviceLocator "+serviceLocator);
		SrvAdminUsuariosService servicio = null;
			
		try
		{
			servicio = serviceLocator.getSrvAdminUsuariosService();
            log("servicio "+servicio);
            String[] rolesUsuarios = servicio.listarRolesUsuario(usuario);
            System.out.println("rolesUsuarios "+rolesUsuarios);
            for (int j = 0; j < rolesUsuarios.length; j++)
            {
            	resultadoNombres.add(rolesUsuarios[j]);
            	System.out.println("Roles BBDD: " + rolesUsuarios[j]);
            }
            
            /* Se añaden los roles pasados por el usuario */
            /*
			if (authorities.length > 0)
			{
				for (int i = 0; i < authorities.length; i++)
				{
					resultadoNombres.add(authorities[i].getAuthority());
					log("Roles añadidos: " + authorities[i].getAuthority());
				}
			}
             */      		
            /* Reseteamos el contexto de Acegi */				
			SecurityContextHolder.getContext().setAuthentication(null);
			
			if (resultadoNombres != null && !resultadoNombres.isEmpty())
			{
				String nombre = null;
				GrantedAuthority ga = null;
				
				for(Iterator it = resultadoNombres.iterator(); it.hasNext(); )
				{
					nombre = (String)it.next();
					ga = new GrantedAuthorityImpl(PREFIJO_ROL_ACEGI + nombre.toUpperCase());
					System.out.println("ROL añadido: " + PREFIJO_ROL_ACEGI + nombre.toUpperCase());
					resultado.add(ga);
				}
				ga = new GrantedAuthorityImpl(PREFIJO_ROL_ACEGI + "ANONYMOUS");
				resultado.add(ga);
			}			
		}
		catch (Exception e) {
			System.out.println("Error al invocar al servicio web de Administración de usuarios:" + e);			
		}		
		
		return (GrantedAuthority[])resultado.toArray(new GrantedAuthority[resultado.size()]);
	}
	
	
	/**
	 * Obtención de los datos del usuario
	 *  
	 * @param usuario string con el login de usuario
	 * @return datosUsuario UsurioVO
	 * */
	public static UsuarioVO obtenerDatosUsuario(String usuario)
	{
		SrvAdminUsuariosServiceServiceLocator serviceLocator = new SrvAdminUsuariosServiceServiceLocator();			
		SrvAdminUsuariosService servicio = null;
		UsuarioVO datosUsuario = null;
		
		try
		{	
			 servicio = serviceLocator.getSrvAdminUsuariosService();
             log("Ref. Servicio web " + servicio);
             datosUsuario = servicio.obtenerDatosUsuario(usuario);
             log("Datos del usuario: " + datosUsuario);
		}
		catch (Exception e) 
		{
			log.error("Se ha producido un error al invocar al servicio web de Administración de usuarios:" + e);				
		}			
		
		return datosUsuario;
	}
	
	/**
	 * Obtención de los roles del usuario sin seguridad más los enviados
	 * 
	 * @param authorities[] GrantedAuthority con las autorizaciones que queramos añadir a las que tenga el usuario
	 * @param usuario string con el login del usuario
	 * @param password string con la clave del usuario
	 * @return GrantedAuthority[] array de GrantedAuthority
	 * */
	public static GrantedAuthority[] obtenerAnadirRoles(GrantedAuthority authorities[], String usuario,String password)
	{
		Collection resultadoNombres = new ArrayList();
		Collection resultado = new ArrayList();		
		SrvAdminUsuariosServiceServiceLocator serviceLocator = new SrvAdminUsuariosServiceServiceLocator();						
		SrvAdminUsuariosService servicio = null;
			
		try
		{
			servicio = serviceLocator.getSrvAdminUsuariosService();
            log("Recuperamos los roles del usuario del web service");
            String[] rolesUsuarios = servicio.listarRolesUsuario(usuario);
     
            for (int j = 0; j < rolesUsuarios.length; j++)
            {
            	resultadoNombres.add(rolesUsuarios[j]);
            	log("Roles BBDD: " + rolesUsuarios[j]);
            }
            
            /* Se añaden los roles pasados por el usuario */
			if (authorities.length > 0)
			{
				for (int i = 0; i < authorities.length; i++)
				{
					resultadoNombres.add(authorities[i].getAuthority());
					log("Roles añadidos: " + authorities[i].getAuthority());
				}
			}
                   		
            /* Reseteamos el contexto de Acegi */				
			SecurityContextHolder.getContext().setAuthentication(null);
			
			if (resultadoNombres != null && !resultadoNombres.isEmpty())
			{
				String nombre = null;
				GrantedAuthority ga = null;
				
				for(Iterator it = resultadoNombres.iterator(); it.hasNext(); )
				{
					nombre = (String)it.next();
					ga = new GrantedAuthorityImpl(PREFIJO_ROL_ACEGI + nombre.toUpperCase());
					log("ROL añadido: " + PREFIJO_ROL_ACEGI + nombre.toUpperCase());
					resultado.add(ga);
				}
			}			
		}
		catch (Exception e) {
			log.error("Error al invocar al servicio web de Administración de usuarios:" + e);			
		}		
		
		return (GrantedAuthority[])resultado.toArray(new GrantedAuthority[resultado.size()]);
	}
	
	
	/**
	 * Obtención de los datos del usuario
	 *  
	 * @param urlOpenId string con la url del openId del usuario
	 * @return datosUsuario UsurioVO
	 * */
	public static UsuarioVO obtenerDatosUsuarioOpenId(String urlOpenId)
	{
		log("obtenerDatosUsuarioOpenId urlOpenId "+urlOpenId);
		SrvAdminUsuariosServiceServiceLocator serviceLocator = new SrvAdminUsuariosServiceServiceLocator();
		log("serviceLocator "+serviceLocator);
		SrvAdminUsuariosService servicio = null;
		UsuarioVO datosUsuario = null;
		
		try
		{	
			 servicio = serviceLocator.getSrvAdminUsuariosService();
             log("Ref. Servicio web " + servicio);
             datosUsuario = servicio.obtenerUsuarioConOpenId(urlOpenId);
             log("Datos del usuario: " + datosUsuario);
		}
		catch (Exception e) 
		{
			log.error("Se ha producido un error al invocar al servicio web de Administración de usuarios:" + e);				
		}			
		
		return datosUsuario;
	}
	
	
	/**
	 * Método que recibe una coleccion de nombres con el prefijo ROLE_ y devuelve esa misma coleccion
	 * sin el prefijo.
	 * 
	 * @param rolesAcceso Collection  de los roles
	 * */
	private static void transformarRolesAcceso(Collection rolesAcceso)
	{
		Collection tmp=new ArrayList();
		
		for(Iterator it=rolesAcceso.iterator(); it.hasNext(); )
		{
			tmp.add(((String)it.next()).substring(PREFIJO_ROL_ACEGI.length()));			
		}
		rolesAcceso.clear();
		rolesAcceso.addAll(tmp);
	}
	
	private static void log (Object obj)
	{
		if (log.isDebugEnabled())
			log.debug(obj);
	}
}
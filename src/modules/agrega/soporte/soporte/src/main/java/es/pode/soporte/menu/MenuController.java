/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.menu;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import net.sf.dozer.util.mapping.DozerBeanMapperSingletonWrapper;
import net.sf.dozer.util.mapping.MapperIF;

import org.acegisecurity.Authentication;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.userdetails.UserDetails;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.tiles.ComponentContext;
import org.apache.struts.tiles.Controller;
import org.apache.struts.tiles.actions.TilesAction;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import es.agrega.soporte.agregaProperties.AgregaProperties;
import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public abstract class MenuController extends TilesAction implements Controller {
	
	public static java.util.Properties pSpringProperties = null;

	protected static final String FILE_NAME_PROPERTIES = "/menu.properties";
	
	protected static final String FILE_NAME_XML = MenuController.getPropertyValue("xml_file",MenuController.FILE_NAME_PROPERTIES);
	protected static final String ROLE_ANONYMOUS = MenuController.getPropertyValue("anonimo",MenuController.FILE_NAME_PROPERTIES);
	protected static final String ROLE_EMPAQUETADOR = MenuController.getPropertyValue("empaquetador",MenuController.FILE_NAME_PROPERTIES);
	protected static final String ROLE_ADMINISTRADOR = MenuController.getPropertyValue("administrador",MenuController.FILE_NAME_PROPERTIES);
	protected static final String SEPARATOR = ",";
	protected static final String MENU_METANAVEGACION = MenuController.getPropertyValue("key_metanavegacion",MenuController.FILE_NAME_PROPERTIES);
	
	protected static Log logger = LogFactory.getLog(MenuController.class); 
	protected static MenuHandlerXml menuHandler = null;
	
	private MapperIF beanMapper = DozerBeanMapperSingletonWrapper.getInstance();
	
	public MenuController()
	{
		try {
			this.parsingXML();
		} catch (IOException e) {
			logger.error(e);
		} catch (SAXException e) {
			logger.error(e);
		} catch (ParserConfigurationException e) {
			logger.error(e);
		}
	}

	public MapperIF getBeanMapper() {
		return beanMapper;
	}

	public void setBeanMapper(MapperIF beanMapper) {
		this.beanMapper = beanMapper;
	}

	public void perform(ComponentContext arg0, HttpServletRequest arg1, HttpServletResponse arg2, ServletContext arg3) throws ServletException, IOException {
		try {
			execute(arg0, arg1, arg2, arg3);
		} 
		catch (Exception e) 
		{
			logger.error(e);
		}
	}

	protected void parsingXML() throws IOException, SAXException, ParserConfigurationException
	{
		if (MenuController.menuHandler == null)
		{
			menuHandler = new MenuHandlerXml();
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(true);
			SAXParser parser =  factory.newSAXParser();
			parser.parse(new InputSource(this.getClass().getResourceAsStream("/"+MenuController.FILE_NAME_XML)), menuHandler);
		}
	}
	
	protected MenuItem itemXml2ItemVO(MenuItemXml itemXml, String sUrl, String queryString, ServletContext context, HttpServletRequest request)
	{
		MenuItem itemVo=null;
		try {
			itemVo = (MenuItem)this.getBeanMapper().map(itemXml,MenuItem.class);
			
			if (itemVo.getLinkConcatVar() != null && !itemVo.getLinkConcatVar().equals(""))
			{
				// Si tenemos concatVar la concatenamos a la ruta
				// Esto se ha inventado para el tema Ayuda.
				// Recojo la variable del request y construyo la URL
				String url2Concat = String.valueOf(request.getAttribute(itemVo.getLinkConcatVar()));
				if (logger.isDebugEnabled())
					logger.debug("Tenemos Url para concatenar = " + url2Concat);
				
				itemVo.setRelativeLink(url2Concat);
				if (logger.isDebugEnabled())
					logger.debug("La URL para asociar es = " + itemVo.getLink());
			}
			else
				itemVo.setRelativeLink(context.getInitParameter(itemVo.getLink()));
			//TODO: Revisar cuando tengamos idiomas
			itemVo.setI18nKey(getResource(itemVo.getI18nKey(),ConstantesAgrega.APPLICATION_PROPERTIES,(Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)));
			itemVo.setSelected(MenuController.checkUrlPattern(sUrl, queryString, itemXml.getPattern()));
			
		} catch (Exception e) {
			logger.error("Excepcion no controlada en menu: ",e);
		}
		return itemVo;
	}


	protected ArrayList menuFilter(String sType, GrantedAuthority[] authorities, String sUrl, ServletContext context)
	{
		return this.menuFilter(sType, authorities, sUrl, null, context, null);
	}

	// nueva sobrecarga por que necesitamos la request para la i18n
	protected ArrayList menuFilter(String sType, GrantedAuthority[] authorities, String sUrl, ServletContext context, HttpServletRequest request)
	{
		return this.menuFilter(sType, authorities, sUrl, null, context, request);
	}

	protected ArrayList menuFilter(String sType, GrantedAuthority[] authorities, String sUrl, String queryString, ServletContext context, HttpServletRequest request)
	{
		//recogemos la variable del nodo neutro
		String nodoNeutro=AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.NEUTRO);
		
		ArrayList arrayMenu = new ArrayList(5);
		Menu menu = MenuController.getMenu(sType);
		
		for (int i = 0; i < authorities.length; i++)
		{
			if (menu != null && checkRol(menu.getRoles(), authorities[i]))
			{
				Iterator it = menu.arrayMenuItem.iterator();
				while (it.hasNext())
				{
					MenuItemXml itemXml = (MenuItemXml)it.next();
					if (checkRol(itemXml.getRoles(), authorities[i]))
					{
						MenuItem itemvo = this.itemXml2ItemVO(itemXml, sUrl, queryString, context, request);
						if (!arrayMenu.contains(itemvo))
							arrayMenu.add(itemvo);
					}
				}
			}
		}
		for(int i=0;i < arrayMenu.size();i++){
			if (MenuController.logger.isDebugEnabled())
				MenuController.logger.debug("MenuController itemvo.getLink() es["+((MenuItem)arrayMenu.get(i)).getLink()+"] LdapUserDetailsUtils.getHost() es ["+LdapUserDetailsUtils.getHost()+"], LdapUserDetailsUtils.getSubdominio() es ["+LdapUserDetailsUtils.getSubdominio()+"]");
				((MenuItem)arrayMenu.get(i)).setLink("http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+((MenuItem)arrayMenu.get(i)).getLink());
		}
		boolean borrado = false;
		//Si el nodo neutro esta activo eliminamos del menu la opcion de Acceder/Registrarse
		if(sType.equalsIgnoreCase(MENU_METANAVEGACION) && nodoNeutro.equalsIgnoreCase("true"))
		{
			if (MenuController.logger.isDebugEnabled())
				MenuController.logger.debug("Estamos en el menu de metanavegacion y el nodo es neutro");
			for(int i=0;i<arrayMenu.size();i++)
			{
				MenuItem itemBorrar = (MenuItem)arrayMenu.get(i);
			
				if(itemBorrar.getId().equalsIgnoreCase("restringida"))
					borrado = arrayMenu.remove(itemBorrar);
			}
		}
		if (MenuController.logger.isDebugEnabled())
			MenuController.logger.debug("Se ha borrado del menu acceder/registrarse? - " + borrado);
		
		return arrayMenu;
	}
	
	protected GrantedAuthority[] getRoles()
	{
		GrantedAuthority[] authorities = null;
		try
		{
			
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (logger.isDebugEnabled())
				logger.debug("Vamos a mirar si tenemos UserDetails");
			if (auth.getPrincipal() != null && auth.getPrincipal() instanceof UserDetails)
			{
				if (logger.isDebugEnabled())
					logger.debug("Si tenemos UserDetails y los roles son...");
				authorities = LdapUserDetailsUtils.getRoles();
				if (logger.isDebugEnabled())
					logger.debug("authorities = " + this.array2Traza(authorities));
			}
			else
			{
				authorities =  auth.getAuthorities();
				if (logger.isWarnEnabled())
					logger.warn("NO tenemos UserDetails y los roles son... authorities = " + this.array2Traza(authorities));
			}
				
			//Ahora viene una ñapa y es si, el usaurio se ha autenticado y tiene
			// más de un rol, eliminamos el Rol Anónimo de la lista para
			// evitar ver botones que sólo deben aparecer a un usaurio anónimo.
			if (authorities.length > 1)
			{
				ArrayList arrayAuthorities = new ArrayList(authorities.length-1);
				for (int i = 0; i < authorities.length; i++)
				{
					boolean isAnonymous = (authorities[i].getAuthority().equalsIgnoreCase(MenuController.ROLE_ANONYMOUS));
					if (logger.isDebugEnabled())
						logger.debug("El role ["+authorities[i]+"] es anónimo ["+isAnonymous+"]");
					if (!isAnonymous)
					{
						if (logger.isDebugEnabled())
							logger.debug("El role ["+authorities[i]+"] no es anónimo y se añade a la lista de roles");
						arrayAuthorities.add(authorities[i]);
					}
				}
				arrayAuthorities=ordenarRolesPortada(arrayAuthorities);
				authorities = (GrantedAuthority[])arrayAuthorities.toArray(new GrantedAuthority[arrayAuthorities.size()]);
			}
			if (logger.isDebugEnabled())
				logger.debug("Finalmente los roles devueltos son... " + this.array2Traza(authorities));
			
		}
		catch (Exception ex)
		{
			if (logger.isErrorEnabled())
				logger.equals("Se ha producido un error al coger los roles " + ex.getMessage() + " Causa = " + ex.getCause());
			ex.printStackTrace();
		}
		return authorities;
	}

	private boolean checkRol(String[] roles2Check, GrantedAuthority authority)
	{
		boolean bReturn = false;
		if (roles2Check != null)
		{
			for (int i = 0; !bReturn && i < roles2Check.length; i++)
			{
				bReturn = roles2Check[i].equals(authority.getAuthority());
			}
		}
		return bReturn;
	}
	
	/**Metodos estáticos**/
	public static String getPropertyValue(String sKey, String file) 
	{
		String sReturn = null;
		try {
			if (pSpringProperties == null)
			{
				InputStream fIsSpringProperties = MenuController.class.getResourceAsStream(file);
				pSpringProperties = new java.util.Properties();
				pSpringProperties.load(fIsSpringProperties);
			}
			sReturn = pSpringProperties.getProperty(sKey); 
		} catch (IOException e) {
			logger.error(e);
		}
		
		// devolvemos la propiedad
		return sReturn;
	}
	
	public String array2Traza (Object[] array)
	{
		StringBuffer sb = new StringBuffer();
		if (array!= null)
		{
			for (int i = 0; i < array.length; i++)
			{
				sb.append("La posicion [");
				sb.append(i);
				sb.append("] del array de tipo [");
				sb.append(array.getClass().getName());
				sb.append("] es [");
				sb.append(array[i]);
				sb.append("]");
				sb.append("\n");
			}
		}
		return sb.toString();
	}

	
	public static boolean checkUrlPattern(String sURL, String queryString, String sPattern)
	{
		boolean resultado = false;
		if (MenuController.logger.isDebugEnabled())
			MenuController.logger.debug("url = " + sURL + " sPattern = " + sPattern + " queryString = " + queryString);
		if(sPattern != null && !sPattern.equals("")){
			String[] patterns = sPattern.split(",");
			
			for (int k = 0;k<patterns.length&&!resultado ;k++)
			{
				resultado = resultado||(sURL.indexOf(patterns[k])!= -1) || 
				(queryString != null && queryString.indexOf(patterns[k])!= -1);
			}
		}
		return resultado;
	}
	
	public static Menu getMenu(String sKey)
	{
		Menu menuReturn =null;
		if (sKey != null && !sKey.equals("") && MenuController.menuHandler != null)
			menuReturn = MenuController.menuHandler.getMenu(sKey); 
		return menuReturn;
	}

	public static String getResource(String key, String baseName, Locale locale){
        String recurso = "";
        ResourceBundle theResourceBundle = null;
        try{
        	theResourceBundle = ResourceBundle.getBundle(baseName,locale);
            if (theResourceBundle!=null){
               recurso = theResourceBundle.getString(key);
           }
        }catch (MissingResourceException mre){
        	try{
        		locale = new Locale("","");
        		theResourceBundle = ResourceBundle.getBundle(baseName,locale);
                if (theResourceBundle!=null){
                	recurso = theResourceBundle.getString(key);
                }
             }catch (MissingResourceException mre2){
            	 recurso = key;
             }
        }
        return recurso;
    }
private static ArrayList ordenarRolesPortada( ArrayList roles){
		
		GrantedAuthority[] rolesDestino=new GrantedAuthority[roles.size()];
		ArrayList vuelta=new ArrayList();
		if(!(roles==null) && roles.size()>0){	
			rolesDestino[0]=(GrantedAuthority)roles.get(0);
			GrantedAuthority rolAux=null;
			for(int i=0;i<roles.size();i++){
				GrantedAuthority authority=(GrantedAuthority)roles.get(i);
				if(authority.getAuthority().equals(MenuController.ROLE_EMPAQUETADOR) || authority.getAuthority().equals(MenuController.ROLE_ADMINISTRADOR)){
					rolAux=rolesDestino[0];
					rolesDestino[0]=(GrantedAuthority) roles.get(i);
					rolesDestino[i]=rolAux;
				}else{
					rolesDestino[i]=(GrantedAuthority)roles.get(i);
				}
			}
			for(int j=0;j<rolesDestino.length;j++){
				vuelta.add(rolesDestino[j]);
			}
		}else{
			return null;
		}
		return vuelta;
		
	}
}

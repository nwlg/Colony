/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.tag.socializacion;

import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;
import es.agrega.soporte.tag.help.LinkTag;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class SocialTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static java.util.Properties pSpringProperties = null;
	protected static Log logger = LogFactory.getLog(SocialTag.class); 
	
	private static final String PROPERTIES_FILE_NAME = "/socializacion.properties";
	private static final String KEY_APPLICATION_RESOURCES_NAME = "application_properties_file";
	
	public static final String KEY_XML_FILE_NAME 	= "xml_file";
	public static final String KEY_QUE_ES_ESTO_LINK = SocialTag.getPropertyValue("que_es_esto");
	public static final String KEY_XML_SOCIAL_TAG 	= SocialTag.getPropertyValue("tag_social");
	public static final String KEY_XML_I18N_TAG 	= SocialTag.getPropertyValue("tag_i18nKey");
	public static final String KEY_XML_TARGET_TAG 	= SocialTag.getPropertyValue("tag_target");	
	
	public final static String ENVIAR = "social.enviar";
	
	private String url = null;	
	private String identificadorODE = null;
	private String buscadorEmpaquetador = null;
	private String busquedaSimpleAvanzada = null;
	private String idioma = null;
	private String titulo = null;
	private String urlImagen = null;	
	private String mostrarVuelta = null;
	
	private static String i18nKey = null;
	private String target = null;
	
	private static ArrayList itemList = null;	

	public String getBuscadorEmpaquetador() {
		return buscadorEmpaquetador;
	}

	public void setBuscadorEmpaquetador(String buscadorEmpaquetador) {
		this.buscadorEmpaquetador = buscadorEmpaquetador;
	}
	
	public String getMostrarVuelta() {
		return mostrarVuelta;
	}

	public void setMostrarVuelta(String mostrarVuelta) {
		this.mostrarVuelta = mostrarVuelta;
	}
	
	public String getBusquedaSimpleAvanzada() {
		return busquedaSimpleAvanzada;
	}

	public void setBusquedaSimpleAvanzada(String busquedaSimpleAvanzada) {
		this.busquedaSimpleAvanzada = busquedaSimpleAvanzada;
	}	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}	
	
	public String getIdentificadorODE() {
		return identificadorODE;
	}

	public void setIdentificadorODE(String identificadorODE) {
		this.identificadorODE = identificadorODE;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	
	public String getUrlImagen() {
		return urlImagen;
	}

	public void setUrlImagen(String urlImagen) {
		this.urlImagen = urlImagen;
	}
		
	
	public int doStartTag() throws JspException {
	      try {
	    	  String urlEnviar = "";
	    	  ServletRequest sRequest = pageContext.getRequest();
	    	  if (sRequest != null && sRequest instanceof HttpServletRequest)
	    	  {
	    		  HttpServletRequest httpRequest = (HttpServletRequest)sRequest;	    		  
	    		  this.setUrl(URLEncoder.encode(this.getServerName(httpRequest.getScheme(), httpRequest.getServerName(), httpRequest.getServerPort())+this.getUrl(),"UTF-8"));
	    		  
	    	  }
	    	  urlEnviar = this.getUrl();
	    	  //Se parsea el itemList
	    	  itemList = this.parsing();
	    	  
	    	  JspWriter out = pageContext.getOut();
	    	  //	    	REALIZAMOS EL TRATAMIENTO DE LOS LITERALES PARA PODER INTRODUCIRLOS EN EL CÓDIGO HTML
  			  String fichero="application-resources";
	  			Locale locale = null;
				try {
					locale = devuelveLocale();
				} catch (Exception e1) {
					logger.error("Error obteniendo el locale",e1);
				}
  			  String literalEnviar=this.getResource(ENVIAR, fichero, locale);  			  
  			  
//	    	  //Se pinta el enlace para enviar un correo
	    	  out.println("<li class=\"enviar_objeto\"><a href=\"http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/buscador/EnviarMailCU/EnviarMailCU.do?identificadorODE=" + identificadorODE + "&amp;idioma=" + idioma + "&amp;tipoLayoutBuscador=" + buscadorEmpaquetador + "&amp;urlODE=" + urlEnviar + "&amp;titulo=" + titulo + "&amp;mostrarVuelta=" + mostrarVuelta +"&amp;urlImagen=" + urlImagen + "\" title=\""+ literalEnviar +"\"><span>" + literalEnviar + "</span></a></li>");
	    	  for (int i=0; i< itemList.size(); i++)
	    	  {
	    		  SocialItem item = (SocialItem)itemList.get(i);		    		 
	    		  out.println("<li><a href='"+item.getLink()+"' target='"+item.getTarget()+"' title='"+item.getName()+"' id='"+item.getId()+"'>&nbsp;<em>"+item.getName()+"</em></a></li>");	    		  
	    	  }
	    	  String titulo = ResourceBundle.getBundle(LinkTag.PROPERTIES_FILE_NAME, (Locale)((HttpServletRequest)pageContext.getRequest()).getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getString("listar.odecu.mostrar.resultados.detalles.queEsEsto");
	    	  out.println("<li><a href='http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/buscador/DetallarODECU/MostrarDetalleODEQueEsEsto.do?identificadorODE="+this.getIdentificadorODE()+"&idioma="+this.getIdioma()+"&busquedaSimpleAvanzada="+this.getBusquedaSimpleAvanzada()+"&tipoLayoutBuscador="+this.getBuscadorEmpaquetador()+"&mostrarVuelta="+this.getMostrarVuelta()+"' target='' title='"+titulo+"' class='underl'><span>"+titulo+"</span></a></li>");
	      } catch (Exception ex) {
	         throw new JspTagException("SocialTag: " + 
	            ex.getMessage());
	      }
	      return SKIP_BODY;
	   }
	
	   public int doEndTag() throws JspException{
	      return EVAL_PAGE;
	   }
	   
	   private ArrayList parsing()
	   {
		   String xmlFileName = null;
		   ArrayList listSocial = new ArrayList(5);
		   try
		   {
			   xmlFileName = SocialTag.getPropertyValue(SocialTag.KEY_XML_FILE_NAME);
			   ResourceBundle resource = ResourceBundle.getBundle(SocialTag.getPropertyValue(SocialTag.KEY_APPLICATION_RESOURCES_NAME), (Locale)((HttpServletRequest)pageContext.getRequest()).getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
	
			   SAXBuilder builder = new SAXBuilder();
			   Document doc = builder.build(SocialTag.class.getResourceAsStream("/"+xmlFileName));
			   Element root = doc.getRootElement();
			   Element social = root.getChild(SocialTag.KEY_XML_SOCIAL_TAG);
			   List attrList = social.getAttributes();
			   Iterator it =SocialTag.checkList(attrList);
			   if (it != null)
			   {
				   while (it.hasNext())
				   {
					   Attribute el = (Attribute)it.next();
					   if (el.getName().equals(SocialTag.KEY_XML_I18N_TAG))
					   {
						   SocialTag.i18nKey=resource.getString(el.getValue());
						   if (logger.isDebugEnabled())
							   logger.debug("El nombre i18nKey es ["+SocialTag.i18nKey+"]" );
					   }
					   else if (el.getName().equals(SocialTag.KEY_XML_TARGET_TAG))
					   {
						   this.target=el.getValue();
						   if (logger.isDebugEnabled())
							   logger.debug("El target es ["+this.target+"]" );
					   }
				   }
			   }
			   List childList = social.getChildren();
			   it = SocialTag.checkList(childList);
			   if (it != null)
			   {
				   while (it.hasNext())
				   {
					   SocialItem socialItem = new SocialItem((Element)it.next(),this.target,this.getUrl());
					   listSocial.add(socialItem);
				   }
			   }
		   }
		   catch (Exception ex)
		   {
			   logger.error("Se ha producido un error al intentar parsear el fichero [" + xmlFileName + "]");
			   logger.error(ex);
		   }
		   return listSocial;
	   }
	   	   
	   public static Iterator checkList(List elementList)
	   {
		   Iterator it = null;
		   if (elementList != null)
		   {
			   it = elementList.iterator();
		   }
		   return it;
	   }
	   
	   public static String getPropertyValue(String sKey) 
	   {
			String sReturn = null;
			try {
				if (pSpringProperties == null)
				{
					InputStream fIsSpringProperties = SocialTag.class.getResourceAsStream(SocialTag.PROPERTIES_FILE_NAME);
					pSpringProperties = new java.util.Properties();
					pSpringProperties.load(fIsSpringProperties);
					fIsSpringProperties.close();
				}
				sReturn = pSpringProperties.getProperty(sKey); 
			} catch (IOException e) {
				logger.error(e);
			}
			
			// devolvemos la propiedad
			return sReturn;
		}
	   
	   private String getServerName(String scheme, String serverName, int port)
	   {
		   StringBuffer sb = new StringBuffer();
		   sb.append(scheme);
		   sb.append("://");
		   sb.append(serverName);
		   sb.append(LdapUserDetailsUtils.getSubdominio());
//		   if (port > 0)
//		   {
//			   sb.append(":");
//			   sb.append(port);
//		   }
		   return sb.toString();
	   }
	   
	   //MÉTODOS PARA PINTAR LOS MENSAJES INTERNACIONALIZADOS
	   public static String getResource(String key, String baseName, Locale locale){
	        String recurso = "";
	        ResourceBundle theResourceBundle = getResource(baseName,locale);
	        try{
	        	if (theResourceBundle!=null){
	               recurso = theResourceBundle.getString(key);
	           }
	        }catch (MissingResourceException mre){
	        	recurso = key;
	        }
	        return recurso;
	    }
		
		public static ResourceBundle getResource(String baseName, Locale locale){
	        try{
	        	return ResourceBundle.getBundle(baseName,locale);
	            
	        }catch (MissingResourceException mre){
	        		locale = new Locale("","");
	        		return ResourceBundle.getBundle(baseName,locale);
	             
	        }
	    }

		private Locale devuelveLocale() throws Exception
		{
			Locale locale=null;
			if (pageContext.getRequest() instanceof HttpServletRequest) {
				locale = (Locale)((HttpServletRequest)pageContext.getRequest()).getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
				
			}
			else{ 	    					
				try {
					locale=new Locale(I18n.getInstance().obtenerIdiomaDefectoPlataforma());
				} catch (Exception e) {								
					logger.error("Error obteniendo el locale de la request",e);
				}
			}
			return locale;
		}	
	
}

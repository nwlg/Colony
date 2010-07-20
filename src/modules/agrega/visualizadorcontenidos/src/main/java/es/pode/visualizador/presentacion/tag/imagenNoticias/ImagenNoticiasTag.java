/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.visualizador.presentacion.tag.imagenNoticias;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class ImagenNoticiasTag extends BodyTagSupport{
	
	private static Logger logger = Logger.getLogger(ImagenNoticiasTag.class);	
	
	private static String HTTP = "http://";
	
	
	private int NUMPXCARACTERANCHO = 5;
	private int NUMPXCARACTERALTO = 12;
	private int NOVCIENTOSCINCUENTA = 950;
	
	private Integer alineamiento = null;
	private String cuerpo = null;
	private String imagen = null;
	
	public Integer getAlineamiento() {
		return alineamiento;
	}
	
	public void setAlineamiento(Integer alineamiento) {
		this.alineamiento = alineamiento;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	
	public String getImagen() {
		return imagen;
	}
	public void setImagen (String imagen){
		this.imagen = imagen;
	}
	
	
	/**
	* doStartTag is called by the JSP container when the tag is encountered
	*/
	    public int doStartTag() throws JspException{
	    	
	    	try {   				
		    		JspWriter out = pageContext.getOut(); 
		    		
		    		
//		    		<c:if test="${!empty form.URLImagen}">
//					<c:choose>
//						<c:when test="${form.alineamientoImg == 1}">
//							<a href="${form.URLImagen}" target="_blank"><img  src="${form.URLImagen}" alt="${form.URLImagen}" class="imagen_flotante_izq" /></a>					
//						</c:when>
//						<c:otherwise>
//							<a href="${form.URLImagen}" target="_blank"><img  src="${form.URLImagen}" alt="${form.URLImagen}" class="imagen_flotante_der"/></a>					
//						</c:otherwise>
//					</c:choose>
//					</c:if>${form.cuerpo}<br /><br />
		    		
		    		if (logger.isDebugEnabled()) logger.debug("El valor del cuerpo es ["+cuerpo+"]");
		    		
		    		
		    		
		    		/**
		    		 * Hay cuatro posibilidades de alineamiento:
		    		 * - Arriba-izquierda
		    		 * - Arriba-derecha
		    		 * - Abajo-izquierda
		    		 * - Abajo-derecha
		    		 * */
		    		
		    		//Se comprueba si viene la imagen
		    		if (imagen != null && !"".equals(imagen))
		    		{
		    			if(logger.isDebugEnabled())logger.debug("Viene con imagen");
		    			
		    			//Se recalcula el ancho y el alto
		    			String url = HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen;
		    			int ancho = 0;
                        int alto = 0;
		    			try
		    			{
		    				if(logger.isDebugEnabled())logger.debug("url imagen tag="+url.substring(0,url.lastIndexOf("/")+1)+codificarURL(url.substring(url.lastIndexOf("/")+1)));
		    				URL urlImagen= new URL(url.substring(0,url.lastIndexOf("/")+1)+codificarURL(url.substring(url.lastIndexOf("/")+1)));
		    				BufferedImage image = ImageIO.read(urlImagen);                   
		    			
			    			int w = image.getWidth(); 
	                        int h = image.getHeight();	                        
	                        
	                        if (w<300 && h<300)
	                        {
	                            // imagen en su tamaño
	                        	  ancho = w;
	                        	  alto = h;                            
	
	                        }else if (w>h)
	                        {
	                        	//imagen horizontal
	                              ancho=300;
	                              alto=(ancho*h)/w;                             
	
	                        }else if (h>w)
	                        { 
	                        	//imagen vertical
		                          alto=300;	
		                          ancho=(alto*w)/h;	                          
	
	                        }else if (h==w)
	                        {
	                        	// imagen cuadrada
	                              ancho=250;
	                              alto=ancho;	                              
	                         }   
		    			}catch(Exception e){

                            logger.error("Error al buscar la imagen", e);

		    			}
		    			
		    			if (logger.isDebugEnabled()) logger.debug("El ancho de la imagen es ["+ancho+"] y el alto es ["+alto+"]");
		    			//Se comprueba el alineamiento
		    			if (alineamiento.intValue() == 3 || alineamiento.intValue() == 2)
		    			{
//		    				Se pinta el texto, la imagen y más texto
		    				// 1 linea ocupa 13 px
		    				// 1 linea tiene 140 caracteres
		    				
		    				//Se comprueba el numero de lineas que ocupa la imagen y el texto
		    				logger.debug("Se comprueba el numero de lineas que ocupa la imagen y el texto");
		    				if (logger.isDebugEnabled()) logger.debug("El numero de caracteres del cuerpo es ["+cuerpo.length()+"]");
//		    				Se calcula en numero de caracteres que ocupa la imagen	
		    				int numCaracteresAlto = alto/NUMPXCARACTERALTO;
		    				int numCaracteresAncho = ancho/NUMPXCARACTERANCHO;
		    				if (logger.isDebugEnabled()) logger.debug("El numero de caracteres que ocupa el alto es ["+numCaracteresAlto+"] y el ancho es ["+numCaracteresAncho+"]");
	    					int numCaracteresImagen = numCaracteresAlto*numCaracteresAncho;
	    					int numCaracteresPrimero = cuerpo.length()-numCaracteresImagen;	
	    					if (logger.isDebugEnabled()) logger.debug("Primero ocupan ["+numCaracteresPrimero+"] caracteres");
		    				if (cuerpo.length() <= numCaracteresImagen && numCaracteresPrimero < 0)
		    				{
		    					numCaracteresPrimero = numCaracteresPrimero - NOVCIENTOSCINCUENTA;
//		    					Si el numero de lineas de texto no supera el numero de lineas de la imagen se pinta la imagen y luego el texto
		    					if(logger.isDebugEnabled())logger.debug("El numero de lineas de texto no supera al numero de lineas de la imagen");
//		    					Se pinta la imagen y luego el texto
			    				out.println("<a href=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" target=\"_blank\">");
			    					if (alineamiento.intValue() == 3)
			    					{
			    						//derecha
			    						out.println("<img  src=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" alt=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" class=\"imagen_flotante_der\" width=\""+ancho+"\" height=\""+alto+"\"/>");
			    					}
			    					else
			    					{
			    						//izquierda
			    						out.println("<img  src=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" alt=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" class=\"imagen_flotante_izq\" width=\""+ancho+"\" height=\""+alto+"\"/>");
			    					}
			    				out.println("</a>");
			    				out.println(cuerpo);
		    				}
		    				else
		    				{
		    					String stringPrimero = "";
		    					String stringSegundo = "";
		    					if(logger.isDebugEnabled())logger.debug("El numero de lineas de texto supera al numero de lineas de la imagen");    					
		    					
		    					stringPrimero = cuerpo.trim().substring(0,numCaracteresPrimero);		    					
		    					stringSegundo = cuerpo.trim().substring(numCaracteresPrimero, cuerpo.length()-1);
		    					if (logger.isDebugEnabled()) logger.debug("El stringPrimero tiene ["+stringPrimero+"] caracteres y el stringSegundo tiene ["+stringSegundo+"] caracteres");
		    					if (!stringPrimero.endsWith(" "))
		    					{
		    						if(logger.isDebugEnabled())logger.debug("El primer string no termina en espacio");
		    						char[] stringSegundoChar = stringSegundo.toCharArray();
		    						//Se recorre hasta encontrar un espacio en blanco y se cuenta los caracteres
		    						int contador = 0;
		    						boolean encontrado = false;
		    						for (int i = 0; encontrado && i < stringSegundoChar.length; i++)
		    						{
		    							if (stringSegundoChar[i] != ' ')		    							
		    								contador++;
		    							else
		    								encontrado = true;
		    						}
		    						//Se recalcula los string
		    						stringPrimero = cuerpo.trim().substring(0,numCaracteresPrimero+contador);
		    						stringSegundo = cuerpo.trim().substring(numCaracteresPrimero+contador, cuerpo.length()-1);
		    						if (logger.isDebugEnabled()) logger.debug("El stringPrimero final tiene ["+stringPrimero+"] caracteres y el stringSegundo final tiene ["+stringSegundo+"] caracteres");
		    						
		    						if(logger.isDebugEnabled())logger.debug("Pintamos la pagina con alineamiento abajo: stringPrimero ["+stringPrimero+"] y stringSegundo["+stringSegundo+"]");
//		    						Se pinta texto, la imagen y luego el texto
		    						out.println(stringPrimero);
				    				out.println("<a href=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" target=\"_blank\">");
				    					if (alineamiento.intValue() == 3)
				    						out.println("<img  src=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" alt=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" class=\"imagen_flotante_der\" width=\""+ancho+"\" height=\""+alto+"\"/>");
				    					else
				    						out.println("<img  src=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" alt=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" class=\"imagen_flotante_izq\" width=\""+ancho+"\" height=\""+alto+"\"/>");
				    				out.println("</a>");
				    				out.println(stringSegundo);		    						
		    					}    							    					
		    				}						    						    				
		    			}		    			
		    			else if (alineamiento.intValue() == 1)
		    			{
		    				//Alineamiento arriba-derecha
		    				if(logger.isDebugEnabled())logger.debug("Alineamiento arriba-derecha");
		    				//Se pinta la imagen y luego el texto
		    				out.println("<a href=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" target=\"_blank\">");
		    					out.println("<img  src=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" alt=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" class=\"imagen_flotante_der\" width=\""+ancho+"\" height=\""+alto+"\"/>");
		    				out.println("</a>");
		    				out.println(cuerpo);
		    				
		    			}
		    			else
		    			{
		    				//Alineamiento arriba-izquierda
		    				if(logger.isDebugEnabled())logger.debug("Alineamiento arriba-izquierda");
		    				//Se pinta la imagen y luego el texto
		    				out.println("<a href=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" target=\"_blank\">");
	    						out.println("<img  src=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" alt=\""+HTTP + LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio() + imagen+"\" class=\"imagen_flotante_izq\" width=\""+ancho+"\" height=\""+alto+"\"/>");
	    					out.println("</a>");
	    					out.println(cuerpo);
		    			}
		    		}
		    		else
		    		{
		    			if(logger.isDebugEnabled())logger.debug("No viene con imagen");
		    			out.println(cuerpo);
		    		}
		    		out.println("<br/><br/>");		    				    			
	    		
	    		} catch (IOException e) {	    			
	    			logger.error("Error pintando la imagen de la noticia",e);	    			
	    		}
	    		catch (Exception e) 
	    		 {
	    			 logger.error("Error pintando la imagen de la noticia",e);
	    		 }
	    		return SKIP_BODY;	
	    }
	    
	    /**
		 * doEndTag is called by the JSP container when the tag is closed
		 */
			public int doEndTag(){
				return SKIP_BODY; 
			}
			
			/**
		       * Forma la parte común de la url para poder visualizar el ODE.
		       * @param  String url: Url a codificar  
		       * @return String con la url
		       * @throws Exception
		       */
		    private String codificarURL (String url)
		    {

		      url=url.replaceAll("%", "%25");
		      url=url.replaceAll("\\$", "%26");
		      url=url.replaceAll(";", "%3B");
		      url=url.replaceAll("\\?", "%3F");
		      url=url.replaceAll("/", "%2F");
		      url=url.replaceAll(":", "%3A");
		      url=url.replaceAll("#", "%23");
		      url=url.replaceAll("&", "%24");
		      url=url.replaceAll("=", "%3D");
		      url=url.replaceAll("\\+", "%2B");
		      url=url.replaceAll(",", "%2C");
		      url=url.replaceAll(" ", "%20");
		      url=url.replaceAll("<", "%3C");
		      url=url.replaceAll(">", "%3E");
		      url=url.replaceAll("~", "%7E");
		      return url;

		    }  		    
		

}

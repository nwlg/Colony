/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.empaquetador.tag.elementos;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import es.pode.empaquetador.negocio.servicio.ArchivoVO;
import es.pode.empaquetador.negocio.servicio.FileVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class AsociarTag extends TagSupport {
	private final int COMPLETO=1;
	private final int PARCIAL=0;
	private final int VACIO=-1;
	
	private List seleccionados;
	private ArchivoVO archivo;
	
	private String urlArc;
	private String urlAso;
	private String keyAso;
	private String urlDes;
	private String keyDes;
	
	private static Logger logger = Logger.getLogger(AsociarTag.class);


	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	public int doEndTag() throws JspException {

		return SKIP_BODY;
	}

	private String encodeUrl(String url,String encoding) {
		String result;
		if(encoding!=null && url != null) {
			try {
			result = URLEncoder.encode(url, encoding);
			result = result.replaceAll(URLEncoder.encode("/", encoding), "/");
			result = result.replaceAll("\\+", "%20");
			} catch (Exception e) {
				logger.error("No se ha podido codificar la URL " + url,e);
				result = url;
			}
		} else result = url;
		if(logger.isDebugEnabled()) logger.debug("Url " + url + " codificada a " + result);
		return result;
	}
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException 
	{
		if(!archivo.getEsProtegido().booleanValue())
		{
			// Obtengo el locale de la session de struts
			Locale locale = (Locale)pageContext.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
			if(logger.isDebugEnabled()) logger.debug("Locale obtenido de la session = " + locale);
			ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
			StringBuffer sb= new StringBuffer();
			sb.append("<td valign=\"top\" class=\"td_larga\">");
			
			if(archivo.getEsFichero().booleanValue())
			{
				if(logger.isDebugEnabled()) logger.debug("el archivo es un fichero, muestro el icono de fichero y el href en la url");
				sb.append("<a href=\"")
				// Cambio en URLs para soportar host/agrega
				.append("http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+"/"+encodeUrl(archivo.getHref(),pageContext.getResponse().getCharacterEncoding()))
				.append("\" target=\"_blank\" class=\"recurso\">")
				.append(archivo.getNombre())
				.append("</a></td><td valign=\"top\" class=\"td_corta03\" align=\"center\"><span class=\"oculto\">-</span>");
				
				if(fileSeleccionado(archivo))
				{
					if(logger.isDebugEnabled()) logger.debug("el fichero esta asociado al recurso. muestro desasociar");
					sb.append("<a href=\"").append(urlDes).append("?nombre=").append(encodeUrl(archivo.getNombre(),pageContext.getResponse().getCharacterEncoding())).append("\">")
					.append(i18n.getString(keyDes))
					.append("</a></td>");
				}else{
					if(logger.isDebugEnabled()) logger.debug("el fichero NO esta asociado al recurso. muestro Asociar");
					sb.append("<a href=\"").append(urlAso).append("?nombre=").append(encodeUrl(archivo.getNombre(),pageContext.getResponse().getCharacterEncoding())).append("\">")
					.append(i18n.getString(keyAso))
					.append("</a></td>");
				}
			}else{
				if(logger.isDebugEnabled()) logger.debug("El Archivo es una Carpeta");
				int estadoCarpeta= carpetaSeleccionada(archivo);
				if(estadoCarpeta==VACIO)
				{
					if(logger.isDebugEnabled()) logger.debug("el ningun fichero de esta carpeta esta asociado al recurso actual");
					sb.append("<a href=\"")
					.append(urlArc).append("?href=").append(archivo.getHref())
					.append("\" class=\"carpeta_vacio\">")
					.append(archivo.getNombre())
					.append("</a></td><td valign=\"top\" class=\"td_corta03\" align=\"center\"><span class=\"oculto\">-</span>")
					.append("<a href=\"")
					.append(urlAso).append("?nombre=").append(encodeUrl(archivo.getNombre(),pageContext.getResponse().getCharacterEncoding()))
					.append("\">").append(i18n.getString(keyAso))
					.append("</a></td>");					
				}
				else if(estadoCarpeta==PARCIAL)
				{
					if(logger.isDebugEnabled()) logger.debug("algunos de los ficheros de esta carpeta, muestro el icono correspondiente y navegar en la url. muestro asociar ");
					sb.append("<a href=\"")
					.append(urlArc).append("?href=").append(archivo.getHref())
					.append("\" class=\"carpeta_parcial\">")
					.append(archivo.getNombre())
					.append("</a></td><td valign=\"top\" class=\"td_corta03\" align=\"center\"><span class=\"oculto\">-</span>")
					.append("<a href=\"")
					.append(urlAso).append("?nombre=").append(encodeUrl(archivo.getNombre(),pageContext.getResponse().getCharacterEncoding()))
					.append("\">").append(i18n.getString(keyAso)).append("</a></td>");					
				}else {
					if(logger.isDebugEnabled()) logger.debug("todos los ficheros estan asociado al recurso, muestrocarpeta completo y desasociar en la url");
					sb.append("<a href=\"")
					.append(urlArc).append("?href=").append(archivo.getHref())
					.append("\" class=\"carpeta_completa\">")
					.append(archivo.getNombre())
					.append("</a></td><td valign=\"top\" class=\"td_corta03\" align=\"center\"><span class=\"oculto\">-</span>")
					.append("<a href=\"")
					.append(urlDes).append("?nombre=").append(encodeUrl(archivo.getNombre(),pageContext.getResponse().getCharacterEncoding()))
					.append("\">").append(i18n.getString(keyDes)).append("</a></td>");
				}			

			}
			
			JspWriter out= pageContext.getOut();
			try {
				out.write(sb.toString());
			} catch (IOException e) {
				logger.error("Error dibujando AsociarTag",e);
				throw new JspException("Error dibujando AsociarTag",e);
				
			}
		}
		return super.SKIP_BODY;
	}

	private boolean fileSeleccionado(ArchivoVO archivo)
	{
		boolean existe=false;
		String nombre;
		if(archivo.getCarpetaPadre()!=null && !archivo.getCarpetaPadre().equals(""))
		{
			nombre= archivo.getCarpetaPadre().concat("/").concat(archivo.getNombre());
		}else
		{
			nombre= archivo.getNombre();
		}
		
		for(int i=0;i<seleccionados.size() && !existe;i++)
		{
			if(((FileVO)seleccionados.get(i)).getHref().equals(nombre))
			{
				existe=true;
			}
		}
		
		return existe;
	}
	
	private int carpetaSeleccionada(ArchivoVO carpeta)
	{
		int asociados=0;
		List listaArc= new ArrayList();
		if(carpeta.getContenidos()!=null && carpeta.getContenidos().length>0)
			listarFileVO(carpeta.getContenidos(), listaArc);
		
		for(int i=0;i<listaArc.size();i++)
		{
			if(fileSeleccionado((ArchivoVO)listaArc.get(i)))
			{
				asociados++;
			}
		}
		if(asociados==0)
		{
			return VACIO;
		}else if(asociados==listaArc.size())
			return COMPLETO;
		else
			return PARCIAL;
	}
	
	
	
	
    private void listarFileVO(ArchivoVO[] archivos,List files)
    {
    	
    	for(int i=0;i<archivos.length;i++)
    	{
    		if(archivos[i].getEsFichero().booleanValue())
    		{
            	files.add(archivos[i]);
    		}else
    		{
    			listarFileVO(archivos[i].getContenidos(), files);
    		}
    	}
    }

	
	

	public String getKeyAso() {
		return keyAso;
	}


	public void setKeyAso(String keyAso) {
		this.keyAso = keyAso;
	}


	public List getSeleccionados() {
		return seleccionados;
	}


	public void setSeleccionados(List seleccionados) {
		this.seleccionados = seleccionados;
	}


	public String getUrlArc() {
		return urlArc;
	}


	public void setUrlArc(String urlArc) {
		this.urlArc = urlArc;
	}


	public String getUrlAso() {
		return urlAso;
	}


	public void setUrlAso(String urlAso) {
		this.urlAso = urlAso;
	}


	/**
	 * @return the keyDes
	 */
	public String getKeyDes() {
		return keyDes;
	}


	/**
	 * @param keyDes the keyDes to set
	 */
	public void setKeyDes(String keyDes) {
		this.keyDes = keyDes;
	}


	/**
	 * @return the urlDes
	 */
	public String getUrlDes() {
		return urlDes;
	}


	/**
	 * @param urlDes the urlDes to set
	 */
	public void setUrlDes(String urlDes) {
		this.urlDes = urlDes;
	}


	/**
	 * @return the archivo
	 */
	public ArchivoVO getArchivo() {
		return archivo;
	}


	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(ArchivoVO archivo) {
		this.archivo = archivo;
	}
	
	
	
}

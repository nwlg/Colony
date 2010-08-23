/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/

package es.pode.presentacion.tags;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.DecisorOffline;
import es.agrega.soporte.tag.url.TransformarURL;
import es.pode.entregar.negocio.servicios.ItemVO;
import es.pode.entregar.negocio.servicios.OrganizacionVO;
import es.pode.entregar.negocio.servicios.RecursoVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;


public class VisualizarSinSecuenciaTag extends TagSupport{
	
	private OrganizacionVO[] organizaciones;

	private String localizacion;
	
	private String idSeleccionado;
	
	private String offline;
	
	private boolean abiertos;
	
	private String clase;
	
	private static Logger logger = Logger.getLogger(VisualizarSinSecuenciaTag.class);
	
	private final static String LOCALHOST = "localhost";
	private static final String PROTOCOLO_HTTP="http://";
	private static final String PROTOCOLO_HTTPS="https://";
	
	public int doEndTag() throws JspException {
		
		return SKIP_BODY;
	}

	
	public int doStartTag() throws JspException {
		
		
		 JspWriter out = pageContext.getOut();

	        ///////formateo nivel
	        int nivelInt=1;
	        String nivel="";
	        if(nivelInt<10)
	        	nivel= "0"+String.valueOf(nivelInt);
	        /////////////////////
	       
			String claseOrgAbierto="nivel"+nivel+"_organizacion_abierto";
			String claseOrgCerrado="nivel"+nivel+"_organizacion_cerrado";
			clase="abierto";
			nivelInt++;
			
			try {
			
		        out.write("<ul>\n");
		        Integer recursoId=new Integer(0);
		        String id="";
		        if(organizaciones!=null){
			        for(int j=0;j<organizaciones.length;j++){
			        	id=String.valueOf(recursoId);
			        	OrganizacionVO org =  organizaciones[j];
						String idOrg = org.getIdOrg();
						String tituloOrg = org.getTituloOrg();
						ItemVO[] items =  org.getItems();
					    out.write("<li id=\""+ idOrg +"_"+ nivel +"\" class=\""+ claseOrgAbierto +"\">\n");
					    out.write("<span onclick=\"abrirCerrar('"+ idOrg + "_" + nivel+"','"+ claseOrgAbierto+"','"+ claseOrgCerrado+"','li');return false\" onkeypress=\"abrirCerrar('"+ idOrg + "_" + nivel+"','"+ claseOrgAbierto+"','"+ claseOrgCerrado+"','li');return false\">&nbsp;</span>\n");
					    out.write("<a href=\"#\" id=\""+idOrg+"\">"+tituloOrg+"</a>\n");
					    //llamada a metodo recursivo que pinta los items 
					    //recorremos el array de items llamado a dicho metodo con cada items
//					    boolean todosCerrados =false;
//						if(items.length>4){
//							todosCerrados = true;
//					    }
					    out.write("<ul>\n");
						for(int i = 0;i<items.length;i++){
					    	int rId = recursoId.intValue();
							rId++;
							recursoId = new Integer(rId);
							recursoId= pintarItem(nivelInt,items[i],localizacion,out,recursoId,abiertos);
						}
					    out.write("</ul>\n");
					    out.write("</li>\n");
				    }
			        id=String.valueOf(recursoId);
			        out.write("</ul>\n");
		        }
			} catch (IOException e) {
				logger.error("Error dibujando VisualizarSinSecuenciaTag",e);
				throw new JspException("Error dibujando VisualizarSinSecuenciaTag",e);
			}
			
	        return SKIP_BODY;
	}
	
	
	private Integer pintarItem(int nivelInt,ItemVO item,String localizacion,Writer out,Integer recursoId,boolean abiertos) throws IOException{
		String encoding = super.pageContext.getResponse().getCharacterEncoding();

		String server = super.pageContext.getRequest().getServerName();
		if (server.equals(LOCALHOST) && DecisorOffline.esOffline())
			server = server + ":" + super.pageContext.getRequest().getServerPort();
		else
			server = server + LdapUserDetailsUtils.getSubdominio();

		
		String nivel="";
		if(nivelInt<10)
			nivel= "0"+String.valueOf(nivelInt);
		String claseOrgAbierto="nivel"+nivel+"_grupo_abierto";
		String claseOrgCerrado="nivel"+nivel+"_grupo_cerrado";
		ItemVO[] itemsHijos= item.getItemHijos();
		String idItem= item.getIdItem();
		RecursoVO recursoVO = item.getRecurso();
		String recurso="";
		if(item.getRecurso()!=null){
			recurso =item.getRecurso().getHrefRec();
		}
		if(idItem.equals(idSeleccionado)&& !abiertos){
			clase="cerrado";
		}
		String claseItem= "nivel"+nivel+"_grupo_"+clase;
		
		String titulo= item.getTitulo();
		//out.write("<ul>\n");
		if(itemsHijos!=null && itemsHijos.length>0){
			if(item.getVisible()==null || item.getVisible()){
				if(recursoVO!=null  &&  recurso!=null){
					if(recurso.toLowerCase().startsWith(PROTOCOLO_HTTP) || recurso.toLowerCase().startsWith(PROTOCOLO_HTTPS)){
						out.write("<li id=\""+idItem+"_"+nivel+"\" class=\""+claseItem+"\">\n");
						out.write("<span  onclick=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\" onkeypress=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\">&nbsp;</span>\n");
						String href = TransformarURL.transformaUrl(encoding, recurso);
//						out.write("<a href=\"#\" onclick=\"javascript:mostrarItem('"+href+"','" + tipoDocumento(href) + "','"+idItem+"');\" id=\""+idItem+"\" target=\"\" >"+titulo+"</a>\n");
						out.write("<a href=\"#\" onclick=\"javascript:mostrarItem('"+href+"','"+idItem+"','"+offline+"');\" id=\""+idItem+"\" target=\"\" >"+titulo+"</a>\n");
//						out.write("<a href=\""+href+"\" onclick=\"cambiar('"+idItem+"');\" id=\""+idItem+"\" target=\"contenido_principal\">"+titulo+"</a>\n");
					}
					else{
						out.write("<li id=\""+idItem+"_"+nivel+"\" class=\""+claseItem+"\">\n");
						out.write("<span  onclick=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\" onkeypress=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\">&nbsp;</span>\n");
						String href = PROTOCOLO_HTTP + server +"/"+localizacion+"/"+recurso;
						href = TransformarURL.transformaUrl(encoding, href);
						out.write("<a href=\"#\" onclick=\"javascript:mostrarItem('"+href+"','"+idItem+"','"+offline+"');\" id=\""+idItem+"\" target=\"\">"+titulo+"</a>\n");
//						out.write("<a href=\"#\" onclick=\"javascript:mostrarItem('"+href+"','" + tipoDocumento(href) + "','"+idItem+"');\" id=\""+idItem+"\" target=\"\">"+titulo+"</a>\n");
//						out.write("<a href=\""+href+"\" onclick=\"cambiar('"+idItem+"');\" id=\""+idItem+"\" target=\"contenido_principal\">"+titulo+"</a>\n");
	
					}
				}
				else{
					out.write("<li id=\""+idItem+"_"+nivel+"\" class=\""+claseItem+"\">\n");
					out.write("<span  onclick=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\" onkeypress=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\">&nbsp;</span>\n");	
					//out.write("<a href=\"#\" onclick=\"cambiar('"+idItem+"');\" id=\""+idItem+"\">"+titulo+"</a>\n");
					out.write("<a href=\"#\" onclick=\"javascript:mostrarItem('','"+idItem+"','"+offline+"');\" id=\""+idItem+"\" target=\"\">"+titulo+"</a>\n");
				}

			}
			if(item.getVisible()==null || item.getVisible()){
				nivelInt++;
				//pintamos los itemsHijos
				out.write("<ul>\n");
				for(int i=0;i<itemsHijos.length;i++){
					int rId = recursoId.intValue();
					rId++;
					recursoId = new Integer(rId);
					recursoId = pintarItem(nivelInt,itemsHijos[i],localizacion,out,recursoId,abiertos);					
				}
				out.write("</ul>\n");
			}
			out.write("</li>\n");	
		}
		else{//itemsHijos==null
			if(item.getVisible()==null || item.getVisible()){
				if(recursoVO!=null  &&  recurso!=null){

					if(recurso.toLowerCase().startsWith(PROTOCOLO_HTTP) || recurso.toLowerCase().startsWith(PROTOCOLO_HTTPS)){
						out.write("<li class=\"item\">\n");
						out.write("<span>&nbsp;\n");
						String href = TransformarURL.transformaUrl(encoding, recurso);
//						out.write("<a href=\"#\" onclick=\"javascript:mostrarItem('"+href+"','" + tipoDocumento(href) + "','"+idItem+"');\" id=\""+idItem+"\" target=\"\">"+titulo+"</a>\n");
						out.write("<a href=\"#\" onclick=\"javascript:mostrarItem('"+href+"','"+idItem+"','"+offline+"');\" id=\""+idItem+"\" target=\"\">"+titulo+"</a>\n");
						out.write("</span>\n");
						out.write("</li>\n");
					}
					else{
						out.write("<li class=\"item\">\n");
						out.write("<span>&nbsp;\n");
						String href = PROTOCOLO_HTTP + server +"/"+localizacion+"/"+recurso;
						href = TransformarURL.transformaUrl(encoding, href);
//						out.write("<a href=\"#\" onclick=\"javascript:mostrarItem('"+href+"','" + tipoDocumento(href) + "','"+idItem+"');\" id=\""+idItem+"\" target=\"\">"+titulo+"</a>\n");
						out.write("<a href=\"#\" onclick=\"javascript:mostrarItem('"+href+"','"+idItem+"','"+offline+"');\" id=\""+idItem+"\" target=\"\">"+titulo+"</a>\n");
						out.write("</span>\n");
						out.write("</li>\n");
					}
				}
				else{
					out.write("<li id=\""+idItem+"_"+nivel+"\" class=\"item\">\n");
					out.write("<span>&nbsp;\n");
					//out.write("<a href=\"#\" onclick=\"cambiar('"+idItem+"');\" id=\""+idItem+"\">"+titulo+"</a>\n");
					out.write("<a href=\"#\" onclick=\"javascript:mostrarItem('','"+idItem+"','"+offline+"');\" id=\""+idItem+"\" target=\"\">"+titulo+"</a>\n");
					out.write("</span>\n");
					out.write("</li>\n");
				}
			}
		}
		//out.write("</ul>\n");
		return recursoId;			
	}
	
	
	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}


	public OrganizacionVO[] getOrganizaciones() {
		return organizaciones;
	}

	public void setOrganizaciones(OrganizacionVO[] organizaciones) {
		this.organizaciones = organizaciones;
	}


	public String getIdSeleccionado() {
		return idSeleccionado;
	}


	public void setIdSeleccionado(String idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}


	public String getOffline() {
		return offline;
	}


	public void setOffline(String offline) {
		this.offline = offline;
	}


	public boolean getAbiertos() {
		return abiertos;
	}


	public void setAbiertos(boolean abiertos) {
		this.abiertos = abiertos;
	}
	
}
/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.presentacion.tags;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;



import org.apache.log4j.Logger;

import es.pode.entregar.negocio.servicios.ItemVO;
import es.pode.entregar.negocio.servicios.OrganizacionVO;
import es.pode.entregar.negocio.servicios.RecursoVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;

public class VisualizarConSecuenciaTag extends TagSupport {

	private OrganizacionVO[] organizaciones;

	private String localizacion;
	
	private String idSeleccionado;
	
	private String identificador;
	
	private String usuario;
	
	private boolean abiertos;
	
	private ArrayList rutaSeleccionado;
	
	private String clase;
	
	private static Logger logger = Logger.getLogger(VisualizarConSecuenciaTag.class);
	
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
				    out.write("<span  onclick=\"abrirCerrar('"+idOrg + "_" + nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\" onkeypress=\"abrirCerrar('"+idOrg + "_" + nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\">&nbsp;</span>\n");
				    if(idOrg.equals(idSeleccionado))
				    	out.write("<a href=\"javascript:clickItem('"+idOrg+",'"+ identificador+"','"+usuario+"');\" class=\"escogido\">"+tituloOrg+"</a>");
				    else
				    	out.write("<a href=\"javascript:clickItem('"+idOrg+",'"+ identificador+"','"+usuario+"');\">"+tituloOrg+"</a>");
				    //llamada a metodo recursivo que pinta los items 
				    //recorremos el array de items llamado a dicho metodo con cada items
//				    boolean todosCerrados =false;
//					if(items.length>4){
//						todosCerrados = true;
//				    }
				    out.write("<ul>\n");
				    for(int i = 0;i<items.length;i++){
						int rId = recursoId.intValue();
						rId++;
						recursoId = new Integer(rId);
						clase = "cerrado";
						
			    		recursoId= pintarItem(nivelInt,items[i],localizacion,out,recursoId,abiertos);
			    		
			    		
	
				    }
				    out.write("</ul>\n");
				    out.write("</li>\n");				    
			    }
	
		        out.write("</ul>\n");
	        }
			} catch (IOException e) {
				logger.error("Error dibujando VisualizarConSecuenciaTag",e);
				throw new JspException("Error dibujando VisualizarConSecuenciaTag",e);
			}
			
	        return SKIP_BODY;
	}
	
	private Integer pintarItem(int nivelInt,ItemVO item,String localizacion,Writer out,Integer recursoId,boolean abiertos) throws IOException{
		ResourceBundle datosResources = I18n.getInstance().getResource("application-resources", (Locale) pageContext.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
				
		String nivel="";
        if(nivelInt<10)
        	nivel= "0"+String.valueOf(nivelInt);
		String claseOrgAbierto="nivel"+nivel+"_grupo_abierto";
		String claseOrgCerrado="nivel"+nivel+"_grupo_cerrado";
		ItemVO[] itemsHijos= item.getItemHijos();
		String idItem="";
		if(item.getIdItem()!=null)
			idItem= item.getIdItem();

		if((rutaSeleccionado!=null && rutaSeleccionado.contains(idItem)) || abiertos){
//		if(idItem.equals(idSeleccionado) && todosCerrados){
			clase="abierto";
		}
		else{
			clase="cerrado";
		}
		String claseItem= "nivel"+nivel+"_grupo_"+clase;
		String tituloItem=item.getTitulo();
		RecursoVO recursoVO = item.getRecurso();
		String recurso="";
		if(item.getRecurso()!=null){
			recurso =item.getRecurso().getHrefRec();
		}
		
		//out.write("<ul>\n");
		if(itemsHijos!=null && itemsHijos.length>0){
			if(recursoVO!=null){
			    if(item.getVisible()==null || item.getVisible()){
					if(item.getClicable()){
						if(idItem.equals(idSeleccionado)){
							out.write("<li id=\""+idItem+"_"+nivel+"\" class=\""+claseItem+"\">\n");	
							out.write("<span  onclick=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\" onkeypress=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\">&nbsp;</span>\n");
							out.write("<a href=\"javascript:clickItem('"+idItem+"', '"+ identificador+"','"+usuario+"');\" class=\"escogido\">"+tituloItem+"</a>");
						}
						else{
							out.write("<li id=\""+idItem+"_"+nivel+"\" class=\""+claseItem+"\">\n");	
							out.write("<span  onclick=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\" onkeypress=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\">&nbsp;</span>\n");
							out.write("<a href=\"javascript:clickItem('"+idItem+"','"+ identificador+"','"+usuario+"');\" >"+tituloItem+"</a>");
						}
					}
					else{
						if(idItem.equals(idSeleccionado)){
							out.write("<li id=\""+idItem+"_"+nivel+"\" class=\""+claseItem+"\">\n");	
							out.write("<span  onclick=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\" onkeypress=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\">&nbsp;</span>\n");
							out.write("<a href=\"#\" class=\"seleccionado\">"+tituloItem+"</a>");
							}
						else{
							out.write("<li id=\""+idItem+"_"+nivel+"\" class=\""+claseItem+"\">\n");	
							out.write("<span  onclick=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\" onkeypress=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\">&nbsp;</span>\n");
							out.write("<a href=\"#\" >"+tituloItem+"</a>");
						}
					}
				}
			}
			else{
			    if(item.getVisible()==null || item.getVisible()){
					if(item.getClicable()){
						if(idItem.equals(idSeleccionado)){
							out.write("<li id=\""+idItem+"_"+nivel+"\" class=\""+claseItem+"\">\n");	
							out.write("<span  onclick=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\" onkeypress=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\">&nbsp;</span>\n");
							out.write("<a href=\"javascript:clickItem('"+idItem+"', '"+ identificador+"', '"+usuario+"');\" class=\"escogido\">"+tituloItem+"</a>");
						}
						else{
							out.write("<li id=\""+idItem+"_"+nivel+"\" class=\""+claseItem+"\">\n");	
							out.write("<span  onclick=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\" onkeypress=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\">&nbsp;</span>\n");
							out.write("<a href=\"javascript:clickItem('"+idItem+"', '"+ identificador+"', '"+usuario+"');\" >"+tituloItem+"</a>");
						}
					}
					else{
						if(idItem.equals(idSeleccionado)){
							out.write("<li id=\""+idItem+"_"+nivel+"\" class=\""+claseItem+"\">\n");	
							out.write("<span  onclick=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\" onkeypress=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\">&nbsp;</span>\n");		
							out.write("<a href=\"#\" class=\"seleccionado\">"+tituloItem+"</a>");
						}
						else{
							out.write("<li id=\""+idItem+"_"+nivel+"\" class=\""+claseItem+"\">\n");	
							out.write("<span  onclick=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\" onkeypress=\"abrirCerrar('"+idItem+"_"+nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"');return false\">&nbsp;</span>\n");
							out.write("<a href=\"#\" >"+tituloItem+"</a>");
						}
					}
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
				if(recurso!=null){
					if(item.getVisible()==null || item.getVisible()){
						if(item.getClicable()){
							if(idItem.equals(idSeleccionado)){
								out.write("<li class=\"item\">\n");
								out.write("<span>&nbsp;\n");
								out.write("<a href=\"javascript:clickItem('"+idItem+"', '"+ identificador+"', '"+usuario+"');\" class=\"escogido\">"+tituloItem+"</a>");
								out.write("</span>\n");
								out.write("</li>\n");
							}
							else{
								out.write("<li class=\"item\">\n");
								out.write("<span>&nbsp;\n");
								out.write("<a href=\"javascript:clickItem('"+idItem+"', '"+ identificador+"', '"+usuario+"');\" >"+tituloItem+"</a>");
								out.write("</span>\n");
								out.write("</li>\n");
							}
						}
						else{
							if(idItem.equals(idSeleccionado)){
								out.write("<li class=\"item\">\n");
								out.write("<span>&nbsp;\n");
								out.write("<a href=\"#\" class=\"seleccionado\">"+tituloItem+"</a>");
								out.write("</span>\n");
								out.write("</li>\n");
							}
							else{
								out.write("<li class=\"item\">\n");
								out.write("<span>&nbsp;\n");
								out.write("<a href=\"#\" >"+tituloItem+"</a>");
								out.write("</span>\n");
								out.write("</li>\n");
							}
						}
					}
				}
				else{
					if(item.getVisible()==null || item.getVisible()){
						if(item.getClicable()){
							if(idItem.equals(idSeleccionado)){
								
								out.write("<li id=\""+idItem+"_"+nivel+"\" class=\"item\">\n");
								out.write("<span>&nbsp;\n");
								out.write("<a href=\"javascript:clickItem('"+idItem+"', '"+ identificador+"', '"+usuario+"');\" class=\"escogido\">"+tituloItem+"</a>");
								out.write("</span>\n");
								out.write("</li>\n");
							}
							else{
								out.write("<li id=\""+idItem+"_"+nivel+"\" class=\"item\">\n");
								out.write("<span>&nbsp;\n");
								out.write("<a href=\"javascript:clickItem('"+idItem+"', '"+ identificador+"', '"+usuario+"');\" >"+tituloItem+"</a>");
								out.write("</span>\n");
								out.write("</li>\n");
							}
						}
						else{
							if(idItem.equals(idSeleccionado)){
								out.write("<li id=\""+idItem+"_"+nivel+"\" class=\"item\">\n");
								out.write("<span>&nbsp;\n");
								out.write("<a href=\"#\" class=\"seleccionado\">"+tituloItem+"</a>");
								out.write("</span>\n");
								out.write("</li>\n");
							}
							else{
								out.write("<li id=\""+idItem+"_"+nivel+"\" class=\"item\">\n");
								out.write("<span>&nbsp;\n");
								out.write("<a href=\"#\" >"+tituloItem+"</a>");
								out.write("</span>\n");
								out.write("</li>\n");
							}
						}
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

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getIdSeleccionado() {
		return idSeleccionado;
	}

	public void setIdSeleccionado(String idSeleccionado) {
		this.idSeleccionado = idSeleccionado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public boolean isAbiertos() {
		return abiertos;
	}

	public void setAbiertos(boolean abiertos) {
		this.abiertos = abiertos;
	}

	public ArrayList getRutaSeleccionado() {
		return rutaSeleccionado;
	}

	public void setRutaSeleccionado(ArrayList rutaSeleccionado) {
		this.rutaSeleccionado = rutaSeleccionado;
	}
		
}

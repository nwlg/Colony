/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.entregar.negocio.utils.menuTemplate;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.SimpleHash;
import freemarker.template.SimpleScalar;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;

public class MenuDirective implements TemplateDirectiveModel{
    
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {

        TemplateHashModel dataModel= env.getDataModel();

        Writer out = env.getOut();
        ///////formateo nivel
        int nivelInt=1;
        String nivel="";
        if(nivelInt<10)
        	nivel= "0"+String.valueOf(nivelInt);
        /////////////////////
        SimpleSequence organizaciones = (SimpleSequence) dataModel.get("organizaciones");
		String claseOrgAbierto="nivel"+nivel+"_organizacion_abierto";
		String claseOrgCerrado="nivel"+nivel+"_organizacion_cerrado";
		nivelInt++;
        out.write("<ul>\n");
        Integer recursoId=new Integer(0);
        String id="";
        for(int j=0;j<organizaciones.size();j++){
        	id=String.valueOf(recursoId);
        	TemplateHashModel org = (TemplateHashModel) organizaciones.get(j);
			String idOrg = ((SimpleScalar) org.get("idOrg")).getAsString();
			String tituloOrg = ((SimpleScalar) org.get("tituloOrg")).getAsString();
			String localizacion = ((SimpleScalar) org.get("localizacion")).getAsString();
			SimpleSequence items = (SimpleSequence) org.get("itemsOrg");
		    out.write("<li id=\""+ idOrg +"_"+ nivel +"\" class=\""+ claseOrgAbierto +"\">\n");
		    out.write("<span onclick=\"P7_swapClass(1,'"+ idOrg + "_" + nivel+"','"+ claseOrgAbierto+"','"+ claseOrgCerrado+"','li');return false\" onkeypress=\"P7_swapClass(1,'"+ idOrg+"_"+ nivel+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"','li');return false\">&nbsp;</span>\n");
		    out.write("<a href=\"#\" onclick=\"cambiar("+id+");\" id=\""+id+"\">"+tituloOrg+"</a>\n");
		    //llamada a metodo recursivo que pinta los items 
		    //recorremos el array de items llamado a dicho metodo con cada items
		    for(int i = 0;i<items.size();i++){
				int rId = recursoId.intValue();
				rId++;
				recursoId = new Integer(rId);
		    	recursoId= pintarItem(nivelInt,(SimpleHash) items.get(i),localizacion,out,recursoId);	
		    }
		    out.write("</li>\n");
	    }
        id=String.valueOf(recursoId);
        out.write("</ul>\n");
        out.write("<form name=\"f1\">\n");
        out.write("<input type=\"hidden\" id=\"maximo\" name=\"maximo\" value=\""+id+"\"/>\n");
        out.write("<input type=\"hidden\" id=\"variable\" name=\"variable\" value=\"0\"/>\n");
        out.write("</form>");
	    if (body != null) {
	    	body.render(env.getOut());
        }
	}
	
	private Integer pintarItem(int nivelInt,SimpleHash item,String localizacion,Writer out,Integer recursoId) throws TemplateException, IOException{
        String nivel="";
        if(nivelInt<10)
        	nivel= "0"+String.valueOf(nivelInt);
		String claseOrgAbierto="nivel"+nivel+"_grupo_abierto";
		String claseOrgCerrado="nivel"+nivel+"_grupo_cerrado";
		SimpleSequence itemsHijos=(SimpleSequence) item.get("itemsHijos");
		String idItem=((SimpleScalar) item.get("idItem")).getAsString();
		SimpleScalar ssRecurso = (SimpleScalar) item.get("recurso");
		String id=String.valueOf(recursoId);
		
		String recurso="";
		
		if (ssRecurso !=null)
			recurso= ssRecurso.getAsString();
		String titulo= ((SimpleScalar) item.get("titulo")).getAsString();
		out.write("<ul>\n");
		if(itemsHijos!=null){
			out.write("<li id=\""+idItem+"\" class=\""+claseOrgAbierto+"\">\n");
			if(ssRecurso!=null){
				out.write("<span  onclick=\"P7_swapClass(1,'"+idItem+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"','li');return false\" onkeypress=\"P7_swapClass(1,'"+idItem+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"','li');return false\">&nbsp;</span>\n");
				if(recurso.startsWith("http://")){
					out.write("<a href=\""+recurso+"\" onclick=\"cambiar("+id+");\" id=\""+id+"\" target=\"contenido_principal\">"+titulo+"</a>\n");
				}
				else{
					out.write("<a href=\""+localizacion+"/"+recurso+"\" onclick=\"cambiar("+id+");\" id=\""+id+"\" target=\"contenido_principal\">"+titulo+"</a>\n");
				}
			}
			else{
				out.write("<span  onclick=\"P7_swapClass(1,'"+idItem+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"','li');return false\" onkeypress=\"P7_swapClass(1,'"+idItem+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"','li');return false\">&nbsp;</span>\n");
				out.write("<a href=\"#\" onclick=\"cambiar("+id+");\" id=\""+id+"\">"+titulo+"</a>\n");
			}
			nivelInt++;
			//pintamos los itemsHijos
			for(int i=0;i<itemsHijos.size();i++){
				int rId = recursoId.intValue();
				rId++;
				recursoId = new Integer(rId);
				recursoId = pintarItem(nivelInt,(SimpleHash) itemsHijos.get(i),localizacion,out,recursoId);
			}			
			out.write("</li>\n");	
		}
		else{//itemsHijos==null
			if(ssRecurso!=null){
				out.write("<li class=\"item\">\n");
				out.write("<span>&nbsp;\n");
				if(recurso.startsWith("http://")){
					out.write("<a href=\""+recurso+"\" onclick=\"cambiar("+id+");\" id=\""+id+"\" target=\"contenido_principal\">"+titulo+"</a>\n");
				}
				else{
					out.write("<a href=\""+localizacion+"/"+recurso+"\" onclick=\"cambiar("+id+");\" id=\""+id+"\" target=\"contenido_principal\">"+titulo+"</a>\n");
				}
				out.write("</span>\n");
				out.write("</li>\n");
			}
			else{
				out.write("<li id=\""+idItem+"\" class=\""+claseOrgAbierto+"\">\n");
				out.write("<span  onclick=\"P7_swapClass(1,'"+idItem+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"','li');return false\" onkeypress=\"P7_swapClass(1,'"+idItem+"','"+claseOrgAbierto+"','"+claseOrgCerrado+"','li');return false\">&nbsp;</span>\n");
				out.write("<a href=\"#\" onclick=\"cambiar("+id+");\" id=\""+id+"\">"+titulo+"</a>\n");
				out.write("</li>\n");
			}
		}
		out.write("</ul>\n");
		return recursoId;			
	}
	
}

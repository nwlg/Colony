/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML.lomes.lomesAgrega;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import es.pode.parseadorXML.castor.Annotation;
import es.pode.parseadorXML.castor.ComplexTypeDateTimeDateTime;
import es.pode.parseadorXML.castor.ComplexTypeDateTimeDescription;
import es.pode.parseadorXML.castor.Date;
import es.pode.parseadorXML.castor.Description;
import es.pode.parseadorXML.castor.Entity;
import es.pode.parseadorXML.castor.GroupAnnotationAnnotation;
import es.pode.parseadorXML.castor.GroupDateDate;
import es.pode.parseadorXML.castor.GroupDescriptionDescription;
import es.pode.parseadorXML.castor.GroupEntityEntity;
import es.pode.parseadorXML.castor.LanguageStringItem;

public class AnnotationAgrega {

private Annotation annotation = null;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public AnnotationAgrega(Annotation annotation) {
		super();
		
		if (annotation.getGroupAnnotationAnnotation()== null){
			GroupAnnotationAnnotation gra= new GroupAnnotationAnnotation();
			annotation.setGroupAnnotationAnnotation(gra);
		}
		
		setAnnotation(annotation);
   
	}

	public Annotation getAnnotation() {
		return annotation;
	}

	public void setAnnotation(Annotation annotation) {
		this.annotation = annotation;
	}
	
	
	 /*****************************Métodos para Catalogador Avanzado********************************/
	
	public String getEntidadAv(){
		String entidades=null;
		try{
			Entity enti = annotation.getGroupAnnotationAnnotation().getEntity();
			if(enti!=null)
				entidades=enti.getGroupEntityEntity().getContent();
			
		}catch (Exception e){
			   String mensaje = "Warning: No es posible recoger la lista de entidades de la categoría Anotación";
			   logger.warn(mensaje);
			   
			   return entidades;
			   //throw e;
		   }
		return entidades;
	}
	
	public void setEntidadAv(String sEntidad){
		if (sEntidad!= null){
			GroupEntityEntity gee = new GroupEntityEntity();
			gee.setContent(sEntidad);
			Entity entidad = new Entity();
			entidad.setGroupEntityEntity(gee);
			annotation.getGroupAnnotationAnnotation().setEntity(entidad);
		}
	}
	
	public FechaAgrega getFechaAv(){
		FechaAgrega tiempo=new FechaAgrega();
		try{
			ArrayList lDesc=new ArrayList();
			Date date = annotation.getGroupAnnotationAnnotation().getDate();
			if(date!=null){
				if(date.getGroupDateDate().getComplexTypeDateTimeDateTime()!=null)
					tiempo.setFecha(annotation.getGroupAnnotationAnnotation().getDate().getGroupDateDate().getComplexTypeDateTimeDateTime().getContent());
				
				LanguageStringItem[] lsi=null;
				if(date.getGroupDateDate().getComplexTypeDateTimeDescription()!=null)
					lsi = annotation.getGroupAnnotationAnnotation().getDate().getGroupDateDate().getComplexTypeDateTimeDescription().getLanguageStringItem();
				
				if((lsi!=null)&&(lsi.length>0)){
					for(int i=0;i<lsi.length;i++){
						LangStringAgrega lLang=new LangStringAgrega();
						lLang.setValor(lsi[i].getString().getContent());
						lLang.setIdioma(lsi[i].getString().getLanguage());
						lDesc.add(lLang);
					}
					tiempo.setDescripciones(lDesc);
				}
			}
		}catch (Exception e){
			   String mensaje = "Warning: No es posible recoger la lista de entidades de la categoría Anotación";
			   logger.warn(mensaje);
			   tiempo=new FechaAgrega();
			   return tiempo;
			   //throw e;
		   }
		return tiempo;
	}
	
	public void setFechaAv(FechaAgrega fecha){
		Date date = null;
		if (fecha != null){
			ArrayList lDescripciones = fecha.getDescripciones();
			String sFecha = fecha.getFecha();
			
			ComplexTypeDateTimeDateTime ctdtdt = null;
			if(sFecha != null){
				ctdtdt = new ComplexTypeDateTimeDateTime();
				ctdtdt.setContent(sFecha);
			}
			
			
			ComplexTypeDateTimeDescription ctdtd = null;
			ArrayList lDesc = new ArrayList();		
			if (lDescripciones != null){	
				for (int i = 0; i < lDescripciones.size(); i++){   
				   LangStringAgrega lsa = (LangStringAgrega) lDescripciones.get(i);
				   String valor = lsa.getValor();
				   String idioma = lsa.getIdioma();
				   
				   es.pode.parseadorXML.castor.String s = new es.pode.parseadorXML.castor.String();
				   s.setContent(valor);
				   s.setLanguage(idioma);
				   
				   LanguageStringItem lsi= new LanguageStringItem();
				   lsi.setString(s);
				   lDesc.add(lsi);
			   }
			   ctdtd = new ComplexTypeDateTimeDescription();
			   ctdtd.setLanguageStringItem((LanguageStringItem[])lDesc.toArray(new LanguageStringItem[lDesc.size()]));
			   
			}
			if(sFecha != null && lDescripciones != null){
				GroupDateDate gdd = new GroupDateDate();
				gdd.setComplexTypeDateTimeDateTime(ctdtdt);
				gdd.setComplexTypeDateTimeDescription(ctdtd);
				
				date = new Date();
				date.setGroupDateDate(gdd);
			}
		}
		annotation.getGroupAnnotationAnnotation().setDate(date);
	}
	
	public ArrayList getDescripcionAv(){
		ArrayList lDescr=new ArrayList();
		try{
			LanguageStringItem[] lsi = annotation.getGroupAnnotationAnnotation().getDescription().getGroupDescriptionDescription().getLanguageStringItem();
			
			if((lsi!=null)&&(lsi.length>0)){
				for(int i=0;i<lsi.length;i++){
					LangStringAgrega lDes=new LangStringAgrega();
					lDes.setValor(lsi[i].getString().getContent());
					lDes.setIdioma(lsi[i].getString().getLanguage());
					lDescr.add(lDes);
				}
			}
		}catch (Exception e){
			   String mensaje = "Warning: No es posible recoger la lista de descripciones de la categoría Anotación";
			   logger.warn(mensaje);
			   lDescr=new ArrayList();
			   return lDescr;
			   //throw e;
		   }
		return lDescr;
	}
	
	public void setDescripcionAv(ArrayList lDescripciones){
		if (lDescripciones != null && lDescripciones.size()>0){
			ArrayList lDesc = new ArrayList();
					
			for (int i = 0; i < lDescripciones.size(); i++){   
			   LangStringAgrega lsa = (LangStringAgrega) lDescripciones.get(i);
			   String valor = lsa.getValor();
			   String idioma = lsa.getIdioma();
			   
			   es.pode.parseadorXML.castor.String s = new es.pode.parseadorXML.castor.String();
			   s.setContent(valor);
			   s.setLanguage(idioma);
			   
			   LanguageStringItem lsi= new LanguageStringItem();
			   lsi.setString(s);
			   lDesc.add(lsi);
		   }
		   GroupDescriptionDescription gdd = new GroupDescriptionDescription();
		   gdd.setLanguageStringItem((LanguageStringItem[])lDesc.toArray(new LanguageStringItem[lDesc.size()]));
		   Description descripcion = new Description();
		   descripcion.setGroupDescriptionDescription(gdd);
		   annotation.getGroupAnnotationAnnotation().setDescription(descripcion);
	   }
	}
}

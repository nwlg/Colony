/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML.lomes.lomesAgrega;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.parseadorXML.castor.Catalog;
import es.pode.parseadorXML.castor.ComplexTypeKindVocabSource;
import es.pode.parseadorXML.castor.ComplexTypeKindVocabValue;
import es.pode.parseadorXML.castor.DescriptionUnbounded;
import es.pode.parseadorXML.castor.Entry;
import es.pode.parseadorXML.castor.GroupCatalogCatalog;
import es.pode.parseadorXML.castor.GroupDescriptionUnboundedDescription;
import es.pode.parseadorXML.castor.GroupEntryEntry;
import es.pode.parseadorXML.castor.GroupIdentifierIdentifier;
import es.pode.parseadorXML.castor.GroupKindKind;
import es.pode.parseadorXML.castor.GroupRelationRelation;
import es.pode.parseadorXML.castor.GroupResourceResource;
import es.pode.parseadorXML.castor.Identifier;
import es.pode.parseadorXML.castor.Kind;
import es.pode.parseadorXML.castor.LanguageStringItem;
import es.pode.parseadorXML.castor.Relation;
import es.pode.parseadorXML.castor.ResourceLomes;

public class RelationAgrega {
	
private Relation relation = null;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public RelationAgrega(Relation relation) {
		super();
		
		if (relation.getGroupRelationRelation()== null){
			GroupRelationRelation grr= new GroupRelationRelation();
			relation.setGroupRelationRelation(grr);
		}
		
		setRelation(relation); 

        
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}
	
	
	 /*****************************Métodos para Catalogador Avanzado********************************/
	
	public String getTipoAv(){
		String tipo=null;
		try{
			Kind kind = relation.getGroupRelationRelation().getKind();
			if(kind!=null)
				if(kind.getGroupKindKind().getComplexTypeKindVocabValue()!=null)
					tipo=kind.getGroupKindKind().getComplexTypeKindVocabValue().getContent();
				else 
					tipo = "";
			   
		   } catch (Exception e){
			   String mensaje = "Warning: No es posible recoger el tipo de la categoría Relación";
			   logger.warn(mensaje);
			   
			   return tipo;
			   //throw e;
		   }
		return tipo;
		
	}
	
	public RecursoAgrega getRecursoAv(){
		RecursoAgrega recurso=new RecursoAgrega();
		IdentificadorAgrega identificador=new IdentificadorAgrega();
		ArrayList lRecurso=new ArrayList();
		
		 try{
			 if(relation.getGroupRelationRelation().getResource()!=null){
				 DescriptionUnbounded[] descRecurso = relation.getGroupRelationRelation().getResource().getGroupResourceResource().getDescriptionUnbounded();
				 if(relation.getGroupRelationRelation().getResource().getGroupResourceResource().getIdentifier()!=null){
					 identificador.setCatalogo(relation.getGroupRelationRelation().getResource().getGroupResourceResource().getIdentifier().getGroupIdentifierIdentifier().getCatalog().getGroupCatalogCatalog().getContent());
					 identificador.setEntrada(relation.getGroupRelationRelation().getResource().getGroupResourceResource().getIdentifier().getGroupIdentifierIdentifier().getEntry().getGroupEntryEntry().getContent());
				 }
			  
				 if ((descRecurso!= null)&&(descRecurso.length>0)){
					 for (int i= 0; i<descRecurso.length; i++){
					  
						 LanguageStringItem[] lsi = descRecurso[i].getGroupDescriptionUnboundedDescription().getLanguageStringItem();
						 if((lsi!=null)&&(lsi.length>0)){
							 for (int j= 0; j<lsi.length; j++){
								 LangStringAgrega ldesc=new LangStringAgrega();
								 ldesc.setIdioma(lsi[j].getString().getLanguage());
								 ldesc.setValor(lsi[j].getString().getContent());
								 lRecurso.add(ldesc);
							 }
						 }
					 }
				 }
				 recurso.setIdentificador(identificador);
				 recurso.setDescripciones(lRecurso);
			 }   
		   } catch (Exception e){
			   String mensaje = "Warning: No es posible recoger los recurso de la categoría Relation";
			   logger.warn(mensaje);
			   
			   recurso= new RecursoAgrega();
			   return recurso;
			   //throw e;
		   }
		return recurso;
	}
	/****************Métodos SET para el Avanzado***************/
	
	public void setTipoAv(String tipo) throws Exception{
		try{
			
			
 		    String tipoProp = null;

 		    tipoProp = AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
 		    
 		    Kind kind=null;
 		    if(tipo!=null){
 		    	kind=new Kind();
 		    	GroupKindKind gkk=new GroupKindKind();
 		    	ComplexTypeKindVocabSource ctkvs=new ComplexTypeKindVocabSource();
 		    	ctkvs.setContent(tipoProp);
 		    	gkk.setComplexTypeKindVocabSource(ctkvs);
 		    	ComplexTypeKindVocabValue ctvv=new ComplexTypeKindVocabValue();
 		    	ctvv.setContent(tipo);
 		    	gkk.setComplexTypeKindVocabValue(ctvv);
 		    	
 		    	kind.setGroupKindKind(gkk);
 		    }
 		    relation.getGroupRelationRelation().setKind(kind);
		}catch (Exception e){
	       	String mensaje = "Error: No es posible insertar el tipo";
		    logger.error(mensaje);
		    throw e;
	    }
	}
	
	public void setRecursoAv(RecursoAgrega recursoAgrega) throws Exception{
		try{
			ResourceLomes resource=new ResourceLomes();
			GroupResourceResource grlrl=new GroupResourceResource();
			DescriptionUnbounded du=new DescriptionUnbounded();
			Identifier identifier=new Identifier();
			ArrayList lista=new ArrayList();
			if((recursoAgrega!=null)){
			
				ArrayList lDesc=new ArrayList();
				
				GroupDescriptionUnboundedDescription gdud=new GroupDescriptionUnboundedDescription();
				ArrayList descripciones=recursoAgrega.getDescripciones();
				IdentificadorAgrega identificador=recursoAgrega.getIdentificador();
				
				if((descripciones!=null)&&(descripciones.size()>0)){
					for (int i=0;i<descripciones.size();i++){
						LanguageStringItem lsi=new LanguageStringItem();
						es.pode.parseadorXML.castor.String string=new es.pode.parseadorXML.castor.String();
						String idioma=((LangStringAgrega)(descripciones.get(i))).getIdioma();
						String valor=((LangStringAgrega)(descripciones.get(i))).getValor();	
						string.setContent(valor);
						string.setLanguage(idioma);
						lsi.setString(string);
						lDesc.add(lsi);
					}
					LanguageStringItem[] listas1=(LanguageStringItem[])lDesc.toArray(new LanguageStringItem[lDesc.size()]);
					gdud.setLanguageStringItem(listas1);
					du.setGroupDescriptionUnboundedDescription(gdud);
					lista.add(du);
				}
				if(identificador!=null){
					String catalogo=identificador.getCatalogo();
					String entrada=identificador.getEntrada();
					
					GroupIdentifierIdentifier gii=new GroupIdentifierIdentifier();
					GroupCatalogCatalog gcc=new GroupCatalogCatalog();
					Catalog catalog=new Catalog();
					Entry entry=new Entry();
					GroupEntryEntry gee=new GroupEntryEntry();
					gee.setContent(entrada);
					entry.setGroupEntryEntry(gee);
					gcc.setContent(catalogo);
					catalog.setGroupCatalogCatalog(gcc);
					gii.setCatalog(catalog);
					gii.setEntry(entry);
					identifier.setGroupIdentifierIdentifier(gii);
				}
			}
			DescriptionUnbounded[] unbounded=(DescriptionUnbounded[])lista.toArray(new DescriptionUnbounded[lista.size()]);
			grlrl.setDescriptionUnbounded(unbounded);
			grlrl.setIdentifier(identifier);
			resource.setGroupResourceResource(grlrl);
			relation.getGroupRelationRelation().setResource(resource);
			
		}catch (Exception e){
	       	String mensaje = "Error: No es posible insertar el recurso";
		    logger.error(mensaje);
		    throw e;
	    }
	}

	
	public String getIdentificadorMEC(){
		String tipo="";
		InputStream is = null;
    	Properties prop = new Properties();
    	is = this.getClass().getResourceAsStream("/parseadorXML.properties");
		try {
			prop.load(is);
			ResourceLomes resource = relation.getGroupRelationRelation().getResource();
			if(resource!=null){
				Identifier ident = resource.getGroupResourceResource().getIdentifier();
				if(ident!=null){
					Catalog catalog = ident.getGroupIdentifierIdentifier().getCatalog();
					Entry entrada=ident.getGroupIdentifierIdentifier().getEntry();
					if(catalog!=null&& entrada!=null){
						String textoCatalogo=catalog.getGroupCatalogCatalog().getContent().toLowerCase().trim();
						String entry = entrada.getGroupEntryEntry().getContent();
						String catalogoMEC=prop.getProperty("catalogoMEC").toLowerCase().trim();
						if(catalogoMEC.equals(textoCatalogo)){
							tipo=entry;
						}
					}
				}
			}
			
			   
		   } catch (Exception e){
			   String mensaje = "Warning: No es posible recoger el identificadorMEC de la categoría Relación";
			   logger.warn(mensaje);
			   
			   return tipo;
			   //throw e;
		   }
		return tipo;
		
	}
	
	public String getTipoRelacionMEC(){
		
		String tipo="";
		InputStream is = null;
    	Properties prop = new Properties();
    	is = this.getClass().getResourceAsStream("/parseadorXML.properties");
		try {
			prop.load(is);
			ResourceLomes resource = relation.getGroupRelationRelation().getResource();
			Kind tip = relation.getGroupRelationRelation().getKind();
			if(resource!=null && tip!=null){
				Identifier ident = resource.getGroupResourceResource().getIdentifier();
				String valorTipo = tip.getGroupKindKind().getComplexTypeKindVocabValue().getContent();
				if(ident!=null && valorTipo!=null){
					Catalog catalog = ident.getGroupIdentifierIdentifier().getCatalog();
					if(catalog!=null){
						String textoCatalogo=catalog.getGroupCatalogCatalog().getContent().toLowerCase().trim();
						String catalogoMEC=prop.getProperty("catalogoMEC").toLowerCase().trim();
						if(catalogoMEC.equals(textoCatalogo)){
							tipo=valorTipo;
						}
					}
				}
			}
			
			   
		   } catch (Exception e){
			   String mensaje = "Warning: No es posible recoger el tipo de relacionMEC de la categoría Relación";
			   logger.warn(mensaje);
			   
			   return tipo;
			   //throw e;
		   }
		return tipo;
	}
}

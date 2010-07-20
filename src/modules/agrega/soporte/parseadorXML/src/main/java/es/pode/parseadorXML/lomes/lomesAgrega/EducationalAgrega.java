/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML.lomes.lomesAgrega;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.parseadorXML.castor.CognitiveProcess;
import es.pode.parseadorXML.castor.ComplexTypeCognitiveProcessVocabSource;
import es.pode.parseadorXML.castor.ComplexTypeCognitiveProcessVocabValue;
import es.pode.parseadorXML.castor.ComplexTypeContextVocabSource;
import es.pode.parseadorXML.castor.ComplexTypeContextVocabValue;
import es.pode.parseadorXML.castor.ComplexTypeDifficultyVocabSource;
import es.pode.parseadorXML.castor.ComplexTypeDifficultyVocabValue;
import es.pode.parseadorXML.castor.ComplexTypeDurationDescription;
import es.pode.parseadorXML.castor.ComplexTypeDurationDuration;
import es.pode.parseadorXML.castor.ComplexTypeIntendedEndUserRoleVocabSource;
import es.pode.parseadorXML.castor.ComplexTypeIntendedEndUserRoleVocabValue;
import es.pode.parseadorXML.castor.ComplexTypeInteractivityLevelVocabSource;
import es.pode.parseadorXML.castor.ComplexTypeInteractivityLevelVocabValue;
import es.pode.parseadorXML.castor.ComplexTypeInteractivityTypeVocabSource;
import es.pode.parseadorXML.castor.ComplexTypeInteractivityTypeVocabValue;
import es.pode.parseadorXML.castor.ComplexTypeLearningResourceTypeVocabSource;
import es.pode.parseadorXML.castor.ComplexTypeLearningResourceTypeVocabValue;
import es.pode.parseadorXML.castor.ComplexTypeSemanticDensityVocabSource;
import es.pode.parseadorXML.castor.ComplexTypeSemanticDensityVocabValue;
import es.pode.parseadorXML.castor.Context;
import es.pode.parseadorXML.castor.DescriptionUnbounded;
import es.pode.parseadorXML.castor.Difficulty;
import es.pode.parseadorXML.castor.Educational;
import es.pode.parseadorXML.castor.GroupCognitiveProcessCognitiveProcess;
import es.pode.parseadorXML.castor.GroupContextContext;
import es.pode.parseadorXML.castor.GroupDescriptionUnboundedDescription;
import es.pode.parseadorXML.castor.GroupDifficultyDifficulty;
import es.pode.parseadorXML.castor.GroupEducationalEducational;
import es.pode.parseadorXML.castor.GroupIntendedEndUserRoleIntendedEndUserRole;
import es.pode.parseadorXML.castor.GroupInteractivityLevelInteractivityLevel;
import es.pode.parseadorXML.castor.GroupInteractivityTypeInteractivityType;
import es.pode.parseadorXML.castor.GroupLanguageLanguage;
import es.pode.parseadorXML.castor.GroupLearningResourceTypeLearningResourceType;
import es.pode.parseadorXML.castor.GroupSemanticDensitySemanticDensity;
import es.pode.parseadorXML.castor.GroupTypicalAgeRangeTypicalAgeRange;
import es.pode.parseadorXML.castor.GroupTypicalLearningTimeTypicalLearningTime;
import es.pode.parseadorXML.castor.IntendedEndUserRole;
import es.pode.parseadorXML.castor.InteractivityLevel;
import es.pode.parseadorXML.castor.InteractivityType;
import es.pode.parseadorXML.castor.Language;
import es.pode.parseadorXML.castor.LanguageStringItem;
import es.pode.parseadorXML.castor.LearningResourceType;
import es.pode.parseadorXML.castor.SemanticDensity;
import es.pode.parseadorXML.castor.TypicalAgeRange;
import es.pode.parseadorXML.castor.TypicalLearningTime;


public class EducationalAgrega {

	private Educational educational = null;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public EducationalAgrega(Educational educational) {
		super();
		
		if (educational.getGroupEducationalEducational()== null){
			GroupEducationalEducational gee= new GroupEducationalEducational();
			educational.setGroupEducationalEducational(gee);
		}
		
		setEducational(educational);

        
	}
	
//	-----------/
    //- Methods -/
   //-----------/

   public Educational getEducational() {
		return educational;
	}
   
   public void setEducational(Educational educational) {
		this.educational = educational;
		
	}
   
   /*****/
   
   // método que recoge el contexto de la posición index
   public java.lang.String getContexto(
           final int index)
   throws java.lang.Exception {
	   
	   java.lang.String c= null;
	   
	   try{
		   c= educational.getGroupEducationalEducational().getContext(index).getGroupContextContext().getComplexTypeContextVocabValue().getContent();
		   
	   } catch (Exception e){
		   String mensaje = "Warning: No es posible recoger el contexto de la posición:" + index;
		   logger.warn(mensaje);
		   
		   //Devuelve null
		   return c;
		   
		   //throw e;
	   }
	   
	   return c;
   }
   
   // método que inserta el contexto en la posición index
   public void setContexto(
           final int index, java.lang.String contexto)
   throws java.lang.Exception {
       
       try{
    	 	if ((educational.getGroupEducationalEducational().getContext().length>0) && (index<educational.getGroupEducationalEducational().getContext().length)){
           		if(contexto != null && !contexto.equals("")){
           			Properties properties = new Properties(); 
					InputStream is = this.getClass().getResourceAsStream("/parseadorXML.properties");
					properties.load(is);
					String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
					
					Context[] auxArrayContexto=new Context[1];
					Context auxContexto = new Context();
					GroupContextContext grupoContexto = new GroupContextContext();
					ComplexTypeContextVocabSource ctcSource = new ComplexTypeContextVocabSource();
					ComplexTypeContextVocabValue ctcValue = new ComplexTypeContextVocabValue();
					ctcSource.setContent(lomes);
					ctcValue.setContent(contexto);
					grupoContexto.setComplexTypeContextVocabSource(ctcSource);
					grupoContexto.setComplexTypeContextVocabValue(ctcValue);
					auxContexto.setGroupContextContext(grupoContexto);
					auxArrayContexto[0]=auxContexto;
					educational.getGroupEducationalEducational().setContext(auxArrayContexto);
        		}
           		else{
           			educational.getGroupEducationalEducational().setContext(new Context[0]);
           		}
           	}
           	else{
           		if(contexto != null && !contexto.equals(""))
           			this.addContexto(contexto);
           	}
//       	if ((educational.getGroupEducationalEducational().getContext().length>0) && (index<educational.getGroupEducationalEducational().getContext().length)){
//       		educational.getGroupEducationalEducational().getContext(index).getGroupContextContext().getComplexTypeContextVocabValue().setContent(contexto);
//       	}
//       	else{
//       		if ((contexto!=null) && (!contexto.equals(""))) {
//       			this.addContexto(contexto);
//       		}
//       	}
       	
       }
       catch (Exception e){
       	String mensaje = "Error: No es posible insertar el contexto en la posición "+ index;
		    logger.error(mensaje);
		    throw e;
       } 
   }
   
   // método que recoge todos los contextos de Educational
   public ArrayList getContextos()
   throws java.lang.Exception {
	   
	   ArrayList cList= new ArrayList();
	   
	   try{
		   Context[] c= educational.getGroupEducationalEducational().getContext();
		   if (c!= null){
			   for (int i= 0; i<c.length; i++){
				   cList.add(c[i].getGroupContextContext().getComplexTypeContextVocabValue().getContent());
			   }
		   }
		   
	   } catch (Exception e){
		   String mensaje = "Warning: No es posible recoger los contextos de la categoría Educational";
		   logger.warn(mensaje);
		   
		   cList= new ArrayList();
		   return cList;
		   //throw e;
	   }
	   
	   return cList;
   }
 
//	 método que añade al final de la lista de contextos en la categoría Educational un contexto para el ODE.
   public void addContexto(
   		java.lang.String contexto ) 
   throws java.lang.Exception{
	   
	   String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
	   
	   Context c= new Context();
	   GroupContextContext gcc= new GroupContextContext();
	   ComplexTypeContextVocabSource ctcvs= new ComplexTypeContextVocabSource();
	   ComplexTypeContextVocabValue ctcvv= new ComplexTypeContextVocabValue();
	   
	   ctcvs.setContent(lomes);
	   ctcvv.setContent(contexto);
	   gcc.setComplexTypeContextVocabSource(ctcvs);
	   gcc.setComplexTypeContextVocabValue(ctcvv);
	   c.setGroupContextContext(gcc);
	   
	   if (educational == null){
		   educational= new Educational();
	   }
	    
	   if (educational.getGroupEducationalEducational() == null){
		   GroupEducationalEducational geeAux= new GroupEducationalEducational();
		   educational.setGroupEducationalEducational(geeAux);
	   }
	   
	   educational.getGroupEducationalEducational().addContext(c);
   }
   
   // método que recoge el tipo de recurso en la posición index
   public java.lang.String getTipoDeRecurso(
           final int index)
   throws java.lang.Exception {
	   
	   java.lang.String tr= null;
	   
	   try{
		   tr= educational.getGroupEducationalEducational().getLearningResourceType(index).getGroupLearningResourceTypeLearningResourceType().getComplexTypeLearningResourceTypeVocabValue().getContent();
		   
	   } catch (Exception e){
		   String mensaje = "Warning: No es posible recoger el tipo de recurso de la posición:" + index;
		   logger.warn(mensaje);
		   
//		 Devuelve null
		   return tr;
		   //throw e;
	   }
	   
	   return tr;
   }
   
   // método que introduce un tipo de recurso en la posición index. Si no existe la posición, lo añade al final de la lista
   public void setTipoDeRecurso(
           final int index, java.lang.String tipo)
   throws java.lang.Exception {
       
       try{
          	if ((educational.getGroupEducationalEducational().getLearningResourceType().length>0) && (index<educational.getGroupEducationalEducational().getLearningResourceType().length)){
           		if(tipo != null && !tipo.equals("")){

					String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
					
					LearningResourceType[] auxArrayTipo=new LearningResourceType[1];
					LearningResourceType tipoRecurso = new LearningResourceType();
					GroupLearningResourceTypeLearningResourceType grupoTipo = new GroupLearningResourceTypeLearningResourceType();
					ComplexTypeLearningResourceTypeVocabSource ctlrtSource = new ComplexTypeLearningResourceTypeVocabSource();
					ComplexTypeLearningResourceTypeVocabValue ctlrtValue = new ComplexTypeLearningResourceTypeVocabValue();
					ctlrtSource.setContent(lomes);
					ctlrtValue.setContent(tipo);
					grupoTipo.setComplexTypeLearningResourceTypeVocabSource(ctlrtSource);
					grupoTipo.setComplexTypeLearningResourceTypeVocabValue(ctlrtValue);
					tipoRecurso.setGroupLearningResourceTypeLearningResourceType(grupoTipo);
					auxArrayTipo[0]=tipoRecurso;
					educational.getGroupEducationalEducational().setLearningResourceType(auxArrayTipo);
        		}
           		else{
           			educational.getGroupEducationalEducational().setLearningResourceType(new LearningResourceType[0]);
           		}
           	}
           	else{
           		if(tipo != null && !tipo.equals(""))
           			this.addTipoDeRecurso(tipo);
           	}
    	   
//       	if ((educational.getGroupEducationalEducational().getLearningResourceType().length>0) && (index<educational.getGroupEducationalEducational().getLearningResourceType().length)){
//       		educational.getGroupEducationalEducational().getLearningResourceType(index).getGroupLearningResourceTypeLearningResourceType().getComplexTypeLearningResourceTypeVocabValue().setContent(tipo);
//       	}
//       	else{
//       			this.addTipoDeRecurso(tipo);
//       
//       	}
       	
       }
       catch (Exception e){
       	String mensaje = "Error: No es posible insertar el tipo de recurso en la posición "+ index;
		    logger.error(mensaje);
		    throw e;
       } 
   }
   
   // método que recoge todos los tipos de recurso de Educational
   public ArrayList getTiposDeRecurso()
   throws java.lang.Exception {
	   
	   ArrayList trList= new ArrayList();
	   
	   try{
		   LearningResourceType[] lrt= educational.getGroupEducationalEducational().getLearningResourceType();
		   if (lrt!= null){
			   for (int i= 0; i<lrt.length; i++){
				   trList.add(lrt[i].getGroupLearningResourceTypeLearningResourceType().getComplexTypeLearningResourceTypeVocabValue().getContent());
			   }
		   }
		   
	   } catch (Exception e){
		   String mensaje = "Warning: No es posible recoger los tipos de recurso de la categoría Educational";
		   logger.warn(mensaje);
		   
		   trList= new ArrayList();
		   return trList;
		   //throw e;
	   }
	   
	   return trList;
   }
   
//	 método que añade a las lista de recursos en la categoría Educational un tipo de recurso.
   public void addTipoDeRecurso(
   		java.lang.String tr ) 
   throws java.lang.Exception{
	   
	   String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
	   
	   LearningResourceType lrt= new LearningResourceType();
	   GroupLearningResourceTypeLearningResourceType glrt= new GroupLearningResourceTypeLearningResourceType();
	   ComplexTypeLearningResourceTypeVocabSource ctlrtvs= new ComplexTypeLearningResourceTypeVocabSource();
	   ComplexTypeLearningResourceTypeVocabValue ctlrtvv= new ComplexTypeLearningResourceTypeVocabValue();
	   
	   ctlrtvs.setContent(lomes);
	   ctlrtvv.setContent(tr);
	   glrt.setComplexTypeLearningResourceTypeVocabSource(ctlrtvs);
	   glrt.setComplexTypeLearningResourceTypeVocabValue(ctlrtvv);
	   lrt.setGroupLearningResourceTypeLearningResourceType(glrt);
	   
	   if (educational == null){
		   educational= new Educational();
	   }
	    
	   if (educational.getGroupEducationalEducational() == null){
		   GroupEducationalEducational geeAux= new GroupEducationalEducational();
		   educational.setGroupEducationalEducational(geeAux);
	   }
	   
	   educational.getGroupEducationalEducational().addLearningResourceType(lrt);
   }
   
// método que recoge el rango de edad en un idioma concreto en la posición especificada en el parámetro
   // si el rango de edad en la posición indicada no existe en el idioma deseado, 
   // se devuelve el rango de edad de esa posición que aparezca en el primer idioma
   public java.lang.String getRangoEdad (int indexRango, java.lang.String idioma
   ) throws java.lang.Exception {

   	java.lang.String lString= null;
       
    try{
    	LanguageStringItem lsi[]= educational.getGroupEducationalEducational().getTypicalAgeRange(indexRango).getGroupTypicalAgeRangeTypicalAgeRange().getLanguageStringItem();
       	
       	if ((lsi != null) && (lsi.length>0)){
	    		int cont= 0;
				boolean idiEncontrado= false;
				while ((cont<lsi.length) && (idiEncontrado== false)){
					if (idioma.equals(lsi[cont].getString().getLanguage())){
						idiEncontrado= true;
					}
					else{
						cont++;
					}
				}
				if ((idiEncontrado) && (cont<lsi.length)){
					lString= lsi[cont].getString().getContent();
				}
				//si no encuentra la descripción buscada, devuelve la primera por defecto
				else{
					lString= lsi[0].getString().getContent();
				}
	    	}
       }
       catch (Exception e){
    	   String mensaje = "Warning: No es posible recoger el rango de edad de la posición "+ indexRango;
    	   logger.warn(mensaje);
		   
		   //Devuelve null
		   lString=null;
		   return lString;
		   //throw e;
       }
       return lString;
   }
   
   public void setRangoEdad(
           final int index, java.lang.String idioma, java.lang.String edad)
   throws java.lang.Exception {
       
       try{
       	if ((educational.getGroupEducationalEducational().getTypicalAgeRange().length>0) && (index<educational.getGroupEducationalEducational().getTypicalAgeRange().length)){
       		if(edad != null && !edad.equals("")){
	       		LanguageStringItem lsi= new LanguageStringItem();
	    		es.pode.parseadorXML.castor.String s= new es.pode.parseadorXML.castor.String();
	    		s.setContent(edad);
	    		s.setLanguage(idioma);
	    		lsi.setString(s); 
	    		TypicalAgeRange[] auxArrayEdad=new TypicalAgeRange[1];
	    		TypicalAgeRange edadRango = new TypicalAgeRange();
	    		GroupTypicalAgeRangeTypicalAgeRange grupoEdad = new GroupTypicalAgeRangeTypicalAgeRange();
	    		grupoEdad.addLanguageStringItem(lsi);
	    		edadRango.setGroupTypicalAgeRangeTypicalAgeRange(grupoEdad);
	    		auxArrayEdad[0]=edadRango;
	    		educational.getGroupEducationalEducational().setTypicalAgeRange(auxArrayEdad);
    		}
       		else{
       			educational.getGroupEducationalEducational().setTypicalAgeRange(new TypicalAgeRange[0]);
       		}
//    		if(edad == null || edad.equals("")){
//    		//	educational.getGroupEducationalEducational().getTypicalAgeRange(index).setGroupTypicalAgeRangeTypicalAgeRange(null);
//    			TypicalAgeRange[] arrayEdad= educational.getGroupEducationalEducational().getTypicalAgeRange();
//    			TypicalAgeRange[] auxArrayEdad=new TypicalAgeRange[arrayEdad.length-1];
//    			for(int i=0;i<auxArrayEdad.length;i++){
//    				auxArrayEdad[i]=arrayEdad[i+1];
//    			}
//    			educational.getGroupEducationalEducational().setTypicalAgeRange(auxArrayEdad);
//    		}
//    		else
//    		if(educational.getGroupEducationalEducational().getTypicalAgeRange().length>1 && edad!=null && edad.equals(""))
//    			educational.getGroupEducationalEducational().getTypicalAgeRange(index).getGroupTypicalAgeRangeTypicalAgeRange().setLanguageStringItem(0, lsi);
//    		else
//    			educational.getGroupEducationalEducational().setTypicalAgeRange(new TypicalAgeRange[0]);
       	}
       	else{
       		if ((edad!=null) && (!edad.equals(""))) {
       			this.addRangoEdad(idioma, edad);
       		}
       		
       	}
       	
       }
       catch (Exception e){
       	String mensaje = "Error: No es posible insertar el tipo de recurso en la posición "+ index;
		    logger.error(mensaje);
		    throw e;
       } 
   }
   
// método que recoge todos los rangos de edad de un ODE de la categoría Educational en el idioma especificado
   public ArrayList getRangosEdadIdioma (java.lang.String idioma
   ) throws java.lang.Exception {

   	ArrayList l= new ArrayList();
       
    try{
    	TypicalAgeRange[] tar= educational.getGroupEducationalEducational().getTypicalAgeRange();
       	
       	if (tar != null){
       		for (int i= 0; i<tar.length; i++){
       			
       			LanguageStringItem[] lsi= educational.getGroupEducationalEducational().getTypicalAgeRange(i).getGroupTypicalAgeRangeTypicalAgeRange().getLanguageStringItem();
	            	
	            if ((lsi != null) && (lsi.length>0)){
	            	int cont= 0;
	    			boolean idiEncontrado= false;
	    			while ((cont<lsi.length) && (idiEncontrado== false)){
		    			if (idioma.equals(lsi[cont].getString().getLanguage())){
		    				idiEncontrado= true;
		    			}
		    			else{
		    				cont++;
		    			}
	    			}
		    		if ((idiEncontrado) && (cont<lsi.length)){
		    			l.add(lsi[cont].getString().getContent());
		    		}
	            }
	       }
       	}
    }
       catch (Exception e){
       	String mensaje = "Warning: No es posible recoger los rangos de edad";
       	logger.warn(mensaje);
		
		l= new ArrayList();
		return l;
		//throw e;
       } 
       return l;
   }
   
// método que recoge todos los rangos de edad de un ODE de la categoría Educational en cualquier idioma
   public ArrayList getRangosEdad (
   ) throws java.lang.Exception {

   	ArrayList l= new ArrayList();
       
    try{
    	TypicalAgeRange[] tar= educational.getGroupEducationalEducational().getTypicalAgeRange();
       	
       	if (tar != null){
       		for (int i= 0; i<tar.length; i++){
       			
       			LanguageStringItem[] lsi= educational.getGroupEducationalEducational().getTypicalAgeRange(i).getGroupTypicalAgeRangeTypicalAgeRange().getLanguageStringItem();
	            
       			if ((lsi != null) && (lsi.length>0)){
    	    		int cont= 0;
    				while (cont<lsi.length){
    					l.add(lsi[cont].getString().getContent());
    					cont++;
    				}
    			}
	       }
       	}
    }
       catch (Exception e){
       	String mensaje = "Warning: No es posible recoger los rangos de edad";
       	logger.warn(mensaje);
		
		l= new ArrayList();
		return l;
		//throw e;
       } 
       return l;
   }
   
// método que añade un rango de edad en la categoría Educational en el idioma indicado en el parámetro
   public void addRangoEdad(java.lang.String idioma, java.lang.String rango ) 
   throws java.lang.Exception{
	   
	   TypicalAgeRange tar= new TypicalAgeRange();
	   GroupTypicalAgeRangeTypicalAgeRange gtar= new GroupTypicalAgeRangeTypicalAgeRange();
	   LanguageStringItem lsi= new LanguageStringItem();
   	   es.pode.parseadorXML.castor.String s= new es.pode.parseadorXML.castor.String();
   		
   		s.setContent(rango);
   		s.setLanguage(idioma);
   		lsi.setString(s);
   		gtar.addLanguageStringItem(lsi);
   		tar.setGroupTypicalAgeRangeTypicalAgeRange(gtar);
   		
   		if (educational == null){
   			educational= new Educational();
		}
   		if (educational.getGroupEducationalEducational()== null){
   			GroupEducationalEducational geeAux= new GroupEducationalEducational();
		    educational.setGroupEducationalEducational(geeAux);
		}
	
   		educational.getGroupEducationalEducational().addTypicalAgeRange(tar);
   }


   public java.lang.String getIdiomaDestinatario (final int index
   ) throws java.lang.Exception {
	   
	   java.lang.String i= null;
	   
	   try{
		   i= educational.getGroupEducationalEducational().getLanguage(index).getGroupLanguageLanguage().getContent();
		   
	   } catch (Exception e){
		   String mensaje = "Warning: No es posible recoger el idioma del destinatario";
		   logger.warn(mensaje);
		   
//		 Devuelve null
		   return i;
		   //throw e;
	   }
	   
	   return i;
   }
   
   public void setIdiomaDestinatario(
           final int index, java.lang.String idiomaDest)
   throws java.lang.Exception {
	   
       try{
       	if ((educational.getGroupEducationalEducational().getLanguage().length>0) && (index<educational.getGroupEducationalEducational().getLanguage().length)){
       		if(idiomaDest != null && !idiomaDest.equals("")){
       			Language[] auxArrayIdioma=new Language[1];
       			Language idioma = new Language();
       			GroupLanguageLanguage grupoIdioma = new GroupLanguageLanguage();
       			grupoIdioma.setContent(idiomaDest);
       			idioma.setGroupLanguageLanguage(grupoIdioma);
       			auxArrayIdioma[0]=idioma;
	    		educational.getGroupEducationalEducational().setLanguage(auxArrayIdioma);
    		}
       		else{
       			educational.getGroupEducationalEducational().setLanguage(new Language[0]);
       		}
       	//	educational.getGroupEducationalEducational().getLanguage(index).getGroupLanguageLanguage().setContent(idiomaDest);
       	}
       	else{
       		if(idiomaDest != null && !idiomaDest.equals(""))
       			this.addIdiomaDestinatario(idiomaDest);
       	}
       	
       }
       catch (Exception e){
       	String mensaje = "Error: No es posible insertar el idioma en la posición "+ index;
		    logger.error(mensaje);
		    throw e;
       } 
   }
   
   public ArrayList getIdiomasDestinatario (
   ) throws java.lang.Exception {
	   
	   ArrayList iList= new ArrayList();
	   
	   try{
		   Language l[]= educational.getGroupEducationalEducational().getLanguage();
		   if (l!= null){
			   for (int i= 0; i<l.length; i++){
				   iList.add(l[i].getGroupLanguageLanguage().getContent());
			   }
		   }
		   
	   } catch (Exception e){
		   String mensaje = "Warning: No es posible recoger los idiomas del destinatario";
		   logger.warn(mensaje);
		   
		   iList= new ArrayList();
		   return iList;
		   //throw e;
	   }
	   
	   return iList;
   }
   
   public void addIdiomaDestinatario (java.lang.String idioma
   ) throws java.lang.Exception {
	   
	   Language l= new Language();
	   GroupLanguageLanguage gll= new GroupLanguageLanguage();
	  
	   gll.setContent(idioma);
	   l.setGroupLanguageLanguage(gll);
	   
	   if (educational == null){
  			educational= new Educational();
	   }
	   if (educational.getGroupEducationalEducational()== null){
		   GroupEducationalEducational geeAux= new GroupEducationalEducational();
		   educational.setGroupEducationalEducational(geeAux);
	   }
	   
	   educational.getGroupEducationalEducational().addLanguage(l);
   }
   
   public java.lang.String getProcesoCognitivo(final int index)
   throws java.lang.Exception {
	   
	   java.lang.String pc= null;
	   
	   try{
		   pc= educational.getGroupEducationalEducational().getCognitiveProcess(index).getGroupCognitiveProcessCognitiveProcess().getComplexTypeCognitiveProcessVocabValue().getContent();
		   
		   
	   } catch (Exception e){
		   String mensaje = "Warning: No es posible recoger el proceso cognitivo de la posición" + index;
		   logger.warn(mensaje);
		   
//		 Devuelve null
		   return pc;
		   //throw e;
	   }
	   
	   return pc;
   }
   
   public void setProcesoCognitivo(
           final int index, java.lang.String proceso)
   throws java.lang.Exception {
       
       try{
    	   if ((educational.getGroupEducationalEducational().getCognitiveProcess().length>0) && (index<educational.getGroupEducationalEducational().getCognitiveProcess().length)){
          		if(proceso != null && !proceso.equals("")){

					String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
					
					CognitiveProcess[] auxArrayProceso=new CognitiveProcess[1];
					CognitiveProcess auxProceso = new CognitiveProcess();
					GroupCognitiveProcessCognitiveProcess grupoProceso = new GroupCognitiveProcessCognitiveProcess();
					ComplexTypeCognitiveProcessVocabSource ctcpSource = new ComplexTypeCognitiveProcessVocabSource();
					ComplexTypeCognitiveProcessVocabValue ctcpValue = new ComplexTypeCognitiveProcessVocabValue();
					ctcpSource.setContent(lomes);
					ctcpValue.setContent(proceso);
					grupoProceso.setComplexTypeCognitiveProcessVocabSource(ctcpSource);
					grupoProceso.setComplexTypeCognitiveProcessVocabValue(ctcpValue);
					auxProceso.setGroupCognitiveProcessCognitiveProcess(grupoProceso);
					auxArrayProceso[0]=auxProceso;
					educational.getGroupEducationalEducational().setCognitiveProcess(auxArrayProceso);
       		}
          		else{
          			educational.getGroupEducationalEducational().setCognitiveProcess(new CognitiveProcess[0]);
          		}
          	}
          	else{
          		if(proceso != null && !proceso.equals(""))
          			this.addProcesoCognitivo(proceso);
          	}
    	   
//       	if ((educational.getGroupEducationalEducational().getCognitiveProcess().length>0) && (index<educational.getGroupEducationalEducational().getCognitiveProcess().length)){
//       		educational.getGroupEducationalEducational().getCognitiveProcess(index).getGroupCognitiveProcessCognitiveProcess().getComplexTypeCognitiveProcessVocabValue().setContent(proceso);
//       	}
//       	else{
//       		if ((proceso!= null) && (!proceso.equals(""))) {
//       			this.addProcesoCognitivo(proceso);
//       		}
//       	}
       	
       }
       catch (Exception e){
       	String mensaje = "Error: No es posible insertar el proceso cognitivo en la posición "+ index;
		    logger.error(mensaje);
		    throw e;
       } 
   }
   
   public ArrayList getProcesosCognitivos()
   throws java.lang.Exception {
	   
	   ArrayList cpList= new ArrayList();
	   
	   try{
		   CognitiveProcess[] cp= educational.getGroupEducationalEducational().getCognitiveProcess();
		   if (cp != null){
			   for (int i= 0; i<cp.length; i++){
				   cpList.add(cp[i].getGroupCognitiveProcessCognitiveProcess().getComplexTypeCognitiveProcessVocabValue().getContent());
			   }
		   }
		   
	   } catch (Exception e){
		   String mensaje = "Warning: No es posible recoger los procesos cognitivos de la categoría Educational";
		   logger.warn(mensaje);
		   
		   cpList= new ArrayList();
		   return cpList;
		   //throw e;
	   }
	   
	   return cpList;
   }
   
   public void addProcesoCognitivo (java.lang.String pc
   ) throws java.lang.Exception {
	   
	   String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
	   
	   CognitiveProcess cp= new CognitiveProcess();
	   GroupCognitiveProcessCognitiveProcess gcp= new GroupCognitiveProcessCognitiveProcess();
	   ComplexTypeCognitiveProcessVocabSource ctcpvs= new ComplexTypeCognitiveProcessVocabSource();
	   ComplexTypeCognitiveProcessVocabValue ctcpvv= new ComplexTypeCognitiveProcessVocabValue();
	   
	   ctcpvs.setContent(lomes);
	   ctcpvv.setContent(pc);
	   gcp.setComplexTypeCognitiveProcessVocabSource(ctcpvs);
	   gcp.setComplexTypeCognitiveProcessVocabValue(ctcpvv);
	   cp.setGroupCognitiveProcessCognitiveProcess(gcp);
	   
	   if (educational == null){
 			educational= new Educational();
	   }
	   if (educational.getGroupEducationalEducational()== null){
		   GroupEducationalEducational geeAux= new GroupEducationalEducational();
		   educational.setGroupEducationalEducational(geeAux);
	   }
	   
	   educational.getGroupEducationalEducational().addCognitiveProcess(cp);
	   
   }
   
   // método que recoge el destinatario en la posición indicada
   public java.lang.String getDestinatario(final int index)
   throws java.lang.Exception {
	   
	   java.lang.String des= null;
	   
	   try{
		   des= educational.getGroupEducationalEducational().getIntendedEndUserRole(index).getGroupIntendedEndUserRoleIntendedEndUserRole().getComplexTypeIntendedEndUserRoleVocabValue().getContent();
		   
	   } catch (Exception e){
		   String mensaje = "Warning: No es posible recoger el destinatario de la posición: " +index;
		   logger.warn(mensaje);
		   
//		 Devuelve null
		   return des;
		   //throw e;
	   }
	   
	   return des;
	   
   }
   
   public ArrayList getDestinatarios()
   throws java.lang.Exception {
	   
	   ArrayList dList= new ArrayList();
	   
	   try{
		   IntendedEndUserRole[] ieur= educational.getGroupEducationalEducational().getIntendedEndUserRole();
		   if (ieur != null){
			   for (int i= 0; i<ieur.length; i++){
				   dList.add(ieur[i].getGroupIntendedEndUserRoleIntendedEndUserRole().getComplexTypeIntendedEndUserRoleVocabValue().getContent());
			   }
		   }
		   
	   } catch (Exception e){
		   String mensaje = "Warning: No es posible recoger los destinatarios de la categoría Educational";
		   logger.warn(mensaje);
		   
		   dList= new ArrayList();
		   return dList;
		   //throw e;
	   }
	   
	   return dList;
	   
   }
   
   /*****************************Métodos para Catalogador Avanzado********************************/
   
   public java.lang.String getTipoDeInteractividadAv()
   throws java.lang.Exception {
	   
	   java.lang.String des= null;
	   
	   try{
		   InteractivityType interac = educational.getGroupEducationalEducational().getInteractivityType();
		   if(interac!=null)
			   des= interac.getGroupInteractivityTypeInteractivityType().getComplexTypeInteractivityTypeVocabValue().getContent();
		   
	   } catch (Exception e){
		   String mensaje = "Warning: No es posible recoger el tipo de interactividad.";
		   logger.warn(mensaje);
		   
//		 Devuelve null
		   return des;
		   //throw e;
	   }
	   
	   return des;
	   
   }
   public void setTipoDeInteractividadAv(String tipoInteractividad)throws java.lang.Exception {
	   InteractivityType tipoInter = null;
	   if (tipoInteractividad != null){

		   String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		   
		   GroupInteractivityTypeInteractivityType citit = new GroupInteractivityTypeInteractivityType();
		   ComplexTypeInteractivityTypeVocabValue ctitvv = new ComplexTypeInteractivityTypeVocabValue();
		   ComplexTypeInteractivityTypeVocabSource ctitvs = new ComplexTypeInteractivityTypeVocabSource();
		   tipoInter = new InteractivityType();
		   
		   ctitvv.setContent(tipoInteractividad);
		   ctitvs.setContent(lomes);
		   citit.setComplexTypeInteractivityTypeVocabSource(ctitvs);
		   citit.setComplexTypeInteractivityTypeVocabValue(ctitvv);
		   tipoInter.setGroupInteractivityTypeInteractivityType(citit);
	   }
	   educational.getGroupEducationalEducational().setInteractivityType(tipoInter);
	   
   }  
   public ArrayList getTiposDeRecursoAv()
   throws java.lang.Exception {
	   
	   ArrayList lTiposRecurso=new ArrayList();
	   lTiposRecurso=getTiposDeRecurso();	   
	   return lTiposRecurso;
   }
   
   public void setTiposDeRecursoAv(ArrayList lTipoRecursos)
   throws java.lang.Exception {
	   ArrayList lTiposRec = new ArrayList();
	   if (lTipoRecursos != null && lTipoRecursos.size()>0){

		   String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		   
		   
		   for (int i = 0; i < lTipoRecursos.size(); i++){
			   GroupLearningResourceTypeLearningResourceType glrtlrt = new GroupLearningResourceTypeLearningResourceType();
			   ComplexTypeLearningResourceTypeVocabValue ctlrtvv = new ComplexTypeLearningResourceTypeVocabValue();
			   ComplexTypeLearningResourceTypeVocabSource ctlrtvs = new ComplexTypeLearningResourceTypeVocabSource();
			   LearningResourceType tipoRecurso = new LearningResourceType();
			   
			   String sRecurso = (String) lTipoRecursos.get(i);
			   
			   ctlrtvv.setContent(sRecurso);
			   ctlrtvs.setContent(lomes);
			   glrtlrt.setComplexTypeLearningResourceTypeVocabSource(ctlrtvs);
			   glrtlrt.setComplexTypeLearningResourceTypeVocabValue(ctlrtvv);
			   tipoRecurso.setGroupLearningResourceTypeLearningResourceType(glrtlrt);
			   lTiposRec.add(tipoRecurso);
			  // educational.getGroupEducationalEducational().addLearningResourceType(tipoRecurso);
		   }
	   }
	   educational.getGroupEducationalEducational().setLearningResourceType((LearningResourceType[])lTiposRec.toArray(new LearningResourceType[lTiposRec.size()]));
   }
   
   public java.lang.String getNivelDeInteractividadAv()throws java.lang.Exception {
	   
	   java.lang.String des= null;
	   
	   try{
		   InteractivityLevel interac = educational.getGroupEducationalEducational().getInteractivityLevel();
		   if(interac!=null)
			   des= interac.getGroupInteractivityLevelInteractivityLevel().getComplexTypeInteractivityLevelVocabValue().getContent();
		   
	   } catch (Exception e){
		   String mensaje = "Warning: No es posible recoger el nivel de interactividad.";
		   logger.warn(mensaje);
		   
//		 Devuelve null
		   return des;
		   //throw e;
	   }
	   
	   return des;
	   
   }
   
   public void setNivelDeInteractividadAv(String nivelInteractividad)throws java.lang.Exception {
	   InteractivityLevel nivelInter =null;
	   if (nivelInteractividad != null){

		   String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		   
		   GroupInteractivityLevelInteractivityLevel gilil = new GroupInteractivityLevelInteractivityLevel();
		   ComplexTypeInteractivityLevelVocabValue ctilvv = new ComplexTypeInteractivityLevelVocabValue();
		   ComplexTypeInteractivityLevelVocabSource ctilvs = new ComplexTypeInteractivityLevelVocabSource();
		   nivelInter = new InteractivityLevel();
		   
		   ctilvv.setContent(nivelInteractividad);
		   ctilvs.setContent(lomes);
		   gilil.setComplexTypeInteractivityLevelVocabSource(ctilvs);
		   gilil.setComplexTypeInteractivityLevelVocabValue(ctilvv);
		   nivelInter.setGroupInteractivityLevelInteractivityLevel(gilil);
		   
	   }
	   educational.getGroupEducationalEducational().setInteractivityLevel(nivelInter);
   }   
   
   public java.lang.String getDensidadSemanticaAv()throws java.lang.Exception {
	   
	   java.lang.String des= null;
	   
	   try{
		   SemanticDensity seman = educational.getGroupEducationalEducational().getSemanticDensity();
		   if(seman!=null)
			   des= seman.getGroupSemanticDensitySemanticDensity().getComplexTypeSemanticDensityVocabValue().getContent();
		   
	   } catch (Exception e){
		   String mensaje = "Warning: No es posible recoger la densidad semántica.";
		   logger.warn(mensaje);
		   
//		 Devuelve null
		   return des;
		   //throw e;
	   }
	   
	   return des;
	   
   }
   
   public  void setDensidadSemanticaAv(String densidadSemantica)throws java.lang.Exception {
	   SemanticDensity densidadSeman =null;
	   
	   if (densidadSemantica != null){

		   String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		   
		   GroupSemanticDensitySemanticDensity gsdsd = new GroupSemanticDensitySemanticDensity();
		   ComplexTypeSemanticDensityVocabValue ctsdvv = new ComplexTypeSemanticDensityVocabValue();
		   ComplexTypeSemanticDensityVocabSource ctsdvs = new ComplexTypeSemanticDensityVocabSource();
		   densidadSeman = new SemanticDensity();
		   
		   ctsdvv.setContent(densidadSemantica);
		   ctsdvs.setContent(lomes);
		   gsdsd.setComplexTypeSemanticDensityVocabSource(ctsdvs);
		   gsdsd.setComplexTypeSemanticDensityVocabValue(ctsdvv);
		   densidadSeman.setGroupSemanticDensitySemanticDensity(gsdsd);
	   } 
	   educational.getGroupEducationalEducational().setSemanticDensity(densidadSeman);
   }
   
   
   public ArrayList getDestinatariosAv() throws java.lang.Exception {
	   
	   ArrayList dList= new ArrayList();
	   dList=getDestinatarios();
	   return dList;
	   
   }

   public  void setDestinatariosAv(ArrayList lDestinatarios) throws java.lang.Exception {
	   ArrayList lDestina = new ArrayList();
	   if (lDestinatarios != null && lDestinatarios.size()>0){
	
		   String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		   
		   for (int i = 0; i < lDestinatarios.size(); i++){
			   GroupIntendedEndUserRoleIntendedEndUserRole gieurieur = new GroupIntendedEndUserRoleIntendedEndUserRole();
			   ComplexTypeIntendedEndUserRoleVocabValue ctieurvv = new ComplexTypeIntendedEndUserRoleVocabValue();
			   ComplexTypeIntendedEndUserRoleVocabSource ctieurvs = new ComplexTypeIntendedEndUserRoleVocabSource();
			   IntendedEndUserRole destinatario = new IntendedEndUserRole();
			   
			   String sDestinatario = (String) lDestinatarios.get(i);
			   
			   ctieurvv.setContent(sDestinatario);
			   ctieurvs.setContent(lomes);
			   gieurieur.setComplexTypeIntendedEndUserRoleVocabSource(ctieurvs);
			   gieurieur.setComplexTypeIntendedEndUserRoleVocabValue(ctieurvv);
			   destinatario.setGroupIntendedEndUserRoleIntendedEndUserRole(gieurieur);
			   lDestina.add(destinatario);
		   }
	   }
	   educational.getGroupEducationalEducational().setIntendedEndUserRole((IntendedEndUserRole[])lDestina.toArray(new IntendedEndUserRole[lDestina.size()]));
   }
      
   public ArrayList getContextosAv() throws java.lang.Exception {
	   
	   ArrayList dList= new ArrayList();
	   dList=getContextos();
	   return dList;
	   
   }
   
   public void setContextosAv(ArrayList lContextos) throws java.lang.Exception {
	   
	   ArrayList lContext = new ArrayList();
	   
	   if (lContextos != null && lContextos.size()>0){

		   String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");

		   
		   for (int i = 0; i < lContextos.size(); i++){
			   GroupContextContext gcc = new GroupContextContext();
			   ComplexTypeContextVocabValue ctcvv = new ComplexTypeContextVocabValue();
			   ComplexTypeContextVocabSource ctcvs = new ComplexTypeContextVocabSource();
			   Context contexto = new Context();
			   
			   String sContexto = (String) lContextos.get(i);
			   
			   ctcvv.setContent(sContexto);
			   ctcvs.setContent(lomes);
			   gcc.setComplexTypeContextVocabSource(ctcvs);
			   gcc.setComplexTypeContextVocabValue(ctcvv);
			   contexto.setGroupContextContext(gcc);
			   lContext.add(contexto);
		   }
	   } 
	   educational.getGroupEducationalEducational().setContext((Context[])lContext.toArray(new Context[lContext.size()]));
   }
   
   public ArrayList getRangosEdadAv() throws java.lang.Exception {

   	ArrayList l= new ArrayList();
       
    try{
    	TypicalAgeRange[] tar= educational.getGroupEducationalEducational().getTypicalAgeRange();
       	
       	if ((tar != null)&&(tar.length>0)){
       		for (int i= 0; i<tar.length; i++){
       			ArrayList laños=new ArrayList();
       			
       			LanguageStringItem[] lsi= educational.getGroupEducationalEducational().getTypicalAgeRange(i).getGroupTypicalAgeRangeTypicalAgeRange().getLanguageStringItem();
	            
       			if ((lsi != null) && (lsi.length>0)){
    	    		int cont= 0;
    				while (cont<lsi.length){
    					LangStringAgrega lString=new LangStringAgrega();
    					lString.setValor(lsi[cont].getString().getContent());
    					lString.setIdioma(lsi[cont].getString().getLanguage());
    					laños.add(lString);
    					cont++;
    				}
    			}
       			l.add(laños);
	       }
       	}
    }
       catch (Exception e){
       	String mensaje = "Warning: No es posible recoger los rangos de edad";
       	logger.warn(mensaje);
		
		l= new ArrayList();
		return l;
		//throw e;
       } 
       return l;
   }
   
   public void setRangosEdadAv(ArrayList lRangosEdad) throws java.lang.Exception {
	   if (lRangosEdad != null && lRangosEdad.size()>0){	   
		  
		   ArrayList lRangosE = new ArrayList();
		   
		   for (int i = 0; i < lRangosEdad.size(); i++){
			   ArrayList lLangRangosE = new ArrayList();
			   GroupTypicalAgeRangeTypicalAgeRange gtartar = new GroupTypicalAgeRangeTypicalAgeRange();
			   TypicalAgeRange rangosEdad = new TypicalAgeRange();	  
			   ArrayList lRangos = (ArrayList) lRangosEdad.get(i);
			   for (int j = 0; j < lRangos.size(); j++){
				   LangStringAgrega lsa = (LangStringAgrega) lRangos.get(j);
				   String valor = lsa.getValor();
				   String idioma = lsa.getIdioma();
				   
				   es.pode.parseadorXML.castor.String s = new es.pode.parseadorXML.castor.String();
				   s.setContent(valor);
				   s.setLanguage(idioma);
				   
				   LanguageStringItem lsi= new LanguageStringItem();
				   lsi.setString(s);
				   lLangRangosE.add(lsi);
			   
			   }
			   gtartar.setLanguageStringItem((LanguageStringItem[])lLangRangosE.toArray(new LanguageStringItem[lLangRangosE.size()]));
			   rangosEdad.setGroupTypicalAgeRangeTypicalAgeRange(gtartar);
			   lRangosE.add(rangosEdad);
		   } 
		   educational.getGroupEducationalEducational().setTypicalAgeRange((TypicalAgeRange[])lRangosE.toArray(new TypicalAgeRange[lRangosE.size()]));
	   }
   }
   
   public DuracionAgrega getTiempoTipicoAprendizajeAv()throws java.lang.Exception {
	   
	   DuracionAgrega des= new DuracionAgrega();
//	   ArrayList lDesc=new ArrayList();
	   ArrayList lDesc=null;
	   try{
		   TypicalLearningTime tipico = educational.getGroupEducationalEducational().getTypicalLearningTime();
		   if(tipico!=null){
			   LanguageStringItem[] lsi=null;
			   if(tipico.getGroupTypicalLearningTimeTypicalLearningTime().getComplexTypeDurationDescription()!=null)
				   lsi=tipico.getGroupTypicalLearningTimeTypicalLearningTime().getComplexTypeDurationDescription().getLanguageStringItem();
			   
			   String duration=null;
			   if(tipico.getGroupTypicalLearningTimeTypicalLearningTime().getComplexTypeDurationDuration()!=null)
				   duration=tipico.getGroupTypicalLearningTimeTypicalLearningTime().getComplexTypeDurationDuration().getContent();
			   if ((lsi != null) && (lsi.length>0)){
				   lDesc=new ArrayList();
				   int cont= 0;
				   while (cont<lsi.length){
						
					   LangStringAgrega lString=new LangStringAgrega();
					   lString.setValor(lsi[cont].getString().getContent());
					   lString.setIdioma(lsi[cont].getString().getLanguage());
					   lDesc.add(lString);
					   cont++;
				   }
				   
			   }
			   des.setDescripciones(lDesc);
			   
			   des.setDuracion(duration);
		   }
		   
	   } catch (Exception e){
		   String mensaje = "Warning: No es posible recoger el tiempo típico de aprendizaje.";
		   logger.warn(mensaje);
		   
//		 Devuelve null
		   return des;
		   //throw e;
	   }
	   
	   return des;   
   }
   
   public void setTiempoTipicoAprendizajeAv(DuracionAgrega tiempoAprendizaje)throws java.lang.Exception {
	   TypicalLearningTime tiempoTA =null;
	   if (tiempoAprendizaje != null){
		   
		   String duracion = tiempoAprendizaje.getDuracion();
		   ArrayList lDescripciones = tiempoAprendizaje.getDescripciones();
		   
		   ComplexTypeDurationDuration ctdd =null;
		   if(duracion != null){
			   ctdd = new ComplexTypeDurationDuration();
			   ctdd.setContent(duracion);   
		   }
		   
		   ArrayList lDescrip = new ArrayList();
		   ComplexTypeDurationDescription ctdde =null;
		   if (lDescripciones != null){
			   
			   for (int i = 0; i < lDescripciones.size(); i++){
				   LangStringAgrega descripcion = (LangStringAgrega) lDescripciones.get(i);
				   String valor = descripcion.getValor();
				   String idioma = descripcion.getIdioma();
				   
				   es.pode.parseadorXML.castor.String s = new es.pode.parseadorXML.castor.String();
				   s.setContent(valor);
				   s.setLanguage(idioma);
				   
				   LanguageStringItem lang= new LanguageStringItem();
				   lang.setString(s);
				   lDescrip.add(lang); 
			   }  
			   ctdde = new ComplexTypeDurationDescription();
			   ctdde.setLanguageStringItem((LanguageStringItem[])lDescrip.toArray(new LanguageStringItem[lDescrip.size()]));
		   }
		   if(duracion != null || lDescripciones !=null){
			   GroupTypicalLearningTimeTypicalLearningTime gtlttlt = new GroupTypicalLearningTimeTypicalLearningTime();
			   
			   tiempoTA = new TypicalLearningTime();
			   
			   gtlttlt.setComplexTypeDurationDescription(ctdde);
			   gtlttlt.setComplexTypeDurationDuration(ctdd);
			   tiempoTA.setGroupTypicalLearningTimeTypicalLearningTime(gtlttlt);
		   }

	   }
	   educational.getGroupEducationalEducational().setTypicalLearningTime(tiempoTA);
   
   }
   
   public ArrayList getDescripcionesAv() throws java.lang.Exception {

	   	ArrayList l= new ArrayList();
	       
	    try{
	    	DescriptionUnbounded[] tar= educational.getGroupEducationalEducational().getDescriptionUnbounded();
	       	
	       	if ((tar != null)&&(tar.length>0)){
	       		for (int i= 0; i<tar.length; i++){
	       			
	       			LanguageStringItem[] lsi= educational.getGroupEducationalEducational().getDescriptionUnbounded(i).getGroupDescriptionUnboundedDescription().getLanguageStringItem();
		            
	       			if ((lsi != null) && (lsi.length>0)){
	    	    		int cont= 0;
	    				while (cont<lsi.length){
	    					LangStringAgrega lString=new LangStringAgrega();
	    					lString.setValor(lsi[cont].getString().getContent());
	    					lString.setIdioma(lsi[cont].getString().getLanguage());
	    					l.add(lString);
	    					cont++;
	    				}
	    			}
		       }
	       	}
	    }
	       catch (Exception e){
	       	String mensaje = "Warning: No es posible recoger las descripciones";
	       	logger.warn(mensaje);
			
			l= new ArrayList();
			return l;
			//throw e;
	       } 
	       return l;
	   }

   public void setDescripcionesAv(ArrayList lDescripciones ) throws java.lang.Exception {
	   if (lDescripciones != null && lDescripciones.size()>0){	   
		   ArrayList lDescrip = new ArrayList();

		   for (int i = 0; i < lDescripciones.size(); i++){
			   ArrayList lLangDescrip = new ArrayList();
			   GroupDescriptionUnboundedDescription gdud = new GroupDescriptionUnboundedDescription();
			   DescriptionUnbounded descripcion = new DescriptionUnbounded();
			   ArrayList lDesc = (ArrayList) lDescripciones.get(i);
			   for (int j = 0; j < lDesc.size(); j++){   
				   LangStringAgrega lsa = (LangStringAgrega) lDesc.get(j);
				   String valor = lsa.getValor();
				   String idioma = lsa.getIdioma();
				   
				   es.pode.parseadorXML.castor.String s = new es.pode.parseadorXML.castor.String();
				   s.setContent(valor);
				   s.setLanguage(idioma);
				   
				   LanguageStringItem lsi= new LanguageStringItem();
				   lsi.setString(s);
				   lLangDescrip.add(lsi);
				   
			   }
			   gdud.setLanguageStringItem((LanguageStringItem[])lLangDescrip.toArray(new LanguageStringItem[lLangDescrip.size()]));
			   descripcion.setGroupDescriptionUnboundedDescription(gdud);
			   lDescrip.add(descripcion);
		   }
		   educational.getGroupEducationalEducational().setDescriptionUnbounded((DescriptionUnbounded[])lDescrip.toArray(new DescriptionUnbounded[lDescrip.size()]));
	   }
   }
   
   public ArrayList getIdiomasDestinatarioAv() throws java.lang.Exception {
	   
	   ArrayList dList= new ArrayList();
	   dList=getIdiomasDestinatario();
	   return dList;
	   
   }
   
   public void setIdiomasDestinatarioAv(ArrayList lIdiomas) throws java.lang.Exception {
	   ArrayList lIdiom = new ArrayList();
	   if (lIdiomas != null && lIdiomas.size()>0){
		   		   
		   for (int i = 0; i < lIdiomas.size(); i++){
			   GroupLanguageLanguage gll = new GroupLanguageLanguage();
			   Language idioma = new Language();
			   
			   String sIdioma = (String) lIdiomas.get(i);

			   gll.setContent(sIdioma);
			   idioma.setGroupLanguageLanguage(gll);
			   lIdiom.add(idioma);
		   }
	   }
	   educational.getGroupEducationalEducational().setLanguage((Language[])lIdiom.toArray(new Language[lIdiom.size()]));
   }
   
   public ArrayList getProcesosCognitivosAv() throws java.lang.Exception {
	   
	   ArrayList dList= new ArrayList();
	   dList=getProcesosCognitivos();
	   return dList;
	   
   }
   
   public void setProcesosCognitivosAv(ArrayList lProcesosCognitivos) throws java.lang.Exception {
	   ArrayList lProcesosC = new ArrayList();
	   
	   if (lProcesosCognitivos != null && lProcesosCognitivos.size()>0){

		   String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		   
		   for (int i = 0; i < lProcesosCognitivos.size(); i++){
			   GroupCognitiveProcessCognitiveProcess gcpcp = new GroupCognitiveProcessCognitiveProcess();
			   ComplexTypeCognitiveProcessVocabValue ctcpvv = new ComplexTypeCognitiveProcessVocabValue();
			   ComplexTypeCognitiveProcessVocabSource ctcpvs = new ComplexTypeCognitiveProcessVocabSource();
			   CognitiveProcess pCognitivo = new CognitiveProcess();
			   
			   String sProcesoCog = (String) lProcesosCognitivos.get(i);
			   
			   ctcpvv.setContent(sProcesoCog);
			   ctcpvs.setContent(lomes);
			   gcpcp.setComplexTypeCognitiveProcessVocabSource(ctcpvs);
			   gcpcp.setComplexTypeCognitiveProcessVocabValue(ctcpvv);
			   pCognitivo.setGroupCognitiveProcessCognitiveProcess(gcpcp);
			   lProcesosC.add(pCognitivo);
		   }
	   }
	   educational.getGroupEducationalEducational().setCognitiveProcess((CognitiveProcess[])lProcesosC.toArray(new CognitiveProcess[lProcesosC.size()]));
   }
   
   public String getDificultadAv(){
	   String dificultad=null;
	   try{
		   Difficulty difi = educational.getGroupEducationalEducational().getDifficulty();
		   if(difi!=null){
			  dificultad= difi.getGroupDifficultyDifficulty().getComplexTypeDifficultyVocabValue().getContent();
		   }
	   } catch (Exception e){
	       	String mensaje = "Warning: No es posible recoger la dificultad";
	       	logger.warn(mensaje);
			
			dificultad=null;
			return dificultad;
			//throw e;
	       } 
	       return dificultad;
   }
   
   public void setDificultadAv(String dificultad) throws java.lang.Exception{
	   Difficulty dificul =null;
	   if (dificultad != null){
	
		   String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		   
		   GroupDifficultyDifficulty gdd = new GroupDifficultyDifficulty();
		   ComplexTypeDifficultyVocabValue ctdvv = new ComplexTypeDifficultyVocabValue();
		   ComplexTypeDifficultyVocabSource ctdvs = new ComplexTypeDifficultyVocabSource();
		   dificul = new Difficulty();
		   
		   ctdvv.setContent(dificultad);
		   ctdvs.setContent(lomes);
		   gdd.setComplexTypeDifficultyVocabSource(ctdvs);
		   gdd.setComplexTypeDifficultyVocabValue(ctdvv);
		   dificul.setGroupDifficultyDifficulty(gdd);
	
	   } 
	   educational.getGroupEducationalEducational().setDifficulty(dificul);
   }
}

/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 1.1</a>, using an XML
 * Schema.
 * $Id$
 */

package es.pode.parseadorXML.lomes.lomesAgrega;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.castor.Annotation;
import es.pode.parseadorXML.castor.Classification;
import es.pode.parseadorXML.castor.Educational;
import es.pode.parseadorXML.castor.General;
import es.pode.parseadorXML.castor.LifeCycle;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.castor.MetaMetadata;
import es.pode.parseadorXML.castor.Relation;
import es.pode.parseadorXML.castor.Rights;
import es.pode.parseadorXML.castor.Technical;

/**
 * Class Lom.
 * 
 * @version $Revision$ $Date$
 */
public class LomAgrega implements java.io.Serializable {
	
	private Lom lom = null;
	
	private Logger logger = Logger.getLogger(this.getClass());

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items.
     */
    //private java.util.List _items;
    

      //----------------/
     //- Constructors -/
    //----------------/

    public LomAgrega(Lom lom) {
        super();
        setLom(lom);
    }
    
//    public LomAgrega() {
//        super();
//        lom= new Lom();
//    }

      //-----------/
     //- Methods -/
    //-----------/
    
    /**
	 * @return the lom
	 */
	public Lom getLom() {
		return lom;
	}

	/**
	 * @param lom
	 *            the lom to set
	 */
	public void setLom(Lom lom) {
		this.lom = lom;
	}

    
    public GeneralAgrega getGeneralAgrega (
    ) throws ParseadorException {
    	
    	GeneralAgrega genAgrega= null;
    	
    	if (lom.getGeneral()!= null){
    		genAgrega= new GeneralAgrega(lom.getGeneral());
    	}
    	else{
    		General g= new General();
    		genAgrega= new GeneralAgrega(g);
    	}
    	
    	return genAgrega;
    }
    
//    public General getGeneral (
//    ) throws ParseadorException {
//    	
//    	return lom.getGeneral();
//    }
    	
    
    public void setGeneralAgrega (es.pode.parseadorXML.lomes.lomesAgrega.GeneralAgrega genAgrega
    ) throws java.lang.Exception {
    	
    	try{
    		lom.setGeneral(genAgrega.getGeneral());
    	}
    	catch (Exception e){
    		String mensaje = "Error: No es posible incluir General en Lom";
		    logger.error(mensaje);
		    throw e;
    	}	
    }
    
    public LifeCycleAgrega getLifeCycleAgrega (
    ) throws ParseadorException {
    	
    	LifeCycleAgrega lifAgrega= null;
    	
    	if (lom.getLifeCycle()!= null){
    		lifAgrega= new LifeCycleAgrega(lom.getLifeCycle());
    	}
    	else{
    		LifeCycle l= new LifeCycle();
    		lifAgrega= new LifeCycleAgrega(l);
    	}
    	
    	return lifAgrega;
    }
    
    public void setLifeCycleAgrega (es.pode.parseadorXML.lomes.lomesAgrega.LifeCycleAgrega lifAgrega
    ) throws java.lang.Exception {
    	
    	try{
    		lom.setLifeCycle(lifAgrega.getLifeCycle());
    	}
    	catch (Exception e){
    		String mensaje = "Error: No es posible incluir LifeCycle en Lom";
		    logger.error(mensaje);
		    throw e;
    	}	
    }
    
    public MetaMetadataAgrega getMetaMetadataAgrega (
    ) throws ParseadorException {
    	
    	MetaMetadataAgrega mmdAgrega= null;
    	
    	if (lom.getMetaMetadata()!= null){
    		mmdAgrega= new MetaMetadataAgrega(lom.getMetaMetadata());
    	}
    	else{
    		MetaMetadata m= new MetaMetadata();
    		mmdAgrega= new MetaMetadataAgrega(m);
    	}
    	
    	return mmdAgrega;
    }
    
    public void setMetaMetadataAgrega (es.pode.parseadorXML.lomes.lomesAgrega.MetaMetadataAgrega mmdAgrega
    ) throws java.lang.Exception {
    	
    	try{
    		lom.setMetaMetadata(mmdAgrega.getMetaMetadata());
    	}
    	catch (Exception e){
    		String mensaje = "Error: No es posible incluir LifeCycle en Lom";
		    logger.error(mensaje);
		    throw e;
    	}	
    }
    
    public TechnicalAgrega getTechnicalAgrega (
    ) throws ParseadorException {
    	
    	TechnicalAgrega tecAgrega= null;
    	
    	if (lom.getTechnical()!= null){
    		tecAgrega= new TechnicalAgrega(lom.getTechnical());
    	}
    	else{
    		Technical t= new Technical();
    		tecAgrega= new TechnicalAgrega(t);
    	}
    	
    	return tecAgrega;
    }
    
    public void setTechnicalAgrega (es.pode.parseadorXML.lomes.lomesAgrega.TechnicalAgrega tecAgrega
    ) throws java.lang.Exception {
    	
    	try{
    		lom.setTechnical(tecAgrega.getTechnical());
    	}
    	catch (Exception e){
    		String mensaje = "Error: No es posible incluir Technical en Lom";
		    logger.error(mensaje);
		    throw e;
    	}	
    }
    
    public EducationalAgrega getEducationalAgrega (int index
    ) throws java.lang.Exception {
    	
    	EducationalAgrega eduAgrega= null;
    	
    	if (lom.getEducational()!= null){
    		try{
    			eduAgrega= new EducationalAgrega(lom.getEducational(index));
    		} catch (Exception e){
    			String mensaje = "Error: No es posible recoger Educational en la posición: " +index;
    		    logger.error(mensaje);
    		    throw e;
    		}
    		
    	}
    	else{
    		Educational t= new Educational();
    		eduAgrega= new EducationalAgrega(t);
    	}
    	
    	return eduAgrega;
    }
    
    public ArrayList getEducationalsAgrega (
    ) throws java.lang.Exception {
    	
    	EducationalAgrega eduAgrega= null;
    	
    	ArrayList eduList= new ArrayList();
    	
    	if (lom.getEducational()!= null){
    		try{
    			for (int i= 0; i<lom.getEducational().length; i++){
        			eduAgrega= new EducationalAgrega(lom.getEducational(i));
        			eduList.add(eduAgrega);
        		}
    		} catch (Exception e){
    			String mensaje = "Error: No es posible recoger las categorías Educational";
    		    logger.error(mensaje);
    		    throw e;
    		}
    		
    		
    	}
    	else{
    		Educational t= new Educational();
    		eduAgrega= new EducationalAgrega(t);
    		eduList.add(eduAgrega);
    	}
    	
    	return eduList;
    }
    

    public void setEducationalsAgrega (EducationalAgrega[] eduAgrega
    ) throws java.lang.Exception {
    	
    	ArrayList educationalList= new ArrayList();
    	
    	for (int i= 0; i<eduAgrega.length; i++){
    		educationalList.add(eduAgrega[i].getEducational());
    	}
    	
    	try{
    		lom.setEducational((Educational[])educationalList.toArray(new Educational[educationalList.size()]));
    	}
    	catch (Exception e){
    		String mensaje = "Error: No es posible incluir el array de Educationals en Lom";
		    logger.error(mensaje);
		    throw e;
    	}
    	
    }
    
    public void addEducationalAgrega (es.pode.parseadorXML.lomes.lomesAgrega.EducationalAgrega eduAgrega
    ) throws java.lang.Exception {
    	
    	try{
    		lom.addEducational(eduAgrega.getEducational());
    	}
    	catch (Exception e){
    		String mensaje = "Error: No es posible incluir Educational en Lom";
		    logger.error(mensaje);
		    throw e;
    	}	
    }
    
    public void removeEducationalAgrega (int index
    ) throws java.lang.Exception {
    	
    	try{
    		lom.removeEducationalAt(index);
        	
    	}
    	catch (Exception e){
    		String mensaje = "Error: No es posible eliminar Educational en la posición: " +index;
		    logger.error(mensaje);
		    throw e;
    	}

    }
    
    public RightsAgrega getRightsAgrega (
    ) throws ParseadorException {
    	
    	RightsAgrega rigAgrega= null;
    	
    	if (lom.getRights()!= null){
    		rigAgrega= new RightsAgrega(lom.getRights());
    	}
    	else{
    		Rights r= new Rights();
    		rigAgrega= new RightsAgrega(r);
    	}
    	
    	return rigAgrega;
    }
    
    public void setRightsAgrega (es.pode.parseadorXML.lomes.lomesAgrega.RightsAgrega rigAgrega
    ) throws java.lang.Exception {
    	
    	try{
    		lom.setRights(rigAgrega.getRights());
    	}
    	catch (Exception e){
    		String mensaje = "Error: No es posible incluir Rights en Lom";
		    logger.error(mensaje);
		    throw e;
    	}	
    }
    
    public ClassificationAgrega getClassificationAgrega (int index
    ) throws java.lang.Exception {
    	
    	ClassificationAgrega claAgrega= null;
    	
    	if (lom.getClassification()!= null){
    		try{
    			claAgrega= new ClassificationAgrega(lom.getClassification(index));
    		} catch (Exception e){
    			String mensaje = "Error: No es posible recoger Classification en la posición: " +index;
    		    logger.error(mensaje);
    		    throw e;
    		}
    		
    	}
    	else{
    		Classification c= new Classification();
    		claAgrega= new ClassificationAgrega(c);
    	}
    	
    	return claAgrega;
    }
    
    public ArrayList getClassificationsAgrega (
    ) throws java.lang.Exception {
    	
    	ClassificationAgrega claAgrega= null;
    	
    	ArrayList claList= new ArrayList();
    	
    	if (lom.getClassification()!= null){
    		try{
    			for (int i= 0; i<lom.getClassification().length; i++){
        			claAgrega= new ClassificationAgrega(lom.getClassification(i));
        			claList.add(claAgrega);
        		}
    		} catch (Exception e){
    			String mensaje = "Error: No es posible recoger las categorías Classification";
    		    logger.error(mensaje);
    		    throw e;
    		}
    		
    		
    	}
    	else{
    		Classification c= new Classification();
    		claAgrega= new ClassificationAgrega(c);
    		claList.add(claAgrega);
    	}
    	
    	return claList;
    }
    
    
    public void setClassificationsAgrega (ClassificationAgrega[] clasAgrega
    ) throws java.lang.Exception {
    	
    	ArrayList classificationList= new ArrayList();
    	
    	for (int i= 0; i<clasAgrega.length; i++){
    		classificationList.add(clasAgrega[i].getClassification());
    	}
    	
    	try{
    		lom.setClassification((Classification[])classificationList.toArray(new Classification[classificationList.size()]));
    	}
    	catch (Exception e){
    		String mensaje = "Error: No es posible incluir el array de Classifications en Lom";
		    logger.error(mensaje);
		    throw e;
    	}
    	
    }

    
    public void addClassificationAgrega (es.pode.parseadorXML.lomes.lomesAgrega.ClassificationAgrega claAgrega
    ) throws java.lang.Exception {
    	
    	try{
    		lom.addClassification(claAgrega.getClassification());
    	}
    	catch (Exception e){
    		String mensaje = "Error: No es posible incluir Classification en Lom";
		    logger.error(mensaje);
		    throw e;
    	}	
    }
    
    public void removeClassificationAgrega (int index
    ) throws java.lang.Exception {
    	
    	try{
    		lom.removeClassificationAt(index);
        	
    	}
    	catch (Exception e){
    		String mensaje = "Error: No es posible eliminar Classification en la posición: " +index;
		    logger.error(mensaje);
		    throw e;
    	}

    }
    
    public RelationAgrega getRelationAgrega (int index
    ) throws java.lang.Exception {
    	
    	RelationAgrega reAgrega= null;
    	
    	if (lom.getRelation()!= null){
    		try{
    			reAgrega= new RelationAgrega(lom.getRelation(index));
    		} catch (Exception e){
    			String mensaje = "Error: No es posible recoger Relation en la posición: " +index;
    		    logger.error(mensaje);
    		    throw e;
    		}
    		
    	}
    	else{
    		Relation r= new Relation();
    		reAgrega= new RelationAgrega(r);
    	}
    	
    	return reAgrega;
    }
    
    public ArrayList getRelationsAgrega (
    ) throws java.lang.Exception {
    	
    	RelationAgrega reAgrega= null;
    	
    	ArrayList reList= new ArrayList();
    	
    	if (lom.getRelation()!= null){
    		try{
    			for (int i= 0; i<lom.getRelation().length; i++){
        			reAgrega= new RelationAgrega(lom.getRelation(i));
        			reList.add(reAgrega);
        		}
    		} catch (Exception e){
    			String mensaje = "Error: No es posible recoger las categorías Relation";
    		    logger.error(mensaje);
    		    throw e;
    		}
    		
    		
    	}
    	else{
    		Relation c= new Relation();
    		reAgrega= new RelationAgrega(c);
    		reList.add(reAgrega);
    	}
    	
    	return reList;
    }

    public void setRelationsAgrega (RelationAgrega[] relaAgrega
    ) throws java.lang.Exception {
    	
    	ArrayList relationList= new ArrayList();
    	
    	for (int i= 0; i<relaAgrega.length; i++){
    		relationList.add(relaAgrega[i].getRelation());
    	}
    	
    	try{
    		lom.setRelation((Relation[])relationList.toArray(new Relation[relationList.size()]));
    	}
    	catch (Exception e){
    		String mensaje = "Error: No es posible incluir el array de Relations en Lom";
		    logger.error(mensaje);
		    throw e;
    	}
    	
    }
    
    public AnnotationAgrega getAnnotationAgrega (int index
    ) throws java.lang.Exception {
    	
    	AnnotationAgrega anAgrega= null;
    	
    	if (lom.getAnnotation()!= null){
    		try{
    			anAgrega= new AnnotationAgrega(lom.getAnnotation(index));
    		} catch (Exception e){
    			String mensaje = "Error: No es posible recoger Anotación en la posición: " +index;
    		    logger.error(mensaje);
    		    throw e;
    		}
    		
    	}
    	else{
    		Annotation a= new Annotation();
    		anAgrega= new AnnotationAgrega(a);
    	}
    	
    	return anAgrega;
    }
    
    public ArrayList getAnnotationsAgrega (
    ) throws java.lang.Exception {
    	
    	AnnotationAgrega anAgrega= null;
    	
    	ArrayList anList= new ArrayList();
    	
    	if (lom.getAnnotation()!= null){
    		try{
    			for (int i= 0; i<lom.getAnnotation().length; i++){
        			anAgrega= new AnnotationAgrega(lom.getAnnotation(i));
        			anList.add(anAgrega);
        		}
    		} catch (Exception e){
    			String mensaje = "Error: No es posible recoger las categorías Annotation";
    		    logger.error(mensaje);
    		    throw e;
    		}
    		
    		
    	}
    	else{
    		Annotation c= new Annotation();
    		anAgrega= new AnnotationAgrega(c);
    		anList.add(anAgrega);
    	}
    	
    	return anList;
    }
    
    public void setAnnotationsAgrega (AnnotationAgrega[] annotaAgrega
    ) throws java.lang.Exception {
    	
    	ArrayList annotationList= new ArrayList();
    	
    	for (int i= 0; i<annotaAgrega.length; i++){
    		annotationList.add(annotaAgrega[i].getAnnotation());
    	}
    	
    	try{
    		lom.setAnnotation((Annotation[])annotationList.toArray(new Annotation[annotationList.size()]));
    	}
    	catch (Exception e){
    		String mensaje = "Error: No es posible incluir el array de Annotations en Lom";
		    logger.error(mensaje);
		    throw e;
    	}
    	
    }
}

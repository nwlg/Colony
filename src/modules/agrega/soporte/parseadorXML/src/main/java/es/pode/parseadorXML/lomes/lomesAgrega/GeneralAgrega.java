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
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.parseadorXML.castor.AggregationLevel;
import es.pode.parseadorXML.castor.Catalog;
import es.pode.parseadorXML.castor.ComplexTypeAggregationLevelVocabSource;
import es.pode.parseadorXML.castor.ComplexTypeAggregationLevelVocabValue;
import es.pode.parseadorXML.castor.ComplexTypeStructureVocabSource;
import es.pode.parseadorXML.castor.ComplexTypeStructureVocabValue;
import es.pode.parseadorXML.castor.Coverage;
import es.pode.parseadorXML.castor.DescriptionUnbounded;
import es.pode.parseadorXML.castor.Entry;
import es.pode.parseadorXML.castor.General;
import es.pode.parseadorXML.castor.GroupAggregationLevelAggregationLevel;
import es.pode.parseadorXML.castor.GroupCatalogCatalog;
import es.pode.parseadorXML.castor.GroupCoverageCoverage;
import es.pode.parseadorXML.castor.GroupDescriptionUnboundedDescription;
import es.pode.parseadorXML.castor.GroupEntryEntry;
import es.pode.parseadorXML.castor.GroupGeneralGeneral;
import es.pode.parseadorXML.castor.GroupIdentifierIdentifier;
import es.pode.parseadorXML.castor.GroupKeywordKeyword;
import es.pode.parseadorXML.castor.GroupLanguageLanguage;
import es.pode.parseadorXML.castor.GroupStructureStructure;
import es.pode.parseadorXML.castor.GroupTitleTitle;
import es.pode.parseadorXML.castor.Identifier;
import es.pode.parseadorXML.castor.Keyword;
import es.pode.parseadorXML.castor.Language;
import es.pode.parseadorXML.castor.LanguageStringItem;
import es.pode.parseadorXML.castor.Structure;
import es.pode.parseadorXML.castor.Title;


/**
 * Class General.
 * 
 * @version $Revision$ $Date$
 */
public class GeneralAgrega implements java.io.Serializable {

	private General general = null;
	
	private Logger logger = Logger.getLogger(this.getClass());
      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _groupGeneralGeneral.
     */
    //private es.pode.parseadorXML.lomes.GroupGeneralGeneral _groupGeneralGeneral;
    
    /**
     * Campos LOM-ES propios
     */


      //----------------/
     //- Constructors -/
    //----------------/

	
    public GeneralAgrega(General general) {
        super();
        
        if (general.getGroupGeneralGeneral()== null){
        	general.setGroupGeneralGeneral(new GroupGeneralGeneral());
        }
        
        setGeneral(general);

    }
    


      //-----------/
     //- Methods -/
    //-----------/

    public General getGeneral() {
		return general;
	}
    
    public void setGeneral(General general) {
		this.general = general;
	}
    
    /*****/

    
    // metodo que devuelve el título de un ODE en el idioma especificado.
    // si no se encuentra el título en el idioma requerido, se devuelve el primer título que tenga el ODE
    
    public ArrayList getTitulos (
    ) throws java.lang.Exception {
    	
    	ArrayList l= new ArrayList();
    	LanguageStringItem[] lsi= null;
    	
    	// se recoge el título en todos los idiomas disponibles en el metadato
    	
    	try{
	    	lsi= general.getGroupGeneralGeneral().getTitle().getGroupTitleTitle().getLanguageStringItem();
	    	
	    	if ((lsi!= null) && (lsi.length>0)){
	    		for (int i= 0; i<lsi.length; i++){
		    		l.add(lsi[i].getString().getContent());
		    	}
	    	}

    	} catch (Exception e){
    		String mensaje = "Warning: No es posible recoger el título.";
    		logger.warn(mensaje);
		    
		    l= new ArrayList();
		    return l;
		    //throw e;
    	}
  		return l;
    }
    
//  metodo que devuelve todos los títulos de un ODE, independientemente del idioma en el que se encuentren.
    public java.lang.String getTitulo (java.lang.String idioma
    ) throws java.lang.Exception {

    	java.lang.String tString= null;
    	LanguageStringItem[] lsi= null;
    	
    	// se recoge el título en todos los idiomas disponibles en el metadato
    	
    	try{
	    	lsi= general.getGroupGeneralGeneral().getTitle().getGroupTitleTitle().getLanguageStringItem();
	    	
	    	if ((lsi != null) && (lsi.length>0)){
				if (idioma!=null) {
					int cont = 0;
					boolean idiEncontrado = false;
					while ((cont < lsi.length) && (idiEncontrado == false)) {
						if (idioma.equals(lsi[cont].getString().getLanguage())) {
							idiEncontrado = true;
						} else {
							cont++;
						}
					}
					if ((idiEncontrado) && (cont < lsi.length)) {
						tString = lsi[cont].getString().getContent();
					}
					//si no encuentra el idioma buscado, devuelve el primero por defecto
					else {
						tString = lsi[0].getString().getContent();
					}
				} else  {
					tString = lsi[0].getString().getContent();
				}
	    	}
    	} catch (Exception e){
    		String mensaje = "Warning: No es posible recoger el título.";
    		logger.warn(mensaje);
		    
		    tString= null;
		    return tString;
		    //throw e;
    	}
  		return tString;
    }
    
    // método que introduce un título en el idioma especificado como parámetro.
    // Si ya existe un título en el idioma indicado, lo sobreescribe, si no lo añade.
    public void setTitulo(
            java.lang.String titulo, java.lang.String idioma)
    throws java.lang.Exception {
        
        try{
        	if (general.getGroupGeneralGeneral().getTitle()!=null){
        		if(titulo!=null && !titulo.equals("")){
					LanguageStringItem lsi= new LanguageStringItem();
					es.pode.parseadorXML.castor.String s= new es.pode.parseadorXML.castor.String();
		    		s.setContent(titulo);
		    		s.setLanguage(idioma);
		    		lsi.setString(s);
		    		Title auxTitulo = new Title(); 
		    		GroupTitleTitle grupoTitulo = new GroupTitleTitle();
		    		LanguageStringItem[] arrayLSI = new LanguageStringItem[1];
		    		arrayLSI[0]=lsi;
		    		grupoTitulo.setLanguageStringItem(arrayLSI);
		    		auxTitulo.setGroupTitleTitle(grupoTitulo);
		    		general.getGroupGeneralGeneral().setTitle(auxTitulo);
        		}
        		else{
        			general.getGroupGeneralGeneral().setTitle(null);
        		}
        		
        	}
        	else{ 
        		if(titulo!=null && !titulo.equals(""))
        			this.addTituloIdioma(idioma, titulo);
        	}
        	
//        	if (general.getGroupGeneralGeneral().getTitle()!=null){
//        		boolean encontrado= false;
//        		int i= 0;
//        		while ((!encontrado) && (i<general.getGroupGeneralGeneral().getTitle().getGroupTitleTitle().getLanguageStringItemCount())){
//        			if (idioma.equals(general.getGroupGeneralGeneral().getTitle().getGroupTitleTitle().getLanguageStringItem(i).getString().getLanguage())){
//        				encontrado = true;
//        			}
//        			else
//        				i++;
//        		}
//        		
//        		if (encontrado){
//        			general.getGroupGeneralGeneral().getTitle().getGroupTitleTitle().getLanguageStringItem(i).getString().setContent(titulo);
//        		}
//        		else{
//        			LanguageStringItem lsi= new LanguageStringItem();
//        			es.pode.parseadorXML.castor.String s= new es.pode.parseadorXML.castor.String();
//            		s.setContent(titulo);
//            		s.setLanguage(idioma);
//            		lsi.setString(s);
//            		general.getGroupGeneralGeneral().getTitle().getGroupTitleTitle().addLanguageStringItem(lsi);
//        		}	
//        	}
//        	else{
//        		this.addTituloIdioma(idioma, titulo);
//        	}
        		
        }
        catch (Exception e){
        	String mensaje = "Error: No es posible insertar el titulo en el idioma "+ idioma;
		    logger.error(mensaje);
		    throw e;
        } 
    }
    
    // metodo que introduce el título de un ODE en el idioma indicado
    
    public void addTituloIdioma(
            java.lang.String idioma, final java.lang.String tit) 
    throws java.lang.Exception{

        
        Title t= new Title();
        GroupTitleTitle gtt= new GroupTitleTitle();
        LanguageStringItem lsi= new LanguageStringItem();
        es.pode.parseadorXML.castor.String s = new es.pode.parseadorXML.castor.String();
        
        s.setContent(tit);
        s.setLanguage(idioma);
        lsi.setString(s);
        gtt.addLanguageStringItem(lsi);
	    t.setGroupTitleTitle(gtt);
        
	    // si no existe la categoría General, se crea
	    if (general == null){
	    	general= new General();
	    }
	    
	    if (general.getGroupGeneralGeneral() == null){
	    	GroupGeneralGeneral gggAux= new GroupGeneralGeneral();
	    	general.setGroupGeneralGeneral(gggAux);
	    	general.getGroupGeneralGeneral().setTitle(t);
	    }
	    else{
	    	if (general.getGroupGeneralGeneral().getTitle() == null){
	    		general.getGroupGeneralGeneral().setTitle(t);
	    	}
	    	else{
	    		try{
	    			general.getGroupGeneralGeneral().getTitle().getGroupTitleTitle().addLanguageStringItem(lsi);
	    		}
	    		catch (Exception e) { 
	    			String mensaje = "Error: No es posible incluir el título en ese idioma";
				    logger.error(mensaje);
				    throw e;
				}
	    			
	    	}  		
	    }
    }
    
    // método que recoge todos los idiomas especificados en la categoría General de LOM-ES
    public List getIdiomas()
    throws java.lang.Exception {
    	
    	List l= new ArrayList();
    	
    	try{
    		l= Arrays.asList(general.getGroupGeneralGeneral().getLanguage());
    	}
    	catch (Exception e){
    		String mensaje = "Warning: No es posible recoger los idiomas";
    		logger.warn(mensaje);
		    
		    l= new ArrayList();
		    return l;
		    //throw e;
    	}
    	
    	return l;     
    }
    
    // método que recoge el idioma en la posición especificada en el parámetro index
    public java.lang.String getIdioma(
            final int index)
    throws java.lang.Exception {
    	
        java.lang.String lString= null;
        
        try{
        	lString= general.getGroupGeneralGeneral().getLanguage(index).getGroupLanguageLanguage().getContent();
        }
        catch (Exception e){
        	String mensaje = "Warning: No es posible recoger el idioma de la posición "+ index;
        	logger.warn(mensaje);
		    
//		  Devuelve null
			   return lString;
		    //throw e;
        }
        
        return lString;
        
    }
    
    // método que introduce un idioma en la posibión indicada en el parámetro.
    // Si la posición indicada no existe, el idioma se añade al final de la lista de idiomas
    //  el idioma introducido debe ser un código de 2 letras ISO 639-1988
    public void setIdioma(
            final int index, java.lang.String idioma)
    throws java.lang.Exception {
        
	        try{
	           	if ((general.getGroupGeneralGeneral().getLanguage().length>0) && (index<general.getGroupGeneralGeneral().getLanguage().length)){
	           		if(idioma != null && !idioma.equals("")){
	           			Language[] auxArrayIdioma=new Language[1];
	           			Language idiomaAux = new Language();
	           			GroupLanguageLanguage grupoIdioma = new GroupLanguageLanguage();
	           			grupoIdioma.setContent(idioma);
	           			idiomaAux.setGroupLanguageLanguage(grupoIdioma);
	           			auxArrayIdioma[0]=idiomaAux;
	           			general.getGroupGeneralGeneral().setLanguage(auxArrayIdioma);
	        		}
	           		else{
	           			general.getGroupGeneralGeneral().setLanguage(new Language[0]);
	           		}
	           	//	educational.getGroupEducationalEducational().getLanguage(index).getGroupLanguageLanguage().setContent(idiomaDest);
	           	}
	           	else{
	           		if(idioma != null && !idioma.equals(""))
	           			this.addIdioma(idioma);
	           	}
	        	
//	        	if ((general.getGroupGeneralGeneral().getLanguage().length>0) && (index<general.getGroupGeneralGeneral().getLanguage().length)){
//	        		general.getGroupGeneralGeneral().getLanguage(index).getGroupLanguageLanguage().setContent(idioma);
//	        	}
//	        	else{
//	        		this.addIdioma(idioma);
//	        	}
	        	
	        }
	        catch (Exception e){
	        	String mensaje = "Error: No es posible insertar el idioma en la posición "+ index;
			    logger.error(mensaje);
			    throw e;
	        } 
    }
    
    // método que inserta un idioma en la categoría General de LOM-ES
    // el idioma introducido debe ser un código de 2 letras ISO 639-1988
    public void addIdioma(java.lang.String idi)
    throws java.lang.Exception {

	    	Language l= new Language();
			GroupLanguageLanguage gll= new GroupLanguageLanguage();
	    
			gll.setContent(idi);
			l.setGroupLanguageLanguage(gll);
			
			if (general == null){
		    	general= new General();
		    }
		    
		    if (general.getGroupGeneralGeneral() == null){
		    	GroupGeneralGeneral gggAux= new GroupGeneralGeneral();
		    	general.setGroupGeneralGeneral(gggAux);
		    }
	
		    general.getGroupGeneralGeneral().addLanguage(l);
    	
    }
    
    // método que recoge la descripción en un idioma concreto en la posición especificada en el parámetro
    // si la descripción en la posición indicada no existe en el idioma deseado, 
    // se devuelve la descripción de esa posición que aparezca en el primer idioma
    public java.lang.String getDescripcion (int indexDescripcion, java.lang.String idioma
    ) throws java.lang.Exception {

    	java.lang.String lString= null;
        
        try{
        	LanguageStringItem lsi[]= general.getGroupGeneralGeneral().getDescriptionUnbounded(indexDescripcion).getGroupDescriptionUnboundedDescription().getLanguageStringItem();
        	
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
        	String mensaje = "Warning: No es posible recoger la descripción de la posición "+ indexDescripcion;
        	logger.warn(mensaje);
		    
		    lString= null;
//		  Devuelve null
			   return lString;
		    //throw e;
        }
        return lString;
    }
    
    // método que introduce una descripción en la posición indicada en el parámetro.
    // si la posición no existe, la descripción se añade al final de la lista.
    public void setDescripcion(
            final int index, java.lang.String desc, java.lang.String idioma)
    throws java.lang.Exception {
        
        try{
        	if ((general.getGroupGeneralGeneral().getDescriptionUnbounded().length>0) && (index<general.getGroupGeneralGeneral().getDescriptionUnbounded().length)){
        		if(desc!=null && !desc.equals("")){
	        		LanguageStringItem lsi= new LanguageStringItem();
	        		es.pode.parseadorXML.castor.String s= new es.pode.parseadorXML.castor.String();
	        		s.setContent(desc);
	        		s.setLanguage(idioma);
	        		lsi.setString(s);
	        		DescriptionUnbounded[] descripciones = new DescriptionUnbounded[1];
	        		DescriptionUnbounded descripcion = new DescriptionUnbounded();
	        		LanguageStringItem[] arrayLSI = new LanguageStringItem[1];
	        		GroupDescriptionUnboundedDescription grupoDesc = new GroupDescriptionUnboundedDescription();
	        		arrayLSI[0]=lsi;
	        		grupoDesc.setLanguageStringItem(arrayLSI);
	        		descripcion.setGroupDescriptionUnboundedDescription(grupoDesc);
	        		descripciones[0]=descripcion;
	        		//general.getGroupGeneralGeneral().getDescriptionUnbounded(index).getGroupDescriptionUnboundedDescription().addLanguageStringItem(0, lsi);
	        		general.getGroupGeneralGeneral().setDescriptionUnbounded(descripciones);
        		}
        		else{
        			general.getGroupGeneralGeneral().setDescriptionUnbounded(new DescriptionUnbounded[0]);
        		}
        	}
        	else{
        		if(desc!=null && !desc.equals(""))
        			this.addDescripcion(desc, idioma);
        	}
        	
//        	if ((general.getGroupGeneralGeneral().getDescriptionUnbounded().length>0) && (index<general.getGroupGeneralGeneral().getDescriptionUnbounded().length)){
//        		LanguageStringItem lsi= new LanguageStringItem();
//        		es.pode.parseadorXML.castor.String s= new es.pode.parseadorXML.castor.String();
//        		s.setContent(desc);
//        		s.setLanguage(idioma);
//        		lsi.setString(s);
//        		//general.getGroupGeneralGeneral().getDescriptionUnbounded(index).getGroupDescriptionUnboundedDescription().addLanguageStringItem(0, lsi);
//        		general.getGroupGeneralGeneral().getDescriptionUnbounded(index).getGroupDescriptionUnboundedDescription().setLanguageStringItem(0, lsi);
//        	}
//        	else{
//        		this.addDescripcion(desc, idioma);
//        	}
        	
        }
        catch (Exception e){
        	String mensaje = "Error: No es posible insertar la descripción en la posición "+ index;
		    logger.error(mensaje);
		    throw e;
        }
        
    }
    
    
    // método que recoge todas las descripciones de un ODE de la categoría General en el idioma especificado
    public ArrayList getDescripcionesIdioma (java.lang.String idioma
    ) throws java.lang.Exception {

    	ArrayList l= new ArrayList();
        
        try{
        	DescriptionUnbounded[] du= general.getGroupGeneralGeneral().getDescriptionUnbounded();
        	
        	if (du != null){
	        	for (int i= 0; i<du.length; i++){
	        		
	        		LanguageStringItem[] lsi= general.getGroupGeneralGeneral().getDescriptionUnbounded(i).getGroupDescriptionUnboundedDescription().getLanguageStringItem();
	            	
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
        	String mensaje = "Warning: No es posible recoger las descripciones";
        	logger.warn(mensaje);
		    
		    l= new ArrayList();
		    return l;
		    //throw e;
        } 
        return l;
    }
    
    // método que recoge todas las descripciones en todos los idiomas
    public ArrayList getDescripciones (
    ) throws java.lang.Exception {

    	ArrayList l= new ArrayList();
        
        try{
        	DescriptionUnbounded[] du= general.getGroupGeneralGeneral().getDescriptionUnbounded();
        	
        	if (du != null)
        	for (int i= 0; i<du.length; i++){
        		
        		LanguageStringItem[] lsi= general.getGroupGeneralGeneral().getDescriptionUnbounded(i).getGroupDescriptionUnboundedDescription().getLanguageStringItem();
            	
            	if ((lsi != null) && (lsi.length>0)){
    	    		int cont= 0;
    				while (cont<lsi.length){
    					l.add(lsi[cont].getString().getContent());
    					cont++;
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
    
    // método que introduce una descripción en la categoría General en el idioma indicado en el parámetro
    public void addDescripcion(java.lang.String des, java.lang.String idioma ) 
    throws java.lang.IndexOutOfBoundsException{
  
    		DescriptionUnbounded d= new DescriptionUnbounded();
    		GroupDescriptionUnboundedDescription gdud= new GroupDescriptionUnboundedDescription();
    		LanguageStringItem lsi= new LanguageStringItem();
    		es.pode.parseadorXML.castor.String s= new es.pode.parseadorXML.castor.String();
    		
    		s.setContent(des);
    		s.setLanguage(idioma);
    		lsi.setString(s);
    		gdud.addLanguageStringItem(lsi);
    		d.setGroupDescriptionUnboundedDescription(gdud);
    		
    		if (general == null){
		    	general= new General();
		    }
		    
		    if (general.getGroupGeneralGeneral() == null){
		    	GroupGeneralGeneral gggAux= new GroupGeneralGeneral();
		    	general.setGroupGeneralGeneral(gggAux);
		    }
	
		    general.getGroupGeneralGeneral().addDescriptionUnbounded(d);
    }
    
//  metodo para escribir el identificador MEC en la primera posición
    public void setIdentificadorMEC(
    		 java.lang.String cat, java.lang.String ent ) 
    throws java.lang.Exception{
    	
    	java.util.List idList= new java.util.ArrayList();
    	
    	if (general == null){
	    	general= new General();
	    }
	    
	    if (general.getGroupGeneralGeneral() == null){
	    	GroupGeneralGeneral gggAux= new GroupGeneralGeneral();
	    	general.setGroupGeneralGeneral(gggAux);
	    }
	    
	    Identifier i= new Identifier();
		GroupIdentifierIdentifier gii= new GroupIdentifierIdentifier();
		Catalog c= new Catalog();
		GroupCatalogCatalog gcc= new GroupCatalogCatalog();
		Entry e= new Entry();
		GroupEntryEntry gee= new GroupEntryEntry();
		
		gcc.setContent(cat);
		c.setGroupCatalogCatalog(gcc);
		gee.setContent(ent);
		e.setGroupEntryEntry(gee);

		gii.setCatalog(c);
		gii.setEntry(e);
		
		i.setGroupIdentifierIdentifier(gii);
		
		idList.add((Identifier) i);
		
	    Identifier[] id= general.getGroupGeneralGeneral().getIdentifier();
	    
	    if (id.length > 0){
	    	for (int cont= 0; cont<id.length; cont++){
	    		idList.add((Identifier)id[cont]);
	    	}
	    } 
	    general.getGroupGeneralGeneral().setIdentifier((Identifier[])idList.toArray(new Identifier[idList.size()]));
	    
    }
    
    // método que recoge el identificador que ocupa la posición indicada en el parámetro
    public Identifier getIdentificador (int index
    ) throws java.lang.Exception {
    	
    	Identifier i= null;
    	
    	try{
    		i= general.getGroupGeneralGeneral().getIdentifier(index);
    	}catch (Exception e){
    		String mensaje = "Warning: No es posible recoger el identificador en la posición: " +index;
    		logger.warn(mensaje);
		    
		    return i;
		    //throw e;
    	}
    	return i;
    	
    }
    
//  metodo para recoger el identificador que se encuentra en la primera posición
    public String getPrimerIdentificador (
    ) throws java.lang.Exception {
    	
    	java.lang.String id= null;
    	
    	try{
    		Identifier i= general.getGroupGeneralGeneral().getIdentifier(0);
    		
    		id= i.getGroupIdentifierIdentifier().getEntry().getGroupEntryEntry().getContent();
    		
    	}catch (Exception e){
    		String mensaje = "Warning: No es posible recoger el primer identificador";
    		logger.warn(mensaje);
		    
		    id= null;
		    return id;
		    //throw e;
    	}
    	return id;
    }
   
   // método que recoge el catálogo correspondiente al identificador en la posición indicada por el parámetro
   public java.lang.String getCatalogo (int index
    ) throws java.lang.Exception {

    	java.lang.String c= null;
    	
    	try{
    		c= general.getGroupGeneralGeneral().getIdentifier(index).getGroupIdentifierIdentifier().getCatalog().getGroupCatalogCatalog().getContent();

    	}catch (Exception e){
    		String mensaje = "Warning: No es posible recoger el catálogo de la posición: " +index;
    		logger.warn(mensaje);
		    
//		  Devuelve null
			   return c;
		    //throw e;
    	}
    	return c;
    }
   
// método que recoge el entry correspondiente al identificador en la posición indicada por el parámetro
   public java.lang.String getEntry (int index
   ) throws java.lang.Exception {
	   
	   java.lang.String en= null;
   	
	   	try{
	   		en= general.getGroupGeneralGeneral().getIdentifier(index).getGroupIdentifierIdentifier().getEntry().getGroupEntryEntry().getContent();
	
	   	}catch (Exception e){
	   		String mensaje = "Warning: No es posible recoger el catálogo de la posición: " +index;
	   		logger.warn(mensaje);
			    
//			  Devuelve null
				   return en;
			    //throw e;
	   	}
	   	return en;
   }
   
   //método que recoge el nivel de agregación
   public java.lang.String getNivelDeAgregacion (
   ) throws java.lang.Exception {
	   
	   java.lang.String lString= null;
       
       try{
       	lString= general.getGroupGeneralGeneral().getAggregationLevel().getGroupAggregationLevelAggregationLevel().getComplexTypeAggregationLevelVocabValue().getContent();
       }
       catch (Exception e){
    	   String mensaje = "Warning: No es posible recoger el nivel de agregación";
    	   logger.warn(mensaje);
		   
		   lString= null;
		   return lString;
		   //throw e;
       }
       
       return lString;
   }
   
   //método que introduce en la categoría General el nivel de agregación del ODE.
   public void setNivelDeAgregacion(java.lang.String agregacion)
   throws java.lang.Exception {
	   
	   String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
	  
	   AggregationLevel al= new AggregationLevel();
	   GroupAggregationLevelAggregationLevel gal= new GroupAggregationLevelAggregationLevel();
	   ComplexTypeAggregationLevelVocabSource ctalvs= new ComplexTypeAggregationLevelVocabSource();
	   ComplexTypeAggregationLevelVocabValue ctalvv= new ComplexTypeAggregationLevelVocabValue();

	   ctalvs.setContent(lomes);
	   ctalvv.setContent(agregacion);
	   gal.setComplexTypeAggregationLevelVocabSource(ctalvs);
	   gal.setComplexTypeAggregationLevelVocabValue(ctalvv);
	   al.setGroupAggregationLevelAggregationLevel(gal);
	   
	   if (general == null){
	    	general= new General();
	    }
	    
	    if (general.getGroupGeneralGeneral() == null){
	    	GroupGeneralGeneral gggAux= new GroupGeneralGeneral();
	    	general.setGroupGeneralGeneral(gggAux);
	    }
	    
	    general.getGroupGeneralGeneral().setAggregationLevel(al);
	    
   }
   
   // método que indica si General tiene al menos un identificador
   public boolean hasIdentifier() throws java.lang.Exception{
   	
   	boolean encontrado= false;
   	Identifier[] ide= null;
   	
   	try{
   		ide= general.getGroupGeneralGeneral().getIdentifier();
   		if ((ide!=null) && (ide.length>0)){
   			encontrado= true;
   		}
   	} catch (Exception e){
   		String mensaje = "Warning: No es posible recoger el nivel de agregación";
		logger.error(mensaje);
		
		encontrado= false;
		return encontrado;
		//throw e;
   	}
   	
   	return encontrado;
   
   }
   
   // método que devuelve el número de identificadores que tiene la categoría General
   public int getCountIdentifier()throws java.lang.Exception
   {
	   int nIds= 0;
	   try{
		    Identifier[] ide= general.getGroupGeneralGeneral().getIdentifier();
	   		if (ide!=null){
	   			nIds= ide.length;
	   		}
	   	} catch (Exception e){
	   		String mensaje = "Warning: No es posible recoger el nivel de agregación";
	   		logger.warn(mensaje);
			
			nIds= 0;
			return nIds;
			//throw e;
	   	}
	   	
	   	return nIds;
   }

   // método que devuelve las palabras clave en el idioma solicitado en el parámetro
   public ArrayList getPalabrasClaveIdioma (java.lang.String idioma) throws java.lang.Exception
   {
	   ArrayList l= new ArrayList();
       
       try{
    	Keyword[] kw= general.getGroupGeneralGeneral().getKeyword();
       	
       	if (kw != null){
	       	for (int i= 0; i<kw.length; i++){
	       		
	       		LanguageStringItem[] lsi= general.getGroupGeneralGeneral().getKeyword(i).getGroupKeywordKeyword().getLanguageStringItem();
	           	
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
       	String mensaje = "Warning: No es posible recoger las palabras clave en el idioma: " +idioma;
       	logger.warn(mensaje);
		    
		    l= new ArrayList();
		    return l;
		    //throw e;
       } 
       return l;
 
   }
   
   //método que recoge todas las palabras clave de la categoría General
   public ArrayList getPalabrasClave () throws java.lang.Exception
   {
	   ArrayList l= new ArrayList();
       
       try{
    	Keyword[] kw= general.getGroupGeneralGeneral().getKeyword();
       	
       	if (kw != null){
	       	for (int i= 0; i<kw.length; i++){
	       		
	       		LanguageStringItem[] lsi= general.getGroupGeneralGeneral().getKeyword(i).getGroupKeywordKeyword().getLanguageStringItem();
	       		
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
       	String mensaje = "Warning: No es posible recoger las palabras clave";
       	logger.warn(mensaje);
		    
		    l= new ArrayList();
		    return l;
		    //throw e;
       } 
       return l;
 
   }
   
   /*********** Métodos para Catalogador Avanzado ***************/
   
   public ArrayList getTitulosAv() throws java.lang.Exception {
   	
   	ArrayList l= new ArrayList();
   	LanguageStringItem[] lsi= null;
   	
   	// se recoge el título en todos los idiomas disponibles en el metadato
   	
   	try{
	    	lsi= general.getGroupGeneralGeneral().getTitle().getGroupTitleTitle().getLanguageStringItem();
	    	
	    	if ((lsi!= null) && (lsi.length>0)){
	    		for (int i= 0; i<lsi.length; i++){
	    			LangStringAgrega lAgrega=new LangStringAgrega();
	    			lAgrega.setIdioma(lsi[i].getString().getLanguage());
	    			lAgrega.setValor(lsi[i].getString().getContent());
	    			l.add(lAgrega);
		    	}
	    	}

   	} catch (Exception e){
   		String mensaje = "Warning: No es posible recoger el título con los diferentes idiomas.";
   		logger.warn(mensaje);
		    
		    l= new ArrayList();
		    return l;
		    //throw e;
   	}
 		return l;
   }
   
   public List getIdiomasAv() throws Exception{
//	   List idiomasAv=getIdiomas();
   	List idiomas= new ArrayList();
	
	try{
		
	   Language language[]= general.getGroupGeneralGeneral().getLanguage();
	   if (language!= null){
		   for (int i= 0; i<language.length; i++){
			   idiomas.add(language[i].getGroupLanguageLanguage().getContent());
		   }
	   }
	}
	catch (Exception e){
		String mensaje = "Warning: No es posible recoger los idiomas";
		logger.warn(mensaje);
	    
	    idiomas= new ArrayList();
	    return idiomas;
	    //throw e;
	}
	
	return idiomas;  
   }
   
   public ArrayList getDescripcionesAv () throws java.lang.Exception {

   	ArrayList l= new ArrayList();
       
       try{
       	DescriptionUnbounded[] du= general.getGroupGeneralGeneral().getDescriptionUnbounded();
       	
       	if (du != null)
       	for (int i= 0; i<du.length; i++){
       		ArrayList lAux= new ArrayList();
       		LanguageStringItem[] lsi= general.getGroupGeneralGeneral().getDescriptionUnbounded(i).getGroupDescriptionUnboundedDescription().getLanguageStringItem();
           	
           	if ((lsi != null) && (lsi.length>0)){
   	    		int cont= 0;
   				while (cont<lsi.length){
   					LangStringAgrega arrayLang=new LangStringAgrega();
   					arrayLang.setIdioma(lsi[cont].getString().getLanguage());
   					arrayLang.setValor(lsi[cont].getString().getContent());
   					lAux.add(arrayLang);
   					cont++;
   				}
   			}
           	l.add(lAux);
       	}
       }
       catch (Exception e){
       	String mensaje = "Warning: No es posible recoger las descripciones con los diferentes idiomas";
       	logger.warn(mensaje);
		    
		    l= new ArrayList();
		    return l;
		    //throw e;
       } 
       return l;
   }
   
   public ArrayList getPalabrasClaveAv () throws java.lang.Exception
   {
	   ArrayList l= new ArrayList();
       
       try{
    	Keyword[] kw= general.getGroupGeneralGeneral().getKeyword();
       	
       	if (kw != null){
	       	for (int i= 0; i<kw.length; i++){
	       		ArrayList lAux= new ArrayList();
	       		
	       		LanguageStringItem[] lsi= general.getGroupGeneralGeneral().getKeyword(i).getGroupKeywordKeyword().getLanguageStringItem();
	       		
	       		if ((lsi != null) && (lsi.length>0)){
	       			int cont= 0;
	       			while (cont<lsi.length){
	       				LangStringAgrega arrayLang=new LangStringAgrega();
	       				arrayLang.setIdioma(lsi[cont].getString().getLanguage());
	       				arrayLang.setValor(lsi[cont].getString().getContent());
	       				lAux.add(arrayLang);
	       				cont++;
	       			}
	       		}
	       		l.add(lAux);
	       	}
       	}
       }
       catch (Exception e){
       	String mensaje = "Warning: No es posible recoger las palabras clave con los diferentes idiomas";
       	logger.warn(mensaje);
		    
		    l= new ArrayList();
		    return l;
		    //throw e;
       } 
       return l;
 
   }
   
   public ArrayList getAmbitos () throws java.lang.Exception
   {
	   ArrayList l= new ArrayList();
       
       try{
    	Coverage[] cov= general.getGroupGeneralGeneral().getCoverage();
       	
       	if (cov != null){
	       	for (int i= 0; i<cov.length; i++){
	       		ArrayList lAux= new ArrayList();
	       		
	       		LanguageStringItem[] lsi= general.getGroupGeneralGeneral().getCoverage(i).getGroupCoverageCoverage().getLanguageStringItem();
	       		
	       		if ((lsi != null) && (lsi.length>0)){
	       			int cont= 0;
	       			while (cont<lsi.length){
	       				LangStringAgrega arrayLang=new LangStringAgrega();
	       				arrayLang.setIdioma(lsi[cont].getString().getLanguage());
	       				arrayLang.setValor(lsi[cont].getString().getContent());
	       				lAux.add(arrayLang);
	       				cont++;
	       			}
	       		}
	       		l.add(lAux);
	       	}
       	}
       }
       catch (Exception e){
       	String mensaje = "Warning: No es posible recoger en ámbito con los diferentes idiomas";
       	logger.warn(mensaje);
		    
		    l= new ArrayList();
		    return l;
		    //throw e;
       } 
       return l;
 
   }
   
   public java.lang.String getEstructuraAv (
   ) throws java.lang.Exception {
	   
	   java.lang.String lString= null;
       
       try{
    	  Structure structura = general.getGroupGeneralGeneral().getStructure();
    	  if(structura!=null)
    		  lString= structura.getGroupStructureStructure().getComplexTypeStructureVocabValue().getContent();
       }
       catch (Exception e){
    	   String mensaje = "Warning: No es posible recoger la estructura";
    	   logger.warn(mensaje);
		   
		   lString= null;
		   return lString;
		   //throw e;
       }
       
       return lString;
   }
   
   public java.lang.String getNivelDeAgregacionAv () throws Exception{
	   //String nivelAgre=getNivelDeAgregacion();
	   java.lang.String nivelAgre= null;
       
       try{
    	   if (general.getGroupGeneralGeneral().getAggregationLevel()!=null)
    		   nivelAgre= general.getGroupGeneralGeneral().getAggregationLevel().getGroupAggregationLevelAggregationLevel().getComplexTypeAggregationLevelVocabValue().getContent();
       }
       catch (Exception e){
    	   String mensaje = "Warning: No es posible recoger el nivel de agregación";
    	   logger.warn(mensaje);
		   
    	   nivelAgre= null;
		   return nivelAgre;
		   //throw e;
       }

       return nivelAgre;
	   
   }
   
   public ArrayList getIdentificadoresAv () throws java.lang.Exception
   {
	   ArrayList l= new ArrayList();
       
       try{
    	Identifier[] ident= general.getGroupGeneralGeneral().getIdentifier();
       	
       	if (ident != null){
	       	for (int i= 0; i<ident.length; i++){
	       		
	       		
	       		Catalog catalog= general.getGroupGeneralGeneral().getIdentifier(i).getGroupIdentifierIdentifier().getCatalog();
	       		Entry entry=general.getGroupGeneralGeneral().getIdentifier(i).getGroupIdentifierIdentifier().getEntry();
	       		String content=catalog.getGroupCatalogCatalog().getContent();
	       		String contEntry=entry.getGroupEntryEntry().getContent();
	       		if ((content != null)&&(content.length()>0)){
	       			IdentificadorAgrega identAgrega=new IdentificadorAgrega();
	       			identAgrega.setCatalogo(content);
	       			identAgrega.setEntrada(contEntry);
	       			l.add(identAgrega);
	       		}
	       		
	       	}
       	}
       }
       catch (Exception e){
       	String mensaje = "Warning: No es posible recoger los idendtificadores";
       	logger.warn(mensaje);
		    
		    l= new ArrayList();
		    return l;
		    //throw e;
       } 
       return l;
 
   }
   
   
   
   /********************Los Métodos SET del Avanzado********************/
   
   public void setTituloAv(ArrayList lTitulo) throws Exception{
	   try{
		   	if((lTitulo!=null)&&(lTitulo.size()>0)){
		   	   GroupTitleTitle grupo=new GroupTitleTitle();
		   	   Title title=new Title();
			   for(int i=0;i<lTitulo.size();i++){
				   es.pode.parseadorXML.castor.String string=new es.pode.parseadorXML.castor.String();
				   LanguageStringItem lsi=new LanguageStringItem();
				   
				  
				   String idioma = ((LangStringAgrega)(lTitulo.get(i))).getIdioma();
				   String valor = ((LangStringAgrega)(lTitulo.get(i))).getValor();
				   
				   string.setContent(valor);
				   string.setLanguage(idioma);
				   lsi.setString(string);
				   grupo.addLanguageStringItem(lsi);
			   }
			   
			   
			   title.setGroupTitleTitle(grupo);
			   
			   general.getGroupGeneralGeneral().setTitle(title);
		   	}
		  
	   }catch (Exception e){
       	String mensaje = "Error: No es posible insertar los titulos ";
	    logger.error(mensaje);
	    throw e;
    } 
   }
   
   public void setIdiomasAv(ArrayList idiomas) throws Exception{
	   try{
		   ArrayList arrayLan=new ArrayList();
		   if((idiomas!=null)&&(idiomas.size()>0)){
			   for(int i=0;i<idiomas.size();i++){
				   GroupLanguageLanguage gll=new GroupLanguageLanguage();
				   Language language=new Language();
				   
				   gll.setContent(idiomas.get(i).toString());
				   language.setGroupLanguageLanguage(gll);
				   arrayLan.add(language);
				   
			   }
		   }
		   Language[] lang=(Language[])arrayLan.toArray(new Language[arrayLan.size()]);
		   general.getGroupGeneralGeneral().setLanguage(lang);   
		  
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar los idiomas ";
		    logger.error(mensaje);
		    throw e;
	    } 
   }
   
   public void setDescripcionesAv(ArrayList descripciones) throws Exception{
	   try{
		   ArrayList array2=new ArrayList();
		  
		   if((descripciones!=null)&&(descripciones.size()>0)){
			   
			   
			   for(int i=0;i<descripciones.size();i++){
				   GroupDescriptionUnboundedDescription gdud=new GroupDescriptionUnboundedDescription();
				   ArrayList array=new ArrayList();
				   ArrayList descripc=(ArrayList) descripciones.get(i);
				   DescriptionUnbounded du=new DescriptionUnbounded();
				   for(int j=0;j<descripc.size();j++){
					   es.pode.parseadorXML.castor.String string=new es.pode.parseadorXML.castor.String();
					   LanguageStringItem lsi=new LanguageStringItem();
					   
					   String idioma= ((LangStringAgrega)(descripc.get(j))).getIdioma();
					   String valor= ((LangStringAgrega)(descripc.get(j))).getValor();
					   string.setContent(valor);
					   string.setLanguage(idioma);
					   lsi.setString(string);
					   array.add(lsi);	   
				   }
				  
				   LanguageStringItem[] lang=(LanguageStringItem[])array.toArray(new LanguageStringItem[array.size()]);
				   gdud.setLanguageStringItem(lang); 
				   
				   du.setGroupDescriptionUnboundedDescription(gdud);
				   array2.add(du);
			   }
			   
			  
		   }
		   
		   
		   DescriptionUnbounded[] desc = (DescriptionUnbounded[])array2.toArray((new DescriptionUnbounded[array2.size()]));
		   general.getGroupGeneralGeneral().setDescriptionUnbounded(desc);
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar las descripciones ";
		    logger.error(mensaje);
		    throw e;
	    } 
   }
   
   public void setPalabrasClaveAv(ArrayList palabrasClave) throws Exception{
	   try{
		  
		   ArrayList arrayPalabras=new ArrayList();
		   if((palabrasClave!=null)&&(palabrasClave.size()>0)){
			  
			   
			   for(int i=0;i<palabrasClave.size();i++){
				   GroupKeywordKeyword gkk=new GroupKeywordKeyword();
				   Keyword keyWord=new Keyword();
				   ArrayList palabras=(ArrayList)(palabrasClave.get(i));
				   ArrayList array=new ArrayList();
				   for(int j=0;j<palabras.size();j++){
					   
					   es.pode.parseadorXML.castor.String string=new es.pode.parseadorXML.castor.String();
					   LanguageStringItem lsi=new LanguageStringItem();
					   String idioma=((LangStringAgrega)(palabras.get(j))).getIdioma();
					   String valor=((LangStringAgrega)(palabras).get(j)).getValor();
					   string.setContent(valor);
					   string.setLanguage(idioma);
					   lsi.setString(string);
					   array.add(lsi);
				   }
				   LanguageStringItem[] lang=(LanguageStringItem[])array.toArray(new LanguageStringItem[array.size()]);
				   gkk.setLanguageStringItem(lang);
				   keyWord.setGroupKeywordKeyword(gkk);
				   arrayPalabras.add(keyWord);
			   }
			   
			   Keyword[] key=(Keyword[])arrayPalabras.toArray(new Keyword[arrayPalabras.size()]);
			   general.getGroupGeneralGeneral().setKeyword(key);
		   }
		   
		   
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar las palabras clave ";
		    logger.error(mensaje);
		    throw e;
	    } 
   }
   
   public void setAmbitosAv(ArrayList ambitos) throws Exception{
	   try{
		   ArrayList arrayPalabras=new ArrayList();
		   if((ambitos!=null)&&(ambitos.size()>0)){
			  
			   
			   for(int i=0;i<ambitos.size();i++){
				   
				   GroupCoverageCoverage gcc=new GroupCoverageCoverage();
				   Coverage coverage=new Coverage();
				   
				   ArrayList ambito=(ArrayList)(ambitos.get(i));
				   ArrayList array=new ArrayList();
				   for(int j=0;j<ambito.size();j++){
					   
					   es.pode.parseadorXML.castor.String string=new es.pode.parseadorXML.castor.String();
					   LanguageStringItem lsi=new LanguageStringItem();
					   String idioma=((LangStringAgrega)(ambito.get(j))).getIdioma();
					   String valor=((LangStringAgrega)(ambito).get(j)).getValor();
					   string.setContent(valor);
					   string.setLanguage(idioma);
					   lsi.setString(string);
					   array.add(lsi);
				   }
				   LanguageStringItem[] lang=(LanguageStringItem[])array.toArray(new LanguageStringItem[array.size()]);
				   gcc.setLanguageStringItem(lang);
				   coverage.setGroupCoverageCoverage(gcc);
				   arrayPalabras.add(coverage);
			   }
			   Coverage[] cov=(Coverage[])arrayPalabras.toArray(new Coverage[arrayPalabras.size()]);
			  
			   general.getGroupGeneralGeneral().setCoverage(cov);
		   }
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar los ambitos";
		    logger.error(mensaje);
		    throw e;
	    } 
   }
   
   public void setEstructuraAv(String estructura) throws Exception{
	   try{
		   
		   String estructuraProp = null;
		   	
		   estructuraProp = "lomes-esv1.0";//AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		   if(estructura!=null){
			   Structure structure=new Structure();
			   GroupStructureStructure gss=new GroupStructureStructure();
			   ComplexTypeStructureVocabValue ctsvv=new ComplexTypeStructureVocabValue();
			   ComplexTypeStructureVocabSource ctsvs=new ComplexTypeStructureVocabSource();
			   ctsvv.setContent(estructura);
			   ctsvs.setContent(estructuraProp);
			   gss.setComplexTypeStructureVocabSource(ctsvs);
			   gss.setComplexTypeStructureVocabValue(ctsvv);
			   structure.setGroupStructureStructure(gss);
			   general.getGroupGeneralGeneral().setStructure(structure);
		   }else{
			   general.getGroupGeneralGeneral().setStructure(null);
		   }
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar la estructura";
		    logger.error(mensaje);
		    throw e;
	    } 
   }
   
   public void setNivelDeAgregacionAv(String agregacion) throws Exception{
//	   setNivelDeAgregacion(agregacion);
	   
   try{
		   
		   String lomes = null;
		   	
		   lomes = "lomes-esv1.0";//AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
		   if(agregacion!=null){
			   AggregationLevel al= new AggregationLevel();
			   GroupAggregationLevelAggregationLevel gal= new GroupAggregationLevelAggregationLevel();
			   ComplexTypeAggregationLevelVocabSource ctalvs= new ComplexTypeAggregationLevelVocabSource();
			   ComplexTypeAggregationLevelVocabValue ctalvv= new ComplexTypeAggregationLevelVocabValue();

			   ctalvs.setContent(lomes);
			   ctalvv.setContent(agregacion);
			   gal.setComplexTypeAggregationLevelVocabSource(ctalvs);
			   gal.setComplexTypeAggregationLevelVocabValue(ctalvv);
			   al.setGroupAggregationLevelAggregationLevel(gal);
			   

			   general.getGroupGeneralGeneral().setAggregationLevel(al);
		   }else{
			   general.getGroupGeneralGeneral().setAggregationLevel(null);
		   }
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar la estructura";
		    logger.error(mensaje);
		    throw e;
	    } 
	   
   }
   
   public void setIdentificadoresAv(ArrayList identificadores) throws Exception{
	   try{
		   
		   ArrayList lista=new ArrayList();
		   if((identificadores!=null)&&(identificadores.size()>0)){
			   for(int i=0;i<identificadores.size();i++){
				  Identifier identifier=new Identifier();
				  GroupIdentifierIdentifier gii=new GroupIdentifierIdentifier();
				  Catalog catalog=new Catalog();
				  Entry entry=new Entry();
				  GroupCatalogCatalog gcc=new GroupCatalogCatalog();
				  GroupEntryEntry gee=new GroupEntryEntry();
				  String catalogo= ((IdentificadorAgrega)(identificadores.get(i))).getCatalogo();
				  String entrada=((IdentificadorAgrega)(identificadores.get(i))).getEntrada();
				  gcc.setContent(catalogo);
				  gee.setContent(entrada);
				  catalog.setGroupCatalogCatalog(gcc);
				  entry.setGroupEntryEntry(gee);
				  gii.setCatalog(catalog);
				  gii.setEntry(entry);
				  
				  identifier.setGroupIdentifierIdentifier(gii);
				  lista.add(identifier);
			   }
			   Identifier[] identi=(Identifier[])lista.toArray(new Identifier[lista.size()]);
			   general.getGroupGeneralGeneral().setIdentifier(identi);
		   }
	   }catch (Exception e){
	       	String mensaje = "Error: No es posible insertar los identificadores";
		    logger.error(mensaje);
		    throw e;
	    } 
   }
}

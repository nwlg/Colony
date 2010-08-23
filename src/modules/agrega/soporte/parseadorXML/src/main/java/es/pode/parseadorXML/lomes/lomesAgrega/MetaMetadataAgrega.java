/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML.lomes.lomesAgrega;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.parseadorXML.castor.Catalog;
import es.pode.parseadorXML.castor.ComplexTypeDateTimeDateTime;
import es.pode.parseadorXML.castor.ComplexTypeDateTimeDescription;
import es.pode.parseadorXML.castor.ComplexTypeRoleMetaVocabSource;
import es.pode.parseadorXML.castor.ComplexTypeRoleMetaVocabValue;
import es.pode.parseadorXML.castor.ContributeMeta;
import es.pode.parseadorXML.castor.Date;
import es.pode.parseadorXML.castor.EntityUnbounded;
import es.pode.parseadorXML.castor.Entry;
import es.pode.parseadorXML.castor.GroupCatalogCatalog;
import es.pode.parseadorXML.castor.GroupContributeMetaContribute;
import es.pode.parseadorXML.castor.GroupDateDate;
import es.pode.parseadorXML.castor.GroupEntityUnboundedEntity;
import es.pode.parseadorXML.castor.GroupEntryEntry;
import es.pode.parseadorXML.castor.GroupIdentifierIdentifier;
import es.pode.parseadorXML.castor.GroupLanguageLanguage;
import es.pode.parseadorXML.castor.GroupMetaMetadataMetaMetadata;
import es.pode.parseadorXML.castor.GroupMetadataSchemaMetadataSchema;
import es.pode.parseadorXML.castor.GroupRoleMetaRole;
import es.pode.parseadorXML.castor.Identifier;
import es.pode.parseadorXML.castor.Language;
import es.pode.parseadorXML.castor.LanguageStringItem;
import es.pode.parseadorXML.castor.MetaMetadata;
import es.pode.parseadorXML.castor.MetadataSchema;
import es.pode.parseadorXML.castor.RoleMeta;

public class MetaMetadataAgrega {

	private MetaMetadata metaMetadata = null;
	
	private Logger logger = Logger.getLogger(this.getClass());
	
	 public MetaMetadataAgrega(MetaMetadata metaMetadata) {
	        super();
	        
	        if (metaMetadata.getGroupMetaMetadataMetaMetadata()== null){
	        	metaMetadata.setGroupMetaMetadataMetaMetadata(new GroupMetaMetadataMetaMetadata());
	        }
	        
	        setMetaMetadata(metaMetadata);
	    }

	public MetaMetadata getMetaMetadata() {
		return metaMetadata;
	}

	public void setMetaMetadata(MetaMetadata metaMetadata) {
		this.metaMetadata = metaMetadata;
	}
	 
//	 método que recoge el rol de la contribución en la posición indicada en el parámetro de entrada
    public String getRol(int contributeIndex) throws java.lang.Exception{
    	
    	String r= null;
    	
		try {
			r= metaMetadata.getGroupMetaMetadataMetaMetadata().getContributeMeta(contributeIndex).getGroupContributeMetaContribute().getRoleMeta().getGroupRoleMetaRole().getComplexTypeRoleMetaVocabValue().getContent();
		} catch (Exception e){
			String mensaje = "Warning: No es posible recoger el rol en la contribución de la posición: " +contributeIndex;
		    logger.warn(mensaje);
		    
//		  Devuelve null
		    return r;
		    //throw e;
		}
		return r;
	}
    
//  método que recoge el Entity de la contribución en la posición indicada en el parámetro de entrada
    public String getEntidad(int contributeIndex, int entityIndex) throws java.lang.Exception {
    	
    	String r= null;
    	
		try {
			r= metaMetadata.getGroupMetaMetadataMetaMetadata().getContributeMeta(contributeIndex).getGroupContributeMetaContribute().getEntityUnbounded(entityIndex).getGroupEntityUnboundedEntity().getContent();
		} catch (Exception e){
			String mensaje = "Warning: No es posible recoger la entidad:" +entityIndex+ " en la contribución de la posición: " +contributeIndex;
		    logger.warn(mensaje);
		    
//		  Devuelve null
		    return r;
		    //throw e;
		}
		return r;
    }
    
//  método que recoge todas las entidades participantes en la contribución indicada en el parámetro de entrada
    public ArrayList getEntidades(int contributeIndex) throws java.lang.Exception {
    	
    	ArrayList en= new ArrayList();
    	
		try {
			EntityUnbounded[] eu=metaMetadata.getGroupMetaMetadataMetaMetadata().getContributeMeta(contributeIndex).getGroupContributeMetaContribute().getEntityUnbounded();
			
			if (eu != null){
				for (int i=0; i<eu.length; i++){
					en.add(metaMetadata.getGroupMetaMetadataMetaMetadata().getContributeMeta(contributeIndex).getGroupContributeMetaContribute().getEntityUnbounded(i).getGroupEntityUnboundedEntity().getContent());
				}
			}
			
		} catch (Exception e){
			String mensaje = "Warning: No es posible recoger las entidades en la contribución de la posición: " +contributeIndex;
		    logger.warn(mensaje);
		    
		    en= new ArrayList();
//		  Devuelve lista vacía
		    return en;
		    //throw e;
		}
		return en;
    }
    
    // método que recoge la fecha de la contribución indicada en el parámetro
    public String getFecha(int contributeIndex) throws java.lang.Exception{
    	
    	String f= null;
    	
		try {
			f= metaMetadata.getGroupMetaMetadataMetaMetadata().getContributeMeta(contributeIndex).getGroupContributeMetaContribute().getDate().getGroupDateDate().getComplexTypeDateTimeDateTime().getContent();
		} catch (Exception e){
			String mensaje = "Warning: No es posible recoger la fecha en la contribución de la posición: " +contributeIndex;
		    logger.warn(mensaje);
		    
//		  Devuelve null
		    return f;
		    //throw e;
		}
		return f;
	}
    
//  método que añade una nueva contribución. Hay que indicar el rol, la entidad, la fecha y la descripción de la contribución
    public void addContribucion(
    		java.lang.String rol, java.lang.String entidad, java.lang.String fecha, java.lang.String desc ) 
    throws java.lang.Exception{
    	
 	   	String lomes= AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
    	
 	   	ContributeMeta c= new ContributeMeta();
    	GroupContributeMetaContribute gcc= new GroupContributeMetaContribute();
    	Date d= new Date();
    	EntityUnbounded eu= new EntityUnbounded();
    	RoleMeta r= new RoleMeta();
    	
    	GroupDateDate gdd= new GroupDateDate();
    	ComplexTypeDateTimeDateTime ctdtt= new ComplexTypeDateTimeDateTime();
    	ComplexTypeDateTimeDescription ctdtd= new ComplexTypeDateTimeDescription();
    	ctdtt.setContent(fecha);
    	LanguageStringItem lsi= new LanguageStringItem();
    	es.pode.parseadorXML.castor.String s= new es.pode.parseadorXML.castor.String();
    	s.setContent(desc);
    	lsi.setString(s);
    	ctdtd.addLanguageStringItem(lsi);
    	gdd.setComplexTypeDateTimeDateTime(ctdtt);
    	gdd.setComplexTypeDateTimeDescription(ctdtd);
    	
    	d.setGroupDateDate(gdd);
    	
    	GroupEntityUnboundedEntity geue= new GroupEntityUnboundedEntity();
    	geue.setContent(entidad);
    	
    	eu.setGroupEntityUnboundedEntity(geue);
    	
    	GroupRoleMetaRole grr= new GroupRoleMetaRole();
    	ComplexTypeRoleMetaVocabSource ctrvs= new ComplexTypeRoleMetaVocabSource();
    	ComplexTypeRoleMetaVocabValue ctrvv= new ComplexTypeRoleMetaVocabValue();
    	ctrvs.setContent(lomes);
    	ctrvv.setContent(rol);
    	grr.setComplexTypeRoleMetaVocabSource(ctrvs);
    	grr.setComplexTypeRoleMetaVocabValue(ctrvv);
    	r.setGroupRoleMetaRole(grr);
    	
    	gcc.setDate(d);
    	gcc.addEntityUnbounded(eu);
    	gcc.setRoleMeta(r);
    	
    	c.setGroupContributeMetaContribute(gcc);
    	
    	if (metaMetadata == null){
    		metaMetadata= new MetaMetadata();
	    }
	    
	    if (metaMetadata.getGroupMetaMetadataMetaMetadata() == null){
	    	es.pode.parseadorXML.castor.GroupMetaMetadataMetaMetadata gmmAux= new es.pode.parseadorXML.castor.GroupMetaMetadataMetaMetadata();
	    	metaMetadata.setGroupMetaMetadataMetaMetadata(gmmAux);
	    }
    	
	    metaMetadata.getGroupMetaMetadataMetaMetadata().addContributeMeta(c);
    }
    
    
    //método que recoge el esquema de metadatos indicado en el parámetro
    public java.lang.String getEsquemaDeMetadatos(final int index)
    throws java.lang.Exception {
    	
    	String esquema= null;
    	try{
    		esquema = metaMetadata.getGroupMetaMetadataMetaMetadata().getMetadataSchema(index).getGroupMetadataSchemaMetadataSchema().getContent();
    	} catch (Exception e){
    		String mensaje = "Warning: No es posible recoger el esquema de metadatos en la posición: " +index;
		    logger.warn(mensaje);
		    
//		  Devuelve null
		    return esquema;
		    //throw e;
    	}
    	
    	return esquema;

    }
    
    public void setEsquemaDeMetadatos(
            final int index, java.lang.String esquema)
    throws java.lang.Exception {
        
        try{
        	
        	if ((metaMetadata.getGroupMetaMetadataMetaMetadata().getMetadataSchema().length>0) && (index<metaMetadata.getGroupMetaMetadataMetaMetadata().getMetadataSchema().length)){
        		metaMetadata.getGroupMetaMetadataMetaMetadata().getMetadataSchema(index).getGroupMetadataSchemaMetadataSchema().setContent(esquema);
        	}
        	else{
        		this.addEsquemaDeMetadatos(esquema);
        	}
        	
        	
        }
        catch (Exception e){
        	String mensaje = "Error: No es posible insertar el esquema de metadatos en la posición "+ index;
 		    logger.error(mensaje);
 		    throw e;
        } 
    }
    
    public ArrayList getEsquemasDeMetadatos()
    throws java.lang.Exception {
    	
    	ArrayList l= new ArrayList();
    	
    	try{
    		MetadataSchema[] ms= metaMetadata.getGroupMetaMetadataMetaMetadata().getMetadataSchema();
    		
    		if (ms != null){
    			for (int i= 0; i<ms.length; i++){
    				l.add(ms[i].getGroupMetadataSchemaMetadataSchema().getContent());
    			}
    		}
    	} catch (Exception e){
    		String mensaje = "Warning: No es posible recoger los esquemas de metadatos";
		    logger.warn(mensaje);
		    
		    l= new ArrayList();
		    return l;
		    //throw e;
    	}
    	
    	return l;
    }
    
    public void addEsquemaDeMetadatos(
    		java.lang.String esq ) 
    throws java.lang.Exception{
      
    	MetadataSchema ms= new MetadataSchema();
    	GroupMetadataSchemaMetadataSchema gms= new GroupMetadataSchemaMetadataSchema();
    	
    	gms.setContent(esq);
    	ms.setGroupMetadataSchemaMetadataSchema(gms);
    
    	if (metaMetadata == null){
    		metaMetadata= new MetaMetadata();
	    }
	    
	    if (metaMetadata.getGroupMetaMetadataMetaMetadata() == null){
	    	es.pode.parseadorXML.castor.GroupMetaMetadataMetaMetadata gmmAux= new es.pode.parseadorXML.castor.GroupMetaMetadataMetaMetadata();
	    	metaMetadata.setGroupMetaMetadataMetaMetadata(gmmAux);
	    }
	    
	    metaMetadata.getGroupMetaMetadataMetaMetadata().addMetadataSchema(ms);	
    }
    
    public java.lang.String getIdioma()
    throws java.lang.Exception {
    	
    	String i= null;
    	
    	try{
    		i= metaMetadata.getGroupMetaMetadataMetaMetadata().getLanguage().getGroupLanguageLanguage().getContent();
    		
    	}catch (Exception e){
    		String mensaje = "Warning: No es posible recoger el idioma de los metametadatos";
		    logger.warn(mensaje);
		    
		    i= null;
		    return i;
		    //throw e;
    	}
    	
    	return i;
    }
	
    //  método que inserta el idioma en la categoría MetaMetadata de LOM-ES
    // el idioma introducido debe ser un código de 2 letras ISO 639-1988
    public void setIdioma(java.lang.String idioma)
    throws java.lang.Exception {
    	
	    	Language l= new Language();
	    	GroupLanguageLanguage gll= new GroupLanguageLanguage();
	    	
	    	gll.setContent(idioma);
	    	l.setGroupLanguageLanguage(gll);
	    	
	    	if (metaMetadata == null){
	    		metaMetadata= new MetaMetadata();
		    }
		    
		    if (metaMetadata.getGroupMetaMetadataMetaMetadata() == null){
		    	es.pode.parseadorXML.castor.GroupMetaMetadataMetaMetadata gmmAux= new es.pode.parseadorXML.castor.GroupMetaMetadataMetaMetadata();
		    	metaMetadata.setGroupMetaMetadataMetaMetadata(gmmAux);
		    }
		    
		    metaMetadata.getGroupMetaMetadataMetaMetadata().setLanguage(l);
    }
    
//  metodo para escribir el identificador MEC en la primera posición
    public void setIdentificadorMEC(
    		 java.lang.String cat, java.lang.String ent ) 
    throws java.lang.Exception{
    	
    	java.util.List idList= new java.util.ArrayList();
    	
    	if (metaMetadata == null){
    		metaMetadata= new MetaMetadata();
	    }
	    
	    if (metaMetadata.getGroupMetaMetadataMetaMetadata() == null){
	    	GroupMetaMetadataMetaMetadata gmmdAux= new GroupMetaMetadataMetaMetadata();
	    	metaMetadata.setGroupMetaMetadataMetaMetadata(gmmdAux);
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
		
	    Identifier[] id= metaMetadata.getGroupMetaMetadataMetaMetadata().getIdentifier();
	    
	    if (id.length > 0){
	    	for (int cont= 0; cont<id.length; cont++){
	    		idList.add((Identifier)id[cont]);
	    	}
	    } 
	    metaMetadata.getGroupMetaMetadataMetaMetadata().setIdentifier((Identifier[])idList.toArray(new Identifier[idList.size()]));
	    
    }
    
    /*****************************Métodos para Catalogador Avanzado********************************/
    
    public ArrayList getIdentificadoresMetaAv(){
    	ArrayList lIdentificadores=new ArrayList();
    	
    	try{
    		Identifier[] identif = metaMetadata.getGroupMetaMetadataMetaMetadata().getIdentifier();
    		if((identif!=null)&&(identif.length>0)){
    			for(int i=0;i<identif.length;i++){
    				IdentificadorAgrega identificador=new IdentificadorAgrega();
    				identificador.setCatalogo(identif[i].getGroupIdentifierIdentifier().getCatalog().getGroupCatalogCatalog().getContent());
    				identificador.setEntrada(identif[i].getGroupIdentifierIdentifier().getEntry().getGroupEntryEntry().getContent());
    				lIdentificadores.add(identificador);
    			}
    		}
    		
    	}catch (Exception e){
    		String mensaje = "Warning: No es posible recoger los identificadores del metadatos";
		    logger.warn(mensaje);
		    
		    lIdentificadores= new ArrayList();
		    return lIdentificadores;
		    //throw e;
    	}
    	
    	
    	return lIdentificadores;
    }
    
    public ArrayList getContribucionesAv(){
    	ArrayList lContribuciones=new ArrayList();

    	try{
    		ContributeMeta[] lContriMetadata=metaMetadata.getGroupMetaMetadataMetaMetadata().getContributeMeta();
    		
    		if ((lContriMetadata != null)&&(lContriMetadata.length>0)){
    			for (int i= 0; i<lContriMetadata.length; i++){
    				ContribucionAgrega contribucion=new ContribucionAgrega();
    				FechaAgrega tiempo=new FechaAgrega();
    				if(lContriMetadata[i].getGroupContributeMetaContribute().getRoleMeta()!=null)
    					contribucion.setTipo(lContriMetadata[i].getGroupContributeMetaContribute().getRoleMeta().getGroupRoleMetaRole().getComplexTypeRoleMetaVocabValue().getContent());
    				
    				EntityUnbounded[] lEntity = lContriMetadata[i].getGroupContributeMetaContribute().getEntityUnbounded();
    				if((lEntity !=null)&&(lEntity.length>0)){
    					ArrayList lEntidades=new ArrayList();
    					int cont= 0;
	    				while (cont<lEntity.length){
	    					lEntidades.add(lEntity[cont].getGroupEntityUnboundedEntity().getContent());
	    					cont++;
	    				}
	    				contribucion.setEntidad(lEntidades);
    					
    				}
    		
    				
    				Date date = lContriMetadata[i].getGroupContributeMetaContribute().getDate();
    				if(date!=null){
    					if(date.getGroupDateDate().getComplexTypeDateTimeDateTime()!=null)
    						tiempo.setFecha(date.getGroupDateDate().getComplexTypeDateTimeDateTime().getContent());
    					
    					LanguageStringItem[] lsi=null;
    					if(date.getGroupDateDate().getComplexTypeDateTimeDescription()!=null)
    						lsi = date.getGroupDateDate().getComplexTypeDateTimeDescription().getLanguageStringItem();
    					
	    				if((lsi != null) && (lsi.length>0)){
	    					int cont= 0;
	    					ArrayList lDesc=new ArrayList();
	    					while (cont<lsi.length){
	    						
	    						LangStringAgrega lString=new LangStringAgrega();
	    						lString.setValor(lsi[cont].getString().getContent());
	    						lString.setIdioma(lsi[cont].getString().getLanguage());
	    						lDesc.add(lString);
	    						cont++;
	    					}
	    					tiempo.setDescripciones(lDesc);
	    				}
    				}
    				contribucion.setFecha(tiempo);
    				lContribuciones.add(contribucion);
    			}
    			
    		}
    		
    	} catch (Exception e){
    		String mensaje = "Warning: No es posible recoger las contribuciones de metadatos";
		    logger.warn(mensaje);
		    
		    lContribuciones= new ArrayList();
		    return lContribuciones;
		    //throw e;
    	}
    	
    	return lContribuciones;
    }
    
    
    public ArrayList getEsquemasDeMetadatosAv() throws Exception{
    	ArrayList lEsquemas=new ArrayList();
    	lEsquemas=getEsquemasDeMetadatos();
    	return lEsquemas;
    }
    
    public String getIdiomaAv() throws Exception{
//    	String idioma=getIdioma();
    	String idioma= null;
    	
    	try{
    		if (metaMetadata.getGroupMetaMetadataMetaMetadata().getLanguage()!=null)
    			idioma= metaMetadata.getGroupMetaMetadataMetaMetadata().getLanguage().getGroupLanguageLanguage().getContent();
    		
    	}catch (Exception e){
    		String mensaje = "Warning: No es posible recoger el idioma de los metametadatos";
		    logger.warn(mensaje);
		    
		    idioma= null;
		    return idioma;
		    //throw e;
    	}

    	return idioma;
    }
    
    /**************Métodos SET del Avanzado******************** */
    
    public void setIdentificadoresMetaAv(ArrayList identificadores) throws Exception{
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
 			   metaMetadata.getGroupMetaMetadataMetaMetadata().setIdentifier(identi);
 		   }
    	}catch (Exception e){
	       	String mensaje = "Error: No es posible insertar los identificadores";
		    logger.error(mensaje);
		    throw e;
	    } 
    }

    public void setContribucionesAv(ArrayList contribuciones) throws Exception{
    	try{
    		ArrayList lista=new ArrayList();
    	
 		    String contriProp = null;
 	
 		    contriProp = AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
 		    
    		if((contribuciones!=null)&&(contribuciones.size()>0)){
    			
    			for(int i=0;i<contribuciones.size();i++){
    				ContributeMeta contributeMeta=new ContributeMeta();
        			GroupContributeMetaContribute gcmc=new GroupContributeMetaContribute();
        		
    				ArrayList lEntidades=((ContribucionAgrega)(contribuciones.get(i))).getEntidad();
    				ArrayList lEnty=new ArrayList();
    				FechaAgrega fechaAgrega=((ContribucionAgrega)(contribuciones.get(i))).getFecha();
    				String tipo=((ContribucionAgrega)(contribuciones.get(i))).getTipo();
    				
    				RoleMeta role=null;
    				if(tipo!=null){
	    				role=new RoleMeta();
	    				GroupRoleMetaRole grmr=new GroupRoleMetaRole();
	    				ComplexTypeRoleMetaVocabValue ctrmvv=new ComplexTypeRoleMetaVocabValue();
	    				ComplexTypeRoleMetaVocabSource ctrmvs=new ComplexTypeRoleMetaVocabSource();
	    				
	    				ctrmvv.setContent(tipo);
	    				ctrmvs.setContent(contriProp);
	    				grmr.setComplexTypeRoleMetaVocabSource(ctrmvs);
	    				grmr.setComplexTypeRoleMetaVocabValue(ctrmvv);
	    				role.setGroupRoleMetaRole(grmr); 				
    				}
    				
    				if((lEntidades!=null)&&(lEntidades.size()>0)){
    					for(int j=0;j<lEntidades.size();j++){
	    					String entidad=	(String) lEntidades.get(j);
	    					EntityUnbounded eu=new EntityUnbounded();
	    					GroupEntityUnboundedEntity geueu=new GroupEntityUnboundedEntity();
	    					geueu.setContent(entidad);
	    					eu.setGroupEntityUnboundedEntity(geueu);
	    					lEnty.add(eu);
    					}
    					
    					
    				}
    				EntityUnbounded[] lUn=(EntityUnbounded[])lEnty.toArray(new EntityUnbounded[lEnty.size()]);
    				
    				
        			Date date=null;
    				if((fechaAgrega!=null)){
    					String data=fechaAgrega.getFecha();
    					ArrayList lDesFe=fechaAgrega.getDescripciones();
    					
    					ComplexTypeDateTimeDateTime ctdtdt=null;
    					if(fechaAgrega.getFecha()!=null){
    						ctdtdt = new ComplexTypeDateTimeDateTime();
    						ctdtdt.setContent(data);
    					}
    					
    					
    					
    					ComplexTypeDateTimeDescription ctdtd=null;
    					ArrayList listas=new ArrayList();
    					if((lDesFe!=null)&&(lDesFe.size()>0)){
    						
    						for(int j=0;j<lDesFe.size();j++){
    							LanguageStringItem lsi=new LanguageStringItem();
    							es.pode.parseadorXML.castor.String string=new es.pode.parseadorXML.castor.String();
    							String idioma=((LangStringAgrega)(lDesFe.get(j))).getIdioma();
    							String valor=((LangStringAgrega)(lDesFe.get(j))).getValor();
    							string.setContent(valor);
    							string.setLanguage(idioma);
    							lsi.setString(string);
    							listas.add(lsi);
    							
    						}
    						LanguageStringItem[] listas1=(LanguageStringItem[])listas.toArray(new LanguageStringItem[listas.size()]);
        					ctdtd = new ComplexTypeDateTimeDescription();
        					ctdtd.setLanguageStringItem(listas1);
        					
    					}
    					if(data != null && lDesFe != null){
    						GroupDateDate gdd=new GroupDateDate();
    						gdd.setComplexTypeDateTimeDateTime(ctdtdt);
    						gdd.setComplexTypeDateTimeDateTime(ctdtdt);
    						gdd.setComplexTypeDateTimeDescription(ctdtd);
    						
    						date = new Date();
    						date.setGroupDateDate(gdd);
    					}
    					
    				}
    				
    				gcmc.setDate(date);
    				gcmc.setRoleMeta(role);
    				gcmc.setEntityUnbounded(lUn);
    				contributeMeta.setGroupContributeMetaContribute(gcmc);
    				lista.add(contributeMeta);
    			}
    		}
    		ContributeMeta[] lContribute=(ContributeMeta[])lista.toArray(new ContributeMeta[lista.size()]);
    		metaMetadata.getGroupMetaMetadataMetaMetadata().setContributeMeta(lContribute);
    	}catch (Exception e){
	       	String mensaje = "Error: No es posible insertar las contribuciones";
		    logger.error(mensaje);
		    throw e;
	    } 
    }
    
    public void setEsquemasDeMetadatosAv(ArrayList esquemas) throws Exception{
    	try{
    		ArrayList lista=new ArrayList();
    		if((esquemas!=null)&&(esquemas.size()>0)){
    			for(int i=0;i<esquemas.size();i++){
    				MetadataSchema ms=new MetadataSchema();
    				GroupMetadataSchemaMetadataSchema mgsms=new GroupMetadataSchemaMetadataSchema();
    				String esquem=esquemas.get(i).toString();
    				mgsms.setContent(esquem);
    				ms.setGroupMetadataSchemaMetadataSchema(mgsms);
    				lista.add(ms);
    			}
    		}
    		MetadataSchema[] metadatasq=(MetadataSchema[])lista.toArray(new MetadataSchema[lista.size()]);
    		metaMetadata.getGroupMetaMetadataMetaMetadata().setMetadataSchema(metadatasq);
    	}catch (Exception e){
	       	String mensaje = "Error: No es posible insertar los esquemas";
		    logger.error(mensaje);
		    throw e;
	    } 
    }
    
    public void setIdiomasAv(String idioma) throws Exception{
//    	setIdioma(idioma);
    	Language language= null;
    	if(idioma !=null){
    		language= new Language();
	    	GroupLanguageLanguage gll= new GroupLanguageLanguage();
	    	
	    	gll.setContent(idioma);
	    	language.setGroupLanguageLanguage(gll);
    	}
    	
    	if (metaMetadata == null){
    		metaMetadata= new MetaMetadata();
	    }
	    
	    if (metaMetadata.getGroupMetaMetadataMetaMetadata() == null){
	    	es.pode.parseadorXML.castor.GroupMetaMetadataMetaMetadata gmmAux= new es.pode.parseadorXML.castor.GroupMetaMetadataMetaMetadata();
	    	metaMetadata.setGroupMetaMetadataMetaMetadata(gmmAux);
	    }
	    
	    metaMetadata.getGroupMetaMetadataMetaMetadata().setLanguage(language);
    }
}

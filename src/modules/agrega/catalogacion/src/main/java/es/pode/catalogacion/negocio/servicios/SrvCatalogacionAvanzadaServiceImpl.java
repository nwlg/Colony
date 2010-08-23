/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.catalogacion.negocio.servicios;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.castor.Annotation;
import es.pode.parseadorXML.castor.Classification;
import es.pode.parseadorXML.castor.Educational;
import es.pode.parseadorXML.castor.General;
import es.pode.parseadorXML.castor.GroupAnnotationAnnotation;
import es.pode.parseadorXML.castor.GroupClassificationClassification;
import es.pode.parseadorXML.castor.GroupEducationalEducational;
import es.pode.parseadorXML.castor.GroupGeneralGeneral;
import es.pode.parseadorXML.castor.GroupLifeCycleLifeCycle;
import es.pode.parseadorXML.castor.GroupMetaMetadataMetaMetadata;
import es.pode.parseadorXML.castor.GroupRelationRelation;
import es.pode.parseadorXML.castor.GroupRightsRights;
import es.pode.parseadorXML.castor.GroupTechnicalTechnical;
import es.pode.parseadorXML.castor.LifeCycle;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.castor.MetaMetadata;
import es.pode.parseadorXML.castor.Relation;
import es.pode.parseadorXML.castor.Rights;
import es.pode.parseadorXML.castor.Technical;


/**
 * @see es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService
 */

public class SrvCatalogacionAvanzadaServiceImpl
    extends es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaServiceBase
{

	private  Logger logger = Logger.getLogger(this.getClass());
//	private LomESDao lomesDao=null;
	private HashMap tablaHash=new HashMap();
//	private MapperIF beanMapperAux = null;
//	private CatalogacionDozerDao catalogacionDao;
	



    

    /** Para obtener un lomAvanzado de un Lom
	 * 
	 * @param identificador Identificador del objeto Lom
	 * @param usuario Nombre del usuario
	 * @param idioma Idioma del objeto Lom
	 * @return LomAvanzadoVO Objeto donde se almacenan los datos de todos los campos.
	 * @throws Exception
	 * */
    
    protected es.pode.catalogacion.negocio.servicios.LomAvanzadoVO handleObtenerLomAvanzado(java.lang.String identificador, java.lang.String usuario, java.lang.String idioma)
        throws java.lang.Exception
    {
//      //**********************************************************
//        String lom1="C:/Metadatos/metadatoLote1.xml";
//        File lomFile1 = new File(lom1);
//        Lom lomObj1 = this.getLomesDao().parsearLom(lomFile1);
//        tablaHash.put("idLOM1", lomObj1);
//      //**********************************************************
    	logger.debug("ASC - OBTENERLOMAVANZADO IDENTIFICADOR " + identificador);
    	
        Lom lomObj=(Lom) tablaHash.get(identificador);
        LomAvanzadoVO lomAvan = new LomAvanzadoVO();
        try{
			if(lomObj!=null){
        
		        //General
				if(lomObj.getGeneral()!=null){
					AvGeneralVO rec=(AvGeneralVO) this.getBeanMapper().map(lomObj.getGeneral().getGroupGeneralGeneral(), AvGeneralVO.class);
					lomAvan.setGeneral(rec);
					logger.debug("ASC - OBTENERLOMAVANZADO general" + rec);
				}
				
		        //Educationals
				if((lomObj.getEducational()!=null)&&(lomObj.getEducational().length>0)){
			        AvEducationalVO[] eduArray = new AvEducationalVO[lomObj.getEducationalCount()];
			        for(int i=0;i<lomObj.getEducationalCount();i++){
			        	AvEducationalVO eduav = (AvEducationalVO) this.getBeanMapper().map(lomObj.getEducational(i).getGroupEducationalEducational(), AvEducationalVO.class);
			        	
			        	eduArray[i] = eduav; 
			        }
			        lomAvan.setEducational(eduArray);
			        logger.debug("ASC - OBTENERLOMAVANZADO educationals " + eduArray.length);
				}
		        
		        //LifeCycle
		        if(lomObj.getLifeCycle()!=null){
		        	AvLifeCycleVO life=(AvLifeCycleVO)this.getBeanMapper().map(lomObj.getLifeCycle().getGroupLifeCycleLifeCycle(), AvLifeCycleVO.class);
		        	lomAvan.setLifeCycle(life);
		        	logger.debug("ASC - OBTENERLOMAVANZADO lifeCycle " + life);
		        }	
		        
		        //Technical
		        if(lomObj.getTechnical()!=null){
			        AvTechnicalVO tech=(AvTechnicalVO)this.getBeanMapper().map(lomObj.getTechnical().getGroupTechnicalTechnical(), AvTechnicalVO.class);
			        lomAvan.setTechnical(tech);
			        logger.debug("ASC - OBTENERLOMAVANZADO technical " + tech);
		        }
		        
		        //MetaData
		        if(lomObj.getMetaMetadata()!=null){
		        	AvMetametadataVO meta=(AvMetametadataVO)this.getBeanMapper().map(lomObj.getMetaMetadata().getGroupMetaMetadataMetaMetadata(), AvMetametadataVO.class);
		        	lomAvan.setMetaMetadata(meta);
		        	logger.debug("ASC - OBTENERLOMAVANZADO MetaData" + meta);
		        }
		        
		        //Derechos
		        if(lomObj.getRights()!=null){
			        AvRightsVO rights=(AvRightsVO)this.getBeanMapper().map(lomObj.getRights().getGroupRightsRights(), AvRightsVO.class);
			        lomAvan.setDerechos(rights);
			        logger.debug("ASC - OBTENERLOMAVANZADO derechos " + rights);
		        }
		       
		        //Relaciones
		        if((lomObj.getRelation()!=null)&&(lomObj.getRelation().length>0)){
			        AvRelationVO[] relArray = new AvRelationVO[lomObj.getRelationCount()];
			        for(int i=0;i<lomObj.getRelationCount();i++){
			        	AvRelationVO relav = (AvRelationVO) this.getBeanMapper().map(lomObj.getRelation(i).getGroupRelationRelation(), AvRelationVO.class);
			        	relArray[i] = relav; 
			        }
			        lomAvan.setRelaciones(relArray);
			        logger.debug("ASC - OBTENERLOMAVANZADO relaciones " + relArray.length);
		        }
		        
		        //Annotationes
		        if((lomObj.getAnnotation()!=null)&&(lomObj.getAnnotation().length>0)){
			        AvAnnotationVO[] anotaArray = new AvAnnotationVO[lomObj.getAnnotationCount()];
			        for(int i=0;i<lomObj.getAnnotationCount();i++){
			        	AvAnnotationVO anotaVo = (AvAnnotationVO) this.getBeanMapper().map(lomObj.getAnnotation(i).getGroupAnnotationAnnotation(), AvAnnotationVO.class);
			        	anotaArray[i] = anotaVo; 
			        }
			        lomAvan.setAnotaciones(anotaArray);
			        logger.debug("ASC - OBTENERLOMAVANZADO anotaciones " + anotaArray.length );
		        }
		        
		        //Classificationes
		        if((lomObj.getClassification()!=null)&&(lomObj.getClassification().length>0)){
			        AvClassificationVO[] claArray = new AvClassificationVO[lomObj.getClassificationCount()];
			        for(int i=0;i<lomObj.getClassificationCount();i++){
			        	AvClassificationVO relav = (AvClassificationVO) this.getBeanMapper().map(lomObj.getClassification(i).getGroupClassificationClassification(), AvClassificationVO.class);
			        	claArray[i] = relav; 
			        }
			        lomAvan.setClasificaciones(claArray); 
			        logger.debug("ASC - OBTENERLOMAVANZADO clasificaciones " + claArray.length);
		        }
		        
			}else{
				throw new  Exception("El Objeto LOM no esta en la Tabla Hash");
			}
			
    	
			}catch(Exception e){
    		logger.error(e);
    		throw e;
    	}

        return lomAvan;
    }

    /**
	 * Genera los datos de los nueve campos
	 * 
	 * @param identificador Identificador del objeto Lom
	 * @param usuario Nombre del usuario
	 * @param lomAvanzadoVO Objeto para almacenar los datos de los nueve campos
	 * @param idioma Idioma de navegacion del usuario
	 * @return lomAvanzadoVO Devuelve el lomAvanzadoVO
	 * @throws Exception
	 */
    
    protected es.pode.catalogacion.negocio.servicios.LomAvanzadoVO handleGenerarMetadatos(
    		java.lang.String identificador, 
    		java.lang.String usuario, 
    		es.pode.catalogacion.negocio.servicios.LomAvanzadoVO lomAvanzado, 
    		java.lang.String idioma)
        throws java.lang.Exception
    {
    	logger.debug("ASC- DENTRO DE GENERARMETADATOS");
    	Lom lomObj=(Lom) tablaHash.get(identificador);
   	 	LomAvanzadoVO lomVO=new LomAvanzadoVO();
   	 	try{
   	 		logger.debug("ASC- DENTRO DE TRY GENERARMETADATOS");
   	 		if (lomObj != null) {

		        General general = new General();
		        
		        LifeCycle life=new LifeCycle();
		        MetaMetadata metaData=new MetaMetadata();
		        Technical tec=new Technical();
		        Rights derechos=new Rights();
		
		        //General
		        AvGeneralVO gen=lomAvanzado.getGeneral();
		        if(gen!=null){
		        	//hay que introducir identificador UUID o MEC
	        		String catalogoPlat=AgregaPropertiesImpl.getInstance().getProperty("catalogo.agrega");
		   
	        		try{
	        			IdentificadorVO[] liden= gen.getIdentificadores();
			        	if ((liden != null)&&(liden.length>0)){  // tiene algun identificador
			        		logger.debug("NRM - HAY IDENTIFICADORES");
			        		boolean encontrado= false;
			        		int i= 0;
			        		while ((!encontrado)&&(i<liden.length)){  // se comprueba si el identificador ya esta en la lista de identificadores
			        			if (identificador.equals(liden[i].getEntrada())){
			        				encontrado= true;
			        			}
			        			else{
			        				i++;
			        			}
			        		}
			        		if (encontrado == false){  // si el identificador no esta en la lista, se añade en la primera posicion
			        			logger.debug("NRM - NO ESTA EL IDENTIFICADOR EN LA LISTA");
				        		ArrayList al= new ArrayList();
				        		
				        		IdentificadorVO idPlat= new IdentificadorVO();
				        		idPlat.setCatalogo(catalogoPlat);
				        		idPlat.setEntrada(identificador);
				        		al.add(idPlat);
				        		
				        		for (int j= 0; j<liden.length; j++){
				        			al.add(liden[j]);
				        		}

				        		IdentificadorVO[] identnews= (IdentificadorVO[]) al.toArray(new IdentificadorVO[al.size()]);
				        		gen.setIdentificadores(identnews);
				        		
				        	}
			        	}
			        	else{ // si la lista de identificadores esta vacia, se crea una nueva con un unico identificador
			        		logger.debug("NRM - NO HAY IDENTIFICADORES EN LA LISTA, SE AÑADE EL NUEVO");
			        		
			        		ArrayList al= new ArrayList();
			        		IdentificadorVO id= new IdentificadorVO();
			        		id.setCatalogo(catalogoPlat);
			        		id.setEntrada(identificador);
			        		al.add(id);
			        		
			        		IdentificadorVO[] identnews= (IdentificadorVO[]) al.toArray(new IdentificadorVO[al.size()]);
			        		
			        		gen.setIdentificadores(identnews);
			        	}
	        		} catch (Exception e){
	        			logger.error(e);
	        			throw e;
	        		}
		        	

		        	general.setGroupGeneralGeneral((GroupGeneralGeneral) this.getBeanMapper().map(gen, GroupGeneralGeneral.class));
		        }
		        	
		        
		        else if ((lomAvanzado.getAnotaciones() == null || lomAvanzado.getAnotaciones().length == 0) 
		        		&& (lomAvanzado.getClasificaciones() == null || lomAvanzado.getClasificaciones().length == 0) 
		        		&& (lomAvanzado.getEducational() == null || lomAvanzado.getEducational().length == 0)
		        		&& (lomAvanzado.getRelaciones() == null || lomAvanzado.getRelaciones().length == 0)
		        		&& lomAvanzado.getDerechos() == null && lomAvanzado.getLifeCycle() == null
		        		&& lomAvanzado.getMetaMetadata() == null && lomAvanzado.getTechnical() == null)
		        	//si las categorias están todas vacías no añadimos el identificador
		        	general = null;
		        
		        else {
		        	//si alguna categoria tiene datos, añadimos el identificador
		        	logger.debug("AOV - GENERAL ES VACIO, SE CREA Y SE AÑADE IDENTIFICADOR");
		        	
		        	gen = new AvGeneralVO();//general era null, entonces lo creamos y añadimos el identificador de plataforma
		        	//hay que introducir identificador UUID o MEC
		       
	        		String catalogoPlat=AgregaPropertiesImpl.getInstance().getProperty("catalogo.agrega");
	        		
	        		//creamos la lista de identificadores con el identificador de plataforma
	        		ArrayList al= new ArrayList();
	        		IdentificadorVO id= new IdentificadorVO();
	        		id.setCatalogo(catalogoPlat);
	        		id.setEntrada(identificador);
	        		al.add(id);
	        		
	        		IdentificadorVO[] identnews= (IdentificadorVO[]) al.toArray(new IdentificadorVO[al.size()]);
	        		
	        		gen.setIdentificadores(identnews);
	        		
		        	general.setGroupGeneralGeneral((GroupGeneralGeneral) this.getBeanMapper().map(gen, GroupGeneralGeneral.class));
		        	}
		  
		        
		        lomObj.setGeneral(general);
		        logger.debug("ASC - GENERARMETADATOS GENERAL" + general );
		        
		        //Educational
		        Educational[] education=new Educational[0];
		        AvEducationalVO[] eduav =lomAvanzado.getEducational();
		        GroupEducationalEducational edg = new GroupEducationalEducational();
		        ArrayList lEd=new ArrayList();
		        if((eduav!=null)&&(eduav.length>0)){
		       	 for(int i=0;i<eduav.length;i++){
		       		 Educational ed = new Educational();
		       		 edg =(GroupEducationalEducational) this.getBeanMapper().map(eduav[i], GroupEducationalEducational.class);
		       		 ed.setGroupEducationalEducational(edg);
		       		 lEd.add(ed);
		       	 }
		       	 education=(Educational[])lEd.toArray(new Educational[lEd.size()]);
		        } 
		        lomObj.setEducational(education); //inicializado a null arriba
		        logger.debug("ASC - GENERARMETADATOS EDUCATIONAL " + education);
		        
		        //LifeCycle
		        AvLifeCycleVO lif=lomAvanzado.getLifeCycle();
		        if(lif!=null)
		        	life.setGroupLifeCycleLifeCycle((GroupLifeCycleLifeCycle)this.getBeanMapper().map(lif, GroupLifeCycleLifeCycle.class));
		        else
		        	life = null;
		        lomObj.setLifeCycle(life);
		        logger.debug("ASC - GENERARMETADATOS LIFECYCLE " + life);
		        
		        //MetaMetadata
		        AvMetametadataVO meta=lomAvanzado.getMetaMetadata();
		        if(meta !=null){
		        	
		        	String esquemaAux=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
	        		String esquema= esquemaAux.toLowerCase();
		        	
	        		try{
	        			EsquemaDeMetadatosVO[] edm= meta.getEsquemas();
	        			if ((edm!=null)&&(edm.length>0)){
	        				logger.debug("NRM - HAY ESQUEMAS DE METADATOS");
			        		boolean encontrado= false;
			        		int i= 0;
			        		while ((!encontrado)&&(i<edm.length)){  // se comprueba si LOM-ESV1.0 ya esta en la lista de esquemas
			        			String esq = edm[i].getTexto().toLowerCase().trim();
        						esq= esq.replaceAll("\\.", "");
        						esq=esq.replaceAll(" ", "");
        						esquema = esquema.replaceAll("\\.", "");
        						esquema = esquema.replaceAll(" ", "");
        						esquema = esquema.toLowerCase().trim();
			        			if (esquema.equals(esq)){
			        				encontrado= true;
			        			}
			        			else{
			        				i++;
			        			}
			        		}
			        		if (encontrado == false){
			        			logger.debug("NRM - NO ESTA EL ESQUEMA DE METADATOS LOM-ESV1.0");
				        		ArrayList al= new ArrayList();
				        		
				        		EsquemaDeMetadatosVO eq= new EsquemaDeMetadatosVO();
				        		eq.setTexto(esquemaAux);
				        		
				        		al.add(eq);
				        		
				        		for (int j= 0; j<edm.length; j++){
				        			al.add(edm[j]);
				        		}

				        		EsquemaDeMetadatosVO[] eqnews= (EsquemaDeMetadatosVO[]) al.toArray(new EsquemaDeMetadatosVO[al.size()]);
				        		meta.setEsquemas(eqnews);
		        			}
			        	}else{ // si la lista de esquemas esta vacia, se crea una nueva con el LOM-ESV1.0
			        		logger.debug("NRM - NO HAY ESQUEMAS DE METADATOS EN LA LISTA, SE AÑADE EL LOM-ESV1.0");
			        		
			        		ArrayList al= new ArrayList();
			        		EsquemaDeMetadatosVO eq= new EsquemaDeMetadatosVO();
			        		eq.setTexto(esquemaAux);

			        		al.add(eq);
			        		
			        		EsquemaDeMetadatosVO[] eqnews= (EsquemaDeMetadatosVO[]) al.toArray(new EsquemaDeMetadatosVO[al.size()]);
			        		meta.setEsquemas(eqnews);
			        	}
	        			
	        		} catch (Exception e){
	        			logger.error(e);
	        			throw e;
	        		}

		        	metaData.setGroupMetaMetadataMetaMetadata((GroupMetaMetadataMetaMetadata)this.getBeanMapper().map(meta, GroupMetaMetadataMetaMetadata.class));
		        }
		        	
		        else if ((lomAvanzado.getAnotaciones() == null || lomAvanzado.getAnotaciones().length == 0) 
		        		&& (lomAvanzado.getClasificaciones() == null || lomAvanzado.getClasificaciones().length == 0) 
		        		&& (lomAvanzado.getEducational() == null || lomAvanzado.getEducational().length == 0)
		        		&& (lomAvanzado.getRelaciones() == null || lomAvanzado.getRelaciones().length == 0)
		        		&& lomAvanzado.getDerechos() == null && lomAvanzado.getLifeCycle() == null
		        		&& lomAvanzado.getGeneral() == null && lomAvanzado.getTechnical() == null)
		        	//si las categorias están todas vacías no añadimos el identificador
		        	metaData = null;
		        
		        else {
		        	logger.debug("AOV - META-METADATA ES VACIO, SE CREA Y SE AÑADE ESQUEMA DE METADATOS");
		        	
		        	meta = new AvMetametadataVO();//metametadata era null, entonces lo creamos y añadimos el esquema de metadatos
		
	            	String esquema=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
	        			        		
	        		//creamos la lista de esquemas de metadatos con el esquema de la plataforma
	        		ArrayList al= new ArrayList();
	        		EsquemaDeMetadatosVO eq= new EsquemaDeMetadatosVO();
	        		eq.setTexto(esquema);

	        		al.add(eq);
	        		
	        		EsquemaDeMetadatosVO[] eqnews= (EsquemaDeMetadatosVO[]) al.toArray(new EsquemaDeMetadatosVO[al.size()]);
	        		meta.setEsquemas(eqnews);	
	        		
	        		metaData.setGroupMetaMetadataMetaMetadata((GroupMetaMetadataMetaMetadata)this.getBeanMapper().map(meta, GroupMetaMetadataMetaMetadata.class));
		        }
		        lomObj.setMetaMetadata(metaData);
		        logger.debug("ASC - GENERARMETADATOS METAMETADATA" + metaData);
		        
		        //Technical
		        AvTechnicalVO tech=lomAvanzado.getTechnical();
		        if(tech!=null)
		        	tec.setGroupTechnicalTechnical((GroupTechnicalTechnical)this.getBeanMapper().map(tech, GroupTechnicalTechnical.class));
		        else 
		        	tec = null;
		        lomObj.setTechnical(tec);
		        logger.debug("ASC - GENERARMETADATOS TECHNICAL " + tec);
		        
		        //Rights
		        AvRightsVO right=lomAvanzado.getDerechos();
		        if (right!=null)
		        	derechos.setGroupRightsRights((GroupRightsRights)this.getBeanMapper().map(right, GroupRightsRights.class));
		        else
		        	derechos =null;
		        lomObj.setRights(derechos);
		        logger.debug("ASC - GENERARMETADATOS RIGHTS " + derechos);
		        
		        //Relations
		        Relation[] relacion=new Relation[0];
		        AvRelationVO[] relav =lomAvanzado.getRelaciones();
		        GroupRelationRelation grr = new GroupRelationRelation();
		        ArrayList lRe=new ArrayList();
		        
		        if((relav!=null)&&(relav.length>0)){
		          	 for(int i=0;i<relav.length;i++){
		          		 Relation relation=new Relation();
		          		 grr =(GroupRelationRelation) this.getBeanMapper().map(relav[i], GroupRelationRelation.class);
		          		 relation.setGroupRelationRelation(grr);
		          		 lRe.add(relation);
		          	 }
		          	relacion=(Relation[])lRe.toArray(new Relation[lRe.size()]);
		        }
		        lomObj.setRelation(relacion);//inicializado a null arriba
		        logger.debug("ASC - GENERARMETADATOS RELACION " + relacion);
		        
		        //annotations
		        Annotation[] anotacion=new Annotation[0];
		        logger.debug("ASC- GUARDARMETADADOS ANOTATION INICIALIZADO LONG "+  anotacion.length);
		        AvAnnotationVO[] anav =lomAvanzado.getAnotaciones();
		        GroupAnnotationAnnotation gaa = new GroupAnnotationAnnotation();
		        ArrayList lAn=new ArrayList();
		        
		        if((anav!=null)&&(anav.length>0)){
		          	 for(int i=0;i<anav.length;i++){
		          		 Annotation annotation=new Annotation();
		          		 gaa =(GroupAnnotationAnnotation) this.getBeanMapper().map(anav[i], GroupAnnotationAnnotation.class);
		          		 annotation.setGroupAnnotationAnnotation(gaa);
		          		 lAn.add(annotation);
		          	 }
		          	anotacion=(Annotation[])lAn.toArray(new Annotation[lAn.size()]);
		          	logger.debug("ASC- GUARDARMETADADOS ANOTATION DESPUES DE METER DATOS LONG "+  anotacion.length);
		        }
		        lomObj.setAnnotation(anotacion);
		        logger.debug("ASC -GENERARMETADATOS ANOTACION " + anotacion); //inicializado a null arriba
		        
		        //Classifications
		        Classification[] clasificacion=new Classification[0];
		        AvClassificationVO[] claav =lomAvanzado.getClasificaciones();
		        GroupClassificationClassification gcc = new GroupClassificationClassification();
		        ArrayList lCla=new ArrayList();
		        
		        if((claav!=null)&&(claav.length>0)){
		          	 for(int i=0;i<claav.length;i++){
		          		 Classification classification=new Classification();
		          		 gcc =(GroupClassificationClassification) this.getBeanMapper().map(claav[i], GroupClassificationClassification.class);
		          		 classification.setGroupClassificationClassification(gcc);
		          		 lCla.add(classification);
		          	 }
		          	clasificacion=(Classification[])lCla.toArray(new Classification[lCla.size()]);
		         }
		        lomObj.setClassification(clasificacion);
		        logger.debug("ASC -GENERARMETADATOS CLASIFICACION " + clasificacion);//inicializado a null arriba

		        tablaHash.put(identificador, lomObj);
		        if( logger.isDebugEnabled() )
		            logger.debug("Añadido el lomObj después de generar los metadatos" );
		        
	   	 	}else{
				
	//			 el objeto lom no esta en la tabla hash y da un error
				throw new  Exception("El Objeto LOM no esta en la Tabla Hash");
			}
	
		}catch(Exception e){
			
			logger.error(e);
			throw e;
		}
	return lomVO;
  
    }

    /** Para la carga de los objetos LOM
	 * 
	 * @param identificador Identificador del objeto Lom
	 * @param usuario Nombre del usuario
	 * @param lomHandler Un dataHandler que contiene los datos de lomes
	 * @return identificador Identificador del objeto Lom
	 * @throws Exception
	 * */
    
    protected java.lang.String handleCargarObjLom(java.lang.String identificador, java.lang.String usuario, javax.activation.DataHandler lom)
        throws java.lang.Exception
    {
    	if (lom.getContentType().equals("application/x-java-serialized-object"))
		{
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			lom.writeTo(baos);
			Object tmp = deserializar(baos.toByteArray());
			Lom lomObj = null;
			if (tmp instanceof Lom)
				lomObj = (Lom) tmp;
			else {
				Logger.getLogger(this.getClass()).error(
						"El objeto recibido no es un LOM_ES");
				throw new Exception("El objeto recibido no es un LOM_ES");
			}
			if (tablaHash==null){
				tablaHash=new HashMap();
			}
			tablaHash.put(identificador,lomObj);
			
			
			if( logger.isDebugEnabled() )

                logger.debug("Cargado objeto Lom con identificador " +identificador );

		}
		else
			throw new Exception ("No existe objeto para cargar");


	return identificador;
        
        
    }

    /**Elimina los objetos LOM 
	 * 
	 * @param ids Array de identificadores de los objetos Lom a eliminar
	 * @throws Exception
	 * */
    protected void handleEliminarObjLoms(java.lang.String[] ids)
        throws java.lang.Exception
    {
    	for (int i=0;i<ids.length;i++){
			
			//Borramos los Lom con los identificadores que nos pasan
			tablaHash.remove(ids[i]);
			if( logger.isDebugEnabled() )

                logger.debug("Eliminado el objeto lom con identificador "+ids[i] );
			
		}
    }

    public void escribe(LomAvanzadoVO lomAvan) throws ParseadorException{

    }
    /**
	 * Obtiene los objetos Lom correspondientes a los identificadores del array de identificadores
	 * 
	 * @param ids Array de identificadores de objetos lom
	 * @return idLomVO[] Array de pares (identificador, objeto Lom)
	 * @throws Exception
	 */
    protected es.pode.catalogacion.negocio.servicios.IdLomVO[] handleObtenerObjLoms(java.lang.String[] ids)
        throws java.lang.Exception
    {
    	List idLomVO=new ArrayList();
		
		for(int i=0;i<ids.length;i++){
			//Recogemos el lom con el identificador ids[i] 
			Lom lomObj=(Lom) tablaHash.get(ids[i]);
			//Si el lomObj es distinto de null lo añadimos al LomHandler, si no, no hacemos nada
			if(lomObj!=null){
				
				IdLomVO idLom=new IdLomVO();
				DataHandler dh=null;
				
				byte[] bytes = serializar(lomObj);
				ByteArrayDataSource bads = new ByteArrayDataSource(bytes,
						"application/x-java-serialized-object");
				dh = new DataHandler(bads);
				idLom.setId(ids[i]);
				idLom.setLomHandler(dh);
				
				//Recogemos el id y el lomHandler en el idLomVO
				idLomVO.add(idLom);
				if( logger.isDebugEnabled() )

                    logger.debug("Recogido objeto lom con identificador "+ids[i] );
			}
		}

		return (IdLomVO[]) idLomVO.toArray(new IdLomVO[ids.length]);
    }

    
    public HashMap getTablaHash() {
		return tablaHash;
	}

	public void setTablaHash(HashMap tablaHash) {
		this.tablaHash = tablaHash;
	}
	
//	public CatalogacionDozerDao getCatalogacionDao() {
//		return catalogacionDao;
//	}
//
//	public void setCatalogacionDao(CatalogacionDozerDao catalogacionDao) {
//		this.catalogacionDao = catalogacionDao;
//	}
//
//	public LomESDao getLomesDao() {
//		return lomesDao;
//	}
//
//	public void setLomesDao(LomESDao lomesDao) {
//		this.lomesDao = lomesDao;
//	}
	
	/**
	 * Deserializa un array de bytes  en un objeto 
	 * 
	 * @param entrada Array de bytes
	 * @return salida Un object
	 * @throws IOException
	 */
	
	private Object deserializar(byte[] entrada) throws IOException {
		ByteArrayInputStream bs = new ByteArrayInputStream(entrada);
		ObjectInputStream is = new ObjectInputStream(bs);
		Object salida = null;
		try {
			salida = is.readObject();
		} catch (IOException e) {
			logger.error("Ha fallado al deserializar el objeto "+ e);
		} catch (ClassNotFoundException e) {
			logger.error(e);
		}
		is.close();
		return salida;
	}
	
	/**
	 * Serializa un objeto en un array de bytes
	 * 
	 * @param entrada Un objeto para serializar
	 * @return bytes Un array de bytes que contiene el objeto serializado
	 * @throws IOException
	 */
	
	private byte[] serializar(Object entrada) throws IOException {

		ByteArrayOutputStream bs = new ByteArrayOutputStream();
		ObjectOutputStream os;
		byte[] bytes = null;
		os = new ObjectOutputStream(bs);
		os.writeObject(entrada);
		os.close();
		bytes = bs.toByteArray();

		return bytes;
	}

	
	
	
	/**
	 * Permite exportar un fichero xml de catalogación LOM-ES avanzado encapsulado 
	 * en un DataHandler.
	 * 
	 * @param identificador  Identificador del ode que se quiere catalogar
	 * @param usuario 		 nombre de usuario 
	 * @param lomAvanzado    LomAvanzado que representa la catalogación que se intenta exportar
	 * @param idioma 		 Idioma en que se intenta exportar la catalogación
	 * @return DataHandler 	 DataHandler que encapsula el fichero xml en que se exporta la catalogación
	 * @throws Exception    
	 */
	protected DataHandler handleExportarLomes(
			String identificador, 
			String usuario, 
			LomAvanzadoVO lomAvanzado, 
			String idioma) 
	throws Exception 
	{
    	String ficheroProperties="/catalogacion.properties";
    	Properties fproperties=new Properties();
    	fproperties.load(this.getClass().getResourceAsStream(ficheroProperties));

		//genero el lom 
		Lom lom= new Lom();
		try{
	        General general = new General();
	        LifeCycle life=new LifeCycle();
	        MetaMetadata metaData=new MetaMetadata();
	        Technical tec=new Technical();
	        Rights derechos=new Rights();
	        
//General
	        AvGeneralVO gen=lomAvanzado.getGeneral();
	        if(gen!=null){
	        	//hay que introducir identificador UUID o MEC
        		
        		String catalogoPlat=AgregaPropertiesImpl.getInstance().getProperty("catalogo.agrega");
	   
        		try{
        			IdentificadorVO[] liden= gen.getIdentificadores();
		        	if ((liden != null)&&(liden.length>0)){  // tiene algun identificador
		        		logger.debug("PLLecf - HAY IDENTIFICADORES");
		        		boolean encontrado= false;
		        		int i= 0;
		        		while ((!encontrado)&&(i<liden.length)){  // se comprueba si el identificador ya esta en la lista de identificadores
		        			if (identificador.equals(liden[i].getEntrada())){
		        				encontrado= true;
		        			}
		        			else{
		        				i++;
		        			}
		        		}
		        		if (encontrado == false){  // si el identificador no esta en la lista, se añade en la primera posicion
		        			logger.debug("PLLecf - NO ESTA EL IDENTIFICADOR EN LA LISTA");
			        		ArrayList al= new ArrayList();
			        		
			        		IdentificadorVO idPlat= new IdentificadorVO();
			        		idPlat.setCatalogo(catalogoPlat);
			        		idPlat.setEntrada(identificador);
			        		al.add(idPlat);
			        		
			        		for (int j= 0; j<liden.length; j++){
			        			al.add(liden[j]);
			        		}

			        		IdentificadorVO[] identnews= (IdentificadorVO[]) al.toArray(new IdentificadorVO[al.size()]);
			        		gen.setIdentificadores(identnews);
			        		
			        	}
		        	}
		        	else{ // si la lista de identificadores esta vacia, se crea una nueva con un unico identificador
		        		logger.debug("PLLecf - NO HAY IDENTIFICADORES EN LA LISTA, SE AÑADE EL NUEVO");
		        		
		        		ArrayList al= new ArrayList();
		        		IdentificadorVO id= new IdentificadorVO();
		        		id.setCatalogo(catalogoPlat);
		        		id.setEntrada(identificador);
		        		al.add(id);
		        		
		        		IdentificadorVO[] identnews= (IdentificadorVO[]) al.toArray(new IdentificadorVO[al.size()]);
		        		
		        		gen.setIdentificadores(identnews);
		        	}
        		} catch (Exception e){
        			logger.error(e);
        			throw e;
        		}
	        	

	        	general.setGroupGeneralGeneral((GroupGeneralGeneral) this.getBeanMapper().map(gen, GroupGeneralGeneral.class));
	        }
	        	
	        
	        else
	        	general = null;
	        lom.setGeneral(general);
	        logger.debug("PLLecf - GENERARMETADATOS GENERAL" + general );
	        

//Educational
	        Educational[] education=new Educational[0];
	        AvEducationalVO[] eduav =lomAvanzado.getEducational();
	        GroupEducationalEducational edg = new GroupEducationalEducational();
	        ArrayList lEd=new ArrayList();
	        if((eduav!=null)&&(eduav.length>0)){
	       	 for(int i=0;i<eduav.length;i++){
	       		 Educational ed = new Educational();
	       		 edg =(GroupEducationalEducational) this.getBeanMapper().map(eduav[i], GroupEducationalEducational.class);
	       		 ed.setGroupEducationalEducational(edg);
	       		 lEd.add(ed);
	       	 }
	       	 education=(Educational[])lEd.toArray(new Educational[lEd.size()]);
	        } 
	        lom.setEducational(education); //inicializado a null arriba
	        logger.debug("PLLecf - GENERARMETADATOS EDUCATIONAL " + education);
	        
//LifeCycle
	        AvLifeCycleVO lif=lomAvanzado.getLifeCycle();
	        if(lif!=null)
	        	life.setGroupLifeCycleLifeCycle((GroupLifeCycleLifeCycle)this.getBeanMapper().map(lif, GroupLifeCycleLifeCycle.class));
	        else
	        	life = null;
	        lom.setLifeCycle(life);
	        logger.debug("PLLecf - GENERARMETADATOS LIFECYCLE " + life);
	        
//MetaMetadata
	        AvMetametadataVO meta=lomAvanzado.getMetaMetadata();
	        if(meta !=null){
	        	
	        	String esquemaAux=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
        		String esquema= esquemaAux.toLowerCase();
	        	
        		try{
        			EsquemaDeMetadatosVO[] edm= meta.getEsquemas();
        			if ((edm!=null)&&(edm.length>0)){
        				logger.debug("PLLecf - HAY ESQUEMAS DE METADATOS");
		        		boolean encontrado= false;
		        		int i= 0;
		        		while ((!encontrado)&&(i<edm.length)){  // se comprueba si LOM-ESV1.0 ya esta en la lista de esquemas
		        			String esq = edm[i].getTexto().toLowerCase().trim();
    						esq= esq.replaceAll("\\.", "");
    						esq=esq.replaceAll(" ", "");
    						esquema = esquema.replaceAll("\\.", "");
    						esquema = esquema.replaceAll(" ", "");
    						esquema = esquema.toLowerCase().trim();
		        			if (esquema.equals(esq)){
		        				encontrado= true;
		        			}
		        			else{
		        				i++;
		        			}
		        		}
		        		if (encontrado == false){
		        			logger.debug("PLLecf - NO ESTA EL ESQUEMA DE METADATOS LOM-ESV1.0");
			        		ArrayList al= new ArrayList();
			        		
			        		EsquemaDeMetadatosVO eq= new EsquemaDeMetadatosVO();
			        		eq.setTexto(esquemaAux);
			        		
			        		al.add(eq);
			        		
			        		for (int j= 0; j<edm.length; j++){
			        			al.add(edm[j]);
			        		}

			        		EsquemaDeMetadatosVO[] eqnews= (EsquemaDeMetadatosVO[]) al.toArray(new EsquemaDeMetadatosVO[al.size()]);
			        		meta.setEsquemas(eqnews);
	        			}
		        	}else{ // si la lista de esquemas esta vacia, se crea una nueva con el LOM-ESV1.0
		        		logger.debug("PLLecf - NO HAY ESQUEMAS DE METADATOS EN LA LISTA, SE AÑADE EL LOM-ESV1.0");
		        		
		        		ArrayList al= new ArrayList();
		        		EsquemaDeMetadatosVO eq= new EsquemaDeMetadatosVO();
		        		eq.setTexto(esquemaAux);

		        		al.add(eq);
		        		
		        		EsquemaDeMetadatosVO[] eqnews= (EsquemaDeMetadatosVO[]) al.toArray(new EsquemaDeMetadatosVO[al.size()]);
		        		meta.setEsquemas(eqnews);
		        	}
        			
        		} catch (Exception e){
        			logger.error(e);
        			throw e;
        		}

	        	metaData.setGroupMetaMetadataMetaMetadata((GroupMetaMetadataMetaMetadata)this.getBeanMapper().map(meta, GroupMetaMetadataMetaMetadata.class));
	        }else
	        	metaData = null;
	        lom.setMetaMetadata(metaData);
	        logger.debug("PLLecf - GENERARMETADATOS METAMETADATA" + metaData);
	        
//Technical
	        AvTechnicalVO tech=lomAvanzado.getTechnical();
	        if(tech!=null)
	        	tec.setGroupTechnicalTechnical((GroupTechnicalTechnical)this.getBeanMapper().map(tech, GroupTechnicalTechnical.class));
	        else 
	        	tec = null;
	        lom.setTechnical(tec);
	        logger.debug("PLLecf - GENERARMETADATOS TECHNICAL " + tec);
	        
//Rights
	        AvRightsVO right=lomAvanzado.getDerechos();
	        if (right!=null)
	        	derechos.setGroupRightsRights((GroupRightsRights)this.getBeanMapper().map(right, GroupRightsRights.class));
	        else
	        	derechos =null;
	        lom.setRights(derechos);
	        logger.debug("PLLecf - GENERARMETADATOS RIGHTS " + derechos);
	        
//Relations
	        Relation[] relacion=new Relation[0];
	        AvRelationVO[] relav =lomAvanzado.getRelaciones();
	        GroupRelationRelation grr = new GroupRelationRelation();
	        ArrayList lRe=new ArrayList();
	        
	        if((relav!=null)&&(relav.length>0)){
	          	 for(int i=0;i<relav.length;i++){
	          		 Relation relation=new Relation();
	          		 grr =(GroupRelationRelation) this.getBeanMapper().map(relav[i], GroupRelationRelation.class);
	          		 relation.setGroupRelationRelation(grr);
	          		 lRe.add(relation);
	          	 }
	          	relacion=(Relation[])lRe.toArray(new Relation[lRe.size()]);
	        }
	        lom.setRelation(relacion);//inicializado a null arriba
	        logger.debug("PLLecf - GENERARMETADATOS RELACION " + relacion);
	        
//annotations
	        Annotation[] anotacion=new Annotation[0];
	        logger.debug("PLLecf- GUARDARMETADADOS ANOTATION INICIALIZADO LONG "+  anotacion.length);
	        AvAnnotationVO[] anav =lomAvanzado.getAnotaciones();
	        GroupAnnotationAnnotation gaa = new GroupAnnotationAnnotation();
	        ArrayList lAn=new ArrayList();
	        
	        if((anav!=null)&&(anav.length>0)){
	          	 for(int i=0;i<anav.length;i++){
	          		 Annotation annotation=new Annotation();
	          		 gaa =(GroupAnnotationAnnotation) this.getBeanMapper().map(anav[i], GroupAnnotationAnnotation.class);
	          		 annotation.setGroupAnnotationAnnotation(gaa);
	          		 lAn.add(annotation);
	          	 }
	          	anotacion=(Annotation[])lAn.toArray(new Annotation[lAn.size()]);
	          	logger.debug("PLLecf- GUARDARMETADADOS ANOTATION DESPUES DE METER DATOS LONG "+  anotacion.length);
	        }
	        lom.setAnnotation(anotacion);
	        logger.debug("PLLecf -GENERARMETADATOS ANOTACION " + anotacion); //inicializado a null arriba
	        
//Classifications
	        Classification[] clasificacion=new Classification[0];
	        AvClassificationVO[] claav =lomAvanzado.getClasificaciones();
	        GroupClassificationClassification gcc = new GroupClassificationClassification();
	        ArrayList lCla=new ArrayList();
	        
	        if((claav!=null)&&(claav.length>0)){
	          	 for(int i=0;i<claav.length;i++){
	          		 Classification classification=new Classification();
	          		 gcc =(GroupClassificationClassification) this.getBeanMapper().map(claav[i], GroupClassificationClassification.class);
	          		 classification.setGroupClassificationClassification(gcc);
	          		 lCla.add(classification);
	          	 }
	          	clasificacion=(Classification[])lCla.toArray(new Classification[lCla.size()]);
	         }
	        lom.setClassification(clasificacion);
	        logger.debug("PLLecf -GENERARMETADATOS CLASIFICACION " + clasificacion);//inicializado a null arriba
	        
		}catch (Exception e) {
			logger.error("PLL - error en SrvCatalogacionAvanzadaService.ExportarLomes: error al generar objeto Lom desde un LomAvanzadoVO " + e);
			throw e;
		}

		
		
		//declaro el data handler
		DataHandler dh=null;
		try {
			//creo un writer para escribir los metadatos
			StringWriter sw= new StringWriter();
			//completo el writer
			this.getLomesDao().escribirLom(lom, sw);
//			lomesDao.escribirLom(lom, sw);
			//creo el datahandler con el string del writer
			dh = new DataHandler(sw.toString(),"text/xml;charset=utf-8");
			
		} catch (Exception e) {
			logger.error("PLL - error en SrvCatalogacionAvanzadaService.ExportarLomes: error al generar el contenido a exportar " + e);
			throw e;
		}
		//regreso el datahandler
		return dh;
	}

	
	
	
	/**
	 * Permite obtener un objeto LomAvanzadoVO desde un fichero xml.
	 * 
	 * @param  ficheroLomes 	DataHandler que encapsula el fichero xml en que se exporta la catalogación
	 * @return LomAvanzadoVO 	objeto LomAvanzadoVO con los datos importados desde el xml
	 * @throws Exception    
	 */

	protected LomAvanzadoVO handleImportarLomes(
			DataHandler ficheroLomes) 
	throws Exception 
	{
		
		//obtener lomAvanzadoVO desde lom
        LomAvanzadoVO lomAvan = new LomAvanzadoVO();
        try{
    		InputStream is= ficheroLomes.getInputStream();
    		InputSource iso= new InputSource(is);

        	//parsear el file
//    		Lom lomObj = lomesDao.parsearLom(iso);
    		Lom lomObj = this.getLomesDao().parsearLom(iso);

        	if(lomObj!=null){
        
		        //General
				if(lomObj.getGeneral()!=null){
					AvGeneralVO rec=(AvGeneralVO) this.getBeanMapper().map(lomObj.getGeneral().getGroupGeneralGeneral(), AvGeneralVO.class);
					lomAvan.setGeneral(rec);
					logger.debug("PLLecf - IMPORTARLOMES general" + rec);
				}
				
		        //Educationals
				if((lomObj.getEducational()!=null)&&(lomObj.getEducational().length>0)){
			        AvEducationalVO[] eduArray = new AvEducationalVO[lomObj.getEducationalCount()];
			        for(int i=0;i<lomObj.getEducationalCount();i++){
			        	AvEducationalVO eduav = (AvEducationalVO) this.getBeanMapper().map(lomObj.getEducational(i).getGroupEducationalEducational(), AvEducationalVO.class);
			        	eduArray[i] = eduav; 
			        }
			        lomAvan.setEducational(eduArray);
			        logger.debug("PLLecf - IMPORTARLOMES educationals " + eduArray.length);
				}
		        
		        //LifeCycle
		        if(lomObj.getLifeCycle()!=null){
		        	AvLifeCycleVO life=(AvLifeCycleVO)this.getBeanMapper().map(lomObj.getLifeCycle().getGroupLifeCycleLifeCycle(), AvLifeCycleVO.class);
		        	lomAvan.setLifeCycle(life);
		        	logger.debug("PLLecf - IMPORTARLOMES lifeCycle " + life);
		        }	
		        
		        //Technical
		        if(lomObj.getTechnical()!=null){
			        AvTechnicalVO tech=(AvTechnicalVO)this.getBeanMapper().map(lomObj.getTechnical().getGroupTechnicalTechnical(), AvTechnicalVO.class);
			        lomAvan.setTechnical(tech);
			        logger.debug("PLLecf - IMPORTARLOMES technical " + tech);
		        }
		        
		        //MetaData
		        if(lomObj.getMetaMetadata()!=null){
		        	AvMetametadataVO meta=(AvMetametadataVO)this.getBeanMapper().map(lomObj.getMetaMetadata().getGroupMetaMetadataMetaMetadata(), AvMetametadataVO.class);
		        	lomAvan.setMetaMetadata(meta);
		        	logger.debug("PLLecf - IMPORTARLOMES MetaData" + meta);
		        }
		        
		        //Derechos
		        if(lomObj.getRights()!=null){
			        AvRightsVO rights=(AvRightsVO)this.getBeanMapper().map(lomObj.getRights().getGroupRightsRights(), AvRightsVO.class);
			        lomAvan.setDerechos(rights);
			        logger.debug("PLLecf - IMPORTARLOMES derechos " + rights);
		        }
		       
		        //Relaciones
		        if((lomObj.getRelation()!=null)&&(lomObj.getRelation().length>0)){
			        AvRelationVO[] relArray = new AvRelationVO[lomObj.getRelationCount()];
			        for(int i=0;i<lomObj.getRelationCount();i++){
			        	AvRelationVO relav = (AvRelationVO) this.getBeanMapper().map(lomObj.getRelation(i).getGroupRelationRelation(), AvRelationVO.class);
			        	relArray[i] = relav; 
			        }
			        lomAvan.setRelaciones(relArray);
			        logger.debug("PLLecf - IMPORTARLOMES relaciones " + relArray.length);
		        }
		        
		        //Annotationes
		        if((lomObj.getAnnotation()!=null)&&(lomObj.getAnnotation().length>0)){
			        AvAnnotationVO[] anotaArray = new AvAnnotationVO[lomObj.getAnnotationCount()];
			        for(int i=0;i<lomObj.getAnnotationCount();i++){
			        	AvAnnotationVO anotaVo = (AvAnnotationVO) this.getBeanMapper().map(lomObj.getAnnotation(i).getGroupAnnotationAnnotation(), AvAnnotationVO.class);
			        	anotaArray[i] = anotaVo; 
			        }
			        lomAvan.setAnotaciones(anotaArray);
			        logger.debug("PLLecf - IMPORTARLOMES anotaciones " + anotaArray.length );
		        }
		        
		        //Classificationes
		        if((lomObj.getClassification()!=null)&&(lomObj.getClassification().length>0)){
			        AvClassificationVO[] claArray = new AvClassificationVO[lomObj.getClassificationCount()];
			        for(int i=0;i<lomObj.getClassificationCount();i++){
			        	AvClassificationVO relav = (AvClassificationVO) this.getBeanMapper().map(lomObj.getClassification(i).getGroupClassificationClassification(), AvClassificationVO.class);
			        	claArray[i] = relav; 
			        }
			        lomAvan.setClasificaciones(claArray); 
			        logger.debug("PLLecf - IMPORTARLOMES clasificaciones " + claArray.length);
		        }
		        
			}else{
				throw new  Exception("El Objeto Lom es null--- no se pudo parsear");
			}
			
    	
			}catch(Exception e){
    		logger.error(e);
    		throw e;
    	}

		//devolver LomAvanzadoVO
		
        return lomAvan;		
	}
	/**
	 * Permite exportar un fichero xml de catalogación LOM-ES avanzado encapsulado 
	 * en un DataHandler.
	 * 
	 * @param identificador  Identificador del ode que se quiere catalogar
	 * @param usuario 		 nombre de usuario 
	 * @param lomAvanzado    LomAvanzado que representa la catalogación que se intenta exportar
	 * @param idioma 		 Idioma en que se intenta exportar la catalogación
	 * @return DataHandler 	 DataHandler que encapsula el fichero xml en que se exporta la catalogación
	 * @throws Exception    
	 */

	protected DataHandler handleExportarLomesDesdeLom(
			String identificador, 
			String usuario, 
			String idioma, 
			DataHandler lom) 
	throws Exception {

		//declaro el data handler
		DataHandler dh=null;
		Lom lomObj = null;
		try{
			if (lom.getContentType().equals("application/x-java-serialized-object"))
			{
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				lom.writeTo(baos);
				Object tmp = deserializar(baos.toByteArray());
				
				if (tmp instanceof Lom)
					lomObj = (Lom) tmp;
				else {
					Logger.getLogger(this.getClass()).error(
							"El objeto recibido no es un LOM_ES");
					throw new Exception("El objeto recibido no es un LOM_ES");
				}
	
			}
			else
				throw new Exception ("No existe objeto para cargar");
	
			//creo un writer para escribir los metadatos
			StringWriter sw= new StringWriter();
			//completo el writer
			this.getLomesDao().escribirLom(lomObj, sw);
//			lomesDao.escribirLom(lomObj, sw);
			//creo el datahandler con el string del writer
			dh = new DataHandler(sw.toString(),"text/plain");
				
		} catch (Exception e) {
			logger.error("PLL - error en SrvCatalogacionAvanzadaService.ExportarLom: error al generar el contenido a exportar " + e);
			throw e;
		}
		//regreso el datahandler
		return dh;
	}
}
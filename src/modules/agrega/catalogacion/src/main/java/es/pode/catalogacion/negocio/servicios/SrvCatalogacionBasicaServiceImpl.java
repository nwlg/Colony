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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;

import org.apache.log4j.Logger;
import org.xml.sax.InputSource;

import es.agrega.soporte.agregaProperties.AgregaPropertiesImpl;
import es.pode.parseadorXML.castor.Classification;
import es.pode.parseadorXML.castor.Educational;
import es.pode.parseadorXML.castor.General;
import es.pode.parseadorXML.castor.LifeCycle;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.castor.MetaMetadata;
import es.pode.parseadorXML.castor.Rights;
import es.pode.parseadorXML.lomes.lomesAgrega.ClassificationAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.EducationalAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.GeneralAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.LifeCycleAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.MetaMetadataAgrega;
import es.pode.parseadorXML.lomes.lomesAgrega.RightsAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class SrvCatalogacionBasicaServiceImpl
    extends es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceBase
{


//	private CatalogacionDozerDao catalogacionDao;
//	
//	private LomESDao lomesDao=null;
	
	private HashMap tablaHash=new HashMap();
	
	private  Logger logger = Logger.getLogger(this.getClass());

	/** Para la carga de los objetos LOM
	 * 
	 * @param identificador Identificador del objeto Lom
	 * @param usuario Nombre del usuario
	 * @param lomHandler Un dataHandler que contiene los datos de lomes
	 * @return identificador Identificador del objeto Lom
	 * @throws Exception
	 * */
	
	protected String handleCargarObjLom(String identificador, String usuario, DataHandler lomHandler) throws Exception
	{
		
			if (lomHandler.getContentType().equals("application/x-java-serialized-object"))
			{
				
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				lomHandler.writeTo(baos);
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
	
	/** Para obtener el Lom Basico del objeto Lom
	 * @param identificador Identificador del objeto Lom
	 * @param usuario Nombre del usuario
	 * @param idioma Idioma de navegacion del usuario
	 * @return LomVO Objeto donde se almacenan los datos obligatorios de los campos general y educational, y los árboles curriculares del campo classification
	 * @throws Exception
	 */
	protected LomBasicoVO handleObtenerLomBasico(String identificador, String usuario, String idioma) throws Exception
    {
//Obtiene del LOM de la tablahash el LomBasico.LomBasico contiene un general,ninguno o varios educational y ninguno o varios classification.
//General contiene titulo, descripción e idioma; Educational contiene Tipo de recurso, contexto,...;
//Classification contiene proposito, taxonPath,...

//      **********************************************************
//
//        String lom1="C:/Metadatos/metadatoLote1.xml";
//        File lomFile1 = new File(lom1);
//        Lom lomObj1 = this.getLomesDao().parsearLom(lomFile1);
//        tablaHash.put(identificador, lomObj1);
//
//      **********************************************************
		Lom lomObj=(Lom) tablaHash.get(identificador);
    	String ficheroProperties="/catalogacion.properties";
    	Properties fproperties=new Properties();
    	fproperties.load(this.getClass().getResourceAsStream(ficheroProperties));
    	
    	LomBasicoVO lomVO=new LomBasicoVO();
		GeneralVO generalVO=new GeneralVO();
		EducationalVO educationalVO=new EducationalVO();
		ClassificationVO clasificacionVO=new ClassificationVO();
		
		try{
			if(lomObj!=null){
				
		    	LomAgrega lomAgrega= new LomAgrega(lomObj);//Convertimos el lom de la tablahash en LomAgrega
		    	GeneralAgrega gen=null;
		    	if(lomAgrega.getGeneralAgrega() !=null){
		    		gen=lomAgrega.getGeneralAgrega();
		    	}
			
				//Si existe general recogemos los valores, si no, no hacemos nada
				if (gen !=null){
					
		    		String titulo=gen.getTitulo(idioma);
		    		String idiomas=gen.getIdioma(0);
		    		String desc=gen.getDescripcion(0, idioma);
		    		
		    		generalVO.setTitulo(titulo);
		    		generalVO.setIdioma(idiomas);
		    		generalVO.setDesc(desc);
		    		
		    		lomVO.setGeneral(generalVO);
		    		
		    		if( logger.isDebugEnabled() )
                        logger.debug("Creado generalVO en el lomVO del lom con identificador "+identificador );
				}
				
				EducationalAgrega edu=null;
	    		if(lomAgrega.getEducationalsAgrega().size()>0)
	    			edu=lomAgrega.getEducationalAgrega(0);//Se recoge el primer educational
	    		
				//Si existe educational recogemos valores, si no, no hacemos nada
				if (edu !=null){
					
					String tipo=edu.getTipoDeRecurso(0);
					String contexto=edu.getContexto(0);
					String edad=edu.getRangoEdad(0, idioma);
					String idiomaDest=edu.getIdiomaDestinatario(0);
					String procesoCog=edu.getProcesoCognitivo(0);
					
					educationalVO.setTipo(tipo);
					educationalVO.setContexto(contexto);
					educationalVO.setEdad(edad);
					educationalVO.setIdiomaDest(idiomaDest);
					educationalVO.setProcesoCog(procesoCog);
					
					lomVO.setEducational(educationalVO);
					
					if( logger.isDebugEnabled() )
                        logger.debug("Creado educationalVO en el lomVO del lom con identificador "+identificador );
				}
				
				
				ArrayList lclassAgrega= lomAgrega.getClassificationsAgrega();
				ArrayList lista= new ArrayList();
				if ((lclassAgrega!= null)&& (lclassAgrega.size()>0)){
					
					int i= 0;
					boolean encontrado= false;
					ClassificationAgrega ca= null;
					while ((i<lclassAgrega.size()) &&(!encontrado)){
						ca= lomAgrega.getClassificationAgrega(i);
						String proposito=fproperties.getProperty("proposito");
						if (ca.getProposito().equals(proposito)){
							encontrado= true;
						}
						else{
							i++;
						}
					}
					String arbol=fproperties.getProperty("arbol");
					if((encontrado==true)&&(i<lclassAgrega.size())){
				
						for( int j=0; j<ca.getTaxonPathsCount(); j++){
							if(arbol.equals(ca.getFuente(j, idioma))){
								ArbolCurricularVO arbolCu=new ArbolCurricularVO();
								arbolCu.setIdArbol(i + "." + j);
								
								ArrayList tax=new ArrayList();
								for( int k=0;k<=ca.getIndiceUltimoTaxon(j);k++){
								// Se recogen los taxones de un taxonPath	
									CBTaxonVO cbTaxon=new CBTaxonVO();
									String identi=ca.getIdentificador(j, k);
									String entry=ca.getEntrada(j, k, idioma);
									cbTaxon.setId(identi);
									cbTaxon.setValorTax(entry);
									cbTaxon.setEsHoja(new Boolean (false)); //siempre a false pq no nos importa el valor
									
									tax.add(cbTaxon);
								}
								
								Collections.reverse(tax);
								CBTaxonVO[] taxonList=(CBTaxonVO[])tax.toArray(new CBTaxonVO[tax.size()]);
								arbolCu.setTaxones(taxonList);
								lista.add(arbolCu);
			
							}
						}
					}
					
					ArbolCurricularVO[] listaArbol=(ArbolCurricularVO[])lista.toArray(new ArbolCurricularVO[lista.size()]);
//					
					clasificacionVO.setArbolesCurriculares(listaArbol);
					
					lomVO.setClassification(clasificacionVO);
					
					if( logger.isDebugEnabled() ){
						logger.debug("Creado clasificationVO en el lomVO del lom con identificador "+identificador );
					}
				}

			}else{
				throw new  Exception("El Objeto LOM no esta en la Tabla Hash");
			}
			
    	
			}catch(Exception e){
    		logger.error(e);
    		throw e;
    	}

 		return lomVO;

 
    }

 
    

    protected void handleAsociarTaxonomia(String identificador, String nomTaxonomia, CBTaxonVO[] taxonList, String idioma) throws Exception {
    

  }

 
    

//	public CatalogacionDozerDao getCatalogacionDao() {
//		return catalogacionDao;
//	}
//
//	public void setCatalogacionDao(CatalogacionDozerDao catalogacionDao) {
//		this.catalogacionDao = catalogacionDao;
//	}

//	public LomESDao getLomesDao() {
//		return lomesDao;
//	}
//
//	public void setLomesDao(LomESDao lomesDao) {
//		this.lomesDao = lomesDao;
//	}
	
	/**Genera los campos obligatorios del LOM 
	 * 
	 * @param identificador Identificador del objeto Lom
	 * @param usuario Nombre del usuario
	 * @param idioma Idioma de navegación del usuario
	 * @throws Exception
	 * */
	private void  generarCamposPorDefecto(java.lang.String identificador, String usuario, String idioma) throws java.lang.Exception {
		
		//Se implementan los campos obligatorios para el LOM de la tablaHash, todos los que no están y el usuario no puede
		//insertar por pantalla
		Lom lomObj=(Lom) tablaHash.get(identificador);
		
		String ficheroProperties="/catalogacion.properties";
    	Properties fproperties=new Properties();
    	fproperties.load(this.getClass().getResourceAsStream(ficheroProperties));
    	
    	if( logger.isDebugEnabled() )
            logger.debug("ASC - GENERAR CAMPOS POR DEFECTO identificador " + identificador + " usuario " + usuario + " idioma " + idioma );
    	
    	LomAgrega lomAgrega= new LomAgrega(lomObj);
		
		//Recogemos los campos General, el primer Educational, Ciclo de Vida, Derechos y MetaMetadatos
		GeneralAgrega gen= lomAgrega.getGeneralAgrega();
		EducationalAgrega edu=lomAgrega.getEducationalAgrega(0);
		LifeCycleAgrega life=lomAgrega.getLifeCycleAgrega();
		RightsAgrega rights=lomAgrega.getRightsAgrega();
		MetaMetadataAgrega metadata=lomAgrega.getMetaMetadataAgrega();
		
		//Si general no existe se crea
		if (gen== null){
			gen= new GeneralAgrega(new General());
		}	
		String agregacion=gen.getNivelDeAgregacion();
    	//Si general no tiene NivelDeAGregacion lo creamos, y le insertamos el valor por defecto
    	if (agregacion==null){
    		String nivelAgregacion=fproperties.getProperty("valorNivelDeAgregacion");
			gen.setNivelDeAgregacion(nivelAgregacion);
			
			if( logger.isDebugEnabled() )
                logger.debug("Agregacion nulo: añadido por defecto" );
    	}

		//Si el general no tiene Identifier lo creamos, y le insertamos valores por defecto
		if(!gen.hasIdentifier()){
			String identificadorMEC=AgregaPropertiesImpl.getInstance().getProperty("catalogo.agrega");
			
			gen.setIdentificadorMEC(identificadorMEC, identificador);
			if( logger.isDebugEnabled() )
                logger.debug("El identificador era nulo, añadido por defecto"+ identificador );
		}
		
		lomAgrega.setGeneralAgrega(gen);
		lomObj.setGeneral(gen.getGeneral());
		
		
    	//Si el Lom no tiene CicloDeVida lo creamos, y le insertamos valores por defecto(fecha,rol y contribución)
    	if(life==null){
    		
    		LifeCycleAgrega lifeAux= new LifeCycleAgrega(new LifeCycle());
    		
    		java.util.Date date=new java.util.Date();
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			String cadenaFecha = formato.format(date);
			SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss.S");
			String cadenaFechaHora = formatoHora.format(date);
			cadenaFecha = cadenaFecha + "T" + cadenaFechaHora + "Z";
			
    		String autor=fproperties.getProperty("rol");
    		if(LdapUserDetailsUtils.estaAutenticado()){ 
    			String nombre = LdapUserDetailsUtils.getNombreCompleto();
        		logger.debug("NOMBRE COMPLETO: " + nombre);
        		String email= LdapUserDetailsUtils.getMail();
        		logger.debug("EMAIL: " + email);
        		String organizacion= AgregaPropertiesImpl.getInstance().getProperty(AgregaPropertiesImpl.CATALOGO_AGREGA);     		
        		String entidad= "BEGIN:VCARD VERSION:3.0 FN: " +nombre+ " EMAIL;TYPE=INTERNET: "+email+" ORG: "+ organizacion+ " ";
        		
        		lifeAux.addContribucionCreacion(entidad, cadenaFecha);
        		lomAgrega.setLifeCycleAgrega(lifeAux);
    			lomObj.setLifeCycle(lifeAux.getLifeCycle());
    		
    		}
    		else{
    			logger.debug("NO ESTA AUTENTICADO");
			}
    		lomObj.setLifeCycle(lifeAux.getLifeCycle());
			
			if( logger.isDebugEnabled() )
                logger.debug("El ciclo de vida no existía: añadido el ciclo de vida con los campos por defecto" );
    		
    	}
    	else{
    		
    		ArrayList l= life.getAutores();
    		
    		if (l.size()==0){
    			java.util.Date date=new java.util.Date();
    			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
    			String cadenaFecha = formato.format(date);
    			SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss.S");
    			String cadenaFechaHora = formatoHora.format(date);
    			cadenaFecha = cadenaFecha + "T" + cadenaFechaHora + "Z";
    			
        		String autor=fproperties.getProperty("rol");
        		
        		if(LdapUserDetailsUtils.estaAutenticado()){ 
        			String nombre = LdapUserDetailsUtils.getNombreCompleto();
	        		logger.debug("NOMBRE COMPLETO: " + nombre);
	        		String email= LdapUserDetailsUtils.getMail();
	        		logger.debug("EMAIL: " + email);
	        		String organizacion= AgregaPropertiesImpl.getInstance().getProperty(AgregaPropertiesImpl.CATALOGO_AGREGA);     		
	        		String entidad= "BEGIN:VCARD VERSION:3.0 FN: " +nombre+ " EMAIL;TYPE=INTERNET: "+email+" ORG: "+ organizacion+ " ";
	        		
	        		life.addContribucionCreacion(entidad, cadenaFecha);
	        		lomAgrega.setLifeCycleAgrega(life);
	    			
        		
        		}
        		else{
        			logger.debug("NO ESTA AUTENTICADO");
    			}
        		lomObj.setLifeCycle(life.getLifeCycle());
    		}
    		
    		
//	    	String rol=lomAgrega.getLifeCycleAgrega().getRol(0);
//	    	String entity=lomAgrega.getLifeCycleAgrega().getEntidad(0, 0);
//	    	String data=lomAgrega.getLifeCycleAgrega().getFecha(0);
//	    	
//	    	//Aunque exista CicloDeVida, si los valores rol,entidad y fecha son nulos les insertamos los valores por defecto
//	    	//son obligatorios los tres segun el esquema!!!
//	    	if((rol==null)||(entity==null)||(data==null)){
//	    		
//				String autor=(rol==null?fproperties.getProperty("rol"):rol);
//				java.util.Date date=new java.util.Date();
//				SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
//				String cadenaFecha = (data==null?formato.format(date):data);
//				String entidad = (entity==null? "BEGIN:VCARD VERSION:3.0 FN: " +usuario+ " EMAIL;TYPE=INTERNET:  ORG: ": entity);
//				life.setContribucion(0, autor, entidad, cadenaFecha, "Creación y catalogación en Agrega", idioma);
//				//life.addContribucion(autor, entidad, cadenaFecha, "Creación y catalogación en Agrega");
//				
//				if( logger.isDebugEnabled() )
//	
//	                logger.debug("El rol, la entidad y la fecha eran nulos: añadidos por defecto" );
//				
//				// nuevo!
//				lomObj.setLifeCycle(life.getLifeCycle());
//			
//	    	}
    	}
    	
    	//Si Derechos es nulo lo creamos y le insertamos el valor de tipoDeAcceso por defecto
		//es obligatorio ademas de access
		if(rights==null){
			
			String tip=fproperties.getProperty("tipoDeAcceso");
			String des="Tipo de acceso por defecto";
			
			RightsAgrega rigthsAux= new RightsAgrega(new Rights());
			
			//Si el tipoDeRecurso no es de tipo Servicio insertamos en derechosDeAutor el valor dominio público
			if( logger.isDebugEnabled() )
                logger.debug("ASC - generarCamposPorDefecto rights==null!!!!!" );
		
			
			if(edu!=null){
				
				String tipo=edu.getTipoDeRecurso(0);
				
				if (tipo!=null){
//					Se corresponden a terminos de LOM-ES, son tipos de recursos educativos.Si no es alguno de esos por defecto
					//los derechos de autor seran de tipo no corresponde. Si no de public domain
					String p1=fproperties.getProperty("5.2.33");
					String p2=fproperties.getProperty("5.2.34");
					String p3=fproperties.getProperty("5.2.35");
					String p4=fproperties.getProperty("5.2.36");
					String p5=fproperties.getProperty("5.2.37");
					String p6=fproperties.getProperty("5.2.38");
					String p7=fproperties.getProperty("5.2.39");
					String derechos= null;

					if((p1.equals(tipo))||(p2.equals(tipo))||(p3.equals(tipo))||(p4.equals(tipo))||(p5.equals(tipo))||(p6.equals(tipo))||(p7.equals(tipo))){
						derechos=fproperties.getProperty("derechosDeAutorNoCorresponde");
						
						if( logger.isDebugEnabled() )
			                logger.debug("Tipo de recurso distinto a los mencionados: cambiados los derechos de autor a no corresponde" );
					}
					else{
						derechos=fproperties.getProperty("derechosdeAutor");
					}
						
					rigthsAux.setDerechosDeAutor(derechos);
				}	
			}
			//metemos Acceso 
			rigthsAux.setAcceso(tip, des);
			lomAgrega.setRightsAgrega(rigthsAux);

			lomObj.setRights(rigthsAux.getRights());
			
			if( logger.isDebugEnabled() )
                logger.debug("Derechos era nulo:añadido derechos con los campos por defecto" );
		}
		
		else{
			
			if(rights.getDerechosDeAutor()==null){
				if(edu!=null){
					
					String tipo=edu.getTipoDeRecurso(0);
					
					if (tipo!=null){
//						Se corresponden a terminos de LOM-ES, son tipos de recursos educativos.Si no es alguno de esos por defecto
						//los derechos de autor seran de tipo no corresponde. Si no de public domain
						String p1=fproperties.getProperty("5.2.33");
						String p2=fproperties.getProperty("5.2.34");
						String p3=fproperties.getProperty("5.2.35");
						String p4=fproperties.getProperty("5.2.36");
						String p5=fproperties.getProperty("5.2.37");
						String p6=fproperties.getProperty("5.2.38");
						String p7=fproperties.getProperty("5.2.39");
						String derechos= null;

						if((tipo.equals(p1))||(tipo.equals(p2))||(tipo.equals(p3))||(tipo.equals(p4))||(tipo.equals(p5))||(tipo.equals(p6))||(tipo.equals(p7))){
							derechos=fproperties.getProperty("derechosDeAutorNoCorresponde");
							
							if( logger.isDebugEnabled() )
				                logger.debug("Tipo de recurso distinto a los mencionados: cambiados los derechos de autor a no corresponde" );
						}
						else{
							derechos=fproperties.getProperty("derechosdeAutor");
						}
							
						rights.setDerechosDeAutor(derechos);
					}	
				}
			}
				
			String acceso=rights.getTipoDeAcceso();
			if(acceso==null){
				String tip=fproperties.getProperty("tipoDeAcceso");
				String des=fproperties.getProperty("DescripcionDeAcceso");
				
				
				rights.setAcceso(tip, des);
				if( logger.isDebugEnabled() )
				  logger.debug("Acceso era nulo: añadido por defecto" );
			}
			
			lomAgrega.setRightsAgrega(rights);
			lomObj.setRights(rights.getRights());
		}
		
		//Si metaMetadata no existe lo creamos y le insertamos valores por defecto
		if(metadata==null){
			
			String metadataSchema=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");

			MetaMetadataAgrega metadataAux= new MetaMetadataAgrega(new MetaMetadata());
			
			metadataAux.addEsquemaDeMetadatos(metadataSchema);
			metadataAux.setIdioma(idioma);
			
			lomAgrega.setMetaMetadataAgrega(metadataAux);
			lomObj.setMetaMetadata(metadataAux.getMetaMetadata());
			
			if( logger.isDebugEnabled() )
                logger.debug("El metadata era nulo: creado con los campos por defecto" );
		}
		
		else{
//			Si el esquema o el idioma son nulos, les insertamos los valores por defecto
			
			String esquema=metadata.getEsquemaDeMetadatos(0);
			if(esquema==null){
				
				String metadataSchema=AgregaPropertiesImpl.getInstance().getProperty("esquemaDeMetadatos");
				metadata.addEsquemaDeMetadatos(metadataSchema);
				
				if( logger.isDebugEnabled() )
	                logger.debug("El esquema era nulo: creado por defecto" );
			}
			
			if(metadata.getIdioma()==null){
				
				metadata.setIdioma(idioma);
				
				if( logger.isDebugEnabled() )
	                logger.debug("El idioma del metametadata era nulo: creado por defecto" );
			}
			
			lomAgrega.setMetaMetadataAgrega(metadata);
			lomObj.setMetaMetadata(metadata.getMetaMetadata());
		}
		
		tablaHash.put(identificador,lomObj);
		
		if( logger.isDebugEnabled() )
            logger.debug("Insertado el Objeto lom en la tabla Hash con el identificador "+identificador );
	}


	//////////////////////////////////////////////////////////////////
	//			ASC - ORDENA LAS ETQS DE LOM-ES         //////////
//	private Lom OrdenaEtqsLom (String idioma, Lom lomObj) {
//		
//		LomAgrega lag =new LomAgrega(); 
//		lag.setLomItem(lomObj.getLomItem());
//		//General Obl
//		GeneralAgrega gen= lag.getGeneralAgrega();
//		GeneralAgrega genOrd = new GeneralAgrega();
//		int nidentif = gen.getCountIdentifier();
//		for (int n=0; n< nidentif; n++) {
//			genOrd.setIdentificadorMEC(gen.getCatalogo(n), gen.getEntry(n));
//			//gen.getCatalogo(n);
//			//gen.getEntry(n);
//		}
//		genOrd.setTitulo(idioma, gen.getTitulo(idioma));
//		genOrd.setIdioma(0, gen.getIdioma(0));
//		genOrd.setDescripcion(0, idioma, gen.getDescripcion(0, idioma));
//		genOrd.setNivelDeAgregacion(gen.getNivelDeAgregacion());
//		
//		// LifeCycle Opcional
//		LifeCycleAgrega lca = lag.getLifeCycleAgrega();
//		LifeCycleAgrega lcaOrd = new LifeCycleAgrega();
//		if (lca!=null) {
//			lcaOrd.setContribucion(0, lca.getRol(0), lca.getEntidad(0, 0), lca.getDate(0), idioma);
//		}
//		
//		// MetaData obl
//		// falta identifier y contributeMeta q son opcionales
//		MetaMetadataAgrega mma = lag.getMetaMetadataAgrega();
//		MetaMetadataAgrega mmaOrd = new MetaMetadataAgrega();
//		mmaOrd.setEsquemaDeMetadatos(0, mma.getEsquemaDeMetadatos(0));
//		mmaOrd.setIdioma(mma.getIdioma());
//		
//		//Technical opcional (lo añadimos si aparece)
//		TechnicalAgrega tec = null;
//		if ((lag.getTechnicalAgrega()!= null) && lag.getTechnicalAgrega().getGroupTechnicalTechnical()!=null) {
//			tec = lag.getTechnicalAgrega();
//		}
//		
//		// Educational obl
//		EducationalAgrega ea = lag.getEducationalAgrega(0);
//		EducationalAgrega eaOrd = new EducationalAgrega();
//		eaOrd.setTipoRecurso(0, ea.getTipoRecurso(0));
//		eaOrd.setContexto(0, ea.getContexto(0));
//		eaOrd.setRangoEdad(0, idioma, ea.getRangoEdad(0, idioma));
//		eaOrd.setIdiomaDestinatario(0, ea.getIdiomaDestinatario(0));
//		eaOrd.setProcesoCognitivo(0, ea.getProcesoCognitivo(0));
//		
//		// rights obl
//		RightsAgrega rights = lag.getRightsAgrega();
//		RightsAgrega rigOrd = new RightsAgrega();
//		try {
//			rigOrd.setCost(idioma, "LOM-ESv1.0", rights.getCost());
//		} catch (IndexOutOfBoundsException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			//e.printStackTrace();
//			logger.error("ERROR EN METODO OrdenaEtqsLom " + e);
//		}
//		//NO PONEMSO DE MOMENTO LOS DERECHOS DE AUTOR... PQ DA ERROR AL VALIDAR!! CREA UNAS ETQ RARAS
//		String derechos = rights.getDerechosDeAutor()!= null? rights.getDerechosDeAutor(): "Public domain" ;
////		
//		rigOrd.setDerechosDeAutor(derechos);
//		rigOrd.setAcceso(idioma, rights.getTipoDeAcceso(), "");
//		rigOrd.setAccessDescription(rights.getDescripcionDeAcceso(idioma));
//		
//		// relation opcional no
//		// annotation opcional no
//		// clasification opcional
//		LomAgrega lagOrd =new LomAgrega(); 
//		lagOrd.setGeneralAgrega(genOrd);
//		lagOrd.setLyfeCycleAgrega(lcaOrd);
//		lagOrd.setMetaMetadataAgrega(mmaOrd);
//		if (tec !=null) {
//			lagOrd.setTechincalAgrega(tec);
//		}
//		lagOrd.addEducationalAgrega(eaOrd);
//		lagOrd.setRightsAgrega(rigOrd);
//		lagOrd.addClassificationAgrega(lag.getClassificationAgrega(0));
//		
//		Lom lomOrd = new Lom();
//		lomOrd.setLomItem(lagOrd.getLomItem());
//		
//		return lomOrd;
//	}
	
	/**Elimina los objetos LOM 
	 * 
	 * @param ids Array de identificadores de los objetos Lom a eliminar
	 * @throws Exception
	 * */
	
	protected void handleEliminarObjLoms(String[] ids) throws Exception {
		
		for (int i=0;i<ids.length;i++){
			
			//Borramos los Lom con los identificadores que nos pasan
			tablaHash.remove(ids[i]);
			if( logger.isDebugEnabled() )

                logger.debug("Eliminado el objeto lom con identificador "+ids[i] );
			
		}
		
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
	 * Obtiene los objetos Lom correspondientes a los identificadores del array de identificadores
	 * 
	 * @param ids Array de identificadores de objetos lom
	 * @return idLomVO[] Array de pares (identificador, objeto Lom)
	 * @throws Exception
	 */
	
	protected IdLomVO[] handleObtenerObjLoms(String[] ids) throws Exception {
		
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

	protected void handleEliminarTaxonomia(String identificador, String nomTaxonomia, int idArbol) throws Exception {
	
	}


	/**
	 * Asocia una lista de TaxonVO en el lomBasico
	 * 
	 * @param identificador Identificador del objeto Lom
	 * @param lomBasico Objeto para almacenar los datos obligatorios de los campos general y educational, y los árboles curriculares del campo classification
	 * @param taxonList Una lista de CBTaxonVO (pares identificador/valor)
	 * @return lomBasico El lomBasico de entrada con la lista de taxones añadida
	 * @throws Exception
	 */

	protected LomBasicoVO handleAsociarTaxonomiaEnLomBasico(String identificador, LomBasicoVO lomBasico, CBTaxonVO[] taxonList) throws Exception {
		//Añade un taxonPath nuevo (taxonList) al lomBasico.
		Lom lomObj=(Lom) tablaHash.get(identificador);
		LomAgrega lomAgrega= new LomAgrega(lomObj);
		
		ArbolCurricularVO arbolVO=new ArbolCurricularVO();
		ArrayList l=new ArrayList();
		
		String ficheroProperties="/catalogacion.properties";
    	Properties fproperties=new Properties();
    	fproperties.load(this.getClass().getResourceAsStream(ficheroProperties));

		int cont=0;
		int idArbol=0;
		int indiceTaxonGrande=-1;
		ArbolCurricularVO[] arbolesCurriculares=null;
		int indice=0;
		int indexClas= 0;
		
		ArrayList lclassAgrega= lomAgrega.getClassificationsAgrega();

		if ((lclassAgrega!= null)&& (lclassAgrega.size()>0)){

			boolean encontrado= false;
			ClassificationAgrega ca= null;
			while ((indexClas<lclassAgrega.size()) &&(!encontrado)){
				ca= lomAgrega.getClassificationAgrega(indexClas);
				String proposito=fproperties.getProperty("proposito");
				if (ca.getProposito().equals(proposito)){
					encontrado= true;
				}
				else{
					indexClas++;
				}
			}
			
//			si existe clasificación y tiene algún taxonPath se obtiene el último índice
//			if((lomAgrega.getClassificationsAgrega()!= null) && (lomAgrega.getClassificationsAgrega().size()>0)){
//				ClassificationAgrega clasificacionGrande=lomAgrega.getClassificationAgrega(indexClas);
//				indiceTaxonGrande=clasificacionGrande.getIndiceUltimoTaxonPath();
//			}else{
//				indiceTaxonGrande=-1;//Lo creamos por defecto, por que getIndiceUltimoTaxonPath nos devuelve -1 si no tiene taxonPath
//				
//				if( logger.isDebugEnabled() )
//	                logger.debug("indiceTaxonGrande=-1 creado por defecto, por que getIndiceUltimoTaxonPath nos devuelve -1 si no tiene taxonPath" );
//			}
			if(!encontrado){
				indiceTaxonGrande=-1;
			}
			else{
				ClassificationAgrega clasificacionGrande=lomAgrega.getClassificationAgrega(indexClas);
				indiceTaxonGrande=clasificacionGrande.getIndiceUltimoTaxonPath();
			}
		}

//		//si existe clasificación y tiene algún taxonPath se obtiene el último índice
//		if((lomAgrega.getClassificationsAgrega()!= null) && (lomAgrega.getClassificationsAgrega().size()>0)){
//			ClassificationAgrega clasificacionGrande=lomAgrega.getClassificationAgrega(i);
//			indiceTaxonGrande=clasificacionGrande.getIndiceUltimoTaxonPath();
//		}else{
//			indiceTaxonGrande=-1;//Lo creamos por defecto, por que getIndiceUltimoTaxonPath nos devuelve -1 si no tiene taxonPath
//			
//			if( logger.isDebugEnabled() )
//
//                logger.debug("indiceTaxonGrande=-1 creado por defecto, por que getIndiceUltimoTaxonPath nos devuelve -1 si no tiene taxonPath" );
//		}
			
		//Si no tenemos TaxonPath en el Lom grande
		if( indiceTaxonGrande==-1){
				
				if (lomBasico.getClassification()!= null){
					if (lomBasico.getClassification().getArbolesCurriculares()!= null){
						ClassificationVO clasificacionBasico= lomBasico.getClassification();
						arbolesCurriculares=clasificacionBasico.getArbolesCurriculares();
						for( int j=0;j<arbolesCurriculares.length;j++){
							l.add(arbolesCurriculares[j]);
						}
						
						//Recogemos el IdArbol mayor
						for ( int i=0;i<arbolesCurriculares.length; i++){
							
							int indexAux= arbolesCurriculares[i].getIdArbol().indexOf(".");
							int nCarac=arbolesCurriculares[i].getIdArbol().length();
							String segId= arbolesCurriculares[i].getIdArbol().substring(indexAux+1,nCarac);
							
							indice= Integer.parseInt(segId);
							if(indice>=cont){
								
								cont=indice;
							}
						}
						//Tenemos que coger el indice más grande entre el LomGrande y el idArbol; y más uno para añadirle en el siguiente.
						if(indiceTaxonGrande>=cont){
							
							idArbol=indiceTaxonGrande+1;
						}
						else{
							if (l.isEmpty()) { //si el array aux esta vacio es pq no tenia ninguno 
								cont=-1;
							}
							idArbol=cont+1;
						}
					}
				}
				
				ClassificationVO miClasificacion= new ClassificationVO();
				arbolVO.setIdArbol(indexClas + "." + idArbol);
				arbolVO.setTaxones(taxonList);
				l.add(arbolVO);
	
				   
				miClasificacion.setArbolesCurriculares((ArbolCurricularVO[])l.toArray(new ArbolCurricularVO[l.size()]));
			    lomBasico.setClassification(miClasificacion);
			    
			    if( logger.isDebugEnabled() )

	                logger.debug("Añadido un taxonPath en Classification, no tenía ninguno" );
				
			}else{//existe clasificación con taxonPath en lomAgrega
			
				ClassificationVO clasificacionBasico=lomBasico.getClassification();
				try{//Si tenemos ArbolesCurriculares
					
					arbolesCurriculares=clasificacionBasico.getArbolesCurriculares();
					for( int j=0;j<arbolesCurriculares.length;j++){
						l.add(arbolesCurriculares[j]);
					}
					//Recogemos el IdArbol mayor
					for ( int i=0;i<arbolesCurriculares.length; i++){
						
						int indexAux= arbolesCurriculares[i].getIdArbol().indexOf(".");
						int nCarac=arbolesCurriculares[i].getIdArbol().length();
						String segId= arbolesCurriculares[i].getIdArbol().substring(indexAux+1,nCarac);
						
						indice= Integer.parseInt(segId);
						if(indice>=cont){
							
							cont=indice;
						}
					}
					//Tenemos que coger el indice más grande entre el LomGrande y el idArbol; y más uno para añadirle en el siguiente.
					if(indiceTaxonGrande>=cont){
						
						idArbol=indiceTaxonGrande+1;
					}
					else{
						
						idArbol=cont+1;
					}
					
					if( logger.isDebugEnabled() )

		                logger.debug("Recogido el identificador del árbol donde vamos a añadir el taxonPath" );
					
					arbolVO.setIdArbol(indexClas + "." + idArbol);
					arbolVO.setTaxones(taxonList);
					l.add(arbolVO);			
					
					clasificacionBasico.setArbolesCurriculares((ArbolCurricularVO[])l.toArray(new ArbolCurricularVO[l.size()]));
					lomBasico.setClassification(clasificacionBasico);
					
					if( logger.isDebugEnabled() )

		                logger.debug("Añadido el Classification al lomBasico" );
				
				}catch(Exception e){//Si no tenemos ArbolesCurriculares, los creamos
					
					indice=0;
					ClassificationVO miClasificacion=new ClassificationVO();
					arbolVO.setIdArbol(indexClas + "." + idArbol);
					arbolVO.setTaxones(taxonList);
					l.add(arbolVO);
					
					if( logger.isDebugEnabled() )

		                logger.debug("Creado ArbolesCurriculares, no teníamos ninguno" );
		
					   
					miClasificacion.setArbolesCurriculares((ArbolCurricularVO[])l.toArray(new ArbolCurricularVO[l.size()]));
				    lomBasico.setClassification(miClasificacion);
				    
				    if( logger.isDebugEnabled() )

		                logger.debug("Añadido el Classification al lomBasico" );
					
				}

		}
			
		return lomBasico;
	
	}

	public HashMap getTablaHash() {
		return tablaHash;
	}

	public void setTablaHash(HashMap tablaHash) {
		this.tablaHash = tablaHash;
	}
	
	
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
	 * Genera los datos de educational, general y classification si no vienen rellenos
	 * 
	 * @param identificador Identificador del objeto Lom
	 * @param usuario Nombre del usuario
	 * @param lomBasico Objeto para almacenar los datos obligatorios de general y educational y los árboles curriculares de classification
	 * @param idioma Idioma de navegacion del usuario
	 * @return lomBasico Devuelve el lomBasico inicial con los datos obligatorios rellenos
	 * @throws Exception
	 */
	
	protected LomBasicoVO handleGenerarMetadatos(String identificador, String usuario, LomBasicoVO lomBasico, String idioma) throws Exception {
		
		Lom lomObj= (Lom) tablaHash.get(identificador);
    	
    	String ficheroProperties="/catalogacion.properties";
    	Properties fproperties=new Properties();
    	fproperties.load(this.getClass().getResourceAsStream(ficheroProperties));
    	
    	try{
    		
    		//recogemos los valores del LomBasico
    		if (lomObj != null) {
    			
	    		LomAgrega lomAgrega= new LomAgrega(lomObj);
	    		
	    		GeneralAgrega gen= lomAgrega.getGeneralAgrega();
	    		
	    		EducationalAgrega edu=null;
	    		if(lomAgrega.getEducationalsAgrega().size()>0)
	    			edu=lomAgrega.getEducationalAgrega(0);
	    		
	    		ClassificationAgrega clasi=null;
	    		int indexClas= 0;
	    		if((lomAgrega.getClassificationsAgrega()!=null)&& (lomAgrega.getClassificationsAgrega().size()>0)){
		
						
						boolean encontrado= false;
						ClassificationAgrega ca= null;
						while ((indexClas<lomAgrega.getClassificationsAgrega().size()) &&(!encontrado)){
							ca= lomAgrega.getClassificationAgrega(indexClas);
							String proposito=fproperties.getProperty("proposito");
							if (ca.getProposito().equals(proposito)){
								encontrado= true;
							}
							else{
								indexClas++;
							}
						}
	    	
	    		}
	    		
	    		if (indexClas<lomAgrega.getClassificationsAgrega().size()){
	    			clasi=lomAgrega.getClassificationAgrega(indexClas);
	    		}
	    		
	    		int nClassifications= lomAgrega.getClassificationsAgrega().size();

	    		String titulo=lomBasico.getGeneral().getTitulo();
	        	String idiomas =lomBasico.getGeneral().getIdioma();
	        	String desc=lomBasico.getGeneral().getDesc();
	        	
	        	String tipo=lomBasico.getEducational().getTipo();
	        	String contexto=lomBasico.getEducational().getContexto();
	        	String edad=lomBasico.getEducational().getEdad();
	        	String idiomaDest=lomBasico.getEducational().getIdiomaDest();
	        	String procesoCog=lomBasico.getEducational().getProcesoCog();
	        	
	        	ArbolCurricularVO[] arboles= lomBasico.getClassification().getArbolesCurriculares();
	        	int longArboles=lomBasico.getClassification().getArbolesCurriculares().length;
	        	     	
	        	//Si existe el general en el Lom le insertamos los valores, si no, lo creamos y insertamos los valores
	        	
	        	if( gen!=null){
		        	//gen.setTitulo("", titulo);
	        		gen.setTitulo(titulo, idioma);
		        	gen.setIdioma(0, idiomas);
	        		gen.setDescripcion(0, desc, idioma);
	        		
	        		lomObj.setGeneral(gen.getGeneral());
		        	
		        	if( logger.isDebugEnabled() )

	                    logger.debug("Creados los metadatos del general" );
	        	}
	        	else{	
					GeneralAgrega genAux= new GeneralAgrega(new General());

					genAux.setTitulo(idioma, titulo);
					genAux.setIdioma(0, idiomas);
					genAux.setDescripcion(0, desc, idioma);
					
					lomAgrega.setGeneralAgrega(genAux);
					lomObj.setGeneral(genAux.getGeneral());
					
					if( logger.isDebugEnabled() )

	                    logger.debug("Creado el general con los metadatos" );
				}

	        	//Si existe el educational en el Lom le insertamos los valores, si no, lo creamos y insertamos los valores
	        	
	        	if(edu!=null){
	        		edu.setTipoDeRecurso(0, tipo);
	        		edu.setContexto(0, contexto);
	        		edu.setRangoEdad(0, idioma, edad);
	        		edu.setIdiomaDestinatario(0, idiomaDest);
	        		edu.setProcesoCognitivo(0, procesoCog);
	        		
	        		//lomObj.addEducational(edu.getEducational());
	        		lomObj.setEducational(0, edu.getEducational());
	        		
	        		if( logger.isDebugEnabled() )
	                    logger.debug("Creados los metadatos del educational" );
	        	}
	        	else{
	        		EducationalAgrega eduAux=new EducationalAgrega(new Educational());
	        		
	        		eduAux.setTipoDeRecurso(0, tipo);
	        		eduAux.setContexto(0, contexto);
	        		eduAux.setRangoEdad(0, idioma, edad);
	        		eduAux.setIdiomaDestinatario(0, idiomaDest);
	        		eduAux.setProcesoCognitivo(0, procesoCog);
	        		
	        		lomAgrega.addEducationalAgrega(eduAux);
	        		
	        		//lomObj.addEducational(eduAux.getEducational());
	        		lomObj.setEducational(0, eduAux.getEducational());
	        		
	        		if( logger.isDebugEnabled() )

	                    logger.debug("Creado el educational con los metadatos" );
	        	}
	        	
	        	// Si existe el classification en el Lom le insertamos los valores, si no, lo creamos y insertamos los valores
	        	if(clasi!=null){
	        		
	        		int indice= -1;
	        		try{
	        			String arbol=fproperties.getProperty("arbol");
						String proposito=fproperties.getProperty("proposito");
	        			int indiceUltimo=clasi.getIndiceUltimoTaxonPath();
	        			//recorre los taxonPath
	        			for( int i=0;i<longArboles;i++){
	        				
	        				int indexAux= arboles[i].getIdArbol().indexOf(".");
	        				int nCarac=arboles[i].getIdArbol().length();
							String segId= arboles[i].getIdArbol().substring(indexAux+1,nCarac);
							
							indice= Integer.parseInt(segId);
	        				
		        			if(indice>indiceUltimo){
		        				
		        				int indice2=++indiceUltimo;
		        				//clasi.setFuente(indice2, "", "arbol curricular"); 
		        				clasi.setFuente(indice2, idioma, arbol);
		        				clasi.setProposito(proposito);
		        				int indiceTaxon=lomBasico.getClassification().getArbolesCurriculares()[i].getTaxones().length;
		        				//recorre los taxones de un taxonPath
		        				for(int j=0;j<indiceTaxon;j++){

		        					String idTaxon=lomBasico.getClassification().getArbolesCurriculares()[i].getTaxones()[j].getId();
		        					String nomTaxon=lomBasico.getClassification().getArbolesCurriculares()[i].getTaxones()[j].getValorTax();

		        					clasi.addTaxon(indice2, idTaxon, nomTaxon, idioma);
		        					
		        				}
		        				
		        				arboles[i].setIdArbol(indexClas + "." + clasi.getIndiceUltimoTaxonPath());
		        				lomBasico.getClassification().getArbolesCurriculares()[i].setIdArbol(indexClas + "." + indice2);
		        				
		        			}
	        			}

		        	}catch(Exception e1){
		        		
		        		logger.error(e1);
		        	}
	        	}else if((arboles!=null)&& (arboles.length>0)){
	        		
	        		ClassificationAgrega clasAux= new ClassificationAgrega(new Classification());
	        		//prueba arreglo para guardarMetadatos, hallamos el idArbol del ultimo
	        		
	        		int indice= 0;
	        		int indiceUltimo=clasAux.getIndiceUltimoTaxonPath();
        			for( int i=0;i<longArboles;i++){
        				
        				int indexAux= arboles[i].getIdArbol().indexOf(".");
        				int nCarac=arboles[i].getIdArbol().length();
						String segId= arboles[i].getIdArbol().substring(indexAux+1,nCarac);
						
						indice= Integer.parseInt(segId);
        				
	        			if(indice>indiceUltimo){
	        				
	        				int indice2=++indiceUltimo;
	        				//clasAux.setFuente(indice2, "", "arbol curricular");
	        				String arbol=fproperties.getProperty("arbol");
	    					String proposito=fproperties.getProperty("proposito");
	        				clasAux.setFuente(indice2, idioma, arbol);
	        				clasAux.setProposito(proposito);
	        				int indiceTaxon=lomBasico.getClassification().getArbolesCurriculares()[i].getTaxones().length;
	        				for(int j=0;j<indiceTaxon;j++){

	        					String idTaxon=lomBasico.getClassification().getArbolesCurriculares()[i].getTaxones()[j].getId();
	        					String nomTaxon=lomBasico.getClassification().getArbolesCurriculares()[i].getTaxones()[j].getValorTax();

	        					//clasAux.addTaxon(indice2, idTaxon, nomTaxon, "");
	        					clasAux.addTaxon(indice2, idTaxon, nomTaxon, idioma);
	        				}
	        				
	        				arboles[i].setIdArbol(nClassifications + "." + clasAux.getIndiceUltimoTaxonPath());
	        				
	        				lomBasico.getClassification().getArbolesCurriculares()[i].setIdArbol(nClassifications + "." + indice2);	
	        			}
        			}
        			
        			
	        		lomAgrega.addClassificationAgrega(clasAux);
	        		
	        		if ((clasAux.getProposito()!= null) && (clasAux.getFuentes().size()>0)){
	        			//lomObj.addClassification(clasAux.getClassification());
	        			lomObj.setClassification(indexClas, clasAux.getClassification());
        				
        				if( logger.isDebugEnabled() )
    	                    logger.debug("Añadidos los taxonPath" );
	        		}
	        	}
  	
	        	if ((lomAgrega.getClassificationsAgrega()!= null) && (lomAgrega.getClassificationsAgrega().size()>0) ){
	        		ArrayList indiBorrar=new ArrayList();

		        	indexClas= 0;
					boolean encontrado= false;
					ClassificationAgrega ca= null;
					while ((indexClas<lomAgrega.getClassificationsAgrega().size()) &&(!encontrado)){
						ca= lomAgrega.getClassificationAgrega(indexClas);
						String proposito=fproperties.getProperty("proposito");
						if (ca.getProposito().equals(proposito)){
							encontrado= true;
						}
						else{
							indexClas++;
						}
					}
					
					ClassificationAgrega clasifica=null;
					if (encontrado){	//Ponemos esta condicion, para que si no encuentra el clasificacion que tiene que tratar no haga nada y
										//no de errores de indices;ejm: caso cuando el proposito no es discipline y no tiene q cargar ningun arbol curricular y guardas.
						clasifica=lomAgrega.getClassificationAgrega(indexClas);
					
			        	int ultimoIndice= clasifica.getIndiceUltimoTaxonPath();
			        	if (ultimoIndice==-1) {
			        		ultimoIndice=0;
			        	}
			        	if (ultimoIndice >= 0){
				        	for( int k=0;k<=clasifica.getIndiceUltimoTaxonPath();k++){
				        		
				        		String arbolCu=clasifica.getFuente(k, idioma);
				        		String arbol=fproperties.getProperty("arbol");
				        		if(arbol.equals(arbolCu)){
				        			
				        			encontrado=false;
				        			int l=0;
				        			int indice= 0;
				        			ArbolCurricularVO[] arbolCurriculares=lomBasico.getClassification().getArbolesCurriculares();
				        			while((l<arbolCurriculares.length)&& (encontrado == false)){
				        				
				        				int indexAux= arbolCurriculares[l].getIdArbol().indexOf(".");
				        				int nCarac=arbolCurriculares[l].getIdArbol().length();
										String segId= arbolCurriculares[l].getIdArbol().substring(indexAux+1,nCarac);
										
				        				indice= Integer.parseInt(segId);
				        				
				        				if(k==indice)
				        					encontrado=true;
				        				else
	 			        					encontrado= false;
				        				l++;
				        			}
				        			
				        			if (encontrado == false){
				        				indiBorrar.add(new Integer(k));
				        			}
				        			
				        		}
				        		
				        	}
				        	for( int l=0;l<indiBorrar.size();l++){
				        		
				        		Integer borrar=(Integer)indiBorrar.get(l);
				        		clasifica.removeTaxonPath(borrar.intValue());
				        		for ( int m=0;m<indiBorrar.size();m++){
				        			
				        			Integer aux=(Integer)indiBorrar.get(m);
				        			int auxInt=aux.intValue();
				        			auxInt=auxInt-1;
				        			Integer aux2=new Integer(auxInt);
				        			indiBorrar.set(m, aux2);
				        		}
				        		
				        		if( logger.isDebugEnabled() )
			
				                    logger.debug("Borrado el taxonPath que no está en el lomBasico" );	
				        	}
			        	}
		        	
					
		        	
			        	if ((clasifica != null)&& (clasifica.getProposito()!= null) && (clasifica.getFuentes().size()>0)){
			        	
			        		lomObj.setClassification(indexClas, clasifica.getClassification());
			        	}else{
	
			        		lomAgrega.removeClassificationAgrega(indexClas);
			        		ArrayList clasificationList=new ArrayList();
			        		for(int i=0;i<lomAgrega.getClassificationsAgrega().size();i++){
			        			clasificationList.add(lomAgrega.getClassificationAgrega(i).getClassification());
			        		}
			        		lomObj.setClassification((Classification[])clasificationList.toArray(new Classification[clasificationList.size()]));
			        	}
					}
	        	}
        	
	    		tablaHash.put(identificador, lomObj);
	    		
	    		if( logger.isDebugEnabled() )

                    logger.debug("Añadido el lomObj después de generar los metadatos" );
    			
	    		generarCamposPorDefecto(identificador,usuario,idioma);
	    		
	    		if( logger.isDebugEnabled() )

                    logger.debug("Generados los campos por defecto" );

    		}else{
    			
//    			 el objeto lom no esta en la tabla hash y da un error
    			throw new  Exception("El Objeto LOM no esta en la Tabla Hash");
    		}
    	
    	}catch(Exception e){
    		
    		logger.error(e);
    		throw e;
    	}
    	
    	return lomBasico;
	}

	protected DataHandler handleExportarLomes(
			String identificador, 
			String usuario, 
			LomBasicoVO lomBasico, 
			String idioma) 
	throws Exception 
	{
		DataHandler resultado=null;
		
		Lom lomObj= (Lom) tablaHash.get(identificador);
    	
    	String ficheroProperties="/catalogacion.properties";
    	Properties fproperties=new Properties();
    	fproperties.load(this.getClass().getResourceAsStream(ficheroProperties));
    	
    	try{
    		
    		//recogemos los valores del LomBasico
    		if (lomObj != null) {
    			
	    		LomAgrega lomAgrega= new LomAgrega(lomObj);
	    		
	    		GeneralAgrega gen= lomAgrega.getGeneralAgrega();
	    		
	    		EducationalAgrega edu=null;
	    		if(lomAgrega.getEducationalsAgrega().size()>0)
	    			edu=lomAgrega.getEducationalAgrega(0);
	    		
	    		ClassificationAgrega clasi=null;
	    		int indexClas= 0;
	    		if((lomAgrega.getClassificationsAgrega()!=null)&& (lomAgrega.getClassificationsAgrega().size()>0)){
		
						
						boolean encontrado= false;
						ClassificationAgrega ca= null;
						while ((indexClas<lomAgrega.getClassificationsAgrega().size()) &&(!encontrado)){
							ca= lomAgrega.getClassificationAgrega(indexClas);
							String proposito=fproperties.getProperty("proposito");
							if (ca.getProposito().equals(proposito)){
								encontrado= true;
							}
							else{
								indexClas++;
							}
						}
	    	
	    		}
	    		
	    		if (indexClas<lomAgrega.getClassificationsAgrega().size()){
	    			clasi=lomAgrega.getClassificationAgrega(indexClas);
	    		}
	    		
	    		int nClassifications= lomAgrega.getClassificationsAgrega().size();

	    		String titulo=lomBasico.getGeneral().getTitulo();
	        	String idiomas =lomBasico.getGeneral().getIdioma();
	        	String desc=lomBasico.getGeneral().getDesc();
	        	
	        	String tipo=lomBasico.getEducational().getTipo();
	        	String contexto=lomBasico.getEducational().getContexto();
	        	String edad=lomBasico.getEducational().getEdad();
	        	String idiomaDest=lomBasico.getEducational().getIdiomaDest();
	        	String procesoCog=lomBasico.getEducational().getProcesoCog();
	        	
	        	ArbolCurricularVO[] arboles= lomBasico.getClassification().getArbolesCurriculares();
	        	int longArboles=lomBasico.getClassification().getArbolesCurriculares().length;
	        	     	
	        	//Si existe el general en el Lom le insertamos los valores, si no, lo creamos y insertamos los valores
	        	
	        	if( gen!=null){
		        	//gen.setTitulo("", titulo);
	        		gen.setTitulo(titulo, idioma);
		        	gen.setIdioma(0, idiomas);
	        		gen.setDescripcion(0, desc, idioma);
	        		
	        		lomObj.setGeneral(gen.getGeneral());
		        	
		        	if( logger.isDebugEnabled() )

	                    logger.debug("Creados los metadatos del general" );
	        	}
	        	else{	
					GeneralAgrega genAux= new GeneralAgrega(new General());

					genAux.setTitulo(idioma, titulo);
					genAux.setIdioma(0, idiomas);
					genAux.setDescripcion(0, desc, idioma);
					
					lomAgrega.setGeneralAgrega(genAux);
					lomObj.setGeneral(genAux.getGeneral());
					
					if( logger.isDebugEnabled() )

	                    logger.debug("Creado el general con los metadatos" );
				}

	        	//Si existe el educational en el Lom le insertamos los valores, si no, lo creamos y insertamos los valores
	        	
	        	if(edu!=null){
	        		edu.setTipoDeRecurso(0, tipo);
	        		edu.setContexto(0, contexto);
	        		edu.setRangoEdad(0, idioma, edad);
	        		edu.setIdiomaDestinatario(0, idiomaDest);
	        		edu.setProcesoCognitivo(0, procesoCog);
	        		
	        		//lomObj.addEducational(edu.getEducational());
	        		lomObj.setEducational(0, edu.getEducational());
	        		
	        		if( logger.isDebugEnabled() )
	                    logger.debug("Creados los metadatos del educational" );
	        	}
	        	else{
	        		EducationalAgrega eduAux=new EducationalAgrega(new Educational());
	        		
	        		eduAux.setTipoDeRecurso(0, tipo);
	        		eduAux.setContexto(0, contexto);
	        		eduAux.setRangoEdad(0, idioma, edad);
	        		eduAux.setIdiomaDestinatario(0, idiomaDest);
	        		eduAux.setProcesoCognitivo(0, procesoCog);
	        		
	        		lomAgrega.addEducationalAgrega(eduAux);
	        		
	        		//lomObj.addEducational(eduAux.getEducational());
	        		lomObj.setEducational(0, eduAux.getEducational());
	        		
	        		if( logger.isDebugEnabled() )

	                    logger.debug("Creado el educational con los metadatos" );
	        	}
	        	
	        	// Si existe el classification en el Lom le insertamos los valores, si no, lo creamos y insertamos los valores
	        	if(clasi!=null){
	        		
	        		int indice= -1;
	        		try{
	        			String arbol=fproperties.getProperty("arbol");
						String proposito=fproperties.getProperty("proposito");
	        			int indiceUltimo=clasi.getIndiceUltimoTaxonPath();
	        			//recorre los taxonPath
	        			for( int i=0;i<longArboles;i++){
	        				
	        				int indexAux= arboles[i].getIdArbol().indexOf(".");
	        				int nCarac=arboles[i].getIdArbol().length();
							String segId= arboles[i].getIdArbol().substring(indexAux+1,nCarac);
							
							indice= Integer.parseInt(segId);
	        				
		        			if(indice>indiceUltimo){
		        				
		        				int indice2=++indiceUltimo;
		        				//clasi.setFuente(indice2, "", "arbol curricular"); 
		        				clasi.setFuente(indice2, idioma, arbol);
		        				clasi.setProposito(proposito);
		        				int indiceTaxon=lomBasico.getClassification().getArbolesCurriculares()[i].getTaxones().length;
		        				//recorre los taxones de un taxonPath
		        				for(int j=0;j<indiceTaxon;j++){

		        					String idTaxon=lomBasico.getClassification().getArbolesCurriculares()[i].getTaxones()[j].getId();
		        					String nomTaxon=lomBasico.getClassification().getArbolesCurriculares()[i].getTaxones()[j].getValorTax();

		        					clasi.addTaxon(indice2, idTaxon, nomTaxon, idioma);
		        					
		        				}
		        				
		        				arboles[i].setIdArbol(indexClas + "." + clasi.getIndiceUltimoTaxonPath());
		        				lomBasico.getClassification().getArbolesCurriculares()[i].setIdArbol(indexClas + "." + indice2);
		        				
		        			}
	        			}

		        	}catch(Exception e1){
		        		
		        		logger.error(e1);
		        	}
	        	}else if((arboles!=null)&& (arboles.length>0)){
	        		
	        		ClassificationAgrega clasAux= new ClassificationAgrega(new Classification());
	        		//prueba arreglo para guardarMetadatos, hallamos el idArbol del ultimo
	        		
	        		int indice= 0;
	        		int indiceUltimo=clasAux.getIndiceUltimoTaxonPath();
        			for( int i=0;i<longArboles;i++){
        				
        				int indexAux= arboles[i].getIdArbol().indexOf(".");
        				int nCarac=arboles[i].getIdArbol().length();
						String segId= arboles[i].getIdArbol().substring(indexAux+1,nCarac);
						
						indice= Integer.parseInt(segId);
        				
	        			if(indice>indiceUltimo){
	        				
	        				int indice2=++indiceUltimo;
	        				//clasAux.setFuente(indice2, "", "arbol curricular");
	        				String arbol=fproperties.getProperty("arbol");
	    					String proposito=fproperties.getProperty("proposito");
	        				clasAux.setFuente(indice2, idioma, arbol);
	        				clasAux.setProposito(proposito);
	        				int indiceTaxon=lomBasico.getClassification().getArbolesCurriculares()[i].getTaxones().length;
	        				for(int j=0;j<indiceTaxon;j++){

	        					String idTaxon=lomBasico.getClassification().getArbolesCurriculares()[i].getTaxones()[j].getId();
	        					String nomTaxon=lomBasico.getClassification().getArbolesCurriculares()[i].getTaxones()[j].getValorTax();

	        					//clasAux.addTaxon(indice2, idTaxon, nomTaxon, "");
	        					clasAux.addTaxon(indice2, idTaxon, nomTaxon, idioma);
	        				}
	        				
	        				arboles[i].setIdArbol(nClassifications + "." + clasAux.getIndiceUltimoTaxonPath());
	        				
	        				lomBasico.getClassification().getArbolesCurriculares()[i].setIdArbol(nClassifications + "." + indice2);	
	        			}
        			}
        			
        			
	        		lomAgrega.addClassificationAgrega(clasAux);
	        		
	        		if ((clasAux.getProposito()!= null) && (clasAux.getFuentes().size()>0)){
	        			//lomObj.addClassification(clasAux.getClassification());
	        			lomObj.setClassification(indexClas, clasAux.getClassification());
        				
        				if( logger.isDebugEnabled() )
    	                    logger.debug("Añadidos los taxonPath" );
	        		}
	        	}
  	
	        	if ((lomAgrega.getClassificationsAgrega()!= null) && (lomAgrega.getClassificationsAgrega().size()>0)){
	        		
		        	ArrayList indiBorrar=new ArrayList();

		        	indexClas= 0;
					boolean encontrado= false;
					ClassificationAgrega ca= null;
					while ((indexClas<lomAgrega.getClassificationsAgrega().size()) &&(!encontrado)){
						ca= lomAgrega.getClassificationAgrega(indexClas);
						String proposito=fproperties.getProperty("proposito");
						if (ca.getProposito().equals(proposito)){
							encontrado= true;
						}
						else{
							indexClas++;
						}
					}

		        	ClassificationAgrega clasifica=lomAgrega.getClassificationAgrega(indexClas);
		        	int ultimoIndice= clasifica.getIndiceUltimoTaxonPath();
		        	if (ultimoIndice >= 0){
			        	for( int k=0;k<=clasifica.getIndiceUltimoTaxonPath();k++){
			        		
			        		String arbolCu=clasifica.getFuente(k, idioma);
			        		String arbol=fproperties.getProperty("arbol");
			        		if(arbol.equals(arbolCu)){
			        			
			        			encontrado=false;
			        			int l=0;
			        			int indice= 0;
			        			ArbolCurricularVO[] arbolCurriculares=lomBasico.getClassification().getArbolesCurriculares();
			        			while((l<arbolCurriculares.length)&& (encontrado == false)){
			        				
			        				int indexAux= arbolCurriculares[l].getIdArbol().indexOf(".");
			        				int nCarac=arbolCurriculares[l].getIdArbol().length();
									String segId= arbolCurriculares[l].getIdArbol().substring(indexAux+1,nCarac);
									
			        				indice= Integer.parseInt(segId);
			        				
			        				if(k==indice)
			        					encontrado=true;
			        				else
			        					encontrado= false;
			        				l++;
			        			}
			        			
			        			if (encontrado == false){
			        				indiBorrar.add(new Integer(k));
			        			}
			        			
			        		}
			        		
			        	}
			        	for( int l=0;l<indiBorrar.size();l++){
			        		
			        		Integer borrar=(Integer)indiBorrar.get(l);
			        		clasifica.removeTaxonPath(borrar.intValue());
			        		for ( int m=0;m<indiBorrar.size();m++){
			        			
			        			Integer aux=(Integer)indiBorrar.get(m);
			        			int auxInt=aux.intValue();
			        			auxInt=auxInt-1;
			        			Integer aux2=new Integer(auxInt);
			        			indiBorrar.set(m, aux2);
			        		}
			        		
			        		if( logger.isDebugEnabled() )
		
			                    logger.debug("Borrado el taxonPath que no está en el lomBasico" );	
			        	}
		        	}
		        	
		        	if ((clasifica.getProposito()!= null) && (clasifica.getFuentes().size()>0)){
		        	
		        		lomObj.setClassification(indexClas, clasifica.getClassification());
		        	}else{

		        		lomAgrega.removeClassificationAgrega(indexClas);
		        		ArrayList clasificationList=new ArrayList();
		        		for(int i=0;i<lomAgrega.getClassificationsAgrega().size();i++){
		        			clasificationList.add(lomAgrega.getClassificationAgrega(i).getClassification());
		        		}
		        		lomObj.setClassification((Classification[])clasificationList.toArray(new Classification[clasificationList.size()]));
		        	}
	        	}
        	
	    		tablaHash.put(identificador, lomObj);
	    		
	    		if( logger.isDebugEnabled() )

                    logger.debug("Añadido el lomObj después de generar los metadatos" );
    			
	    		generarCamposPorDefecto(identificador,usuario,idioma);
	    		
	    		if( logger.isDebugEnabled() )

                    logger.debug("Generados los campos por defecto" );

    		}else{
    			
//    			 el objeto lom no esta en la tabla hash y da un error
    			throw new  Exception("El Objeto LOM no esta en la Tabla Hash");
    		}
    	
    	}catch(Exception e){
    		
    		logger.error(e);
    		throw e;
    	}
    	
    	
		try {
			//creo un writer para escribir los metadatos
			StringWriter sw= new StringWriter();
			//completo el writer
			this.getLomesDao().escribirLom(lomObj, sw);
//			lomesDao.escribirLom(lomObj, sw);
			//creo el datahandler con el string del writer
			resultado = new DataHandler(sw.toString(),"text/xml;charset=utf-8");
			
		} catch (Exception e) {
			logger.error("PLL - error en SrvCatalogacionBasicaService.ExportarLomes: error al generar el contenido a exportar " + e);
			throw e;
		}

    	return resultado;
	}

	protected LomBasicoVO handleImportarLomes(
			DataHandler ficheroLomes, 
			String idioma)
	throws Exception 
	{		
		

		Lom lomObj=null;
		String ficheroProperties="/catalogacion.properties";
		Properties fproperties=new Properties();
		
		LomBasicoVO lomVO=new LomBasicoVO();
		GeneralVO generalVO=new GeneralVO();
		EducationalVO educationalVO=new EducationalVO();
		ClassificationVO clasificacionVO=new ClassificationVO();
		
		try{
			fproperties.load(this.getClass().getResourceAsStream(ficheroProperties));
			InputStream is= ficheroLomes.getInputStream();
			InputSource iso= new InputSource(is);

//			lomObj = lomesDao.parsearLom(iso);
			lomObj =this.getLomesDao().parsearLom(iso);
			if(lomObj!=null){
				
		    	LomAgrega lomAgrega= new LomAgrega(lomObj);//Convertimos el lom de la tablahash en LomAgrega
		    	GeneralAgrega gen=null;
		    	if(lomAgrega.getGeneralAgrega() !=null){
		    		gen=lomAgrega.getGeneralAgrega();
		    	}
			
				//Si existe general recogemos los valores, si no, no hacemos nada
				if (gen !=null){
					
		    		String titulo=gen.getTitulo(idioma);
		    		String idiomas=gen.getIdioma(0);
		    		String desc=gen.getDescripcion(0, idioma);
		    		
		    		generalVO.setTitulo(titulo);
		    		generalVO.setIdioma(idiomas);
		    		generalVO.setDesc(desc);
		    		
		    		lomVO.setGeneral(generalVO);
		    		
				}
				
				EducationalAgrega edu=null;
	    		if(lomAgrega.getEducationalsAgrega().size()>0)
	    			edu=lomAgrega.getEducationalAgrega(0);//Se recoge el primer educational
	    		
				//Si existe educational recogemos valores, si no, no hacemos nada
				if (edu !=null){
					
					String tipo=edu.getTipoDeRecurso(0);
					String contexto=edu.getContexto(0);
					String edad=edu.getRangoEdad(0, idioma);
					String idiomaDest=edu.getIdiomaDestinatario(0);
					String procesoCog=edu.getProcesoCognitivo(0);
					
					educationalVO.setTipo(tipo);
					educationalVO.setContexto(contexto);
					educationalVO.setEdad(edad);
					educationalVO.setIdiomaDest(idiomaDest);
					educationalVO.setProcesoCog(procesoCog);
					
					lomVO.setEducational(educationalVO);
					
				}
				
				
				ArrayList lclassAgrega= lomAgrega.getClassificationsAgrega();
				ArrayList lista= new ArrayList();
				if ((lclassAgrega!= null)&& (lclassAgrega.size()>0)){
					
					int i= 0;
					boolean encontrado= false;
					ClassificationAgrega ca= null;
					while ((i<lclassAgrega.size()) &&(!encontrado)){
						ca= lomAgrega.getClassificationAgrega(i);
						String proposito=fproperties.getProperty("proposito");
						if (ca.getProposito().equals(proposito)){
							encontrado= true;
						}
						else{
							i++;
						}
					}
					String arbol=fproperties.getProperty("arbol");
					if((encontrado==true)&&(i<lclassAgrega.size())){
				
						for( int j=0; j<ca.getTaxonPathsCount(); j++){
							if(arbol.equals(ca.getFuente(j, idioma))){
								ArbolCurricularVO arbolCu=new ArbolCurricularVO();
								arbolCu.setIdArbol(i + "." + j);
								
								ArrayList tax=new ArrayList();
								for( int k=0;k<=ca.getIndiceUltimoTaxon(j);k++){
								// Se recogen los taxones de un taxonPath	
									CBTaxonVO cbTaxon=new CBTaxonVO();
									String identi=ca.getIdentificador(j, k);
									String entry=ca.getEntrada(j, k, idioma);
									cbTaxon.setId(identi);
									cbTaxon.setValorTax(entry);
									cbTaxon.setEsHoja(new Boolean (false)); //siempre a false pq no nos importa el valor
									
									tax.add(cbTaxon);
								}
								
								Collections.reverse(tax);
								CBTaxonVO[] taxonList=(CBTaxonVO[])tax.toArray(new CBTaxonVO[tax.size()]);
								arbolCu.setTaxones(taxonList);
								lista.add(arbolCu);
			
							}
						}
					}
					
					ArbolCurricularVO[] listaArbol=(ArbolCurricularVO[])lista.toArray(new ArbolCurricularVO[lista.size()]);
	//				
					clasificacionVO.setArbolesCurriculares(listaArbol);
					
					lomVO.setClassification(clasificacionVO);
					
				}
	
			}else{
				throw new  Exception("El Objeto LOM no esta en la Tabla Hash");
			}
			
		
			}catch(Exception e){
			logger.error(e);
			throw e;
		}
	
			return lomVO;
	}

	/**
	 * Elimina la taxonomia de identificador idArbol del lomBasico
	 * 
	 * @param lomBasico Objeto que almacena los datos obligatorios de los campos general y educational, y los árboles curriculares del campo classification
	 * @param idArbol[] array de Identificadores de los árboles curriculares a eliminar dentro de la categoría classification
	 * @return lomBasico El lomBasico de entrada sin los árboles curriculares indicados por el array de identificadores 
	 * @throws Exception
	 */
	protected LomBasicoVO handleEliminarTaxonomiasEnLomBasico(
			LomBasicoVO lomBasico, 
			String[] idArbol) 
	throws Exception 
	{
			
			if(lomBasico.getClassification()!=null){
				ClassificationVO clasificacion=lomBasico.getClassification();
				ArbolCurricularVO[] arboles=clasificacion.getArbolesCurriculares();
				ClassificationVO miClasificacion=new ClassificationVO();
				List lista =new ArrayList();
				
				boolean eliminado;
				for (int i = 0; i < arboles.length; i++) 
				{
					String  idArbolEliminar= arboles[i].getIdArbol();
					eliminado= false;
					for (int j = 0; j < idArbol.length && !eliminado; j++) 
					{
						if(idArbolEliminar!=null && (idArbolEliminar.equals(idArbol[j])))
						{
							eliminado=true;
						}
					}
					if(!eliminado)
						lista.add(arboles[i]);
				}
				
				miClasificacion.setArbolesCurriculares((ArbolCurricularVO[])lista.toArray(new ArbolCurricularVO[lista.size()]));
			    lomBasico.setClassification(miClasificacion);
			}
			return lomBasico;
	}


  

}
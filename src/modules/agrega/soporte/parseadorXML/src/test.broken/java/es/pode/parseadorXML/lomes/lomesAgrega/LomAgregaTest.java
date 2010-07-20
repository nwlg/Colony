/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML.lomes.lomesAgrega;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.pode.parseadorXML.LomESDao;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.castor.Classification;
import es.pode.parseadorXML.castor.Educational;
import es.pode.parseadorXML.castor.GroupEducationalEducational;
import es.pode.parseadorXML.castor.Lom;


public class LomAgregaTest extends TestCase {

	private LomESDao dao = null;

	private Properties properties = null;

	private ClassPathXmlApplicationContext context = null;

	private Logger logger = Logger.getLogger(this.getClass());

	public LomAgregaTest(String arg0) {
		super(arg0);
		this.context = new ClassPathXmlApplicationContext(
				"parseadorXML-applicationContext.xml");
		this.dao = (LomESDao) this.context.getBean("lomesDao",
				LomESDao.class);
		this.properties = new Properties();

		try {
			InputStream is = this.getClass().getResourceAsStream(
					"/parseadorXML.properties");
			properties.load(is);
		} catch (IOException e) {
			logger.error("No se pudo abrir el fichero de propiedades; ", e);
		}
	}

	protected void setUp() throws Exception {
		super.setUp();
		logger.info("Paso por setup");
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGeneral() {
		try {
			URL url = this.getClass().getResource(
					"/" + properties.getProperty("test.lomes"));
			if (url != null) {

				Lom lom= dao.parsearLom(new File("D:/metadatoLote1.xml"));
				LomAgrega lomAgrega = new LomAgrega(lom);	
				GeneralAgrega generalAgrega= lomAgrega.getGeneralAgrega();

				try{
					String titulo= generalAgrega.getTitulo("es");
					assertNotNull("Título distinto de null?", titulo);
					
					List l= generalAgrega.getIdiomas();
					assertNotNull("Lista de idiomas distinta de null?", l);
					
					String idioma= generalAgrega.getIdioma(0);
					
					generalAgrega.addIdioma("en");
					generalAgrega.addIdioma("fr");
					
					String desc= generalAgrega.getDescripcion(0, "es");
					String desc2= generalAgrega.getDescripcion(0, "fr");
					
					ArrayList ldesc= generalAgrega.getDescripcionesIdioma("es");
					ArrayList ldesc2= generalAgrega.getDescripcionesIdioma("fr");
					
					ArrayList ldesc3= generalAgrega.getDescripciones();
					
					generalAgrega.addDescripcion("es", "Se inserta una descripción de prueba");
					
					generalAgrega.setIdentificadorMEC("Catalogo MEC de prueba", "ID MEC de prueba");
					
					String PrimerId= generalAgrega.getPrimerIdentificador();
					
					String catalogo= generalAgrega.getCatalogo(0);
					
					String entry= generalAgrega.getEntry(0);
					
					String nivel= generalAgrega.getNivelDeAgregacion();
					generalAgrega.setNivelDeAgregacion("2");
					
					boolean id= generalAgrega.hasIdentifier();
					int nIds= generalAgrega.getCountIdentifier();
					
					ArrayList lKwi= generalAgrega.getPalabrasClaveIdioma("es");
					ArrayList lKwi2= generalAgrega.getPalabrasClaveIdioma("fr");
					ArrayList lKw= generalAgrega.getPalabrasClave();
					ArrayList ambitos=generalAgrega.getAmbitos();
				} catch (Exception e){
					String mensaje = "Error al obtener elemento de LOM-ES: " +e;
				    logger.error(mensaje);
				}
						
				Lom lomNuevo= new Lom();
				LomAgrega lomAgregaNuevo = new LomAgrega(lomNuevo);	
				GeneralAgrega generalAgregaNuevo= lomAgregaNuevo.getGeneralAgrega();
				
				try{
//					String titulo= generalAgregaNuevo.getTitulo("es");
//					assertNotNull("Título distinto de null?", titulo);
					
//					List l= generalAgregaNuevo.getIdiomas();
//					assertNotNull("Lista de idiomas distinta de null?", l);
					
//					String idioma= generalAgregaNuevo.getIdioma(0);
					
//					generalAgregaNuevo.setIdioma("en");
//					generalAgregaNuevo.setIdioma("fr");
					
//					String desc= generalAgregaNuevo.getDescripcion(0, "es");
//					String desc2= generalAgregaNuevo.getDescripcion(0, "fr");
					
//					ArrayList ldesc= generalAgregaNuevo.getDescripcionesIdioma("es");
//					ArrayList ldesc2= generalAgregaNuevo.getDescripcionesIdioma("fr");
					
//					ArrayList ldesc3= generalAgregaNuevo.getDescripciones();
					
//					generalAgregaNuevo.setDescripcion("es", "Se inserta una descripción de prueba");
					
//					generalAgregaNuevo.setIdentificadorMEC("Catalogo MEC de prueba", "ID MEC de prueba");
//					
//					String PrimerId= generalAgregaNuevo.getPrimerIdentificador();
					
//					String catalogo= generalAgregaNuevo.getCatalogo(0);
					
//					String entry= generalAgregaNuevo.getEntry(0);
					
//					String nivel= generalAgregaNuevo.getNivelDeAgregacion();
					generalAgregaNuevo.setNivelDeAgregacion("2");
					
					boolean id= generalAgregaNuevo.hasIdentifier();
					int nIds= generalAgregaNuevo.getCountIdentifier();
					
					ArrayList lKwi= generalAgregaNuevo.getPalabrasClaveIdioma("es");
					ArrayList lKwi2= generalAgregaNuevo.getPalabrasClaveIdioma("fr");	
					ArrayList lKw= generalAgregaNuevo.getPalabrasClave();
					
				}catch (Exception e){
					logger.error(e);
				}
				
				try{
					lomAgregaNuevo.setGeneralAgrega(generalAgregaNuevo);
				}catch (Exception e){
					logger.error(e);
				}
				
				logger.info("OK");
			} else
				fail("Recurso de test "
						+ properties.getProperty("test.lomes")
						+ " no encontrado");

		} catch (ParseadorException e) {
			logger.error(e);
		}
	}
	
	public void testLifeCycle() {
		try {
			URL url = this.getClass().getResource(
					"/" + properties.getProperty("test.lomes"));
			if (url != null) {

				Lom lom= dao.parsearLom(new File("D:/metadatoLote1.xml"));
				LomAgrega lomAgrega = new LomAgrega(lom);	
				LifeCycleAgrega lcAgrega= lomAgrega.getLifeCycleAgrega();

				try{
					String rol= lcAgrega.getRol(0);
					assertNotNull("Rol distinto de null?", rol);
					
					String entidad= lcAgrega.getEntidad(0, 0);
					assertNotNull("Entidad distinta de null?", entidad);
					
					ArrayList entidades= lcAgrega.getEntidades(0);
					
					String fecha= lcAgrega.getFecha(0);
					
//					lcAgrega.addContribucion("author", "autor del ODE", "2007-12-23", "Descripcion del autor");
					
					ArrayList autores= lcAgrega.getAutores();
					ArrayList publica=lcAgrega.getPublicadores();
					ArrayList revisor=lcAgrega.getRevisores();
					String fechaPublicacion= lcAgrega.getFechaPublicacion();
					
					String sinVCard= lcAgrega.interpretaVCard("BEGIN:VCARD VERSION:3.0 FN: pepito de los palotes, lalala EMAIL;TYPE=INTERNET:  ORG: ");
	
				} catch (Exception e){
					String mensaje = "Error al obtener elemento de LOM-ES: " +e;
				    logger.error(mensaje);
				}
						
				Lom lomNuevo= new Lom();
				LomAgrega lomAgregaNuevo = new LomAgrega(lomNuevo);	
				LifeCycleAgrega lcAgregaNuevo= lomAgregaNuevo.getLifeCycleAgrega();
				
				try{

					//String rololipn= lcAgregaNuevo.getRol(0);
					//assertNotNull("Rol distinto de null?", rol);
					
//					String entidad= lcAgregaNuevo.getEntidad(0, 0);
//					assertNotNull("Entidad distinta de null?", entidad);
					
					//ArrayList entidades= lcAgregaNuevo.getEntidades(0);
					
					//String fecha= lcAgregaNuevo.getFecha(0);
					
					lcAgregaNuevo.addContribucion("author", "autor del ODE", "2007-12-23", "Descripcion del autor");
					
				}catch (Exception e){
					String mensaje = "Error al obtener elemento de LOM-ES: " +e;
				    logger.error(mensaje);
				}
				
				try{
					lomAgregaNuevo.setLifeCycleAgrega(lcAgregaNuevo);
				}catch (Exception e){
					String mensaje = "Error al insertar LOM-ES: " +e;
				    logger.error(mensaje);
				}
				
				logger.info("OK");
			} else
				fail("Recurso de test "
						+ properties.getProperty("test.lomes")
						+ " no encontrado");

		} catch (ParseadorException e) {

			logger.error(e);
		}
	}
	
	public void testMetaMetadata() {
		try {
			URL url = this.getClass().getResource(
					"/" + properties.getProperty("test.lomes"));
			if (url != null) {

				Lom lom= dao.parsearLom(new File("D:/metadatoLote1.xml"));
				LomAgrega lomAgrega = new LomAgrega(lom);	
				MetaMetadataAgrega mmdAgrega= lomAgrega.getMetaMetadataAgrega();

				try{
					String rol= mmdAgrega.getRol(0);
					assertNotNull("Rol distinto de null?", rol);
					
					String entidad= mmdAgrega.getEntidad(0, 0);
					assertNotNull("Entidad distinta de null?", entidad);
					
					ArrayList entidades= mmdAgrega.getEntidades(0);
					
					String fecha= mmdAgrega.getFecha(0);
					
					mmdAgrega.addContribucion("author", "catalogador del ODE", "2007-12-25", "Descripcion del catalogador");
	
				} catch (Exception e){
					String mensaje = "Error al obtener elemento de LOM-ES: " +e;
				    logger.error(mensaje);
				}
						
				Lom lomNuevo= new Lom();
				LomAgrega lomAgregaNuevo = new LomAgrega(lomNuevo);	
				MetaMetadataAgrega mmdAgregaNuevo= lomAgregaNuevo.getMetaMetadataAgrega();
				
				try{

					//String rololipn= lcAgregaNuevo.getRol(0);
					//assertNotNull("Rol distinto de null?", rol);
					
//					String entidad= lcAgregaNuevo.getEntidad(0, 0);
//					assertNotNull("Entidad distinta de null?", entidad);
					
					//ArrayList entidades= lcAgregaNuevo.getEntidades(0);
					
					//String fecha= lcAgregaNuevo.getFecha(0);
					
					mmdAgregaNuevo.addContribucion("author", "catalogador del ODE", "2007-12-25", "Descripcion del catalogador");
					
				}catch (Exception e){
					String mensaje = "Error al obtener elemento de LOM-ES: " +e;
				    logger.error(mensaje);
				}
				
				try{
					lomAgregaNuevo.setMetaMetadataAgrega(mmdAgregaNuevo);
				}catch (Exception e){
					String mensaje = "Error al insertar LOM-ES: " +e;
				    logger.error(mensaje);
				}
				
				logger.info("OK");
			} else
				fail("Recurso de test "
						+ properties.getProperty("test.lomes")
						+ " no encontrado");

		} catch (ParseadorException e) {

			logger.error(e);
		}
	}
	
	
	public void testTechnical() {
		try {
			URL url = this.getClass().getResource(
					"/" + properties.getProperty("test.lomes"));
			if (url != null) {

				Lom lom= dao.parsearLom(new File("D:/metadatoLote1.xml"));
				LomAgrega lomAgrega = new LomAgrega(lom);	
				TechnicalAgrega tecAgrega= lomAgrega.getTechnicalAgrega();

				try{
					ArrayList formatos= tecAgrega.getFormatos();
					assertNotNull("Rol distinto de null?", formatos);
				
	
				} catch (Exception e){
					String mensaje = "Error al obtener elemento de LOM-ES: " +e;
				    logger.error(mensaje);
				}
						
				Lom lomNuevo= new Lom();
				LomAgrega lomAgregaNuevo = new LomAgrega(lomNuevo);	
				TechnicalAgrega tecAgregaNuevo= lomAgregaNuevo.getTechnicalAgrega();
				
				try{
					
					ArrayList formatos= tecAgregaNuevo.getFormatos();
					
				}catch (Exception e){
					String mensaje = "Error al obtener elemento de LOM-ES: " +e;
				    logger.error(mensaje);
				}
				
				try{
					lomAgregaNuevo.setTechnicalAgrega(tecAgregaNuevo);
				}catch (Exception e){
					String mensaje = "Error al insertar LOM-ES: " +e;
				    logger.error(mensaje);
				}
				
				logger.info("OK");
			} else
				fail("Recurso de test "
						+ properties.getProperty("test.lomes")
						+ " no encontrado");

		} catch (ParseadorException e) {
			logger.error(e);
		}
	}
	
	public void testEducational() {
		try {
			URL url = this.getClass().getResource(
					"/" + properties.getProperty("test.lomes"));
			if (url != null) {

				Lom lom= dao.parsearLom(new File("D:/metadatoLote1.xml"));
				LomAgrega lomAgrega = new LomAgrega(lom);	

				try{
					EducationalAgrega eduAgrega= lomAgrega.getEducationalAgrega(0);
					
					String contexto= eduAgrega.getContexto(0);
					assertNotNull("Rol distinto de null?", contexto);
					
					ArrayList lContextos= eduAgrega.getContextos();
					eduAgrega.addContexto("classroom");
					
					String tipoRecurso= eduAgrega.getTipoDeRecurso(0);
					ArrayList tiposRecurso= eduAgrega.getTiposDeRecurso();
					eduAgrega.addTipoDeRecurso("video");
					
					String rangoEs= eduAgrega.getRangoEdad(0, "es");
					String rangoFr= eduAgrega.getRangoEdad(0, "fr");
					ArrayList rangosEs= eduAgrega.getRangosEdadIdioma("es");
					ArrayList rangosFr= eduAgrega.getRangosEdadIdioma("fr");
					eduAgrega.addRangoEdad("es", "mayores 18");
					
					String idioma= eduAgrega.getIdiomaDestinatario(0);
					ArrayList idiomas= eduAgrega.getIdiomasDestinatario();
					eduAgrega.addIdiomaDestinatario("fr");
					
					//eduAgrega.getProcesoCognitivo(0);
					ArrayList pcs= eduAgrega.getProcesosCognitivos();
					eduAgrega.addProcesoCognitivo("analyse");
					
					String des= eduAgrega.getDestinatario(0);
					ArrayList dList= eduAgrega.getDestinatarios();
				
	
				} catch (Exception e){
					String mensaje = "Error al obtener elemento de LOM-ES: " +e;
				    logger.error(mensaje);
				}
						
				Lom lomNuevo= new Lom();
				LomAgrega lomAgregaNuevo = new LomAgrega(lomNuevo);
		
				try{
					EducationalAgrega eduAgregaNuevo= null;
					try{
						ArrayList l= lomAgregaNuevo.getEducationalsAgrega();
						if ((l != null) && (l.size()>0)){
							eduAgregaNuevo= lomAgregaNuevo.getEducationalAgrega(0);
						}
						else{
							eduAgregaNuevo= new EducationalAgrega(new Educational());
							GroupEducationalEducational gee= new GroupEducationalEducational();
							eduAgregaNuevo.getEducational().setGroupEducationalEducational(gee);
						}
		
					
					} catch (Exception e){
						String mensaje = "Error al obtener Educational de LOM-ES: " +e;
					    logger.error(mensaje);
					}
					
					
//					String contexto= eduAgregaNuevo.getContexto(0);
//					assertNotNull("Rol distinto de null?", contexto);
//					
//					ArrayList lContextos= eduAgregaNuevo.getContextos();
//					eduAgregaNuevo.addContexto("classroom");
//					
//					String tipoRecurso= eduAgregaNuevo.getTipoDeRecurso(0);
//					ArrayList tiposRecurso= eduAgregaNuevo.getTiposDeRecurso();
					eduAgregaNuevo.addTipoDeRecurso("video");
					
//					String rangoEs= eduAgregaNuevo.getRangoEdad(0, "es");
//					String rangoFr= eduAgregaNuevo.getRangoEdad(0, "fr");
//					ArrayList rangosEs= eduAgregaNuevo.getRangosEdadIdioma("es");
//					ArrayList rangosFr= eduAgregaNuevo.getRangosEdadIdioma("fr");
					eduAgregaNuevo.addRangoEdad("es", "mayores 18");
					
//					String idioma= eduAgregaNuevo.getIdiomaDestinatario(0);
//					ArrayList idiomas= eduAgregaNuevo.getIdiomasDestinatario();
					eduAgregaNuevo.addIdiomaDestinatario("fr");
					
//					eduAgregaNuevo.getProcesoCognitivo(0);
//					ArrayList pcs= eduAgregaNuevo.getProcesosCognitivos();
					eduAgregaNuevo.addProcesoCognitivo("analyse");
					
//					String des= eduAgregaNuevo.getDestinatario(0);
//					ArrayList dList= eduAgregaNuevo.getDestinatarios();
					
					try{
						lomAgregaNuevo.addEducationalAgrega (eduAgregaNuevo);
					}catch (Exception e){
						String mensaje = "Error al insertar LOM-ES: " +e;
					    logger.error(mensaje);
					}
					
				}catch (Exception e){
					String mensaje = "Error al obtener elemento de LOM-ES: " +e;
				    logger.error(mensaje);
				}
				
				logger.info("OK");
			} else
				fail("Recurso de test "
						+ properties.getProperty("test.lomes")
						+ " no encontrado");

		} catch (ParseadorException e) {
			logger.error(e);
		}
	}
	
	public void testRights() {
		try {
			URL url = this.getClass().getResource(
					"/" + properties.getProperty("test.lomes"));
			if (url != null) {

				Lom lom= dao.parsearLom(new File("D:/metadatoLote1.xml"));
				LomAgrega lomAgrega = new LomAgrega(lom);	
				RightsAgrega rigAgrega= lomAgrega.getRightsAgrega();

				try{
					String coste= rigAgrega.getCoste();
					assertNotNull("Coste distinto de null?", coste);
					
					String derechos= rigAgrega.getDerechosDeAutor();
					assertNotNull("Derechos distinto de null?", derechos);
					
					String desEs= rigAgrega.getDescripcionAcceso("es");
					String desFr= rigAgrega.getDescripcionAcceso("fr");
					
					String tipo= rigAgrega.getTipoDeAcceso();
					assertNotNull("Tipo de acceso distinto de null?", tipo);
					
					rigAgrega.setCoste("yes");
					rigAgrega.setDerechosDeAutor("public domain");
					rigAgrega.setAcceso("universal", "Acceso todas CCAA");
				
	
				} catch (Exception e){
					String mensaje = "Error al obtener elemento de LOM-ES: " +e;
				    logger.error(mensaje);
				}
						
				Lom lomNuevo= new Lom();
				LomAgrega lomAgregaNuevo = new LomAgrega(lomNuevo);	
				RightsAgrega rigAgregaNuevo= lomAgregaNuevo.getRightsAgrega();
				
				try{
					
					rigAgregaNuevo.setCoste("yes");
					rigAgregaNuevo.setDerechosDeAutor("public domain");
					rigAgregaNuevo.setAcceso("universal", "Acceso todas CCAA");
					
					String coste= rigAgregaNuevo.getCoste();
					assertNotNull("Coste distinto de null?", coste);
					
					String derechos= rigAgregaNuevo.getDerechosDeAutor();
					assertNotNull("Derechos distinto de null?", derechos);
					
					String desEs= rigAgregaNuevo.getDescripcionAcceso("es");
					String desFr= rigAgregaNuevo.getDescripcionAcceso("fr");
					
					String tipo= rigAgregaNuevo.getTipoDeAcceso();
					assertNotNull("Tipo de acceso distinto de null?", tipo);
					
				}catch (Exception e){
					String mensaje = "Error al obtener elemento de LOM-ES: " +e;
				    logger.error(mensaje);
				}
				
				try{
					lomAgregaNuevo.setRightsAgrega(rigAgregaNuevo);
				}catch (Exception e){
					String mensaje = "Error al insertar LOM-ES: " +e;
				    logger.error(mensaje);
				}
				
				logger.info("OK");
			} else
				fail("Recurso de test "
						+ properties.getProperty("test.lomes")
						+ " no encontrado");

		} catch (ParseadorException e) {
			logger.error(e);
		}
	}
	public void testRelation() {
		try {
			URL url = this.getClass().getResource(
					"/" + properties.getProperty("test.lomes"));
			if (url != null) {

				Lom lom= dao.parsearLom(new File("D:/metadatoLote1.xml"));
				LomAgrega lomAgrega = new LomAgrega(lom);	

				try{
					ArrayList identifi=new ArrayList();
					ArrayList tipos=new ArrayList();
					ArrayList relaciones = lomAgrega.getRelationsAgrega();
					for(int i=0;i<relaciones.size();i++){
						RelationAgrega relacion=(RelationAgrega)relaciones.get(i);
						String ident=relacion.getIdentificadorMEC();
						if(ident!=null){
							identifi.add(ident);
							logger.info(ident);
						}
						
						String tipo=relacion.getTipoRelacionMEC();
						if(tipo!=null){
							tipos.add(tipo);
							logger.info(tipo);
						}
					}
				}catch (Exception e){
					String mensaje = "Error al obtener elemento de LOM-ES: " +e;
				    logger.error(mensaje);
				}
			}
		}catch (ParseadorException e) {
			logger.error(e);
		}
	}
	
	public void testClassification() {
		try {
			URL url = this.getClass().getResource(
					"/" + properties.getProperty("test.lomes"));
			if (url != null) {

				Lom lom= dao.parsearLom(new File("D:/metadatoLote1.xml"));
				LomAgrega lomAgrega = new LomAgrega(lom);	

				try{
					ClassificationAgrega claAgrega= lomAgrega.getClassificationAgrega(0);
					
					String proposito= claAgrega.getProposito();
					assertNotNull("Propósito distinto de null?", proposito);
					claAgrega.setProposito("discipline");
					
					String fuenteEs= claAgrega.getFuente(0, "es");
					assertNotNull("Fuente distinta de null?", fuenteEs);
					String fuenteFr= claAgrega.getFuente(0, "fr");
					ArrayList fList= claAgrega.getFuentesIdioma("es");
					ArrayList fList2= claAgrega.getFuentesIdioma("fr");
					ArrayList fList3= claAgrega.getFuentes();
					
					String id= claAgrega.getIdentificador(0, 0);
					//String id1= claAgrega.getIdentificador(0, 1);
					//String id2= claAgrega.getIdentificador(1, 0);
					//String id3= claAgrega.getIdentificador(1, 1);
					
					ArrayList idList= claAgrega.getIdentificadores(0);
					
					String enEs= claAgrega.getEntrada(0, 0, "es");
					String enFr= claAgrega.getEntrada(0, 0, "fr");
					String en= claAgrega.getEntrada(0, 0, "");
//					String en2= claAgrega.getEntrada(0, 1, "es");
//					String en3= claAgrega.getEntrada(1, 0, "es");
//					String en4= claAgrega.getEntrada(1, 1, "es");
					
					claAgrega.setFuente(0, "es", "fuente de prueba");
					claAgrega.setFuente(2, "es", "fuente de prueba");
					
					claAgrega.addTaxon(0, "0.0.0", "Taxon de prueba", "es");
//					claAgrega.addTaxon(1, "0.0.0", "Taxon de prueba", "es");
//					claAgrega.addTaxon(2, "0.0.0", "Taxon de prueba", "es");
					
					int in= claAgrega.getIndiceUltimoTaxonPath();
					int in1= claAgrega.getIndiceUltimoTaxon(0);
					int l= claAgrega.getTaxonPathsCount();
					
//					ArrayList arboles= claAgrega.getArbolesCurriculares("");
//					ArrayList arboles2= claAgrega.getArbolesCurriculares("es");
//					ArrayList arbolesIds= claAgrega.getIdsArbolesCurriculares("es");
//					ArrayList arbolesIds2= claAgrega.getIdsArbolesCurriculares("");
					
					ArrayList niveles= claAgrega.getIdsNivelesEducativos("es");
					
					//claAgrega.removeTaxonPath(1);
					claAgrega.removeTaxonPath(0);
					
					
				} catch (Exception e){
					String mensaje = "Error al obtener elemento de LOM-ES: " +e;
				    logger.error(mensaje);
				}
						
				Lom lomNuevo= new Lom();
				LomAgrega lomAgregaNuevo = new LomAgrega(lomNuevo);
		
				try{
					ClassificationAgrega claAgregaNuevo= null;
					try{
						ArrayList l= lomAgregaNuevo.getClassificationsAgrega();
						if ((l != null) && (l.size()>0)){
							claAgregaNuevo= lomAgregaNuevo.getClassificationAgrega(0);
						}
						else{
							claAgregaNuevo= new ClassificationAgrega(new Classification());
							
						}
						

						claAgregaNuevo.setProposito("discipline");
						
						claAgregaNuevo.setFuente(0, "es", "Árbol curricular LOE 2006");
						claAgregaNuevo.setFuente(0, "es", "Nivel educativo LOM-ESv1.0");
						claAgregaNuevo.setFuente(2, "es", "fuente de prueba");
						
//						claAgregaNuevo.addTaxon(0, "0.0.0", "Taxon de prueba", "es");
//						claAgregaNuevo.addTaxon(1, "0.0.0", "Taxon de prueba", "es");
//						claAgregaNuevo.addTaxon(2, "0.0.0", "Taxon de prueba", "es");
						
						int in= claAgregaNuevo.getIndiceUltimoTaxonPath();
//						int in1= claAgregaNuevo.getIndiceUltimoTaxon(0);
						int count= claAgregaNuevo.getTaxonPathsCount();
						
//						ArrayList arboles= claAgregaNuevo.getArbolesCurriculares("");
//						ArrayList arboles2= claAgregaNuevo.getArbolesCurriculares("es");
//						ArrayList arbolesIds= claAgregaNuevo.getIdsArbolesCurriculares("es");
//						ArrayList arbolesIds2= claAgregaNuevo.getIdsArbolesCurriculares("");
						
						ArrayList niveles= claAgregaNuevo.getIdsNivelesEducativos("es");
						
//						claAgregaNuevo.removeTaxonPath(1);
//						claAgregaNuevo.removeTaxonPath(0);
		
					
					} catch (Exception e){
						String mensaje = "Error al obtener Classification de LOM-ES: " +e;
					    logger.error(mensaje);
					}
					
					try{
						lomAgregaNuevo.addClassificationAgrega (claAgregaNuevo);
					}catch (Exception e){
						String mensaje = "Error al insertar LOM-ES: " +e;
					    logger.error(mensaje);
					}
					
				}catch (Exception e){
					String mensaje = "Error al obtener elemento de LOM-ES: " +e;
				    logger.error(mensaje);
				}

				logger.info("OK");
			} else
				fail("Recurso de test "
						+ properties.getProperty("test.lomes")
						+ " no encontrado");

		} catch (ParseadorException e) {
			logger.error(e);
		}
	}

//	public void testSetLom() {
//		try {
//			URL url = this.getClass().getResource(
//					"/" + properties.getProperty("test.manifest"));
//			if (url != null) {
//				Manifest manifest = dao.parsearODELazy(new File(url.getFile()));
//				ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);
//
//				Lom lomAInsertar = new Lom();
//				// Insertamos un Lom vacio en tres elementos (uno con Lom
//				// previo, otro con metadata sin Lom y otro sin metadata
//				manifestAgrega.setLom("MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8",null, lomAInsertar);
//				manifestAgrega.setLom("ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699",null, lomAInsertar);
//				manifestAgrega.setLom("ITEM-F7E7F37D-5427-58DC-E205-19D75FF4DA35",null, lomAInsertar);
//				manifestAgrega.setLom("RES-1937E17748FA68C8270AA65D7691BB67","contenido/actividad.html", lomAInsertar);
//
//				// Comprobamos que estos elementos tienen un Lom vacio
////				Lom extraido = manifestAgrega.obtenerLom("MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8",null);
////				assertTrue("Con Lom previo: ", extraido instanceof Lom && extraido.getGeneral()!=null);
////				extraido = manifestAgrega.obtenerLom("ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699",null);
////				assertTrue("Con Metadata previo sin Lom: ", extraido instanceof Lom && extraido.getGeneral()!=null);
////				extraido = manifestAgrega.obtenerLom("ITEM-F7E7F37D-5427-58DC-E205-19D75FF4DA35",null);
////				assertTrue("Sin Metadata previo: ", extraido instanceof Lom && extraido.getGeneral()!=null);
////				extraido = manifestAgrega.obtenerLom("RES-1937E17748FA68C8270AA65D7691BB67","contenido/actividad.html");
////				assertTrue("Sin Metadata previo: ", extraido instanceof Lom && extraido.getGeneral()!=null);
//				
//				dao.escribirODE(manifest, new File("D:/resultado_test.xml"));
//				System.out.println("OK");
//			} else
//				fail("Recurso de test "
//						+ properties.getProperty("test.manifest")
//						+ " no encontrado");
//
//		} catch (ParseadorException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
//	public void testObtenerLom() {
//		try {
//			URL url = this.getClass().getResource(
//					"/" + properties.getProperty("test.manifest"));
//			if (url != null) {
//				Manifest manifest = dao.parsearODELazy(new File(url.getFile()));
//				ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);
//
//				Lom lom1 = manifestAgrega
//						.obtenerLom("MANIFEST-9AFF8BAC67A819C826E54E040640DBFE", null);
//				Lom lom2 = manifestAgrega
//						.obtenerLom("RES-1937E17748FA68C8270AA65D7691BB67", null);
//				Lom lom3 = manifestAgrega
//						.obtenerLom("MANIFEST-2B3052FE-91ED-61FC-F5BF-2E7ED32F1BE5", null);
//				Lom lom4 = manifestAgrega
//				.obtenerLom("RES-1937E17748FA68C8270AA65D7691BB67","contenido/actividad.html");
//				Lom lomNull = manifestAgrega
//						.obtenerLom("ORG-6B2AEB07-8EA1-B15D-C129-B6D8A5F66956", null);
//
//				assertTrue("lom1: ", lom1 instanceof Lom);
//				assertTrue("lom2: ", lom2 instanceof Lom);
//				assertTrue("lom3: ", lom3 instanceof Lom);
//				assertTrue("lom3: ", lom4 instanceof Lom);
//				assertNull("lomNull: ", lomNull);
//
//				System.out.println("OK");
//			} else
//				fail("Recurso de test "
//						+ properties.getProperty("test.manifest")
//						+ " no encontrado");
//
//		} catch (ParseadorException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}

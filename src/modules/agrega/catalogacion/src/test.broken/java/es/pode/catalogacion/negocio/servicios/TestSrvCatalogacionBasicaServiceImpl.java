/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.catalogacion.negocio.servicios;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.activation.DataHandler;
import javax.mail.util.ByteArrayDataSource;

import org.apache.log4j.Logger;

import es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceImpl;
import es.pode.parseadorXML.LomESDao;
import es.pode.parseadorXML.ParseadorException;


/**
 * @see SrvCatalogacionBasicaServiceImpl
 */
public class TestSrvCatalogacionBasicaServiceImpl
    extends SrvCatalogacionBasicaServiceImplBase
{
	
	private static Logger logger = Logger.getLogger(TestSrvCatalogacionBasicaServiceImpl.class);
	
	private LomESDao lomesDao=new LomESDao();
	

	public LomESDao getLomesDao() {
		return lomesDao;
	}

	public void setLomesDao(LomESDao lomesDao) {
		this.lomesDao = lomesDao;
	}

    /**
     * Constructor
     */
     public TestSrvCatalogacionBasicaServiceImpl(){
		super();
	}

    /**
     * onSetUpInTransaction
     */

     protected void onSetUpInTransaction() throws Exception {

     	/**
     	 * Implementar si no desea usar DataSets
     	 */
		super.onSetUpInTransaction();
	}

    /**
     * onTearDownInTransaction
     */

	 protected void onTearDownInTransaction() {

     	/**
     	 * Implementar si no desea usar DataSets
     	 */
	 	
    	 super.onTearDownInTransaction();
     }
	

    /**
     * testInicial
     *   TODO: Agregar las pruebas unitarias que correspondan al servicio, siguiendo un patron de nombrado como
     *     public void test<nombreTest>().
     */	
     public void testInicial(){
		assertTrue(true);
	}
     
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
	
     public void testcargarObjLom() throws ParseadorException, IOException {
    	 
    	 
    	 SrvCatalogacionBasicaService cargarObjLom=this.servicio;
    	 
    	 String identificadorCompleto="idLOM";
    	 String identificador1="idLOM1";
    	 String identificador2="idLOM2";
    	 String identificador3="idLOM3";
    	 String identificador4="idLOM4";
    	 String identificador5="idLOM5";
    	 String identificador6="idLOM6";
    	 String identificadorVacio="idLOMVacio";
    	 String identificadorLote="idLOMLote";
    	 
//    	 String lomCompleto="../catalogacion/core/src/test-resources/pruebasDeMetadatos/metadatoCompleto.xml";//toda la estructura
    	 String lom1="../catalogacion/core/src/test-resources/pruebasDeMetadatos/metadato1_N20.xml";//con todas las estructuras
//    	 String lom2="../catalogacion/core/src/test-resources/pruebasDeMetadatos/metadato1_N21.xml";//sin general
//    	 String lom3="../catalogacion/core/src/test-resources/pruebasDeMetadatos/metadato1_N22.xml";//sin Ciclo de Vida
//    	 String lom4="../catalogacion/core/src/test-resources/pruebasDeMetadatos/metadato1_N23.xml";//sin MetaMetadata
//    	 String lom5="../catalogacion/core/src/test-resources/pruebasDeMetadatos/metadato1_N24.xml";//sin educational
//    	 String lom6="../catalogacion/core/src/test-resources/pruebasDeMetadatos/metadato1_N25.xml";//sin derechos
//    	 String lomVacio="../catalogacion/core/src/test-resources/pruebasDeMetadatos/metadatoCompletoVacio.xml";//Esquema vacio
//    	 String lomLote="../catalogacion/core/src/test-resources/pruebasDeMetadatos/metadatoLote1.xml";
    	 
//    	 File lomFileCompleto=new File(lomCompleto);
    	 File lomFile1 = new File(lom1);
//    	 File lomFile2=new File(lom2);
//    	 File lomFile3=new File(lom3);
//    	 File lomFile4=new File(lom4);
//    	 File lomFile5=new File(lom5);
//    	 File lomFile6=new File(lom6);
//    	 File lomFileCompletoVacio=new File(lomVacio);
//    	 File lomFileLote=new File(lomLote);
    	 
    	 String usuario="admin";
    	 
//    	 es.pode.parseadorXML.castor.Lom lomObjCompleto = this.getLomesDao().parsearLom(lomFileCompleto);
    	 es.pode.parseadorXML.castor.Lom lomObj1 = this.getLomesDao().parsearLom(lomFile1);
//    	 es.pode.parseadorXML.castor.Lom lomObj2 = this.getLomesDao().parsearLom(lomFile2);
//    	 es.pode.parseadorXML.castor.Lom lomObj3 = this.getLomesDao().parsearLom(lomFile3);
//    	 es.pode.parseadorXML.castor.Lom lomObj4= this.getLomesDao().parsearLom(lomFile4);
//    	 es.pode.parseadorXML.castor.Lom lomObj5= this.getLomesDao().parsearLom(lomFile5);
//    	 es.pode.parseadorXML.castor.Lom lomObj6= this.getLomesDao().parsearLom(lomFile6);
//    	 es.pode.parseadorXML.castor.Lom lomObjCompletoVacio=this.getLomesDao().parsearLom(lomFileCompletoVacio);
//    	 es.pode.parseadorXML.castor.Lom lomObjLote = this.getLomesDao().parsearLom(lomFileLote);
    	 
//    	 byte[] bytesCompleto = serializar(lomObjCompleto);
    	 byte[] bytes1 = serializar(lomObj1);
//    	 byte[] bytes2 = serializar(lomObj2);
//    	 byte[] bytes3 = serializar(lomObj3);
//    	 byte[] bytes4 = serializar(lomObj4);
//    	 byte[] bytes5 = serializar(lomObj5);
//    	 byte[] bytes6 = serializar(lomObj6);
//    	 byte[] bytesCompletoVacio = serializar(lomObjCompletoVacio);
//    	 byte[] bytesLote = serializar(lomObjLote);
    	 
    	 
//  		 ByteArrayDataSource badsCompleto = new ByteArrayDataSource(bytesCompleto,"application/x-java-serialized-object");
  		 ByteArrayDataSource bads1 = new ByteArrayDataSource(bytes1,"application/x-java-serialized-object");
//  		 ByteArrayDataSource bads2 = new ByteArrayDataSource(bytes2,"application/x-java-serialized-object");
//  		 ByteArrayDataSource bads3 = new ByteArrayDataSource(bytes3,"application/x-java-serialized-object");
//  		 ByteArrayDataSource bads4 = new ByteArrayDataSource(bytes4,"application/x-java-serialized-object");
//  		 ByteArrayDataSource bads5 = new ByteArrayDataSource(bytes5,"application/x-java-serialized-object");
//  		 ByteArrayDataSource bads6 = new ByteArrayDataSource(bytes6,"application/x-java-serialized-object");
//  		 ByteArrayDataSource badsCompletoVacio = new ByteArrayDataSource(bytesCompletoVacio,"application/x-java-serialized-object");
//  		 ByteArrayDataSource badsLote = new ByteArrayDataSource(bytesLote,"application/x-java-serialized-object");
    	 
//	  	 DataHandler lomHandlerCompleto=new DataHandler(badsCompleto);
	   	 DataHandler lomHandler1=new DataHandler(bads1);
//	   	 DataHandler lomHandler2=new DataHandler(bads2);
//	  	 DataHandler lomHandler3=new DataHandler(bads3);
//	  	 DataHandler lomHandler4=new DataHandler(bads4);
//	  	 DataHandler lomHandler5=new DataHandler(bads5);
//	  	 DataHandler lomHandler6=new DataHandler(bads6);
//	  	 DataHandler lomHandlerCompletoVacio=new DataHandler(badsCompletoVacio);
//	  	 DataHandler lomHandlerLote=new DataHandler(badsLote);
    	 
    	
//    	 String localPruebaCompleto=cargarObjLom.cargarObjLom(identificadorCompleto,usuario, lomHandlerCompleto);
    	 String localPrueba1=cargarObjLom.cargarObjLom(identificador1,usuario, lomHandler1);
//    	 String localPrueba2=cargarObjLom.cargarObjLom(identificador2,usuario, lomHandler2);
//    	 String localPrueba3=cargarObjLom.cargarObjLom(identificador3,usuario, lomHandler3);
//    	 String localPrueba4=cargarObjLom.cargarObjLom(identificador4, usuario, lomHandler4);
//    	 String localPrueba5=cargarObjLom.cargarObjLom(identificador5, usuario, lomHandler5);
//    	 String localPrueba6=cargarObjLom.cargarObjLom(identificador6, usuario, lomHandler6);
//    	 String localPruebaCompletoVacio=cargarObjLom.cargarObjLom(identificadorVacio, usuario, lomHandlerCompletoVacio);
//    	 String localPruebaLote=cargarObjLom.cargarObjLom(identificadorLote,usuario, lomHandlerLote);
    	 
//    	 assertNotNull(entrega.cargarObjManifest(usuario, this.serializeManifest(manifest)));
//    	 assertNotNull(localPruebaCompleto);
    	 assertNotNull(localPrueba1);
//    	 assertNotNull(localPrueba2);
//    	 assertNotNull(localPrueba3);
//    	 assertNotNull(localPrueba4);
//    	 assertNotNull(localPrueba5);
//    	 assertNotNull(localPrueba6);
//    	 assertNotNull(localPruebaCompletoVacio);
//    	 assertNotNull(localPruebaLote);

    	 
    }
     
    
    /**
     *   TEST obtenerLomBasico
     *   TODO: Implementar el test para el metodo obtenerLomBasico del servicio SrvCatalogacionBasicaService.
     */
     public void testobtenerLomBasico() {
    	 
    	 String idioma1="en"; 
    	 String idioma2="en";
    	 String usuario1="admin";
    	 String identificador1="idLOM1";
//    	 String identificador2="idLOM2";
//    	 String identificador="idLOM";
//    	 String identificador4="idLOM5";
//    	 String identificadorLote="idLOMLote";
    	 
    	 List titulo=new ArrayList();
    	 List idioma=new ArrayList();
    	 List desc=new ArrayList();
    	 List tipo=new ArrayList();
    	 List contexto=new ArrayList();
    	 List edad=new ArrayList();
    	 List idiomaDest=new ArrayList();
    	 List proceso=new ArrayList();
    	 List idArbol=new ArrayList();
    	 List taxonesId=new ArrayList();
    	 List taxonesId2=new ArrayList();
    	 List taxonesNom=new ArrayList();
    	 List taxonesNom2=new ArrayList();
    	 
    	 titulo.add("Acoplamiento a media madera");
    	 titulo.add("Título del objeto digital");
    	 titulo.add("Acoplamiento a media madera");
    	 titulo.add("Historia de la Publicidad");
    	 
    	 idioma.add("es");
    	 idioma.add("eu");
    	 idioma.add("es");
    	 idioma.add("es");
    	 
    	 desc.add("Representación del acoplamiento horizontal de dos piezas a media madera");
    	 desc.add("Unidad didáctica introductoria a la Ética en la que se tratan los conceptos básicos de esta disciplina, especialmente su especificidad humana y su fundamento antropológico");
    	 desc.add("Representación del acoplamiento horizontal de dos piezas a media madera");
    	 desc.add("Desarrollo, en formato texto, de la historia de la publicidad, sus principales hitos y su transformación, desde sus precedentes hasta nuestros días.");
    	 
    	 tipo.add("animation");
    	 tipo.add("animation");
    	 tipo.add("narrative text");
    	 tipo.add("hypertext");
    	 
    	 contexto.add("classroom");
    	 contexto.add("classroom");
    	 contexto.add("classroom");
    	 contexto.add("mixed");
    	 
    	 edad.add("Edad mínima 16 anos");
    	 edad.add("Edad mínima 16 anos");
    	 edad.add("Edad mínima:14 años, Edad máxima: 18 años, Descripción: Se trata de una secuencia didáctica de introducción a conceptos abstractos como la ética");
    	 edad.add("Para alumnos entre 12-16 años");
    	 
    	 idiomaDest.add("es");
    	 idiomaDest.add("es");
    	 idiomaDest.add("es");
    	 idiomaDest.add("es");
    	 
    	 proceso.add("understand");
    	 proceso.add("understand");
    	 proceso.add("analyse"); 
    	 proceso.add("analyse");
    	 
    	 idArbol.add(new Integer(0));
    	 Integer borrar=(Integer)idArbol.get(0);
    	 idArbol.add(new Integer(0));
    	 Integer borrar1=(Integer)idArbol.get(1);
    	 idArbol.add(new Integer(1));
    	 Integer borrar2=(Integer)idArbol.get(2);
    	 idArbol.add(new Integer(3));
    	 Integer borrar3=(Integer)idArbol.get(3);
    	 
    	 taxonesId.add("1");
    	 taxonesId.add("1.2");
    	 taxonesId.add("1.2.2");
    	 taxonesId.add("1.2.2.1");
    	 
    	 taxonesId2.add("1");
    	 taxonesId2.add("1.2");
    	 taxonesId2.add("1.2.2");
    	 taxonesId2.add("1.2.2.1");
    	 taxonesId2.add("2");
    	 taxonesId2.add("2.1");
    	 taxonesId2.add("2.1.2");
    	 taxonesId2.add("2.1.2.4");
    	 taxonesId2.add("4");
    	 taxonesId2.add("4.1");
    	 taxonesId2.add("4.1.2");
    	 taxonesId2.add("4.1.2.4");
    	 
    	 
    	 taxonesNom.add("Educación Infantil");
    	 taxonesNom.add("Segundo Ciclo");
    	 taxonesNom.add("Conociendo a los demás");
    	 taxonesNom.add("Bloque 1: Medio físico: Elementos, relaciones y medida");
    	 
    	 taxonesNom2.add("Educación Juvenil");
    	 taxonesNom2.add("Segundo Ciclo");
    	 taxonesNom2.add("Conocimiento de la Sociedad");
    	 taxonesNom2.add("Bloque 1: Medio físico: Elementos, relaciones y medida");
    	 taxonesNom2.add("Educación Primaria");
    	 taxonesNom2.add("Primer Ciclo");
    	 taxonesNom2.add("Educación Artística");
    	 taxonesNom2.add("Bloque 4:Interpretación y creación musical");
    	 taxonesNom2.add("Educación Primaria2");
    	 taxonesNom2.add("Primer Ciclo");
    	 taxonesNom2.add("Educación Artística");
    	 taxonesNom2.add("Bloque 4:Interpretación y creación musical");
    	 
    	 SrvCatalogacionBasicaService catalogacionBasica=this.servicio;
    	 try{
    		 LomBasicoVO lomBasico1 = catalogacionBasica.obtenerLomBasico(identificador1,usuario1, idioma1);
//    		 LomBasicoVO lomBasico2 = catalogacionBasica.obtenerLomBasico(identificador2,usuario1, idioma2);
//    		 LomBasicoVO lomBasicoCompleto= catalogacionBasica.obtenerLomBasico(identificador, usuario1, idioma1);
//    		 LomBasicoVO lomBasico4=catalogacionBasica.obtenerLomBasico(identificador4,usuario1,idioma2);
//    		 LomBasicoVO lomBasicoLote = catalogacionBasica.obtenerLomBasico(identificadorLote,usuario1, idioma1);
    		 
    		 assertNotNull(lomBasico1);
//    		 assertNotNull(lomBasico2);
//    		 assertNotNull(lomBasicoCompleto);
//    		 assertNotNull(lomBasico4);
//    		 assertNotNull(lomBasicoLote);
    		 
    		 assertEquals(titulo.get(0), lomBasico1.getGeneral().getTitulo().trim()); 
//    		 assertEquals(titulo.get(1), lomBasicoCompleto.getGeneral().getTitulo().trim());
//    		 assertEquals(titulo.get(2),lomBasico4.getGeneral().getTitulo().trim());
//    		 assertEquals(titulo.get(3), lomBasicoLote.getGeneral().getTitulo().trim());

    		 assertEquals(idioma.get(0), lomBasico1.getGeneral().getIdioma().trim());
//    		 assertEquals(idioma.get(1), lomBasicoCompleto.getGeneral().getIdioma().trim());
//    		 assertEquals(idioma.get(2), lomBasico4.getGeneral().getIdioma().trim());
//    		 assertEquals(idioma.get(3), lomBasicoLote.getGeneral().getIdioma().trim());
    		 
    		 assertEquals(desc.get(0),lomBasico1.getGeneral().getDesc().trim());
//    		 assertEquals(desc.get(1), lomBasicoCompleto.getGeneral().getDesc().trim());
//    		 assertEquals(desc.get(2), lomBasico4.getGeneral().getDesc().trim());
//    		 assertEquals(desc.get(3),lomBasicoLote.getGeneral().getDesc().trim());
    		 
    		 assertEquals(tipo.get(0),lomBasico1.getEducational().getTipo().trim());
    		 assertEquals(contexto.get(0),lomBasico1.getEducational().getContexto().trim());
    		 assertEquals(edad.get(0),lomBasico1.getEducational().getEdad().trim());
    		 assertEquals(idiomaDest.get(0),lomBasico1.getEducational().getIdiomaDest().trim());
    		 assertEquals(proceso.get(0),lomBasico1.getEducational().getProcesoCog().trim());
    		 
//    		 assertEquals(tipo.get(1),lomBasico2.getEducational().getTipo().trim());
//    		 assertEquals(contexto.get(1),lomBasico2.getEducational().getContexto().trim());
//    		 assertEquals(edad.get(1),lomBasico2.getEducational().getEdad().trim());
//    		 assertEquals(idiomaDest.get(1),lomBasico2.getEducational().getIdiomaDest().trim());
//    		 assertEquals(proceso.get(1),lomBasico2.getEducational().getProcesoCog().trim());
//    		 
//    		 assertEquals(tipo.get(2),lomBasicoCompleto.getEducational().getTipo().trim());
//    		 assertEquals(contexto.get(2), lomBasicoCompleto.getEducational().getContexto().trim());
//    		 assertEquals(edad.get(2), lomBasicoCompleto.getEducational().getEdad().trim());
//    		 assertEquals(idiomaDest.get(2),lomBasicoCompleto.getEducational().getIdiomaDest().trim());
//    		 assertEquals(proceso.get(2),lomBasicoCompleto.getEducational().getProcesoCog().trim());
//    		 
//    		 assertEquals(tipo.get(3),lomBasicoLote.getEducational().getTipo().trim());
//    		 assertEquals(contexto.get(3),lomBasicoLote.getEducational().getContexto().trim());
//    		 assertEquals(edad.get(3),lomBasicoLote.getEducational().getEdad().trim());
//    		 assertEquals(idiomaDest.get(3),lomBasicoLote.getEducational().getIdiomaDest().trim());
//    		 assertEquals(proceso.get(3),lomBasicoLote.getEducational().getProcesoCog().trim());
//    		 
//    		 assertEquals(borrar.intValue(),lomBasico2.getClassification().getArbolesCurriculares()[0].getIdArbol());
//    		 assertEquals(borrar1.intValue(),lomBasico4.getClassification().getArbolesCurriculares()[0].getIdArbol());
//    		 assertEquals(borrar2.intValue(),lomBasico4.getClassification().getArbolesCurriculares()[1].getIdArbol());
//    		 assertEquals(borrar3.intValue(),lomBasico4.getClassification().getArbolesCurriculares()[2].getIdArbol());
//    		 
//    		 assertEquals(taxonesId.get(3),lomBasico2.getClassification().getArbolesCurriculares()[0].getTaxones()[0].getId());
//    		 assertEquals(taxonesId.get(2),lomBasico2.getClassification().getArbolesCurriculares()[0].getTaxones()[1].getId());
//    		 assertEquals(taxonesId.get(1),lomBasico2.getClassification().getArbolesCurriculares()[0].getTaxones()[2].getId());
//    		 assertEquals(taxonesId.get(0),lomBasico2.getClassification().getArbolesCurriculares()[0].getTaxones()[3].getId());
//    		 
//    		 assertEquals(taxonesId2.get(3),lomBasico4.getClassification().getArbolesCurriculares()[0].getTaxones()[0].getId());
//    		 assertEquals(taxonesId2.get(2),lomBasico4.getClassification().getArbolesCurriculares()[0].getTaxones()[1].getId());
//    		 assertEquals(taxonesId2.get(1),lomBasico4.getClassification().getArbolesCurriculares()[0].getTaxones()[2].getId());
//    		 assertEquals(taxonesId2.get(0),lomBasico4.getClassification().getArbolesCurriculares()[0].getTaxones()[3].getId());
//    		 assertEquals(taxonesId2.get(7),lomBasico4.getClassification().getArbolesCurriculares()[1].getTaxones()[0].getId());
//    		 assertEquals(taxonesId2.get(6),lomBasico4.getClassification().getArbolesCurriculares()[1].getTaxones()[1].getId());
//    		 assertEquals(taxonesId2.get(5),lomBasico4.getClassification().getArbolesCurriculares()[1].getTaxones()[2].getId());
//    		 assertEquals(taxonesId2.get(4),lomBasico4.getClassification().getArbolesCurriculares()[1].getTaxones()[3].getId());
//    		 assertEquals(taxonesId2.get(11),lomBasico4.getClassification().getArbolesCurriculares()[2].getTaxones()[0].getId());
//    		 assertEquals(taxonesId2.get(10),lomBasico4.getClassification().getArbolesCurriculares()[2].getTaxones()[1].getId());
//    		 assertEquals(taxonesId2.get(9),lomBasico4.getClassification().getArbolesCurriculares()[2].getTaxones()[2].getId());
//    		 assertEquals(taxonesId2.get(8),lomBasico4.getClassification().getArbolesCurriculares()[2].getTaxones()[3].getId());
//    		 
//    		 assertEquals(taxonesNom.get(3),lomBasico2.getClassification().getArbolesCurriculares()[0].getTaxones()[0].getValorTax());
//    		 assertEquals(taxonesNom.get(2),lomBasico2.getClassification().getArbolesCurriculares()[0].getTaxones()[1].getValorTax());
//    		 assertEquals(taxonesNom.get(1),lomBasico2.getClassification().getArbolesCurriculares()[0].getTaxones()[2].getValorTax());
//    		 assertEquals(taxonesNom.get(0),lomBasico2.getClassification().getArbolesCurriculares()[0].getTaxones()[3].getValorTax());
//    		 
//    		 assertEquals(taxonesNom2.get(3),lomBasico4.getClassification().getArbolesCurriculares()[0].getTaxones()[0].getValorTax());
//    		 assertEquals(taxonesNom2.get(2),lomBasico4.getClassification().getArbolesCurriculares()[0].getTaxones()[1].getValorTax());
//    		 assertEquals(taxonesNom2.get(1),lomBasico4.getClassification().getArbolesCurriculares()[0].getTaxones()[2].getValorTax());
//    		 assertEquals(taxonesNom2.get(0),lomBasico4.getClassification().getArbolesCurriculares()[0].getTaxones()[3].getValorTax());
//    		 assertEquals(taxonesNom2.get(7),lomBasico4.getClassification().getArbolesCurriculares()[1].getTaxones()[0].getValorTax());
//    		 assertEquals(taxonesNom2.get(6),lomBasico4.getClassification().getArbolesCurriculares()[1].getTaxones()[1].getValorTax());
//    		 assertEquals(taxonesNom2.get(5),lomBasico4.getClassification().getArbolesCurriculares()[1].getTaxones()[2].getValorTax());
//    		 assertEquals(taxonesNom2.get(4),lomBasico4.getClassification().getArbolesCurriculares()[1].getTaxones()[3].getValorTax());
//    		 assertEquals(taxonesNom2.get(11),lomBasico4.getClassification().getArbolesCurriculares()[2].getTaxones()[0].getValorTax());
//    		 assertEquals(taxonesNom2.get(10),lomBasico4.getClassification().getArbolesCurriculares()[2].getTaxones()[1].getValorTax());
//    		 assertEquals(taxonesNom2.get(9),lomBasico4.getClassification().getArbolesCurriculares()[2].getTaxones()[2].getValorTax());
//    		 assertEquals(taxonesNom2.get(8),lomBasico4.getClassification().getArbolesCurriculares()[2].getTaxones()[3].getValorTax());
    		 
    		 assertTrue(true);
    		 
    	 }catch(Exception e){
    		 assertTrue(false);
    		 logger.error(e);
    	 }
    }
     

    /**
     *   TEST generarMetadatos
     *   TODO: Implementar el test para el metodo generarMetadatos del servicio SrvCatalogacionBasicaService.
     */
//     public void testgenerarMetadatos() {
//
//    	 LomBasicoVO lomBasico=new LomBasicoVO(); 
//    	 
//    	 String identificadorCompleto="idLOM";
//    	 
//    	 String usuario="admin";
//    	 String idioma="es";
//    	 GeneralVO general=new GeneralVO();
//    	 general.setIdioma("ga"); 
//    	 general.setDesc("18 de mayo del 2007");
//    	 general.setTitulo("El teorema de la probabilidad total");
//    	 lomBasico.setGeneral(general);
//    	 EducationalVO educational=new EducationalVO();
//    	 educational.setContexto("family");
//    	 educational.setEdad("De 5 a 6 añitos");
//    	 educational.setIdiomaDest("ca");
//    	 educational.setProcesoCog("analyse");
//    	 educational.setTipo("office service");
//    	 lomBasico.setEducational(educational);
//    	 
//		 ClassificationVO clasificacion=new ClassificationVO();
//		 ArbolCurricularVO arbol=new ArbolCurricularVO();
//		 ArrayList arboles=new ArrayList();
//		 CBTaxonVO taxon1=new CBTaxonVO();
//		 CBTaxonVO taxon2=new CBTaxonVO();
//		 CBTaxonVO taxon3=new CBTaxonVO();
//		 CBTaxonVO taxon4=new CBTaxonVO();
//
//		 ArrayList list=new ArrayList();
//
//		 int numero=4;
//		 CBTaxonVO[] taxonList=null;
//		 taxon4.setId("3.2.4.2");
//		 taxon3.setId("3.2.4");
//		 taxon2.setId("3.2");
//		 taxon1.setId("3");
//		 taxon4.setValorTax("Plantanos");
//		 taxon3.setValorTax("Manazanas");
//		 taxon2.setValorTax("Melones");
//		 taxon1.setValorTax("Peras");
//		 list.add(taxon1);
//		 list.add(taxon2);
//		 list.add(taxon3);
//		 list.add(taxon4);
//		 taxonList=(CBTaxonVO[])list.toArray(new CBTaxonVO[list.size()]);
//		 arbol.setIdArbol(numero);
//		 arbol.setTaxones(taxonList);
//		 arboles.add(arbol);
//		   
//		 ArbolCurricularVO arbol2=new ArbolCurricularVO();
//		 CBTaxonVO taxon12=new CBTaxonVO();
//		 CBTaxonVO taxon22=new CBTaxonVO();
//		 CBTaxonVO taxon32=new CBTaxonVO();
//		 CBTaxonVO taxon42=new CBTaxonVO();
//		   
//		 ArrayList list2=new ArrayList();
//
//		 int numero2=5;
//		 CBTaxonVO[] taxonList2=null;
//		 taxon42.setId("5.6.7.8");
//		 taxon32.setId("5.6.7");
//		 taxon22.setId("5.6");
//		 taxon12.setId("5");
//		 taxon42.setValorTax("Carlos");
//		 taxon32.setValorTax("Ana");
//		 taxon22.setValorTax("Nora");
//		 taxon12.setValorTax("Larraitz");
//		 list2.add(taxon12);
//		 list2.add(taxon22);
//		 list2.add(taxon32);
//		 list2.add(taxon42);
//		 taxonList2=(CBTaxonVO[])list2.toArray(new CBTaxonVO[list2.size()]);
//		 arbol2.setIdArbol(numero2);
//		 arbol2.setTaxones(taxonList2);
//		 arboles.add(arbol2);
//		   
//		 clasificacion.setArbolesCurriculares(new ArbolCurricularVO[arboles.size()]);
//		   
//		 clasificacion.setArbolesCurriculares((ArbolCurricularVO[])arboles.toArray(new ArbolCurricularVO[arboles.size()]));
//		 lomBasico.setClassification(clasificacion);
//    	 
//    	 SrvCatalogacionBasicaService catalogacion=this.servicio;
//    	
//    	 
//    	 
//    	 try{
//	    	 catalogacion.generarMetadatos(identificadorCompleto,usuario, lomBasico,idioma);
//	    	 assertTrue(true);
//	    	 
//    	 }catch(Exception e){
//    		 assertTrue(false);
//    	 }
//	
//    }
     
     public void testgenerarMetadatos1() {

    	 LomBasicoVO lomBasico=new LomBasicoVO(); 
    	 
    	 	
    	 String identificador1="idLOM1";
    	 String idioma="es";
    	 String usuario="admin";
    	 GeneralVO general=new GeneralVO();
    	 general.setIdioma("ga"); 
    	 general.setDesc("18 de mayo del 2007");
    	 general.setTitulo("El teorema de la probabilidad total");
    	 lomBasico.setGeneral(general);
    	 EducationalVO educational=new EducationalVO();
    	 educational.setContexto("family");
    	 educational.setEdad("De 5 a 6 añitos");
    	 educational.setIdiomaDest("ca");
    	 educational.setProcesoCog("analyse");
    	 educational.setTipo("office service");
    	 lomBasico.setEducational(educational);
    	 
		 ClassificationVO clasificacion=new ClassificationVO();
		 ArbolCurricularVO arbol=new ArbolCurricularVO();
		 ArrayList arboles=new ArrayList();
		 CBTaxonVO taxon1=new CBTaxonVO();
		 CBTaxonVO taxon2=new CBTaxonVO();
		 CBTaxonVO taxon3=new CBTaxonVO();
		 CBTaxonVO taxon4=new CBTaxonVO();

		 ArrayList list=new ArrayList();

		 String numero="0";
		 CBTaxonVO[] taxonList=null;
		 taxon4.setId("3.2.4.2");
		 taxon3.setId("3.2.4");
		 taxon2.setId("3.2");
		 taxon1.setId("3");
		 taxon4.setValorTax("Platanos");
		 taxon3.setValorTax("Manazanas");
		 taxon2.setValorTax("Melones");
		 taxon1.setValorTax("Peras");
		 list.add(taxon1);
		 list.add(taxon2);
		 list.add(taxon3);
		 list.add(taxon4);
		 taxonList=(CBTaxonVO[])list.toArray(new CBTaxonVO[list.size()]);
		 arbol.setIdArbol(numero);
		 arbol.setTaxones(taxonList);
		 arboles.add(arbol);
		   
		 ArbolCurricularVO arbol2=new ArbolCurricularVO();
		 CBTaxonVO taxon12=new CBTaxonVO();
		 CBTaxonVO taxon22=new CBTaxonVO();
		 CBTaxonVO taxon32=new CBTaxonVO();
		 CBTaxonVO taxon42=new CBTaxonVO();
		   
		 ArrayList list2=new ArrayList();

		 String numero2="1";
		 CBTaxonVO[] taxonList2=null;
		 taxon42.setId("5.6.7.8");
		 taxon32.setId("5.6.7");
		 taxon22.setId("5.6");
		 taxon12.setId("5");
		 taxon42.setValorTax("Carlos");
		 taxon32.setValorTax("Ana");
		 taxon22.setValorTax("Nora");
		 taxon12.setValorTax("Larraitz");
		 list2.add(taxon12);
		 list2.add(taxon22);
		 list2.add(taxon32);
		 list2.add(taxon42);
		 taxonList2=(CBTaxonVO[])list2.toArray(new CBTaxonVO[list2.size()]);
		 arbol2.setIdArbol(numero2);
		 arbol2.setTaxones(taxonList2);
		 arboles.add(arbol2);
		   
		 clasificacion.setArbolesCurriculares(new ArbolCurricularVO[arboles.size()]);
		   
		 clasificacion.setArbolesCurriculares((ArbolCurricularVO[])arboles.toArray(new ArbolCurricularVO[arboles.size()]));
		 lomBasico.setClassification(clasificacion);
    	 	
    	 SrvCatalogacionBasicaService catalogacion1=this.servicio;

    	 try{
		    	 
	    	 catalogacion1.generarMetadatos(identificador1,usuario, lomBasico,idioma);
	    	 assertTrue(true);
	    	 
    	 }catch(Exception e){
    		 assertTrue(false);
    	 }
	
    }
 
//     public void testgenerarMetadatos2() {
//
//		 LomBasicoVO lomBasico=new LomBasicoVO(); 
//		 
//		  
//		 String identificador2="idLOM2";
//		 String idioma="es"; 
//		 String usuario="admin";
//		 GeneralVO general=new GeneralVO();
//		 general.setIdioma("ga"); 
//		 general.setDesc("18 de mayo del 2007");
//		 general.setTitulo("El teorema de la probabilidad total");
//		 lomBasico.setGeneral(general);
//		 EducationalVO educational=new EducationalVO();
//		 educational.setContexto("family");
//		 educational.setEdad("De 5 a 6 añitos");
//		 educational.setIdiomaDest("ca");
//		 educational.setProcesoCog("analyse");
//		 educational.setTipo("office service");
//		 lomBasico.setEducational(educational);
//		 
//		 ClassificationVO clasificacion=new ClassificationVO();
//		 ArbolCurricularVO arbol=new ArbolCurricularVO();
//		 ArrayList arboles=new ArrayList();
//		 CBTaxonVO taxon1=new CBTaxonVO();
//		 CBTaxonVO taxon2=new CBTaxonVO();
//		 CBTaxonVO taxon3=new CBTaxonVO();
//		 CBTaxonVO taxon4=new CBTaxonVO();
//	
//		 ArrayList list=new ArrayList();
//	
//		 int numero=4;
//		 CBTaxonVO[] taxonList=null;
//		 taxon4.setId("3.2.4.2");
//		 taxon3.setId("3.2.4");
//		 taxon2.setId("3.2");
//		 taxon1.setId("3");
//		 taxon4.setValorTax("Plantanos");
//		 taxon3.setValorTax("Manazanas");
//		 taxon2.setValorTax("Melones");
//		 taxon1.setValorTax("Peras");
//		 list.add(taxon1);
//		 list.add(taxon2);
//		 list.add(taxon3);
//		 list.add(taxon4);
//		 taxonList=(CBTaxonVO[])list.toArray(new CBTaxonVO[list.size()]);
//		 arbol.setIdArbol(numero);
//		 arbol.setTaxones(taxonList);
//		 arboles.add(arbol);
//		   
//		 ArbolCurricularVO arbol2=new ArbolCurricularVO();
//		 CBTaxonVO taxon12=new CBTaxonVO();
//		 CBTaxonVO taxon22=new CBTaxonVO();
//		 CBTaxonVO taxon32=new CBTaxonVO();
//		 CBTaxonVO taxon42=new CBTaxonVO();
//		   
//		 ArrayList list2=new ArrayList();
//	
//		 int numero2=5;
//		 CBTaxonVO[] taxonList2=null;
//		 taxon42.setId("5.6.7.8");
//		 taxon32.setId("5.6.7");
//		 taxon22.setId("5.6");
//		 taxon12.setId("5");
//		 taxon42.setValorTax("Carlos");
//		 taxon32.setValorTax("Ana");
//		 taxon22.setValorTax("Nora");
//		 taxon12.setValorTax("Larraitz");
//		 list2.add(taxon12);
//		 list2.add(taxon22);
//		 list2.add(taxon32);
//		 list2.add(taxon42);
//		 taxonList2=(CBTaxonVO[])list2.toArray(new CBTaxonVO[list2.size()]);
//		 arbol2.setIdArbol(numero2);
//		 arbol2.setTaxones(taxonList2);
//		 arboles.add(arbol2);
//		   
//		 clasificacion.setArbolesCurriculares(new ArbolCurricularVO[arboles.size()]);
//		   
//		 clasificacion.setArbolesCurriculares((ArbolCurricularVO[])arboles.toArray(new ArbolCurricularVO[arboles.size()]));
//		 lomBasico.setClassification(clasificacion);
//		 
//		  
//		 SrvCatalogacionBasicaService catalogacion2=this.servicio;
//
//		 try{
//	    	 
//	    	 catalogacion2.generarMetadatos(identificador2,usuario, lomBasico,idioma);
//	    	 assertTrue(true);
//	    	 
//		 }catch(Exception e){
//			 assertTrue(false);
//		 }
//	
//}
// 
// 
//	 public void testgenerarMetadatos3() {
//	
//		 LomBasicoVO lomBasico=new LomBasicoVO(); 
//		 		  
//		 String identificador3="idLOM3";
//		 String idioma="es"; 
//		 String usuario="admin";
//		 GeneralVO general=new GeneralVO();
//		 general.setIdioma("ga"); 
//		 general.setDesc("18 de mayo del 2007");
//		 general.setTitulo("El teorema de la probabilidad total");
//		 lomBasico.setGeneral(general);
//		 EducationalVO educational=new EducationalVO();
//		 educational.setContexto("family");
//		 educational.setEdad("De 5 a 6 añitos");
//		 educational.setIdiomaDest("ca");
//		 educational.setProcesoCog("analyse");
//		 educational.setTipo("office service");
//		 lomBasico.setEducational(educational);
//		 
//		 ClassificationVO clasificacion=new ClassificationVO();
//		 ArbolCurricularVO arbol=new ArbolCurricularVO();
//		 ArrayList arboles=new ArrayList();
//		 CBTaxonVO taxon1=new CBTaxonVO();
//		 CBTaxonVO taxon2=new CBTaxonVO();
//		 CBTaxonVO taxon3=new CBTaxonVO();
//		 CBTaxonVO taxon4=new CBTaxonVO();
//	
//		 ArrayList list=new ArrayList();
//	
//		 int numero=4;
//		 CBTaxonVO[] taxonList=null;
//		 taxon4.setId("3.2.4.2");
//		 taxon3.setId("3.2.4");
//		 taxon2.setId("3.2");
//		 taxon1.setId("3");
//		 taxon4.setValorTax("Plantanos");
//		 taxon3.setValorTax("Manazanas");
//		 taxon2.setValorTax("Melones");
//		 taxon1.setValorTax("Peras");
//		 list.add(taxon1);
//		 list.add(taxon2);
//		 list.add(taxon3);
//		 list.add(taxon4);
//		 taxonList=(CBTaxonVO[])list.toArray(new CBTaxonVO[list.size()]);
//		 arbol.setIdArbol(numero);
//		 arbol.setTaxones(taxonList);
//		 arboles.add(arbol);
//		   
//		 ArbolCurricularVO arbol2=new ArbolCurricularVO();
//		 CBTaxonVO taxon12=new CBTaxonVO();
//		 CBTaxonVO taxon22=new CBTaxonVO();
//		 CBTaxonVO taxon32=new CBTaxonVO();
//		 CBTaxonVO taxon42=new CBTaxonVO();
//		   
//		 ArrayList list2=new ArrayList();
//	
//		 int numero2=5;
//		 CBTaxonVO[] taxonList2=null;
//		 taxon42.setId("5.6.7.8");
//		 taxon32.setId("5.6.7");
//		 taxon22.setId("5.6");
//		 taxon12.setId("5");
//		 taxon42.setValorTax("Carlos");
//		 taxon32.setValorTax("Ana");
//		 taxon22.setValorTax("Nora");
//		 taxon12.setValorTax("Larraitz");
//		 list2.add(taxon12);
//		 list2.add(taxon22);
//		 list2.add(taxon32);
//		 list2.add(taxon42);
//		 taxonList2=(CBTaxonVO[])list2.toArray(new CBTaxonVO[list2.size()]);
//		 arbol2.setIdArbol(numero2);
//		 arbol2.setTaxones(taxonList2);
//		 arboles.add(arbol2);
//		   
//		 clasificacion.setArbolesCurriculares(new ArbolCurricularVO[arboles.size()]);
//		   
//		 clasificacion.setArbolesCurriculares((ArbolCurricularVO[])arboles.toArray(new ArbolCurricularVO[arboles.size()]));
//		 lomBasico.setClassification(clasificacion);
//		 
//		  
//		 SrvCatalogacionBasicaService catalogacion3=this.servicio;
//		  
//		 
//		 
//		 try{
//	    	 
//	    	 catalogacion3.generarMetadatos(identificador3,usuario, lomBasico,idioma); 
//	    	 assertTrue(true);
//	    	 
//		 }catch(Exception e){
//			 assertTrue(false);
//		 }
//	
//	}
// 
//	 public void testgenerarMetadatos4() {
//	
//		 LomBasicoVO lomBasico=new LomBasicoVO(); 
//		 	  
//		 String identificador4="idLOM4";
//		 String idioma="es"; 
//		 String usuario="admin";
//		 GeneralVO general=new GeneralVO();
//		 general.setIdioma("ga"); 
//		 general.setDesc("18 de mayo del 2007");
//		 general.setTitulo("El teorema de la probabilidad total");
//		 lomBasico.setGeneral(general);
//		 EducationalVO educational=new EducationalVO();
//		 educational.setContexto("family");
//		 educational.setEdad("De 5 a 6 añitos");
//		 educational.setIdiomaDest("ca");
//		 educational.setProcesoCog("analyse");
//		 educational.setTipo("office service");
//		 lomBasico.setEducational(educational);
//		 
//		 ClassificationVO clasificacion=new ClassificationVO();
//		 ArbolCurricularVO arbol=new ArbolCurricularVO();
//		 ArrayList arboles=new ArrayList();
//		 CBTaxonVO taxon1=new CBTaxonVO();
//		 CBTaxonVO taxon2=new CBTaxonVO();
//		 CBTaxonVO taxon3=new CBTaxonVO();
//		 CBTaxonVO taxon4=new CBTaxonVO();
//	
//		 ArrayList list=new ArrayList();
//	
//		 int numero=0;
//		 CBTaxonVO[] taxonList=null;
//		 taxon4.setId("3.2.4.2");
//		 taxon3.setId("3.2.4");
//		 taxon2.setId("3.2");
//		 taxon1.setId("3");
//		 taxon4.setValorTax("Plantanos");
//		 taxon3.setValorTax("Manazanas");
//		 taxon2.setValorTax("Melones");
//		 taxon1.setValorTax("Peras");
//		 list.add(taxon1);
//		 list.add(taxon2);
//		 list.add(taxon3);
//		 list.add(taxon4);
//		 taxonList=(CBTaxonVO[])list.toArray(new CBTaxonVO[list.size()]);
//		 arbol.setIdArbol(numero);
//		 arbol.setTaxones(taxonList);
//		 arboles.add(arbol);
//		   
//		 ArbolCurricularVO arbol2=new ArbolCurricularVO();
//		 CBTaxonVO taxon12=new CBTaxonVO();
//		 CBTaxonVO taxon22=new CBTaxonVO();
//		 CBTaxonVO taxon32=new CBTaxonVO();
//		 CBTaxonVO taxon42=new CBTaxonVO();
//		   
//		 ArrayList list2=new ArrayList();
//	
//		 int numero2=1;
//		 CBTaxonVO[] taxonList2=null;
//		 taxon42.setId("5.6.7.8");
//		 taxon32.setId("5.6.7");
//		 taxon22.setId("5.6");
//		 taxon12.setId("5");
//		 taxon42.setValorTax("Carlos");
//		 taxon32.setValorTax("Ana");
//		 taxon22.setValorTax("Nora");
//		 taxon12.setValorTax("Larraitz");
//		 list2.add(taxon12);
//		 list2.add(taxon22);
//		 list2.add(taxon32);
//		 list2.add(taxon42);
//		 taxonList2=(CBTaxonVO[])list2.toArray(new CBTaxonVO[list2.size()]);
//		 arbol2.setIdArbol(numero2);
//		 arbol2.setTaxones(taxonList2);
//		 arboles.add(arbol2);
//		   
//		 clasificacion.setArbolesCurriculares(new ArbolCurricularVO[arboles.size()]);
//		   
//		 clasificacion.setArbolesCurriculares((ArbolCurricularVO[])arboles.toArray(new ArbolCurricularVO[arboles.size()]));
//		 lomBasico.setClassification(clasificacion);
//		 		  
//		 SrvCatalogacionBasicaService catalogacion4=this.servicio;
//
//		 try{
//	    	  
//	    	 catalogacion4.generarMetadatos(identificador4,usuario, lomBasico,idioma);			 
//	    	 assertTrue(true);
//	    	 
//		 }catch(Exception e){
//			 assertTrue(false);
//		 }
//				
//	}
// 
//	 public void testgenerarMetadatos5() {
//	
//		 LomBasicoVO lomBasico=new LomBasicoVO(); 
//		 		  
//		 String identificador5="idLOM5";
//		 String idioma="es"; 
//		 String usuario="admin";
//		 GeneralVO general=new GeneralVO();
//		 general.setIdioma("ga"); 
//		 general.setDesc("18 de mayo del 2007");
//		 general.setTitulo("El teorema de la probabilidad total");
//		 lomBasico.setGeneral(general);
//		 EducationalVO educational=new EducationalVO();
//		 educational.setContexto("family");
//		 educational.setEdad("De 5 a 6 añitos");
//		 educational.setIdiomaDest("ca");
//		 educational.setProcesoCog("analyse");
//		 educational.setTipo("office service");
//		 lomBasico.setEducational(educational);
//		 
//		 ClassificationVO clasificacion=new ClassificationVO();
//		 ArbolCurricularVO arbol=new ArbolCurricularVO();
//		 ArrayList arboles=new ArrayList();
//		 CBTaxonVO taxon1=new CBTaxonVO();
//		 CBTaxonVO taxon2=new CBTaxonVO();
//		 CBTaxonVO taxon3=new CBTaxonVO();
//		 CBTaxonVO taxon4=new CBTaxonVO();
//	
//		 ArrayList list=new ArrayList();
//	
//		 int numero=4;
//		 CBTaxonVO[] taxonList=null;
//		 taxon4.setId("3.2.4.2");
//		 taxon3.setId("3.2.4");
//		 taxon2.setId("3.2");
//		 taxon1.setId("3");
//		 taxon4.setValorTax("Plantanos");
//		 taxon3.setValorTax("Manazanas");
//		 taxon2.setValorTax("Melones");
//		 taxon1.setValorTax("Peras");
//		 list.add(taxon1);
//		 list.add(taxon2);
//		 list.add(taxon3);
//		 list.add(taxon4);
//		 taxonList=(CBTaxonVO[])list.toArray(new CBTaxonVO[list.size()]);
//		 arbol.setIdArbol(numero);
//		 arbol.setTaxones(taxonList);
//		 arboles.add(arbol);
//		   
//		 ArbolCurricularVO arbol2=new ArbolCurricularVO();
//		 CBTaxonVO taxon12=new CBTaxonVO();
//		 CBTaxonVO taxon22=new CBTaxonVO();
//		 CBTaxonVO taxon32=new CBTaxonVO();
//		 CBTaxonVO taxon42=new CBTaxonVO();
//		   
//		 ArrayList list2=new ArrayList();
//	
//		 int numero2=5;
//		 CBTaxonVO[] taxonList2=null;
//		 taxon42.setId("5.6.7.8");
//		 taxon32.setId("5.6.7");
//		 taxon22.setId("5.6");
//		 taxon12.setId("5");
//		 taxon42.setValorTax("Carlos");
//		 taxon32.setValorTax("Ana");
//		 taxon22.setValorTax("Nora");
//		 taxon12.setValorTax("Larraitz");
//		 list2.add(taxon12);
//		 list2.add(taxon22);
//		 list2.add(taxon32);
//		 list2.add(taxon42);
//		 taxonList2=(CBTaxonVO[])list2.toArray(new CBTaxonVO[list2.size()]);
//		 arbol2.setIdArbol(numero2);
//		 arbol2.setTaxones(taxonList2);
//		 arboles.add(arbol2);
//		   
//		 clasificacion.setArbolesCurriculares(new ArbolCurricularVO[arboles.size()]);
//		   
//		 clasificacion.setArbolesCurriculares((ArbolCurricularVO[])arboles.toArray(new ArbolCurricularVO[arboles.size()]));
//		 lomBasico.setClassification(clasificacion);
//		 		 
//		 SrvCatalogacionBasicaService catalogacion5=this.servicio;
// 
//		 try{
//	    	 
//	    	 catalogacion5.generarMetadatos(identificador5,usuario, lomBasico, idioma);	    	 
//	    	 assertTrue(true);
//	    	 
//		 }catch(Exception e){
//			 assertTrue(false);
//		 }
//		
//	}
// 
//	 public void testgenerarMetadatos6() {
//	
//		 LomBasicoVO lomBasico=new LomBasicoVO(); 
//		 		 
//		 String identificador6="idLOM6";
//		 String idioma="es";
//		 String usuario="admin";
//		 GeneralVO general=new GeneralVO();
//		 general.setIdioma("ga"); 
//		 general.setDesc("18 de mayo del 2007");
//		 general.setTitulo("El teorema de la probabilidad total");
//		 lomBasico.setGeneral(general);
//		 EducationalVO educational=new EducationalVO();
//		 educational.setContexto("family");
//		 educational.setEdad("De 5 a 6 añitos");
//		 educational.setIdiomaDest("ca");
//		 educational.setProcesoCog("analyse");
//		 educational.setTipo("office service");
//		 lomBasico.setEducational(educational);
//		 
//		 ClassificationVO clasificacion=new ClassificationVO();
//		 ArbolCurricularVO arbol=new ArbolCurricularVO();
//		 ArrayList arboles=new ArrayList();
//		 CBTaxonVO taxon1=new CBTaxonVO();
//		 CBTaxonVO taxon2=new CBTaxonVO();
//		 CBTaxonVO taxon3=new CBTaxonVO();
//		 CBTaxonVO taxon4=new CBTaxonVO();
//	
//		 ArrayList list=new ArrayList();
//	
//		 int numero=4;
//		 CBTaxonVO[] taxonList=null;
//		 taxon4.setId("3.2.4.2");
//		 taxon3.setId("3.2.4");
//		 taxon2.setId("3.2");
//		 taxon1.setId("3");
//		 taxon4.setValorTax("Plantanos");
//		 taxon3.setValorTax("Manazanas");
//		 taxon2.setValorTax("Melones");
//		 taxon1.setValorTax("Peras");
//		 list.add(taxon1);
//		 list.add(taxon2);
//		 list.add(taxon3);
//		 list.add(taxon4);
//		 taxonList=(CBTaxonVO[])list.toArray(new CBTaxonVO[list.size()]);
//		 arbol.setIdArbol(numero);
//		 arbol.setTaxones(taxonList);
//		 arboles.add(arbol);
//		   
//		 ArbolCurricularVO arbol2=new ArbolCurricularVO();
//		 CBTaxonVO taxon12=new CBTaxonVO();
//		 CBTaxonVO taxon22=new CBTaxonVO();
//		 CBTaxonVO taxon32=new CBTaxonVO();
//		 CBTaxonVO taxon42=new CBTaxonVO();
//		   
//		 ArrayList list2=new ArrayList();
//	
//		 int numero2=5;
//		 CBTaxonVO[] taxonList2=null;
//		 taxon42.setId("5.6.7.8");
//		 taxon32.setId("5.6.7");
//		 taxon22.setId("5.6");
//		 taxon12.setId("5");
//		 taxon42.setValorTax("Carlos");
//		 taxon32.setValorTax("Ana");
//		 taxon22.setValorTax("Nora");
//		 taxon12.setValorTax("Larraitz");
//		 list2.add(taxon12);
//		 list2.add(taxon22);
//		 list2.add(taxon32);
//		 list2.add(taxon42);
//		 taxonList2=(CBTaxonVO[])list2.toArray(new CBTaxonVO[list2.size()]);
//		 arbol2.setIdArbol(numero2);
//		 arbol2.setTaxones(taxonList2);
//		 arboles.add(arbol2);
//		   
//		 clasificacion.setArbolesCurriculares(new ArbolCurricularVO[arboles.size()]);
//		   
//		 clasificacion.setArbolesCurriculares((ArbolCurricularVO[])arboles.toArray(new ArbolCurricularVO[arboles.size()]));
//		 lomBasico.setClassification(clasificacion);
//		 		 
//		 SrvCatalogacionBasicaService catalogacion6=this.servicio;
// 
//		 try{
//	    	 
//	    	 catalogacion6.generarMetadatos(identificador6,usuario, lomBasico,idioma);
//	    	 assertTrue(true);
//	    	 
//		 }catch(Exception e){
//			 assertTrue(false);
//		 }
//		
//		
//	}
// 
//	 public void testgenerarMetadatos7() {
//	
//		 LomBasicoVO lomBasico=new LomBasicoVO(); 
//		 		
//		 String identificadorVacio="idLOMVacio";
//		 String idioma="es";
//		 String usuario="admin";
//		 GeneralVO general=new GeneralVO();
//		 general.setIdioma("ga"); 
//		 general.setDesc("18 de mayo del 2007");
//		 general.setTitulo("El teorema de la probabilidad total");
//		 lomBasico.setGeneral(general);
//		 EducationalVO educational=new EducationalVO();
//		 educational.setContexto("family");
//		 educational.setEdad("De 5 a 6 añitos");
//		 educational.setIdiomaDest("ca");
//		 educational.setProcesoCog("analyse");
//		 educational.setTipo("office service");
//		 lomBasico.setEducational(educational);
//		 
//		 ClassificationVO clasificacion=new ClassificationVO();
//		 ArbolCurricularVO arbol=new ArbolCurricularVO();
//		 ArrayList arboles=new ArrayList();
//		 CBTaxonVO taxon1=new CBTaxonVO();
//		 CBTaxonVO taxon2=new CBTaxonVO();
//		 CBTaxonVO taxon3=new CBTaxonVO();
//		 CBTaxonVO taxon4=new CBTaxonVO();
//	
//		 ArrayList list=new ArrayList();
//	
//		 int numero=4;
//		 CBTaxonVO[] taxonList=null;
//		 taxon4.setId("3.2.4.2");
//		 taxon3.setId("3.2.4");
//		 taxon2.setId("3.2");
//		 taxon1.setId("3");
//		 taxon4.setValorTax("Plantanos");
//		 taxon3.setValorTax("Manazanas");
//		 taxon2.setValorTax("Melones");
//		 taxon1.setValorTax("Peras");
//		 list.add(taxon1);
//		 list.add(taxon2);
//		 list.add(taxon3);
//		 list.add(taxon4);
//		 taxonList=(CBTaxonVO[])list.toArray(new CBTaxonVO[list.size()]);
//		 arbol.setIdArbol(numero);
//		 arbol.setTaxones(taxonList);
//		 arboles.add(arbol);
//		   
//		 ArbolCurricularVO arbol2=new ArbolCurricularVO();
//		 CBTaxonVO taxon12=new CBTaxonVO();
//		 CBTaxonVO taxon22=new CBTaxonVO();
//		 CBTaxonVO taxon32=new CBTaxonVO();
//		 CBTaxonVO taxon42=new CBTaxonVO();
//		   
//		 ArrayList list2=new ArrayList();
//	
//		 int numero2=5;
//		 CBTaxonVO[] taxonList2=null;
//		 taxon42.setId("5.6.7.8");
//		 taxon32.setId("5.6.7");
//		 taxon22.setId("5.6");
//		 taxon12.setId("5");
//		 taxon42.setValorTax("Carlos");
//		 taxon32.setValorTax("Ana");
//		 taxon22.setValorTax("Nora");
//		 taxon12.setValorTax("Larraitz");
//		 list2.add(taxon12);
//		 list2.add(taxon22);
//		 list2.add(taxon32);
//		 list2.add(taxon42);
//		 taxonList2=(CBTaxonVO[])list2.toArray(new CBTaxonVO[list2.size()]);
//		 arbol2.setIdArbol(numero2);
//		 arbol2.setTaxones(taxonList2);
//		 arboles.add(arbol2);
//		   
//		 clasificacion.setArbolesCurriculares(new ArbolCurricularVO[arboles.size()]);
//		   
//		 clasificacion.setArbolesCurriculares((ArbolCurricularVO[])arboles.toArray(new ArbolCurricularVO[arboles.size()]));
//		 lomBasico.setClassification(clasificacion);
//		 
//		 
//		 SrvCatalogacionBasicaService catalogacionVacia=this.servicio;
//		 
//		 try{
//	    	
//	    	 catalogacionVacia.generarMetadatos(identificadorVacio, usuario, lomBasico, idioma);
//	    	 assertTrue(true);
//	    	 
//		 }catch(Exception e){
//			 assertTrue(false);
//		 }
//		
//		
//	}
// 
//	 public void testgenerarMetadatos8() {
//	
//		 LomBasicoVO lomBasico=new LomBasicoVO(); 
//		 String idioma="es";
//		 String identificadorLote="idLOMLote";
//		 String usuario="admin";
//		 GeneralVO general=new GeneralVO();
//		 general.setIdioma("ga"); 
//		 general.setDesc("18 de mayo del 2007");
//		 general.setTitulo("El teorema de la probabilidad total");
//		 lomBasico.setGeneral(general);
//		 EducationalVO educational=new EducationalVO();
//		 educational.setContexto("family");
//		 educational.setEdad("De 5 a 6 añitos");
//		 educational.setIdiomaDest("ca");
//		 educational.setProcesoCog("analyse");
//		 educational.setTipo("office service");
//		 lomBasico.setEducational(educational);
//		 
//		 ClassificationVO clasificacion=new ClassificationVO();
//		 ArbolCurricularVO arbol=new ArbolCurricularVO();
//		 ArrayList arboles=new ArrayList();
//		 CBTaxonVO taxon1=new CBTaxonVO();
//		 CBTaxonVO taxon2=new CBTaxonVO();
//		 CBTaxonVO taxon3=new CBTaxonVO();
//		 CBTaxonVO taxon4=new CBTaxonVO();
//	
//		 ArrayList list=new ArrayList();
//	
//		 int numero=4;
//		 CBTaxonVO[] taxonList=null;
//		 taxon4.setId("3.2.4.2");
//		 taxon3.setId("3.2.4");
//		 taxon2.setId("3.2");
//		 taxon1.setId("3");
//		 taxon4.setValorTax("Plantanos");
//		 taxon3.setValorTax("Manazanas");
//		 taxon2.setValorTax("Melones");
//		 taxon1.setValorTax("Peras");
//		 list.add(taxon1);
//		 list.add(taxon2);
//		 list.add(taxon3);
//		 list.add(taxon4);
//		 taxonList=(CBTaxonVO[])list.toArray(new CBTaxonVO[list.size()]);
//		 arbol.setIdArbol(numero);
//		 arbol.setTaxones(taxonList);
//		 arboles.add(arbol);
//		   
//		 ArbolCurricularVO arbol2=new ArbolCurricularVO();
//		 CBTaxonVO taxon12=new CBTaxonVO();
//		 CBTaxonVO taxon22=new CBTaxonVO();
//		 CBTaxonVO taxon32=new CBTaxonVO();
//		 CBTaxonVO taxon42=new CBTaxonVO();
//		   
//		 ArrayList list2=new ArrayList();
//	
//		 int numero2=5;
//		 CBTaxonVO[] taxonList2=null;
//		 taxon42.setId("5.6.7.8");
//		 taxon32.setId("5.6.7");
//		 taxon22.setId("5.6");
//		 taxon12.setId("5");
//		 taxon42.setValorTax("Carlos");
//		 taxon32.setValorTax("Ana");
//		 taxon22.setValorTax("Nora");
//		 taxon12.setValorTax("Larraitz");
//		 list2.add(taxon12);
//		 list2.add(taxon22);
//		 list2.add(taxon32);
//		 list2.add(taxon42);
//		 taxonList2=(CBTaxonVO[])list2.toArray(new CBTaxonVO[list2.size()]);
//		 arbol2.setIdArbol(numero2);
//		 arbol2.setTaxones(taxonList2);
//		 arboles.add(arbol2);
//		   
//		 clasificacion.setArbolesCurriculares(new ArbolCurricularVO[arboles.size()]);
//		   
//		 clasificacion.setArbolesCurriculares((ArbolCurricularVO[])arboles.toArray(new ArbolCurricularVO[arboles.size()]));
//		 lomBasico.setClassification(clasificacion);		 
//		 
//		 SrvCatalogacionBasicaService catalogacionLote=this.servicio;
//		 		 
//		 try{
//	    	 
//			 catalogacionLote.generarMetadatos(identificadorLote, usuario, lomBasico, idioma);			 
//	    	 assertTrue(true);
//	    	 
//		 }catch(Exception e){
//			 assertTrue(false);
//		 }
//		
//		
//	}

    /**
     *   TEST asociarTaxonomia
     *   TODO: Implementar el test para el metodo asociarTaxonomia del servicio SrvCatalogacionBasicaService.
     */
     public void  testasociarTaxonomia() {
    	 assertTrue(true);
    	 
    }


//	   public void testeliminarObjLoms(){
//		   List ids=new ArrayList();
//		   ids.add("idLOM10");
//		   ids.add("idLOM4");
//		   String[] lista=(String[]) ids.toArray(new String[ids.size()]);
//		   //Elimina los lom-es
//		   SrvCatalogacionBasicaService eliminarLoms=this.servicio;
//		   
//		   try{
//			   eliminarLoms.eliminarObjLoms(lista);
//		   }catch(Exception e){
//			   e.printStackTrace();
//		   }
//	   }
	   
	   public void testobtenerObjLoms(){
		   Collection ids=new ArrayList();
//		   ids.add("idLOMLote");
		   ids.add("idLOM1");
		   String[] lista=(String[]) ids.toArray(new String[ids.size()]);
		   //Recogemos los objetos lom-es que necesitemos
		   SrvCatalogacionBasicaService obtenerLoms=this.servicio;
		   
		   try{
			   IdLomVO[] idLomVO=obtenerLoms.obtenerObjLoms(lista);
			   assertNotNull(idLomVO);
			   
			   
		   }catch(Exception e){
			   logger.error(e);
		   }
		   
	   }
	   
	   public void testasociarTaxonomiaEnLomBasico(){
		   String identificador="idLOM1";
		   LomBasicoVO lomBasico=new LomBasicoVO();
		   
		   GeneralVO general=new GeneralVO();
		   general.setIdioma("ga"); 
		   general.setDesc("24 de mayo del 2007");
		   general.setTitulo("El teorema de la probabilidad total");
		   lomBasico.setGeneral(general);
		   EducationalVO educational=new EducationalVO();
		   educational.setContexto("family");
		   educational.setEdad("De 5 a 6 añitos");
		   educational.setIdiomaDest("ca");
		   educational.setProcesoCog("analyse");
		   educational.setTipo("office service");
		   lomBasico.setEducational(educational);
		   
		   ClassificationVO clasificacion=new ClassificationVO();
		   ArbolCurricularVO arbol=new ArbolCurricularVO();
		   ArrayList arboles=new ArrayList();
		   CBTaxonVO taxon1=new CBTaxonVO();
		   CBTaxonVO taxon2=new CBTaxonVO();
		   CBTaxonVO taxon3=new CBTaxonVO();
		   CBTaxonVO taxon4=new CBTaxonVO();

		   ArrayList list=new ArrayList();

		   String numero="3";
		   CBTaxonVO[] taxonList=null;
		   taxon4.setId("2.1.2.4");
		   taxon3.setId("2.1.2");
		   taxon2.setId("2.1");
		   taxon1.setId("2");
		   taxon4.setValorTax("Bloque 4: Interpretación y creación musical");
		   taxon3.setValorTax("Educación artística");
		   taxon2.setValorTax("Primer Ciclo");
		   taxon1.setValorTax("Educación Primaria");
		   list.add(taxon1);
		   list.add(taxon2);
		   list.add(taxon3);
		   list.add(taxon4);
		   taxonList=(CBTaxonVO[])list.toArray(new CBTaxonVO[list.size()]);
		   arbol.setIdArbol(numero);
		   arbol.setTaxones(taxonList);
		   arboles.add(arbol);
		   
		   ArbolCurricularVO arbol2=new ArbolCurricularVO();
		   CBTaxonVO taxon12=new CBTaxonVO();
		   CBTaxonVO taxon22=new CBTaxonVO();
		   CBTaxonVO taxon32=new CBTaxonVO();
		   CBTaxonVO taxon42=new CBTaxonVO();
		   
		   ArrayList list2=new ArrayList();

		   String numero2="2";
		   CBTaxonVO[] taxonList2=null;
		   taxon42.setId("3.1.2.4");
		   taxon32.setId("3.1.2");
		   taxon22.setId("3.1");
		   taxon12.setId("3");
		   taxon42.setValorTax("Carlos");
		   taxon32.setValorTax("Ana");
		   taxon22.setValorTax("Nora");
		   taxon12.setValorTax("Larraitz");
		   list2.add(taxon12);
		   list2.add(taxon22);
		   list2.add(taxon32);
		   list2.add(taxon42);
		   taxonList2=(CBTaxonVO[])list2.toArray(new CBTaxonVO[list2.size()]);
		   arbol2.setIdArbol(numero2);
		   arbol2.setTaxones(taxonList2);
		   arboles.add(arbol2);
		   
		   ArbolCurricularVO arbol3=new ArbolCurricularVO();
		   CBTaxonVO taxon13=new CBTaxonVO();
		   CBTaxonVO taxon23=new CBTaxonVO();
		   CBTaxonVO taxon33=new CBTaxonVO();
		   CBTaxonVO taxon43=new CBTaxonVO();
		   CBTaxonVO taxon53=new CBTaxonVO();
		   
		   
		   
		   ArrayList list3=new ArrayList();

		   String numero3="4";
		   CBTaxonVO[] taxonList3=null;
		   taxon53.setId("9.1.32.2.7");
		   taxon43.setId("9.1.32.2");
		   taxon33.setId("9.1.32");
		   taxon23.setId("9.1");
		   taxon13.setId("9");
		   taxon53.setValorTax("Coche");
		   taxon43.setValorTax("Perro");
		   taxon33.setValorTax("Camión");
		   taxon23.setValorTax("Maceta");
		   taxon13.setValorTax("Armario");
		   list3.add(taxon13);
		   list3.add(taxon23);
		   list3.add(taxon33);
		   list3.add(taxon43);
		   list3.add(taxon53);
		   taxonList3=(CBTaxonVO[])list3.toArray(new CBTaxonVO[list3.size()]);
		   arbol3.setIdArbol(numero3);
		   arbol3.setTaxones(taxonList3);
		   arboles.add(arbol3);
		   
		   clasificacion.setArbolesCurriculares(new ArbolCurricularVO[arboles.size()]);
		   
		   clasificacion.setArbolesCurriculares((ArbolCurricularVO[])arboles.toArray(new ArbolCurricularVO[arboles.size()]));
		   lomBasico.setClassification(clasificacion);
		   
		   CBTaxonVO taxon11=new CBTaxonVO();
		   CBTaxonVO taxon21=new CBTaxonVO();
		   CBTaxonVO taxon31=new CBTaxonVO();
		   CBTaxonVO taxon41=new CBTaxonVO();

		   ArrayList list1=new ArrayList();
		   CBTaxonVO[] taxonList1=null;
		   taxon41.setId("7.1.2.4");
		   taxon31.setId("7.1.2");
		   taxon21.setId("7.1");
		   taxon11.setId("7");
		   taxon41.setValorTax("Casa");
		   taxon31.setValorTax("Barrio");
		   taxon21.setValorTax("Distrito");
		   taxon11.setValorTax("Ciudad");
		   list1.add(taxon11);
		   list1.add(taxon21);
		   list1.add(taxon31);
		   list1.add(taxon41);
		   taxonList1=(CBTaxonVO[])list1.toArray(new CBTaxonVO[list1.size()]);
		   
		   SrvCatalogacionBasicaService asociarTaxonomiaEnLomBasico=this.servicio;
		   
		   try{
			   asociarTaxonomiaEnLomBasico.asociarTaxonomiaEnLomBasico(identificador, lomBasico, taxonList1);
			   assertNotNull(lomBasico.getClassification().getArbolesCurriculares()[2]);
			   assertEquals("4",lomBasico.getClassification().getArbolesCurriculares()[2].getIdArbol());
		   }catch(Exception e){
			   logger.error(e);
		   }   
		   
	   }
	   
//	   public void testasociarTaxonomiaEnLomBasico2(){
//		   String identificador="idLOMLote";
//		   LomBasicoVO lomBasico=new LomBasicoVO();
//		   
//		   GeneralVO general=new GeneralVO();
//		   general.setIdioma("ga"); 
//		   general.setDesc("24 de mayo del 2007");
//		   general.setTitulo("El teorema de la probabilidad total");
//		   lomBasico.setGeneral(general);
//		   EducationalVO educational=new EducationalVO();
//		   educational.setContexto("family");
//		   educational.setEdad("De 5 a 6 añitos");
//		   educational.setIdiomaDest("ca");
//		   educational.setProcesoCog("analyse");
//		   educational.setTipo("office service");
//		   lomBasico.setEducational(educational);
//		   
//		   CBTaxonVO taxon11=new CBTaxonVO();
//		   CBTaxonVO taxon21=new CBTaxonVO();
//		   CBTaxonVO taxon31=new CBTaxonVO();
//		   CBTaxonVO taxon41=new CBTaxonVO();
//
//		   ArrayList list1=new ArrayList();
//		   CBTaxonVO[] taxonList1=null;
//		   taxon41.setId("7.1.2.4");
//		   taxon31.setId("7.1.2");
//		   taxon21.setId("7.1");
//		   taxon11.setId("7");
//		   taxon41.setValorTax("Casa");
//		   taxon31.setValorTax("Barrio");
//		   taxon21.setValorTax("Distrito");
//		   taxon11.setValorTax("Ciudad");
//		   list1.add(taxon11);
//		   list1.add(taxon21);
//		   list1.add(taxon31);
//		   list1.add(taxon41);
//		   taxonList1=(CBTaxonVO[])list1.toArray(new CBTaxonVO[list1.size()]);
//		   
//		   SrvCatalogacionBasicaService asociarTaxonomiaEnLomBasico=this.servicio;
//		   
//		   try{
//			   asociarTaxonomiaEnLomBasico.asociarTaxonomiaEnLomBasico(identificador, lomBasico, taxonList1);
//			   assertNotNull(lomBasico.getClassification().getArbolesCurriculares()[0]);
//			   assertEquals(0,lomBasico.getClassification().getArbolesCurriculares()[0].getIdArbol());
//		   }catch(Exception e){
//			   e.printStackTrace();
//		   }
//	   }
//	   
//	   public void testasociarTaxonomiaEnLomBasico3(){
//		   String identificador="idLOM6";
//		   LomBasicoVO lomBasico=new LomBasicoVO();
//		   
//		   GeneralVO general=new GeneralVO();
//		   general.setIdioma("ga"); 
//		   general.setDesc("24 de mayo del 2007");
//		   general.setTitulo("El teorema de la probabilidad total");
//		   lomBasico.setGeneral(general);
//		   EducationalVO educational=new EducationalVO();
//		   educational.setContexto("family");
//		   educational.setEdad("De 5 a 6 añitos");
//		   educational.setIdiomaDest("ca");
//		   educational.setProcesoCog("analyse");
//		   educational.setTipo("office service");
//		   lomBasico.setEducational(educational);
//		   
//		   ClassificationVO clasificacion=new ClassificationVO();
//		   ArbolCurricularVO arbol=new ArbolCurricularVO();
//		   ArrayList arboles=new ArrayList();
//		   CBTaxonVO taxon1=new CBTaxonVO();
//		   CBTaxonVO taxon2=new CBTaxonVO();
//		   CBTaxonVO taxon3=new CBTaxonVO();
//		   CBTaxonVO taxon4=new CBTaxonVO();
//
//		   ArrayList list=new ArrayList();
//
//		   int numero=1;
//		   CBTaxonVO[] taxonList=null;
//		   taxon4.setId("2.1.2.4");
//		   taxon3.setId("2.1.2");
//		   taxon2.setId("2.1");
//		   taxon1.setId("2");
//		   taxon4.setValorTax("Bloque 4: Interpretación y creación musical");
//		   taxon3.setValorTax("Educación artística");
//		   taxon2.setValorTax("Primer Ciclo");
//		   taxon1.setValorTax("Educación Primaria");
//		   list.add(taxon1);
//		   list.add(taxon2);
//		   list.add(taxon3);
//		   list.add(taxon4);
//		   taxonList=(CBTaxonVO[])list.toArray(new CBTaxonVO[list.size()]);
//		   arbol.setIdArbol(numero);
//		   arbol.setTaxones(taxonList);
//		   arboles.add(arbol);
//		   
//		   ArbolCurricularVO arbol2=new ArbolCurricularVO();
//		   CBTaxonVO taxon12=new CBTaxonVO();
//		   CBTaxonVO taxon22=new CBTaxonVO();
//		   CBTaxonVO taxon32=new CBTaxonVO();
//		   CBTaxonVO taxon42=new CBTaxonVO();
//		   
//		   ArrayList list2=new ArrayList();
//
//		   int numero2=2;
//		   CBTaxonVO[] taxonList2=null;
//		   taxon42.setId("3.1.2.4");
//		   taxon32.setId("3.1.2");
//		   taxon22.setId("3.1");
//		   taxon12.setId("3");
//		   taxon42.setValorTax("Carlos");
//		   taxon32.setValorTax("Ana");
//		   taxon22.setValorTax("Nora");
//		   taxon12.setValorTax("Larraitz");
//		   list2.add(taxon12);
//		   list2.add(taxon22);
//		   list2.add(taxon32);
//		   list2.add(taxon42);
//		   taxonList2=(CBTaxonVO[])list2.toArray(new CBTaxonVO[list2.size()]);
//		   arbol2.setIdArbol(numero2);
//		   arbol2.setTaxones(taxonList2);
//		   arboles.add(arbol2);
//		   
//		   clasificacion.setArbolesCurriculares(new ArbolCurricularVO[arboles.size()]);
//		   
//		   clasificacion.setArbolesCurriculares((ArbolCurricularVO[])arboles.toArray(new ArbolCurricularVO[arboles.size()]));
//		   lomBasico.setClassification(clasificacion);
//		   
//		   CBTaxonVO taxon11=new CBTaxonVO();
//		   CBTaxonVO taxon21=new CBTaxonVO();
//		   CBTaxonVO taxon31=new CBTaxonVO();
//		   CBTaxonVO taxon41=new CBTaxonVO();
//
//		   ArrayList list1=new ArrayList();
//		   CBTaxonVO[] taxonList1=null;
//		   taxon41.setId("7.1.2.4");
//		   taxon31.setId("7.1.2");
//		   taxon21.setId("7.1");
//		   taxon11.setId("7");
//		   taxon41.setValorTax("Casa");
//		   taxon31.setValorTax("Barrio");
//		   taxon21.setValorTax("Distrito");
//		   taxon11.setValorTax("Ciudad");
//		   list1.add(taxon11);
//		   list1.add(taxon21);
//		   list1.add(taxon31);
//		   list1.add(taxon41);
//		   taxonList1=(CBTaxonVO[])list1.toArray(new CBTaxonVO[list1.size()]);
//		   
//		   SrvCatalogacionBasicaService asociarTaxonomiaEnLomBasico=this.servicio;
//		   
//		   try{
//			   asociarTaxonomiaEnLomBasico.asociarTaxonomiaEnLomBasico(identificador, lomBasico, taxonList1);
//			   assertNotNull(lomBasico.getClassification().getArbolesCurriculares()[2]);
//			   assertEquals(3,lomBasico.getClassification().getArbolesCurriculares()[2].getIdArbol());
//			   
//		   }catch(Exception e){
//			   e.printStackTrace();
//		   }
//	   
//	   }
//	   
	   public void testasociarTaxonomiaEnLomBasico4(){
		   String identificador="idLOM1";
		   LomBasicoVO lomBasico=new LomBasicoVO();
		   
		   GeneralVO general=new GeneralVO();
		   general.setIdioma("ga"); 
		   general.setDesc("24 de mayo del 2007");
		   general.setTitulo("El teorema de la probabilidad total");
		   lomBasico.setGeneral(general);
		   EducationalVO educational=new EducationalVO();
		   educational.setContexto("family");
		   educational.setEdad("De 5 a 6 añitos");
		   educational.setIdiomaDest("ca");
		   educational.setProcesoCog("analyse");
		   educational.setTipo("office service");
		   lomBasico.setEducational(educational);
		   
		   CBTaxonVO taxon11=new CBTaxonVO();
		   CBTaxonVO taxon21=new CBTaxonVO();
		   CBTaxonVO taxon31=new CBTaxonVO();
		   CBTaxonVO taxon41=new CBTaxonVO();

		   ArrayList list1=new ArrayList();
		   CBTaxonVO[] taxonList1=null;
		   taxon41.setId("7.1.2.4");
		   taxon31.setId("7.1.2");
		   taxon21.setId("7.1");
		   taxon11.setId("7");
		   taxon41.setValorTax("Casa");
		   taxon31.setValorTax("Barrio");
		   taxon21.setValorTax("Distrito");
		   taxon11.setValorTax("Ciudad");
		   list1.add(taxon11);
		   list1.add(taxon21);
		   list1.add(taxon31);
		   list1.add(taxon41);
		   taxonList1=(CBTaxonVO[])list1.toArray(new CBTaxonVO[list1.size()]);
		   
		   SrvCatalogacionBasicaService asociarTaxonomiaEnLomBasico=this.servicio;
		   
		   try{
			   asociarTaxonomiaEnLomBasico.asociarTaxonomiaEnLomBasico(identificador, lomBasico, taxonList1);
			   assertNotNull(lomBasico.getClassification().getArbolesCurriculares()[0]);
			   assertEquals("0",lomBasico.getClassification().getArbolesCurriculares()[0].getIdArbol());
		   }catch(Exception e){
			   logger.error(e);
		   }
	   }
	   
	   
	   //Solo podemos añadir un taxon......
//	   public void testasociarTaxonomiaEnLomBasico5(){
//		   String identificador="idLOMLote";
//		   LomBasicoVO lomBasico=new LomBasicoVO();
//		   
//		   GeneralVO general=new GeneralVO();
//		   general.setIdioma("ga"); 
//		   general.setDesc("11 de mayo del 2007");
//		   general.setTitulo("El teorema de la probabilidad total");
//		   lomBasico.setGeneral(general);
//		   EducationalVO educational=new EducationalVO();
//		   educational.setContexto("family");
//		   educational.setEdad("De 5 a 6 añitos");
//		   educational.setIdiomaDest("ca");
//		   educational.setProcesoCog("analyse");
//		   educational.setTipo("office service");
//		   lomBasico.setEducational(educational);
//		   
//		   CBTaxonVO taxon11=new CBTaxonVO();
//		   CBTaxonVO taxon21=new CBTaxonVO();
//		   CBTaxonVO taxon31=new CBTaxonVO();
//		   CBTaxonVO taxon41=new CBTaxonVO();
//
//		   ArrayList list1=new ArrayList();
//		   CBTaxonVO[] taxonList1=null;
//		   taxon41.setId("7.1.2.4");
//		   taxon31.setId("7.1.2");
//		   taxon21.setId("7.1");
//		   taxon11.setId("7");
//		   taxon41.setValorTax("Casa");
//		   taxon31.setValorTax("Barrio");
//		   taxon21.setValorTax("Distrito");
//		   taxon11.setValorTax("Ciudad");
//		   list1.add(taxon11);
//		   list1.add(taxon21);
//		   list1.add(taxon31);
//		   list1.add(taxon41);
//		   
//		   CBTaxonVO taxon12=new CBTaxonVO();
//		   CBTaxonVO taxon22=new CBTaxonVO();
//		   CBTaxonVO taxon32=new CBTaxonVO();
//		   CBTaxonVO taxon42=new CBTaxonVO();
//
//		   
//		   taxon42.setId("9.1.2.4");
//		   taxon32.setId("9.1.2");
//		   taxon22.setId("9.1");
//		   taxon12.setId("9");
//		   taxon42.setValorTax("Camión");
//		   taxon32.setValorTax("Coche");
//		   taxon22.setValorTax("Tren");
//		   taxon12.setValorTax("Bicicleta");
//		   list1.add(taxon12);
//		   list1.add(taxon22);
//		   list1.add(taxon32);
//		   list1.add(taxon42);
//		   
//		   CBTaxonVO taxon13=new CBTaxonVO();
//		   CBTaxonVO taxon23=new CBTaxonVO();
//		   CBTaxonVO taxon33=new CBTaxonVO();
//		   CBTaxonVO taxon43=new CBTaxonVO();
//		   CBTaxonVO taxon53=new CBTaxonVO();
//
//		   taxon53.setId("1.1.2.4.9");
//		   taxon43.setId("1.1.2.4");
//		   taxon33.setId("1.1.2");
//		   taxon23.setId("1.1");
//		   taxon13.setId("1");
//		   taxon53.setValorTax("Xirimiri");
//		   taxon43.setValorTax("Lluvia");
//		   taxon33.setValorTax("Nieve");
//		   taxon23.setValorTax("Sol");
//		   taxon13.setValorTax("Granizo");
//		   list1.add(taxon13);
//		   list1.add(taxon23);
//		   list1.add(taxon33);
//		   list1.add(taxon43);
//		   list1.add(taxon53);
//		   taxonList1=(CBTaxonVO[])list1.toArray(new CBTaxonVO[list1.size()]);
//		   
//		   SrvCatalogacionBasicaService asociarTaxonomiaEnLomBasico=this.servicio;
//		   
//		   try{
//			   asociarTaxonomiaEnLomBasico.asociarTaxonomiaEnLomBasico(identificador, lomBasico, taxonList1);
//			   assertNotNull(lomBasico.getClassification().getArbolesCurriculares()[0]);
//			   assertEquals(0,lomBasico.getClassification().getArbolesCurriculares()[0].getIdArbol());
//		   }catch(Exception e){
//			   e.printStackTrace();
//		   }
//	   }
//	   
//	   public void testeliminarTaxonomiaEnLomBasico(){
//		   int idArbol=1;
//		   
//		   LomBasicoVO lomBasico=new LomBasicoVO();
//		   
//		   GeneralVO general=new GeneralVO();
//		   general.setIdioma("ga"); 
//		   general.setDesc("24 de mayo del 2007");
//		   general.setTitulo("El teorema de la probabilidad total");
//		   lomBasico.setGeneral(general);
//		   EducationalVO educational=new EducationalVO();
//		   educational.setContexto("family");
//		   educational.setEdad("De 5 a 6 añitos");
//		   educational.setIdiomaDest("ca");
//		   educational.setProcesoCog("analyse");
//		   educational.setTipo("office service");
//		   lomBasico.setEducational(educational);
//		   
//		   ClassificationVO clasificacion=new ClassificationVO();
//		   ArbolCurricularVO arbol=new ArbolCurricularVO();
//		   ArrayList arboles=new ArrayList();
//		   CBTaxonVO taxon1=new CBTaxonVO();
//		   CBTaxonVO taxon2=new CBTaxonVO();
//		   CBTaxonVO taxon3=new CBTaxonVO();
//		   CBTaxonVO taxon4=new CBTaxonVO();
//
//		   ArrayList list=new ArrayList();
//
//		   int numero=1;
//		   CBTaxonVO[] taxonList=null;
//		   taxon4.setId("2.1.2.4");
//		   taxon3.setId("2.1.2");
//		   taxon2.setId("2.1");
//		   taxon1.setId("2");
//		   taxon4.setValorTax("Bloque 4: Interpretación y creación musical");
//		   taxon3.setValorTax("Educación artística");
//		   taxon2.setValorTax("Primer Ciclo");
//		   taxon1.setValorTax("Educación Primaria");
//		   list.add(taxon1);
//		   list.add(taxon2);
//		   list.add(taxon3);
//		   list.add(taxon4);
//		   taxonList=(CBTaxonVO[])list.toArray(new CBTaxonVO[list.size()]);
//		   arbol.setIdArbol(numero);
//		   arbol.setTaxones(taxonList);
//		   arboles.add(arbol);
//		   
//		   ArbolCurricularVO arbol2=new ArbolCurricularVO();
//		   CBTaxonVO taxon12=new CBTaxonVO();
//		   CBTaxonVO taxon22=new CBTaxonVO();
//		   CBTaxonVO taxon32=new CBTaxonVO();
//		   CBTaxonVO taxon42=new CBTaxonVO();
//		   
//		   ArrayList list2=new ArrayList();
//
//		   int numero2=2;
//		   CBTaxonVO[] taxonList2=null;
//		   taxon42.setId("3.1.2.4");
//		   taxon32.setId("3.1.2");
//		   taxon22.setId("3.1");
//		   taxon12.setId("3");
//		   taxon42.setValorTax("Carlos");
//		   taxon32.setValorTax("Ana");
//		   taxon22.setValorTax("Nora");
//		   taxon12.setValorTax("Larraitz");
//		   list2.add(taxon12);
//		   list2.add(taxon22);
//		   list2.add(taxon32);
//		   list2.add(taxon42);
//		   taxonList2=(CBTaxonVO[])list2.toArray(new CBTaxonVO[list2.size()]);
//		   arbol2.setIdArbol(numero2);
//		   arbol2.setTaxones(taxonList2);
//		   arboles.add(arbol2);
//		   
//		   clasificacion.setArbolesCurriculares(new ArbolCurricularVO[arboles.size()]);
//		   
//		   clasificacion.setArbolesCurriculares((ArbolCurricularVO[])arboles.toArray(new ArbolCurricularVO[arboles.size()]));
//		   lomBasico.setClassification(clasificacion);
//		   
//		   SrvCatalogacionBasicaService eliminarTaxonomiaEnLomBasico=this.servicio;
//		   
//		   try{
//			   eliminarTaxonomiaEnLomBasico.eliminarTaxonomiaEnLomBasico(lomBasico, idArbol);
//		   }catch(Exception e){
//			   e.printStackTrace();
//		   }
//		   
//	   }
//	   
//	   public void testeliminarTaxonomiaEnLomBasico2(){
//		   int idArbol=2; 
////		   String identificador="idLOMLote";
//		   LomBasicoVO lomBasico=new LomBasicoVO();
//		   
//		   GeneralVO general=new GeneralVO();
//		   general.setIdioma("ga"); 
//		   general.setDesc("24 de mayo del 2007");
//		   general.setTitulo("El teorema de la probabilidad total");
//		   lomBasico.setGeneral(general);
//		   EducationalVO educational=new EducationalVO();
//		   educational.setContexto("family");
//		   educational.setEdad("De 5 a 6 añitos");
//		   educational.setIdiomaDest("ca");
//		   educational.setProcesoCog("analyse");
//		   educational.setTipo("office service");
//		   lomBasico.setEducational(educational);
//		   
//		   ClassificationVO clasificacion=new ClassificationVO();
//		   ArbolCurricularVO arbol=new ArbolCurricularVO();
//		   ArrayList arboles=new ArrayList();
//		   CBTaxonVO taxon1=new CBTaxonVO();
//		   CBTaxonVO taxon2=new CBTaxonVO();
//		   CBTaxonVO taxon3=new CBTaxonVO();
//		   CBTaxonVO taxon4=new CBTaxonVO();
//
//		   ArrayList list=new ArrayList();
//
//		   int numero=3;
//		   CBTaxonVO[] taxonList=null;
//		   taxon4.setId("2.1.2.4");
//		   taxon3.setId("2.1.2");
//		   taxon2.setId("2.1");
//		   taxon1.setId("2");
//		   taxon4.setValorTax("Bloque 4: Interpretación y creación musical");
//		   taxon3.setValorTax("Educación artística");
//		   taxon2.setValorTax("Primer Ciclo");
//		   taxon1.setValorTax("Educación Primaria");
//		   list.add(taxon1);
//		   list.add(taxon2);
//		   list.add(taxon3);
//		   list.add(taxon4);
//		   taxonList=(CBTaxonVO[])list.toArray(new CBTaxonVO[list.size()]);
//		   arbol.setIdArbol(numero);
//		   arbol.setTaxones(taxonList);
//		   arboles.add(arbol);
//		   
//		   ArbolCurricularVO arbol2=new ArbolCurricularVO();
//		   CBTaxonVO taxon12=new CBTaxonVO();
//		   CBTaxonVO taxon22=new CBTaxonVO();
//		   CBTaxonVO taxon32=new CBTaxonVO();
//		   CBTaxonVO taxon42=new CBTaxonVO();
//		   
//		   ArrayList list2=new ArrayList();
//
//		   int numero2=2;
//		   CBTaxonVO[] taxonList2=null;
//		   taxon42.setId("3.1.2.4");
//		   taxon32.setId("3.1.2");
//		   taxon22.setId("3.1");
//		   taxon12.setId("3");
//		   taxon42.setValorTax("Carlos");
//		   taxon32.setValorTax("Ana");
//		   taxon22.setValorTax("Nora");
//		   taxon12.setValorTax("Larraitz");
//		   list2.add(taxon12);
//		   list2.add(taxon22);
//		   list2.add(taxon32);
//		   list2.add(taxon42);
//		   taxonList2=(CBTaxonVO[])list2.toArray(new CBTaxonVO[list2.size()]);
//		   arbol2.setIdArbol(numero2);
//		   arbol2.setTaxones(taxonList2);
//		   arboles.add(arbol2);
//		   
//		   ArbolCurricularVO arbol3=new ArbolCurricularVO();
//		   CBTaxonVO taxon13=new CBTaxonVO();
//		   CBTaxonVO taxon23=new CBTaxonVO();
//		   CBTaxonVO taxon33=new CBTaxonVO();
//		   CBTaxonVO taxon43=new CBTaxonVO();
//		   CBTaxonVO taxon53=new CBTaxonVO();
//
//		   ArrayList list3=new ArrayList();
//
//		   int numero3=4;
//		   CBTaxonVO[] taxonList3=null;
//		   taxon53.setId("9.1.32.2.7");
//		   taxon43.setId("9.1.32.2");
//		   taxon33.setId("9.1.32");
//		   taxon23.setId("9.1");
//		   taxon13.setId("9");
//		   taxon53.setValorTax("Coche");
//		   taxon43.setValorTax("Perro");
//		   taxon33.setValorTax("Camión");
//		   taxon23.setValorTax("Maceta");
//		   taxon13.setValorTax("Armario");
//		   list3.add(taxon13);
//		   list3.add(taxon23);
//		   list3.add(taxon33);
//		   list3.add(taxon43);
//		   list3.add(taxon53);
//		   taxonList3=(CBTaxonVO[])list3.toArray(new CBTaxonVO[list3.size()]);
//		   arbol3.setIdArbol(numero3);
//		   arbol3.setTaxones(taxonList3);
//		   arboles.add(arbol3);
//		   
//		   clasificacion.setArbolesCurriculares(new ArbolCurricularVO[arboles.size()]);
//		   
//		   clasificacion.setArbolesCurriculares((ArbolCurricularVO[])arboles.toArray(new ArbolCurricularVO[arboles.size()]));
//		   lomBasico.setClassification(clasificacion);
//		
//		   
//		   SrvCatalogacionBasicaService eliminarTaxonomiaEnLomBasico=this.servicio;
//		   
//		   try{
//			   eliminarTaxonomiaEnLomBasico.eliminarTaxonomiaEnLomBasico(lomBasico, idArbol);
//		   }catch(Exception e){
//			   e.printStackTrace();
//		   }
//		   
//	   }
//	   
//	   
//	   public void testeliminarTaxonomiaEnLomBasico3(){
//		   int idArbol=6; //No borra nada!
//		   
////		   String identificador="idLOMLote";
//		   LomBasicoVO lomBasico=new LomBasicoVO();
//		   
//		   GeneralVO general=new GeneralVO();
//		   general.setIdioma("ga"); 
//		   general.setDesc("11 de mayo del 2007");
//		   general.setTitulo("El teorema de la probabilidad total");
//		   lomBasico.setGeneral(general);
//		   EducationalVO educational=new EducationalVO();
//		   educational.setContexto("family");
//		   educational.setEdad("De 5 a 6 añitos");
//		   educational.setIdiomaDest("ca");
//		   educational.setProcesoCog("analyse");
//		   educational.setTipo("office service");
//		   lomBasico.setEducational(educational);
//		   
//		   ClassificationVO clasificacion=new ClassificationVO();
//		   ArbolCurricularVO arbol=new ArbolCurricularVO();
//		   ArrayList arboles=new ArrayList();
//		   CBTaxonVO taxon1=new CBTaxonVO();
//		   CBTaxonVO taxon2=new CBTaxonVO();
//		   CBTaxonVO taxon3=new CBTaxonVO();
//		   CBTaxonVO taxon4=new CBTaxonVO();
//
//		   ArrayList list=new ArrayList();
//
//		   int numero=3;
//		   CBTaxonVO[] taxonList=null;
//		   taxon4.setId("2.1.2.4");
//		   taxon3.setId("2.1.2");
//		   taxon2.setId("2.1");
//		   taxon1.setId("2");
//		   taxon4.setValorTax("Bloque 4: Interpretación y creación musical");
//		   taxon3.setValorTax("Educación artística");
//		   taxon2.setValorTax("Primer Ciclo");
//		   taxon1.setValorTax("Educación Primaria");
//		   list.add(taxon1);
//		   list.add(taxon2);
//		   list.add(taxon3);
//		   list.add(taxon4);
//		   taxonList=(CBTaxonVO[])list.toArray(new CBTaxonVO[list.size()]);
//		   arbol.setIdArbol(numero);
//		   arbol.setTaxones(taxonList);
//		   arboles.add(arbol);
//		   
//		   ArbolCurricularVO arbol2=new ArbolCurricularVO();
//		   CBTaxonVO taxon12=new CBTaxonVO();
//		   CBTaxonVO taxon22=new CBTaxonVO();
//		   CBTaxonVO taxon32=new CBTaxonVO();
//		   CBTaxonVO taxon42=new CBTaxonVO();
//		   
//		   ArrayList list2=new ArrayList();
//
//		   int numero2=2;
//		   CBTaxonVO[] taxonList2=null;
//		   taxon42.setId("3.1.2.4");
//		   taxon32.setId("3.1.2");
//		   taxon22.setId("3.1");
//		   taxon12.setId("3");
//		   taxon42.setValorTax("Carlos");
//		   taxon32.setValorTax("Ana");
//		   taxon22.setValorTax("Nora");
//		   taxon12.setValorTax("Larraitz");
//		   list2.add(taxon12);
//		   list2.add(taxon22);
//		   list2.add(taxon32);
//		   list2.add(taxon42);
//		   taxonList2=(CBTaxonVO[])list2.toArray(new CBTaxonVO[list2.size()]);
//		   arbol2.setIdArbol(numero2);
//		   arbol2.setTaxones(taxonList2);
//		   arboles.add(arbol2);
//		   
//		   ArbolCurricularVO arbol3=new ArbolCurricularVO();
//		   CBTaxonVO taxon13=new CBTaxonVO();
//		   CBTaxonVO taxon23=new CBTaxonVO();
//		   CBTaxonVO taxon33=new CBTaxonVO();
//		   CBTaxonVO taxon43=new CBTaxonVO();
//		   CBTaxonVO taxon53=new CBTaxonVO();
//
//		   ArrayList list3=new ArrayList();
//
//		   int numero3=4;
//		   CBTaxonVO[] taxonList3=null;
//		   taxon53.setId("9.1.32.2.7");
//		   taxon43.setId("9.1.32.2");
//		   taxon33.setId("9.1.32");
//		   taxon23.setId("9.1");
//		   taxon13.setId("9");
//		   taxon53.setValorTax("Coche");
//		   taxon43.setValorTax("Perro");
//		   taxon33.setValorTax("Camión");
//		   taxon23.setValorTax("Maceta");
//		   taxon13.setValorTax("Armario");
//		   list3.add(taxon13);
//		   list3.add(taxon23);
//		   list3.add(taxon33);
//		   list3.add(taxon43);
//		   list3.add(taxon53);
//		   taxonList3=(CBTaxonVO[])list3.toArray(new CBTaxonVO[list3.size()]);
//		   arbol3.setIdArbol(numero3);
//		   arbol3.setTaxones(taxonList3);
//		   arboles.add(arbol3);
//		   
//		   clasificacion.setArbolesCurriculares(new ArbolCurricularVO[arboles.size()]);
//		   
//		   clasificacion.setArbolesCurriculares((ArbolCurricularVO[])arboles.toArray(new ArbolCurricularVO[arboles.size()]));
//		   lomBasico.setClassification(clasificacion);
//		
//		   
//		   SrvCatalogacionBasicaService eliminarTaxonomiaEnLomBasico=this.servicio;
//		   
//		   try{
//			   eliminarTaxonomiaEnLomBasico.eliminarTaxonomiaEnLomBasico(lomBasico, idArbol);
//		   }catch(Exception e){
//			   e.printStackTrace();
//		   }
//		   
//	   }
	   
	   

}
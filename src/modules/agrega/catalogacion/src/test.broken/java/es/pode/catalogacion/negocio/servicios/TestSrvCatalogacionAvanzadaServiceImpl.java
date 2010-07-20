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
import javax.activation.FileDataSource;
import javax.mail.util.ByteArrayDataSource;

import es.pode.parseadorXML.LomESDao;
import es.pode.parseadorXML.ParseadorException;

import org.apache.log4j.Logger;

/**
 * @see SrvCatalogacionAvanzadaServiceImpl
 */
public class TestSrvCatalogacionAvanzadaServiceImpl
    extends SrvCatalogacionAvanzadaServiceImplBase
{

	private static Logger logger = Logger.getLogger(TestSrvCatalogacionAvanzadaServiceImpl.class);
	
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
     public TestSrvCatalogacionAvanzadaServiceImpl(){
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
		String prueba = null;
		assertNull(prueba);
	}
	
	
    /**
     *   TEST obtenerLomAvanzado
     *   TODO: Implementar el test para el metodo obtenerLomAvanzado del servicio SrvCatalogacionAvanzadaService.
     */
     public void testobtenerLomAvanzado() {
  
     	 SrvCatalogacionAvanzadaService catalogacionAvanzada=this.servicio;
     	 try{
     		String identificador="idLOM1";
 			String usuario="prueba";
 			String idioma="es";

 			LomAvanzadoVO lomAvanzado = catalogacionAvanzada.obtenerLomAvanzado(identificador, usuario, idioma);
 			catalogacionAvanzada.generarMetadatos(identificador,usuario, lomAvanzado,idioma);
    		 
    	 }catch(Exception e){
    		 assertTrue(false);
    		 logger.error(e);
    	 }

    }

    /**
     *   TEST generarMetadatos
     *   TODO: Implementar el test para el metodo generarMetadatos del servicio SrvCatalogacionAvanzadaService.
     */
     public void testgenerarMetadatos() {
    	 try{
    		 assertTrue(true);
	    	 }catch(Exception e){
	    		 assertTrue(false);
	    		 logger.error(e);
	    	 }

    }

    /**
     *   TEST cargarObjLom
     *   TODO: Implementar el test para el metodo cargarObjLom del servicio SrvCatalogacionAvanzadaService.
     * @throws ParseadorException 
     * @throws IOException 
     */
     public void testcargarObjLom() throws ParseadorException, IOException {
    	 SrvCatalogacionAvanzadaService cargarObjLom=this.servicio;
    	 String identificador1="idLOM1";
//    	 String lom1="C:/Metadatos/metadatoLote1.xml";//con todas las estructuras
//    	 File lomFile1 = new File(lom1);

    	 java.net.URL ficheroURL= null;
 		 ficheroURL = this.getClass().getResource("/pruebasDeMetadatos/metadatoLote1.xml");
 		 File lomFile1= new File(ficheroURL.getFile());    	 
    	 
 		 String usuario="user";
    	 es.pode.parseadorXML.castor.Lom lomObj1 = this.getLomesDao().parsearLom(lomFile1);
    	 byte[] bytes1 = serializar(lomObj1);
    	 ByteArrayDataSource bads1 = new ByteArrayDataSource(bytes1,"application/x-java-serialized-object");
    	 DataHandler lomHandler1=new DataHandler(bads1);
    	 String localPrueba1=cargarObjLom.cargarObjLom(identificador1,usuario, lomHandler1);
    	 assertNotNull(localPrueba1);

    }

    /**
     *   TEST eliminarObjLoms
     *   TODO: Implementar el test para el metodo eliminarObjLoms del servicio SrvCatalogacionAvanzadaService.
     */
     public void testeliminarObjLoms() {
    	   List ids=new ArrayList();
		   ids.add("idLOM1");
		   
		   String[] lista=(String[]) ids.toArray(new String[ids.size()]);
		   //Elimina los lom-es
		   SrvCatalogacionAvanzadaService eliminarLoms=this.servicio;
		   
		   try{
			   eliminarLoms.eliminarObjLoms(lista);
		   }catch(Exception e){
			   logger.error(e);
		   }

    }

    /**
     *   TEST obtenerObjLoms
     *   TODO: Implementar el test para el metodo obtenerObjLoms del servicio SrvCatalogacionAvanzadaService.
     */
     public void testobtenerObjLoms() {
    	   Collection ids=new ArrayList();
		   ids.add("idLOM1");
		   String[] lista=(String[]) ids.toArray(new String[ids.size()]);
		   //Recogemos los objetos lom-es que necesitemos
		   SrvCatalogacionAvanzadaService obtenerLoms=this.servicio;
		   
		   try{
			   IdLomVO[] idLomVO=obtenerLoms.obtenerObjLoms(lista);
			   assertNotNull(idLomVO);
			   
			   
		   }catch(Exception e){
			   logger.error(e);
		   }

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
	
	
	
	
	
	
	public void testImportarLomes01() 
	throws Exception 
	{
	   	 java.net.URL ficheroURL= null;
	   	 //fichero lomes valido
		 ficheroURL = this.getClass().getResource("/pruebasDeMetadatos/metadatoLote1.xml");
		 File lomFile= new File(ficheroURL.getFile());    	 
	 
		 DataHandler lomHandler=new DataHandler(new FileDataSource(lomFile));
		 try{
			 LomAvanzadoVO lomAv= this.servicio.importarLomes(lomHandler);
			 assertNotNull(lomAv);
		 }catch(Exception e)
		 {
			 logger.error(e);
		 }
		 
	}
	
	public void testImportarLomes02() 
	throws Exception 
	{
	   	 //fichero inexistente.. por lo que no lo parsea y devuelve un lomav=null
		 File lomFile= new File("/pruebasDeMetadatos/maaaaa.xml");    	 
	 
		 DataHandler lomHandler=new DataHandler(new FileDataSource(lomFile));
		 try{
			 LomAvanzadoVO lomAv= this.servicio.importarLomes(lomHandler);
			 assertNull(lomAv);
		 }catch(Exception e)
		 {
			 logger.error(e);
		 }
		 
	}
	
	public void testImportarLomes03() 
	throws Exception 
	{
	   	 java.net.URL ficheroURL= null;
	   	 //fichero lomes No valido.. por lo que no lo parsea y devuelve un lomav=null
		 ficheroURL = this.getClass().getResource("/pruebasDeMetadatos/metadatoNoValido.xml");
		 File lomFile= new File(ficheroURL.getFile());    	 
	 
		 DataHandler lomHandler=new DataHandler(new FileDataSource(lomFile));
		 try{
			 LomAvanzadoVO lomAv= this.servicio.importarLomes(lomHandler);
			 assertNotNull(lomAv);
		 }catch(Exception e)
		 {
			 logger.error(e);
		 }
		 
	}

    public void testExportarLomes01() 
    {
    	 SrvCatalogacionAvanzadaService catalogacionAvanzada=this.servicio;
    	 try{
    		String identificador="idLOM1";
			String usuario="prueba";
			String idioma="es";

			LomAvanzadoVO lomAvanzado = catalogacionAvanzada.obtenerLomAvanzado(identificador, usuario, idioma);
			DataHandler dh;
			dh= catalogacionAvanzada.exportarLomes(identificador, usuario, lomAvanzado, idioma);
   		 	
			assertNotNull(dh);
   	 }catch(Exception e){
   		 assertTrue(false);
   		 logger.error(e);
   	 }

   }

	
}
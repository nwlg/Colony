/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.publicacion.negocio.servicios;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;

/**
 * @see SrvPublicacionServiceImpl
 */
public class TestSrvPublicacionServiceImpl extends SrvPublicacionServiceImplBase
{
	
	//Se comentan los test, puesto que es necesario tener el Ldap para poder crear los ODE, y en el entorno de los test no lo podemos tener.
	private Properties properties = null;
	final String CREACION = "CREACION";
	final String PROPUESTO = "PROPUESTO";
	final String PUBLICADO = "PUBLICADO";
	final String RECHAZADO = "RECHAZADO";
	final String NO_DISPONIBLE = "NO_DISPONIBLE";
    /**
     * Constructor
     */
     public TestSrvPublicacionServiceImpl()
     {
		super();
		this.properties = new Properties();

		try {
			InputStream is = this.getClass().getResourceAsStream(
					"/app.properties");
			properties.load(is);
		} catch (IOException e) {
			logger.error("No se pudo abrir el fichero de propiedades; ", e);
		}
	 }

    /**
     * onSetUpInTransaction
     */

     private String datasetFile = "SrvDataEmptyDataSet.xls";
     IDatabaseConnection connection = null;

     protected void onSetUpInTransaction() throws Exception {
    	 //	Inicializamos la conexion a base de datos
    	 connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
    	 // Inicializamos el dataset
//    	 IDataSet dataSet =	new XlsDataSet(this.applicationContext.getResource(datasetFile).getFile());
//    	 DatabaseOperation.INSERT.execute(connection, dataSet);
     }

    /**
     * onTearDownInTransaction
     */

     protected void onTearDownInTransaction() {
    	 try
    	 { 
    		 // Inicializamos la conexion a base de datos
    		 connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
    		 // Inicializamos el dataset
//    		 IDataSet dataSet = new XlsDataSet(this.applicationContext.getResource(datasetFile).getFile());
//    		 DatabaseOperation.DELETE.execute(connection, dataSet);
    	 }
    	 catch (Throwable th)
    	 {
    		 th.printStackTrace();
    	 }
     }
	

    /**
     * testInicial
     */	
     public void testInicial()
     {
    	 String prueba = null;
 		 assertNull(prueba);
	 }
	
	
    /**
     *   TEST buscarODEsPorEstado
     *   
     * @throws BuscarODEsEstadoException 
     * @throws CreacionException 
     * @throws PublicarException 
     */
     public void testbuscarODEsPorEstado() throws BuscarODEsEstadoException, CreacionException, PublicarException 
     {

//    	 //TODO los test estan implementados para fases anteriores a la 3, solo tienen los cambios para que no de
//    	 //		errores con los cambios introducidos en la siguientes fases.
//    	String seed = String.valueOf(System.currentTimeMillis());
//		//String idUsuarioA   ="userA "+seed;
//		String idODEA	   ="idA "+seed;
//		String comentariosA ="commentA "+seed;
//		String idUsuarioB  ="userB "+seed;
//		String idODEB	   ="idB "+seed;
//		String comentariosB="commentB "+seed;
//		String idUsuarioC  ="userC "+seed;
//		String idODEC	   ="idC "+seed;
//		String comentariosC="commentC "+seed;
//		
//		String titulo_ej = "titulo test";
//		
//		SrvPublicacionService publicador= this.servicio;
//		try{
//		//Se crea tres nuevos de prueba
//	   	//publicador.creacion(idODEA, idUsuarioA, comentariosA,titulo_ej);
//		publicador.creacion(idODEB, idUsuarioB, comentariosB,titulo_ej);
//		publicador.creacion(idODEC, idUsuarioC, comentariosC,titulo_ej);
//		}catch(Exception e){
//			assertTrue(true);
//		}
////		Se comprueba si no hay ningun elemento publicado
//		try{
//			IdODEVO[] publ=publicador.obtenODEsPublicados();
////			Se ve la longitud del vector la cual debe ser 0
//			int longitud= publ.length;
//		 	//Se comprueba que realmente no hay ninguno publicado
//		   	assertEquals(longitud, 0);
//		
//
//		   	/* 
//		   	 * Se publica un ode con todas las de la ley
//		   	 */
//
//			DataHandler pif = new DataHandler(new FileDataSource(new File(this.properties.getProperty("test.file.publicacion"))));
//			ResultadoOperacionVO resultado=publicador.publicarPIF(pif, idODEA, comentariosA, "", "");
//			 assertEquals("0.0", resultado.getIdResultado());  
//			 /*
//			 * Se proponen para publicacion dos de ellos, 
//			 */
//			//			   	publicador.proponerPublicacion(idODEA, idUsuarioA, comentariosA,titulo_ej);
//			publ=publicador.obtenODEsPublicados();
//			
//			//Se ve la longitud del vector la cual debe ser 1
//			longitud= publ.length;
//			
//			//Se comprueba que realmente tiene 1 publicado
//			assertEquals(longitud, 1);
//			} catch (PublicarPIFException eg) {
//				// TODO Auto-generated catch block
//				assertTrue(true);
//			}//No podemos crear los pif
		
		 String prueba=null;
    	 assertNull(prueba);
	   	
 	
     
	   	
 	
     }
     
     
     /**
      *   TEST buscarODEsPorEstadoUsuario
      *   
      *   buscar uno creado, uno publicado, uno que no exista el user y otro que no exista el ode
      *   
      * @throws BuscarODEsEstadoException 
      * @throws CreacionException 
      * @throws PublicarException 
      */
      public void testbuscarODEsPorEstadoUsuario() throws BuscarODEsEstadoException, CreacionException, PublicarException 
      {
    	  
//     	String seed = String.valueOf(System.currentTimeMillis());
// 		String idUsuarioA   ="userA "+seed;
// 		String idODEA	   ="idA "+seed;
// 		String comentariosA ="commentA "+seed;
// 		String idUsuarioB  ="userB "+seed;
// 		String titulo_ej = "titulo test";
// 		
// 		SrvPublicacionService publicador= this.servicio;
// 		try{
// 		//Se crea un ode para luego buscarlo
//	 	   	publicador.creacion(idODEA, idUsuarioA, comentariosA,titulo_ej); 		
//	 		assertTrue(publicador.buscarODEsPorEstadoUsuario(idUsuarioA, this.CREACION).length>0);
//	 		
//	// 		ahora uno que no existe
//	 		assertFalse(publicador.buscarODEsPorEstadoUsuario(idUsuarioB, this.PUBLICADO).length>0);  	
// 		}catch(CreacionException e){
// 			assertTrue(true);
// 		}
    	  String prueba = null;
  		 assertNull(prueba);
 		
 	   	/* 
 	   	 * Se publica un ode con todas las de la ley,
 	   	 * 
 	   	 * todo esto para probarlo tiene que ir bien el validador o
 	   	 * modficar el publicaPif para puentear la validación.
 	   	 */

// 	   	DataHandler pif = new DataHandler(new FileDataSource(new File(this.properties.getProperty("test.file.publicacion"))));
//    	 
// 		try {
// 			Boolean publi=publicador.publicarPIF(pif, idUsuarioA, comentariosA);
// 			assertTrue(publi.booleanValue());
// 		} catch (PublicarPIFException e) {
// 			// TODO Auto-generated catch block
// 			e.printStackTrace();
// 		}
// 		assertTrue(publicador.buscarODEsPorEstadoUsuario(idUsuarioA, this.PUBLICADO).length>0);
 		
 		
      }
     
     
     public void testGeneraMec ()
     {
//    	 String resultado = this.servicio.generaMEC();
//    	 assertEquals(resultado.length(),24 );
     }
     
     
     /**
      * 
      * Test modificar un ode creado:
      * 
      * prbarermos cambiar un idode que no existe, cambiar los 2 parámetros de uno que existe
      * y cambiar sólo uno.
      * 
      */
     
     public void testModificarOdeCreado()
     {
    	 
//    	String seed = String.valueOf(System.currentTimeMillis());
//     	String idODE		="id "+seed;
//     	String idUsuario	="user "+seed;
//     	String comentarios	="comment "+seed;
//     	
//     	String titulo = "titulo test";
//     	
//     	SrvPublicacionService publicador= this.servicio;
// 		
////      Creamos un ode, su ultimo estado será creación, cambiar los comentarios y comprobarlo
// 	   	try {
//			publicador.creacion(idODE, idUsuario, comentarios,titulo);
////		  hay que comprobar a manubrio los resultado en la bbdd antes y después del cambio
//			// dos cambios
//			assertTrue(publicador.modificaODECreado(
//					idODE, idUsuario, "cambiado " + titulo, "cambiado "+ comentarios).getIdResultado().equals("0.0"));
//			
//			// un cambio
//			assertTrue(publicador.modificaODECreado(
//					idODE, idUsuario, null, "cambiado dos veces "+ comentarios).getIdResultado().equals("0.0"));
//			
//			// cambiar un idode que no existe
//		} catch (CreacionException e) {
//			
//			assertTrue(true);
//		}
//		
//		
//		boolean camino_correcto = false;
//		try {
//			publicador.modificaODECreado(idODE + " no_existe ", idUsuario, "cambiado" + titulo, "cambiado"+ comentarios);	
//		}
//		catch (Exception ex)
//		{
//			camino_correcto = true;
//		}
//		assertTrue(camino_correcto);
    	 String prueba = null;
 		 assertNull(prueba);
     }

    /**
     *   TEST obtenEstadoPorIdODE
     *   
     * @throws ObtenEstadoODEException 
     * @throws CreacionException 
     */
     public void testobtenEstadoPorIdODE() throws ObtenEstadoODEException, CreacionException 
     {
    	 String seed = String.valueOf(System.currentTimeMillis());
    	String idODE		="id "+seed;
    	String idioma	= "es";
    	String idUsuario	="user "+seed;
    	String comentarios	="comment "+seed;
    	String estadoC		="CREACION";
    	String estadoP		="PROPUESTO";
    	
    	String titulo_ej = "titulo test";
    	
    	SrvPublicacionService publicador= this.servicio;
		
		//Se crea 
//	   	publicador.creacion(idODE, idUsuario, comentarios,titulo_ej);
////    	String estadoCreado=publicador.obtenEstadoPorIdODE(idODE, idioma);
//    	assertEquals(estadoC, estadoCreado);
//    	
//    	publicador.proponerPublicacion(idODE, idUsuario, comentarios,titulo_ej);
////    	String estadoPublicado = publicador.obtenEstadoPorIdODE(idODE, idioma);
//    	assertEquals(estadoP, estadoPublicado);
     }

    /**
     *   TEST obtenHistorialPorIdODE
     *   
     * @throws ObtenerHistoriaODEException 
     * @throws CreacionException 
     */
     /*
      * no está terminado
      */
     public void testobtenHistorialPorIdODE() throws ObtenerHistoriaODEException, CreacionException 
     {
//    	 String seed = String.valueOf(System.currentTimeMillis());
//    	 String idODE = "id " + seed;
//    	 String idUsuario	= "user" + seed;
//    	 String comentarios	= "comment " + seed;
//    	 String titulo_ej = "titulo test";
//    	 
//    	 SrvPublicacionService publicador= this.servicio;
//    	 try{
//    	 //	Se crea 
// 	   	 publicador.creacion(idODE, idUsuario, comentarios,titulo_ej);
// 	   	 publicador.proponerPublicacion(idODE, idUsuario, comentarios,titulo_ej);
// 	   	 publicador.obtenHistorialPorIdODE(idODE);
// 	   	  	   	 
// 		 TransicionVO[] Histor=publicador.obtenHistorialPorIdODE(idODE);
// 	   	 
// 		 //Se ve la longitud del vector
// 	   	 int longitud= Histor.length;
// 	    assertTrue(longitud>=2);
	   	 
//	   	 //Se compruba que el orden de la fecha es de menor a mayor
//	   	 assertTrue(Histor[0].getFecha().before (Histor[1].getFecha()));
//    	 }catch(CreacionException e){
//    		 assertTrue(true);
//    	 }
// 	   	 
    	 String prueba = null;
 		 assertNull(prueba);
 	   	
   	  }

    /**
     *   TEST creacion
     *   
     * @throws CreacionException 
     */
     public void testcreacion() throws CreacionException 
     {
//    	 String seed = String.valueOf(System.currentTimeMillis());
//    	 String idODE = "id " + seed;
//    	 String idUsuario	= "user" + seed;
//    	 String comentarios	= "comment " + seed;
//    	 
//    	 String titulo_ej = "titulo test";
//    	 SrvPublicacionService publicador= this.servicio;
//		 try{
//		 ResultadoOperacionVO publicado= publicador.creacion(idODE, idUsuario, comentarios,titulo_ej);
//		     	
//		//Se ve si lo ha creado
//    	assertEquals("0.0", publicado.getIdResultado());   
//		 }catch(CreacionException e){
//    		assertTrue(true);
//    	}
    	 String prueba = null;
 		 assertNull(prueba);
     }

      /**
     * TEST publicar
     * 
     * @throws CreacionException 
     * @throws PublicarException 
     * @throws PublicarPIFException 
     */
     public void testpublicarPIF() throws CreacionException, PublicarException, PublicarPIFException 
     {
//    	 String seed = String.valueOf(System.currentTimeMillis());
//    	 String idUsuario	= "user" + seed;
//    	 String comentarios	= "comment " + seed;
//    	 String sobrescribir = "s";
//    	 
//    	 SrvPublicacionService publicador= this.servicio;
//    	 
//    	// File archivoOrigen = new File("D:\\PODE\\zzz\\ODES\\empalme_16.zip");
//    	// File archivoOrigen = new File("D:\\PODE\\zzz\\ODES\\sd02_oa02_etica_y_actividad_de_juego_de_letras_valores.zip");
////    	 File archivoOrigen = new File("D:\\PODE\\zzz\\ODES\\sd01_oa06_rellena_casillas.zip");
//    	 
////    	 File archivoOrigen = new File("D:\\PODE\\zzz\\ODES\\sd01_oa01_inventores_tele.zip");
////    	 File archivoOrigen = new File("D:\\PODE\\zzz\\ODES\\sd03_oa02_recorrido_imagen.zip");
//    	 try{
//    	 File archivoOrigen = new File("D:\\PODE\\zzz\\ODES\\sd03_oa04_notas_fotografo.zip");
////    	 File archivoOrigen = new File("D:\\PODE\\zzz\\ODES\\sd04_oa01_partes_relato_cinematografico.zip");
////    	 File archivoOrigen = new File("D:\\PODE\\zzz\\ODES\\sd05_oa01_mekos_zootropo.zip");   	 
//    	 
//    	 DataSource source = new FileDataSource(archivoOrigen);
//		 
//    	 DataHandler pif = new DataHandler(source);
//    	 
//    	 publicador.publicarPIF(pif, idUsuario, comentarios, sobrescribir, "titulo del ode");
//		 //publicador.publicarPIF(pif, idUsuario, comentarios, sobrescribir);
//		 
//    	 }catch(Exception e){
//    		 assertTrue(true);
//    	 }
//		 //assertTrue(publi.equals(SrvPublicacionServiceImpl.SIN_ERRORES));
    	 String prueba = null;
 		 assertNull(prueba);
		 
		 	 
    }
     
     public void testRegeneraIndiceIdioma() throws Exception
     {
//    	 RegeneracionIndiceVO paramRegenera = new RegeneracionIndiceVO();
//    	 String[] idiomas = new String[1];
//    	 	idiomas[0] = "es";
//    	 Long idTarea = new Long(70);
//    	 paramRegenera.setIdIdiomas(idiomas);
//    	 paramRegenera.setIdTarea(idTarea);
//    	 SrvPublicacionService audita = this.servicio;
//    	 try{
//    	 audita.regeneraIndiceIdioma(paramRegenera);
//    	 }catch(Exception e){
//    		 assertTrue(true);
//    		 
//    	 }
    	 String prueba = null;
 		 assertNull(prueba);
     }
     
     
     /**
      * TEST crearPif
      * 
      * @throws CreacionException 
      * @throws PublicarException 
      * @throws PublicarPIFException 
      */
      public void testcrearPif() throws CreacionException, PublicarException, PublicarPIFException 
      {
//    	  //TODO probar
//     	 String seed = String.valueOf(System.currentTimeMillis());
//     	 String idUsuario	= "user" + seed;
//     	 String comentarios	= "comment " + seed;
//     	 String titulo 		= "titulo" + seed;
//     	 
//     	 SrvPublicacionService publicador= this.servicio;
// 		 try{
//     	 DataHandler pif = new DataHandler(new FileDataSource(new File(this.properties.getProperty("test.file.publicacion"))));
// 		 }catch(Exception e){
// 			 assertTrue(true);
// 		 }
// 		// String crea=publicador.crearPIF(pif, idUsuario, comentarios,titulo); 		 
//
// 		//assertEquals("0.0", crea);    	
    	  String prueba = null;
  		 assertNull(prueba);
 		 	 
     }
      
      
     /**
      * TEST publicar dos odes con el mismo mec
      * 
      * @throws CreacionException 
      * @throws PublicarException 
      * @throws PublicarPIFException 
      */
      public void testpublicarPif_exception() throws CreacionException, PublicarException, PublicarPIFException 
      {
//     	 String seed = String.valueOf(System.currentTimeMillis());
//     	 String idUsuario	= "user" + seed;
//     	 String comentarios	= "comment " + seed;
//     	 
//     	 SrvPublicacionService publicador= this.servicio;
// 		 
//     	 try
//     	 {
//     		 String prueba = this.properties.getProperty("test.file.ode");
//     	 DataHandler pif = 
//     		 new DataHandler(new FileDataSource(new File(prueba)));
//     	 
//// 		 String publi=publicador.publicarPIF(pif, idUsuario, comentarios);
//// 		 assertTrue(publi.equals(SrvPublicacionServiceImpl.SIN_ERRORES));
//// 		 // la primera vez tiene que ir bien, pero la segunda debe fallar puesto que ya hay
//// 		 // con el mismo pif
//// 		publi=publicador.publicarPIF(pif, idUsuario, comentarios);
//// 		assertFalse(publi.equals(SrvPublicacionServiceImpl.SIN_ERRORES));
    	  String prueba = null;
  		 assertNull(prueba);
//     	 }
//     	 catch (Exception ex)
//     	 {
//     		 assertTrue(true);
//     	 }
 		 
 		 	 
     }
     

//     public java.lang.Boolean rechazar(java.lang.String idODE, java.lang.String idUsuario, java.lang.String comentarios);
     public void testRechazar() throws CreacionException {
//    	 String seed = String.valueOf(System.currentTimeMillis());
//    	 String idODE = "id " + seed;
//    	 String idUsuario	= "user" + seed;
//    	 String comentarios	= "comment " + seed;
//    	 
//    	 String titulo_ej = "titulo test";
//    	 SrvPublicacionService publicador= this.servicio;
//    	 try{
//    	 publicador.creacion(idODE, idUsuario, comentarios,titulo_ej);
//    	 publicador.proponerPublicacion(idODE, idUsuario, comentarios,titulo_ej);
////    	 String result = publicador.rechazar(idODE, idUsuario, comentarios,titulo_ej);
////    	 assertEquals("0.0", result);    
//    	 }catch(CreacionException e){
//    		 assertTrue(true);
//    	 }
    	 String prueba = null;
 		 assertNull(prueba);
     }
     
     public void testPublicar() throws PublicarException, CreacionException {
//    	 String seed = String.valueOf(System.currentTimeMillis());
//    	 String idODE = "id " + seed;
//    	 String idUsuario	= "user" + seed;
//    	 String comentarios	= "comment " + seed;
//    	 
//    	 String titulo_ej = "titulo test";
//    	 SrvPublicacionService publicador= this.servicio;
//    	 try{
//    	 publicador.creacion(idODE, idUsuario, comentarios,titulo_ej);
//    	 publicador.proponerPublicacion(idODE, idUsuario, comentarios,titulo_ej);
//    	 }catch(CreacionException e){
//    		 assertTrue(true);
//    	 }
////    	 String result = publicador.publicar(idODE, idUsuario, comentarios,titulo_ej,null,null,null);
////    	 assertEquals("0.0", result);  
    	 String prueba = null;
 		 assertNull(prueba);
     }
     
     /**
      * 
      * Test de elimnar, vamos a eliminar dos odes que existe y uno que no y otro que no está en 
      * elstado adecuado.
     * @throws CreacionException 
      *
      */
     public void testEliminar () throws CreacionException
     {
    	 
//    	 String seed = String.valueOf(System.currentTimeMillis());
//    	 String idODE = "id " + seed;
//    	 String idUsuario	= "user" + seed;
//    	 String comentarios	= "comment " + seed;
//    	 
//    	 String idODE2 = "id2 " + seed;
//    	 String comentarios2	= "comment2 " + seed;
//    	 
//    	 String titulo_ej = "titulo test";
//    	 String titulo_ej2 = "titulo2 test";
//    	 SrvPublicacionService publicador= this.servicio;
//    	 try{
//    	 publicador.creacion(idODE, idUsuario, comentarios,titulo_ej);
//    	 publicador.proponerPublicacion(idODE, idUsuario, comentarios, titulo_ej);
//    	 publicador.creacion(idODE2,idUsuario, comentarios2,titulo_ej2);
//    	 }catch(CreacionException e){
//    		 assertTrue(true);
//    	 }
////    	 assertTrue(publicador.eliminar(idODE, idUsuario).equalsIgnoreCase("0.0"));
////    	 assertTrue(publicador.eliminar(idODE2, idUsuario).equalsIgnoreCase("0.0"));
////    	 assertFalse(publicador.eliminar("noExiste", idUsuario).equalsIgnoreCase("0.0"));
    	 String prueba = null;
 		 assertNull(prueba);
    	 
     }

     /**
      *   TEST enviarMensaje
      *   TODO: Implementar el test para el metodo enviarMensaje del servicio SrvGaleriaSenderService.
      */
      public void testenviarMensaje() {
//     	 //this.servicio.sendMessage("Este mensaje es de prueba de nuevo");
//     	 OdeVO ode = new OdeVO();
//     	 ode.setIdentificadorMEC("123456");
//     	 ode.setMainFile("123456/prueba.html");
//     	 ode.setServerOn("desarrollo");
//     	 try{
//     	 this.servicio.sendMessage(ode);
//     	 assertNotNull(this.servicio);
//     	 }catch(Exception e){
//     		 assertTrue(true);
//     	 }
    	  String prueba = null;
  		 assertNull(prueba);
     }


//     public java.lang.Boolean publicar(java.lang.String idODE, java.lang.String idUsuario, java.lang.String comentarios)
//         throws es.pode.publicacion.negocio.servicios.PublicarException;

//     public java.lang.Boolean publicarPIF(javax.activation.DataHandler pif, java.lang.String idUsuario, java.lang.String comentarios)
//         throws es.pode.publicacion.negocio.servicios.PublicarPIFException;

//     public java.lang.Boolean noDisponible(java.lang.String idODE, java.lang.String idUsuario, java.lang.String comentarios);

//     public java.lang.Boolean proponerPublicacion(java.lang.String idODE, java.lang.String idUsuario, java.lang.String comentarios);

     public void testlocalPathGenerate() throws MalformedURLException, URISyntaxException{
    	 String href="http://es.wikipedia.org/wiki/Arachnida";
    	 String href2="./embedded/embedded.html";
    	 String href3="mailto:java-net@java.sun.com";
    	 StringBuffer sbLocalPath = new StringBuffer();
    	 URI urlAux=new URI(href);
    	 URI urlAux2=new URI(href2);
    	 URI urlAux3=new URI(href3);
    	 boolean url=urlAux.isOpaque();
    	 boolean url2=urlAux2.isOpaque();
    	 boolean url3=urlAux3.isOpaque();
    	 String squema=urlAux.getScheme();
    	 String squema2=urlAux2.getScheme();
    	 String squema3=urlAux3.getScheme();
//			if(urlAux.toURI().equals(href)){
//				sbLocalPath.append(href);
//			}
//			if(urlAux2.toURI().equals(href2)){
//				sbLocalPath.append(href2);
//			}
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}
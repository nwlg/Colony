/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.localizador.negocio.servicios;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


/**
 * @see SrvLocalizadorServiceImpl
 */
public class TestSrvLocalizadorServiceImpl
    extends SrvLocalizadorServiceImplBase
{
	String usuario;
	String uuid;

    /**
     * Constructor
     */
     public TestSrvLocalizadorServiceImpl()
     {
		super();
	 }

    /**
     * onSetUpInTransaction
     */

     protected void onSetUpInTransaction() throws Exception 
     {

     	/**
     	 * Implementar si no desea usar DataSets
     	 */
		super.onSetUpInTransaction();
	 }

    /**
     * onTearDownInTransaction
     */

	 protected void onTearDownInTransaction() 
	 {

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
     public void testInicial()
     {
		String prueba = null;
		assertNull(prueba);
	 }
	
	
    /**
     *   TEST crearLocalizador
     *   TODO: Implementar el test para el metodo crearLocalizador del servicio SrvLocalizadorService.
     * @throws IOException 
     * @throws CreaLocalizadorNoPublicadoException 
     * @throws EliminaLocalizadorException 
     */
     public void testCrearLocalizadorNoPublicado() throws IOException, CreaLocalizadorNoPublicadoException, EliminaLocalizadorException 
     {
 		usuario = "administrador";
 		uuid 	= "uuid "+new String(new Long(System.currentTimeMillis()).toString());
    		    
    	SrvLocalizadorService localizador =this.servicio;
    	LocalizadorVO localPrueba=localizador.crearLocalizadorNoPublicado(usuario, uuid);
    	//vemos si es igual el uuid a id
    	assertEquals(uuid,localPrueba.getIdentificador());
    	//El Mec tiene que ser siempre vacio, así vemos si se ha cambiado
    	assertEquals(localPrueba.getMec(),"");
    	//vemos si es igual Url al que le hemos pasado
    	Properties props = new Properties();
    	
    	//carga el fichero localizador.properties en props
    	props.load(this.getClass().getResourceAsStream("/localizador.properties"));
    	
    	assertEquals(localPrueba.getPath(),props.getProperty("tallerPathBase")+usuario+this.getDirectorioFecha()+"/"+uuid);
    	assertEquals(localPrueba.getUrl(),props.getProperty("tallerUrlBase")+usuario+this.getDirectorioFecha()+"/"+uuid);
    	localizador.eliminarLocalizador(uuid);
    	//crea existiendo uuid
    	try 
    	{
    		String id="uuid "+new String(new Long(System.currentTimeMillis()).toString());
    		localPrueba=localizador.crearLocalizadorNoPublicado(usuario, id);
    		localizador.eliminarLocalizador(id);
    	} 
    	catch (CreaLocalizadorNoPublicadoException e) 
    	{
    		assertTrue(true);
    	}
    	catch (EliminaLocalizadorException e) 
    	{
    		assertTrue(true);
    	}
    	
    	//si el id es el mismo y el usuario distinto modifica la localizacion
    	
    	//creo un usuario distinto usuario2
    	String usuario2 = "Usuario "+new String(new Long(System.currentTimeMillis()).toString());
    	
    	//creo otro un LocalizadorNo Publicado con el mismo uuid y distinto usuario
    	localPrueba=localizador.crearLocalizadorNoPublicado(usuario2, uuid);
    	
    	assertEquals(localPrueba.getPath(),props.getProperty("tallerPathBase")+usuario2+this.getDirectorioFecha()+"/"+uuid);
    	assertEquals(localPrueba.getUrl(),props.getProperty("tallerUrlBase")+usuario2+this.getDirectorioFecha()+"/"+uuid);
    	localizador.eliminarLocalizador(uuid);
       			
     }

    /**
     *   TEST crearLocalizador
     *   TODO: Implementar el test para el metodo crearLocalizador del servicio SrvLocalizadorService.
     * @throws IOException 
     * @throws CreaLocalizadorNoPublicadoException 
     * @throws CreaLocalizadorPublicadoException 
     * @throws ConsultaLocalizadorException 
     */
     public void testCrearLocalizadorPublicado() throws IOException, CreaLocalizadorNoPublicadoException, CreaLocalizadorPublicadoException, ConsultaLocalizadorException 
     {
 		usuario 	= "Usuario "+new String(new Long(System.currentTimeMillis()).toString());
 		uuid 	   	= "uuid "+new String(new Long(System.currentTimeMillis()).toString());
     	String mec 	= "mec "+new String(new Long(System.currentTimeMillis()).toString());
 		
     	SrvLocalizadorService localizador =this.servicio;
     	
     	//crea sin que exista el uuid
     	localizador.crearLocalizadorNoPublicado(usuario, uuid);
     	try{
     		localizador.crearLocalizadorPublicado(uuid, mec);
     		LocalizadorVO localTaller = localizador.consultaLocalizador(uuid);
     		LocalizadorVO localPublicado=localizador.consultaLocalizador(mec);
     	
     		//compara los mec del taller
     		assertEquals(mec,localTaller.getMec());
     	
     		//El Mec tiene que ser siempre vacio, así vemos si se ha cambiado
     		assertEquals(localPublicado.getMec(),"");
     	
     	
     	//vemos si es igual Url al que le hemos pasado
    	Properties props = new Properties();
    	
    	//carga el fichero localizador.properties en props
    	props.load(this.getClass().getResourceAsStream("/localizador.properties"));
    	
    	assertEquals(localPublicado.getPath(),props.getProperty("publicacionPathBase")+this.getDirectorioFecha()+"/"+localPublicado.getIdentificador());
    	assertEquals(localPublicado.getUrl(),props.getProperty("publicacionUrlBase")+this.getDirectorioFecha()+"/"+localPublicado.getIdentificador());
    	
    	//crea existiendo uuid y mec devuelve la localizacion
    	
    	localPublicado=localizador.crearLocalizadorPublicado(uuid, mec);
    	assertNotNull(localPublicado); 

     	}catch(CreaLocalizadorPublicadoException e) 
    	{
    		assertTrue(true);
    	}
    	
    	//si recibo un id y un mec y el id ya tiene mec asignado da error
    	String mec2 	= "mec "+new String(new Long(System.currentTimeMillis()).toString());
    	
      	try 
    	{
      		localizador.crearLocalizadorPublicado(uuid, mec2);
    	}
    	catch (CreaLocalizadorPublicadoException e) 
    	{
    		assertTrue(true);
    	}//La prueba no nos vale, pues cuando se publica se crea una carpeta con la fecha del dia
    	 String prueba = null;
 		assertNull(prueba); 		
     }

    /**
     *   TEST consultaLocalizador
     *   TODO: Implementar el test para el metodo consultaLocalizador del servicio SrvLocalizadorService.
     * @throws CreaLocalizadorNoPublicadoException 
     * @throws ConsultaLocalizadorException 
     * @throws EliminaLocalizadorException 
     */
     public void testconsultaLocalizador() throws CreaLocalizadorNoPublicadoException, ConsultaLocalizadorException, EliminaLocalizadorException 
     {
 		 usuario 				= "Usuario "+new String(new Long(System.currentTimeMillis()).toString());
 		 String identificador 	= "uuid "+new String(new Long(System.currentTimeMillis()).toString());
   	       	    	     
    	 SrvLocalizadorService localizador =this.servicio;
    	 
    	 //creo uno nuevo de prueba
      	     	 
      	 LocalizadorVO nuevaTupla = localizador.crearLocalizadorNoPublicado(usuario, identificador);
    	 LocalizadorVO localPrueba=localizador.consultaLocalizador(identificador);
      	  
    	 //compruebo que la que creo y la que me devuelve tienen los mismos valores
      	 assertTrue(nuevaTupla.getIdentificador().equals(localPrueba.getIdentificador()));
      	 assertTrue(nuevaTupla.getPath().equals(localPrueba.getPath()));
      	 assertTrue(nuevaTupla.getUrl().equals(localPrueba.getUrl()));
      	 assertTrue(nuevaTupla.getMec().equals(localPrueba.getMec()));
      	
      	/*
      	 *si el id no existe, devuelve una excepción 
      	 */
      	
      	//lo borramos
      	localizador.eliminarLocalizador(identificador);
      	
      	try 
    	{
      		localPrueba=localizador.consultaLocalizador(identificador);
    	}
    	catch (ConsultaLocalizadorException e) 
    	{
    		assertTrue(true);
    	}
      	
	}
     
     public void testConsultaLocalizadores() throws EliminaLocalizadorException, CreaLocalizadorNoPublicadoException, ConsultaLocalizadorException, BuscarLocalizadoresException {
 		 usuario 				= "Usuario "+new String(new Long(System.currentTimeMillis()).toString());
 		 String identificador 	= "uuid "+new String(new Long(System.currentTimeMillis()).toString());
   	       	    	     
    	 SrvLocalizadorService localizador =this.servicio;
    	 String[] ids = {identificador};
    	 LocalizadorVO primerLocal = localizador.crearLocalizadorNoPublicado(usuario, identificador);
    	 LocalizadorVO[] localPruebaArray = {primerLocal};
    	
    	 //creo uno nuevo de prueba
    	 localPruebaArray = localizador.buscarLocalizadoresPorId(ids);
      	  
    	 //compruebo que la que creo y la que me devuelve tienen los mismos valores
      	 assertTrue(localPruebaArray[0].getIdentificador().equals(primerLocal.getIdentificador()));
      	 assertTrue(localPruebaArray[0].getPath().equals(primerLocal.getPath()));
      	 assertTrue(localPruebaArray[0].getUrl().equals(primerLocal.getUrl()));
      	 assertTrue(localPruebaArray[0].getMec().equals(primerLocal.getMec()));

      	//añadimos otro y comprobamos
      	
 		 usuario = "Usuario "+new String(new Long(System.currentTimeMillis()).toString());
 		 identificador 	= "uuid "+new String(new Long(System.currentTimeMillis()).toString());
 		 LocalizadorVO segundoLocal = localizador.crearLocalizadorNoPublicado(usuario, identificador);
      	 localPruebaArray = new LocalizadorVO[2];
      	 localPruebaArray[0] = primerLocal;
      	 localPruebaArray[1] = segundoLocal;
// 		compruebo que la que creo y la que me devuelve tienen los mismos valores
      	 assertTrue(localPruebaArray[0].getIdentificador().equals(primerLocal.getIdentificador()));
      	 assertTrue(localPruebaArray[0].getPath().equals(primerLocal.getPath()));
      	 assertTrue(localPruebaArray[0].getUrl().equals(primerLocal.getUrl()));
      	 assertTrue(localPruebaArray[0].getMec().equals(primerLocal.getMec()));
      	 assertTrue(localPruebaArray[1].getIdentificador().equals(segundoLocal.getIdentificador()));
     	 assertTrue(localPruebaArray[1].getPath().equals(segundoLocal.getPath()));
     	 assertTrue(localPruebaArray[1].getUrl().equals(segundoLocal.getUrl()));
     	 assertTrue(localPruebaArray[1].getMec().equals(segundoLocal.getMec()));
     	 
     	 //borro uno de ellos y pido con el mismo array...
     	 localizador.eliminarLocalizador(identificador);
     	 localPruebaArray = localizador.buscarLocalizadoresPorId(ids);
     	 assertTrue(localPruebaArray.length==1);
     	 localizador.eliminarLocalizador(ids[0]);
//      	try 
//    	{
//      		localPrueba=localizador.buscarLocalizadoresPorId());
//    	}
//    	catch (ConsultaLocalizadorException e) 
//    	{
//    		assertTrue(true);
//    	}
     }
     
     public void testeliminarLocalizacion() throws CreaLocalizadorNoPublicadoException, EliminaLocalizadorException, ConsultaLocalizadorException
     {
    	 String identificador 	= "uuid "+new String(new Long(System.currentTimeMillis()).toString());
    	 usuario  				= "Usuario "+new String(new Long(System.currentTimeMillis()).toString());
    	 uuid 					= "uuid "+new String(new Long(System.currentTimeMillis()).toString());
    	     	 
    	 SrvLocalizadorService localizador =this.servicio;
    	 
    	 //lo creo
    	 LocalizadorVO localPrueba = localizador.crearLocalizadorNoPublicado(usuario, uuid);
    	 
    	    	 
    	 //lo consulto y si da Null es que lo ha borrado bien de la BBDD
    	 try 
    	 {
    		 localPrueba=localizador.consultaLocalizador(identificador);
    	 } 
    	 catch (ConsultaLocalizadorException e) 
    	 {
    		 assertTrue(true);
    	 }
    	     	 
    	 //compruebo que se borra del fichero
    	 
    	 String Path= localPrueba.getPath();
    	 
    	 
    	 // lo borramos
       	
       	 try 
     	 {
       		localizador.eliminarLocalizador(identificador);
       	 	localPrueba=localizador.consultaLocalizador(identificador);
       	    File ficheroPrueba= new File(Path);
       	    assertFalse(ficheroPrueba.exists());
       	 	assertNull(localPrueba);
     	 }
     	 catch (ConsultaLocalizadorException e) 
     	 {
     		assertTrue(true);
     	 }
    	    	 
     }
     
     public Long testconsultaEspacioLocalizador(){
    	 SrvLocalizadorService localizador =this.servicio;
    	 Long tamaino=localizador.consultaEspacioLocalizador("ODE-3fda92bd-1a70-31a0-abf9-9fbdd60fd636");
    	 return tamaino;
     }
     
     private String getDirectorioFecha()
     {
     	String sFecha = "";
     	try
     	{
 	    	// Se va a localizar por fecha
 			SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
 			Date fecha = new Date();
 			sFecha = sdf.format(fecha);
 			sFecha = "/" + sFecha;
     	}
     	catch (Exception ex)
     	{
     		logger.error(ex);
     	}
     	return sFecha;
     	
     }
     
     
}
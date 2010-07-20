/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/

// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.modificador.negocio.servicio;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.activation.DataHandler;

import net.sf.dozer.util.mapping.MapperIF;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.pode.modificador.negocio.cambios.configuracion.ConfiguracionDao;
import es.pode.modificador.negocio.cambios.configuracion.GeneradorTaxonomias;
import es.pode.modificador.negocio.cambios.configuracion.ModificadorProperties;
import es.pode.modificador.negocio.cambios.configuracion.castor.ModificationTask;
import es.pode.modificador.negocio.servicio.vo.CambioTypes;
import es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea;
import es.pode.modificador.negocio.servicio.vo.FormularioModificarVO;
import es.pode.modificador.negocio.utilidades.EstadosTarea;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.SCORM2004Dao;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;

/**
 * @see SrvHerramientaModificacionImpl
 * TODO: To execute test on services that invoke webservices which implement security,
 * you must include the next param to the java virtual machine:
 * -Daxis.ClientConfigFile=client-config.wsdd
 */
public class TestSrvHerramientaModificacionImpl
    extends SrvHerramientaModificacionImplBase
{
	private static final String TEST_XML2 = "/odes/es_20070727_2_0130101/imsmanifest.xml";
	private static final String TEST_XML1 = "/xmls/test-configuracion-tareas.xml";
	private static final String TEST_XML3 = "/xmlsTest/test-configuracion-tareas.xml";
	private SCORM2004Dao dao = null;
	private ModificadorProperties props = null;
	private MapperIF mapper = null;
	private ConfiguracionDao daoC = null;
	private static ClassPathXmlApplicationContext context = null;
	private GeneradorTaxonomias generadorTaxonomias=null;

    /**
	 * @return the generadorTaxonomias
	 */
	public GeneradorTaxonomias getGeneradorTaxonomias()
	{
		return generadorTaxonomias;
	}

	/**
	 * @param generadorTaxonomias the generadorTaxonomias to set
	 */
	public void setGeneradorTaxonomias(GeneradorTaxonomias generadorTaxonomias)
	{
		this.generadorTaxonomias = generadorTaxonomias;
	}

	/**
     * Constructor
     */
     public TestSrvHerramientaModificacionImpl(){
		super();
		try {
		if(context==null) {
			context = new ClassPathXmlApplicationContext(getConfigLocations());
		}
		if(mapper==null) {
			mapper = (MapperIF)context.getBean("beanMapper");
		}
		if(daoC==null) {
			daoC = (ConfiguracionDao)context.getBean("configuracionDao");
		}
		if(generadorTaxonomias==null) {
			generadorTaxonomias = (GeneradorTaxonomias) context.getBean("generadorTaxonomias");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
     * 	 En el caso de tener que el metodo ${operation.name} acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvHerramientaModificacionImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */	
     public void testInicial(){
		String prueba = "";
		this.initAthenticationUser("alberto", "alberto"); 
		assertNotNull(prueba);
	}
	
	
    /**
     *   TEST obtenerTipos
     *   TODO: Implementar el test para el metodo obtenerTipos del servicio SrvHerramientaModificacion.
     * 	 En el caso de tener que el metodo obtenerTipos acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvHerramientaModificacionImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testobtenerTipos() {
		CambioTypes tipos = this.servicio.obtenerTipos();
		assertNotNull("No se recibieron Tipos de Modificacion",tipos);
		assertNotNull("No hay literales",tipos.literals());
		assertTrue("No contiene ADD_LOMES",tipos.literals().contains(CambioTypes.ADD_LOMES));
		assertTrue("No contiene CHECK_LOMES",tipos.literals().contains(CambioTypes.CHECK_LOMES));
		assertTrue("No contiene ELIMINAR_LOMES",tipos.literals().contains(CambioTypes.ELIMINAR_LOMES));
		assertTrue("No contiene MODIFICAR_LOMES",tipos.literals().contains(CambioTypes.MODIFICAR_LOMES));
    }

    /**
     *   TEST configurar
     *   TODO: Implementar el test para el metodo configurar del servicio SrvHerramientaModificacion.
     * 	 En el caso de tener que el metodo configurar acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvHerramientaModificacionImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     
     //probado
     public void testconfigurar() 
     {
    	InputStream is = this.getClass().getResourceAsStream(TEST_XML1);
    	//nombre que existe
    	String nombre="Prueba2";
    	
    	//nombre que NO existe
//    	String nombre="Noexiste";
    	
 		if(is== null) {
 			fail("No se ha podido leer el xml de configuracion de tareas " + TEST_XML1);
 		}
 		ModificationTask task=null;
 		try {
 			task = daoC.leerConfiguracion(is);
 			ConfiguracionTarea configuracion = (ConfiguracionTarea)mapper.map(task, ConfiguracionTarea.class);
 			Long config = this.servicio.configurar(null, configuracion,nombre);
 			assertNotNull("El resultado tiene valores",config);
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 			fail("Fallo en la lectura de " + TEST_XML1);
 		}
		
 		
    }

    /**
     *   TEST validar
     *   TODO: Implementar el test para el metodo validar del servicio SrvHerramientaModificacion.
     * 	 En el caso de tener que el metodo validar acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvHerramientaModificacionImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testvalidar() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST obtenerModificacionesConfiguradas
     *   TODO: Implementar el test para el metodo obtenerModificacionesConfiguradas del servicio SrvHerramientaModificacion.
     * 	 En el caso de tener que el metodo obtenerModificacionesConfiguradas acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvHerramientaModificacionImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     //probado
     public void testobtenerModificacionesConfiguradas() {
 		ModificacionVO[] modificaciones=this.servicio.obtenerModificacionesConfiguradas();
		assertNotNull("No se encontró modificaciones configuradas",modificaciones);
		assertEquals("El título de la modificacion es el esperado",modificaciones[0].getNombre(),"Prueba2");
		assertEquals("La tarea no está CONFIGURADA",modificaciones[0].getResultado(), EstadosTarea.CONFIGURADA);
    }

    /**
     *   TEST obtenerModificacion
     *   TODO: Implementar el test para el metodo obtenerModificacion del servicio SrvHerramientaModificacion.
     * 	 En el caso de tener que el metodo obtenerModificacion acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvHerramientaModificacionImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     //probada
     public void testobtenerModificacion() {
		Long idModificacion = new Long(1);
		ModificacionVO modificacion=this.servicio.obtenerModificacion(idModificacion);
		assertNotNull("se encontró Modificación con id = "+idModificacion,modificacion);
		assertEquals("El título de la modificacion es el esperado",modificacion.getNombre(),"Prueba");
		assertEquals("La tarea está CONFIGURADA",modificacion.getResultado(), EstadosTarea.CONFIGURADA);
    }

    /**
     *   TEST recuperarResultadoODE
     *   TODO: Implementar el test para el metodo recuperarResultadoODE del servicio SrvHerramientaModificacion.
     * 	 En el caso de tener que el metodo recuperarResultadoODE acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvHerramientaModificacionImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     * @throws ParseadorException 
     */
     
     //probado
     public void testrecuperarResultadoODE() 
     {
    	Long id = 1l;
    	Long idModificacion= new Long(1);
    	String path = "test/modificador/es_20070518_3_0041101/report.log";
    	File report = new File(path);
    	
    	try
		{
    		report.createNewFile();
        	PrintWriter fich= new PrintWriter(new FileWriter(report));
        	fich.print("texto");
        	fich.flush();
		ResultadoModificacionVO resultadoModificacion = this.servicio.recuperarResultadoODE(idModificacion, id);
		assertNotSame(resultadoModificacion.getTraza(), "");
		fich.close();
		}
    	catch (Exception e) {
			logger.error(e);
			fail("error al recuperar el resultado "+e);
		}

    }

    /**
     *   TEST restaurar
     *   TODO: Implementar el test para el metodo restaurar del servicio SrvHerramientaModificacion.
     * 	 En el caso de tener que el metodo restaurar acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvHerramientaModificacionImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     //probada
     public void testrestaurar() 
     {
    	Long idODE= 1l;
     	Long idModificacion= new Long(1);   
     	Boolean restaurado = this.servicio.restaurar(idModificacion, idODE);
     	assertEquals(restaurado.booleanValue(), true);
     }

    /**
     *   TEST ejecutarModificacion
     *   TODO: Implementar el test para el metodo ejecutarModificacion del servicio SrvHerramientaModificacion.
     * 	 En el caso de tener que el metodo ejecutarModificacion acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvHerramientaModificacionImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testejecutarModificacion() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST eliminarModificacion
     *   TODO: Implementar el test para el metodo eliminarModificacion del servicio SrvHerramientaModificacion.
     * 	 En el caso de tener que el metodo eliminarModificacion acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvHerramientaModificacionImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testeliminarModificacion() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST obtenerModificacionesEjecutadas
     *   TODO: Implementar el test para el metodo obtenerModificacionesEjecutadas del servicio SrvHerramientaModificacion.
     * 	 En el caso de tener que el metodo obtenerModificacionesEjecutadas acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvHerramientaModificacionImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     
     //probada
     public void testobtenerModificacionesEjecutadas() {
  		ModificacionVO[] modificaciones=this.servicio.obtenerModificacionesEjecutadas();
		assertNotNull("No se encontró modificaciones ejecutadas",modificaciones);
		assertEquals("El título de la modificacion es el esperado",modificaciones[0].getNombre(),"Prueba2");
		assertNotSame("La tarea no está FINALIZADA",modificaciones[1].getResultado(), EstadosTarea.FINALIZADA);
		assertEquals("La tarea está CONFIGURADA",modificaciones[0].getResultado(), EstadosTarea.FINALIZADA);
    }

    /**
     *   TEST obtenerResultadoModificacion
     *   TODO: Implementar el test para el metodo obtenerResultadoModificacion del servicio SrvHerramientaModificacion.
     * 	 En el caso de tener que el metodo obtenerResultadoModificacion acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvHerramientaModificacionImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     //PROBADO
     public void testobtenerResultadoModificacion() {
		ResultadoModificacionVO[] resultado=this.servicio.obtenerResultadoModificacion(new Long(1));
		assertNotNull("No se recuperó resultados",resultado);
		assertEquals("El path de Backup no es el esperado",resultado[0].getPathBackup(),"test/modificador/es_20070518_3_0041101");
		assertEquals("El path Original no es el esperado",resultado[0].getPathOriginal(),"test/modificador/es_20070518_3_0041101");
		assertEquals("El path de los Logs no es el esperado",resultado[0].getPathTraza(),"test/modificador/es_20070518_3_0041101");
		assertEquals("El estado de la tarea no es FINALIZADA", resultado[0].getStatus(),EstadosTarea.WARNING);
    }

    /**
     *   TEST importarModificacion
     *   TODO: Implementar el test para el metodo importarModificacion del servicio SrvHerramientaModificacion.
     * 	 En el caso de tener que el metodo importarModificacion acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvHerramientaModificacionImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     
     //probado
     public void testimportarModificacion() {
    	InputStream is = this.getClass().getResourceAsStream(TEST_XML1);
       if(is== null) {
   		fail("No se ha podido leer el xml de configuracion de tareas " + TEST_XML1);
   		}
   		ModificationTask task=null;
   		try {
   			task = daoC.leerConfiguracion(is);
   			ConfiguracionTarea tarea = (ConfiguracionTarea)mapper.map(task, ConfiguracionTarea.class);
   			DataHandler expTarea = this.servicio.exportarModificacion(tarea);
   			ConfiguracionTarea impTarea = this.servicio.importarModificacion(expTarea);
   			assertNotNull("El resultado tiene valores",impTarea);
  			
  		} catch (Exception e) {
  			e.printStackTrace();
  			fail("Fallo en la lectura de " + TEST_XML1);
  		}

    }

    /**
     *   TEST exportarModificacion
     *   TODO: Implementar el test para el metodo exportarModificacion del servicio SrvHerramientaModificacion.
     * 	 En el caso de tener que el metodo exportarModificacion acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvHerramientaModificacionImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     
     //probado
     public void testexportarModificacion() 
     {
    	InputStream is = this.getClass().getResourceAsStream(TEST_XML1);
  		if(is== null) {
  			fail("No se ha podido leer el xml de configuracion de tareas " + TEST_XML1);
  		}
  		ModificationTask task=null;
  		try {
  			task = daoC.leerConfiguracion(is);
  			ConfiguracionTarea tarea = (ConfiguracionTarea)mapper.map(task, ConfiguracionTarea.class);
  			DataHandler expTarea = this.servicio.exportarModificacion(tarea);
  			assertNotNull("El resultado tiene valores",expTarea);
  			
  		} catch (Exception e) {
  			e.printStackTrace();
  			fail("Fallo en la lectura de " + TEST_XML1);
  		}
 		
    	 
     }

     public void testsimularModificacion()
     {
    	InputStream is = this.getClass().getResourceAsStream(TEST_XML3);
      	Integer numeroOdes=new Integer(3);
      		
  		if(is== null) {
  			fail("No se ha podido leer el xml de configuracion de tareas " + TEST_XML3);
  		}
  		ModificationTask task=null;
  		java.net.URL url = this.getClass().getResource("/odes/folder/es_20070518_3_0041101");
  		if(url!=null)
  		{
  			File oldDir= new File(url.getFile());	
	  		File newDir=new File("odes/folder/17004__106_a_1");
	  		try {
	  			UtilesFicheros.copiar(oldDir, newDir);
	  			task = daoC.leerConfiguracion(is);
	  			ConfiguracionTarea configuracion = (ConfiguracionTarea)mapper.map(task, ConfiguracionTarea.class);
	  			ModificacionSimuladaVO simModif = this.servicio.simularModificacion(configuracion, numeroOdes);
	  			assertNotNull("El resultado tiene valores",simModif);
	  			newDir.exists();
	  			
	  		} 
	  		catch (Exception e) 
	  		{
	  			e.printStackTrace();
	  			fail("Fallo en la lectura de " + TEST_XML3);
	  		}
  		}
  		else
  		{
  			fail("no se ha encontrado el fichero requerido");
  		}
 		
     }
     public void testRecuperarPlantillaLomes()
     {
    	 
    	 String a = this.servicio.recuperarPlantillaLomes("5");
//    	 this.servicio.recuperarPlantillaLomes("4.1");
//    	 this.servicio.recuperarPlantillaLomes("3.2");
    	 assertNotSame(a, "");
     }
	
     public void testNavegarArbolCurricular()
     {
//    	 TaxonomiaVO tax = this.servicio.navegarArbolCurricular(null, "Arbol_Curricular_Agrega", "es");
//    	 TaxonomiaVO tax = this.servicio.navegarArbolCurricular(null, null, "es");
    	 TaxonomiaVO tax = this.servicio.navegarArbolCurricular("2","Arbol_Curricular_Agrega", "es");
    	 assertNotNull(tax.getNombreTaxonomia());
     }
     
     public void testObtenerFormularioModificar()
     {
//    	 FormularioModificarVO formulario = this.servicio.obtenerFormularioModificar("1.3");
    	 FormularioModificarVO formulario = this.servicio.obtenerFormularioModificar("4.1");
//    	 FormularioModificarVO formulario = this.servicio.obtenerFormularioModificar("5.4.2");
//    	 FormularioModificarVO formulario = this.servicio.obtenerFormularioModificar("4.5.1");
//    	 FormularioModificarVO formulario = this.servicio.obtenerFormularioModificar("7.2.1.1");
    	 assertNotNull(formulario);
     }
     
     public void testGeneradorTaxonomia()
     {
    	 
    	 TaxonomiaVO taxonomia = this.servicio.navegarArbolCurricular("2","Arbol_Curricular_Agrega", "es");
    	 String genTaxonomias = this.generadorTaxonomias.generarTaxonomia(taxonomia, 2);
    	 assertNotSame(genTaxonomias, "");
     }
     
     public void testNavegarLom() {
    	TerminoLomVO termino = servicio.navegarLom(null);
    	assertNotNull(termino);
    	assertEquals(9, termino.getHijos().length);
    	assertEquals(1, termino.getPadres().length);
    	termino = servicio.navegarLom("1");
    	assertNotNull(termino);
    	assertEquals(8, termino.getHijos().length);
    	assertEquals(2, termino.getPadres().length);
    	termino = servicio.navegarLom("4.1");
    	assertEquals(0, termino.getHijos().length);
    	assertEquals(3, termino.getPadres().length);
    	assertNotNull(termino);
    	termino = servicio.navegarLom("4.5.1");
    	assertEquals(0, termino.getHijos().length);
    	assertEquals(4, termino.getPadres().length);
    	assertNotNull(termino);
     }
	
     public void testnavegarTesauros() {
    	 String nombreTaxonomia = "ETB-LRE_MEC-CCAA_V.1.0";
    	 String idioma = "es";
    	 
    	 TaxonomiaVO taxonomia = null;
//    	 Obtener raiz del tesauro
    	 taxonomia = servicio.navegarTesauro(null, nombreTaxonomia, idioma);
    	 assertNotNull(taxonomia);
    	 assertNull(taxonomia.getJerarquia());
    	 assertNull(taxonomia.getTaxonPath());
    	 assertEquals(332, taxonomia.getHijos().length);
//    	 Obtener nodo con 1 ruta padre
    	 taxonomia = servicio.navegarTesauro("1370", nombreTaxonomia, idioma);
    	 assertNull(taxonomia.getJerarquia());
    	 assertNotNull(taxonomia.getTaxonPath());
    	 assertEquals(13, taxonomia.getHijos().length);
    	 assertEquals(3, taxonomia.getTaxonPath().length);
//    	 Obtener nodo con varias rutas padre
    	 taxonomia = servicio.navegarTesauro("303", nombreTaxonomia, idioma);
    	 assertNotNull(taxonomia.getJerarquia());
    	 assertNotNull(taxonomia.getTaxonPath());
    	 assertEquals(19, taxonomia.getHijos().length);
    	 assertEquals(2, taxonomia.getTaxonPath().length);
    	 assertEquals(3, taxonomia.getJerarquia().length);
    	 assertEquals("0.0", taxonomia.getTaxonPath()[0].getId());
     }
     
}
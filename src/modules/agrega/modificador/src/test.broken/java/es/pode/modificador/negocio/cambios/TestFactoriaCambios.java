/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.negocio.cambios;

import java.io.InputStream;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.pode.modificador.negocio.cambios.configuracion.ConfiguracionDao;
import es.pode.modificador.negocio.cambios.configuracion.castor.ModificationTask;
import es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;

import net.sf.dozer.util.mapping.MapperIF;
import junit.framework.TestCase;

public class TestFactoriaCambios extends TestCase {
	private static final String TEST_XML = "/xmls/test-configuracion-odes.xml";
	private static final String TEST_XML2 = "/xmls/test-configuracion-tareas.xml";
	private MapperIF mapper = null;
	private static ClassPathXmlApplicationContext context = null;
	private ConfiguracionDao dao = null;
	private FactoriaCambios factoria = null;
	
	public TestFactoriaCambios() {
		super();
		if(context==null) {
			context = new ClassPathXmlApplicationContext(new String[]{"testContext.xml","test-user-applicationContext.xml"});
		}
		if(mapper==null) {
			mapper = (MapperIF)context.getBean("beanMapper");
		}
		if(dao==null) {
			dao = (ConfiguracionDao)context.getBean("configuracionDao");
		}
		if(factoria==null) {
			factoria = (FactoriaCambios)context.getBean("factoriaCambios");
		}
	}

	protected void setUp() throws Exception {
		super.setUp();
		java.net.URL carpetaOdes = this.getClass().getResource("/odes");
		if(carpetaOdes==null) {
			fail("No se encuentra la carpeta de odes");
		}
		java.io.File carpetaTest=new java.io.File("odes");
		if(!carpetaTest.isDirectory()) assertTrue(carpetaTest.mkdirs());
		UtilesFicheros.copiar(new java.io.File(carpetaOdes.getPath()),carpetaTest);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		java.io.File carpetaTest=new java.io.File("odes");
		if(carpetaTest.exists()) UtilesFicheros.eliminar(carpetaTest);
	}

	public void testGenerarTareaCambios() 
	{
		InputStream is = this.getClass().getResourceAsStream(TEST_XML2);
		if(is== null) {
			fail("No se ha podido leer el xml de configuracion de tareas " + TEST_XML2);
		}
		ModificationTask task=null;
		try {
			task = dao.leerConfiguracion(is);
			ConfiguracionTarea vo = (ConfiguracionTarea)mapper.map(task, ConfiguracionTarea.class);
			factoria.generarTareaCambios(vo, "tareaTest/");
			assertNotNull("El resultado de obtenerODEs ha sido null",vo);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Fallo en la lectura de " + TEST_XML);
		}
		
	}

	public void testObtenerODEs() {
		// Leo la configuracion de tareas para el test
		InputStream is = this.getClass().getResourceAsStream(TEST_XML);
		if(is== null) {
			fail("No se ha podido leer el xml de configuracion de tareas " + TEST_XML);
		}
		ModificationTask task=null;
		try {
			task = dao.leerConfiguracion(is);
			ConfiguracionTarea vo = (ConfiguracionTarea)mapper.map(task, ConfiguracionTarea.class);
			ODE[] odes = factoria.obtenerODEs(vo.getObjetos(), "tareaTest/", false);
			assertNotNull("El resultado de obtenerODEs ha sido null",odes);
			assertEquals("El numero de odes no es el esperado",4, odes.length);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Fallo en la lectura de " + TEST_XML);
		} finally {
			try {
				is.close();
			} catch (Exception e) {
				// No hacer nada
			}
		}
		
	}

}

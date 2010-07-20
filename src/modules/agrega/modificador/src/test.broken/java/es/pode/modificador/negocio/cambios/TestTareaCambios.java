/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.negocio.cambios;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import junit.framework.TestCase;
import net.sf.dozer.util.mapping.MapperIF;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.pode.modificador.negocio.cambios.configuracion.ConfiguracionDao;
import es.pode.modificador.negocio.cambios.configuracion.castor.ModificationTask;
import es.pode.modificador.negocio.servicio.vo.ConfiguracionTarea;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;

public class TestTareaCambios extends TestCase {

	private MapperIF mapper = null;
	private static ClassPathXmlApplicationContext context = null;
	private ConfiguracionDao dao = null;
	private FactoriaCambios factoria = null;
	private static final String basePath = "test/modificador/";
	
	public TestTareaCambios(String name) {
		super(name);
		if(context==null) {
			context = new ClassPathXmlApplicationContext(new String[]{"testContext.xml","user-applicationContext.xml"});
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
		File test = new File(basePath);
		if(!test.mkdirs() && !test.exists()) fail("No se ha podido crear la carpeta de tests");
		File odes = new File("odes");
		if(!odes.mkdirs() && !odes.exists()) fail("No se ha podido crear la carpeta de tests");
		URL folder = this.getClass().getResource("/odes");
		if(folder==null) fail("No se ha podido leer la carpeta de odes en test-resources");
		UtilesFicheros.copiar(new File(folder.getFile()), odes);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		UtilesFicheros.eliminar(new File("odes"));
		UtilesFicheros.eliminar(new File(basePath));
	}

	public void testejecutarNoSimulada() {
		// Recupera XML configuracion
		InputStream is = this.getClass().getResourceAsStream("/xmls/test-ejecucion-tarea.xml");
		if(is==null) fail("No se pudo abrir el XML de tarea");
		try {
			ModificationTask task = dao.leerConfiguracion(is);
			ConfiguracionTarea config = (ConfiguracionTarea)mapper.map(task, ConfiguracionTarea.class);
			TareaCambios tc = factoria.generarTareaCambios(config, basePath);
			long a = System.currentTimeMillis();
			tc.ejecutarTarea();
			long b = System.currentTimeMillis();
			long c = System.currentTimeMillis();
			long time = (b-a)-(c-b);
			
			System.out.println("Tarea terminada. Tiempo = " + time/1000f);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error inesperado : " + e.getMessage());
		}
	}
	
	public void testejecutarSimulada() 
	{
//		 Recupera XML configuracion
		InputStream is = this.getClass().getResourceAsStream("/xmls/test-ejecucion-tarea.xml");
		if(is==null) fail("No se pudo abrir el XML de tarea");
		try {
			ModificationTask task = dao.leerConfiguracion(is);
			ConfiguracionTarea config = (ConfiguracionTarea)mapper.map(task, ConfiguracionTarea.class);
			TareaCambios tc = factoria.generarTareaCambios(config, basePath);
			long a = System.currentTimeMillis();
			tc.ejecutarTarea(true);
			long b = System.currentTimeMillis();
			long c = System.currentTimeMillis();
			long time = (b-a)-(c-b);
			
			System.out.println("Tarea terminada. Tiempo = " + time/1000f);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error inesperado : " + e.getMessage());
		}
	}
}

/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.negocio.cambios;

import junit.framework.TestCase;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import es.pode.soporte.utiles.ficheros.UtilesFicheros;

public class TestValidacionManifest extends TestCase {
	
	private static Logger logger = Logger.getLogger(TestValidacionManifest.class);
	private static final String TEST_FOLDER = "tests";
	private static final String TEST_ODE1= "/odes/folder/es_20070518_3_0041101";
	private static final String TEST_ODE_ERRONEO= "/odes/es_20070727_2_0130101_erroneo";
	
	public TestValidacionManifest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		// Creo una carpeta para los tests
		java.io.File test = new java.io.File(TEST_FOLDER);
		if(!test.exists()) {
			if(!test.mkdirs()) fail("No se ha podido crear la carpeta de test " + test.getPath());
		}
		// Copio el ode de tests a la carpeta de tests
		copiarTestOde(test, TEST_ODE1);
		copiarTestOde(test, TEST_ODE_ERRONEO);
	}

	private void copiarTestOde(java.io.File test, String odePath) throws Exception {
		java.io.File destino = new java.io.File(test,odePath);
		if(!destino.mkdirs()) fail("No se ha podido copiar el ode de test a la carpeta de test");
		java.net.URL ode = this.getClass().getResource(odePath);
		if(ode==null) fail("No se ha encontrado el ode de test " + odePath);
		UtilesFicheros.copiar(new java.io.File(ode.getFile()), destino);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		java.io.File test = new java.io.File(TEST_FOLDER);
		if(test.exists()) UtilesFicheros.eliminar(test);
	}

	public void testejecutar() {
		ValidacionManifest validacion = new ValidacionManifest();
		try {
			Layout layout = new PatternLayout("%p - %m%n");
			FileAppender app = new FileAppender(layout,TEST_FOLDER+"/report.log");

			app.setThreshold(Level.INFO);
			app.setImmediateFlush(true);
			app.setAppend(false);
			java.io.File folder = new java.io.File(TEST_FOLDER + TEST_ODE1);
			if(!folder.isDirectory()) fail("No existe la carpeta del ODE");
			boolean resultado = validacion.ejecutar(null, app, folder.getCanonicalPath());
			assertTrue("Validacion erronea", resultado);
			
			FileAppender app2 = new FileAppender(layout,TEST_FOLDER+"/report_error.log");

			app2.setThreshold(Level.INFO);
			app2.setImmediateFlush(true);
			app2.setAppend(false);
			folder = new java.io.File(TEST_FOLDER + TEST_ODE_ERRONEO);
			if(!folder.isDirectory()) fail("No existe la carpeta del ODE");
			resultado = validacion.ejecutar(null, app2, folder.getCanonicalPath());
			assertFalse("Validacion erronea", resultado);
		} catch (Exception e) {
			logger.error(e);
			fail("Error inesperado");
		}
	}
}

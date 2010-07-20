/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Properties;

import junit.framework.TestCase;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;

//import es.pode.parseadorXML.lomesAgrega.LomAgrega;

public class LomEsDaoTest extends TestCase {

	private LomESDao dao = null;

	private Properties properties = null;

	private Logger logger = Logger.getLogger(this.getClass());

	public LomEsDaoTest() {
		super();
		try {
			this.properties = new Properties();
			this.dao = SpringBootstrapContextLoader.getLomesDao();
			InputStream is = this.getClass().getResourceAsStream(
					"/parseadorXML.properties");
			properties.load(is);
		} catch (IOException e) {
			logger.error("No se pudo abrir el fichero de propiedades; ", e);
		} catch (Exception e) {
			logger.error("Error en el constructor del test: ", e);
			fail("Error en la construccion del test : " + e.getMessage());
		}
	}

	protected void setUp() throws Exception {
		super.setUp();

	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testParsearLom() {
		try {
			String manifestName = getManifestTestName();
			java.net.URL url = this.getClass().getResource(manifestName);

			//File file = new File(url.getFile());
			File file = new File("D:/ParaParsear.xml");
			String fichero = "";
			try {
				fichero = FileUtils.readFileToString(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			es.pode.parseadorXML.lomes.Lom lom = this.getDao().parsearLom(
//					file);
			es.pode.parseadorXML.castor.Lom lom = null;

			lom = this.getDao().parsearLom(
					new InputSource(new StringReader(fichero)));

			
			assertNotNull(lom);
		


			// TODO Hacer Asserts de los contenidos del Lom
		} catch (ParseadorException e) {
			logger.error("Error de parseo: ", e);
			fail("Excepcion de parseo" + e.getMessage());
		}
	}

	public void testEscribirLom() {
		try {
			String manifestName = getManifestTestName();
			String manifestTarget = getLomSalida();
			java.net.URL url = this.getClass().getResource(manifestName);

			//File file = new File(url.getFile());
			File file = new File("D:/metadatoLote1.xml");

			es.pode.parseadorXML.castor.Lom lom = this.getDao().parsearLom(
					file);
//			LomAgrega la = new LomAgrega();
//			la.setLomItem(lom.getLomItem());
//			la.getGeneralAgrega().setTitulo("es",
//					"Lomes modificado para JUnit tests");
			//java.io.File salida = new java.io.File(manifestTarget);
			java.io.File salida = new java.io.File("D:/salida.xml");
			this.getDao().escribirLom(lom, salida);
			assertTrue("Fichero generado", salida.isFile());
			assertTrue("Tamaño mayor que 0 : ", salida.length() > 0);
		} catch (Exception e) {
			logger.error(e);
			fail(e.getMessage());
		}
	}

	private String getManifestTestName() {

		return "/" + this.properties.getProperty("test.lomes");
	}

	private String getLomSalida() {

		return "/" + this.properties.getProperty("test.lomes_salida");
	}

	public LomESDao getDao() {
		return dao;
	}

	public void setDao(LomESDao dao) {
		this.dao = dao;
	}
}

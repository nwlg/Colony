/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.parseadorXML;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega;
import es.pode.parseadorXML.castor.Manifest;
import es.pode.parseadorXML.scorm2004.agrega.ManifestAgrega;

public class SCORM2004DaoTest extends TestCase {

	private SCORM2004Dao dao = null;

	private ClassPathXmlApplicationContext context = null;

	private Properties properties = null;

	private Logger logger = Logger.getLogger(this.getClass());

	public SCORM2004DaoTest() {
		super();
		this.context = new ClassPathXmlApplicationContext(
				"parseadorXML-applicationContext.xml");
		this.dao = (SCORM2004Dao) this.context.getBean("scorm2004Dao",
				SCORM2004Dao.class);
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
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testParsearODELazy() {
		try {
//			java.net.URL url = this.getClass().getResource("/imsmanifest.xml");
//			if (url != null) {
				File imsmanifestPath = new File("C:/temp/imsmanifest_apostrofe.xml");
				Manifest manifest = this.getDao().parsearODELazy(
						imsmanifestPath);

				// Prueba de escritura
				getDao().escribirODE(manifest, "C:/temp/imsmanifest_apostrofe_cambiado.xml");
				
				ManifestAgrega ma = new ManifestAgrega(manifest);
				
				Lom lomes = ma.obtenerLom(manifest.getIdentifier(), null);
			
				LomAgrega la = new LomAgrega(lomes);
				try {
					la.getGeneralAgrega().addTituloIdioma("en", "Title added during unit test");
				} catch (Exception e) {
					e.printStackTrace();
					fail(e.getMessage());
				}
				ma.setLom("ORG-682af611-5cd2-3bae-a422-903425344809", null, lomes);
				this.getDao().escribirODE(manifest, "D:/test_parseador.xml");
				
				assertEquals("Identificador : ", manifest.getIdentifier(),
						"MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8");
				assertEquals("Recursos : ", 1, manifest.getResources()
						.getResource().length);
				assertEquals("Submanifiestos : ", 1,
						manifest.getManifest().length);

//			}

		} catch (ParseadorException e) {
			logger.error("Error de parseo: ", e);
			fail("Excepcion de parseo" + e.getMessage());
		}
	}

	public void testParsearODEEager() {
		try {
			java.net.URL url = this.getClass().getResource("/imsmanifest.xml");
			if (url != null) {
				File imsmanifestPath = new File(url.getFile());
				Manifest manifest = this.getDao().parsearODELazy(
						imsmanifestPath);
				assertEquals("Identificador : ", manifest.getIdentifier(),
						"MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8");
				assertEquals("Recursos : ", 1, manifest.getResources()
						.getResource().length);
				assertEquals("Submanifiestos : ", 1,
						manifest.getManifest().length);

			}

		} catch (ParseadorException e) {
			logger.error("Error de parseo: ", e);
			fail("Excepcion de parseo" + e.getMessage());
		}
	}

	public void testEscribirODE() {
		try {

			java.net.URL url = this.getClass().getResource("/imsmanifest.xml");
			if (url != null) {
				File imsmanifestPath = new File(url.getFile());
				// Parseamos el manifiesto para poder escribirlo:
				Manifest manifest = getDao().parsearODELazy(imsmanifestPath);
				manifest.setIdentifier("IDENTIFICADORMODIFICADO");
				manifest.removeAllManifest();
				// Escribo el manifest
				File ficheroDestino = new File("d:/salida.xml");
				getDao().escribirODE(manifest, ficheroDestino);
				assertTrue("El fichero existe ", ficheroDestino.exists());
				assertTrue("El tamaño es mayor que 0 bytes ", ficheroDestino
						.length() > 0);
				// Borro el fichero de salida
				ficheroDestino.delete();
			}
		} catch (Exception e) {
			logger.error("Error en testEscribirODE", e);
			fail("Excepcion capturada : " + e.getClass() + " : "
					+ e.getMessage());
		}
	}

	public SCORM2004Dao getDao() {
		return dao;
	}

	public void setDao(SCORM2004Dao dao) {
		this.dao = dao;
	}

	private String getManifestTestName() {

		return this.properties.getProperty("test.manifest");
	}
}

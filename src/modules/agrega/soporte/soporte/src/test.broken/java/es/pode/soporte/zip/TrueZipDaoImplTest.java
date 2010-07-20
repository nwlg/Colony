/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.zip;

import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import junit.framework.TestCase;
import de.schlichtherle.io.ArchiveException;
import de.schlichtherle.io.File;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;

public class TrueZipDaoImplTest extends TestCase {

	private static Properties props = null;

	private final static String TEST_ZIP = "zip/test.zip";

	private final static String TEST_ENTRY = "imsmanifest.xml";

	private final static String TEST_CARPETA = "contenidos";

	private final static String TEST_NEW_ZIP = "zip/newZip.zip";

	private static String carpetaTest = null;

	private static Log logger = LogFactory.getLog(TrueZipDaoImplTest.class);

	public TrueZipDaoImplTest(String arg0) {
		super(arg0);
		// Cargar propiedades del test
		if (props == null) {
			props = new Properties();
			InputStream is = this.getClass().getResourceAsStream(
					"/test.properties");
			if (is == null) {
				fail("No se han podido cargar las propiedades del test");
			} else {
				try {
					props.load(is);
					carpetaTest = props.getProperty("zipDao.test.folder");
					logger.info("Carpeta de test recuperada : " + carpetaTest);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	protected void setUp() throws Exception {
		super.setUp();
		// Crear carpeta de tests:
		if(carpetaTest == null ) fail("No se han cargado las propiedades del test");
		java.io.File carpeta = new java.io.File("./" + carpetaTest);
		logger.debug("Creando carpetas de tests en : "
				+ carpeta.getCanonicalPath());
		if (!carpeta.exists()) {
			boolean resultado = carpeta.mkdirs();
			if (!resultado)
				fail("No se pudo crear la carpeta de test");
		}
		// Copia los test-resources a la carpeta de test creada
		java.net.URL url = this.getClass().getResource("/carpeta-test");
		if (url == null)
			fail("No se encuentran los recursos de src/test-resources");
		String path = url.getPath();
		UtilesFicheros.copiar(new java.io.File(path), carpeta);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		// Elimino la carpeta de tests

		java.io.File carpeta = new java.io.File("./" + carpetaTest);
		UtilesFicheros.eliminar(carpeta);
	}

	// FUNCIONA
	public void testChequearEntrada() throws ZipDaoException {
		String entrada = TEST_ENTRY;

		String archivo = carpetaTest + "/" + TEST_ZIP;
		TrueZipDaoImpl dao = new TrueZipDaoImpl();
		boolean chequeo = dao.chequearEntrada(entrada, archivo);
		assertTrue(chequeo);
	}

	// FUNCIONA
	public void testComprimir() throws ZipDaoException {

		String rutaOrigen = carpetaTest + "/" + TEST_CARPETA;
		String rutaArchivo = carpetaTest + "/" + TEST_NEW_ZIP;

		TrueZipDaoImpl dao = new TrueZipDaoImpl();

		dao.comprimir(rutaArchivo, rutaOrigen);
		java.io.File nuevoZip = new java.io.File(rutaArchivo);
		assertTrue(nuevoZip.exists());
	}

	// FUNCIONA
	public void testDescomprimir() throws ZipDaoException {
		String rutaArchivo = carpetaTest + "/" + TEST_ZIP;
		String rutaDestino = carpetaTest;
		TrueZipDaoImpl dao = new TrueZipDaoImpl();

		dao.descomprimir(rutaArchivo, rutaDestino);

		java.io.File contenido = new java.io.File(carpetaTest + "/"
				+ "imsmanifest.xml");
		assertTrue( "Assert " + contenido.getPath(),contenido.exists());
		contenido = new java.io.File(carpetaTest + "/carpeta/imsmanifest.xml");
		assertTrue("Assert " + contenido.getPath(), contenido.exists());
	}

	// FUNCIONA
	public void testEsZip() throws ZipDaoException {
		String archivo = carpetaTest + "/" + TEST_ZIP;

		TrueZipDaoImpl dao = new TrueZipDaoImpl();
		boolean zip = dao.esZip(archivo);
		assertTrue(zip);

	}

	// FUNCIONA
	public void testExtraerFichero() {

		String archivo = carpetaTest + "/" + TEST_ZIP;

		// descomentar si se quiere carpeta
		String fichero = TEST_ENTRY;

		// descomentar si se quiere fichero
		// String fichero="imsmanifestold.xml";

		String destino = carpetaTest;
		TrueZipDaoImpl dao = new TrueZipDaoImpl();

		dao.extraerFichero(fichero, archivo, destino);

		java.io.File destino2 = new java.io.File(destino, fichero);
		assertTrue(destino2.exists());

	}

	public void testComprimirSeleccionando() {
		String rutaOrigen = carpetaTest + "/" + TEST_CARPETA;
		String rutaArchivo = carpetaTest + "/" + TEST_NEW_ZIP;

		String[] exclude = new String[1];

		exclude[0] = TEST_ENTRY;

		TrueZipDaoImpl dao = new TrueZipDaoImpl();
		try {
			dao.comprimir(rutaArchivo, rutaOrigen, exclude);
			File rutaD = new File(rutaArchivo + "/" + exclude[0]);
			assertFalse(rutaD.exists());
		} catch (Exception e) {
			logger.error("Traza del error obtenido al comprimir: ",e);
			assertEquals(e.getMessage(), "no existe el fichero a excluir");
			
		} finally {
			try {
				File.umount(true);
			} catch (ArchiveException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

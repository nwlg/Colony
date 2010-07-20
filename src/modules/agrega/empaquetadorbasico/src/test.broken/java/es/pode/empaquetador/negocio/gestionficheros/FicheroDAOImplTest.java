/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.empaquetador.negocio.gestionficheros;

import java.io.File;

import junit.framework.TestCase;

/**
 * @author fjespino
 *
 */
public class FicheroDAOImplTest extends TestCase {
	private FicheroDaoImpl dao = new FicheroDaoImpl();
	
	/**
	 * @param arg0
	 */
	public FicheroDAOImplTest(String arg0) {
		super(arg0);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link es.pode.empaquetador.negocio.gestionficheros.FicheroDAOImpl#cargar(es.pode.empaquetador.negocio.gestionficheros.Fichero)}.
	 */
	public void testCargar() {
		fail("Not yet implemented");
	}
	
	/**
	 * Test method for {@link es.pode.empaquetador.negocio.gestionficheros.FicheroDAOImpl#cargar(es.pode.empaquetador.negocio.gestionficheros.Fichero)}.
	 */
	public void testCrearCarpeta() {
		String arg1 = "c:/windows/temp";
		String arg2 = "";
		try {
			dao.crearCarpeta(arg1, arg2);
		} catch (FicheroException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File prueba = new File (arg1 + "/" + arg2);
		assertTrue(prueba.exists());
		
		//nota: esto creará carpetas en c:/windows/temp 
	}

	/**
	 * Test method for {@link es.pode.empaquetador.negocio.gestionficheros.FicheroDAOImpl#almacenar(es.pode.empaquetador.negocio.gestionficheros.Fichero)}.
	 */
	public void testAlmacenar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link es.pode.empaquetador.negocio.gestionficheros.FicheroDAOImpl#eliminar(es.pode.empaquetador.negocio.gestionficheros.Fichero)}.
	 */
	public void testEliminar() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link es.pode.empaquetador.negocio.gestionficheros.FicheroDAOImpl#toFicheroVO()}.
	 */
	public void testToFicheroVO() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link es.pode.empaquetador.negocio.gestionficheros.FicheroDAOImpl#fromFicheroVO(es.pode.empaquetador.negocio.servicio.FicheroVO)}.
	 */
	public void testFromFicheroVO() {
		fail("Not yet implemented");
	}

	public FicheroDaoImpl getDao() {
		return dao;
	}

	public void setDao(FicheroDaoImpl dao) {
		this.dao = dao;
	}

}

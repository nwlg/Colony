/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.empaquetador.negocio.servicio;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import es.pode.localizador.negocio.servicios.LocalizadorVO;
import es.pode.localizador.negocio.servicios.SrvLocalizadorService;
import es.pode.localizador.negocio.servicios.SrvLocalizadorServiceService;
import es.pode.localizador.negocio.servicios.SrvLocalizadorServiceServiceLocator;
import es.pode.soporte.constantes.ConstantesAgrega;

/**
 * @see SrvFachadaAgregarServiceImpl
 * TODO: To execute test on services that invoke webservices which implement security,
 * you must include the next param to the java virtual machine:
 * -Daxis.ClientConfigFile=client-config.wsdd
 */
public class TestSrvFachadaAgregarServiceImpl
    extends SrvFachadaAgregarServiceImplBase
{

    private SrvLocalizadorService localizador = null;
//	private SrvFachadaAgregarService fachada = null;

    /**
     * Constructor
     */
     public TestSrvFachadaAgregarServiceImpl(){
		super();
		try {
			SrvLocalizadorServiceService localizadorLocator = new SrvLocalizadorServiceServiceLocator();
			localizador = localizadorLocator.getSrvLocalizadorService();
		} catch (ServiceException e) {
			logger.error("No se ha podido obtener una referencia al servicio localizador. " , e);
			fail("No se ha podido obtener una referencia al servicio de localizador.");
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
     * 	 {@link es.indra.servicios.SrvFachadaAgregarServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */	
     public void testInicial(){
		String prueba = null;
		this.initAthenticationUser("usuario", "ibuilder"); 
		assertNotNull(prueba);
	}
	
	
    /**
     *   TEST agregar
     *   TODO: Implementar el test para el metodo agregar del servicio SrvFachadaAgregarService.
     * 	 En el caso de tener que el metodo agregar acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvFachadaAgregarServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testagregar() {
		String prueba = null; 
		assertNotNull(prueba);

    }

	public void testAnalizar() {
		String ruta="";
		//Fichero, esperamos FICHERO
		try {
			ruta = this.applicationContext.getResource("/ncarpeta/atardecer.jpg").getFile().getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		AnalizaArchivoVO resultado=servicio.analizarArchivo(ruta);
		assertNotNull(resultado);
		assertEquals(resultado.getTipoArchivo(),ConstantesAgrega.FICHERO);
		// Ode, esperamos CA
		try {
			ruta = this.applicationContext.getResource("sd02_oa04_actividad_campanias_publicitarias.zip").getFile().getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		resultado=servicio.analizarArchivo(ruta);
		assertNotNull(resultado);
		assertEquals(resultado.getTipoArchivo(),ConstantesAgrega.CA);
		// Archivo ZIP, espera ARCHIVO
		try {
			ruta = this.applicationContext.getResource("material.zip").getFile().getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		resultado=servicio.analizarArchivo(ruta);
		assertNotNull(resultado);
		assertEquals(resultado.getTipoArchivo(),ConstantesAgrega.ARCHIVO);
		//RCP, espera RCP
		try {
			ruta = this.applicationContext.getResource("recurso_ejemplo.zip").getFile().getAbsolutePath();
		} catch (IOException e) {
			e.printStackTrace();
		}
		resultado=servicio.analizarArchivo(ruta);
		assertNotNull(resultado);
		assertEquals(resultado.getTipoArchivo(),ConstantesAgrega.RCP);
	}
	
	public void testGenerarManifest() {
		String idioma="es";
		String identificador="prueba";
		String href="ncarpeta/atardecer.jpg";
		String[] files= new String[]{"ncarpeta/atardecer.jpg"};
		servicio.generarManifest(identificador, files, href, idioma);
		try {
			LocalizadorVO localizador = this.localizador.consultaLocalizador(identificador);
			String path=localizador.getPath();
			assertNotNull(path);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testGenerarManifestRCP() {
		String idioma="es";
		String identificador="prueba";
		servicio.generarManifestRCP(identificador, idioma);
		try {
			LocalizadorVO localizador = this.localizador.consultaLocalizador(identificador);
			String path=localizador.getPath();
			assertNotNull(path);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void testGenerarManifestLom() {
		String idioma="es";
		String identificador="prueba";
		String href="http://proyectoagrega.es/";
		String titulo=href;
		String descripcion="";
		String idiomaDestinatario="es";
		String tipo="thematic or corporate webs/web portals";
		
		servicio.generarManifestLom(identificador, null, href, idioma, titulo, descripcion, idiomaDestinatario, tipo);
		try {
			LocalizadorVO localizador = this.localizador.consultaLocalizador(identificador);
			String path=localizador.getPath();
			assertNotNull(path);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
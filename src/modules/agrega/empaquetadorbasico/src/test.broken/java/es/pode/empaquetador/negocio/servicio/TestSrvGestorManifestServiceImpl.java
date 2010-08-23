/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.empaquetador.negocio.servicio;

import java.io.File;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.xml.rpc.ServiceException;

import es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaService;
import es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceService;
import es.pode.catalogacion.negocio.servicios.SrvCatalogacionBasicaServiceServiceLocator;
import es.pode.empaquetador.negocio.externos.ScormDao;
import es.pode.localizador.negocio.servicios.LocalizadorVO;
import es.pode.localizador.negocio.servicios.SrvLocalizadorService;
import es.pode.localizador.negocio.servicios.SrvLocalizadorServiceService;
import es.pode.localizador.negocio.servicios.SrvLocalizadorServiceServiceLocator;
import es.pode.parseadorXML.SCORM2004Dao;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;

/**
 * @see SrvGestorManifestServiceImpl
 */
public class TestSrvGestorManifestServiceImpl extends
		SrvGestorManifestServiceImplBase {
	protected SCORM2004Dao scormDao = null;

	private static final String ODE_PRUEBAS = "CON_SUBM";

	private SrvCatalogacionBasicaService catalogacion = null;

	private SrvLocalizadorService localizador = null;

	/**
	 * Constructor
	 */
	public TestSrvGestorManifestServiceImpl() {
		super();
		/*
		 *  Inicio el contexto Agegi para autenticar el usuario empaquetador 
		 */
		logger.info("Autenticando usuario empaquetador con password 1");
//		UserDetails user = new User("empaquetador", "1", true, false, true, true, new GrantedAuthority[0]);
//		try {
//			LdapUserDetailsAgrega.Essence user = new LdapUserDetailsAgrega.Essence();
//			user.setUsername("empaquetador");
//			user.setPassword("1");
//			BasicAttributes attributes = new BasicAttributes();
//			attributes.put("preferredlanguage", "es");
//			attributes.put("initials", "es");
//			attributes.put("sn", "Usuario Empaquetador");
//			attributes.put("mail", "empaquetador@agrega.es");
//			attributes.put("employeeType", "avanzado");
//			attributes.put("cn", "empaquetador");
//			user.setAttributes(attributes);
//			
//			Authentication currentAuth = new UsernamePasswordAuthenticationToken(user.createUserDetails(), null);
//			SecurityContextHolder.getContext().setAuthentication(currentAuth);
//		} catch (Exception e) {
//			logger.error(e);
//			fail("Error de construccion del test durante la autenticacion");
//		}
		
		super.initAthenticationUser("empaquetador", "empaquetador");
		try {
			SrvCatalogacionBasicaServiceService locator = new SrvCatalogacionBasicaServiceServiceLocator();
			catalogacion = locator.getSrvCatalogacionBasicaService();
		} catch (ServiceException e) {
			logger
					.error(
							"No se ha podido obtener una referencia al servicio de catalogacion. ",
							e);
			fail("No se ha podido obtener una referencia al servicio de catalogacion.");
		}

		try {
			SrvLocalizadorServiceService localizadorLocator = new SrvLocalizadorServiceServiceLocator();
			localizador = localizadorLocator.getSrvLocalizadorService();
		} catch (ServiceException e) {
			logger
					.error(
							"No se ha podido obtener una referencia al servicio localizador. ",
							e);
			fail("No se ha podido obtener una referencia al servicio de localizador.");
		}
	}

	/**
	 * onSetUpInTransaction
	 */

	protected void onSetUpInTransaction() throws Exception {
		super.onSetUpInTransaction();
		String identificador1 = "SIN_SUBM";
		String identificador2 = ODE_PRUEBAS;
		String identificador3 = "prueb";
		String identificador4 = "ode_datos_item";
		LocalizadorVO localizadorManifest1 = new LocalizadorVO();
		LocalizadorVO localizadorManifest2 = new LocalizadorVO();
		LocalizadorVO localizadorManifest3 = new LocalizadorVO();
		LocalizadorVO localizadorManifest4 = new LocalizadorVO();
		
		// Traza para comprobar el directorio base de los tests
		File baseDir = new File("./");
		logger.info("El directorio base de los tests es : "
				+ baseDir.getCanonicalPath());
		try {
			localizadorManifest2 = this.getSrvLocalizadorService()
					.consultaLocalizador(identificador2);
			localizadorManifest1 = this.getSrvLocalizadorService()
					.consultaLocalizador(identificador1);
			localizadorManifest3 = this.getSrvLocalizadorService()
			.consultaLocalizador(identificador3);
			localizadorManifest4 = this.getSrvLocalizadorService()
			.consultaLocalizador(identificador4);
			File newDir = new File(localizadorManifest2.getPath());
			File newDir1 = new File(localizadorManifest1.getPath());
			File newDir3 = new File(localizadorManifest3.getPath());
			File newDir4 = new File(localizadorManifest4.getPath());
			// Si no existen los directorios de test, los creamos.
			if (!newDir.exists())
				newDir.mkdirs();
			if (!newDir1.exists())
				newDir1.mkdirs();
			if (!newDir3.exists())
				newDir3.mkdirs();
			if (!newDir4.exists())
				newDir4.mkdirs();
			
			java.net.URL nombrefichero2 = null;
			java.net.URL nombrefichero1 = null;
			java.net.URL nombrefichero3 = null;
			java.net.URL nombrefichero4 = null;

			nombrefichero2 = this.getClass().getResource(
					"/MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8");
			nombrefichero1 = this.getClass().getResource(
					"/MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C9");
			nombrefichero3 = this.getClass().getResource(
			"/MANIFEST-A09C57BFD9E2313044F1D6AC99DD31D0");
			nombrefichero4 = this.getClass().getResource(
			"/MANIFEST-DATOS-ITEM");
			
			File oldDir = new File(nombrefichero2.getFile());
			File oldDir1 = new File(nombrefichero1.getFile());
			File oldDir3 = new File(nombrefichero3.getFile());
			File oldDir4 = new File(nombrefichero4.getFile());

			UtilesFicheros.copiar(oldDir, newDir);
			UtilesFicheros.copiar(oldDir1, newDir1);
			UtilesFicheros.copiar(oldDir3, newDir3);
			UtilesFicheros.copiar(oldDir4, newDir4);

			localizadorManifest3 = this.getSrvLocalizadorService()
					.consultaLocalizador(identificador3);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		OdeVO manifestConSubm = servicio.editarODE(identificador2);
//		OdeVO manifestConSubm = servicio.editarODE(identificador4);
		
		// Inyecto un SCORM2004Dao para parseos

		scormDao = (ScormDao) applicationContext.getBean("ScormDao");

	}

	/**
	 * onTearDownInTransaction
	 */

	protected void onTearDownInTransaction() {

		/**
		 * Implementar si no desea usar DataSets
		 */

		super.onTearDownInTransaction();
		servicio.descargarManifest("CON_SUBM");

		// BORRAMOS LA CARPETA test_empaquetador CREADA EN EL ONSETUP
		File borrar = new File("test_empaquetador");

		try {
			UtilesFicheros.eliminar(borrar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * testInicial TODO: Agregar las pruebas unitarias que correspondan al
	 * servicio, siguiendo un patron de nombrado como public void test<nombreTest>().
	 */
	public void testInicial() {
		String prueba = null;
		assertNull(prueba);
	}

	/**
	 * TEST cargarManifest TODO: Implementar el test para el metodo
	 * cargarManifest del servicio SrvGestorManifestService.
	 */

	// FUNCIONA
	public void testcargarManifest() {

		String identificador = "CON_SUBM";

		// Comprobacion
		OdeVO cargado = servicio.cargarManifest(identificador);
		assertTrue(cargado.getIdentifier().equals(
				"MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8"));
		assertTrue(cargado.getOrganizaciones().length == 1);
		assertTrue(cargado.getOrganizacionPrincipal().equals(
				"ORG-1407CA53DF6A0791B2C82466F69C4BB1"));

	}

	/**
	 * TEST descargarManifest TODO: Implementar el test para el metodo
	 * descargarManifest del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testdescargarManifest() {
		Boolean descarga = null;
		String identificador = "CON_SUBM";
		descarga = servicio.descargarManifest(identificador);
		assertTrue(descarga.booleanValue());
		assertNull(servicio.cargarManifest(identificador));

	}

	/**
	 * TEST crearGrupo TODO: Implementar el test para el metodo crearGrupo del
	 * servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testcrearGrupo() {

		// PRIMERO: prueba de que se crea un grupo en otro grupo
		String identificador_manifest = "CON_SUBM";
		String identificador_padre1 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
		String identificador_item_nuevo = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD695";
		String titulo_grupo = "prueba_añadir_grupo_en_grupo";

		GrupoVO grupo = new GrupoVO();

		// meter informacion dentro del grupo
		grupo.setIdentifier(identificador_item_nuevo);
		grupo.setTitle(titulo_grupo);
		servicio.crearGrupo(identificador_manifest, grupo,
				identificador_padre1);
		OdeVO nuevo_grupo = servicio.cargarManifest(identificador_manifest); 

		assertTrue(nuevo_grupo.getIdentifier().equals(
				"MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8"));
		assertTrue(nuevo_grupo.getOrganizaciones().length == 1);
		assertTrue(nuevo_grupo.getOrganizaciones()[0].getGrupos().length == 1);
		assertTrue(nuevo_grupo.getOrganizaciones()[0].getGrupos()[0]
				.getGrupos().length == 1);
		assertEquals("Comparando titulo del grupo", nuevo_grupo
				.getOrganizaciones()[0].getGrupos()[0].getGrupos()[0]
				.getTitle(), titulo_grupo);
		assertEquals("Comparando identificador del grupo", nuevo_grupo
				.getOrganizaciones()[0].getGrupos()[0].getGrupos()[0]
				.getIdentifier(), identificador_item_nuevo);

		// SEGUNDO: prueba de que se crea un grupo en una organizacion
		String identificador_padre = "ORG-1407CA53DF6A0791B2C82466F69C4BB1";
		String identificador_item2 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD693";
		String titulo_grupo2 = "prueba_añadir_grupo_en_organizacion";

		GrupoVO grupo2 = new GrupoVO();

		// meter informacion dentro del grupo
		grupo2.setIdentifier(identificador_item2);
		grupo2.setTitle(titulo_grupo2);

		servicio.crearGrupo(identificador_manifest,
				grupo2, identificador_padre);
		OdeVO nuevo_grupo2 = servicio.cargarManifest(identificador_manifest);
		assertTrue(nuevo_grupo2.getIdentifier().equals(
				"MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8"));
		assertTrue(nuevo_grupo2.getOrganizaciones().length == 1);
		assertTrue(nuevo_grupo2.getOrganizaciones()[0].getGrupos().length == 2);
		assertEquals("Comparando titulo del grupo", nuevo_grupo2
				.getOrganizaciones()[0].getGrupos()[1].getTitle(),
				titulo_grupo2);
		assertEquals("Comparando identificador del grupo", nuevo_grupo2
				.getOrganizaciones()[0].getGrupos()[1].getIdentifier(),
				identificador_item2);

		// TERCERO: prueba de que el objeto es null

		String identificador_padre3 = "NO EXISTO";
		String identificador_item3 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD697";
		String titulo_grupo3 = "prueba_añadir_grupo_null";

		GrupoVO grupo3 = new GrupoVO();

		// meter informacion dentro del grupo
		grupo3.setIdentifier(identificador_item3);
		grupo3.setTitle(titulo_grupo3);

		try {
			servicio.crearGrupo(identificador_manifest,
					grupo3, identificador_padre3);
			OdeVO nuevo_grupo3 =  servicio.cargarManifest(identificador_manifest);
		} catch (Exception e) {
			assertEquals(e.getCause().getClass(), AlmacenamientoException.class);
		}

	}

	/**
	 * TEST modificarGrupo TODO: Implementar el test para el metodo
	 * modificarGrupo del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testmodificarGrupo() {

		// PRIMERO: prueba de que se modifica un grupo en otro grupo
		String identificador_manifest = "CON_SUBM";
		String identificador_padre1 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
		String identificador_item_nuevo = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD695";
		String titulo_grupo = "prueba_modificar_grupo";

		GrupoVO grupo = new GrupoVO();

		// meter informacion dentro del grupo
		grupo.setIdentifier(identificador_item_nuevo);
		grupo.setTitle("Prueba");
		servicio.crearGrupo(identificador_manifest, grupo,
				identificador_padre1);
		OdeVO nuevo_grupo = servicio.cargarManifest(identificador_manifest);

		assertTrue(nuevo_grupo.getIdentifier().equals(
				"MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8"));
		assertTrue(nuevo_grupo.getOrganizaciones().length == 1);
		assertTrue(nuevo_grupo.getOrganizaciones()[0].getGrupos().length == 1);
		assertTrue(nuevo_grupo.getOrganizaciones()[0].getGrupos()[0]
				.getGrupos().length == 1);

		GrupoVO modificar_grupo = new GrupoVO();
		modificar_grupo.setIdentifier(identificador_item_nuevo);
		modificar_grupo.setTitle(titulo_grupo);
		servicio.modificarGrupo(
				identificador_manifest, modificar_grupo);
		OdeVO grupo_modificado = servicio.cargarManifest(identificador_manifest);

		// comprobaciones
		assertTrue(nuevo_grupo.getOrganizaciones()[0].getGrupos().length == 1);
		assertTrue(nuevo_grupo.getOrganizaciones()[0].getGrupos()[0]
				.getGrupos().length == 1);
		assertEquals("Comparando el identificador", grupo_modificado
				.getOrganizaciones()[0].getGrupos()[0].getGrupos()[0]
				.getIdentifier(), identificador_item_nuevo);
		assertEquals("Comparando titulo de la organizacion", grupo_modificado
				.getOrganizaciones()[0].getGrupos()[0].getGrupos()[0]
				.getTitle(), titulo_grupo);

		// SEGUNDO: prueba de que se modifica un grupo en una organizacion
		String identificador_padre = "ORG-1407CA53DF6A0791B2C82466F69C4BB1";
		String identificador_item2 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD693";
		String titulo_grupo2 = "prueba_añadir_grupo_en_organizacion";

		GrupoVO grupo2 = new GrupoVO();

		// meter informacion dentro del grupo
		grupo2.setIdentifier(identificador_item2);
		grupo2.setTitle("Prueba2");
		servicio.crearGrupo(identificador_manifest,
				grupo2, identificador_padre);

		OdeVO nuevo_grupo2 = servicio.cargarManifest(identificador_manifest);
		assertTrue(nuevo_grupo2.getIdentifier().equals(
				"MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8"));
		assertTrue(nuevo_grupo2.getOrganizaciones().length == 1);
		assertTrue(nuevo_grupo2.getOrganizaciones()[0].getGrupos().length == 2);

		GrupoVO modificar_grupo2 = new GrupoVO();
		modificar_grupo2.setIdentifier(identificador_item2);
		modificar_grupo2.setTitle(titulo_grupo2);
		servicio.modificarGrupo(
				identificador_manifest, modificar_grupo2);
		OdeVO grupo_modificado2 = servicio.cargarManifest(identificador_manifest);

		// comprobaciones
		assertTrue(nuevo_grupo2.getOrganizaciones().length == 1);
		assertTrue(nuevo_grupo2.getOrganizaciones()[0].getGrupos().length == 2);
		assertEquals("Comparando el identificador", grupo_modificado2
				.getOrganizaciones()[0].getGrupos()[1].getIdentifier(),
				identificador_item2);
		assertEquals("Comparando titulo de la organizacion", grupo_modificado2
				.getOrganizaciones()[0].getGrupos()[1].getTitle(),
				titulo_grupo2);

		// TERCERO: prueba modificar un objeto que es null
		String identificador_padre3 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
		String identificador_item3 = "NO_EXISTO";
		String titulo_grupo3 = "prueba modificar grupo null";

		GrupoVO grupo3 = new GrupoVO();

		// meter informacion dentro del grupo
		grupo3.setIdentifier(identificador_item3);
		grupo3.setTitle("Prueba3");
		servicio.crearGrupo(identificador_manifest,
				grupo3, identificador_padre3);
		OdeVO nuevo_grupo3 = servicio.cargarManifest(identificador_manifest);

		GrupoVO modificar_grupo3 = new GrupoVO();
		modificar_grupo3.setIdentifier(identificador_item3);
		modificar_grupo3.setTitle(titulo_grupo3);

		try {
			servicio.modificarGrupo(
					identificador_manifest, modificar_grupo3);
			OdeVO grupo_modificado3 = servicio.cargarManifest(identificador_manifest);
		} catch (Exception e) {
			assertEquals(e.getCause().getClass(), AlmacenamientoException.class);
		}

	}

	/**
	 * TEST eliminarGrupo TODO: Implementar el test para el metodo eliminarGrupo
	 * del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testeliminarGrupo() {

		// PRIMERO: elimino un grupo que cuelga de una organizacion
		String identificador_padre = "ORG-1407CA53DF6A0791B2C82466F69C4BB1";
		String identificador_manifest = "CON_SUBM";
		String identificador_item = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD697";
		String titulo_grupo = "prueba eliminar grupo de organizacion";

		GrupoVO grupo = new GrupoVO();

		// meter informacion dentro del grupo
		grupo.setIdentifier(identificador_item);
		grupo.setTitle(titulo_grupo);
		servicio.crearGrupo(identificador_manifest, grupo,
				identificador_padre);
		
		
		servicio.eliminarGrupo(identificador_manifest,
					identificador_item);

		OdeVO eliminar_grupo = servicio.cargarManifest(identificador_manifest); 
		assertTrue(eliminar_grupo.getIdentifier().equals(
				"MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8"));
		assertTrue(eliminar_grupo.getOrganizaciones().length == 1);
		assertTrue(eliminar_grupo.getOrganizaciones()[0].getGrupos().length == 1);

		GrupoVO[] grup = eliminar_grupo.getOrganizaciones()[0].getGrupos();
		boolean flag = false;
		for (int i = 0; i < grup.length && !flag; i++) {
			if (grup[i].getIdentifier() == "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699") {
				flag = true;
			}
		}
		assertFalse(flag);

		// SEGUNDO: elimino un grupo que cuelga de otro grupo

		String identificador_padre2 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
		String identificador_item_nuevo = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD695";
		String titulo_grupo2 = "prueba eliminar grupo de grupo";

		GrupoVO grupo2 = new GrupoVO();

		// meter informacion dentro del grupo
		grupo2.setIdentifier(identificador_item_nuevo);
		grupo2.setTitle(titulo_grupo2);

		servicio.crearGrupo(identificador_manifest,
				grupo2, identificador_padre2);
		servicio.eliminarGrupo(identificador_manifest,
				identificador_item_nuevo);
		OdeVO eliminar_grupo2 = servicio.cargarManifest(identificador_manifest);

		assertTrue(eliminar_grupo2.getIdentifier().equals(
				"MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8"));
		assertTrue(eliminar_grupo2.getOrganizaciones().length == 1);
		assertTrue(eliminar_grupo2.getOrganizaciones()[0].getGrupos().length == 1);

		GrupoVO[] grup2 = eliminar_grupo2.getOrganizaciones()[0].getGrupos()[0]
				.getGrupos();
		boolean flag2 = false;
		for (int i = 0; i < grup2.length && !flag2; i++) {
			if (grup2[i].getIdentifier() == "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD695") {
				flag2 = true;
			}
		}
		assertFalse(flag2);

		// TERCERO: prueba de que el objeto padre es null

		String identificador_padre3 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
		String identificador_item3 = "NO_EXISTO";
		String titulo_grupo3 = "prueba eliminar grupo con padre null";

		GrupoVO grupo3 = new GrupoVO();

		// meter informacion dentro del grupo
		grupo3.setIdentifier(identificador_item3);
		grupo3.setTitle(titulo_grupo3);

		servicio.crearGrupo(identificador_manifest,
				grupo3, identificador_padre3);

		try {
			servicio.eliminarGrupo(
					identificador_manifest, identificador_item3);

		} catch (Exception e) {
			assertEquals(e.getCause().getClass(), AlmacenamientoException.class);
		}

	}

	/**
	 * TEST vincularGrupo TODO: Implementar el test para el metodo vincularGrupo
	 * del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testvincularGrupo() {

		String identificador_manifest = "CON_SUBM";
		String identificador_item = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
		String identificador_recurso = "RES-1937E17748FA68C8270AA65D7691BB67";
		String id_recurso_no_existe = "NO EXISTO";
		String id_item_no_existe = "NO EXISTO";
		servicio.vincularGrupo(identificador_manifest,
				identificador_item, identificador_recurso);
		OdeVO vincular_grupo = servicio.cargarManifest(identificador_manifest);

		// comprobaciones
		assertTrue(vincular_grupo.getOrganizaciones()[0].getGrupos()[0]
				.getElementoReferenciado().equals(
						"RES-1937E17748FA68C8270AA65D7691BB67"));
		try {
			servicio.vincularGrupo(
					identificador_manifest, id_item_no_existe,
					identificador_recurso);
		} catch (Exception e) {
			assertEquals(e.getCause().getClass(), NullPointerException.class);
		}

		try {
			servicio.vincularGrupo(
					identificador_manifest, identificador_item,
					id_recurso_no_existe);
		} catch (Exception e) {
			assertEquals(e.getCause().getClass(),
					IllegalArgumentException.class);
		}

	}

	/**
	 * TEST desvincularGrupo TODO: Implementar el test para el metodo
	 * desvincularGrupo del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testdesvincularGrupo() {

		String identificador_manifest = "CON_SUBM";
		String identificador_item = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
		String identificador_recurso = "RES-1937E17748FA68C8270AA65D7691BB67";
		String id_item_no_existe = "NO EXISTO";
		servicio.vincularGrupo(identificador_manifest,
				identificador_item, identificador_recurso);
		OdeVO vincular_grupo = servicio.cargarManifest(identificador_manifest);
		assertTrue(vincular_grupo.getOrganizaciones()[0].getGrupos()[0]
				.getElementoReferenciado().equals(
						"RES-1937E17748FA68C8270AA65D7691BB67"));
		servicio.desvincularGrupo(
				identificador_manifest, identificador_item);
		OdeVO desvincular_grupo = servicio.cargarManifest(identificador_manifest);
		assertNull(desvincular_grupo.getOrganizaciones()[0].getGrupos()[0]
				.getElementoReferenciado());

		try {
			servicio.desvincularGrupo(
					identificador_manifest, id_item_no_existe);
		} catch (Exception e) {
			assertEquals(e.getCause().getClass(), NullPointerException.class);
		}

	}

	/**
	 * TEST CrearRecurso TODO: Implementar el test para el metodo CrearRecurso
	 * del servicio SrvGestorManifestService.
	 */

	// FUNCIONA
	public void testCrearRecurso() {

		String identificador_recurso = "RES-1937E17748FA68C8270AA65D7691BB68";
		String identificador_manifest = "CON_SUBM";

		RecursoVO recurso = new RecursoVO();
		recurso.setIdentifier(identificador_recurso);
		servicio.crearRecurso(identificador_manifest,
				recurso);
		OdeVO nuevo_recurso = servicio.cargarManifest(identificador_manifest);

		assertTrue(nuevo_recurso.getIdentifier().equals(
				"MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8"));
		assertTrue(nuevo_recurso.getRecursos().length == 2);
		assertTrue(nuevo_recurso.getRecursos()[1].getDependencias().length == 0);

	}

	/**
	 * TEST EliminarRecurso TODO: Implementar el test para el metodo
	 * EliminarRecurso del servicio SrvGestorManifestService.
	 */

	// FUNCIONA
	public void testEliminarRecursos() {

		String identificador_recurso = "RES-1937E17748FA68C8270AA65D7691BB68";
		String identificador_manifest = "CON_SUBM";
		String[] arrayRecursos = new String[1];

		RecursoVO recurso = new RecursoVO();
		recurso.setIdentifier(identificador_recurso);

		servicio.crearRecurso(identificador_manifest,
				recurso);

		arrayRecursos[0] = identificador_recurso;
		servicio.eliminarRecursos(identificador_manifest,
				arrayRecursos);
		OdeVO eliminarRec = servicio.cargarManifest(identificador_manifest);

		assertTrue(eliminarRec.getRecursos().length == 1);
		assertTrue(eliminarRec.getRecursos()[0].getIdentifier().equals(
				"RES-1937E17748FA68C8270AA65D7691BB67"));

	}

	/**
	 * TEST ModificarRecurso TODO: Implementar el test para el metodo
	 * ModificarRecurso del servicio SrvGestorManifestService.
	 */

	// FUNCIONA
	public void testModificarRecurso() {

		String identificador_recurso = "RES-1937E17748FA68C8270AA65D7691BB69";
		String identificador_manifest = "CON_SUBM";
		String modificado = "MODIFICADO";

		RecursoVO recurso = new RecursoVO();
		recurso.setIdentifier(identificador_recurso);
		recurso.setHref("SIN MODIFICAR");

		servicio.crearRecurso(identificador_manifest,
				recurso);

		RecursoVO recurso_modificado = new RecursoVO();
		recurso_modificado.setIdentifier(identificador_recurso);
		recurso_modificado.setHref(modificado);
		servicio.modificarRecurso(
				identificador_manifest, recurso_modificado);
		OdeVO modificar_recurso = servicio.cargarManifest(identificador_manifest);

		assertTrue(modificar_recurso.getIdentifier().equals(
				"MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8"));
		assertTrue(modificar_recurso.getRecursos().length == 2);
		assertEquals("Comparando Href", recurso_modificado.getHref(),
				modificado);

	}

	/**
	 * TEST guardarManifiesto TODO: Implementar el test para el metodo
	 * guardarManifiesto del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testguardarManifiesto() {

		String identificador_manifest = "CON_SUBM";
		String identificador_manifest2 = "MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8";
		String identificador_nuevo_grupo = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD694";
		String title_nuevo_grupo = "prueba_guardar_manifest";
		String identificador_organizacion = "ORG-1407CA53DF6A0791B2C82466F69C4BB1";

		// Crear un nuevo grupo
		GrupoVO grupo = new GrupoVO();
		grupo.setIdentifier(identificador_nuevo_grupo);
		grupo.setTitle(title_nuevo_grupo);
		servicio.crearGrupo(identificador_manifest, grupo,
				identificador_organizacion);

		// Llamar al metodo guardar manifiesto
		servicio.guardarManifiesto(identificador_manifest);

		// Llamar al metodo cargar manifest y ver si ha realizado la agregacion
		// del nuevo grupo
		OdeVO cargado = servicio.cargarManifest(identificador_manifest);
		assertTrue(cargado.getIdentifier().equals(identificador_manifest2));
		assertTrue(cargado.getOrganizaciones()[0].getGrupos().length == 2);
		assertEquals("Comparando titulo del grupo",
				cargado.getOrganizaciones()[0].getGrupos()[1].getTitle(),
				title_nuevo_grupo);
		assertEquals("Comparando titulo del grupo",
				cargado.getOrganizaciones()[0].getGrupos()[1].getIdentifier(),
				identificador_nuevo_grupo);

	}

	/**
	 * TEST crearOrganizacion TODO: Implementar el test para el metodo
	 * crearOrganizacion del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testcrearOrganizacion() {

		String identificador_nueva_organization = "ORG-1407CA53DF6A0791B2C82466F69C4BB2";
		String identificador_manifest = "CON_SUBM";
		String identificador_manifest2 = "MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8";
		String title_organizacion = "prueba_crear";
		OrganizacionVO org = new OrganizacionVO();

		// meter informacion dentro de organizacion
		org.setTitle(title_organizacion);
		org.setIdentifier(identificador_nueva_organization);

		// comprobar que habia ya una organizacion
		OdeVO primera_comprobacion = servicio.cargarManifest(ODE_PRUEBAS);
		assertTrue(primera_comprobacion.getOrganizaciones().length == 1);
		servicio.crearOrganizacion(
				identificador_manifest, org);
		OdeVO nueva_organizacion = servicio.cargarManifest(identificador_manifest);
		assertTrue(nueva_organizacion.getIdentifier().equals(
				identificador_manifest2));
		assertTrue(nueva_organizacion.getOrganizaciones().length == 2);

		assertEquals("Comparando titulo de la organizacion", nueva_organizacion
				.getOrganizaciones()[1].getTitle(), title_organizacion);
		assertEquals("Comparando identificador de la organizacion",
				nueva_organizacion.getOrganizaciones()[1].getIdentifier(),
				identificador_nueva_organization);

	}

	/**
	 * TEST eliminarOrganizacion TODO: Implementar el test para el metodo
	 * eliminarOrganizacion del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testeliminarOrganizacion() {

		String identificador_nueva_organization = "ORG-1407CA53DF6A0791B2C82466F69C4BB2";
		String identificador_nueva_organization2 = "NO EXISTO";
		String identificador_manifest = "CON_SUBM";
		String identificador_manifest2 = "MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8";
		String title_organizacion = "prueba_eliminar";
		OrganizacionVO org = new OrganizacionVO();

		// meter informacion dentro de organizacion
		org.setTitle(title_organizacion);
		org.setIdentifier(identificador_nueva_organization);

		// comprobar que habia ya una organizacion
		OdeVO primera_comprobacion = servicio.cargarManifest(ODE_PRUEBAS);
		assertTrue(primera_comprobacion.getOrganizaciones().length == 1);

		// meto el identificador de una organizacion que no existe
		servicio.eliminarOrganizacion(
				identificador_manifest, identificador_nueva_organization2);
		OdeVO elimina_organizacion2 = servicio.cargarManifest(identificador_manifest);
		assertTrue(elimina_organizacion2.getOrganizaciones().length == 1);

		// creo una organizacion y la elimino
		servicio.crearOrganizacion(
				identificador_manifest, org);
		servicio.eliminarOrganizacion(
				identificador_manifest, identificador_nueva_organization);
		OdeVO elimina_organizacion = servicio.cargarManifest(identificador_manifest);
		assertTrue(elimina_organizacion.getIdentifier().equals(
				identificador_manifest2));
		assertTrue(elimina_organizacion.getOrganizaciones().length == 1);

		// compruebo que la ha eliminado correctamente
		OrganizacionVO[] org2 = elimina_organizacion.getOrganizaciones();
		boolean flag = false;
		for (int i = 0; i < org2.length && !flag; i++) {
			if (org2[i].getIdentifier() == identificador_nueva_organization) {
				flag = true;
			}
		}
		assertFalse(flag);
	}

	/**
	 * TEST modificarOrganizacion TODO: Implementar el test para el metodo
	 * modificarOrganizacion del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testmodificarOrganizacion() {

		// Crea una nueva organizacion y a continuacion la modifica

		String identificador_nueva_organization = "ORG-1407CA53DF6A0791B2C82466F69C4BB2";
		String title_nueva = "prueba_modificar";
		String identificador_manifest = "CON_SUBM";
		OrganizacionVO org = new OrganizacionVO();

		// meter informacion dentro de organizacion
		org.setTitle("prueba_crear");
		org.setIdentifier(identificador_nueva_organization);

		// comprobar que habia ya una organizacion
		OdeVO primera_comprobacion = servicio.cargarManifest(ODE_PRUEBAS);
		assertTrue(primera_comprobacion.getOrganizaciones().length == 1);
		servicio.crearOrganizacion(
				identificador_manifest, org);
		OdeVO nueva_organizacion = servicio.cargarManifest(identificador_manifest);
		assertTrue(nueva_organizacion.getIdentifier().equals(
				"MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8"));
		assertTrue(nueva_organizacion.getOrganizaciones().length == 2);

		// modificar la organizacion
		OrganizacionVO org_modificada = new OrganizacionVO();
		org_modificada.setIdentifier(identificador_nueva_organization);
		org_modificada.setTitle(title_nueva);

		// Llamar al metodo modificarOrganizacion
		servicio.modificarOrganizacion(
				identificador_manifest, org_modificada);
		OdeVO modifica_organizacion = servicio.cargarManifest(identificador_manifest);

		// comprobaciones
		assertEquals("Comparando el identificador", modifica_organizacion
				.getOrganizaciones()[1].getIdentifier(),
				identificador_nueva_organization);
		assertEquals("Comparando titulo de la organizacion",
				modifica_organizacion.getOrganizaciones()[1].getTitle(),
				title_nueva);
		assertTrue(modifica_organizacion.getOrganizaciones().length == 2);

	}

	/**
	 * TEST fijarOrganizacionPorDefecto TODO: Implementar el test para el metodo
	 * fijarOrganizacionPorDefecto del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testfijarOrganizacionPorDefecto() {

		String identificador_manifest = "CON_SUBM";
		String identificador_organizacion = "ORG-1407CA53DF6A0791B2C82466F69C4BB1";
		String identificador_manifest2 = "MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8";
		String identificador_nueva_organization2 = "NO EXISTO";

		// Hacer una principal una que no existe
		servicio.fijarOrganizacionPorDefecto(
				identificador_manifest, identificador_nueva_organization2);

		// de una organizacion ya creada hacerla principal
		// PRIMERO: hacer principal una que ya existe en el manifest
		 servicio.fijarOrganizacionPorDefecto(
					identificador_manifest, identificador_organizacion);
		OdeVO org_por_defecto = servicio.cargarManifest(identificador_manifest);
		// comprobaciones
		assertEquals("Comprobacion organizacion principal por defecto",
				org_por_defecto.getOrganizacionPrincipal(),
				identificador_organizacion);
		assertTrue(org_por_defecto.getOrganizaciones().length == 1);

		// SEGUNDO: hacer principal una que crearemos
		String title_nueva = "prueba_por_defecto";
		String identificador_nueva_organizacion = "ORG-1407CA53DF6A0791B2C82466F69C4BB2";
		OrganizacionVO org = new OrganizacionVO();

		// meter informacion dentro de organizacion
		org.setTitle(title_nueva);
		org.setIdentifier(identificador_nueva_organizacion);
		servicio.crearOrganizacion(
				identificador_manifest, org);
		OdeVO nueva_organizacion = servicio.cargarManifest(identificador_manifest);
		assertTrue(nueva_organizacion.getIdentifier().equals(
				identificador_manifest2));
		assertTrue(nueva_organizacion.getOrganizaciones().length == 2);
		servicio.fijarOrganizacionPorDefecto(
				identificador_manifest, identificador_nueva_organizacion);
		OdeVO org_por_defecto2 = servicio.cargarManifest(identificador_manifest);
		// comprobaciones
		assertEquals("Comprobacion organizacion principal por defecto",
				org_por_defecto2.getOrganizacionPrincipal(),
				identificador_nueva_organizacion);
		assertTrue(org_por_defecto2.getOrganizaciones().length == 2);

		// TERCERO: volver a cambiar la organizacion principal
		 servicio.fijarOrganizacionPorDefecto(
					identificador_manifest, identificador_organizacion);
		OdeVO org_por_defecto3 = servicio.cargarManifest(identificador_manifest);

		// comprobaciones
		assertEquals("Comprobacion organizacion principal por defecto",
				org_por_defecto3.getOrganizacionPrincipal(),
				identificador_organizacion);
		assertTrue(org_por_defecto3.getOrganizaciones().length == 2);

	}

	/**
	 * TEST agregarManifiestoZIP TODO: Implementar el test para el metodo
	 * agregarManifiestoZIP del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testagregarManifiestoZIP() {

		String identificador_manifest = "CON_SUBM";
		String subId1 = null;
		String subId2 = "MANIFEST-49BA2CAB-23E8-BF28-85C4-535C652E6DD2";
		String nombrefichero = "sd02_oa04_actividad_campanias_publicitarias.zip";

		// Creo el paqueteScorm
		java.net.URL url = this.getClass().getResource("/" + nombrefichero);
		String ruta = url.getFile();
		java.io.File ficheroZip = new File(ruta);
		DataSource source = new FileDataSource(ficheroZip);
		DataHandler paqueteScorm = new DataHandler(source);

		// Agregar el manifiestozip descendiendo del principal; subId1=null
		servicio.agregarManifiestoZIP(
				identificador_manifest, paqueteScorm, subId1);
		OdeVO agrega_zip = servicio.cargarManifest(identificador_manifest);
		assertTrue(agrega_zip.getSubmanifiestos().length == 2);

		// Agregar el manifiestozip descendiendo de un submanifiesto;
		// subId1=identificador_determinado
		// Primero creo una referencia en la cache para el submanifiesto
		Boolean crear_referencia = servicio.crearReferenciaEnCache(
				identificador_manifest, subId2);
		servicio.agregarManifiestoZIP(
				identificador_manifest, paqueteScorm, subId2);
		OdeVO agrega_zip2 = servicio.cargarManifest(identificador_manifest);
		assertTrue(agrega_zip2.getSubmanifiestos().length == 2);
		assertTrue(agrega_zip2.getSubmanifiestos()[0].getSubmanifiestos().length == 1);

	}

	/**
	 * TEST AgregarManifiestoRepositorio TODO: Implementar el test para el
	 * metodo AgregarManifiestoRepositorio del servicio
	 * SrvGestorManifestService.
	 */

	public void testagregarManifiestoRepositorio() {

		String identificador_manifest = "CON_SUBM";
		String localizador = "SIN_SUBM";
		String subId1 = null;
		String subId2 = "MANIFEST-49BA2CAB-23E8-BF28-85C4-535C652E6DD2";

		// Agregar el manifiestorepositorio descendiendo del manifiesto
		// principal ; subId1=null
		servicio.agregarManifiestoRepositorio(
				identificador_manifest, localizador, subId1);
		OdeVO agrega_manif_repositorio = servicio.cargarManifest(identificador_manifest);
		assertTrue(agrega_manif_repositorio.getSubmanifiestos().length == 2);

		// Agregar el manifiestorepositorio descendiendo de un submanifiesto;
		// subId1=identificador_determinado
		// Primero creo una referencia en la cache para el submanifiesto
		Boolean crear_referencia = servicio.crearReferenciaEnCache(
				identificador_manifest, subId2);
		servicio
		.agregarManifiestoRepositorio(identificador_manifest,
				localizador, subId2);
		OdeVO agrega_manif_repositorio2 =servicio.cargarManifest(identificador_manifest); 
		assertTrue(agrega_manif_repositorio2.getSubmanifiestos().length == 2);
		assertTrue(agrega_manif_repositorio2.getSubmanifiestos()[0]
				.getSubmanifiestos().length == 1);

	}

	/**
	 * TEST subirItem TODO: Implementar el test para el metodo subirItem del
	 * servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testSubirItem() {
		// crear un grupo nuevo
		String identificador_manifest = "CON_SUBM";
		String identificador_nuevo_grupo1 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD694";
		String title_nuevo_grupo1 = "prueba_subir_item1";
		String identificador_grupo0 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
		String identificador_organizacion = "ORG-1407CA53DF6A0791B2C82466F69C4BB1";
		String identificador_grupo2 = "NO EXISTE";

		
		GrupoVO grupo1 = new GrupoVO();
		grupo1.setIdentifier(identificador_nuevo_grupo1);
		grupo1.setTitle(title_nuevo_grupo1);
		servicio.crearGrupo(identificador_manifest, grupo1,
				identificador_organizacion);
		
		String identificador_nuevo_grupo3 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD695";
		String identificador_nuevo_grupo4 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD696";
		String title_nuevo_grupo3 = "prueba_subir_item3";
		String title_nuevo_grupo4 = "prueba_subir_item4";
		GrupoVO grupo3 = new GrupoVO();
		GrupoVO grupo4 = new GrupoVO();
		grupo3.setIdentifier(identificador_nuevo_grupo3);
		grupo3.setTitle(title_nuevo_grupo3);
		grupo4.setIdentifier(identificador_nuevo_grupo4);
		grupo4.setTitle(title_nuevo_grupo4);
		
		servicio.crearGrupo(identificador_manifest, grupo3,
				identificador_organizacion);
		servicio.crearGrupo(identificador_manifest, grupo4,
				identificador_organizacion);
		servicio.subirItem(identificador_manifest, identificador_nuevo_grupo4);
		OdeVO subir_item4 = servicio.cargarManifest(identificador_manifest);
		assertEquals(subir_item4.getOrganizaciones()[0].getGrupos()[2].getIdentifier(), identificador_nuevo_grupo4);
		
		

		// COMPROBACIONES
		// PRIMERO: Si está en la primera posición no puede hacerlo
		servicio.subirItem(identificador_manifest,
				identificador_grupo0);
		OdeVO subir_item1 = servicio.cargarManifest(identificador_manifest);
		assertEquals("Comparando identificador del grupo", subir_item1
				.getOrganizaciones()[0].getGrupos()[0].getIdentifier(),
				identificador_grupo0);
		assertEquals("Comparando titulo del grupo", subir_item1
				.getOrganizaciones()[0].getGrupos()[1].getTitle(),
				title_nuevo_grupo1);
		assertEquals("Comparando identificador del grupo", subir_item1
				.getOrganizaciones()[0].getGrupos()[1].getIdentifier(),
				identificador_nuevo_grupo1);

		// SEGUNDO: Si está en otra posicion que no sea la primera
		servicio.subirItem(identificador_manifest,
				identificador_nuevo_grupo1);
		OdeVO subir_item2 = servicio.cargarManifest(identificador_manifest);
		assertTrue(subir_item2.getOrganizaciones()[0].getGrupos().length == 4);
		assertEquals("Comparando titulo del grupo", subir_item2
				.getOrganizaciones()[0].getGrupos()[0].getTitle(),
				title_nuevo_grupo1);
		assertEquals("Comparando identificador del grupo", subir_item2
				.getOrganizaciones()[0].getGrupos()[0].getIdentifier(),
				identificador_nuevo_grupo1);
		assertEquals("Comparando identificador del grupo", subir_item2
				.getOrganizaciones()[0].getGrupos()[1].getIdentifier(),
				identificador_grupo0);

		// TERCERO: Si el identificador no es válido
		servicio.subirItem(identificador_manifest,
				identificador_grupo2);
		OdeVO subir_item3 = servicio.cargarManifest(identificador_manifest);
		assertTrue(subir_item3.getOrganizaciones()[0].getGrupos().length == 4);
		assertEquals("Comparando titulo del grupo", subir_item3
				.getOrganizaciones()[0].getGrupos()[0].getTitle(),
				title_nuevo_grupo1);
		assertEquals("Comparando identificador del grupo", subir_item3
				.getOrganizaciones()[0].getGrupos()[0].getIdentifier(),
				identificador_nuevo_grupo1);
		assertEquals("Comparando identificador del grupo", subir_item3
				.getOrganizaciones()[0].getGrupos()[1].getIdentifier(),
				identificador_grupo0);

	}

	/**
	 * TEST bajarItem TODO: Implementar el test para el metodo subirItem del
	 * servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testBajarItem() {
		// crear un grupo nuevo
		String identificador_manifest = "CON_SUBM";
		String identificador_nuevo_grupo1 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD694";
		String title_nuevo_grupo1 = "prueba_subir_item1";
		String identificador_nuevo_grupo2 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD695";
		String title_nuevo_grupo2 = "prueba_subir_item2";
		String identificador_grupo0 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
		String identificador_organizacion = "ORG-1407CA53DF6A0791B2C82466F69C4BB1";
		String identificador_grupo2 = "NO EXISTE";

		GrupoVO grupo1 = new GrupoVO();
		grupo1.setIdentifier(identificador_nuevo_grupo1);
		grupo1.setTitle(title_nuevo_grupo1);
		servicio.crearGrupo(identificador_manifest, grupo1,
				identificador_organizacion);
		
		GrupoVO grupo2 = new GrupoVO();
		grupo2.setIdentifier(identificador_nuevo_grupo2);
		grupo2.setTitle(title_nuevo_grupo2);
		servicio.crearGrupo(identificador_manifest, grupo2,
				identificador_organizacion);

		OdeVO manifest=servicio.cargarManifest("CON_SUBM");
		
		// COMPROBACIONES
		// PRIMERO: Si está en la ultima posición no se puede bajar
		servicio.bajarItem(identificador_manifest,
				manifest.getOrganizaciones()[0].getGrupos()[0].getIdentifier());
		OdeVO bajar_item1 = servicio.cargarManifest(identificador_manifest);
		assertEquals("Comparando identificador del grupo", bajar_item1
				.getOrganizaciones()[0].getGrupos()[0].getIdentifier(),
				identificador_nuevo_grupo1);
		assertEquals("Comparando titulo del grupo", bajar_item1
				.getOrganizaciones()[0].getGrupos()[0].getTitle(),
				title_nuevo_grupo1);
		assertEquals("Comparando identificador del grupo", bajar_item1
				.getOrganizaciones()[0].getGrupos()[2].getIdentifier(),
				identificador_nuevo_grupo2);

		// SEGUNDO: Si está en otra posicion que no sea la ultima
		servicio.bajarItem(identificador_manifest,
				identificador_grupo0);
		OdeVO bajar_item2 = servicio.cargarManifest(identificador_manifest);
		assertTrue(bajar_item2.getOrganizaciones()[0].getGrupos().length == 3);
		assertEquals("Comparando identificador del grupo", bajar_item2
				.getOrganizaciones()[0].getGrupos()[2].getIdentifier(),
				identificador_grupo0);
		assertEquals("Comparando identificador del grupo", bajar_item2
				.getOrganizaciones()[0].getGrupos()[1].getIdentifier(),
				identificador_nuevo_grupo2);
		assertEquals("Comparando titulo del grupo", bajar_item2
				.getOrganizaciones()[0].getGrupos()[0].getTitle(),
				title_nuevo_grupo1);

		// TERCERO: Si el identificador no es válido
		servicio.bajarItem(identificador_manifest,
				identificador_grupo2);
		OdeVO bajar_item3 = servicio.cargarManifest(identificador_manifest);
		assertTrue(bajar_item3.getOrganizaciones()[0].getGrupos().length == 3);
		assertEquals("Comparando identificador del grupo", bajar_item3
				.getOrganizaciones()[0].getGrupos()[0].getIdentifier(),
				identificador_nuevo_grupo1);
		assertEquals("Comparando identificador del grupo", bajar_item3
				.getOrganizaciones()[0].getGrupos()[1].getIdentifier(),
				identificador_nuevo_grupo2);
		assertEquals("Comparando titulo del grupo", bajar_item3
				.getOrganizaciones()[0].getGrupos()[2].getTitle(),
				manifest.getOrganizaciones()[0].getGrupos()[0].getTitle());
	}

	/**
	 * TEST subirOrganization TODO: Implementar el test para el metodo
	 * subirOrganization del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testSubirOrganization() {
		String identificador_nueva_organization = "ORG-1407CA53DF6A0791B2C82466F69C4BB2";
		String title_nueva_organizacion = "prueba_subiror";
		String identificador_manifest = "CON_SUBM";
		String identificador_manifest2 = "MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8";
		String identificador_organizacion = "ORG-1407CA53DF6A0791B2C82466F69C4BB1";
		String identificador_organizacion2 = "NO EXISTE";
		OrganizacionVO org = new OrganizacionVO();

		// comprobar que habia ya una organizacion
		OdeVO primera_comprobacion = servicio.cargarManifest(ODE_PRUEBAS);
		assertTrue(primera_comprobacion.getOrganizaciones().length == 1);

		// hay que crear una nueva organizacion
		org.setTitle(title_nueva_organizacion);
		org.setIdentifier(identificador_nueva_organization);

		servicio.crearOrganizacion(
				identificador_manifest, org);

		// PRIMERO: subir la organizacion "bien" situada
		servicio.subirOrganization(
				identificador_manifest, identificador_nueva_organization);
		OdeVO subir_organizacion = servicio.cargarManifest(identificador_manifest);

		// comprobaciones
		assertTrue(subir_organizacion.getIdentifier().equals(
				identificador_manifest2));
		assertTrue(subir_organizacion.getOrganizaciones().length == 2);
		assertEquals("Comparando titulo de la organizacion", subir_organizacion
				.getOrganizaciones()[0].getTitle(), title_nueva_organizacion);
		assertEquals("Comparando identificador de la organizacion",
				subir_organizacion.getOrganizaciones()[0].getIdentifier(),
				identificador_nueva_organization);

		// SEGUNDO: subir la organizacion que está en la primera posicion
		servicio.subirOrganization(
				identificador_manifest, identificador_nueva_organization);
		OdeVO subir_organizacion2 = servicio.cargarManifest(identificador_manifest);
		assertTrue(subir_organizacion2.getOrganizaciones().length == 2);
		assertEquals("Comparando titulo de la organizacion",
				subir_organizacion2.getOrganizaciones()[0].getTitle(),
				title_nueva_organizacion);
		assertEquals("Comparando identificador de la organizacion",
				subir_organizacion2.getOrganizaciones()[0].getIdentifier(),
				identificador_nueva_organization);

		// TERCERO: subir una organizacion que no existe
		servicio.subirOrganization(
				identificador_manifest, identificador_organizacion2);
		OdeVO subir_organizacion3 = servicio.cargarManifest(identificador_manifest);
		assertTrue(subir_organizacion3.getOrganizaciones().length == 2);
		assertEquals("Comparando titulo de la organizacion",
				subir_organizacion3.getOrganizaciones()[0].getTitle(),
				title_nueva_organizacion);
		assertEquals("Comparando identificador de la organizacion",
				subir_organizacion3.getOrganizaciones()[0].getIdentifier(),
				identificador_nueva_organization);
	}

	/**
	 * TEST bajarOrganization TODO: Implementar el test para el metodo
	 * bajarOrganization del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testBajarOrganization() {
		/*
		 * Actualmente hay una organizacion creada en la posicion 0 en el array
		 * de organizaciones; voy a crear otras dos organizaciones en la
		 * posicion 1 y 2. Para comprobar que el metodo funciona correctamente
		 * bajara la 1 a 2
		 */
		String identificador_nueva_organization1 = "ORG-1407CA53DF6A0791B2C82466F69C4BB2";
		String title1_nueva_organizacion = "prueba_subiror1";
		String title2_nueva_organizacion = "prueba_subiror2";
		String identificador_nueva_organization2 = "ORG-1407CA53DF6A0791B2C82466F69C4BB3";
		String identificador_manifest = "CON_SUBM";
		String identificador_manifest2 = "MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8";
		String identificador_organizacion2 = "NO EXISTE";
		OrganizacionVO org1 = new OrganizacionVO();
		OrganizacionVO org2 = new OrganizacionVO();

		// comprobar que habia ya una organizacion
		OdeVO primera_comprobacion = servicio.cargarManifest(ODE_PRUEBAS);
		assertTrue(primera_comprobacion.getOrganizaciones().length == 1);

		// hay que crear una nueva organizacion en la posicion 1
		org1.setTitle(title1_nueva_organizacion);
		org1.setIdentifier(identificador_nueva_organization1);

		// hay que crear una nueva organizacion en la posicion 2
		org2.setTitle(title2_nueva_organizacion);
		org2.setIdentifier(identificador_nueva_organization2);
		servicio.crearOrganizacion(
				identificador_manifest, org1);
		OdeVO nueva_organizacion1 = servicio.cargarManifest(identificador_manifest);
		servicio.crearOrganizacion(
				identificador_manifest, org2);
		OdeVO nueva_organizacion2 = servicio.cargarManifest(identificador_manifest);

		// bajar la organizcion en la posicion 1 a la posicion 2
		servicio.bajarOrganization(
				identificador_manifest, nueva_organizacion1.getOrganizaciones()[0].getIdentifier());
		OdeVO bajar_organizacion = servicio.cargarManifest(identificador_manifest);

		// comprobaciones
		assertTrue(bajar_organizacion.getIdentifier().equals(
				identificador_manifest2));
		assertTrue(bajar_organizacion.getOrganizaciones().length == 3);
		assertEquals("Comparando titulo de la organizacion1",
				bajar_organizacion.getOrganizaciones()[0].getTitle(),
				title1_nueva_organizacion);
		assertEquals("Comparando identificador de la organizacion1",
				bajar_organizacion.getOrganizaciones()[0].getIdentifier(),
				identificador_nueva_organization1);
		assertEquals("Comparando titulo de la organizacion bajada",
				bajar_organizacion.getOrganizaciones()[1].getTitle(),
				nueva_organizacion1.getOrganizaciones()[0].getTitle());
		assertEquals("Comparando identificador de la organizacion bajada",
				bajar_organizacion.getOrganizaciones()[1].getIdentifier(),
				nueva_organizacion1.getOrganizaciones()[0].getIdentifier());

		// SEGUNDO: bajar la organizacion que está en la ultima posicion
		servicio.bajarOrganization(
				identificador_manifest, identificador_nueva_organization1);
		OdeVO bajar_organizacion2 = servicio.cargarManifest(identificador_manifest);
		assertTrue(bajar_organizacion2.getIdentifier().equals(
				identificador_manifest2));
		assertTrue(bajar_organizacion2.getOrganizaciones().length == 3);
		assertEquals("Comparando titulo de la organizacion1",
				bajar_organizacion2.getOrganizaciones()[1].getTitle(),
				title1_nueva_organizacion);
		assertEquals("Comparando identificador de la organizacion1",
				bajar_organizacion2.getOrganizaciones()[1].getIdentifier(),
				identificador_nueva_organization1);

		// TERCERO: subir una organizacion que no existe
		servicio.bajarOrganization(
				identificador_manifest, identificador_organizacion2);
		OdeVO bajar_organizacion3 = servicio.cargarManifest(identificador_manifest);
		assertTrue(bajar_organizacion3.getIdentifier().equals(
				identificador_manifest2));
		assertTrue(bajar_organizacion3.getOrganizaciones().length == 3);
		assertEquals("Comparando titulo de la organizacion1",
				bajar_organizacion3.getOrganizaciones()[2].getTitle(),
				title2_nueva_organizacion);
		assertEquals("Comparando identificador de la organizacion1",
				bajar_organizacion3.getOrganizaciones()[2].getIdentifier(),
				identificador_nueva_organization2);

	}

	/**
	 * TEST copiarElementos TODO: Implementar el test para el metodo
	 * copiarElementos del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testCopiarElementos() {
		// Crear un grupo nuevo debajo del grupo ya existente e le introduzco la
		// informacion correspondiente
		String identificador_manifest = "CON_SUBM";
		String identificador_nuevo_grupo = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD694";
		String title_nuevo_grupo = "prueba_copiar_elementos";
		String identificador_grupo = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
		String identificador_organizacion = "ORG-1407CA53DF6A0791B2C82466F69C4BB1";

		GrupoVO grupo = new GrupoVO();
		grupo.setIdentifier(identificador_nuevo_grupo);
		grupo.setTitle(title_nuevo_grupo);
		servicio.crearGrupo(identificador_manifest,
				grupo, identificador_grupo);

		// almaceno en el array de elementos el grupo desde donde quiero copiar
		String[] elementos = new String[1];
		elementos[0] = identificador_grupo;

		// llamo al metodo copiar elementos
		servicio.copiarElementos(
				identificador_manifest, elementos, identificador_nuevo_grupo);
		OdeVO copiar_elementos2 = servicio.cargarManifest(identificador_manifest);

		// COMPROBACIONES
		// PRIMERO: Se hayan creado los grupos
		assertTrue(copiar_elementos2.getOrganizaciones().length == 1); // array
																		// de
																		// organizaciones
		assertTrue(copiar_elementos2.getOrganizaciones()[0].getGrupos().length == 1); // array
																						// de
																						// grupo
																						// primer
																						// nivel
		assertTrue(copiar_elementos2.getOrganizaciones()[0].getGrupos()[0]
				.getGrupos().length == 1); // array grupo 2º nivel
		assertTrue(copiar_elementos2.getOrganizaciones()[0].getGrupos()[0]
				.getGrupos()[0].getGrupos().length == 1);// array grupo
															// tercer nivel
		assertTrue(copiar_elementos2.getOrganizaciones()[0].getGrupos()[0]
				.getGrupos()[0].getGrupos()[0].getGrupos().length == 1); // array
																			// grupo
																			// cuarto
																			// nivel
		// SEGUNDO: El grupo "1" y "3" tengan el mismo title y distinto
		// identificador e idem con el "2" y "4"
		assertEquals("Comparando titulo grupo1 y 3", copiar_elementos2
				.getOrganizaciones()[0].getGrupos()[0].getTitle(),
				copiar_elementos2.getOrganizaciones()[0].getGrupos()[0]
						.getGrupos()[0].getGrupos()[0].getTitle());
		assertNotSame("Comparando identificador grupo1 y 3", copiar_elementos2
				.getOrganizaciones()[0].getGrupos()[0].getIdentifier(),
				copiar_elementos2.getOrganizaciones()[0].getGrupos()[0]
						.getGrupos()[0].getGrupos()[0].getIdentifier());

		assertEquals("Comparando titulo grupo2 y 4", copiar_elementos2
				.getOrganizaciones()[0].getGrupos()[0].getGrupos()[0]
				.getTitle(), copiar_elementos2.getOrganizaciones()[0]
				.getGrupos()[0].getGrupos()[0].getGrupos()[0].getGrupos()[0]
				.getTitle());
		assertNotSame("Comparando identificador grupo2 y 4", copiar_elementos2
				.getOrganizaciones()[0].getGrupos()[0].getGrupos()[0]
				.getTitle(), copiar_elementos2.getOrganizaciones()[0]
				.getGrupos()[0].getGrupos()[0].getGrupos()[0].getGrupos()[0]
				.getIdentifier());

		String[] elementos2 = new String[1];
		elementos2[0] = identificador_nuevo_grupo;
		servicio.copiarElementos(
				identificador_manifest, elementos2, identificador_organizacion);
		OdeVO copiar_elementos3 = servicio.cargarManifest(identificador_manifest);
		assertTrue(copiar_elementos3.getOrganizaciones().length == 1); // array
																		// de
																		// organizaciones
		assertTrue(copiar_elementos3.getOrganizaciones()[0].getGrupos().length == 2);

	}

	/**
	 * TEST moverElementos TODO: Implementar el test para el metodo
	 * moverElementos del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testMoverElementos() {
		// Crear un grupo nuevo debajo del grupo ya existente e le introduzco la
		// informacion correspondiente
		String identificador_manifest = "CON_SUBM";
		String identificador_nuevo_grupo = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD694";
		String title_nuevo_grupo = "prueba_mover_elementos";
		String identificador_nuevo_grupo2 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD695";
		String title_nuevo_grupo2 = "prueba_mover_elementos2";
		String identificador_grupo = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
		String identificador_organizacion = "ORG-1407CA53DF6A0791B2C82466F69C4BB1";
		String title_grupo1 = "Actividad Flash sobre los específico del medio publicitario";

		GrupoVO grupo = new GrupoVO();
		grupo.setIdentifier(identificador_nuevo_grupo);
		grupo.setTitle(title_nuevo_grupo);
		servicio.crearGrupo(identificador_manifest,
				grupo, identificador_grupo);

		// Creo un nuevo grupo que es hijo de la organizacion ya creada
		GrupoVO grupo2 = new GrupoVO();
		grupo2.setIdentifier(identificador_nuevo_grupo2);
		grupo2.setTitle(title_nuevo_grupo2);
		servicio.crearGrupo(identificador_manifest,
				grupo2, identificador_organizacion);

		// Almaceno en el array de elementos el grupo desde donde quiero mover
		String[] elementos = new String[1];
		elementos[0] = identificador_grupo;

		// Llamo al metodo moverElementos. Muevo el grupo que desciende de la
		// posicion 0 del primer array de grupos y lo muevo a la posicion 1.
		servicio.moverElementos(
				identificador_manifest, elementos, identificador_nuevo_grupo2);
		OdeVO mover_elementos3 = servicio.cargarManifest(identificador_manifest);

		// COMPROBACIONES
		// Ha movido los elementos correctamente y el identificador sigue siendo
		// el mismo
		assertTrue(mover_elementos3.getOrganizaciones().length == 1);// array
																		// de
																		// organizaciones
		assertTrue(mover_elementos3.getOrganizaciones()[0].getGrupos().length == 1); // array
																						// de
																						// grupo
																						// primer
																						// nivel
		assertTrue(mover_elementos3.getOrganizaciones()[0].getGrupos()[0]
				.getGrupos().length == 1); // array grupo 2º nivel
		assertTrue(mover_elementos3.getOrganizaciones()[0].getGrupos()[0]
				.getGrupos()[0].getGrupos().length == 1);// array grupo
															// tercer nivel
		assertEquals("Comparando titulo grupo1", mover_elementos3
				.getOrganizaciones()[0].getGrupos()[0].getTitle(),
				title_nuevo_grupo2);
		assertEquals("Comparando identificador grupo1", mover_elementos3
				.getOrganizaciones()[0].getGrupos()[0].getIdentifier(),
				identificador_nuevo_grupo2);
		assertEquals("Comparando titulo grupo2", mover_elementos3
				.getOrganizaciones()[0].getGrupos()[0].getGrupos()[0]
				.getTitle(), title_grupo1);
		assertEquals("Comparando identificador grupo2", mover_elementos3
				.getOrganizaciones()[0].getGrupos()[0].getGrupos()[0]
				.getIdentifier(), identificador_grupo);
		assertEquals("Comparando titulo grupo3", mover_elementos3
				.getOrganizaciones()[0].getGrupos()[0].getGrupos()[0]
				.getGrupos()[0].getTitle(), title_nuevo_grupo);
		assertEquals("Comparando identificador grupo3", mover_elementos3
				.getOrganizaciones()[0].getGrupos()[0].getGrupos()[0]
				.getGrupos()[0].getIdentifier(), identificador_nuevo_grupo);

	}

	/**
	 * TEST AsociarSecuencia TODO: Implementar el test para el metodo
	 * AsociarSecuancia del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testAsociarSecuencia()

	{
		String identificador_manifest = "CON_SUBM";
		String identificador_grupo = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
		String title_grupo = "Actividad Flash sobre los específico del medio publicitario";
		String identificador_nuevo_grupo = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD694";
		String title_nuevo_grupo = "prueba_asociar_secuencia";
		Boolean Choice = new Boolean(true);
		Boolean choiceExit = new Boolean(true);
		Boolean flow = new Boolean(true);
		Boolean forwardOnly = new Boolean(true);
		Boolean prueba_Choice = new Boolean(true);
		Boolean prueba_choiceExit = new Boolean(true);
		Boolean prueba_flow = new Boolean(true);
		Boolean prueba_forwardOnly = new Boolean(true);

		// Creo un nuevo grupo debajo del ya existente
		GrupoVO grupo = new GrupoVO();
		grupo.setIdentifier(identificador_nuevo_grupo);
		grupo.setTitle(title_nuevo_grupo);
		servicio.crearGrupo(identificador_manifest,
				grupo, identificador_grupo);

		// Creo un nuevo Controlmode
		ControlModeVO controlMode = new ControlModeVO();
		controlMode.setChoice(Choice);
		controlMode.setChoiceExit(choiceExit);
		controlMode.setFlow(flow);
		controlMode.setForwardOnly(forwardOnly);

		// Le asocio una secuencia.
		servicio.asociarSecuencia(
				identificador_manifest, identificador_nuevo_grupo, controlMode);
		OdeVO asociar_secuencia2 = servicio.cargarManifest(identificador_manifest);

		// COMPROBACIONES
		assertTrue(asociar_secuencia2.getOrganizaciones()[0].getGrupos()[0]
				.getGrupos()[0].getSecuencia().length == 1);
		assertEquals("Comprobacion del Choice del controlMode",
				asociar_secuencia2.getOrganizaciones()[0].getGrupos()[0]
						.getGrupos()[0].getSecuencia()[0].getControlMode()
						.getChoice(), prueba_Choice);
		assertEquals("Comprobacion del ChoiceExit del controlMode",
				asociar_secuencia2.getOrganizaciones()[0].getGrupos()[0]
						.getGrupos()[0].getSecuencia()[0].getControlMode()
						.getChoiceExit(), prueba_choiceExit);
		assertEquals("Comprobacion del flow del controlMode",
				asociar_secuencia2.getOrganizaciones()[0].getGrupos()[0]
						.getGrupos()[0].getSecuencia()[0].getControlMode()
						.getFlow(), prueba_flow);
		assertEquals("Comprobacion del forwardOnly del controlMode",
				asociar_secuencia2.getOrganizaciones()[0].getGrupos()[0]
						.getGrupos()[0].getSecuencia()[0].getControlMode()
						.getForwardOnly(), prueba_forwardOnly);

	}

	/**
	 * TEST testCrearReferenciaEnCache TODO: Implementar el test para el metodo
	 * testCrearReferenciaEnCache del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testCrearReferenciaEnCache() {
		String identificador_manifest = "CON_SUBM";
		String identificador_submanifest = "MANIFEST-49BA2CAB-23E8-BF28-85C4-535C652E6DD2";

		// Crear referencia en cache del submanifiesto creado en la ejecucion
		servicio.crearReferenciaEnCache(
				identificador_manifest, identificador_submanifest);

		// Llamar al metodo cargar manifest con el identificador del
		// submanifiesto
		OdeVO crear_referencia = servicio
				.cargarManifest(identificador_submanifest);

		// COMPROBACIONES
		assertEquals("Comprobacion ode referenciado es el submanifiesto",
				crear_referencia.getIdentifier(), identificador_submanifest);

	}

	/**
	 * TEST desagregarSubmanifiestoLocal TODO: Implementar el test para el
	 * metodo desagregarSubmanifiestoLocal del servicio
	 * SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testdesagregarSubmanifiestoLocal() {

		String identificador_manifest = "CON_SUBM";
		String localizador = "SIN_SUBM";
		String identificador_submanifest = "MANIFEST-49BA2CAB-23E8-BF28-85C4-535C652E6DD2";// ya
																							// existe
		String subId1 = null;

		// crear referencia en cache

		Boolean crear_referencia_cache2 = servicio.crearReferenciaEnCache(
				identificador_manifest, identificador_submanifest);
		DataHandler desagregar_local = servicio.desagregarSubmanifiestoLocal(
				identificador_manifest, identificador_submanifest, subId1);
		OdeVO cargar_manifest = servicio.cargarManifest(identificador_manifest);
		assertTrue(cargar_manifest.getSubmanifiestos().length == 1);

		// Agregar el manifiestorepositorio descendiendo de un submanifiesto;
		// subId1=identificador_determinado
		// Primero creo una referencia en la cache para el submanifiesto
		servicio.agregarManifiestoRepositorio(
				identificador_manifest, localizador, identificador_submanifest);
		OdeVO agrega_manif = servicio.cargarManifest(identificador_manifest);
		assertTrue(agrega_manif.getSubmanifiestos().length == 1);
		assertTrue(agrega_manif.getSubmanifiestos()[0].getSubmanifiestos().length == 1);

		String id = agrega_manif.getSubmanifiestos()[0].getSubmanifiestos()[0]
				.getIdentifier();

		Boolean crear_referencia_cache = servicio.crearReferenciaEnCache(
				identificador_manifest, id);
		DataHandler desagregar_local2 = servicio.desagregarSubmanifiestoLocal(
				identificador_manifest, id, identificador_submanifest);
		OdeVO cargar_manifest2 = servicio
				.cargarManifest(identificador_manifest);
		assertTrue(cargar_manifest2.getSubmanifiestos().length == 1);
		assertTrue(cargar_manifest2.getSubmanifiestos()[0].getSubmanifiestos().length == 1);

	}

	/**
	 * TEST eliminarSubmanifiesto TODO: Implementar el test para el metodo
	 * eliminarSubmanifiesto del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testeliminarSubmanifiesto() {

		String identificador_manifest = "CON_SUBM";
		String identificador_submanifest = "MANIFEST-49BA2CAB-23E8-BF28-85C4-535C652E6DD2";

		OdeVO cargar_manifiesto = servicio
				.cargarManifest(identificador_manifest);
		assertTrue(cargar_manifiesto.getSubmanifiestos().length == 1);
		servicio.eliminarSubmanifiesto(
				identificador_manifest, identificador_submanifest,null);
		OdeVO eliminar_submanifiesto = servicio.cargarManifest(identificador_manifest);
		assertTrue(eliminar_submanifiesto.getSubmanifiestos().length == 0);
	}

	/**
	 * TEST desagregarSubmanifiestoRepositorio TODO: Implementar el test para el
	 * metodo desagregarSubmanifiestoRepositorio del servicio
	 * SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testdesagregarSubmanifiestoRepositorio() {
		try {
			
		
		String identificador_manifest = "CON_SUBM";
		String localizador = "SIN_SUBM";
		String identificador_submanifest = "MANIFEST-49BA2CAB-23E8-BF28-85C4-535C652E6DD2";// ya
																							// existe
		String subId1 = null;

		// crear referencia en cache
		Boolean crear_referencia_cache2 = servicio.crearReferenciaEnCache(
				identificador_manifest, identificador_submanifest);
		servicio.desagregarSubmanifiestoRepositorio(identificador_manifest,
				identificador_submanifest, subId1);
		OdeVO cargar_manifest = servicio.cargarManifest(identificador_manifest);
		assertTrue(cargar_manifest.getSubmanifiestos().length == 1);

		// Agregar el manifiestorepositorio descendiendo de un submanifiesto;
		// subId1=identificador_determinado
		// Primero creo una referencia en la cache para el submanifiesto
		servicio
		.agregarManifiestoRepositorio(identificador_manifest,
				localizador, identificador_submanifest);
		OdeVO agrega_manif_repositorio2 = servicio.cargarManifest(identificador_manifest);
		assertTrue(agrega_manif_repositorio2.getSubmanifiestos().length == 1);
		assertTrue(agrega_manif_repositorio2.getSubmanifiestos()[0]
				.getSubmanifiestos().length == 1);

		String id = agrega_manif_repositorio2.getSubmanifiestos()[0]
				.getSubmanifiestos()[0].getIdentifier();
		Boolean crear_referencia_cache3 = servicio.crearReferenciaEnCache(
				identificador_manifest, id);

		servicio.desagregarSubmanifiestoRepositorio(identificador_manifest, id,
				identificador_submanifest);
		OdeVO cargar_manifest2 = servicio
				.cargarManifest(identificador_manifest);
		assertTrue(cargar_manifest2.getSubmanifiestos().length == 1);
		} catch (Exception e) {
			logger.error(e);
			fail("Excepcion inesperada " + e.getMessage());
		}
	}

	/**
	 * TEST iniciarNuevoODE TODO: Implementar el test para el metodo
	 * iniciarNuevoODE del servicio SrvGestorManifestService.
	 * 
	 * @throws Exception
	 */
	// FUNCIONA
	public void testiniciarNuevoODE() throws Exception {

		String user = "user";
		String identificador_manifest = "CON_SUBM";

		Properties props = new Properties();
		InputStream is = this.getClass().getResourceAsStream(
				"/empaquetador.properties");
		if (is == null) {
			fail("No se ha podido leer empaquetador.properties");
		}
		props.load(is);

		/*
		 * Suprimo la copia de schemas a la carpeta schemas del servidor. Los
		 * schemas deberian estar en el servidor dado que son un requisito del
		 * Validador.
		 */

		// Llamo al metodo
		OdeVO iniciar_ode = servicio.iniciarNuevoODE(user,"","");
		// Compruebo que hay una organizacion
		assertTrue(iniciar_ode.getOrganizaciones().length == 1);
		// Compruebo que no hay resursos
		assertTrue(iniciar_ode.getRecursos().length == 0);

	}

	/**
	 * TEST editarODE TODO: Implementar el test para el metodo editarODE del
	 * servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testeditarODE() {

		String identificador_manifest = "SIN_SUBM";
		String prueba_backup = "test_empaquetador/backup/SIN_SUBM.zip";

		File prueba = new File(prueba_backup);
		
		OdeVO editar_ode = servicio.editarODE(identificador_manifest);
		assertTrue(editar_ode.getOrganizaciones().length == 1);
		// Comprobar que ha creado el backup
		assertTrue(prueba.exists());

		//se prueb
		identificador_manifest = "prueb";
		String prueba_backup2 = "test_empaquetador/backup/prueb.zip";

		//se prueba un manifiest sin imsmanifest.xml
		File prueba2 = new File(prueba_backup2);
		editar_ode = servicio.editarODE(identificador_manifest);
		assertTrue(editar_ode.getOrganizaciones().length == 1);
		// Comprobar que ha creado el backup
		assertTrue(prueba2.exists());
	}

	/**
	 * TEST terminarEdicion TODO: Implementar el test para el metodo
	 * terminarEdicion del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testterminarEdicion() {

		String identificador_manifest = ODE_PRUEBAS;
		String prueba_backup = "test_empaquetador/backup/CON_SUBM.zip";
		File prueba = new File(prueba_backup);

		// Llamo al metodo
		servicio.terminarEdicion(identificador_manifest);

		// compruebo ha eliminado el zip
		assertFalse(prueba.exists());

	}

	/**
	 * TEST asociarLom TODO: Implementar el test para el metodo asociarLom del
	 * servicio SrvGestorManifestService.
	 */

	public void testasociarLom() {

		String identificador_manifest = "CON_SUBM";
		String idElemento = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
		// Para todas las opciones menos cuando es un archivo
		String href1 = null;
		// Para cuando es un archivo
		String href2 = "RES-1937E17748FA68C8270AA65D7691BB67contenido/actividad.html";

		servicio.prepararCatalogacion(identificador_manifest, idElemento, href1);
		servicio.asociarLom(identificador_manifest, idElemento, href1);

		servicio.prepararCatalogacion(identificador_manifest, idElemento, href2);
		servicio.asociarLom(identificador_manifest, idElemento, href2);

	}

	/**
	 * TEST prepararCatalogacion TODO: Implementar el test para el metodo
	 * prepararCatalogacion del servicio SrvGestorManifestService.
	 */
	// FUNCIONA
	public void testprepararCatalogacion() {

		String identificador_manifest = "CON_SUBM";
		String idElemento = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
		String href1 = null;// Todas las opciones menos que es un archivo
		String idElemento2 = "RES-1937E17748FA68C8270AA65D7691BB67";
		String href2 = "contenido/actividad.html";// es un archivo
		String id_href = "RES-1937E17748FA68C8270AA65D7691BB67contenido/actividad.html";

		// PRIMERO: Llamo al metodo preparar catalogacion con href=null
		String preparar_catalogacion = servicio.prepararCatalogacion(
				identificador_manifest, idElemento, href1);
		OdeVO cargar_manifest = servicio.cargarManifest(identificador_manifest);
		// COMPROBACIONES
		assertEquals(
				"Comprobacion el identificador es igual al valor devuelto",
				idElemento, preparar_catalogacion);

		// SEGUNDO: Llamo al metodo preparar catalogacion con
		// href="valor_determinado"
		String preparar_catalogacion2 = servicio.prepararCatalogacion(
				identificador_manifest, idElemento2, href2);
		OdeVO cargar_manifest2 = servicio
				.cargarManifest(identificador_manifest);
		// COMPROBACIONES
		assertEquals(
				"Comprobacion el identificador es igual al valor devuelto",
				id_href, preparar_catalogacion2);

	}

	/**
	 * TEST importarRecursos TODO: Implementar el test para el metodo
	 * importarRecursos del servicio SrvGestorManifestService.
	 */

	public void testimportarRecursos() {

		String identificador_manifest = "CON_SUBM";
		String identificador_submanifest = "MANIFEST-49BA2CAB-23E8-BF28-85C4-535C652E6DD2";// ya
																							// existe
		String nombrefichero = "recurso_ejemplo.zip";
		String idSub = null;
		String recursoImportado = "RES-76b5dacf-d389-3dbf-8612-d3c320f054d1";
		String localizador = "SIN_SUBM";

		// Creo el paqueteScorm
		java.net.URL url = this.getClass().getResource("/" + nombrefichero);
		String ruta = url.getFile();
		java.io.File ficheroZip = new File(ruta);
		DataSource source = new FileDataSource(ficheroZip);
		DataHandler paqueteScorm = new DataHandler(source);

		// Llamo al metodo. Primer caso inserto en el principal
		servicio.importarRecursos(
				identificador_manifest, paqueteScorm, idSub);
		OdeVO importarRecursos = servicio.cargarManifest(identificador_manifest);
		assertTrue(importarRecursos.getRecursos().length == 2);

		Boolean crear_referencia_cache2 = servicio.crearReferenciaEnCache(
				identificador_manifest, identificador_submanifest);
		servicio
		.importarRecursos(identificador_manifest, paqueteScorm,
				identificador_submanifest);
		OdeVO importarRecursos2 = servicio.cargarManifest(identificador_manifest);

	}

	/**
	 * TEST exportarRecursos TODO: Implementar el test para el metodo
	 * exportarRecursos del servicio SrvGestorManifestService.
	 */

	public void testexportarRecursos() {

		String id_manifest = "CON_SUBM";
		String id_submanifest = null;
		String identificador_recurso = "RES-1937E17748FA68C8270AA65D7691BB67";
		String[] recursos = new String[1];
		recursos[0] = identificador_recurso;
		String nombre = "Prueba";

		DataHandler recurso_exportado = servicio.exportarRecursos(id_manifest,
				recursos, id_submanifest, nombre);
		File ficheroGenerado = new File("test_empaquetador/MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8/../temp/CON_SUBM/../Prueba.zip");
		assertTrue(
				"El fichero se ha generado",
				ficheroGenerado.isFile());

		String id_submanifest2 = "MANIFEST-49BA2CAB-23E8-BF28-85C4-535C652E6DD2";
		String identificador_recurso2 = "RES-733DA9EE-0734-81E0-25DA-8DC4002293A9";

		String[] recursos2 = new String[1];
		recursos2[0] = identificador_recurso2;
		String nombre2 = "Prueba2";

		// crear referencia en cache del submanifest cuando no es null
		servicio.crearReferenciaEnCache(id_manifest, id_submanifest2);

		DataHandler recurso_exportado2 = servicio.exportarRecursos(id_manifest,
				recursos2, id_submanifest2, nombre2);
		ficheroGenerado = new File("test_empaquetador/MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C8/../temp/CON_SUBM/../Prueba2.zip");
		assertTrue(
				"El fichero generado existe (Para recursos de un submanifiesto)",
				ficheroGenerado.isFile());
	}

	public void testasociarDatosItem(){
		String identificador = "ode_datos_item";
		String idElemento = "WELCOME";
		TimeLimitActionVO timeLimitAction = null;
		DataFromLMSVO dataFromLMS = null;
		CompletionThresholdVO completionThreshold = null;
		PresentationVO presentation = null;
		
		//Presentation
		presentation = new PresentationVO();
		NavigationInterfaceVO navigationInterface = new NavigationInterfaceVO();
		HideLMSUIVO[] hideLMSUI = new HideLMSUIVO[2];
		HideLMSUIVO hide1= new HideLMSUIVO();
		HideLMSUIVO hide2= new HideLMSUIVO();
		hide1.setContent("exit");
		hide2.setContent("exitAll2");
		hideLMSUI[0]=hide1;
		hideLMSUI[1]=hide2;
		
		//DataFromLMS
		dataFromLMS = new DataFromLMSVO();
		dataFromLMS.setContent("Pepe");
		
		
		navigationInterface.setHideLMSUI(hideLMSUI);
		presentation.setNavigationInterface(navigationInterface);
		
		servicio.asociarDatosItem(identificador, idElemento, timeLimitAction, dataFromLMS, completionThreshold, presentation);
	
		//Presentation
		presentation = new PresentationVO();
		navigationInterface = new NavigationInterfaceVO();
		hideLMSUI = new HideLMSUIVO[2];
		hide1= new HideLMSUIVO();
		hide2= new HideLMSUIVO();
		hide1.setContent("continue");
		hide2.setContent("exitAll");
		hideLMSUI[0]=hide1;
		hideLMSUI[1]=hide2;
		
		//DataFromLMS
		timeLimitAction = new TimeLimitActionVO();
		timeLimitAction.setContent("time");
		
		//CompletionThreshold
		completionThreshold = new CompletionThresholdVO();
		completionThreshold.setContent(new Double("0.25"));
		
		navigationInterface.setHideLMSUI(hideLMSUI);
		presentation.setNavigationInterface(navigationInterface);
		
		servicio.asociarDatosItem(identificador, idElemento, timeLimitAction, dataFromLMS, completionThreshold, presentation);
		
		
	}
	
	protected final es.pode.localizador.negocio.servicios.SrvLocalizadorService getSrvLocalizadorService()
			throws java.lang.Exception {

		return localizador;

	}

	public SrvCatalogacionBasicaService getCatalogacion() {
		return catalogacion;
	}

}

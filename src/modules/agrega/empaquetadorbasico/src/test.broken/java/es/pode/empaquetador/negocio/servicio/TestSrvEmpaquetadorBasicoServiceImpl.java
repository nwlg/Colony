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
import java.rmi.RemoteException;
import java.util.Arrays;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import net.sf.dozer.util.mapping.MapperIF;

import org.apache.log4j.Logger;

import es.pode.empaquetador.negocio.externos.ScormDao;
import es.pode.empaquetador.negocio.utilidades.FileStringComparator;
import es.pode.empaquetador.negocio.utilidades.ItemStringComparator;
import es.pode.empaquetador.negocio.utilidades.ResourceStringComparator;
import es.pode.empaquetador.negocio.utilidades.Utilidades;
import es.pode.localizador.negocio.servicios.LocalizadorVO;
import es.pode.localizador.negocio.servicios.SrvLocalizadorService;
import es.pode.localizador.negocio.servicios.SrvLocalizadorServiceServiceLocator;
import es.pode.parseadorXML.ParseadorException;
import es.pode.parseadorXML.SCORM2004Dao;
import es.pode.parseadorXML.castor.Item;
import es.pode.parseadorXML.castor.Manifest;
import es.pode.parseadorXML.castor.Resource;
import es.pode.parseadorXML.scorm2004.agrega.ManifestAgrega;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;
import es.pode.soporte.uuid.PodeUUIDGenerator;

/**
 * @see SrvEmpaquetadorBasicoServiceImpl
 * TODO: To execute test on services that invoke webservices which implement security,
 * you must include the next param to the java virtual machine:
 * -Daxis.ClientConfigFile=client-config.wsdd
 */
public class TestSrvEmpaquetadorBasicoServiceImpl
    extends SrvEmpaquetadorBasicoServiceImplBase
{

	private static Logger logger = Logger.getLogger(TestSrvEmpaquetadorBasicoServiceImpl.class);
	
	private Utilidades  utilidades =null;

	private SCORM2004Dao scormDao = null;
	
	private CacheEmpaquetacion cacheEmpaquetacion = null;
	
	private SrvLocalizadorService localizador = null;
	
	private static String idOde = "MANIFEST-A09C57BFD9E2313044F1D6AC99DD31D1";
	
	private SrvGestorManifestService gsManifestService = null;
	
	private SrvGestorArchivosService gsArchivosService = null;
	
    /**
     * Constructor
     */
     public TestSrvEmpaquetadorBasicoServiceImpl(){
		super();
		
		try {
		localizador = (new SrvLocalizadorServiceServiceLocator()).getSrvLocalizadorService();
		} catch (Exception e) {
			logger.error("No se pudo obtener referencia al localizador.",e);
			fail("No se pudo obtener referencia al localizador.");
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
 		/*
 		 *  Inicio el contexto Agegi para autenticar el usuario empaquetador 
 		 */
 		logger.info("Autenticando usuario empaquetador con password empaquetador");
// 		UserDetails user = new User("empaquetador", "1", true, false, true, true, new GrantedAuthority[0]);
 		try {
 			super.initAthenticationUser("empaquetador", "empaquetador");
 		} catch (Exception e) {
 			logger.error(e);
 			fail("Error de construccion del test durante la autenticacion");
 		}
 		try {
 			 utilidades = (Utilidades)applicationContext.getBean("utilidades");
 			 scormDao = (ScormDao)applicationContext.getBean("ScormDao");
 			 cacheEmpaquetacion = (CacheEmpaquetacion)applicationContext.getBean("cacheEmpaquetacion");
 			 gsManifestService = (SrvGestorManifestService)applicationContext.getBean("srvGestorManifestService");
 			 gsArchivosService = (SrvGestorArchivosService)applicationContext.getBean("srvGestorArchivosService");
 		} catch (Exception e) {
 			logger.error("Error leyendo el application-context",e);
 			fail("Error leyendo el application-context");
 		}
 		/*
 		 * Cargar el manifest de pruebas
 		 * MANIFEST-A09C57BFD9E2313044F1D6AC99DD31D1 en la cache
 		 */
 		java.io.File odeInClassPath = null;
 		java.io.File odeAltInClassPath = null;
 		try {
 			boolean flag = false;
 			odeInClassPath = utilidades.obtenerRecursoClassPathAsFile(idOde);
 			String idOdeAlt = "MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C9";
 			odeAltInClassPath = utilidades.obtenerRecursoClassPathAsFile(idOdeAlt);
 			
 			if(odeInClassPath != null && odeInClassPath.exists()) {
 				
 				Manifest manifest = scormDao.parsearODELazy(new File(odeInClassPath,"imsmanifest.xml"));
 				LocalizadorVO locOde = localizador.consultaLocalizador(idOde);
 				String path = locOde.getPath();
 				File pathFile = new File(path);
 				if(!pathFile.exists()) {
 					flag= pathFile.mkdirs();
 					if(!flag) fail("No se ha podido crear la carpeta del localizador : " + path);
 				}
 				logger.debug("Copiando de " + odeInClassPath.getCanonicalPath() + " a " + pathFile.getCanonicalPath());
 				UtilesFicheros.copiar(odeInClassPath, pathFile);
 				
 				cacheEmpaquetacion.put(idOde, manifest);
 			} else {
 				fail("El recurso" + idOde + "no esta en el classpath");
 			}
 			if(odeInClassPath != null && odeInClassPath.exists()) {
 				LocalizadorVO locOde = localizador.consultaLocalizador(idOdeAlt);
 				String path = locOde.getPath();
 				File pathFile = new File(path);
 				if(!pathFile.exists()) {
 					flag= pathFile.mkdirs();
 					if(!flag) fail("No se ha podido crear la carpeta del localizador : " + path);
 				}
 				logger.debug("Copiando de " + odeInClassPath.getCanonicalPath() + " a " + pathFile.getCanonicalPath());
 				UtilesFicheros.copiar(odeAltInClassPath, pathFile);
 			} else {
 				fail("El recurso" + idOde + "no esta en el classpath");
 			}
 		} catch (Exception e) {
 			logger.error("Error en setup: " , e);
 		}
 	}

     /**
      * onTearDownInTransaction
      */

 	 protected void onTearDownInTransaction() {

      	/**
      	 * Implementar si no desea usar DataSets
      	 */
     	 // Borro localizador del ODE
 		 try {
 			 
 			 File pathFile = new File("test_empaquetador");
 			 UtilesFicheros.eliminar(pathFile);
 		 } catch (Exception e) {
 			 logger.error("No se pudo eliminar el ODE de pruebas",e);
 		 } finally {
 			 super.onTearDownInTransaction();
 		 }

      }


    /**
     * testInicial
     * 	 En el caso de tener que el metodo ${operation.name} acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvEmpaquetadorBasicoServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */	
     public void testInicial(){
		OdeVO resultado = null;
		try {
			logger.info("Probando el resultado del setup()");
			
			resultado = gsManifestService.cargarManifest(idOde);
			assertTrue("No se ha encontrado el Manifest a traves de SrvGestorManifestService.", resultado instanceof OdeVO);
		} catch (Exception e) {
			logger.error("Error al recuperar el OdeVO a traves de GestorManifest",e);
			fail("Error al recuperar el OdeVO a traves de GestorManifest");
		}
	}


    /**
     *   TEST editarOde
     * 	 En el caso de tener que el metodo editarOde acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvEmpaquetadorBasicoServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
public void testeditarOde() {
    	 
    	 
    	 try {
    	 OdeVO ode_editado= servicio.editarOde(idOde);
    	 
    	 Manifest manifest = (Manifest) cacheEmpaquetacion.get(ode_editado.getIdentifier());
    	 assertNotNull("El manifest en la cache es null",manifest);
    	 
    	 ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);
    	 
    	 
    	 assertTrue (manifestAgrega.getManifest().getOrganizations().getOrganization().length==1);
    	 assertTrue (manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem().length==4);
    	 assertTrue (manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(1).getItem().length==1);
    	 assertTrue (manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(3).getItem().length==3);
    	 assertTrue (manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(3).getItem(1).getItem().length==1);
    	 
    	 assertResourceFromItem(manifestAgrega, manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(0).getIdentifierref());
    	 assertResourceFromItem(manifestAgrega, manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(2).getIdentifierref());
    	 
    	 assertResourceFromItem(manifestAgrega, manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(3).getItem(0).getIdentifierref());
    	 assertResourceFromItem(manifestAgrega, manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(3).getItem(2).getIdentifierref());
    	 
    	 assertTrue (manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(1).getItem().length==1);
    	 assertTrue (manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(1).getItem(0).getItem().length==1);

    	 assertResourceFromItem(manifestAgrega, manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(1).getItem(0).getItem(0).getIdentifierref());
    	 
    	 assertTrue (manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(3).getItem(1).getItem().length==1);
    	 assertTrue (manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(3).getItem(1).getItem(0).getItem().length==1);
    	 
    	 assertResourceFromItem(manifestAgrega, manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(3).getItem(1).getItem(0).getItem(0).getIdentifierref());
    	 } catch (Exception e) {
    		 logger.error(e);
    		 fail("Error inesperado " + e.getMessage());
    	 }
    }

	private void assertResourceFromItem(ManifestAgrega manifestAgrega, String idRef) throws ParseadorException {
		Resource res1 = manifestAgrega.obtenerResource(idRef);
    	 assertNotNull("No se encuentra el recurso " + manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem(0).getIdentifierref(), res1);
	}

	private FicheroVO obtainFicheroVOFromTestResources(String resource) {
   	 File fichero = utilidades.obtenerRecursoClassPathAsFile(resource);
   	 DataHandler dh = new DataHandler(new FileDataSource(fichero));
   	 FicheroVO ficheroVO = new FicheroVO();
   	 ficheroVO.setDatos(dh);
   	 ficheroVO.setNombre(fichero.getName());
   	 return ficheroVO;
    }
   
    public void testagregarLocalFichero() {
		FicheroVO fichero = obtainFicheroVOFromTestResources("ncarpeta/atardecer.jpg");
		String idGrupo = null;
		try {
			Manifest manifest = cacheEmpaquetacion.comprobarManifest(idOde);
			ManifestAgrega ma = new ManifestAgrega(manifest);
			idGrupo = manifest.getOrganizations().getDefault();
			this.servicio.agregarLocal(idOde, fichero, idGrupo);
			
			assertEquals("El numero de items no es el esperado.",4, manifest.getOrganizations().getOrganization(0).getItemCount());
			Item item = manifest.getOrganizations().getOrganization(0).getItem(3);
			assertEquals("El titulo del item creado no es correcto",fichero.getNombre(), item.getTitle());
			assertNotNull("Falta el idRef del item creado", item.getIdentifierref());
			Resource res = ma.obtenerResource(item.getIdentifierref());
			assertNotNull("Falta el recurso referenciado", res);
			assertEquals("El href del recurso no es correcto",item.getIdentifier() + "/" + fichero.getNombre(), res.getHref());
			assertEquals("El numero de files es incorrecto",1, res.getFile().length);
			assertEquals("El href del file no es correcto",item.getIdentifier() + "/" + fichero.getNombre(), res.getFile()[0].getHref());
		} catch (Exception e ) {
			logger.error(e);
			fail("Fallo inesperado " + e.getMessage());
		}
   }
    
    public void testagregarLocalArchivo() {
   	 FicheroVO fichero = obtainFicheroVOFromTestResources("material.zip");
		String idGrupo = "ORG-1407CA53DF6A0791B2C82466F69C4BB1";
		try {
			this.servicio.agregarLocal(idOde, fichero, idGrupo);
			Manifest manifest = cacheEmpaquetacion.comprobarManifest(idOde);
			ManifestAgrega ma = new ManifestAgrega(manifest);
			assertEquals("El numero de items no es el esperado.",4, manifest.getOrganizations().getOrganization(0).getItemCount());
			Item item = manifest.getOrganizations().getOrganization(0).getItem(3);
			assertEquals("El titulo del item creado no es correcto",fichero.getNombre(), item.getTitle());
			assertNotNull("Falta el idRef del item creado", item.getIdentifierref());
			assertFilesInResource(ma, item,16);
		} catch (Exception e ) {
			logger.error(e);
			fail("Fallo inesperado " + e.getMessage());
		}
    }
    
    public void testagregarLocalRCP() {
   	 FicheroVO fichero = obtainFicheroVOFromTestResources("recurso_ejemplo.zip");
 		String idGrupo = "ORG-1407CA53DF6A0791B2C82466F69C4BB1";
 		
 		try {
			this.servicio.agregarLocal(idOde, fichero, idGrupo);
			Manifest manifest = cacheEmpaquetacion.comprobarManifest(idOde);
			ManifestAgrega ma = new ManifestAgrega(manifest);
			assertEquals("El numero de items no es el esperado.",4, manifest.getOrganizations().getOrganization(0).getItemCount());
			Item item = manifest.getOrganizations().getOrganization(0).getItem(3);
			assertEquals("El titulo del item creado no es correcto",fichero.getNombre(), item.getTitle());
			assertEquals("El numero de hijos del item no es correcto ",1, item.getItemCount());
			assertNotNull("Falta el idRef del item hijo creado", item.getItem(0).getIdentifierref());
			assertFilesInResource(ma, item.getItem(0),2);
 		} catch (Exception e ) {
			logger.error(e);
			fail("Fallo inesperado " + e.getMessage());
		}
    }
    
    public void testagregarLocalManifest() {
   	 FicheroVO fichero = obtainFicheroVOFromTestResources("sd02_oa04_actividad_campanias_publicitarias.zip");
  		String idGrupo = "ORG-1407CA53DF6A0791B2C82466F69C4BB1";
  		
  		try {
 			this.servicio.agregarLocal(idOde, fichero, idGrupo);
 			Manifest manifest = cacheEmpaquetacion.comprobarManifest(idOde);
 			ManifestAgrega ma = new ManifestAgrega(manifest);
			assertEquals("El numero de items no es el esperado.",5, manifest.getOrganizations().getOrganization(0).getItemCount());
			Item item = manifest.getOrganizations().getOrganization(0).getItem(3);
			assertEquals("El titulo del item creado no es correcto","Actividad Flash sobre planificación de campañas publicitarias", item.getTitle());
			assertEquals("El numero de hijos del item creado es incorrecto",1, item.getItemCount());
			Item itemOrg = item.getItem(0);
			assertEquals("El titulo del item de la organizacion no es correcto","Actividad Flash sobre planificación de campañas publicitarias", itemOrg.getTitle());
			assertEquals("El numero de hijos del item de la organizacion es incorrecto",1, itemOrg.getItemCount());
			Item itemAgregado = itemOrg.getItem(0);
			assertEquals("El titulo del item de la organizacion no es correcto","Actividad Flash sobre planificación de campañas publicitarias", itemAgregado.getTitle());
			assertEquals("El numero de hijos del item de la organizacion es incorrecto",0, itemAgregado.getItemCount());
			assertNotNull("El item agregado no tiene idRef", itemAgregado.getIdentifierref());
			assertFilesInResource(ma, itemAgregado,5);
			assertEquals("No hay submanifiestos despues de agregar ", 0, manifest.getManifestCount());
  		} catch (Exception e ) {
			logger.error(e);
			fail("Fallo inesperado " + e.getMessage());
		}
    }

	private void assertFilesInResource(ManifestAgrega ma, Item itemAgregado, int numFiles) throws ParseadorException, RemoteException {
		Resource res = ma.obtenerResource(itemAgregado.getIdentifierref());
		assertNotNull("Falta el recurso referenciado", res);
		assertEquals("El numero de files es incorrecto",numFiles, res.getFile().length);
		LocalizadorVO localizador = this.localizador.consultaLocalizador(idOde);
		for(int i=0;i<res.getFile().length;i++) {
			File file = new File(localizador.getPath() + "/" + res.getFile(i).getHref());
			assertTrue("El fichero " + file.getPath() + " no se encuentra en el servidor", file.isFile());
		}
	}

    /**
     *   TEST referenciadoPor
     * 	 En el caso de tener que el metodo referenciadoPor acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvEmpaquetadorBasicoServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     * @throws Exception 
     */
     public void testreferenciadoPor() throws Exception {
		
    	Manifest manifest=(Manifest) cacheEmpaquetacion.get(idOde);
    	ManifestAgrega manifestAgrega= new ManifestAgrega (manifest);
    	 		
    	String fich1="actividad.html";
   	 	String carpetaPadre="contenido";
   	 	ArchivoVO arch1=new ArchivoVO();
   	 	arch1.setCarpetaPadre(carpetaPadre);
		arch1.setEsFichero(Boolean.TRUE);
		arch1.setNombre(fich1);
		
		String href="contenido/actividad.html";
		String idElementoReferenciado="";
		
		GrupoVO[] referenciados=servicio.referenciadoPor(idOde, arch1);
		
		for (int i=0;i<referenciados.length;i++){
			
			idElementoReferenciado=referenciados[i].getElementoReferenciado();
			
			assertNotNull ("El elemento esta siendo referenciado por el recurso "+ idElementoReferenciado,manifestAgrega.obtenerElemento(idElementoReferenciado, href));
		}
		
		String fich2="xml.xsd";
   	 	String carpetaPadre2=idOde;
   	 	ArchivoVO arch2=new ArchivoVO();
   	 	arch2.setCarpetaPadre(carpetaPadre2);
		arch2.setEsFichero(Boolean.TRUE);
		arch2.setNombre(fich2);
		
		String href2=idOde.concat("/xml.xsd");
		String idElementoReferenciado2="";
		
		GrupoVO[] referenciados2=servicio.referenciadoPor(idOde, arch2);
		
		for (int i=0;i<referenciados2.length;i++){
			
			idElementoReferenciado2=referenciados2[i].getElementoReferenciado();
			
			assertNull (manifestAgrega.obtenerElemento(idElementoReferenciado2, href2));
		}
		    
     }

    /**
     *   TEST eliminarFicheros
     *   TODO: Implementar el test para el metodo eliminarFicheros del servicio SrvEmpaquetadorBasicoService.
     * 	 En el caso de tener que el metodo eliminarFicheros acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvEmpaquetadorBasicoServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testeliminarFicheros() {
    	 ArchivoVO arch1 = new ArchivoVO();
    	 ArchivoVO arch2 = new ArchivoVO();
    	 try {
	    	 // Recupero el localizador
	    	 LocalizadorVO loc = localizador.consultaLocalizador(idOde);
	    	 // Borro dos ficheros: uno de manifiesto principal y otro de submanifiesto
	    	 arch1.setNombre("actividad.html");
	    	 arch1.setCarpetaPadre("contenido");
	    	 arch1.setContenidos(new ArchivoVO[]{});
	    	 arch1.setEsProtegido(Boolean.FALSE);
	    	 arch1.setEsFichero(Boolean.TRUE);
	    	 arch1.setHref(loc.getPath() + "/" + arch1.getCarpetaPadre() + "/" + arch1.getNombre());
	    	 
	    	 arch2.setNombre("contenido");
	    	 arch2.setCarpetaPadre("submanifest1");
	    	 arch2.setContenidos(new ArchivoVO[]{});
	    	 arch2.setEsProtegido(Boolean.FALSE);
	    	 arch2.setEsFichero(Boolean.FALSE);
	    	 arch2.setHref(loc.getPath() + "/" + arch1.getCarpetaPadre() + "/" + arch1.getNombre());
	    	 
	    	 // Obtengo referencias a manifest
	    	 Manifest manifest = cacheEmpaquetacion.comprobarManifest(idOde);
	    	 ManifestAgrega ma = new ManifestAgrega(manifest);
	    	 
	    	 // Elimino los ficheros
	    	 servicio.eliminarFicheros(idOde, new ArchivoVO[]{arch1,arch2}, true);
	    	 
	    	 // Compruebo la eliminacion de los files en el manifest
	    	 // Fichero manifest principal contenido/actividad.html
	    	 assertNotSame("El file contenido/actividad.html no ha sido borrado", "contenido/actividad.html", manifest.getResources().getResource(0).getFile()[0].getHref());
	    	 assertNotSame("El href del recurso (contenido/actividad.html) no ha sido modificado", "contenido/actividad.html", manifest.getResources().getResource(0).getHref());
	    	 // Ficheros bajo contenidos de submanifiesto
	    	 assertEquals("No se han borrado los objetos file del submanifiesto",0, manifest.getManifest(0).getResources().getResource(0).getFile().length);
	    	 assertNull("El href del recurso en el submanifiesto sigue siendo != null",manifest.getManifest(0).getResources().getResource(0).getHref());
	    	 
    	 } catch (Exception e) {
    		 logger.error(e);
    		 fail("Error inesperado");
    	 }
    }

     
    public void testrenombrarFichero() {
    	String carpetaPadre = "contenido";
    	String nombre = "actividad.html";
    	String nuevoNombre = "actividad_modificado.html";
    	testRenombrar(carpetaPadre, nombre, nuevoNombre);
    	try {
			Manifest manifest = cacheEmpaquetacion.comprobarManifest(idOde);
			assertEquals("No se ha renombrado la referencia al fichero contenido/actividad.html", carpetaPadre.concat("/").concat(nuevoNombre), manifest.getResources().getResource(0).getFile()[0].getHref());
			assertEquals("No se ha renombrado el href del recurso (antes contenido/actividad.html)", carpetaPadre.concat("/").concat(nuevoNombre), manifest.getResources().getResource(0).getHref());
			assertEquals("Se ha modificado un file incorrecto", "contenido/actividad/2.swf", manifest.getResources().getResource(0).getFile()[1].getHref());
			assertEquals("El base del submanifiesto ha cambiado", "submanifest1/", manifest.getManifest(0).getBase());
			assertEquals("Se ha modificado un recurso del submanifiesto", "contenido/index.html", manifest.getManifest(0).getResources().getResource(0).getHref());
			assertEquals("Se ha modificado un recurso del submanifiesto", "contenido/index.html", manifest.getManifest(0).getResources().getResource(0).getFile()[0].getHref());
		} catch (Exception e) {
			logger.error("Error inesperado", e);
			fail("Error inesperado");
		}
    }
    
    public void testrenombrarCarpeta() {
		String carpetaPadre = null;
		String nombre = "contenido";
		String nuevoNombre = "contenido_modificado";
		testRenombrar(carpetaPadre, nombre, nuevoNombre);
		try {
			Manifest manifest = cacheEmpaquetacion.comprobarManifest(idOde);
			assertEquals("No se ha renombrado la referencia al fichero contenido/actividad.html", nuevoNombre.concat("/").concat("actividad.html"), manifest.getResources().getResource(0).getFile()[0].getHref());
			assertEquals("No se ha renombrado la referencia al fichero contenido/actividad/2.swf", nuevoNombre.concat("/").concat("actividad/2.swf"), manifest.getResources().getResource(0).getFile()[1].getHref());
			assertEquals("No se ha renombrado el href del recurso (antes contenido/actividad.html)", nuevoNombre.concat("/actividad.html"), manifest.getResources().getResource(0).getHref());
			assertEquals("El base del submanifiesto ha cambiado", "submanifest1/", manifest.getManifest(0).getBase());
			assertEquals("Se ha modificado un recurso del submanifiesto", "contenido/index.html", manifest.getManifest(0).getResources().getResource(0).getHref());
			assertEquals("Se ha modificado un recurso del submanifiesto", "contenido/index.html", manifest.getManifest(0).getResources().getResource(0).getFile()[0].getHref());
		} catch (Exception e) {
			logger.error("Error inesperado", e);
			fail("Error inesperado");
		}
		
	}

	private void testRenombrar(String carpetaPadre, String nombre, String nuevoNombre) {
		try {
			servicio.renombrar(idOde, carpetaPadre, nombre, nuevoNombre);
		} catch (Exception e) {
			logger.error("Error inesperado", e);
			fail("Error inesperado");
		}
	}

	public void testrenombrarCarpetaSubmanifest() {
		String carpetaPadre = "submanifest1";
		String nombre = "contenido";
		String nuevoNombre = "contenido_modificado";
		testRenombrar(carpetaPadre, nombre, nuevoNombre);
		try {
			Manifest manifest = cacheEmpaquetacion.comprobarManifest(idOde);
			assertEquals("Se ha renombrado incorrectamente la referencia al fichero contenido/actividad.html", "contenido/actividad.html", manifest.getResources().getResource(0).getFile()[0].getHref());
			assertEquals("Se ha renombrado incorrectamente el href del recurso (antes contenido/actividad.html)", "contenido/actividad.html", manifest.getResources().getResource(0).getHref());
			assertEquals("Se ha modificado un file incorrecto", "contenido/actividad/2.swf", manifest.getResources().getResource(0).getFile()[1].getHref());
			assertEquals("El base del submanifiesto ha cambiado", "submanifest1/", manifest.getManifest(0).getBase());
			assertEquals("No se ha modificado un recurso del submanifiesto", nuevoNombre.concat("/index.html"), manifest.getManifest(0).getResources().getResource(0).getHref());
			assertEquals("No se ha modificado un recurso del submanifiesto", nuevoNombre.concat("/index.html"), manifest.getManifest(0).getResources().getResource(0).getFile()[0].getHref());
			assertEquals("No se ha modificado incorrectamente un file del submanifiesto", nuevoNombre.concat("/css/radio_estilo.css"), manifest.getManifest(0).getResources().getResource(0).getFile()[3].getHref());
		} catch (Exception e) {
			logger.error("Error inesperado", e);
			fail("Error inesperado");
		}
	}
	
	public void testrenombrarFicheroSubmanifest() {
		String carpetaPadre = "submanifest1/contenido";
		String nombre = "index.html";
		String nuevoNombre = "index_modificado.html";
		testRenombrar(carpetaPadre, nombre, nuevoNombre);
		try {
			Manifest manifest = cacheEmpaquetacion.comprobarManifest(idOde);
			assertEquals("Se ha renombrado incorrectamente la referencia al fichero contenido/actividad.html", "contenido/actividad.html", manifest.getResources().getResource(0).getFile()[0].getHref());
			assertEquals("Se ha renombrado incorrectamente el href del recurso (antes contenido/actividad.html)", "contenido/actividad.html", manifest.getResources().getResource(0).getHref());
			assertEquals("Se ha modificado un file incorrecto", "contenido/actividad/2.swf", manifest.getResources().getResource(0).getFile()[1].getHref());
			assertEquals("El base del submanifiesto ha cambiado", "submanifest1/", manifest.getManifest(0).getBase());
			assertEquals("No se ha modificado un recurso del submanifiesto", "contenido/".concat(nuevoNombre), manifest.getManifest(0).getResources().getResource(0).getHref());
			assertEquals("No se ha modificado un recurso del submanifiesto", "contenido/".concat(nuevoNombre), manifest.getManifest(0).getResources().getResource(0).getFile()[0].getHref());
			assertEquals("No se ha modificado incorrectamente un file del submanifiesto", "contenido/css/radio_estilo.css", manifest.getManifest(0).getResources().getResource(0).getFile()[3].getHref());
		} catch (Exception e) {
			logger.error("Error inesperado", e);
			fail("Error inesperado");
		}
	}

	public void testrenombrarBaseSubmanifest() {
		String carpetaPadre = null;
		String nombre = "submanifest1";
		String nuevoNombre = "submanifest_modificado";
		testRenombrar(carpetaPadre, nombre, nuevoNombre);
		try {
			Manifest manifest = cacheEmpaquetacion.comprobarManifest(idOde);
			assertEquals("Se ha renombrado incorrectamente la referencia al fichero contenido/actividad.html", "contenido/actividad.html", manifest.getResources().getResource(0).getFile()[0].getHref());
			assertEquals("Se ha renombrado incorrectamente el href del recurso (antes contenido/actividad.html)", "contenido/actividad.html", manifest.getResources().getResource(0).getHref());
			assertEquals("Se ha modificado un file incorrecto", "contenido/actividad/2.swf", manifest.getResources().getResource(0).getFile()[1].getHref());
			assertEquals("El base del submanifiesto no ha cambiado", nuevoNombre.concat("/"), manifest.getManifest(0).getBase());
			assertEquals("Se ha modificado un recurso del submanifiesto", "contenido/index.html", manifest.getManifest(0).getResources().getResource(0).getHref());
			assertEquals("Se ha modificado un recurso del submanifiesto", "contenido/index.html", manifest.getManifest(0).getResources().getResource(0).getFile()[0].getHref());
		} catch (Exception e) {
			logger.error("Error inesperado", e);
			fail("Error inesperado");
		}
	}
     
    public void testcortar() {
    	try {
    		LocalizadorVO loc = localizador.consultaLocalizador(idOde);
    		Manifest manifest = cacheEmpaquetacion.comprobarManifest(idOde);
    		String destino = "destino";
    		java.io.File fDestino = new java.io.File(loc.getPath(),destino);
    		boolean creada = fDestino.mkdirs();
    		assertTrue("No se ha creado la carpeta de destino",creada);
    		// Archivos a cortar
    		ArchivoVO arch1 = new ArchivoVO();
    		arch1.setNombre("fondo_amarillo.gif");
    		arch1.setCarpetaPadre("contenido/imagenes");
    		arch1.setEsFichero(Boolean.TRUE);
    		arch1.setContenidos(new ArchivoVO[]{});
//    		 Archivos a cortar
    		ArchivoVO arch2 = new ArchivoVO();
    		arch2.setNombre("index_17.gif");
    		arch2.setCarpetaPadre("contenido/imagenes");
    		arch2.setEsFichero(Boolean.TRUE);
    		arch2.setContenidos(new ArchivoVO[]{});
    		
    		// Muevo archivos
    		servicio.cortar(idOde, destino, new ArchivoVO[]{arch1,arch2});
    		
    		// Asserts
    		assertEquals("El fichero fondo_amarillo.gif no se ha renombrado correctamente",destino.concat("/").concat(arch1.getNombre()), manifest.getResources().getResource(0).getFile()[3].getHref());
    		assertEquals("El fichero index_17.gif no se ha renombrado correctamente",destino.concat("/").concat(arch2.getNombre()), manifest.getResources().getResource(0).getFile()[4].getHref());
    		
    	} catch(Exception e) {
    		logger.error(e);
    		fail(e.getMessage());
    	}
    }
    
    /**
	 * TEST desagregarItem TODO: Implementar el test para el metodo
	 * desagregarItem del servicio SrvEmpaquetadorBasicoService. En el caso de
	 * tener que el metodo desagregarItem acceda a un webservice el cuál
	 * implementa seguridad (se necesita la autenticación de usuario), antes de
	 * invocarlo en el test, se debe establecer un usuario con derechos de
	 * acceso utilizando el método
	 * {@link es.indra.servicios.SrvEmpaquetadorBasicoServiceImplBase#initAthenticationUser(String, String) 
	 * initAuthenticationUser(authenticationUser, authenticationPassword)}
	 */
     public void testdesagregarItemLocal() {
		try {
			MapperIF mapper = (MapperIF)applicationContext.getBean("beanMapper");
			Manifest manifest = cacheEmpaquetacion.comprobarManifest(idOde);
			Item item = manifest.getOrganizations().getOrganization(0).getItem(0);
			GrupoVO grupo = (GrupoVO)mapper.map(item, GrupoVO.class);
			DataHandler resultado = servicio.desagregarItemLocal(idOde, new GrupoVO[]{grupo});
			logger.info("Resultado de desagregar local : " + resultado);
			
			
			assertNotNull("DataHandler != null ",resultado);
			
		} catch (Exception e) {
			logger.error(e);
			fail("Error inesperado");
		}
    }
     
     private final es.pode.validador.negocio.servicio.SrvValidadorService getSrvValidadorService()
			throws java.lang.Exception {

		String srvValidadorServiceFile = "importedServices.properties";
		java.io.InputStream srvValidadorServiceInputStream = SrvEmpaquetadorBasicoServiceBase.class
				.getClassLoader().getResourceAsStream(srvValidadorServiceFile);
		java.util.Properties srvValidadorServiceProperties = new java.util.Properties();
		srvValidadorServiceProperties.load(srvValidadorServiceInputStream);
		String srvValidadorServiceEndPointAddress = "";
		srvValidadorServiceEndPointAddress = (String) srvValidadorServiceProperties
				.get("srvValidadorServicePort");
		System.out
				.println("srvValidadorServiceEndPointAddress del fichero --> "
						+ srvValidadorServiceEndPointAddress);
		es.pode.validador.negocio.servicio.SrvValidadorServiceService srvValidadorService = new es.pode.validador.negocio.servicio.SrvValidadorServiceServiceLocator();
		if (srvValidadorServiceEndPointAddress.length() > 0)
			((es.pode.validador.negocio.servicio.SrvValidadorServiceServiceLocator) srvValidadorService)
					.setSrvValidadorServiceEndpointAddress(srvValidadorServiceEndPointAddress);
		es.pode.validador.negocio.servicio.SrvValidadorService port = srvValidadorService
				.getSrvValidadorService();
		return port;

	}
     
     public void testdesagregarItemRepositorio() {
    	 try {
    		MapperIF mapper = (MapperIF)applicationContext.getBean("beanMapper");
    		Manifest manifest = cacheEmpaquetacion.comprobarManifest(idOde);
 			Item item = manifest.getOrganizations().getOrganization(0).getItem(0);
 			GrupoVO grupo = (GrupoVO)mapper.map(item, GrupoVO.class);
 			String resultado = servicio.desagregarItem(idOde, new GrupoVO[]{grupo});
 			LocalizadorVO desagregado = localizador.consultaLocalizador(resultado);
 			String path = desagregado.getPath() + "/imsmanifest.xml";
 			assertTrue("No se encuentra el imsmanifest del ODE desagregado", (new File(path)).exists());
 		} catch (Exception e) {
 			logger.error(e);
 			fail("Error inesperado");
 		}
     }

    /**
     *   TEST crearObjetoEmbebido
     *   TODO: Implementar el test para el metodo crearObjetoEmbebido del servicio SrvEmpaquetadorBasicoService.
     * 	 En el caso de tener que el metodo crearObjetoEmbebido acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvEmpaquetadorBasicoServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testcrearObjetoEmbebido() {
    	try {
    		ArchivoVO result = servicio.crearObjetoEmbebido(idOde, "<p>Test unitario de crearObjetoEmbebido</p>");
    		java.io.File fResult = new File(result.getHref());
    		assertTrue("El fichero creado no se encuentra",fResult.isFile());
    	} catch (Exception e) {
    		logger.error(e);
    		fail(e.getMessage());
    	}
    }

    /**
     *   TEST agregarRepositorio
     * 	 En el caso de tener que el metodo agregarRepositorio acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvEmpaquetadorBasicoServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testagregarRepositorio() {
    	 try {
    	 //pruebo a agregarlo al principal
    	 
    	 String idOdeAgregar ="MANIFEST-A09C57BFD9E2313044F1D6AC99DD31C9";
    	String idPadre = "ORG-1407CA53DF6A0791B2C82466F69C4BB1";
    	 Manifest manifest = (Manifest) cacheEmpaquetacion.get(idOde);
    	 ManifestAgrega manifestAgrega = new ManifestAgrega (manifest);
    	 
    	 servicio.agregarRepositorio(idOde, idOdeAgregar, idPadre);
    	 
    	 assertEquals ("El numero de items no es correcto",5,manifestAgrega.getManifest().getOrganizations().getOrganization(0).getItem().length);
    	 Item item = manifest.getOrganizations().getOrganization(0).getItem(3);
			assertEquals("El titulo del item creado no es correcto","Actividad Flash sobre planificación de campañas publicitarias", item.getTitle());
			assertEquals("El numero de hijos del item creado es incorrecto",1, item.getItemCount());
			Item itemOrg = item.getItem(0);
			assertEquals("El titulo del item de la organizacion no es correcto","Actividad Flash sobre planificación de campañas publicitarias", itemOrg.getTitle());
			assertEquals("El numero de hijos del item de la organizacion es incorrecto",1, itemOrg.getItemCount());
			Item itemAgregado = itemOrg.getItem(0);
			assertEquals("El titulo del item de la organizacion no es correcto","Actividad Flash sobre planificación de campañas publicitarias", itemAgregado.getTitle());
			assertEquals("El numero de hijos del item de la organizacion es incorrecto",0, itemAgregado.getItemCount());
			assertNotNull("El item agregado no tiene idRef", itemAgregado.getIdentifierref());
			assertFilesInResource(manifestAgrega, itemAgregado,5);
			assertEquals("No hay submanifiestos despues de agregar ", 0, manifest.getManifestCount());
    	 }catch(Exception e) {
    		 logger.error("Error inesperado ",e);
    		 fail("Error inesperado " + e.getMessage());
    	 }
    }

     /**
 	 * TEST asociarContenidos En el caso de tener que el metodo
 	 * asociarContenidos acceda a un webservice el cuál implementa seguridad (se
 	 * necesita la autenticación de usuario), antes de invocarlo en el test, se
 	 * debe establecer un usuario con derechos de acceso utilizando el método
 	 * {@link es.indra.servicios.SrvEmpaquetadorBasicoServiceImplBase#initAthenticationUser(String, String) 
 	 * initAuthenticationUser(authenticationUser, authenticationPassword)}
 	 */
 	public void testasociarContenidos() {
 		try {
 			// Asociación de array vacío
 			FileVO[] ficheros = new FileVO[0];
 			String idGrupo = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
 			String url = "www.elpais.com";

 			servicio.asociarContenidos(idOde, idGrupo, ficheros, url);
 			Manifest manifest = (Manifest) cacheEmpaquetacion.get(idOde);
 			Item[] items = manifest.getOrganizations().getOrganization(0)
 					.getItem();
 			Item item = items[Arrays.binarySearch(items, idGrupo,
 					new ItemStringComparator())];
 			String idResource = item.getIdentifierref();

 			Resource[] resources = manifest.getResources().getResource();
 			Resource resource = resources[Arrays.binarySearch(resources,
 					idResource, new ResourceStringComparator())];
 			assertEquals("No se encuentra el contenido asociado a " + idGrupo,
 					url, resource.getHref());

 			// Asociación de fichero a item existente
 			ficheros = new FileVO[1];
 			ficheros[0] = new FileVO();
 			String idFile = "sd02_oa04_actividad_campanias_publicitarias.zip";
 			ficheros[0].setHref(idFile);

 			servicio.asociarContenidos(idOde, idGrupo, ficheros, ficheros[0]
 					.getHref());
 			manifest = (Manifest) cacheEmpaquetacion.get(idOde);
 			items = manifest.getOrganizations().getOrganization(0).getItem();
 			item = items[Arrays.binarySearch(items, idGrupo,
 					new ItemStringComparator())];
 			idResource = item.getIdentifierref();

 			resources = manifest.getResources().getResource();
 			resource = resources[Arrays.binarySearch(resources, idResource,
 					new ResourceStringComparator())];
 			es.pode.parseadorXML.castor.File[] files = resource.getFile();
 			assertEquals("No se encuentra el fichero asociado", Integer
 					.toString(0), Integer.toString(Arrays.binarySearch(files,
 					idFile, new FileStringComparator())));

 			// Asociación de fichero a item con recurso no existente
 			// 1º obtenemos lista de items de primera organización
 			manifest = (Manifest) cacheEmpaquetacion.get(idOde);
 			items = manifest.getOrganizations().getOrganization(0).getItem();
 			// Creamos item nuevo
 			Item newItem = new Item();
 			newItem.setIdentifier(PodeUUIDGenerator.getRecursoUUID(String
 					.valueOf(java.lang.Math.random())));
 			String newItemId = newItem.getIdentifier();

 			// Añadimos nuevo item
 			Item[] newItems = new Item[items.length + 1];
 			for (int i = 0; i < items.length; i++) {
 				newItems[i] = items[i];
 			}
 			newItems[newItems.length - 1] = newItem;
 			manifest.getOrganizations().getOrganization(0).setItem(newItems);

 			// Al fin, nuestra prueba
 			servicio.asociarContenidos(idOde, newItemId, ficheros, ficheros[0]
 					.getHref());

 			Manifest manifest2 = (Manifest) cacheEmpaquetacion.get(idOde);
 			Item[] items2 = manifest2.getOrganizations().getOrganization(0)
 					.getItem();
 			Item item2 = items2[Arrays.binarySearch(items2, newItemId,
 					new ItemStringComparator())];
 			String idResource2 = item2.getIdentifierref();

 			Resource[] resources2 = manifest2.getResources().getResource();
 			Resource resource2 = resources2[Arrays.binarySearch(resources2,
 					idResource2, new ResourceStringComparator())];
 			es.pode.parseadorXML.castor.File[] files2 = resource2.getFile();
 			assertNotSame("No se encuentra el fichero asociado", Integer
 					.toString(-1), Integer.toString(Arrays.binarySearch(files2,
 					idFile, new FileStringComparator())));

 			// Volvemos a lista anterior de items
 			manifest.getOrganizations().getOrganization(0).setItem(items);
 		} catch (Exception e) {
 			logger.error(e);
 			fail("Error inesperado " + e.getMessage());
 		}
 	}

 	/**
	 * TEST eliminarGrupo En el caso de tener que el metodo eliminarGrupo acceda
	 * a un webservice el cuál implementa seguridad (se necesita la
	 * autenticación de usuario), antes de invocarlo en el test, se debe
	 * establecer un usuario con derechos de acceso utilizando el método
	 * {@link es.indra.servicios.SrvEmpaquetadorBasicoServiceImplBase#initAthenticationUser(String, String) 
	 * initAuthenticationUser(authenticationUser, authenticationPassword)}
	 */
	public void testeliminarGrupo() {
		try {
			Boolean eliminarFicheros = Boolean.TRUE;

			// Pruebo a eliminar un grupo que cuelga de otro grupo

			String idGrupo = "MANIFEST-49BA2CAB-23E8-BF28-85C4-535C652E6DD2";
			String idRec = "RES-733DA9EE-0734-81E0-25DA-8DC4002293A9";
			String href = "contenido/index.html";
			String href2 = "contenido/bibliogra.html";

			servicio.eliminarGrupo(idOde, idGrupo, eliminarFicheros);

			Manifest manifest = (Manifest) cacheEmpaquetacion.get(idOde);
			ManifestAgrega manifestAgrega = new ManifestAgrega(manifest);

			assertEquals(0, manifestAgrega.getManifest().getOrganizations()
					.getOrganization(0).getItem(2).getItemCount());

			// Pruebo a eliminar un grupo que cuelga de una organizacion
			String idGrupo2 = "ITEM-C0B1ECC9ADE44FDDBB72F0E4871DD699";
			String idRec2 = "RES-1937E17748FA68C8270AA65D7691BB67";
			String href3 = "contenido/actividad.html";

			servicio.eliminarGrupo(idOde, idGrupo2, eliminarFicheros);

			assertEquals(2, manifestAgrega.getManifest().getOrganizations()
					.getOrganization(0).getItemCount());
			
			es.pode.parseadorXML.castor.File[] ficheros2 = new es.pode.parseadorXML.castor.File[manifestAgrega.obtenerResource(idRec2).getFile().length];
			ficheros2 = manifestAgrega.obtenerResource(idRec2).getFile();

			for (int i = 0; i < ficheros2.length; i++) {
				assertFalse(ficheros2[i].getHref().equals(href3));
			}
		} catch (Exception e) {
			logger.error(e);
			fail("Error inesperado " + e.getMessage());
		}
	}
}
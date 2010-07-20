// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.agregador.negocio.agregador.servicio;

/**
 * @see SrvAgregadorRssServiceImpl
 * TODO: To execute test on services that invoke webservices which implement security,
 * you must include the next param to the java virtual machine:
 * -Daxis.ClientConfigFile=client-config.wsdd
 */
public class TestSrvAgregadorRssServiceImpl
    extends SrvAgregadorRssServiceImplBase
{


    /**
     * Constructor
     */
     public TestSrvAgregadorRssServiceImpl(){
		super();
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
     * 	 {@link es.indra.servicios.SrvAgregadorRssServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */	
     public void testInicial(){
		String prueba = null;
		this.initAthenticationUser("usuario", "ibuilder"); 
		assertNotNull(prueba);
	}
	
	
    /**
     *   TEST crearXML
     *   TODO: Implementar el test para el metodo crearXML del servicio SrvAgregadorRssService.
     * 	 En el caso de tener que el metodo crearXML acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAgregadorRssServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testcrearXML() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST devuelveFeeds
     *   TODO: Implementar el test para el metodo devuelveFeeds del servicio SrvAgregadorRssService.
     * 	 En el caso de tener que el metodo devuelveFeeds acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAgregadorRssServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testdevuelveFeeds() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST devuelveRssBusqueda
     *   TODO: Implementar el test para el metodo devuelveRssBusqueda del servicio SrvAgregadorRssService.
     * 	 En el caso de tener que el metodo devuelveRssBusqueda acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAgregadorRssServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testdevuelveRssBusqueda() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST eliminarFichero
     *   TODO: Implementar el test para el metodo eliminarFichero del servicio SrvAgregadorRssService.
     * 	 En el caso de tener que el metodo eliminarFichero acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAgregadorRssServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testeliminarFichero() {
		String prueba = null; 
		assertNotNull(prueba);

    }

	
	
	
}
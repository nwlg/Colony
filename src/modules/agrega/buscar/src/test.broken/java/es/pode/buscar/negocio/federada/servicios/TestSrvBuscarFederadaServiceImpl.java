// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.buscar.negocio.federada.servicios;

/**
 * @see SrvBuscarFederadaServiceImpl
 * TODO: To execute test on services that invoke webservices which implement security,
 * you must include the next param to the java virtual machine:
 * -Daxis.ClientConfigFile=client-config.wsdd
 */
public class TestSrvBuscarFederadaServiceImpl
    extends SrvBuscarFederadaServiceImplBase
{


    /**
     * Constructor
     */
     public TestSrvBuscarFederadaServiceImpl(){
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
     * 	 {@link es.indra.servicios.SrvBuscarFederadaServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */	
     public void testInicial(){
		String prueba = null;
		this.initAthenticationUser("usuario", "ibuilder"); 
		assertNotNull(prueba);
	}
	
	
    /**
     *   TEST busquedaFederada
     *   TODO: Implementar el test para el metodo busquedaFederada del servicio SrvBuscarFederadaService.
     * 	 En el caso de tener que el metodo busquedaFederada acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvBuscarFederadaServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testbusquedaFederada() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST solicitarDocsCountArbolCurricular
     *   TODO: Implementar el test para el metodo solicitarDocsCountArbolCurricular del servicio SrvBuscarFederadaService.
     * 	 En el caso de tener que el metodo solicitarDocsCountArbolCurricular acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvBuscarFederadaServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testsolicitarDocsCountArbolCurricular() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST buscarDocsNodoArbolCurricular
     *   TODO: Implementar el test para el metodo buscarDocsNodoArbolCurricular del servicio SrvBuscarFederadaService.
     * 	 En el caso de tener que el metodo buscarDocsNodoArbolCurricular acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvBuscarFederadaServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testbuscarDocsNodoArbolCurricular() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST estoyActivo
     *   TODO: Implementar el test para el metodo estoyActivo del servicio SrvBuscarFederadaService.
     * 	 En el caso de tener que el metodo estoyActivo acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvBuscarFederadaServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testestoyActivo() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST obtenerIdentificadorNodo
     *   TODO: Implementar el test para el metodo obtenerIdentificadorNodo del servicio SrvBuscarFederadaService.
     * 	 En el caso de tener que el metodo obtenerIdentificadorNodo acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvBuscarFederadaServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testobtenerIdentificadorNodo() {
		String prueba = null; 
		assertNotNull(prueba);

    }

	
	
	
}
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.contenidos.negocio.logs.servicio;

/**
 * @see SrvLogServiceImpl
 */
public class TestSrvLogServiceImpl
    extends SrvLogServiceImplBase
{


    /**
     * Constructor
     */
     public TestSrvLogServiceImpl(){
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
     */	
     public void testInicial(){
		String prueba = null;
		assertNotNull(prueba);
	}
	
	
    /**
     *   TEST listarFicherosLog
     *   TODO: Implementar el test para el metodo listarFicherosLog del servicio SrvLogService.
     */
     public void testlistarFicherosLog() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST eliminarFicheroLog
     *   TODO: Implementar el test para el metodo eliminarFicheroLog del servicio SrvLogService.
     */
     public void testeliminarFicheroLog() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST recuperarFicheroLog
     *   TODO: Implementar el test para el metodo recuperarFicheroLog del servicio SrvLogService.
     */
     public void testrecuperarFicheroLog() {
		String prueba = null; 
		assertNotNull(prueba);

    }

	
	
	
}
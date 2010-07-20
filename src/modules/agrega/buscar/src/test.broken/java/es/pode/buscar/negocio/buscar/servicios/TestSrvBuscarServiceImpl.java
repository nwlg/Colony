/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.buscar.negocio.buscar.servicios;



/**
 * @see SrvBuscarServiceImpl
 */
public class TestSrvBuscarServiceImpl
    extends SrvBuscarServiceImplBase
{


    /**
     * Constructor
     */
     public TestSrvBuscarServiceImpl(){
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
     *   TEST buscarSimple
     *   TODO: Implementar el test para el metodo buscarSimple del servicio SrvBuscarService.
     */
     public void testbuscarSimple() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST buscarLomEs
     *   TODO: Implementar el test para el metodo buscarLomEs del servicio SrvBuscarService.
     */
     public void testbuscarLomEs() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST buscarAvanzado
     *   TODO: Implementar el test para el metodo buscarAvanzado del servicio SrvBuscarService.
     */
     public void testbuscarAvanzado() 
     {
    	 ParametrosBusquedaAvanzadaVO param= new ParametrosBusquedaAvanzadaVO();
    	 
    	 param.setIdiomaBusqueda("es");
    	 param.setIdiomaNavegacion("es");
    	 param.setPalabrasClave("magia");
    	 param.setComunidadPeticion("localhost");
    	 param.setNumeroResultados(new Integer(1000));
    	 param.setResultadosPorPagina(new Integer(10));
    	 param.setIdTesauro("hola");
    	 ResultadoBusquedaVO resultado = servicio.buscarAvanzado(param);
    	 
		
		assertNotNull(resultado);

    }

    /**
     *   TEST solicitarMetadato
     *   TODO: Implementar el test para el metodo solicitarMetadato del servicio SrvBuscarService.
     */
     public void testsolicitarMetadato() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST busquedaLocal
     *   TODO: Implementar el test para el metodo busquedaLocal del servicio SrvBuscarService.
     */
     public void testbusquedaLocal() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST busquedaFederada
     *   TODO: Implementar el test para el metodo busquedaFederada del servicio SrvBuscarService.
     */
     public void testbusquedaFederada() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST limpiarBusquedas
     *   TODO: Implementar el test para el metodo limpiarBusquedas del servicio SrvBuscarService.
     */
     public void testlimpiarBusquedas() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST generaIdentificadorSimple
     *   TODO: Implementar el test para el metodo generaIdentificadorSimple del servicio SrvBuscarService.
     */
     public void testgeneraIdentificadorSimple() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST generadorIdentificadorAvanzado
     *   TODO: Implementar el test para el metodo generadorIdentificadorAvanzado del servicio SrvBuscarService.
     */
     public void testgeneradorIdentificadorAvanzado() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST busquedaAvanzadaLocal
     *   TODO: Implementar el test para el metodo busquedaAvanzadaLocal del servicio SrvBuscarService.
     */
     public void testbusquedaAvanzadaLocal() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST solicitarDocsCountArbolCurricular
     *   TODO: Implementar el test para el metodo solicitarDocsCountArbolCurricular del servicio SrvBuscarService.
     */
     public void testsolicitarDocsCountArbolCurricular() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST buscarDocsNodoArbolCurricular
     *   TODO: Implementar el test para el metodo buscarDocsNodoArbolCurricular del servicio SrvBuscarService.
     */
     public void testbuscarDocsNodoArbolCurricular() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST busquedaDocsArbolCurricularLocal
     *   TODO: Implementar el test para el metodo busquedaDocsArbolCurricularLocal del servicio SrvBuscarService.
     */
     public void testbusquedaDocsArbolCurricularLocal() {
		String prueba = null; 
		assertNotNull(prueba);

    }

    /**
     *   TEST solicitudDocsCountArbolLocal
     *   TODO: Implementar el test para el metodo solicitudDocsCountArbolLocal del servicio SrvBuscarService.
     */
     public void testsolicitudDocsCountArbolLocal() {
		String prueba = null; 
		assertNotNull(prueba);

    }
     

	 public void testBuscarSQI() throws Exception {

	       ParamBusquedaSQIVO consulta = new ParamBusquedaSQIVO();

//	       consulta.setNumeroResultados(new Integer(10));

	       consulta.setOrigenPagina(new Integer(1));

	       consulta.setPalabrasClave("child");

	       consulta.setResultadoPorPagina(new Integer(100));

	       ResultadoBusquedaSQIVO resultado = servicio.buscarSQI(consulta);

	       LomEsVO[] lomes = resultado.getResultadoBusqueda();

	       for(int i=0;i<lomes.length;i++)

	       {

	             System.out.println("Titulo "+lomes[i].getTitulo());
	             System.out.println("Localizador "+ lomes[i].getLocalizacion());
	             System.out.println("Lomes "+lomes[i].getLomES());

	       }

	     }




	
	
	
}
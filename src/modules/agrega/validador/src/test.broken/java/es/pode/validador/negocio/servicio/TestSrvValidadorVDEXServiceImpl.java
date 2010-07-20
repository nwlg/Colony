/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.validador.negocio.servicio;

import org.apache.log4j.Logger;


/**
 * @see SrvValidadorVDEXServiceImpl
 */
public class TestSrvValidadorVDEXServiceImpl
    extends SrvValidadorVDEXServiceImplBase
{

	private static Logger logger = Logger.getLogger(TestSrvValidadorVDEXServiceImpl.class);
    /**
     * Constructor
     */
     public TestSrvValidadorVDEXServiceImpl(){
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
     */	
     public void testInicial(){

	}
	
	
    /**
     *   TEST obtenerValidacionTesauro
     *   
     */
     public void testObtenerValidacionTesauro01() 
     throws Exception 
     {
 		String tesauroBad="/xmls/tesauros/prueba_ok_es.xml";
	   	 java.net.URL fichero=null;
	   	 try 
	   	 {		
	   		 fichero = this.getClass().getResource(tesauroBad);
	   	 } 
	   	 catch (Exception e1)  
	   	 {
			logger.error(e1);
	   	 }

	   	 SrvValidadorVDEXService servicio= this.servicio;
		ValidaVdexVO valida= new ValidaVdexVO();
		valida= servicio.obtenerValidacionTesauro(fichero.getPath());

		assertEquals( valida.getValido().booleanValue(), true);
    }

     public void testObtenerValidadorTesauro02() 
     throws Exception 
     {
  		String tesauroBad="/xmls/tesauros/prueba_bad_es.xml";
	   	 java.net.URL fichero=null;
	   	 try 
	   	 {		
	   		fichero = this.getClass().getResource(tesauroBad);
	   	 } 
	   	 catch (Exception e1)  
	   	 {

	   		 logger.error(e1);
	   	 }

		SrvValidadorVDEXService servicio= this.servicio;
		ValidaVdexVO valida= new ValidaVdexVO();
		valida= servicio.obtenerValidacionTesauro(fichero.getPath());

		assertEquals( valida.getValido().booleanValue(), false);
		
	}
	
	public void testObtenerValidacionTaxonomias01()
	throws Exception 
	{
  		String taxonomia="/xmls/taxonomias/prueba_ok_es.xml";
	   	 java.net.URL fichero=null;
	   	 try 
	   	 {		
	   		fichero = this.getClass().getResource(taxonomia);
	   	 } 
	   	 catch (Exception e1)  
	   	 {

	   		 logger.error(e1);
	   	 }
		
		SrvValidadorVDEXService servicio= this.servicio;
		ValidaVdexVO valida= new ValidaVdexVO();
		valida= servicio.obtenerValidacionTaxonomia(fichero.getPath());
		
		assertEquals( valida.getValido().booleanValue(), true);		
	}
	
	public void testObtenerValidacionTaxonomias02()
	throws Exception 
	{
  		String taxonomia="/xmls/taxonomias/prueba_bad_es.xml";
	   	 java.net.URL fichero=null;
	   	 try 
	   	 {		
	   		fichero = this.getClass().getResource(taxonomia);
	   	 } 
	   	 catch (Exception e1)  
	   	 {

	   		 logger.error(e1);
	   	 }
		SrvValidadorVDEXService servicio= this.servicio;
		ValidaVdexVO valida= new ValidaVdexVO();
		valida= servicio.obtenerValidacionTaxonomia(fichero.getPath());
		
		assertEquals( valida.getValido().booleanValue(), false);		
	}
}
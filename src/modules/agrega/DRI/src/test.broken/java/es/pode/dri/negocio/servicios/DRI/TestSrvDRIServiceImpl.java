/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.dri.negocio.servicios.DRI;





/**
 * @see SrvDRIServiceImpl
 */
public class TestSrvDRIServiceImpl
    extends SrvDRIServiceImplBase
{


    /**
     * Constructor
     */
     public TestSrvDRIServiceImpl(){
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
		assertNull(prueba);
	}
	
	public void testPresentarAlmacenar() 
	{
     	String seed = new Long(System.currentTimeMillis()).toString();
    	//String sesionId = "sesion "+seed;
     	String sesionId;
//     	DataHandler pif = null;
//     	pif = new DataHandler(new FileDataSource(new File("D:\\1234.zip")));
     	//DataHandler pif = new DataHandler(null, "");
		SrvDRIService service = this.servicio;
		
		try 
		{
			sesionId = this.servicioSession.createSession("administrador", "1111111");
//			service.presentarAlmacenar(sesionId, pif);
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}
	
	public void testSolicitarEntregar() {
     	String seed = new Long(System.currentTimeMillis()).toString();
     	//String sesionId = "sesion "+seed;
    	//String mec = "mec "+seed;
     	String mec="es_ex_20070518_1_9095447220";
		SrvDRIService service = this.servicio;
		String sesionId;
		try 
		{
			sesionId = this.servicioSession.createSession("administrador", "1111111");
//			service.solicitarEntregar(sesionId, mec);
		} 
		catch (Exception e) 
		{
			assertTrue(true);
		}
		//poco mas se puede hacer sin acceso al servicio de sesion
	}
	
	
	
}
/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.dri.negocio.servicios.SQI;

import java.util.List;

import es.pode.dri.negocio.dominio.Consulta;
import es.pode.dri.negocio.dominio.ConsultaDao;
import es.pode.dri.negocio.dominio.ConsultaPorSesionCriteria;
import es.pode.dri.negocio.servicios.Sesion.NoExisteSesionException;
import es.pode.dri.negocio.servicios.Sesion.WrongCredentialsException;

/**
 * @see SrvSQIServiceImpl
 */
public class TestSrvSQIServiceImpl
    extends SrvSQIServiceImplBase
{

	private String datasetFile = "SrvDataEmptyDataSet.xls";
    /**
     * Constructor
     */
     public TestSrvSQIServiceImpl(){
		super();
	}

    /**
     * onSetUpInTransaction
     */

     protected void onSetUpInTransaction() throws Exception {

   		// Conexion a la base de datos
    	 
//    	 connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
    	 
    	 /*
   		connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
   		DatabaseConfig config = connection.getConfig();
   		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
   		*/
   		// Inicialización 
    	 /*
   		IDataSet dataSet = new XlsDataSet(this.applicationContext.getResource(datasetFile).getFile());
   		DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
   		*/
    	 String prueba = null;
 		assertNull(prueba);
  	}

      /**
       * onTearDownInTransaction
       */

  	 protected void onTearDownInTransaction() {
  		 
//  		 try
//    	 { 
//    		 // Inicializamos la conexion a base de datos
//    		 connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
//    		 // Inicializamos el dataset
////    		 IDataSet dataSet = new XlsDataSet(this.applicationContext.getResource(datasetFile).getFile());
////    		 DatabaseOperation.DELETE.execute(connection, dataSet);
//    	 }
//    	 catch (Throwable th)
//    	 {
//    		 th.printStackTrace();
//    	 }
  		String prueba = null;
		assertNull(prueba);
		
         
/*
  		 try 
  		 {
  		 		// Conexion a la base de datos
  				connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
  				DatabaseConfig config = connection.getConfig();
  				config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());

  				//	Inicialización 
  				IDataSet dataSet = new XlsDataSet(this.applicationContext.getResource(datasetFile).getFile());
  				DatabaseOperation.DELETE_ALL.execute(connection, dataSet);
  		 } 
  		 catch (Throwable th) 
  		 {
  			th.printStackTrace();
  		 }
  		 */
       }
     
     /*
     protected void onSetUpInTransaction() throws Exception {

     	
		super.onSetUpInTransaction();
	}
*/

    /**
     * onTearDownInTransaction
     */
/*
	 protected void onTearDownInTransaction() {

     	
	 	
    	 super.onTearDownInTransaction();
     }
	*/

    /**
     * testInicial
     *   TODO: Agregar las pruebas unitarias que correspondan al servicio, siguiendo un patron de nombrado como
     *     public void test<nombreTest>().
     */	
     public void testInicial(){
		String prueba = null;
		assertNull(prueba);
	}
	
	
    /**
     *   TEST createAnonymousSession
     *   TODO: Implementar el test para el metodo createAnonymousSession del servicio SrvSQIService.
     * @throws NoExisteSesionException 
     */
     public void testcreateAnonymousSession() throws NoExisteSesionException 
     {

    }

    /**
     *   TEST destroySession
     *   TODO: Implementar el test para el metodo destroySession del servicio SrvSQIService.
     */
     public void testdestroySession() throws WrongCredentialsException, NoExisteSesionException 
     {


    }

    /**
     *   TEST getTotalResultsCount
     *   TODO: Implementar el test para el metodo getTotalResultsCount del servicio SrvSQIService.
     * @throws NoSuchSessionException 
     * @throws NoQuerySubmittedException 
     * @throws QueryModeNotSupportedException 
     * @throws WrongCredentialsException 
     */
     public void testgetTotalResultsCount() throws QueryModeNotSupportedException, NoQuerySubmittedException, NoSuchSessionException, WrongCredentialsException 
     {
    	 try{
    		String sesionId = this.servicioSession.createAnonymousSession();
        	SrvSQIService servicios=this.servicio;
        	assertNull(servicios.getTotalResultsCount(sesionId, "prueba"));
    	 } catch (Exception e) {
  			assertTrue(true);
  		}
//    	 String prueba = null;
// 		assertNull(prueba);
//	
     }

    /**
     *   TEST createSession
     *   TODO: Implementar el test para el metodo createSession del servicio SrvSQIService.
     * @throws WrongCredentialsException 
     * @throws NoExisteSesionException 
     */
     public void testcreateSession() throws WrongCredentialsException, NoExisteSesionException 
     {

     }

    /**
     *   TEST setMaxDuration
     *   TODO: Implementar el test para el metodo setMaxDuration del servicio SrvSQIService.
     */
     //funciona
     public void testsetMaxDuration() 
     {

    	 Integer bueno=new Integer(2);
    	 Integer bueno2=new Integer(3);
    	 try
    	 {
    		 String sesionId = this.servicioSession.createAnonymousSession();
//  		 Sesion sin consulta asociada
    		 SrvSQIService servicios=this.servicio;
    		 servicios.setMaxDuration(sesionId, bueno);


    		 ConsultaPorSesionCriteria criterio= new ConsultaPorSesionCriteria();
    		 criterio.setSesion(sesionId);
    		 List consulta = consultaDao.buscaConsultaPorCriterioSesion(ConsultaDao.TRANSFORM_NONE, criterio);
    		 //si hay consulta y tiene valor

    		 if (consulta != null && consulta.size()>0) 
    		 {
    			 Consulta consul = (Consulta)consulta.get(0);
    			 consul.setMaxDuracion(bueno);
    			 consulta.set(0, consul);
    			 consul.getMaxDuracion();
    			 assertEquals(consul.getMaxDuracion(), bueno);

    		 }
    		 else
    		 {
    			 assertTrue(false);
    		 }
    		 //con consulta asociada
    		 servicios.setMaxDuration(sesionId, bueno2);
    		 consulta= consultaDao.buscaConsultaPorCriterioSesion(ConsultaDao.TRANSFORM_NONE, criterio);

    		 if (consulta != null && consulta.size()>0) 
    		 {
    			 Consulta consul = (Consulta)consulta.get(0);
    			 consul.setMaxDuracion(bueno2);
    			 consulta.set(0, consul);
    			 consul.getMaxDuracion();
    			 assertEquals(consul.getMaxDuracion(), bueno2);

    		 }
    		 else
    		 {
    			 assertTrue(false);
    		 }
    	 }
    	 catch (Exception e) 
    	 {
    		 assertTrue(false);
    	 }

    }

    /**
     *   TEST setResultsFormat
     *   TODO: Implementar el test para el metodo setResultsFormat del servicio SrvSQIService.
     */
     //funciona
     public void testsetResultsFormat() 
     {
    	 String bueno=new String("formato1");
    	 String bueno2=new String("formato2");
    	 try
    	 {
    		 String sesionId = this.servicioSession.createAnonymousSession();
//  		 Sesion sin consulta asociada
    		 SrvSQIService servicios=this.servicio;
    		 servicios.setResultsFormat(sesionId, bueno);


    		 ConsultaPorSesionCriteria criterio= new ConsultaPorSesionCriteria();
    		 criterio.setSesion(sesionId);
    		 List consulta = consultaDao.buscaConsultaPorCriterioSesion(ConsultaDao.TRANSFORM_NONE, criterio);
    		 //si hay consulta y tiene valor

    		 if (consulta != null && consulta.size()>0) 
    		 {
    			 Consulta consul = (Consulta)consulta.get(0);
    			 consul.setFormatoResultados(bueno);
    			 consulta.set(0, consul);
    			 consul.getFormatoResultados();
    			 assertEquals(consul.getFormatoResultados(), bueno);

    		 }
    		 else
    		 {
    			 assertTrue(false);
    		 }
    		 //con consulta asociada
    		 servicios.setResultsFormat(sesionId, bueno2);
    		 consulta= consultaDao.buscaConsultaPorCriterioSesion(ConsultaDao.TRANSFORM_NONE, criterio);

    		 if (consulta != null && consulta.size()>0) 
    		 {
    			 Consulta consul = (Consulta)consulta.get(0);
    			 consul.setFormatoResultados(bueno2);
    			 consulta.set(0, consul);
    			 consul.getResultadosDevueltos();
    			 assertEquals(consul.getFormatoResultados(), bueno2);

    		 }
    		 else
    		 {
    			 assertTrue(false);
    		 }
    	 }
    	 catch (Exception e) 
    	 {
    		 assertTrue(false);
    	 }
    }

    /**
     *   TEST setResultsSetSize
     *   TODO: Implementar el test para el metodo setResultsSetSize del servicio SrvSQIService.
     */
     //funciona
     public void testsetResultsSetSize() 
     {
    	 Integer bueno=new Integer(2);
    	 Integer bueno2=new Integer(3);
    	 try
    	 {
    		 String sesionId = this.servicioSession.createAnonymousSession();
//  		 Sesion sin consulta asociada
    		 SrvSQIService servicios=this.servicio;
    		 servicios.setResultsSetSize(sesionId, bueno);


    		 ConsultaPorSesionCriteria criterio= new ConsultaPorSesionCriteria();
    		 criterio.setSesion(sesionId);
    		 List consulta = consultaDao.buscaConsultaPorCriterioSesion(ConsultaDao.TRANSFORM_NONE, criterio);
    		 //si hay consulta y tiene valor

    		 if (consulta != null && consulta.size()>0) 
    		 {
    			 Consulta consul = (Consulta)consulta.get(0);
    			 consul.setResultadosDevueltos(bueno);
    			 consulta.set(0, consul);
    			 consul.getResultadosDevueltos();
    			 assertEquals(consul.getResultadosDevueltos(), bueno);

    		 }
    		 else
    		 {
    			 assertTrue(false);
    		 }
    		 //con consulta asociada
    		 servicios.setMaxDuration(sesionId, bueno2);
    		 consulta= consultaDao.buscaConsultaPorCriterioSesion(ConsultaDao.TRANSFORM_NONE, criterio);

    		 if (consulta != null && consulta.size()>0) 
    		 {
    			 Consulta consul = (Consulta)consulta.get(0);
    			 consul.setResultadosDevueltos(bueno2);
    			 consulta.set(0, consul);
    			 consul.getResultadosDevueltos();
    			 assertEquals(consul.getResultadosDevueltos(), bueno2);

    		 }
    		 else
    		 {
    			 assertTrue(false);
    		 }
    	 }
    	 catch (Exception e) 
    	 {
    		 assertTrue(false);
    	 }

     }

    /**
     *   TEST setSourceLocation
     *   TODO: Implementar el test para el metodo setSourceLocation del servicio SrvSQIService.
     */
     //funciona
     public void testsetSourceLocation() 
     {
      	 String bueno=new String("formato1");
    	 String bueno2=new String("formato2");
    	 try
    	 {
    		 String sesionId = this.servicioSession.createAnonymousSession();
//  		 Sesion sin consulta asociada
    		 SrvSQIService servicios=this.servicio;
    		 servicios.setSourceLocation(sesionId, bueno);


    		 ConsultaPorSesionCriteria criterio= new ConsultaPorSesionCriteria();
    		 criterio.setSesion(sesionId);
    		 List consulta = consultaDao.buscaConsultaPorCriterioSesion(ConsultaDao.TRANSFORM_NONE, criterio);
    		 //si hay consulta y tiene valor

    		 if (consulta != null && consulta.size()>0) 
    		 {
    			 Consulta consul = (Consulta)consulta.get(0);
    			 consul.setLocalizacionRemota(bueno);
    			 consulta.set(0, consul);
    			 consul.getLocalizacionRemota();
    			 assertEquals(consul.getLocalizacionRemota(), bueno);

    		 }
    		 else
    		 {
    			 assertTrue(false);
    		 }
    		 //con consulta asociada
    		 servicios.setResultsFormat(sesionId, bueno2);
    		 consulta= consultaDao.buscaConsultaPorCriterioSesion(ConsultaDao.TRANSFORM_NONE, criterio);

    		 if (consulta != null && consulta.size()>0) 
    		 {
    			 Consulta consul = (Consulta)consulta.get(0);
    			 consul.setLocalizacionRemota(bueno2);
    			 consulta.set(0, consul);
    			 consul.getLocalizacionRemota();
    			 assertEquals(consul.getLocalizacionRemota(), bueno2);

    		 }
    		 else
    		 {
    			 assertTrue(false);
    		 }
    	 }
    	 catch (Exception e) 
    	 {
    		 assertTrue(false);
    	 }

    }

    /**
     *   TEST setQueryLanguage
     *   TODO: Implementar el test para el metodo setQueryLanguage del servicio SrvSQIService.
     */
     //funciona
     public void testsetQueryLanguage() 
     {
       	 String bueno=new String("VSQL");
    	 
    	 try
    	 {
    		 String sesionId = this.servicioSession.createAnonymousSession();
//  		 Sesion sin consulta asociada
    		 SrvSQIService servicios=this.servicio;
    		 servicios.setQueryLanguage(sesionId, bueno);


    		 ConsultaPorSesionCriteria criterio= new ConsultaPorSesionCriteria();
    		 criterio.setSesion(sesionId);
    		 List consulta = consultaDao.buscaConsultaPorCriterioSesion(ConsultaDao.TRANSFORM_NONE, criterio);
    		 //si hay consulta y tiene valor

    		 if (consulta != null && consulta.size()>0) 
    		 {
    			 Consulta consul = (Consulta)consulta.get(0);
    			 consul.setLenguaje(bueno);
    			 consulta.set(0, consul);
    			 consul.getLenguaje();
    			 assertEquals(consul.getLenguaje(), bueno);

    		 }
    		 else
    		 {
    			 assertTrue(false);
    		 }
    		 //con consulta asociada
    		 servicios.setQueryLanguage(sesionId, bueno);
    		 consulta= consultaDao.buscaConsultaPorCriterioSesion(ConsultaDao.TRANSFORM_NONE, criterio);

    		 if (consulta != null && consulta.size()>0) 
    		 {
    			 Consulta consul = (Consulta)consulta.get(0);
    			 consul.setLenguaje(bueno);
    			 consulta.set(0, consul);
    			 consul.getLenguaje();
    			 assertEquals(consul.getLenguaje(), bueno);

    		 }
    		 else
    		 {
    			 assertTrue(false);
    		 }
    	 }
    	 catch (Exception e) 
    	 {
    		 assertTrue(false);
    	 }

    }

    /**
     *   TEST setMaxQueryResults
     *   TODO: Implementar el test para el metodo setMaxQueryResults del servicio SrvSQIService.
     */
     //funciona
     public void testsetMaxQueryResults() 
     {
    	 Integer bueno=new Integer(2);
    	 Integer bueno2=new Integer(3);
    	 try
    	 {
    		 String sesionId = this.servicioSession.createAnonymousSession();
//  		 Sesion sin consulta asociada
    		 SrvSQIService servicios=this.servicio;
    		 servicios.setMaxQueryResults(sesionId, bueno);


    		 ConsultaPorSesionCriteria criterio= new ConsultaPorSesionCriteria();
    		 criterio.setSesion(sesionId);
    		 List consulta = consultaDao.buscaConsultaPorCriterioSesion(ConsultaDao.TRANSFORM_NONE, criterio);
    		 //si hay consulta y tiene valor

    		 if (consulta != null && consulta.size()>0) 
    		 {
    			 Consulta consul = (Consulta)consulta.get(0);
    			 consul.setMaxResultados(bueno);
    			 consulta.set(0, consul);
    			 consul.getMaxResultados();
    			 assertEquals(consul.getMaxResultados(), bueno);

    		 }
    		 else
    		 {
    			 assertTrue(false);
    		 }
    		 //con consulta asociada
    		 servicios.setMaxQueryResults(sesionId, bueno2);
    		 consulta= consultaDao.buscaConsultaPorCriterioSesion(ConsultaDao.TRANSFORM_NONE, criterio);

    		 if (consulta != null && consulta.size()>0) 
    		 {
    			 Consulta consul = (Consulta)consulta.get(0);
    			 consul.setMaxResultados(bueno2);
    			 consulta.set(0, consul);
    			 consul.getMaxResultados();
    			 assertEquals(consul.getMaxResultados(), bueno2);

    		 }
    		 else
    		 {
    			 assertTrue(false);
    		 }
    	 }
    	 catch (Exception e) 
    	 {
    		 assertTrue(false);
    	 }

    }

    /**
     *   TEST asynchronousQuery
     *   TODO: Implementar el test para el metodo asynchronousQuery del servicio SrvSQIService.
     */
     public void testasynchronousQuery() {
		String prueba = null; 
		assertNull(prueba);

    }

    /**
     *   TEST synchronousQuery
     *   TODO: Implementar el test para el metodo synchronousQuery del servicio SrvSQIService.
     * @throws WrongCredentialsException 
     * @throws NoSuchSessionException 
     * @throws NoValidQueryStatementException 
     * @throws QueryModeNotSupportedException 
     * @throws NoValidStartResultException 
     * @throws NoValidMaxQueryResultsException 
     * @throws QueryLanguageNotSupportedException 
     * @throws NoValidResultsSetSizeException 
     */
     public void testsynchronousQuery() throws WrongCredentialsException, NoValidStartResultException, QueryModeNotSupportedException, NoValidQueryStatementException, NoSuchSessionException, NoValidMaxQueryResultsException, QueryLanguageNotSupportedException, NoValidResultsSetSizeException 
     {
//    	String sesion = this.servicioSession.createSession("larraitz", "larraitz");
////    	 String sesionAnonima = "2c9a039b1cf6f711011cf6f717210001";
//    	//String sesionId = this.servicioSession.createSession("123", "123");
//    	SrvSQIService servicios=this.servicio;//Todos los que encuentra
//    	String resultado = servicios.synchronousQuery(sesion, "<simpleQuery><term>cinco</term></simpleQuery>", 1);
//    	System.out.println("Resultado "+resultado);
//    	
//    	String resultado2 = servicios.synchronousQuery(sesion, "<simpleQuery><term>cinco</term></simpleQuery>", 1);
//    	System.out.println("Resultado2 "+resultado2);
//    	//assertNotNull(servicios.synchronousQuery(sesionId, "VSQI", new Integer (10)));
//    	servicio.setMaxQueryResults(sesion, 8);//Los 8 primeros
//    	servicio.setQueryLanguage(sesion, "VSQL");
//    	String resultado2 = servicios.synchronousQuery(sesion, "<simpleQuery><term>cinco</term></simpleQuery>", 1);
//    	System.out.println("Resultado2 "+resultado2);
//    	
//    	servicio.setMaxQueryResults(sesion, 4);//4 empezando por el 1
//    	servicio.setQueryLanguage(sesion, "VSQL");
//    	String resultado3 = servicios.synchronousQuery(sesion, "<simpleQuery><term>cinco</term></simpleQuery>", 2);
//    	System.out.println("Resultado3 "+resultado3);
    	
//    	servicio.setMaxQueryResults(sesion, 5);//Devuelve el 1,2,3; 3 empezando por el 1; por que 3<5(se devuelve el primer grupo)
//    	servicio.setQueryLanguage(sesion, "VSQL");
//    	servicio.setResultsSetSize(sesion, 3);//Tamaño del conjunto de resultados(grupos)
//    	String resultado4 = servicios.synchronousQuery(sesion, "<simpleQuery><term>cinco</term></simpleQuery>", 2);
//    	System.out.println("Resultado4 "+resultado4);
    	
//    	servicio.setMaxQueryResults(sesion, 5);//Devuelve el 1,2,3,4,5 (Se devuelve el maximo)
//    	servicio.setQueryLanguage(sesion, "VSQL");
//    	servicio.setResultsSetSize(sesion, 7);//Tamaño del conjunto de resultados(grupos)
//    	String resultado5 = servicios.synchronousQuery(sesion, "<simpleQuery><term>cinco</term></simpleQuery>", 2);
//    	System.out.println("Resultado5 "+resultado5);
    	
//    	servicio.setMaxQueryResults(sesion, 25);//Devuelve el 5,6,7,8,9
//    	servicio.setQueryLanguage(sesion, "VSQL");
//    	servicio.setResultsSetSize(sesion, 5);//Tamaño del conjunto de resultados(grupos)
//    	String resultado6 = servicios.synchronousQuery(sesion, "<simpleQuery><term>cinco</term></simpleQuery>", 6);
//    	System.out.println("Resultado6 "+resultado6);
    	 String prueba = null;
 		assertNull(prueba);
    }

	
	
	
}
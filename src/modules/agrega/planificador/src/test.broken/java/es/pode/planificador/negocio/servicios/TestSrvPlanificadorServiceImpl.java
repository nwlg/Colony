/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.planificador.negocio.servicios;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

import es.pode.planificador.negocio.comun.CtesPlanificador;
import es.pode.planificador.negocio.trabajos.GenerarSitemaps;
import es.pode.planificador.negocio.trabajos.InformeCatalogo;
import es.pode.planificador.negocio.trabajos.InformesPortada;
import es.pode.planificador.negocio.trabajos.LanzarRSS;
import es.pode.planificador.negocio.trabajos.PortadaODE;
import es.pode.soporte.utiles.date.DateManager;


public class TestSrvPlanificadorServiceImpl
    extends SrvPlanificadorServiceImplBase
{

	private String datasetFile = "SrvDataEmptyDataSet.xls";
	
    /**
     * Constructor
     */
     public TestSrvPlanificadorServiceImpl(){
		super();
		
        logger.info("Autenticando usuario administrador con password 1");

        try {
        	/*
        	LdapUserDetailsAgrega.Essence user = new LdapUserDetailsAgrega.Essence();
        	
            user.setUsername("administrador");
            user.setPassword("1");
            */
            /* Si queremos realizar los test personalizando los datos del usuario 
            
            BasicAttributes attributes = new BasicAttributes();
            attributes.put("preferredlanguage", "es"); // idioma en que se le va a mostrar el portal
            attributes.put("initials", "es"); // Idioma por defecto de las búsquedas
            attributes.put("sn", "Usuario Administrador"); // Nombre y apellidos
            attributes.put("mail", "administrador@agrega.es"); // Correo electrónico
            attributes.put("employeeType", "basico"); // El tipo de edición del empaquetador
            attributes.put("cn", "administrador"); // Login
            user.setAttributes(attributes);
            */
            
            /* Si se quiere utilizar los datos del usuario que devuelve el servicio de administración de usuario */
        	/*
            user.setDatosUsuario("administrador");
            
            Authentication currentAuth = new UsernamePasswordAuthenticationToken(user.createUserDetails(), null);
            SecurityContextHolder.getContext().setAuthentication(currentAuth);
            */
        } 
        catch (Exception e) 
        {
              logger.error(e);
              fail("Error de construccion del test durante la autenticacion");
        }
	}

          
    /**
     * onSetUpInTransaction
     */

     protected void onSetUpInTransaction() throws Exception {

 		// Conexion a la base de datos
 		connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
 		DatabaseConfig config = connection.getConfig();
 		config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());
 		
 		// Inicialización 
 		IDataSet dataSet = new XlsDataSet(this.applicationContext.getResource(datasetFile).getFile());
 		DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
	}

    /**
     * onTearDownInTransaction
     */

	 protected void onTearDownInTransaction() {

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
     }
	

    /**
     * testInicial
     *     public void test<nombreTest>().
     */	
     public void testInicial(){

    	 /* No aplica porque no tiene seguridad
  		String nulo = null;
		this.initAthenticationUser("usuario", "ibuilder");
		assertNull(nulo);
    	*/
	}
	 
    /**
     *   TEST registrarTrabajo
     */
     
     public void testregistrarTrabajo() 
     {
    	TareaEjecutadaVO tarea= new TareaEjecutadaVO();
     	tarea.setDescripcion("prueba1");
     	tarea.setGrupoTrabajo("grupoTrabajo");
     	Long id= new Long(1);
     	tarea.setId(id);
     	tarea.setTrabajo("trabajo1");
     	assertNotNull(tarea);
    }

    /**
     *   TEST registrarTrabajoHijo
     */
     
     public void testregistrarTrabajoHijo()
     {
    	 	TareaEjecutadaVO tarea= new TareaEjecutadaVO();
      		tarea.setDescripcion("prueba1");
      		tarea.setGrupoTrabajo(CtesPlanificador.GRUPO_JOBS);
      		Long id = new Long(1);
      		tarea.setId(id);
      		tarea.setTrabajo("trabajo1");
      		assertNotNull(tarea);
     }

     /*
      *   TEST obtenerInformeTrabajo 
      */
      
      public void testobtenerInformeTrabajo()
      		throws java.lang.Exception
      {
     	 RegistroTareaEjecutadaVO[] registros = null;
     	 Long tal = new Long(2);
     	 registros = this.servicio.obtenerInformeTrabajo(tal);
     	 assertNotNull(registros);
     }
      
     
      /*
       * Test ObtenerInformeTrabajoErroneos 
       */
       
      public void testObtenerInformeTrabajoErroneos() throws ObtenerInformeException
      {
     	 Long tal = new  Long (1);
     	 RegistroTareaEjecutadaVO[] re = this.servicio.obtenerInformeTrabajoErroneos(tal); 
     	 assertNotNull (re[0]);
      }
      
     
    /*
     *   TEST eliminarTrabajoEjecutado
     */
     
     public void testeliminarTrabajoEjecutado()
     throws java.lang.Exception
     {
    	 Boolean devolver;
    	 Long tal[] = {new Long(1)};
    	 devolver = this.servicio.eliminarTrabajoEjecutado(tal);
    	 assertTrue( devolver.booleanValue()); 
    }
     
     
    /*
     *   TEST obtenerTrabajosEjecutados
     */
     
     public void testobtenerTrabajosEjecutados() 
     		throws java.lang.Exception
     {    	 
    	 TareaEjecutadaVO[] trabajo = this.servicio.obtenerTrabajosEjecutados(); 
    	 assertNotNull(trabajo);
     }

    /**
     *   TEST obtenerTareasEnEjecucion
     */
     
     public void testobtenerTareasEnEjecucion() 
     		throws java.lang.Exception
     {
    	 TareaVO[] tareas = this.servicio.obtenerTareasEnEjecucion(); 
		 assertNotNull(tareas);
     }

     /*
      * Test ObtenerTrabajoEjecutado
      */
     
     public void testobtenerTrabajoEjecutado() 
     		throws java.lang.Exception
     {
    	 Long tal = new  Long (1);
    	 TareaEjecutadaVO tarea = this.servicio.obtenerTrabajoEjecutado(tal);    	 
    	 assertNotNull(tarea);
     }	 
     
        
     /*
      * Test ObtenerTrabajoEjecutados entre dos fechas
      */
     
     public void testobtenerTrabajoEjecutadoDesdeHasta() 
     		throws java.lang.Exception
     {
    	 ParametrosVO parametros = new  ParametrosVO();
    	 
         Calendar calDesde = new GregorianCalendar(2000, Calendar.JANUARY, 1);
         calDesde.set(calDesde.HOUR_OF_DAY, 1);
         calDesde.set(calDesde.MINUTE, 1);
         calDesde.set(calDesde.SECOND, 0);
         calDesde.set(calDesde.MILLISECOND, 0);
    	 parametros.setFechaDesde(calDesde);
    	 
         Calendar calHasta = new GregorianCalendar(2010, Calendar.JANUARY, 1);
         calHasta.set(calHasta.HOUR_OF_DAY, 1);
         calHasta.set(calHasta.MINUTE, 1);
         calHasta.set(calHasta.SECOND, 0);
         calHasta.set(calHasta.MILLISECOND, 0);
    	 parametros.setFechaHasta(calHasta);
    	 
    	 TareaEjecutadaVO[] trabajos = this.servicio.obtenerTrabajosEjecutadosDesdeHasta(parametros);    	 
    	 assertNotNull(trabajos);
     }	 
     
     /*
      * Test Calculo de fechas desde
      */
     
     public void testcalculoFechaDesde() 
     		throws java.lang.Exception
     {
    	 
         Calendar cal = new GregorianCalendar(2008, Calendar.FEBRUARY, 17);
         Date fecha = cal.getTime();
    	 
         TareaInformesVO tareas = new TareaInformesVO();         
    	 //Date fechaCal = GenerarInforme.calculoFechaDesde(fecha, CtesPlanificador.SEMANAL, tareas);
    	 
    	 //assertNotNull(fechaCal);
     }
     
     /*
      * Test Calculo de fechas
      */
     
     public void testcalculoFechaHasta() 
     		throws java.lang.Exception
     {
    	 
         Calendar cal = new GregorianCalendar(2008, Calendar.FEBRUARY, 11);
         Date fecha = cal.getTime();
    	 
         TareaInformesVO tareas = new TareaInformesVO();                  
    	 //Date fechaCal = GenerarInforme.calculoFechaHasta(fecha, CtesPlanificador.SEMANAL, tareas);
    	 
    	 //assertNotNull(fechaCal);
     }

     /* Clase test para probar la creación de una tarea genérica
      * Se puede utilizar para crear una tarea determinada que queremos que se ejecute siempre y 
      * que no aparezca en la administración de tareas. 
      * Al crear una tarea se actualizan las tablas:
      * QRTZ_JOB_DETAILS
      * QRTZ_TRIGGERS
      * QRTZ_CRON_TRIGGERS
      */ 
     public void testCrearTareaGenerica() 
		throws java.lang.Exception
	{
    	 
    	 TareaVO tareaCreada = new TareaVO();
    	 tareaCreada.setTrabajo("lanzarRSS");
    	 tareaCreada.setGrupoTrabajo("GrupoTrabajoRSS");
    	 tareaCreada.setTrigger("TriggerLanzarRSS");
    	 tareaCreada.setGrupoTrigger("GrupoTriggerRSS");
    	 tareaCreada.setUsuario("administrador");
    	 tareaCreada.setPeriodicidad("D");
         Calendar calInicio = new GregorianCalendar(2008, Calendar.JANUARY, 1);
         calInicio.set(calInicio.HOUR_OF_DAY, 1);
         calInicio.set(calInicio.MINUTE, 1);
         calInicio.set(calInicio.SECOND, 0);
         calInicio.set(calInicio.MILLISECOND, 0);
         Date fechaInicio = calInicio.getTime();
    	 tareaCreada.setFechaInicio(DateManager.dateToCalendar(fechaInicio));
    	 
    	 /* Parámetros propios de la tarea */
    	 
    	 List parametrosTarea = new ArrayList();		 							 		     	 
    	 SrvPlanificadorServiceImpl servicio = new SrvPlanificadorServiceImpl();
    	 servicio.handleCrearTarea(tareaCreada, parametrosTarea, LanzarRSS.class);
    	 
    	 /* Informes portada */
    	 
    	 tareaCreada.setTrabajo("Informes portada");
    	 tareaCreada.setGrupoTrabajo("GrupoTrabaInformesPortada");
    	 tareaCreada.setTrigger("TriggerInformesPortada");
    	 tareaCreada.setGrupoTrigger("GrupoTriggerInformesPortada");
    	 tareaCreada.setUsuario("administrador");
    	 tareaCreada.setPeriodicidad("D");

    	 tareaCreada.setFechaInicio(DateManager.dateToCalendar(fechaInicio));
    	 
    	 /* Parámetros propios de la tarea */
    	 
    	 List parametrosTareaInformesPortada = new ArrayList();		 							 		     	 
    	 servicio.handleCrearTarea(tareaCreada, parametrosTareaInformesPortada, InformesPortada.class);
    	
    	 /* ODE portada */
    	 
    	 tareaCreada.setTrabajo("ODE portada");
    	 tareaCreada.setGrupoTrabajo("GrupoTrabaODEPortada");
    	 tareaCreada.setTrigger("TriggerODEPortada");
    	 tareaCreada.setGrupoTrigger("GrupoTriggerODEPortada");
    	 tareaCreada.setUsuario("administrador");
    	 tareaCreada.setPeriodicidad("D");

    	 tareaCreada.setFechaInicio(DateManager.dateToCalendar(fechaInicio));
    	 
    	 /* Parámetros propios de la tarea */
    	 
    	 List parametrosTareaODEPortada = new ArrayList();		 							 		     	 
    	 servicio.handleCrearTarea(tareaCreada, parametrosTareaODEPortada, PortadaODE.class);
    	
    	 /*
    	  * Lanzar tarea generar sitemaps
    	  */
    	
    	 tareaCreada.setTrabajo("Sitemaps");
    	 tareaCreada.setGrupoTrabajo("GrupoTrabajoSitemaps");
    	 tareaCreada.setTrigger("TriggerSitemaps");
    	 tareaCreada.setGrupoTrigger("GrupoTriggerSitemaps");
    	 tareaCreada.setUsuario("administrador");
    	 tareaCreada.setPeriodicidad("D");
         tareaCreada.setFechaInicio(DateManager.dateToCalendar(fechaInicio));
    	 
    	 /* Parámetros propios de la tarea */
    	 
    	 List parametrosTareaSitemaps = new ArrayList();		 							 		     	 
    	 servicio.handleCrearTarea(tareaCreada, parametrosTareaSitemaps, GenerarSitemaps.class);
    	 
    	 /*
    	  * Generar informe catálogo
    	  */
    	 
    	 tareaCreada.setTrabajo("Informe Catalogo");
    	 tareaCreada.setGrupoTrabajo("GrupoTrabaInformeCatalogo");
    	 tareaCreada.setTrigger("TriggerInformeCatalogo");
    	 tareaCreada.setGrupoTrigger("GrupoTriggerInformeCatalogo");
    	 tareaCreada.setUsuario("administrador");
    	 tareaCreada.setPeriodicidad("M");
    	 calInicio = new GregorianCalendar(2008, Calendar.JANUARY, 1);
         calInicio.set(calInicio.HOUR_OF_DAY, 1);
         calInicio.set(calInicio.MINUTE, 0);
         calInicio.set(calInicio.SECOND, 0);
         calInicio.set(calInicio.MILLISECOND, 0);
         fechaInicio = calInicio.getTime();
    	 tareaCreada.setFechaInicio(DateManager.dateToCalendar(fechaInicio));
    	
    	 /* Parámetros propios de la tarea */
    	
    	 List parametrosInformeCatalogo = new ArrayList();		 							 		     	 
    	 servicio.handleCrearTarea(tareaCreada, parametrosInformeCatalogo, InformeCatalogo.class);
    	
    	    	   	
	}

     
     /* Para poder ejecutar estos test se necesita conexión a la BBDD no funcionan a través de hibernate
      * Cambiar quartz_priority.properties
      * comentando org.quartz.dataSource.myDS.jndiURL y descomentando las del datasource correspondiente
      
     
      public void testobtenerTareaReindexado() 
      		throws java.lang.Exception
      {
    	  TareaVO tarea = new TareaVO();
   	   	  tarea.setTrabajo("Trabajo2");
   	      tarea.setGrupoTrabajo(CtesPlanificador.GRUPO_JOBS);
   	      tarea.setTrigger("Trigger2");
   	      tarea.setGrupoTrigger(CtesPlanificador.GRUPO_TRIGGER);
   	       
   	      TareaReindexadoVO tareaReindexado = this.servicio.obtenerTareaReindexado(tarea);
   	      assertNotNull(tareaReindexado);
      }
  
     
      public void testmodificarTareaReindexado()
      		throws java.lang.Exception 
      {
    	 TrabajoVO modificar = new TrabajoVO();
     	 modificar.setTrabajo("Trabajo2");
     	 modificar.setGrupoTrabajo(CtesPlanificador.GRUPO_JOBS);
     	 modificar.setUsuario(new Long(1));
     	 
     	 TareaReindexadoVO datos = new TareaReindexadoVO();
         datos.setTrabajo("Trabajo2");
         datos.setGrupoTrabajo(CtesPlanificador.GRUPO_JOBS);
         datos.setTrigger("Trigger2");
         datos.setGrupoTrigger(CtesPlanificador.GRUPO_TRIGGER);
         datos.setUsuario(new Long(1));
         datos.setPeriodicidad("N");
         datos.setRepositorioIndices("ca_ES");
         
         Calendar cal = new GregorianCalendar(2010, Calendar.JANUARY, 1);
         cal.set(cal.HOUR_OF_DAY, 1);
         cal.set(cal.MINUTE, 1);
         cal.set(cal.SECOND, 0);
         cal.set(cal.MILLISECOND, 0);
         Date fecha = cal.getTime();
         
         datos.setFechaInicio(fecha);
         
         datos = this.servicio.modificarTareaReindexado(datos,modificar);
     	 
         assertTrue(datos.getTrabajo() != null);  	 
      }
      
      public void testpararTarea() 
		throws java.lang.Exception
		{
	   	   	TrabajoVO trabajo = new TrabajoVO();
	   	   	trabajo.setTrabajo("Trabajo1");
	   	   	trabajo.setGrupoTrabajo(CtesPlanificador.GRUPO_JOBS);
	   	   	trabajo.setUsuario(new Long(1234));
	   	   	this.servicio.pararTarea(trabajo);
	   	   	assertTrue (true);
		}
      
       public void testeliminarTareas() 
       		throws java.lang.Exception
       {
	      	
    	    TrabajoVO trabajo = new TrabajoVO();
			trabajo.setGrupoTrabajo("GrupoTrabajoSitemaps");
			System.out.println("trabajo.getGrupoTrabajo() "+trabajo.getGrupoTrabajo());
			trabajo.setTrabajo("Sitemaps");
			System.out.println("trabajo.getTrabajo() "+trabajo.getTrabajo());
			trabajo.setUsuario("administrador");
			TrabajoVO[] trabajoArray = new TrabajoVO[1];
			trabajoArray[0] = trabajo;
			boolean resultadoEliminacion = (servicio.eliminarTareas(trabajoArray)).booleanValue();
			System.out.println("resultadoEliminacion "+resultadoEliminacion);
    	
       }
       
        
        public void testcrearTareaCargaODEs()
        		throws java.lang.Exception
        {    	 
       	 TareaCargaODEsVO voCargaContenidos = new TareaCargaODEsVO();

       	 voCargaContenidos.setTrabajo("Trabajo1");
       	 voCargaContenidos.setGrupoTrabajo(CtesPlanificador.GRUPO_JOBS);
       	 voCargaContenidos.setTrigger("Trigger1");
       	 voCargaContenidos.setGrupoTrigger(CtesPlanificador.GRUPO_TRIGGER);
      
       	 voCargaContenidos.setPathODE("C:");
           voCargaContenidos.setPathODEsCargados("C:");
           voCargaContenidos.setPathODEsNoCargados("C:");
           voCargaContenidos.setPeriodicidad("N");
           voCargaContenidos.setUsuario(new Long(100));

           Calendar cal = new GregorianCalendar(2010, Calendar.JANUARY, 1);
           cal.set(cal.HOUR_OF_DAY, 1);
           cal.set(cal.MINUTE, 1);
           cal.set(cal.SECOND, 0);
           cal.set(cal.MILLISECOND, 0);

           Date startTime = cal.getTime();

           voCargaContenidos.setFechaInicio(startTime);
     
           this.servicio.crearTareaCargaODEs(voCargaContenidos); 
           assertNotNull(voCargaContenidos);
       }
        
         public void testcrearTareaReindexado() 
         		throws java.lang.Exception 
         {
      	   TareaReindexadoVO datosTarea = new TareaReindexadoVO();

      	   Calendar cal = new GregorianCalendar(2010, Calendar.JANUARY, 1);
             cal.set(cal.HOUR_OF_DAY, 2);
             cal.set(cal.MINUTE, 2);
             cal.set(cal.SECOND, 0);
             cal.set(cal.MILLISECOND, 0);

             Date startTime = cal.getTime();

             datosTarea.setTrabajo("Trabajo2");
             datosTarea.setGrupoTrabajo(CtesPlanificador.GRUPO_JOBS);
             datosTarea.setTrigger("Trigger2");
             datosTarea.setGrupoTrigger(CtesPlanificador.GRUPO_TRIGGER);

             datosTarea.setPeriodicidad("N");
             datosTarea.setUsuario(new Long(100)); 
             datosTarea.setFechaInicio(startTime);
             datosTarea.setRepositorioIndices("es_ES");

             this.servicio.crearTareaReindexado(datosTarea); 
             assertNotNull(datosTarea);
        }

          public void testobtenerTareaModificarCargaODEs() 
          		throws java.lang.Exception
          {     	
          	TareaVO voCargaContenidos = new TareaVO();    	
          	voCargaContenidos.setTrabajo("Trabajo1");
          	voCargaContenidos.setGrupoTrabajo(CtesPlanificador.GRUPO_JOBS);
          	voCargaContenidos.setTrigger("Trigger1");
          	voCargaContenidos.setGrupoTrigger(CtesPlanificador.GRUPO_TRIGGER);
          	voCargaContenidos.setUsuario(new Long(1));
          	
          	TareaCargaODEsVO tareaModificar = this.servicio.obtenerTareaModificarCargaODEs(voCargaContenidos);
          	
          	assertNotNull(tareaModificar);
         }
                
       public void testmodificarTareaCargaODEs()  
       		throws java.lang.Exception
       {	 
      	 // Tarea a modificar 
      	 TrabajoVO modificar = new TrabajoVO();
      	 modificar.setTrabajo("Trabajo1");
      	 modificar.setGrupoTrabajo(CtesPlanificador.GRUPO_JOBS);
      	 modificar.setUsuario(new Long(1));
      	 
      	 // Datos a modificar
      	 TareaCargaODEsVO datos = new TareaCargaODEsVO();
           datos.setTrabajo("Trabajo1");
           datos.setGrupoTrabajo(CtesPlanificador.GRUPO_JOBS);
           datos.setTrigger("Trigger1");
           datos.setGrupoTrigger(CtesPlanificador.GRUPO_TRIGGER);
           datos.setUsuario(new Long(1));
           
           // Nuevos valores
           Calendar cal = new GregorianCalendar(2010, Calendar.JANUARY, 1);
           cal.set(cal.HOUR_OF_DAY, 1);
           cal.set(cal.MINUTE, 1);
           cal.set(cal.SECOND, 0);
           cal.set(cal.MILLISECOND, 0);
           Date fecha = cal.getTime();
           
           datos.setFechaInicio(fecha);
           datos.setPeriodicidad("N");
           datos.setPathODE("D:");
           datos.setPathODEsCargados("D:");
           datos.setPathODEsNoCargados("D:");

           datos = this.servicio.modificarTareaCargaODEs(datos, modificar);
           
      	 assertTrue(datos.getTrabajo() != null);
      }

        public void testobtenerTareasPendientesTodas() 
        		throws java.lang.Exception
        {
       	 TareaVO[] tareas = this.servicio.obtenerTareasPendientesTodas();
   		 assertNotNull(tareas);
        }

         public void testobtenerTareasPendientes() 
         		throws java.lang.Exception
         {
        	 TareaVO[] tareas = this.servicio.obtenerTareasPendientes();
    		 assertNotNull(tareas);
         }

         public void testreiniciarPlanificador() 
         		throws java.lang.Exception
         {
        	 SrvPlanificadorService srv = this.servicio;
        	 
        	 if( Planificador.getAgenda().isStarted())
        		 this.servicio.reiniciarPlanificador();
        	 
        	 assertNotNull(srv);
         }
        
         public void testiniciarPlanificador() 
         		throws java.lang.Exception
         {
        	 SrvPlanificadorService planificador = this.servicio;
        	 Boolean ver= planificador.estaIniciado();
        	 
        	 if (ver == null)
        		 planificador.iniciarPlanificador();
        	 
        	 assertNotNull(planificador);
         }
              
     public void testpararPlanificador() 
     		throws java.lang.Exception
     {
    	this.servicio.pararPlanificador();
    	assertTrue (true);
     }

     public void testestaIniciado() 
     		throws java.lang.Exception
     {   
    	Boolean boo = this.servicio.estaIniciado();	
     	assertTrue (true);
     }
         */
}  
/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.auditoria.negocio.servicios;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.dbunit.database.DatabaseConnection;

/**
 * @see SrvAuditoriaServicioImpl
 */


public class TestSrvAuditoriaServicioImpl
    extends SrvAuditoriaServicioImplBase
{

    /**
     * Constructor
     */
	 public TestSrvAuditoriaServicioImpl()
	 {
		 super();
	 }

	
    /**
     * onTearDownInTransaction
     */

	      
/*
	        try 
	        {
	        	LdapUserDetailsAgrega.Essence user = new LdapUserDetailsAgrega.Essence();
	        	
	            user.setUsername("administrador");
	            user.setPassword("1");
	                        
	           // Si se quiere utilizar los datos del usuario que devuelve el servicio de administración de usuario 
	            user.setDatosUsuario("administrador");
	            
	            Authentication currentAuth = new UsernamePasswordAuthenticationToken(user.createUserDetails(), null);
	            SecurityContextHolder.getContext().setAuthentication(currentAuth);
	        } 
	        catch (Exception e) 
	        {
	              logger.error(e);
	              fail("Error de construccion del test durante la autenticacion");
	        }	
	        */
		//}

	 protected void onSetUpInTransaction() throws Exception {

    	 connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
  		
	}
     

    /**
     * onTearDownInTransaction
     */

	 protected void onTearDownInTransaction() {
			
		 try
    	 { 
    		 // Inicializamos la conexion a base de datos
    		 connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
    		 // Inicializamos el dataset
//    		 IDataSet dataSet = new XlsDataSet(this.applicationContext.getResource(datasetFile).getFile());
//    		 DatabaseOperation.DELETE.execute(connection, dataSet);
    	 }
    	 catch (Throwable th)
    	 {
    		 th.printStackTrace();
    	 }
		
         }

     /**
      * testInicial
      *   TODO: Agregar las pruebas unitarias que correspondan al servicio, siguiendo un patron de nombrado como
      *     public void test<nombreTest>().
      * 	 En el caso de tener que el metodo ${operation.name} acceda a un webservice
      * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
      * 	 antes de invocarlo en el test, se debe establecer un usuario con
      * 	 derechos de acceso utilizando el método 
      * 	 {@link es.indra.servicios.SrvAuditoriaServicioImplBase#initAthenticationUser(String, String) 
      * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */	
	
	
     /**
      *   TEST registrarTrabajoPlan
      *   TODO: Implementar el test para el metodo registrarTrabajoPlan del servicio SrvAuditoriaServicio.
      * 	 En el caso de tener que el metodo registrarTrabajoPlan acceda a un webservice
      * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
      * 	 antes de invocarlo en el test, se debe establecer un usuario con
      * 	 derechos de acceso utilizando el método 
      * 	 {@link es.indra.servicios.SrvAuditoriaServicioImplBase#initAthenticationUser(String, String) 
      * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
      */


      public void testregistrarTrabajoPlan() {
 		
     	TareaEjecutadaPlanVO tarea = new TareaEjecutadaPlanVO(); 
     	 
  		//tarea.setId(new Long("1001"));
 		tarea.setTrabajo("Trabajo1");
 		tarea.setGrupoTrabajo("GrupoTrabajo1");
 		tarea.setDescripcion("Descripcion");
 		tarea.setEstado("1");
 		tarea.setFechaInicio(new Date());
 		tarea.setFechaFin(new Date());
 		
        // Long id = this.servicio.registrarTrabajoPlan(tarea);
      	 // logger.info("id "+id); 	
 		//assertNotNull(id);    	 
     }
 
      /**
       *   TEST registrarTrabajoFechaFinPlan
       *   TODO: Implementar el test para el metodo registrarTrabajoFechaFinPlan del servicio SrvAuditoriaServicio.
       * 	 En el caso de tener que el metodo registrarTrabajoFechaFinPlan acceda a un webservice
       * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
       * 	 antes de invocarlo en el test, se debe establecer un usuario con
       * 	 derechos de acceso utilizando el método 
       * 	 {@link es.indra.servicios.SrvAuditoriaServicioImplBase#initAthenticationUser(String, String) 
       * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
       */
	
       public void testregistrarTrabajoFechaFinPlan() {
  		String prueba = null; 
  		

      }

       /**
        *   TEST registrarTrabajoHijoPlan
        *   TODO: Implementar el test para el metodo registrarTrabajoHijoPlan del servicio SrvAuditoriaServicio.
        * 	 En el caso de tener que el metodo registrarTrabajoHijoPlan acceda a un webservice
        * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
        * 	 antes de invocarlo en el test, se debe establecer un usuario con
        * 	 derechos de acceso utilizando el método 
        * 	 {@link es.indra.servicios.SrvAuditoriaServicioImplBase#initAthenticationUser(String, String) 
        * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
        */

        public void testregistrarTrabajoHijoPlan() {
   		String prueba = null; 
   		

       }
       
        /**
         *   TEST registrarTrabajoInterrPlan
         *   TODO: Implementar el test para el metodo registrarTrabajoInterrPlan del servicio SrvAuditoriaServicio.
         * 	 En el caso de tener que el metodo registrarTrabajoInterrPlan acceda a un webservice
         * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
         * 	 antes de invocarlo en el test, se debe establecer un usuario con
         * 	 derechos de acceso utilizando el método 
         * 	 {@link es.indra.servicios.SrvAuditoriaServicioImplBase#initAthenticationUser(String, String) 
         * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
         */

         public void testregistrarTrabajoInterrPlan() {
    		String prueba = null; 
    		
        } 
       
    /**
     *   TEST registrarOperacion
     *   TODO: Implementar el test para el metodo registrarOperacion del servicio SrvAuditoriaServicio.
     */
	
     public void testregistrarOperacion() {
		String prueba = null; 
		

    }

         
    /**
     *   TEST informeTerminosBusqueda
     *   TODO: Implementar el test para el metodo informeTerminosBusqueda del servicio SrvAuditoriaServicio.
     */
	
     public void testinformeTerminosBusqueda() 
     {
    	 ParametrosInformeVO parametrosInformeVO = new ParametrosInformeVO();
    	 GregorianCalendar gregorianCalendarInicial = new GregorianCalendar(2007,Calendar.DECEMBER,1);
	     Date fechaInicial = gregorianCalendarInicial.getTime();
	     GregorianCalendar gregorianCalendarFinal = new GregorianCalendar(2007,Calendar.DECEMBER,31);
	     Date fechaFinal = gregorianCalendarFinal.getTime();
	     logger.info("fechaFinal "+fechaFinal);
    	 parametrosInformeVO.setFechaDesde(fechaInicial);
    	 parametrosInformeVO.setFechaHasta(fechaFinal);
    	 parametrosInformeVO.setRango(5);
    	 logger.info("Despues de asignar la fechaDesde y fechaHAsta");
    	 InformeTerminoBusquedaVO[] informeTerminoBusqueda = this.servicio.informeTerminosBusqueda(parametrosInformeVO);
    	 logger.info("Despues de obtener informeTerminoBusqueda");
    	 if(informeTerminoBusqueda == null)
    	 {
    		logger.info("No hay terminos buscados en ese periodo"); 
    	 }else
    	 {
    		 for(int i=0;i<informeTerminoBusqueda.length;i++)
    		 {
    			 logger.info("informeTerminoBusqueda[i].getTerminoBuscado() "+informeTerminoBusqueda[i].getTerminoBuscado());
    			 logger.info("informeTerminoBusqueda[i].getNumVeces() "+informeTerminoBusqueda[i].getNumVeces());
    		 }
    	 }
     }

   

    

   
       /**
     *   TEST informeUsuarios
     *   Implementa el test para el método del servicio InformeUsuarios. Necesitará como parámetro la fecha de inicio y la fecha
     *   final.
     */
	
     public void testinformeUsuarios() {
    	 ParametrosInformeVO parametrosInformeVO = new ParametrosInformeVO();
    	 GregorianCalendar gregorianCalendarInicial = new GregorianCalendar(2007,Calendar.JANUARY,1);
	     Date fechaInicial = gregorianCalendarInicial.getTime();
	     GregorianCalendar gregorianCalendarFinal = new GregorianCalendar(2007,Calendar.FEBRUARY,1);
	     Date fechaFinal = gregorianCalendarFinal.getTime();
	     logger.info("fechaFinal "+fechaFinal);
    	 parametrosInformeVO.setFechaDesde(fechaInicial);
    	 parametrosInformeVO.setFechaHasta(fechaFinal);
    	 InformeUsuariosVO[] informeUsuariosVO = null;
    	  if(informeUsuariosVO == null)
    	 {
    		 logger.info("No hay usuarios en ese periodo");
    	 }else
    	 {
    		 for(int i=0;i<informeUsuariosVO.length;i++){
    			 logger.info("usuariosActivos[i].getLogin() "+informeUsuariosVO[i]); 
    		 }
    	 }
    	// assertEquals(informeUsuariosVO.length,2);

    }

  

    /**
     *   TEST informeMasValorado
     *   TODO: Implementar el test para el metodo informeMasValorado del servicio SrvAuditoriaServicio.
     */
	
     public void testinformeMasValorado() {
    	 ParametrosInformeVO parametrosInformeVO = new ParametrosInformeVO();
    	 GregorianCalendar gregorianCalendarInicial = new GregorianCalendar(2006,Calendar.JANUARY,10);
	     Date fechaInicial = gregorianCalendarInicial.getTime();
	     GregorianCalendar gregorianCalendarFinal = new GregorianCalendar(2008,Calendar.DECEMBER,13);
	     Date fechaFinal = gregorianCalendarFinal.getTime();
	     logger.info("fechaFinal "+fechaFinal);
    	 parametrosInformeVO.setFechaDesde(fechaInicial);
    	 parametrosInformeVO.setFechaHasta(fechaFinal);
    	 parametrosInformeVO.setRango(10);
    	 InformeMasValoradoVO[] informeMasValoradoVO = this.servicio.informeMasValorado(parametrosInformeVO);
    	 
    	 if(informeMasValoradoVO == null)
    	 {
    		 logger.info("no hay odes mas valorados en ese periodo");
    	 }else
    	 {
    		 for(int i=0;i<informeMasValoradoVO.length;i++)
    		 {
    			 logger.info("informeMasValoradoVO[i].getTitulo() "+informeMasValoradoVO[i].getTitulo()); 
    			 logger.info("informeMasValoradoVO[i].getValoracion() "+informeMasValoradoVO[i].getValoracion());
    			 logger.info("informeMasValoradoVO[i].getIdOde() "+informeMasValoradoVO[i].getIdOde());
    		 }
    	 }
    }

    /**
     *   TEST informeMasMostrado
     *   TODO: Implementar el test para el metodo informeMasMostrado del servicio SrvAuditoriaServicio.
     */
	
     public void testinformeMasMostrado() {
    	 logger.info("MAS MOSTRADO");
    	 ParametrosInformeVO parametrosInformeVO = new ParametrosInformeVO();
    	 GregorianCalendar gregorianCalendarInicial = new GregorianCalendar(2007,Calendar.NOVEMBER,20);
	     Date fechaInicial = gregorianCalendarInicial.getTime();
	     GregorianCalendar gregorianCalendarFinal = new GregorianCalendar(2008,Calendar.DECEMBER,31);
	     Date fechaFinal = gregorianCalendarFinal.getTime();
	     logger.info("fechaFinal "+fechaFinal);
    	 parametrosInformeVO.setFechaDesde(fechaInicial);
    	 parametrosInformeVO.setFechaHasta(fechaFinal);
    	 parametrosInformeVO.setRango(9);
    	 InformeMasVO[] informeMasVO = this.servicio.informeMasMostrado(parametrosInformeVO);
    	 logger.info("despues de llamar al servicio "+informeMasVO);
    	 if(informeMasVO == null)
    	 {
    		 logger.info("No hay odes mas mostrados");
    	 }else
    	 {
    		 for(int i=0;i<informeMasVO.length;i++)
    		 {
    			 logger.info("informeMasVO[i].getTituloOde() "+informeMasVO[i].getTituloOde()); 
    			 logger.info("informeMasVO[i].getNumVeces() "+informeMasVO[i].getNumVeces());
    			 logger.info("informeMasVO[i].getIdioma() "+informeMasVO[i].getIdioma());
    			 logger.info("informeMasVO[i].getIdOde() "+informeMasVO[i].getIdOde());
    			 logger.info("informeMasVO[i].getUrlImagen() "+informeMasVO[i].getUrlImagen());
    		 }
    	 }
    }

    /**
     *   TEST informeMasPrevisualizados
     *   TODO: Implementar el test para el metodo informeMasPrevisualizados del servicio SrvAuditoriaServicio.
     */
	 
     public void testinformeMasPrevisualizados() {
    	 logger.info("MAS PREVISUALIZADO");
    	 ParametrosInformeVO parametrosInformeVO = new ParametrosInformeVO();
    	 GregorianCalendar gregorianCalendarInicial = new GregorianCalendar(2006,Calendar.NOVEMBER,20);
	     Date fechaInicial = gregorianCalendarInicial.getTime();
	     GregorianCalendar gregorianCalendarFinal = new GregorianCalendar(2008,Calendar.DECEMBER,31);
	     Date fechaFinal = gregorianCalendarFinal.getTime();
	     logger.info("fechaFinal "+fechaFinal);
    	 parametrosInformeVO.setFechaDesde(fechaInicial);
    	 parametrosInformeVO.setFechaHasta(fechaFinal);
    	 parametrosInformeVO.setRango(3);
    	 InformeMasVO[] informeMasVO = this.servicio.informeMasPrevisualizados(parametrosInformeVO);
    	 if(informeMasVO == null)
    	 {
    		logger.info("no hay odes mas previsualizados en ese periodo de tiempo"); 
    	 }else
    	 {
    		 logger.info("informeMasVO.length "+informeMasVO.length);
    	 for(int i=0;i<informeMasVO.length;i++)
    	 {
    		 
    		 logger.info("informeMasVO[i].getTituloOde() "+informeMasVO[i].getTituloOde()); 
			 logger.info("informeMasVO[i].getNumVeces() "+informeMasVO[i].getNumVeces());
			 logger.info("informeMasVO[i].getIdioma() "+informeMasVO[i].getIdioma());
			 logger.info("informeMasVO[i].getIdOde() "+informeMasVO[i].getIdOde());
    	 }
    	 }

    }

   

    /**
     *   TEST informeMasDescargados
     *   TODO: Implementar el test para el metodo informeMasDescargados del servicio SrvAuditoriaServicio.
     */

     public void testinformeMasDescargados() {
    	 logger.info("MAS DESCARGADO");
    	 ParametrosInformeVO parametrosInformeVO = new ParametrosInformeVO();
    	 GregorianCalendar gregorianCalendarInicial = new GregorianCalendar(2006,Calendar.NOVEMBER,20);
	     Date fechaInicial = gregorianCalendarInicial.getTime();
	     GregorianCalendar gregorianCalendarFinal = new GregorianCalendar(2009,Calendar.DECEMBER,31);
	     Date fechaFinal = gregorianCalendarFinal.getTime();
	     logger.info("fechaFinal "+fechaFinal);
    	 parametrosInformeVO.setFechaDesde(fechaInicial);
    	 parametrosInformeVO.setFechaHasta(fechaFinal);
    	 parametrosInformeVO.setRango(3);
    	 InformeMasVO[] informeMasVO = this.servicio.informeMasDescargados(parametrosInformeVO);
    	 if(informeMasVO == null)
    	 {
    		 logger.info("No hay odes mas descargados en ese periodo de tiempo");
    	 }else
    	 {
    		 for(int i=0;i<informeMasVO.length;i++)
    		 {
    			 logger.info("informeMasVO[i].getTituloOde() "+informeMasVO[i].getTituloOde()); 
    			 logger.info("informeMasVO[i].getNumVeces() "+informeMasVO[i].getNumVeces());
    			 logger.info("informeMasVO[i].getIdioma() "+informeMasVO[i].getIdioma());
    			 logger.info("informeMasVO[i].getIdOde() "+informeMasVO[i].getIdOde());
    		 }
    	 }
    }

    /**
     *   TEST informeMasPesados
     *   TODO: Implementar el test para el metodo informeMasPesados del servicio SrvAuditoriaServicio.
     */

     public void testinformeMasPesados() {
    	 ParametrosInformeVO parametrosInformeVO = new ParametrosInformeVO();
    	 GregorianCalendar gregorianCalendarInicial = new GregorianCalendar(2007,Calendar.NOVEMBER,20);
	     Date fechaInicial = gregorianCalendarInicial.getTime();
	     GregorianCalendar gregorianCalendarFinal = new GregorianCalendar(2007,Calendar.DECEMBER,31);
	     Date fechaFinal = gregorianCalendarFinal.getTime();
	     logger.info("fechaFinal "+fechaFinal);
    	 parametrosInformeVO.setFechaDesde(fechaInicial);
    	 parametrosInformeVO.setFechaHasta(fechaFinal);
    	 parametrosInformeVO.setRango(10);
    	 //InformeMasPesadosVO[] informeMasPesadosVO = this.servicio.informeMasPesados(parametrosInformeVO);
    	 InformeMasPesadosVO[] informeMasPesadosVO = null;
    	 if(informeMasPesadosVO == null)
    	 {
    		 logger.info("No hay odes mas pesados en ese periodo de tiempo");
    	 }else
    	 {
    		 for(int i=0;i<informeMasPesadosVO.length;i++)
    		 {
    			 logger.info("informeMasPesadosVO[i].getTituloOde() "+informeMasPesadosVO[i].getTituloOde()); 
    			 logger.info("informeMasPesadosVO[i].getTamanio() "+informeMasPesadosVO[i].getTamanio());
    		 }	 
    	 }
    }
 
    public void testObtenerInformes()
    
   {
 	
 	logger.info("Obtener informes");
 	String[] resultado = servicio.obtenerInformes();
 	logger.info("el valor de resultado es "+resultado.length);
 	for(int i=0;i<resultado.length;i++)
 	{
 		logger.info("el valor de informes es "+resultado[i]);
 	}
   }
    
    public void testObtenNumeroOperaciones(){
    	logger.info("Obtener numero de operaciones");
    	String identificador="es_20080625_1_9084351";
    	//es_20080625_3_9105219;es_20080618_1_9120636
    	System.out.println("Empecemos");
    	NumeroOperacionesVO[] numeroOperaciones=servicio.obtenNumeroOperaciones(identificador);
    	System.out.println("Tarda?");
    }
 	
 
	
	
}

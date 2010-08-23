/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.planificador.negocio.servicios;

import java.util.Date;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

import es.pode.soporte.seguridad.ldap.LdapUserDetailsAgrega;

/**
 * @see SrvRegistroPlanificadorServiceImpl
 */
public class TestSrvRegistroPlanificadorServiceImpl
    extends SrvRegistroPlanificadorServiceImplBase
{


	private String datasetFile = "SrvDataEmptyDataSet.xls";
	
    /**
     * Constructor
     */
     public TestSrvRegistroPlanificadorServiceImpl()
     {
         logger.info("Autenticando usuario administrador con password 1");

         try {
         	LdapUserDetailsAgrega.Essence user = new LdapUserDetailsAgrega.Essence();
         	
             user.setUsername("administrador");
             user.setPassword("1");
             
             /* Si se quiere utilizar los datos del usuario que devuelve el servicio de administración de usuario */
             user.setDatosUsuario("administrador");
             
             Authentication currentAuth = new UsernamePasswordAuthenticationToken(user.createUserDetails(), null);
             SecurityContextHolder.getContext().setAuthentication(currentAuth);
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

     protected void onSetUpInTransaction() throws Exception 
     {		
 		/* Inicializamos la conexion a base de datos 
 		connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
 		DatabaseConfig config = connection.getConfig();
 		IDataSet dataSet = new XlsDataSet(this.applicationContext.getResource("SrvDataEmptyDataSet.xls").getFile());
 		DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
 		*/
	}

    /**
     * onTearDownInTransaction
     */

	 protected void onTearDownInTransaction() 
	 {
		 try 
		 {
			/* Inicializamos la conexion a base de datos 
			connection = new DatabaseConnection(this.jdbcTemplate.getDataSource().getConnection());
			IDataSet dataSet = new XlsDataSet(this.applicationContext.getResource("SrvDataEmptyDataSet.xls").getFile());
			DatabaseOperation.DELETE_ALL.execute(connection, dataSet);
			*/
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
     */	
     public void testInicial(){
	}
	
	
    /**
     *   TEST registrarTrabajo
     *   
     */
     public void testregistrarTrabajo() 
     {
    	 TareaEjecutadaVO trabajo = new TareaEjecutadaVO();
    	 Long id = null;
    	 
    	 trabajo.setId(new Long("999"));
    	 trabajo.setTrabajo("Prueba1");
    	 trabajo.setDescripcion("descripcion1");
    	 trabajo.setEstado("1");
    	 trabajo.setGrupoTrabajo("Grupo trabajo1");
    	 trabajo.setUsuario("1234");
    	 
    	 try {
    		 id = this.servicio.registrarTrabajo(trabajo);
    	 }
    	 catch (Exception e)
    	 {
    		 fail("Error al llamar al servicio de registrar trabajo");
    	 }
    
		 assertNotNull(id);
    }

    /**
     *   TEST registrarTrabajoHijo
     *   
     
     public void testregistrarTrabajoHijo() 
     {
    	 TareaEjecutadaVO trabajoPadre = new TareaEjecutadaVO(); 
    	 RegistroTareaEjecutadaVO trabajoHijo = new RegistroTareaEjecutadaVO();
    	 Long id = null;
    	 
    	 trabajoPadre.setId(new Long("1"));
    	 trabajoHijo.setId(new Long("999"));
    	 trabajoHijo.setCodigo("0.0");
    	 trabajoHijo.setDescripcion("descripcion1");
    	 trabajoHijo.setEstado("1");
    	 trabajoHijo.setFecha(new Date());
    	 trabajoHijo.setTarea_ejecutada(trabajoPadre);

    	 try 
    	 {
    		 id = this.servicio.registrarTrabajoHijo(trabajoHijo);
    	 }
    	 catch (Exception e)
    	 {
    		 fail("Error al llamar al servicio de registrar trabajo hijo");
    	 }

		 assertNotNull(id);
    }
*/
    /**
     *   TEST registrarTrabajoFechaFin
     
     public void testregistrarTrabajoFechaFin()
     {
    	 TareaEjecutadaVO trabajo = new TareaEjecutadaVO();
    	 Long id = null;
    	 
    	 trabajo.setId(new Long("1"));
    	 trabajo.setTrabajo("Prueba1");
    	 trabajo.setDescripcion("descripcion1");
    	 trabajo.setEstado("1");
    	 trabajo.setGrupoTrabajo("Grupo trabajo1");
    	 trabajo.setUsuario(new Long("1234"));
    	 trabajo.setFechaFin(new Date());
    	 
    	 try
    	 {
    		 id = this.servicio.registrarTrabajoFechaFin(trabajo);
    	 }
    	 catch (Exception e)
    	 {
    		 fail("Error al llamar al servicio de registrar fin de trabajo");
    	 }

 		 assertNotNull(id);
    }
*/
    /**
     *   TEST registrarTrabajoInterrupido
     *   TODO: Implementar el test para el metodo registrarTrabajoInterrupido del servicio SrvRegistroPlanificadorService.
     */
     public void testregistrarTrabajoInterrupido() throws java.lang.Exception
     {
    	 Long numTareasInterrumpidas = this.servicio.registrarTrabajoInterrumpido();
    	 assertNotNull(numTareasInterrumpidas);
     }
}
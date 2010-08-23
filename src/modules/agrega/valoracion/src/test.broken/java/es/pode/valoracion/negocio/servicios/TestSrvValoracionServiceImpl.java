/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.valoracion.negocio.servicios;

import java.util.List;

//import es.pode.valoracion.negocio.dominio.ComentarioDao;
//import es.pode.valoracion.negocio.dominio.ComentarioDao;
import es.pode.valoracion.negocio.dominio.IdODEFechaCriteria;

/**
 * @see SrvValoracionServiceImpl
 * TODO: To execute test on services that invoke webservices which implement security,
 * you must include the next param to the java virtual machine:
 * -Daxis.ClientConfigFile=client-config.wsdd
 */
public class TestSrvValoracionServiceImpl
    extends SrvValoracionServiceImplBase
{


    /**
     * Constructor
     */
     public TestSrvValoracionServiceImpl(){
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
     * 	 {@link es.indra.servicios.SrvValoracionServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */	
     public void testInicial(){
		String prueba = null;
		this.initAthenticationUser("usuario", "ibuilder"); 
		assertNull(prueba);
	}
	
	
    /**
     *   TEST introducirComentario
     *   TODO: Implementar el test para el metodo introducirComentario del servicio SrvValoracionService.
     * 	 En el caso de tener que el metodo introducirComentario acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvValoracionServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
//     FUNCIONA
     public void testintroducirComentario() {
    	 
    	 //Creamos un comentario

    	 String idODE="identificador_prueba_1";
    	 String idiomaODE = "es";
    	 String titulo="Titulo_ODE_1";
    	 String comentario="Comentario del ODE 1";
    	 String usuario = "Usuario que ha creado el comentario";
    	 servicio.introducirComentario(idODE, comentario, idiomaODE, usuario);   
    	 
//    	Llamo al metodo que devuelvo los comentarios
    	 ComentarioVO[] prueba=servicio.obtenerComentarios(idODE);
    	 
    	 //Comprobaciones
    	 assertTrue(prueba.length==1);
    	 assertEquals("Comprobacion idODE", prueba[0].getIdODE(), idODE);    	 
    	 assertEquals("Comprobacion comentario", prueba[0].getComentario(), comentario);
    	 assertEquals("Comprobacion valoracion", prueba[0].getUsuario(), usuario);    	     	 

    }

    /**
     *   TEST consultarValoracion
     *   TODO: Implementar el test para el metodo consultarValoracion del servicio SrvValoracionService.
     * 	 En el caso de tener que el metodo consultarValoracion acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvValoracionServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testconsultarValoracion() {
		
    	 //	Introduzco 2 comentarios
    	 String idODE="identificador_prueba_1";
    	 String autor = "Autor de la valoracion";
    	 String idiomaODE = "es";
    	 Float valoracion=new Float(5.0); 
    	 servicio.introducirValoracion(valoracion, idODE, autor, idiomaODE);    	 
    	 
    	 
    	 Float valoracion_2=new Float(4.0); 
    	 String autor2 = "Autor2 de la valoracion";
    	 servicio.introducirValoracion(valoracion_2, idODE, autor2, idiomaODE);      	   
    	 
    	 Float pruebaFloat=new Float(4.5);
    	 
    	 //Llamamos al metodo que consulta la valoracion
    	 Float resultadoValoracion=servicio.consultarValoracion(idODE);
    	 assertEquals("Comprobacion valoracion", resultadoValoracion, pruebaFloat); 	   	 

    }

    /**
     *   TEST eliminarComentarios
     *   TODO: Implementar el test para el metodo eliminarComentarios del servicio SrvValoracionService.
     * 	 En el caso de tener que el metodo eliminarComentarios acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvValoracionServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
//     FUNCIONA
     public void testeliminarComentarios() {
		
    	 //Primero creo comentarios: 3 pertenecientes a un ode y 1 perteneciente a otro ODE
    	 String idODE="identificador_prueba_1";
    	 String idiomaODE = "es";
    	 String titulo="Titulo_ODE_1";
    	 String comentario="Comentario del ODE 1";
    	 String usuario1 = "Usuario1"; 	 
    	 servicio.introducirComentario(idODE, comentario, idiomaODE, usuario1);
    	 
    	 String titulo_2="Titulo_ODE_2";
    	 String comentario_2="Comentario del ODE 2";
    	 String usuario2 = "Usuario2"; 	       	 
    	 servicio.introducirComentario(idODE, comentario_2, idiomaODE, usuario2);    	 
    	 
    	 String titulo_3="Titulo_ODE_3";
    	 String comentario_3="Comentario del ODE 3";
    	 String usuario3 = "Usuario3"; 	       	 
    	 servicio.introducirComentario(idODE, comentario_3, idiomaODE, usuario3);
    	 
    	 //Elimino dos comentarios
    	 Long[] id = new Long[2];
    	 id[0] = new Long(9);
    	 id[1] = new Long(11);
    	 
    	 //Elimino los comentarios del ODE que tiene 3
    	 servicio.eliminarComentarios(id);
    	 
    	 //Compruebo que hay un elemento
    	 ComentarioVO[] comments = servicio.obtenerComentarios(idODE);
    	 assertTrue(comments.length==1);
    	 assertEquals("Comprobacion idODE", comments[0].getIdODE(), idODE);    	
    	 assertEquals("Comprobacion comentario", comments[0].getComentario(), comentario_2);
    	 assertEquals("Comprobacion valoracion", comments[0].getUsuario(), usuario2);  
    	 
    }
    

    /**
     *   TEST recalcularValoracionODE
     *   TODO: Implementar el test para el metodo recalcularValoracionODE del servicio SrvValoracionService.
     * 	 En el caso de tener que el metodo recalcularValoracionODE acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvValoracionServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testrecalcularValoracionODE() {
    	 
    	 

    }

    /**
     *   TEST obtenerComentarios
     *   TODO: Implementar el test para el metodo obtenerComentarios del servicio SrvValoracionService.
     * 	 En el caso de tener que el metodo obtenerComentarios acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvValoracionServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     //FUNCIONA
     public void testobtenerComentarios() {
//    	Introduzco 2 comentarios
    	 String idODE="identificador_prueba_1";
    	 String idiomaODE = "es";
    	 String titulo="Titulo_ODE_1";
    	 String comentario="Comentario del ODE 1";
    	 String usuario = "Usuario comentario 1";
    	 servicio.introducirComentario(idODE, comentario, idiomaODE, usuario);
    	 
    	 
    	 String titulo_2="Titulo_ODE_2";    	
    	 String comentario_2="Comentario del ODE 2";
    	 String usuario2 = "Usuario comentario 1";    	 
    	 servicio.introducirComentario(idODE, comentario_2, idiomaODE, usuario2);        	 
    	 
    	 //Llamo al metodo que devuelvo los comentarios
    	 ComentarioVO[] prueba=servicio.obtenerComentarios(idODE);
    	 
    	 //Comprobaciones
    	 assertTrue(prueba.length==2);
    	 assertEquals("Comprobacion idODE", prueba[0].getIdODE(), idODE);    	 
    	 assertEquals("Comprobacion comentario", prueba[0].getComentario(), comentario);
    	 assertEquals("Comprobacion valoracion", prueba[0].getUsuario(), usuario);    	 
    	 assertEquals("Comprobacion idODE", prueba[1].getIdODE(), idODE);    	 
    	 assertEquals("Comprobacion comentario", prueba[1].getComentario(), comentario_2);
    	 assertEquals("Comprobacion valoracion", prueba[1].getUsuario(), usuario2);

    }
     
    public void testintroducirValoracion(){
    	
    	 //Creamos una valoracion    	
	   	 String idODE="identificador_prueba_valoracion_1";
	   	 Float valoracion = new Float(3.0);	   	
	   	 String autor = "Autor que ha creado la valoracion";
	   	 String idiomaODE = "es";
	   	 servicio.introducirValoracion(valoracion, idODE, autor, idiomaODE);
	   	  
	   	 
	//   	Llamo al metodo que devuelvo los comentarios
	   	 ComentarioVO[] prueba=servicio.obtenerComentarios(idODE);
	   	 
	   	 //Comprobaciones
	   	 assertTrue(prueba.length==1);
	   	 assertEquals("Comprobacion idODE", prueba[0].getIdODE(), idODE);
	   	 
    }
	
	
	
}
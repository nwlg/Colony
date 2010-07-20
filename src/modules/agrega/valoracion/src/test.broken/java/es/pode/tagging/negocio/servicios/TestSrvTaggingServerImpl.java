/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.tagging.negocio.servicios;


/**
 * @see SrvTaggingServerImpl
 * TODO: To execute test on services that invoke webservices which implement security,
 * you must include the next param to the java virtual machine:
 * -Daxis.ClientConfigFile=client-config.wsdd
 */
public class TestSrvTaggingServerImpl
    extends SrvTaggingServerImplBase
{


    /**
     * Constructor
     */
     public TestSrvTaggingServerImpl(){
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
     * 	 {@link es.indra.servicios.SrvTaggingServerImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */	
     public void testInicial(){
		String prueba = null;
		this.initAthenticationUser("usuario", "ibuilder"); 
		assertNotNull(prueba);
	}
	
	
    /**
     *   TEST introducirTag
     *   TODO: Implementar el test para el metodo introducirTag del servicio SrvTaggingServer.
     * 	 En el caso de tener que el metodo introducirTag acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvTaggingServerImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testintroducirTags() {

    	 //Creamos un tag

    	 String idOde="identificador_prueba_1";
    	 String[] tag = new String[1];
    	 tag[0]= "etiqueta1";
    	 String idUsuario = "Usuario que ha creado el tag";
    	 String titulo= "Esto es un título";
    	 String idioma= "es";
    	 servicio.introducirTags(idOde, titulo, idioma, tag, idUsuario);
    	 
//    	Llamo al metodo que devuelve los tags
    	 TagVO[] tagging= servicio.obtenerTodosTags();
    	 
    	 //Comprobaciones
    	 assertTrue(tagging.length==1);
//    	 assertEquals("Comprobacion idOde", tagging[0], idOde);    	 
//    	 assertEquals("Comprobacion tag", tagging[0].getTag(), tag);
//    	 assertEquals("Comprobacion idUsuario", tagging[0].getIdUsuario(), idUsuario);

    }

    /**
     *   TEST obtenerTagsDeUsuario
     *   TODO: Implementar el test para el metodo obtenerTagsDeUsuario del servicio SrvTaggingServer.
     * 	 En el caso de tener que el metodo obtenerTagsDeUsuario acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvTaggingServerImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testobtenerTagsDeUsuario() {
    	 
    	 String idUsuario="nrm";
    	 
    	 TagVO[] lista= servicio.obtenerTagsDeUsuario(idUsuario);
    	 
    	 assertTrue(lista.length==5);
    	 assertEquals("Comprobacion tag", lista[0].getNombre(), "casa");

    }

    /**
     *   TEST obtenerOdesDeTagYUsuario
     *   TODO: Implementar el test para el metodo obtenerOdesDeTagYUsuario del servicio SrvTaggingServer.
     * 	 En el caso de tener que el metodo obtenerOdesDeTagYUsuario acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvTaggingServerImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testobtenerOdesDeTagYUsuario() {

    	 String idUsuario="idUsuario20";
    	 String tag= "tag20";
    	 
    	 TaggingVO[] lista= servicio.obtenerOdesDeTagYUsuario(tag, idUsuario);
    	 
    	 assertTrue(lista.length==1);
    	 assertEquals("Comprobacion usuario", lista[0].getIdUsuario(), idUsuario);
    	 assertEquals("Comprobacion tag", lista[0].getTag(), tag);

    }

    /**
     *   TEST obtenerTodosTags
     *   TODO: Implementar el test para el metodo obtenerTodosTags del servicio SrvTaggingServer.
     * 	 En el caso de tener que el metodo obtenerTodosTags acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvTaggingServerImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testobtenerTodosTags() {

    	 TagVO[] lista= servicio.obtenerTodosTags();
    	 
    	 assertTrue(lista.length==4);

    }

    /**
     *   TEST obtenerOdesDeTag
     *   TODO: Implementar el test para el metodo obtenerOdesDeTag del servicio SrvTaggingServer.
     * 	 En el caso de tener que el metodo obtenerOdesDeTag acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvTaggingServerImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testobtenerOdesDeTag() {

    	 String tag= "tag20";
    	 
    	 TaggingVO[] lista= servicio.obtenerOdesDeTag(tag);
    	 
    	 assertTrue(lista.length==1);
    	 assertEquals("Comprobacion tag", lista[0].getTag(), tag);

    }

    /**
     *   TEST eliminarTags
     *   TODO: Implementar el test para el metodo eliminarTags del servicio SrvTaggingServer.
     * 	 En el caso de tener que el metodo eliminarTags acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvTaggingServerImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testeliminarTags() {

//    	Primero se crean tags
    	 String idOde="identificador_prueba_1";
    	 String[] tag = new String[1];
    	 tag[0]= "etiqueta1";
    	 String idUsuario = "Usuario que ha creado el tag";
    	 String titulo= "Esto es un título";
    	 String idioma= "es";
    	 servicio.introducirTags(idOde, titulo, idioma, tag, idUsuario);
    	 
    	 String idOde2="identificador_prueba_1";
    	 String[] tag2 = new String[1];
    	 tag[0]= "etiqueta1";
    	 String idUsuario2 = "Usuario que ha creado el tag";
    	 String titulo2= "Esto es un título";
    	 String idioma2= "es";
    	 servicio.introducirTags(idOde2, titulo2, idioma2, tag2, idUsuario2);   	 
    	 
    	 TagVO[] etiqueta= servicio.obtenerTagsDeUsuario(idUsuario2);
    	 
    	 //Elimino los comentarios del ODE que tiene 3
//    	 servicio.eliminarTags(etiqueta);
    	 
    	 //Compruebo que hay un elemento
    	 TagVO[] lista = servicio.obtenerTodosTags();
    	 assertTrue(lista.length==1);

    }
     
     public void testmodificarTag() {
    	 
    	 String[] tags= new String[2];
    	 tags[0]= "perro";
    	 tags[1]= "gato";
    	 servicio.introducirTags("idOde1", "titulo del ODe", "es", tags, "user1");
    	 
    	 assertTrue(servicio.modificarTag("perro", "gato"));
    	 
    	 TagVO[] lista= servicio.obtenerTagsDeUsuario("user1");
    	 
     }
     
     public void testmodificarTagDeUsuario() {
    	 
    	 String[] tags= new String[2];
    	 tags[0]= "perro";
    	 tags[1]= "gato";
    	 servicio.introducirTags("idOde1", "titulo del ODe", "es", tags, "user1");
    	 
    	 assertTrue(servicio.modificarTagDeUsuario("perro", "gato", "user1"));
    	 
    	 TagVO[] lista= servicio.obtenerTagsDeUsuario("user1");
    	 
     }


      public void testobtenerTagsDeOde() {
     	 
     	 String idOde="idOde1";
     	 
     	 String[] lista= servicio.obtenerTagsDeOde(idOde);
     	 
     	 assertTrue(lista.length==5);
     	 assertEquals("Comprobacion tag", lista[0], "Prueba");

     }
	
	
}
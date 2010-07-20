/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.buscar.negocio.nodosSQI.servicio;

/**
 * @see SrvGestionSqiServiceImpl
 * TODO: To execute test on services that invoke webservices which implement security,
 * you must include the next param to the java virtual machine:
 * -Daxis.ClientConfigFile=client-config.wsdd
 */
public class TestSrvGestionSqiServiceImpl
    extends SrvGestionSqiServiceImplBase
{


    /**
     * Constructor
     */
     public TestSrvGestionSqiServiceImpl(){
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
     * 	 {@link es.indra.servicios.SrvGestionSqiServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */	
     public void testInicial(){
		String prueba = null;
		this.initAthenticationUser("usuario", "ibuilder"); 
		assertNotNull(prueba);
	}
	
	
    /**
     *   TEST altaNodoSQI
     *   TODO: Implementar el test para el metodo altaNodoSQI del servicio SrvGestionSqiService.
     * 	 En el caso de tener que el metodo altaNodoSQI acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvGestionSqiServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testaltaNodoSQI() {
 		NodoSQIVO nodoSQI=new NodoSQIVO();
 		nodoSQI.setClave("larraitz");
 		nodoSQI.setDescripcionNodo("Nodo con lenguaje de respuesta LOM-es");
 		nodoSQI.setGestorSesion("http://desarrollo.agrega.indra.es:8080/dri-1/services/SrvSesionesService");
 		nodoSQI.setLenguajeConsulta("VSQL");
 		nodoSQI.setLenguajeRespuesta("LOM-es");
 		nodoSQI.setUrlServicio("http://desarrollo.agrega.indra.es:8080/dri-1/services/SrvSQIService");
 		nodoSQI.setUsuario("larraitz");
 		nodoSQI.setNombreNodo("Nodo LOM-ES");
 		SrvGestionSqiService gestion=this.servicio;
 		Long identificador=gestion.altaNodoSQI(nodoSQI);
 		System.out.println("El identificador que devuelve es "+identificador);
     }
      
      public void testaltaNodoSQI1() {
  		NodoSQIVO nodoSQI=new NodoSQIVO();
  		nodoSQI.setClave("clave1");
  		nodoSQI.setDescripcionNodo("prueba1");
  		nodoSQI.setId(new Long(2));
  		nodoSQI.setIdentificadorSesion("identificadorSesion1");
  		nodoSQI.setLenguajeConsulta("VSQL");
  		nodoSQI.setLenguajeRespuesta("LOM");
  		nodoSQI.setUrlServicio("URL del servicio1");
  		nodoSQI.setUsuario("test1");
  		nodoSQI.setNombreNodo("nombre1");
  		SrvGestionSqiService gestion=this.servicio;
  		Long identificador=gestion.altaNodoSQI(nodoSQI);
  		System.out.println("El identificador que devuelve es "+identificador);
      }
      
      public void testaltaNodoSQI2() {
  		NodoSQIVO nodoSQI=new NodoSQIVO();
  		nodoSQI.setDescripcionNodo("prueba2");
  		nodoSQI.setGestorSesion("gestorSesion2");
  		nodoSQI.setId(new Long(3));
  		nodoSQI.setLenguajeConsulta("VSQL");
  		nodoSQI.setLenguajeRespuesta("LOM");
  		nodoSQI.setUrlServicio("URL del servicio2");
  		nodoSQI.setNombreNodo("nombre2");
  		SrvGestionSqiService gestion=this.servicio;
  		Long identificador=gestion.altaNodoSQI(nodoSQI);
  		System.out.println("El identificador que devuelve es "+identificador);
      }
      
      public void testaltaNodoSQI3() {//Erroneo, tiene clave pero no tiene usuario
  		NodoSQIVO nodoSQI=new NodoSQIVO();
  		nodoSQI.setClave("clave3");
  		nodoSQI.setDescripcionNodo("prueba3");
  		nodoSQI.setGestorSesion("gestorSesion3");
  		nodoSQI.setId(new Long(4));
  		nodoSQI.setIdentificadorSesion("identificadorSesion3");
  		nodoSQI.setLenguajeConsulta("VSQL");
  		nodoSQI.setLenguajeRespuesta("LOM");
  		nodoSQI.setUrlServicio("URL del servicio3");
  		nodoSQI.setNombreNodo("nombre3");
  		SrvGestionSqiService gestion=this.servicio;
  		Long identificador=gestion.altaNodoSQI(nodoSQI);
  		System.out.println("El identificador que devuelve es "+identificador);
      }
      public void testaltaNodoSQI4() {
  		NodoSQIVO nodoSQI=new NodoSQIVO();
  		nodoSQI.setClave("clave4");
  		nodoSQI.setDescripcionNodo("prueba4");
  		nodoSQI.setGestorSesion("gestorSesion4");
  		nodoSQI.setId(new Long(5));
  		nodoSQI.setIdentificadorSesion("identificadorSesion4");
  		nodoSQI.setLenguajeConsulta("VSQL");
  		nodoSQI.setLenguajeRespuesta("LOM");
  		nodoSQI.setUrlServicio("URL del servicio4");
  		nodoSQI.setUsuario("test4");
  		nodoSQI.setNombreNodo("nombre4");
  		SrvGestionSqiService gestion=this.servicio;
  		Long identificador=gestion.altaNodoSQI(nodoSQI);
  		System.out.println("El identificador que devuelve es "+identificador);
      }
      public void testaltaNodoSQI5() {
  		NodoSQIVO nodoSQI=new NodoSQIVO();
  		nodoSQI.setClave("clave5");
  		nodoSQI.setDescripcionNodo("prueba5");
  		nodoSQI.setGestorSesion("gestorSesion5");
  		nodoSQI.setId(new Long(100));
  		nodoSQI.setIdentificadorSesion("identificadorSesion5");
  		nodoSQI.setLenguajeConsulta("VSQL");
  		nodoSQI.setLenguajeRespuesta("LOM");
  		nodoSQI.setUrlServicio("URL del servicio5");
  		nodoSQI.setUsuario("test5");
  		nodoSQI.setNombreNodo("nombre5");
  		SrvGestionSqiService gestion=this.servicio;
  		Long identificador=gestion.altaNodoSQI(nodoSQI);
  		System.out.println("El identificador que devuelve es "+identificador);
      }
      public void testaltaNodoSQI6() {
  		NodoSQIVO nodoSQI=new NodoSQIVO();
  		nodoSQI.setClave("clave6");
  		nodoSQI.setDescripcionNodo("prueba6");
  		nodoSQI.setGestorSesion("gestorSesion6");
  		nodoSQI.setId(new Long(7));
  		nodoSQI.setIdentificadorSesion("identificadorSesion7");
  		nodoSQI.setLenguajeConsulta("VSQL");
  		nodoSQI.setLenguajeRespuesta("LOM");
  		nodoSQI.setUrlServicio("URL del servicio7");
  		nodoSQI.setUsuario("test7");
  		nodoSQI.setNombreNodo("nombre7 añadido después");
  		SrvGestionSqiService gestion=this.servicio;
  		Long identificador=gestion.altaNodoSQI(nodoSQI);
  		System.out.println("El identificador que devuelve es "+identificador);
      }
      public void testaltaNodoSQI7() {
  		NodoSQIVO nodoSQI=new NodoSQIVO();
  		nodoSQI.setClave("clave7");
  		nodoSQI.setDescripcionNodo("prueba7");
  		nodoSQI.setGestorSesion("gestorSesion7");
  		nodoSQI.setId(new Long(2));
  		nodoSQI.setIdentificadorSesion("identificadorSesion7");
  		nodoSQI.setLenguajeConsulta("VSQL");
  		nodoSQI.setLenguajeRespuesta("LOM");
  		nodoSQI.setUrlServicio("URL del servicio7");
  		nodoSQI.setUsuario("test7");
  		nodoSQI.setNombreNodo("nombre7");
  		SrvGestionSqiService gestion=this.servicio;
  		Long identificador=gestion.altaNodoSQI(nodoSQI);
  		System.out.println("El identificador que devuelve es "+identificador);
      }
      public void testaltaNodoSQI8() {//Erroneo, no es un lenguaje válido
  		NodoSQIVO nodoSQI=new NodoSQIVO();
  		nodoSQI.setClave("clave");
  		nodoSQI.setDescripcionNodo("prueba");
  		nodoSQI.setGestorSesion("gestorSesion");
  		nodoSQI.setId(new Long(1));
  		nodoSQI.setIdentificadorSesion("identificadorSesion");
  		nodoSQI.setLenguajeConsulta("VSQLM");
  		nodoSQI.setLenguajeRespuesta("LOM");
  		nodoSQI.setUrlServicio("URL del servicio");
  		nodoSQI.setUsuario("test");
  		nodoSQI.setNombreNodo("nombre");
  		SrvGestionSqiService gestion=this.servicio;
  		Long identificador=gestion.altaNodoSQI(nodoSQI);
  		System.out.println("El identificador que devuelve es "+identificador);
      }
      public void testaltaNodoSQI9() {//El identificador lo inserta directamente, no se lo tenemos que meter
   		NodoSQIVO nodoSQI=new NodoSQIVO();
   		nodoSQI.setClave("clave");
   		nodoSQI.setDescripcionNodo("prueba");
   		nodoSQI.setGestorSesion("gestorSesion");
   		nodoSQI.setIdentificadorSesion("identificadorSesion");
   		nodoSQI.setLenguajeConsulta("VSQL");
   		nodoSQI.setLenguajeRespuesta("LOM");
   		nodoSQI.setUrlServicio("URL del servicio");
   		nodoSQI.setUsuario("test");
   		nodoSQI.setNombreNodo("nombre");
   		SrvGestionSqiService gestion=this.servicio;
   		Long identificador=gestion.altaNodoSQI(nodoSQI);
   		System.out.println("El identificador que devuelve es "+identificador);
       }

    /**
     *   TEST bajaNodosSQI
     *   TODO: Implementar el test para el metodo bajaNodosSQI del servicio SrvGestionSqiService.
     * 	 En el caso de tener que el metodo bajaNodosSQI acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvGestionSqiServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
      public void testbajaNodosSQI() {
  		Long[] ids=new Long[1];
  		ids[0]=new Long(12);
//  		ids[1]=new Long(7);
  		SrvGestionSqiService gestion=this.servicio;
    		gestion.bajaNodosSQI(ids);
    		NodoDescripcionSQIVO[] nodos = gestion.listarNodosSQI();
    		for(int i=0;i<nodos.length;i++){
    			System.out.println("Los nodos devueltos son:"+nodos[i].getId());
    		}

      }
       
       public void testbajaNodosSQI1() {
   		Long[] ids=new Long[2];
   		ids[0]=new Long(2);
   		SrvGestionSqiService gestion=this.servicio;
     		gestion.bajaNodosSQI(ids);
     		NodoDescripcionSQIVO[] nodos = gestion.listarNodosSQI();
     		for(int i=0;i<nodos.length;i++){
     			System.out.println("Los nodos devueltos son:"+nodos[i].getId());
     		}

       }
       
       public void testbajaNodosSQI2() {
      		Long[] ids=new Long[4];
      		ids[0]=new Long(5);
      		ids[1]=new Long(6);
      		ids[2]=new Long(9);
      		ids[3]=new Long(8);
      		SrvGestionSqiService gestion=this.servicio;
        		gestion.bajaNodosSQI(ids);
        		NodoDescripcionSQIVO[] nodos = gestion.listarNodosSQI();
        		for(int i=0;i<nodos.length;i++){
        			System.out.println("Los nodos devueltos son:"+nodos[i].getId());
        		}

          }


    /**
     *   TEST consultaNodosSQI
     *   TODO: Implementar el test para el metodo consultaNodosSQI del servicio SrvGestionSqiService.
     * 	 En el caso de tener que el metodo consultaNodosSQI acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvGestionSqiServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
       public void testconsultaNodosSQI() {//Aunque no existen los nodos no da error
      	 Long[] ids=new Long[2];
   		ids[0]=new Long(2);
   		ids[1]=new Long(7);
   		SrvGestionSqiService gestion=this.servicio;
     		NodoSQIVO[] nodos = gestion.consultaNodosSQI(ids);
     		for(int i=0;i<nodos.length;i++){
    			System.out.println("Los nodos devueltos son:"+nodos[i].getDescripcionNodo());
    		}

      }
       public void testconsultaNodosSQI1() {//Aunque no existen los nodos no da error
      	 Long[] ids=new Long[2];
   		ids[0]=new Long(1);
   		ids[1]=new Long(3);
   		SrvGestionSqiService gestion=this.servicio;
     		NodoSQIVO[] nodos = gestion.consultaNodosSQI(ids);
     		for(int i=0;i<nodos.length;i++){
    			System.out.println("Los nodos devueltos son:"+nodos[i].getDescripcionNodo());
    		}

      }
    /**
     *   TEST modificarNodoSQI
     *   TODO: Implementar el test para el metodo modificarNodoSQI del servicio SrvGestionSqiService.
     * 	 En el caso de tener que el metodo modificarNodoSQI acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvGestionSqiServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
       public void testmodificarNodoSQI() {
      	 NodoSQIVO nodoSQI=new NodoSQIVO();
     		nodoSQI.setClave("claveModificado");
     		nodoSQI.setDescripcionNodo("pruebaModificado");
     		nodoSQI.setGestorSesion("gestorSesionModificado");
     		nodoSQI.setIdentificadorSesion("identificadorSesionModificado");
     		nodoSQI.setLenguajeConsulta("VSQL");
     		nodoSQI.setLenguajeRespuesta("LOM");
     		nodoSQI.setUrlServicio("URL del servicio modificado");
     		nodoSQI.setUsuario("test modificado");
     		nodoSQI.setNombreNodo("nombre modificado");
     		nodoSQI.setId(new Long(6));
     		SrvGestionSqiService gestion=this.servicio;
     		Long identificador=gestion.modificarNodoSQI(nodoSQI);
     		NodoSQIVO[] arrayResultado=gestion.consultaNodosSQI(new Long[]{nodoSQI.getId()});
     		System.out.println("El identificador que devuelve es "+identificador);

      }

    /**
     *   TEST listarNodosSQI
     *   TODO: Implementar el test para el metodo listarNodosSQI del servicio SrvGestionSqiService.
     * 	 En el caso de tener que el metodo listarNodosSQI acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvGestionSqiServiceImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
       public void testlistarNodosSQI() {
      	 SrvGestionSqiService gestion=this.servicio;
      	 	NodoDescripcionSQIVO[] nodos = gestion.listarNodosSQI();
      		for(int i=0;i<nodos.length;i++){
      			System.out.println("Los identficadores de los nodos devueltos son:"+nodos[i].getId()+" con nombre: "+ nodos[i].getDescripcionNodo());
      		}

      }

	
	
	
}
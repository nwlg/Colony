/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.auditoria.negocio.servicios;

import java.util.GregorianCalendar;

/**
 * @see SrvAuditoriaFederadaServicioImpl
 * TODO: To execute test on services that invoke webservices which implement security,
 * you must include the next param to the java virtual machine:
 * -Daxis.ClientConfigFile=client-config.wsdd
 */
public class TestSrvAuditoriaFederadaServicioImpl
    extends SrvAuditoriaFederadaServicioImplBase
{


    /**
     * Constructor
     */
     public TestSrvAuditoriaFederadaServicioImpl(){
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
     * 	 {@link es.indra.servicios.SrvAuditoriaFederadaServicioImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */	
     public void testInicial(){
		String prueba = null;
		this.initAthenticationUser("usuario", "ibuilder"); 
		assertNotNull(prueba);
	}
	
	
    /**
     *   TEST informeNivelAgregacionFederado
     *   TODO: Implementar el test para el metodo informeNivelAgregacionFederado del servicio SrvAuditoriaFederadaServicio.
     * 	 En el caso de tener que el metodo informeNivelAgregacionFederado acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAuditoriaFederadaServicioImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testinformeNivelAgregacionFederado() {
    	 ParametrosInformeFederadoVO parametros = new ParametrosInformeFederadoVO();
    	 parametros.setFechaDesde(new GregorianCalendar());
    	 parametros.setFechaHasta(new GregorianCalendar());
    	 parametros.setIdioma("es");
    	 parametros.setIdUsuario("administrador");
    	 parametros.setTipoInforme("nivelAgregacion");
    	 System.out.println("Despues de crear los parametros");
    	 this.servicio.informeNivelAgregacionFederado(parametros);
    	 System.out.println("Despues de llamar al servicio");
		//String prueba = null; 
		//assertNotNull(prueba);

    }

    /**
     *   TEST nivelAgregacionFederadoLocal
     *   TODO: Implementar el test para el metodo nivelAgregacionFederadoLocal del servicio SrvAuditoriaFederadaServicio.
     * 	 En el caso de tener que el metodo nivelAgregacionFederadoLocal acceda a un webservice
     * 	 el cuál implementa seguridad (se necesita la autenticación de usuario),
     * 	 antes de invocarlo en el test, se debe establecer un usuario con
     * 	 derechos de acceso utilizando el método 
     * 	 {@link es.indra.servicios.SrvAuditoriaFederadaServicioImplBase#initAthenticationUser(String, String) 
     * 	 initAuthenticationUser(authenticationUser, authenticationPassword)}
     */
     public void testnivelAgregacionFederadoLocal() {
		String prueba = null; 
		assertNotNull(prueba);

    }
     
	
	
	
}
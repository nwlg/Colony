/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point

package es.pode.soporte.auditoria.registrar;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/** 
 * Clase que se encarga de la intercepci�n de los servicios web, m�todos y argumentos que nos interesa registrar
 * 
 * Inicialmente s�lo se trata el escenario clase servidor web compuesta de uno o varios m�todos 
 * y estos m�todos est�n compuestos por uno o varios Objetos VO (argumentos) 
 * y estos Objetos tienen uno o varios atributos que son los que se extrae su valor. 
 * Los atributos que registramos deben ser de tipo String.    
 * 
 * @author jsimon
 */

public class ServiceRegistrarInterceptor implements MethodInterceptor 
{
	static Log log = LogFactory.getLog("ServiceRegistrarInterceptor");
	static java.util.Properties pSpringProperties = null;
	static final String AUDITORIA = ServiceRegistrarInterceptor.getPropertyValue("auditoria");
	
	/** 
	 * M�todo de invocaci�n que se ejecuta cuando se llama a un servicio web 
	 * 
	 * @param invocation Informaci�n de la clase que se est� ejecutando y que se va a interceptar
	 * @return returnObject Objeto Devuelta: Joinpoint
	 */
    public Object invoke(MethodInvocation invocation) throws Throwable
    {
    	if (RegistroCtes.AUDITORIA_NO.equals(AUDITORIA)) {
    		log.info("!!!!! Opci�n sin auditor�a. No se capturan datos");
    		return invocation.proceed();
    	}
    
    	try {
    		/* Se interceptan los datos */
    		DatosVO datosInterceptados = Interceptor.getDatosInterceptados(invocation);
    	
	    	if (datosInterceptados != null) {
	    		HashMap valores = datosInterceptados.getValores();  
	    	
	    		if (valores != null && valores.size() > 0)     			 
	    			Registrar.operacion(datosInterceptados);
	    		else { 
	    			if (log.isDebugEnabled())
	    				log.debug("No se han interceptados valores");    		
	    		}
	    	}
    	}
	    catch (Throwable t) {
	    	log.error("Error: No se han interceptados los valores"); 
	    	log.error(t);
	    }
    	
    	Object returnObject = invocation.proceed();   
            	
        return returnObject;         
    }
  
	/** 
	 * Recuperado de un valor de un fichero de properties 
	 *   
	 * @param sKey El nombre a buscar en el fichero 
	 * @return sReturn El valor buscado
	 */
	private static String getPropertyValue(String sKey) 
	{
		String sReturn = null;
		try 
		{
			if (pSpringProperties == null)
			{
				InputStream fIsSpringProperties = ServiceRegistrarInterceptor.class.getResourceAsStream(RegistroCtes.FILE_NAME_PROPERTIES);
				pSpringProperties = new java.util.Properties();
				pSpringProperties.load(fIsSpringProperties);
			}
			sReturn = pSpringProperties.getProperty(sKey); 
		} 
		catch (IOException e) {
			log.error(e);
		}
		
		return sReturn;
	}
}
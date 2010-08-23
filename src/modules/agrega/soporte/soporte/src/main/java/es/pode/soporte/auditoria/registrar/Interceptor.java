/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point

package es.pode.soporte.auditoria.registrar;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/** 
 * Clase que se encarga de la intercepción de los servicios web, métodos y argumentos que nos interesa registrar
 * 
 * Se captura las llamadas a servicios web indicadas en un fichero auditoria.xml
 * Donde se indica el servicio web a capturar, los métodos que se capturan y los 
 * argumentos (pueden ser objetos VO) que se quieren interceptar.   
 * Los atributos que se registran en última instancia deben ser de tipo String.    
 * 
 * @author jsimon
 */

public class Interceptor 
{
	public static Log log = LogFactory.getLog("Interceptor");
	static Document doc = null;
	static List serviciosWebXML = null;
		
	/** 
	 * Método que se encarga de ver si hay que interceptar y de la intercepción 
	 * @param invocation Objeto sobre el que se realiza la reflexión para capturar los datos 
	 * @return datosInterceptados Objeto con los datos interceptados y con el módulo destino
	 * */ 
	public static DatosVO getDatosInterceptados(MethodInvocation invocation)
	{
		HashMap valores = null;		
		String metodoServicioWeb = null;
		String servicioWebClass = null;
		Element elementMetodoServicioWeb = null;
		Element elementServicioWeb = null;
		String moduloDestino = null;
				
		try {			
		  	if (doc == null)
	    		parseo();
		    	
	    	/* Se recupera el nombre del servicio web llamado */
	    	servicioWebClass = invocation.getMethod().getDeclaringClass().getName();	    	
	    	log.debug("Servicio web en ejecución: " + servicioWebClass);
	
	    	/* Comprobamos a partir del fichero XML, auditoria.xml (webService)  si hay que interceptar el servicio web */
	    	elementServicioWeb = esInterceptadoServicioWeb(servicioWebClass, serviciosWebXML);	    	
	    	log("elementServicioWeb " + elementServicioWeb);    	
	    	
	    	if (elementServicioWeb == null) 
	    		return null;
	        
	    	/* Se recupera el método del servicio web llamado */
	        metodoServicioWeb = invocation.getMethod().getName();
	        log("Método del servicio web en ejecución: " + metodoServicioWeb);       
	        
	        /* Se comprueba a partir del fichero XML, auditoria.xml (metodoItem) si hay que interceptar el método */
	        elementMetodoServicioWeb = esInterceptadoMetodo(metodoServicioWeb, elementServicioWeb);	                
	        if (elementMetodoServicioWeb == null)
	        	return null;	
	    	
	        /* Se recorren los argumentos del método del servicio web invocado para ver si hay que interceptarlos */
	        Object argumentos[] = invocation.getArguments();
        			
	        if (argumentos != null) {	        	
	        	valores = new HashMap();
	        	
	        	/* Se recupera el módulo de destino de auditoria.xml (metodoItem -> destino) donde se deben almacenar los valores interceptados */
	        	moduloDestino = elementMetodoServicioWeb.getAttribute(RegistroCtes.ATTRIBUTE_DESTINO).getValue();
	        	
				/* Recorremos los argumento que tiene el método del servicio web en ejecución */
				for(int i = 0; i < argumentos.length; i++) {        
					/* Se comprueba si hay que interceptar el argumento. auditoria.xml (argumentoItem -> name) */
					log("Argumento (Clase) del metodo del servicio web en ejecución: " + argumentos[i].getClass().getName() + " posición del argumento: " + i);
					
					Element argumentoServicioWeb = esInterceptadoArgumento(argumentos[i].getClass().getName(), 
							elementMetodoServicioWeb);
					
					if (argumentoServicioWeb != null) {																	
						/* Se contemplan dos posibilidades *
						 * 1- El argumento es de tipo String, Long o Date se recupera el valor por la posición del argumento que se indica en el fichero XML
						 * 2- El argumento es un objeto VO (Value Object) se recupera por el tipo 
						 */																			    	       					    
						if (java.lang.String.class.isAssignableFrom(argumentos[i].getClass())
							|| java.lang.Long.class.isAssignableFrom(argumentos[i].getClass()) 
							|| java.util.Date.class.isAssignableFrom(argumentos[i].getClass()))
						{
							log("Argumento del tipo java.lang.String, java.lang.Long o java.util.Date");

							/* Se recupera la posición del atributo a partir del atributo del fichero XML: auditoria.xml argumentoItem -> atributo)*/ 
							String atributo = argumentoServicioWeb.getAttribute(RegistroCtes.ATTRIBUTE_ATRIBUTO).getValue();

							/* Se recupera la descripción del parámetro que nos interesa del argumento que se intercepta. A partir del auditoria.xml: argumentoItem -> descripcionParametro*/ 
							String descripcionParametro = argumentoServicioWeb.getAttribute(RegistroCtes.ATTRIBUTE_DESC_PARAMETRO).getValue();
							
							if (Integer.parseInt(atributo) -1 == i) {
								valores.put(descripcionParametro, argumentos[i].toString());							
								log("Valor interceptado: " + argumentos[i].toString());
							}
						}
						else {
							log("Argumento del tipo Value Object");

							/* Se recupera el array de atributos que nos interesa del argumento que se intercepta. Auditoria.xml: argumentoItem -> atributo */ 
							String[] atributos = getAtributos(argumentoServicioWeb.getAttribute(RegistroCtes.ATTRIBUTE_ATRIBUTO).getValue());
							
							/* Se recuperan los valores de esos atributos que se interceptan */
							valores = getValores(argumentos[i], atributos); 						
						}						
					}			
				}					
	        }		       	        
		}
		catch(Exception e)
		{
			/* Si se produce un error en el registro lo indicamos en el log pero continuamos con la ejecución */ 
			log.error("No se ha podido registrar la tarea. Servicio: " 
					+ servicioWebClass + " método: " + metodoServicioWeb + " " + e);
			return null;
		}
		
		/* Se rellena el VO con los valores interceptados */
		DatosVO datosInterceptados = new DatosVO();
		datosInterceptados.setValores(valores);
		datosInterceptados.setModuloDestino(moduloDestino);
		
		return datosInterceptados;			
	}
	
	/** 
	 * Método que devuelve los valores capturados en un HashMap. No captura el modulo destino 
	 * @param invocation Objeto sobre el que se realiza la reflexión para capturar los datos 
	 * @return datosInterceptados Objeto con los datos interceptados y con el módulo destino
	 * */ 
	public static HashMap getValoresInterceptados(MethodInvocation invocation)
	{	
		HashMap valoresInterceptados = null;
		DatosVO datosInterceptados = getDatosInterceptados(invocation);
				
		if (datosInterceptados != null) 
			valoresInterceptados = datosInterceptados.getValores();			
		
		return valoresInterceptados;
	
	}
	
    /* Si es necesario interceptar los datos que se retornan
     * 
    // Recuperar los argumentos de vuelta 
    String valorRetorno = null;
    String argumentoVueltaXML = elementMetodoServicioWeb.getAttributeValue(RegistroCtes.ATTRIBUTE_ARGUMENTO_VUELTA); 
    	
    if(returnObject != null && argumentoVueltaXML != null && !argumentoVueltaXML.equals(""))
    {        	
    	valorRetorno = BeanDescripcion.describe(returnObject, 
    			elementMetodoServicioWeb.getAttribute(RegistroCtes.ATTRIBUTE_ARTRIBUTO_VUELTA).getValue());        	
    	log("Valor interceptado de retorno: " + valorRetorno);
    }
    else
        log.debug("El servicio web " + servicioWebClass + " método " + metodoServicioWeb + " no retorna nada");
    
    */
	
	
	/** 
	 * Parseo del fichero xml. Se carga un objeto Iterator con los servicios web que hay que interceptar
	 */
    public static void parseo() throws JDOMException, IOException
	{
		try
		{
		   SAXBuilder builder = new SAXBuilder();
		   doc = builder.build(ServiceRegistrarInterceptor.class.getResourceAsStream(RegistroCtes.FILE_NAME_XML));
		   serviciosWebXML = doc.getRootElement().getChildren(RegistroCtes.ITEM_WEBSERVICE);
		   log("Parseo servicios Web del fichero " + serviciosWebXML);			
		}
		catch (Exception ex)
		{
			log.error("ERROR al intentar parsear el fichero [" + RegistroCtes.FILE_NAME_XML + "]");
			log.error(ex);
		}
	}
    	    	
	/** 
	 * Función para partir dividir la cadena de los atributos en un array de String de atributos 
	 *   
	 * @param sAtributos Cadena a dividir 
	 * @return arrayAtributos Array de atributos
	 */
	public static String[] getAtributos(String sAtributos) 
	{
		String[] arrayAtributos = null;
		
		if (sAtributos != null && sAtributos.indexOf(RegistroCtes.SEPARATOR) != -1)
			arrayAtributos = sAtributos.split(RegistroCtes.SEPARATOR);			
		else if (sAtributos != null && !sAtributos.equals(""))
		{
			arrayAtributos = new String[1];
			arrayAtributos[0] = sAtributos;
		}
		
		log("Atributos a recuperar su valor: " + array2Traza(arrayAtributos));
		
		return arrayAtributos;		
	}
	
	/** 
	 * Se recuperan los valores de los atributos de un objeto 
	 *
	 * @param param El objeto que contiene los valores
	 * @param atributos Los atributos de los que hay que recuperar los valores 
	 * @param descripcion Descripción de los parámetros 
	 * @return valores Array de valores correspondientes a los atributos
	 */
	public static HashMap getValores(Object param, String[] atributos, String[] descripcion)
	{
		HashMap valores = new HashMap(); 
		int contador = 0;
		
		/* Recuperamos los valores de los atributos seleccionados */
		for (int j = 0; j < atributos.length; j++) {	
			log("Atributo: " + atributos[j]);
			
			/* Recuperación del atributo del argumento */
			String valor = BeanDescripcion.describe(param, atributos[j]);
			
			if (valor != null) {						
				valores.put(descripcion[j], valor);
				contador++;
				log("Valor interceptado: " + valor);
			}											
		}
		
		return valores;	
	}
		
	
	/** 
	 * Se recuperan los valores de los atributos de un objeto.
	 * Si son VOs utilizo la el atributo del argumentoItem del auditoria.xml como descripcionParametro  
	 *
	 * @param param El objeto que contiene los valores
	 * @param atributos Los atributos de los que hay que recuperar los valores 
	 * @return valores Array de valores correspondientes a los atributos
	 */
	public static HashMap getValores(Object param, String[] atributos)
	{
		return getValores(param, atributos, atributos);		
	}
	
	/** 
	 * Comprobación de si hay que interceptar la clase servicio web a partir del fichero xml de configuración 
	 *   
	 * @param servicioClass Nombre de la clase 
	 * @param serviciosWebIterator Lista de servicios web (Iterator) con los que hay que comparar
	 * @return el Se devuelve el elemento que coincide con la clase
	 */
	public static Element esInterceptadoServicioWeb(String servicioClass, List serviciosWeb) {
		
		Iterator serviciosWebIterator = serviciosWeb.iterator();
		
		if (serviciosWebIterator != null) {
			while (serviciosWebIterator.hasNext()) {	
				Element el = (Element)serviciosWebIterator.next();
			
				if (log.isDebugEnabled())
					log.debug("Servicio web (XML) a comparar: " + el.getAttributeValue(RegistroCtes.ATTRIBUTE_NAME));
			
				if (el.getAttributeValue(RegistroCtes.ATTRIBUTE_NAME).equals(servicioClass)) {
					if (log.isDebugEnabled())
						log.debug("Servicio web que se intercepta: " + servicioClass);
				
					return el;
				}
			}
		}
		return null;
	}
	
	/** 
	 * Comprobación de si hay que interceptar el método servicio web a partir del fichero xml de configuración 
	 *   
	 * @param metodoServicioWeb Nombre del método 
	 * @param elServicioWeb El elemento donde buscamos si tiene el método a interceptar
	 * @return metodoElement El elemento del métododel servicio que coincide con el método pedido
	 */
	public static Element esInterceptadoMetodo(String metodoServicioWeb, Element elServicioWeb) {
		List metodosElement = elServicioWeb.getChildren();
		
		if (log.isDebugEnabled())
			log.debug("metodosElement XML: " + metodosElement);
		
		Iterator itMetodos = checkList(metodosElement);
		
		if (itMetodos == null)
			return null;
		
		while (itMetodos.hasNext()) {
			Element el = (Element)itMetodos.next();
			
			if (log.isDebugEnabled())
				log.debug("Método del servicio web en el XML a comparar: " + el.getAttribute(RegistroCtes.ATTRIBUTE_NAME).getValue());
			
			if (el.getAttribute(RegistroCtes.ATTRIBUTE_NAME).getValue().equals(metodoServicioWeb)) {	
				if (log.isDebugEnabled())
					log.debug("Método del servicio web que se intercepta: " + metodoServicioWeb);
				
				return el;
			}
		}
		
		return null;
	}	
	
	/** 
	 * Comprobación de si hay que interceptar el argumento del método de servicio web a partir del fichero xml de configuración 
	 *   
	 * @param argumentoMetodoServicioWeb Nombre del argumento a buscar 
	 * @param elMetodoServicioWeb El elemento del método del servicio donde se busca el argumento
	 * @return argumentoElement El elemento argumento
	 */
	public static Element esInterceptadoArgumento(String argumentoMetodoServicioWeb, Element elMetodoServicioWeb) {
		Element argumentoElement = elMetodoServicioWeb.getChild(RegistroCtes.ITEM_ARGUMENTO);
		
		if (log.isDebugEnabled())
			log.debug("Argumento del método del servicio web (XML) a comparar: " + argumentoElement.getAttribute(RegistroCtes.ATTRIBUTE_NAME).getValue());
		
		if (argumentoElement.getAttribute(RegistroCtes.ATTRIBUTE_NAME).getValue().equals(argumentoMetodoServicioWeb)) {
			if (log.isDebugEnabled())
				log.debug("Argumento del método del servicio web que se intercepta: " + argumentoMetodoServicioWeb);
			
			return argumentoElement;
		}
		else
			return null;
	}
	
	/** 
	 * Se convierte una lista en un Iterador 
	 *   
	 * @param elementList Lista a transformar 
	 * @return it Se retorna el iterador de la lista
	 */
	public static Iterator checkList(List elementList) {
		Iterator it = null;
		if (elementList != null)
			it = elementList.iterator();
	
		return it;
	 }
	
	public static String array2Traza (Object[] array) {
		StringBuffer sb = new StringBuffer();
		if (array!= null)
		{
			for (int i = 0; i < array.length; i++)
			{
				sb.append("La posicion [");
				sb.append(i);
				//sb.append("] del array de tipo [");
				//sb.append(array.getClass().getName());
				sb.append("] es [");
				sb.append(array[i]);
				sb.append("]");
			}
		}
		return sb.toString();
	}
	
	private static void log (Object obj) {
		if (log.isDebugEnabled())
			log.debug(obj);
	}
}	
	

/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point

package es.pode.soporte.auditoria.registrar;

import java.beans.PropertyDescriptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanDescripcion 
{
	public static Log log = LogFactory.getLog("BeanDescripcion");
	
	/** 
	 * Método para recuperar información de un objeto a través de reflexión 
	 *   
	 * @param objeto Objeto al cual se le realiza la reflexión 
	 * @param atributo Valor que se recupera del objeto
	 * @return valor Se devuelve el valor del atributo buscado
	 */
    public static String describe (Object objeto, String atributo) {
    	
        if(objeto == null)
            return null;

    	Object valor = null;
    	        
        Class clase = objeto.getClass();
        if(clase.isArray() || java.util.Collection.class.isAssignableFrom(clase)) 
            log.warn("El atributo es un array y debería ser un String");
        else {
        	log("Reflexión del objeto: " + objeto);
        	
            BeanWrapper wrapper = new BeanWrapperImpl(objeto);
            PropertyDescriptor descriptors[] = wrapper.getPropertyDescriptors();
                        
            for(int i = 0; i < descriptors.length; i++) {
                PropertyDescriptor pd = descriptors[i];
                          
                if(pd.getReadMethod() != null && pd.getWriteMethod() != null) {
                    String name = pd.getName();
                
                	/* Capturamos el valor del atributo que nos interesa */
                    if (name.equals(atributo)) {
                    	log("Nombre atributo: " + name);
                    	valor = wrapper.getPropertyValue(name);
                    	
                    	/* Si el valor es nulo registramos un "" */
                    	if(valor == null) {
                    		log("El valor del atributo interceptado es nulo");
                    		return null;
                    	}
                    	else 
                    		return valor.toString();
                    }                   	
                }
            }
        }
        
        return null;
    }
    
	private static void log (Object obj) {
		if (log.isDebugEnabled())
			log.debug(obj);
	}
}

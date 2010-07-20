/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.uuid;

import org.safehaus.uuid.UUID;
import org.safehaus.uuid.UUIDGenerator;

/**
 * Generador de identificadores únicos para los elementos que forman parte de ODE.
 * 
 * @author INDRA
 */
public class PodeUUIDGenerator {

	/**
	 * Genera un identificador único para el String que se le pasa.
	 * 
	 * @param id
	 * @param prefijo
	 * @return
	 */
	private static String getUUID(String id, String prefijo){
		String result = null;
		
		if(id != null)
		{
			long time = System.currentTimeMillis();
			id += Long.toString(time);
	
			UUID uuid = UUIDGenerator.getInstance().generateNameBasedUUID( new UUID(UUID.NAMESPACE_DNS), id);
	
			if (uuid != null)
			{
				result = uuid.toString();
				if(prefijo != null)
					result = prefijo + result;
			}
		}
		return result;
	}
	
	/**
	 * Devuelve un identificador único.
	 * 
	 * @param nombre Nombre a partir del cual se genera el identificador único.
	 * @return
	 */
	public static String getUUID(String nombre){
		if(nombre != null)
		{
			return getUUID(nombre, "");
		}
		return null;
	}

	/**
	 * Devuelve un identificador único para un objeto de tipo ODE.
	 * 
	 * @param nombre Nombre a partir del cual se genera el identificador único.
	 * @return
	 */
	public static String getOdeUUID(String nombre){
		if(nombre != null)
		{
			return getUUID(nombre, UUIDConstantes.ODE);
		}
		return null;
	}

	/**
	 * Devuelve un identificador único para un objeto de tipo RECURSO.
	 * 
	 * @param nombre Nombre a partir del cual se genera el identificador único.
	 * @return
	 */
	public static String getRecursoUUID(String nombre){
		if(nombre != null)
		{
			return getUUID(nombre, UUIDConstantes.RESURSO);
		}
		return null;
	}

	/**
	 * Devuelve un identificador único para un objeto de tipo ITEM.
	 * 
	 * @param nombre Nombre a partir del cual se genera el identificador único.
	 * @return
	 */
	public static String getItemUUID(String nombre){
		if(nombre != null)
		{
			return getUUID(nombre, UUIDConstantes.ITEM);
		}
		return null;
	}

	/**
	 * Devuelve un identificador único para un objeto de tipo ORGANIZACION.
	 * 
	 * @param nombre Nombre a partir del cual se genera el identificador único.
	 * @return
	 */
	public static String getOrganizacionUUID(String nombre){
		if(nombre != null)
		{
			return getUUID(nombre, UUIDConstantes.ORGANIZACION);
		}
		return null;
	}

	/**
	 * Devuelve un identificador único para un objeto de tipo SUBMANIFIESTO.
	 * 
	 * @param nombre Nombre a partir del cual se genera el identificador único.
	 * @return
	 */
	public static String getSubmanifiestoUUID(String nombre){
		if(nombre != null)
		{
			return getUUID(nombre, UUIDConstantes.SUBMANIFIESTO);
		}
		return null;
	}

}

/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.empaquetador.negocio.servicio;

import java.util.HashMap;

import org.apache.log4j.Logger;

import es.pode.parseadorXML.castor.Manifest;

//import org.apache.log4j.Logger;
//
//import es.pode.parseadorXML.castor.Manifest;

/**
 * @author dgonzalezd
 *
 */
public class CacheEmpaquetacion {
	
	
	private static Logger logger = Logger.getLogger(CacheEmpaquetacion.class);
	private HashMap<String, Object> cacheEmpaquetacion = new HashMap<String, Object>(10);
	
//	private static Logger logger = Logger.getLogger(CacheEmpaquetacion.class);

	/**
	 * Recupera objeto de la cach�
	 * @param identificador String identificador del objeto a recuperar
	 * @return Objeto recuperado, null si no se encontr�
	 */
	public Object get(String identificador) {
		return cacheEmpaquetacion.get(identificador);
	}
	
	
	/**
	 * Elimina objeto de la cach�
	 * @param identificador String identificador del objeto a eliminar
	 * @return Objeto eliminado, null si no se encontr�
	 */
	public Object remove(String identificador) {
		return cacheEmpaquetacion.remove(identificador);
	}
	
	/**
	 * A�adir objeto a la cach�
	 * @param key String identificador del objeto a a�adir
	 * @param value Objeto a a�adir
	 * @return Objeto previamente asociado al identificador, null si no hab�a
	 */
	public Object put(String key, Object value) {
		return cacheEmpaquetacion.put(key, value);
	}
	
/* Al final no le veo mucho sentido tenerlo aqu�, pues me parece no muy ligado
 * a esta clase. En los m�todos de SrvGestorManifestServiceImpl que se llama a
 * m�todos de esta clase se llama a este m�todo, pero no en todos los m�todos 
 * que lo llaman se usan m�todos de esta clase. 
 */
	public Manifest comprobarManifest(String identificador)
			throws java.lang.Exception {
		Manifest manifest = null;
		Object obj = get(identificador);
		
		if (obj instanceof es.pode.parseadorXML.castor.Manifest) {
			logger.debug("El objeto " + obj + " es de tipo manifest");
			manifest = (Manifest) obj;
		} else if (obj != null) {
			logger.error("El objeto " + obj + " no es de tipo manifest");
			throw new AlmacenamientoException("El objeto no es de tipo manifest");
		}
		return manifest;

	}
}

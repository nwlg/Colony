/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.publicacion.negocio.soporte;

import net.sf.dozer.util.mapping.converters.CustomConverter;

import org.apache.log4j.Logger;

import es.pode.publicacion.i18n.EstadosI18nManager;
import es.pode.publicacion.negocio.dominio.Estado;
import es.pode.publicacion.negocio.dominio.EstadoImpl;
import es.pode.publicacion.negocio.servicios.EstadoVO;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

public class EstadoVOConverter implements CustomConverter {

	private static Logger logger = Logger.getLogger(EstadoVOConverter.class);
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.dozer.util.mapping.converters.CustomConverter#convert(java.lang.Object,
	 *      java.lang.Object, java.lang.Class, java.lang.Class)
	 */
	public Object convert(Object destination, Object source, Class destClass,
			Class srcClass) {
//		Si no hay nada que hacer, no hago nada
		if (source == null) {
			return null;
		}
    	if(source instanceof Estado)
    	{
    		Estado estadoActual = (Estado)source;
    		if (estadoActual.getId()==null || estadoActual.getId().equals(new Long(0)))
    		{
    			logger.debug("mapeando estadoVO nulo, volvemos");
    			return new EstadoVO();
    		}
    		EstadoVO estadoDestino = (EstadoVO)destination;
    		if (destination == null)
    			estadoDestino = new EstadoVO();
//  		Introducimos la traduccion del estado al idioma del usuario
    		String idioma = null;
    		try {
    			idioma = LdapUserDetailsUtils.getIdioma(); // obtenemos el idioma de la consulta que es el idioma de configuruacion del usuario.
    		} catch (Exception e1) {
    			// ha cascado la llamada al LDAP, utilizamos el idioma por defecto de la plataforma para saber el idioma al que traducir.
    			try {
    				idioma = I18n.getInstance().obtenerIdiomaDefectoPlataforma();
    			} catch (Exception e) {
    				Logger.getLogger(this.getClass()).error("ERROR: Error mapeando ["+source.getClass()+"]->["+destination.getClass()+"] intentando traducir estado["+estadoActual.getNombre()+"]. Error obteniendo idioma por defecto de la plataforma. No sabemos en que idioma trabajar.");
    				estadoDestino.setClave(estadoActual.getNombre()); // al menos lo dejamos igual
    				estadoDestino.setNombre(estadoActual.getNombre()); // completamos el tema
    				return estadoDestino;
    			}
    		}
    		try {
    			estadoDestino.setClave(estadoActual.getNombre());
    			estadoDestino.setNombre((String)EstadosI18nManager.getInstance().getDescription(estadoActual.getNombre(), idioma));
    		} catch (Exception e) {
    			Logger.getLogger(this.getClass()).error("ERROR: Error mapeando ["+source.getClass()+"]->["+destination.getClass()+"] intentando traducir estado["+estadoActual.getNombre()+"]. Excepcion obteniendo traduccion del estado["+((estadoActual!=null)?estadoActual.getNombre():"null")+"] al idioma["+idioma+"]. Devolvemos el mismo texto.");
    			estadoDestino.setClave(estadoActual.getNombre()); // al menos lo dejamos igual
    			estadoDestino.setNombre(estadoActual.getNombre()); // completamos el tema
    		}
    		return estadoDestino;
    	}
//    	Nunca deberia mapear VO's de estado a entity, puesto que en la tabla de estados no se inserta informacion
    	else
    	{
    		EstadoVO estadoActual = (EstadoVO)source;
    		Estado estadoDestino = (Estado)destination;
    		if (destination == null)
    			estadoDestino = new EstadoImpl();
    		estadoDestino.setNombre(estadoActual.getClave());
    		return estadoDestino;
    	}
	}
}

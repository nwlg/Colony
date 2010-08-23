/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.empaquetador.negocio.utilidades;

import java.util.ArrayList;
import java.util.List;

import net.sf.dozer.util.mapping.converters.CustomConverter;

import org.apache.log4j.Logger;

import es.pode.empaquetador.negocio.servicio.LomVO;
import es.pode.parseadorXML.castor.Location;
import es.pode.parseadorXML.castor.Lom;
import es.pode.parseadorXML.lomes.lomesAgrega.LomAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * 
 * Clase para rellenar los atributos lom de los objetos OdeVO, RecursoVO,
 * OrganizacionVO y FileVO. Si no hay un Lom asociado a la clase fuente el
 * atributo lom se fija a null.
 * 
 * @author fjespino
 * 
 */
public class LomVOConverter implements CustomConverter {

	private static Logger logger = Logger.getLogger(LomVOConverter.class);
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.dozer.util.mapping.converters.CustomConverter#convert(java.lang.Object,
	 *      java.lang.Object, java.lang.Class, java.lang.Class)
	 */
	public Object convert(Object destination, Object source, Class destClass,
			Class srcClass) {
		LomVO resultado = null;
				
		if (source instanceof Object[]) {
			// El objeto fuente tiene un array de objetos en su metadata.grpAny.anyObject
			// Compruebo si uno es un Lom
			Object[] array = (Object[])source;
			for(int i=0;i<array.length && resultado == null;i++) {
				if(array[i] instanceof Lom) {
					LomAgrega la = new LomAgrega((Lom)array[i]);
					
					resultado = new LomVO();
					try {
						resultado.setIdioma(la.getMetaMetadataAgrega().getIdioma());
						if(logger.isDebugEnabled()) logger.debug("Idioma recuperado del Lom-ES: " + resultado.getIdioma());
					} catch (Exception e) {
						logger.error("Error al recuperar idioma del Lom");
					}
					try {
						// Cambio: recupero idioma de usuario. Si no hay titulo para ese idioma, recupero el primer titulo que encuentre.
						String idiomaUsuario = LdapUserDetailsUtils.getIdioma();
						String titulo = la.getGeneralAgrega().getTitulo(idiomaUsuario);
						if(titulo == null) {
							if(logger.isDebugEnabled()) logger.debug("No hay titulo en el lom para el idioma del usuario " + idiomaUsuario + " intento recuperar un titulo cualquiera");
							List titulos = la.getGeneralAgrega().getTitulos();
							if(titulos.size()>0) {
							if(logger.isDebugEnabled()) logger.debug("Se han recuperado " + titulos.size() + " titulos. Recupero el primero.");
							titulo = (String)titulos.get(0);
							} else {
								logger.debug("El Lom no tiene ningun titulo");
							}
						}
						resultado.setTitulo(titulo);
						
					} catch (Exception e) {
						logger.error("Error al recuperar titulo del Lom en idioma " + resultado.getIdioma());
					}
					ArrayList descripciones = null;
					try {
						descripciones = la.getGeneralAgrega().getDescripcionesIdioma(resultado.getIdioma());
					} catch (Exception e) {
						logger.error("Error al recuperar descripcion del Lom en idioma " + resultado.getIdioma());
					}
					if(logger.isDebugEnabled()) logger.debug("Descripciones recuperadas " + descripciones);
					if(descripciones != null && descripciones.size()>0) {
						if(logger.isDebugEnabled()) logger.debug(descripciones.size() + " descripciones recuperadas para Lom con titulo " + resultado.getTitulo() + " e idioma " + resultado.getIdioma());
						resultado.setDescripcion(descripciones.get(0).toString());
					}
					if(logger.isDebugEnabled()) logger.debug("LomVO generado con titulo: " + resultado.getTitulo());
				} else if (array[i] instanceof Location) {
					/*
					 * Es una instancia de adlcp:location. Almaceno el path en
					 * el VO para que el MapOdeVOListener lo procese recuperando
					 * el título del ODE.
					 */
					resultado = new LomVO();
					resultado.setMetadatoExterno(((Location)array[i]).getContent());
					if(logger.isDebugEnabled()) logger.debug("Encontrada referencia a metadato externo : " + resultado.getMetadatoExterno());
				}
			}
		}
		destination = resultado;
		return destination;
	}
}

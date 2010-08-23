/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.auditoria.registrar;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/** 
 * Clase que se encarga del registro de los datos que no son interceptados
 * 
 * @author jsimon
 */

public class RegistroExterno {

	static Log log = LogFactory.getLog("RegistroExterno");
	
	/**
	 *  Método genérico para poder registrar operaciones que no se interceptan  
	 * 	@param datos Datos a registrar 
	 *  @return registro  
	 */
	public static boolean operacionGenerica(DatosVO datos) {

		boolean registro = false;
		
		try {
			Registrar.operacion(datos);			
			registro = true;		
		}
		catch (Exception e) {
			log.error("Se ha producido un error al registrar una operación externa " + e);			
		}
		
		return registro;		
	}
	
	/**
	 *  Método genérico para poder registrar operaciones que no se interceptan  
	 * 	@param valores Datos a registrar 
	 *  @param moduloDestino Operación realizada
	 *  @return registro  
	 */
	public static boolean operacionGenerica(HashMap valores, String moduloDestino) {

		boolean registro = false;
		
		try {
			DatosVO datos = new DatosVO();
			datos.setValores(valores);
			datos.setModuloDestino(moduloDestino);			
			registro = operacionGenerica(datos);		
		}
		catch (Exception e) {
			log.error("Se ha producido un error al registrar una operación externa " + e);			
		}
		
		return registro;		
	}
	
	/**
	 *  Método genérico para poder registrar operaciones que no se interceptan  
	 * 	@param idODE Identificador del ODE 
	 *  @param idioma Idioma del ODE
	 *  @param moduloDestino Operación realizada
	 *  @return registro  
	 */
	public static boolean operacionGenerica(String idODE, String idioma, String moduloDestino) {

		boolean registro = false;
		
		try {
			HashMap<String,String> valores = new HashMap<String,String>();
			valores.put(RegistroCtes.PARAMETRO_IDENTIFICADOR_ODE, idODE);
			valores.put(RegistroCtes.PARAMETRO_IDIOMA, idioma);			
			registro = operacionGenerica(valores, moduloDestino);
		}
		catch (Exception e) {
			log.error("Se ha producido un error al realizar un registro externo (no interceptado) de una operación  " + e);			
		}
		
		return registro;		
	}	
	
	/**
	 *  Método para poder registrar el envío de un correo que no se intercepta porque esa operación no llama a un web service  
	 * 	@param idODE Identificador del ODE 
	 *  @param idioma Idioma del ODE
	 *  @return registro  
	 */
	public static boolean operacionEnviarCorreo(String idODE, String idioma) {

		return operacionGenerica(idODE, idioma, RegistroCtes.OPERACION_ENVIAR_CORREO);		
	}
}

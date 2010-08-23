/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.validar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.ValidaVO;
import es.pode.empaquetador.presentacion.GestorSesion;



/**
 * @see es.pode.empaquetador.presentacion.validar.ValidarController
 */
public class ValidarControllerImpl extends ValidarController
{
	private static Logger logger = Logger.getLogger(ValidarControllerImpl.class);
	private static GestorSesion gs = new GestorSesion();
	
	
    /**
     * @see es.pode.empaquetador.presentacion.validar.ValidarController#validar(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.validar.ValidarForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void validar(ActionMapping mapping, es.pode.empaquetador.presentacion.validar.ValidarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        
    	// Validar e insertar el ValidaVO resultante en el form de salida.
    	
    	OdeVO ode=this.getEmpaquetadorSession(request).getOde();
    	ValidaVO validacion=null;
		try {
			this.getSrvGestorManifestService().guardarManifiesto(getEmpaquetadorSession(request).getIdLocalizador());
			validacion = this.getSrvGestorManifestService().validar(getEmpaquetadorSession(request).getIdLocalizador(), "COMPLETA");
		} catch (Exception e) {
			logger.error("Error detectado al guardar el ode antes de validar" + ode.getIdentifier());
		}
    	form.setValidaVO(validacion);
    }

	public boolean esValido(ActionMapping mapping, EsValidoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 *  Recoger el form de salida, comprobar si es valido y:
		 *   - Parsear los mensajes de error (si los hay) para
		 *    generar una List de mensajes (claves de i18n).
		 *   - Devolver el resultado de la validacion 
		 *     (true = valido; false = errores)
		 */
		
		
		Boolean valido = form.getValidaVO().getEsValidoManifest();		
		//form.
		String mensajesString = form.getValidaVO().getResultadoValidacion();
		
		String[] mensajes = mensajesString.split(";");		
		form.setMensajesErrorAsArray(mensajes);
		
		return valido.booleanValue();
	}

	public String esAvanzado(ActionMapping mapping, EsAvanzadoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String resultado = null;
		
		if(logger.isDebugEnabled()) logger.debug("Recupero datos de autenticacion");
		
		if(gs.esAvanzado()) resultado="Avanzado";
		else resultado="Basico";

		if(logger.isDebugEnabled()) logger.debug("Tipo de empaquetador detectado por validar : " + resultado);
		return resultado;
	}

	
}
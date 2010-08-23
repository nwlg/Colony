/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.presentacion.GestorSesion;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.empaquetador.presentacion.agregar.AgregarSubmanifiestoController
 */
public class AgregarSubmanifiestoControllerImpl extends AgregarSubmanifiestoController
{

	private static Logger logger = Logger.getLogger(AgregarSubmanifiestoControllerImpl.class);
	private GestorSesion gs = new GestorSesion();
	
	
    /**
     * @see es.pode.empaquetador.presentacion.agregar.AgregarSubmanifiestoController#seleccionarOrigen(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.agregar.SeleccionarOrigenForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String seleccionarOrigen(ActionMapping mapping, es.pode.empaquetador.presentacion.agregar.SeleccionarOrigenForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		String origen = form.getOrigen();
    	String accion = form.getAction();
    	String resultado = null;
    	
    	if (accion.equals(i18n.getString("portal_empaquetado_agregarSubmanifiestos.continuar")))
     	{
    		if((origen.equals("Local"))||(origen.equals("Personales"))||(origen.equals("Repositorio")))
    		{
    		    resultado=origen;
    		}
    		else
    		{
    			throw new ValidatorException("{portal_empaquetado.exception}");
    		}
    		
    	}
    	else
    	{
    		resultado="Cancelar";
    	}
      return resultado;
    }


    /**
     * @see es.pode.empaquetador.presentacion.agregar.AgregarSubmanifiestoController#tipoEmpaquetador(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.agregar.TipoEmpaquetadorForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String tipoEmpaquetador(ActionMapping mapping, es.pode.empaquetador.presentacion.agregar.TipoEmpaquetadorForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        return gs.tipoEmpaquetador(this.getEmpaquetadorSession(request));
    }


}
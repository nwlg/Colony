/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.ControlModeVO;
import es.pode.empaquetador.negocio.servicio.GrupoVO;
import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia.SecuenciaController
 */
public class SecuenciaControllerImpl extends SecuenciaController
{

    public final void recuperarDatos(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia.RecuperarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	if((form.getChoice()==null) || (form.getChoiceExit()==null) 
				||(form.getFlow()==null)||(form.getForwardOnly()==null))
		{
    		
			form.setChoice(Boolean.TRUE);
			form.setChoiceExit(Boolean.FALSE);
			form.setFlow(Boolean.TRUE);
			form.setForwardOnly(Boolean.FALSE);
		}
    	else
    	{
    		form.setChoice(form.getChoice());
    		form.setChoiceExit(form.getChoiceExit());
    		form.setFlow(form.getFlow());
    		form.setForwardOnly(form.getForwardOnly());
    	}
     }


    public final void submit(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia.SubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
    	String accion = form.getAction();
    	
    	if (accion.equals(i18n.getString("portal_empaquetado_secuencia.aceptar")))
    	{
    		if((form.getChoice()==null) || (form.getChoiceExit()==null) 
    				||(form.getFlow()==null)||(form.getForwardOnly()==null))
    		{
    			throw new ValidatorException("{portal_empaquetado.exception}");
    		}
    	}
     }


    public final java.lang.String selectAction(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia.SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String result = null;
		String actionSubmit = form.getAction();
		java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		
		if (form.getAction()== (null))
		{
			throw new ValidatorException("{portal_empaquetado.exception}");
		}
			
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_secuencia.cancelar")) )
		{
			result = "Cancelar";
		} 
		else if (actionSubmit.equals(i18n.getString("portal_empaquetado_secuencia.aceptar"))) 
		{
			result = "aceptar";
		} 
		else if (actionSubmit.equals(i18n.getString("secuencia.valorPorDefecto"))) 
		{
			result = "default";
		} 
		
		Logger.getLogger(this.getClass()).error("El valor del submit no es correcto (actionSubmit = "
							+ actionSubmit + ";");
       
         return result;
    }


    public final void fijarPorDefecto(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia.FijarPorDefectoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	form.setChoice(Boolean.TRUE);
		form.setChoiceExit(Boolean.FALSE);
		form.setFlow(Boolean.TRUE);
		form.setForwardOnly(Boolean.FALSE);
     }


    public final void asociarSecuencia(ActionMapping mapping, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia.AsociarSecuenciaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
    	
    	List submanifestPath = sesEmpaq.getSubmanifestPath();
    	OdeVO ultimoSubm = (OdeVO) submanifestPath.get(submanifestPath.size()-1);
    	Integer index = submanifestPath.size()-1;
    	String identificador = index==0?sesEmpaq.getIdLocalizador():ultimoSubm.getIdentifier();
    	List idCollection = sesEmpaq.getIdCollection();
    	String idElemento ="";
    	if(idCollection.size()>1)
    	{
    		GrupoVO ultimoIdCollection = (GrupoVO) idCollection.get(idCollection.size()-1);
    		idElemento = ultimoIdCollection.getIdentifier();
    	}
    	else
    	{
    		OrganizacionVO ultimoIdCollection = (OrganizacionVO) idCollection.get(idCollection.size()-1);
    		idElemento = ultimoIdCollection.getIdentifier();
    		
    	}
    	
    	
    	ControlModeVO controlMode=new ControlModeVO();
    	controlMode.setChoice(form.getChoice());
    	controlMode.setChoiceExit(form.getChoiceExit());
    	controlMode.setFlow(form.getFlow());
    	controlMode.setForwardOnly(form.getForwardOnly());
    	
    	this.getSrvGestorManifestService().asociarSecuencia(identificador, idElemento, controlMode);
     }


}
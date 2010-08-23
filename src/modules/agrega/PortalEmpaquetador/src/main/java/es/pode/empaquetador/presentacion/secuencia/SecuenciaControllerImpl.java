/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.secuencia;

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
import es.pode.empaquetador.presentacion.GestorSesion;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.empaquetador.presentacion.secuencia.SecuenciaController
 */
public class SecuenciaControllerImpl extends SecuenciaController
{

	private static Logger logger = Logger.getLogger(SecuenciaControllerImpl.class);
	
	private GestorSesion gs = new GestorSesion();
	
    /**
     * @see es.pode.empaquetador.presentacion.secuencia.SecuenciaController#modificarSecuencia(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.secuencia.ModificarSecuenciaForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void asociarSecuencia(ActionMapping mapping, AsociarSecuenciaForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
    	
    	List submanifestPath = sesEmpaq.getSubmanifestPath();
    	Integer index = submanifestPath.size()-1;
    	OdeVO ultimoSubm = (OdeVO) submanifestPath.get(index);
    	String identificador=index==0?sesEmpaq.getIdLocalizador():ultimoSubm.getIdentifier();
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

	/* (non-Javadoc)
	 * @see es.pode.empaquetador.presentacion.secuencia.SecuenciaController#recuperarDatos(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.secuencia.RecuperarDatosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public final void recuperarDatos(ActionMapping mapping, RecuperarDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		ControlModeVO ctrlModeVo = new ControlModeVO(); 
		List idCol = getEmpaquetadorSession(request).getIdCollection();
		
		if(idCol.get(idCol.size()-1) instanceof OrganizacionVO)
		{
			ctrlModeVo = gs.obtenerCM( ((OrganizacionVO) idCol.get(idCol.size()-1)).getSecuencia());
		}else if(idCol.get(idCol.size()-1) instanceof GrupoVO)
		{
			ctrlModeVo = gs.obtenerCM( ((GrupoVO) idCol.get(idCol.size()-1)).getSecuencia());
		}
		
      	form.setChoice(ctrlModeVo.getChoice());
      	form.setChoiceExit(ctrlModeVo.getChoiceExit());
      	form.setFlow(ctrlModeVo.getFlow());
      	form.setForwardOnly(ctrlModeVo.getForwardOnly());
 
	}

	public final void fijarPorDefecto(ActionMapping mapping, FijarPorDefectoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		form.setChoice(Boolean.TRUE);
		form.setChoiceExit(Boolean.FALSE);
		form.setFlow(Boolean.TRUE);
		form.setForwardOnly(Boolean.FALSE);
	}
	
	

	public String selectAction(ActionMapping mapping, SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String resultado = null;
		
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
    	
    	if (form.getAction()== (null))
		{
			throw new ValidatorException("{portal_empaquetado.exception}");
		}
			
		else if (accion.equals(i18n.getString("portal_empaquetado_secuencia.cancelar")) )
		{
			resultado = "Cancelar";
		} 
		else if (accion.equals(i18n.getString("portal_empaquetado_secuencia.aceptar"))) 
		{
			resultado = "Aceptar";
		} 
		else if (accion.equals(i18n.getString("secuencia.valorPorDefecto"))) 
		{
			resultado = "Default";
		} 
		
    	return resultado;
	}

	

	public final String tipoEmpaquetador(ActionMapping mapping, TipoEmpaquetadorForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return gs.tipoEmpaquetador(this.getEmpaquetadorSession(request));
	}


}
/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.simular;

import java.util.Arrays;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import es.pode.modificador.negocio.servicio.ConfiguracionTarea;
import es.pode.modificador.negocio.servicio.ModificacionSimuladaVO;
import es.pode.modificador.negocio.servicio.ResultadoModificacionVO;
import es.pode.modificador.presentacion.idiomasBuscador.IdiomasBuscadorSingleton;
import es.pode.modificador.presentacion.informes.tarea.ConstantesInforme;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.modificador.presentacion.simular.SimularModificacionController
 */
public class SimularModificacionControllerImpl extends SimularModificacionController
{

	private static final Logger logger = Logger.getLogger(SimularModificacionControllerImpl.class);
	private static final int NUM_ODES = 3;

    public String submitConfirmacion(ActionMapping mapping, SubmitConfirmacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String result = null;
		MessageResources resources = MessageResources.getMessageResources("application-resources");
		String action = form.getAction();
		if(logger.isDebugEnabled()) logger.debug("action = " + action);
		form.setIdModificacion(this.getConfigurarModificacionSession(request).getIdModificacion());
		if(resources.getMessage((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE),"simular.si").equals(action)) {
			result = "Aceptar";
		} else {
			this.removeConfigurarModificacionSession(request);
			result = "Cancelar";
		}
		return result;
	}

	/**
     * @see es.pode.modificador.presentacion.simular.SimularModificacionController#simular(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.simular.SimularForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void simular(ActionMapping mapping, es.pode.modificador.presentacion.simular.SimularForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try {
    		ConfiguracionTarea tarea = this.getConfigurarModificacionSession(request).getConfiguracion();
    		String nombre = this.getConfigurarModificacionSession(request).getNombre();
    		Long idModificacion=this.getConfigurarModificacionSession(request).getIdModificacion();
    		this.getInformeSession(request).setNombreTarea(nombre);
    		this.getInformeSession(request).setTareaSeleccionada(idModificacion);
    		this.removeConfigurarModificacionSession(request);
    		
    		ModificacionSimuladaVO modificacion = this.getSrvHerramientaModificacion().simularModificacion(tarea, new Integer(NUM_ODES));
    		ResultadoModificacionVO[] resultados = modificacion.getResultados();
    		for(int i=0; i<resultados.length;i++)
    		{
    			//Si Titulo es vacio, le pongo ultimo token path
    			ResultadoModificacionVO resultado = resultados[i];
    			if(resultado.getTitulo()==null||resultado.getTitulo().equals("")) {
    				String path = resultado.getPathOriginal();
    				if(path.lastIndexOf('/')==path.length()-1) {
    					path=path.substring(0,path.lastIndexOf('/'));
    				}
    				String nombreFichero= path.substring(path.lastIndexOf('/')+1);
    				resultado.setTitulo(nombreFichero);
    			}		
    		}
    		
    		// Meto en la sesion el resultado de la tarea. 		
    		this.getInformeSession(request).setResultadoTarea(modificacion.getResultado().getValue());
    		this.getInformeSession(request).setOdes(Arrays.asList(modificacion.getResultados()));
    		this.getInformeSession(request).setOrigen(ConstantesInforme.Configurar);
    		this.getInformeSession(request).setDescResultado(modificacion.getMsgError());
    		
    	} catch (Exception e) {
			logger.error("Error al simular tarea de modificacion : " + e.getMessage());
			if(logger.isDebugEnabled()) logger.debug(e);
		}
    }

	public void obtenerDatos(ActionMapping mapping, ObtenerDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");
	}









}
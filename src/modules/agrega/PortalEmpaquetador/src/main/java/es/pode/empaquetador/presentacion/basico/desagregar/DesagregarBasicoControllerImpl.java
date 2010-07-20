/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.desagregar;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.GrupoVO;
import es.pode.empaquetador.presentacion.DecisorOffline;
import es.pode.empaquetador.presentacion.GestorSesion;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.empaquetador.presentacion.basico.desagregar.DesagregarBasicoController
 */
public class DesagregarBasicoControllerImpl extends DesagregarBasicoController
{
	private static Logger logger = Logger.getLogger(DesagregarBasicoControllerImpl.class);
	private GestorSesion gs = new GestorSesion();
    /**
     * @see es.pode.empaquetador.presentacion.basico.desagregar.DesagregarBasicoController#crearSesion(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.desagregar.CrearSesionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void crearSesion(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.desagregar.CrearSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        try {
        	
	    	List identificadores = form.getIdentificadores();
	        if(identificadores == null ) {
	        	logger.error("Identificadores null en crearSesion de desagregarbasico");
	        	throw new ValidatorException("{gestor_basico.desagregar.error.identificadores}");
	        }
	        if(logger.isDebugEnabled()) logger.debug("Creando sesion desagregar basico para exportar " + identificadores.size() + " items como ode");
	        GrupoVO[] hijos = gs.buscarHijosIdCollection(request);
	        List grupos = new ArrayList();
	        for(int i=0;i<hijos.length;i++) {
	        	if(identificadores.contains(hijos[i].getIdentifier())) grupos.add(hijos[i]);
	        }
	        if(logger.isDebugEnabled()) logger.debug(grupos.size() + " gruposVO encontrados para desagregar");
	        this.getDesagregarBasicoSession(request).setGrupos(grupos);
        } catch (Exception e) {
        	logger.error(e);
        	throw e;
        }
    }

    /**
     * @see es.pode.empaquetador.presentacion.basico.desagregar.DesagregarBasicoController#selectAction(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.desagregar.SelectActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String selectAction(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.desagregar.SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        String action = form.getAction();
        String destino = form.getDestino();
        String resultado = "Cancelar";
        
        try {
        	ResourceBundle i18n = ResourceBundle.getBundle("application-resources",(Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE));
        	if(i18n.getString("gestor_basico.desagregar.cancelar").equalsIgnoreCase(action)) {
        		logger.debug("Se ha pulsado cancelar");
        	} else {
        		
        		if("Local".equalsIgnoreCase(destino)) {
        			resultado = "Local";
        			logger.debug("Se ha pulsado local");
        		} else if("Personales".equalsIgnoreCase(destino)) {
        			resultado = "Personales";
        			logger.debug("Se ha pulsado personales");
        		} else {
        			logger.error("SelectAction no tiene datos para decidir");
        		}
        	}
        } catch (Exception e) {
        	logger.error(e);
        	throw new ValidatorException("{gestor_basico.error.inesperado}");
        }
        return resultado;
    }


    /**
     * @see es.pode.empaquetador.presentacion.basico.desagregar.DesagregarBasicoController#desagregarPersonales(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.desagregar.DesagregarPersonalesForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void desagregarPersonales(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.desagregar.DesagregarPersonalesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        try {
        	String idOde = this.getEmpaquetadorSession(request).getIdLocalizador();
        	GrupoVO[] items = (GrupoVO[])this.getDesagregarBasicoSession(request).getGrupos().toArray(new GrupoVO[]{});
        	logger.debug("Llamando a desagregarItem para desagregar en personales");
        	String id = this.getSrvEmpaquetadorBasicoService().desagregarItem(idOde, items);
        	logger.debug("Desagregado con identificador " + id);
        	saveSuccessMessage(request, "gestor_basico.desagregar.personales.success",new String[]{id});
        } catch (Exception e) {
        	logger.error("Error inesperado",e);
        	throw new ValidatorException("{gestor_basico.error.inesperado}");
        }
    }


    /**
     * @see es.pode.empaquetador.presentacion.basico.desagregar.DesagregarBasicoController#desagregarLocal(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.desagregar.DesagregarLocalForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void desagregarLocal(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.desagregar.DesagregarLocalForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
       try {
			String idOde = this.getEmpaquetadorSession(request).getIdLocalizador();
			GrupoVO[] items = (GrupoVO[])this.getDesagregarBasicoSession(request).getGrupos().toArray(new GrupoVO[]{});
			logger.debug("Llamando a desagregarItem para desagregar en local");
			DataHandler dh = this.getSrvEmpaquetadorBasicoService().desagregarItemLocal(idOde, items);
			logger.debug("Iniciando la descarga del paquete generado");
			gs.iniciarDescargaFichero(dh, response, idOde+".zip");
       } catch (Exception e) {
			logger.error("Error inesperado",e);
			throw new ValidatorException("{gestor_basico.error.inesperado}");
       }
     }

    /**
     * @see es.pode.empaquetador.presentacion.basico.desagregar.DesagregarBasicoController#borrarObjetoSesion(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.desagregar.BorrarObjetoSesionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void borrarObjetoSesion(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.desagregar.BorrarObjetoSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	logger.debug("Borrando objeto de sesion DesagregarBasicoSession");
        this.removeDesagregarBasicoSession(request);
    }

	public boolean esOffline(ActionMapping mapping, EsOfflineForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(logger.isDebugEnabled()) logger.debug("Es offline? " + DecisorOffline.esOffline());
		return DecisorOffline.esOffline();
	}









}
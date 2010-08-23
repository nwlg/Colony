/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.gestor;

import java.util.ArrayList;
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
 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController
 */
public class GestorBasicoControllerImpl extends GestorBasicoController {

	private static Logger logger = Logger.getLogger(GestorBasicoControllerImpl.class);
	private GestorSesion gestorSesion = new GestorSesion();
	
	/**
	 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#vaciarPortapapeles(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.basico.gestor.VaciarPortapapelesForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void vaciarPortapapeles(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.basico.gestor.VaciarPortapapelesForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
//		 Reinicializa el portapapeles a lista vacia

		EmpaquetadorSession sesion=this.getEmpaquetadorSession(request);
		
		this.getEmpaquetadorSession(request).setPortapapeles(new ArrayList());
		
		if(!sesion.getAccion().equals("Normal"))
    	{
    		sesion.setModoPegar(false);
    		sesion.setAccion("Normal");
    	}
	}

	/**
	 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#submit(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.basico.gestor.SubmitForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void submit(ActionMapping mapping,
			es.pode.empaquetador.presentacion.basico.gestor.SubmitForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmpaquetadorSession sesEmpaq = this.getEmpaquetadorSession(request);
    	List identificadores = form.getIdentifierRowSelection();
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
		String accion = form.getActionSubmit();
		String combo = form.getActionCombo();
		if ((accion.equals(i18n.getString("gestor_basico.eliminar"))) 
    			||(accion.equals(i18n.getString("gestor_basico.copiar")))
    			||(accion.equals(i18n.getString("gestor_basico.cortar")))
    			|| (accion.equals(i18n.getString("gestor_basico.masAcciones.submit")) && "Desagregar".equals(combo)))
		{
			if((identificadores==null)||(identificadores.size()==0))
			{
    	    	if (accion.equals(i18n.getString("gestor_basico.copiar")))
    	    		throw new ValidatorException("{portalempaquetado.gestorbasico.carpetas.copiar.error.noseleccionado}");
    	    	else if ((accion.equals(i18n.getString("gestor_basico.cortar"))))
    	    		throw new ValidatorException("{portalempaquetado.gestorbasico.carpetas.cortar.error.noseleccionado}");
      	    	else if ((accion.equals(i18n.getString("gestor_basico.eliminar"))))
    	    		throw new ValidatorException("{portalempaquetado.gestorbasico.carpetas.eliminar.error.noseleccionado}");
      	    	else if ((accion.equals(i18n.getString("gestor_basico.masAcciones.submit")) && "Desagregar".equals(combo)))
    	    		throw new ValidatorException("{portalempaquetado.gestorbasico.carpetas.desagregar.error.noseleccionado}");
			}
			else
			{
				form.setIdentificadores(identificadores);
			}
		}
		else if((accion.equals(i18n.getString("gestor_basico.pegar"))))
		{
			if((sesEmpaq.getPortapapeles()==null)||(sesEmpaq.getPortapapeles().size()==0))
			{
				throw new ValidatorException("{portal_empaquetado.exception}");
			}
		}
 		
	}

	/**
	 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#subir(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.basico.gestor.SubirForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void subir(ActionMapping mapping,
			es.pode.empaquetador.presentacion.basico.gestor.SubirForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idODE = this.getEmpaquetadorSession(request).getIdLocalizador();
		if (logger.isDebugEnabled()) logger.debug("Subiendo el ODE : " + idODE);
		if (idODE != null && form.getIdentifier() != null) {
			try {
				this.getSrvGestorManifestService().subirItem(idODE, form.getIdentifier());
			} catch (Exception e) {
				throw new ValidatorException("{gestor_basico.error_subir}");
			}
		}
	}

	/**
	 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#selectAction(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.basico.gestor.SelectActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final java.lang.String selectAction(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.basico.gestor.SelectActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * Metodo de decision para el action. Analiza los parametros
		 * actionSubmit (value de los botones submit) y actionCombo (valor
		 * introducido en el combo de decision) para redirigir al caso de uso
		 * correspondiente. El actionSubmit y actionCombo llegara
		 * internacionalizado, por lo que es necesario acceder al ResouceBundle
		 * para obtener el valor correcto en la comparacion.
		 */
		String result = null;
		String actionCombo = form.getActionCombo();
		String actionSubmit = form.getActionSubmit();
		java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);//request.getLocale();
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",
				locale);
		
		if(actionSubmit == null) {
			logger.error("Error: actionSubmit null en GestorBasico");
		} else {
			if(actionSubmit.equalsIgnoreCase(i18n.getString("gestor_basico.anadirCarpeta"))) {
				result="CrearCarpeta";
			} else if(actionSubmit.equalsIgnoreCase(i18n.getString("gestor_basico.copiar"))) {
				result="Copiar";
			} else if(actionSubmit.equalsIgnoreCase(i18n.getString("gestor_basico.cortar"))) {
				result="Cortar";
			} else if(actionSubmit.equalsIgnoreCase(i18n.getString("gestor_basico.pegar"))) {
				result="Pegar";
			} else if(actionSubmit.equalsIgnoreCase(i18n.getString("gestor_basico.eliminar"))) {
				result="Eliminar";
			} else if(actionSubmit.equalsIgnoreCase(i18n.getString("gestor_basico.masAcciones.submit"))) {
				if(actionCombo == null ) {
					logger.error("Error: actionCombo null en GestorBasico");
				} else if(actionCombo.equals("Agregar")) {
					result = "Agregar";
				} else if (actionCombo.equals("Desagregar")) {
					result = "Desagregar";
				} else if(actionCombo.equals("RenombrarOrganizacion")) {
					result = "RenombrarOrganizacion";
				}
			} else {
				logger.debug("No se ha seleccionado ningun action valido. Regresando a GestorBasico");
				result="Ninguno";
			}
		}
		if(logger.isDebugEnabled()) logger.debug("SelectAction en GestorBasico devuelve : " + result);
		return result;
	}

	/**
	 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#pegar(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.basico.gestor.PegarForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void pegar(ActionMapping mapping,
			es.pode.empaquetador.presentacion.basico.gestor.PegarForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmpaquetadorSession sesion = this.getEmpaquetadorSession(request);
    	List portapapeles = sesion.getPortapapeles();
    
        	
    	if(sesion.isModoPegar()==true)
    	{
	    	if(portapapeles!=null && portapapeles.size()>0)
	    	{
	    		
    			String identificador=sesion.getIdLocalizador();
    			List idCollection = this.getEmpaquetadorSession(request)
										.getIdCollection();
    			Object elemento=idCollection.get(idCollection.size()-1);
    			String destino;
    			if (elemento instanceof GrupoVO) {
					destino=((GrupoVO)elemento).getIdentifier();
				}else{
					destino=((OrganizacionVO)elemento).getIdentifier();
				}
    			    			 
    			//ficheros a copiar del portapapeles
    			String [] elementos=new String[portapapeles.size()];
    			for(int i=0;i<portapapeles.size();i++){
    				elementos[i]=((GrupoVO)portapapeles.get(i)).getIdentifier();
    			}
    			
				if(sesion.getAccion().equals("Cortar"))
	    		{
					this.getSrvGestorManifestService().moverElementos(identificador, elementos, destino);
	    		}
	    		else if(sesion.getAccion().equals("Copiar")) 
	    		{
	    			this.getSrvGestorManifestService().copiarElementos(identificador, elementos, destino);
	    		}
	    	}
	    	else
	    	{
	    		throw new ValidatorException("{portal_empaquetado.exception.session}");
	    	}
	    }
	    else
	    {
	    	throw new ValidatorException("{portal_empaquetado.exception}");
	    }
	}

	/**
	 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#obtenerItems(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.basico.gestor.ObtenerItemsForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void recuperarDatos(
			ActionMapping mapping,
			RecuperarDatosForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * Usa el parametro idActual para obtener una lista de los GruposVO que
		 * hay que mandar al JSP para dibujar.
		 */

		EmpaquetadorSession sesion = this.getEmpaquetadorSession(request);
		if (sesion.getVistaCarpeta() == null) {
			sesion.setVistaCarpeta(new Boolean(true));
		}
		if (logger.isDebugEnabled())
			logger.debug("Refrescando los objetos de la sesion ... ");
		gestorSesion.refrescarObjetosSesion(request);
		if (logger.isDebugEnabled())
			logger.debug("Objetos de sesion de empaquetador refrescados.");
		List listId = sesion.getIdCollection();
		OrganizacionVO orgPrincipal = recuperaOrganizacionPrincipal(sesion.getOde());
		List grupos = new java.util.ArrayList();
		ControlModeVO seq = null;
		if (listId != null && !listId.isEmpty()) {
			Object idActual = (Object) listId.get(listId.size() - 1);
			if (idActual instanceof OrganizacionVO) {
				// Estamos navegando en el raiz (organizacion principal)
				GrupoVO[] subGrupos = ((OrganizacionVO) idActual).getGrupos();
				if (subGrupos != null) {
					grupos.addAll(java.util.Arrays.asList(subGrupos));
				}
				seq = gestorSesion.obtenerCM(((OrganizacionVO)idActual).getSecuencia());
			} else if (idActual instanceof GrupoVO) {
				// Obtener los subgrupos del grupo actual
				GrupoVO[] subGrupos = ((GrupoVO) idActual).getGrupos();
				if (subGrupos != null) {
					grupos.addAll(java.util.Arrays.asList(subGrupos));
				}
				seq = gestorSesion.obtenerCM(((GrupoVO)idActual).getSecuencia());
			} else {
				logger.error("Error al recuperar el grupo sobre el que se esta navegando. Inicializa a organizacion principal.");
				listId = new java.util.ArrayList();
				listId.add(orgPrincipal);
				grupos.addAll(java.util.Arrays
						.asList(orgPrincipal.getGrupos()));
				seq = gestorSesion.obtenerCM(orgPrincipal.getSecuencia());
			}
		}
		form.setPortapapeles(this.getEmpaquetadorSession(request)
				.getPortapapeles());
		form.setGrupos(grupos);
		form.setIdCollection(this.getEmpaquetadorSession(request)
				.getIdCollection());
		form.setControlMode(seq);
		form.setOrganizacion(orgPrincipal);

	}

	/**
	 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#navegar(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.basico.gestor.NavegarForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void navegar(ActionMapping mapping,
			es.pode.empaquetador.presentacion.basico.gestor.NavegarForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		/*
		 * TODO Version simple de Navegar. Completar para que no navege en el
		 * interior de sub-manifiestos, que podrian no ser editables con el
		 * Gestor Basico.
		 */
		
		EmpaquetadorSession sesion=this.getEmpaquetadorSession(request);
		List lista = new ArrayList();
		OdeVO ode = this.getEmpaquetadorSession(request).getOde();
		String id = form.getIdentifier();
		OrganizacionVO[] orgs = ode.getOrganizaciones();
		for (int i = 0; i < orgs.length && lista.isEmpty(); i++) {
			if (id.equals(orgs[i].getIdentifier())) {
				lista.add(orgs[i]);
			} else {
				List tmpList = rellenarBarraNavegacion(orgs[i].getGrupos(), id);
				if (tmpList != null && tmpList.size() > 0) {
					lista.add(orgs[i]);
					lista.addAll(tmpList);
				}
			}
		}
		this.getEmpaquetadorSession(request).setIdCollection(lista);
		if(!sesion.getAccion().equals("Normal"))
    	{
    		sesion.setModoPegar(true);
    	}
	}

	/**
	 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#eliminarPortapapeles(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.basico.gestor.EliminarPortapapelesForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void eliminarPortapapeles(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.basico.gestor.EliminarPortapapelesForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmpaquetadorSession sesion=this.getEmpaquetadorSession(request);
    	List portapapeles = sesion.getPortapapeles();
    	
    	String nombreEliminar=form.getIdentifier();
    	
    	//voy recorriendo el portapapeles comprobando el nombre a eliminar
    	if(portapapeles!=null && portapapeles.size()>0)
    	{
	    	for(int i=0; i<portapapeles.size();i++)
	    	{
	    		GrupoVO porta=(GrupoVO) portapapeles.get(i);
	    		if (porta.getIdentifier().equals(nombreEliminar))
	    		{
	    			portapapeles.remove(i);
	    		}
	    	}
	    	
	    	if(portapapeles.size()==0)
	    	{
	    		sesion.setAccion("Normal");
	    		sesion.setModoPegar(false);
	    	}
	    	 // inserto el portapapeles sin el elemento a eliminar
	        sesion.setPortapapeles(portapapeles);
    	}
    	else
    	{
    		throw new ValidatorException("{portal_empaquetado.exception.session}");
    	}
	}

	/**
	 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#eliminar(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.basico.gestor.EliminarForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void eliminar(ActionMapping mapping,
			es.pode.empaquetador.presentacion.basico.gestor.EliminarForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List idEliminar = form.getIdentificadores();

		if (idEliminar == null || idEliminar.size()==0) {
			throw new ValidatorException("{gestor_basico.error_seleccionar}");
		}
		String idOde=this.getEmpaquetadorSession(request).getIdLocalizador();
		if(logger.isDebugEnabled()) logger.debug("Eliminando " + idEliminar.size() + " grupos de " + idOde);
		for(int i=0;i<idEliminar.size();i++) {
			if(logger.isDebugEnabled()) logger.debug("Eliminando " + idEliminar.get(i) + " de " + idOde);
			this.getSrvGestorManifestService().eliminarGrupo(idOde, (String)idEliminar.get(i));
		}
	}

	/**
	 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#cortar(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.basico.gestor.CortarForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void cortar(ActionMapping mapping,
			es.pode.empaquetador.presentacion.basico.gestor.CortarForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmpaquetadorSession sesion = this.getEmpaquetadorSession(request);
		List idCopiar = form.getIdentificadores();
		List idCollection=sesion.getIdCollection();
		Object obj=idCollection.get(idCollection.size()-1);
		List portapapeles=sesion.getPortapapeles();
		
		GrupoVO[]grupos;
		if (obj instanceof GrupoVO){
			grupos=new GrupoVO[((GrupoVO)obj).getGrupos().length];
			grupos=((GrupoVO)obj).getGrupos();
		}else{
			grupos=new GrupoVO[((OrganizacionVO)obj).getGrupos().length];
			grupos=((OrganizacionVO)obj).getGrupos();
		}
		
		List porta=new ArrayList();
		if (idCopiar == null) {
			throw new ValidatorException("{gestor_basico.error_seleccionar}");
		}else{
			for (int i=0;i<idCopiar.size();i++){
				boolean encontrado=false;
				for (int k=0;k<grupos.length && !encontrado;k++){
					if (grupos[k].getIdentifier().equals(idCopiar.get(i))){
						porta.add(grupos[k]);
						encontrado=true;
					}
				}
			}
			portapapeles.addAll(porta);
			sesion.setAccion("Cortar");
			}
	}

	/**
	 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#copiar(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.basico.gestor.CopiarForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void copiar(ActionMapping mapping,
			es.pode.empaquetador.presentacion.basico.gestor.CopiarForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		EmpaquetadorSession sesion = this.getEmpaquetadorSession(request);
		List idCopiar = form.getIdentificadores();
		List idCollection=sesion.getIdCollection();
		Object obj=idCollection.get(idCollection.size()-1);
		List portapapeles=sesion.getPortapapeles();

		GrupoVO[]grupos;
		if (obj instanceof GrupoVO){
			grupos=new GrupoVO[((GrupoVO)obj).getGrupos().length];
			grupos=((GrupoVO)obj).getGrupos();
		}else{
			grupos=new GrupoVO[((OrganizacionVO)obj).getGrupos().length];
			grupos=((OrganizacionVO)obj).getGrupos();
		}
		
		List porta=new ArrayList();
		if (idCopiar == null) {
			throw new ValidatorException("{gestor_basico.error_seleccionar}");
		}else{
			for (int i=0;i<idCopiar.size();i++){
				boolean encontrado=false;
				for (int k=0;k<grupos.length && !encontrado;k++){
					if (grupos[k].getIdentifier().equals(idCopiar.get(i))){
						porta.add(grupos[k]);
						encontrado=true;
					}
				}
			}
		portapapeles.addAll(porta);
		sesion.setAccion("Copiar");
		}
	}

	/**
	 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#cambiarVista(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.basico.gestor.CambiarVistaForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void cambiarVista(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.basico.gestor.CambiarVistaForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		this.getEmpaquetadorSession(request).setVistaCarpeta(
				new Boolean(form.isVistaCarpeta()));
	}

	/**
	 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#bajar(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.basico.gestor.BajarForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public final void bajar(ActionMapping mapping,
			es.pode.empaquetador.presentacion.basico.gestor.BajarForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String idODE = this.getEmpaquetadorSession(request).getIdLocalizador();
		if (logger.isDebugEnabled()) logger.debug("Bajando el ODE : " + idODE);
		if (idODE != null && form.getIdentifier() != null) {
			try {
				this.getSrvGestorManifestService().bajarItem(idODE, form.getIdentifier());
			} catch (Exception e) {
				throw new ValidatorException("{gestor_basico.error_bajar}");
			}
		}
	}


	private OrganizacionVO recuperaOrganizacionPrincipal(OdeVO ode) {
		OrganizacionVO org = null;
		OrganizacionVO[] orgs = ode.getOrganizaciones();
		for (int i = 0; i < orgs.length && org == null; i++) {
			if (ode.getOrganizacionPrincipal().equals(orgs[i].getIdentifier()))
				org = orgs[i];
		}
		if (org == null)
			logger.error("No se ha encontrado la organizacion principal de "
					+ ode.getIdentifier());
		return org;
	}
	

	/**
	 * Metodo recursivo para rellenar la idCollection
	 * 
	 * @param grupos
	 * @param id
	 * @return
	 */
	private List rellenarBarraNavegacion(GrupoVO[] grupos, String id) {
		List lista = new ArrayList();
		if (grupos != null) {
			for (int i = 0; i < grupos.length && lista.isEmpty(); i++) {
				if (id.equals(grupos[i].getIdentifier())) {
					lista.add(grupos[i]);
				} else {
					List tmpList = rellenarBarraNavegacion(grupos[i]
							.getGrupos(), id);
					if (tmpList != null && tmpList.size() > 0) {
						lista.add(grupos[i]);
						lista.addAll(tmpList);
					}
				}
			}
		}
		return lista;
	}
	
	
}
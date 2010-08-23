/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.iniciarEmpaquetador;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;
import es.pode.empaquetador.presentacion.DecisorOffline;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.empaquetador.presentacion.GestorSesion;
import es.pode.empaquetador.presentacion.archivos.GestorArchivosSession;
import es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession;
import es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession;
import es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.i18n.I18n;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController
 */
public class InicioEmpaquetadorControllerImpl extends InicioEmpaquetadorController
{
    private static Logger logger = Logger.getLogger(InicioEmpaquetadorControllerImpl.class);

    private GestorSesion gs = new GestorSesion();
    
	/**
     * @see es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController#esEdicion(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.EsEdicionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String esEdicion(ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.EsEdicionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String ident=form.getIdentificador();
    	if(ident==null)
    	{
    		return "Crear";
    	}
    	else
    	{
    		form.setIdentificador(ident);
           return "Editar";
    	}
    }

    /**
     * @see es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController#crearOde(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.CrearOdeForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void crearOde(ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.CrearOdeForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
       if(logger.isDebugEnabled()) logger.debug("Intentando recuperar el login del usuario...");
		String sUser = gs.obtenerUsuario(request);
		if(logger.isDebugEnabled()) logger.debug("Llamando al servicio para iniciarNuevoODE con parametro user = " + sUser + "; titulo = " + form.getTitulo() + "; idioma = " + ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage());
		OdeVO odeCreado = this.getSrvGestorManifestService().iniciarNuevoODE(sUser, form.getTitulo(), ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage());
		try {
			if(logger.isDebugEnabled()) logger.debug("Generando backup del conjunto de archivos inicial");
			this.getSrvGestorArchivosService().generarBackup(
					odeCreado.getIdentifier());
		} catch (Exception e) {
			logger.error("Fallo en la generacion del backup",e);
		}
		form.setOde(odeCreado);
		getEmpaquetadorSession(request).setIdLocalizador(odeCreado.getIdentifier());
//		if(DecisorOffline.esOffline())
//			this.getEmpaquetadorSession(request).setUrlCerrar(this.getEmpaquetadorSession(request).getUrlCerrar() + "?idODE="+odeCreado.getIdentifier());
		this.getEmpaquetadorSession(request).setGuardadoPrimeraVez(false);
     }

    /**
	 * @see es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController#editarOde(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.iniciarEmpaquetador.EditarOdeForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
    public final void editarOde(
			ActionMapping mapping,
			es.pode.empaquetador.presentacion.iniciarEmpaquetador.EditarOdeForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String ident = form.getIdentificador();
		try {
			String tipoEmpaquetador = tipoEmpaquetador(request);
			OdeVO odeEditado = null;
			if("Avanzado".equalsIgnoreCase(tipoEmpaquetador)) {
				odeEditado = this.getSrvGestorManifestService().editarODE(ident);
			} else {
				odeEditado = this.getSrvEmpaquetadorBasicoService().editarOde(ident);
			}
			form.setOde(odeEditado);
		} catch (Exception e) {
			logger.error("Error en la edicion del ODE", e);
		}
		getEmpaquetadorSession(request).setIdLocalizador(ident);
		this.getEmpaquetadorSession(request).setGuardadoPrimeraVez(true);
	}

    /**
	 * @see es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController#crearSesion(org.apache.struts.action.ActionMapping,
	 *      es.pode.empaquetador.presentacion.iniciarEmpaquetador.CrearSesionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
    public final void crearSesion(ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.CrearSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	OdeVO ode = form.getOde();
    	EmpaquetadorSession ses = this.getEmpaquetadorSession(request);
    	GestorArchivosSession sesArch = this.getGestorArchivosSession(request);
     
    	ses.setOde(ode);
    	ses.setVistaCarpeta(Boolean.TRUE);
    	ses.setAccion("Normal");
    	ses.setModoPegar(false);
    	
    	sesArch.setAccion("Normal");
    	sesArch.setModoPegar(false);
    	
    	
    	//le introduzco la organizacion principal
    	List idCollection=new ArrayList();
       	String idOrgPrincipal = ode.getOrganizacionPrincipal();
    	
       	if(idOrgPrincipal!=null)
    	{
       		OrganizacionVO[] orgs= ode.getOrganizaciones();
       		if(orgs!=null && orgs.length>0)
       		{
       			for(int i=0;i<orgs.length ; i++)
       			{
       				if(orgs[i].getIdentifier().equals(idOrgPrincipal))
       				{
       					idCollection.add(orgs[i]);
       				}
       			}
       		}
       	}
    	ses.setIdCollection(idCollection);
	
    	//le introduzco la ruta de los submanifiestos
    	List submanifestPath =new ArrayList();
    	submanifestPath.add(ode);	
    	ses.setSubmanifestPath(submanifestPath);
    	ses.setPendientesCatalogacion(new ArrayList());
    	ses.setPortapapeles(new ArrayList());
    	ses.setEsOffline(DecisorOffline.esOffline());
     }

    /**
     * @see es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController#esAvanzado(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.EsAvanzadoForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String esAvanzado(ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.EsAvanzadoForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String tipoSesion=null;

    	try{
    		tipoSesion = tipoEmpaquetador(request);

    	}catch (Exception e){
    		tipoSesion="Avanzado";
//    		saveErrorMessage(request, "Error al leer la sesión. Por defecto el usuario trabaja en la Avanzada");
    		logger.error("Error al leer la sesión de usuario. Trabaja en Avanzado");
    		
    	}
    	this.getEmpaquetadorSession(request).setTipoEmpaquetador(tipoSesion);
    	return tipoSesion;
    }

	private String tipoEmpaquetador(HttpServletRequest request) {
		String tipoSesion = null;
		if ("avanzado".equals(LdapUserDetailsUtils.getEmpaquetador())){
			tipoSesion="Avanzado";
			if (logger.isDebugEnabled()) 
				logger.debug("La sesión en la que está trabajando el usuario es la " + tipoSesion);
		}else if ("basico".equals(LdapUserDetailsUtils.getEmpaquetador())){
			tipoSesion="Basico";
			if (logger.isDebugEnabled()) 
				logger.debug("La sesión en la que está trabajando el usuario es la " + tipoSesion);
		} else {
			tipoSesion="Avanzado";
			saveErrorMessage(request, "Error al leer la sesión. Por defecto el usuario trabaja en la Avanzada");
		}
		return tipoSesion;
	}

    /**
     * @see es.pode.empaquetador.presentacion.iniciarEmpaquetador.InicioEmpaquetadorController#compruebaSesion(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.CompruebaSesionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void compruebaSesion(ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.CompruebaSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String ident=request.getParameter("identificador");
    	String urlCerrar = request.getParameter("urlCerrar");
    	String espacioLibre = request.getParameter("espacioLibre");
    	String espacioOde = request.getParameter("espacioODE");
    	if(urlCerrar==null) {
    		urlCerrar = "/".concat(request.getSession().getServletContext().getInitParameter("url_gestorFlujo"));
    	}
    	form.setIdentificador(ident);
    	//compruebo que no hay nada creado y en el caso en que haya, lo borro
    	
    	if(this.getCrearElementoSession(request)!=null)
    	{
    		request.getSession().removeAttribute(CrearElementoSession.SESSION_KEY);
    	}
    	if(this.getCrearOrganizacionSession(request)!=null)
    	{
    		request.getSession().removeAttribute(CrearOrganizacionSession.SESSION_KEY);
    	}
    	if(this.getCrearRecursoAvanzadoSession(request)!=null)
    	{
    		request.getSession().removeAttribute(CrearRecursoAvanzadoSession.SESSION_KEY);
    	}
    	if	(this.getEmpaquetadorSession(request)!=null)
    	{
    		request.getSession().removeAttribute(EmpaquetadorSession.SESSION_KEY);
    	}
    	if((this.getGestorArchivosSession(request)!=null))	
    	{
    		request.getSession().removeAttribute(GestorArchivosSession.SESSION_KEY);
    	}
    	// Genero el objeto de sesio y le meto la url necesaria para cerrar el empaqueator
    	if(logger.isDebugEnabled()) logger.debug("Url de cerrar : " + urlCerrar);
    	this.getEmpaquetadorSession(request).setUrlCerrar(urlCerrar);
    	this.getEmpaquetadorSession(request).setEspacioLibre(espacioLibre);
    	this.getEmpaquetadorSession(request).setEspacioOde(espacioOde);
     }


	public void redirect(ActionMapping mapping, RedirectForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String urlCerrar = this.getEmpaquetadorSession(request).getUrlCerrar();
		if(urlCerrar==null ) urlCerrar = "/" + request.getSession().getServletContext().getInitParameter("url_gestorFlujo");
		// URLs tipo host/agrega
		urlCerrar="http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio()+ (urlCerrar.startsWith("/")?"":"/") +urlCerrar;
		this.removeEmpaquetadorSession(request);
		this.removeGestorArchivosSession(request);
		logger.debug("Redirigiendo a " + urlCerrar);
		response.sendRedirect(urlCerrar);
	}


	public String selectAction(ActionMapping mapping, SelectActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String result = "Cancelar";
		Locale loc = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		String aceptar = I18n.getInstance().getResource("iniciarEmpaquetador.aceptar", "application-resources", loc);
		if(logger.isDebugEnabled()) logger.debug("Action = " + form.getAction());
		if(aceptar!=null &&form.getAction()!=null&& aceptar.equals(form.getAction())) {
			if(form.getTitulo()==null || "".equals(form.getTitulo().trim())) {
				throw new ValidatorException("{iniciarEmpaquetador.titulo.error}");
			}
			result = "Aceptar";
		}
		
		return result;
	}


	public void crearLomesInicial(ActionMapping mapping, CrearLomesInicialForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String titulo = form.getTitulo();
		String identificador = form.getIdentificador();
		String idioma = ((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE)).getLanguage();
		logger.debug("Datos recibidos : titulo = " + titulo + " : identificador = " + identificador + " : idioma = " + idioma);
		OdeVO ode = this.getSrvGestorManifestService().generarMetadatoInicial(titulo, idioma, identificador);
		form.setOde(ode);
	}


	public String selectActionEditar(ActionMapping mapping, SelectActionEditarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String result = "Cancelar";
		Locale loc = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		String aceptar = I18n.getInstance().getResource("iniciarEmpaquetador.aceptar", "application-resources", loc);
		if(aceptar.equals(form.getAction())) {
			// Validaciones
			if(form.getTitulo()==null || "".equals(form.getTitulo().trim())) {
				throw new ValidatorException("{iniciarEmpaquetador.titulo.error}");
			}
			result = "Aceptar";
		}
		
		return result;
	}


	public boolean tieneLomes(ActionMapping mapping, TieneLomesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		OdeVO ode = form.getOde();
		boolean result =false;
		if(ode!=null && ode.getLom() !=null) result = true;
		if(logger.isDebugEnabled()) logger.debug("Tiene Lomes? " + result);
		return result;
	}

}
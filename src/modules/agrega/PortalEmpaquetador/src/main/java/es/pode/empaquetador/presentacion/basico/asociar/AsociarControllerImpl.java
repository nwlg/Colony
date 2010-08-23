/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.empaquetador.negocio.servicio.ArchivoVO;
import es.pode.empaquetador.negocio.servicio.FileVO;
import es.pode.empaquetador.negocio.servicio.GrupoVO;
import es.pode.empaquetador.negocio.servicio.OdeVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;
import es.pode.empaquetador.negocio.servicio.RecursoVO;
import es.pode.empaquetador.presentacion.EmpaquetadorSession;
import es.pode.empaquetador.presentacion.GestorSesion;
import es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoControllerImpl;
import es.pode.soporte.constantes.ConstantesAgrega;



/**
 * @see es.pode.empaquetador.presentacion.basico.asociar.AsociarController
 */
public class AsociarControllerImpl extends AsociarController
{ 
	private static Logger logger = Logger.getLogger(GestorBasicoControllerImpl.class);
	private GestorSesion gs = new GestorSesion();


    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.AsociarController#borrarSesion(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.BorrarSesionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void borrarSesion(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.BorrarSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        this.removeAsociarSession(request);
    }

    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.AsociarController#crearSesion(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.CrearSesionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void crearSesion(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.CrearSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
        AsociarSession asociarSession = this.getAsociarSession(request);
        EmpaquetadorSession empaSesion = this.getEmpaquetadorSession(request );
        asociarSession.setHref("");
        asociarSession.setFicheros(new ArrayList());
        
        OdeVO ode = empaSesion.getOde();
		String id = form.getIdentifier();
		if(logger.isDebugEnabled()) logger.debug("voy a buscar el GrupoVO en el Ode actual con el identifier " + id);
		GrupoVO grupo=buscarGrupo(ode,id);
		
		if(grupo!=null && grupo.getEsRecurso().booleanValue())
		{
			if(logger.isDebugEnabled()) logger.debug("voy a buscar el Recurso correspondiente al elementoReferenciado del GrupoVO " +  grupo.getElementoReferenciado());

			RecursoVO rec= buscarRecurso(ode, grupo.getElementoReferenciado());
			if(rec!=null)
			{
				if(logger.isDebugEnabled()) logger.debug(" se encontró el recurso .. se setea el href siguiente " + rec.getHref());
				asociarSession.setHref( rec.getHref() );
				
				if(rec.getFileList().length>0)
				{
					if(logger.isDebugEnabled()) logger.debug(" la lista de FileVO no esta vacia, agrego los fileVO a la lista de FIcheros de AsociarSession");
					asociarSession.getFicheros().addAll( Arrays.asList(rec.getFileList()));
				}
			}
		}
		
        asociarSession.setIdGrupo(id);
        
        form.setTipo(obtenerTipo(asociarSession));
    }

    private String obtenerTipo(AsociarSession sesion) {
    	String tipo = null;
    	// Chequea si es URL
    	if(sesion.getFicheros().size()==0 && sesion.getHref()!=null) {
    		// Validido si es URL
    		java.net.URL url = null;
    		try {
    			url = new java.net.URL(sesion.getHref());
    		} catch (MalformedURLException e) {
    			logger.debug(sesion.getHref() + " no es URL");
			}
    		if(url!=null) tipo = "URL";
    	}
    	// en caso de que no sea URL, comprueba embbed
    	if(tipo == null) {
    		if(sesion.getFicheros().size()==1) {
    			String href = sesion.getHref();
    			if(href!=null) {
    				String lastToken = href.split("/")[href.split("/").length-1];
    				String embbeded = null;
    				try {
    				embbeded= gs.getProperty("embedded.default.name");
    				if(lastToken.startsWith(embbeded)) {
    					tipo="Object";
    				}
    				}
    				catch (Exception e) {
    					logger.error("No se pudo recuperar de propiedades (spring.properties) el nombre del fichero para embeber objetos");
    				}
    				
    			}
    		}
    	}
    	if(tipo==null) {
    		tipo = "Archivos";
    	}
    	logger.debug("Tipo identificado : " + tipo);
    	return tipo;
    }

    private GrupoVO buscarGrupo(OdeVO ode, String id)
    {
		OrganizacionVO[] orgs= ode.getOrganizaciones();
		GrupoVO[] grupos;
		
		for(int i=0;i<orgs.length ;i++)
		{
			grupos=orgs[i].getGrupos();
			for(int j=0;j <grupos.length  ;j++)
			{
				if(id.equals(grupos[j].getIdentifier()))
				{
					return grupos[j];
				}
			}
		}
		return null;
    }

    private RecursoVO buscarRecurso(OdeVO ode,String id)
    {
    	RecursoVO[] recs= ode.getRecursos();
    	for(int i=0;i<recs.length ; i++)
    	{
    		if(recs[i].getIdentifier().equals(id))
    		{
    			return recs[i];
    		}
    	}
    	return null;
    }


    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.AsociarController#seleccionar(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.SeleccionarForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String seleccionar(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.SeleccionarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
    	String accion = form.getAction();
    	String tipo = form.getTipo();
    	String resultado = null;
    	
    	if (accion.equals(i18n.getString("portalempaquetado.Continuar")))
     	{
    		    if("Archivos".equals(tipo))
    		    {
    		    	resultado ="Archivos";
    		    }else if("Object".equals(tipo))
    		    {
    		    	resultado ="Object";
    		    }else  if( "URL".equals(tipo))
    		    {
    		    	resultado ="Url";
    		    }
    	}
    	else
    	{
    		resultado="Cancelar";
    	}
      return resultado;
    }

    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.AsociarController#selectActionObject(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.SelectActionObjectForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String selectActionObject(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.SelectActionObjectForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
    	String accion = form.getAction();
    	String resultado = null;
    	if (accion.equals(i18n.getString("portalempaquetado.Aceptar")))
     	{
    		   
    	if(form.getTexto()==null || form.getTexto().equals(""))
    	{
    		if(logger.isDebugEnabled()) logger.debug("el texto embebido es null");
    		throw new ValidatorException("{portalempaquetado.basico.asociar.embed.error.vacio}");
    		
    	}
    	 resultado="Aceptar";
    	
    	}
    	else
    	{
    		resultado="Cancelar";
    		form.setTipo("Object");
    	}
      return resultado;
    }







    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.AsociarController#crearObject(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.CrearObjectForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void crearObject(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.CrearObjectForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
        AsociarSession asociarSession =this.getAsociarSession(request);
        EmpaquetadorSession empaSesion= this.getEmpaquetadorSession(request);
        
        ArchivoVO archivoVO=null;
		try {
			archivoVO = this.getSrvEmpaquetadorBasicoService().crearObjetoEmbebido(empaSesion.getIdLocalizador(),form.getTexto());
		} catch (RemoteException e) {
			if (logger.isDebugEnabled()) logger.debug("error mientras se llamo al servicio " + e.getStackTrace());
			e.printStackTrace();
			this.saveErrorMessage(request, i18n.getString("portalempaquetado.basico.asociar.embed.error"));
		} catch (Exception e) {
			if (logger.isDebugEnabled()) logger.debug("error mientras se llamo al servicio " + e.getStackTrace());
			e.printStackTrace();
			this.saveErrorMessage(request, i18n.getString("portalempaquetado.basico.asociar.embed.error"));
		}
        if(archivoVO!=null)
        {
	        String href;
	        if(archivoVO.getCarpetaPadre()!=null && !archivoVO.getCarpetaPadre().equals(""))
	        {
	        	href=archivoVO.getCarpetaPadre() +"/"+archivoVO.getNombre();
	        }else{
	        	href=archivoVO.getNombre();
	        }
	        
	        
	        FileVO file= new FileVO();
	        file.setHref(href );
	        List list = new ArrayList();
	        list.add(file);
	         
	        asociarSession.setFicheros(list);
	        asociarSession.setHref(href);
        }
     }



    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.AsociarController#crearURL(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.CrearURLForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void crearURL(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.CrearURLForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	AsociarSession asociarSession= this.getAsociarSession(request);
    	
    	java.net.URL url = null;
    	try {
    		url = new java.net.URL(form.getUrl());
    	} catch (MalformedURLException e) {
    		logger.warn("No se ha podido validar la URL, añado protocolo http:// a la url introducida " + form.getUrl(),e);
    		try {
    			url = new java.net.URL("http://".concat(form.getUrl()));
    		} catch (MalformedURLException e2) {
    			logger.error("No se ha podido generar una URL valida con " + form.getUrl(),e2);
    			throw new ValidatorException("{gestor_basico.asociar.url.error}");
			}
		}
    	
    	asociarSession.setHref( url.toString());
    	asociarSession.setFicheros(new ArrayList());
     }

    /**
     * @see es.pode.empaquetador.presentacion.basico.asociar.AsociarController#selectActionURL(org.apache.struts.action.ActionMapping, es.pode.empaquetador.presentacion.basico.asociar.SelectActionURLForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String selectActionURL(ActionMapping mapping, es.pode.empaquetador.presentacion.basico.asociar.SelectActionURLForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	java.util.Locale locale = (Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
    	String accion = form.getAction();
    	String resultado = null;

    	if (accion.equals(i18n.getString("portalempaquetado.Aceptar")))
     	{
    		if(form.getUrl()==null || form.getUrl().equals(""))
        	{
        		if(logger.isDebugEnabled()) logger.debug("El texto del URL es null");
        		throw new ValidatorException("{portalempaquetado.basico.asociar.url.error.vacio}");
        	}
    		resultado="Aceptar";
    	}
    	else
    	{
    		resultado="Cancelar";
    		form.setTipo("URL");
    	}
      return resultado;
    }

	public void recuperaURL(ActionMapping mapping, RecuperaURLForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(this.getAsociarSession(request).getHref()!=null) {
			try {
				java.net.URL url = new java.net.URL(this.getAsociarSession(request).getHref());
				form.setUrl(this.getAsociarSession(request).getHref());
			} catch (java.net.MalformedURLException e) {
				logger.debug("El href "  + this.getAsociarSession(request).getHref() + " no es una URL");
			}
		}
	}

	@Override
	public void recuperarObject(ActionMapping mapping, RecuperarObjectForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
        AsociarSession asociarSession =this.getAsociarSession(request);
        EmpaquetadorSession empaSesion= this.getEmpaquetadorSession(request);
		
		String file = asociarSession.getHref();
		String idOde = empaSesion.getIdLocalizador(); 
		if(file!=null) {
			String contenido =this.getSrvEmpaquetadorBasicoService().editarObjetoEmbebido(idOde,file);
			form.setTexto(contenido);
		}
	}









}
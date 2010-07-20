/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.bajaCatalogadores;

import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO;
import es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService;
import es.pode.adminusuarios.negocio.servicios.ValidaBajaGrupoTrabajoVO;



/**
 * @see es.pode.administracion.presentacion.catalogacion.bajaCatalogadores.BajaCatalogadoresController
 */
public class BajaCatalogadoresControllerImpl extends BajaCatalogadoresController
{


	private static Logger log = Logger.getLogger(BajaCatalogadoresControllerImpl.class);



    /**
     * @see es.pode.administracion.presentacion.catalogacion.bajaCatalogadores.BajaCatalogadoresController#recogerCatalogadores(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.catalogacion.bajaCatalogadores.RecogerCatalogadoresForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recogerCatalogadores(ActionMapping mapping, es.pode.administracion.presentacion.catalogacion.bajaCatalogadores.RecogerCatalogadoresForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try {
		    
		    SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
	
		    Iterator iter = (form.getIds()).iterator();
		    GrupoTrabajoVO[] gruposTrabajo = new GrupoTrabajoVO[form.getIds().size()];
		    int i = 0;
		    String listaId = "";
		    
		    while (iter.hasNext()) 
		    {
		    	Long id = new Long((String) iter.next());
		    	listaId = listaId + id.toString() + " ";
	
		    	GrupoTrabajoVO grupoTrabajoVO = srvAdminUsuariosService.descripcionGrupoTrabajo(id);
		    	gruposTrabajo[i] = grupoTrabajoVO;
		    	i = i + 1;
		    }
		    
		    form.setListaId(listaId.trim());
		    form.setGruposTrabajo(gruposTrabajo);
		    
		    if ((listaId.length() == 0) || (gruposTrabajo.length == 0)) 
		    {
		    	saveErrorMessage(request, "errors.borrarGrupo");
		    }
	
		} 
    	catch (Exception e) 
    	{
		    log.error("Error: " + e);
		    throw new ValidatorException("{errors.borrarGrupo}");
		}
     }







    /**
     * @see es.pode.administracion.presentacion.catalogacion.bajaCatalogadores.BajaCatalogadoresController#bajaCatalogadores(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.catalogacion.bajaCatalogadores.BajaCatalogadoresForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void bajaCatalogadores(ActionMapping mapping, es.pode.administracion.presentacion.catalogacion.bajaCatalogadores.BajaCatalogadoresForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	String listaId = request.getParameter("listaId");
    	if(log.isDebugEnabled())log.debug("los ids de usuario que se quieren eliminar son " + listaId);
		Object[] objeto = listaId.split(" ");
		ResourceBundle ficheroRecursos = null;
		
		try {
		    
		    SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
		    ValidaBajaGrupoTrabajoVO validaBaja = srvAdminUsuariosService.bajaGrupoTrabajo(obtenerIds(objeto));
		    Locale locale = request.getLocale();
		    ficheroRecursos = this.getFicherRecursos(locale);
		    form.setDescripcionBaja(ficheroRecursos.getString(validaBaja.getDescripcion()));
		    form.setGruposTrabajoBorrados(validaBaja.getItemsDeleted());    
		} 
		catch (Exception e) 
		{
		    log.error("Se ha producido un error al eliminar el usuario " + e);
		    throw new ValidatorException("{errors.borrarUsuario}");
		}
     }
    
    


    
    private Long[] obtenerIds(Object[] id) 
    {	
		Long[] resultado = new Long[id.length];
		
		for (int i = 0; i < id.length; i++) 
		{
		    resultado[i] = new Long((String) id[i]);
		}
		
		return resultado;
	}
	
	private ResourceBundle getFicherRecursos(Locale locale) 
	{
		ResourceBundle ficheroRecursos = null;
		ficheroRecursos = ResourceBundle.getBundle("application-resources", locale);
		return ficheroRecursos;
    }








}
/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.listarCatalogadores;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO;
import es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService;



/**
 * @see es.pode.administracion.presentacion.catalogacion.listarCatalogadores.listarCatalogadoresController
 */
public class listarCatalogadoresControllerImpl extends listarCatalogadoresController
{



	private static Logger log = Logger.getLogger(listarCatalogadoresControllerImpl.class);


    /**
     * @see es.pode.administracion.presentacion.catalogacion.listarCatalogadores.listarCatalogadoresController#recuperarCatalogadores(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.catalogacion.listarCatalogadores.RecuperarCatalogadoresForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarCatalogadores(ActionMapping mapping, es.pode.administracion.presentacion.catalogacion.listarCatalogadores.RecuperarCatalogadoresForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
		
    	try {
    		
  		   
		    GrupoTrabajoVO[] grupoTrabajoVO = this.getSrvAdminUsuariosService().listarGruposTrabajo();
		    form.setGruposTrabajoAsArray(grupoTrabajoVO);
		    
		} 
    	catch (Exception e) 
    	{
		    log.error("Error: " + e);
		    throw new ValidatorException("{listarGrupos.error}");
		}
     }



    /**
     * @see es.pode.administracion.presentacion.catalogacion.listarCatalogadores.listarCatalogadoresController#obtenerIdentificadores(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.catalogacion.listarCatalogadores.ObtenerIdentificadoresForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String obtenerIdentificadores(ActionMapping mapping, es.pode.administracion.presentacion.catalogacion.listarCatalogadores.ObtenerIdentificadoresForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	List lista = ((FormularioListadoCatalogadoresEliminarCatalogadoresFormImpl) form).getIdentificadorRowSelection();
    	
		String resultado = "vacio";
		try 
		{
		    if (lista == null) 
		    {
		    	throw new ValidatorException("{errors.borrarGrupo.idNulo}");
		    } 
		    else 
		    {
		    	// Validamos los grupos seleccionados para comprobar si tienen usuarios asociados a ellos
		    	Long[] ids = new Long[lista.size()];
		    	Iterator iter = lista.iterator();
		    	SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
		    	int i = 0;
		    	
		    	while (iter.hasNext()) 
		    	{
	
				    Long id = new Long((String) iter.next());
				    GrupoTrabajoVO grupoTrabajoVO = srvAdminUsuariosService.descripcionGrupoTrabajo(id);
		
				    if ((srvAdminUsuariosService.obtenerUsuariosGrupoTrabajo(id)).booleanValue()) 
				    {
				    	log.error("el grupo tiene un usuario " + grupoTrabajoVO.getDescripcion());
				    	throw new ValidatorException("{errors.borrarGrupo.GrupoConUsuarios}");
				    }
				    else 
				    {
				    	ids[i] = id;
				    	i++;
				    }
		    	}
	
				
				form.setIds(lista);
				resultado = "identificadores";
				
		    }
		} 
		catch (ValidatorException validator) 
		{
		    log.error("Se ha producido la siguiente exception " + validator);
		    throw validator;
		} 
		catch (Exception e) 
		{
		    log.error("Se produce una excepcion ", e);
		    throw new ValidatorException("{errors.borrarGrupo.idNulo}");
		}
		return resultado;
    }







    /**
     * @see es.pode.administracion.presentacion.catalogacion.listarCatalogadores.listarCatalogadoresController#submit(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.catalogacion.listarCatalogadores.SubmitForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void submit(ActionMapping mapping, es.pode.administracion.presentacion.catalogacion.listarCatalogadores.SubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	form.setIds(form.getIds());
     }



}
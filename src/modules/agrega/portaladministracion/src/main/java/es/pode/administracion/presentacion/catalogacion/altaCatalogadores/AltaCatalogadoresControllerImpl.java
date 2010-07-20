/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.altaCatalogadores;

import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;

import es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO;
import es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService;


/**
 * @see es.pode.administracion.presentacion.catalogacion.altaCatalogadores.AltaCatalogadoresController
 */
public class AltaCatalogadoresControllerImpl extends AltaCatalogadoresController
{


	private static Logger log = Logger.getLogger(AltaCatalogadoresControllerImpl.class);



    /**
     * @see es.pode.administracion.presentacion.catalogacion.altaCatalogadores.AltaCatalogadoresController#altaCatalogadores(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.catalogacion.altaCatalogadores.AltaCatalogadoresForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void altaCatalogadores(ActionMapping mapping, es.pode.administracion.presentacion.catalogacion.altaCatalogadores.AltaCatalogadoresForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try
    	{
	    	String descripcion = form.getDescripcion();
	    	String nombre = form.getNombre();
	    	
	    	GrupoTrabajoVO grupoTrabajo = new GrupoTrabajoVO();
	    	SrvAdminUsuariosService srvAdminUsuariosService = this.getSrvAdminUsuariosService();
	    	
	    	Pattern mask = Pattern.compile("[^\\¿\\?\\¡\\!\\>\\#\\&\\<\\@\\$\\/\\\'\\\"]+");
	        Matcher matcher = null;
	    	
	    	if ((nombre == null) || (nombre.length() == 0)) 
	    	{
	    	    if(log.isDebugEnabled())log.debug("el nombre introducido es nulo");
	    	    throw new ValidatorException("{errors.altagrupo.descripcion}");
	    		
	    	}
	    	else 
	    	{	
	    		matcher = mask.matcher(nombre);
	    	    if (!matcher.matches()) {
	    	    	if(log.isDebugEnabled())log.debug("nombre caracter ilegal");
	    	    	throw new ValidatorException("{errors.altagrupo.descripcion.caracterIlegal}");
	    	    }
	    	    
	    	    matcher = mask.matcher(descripcion);
	    	    if (!matcher.matches()) {
	    	    	if(log.isDebugEnabled())log.debug("descripcion caracter ilegal");
	    	    	throw new ValidatorException("{errors.altaGrupoTrabajo.caracterIlegal.descripcion}");
	    	    }
	    		
	    	    if ((srvAdminUsuariosService.existeNombreTrabajo(nombre, Long.valueOf("-1"))).booleanValue()) 
	    	    {
	    	    	if(log.isDebugEnabled())log.debug("ya existe la descripcion");
	    	    	throw new ValidatorException("{errors.altagrupo.descripcionExistente}");
	    	    } 
	    	    else 
	    	    {
	    	    	grupoTrabajo.setNombre(nombre);
	    	    	grupoTrabajo.setDescripcion(descripcion);
	    	    	
	    	    	Long identificador = srvAdminUsuariosService.altaGrupoTrabajo(grupoTrabajo);
	    			form.setIdModificado(identificador);
	    	    }
	    	}
    	}
    	catch (ValidatorException e) 
    	{
    		throw e;
    	} 
    	catch (Exception e) 
    	{
    		log.error("Error: " + e);
    		throw new ValidatorException("{errors.altagrupo}");
    	}
    	
     }

  


}





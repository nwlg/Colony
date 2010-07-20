/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.modificarCatalogadores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO;



/**
 * @see es.pode.administracion.presentacion.catalogacion.modificarCatalogadores.modificarCatalogadoresController
 */
public class modificarCatalogadoresControllerImpl extends modificarCatalogadoresController
{


	private static Logger log = Logger.getLogger(modificarCatalogadoresControllerImpl.class);



    /**
     * @see es.pode.administracion.presentacion.catalogacion.modificarCatalogadores.modificarCatalogadoresController#cargarDescripcion(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.catalogacion.modificarCatalogadores.CargarDescripcionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void cargarDescripcion(ActionMapping mapping, es.pode.administracion.presentacion.catalogacion.modificarCatalogadores.CargarDescripcionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try {
  		   
		    Long id = form.getId();
		    GrupoTrabajoVO grupoTrabajo = this.getSrvAdminUsuariosService().descripcionGrupoTrabajo(id);
		    log("Obtengo el grupoTrabajoVO seleccionado");
		    form.setNombre(grupoTrabajo.getNombre());
		    form.setDescripcion(grupoTrabajo.getDescripcion());
		    form.setId(grupoTrabajo.getIdentificador());
		} catch (Exception e) {
		    log.error("Error: " + e);
		    throw new ValidatorException("{modificarGrupo.error}");
		}
     }





    /**
     * @see es.pode.administracion.presentacion.catalogacion.modificarCatalogadores.modificarCatalogadoresController#modificarCatalogadores(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.catalogacion.modificarCatalogadores.ModificarCatalogadoresForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void modificarCatalogadores(ActionMapping mapping, es.pode.administracion.presentacion.catalogacion.modificarCatalogadores.ModificarCatalogadoresForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try 
    	{
		    String nombre = form.getNombre();
		    String descripcion = form.getDescripcion();
		    
		    log("El valor del nombre es " + nombre);
		    
		    //VALIDACION DE CARACTERES INCORRECTOS
		    Pattern mask = Pattern.compile("[^\\¿\\?\\¡\\!\\>\\#\\&\\<\\@\\$\\/\\\'\\\"]+");
		    Matcher matcher = null;
		    
		    matcher = mask.matcher(nombre);
		    if (!matcher.matches()) {
		    	log("nombre caracter ilegal");
		    	throw new ValidatorException("{errors.altagrupo.descripcion.caracterIlegal}");
		    }
		    
		    matcher = mask.matcher(descripcion);
		    if (!matcher.matches()) {
		    	log("nombre caracter ilegal");
		    	throw new ValidatorException("{errors.altaGrupoTrabajo.caracterIlegal.descripcion}");
		    }
		    
		    Long id = Long.valueOf(request.getParameter("id"));
		    log("Chequeo si el nombre ya esta asociado a otro grupo de trabajo");
		    GrupoTrabajoVO grupoTrabajoVO = this.getSrvAdminUsuariosService().descripcionGrupoTrabajo(id);
		    
		    if ((this.getSrvAdminUsuariosService().existeNombreTrabajo(nombre, id)).booleanValue()) 
		    {
		    	log("Ya existe un grupo en el sistema con este nombre");
		    	throw new ValidatorException("{errors.modificaciongrupo.descripcionExistente}");
		    }
		    
		    if (descripcion.length() > 0) 
		    {
		    	grupoTrabajoVO.setNombre(nombre);
		    	grupoTrabajoVO.setDescripcion(descripcion);
		    	
		    	Long identificador=this.getSrvAdminUsuariosService().modificarGrupoTrabajo(grupoTrabajoVO);
		    	log("llamamos al servicio para modificar el grupo trabajo");
		    	form.setIdModificado(identificador);
		    } 
		    else 
		    {
		    	log("La descripcion introducida es nula");
		    	throw new ValidatorException("{errors.modificaciongrupo.descripcion}");
		    }
		    form.setResultado("gruposTrabajo.modificar.OK");
		    
		} 
    	catch (ValidatorException validator) 
    	{
    		form.setResultado("gruposTrabajo.modificar.FALLO");
		    throw validator;
		} 
    	catch (Exception e) 
    	{
		    log.error("Error: " + e);
		    form.setResultado("gruposTrabajo.modificar.FALLO");
		    throw new ValidatorException("{modificarGrupo.errorRoles}");
		}
     }

    private void log(Object obj) {
    	
		if (log.isDebugEnabled())
		    log.debug(obj);
    }







}
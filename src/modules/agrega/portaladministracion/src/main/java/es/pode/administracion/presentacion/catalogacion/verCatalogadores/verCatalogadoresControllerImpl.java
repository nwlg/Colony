/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.verCatalogadores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO;



/**
 * @see es.pode.administracion.presentacion.catalogacion.verCatalogadores.verCatalogadoresController
 */
public class verCatalogadoresControllerImpl extends verCatalogadoresController
{


	private static Logger log = Logger.getLogger(verCatalogadoresControllerImpl.class);



    /**
     * @see es.pode.administracion.presentacion.catalogacion.verCatalogadores.verCatalogadoresController#recuperarDescripcion(org.apache.struts.action.ActionMapping, es.pode.administracion.presentacion.catalogacion.verCatalogadores.RecuperarDescripcionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void recuperarDescripcion(ActionMapping mapping, es.pode.administracion.presentacion.catalogacion.verCatalogadores.RecuperarDescripcionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	try {
			
			Long id = form.getId();
			
			GrupoTrabajoVO grupoTrabajo = this.getSrvAdminUsuariosService().descripcionGrupoTrabajo(id);
			
			form.setNombre(grupoTrabajo.getNombre());
			form.setDescripcion(grupoTrabajo.getDescripcion());
			form.setId(id);
			
			
			
			
		} 
    	catch (Exception e) 
    	{
			log.error("Error: " + e);
			throw new ValidatorException("{verGrupo.error}");
		}
     }
    
   







}
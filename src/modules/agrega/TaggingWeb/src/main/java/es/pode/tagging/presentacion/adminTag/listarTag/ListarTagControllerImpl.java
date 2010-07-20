/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.tagging.presentacion.adminTag.listarTag;

import java.util.Locale;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.tagging.negocio.servicios.TagVO;
import es.pode.tagging.presentacion.TaggingSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * @see es.pode.tagging.presentacion.adminTag.listarTag.ListarTagController
 */
public class ListarTagControllerImpl extends ListarTagController
{


	protected static Logger logger = Logger.getLogger(ListarTagControllerImpl.class); 



    /**
     * @see es.pode.tagging.presentacion.adminTag.listarTag.ListarTagController#obtenerTags(org.apache.struts.action.ActionMapping, es.pode.tagging.presentacion.adminTag.listarTag.ObtenerTagsForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerTags(ActionMapping mapping, es.pode.tagging.presentacion.adminTag.listarTag.ObtenerTagsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	TaggingSession taggingSession = this.getTaggingSession(request);
    	taggingSession.setTagPaginacion("");
    	
    	TagVO[] tags = this.getSrvTaggingServer().obtenerTodosTags();
    	form.setTagsAsArray(tags);
    	
    	//cuando volvemos del modificar hay que comprobar si el tag ha sido cambiado para marcar la fila de la tabla
    	String oldTag = form.getTagOld();
    	String newTag = form.getNewTag();
    	if(oldTag!=null && oldTag.equals(newTag))// no hay cambio no marcamos linea en amarillo
    		form.setNewTag("");
     }

	@Override
	
	public void eliminar(ActionMapping mapping, EliminarForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		TaggingSession taggingSession =  this.getTaggingSession(request);
		String[] tagsEliminar = taggingSession.getTagsEliminar();
		if(tagsEliminar!=null && tagsEliminar.length > 0){
			logger.debug("Eliminando tags" );
			this.getSrvTaggingServer().eliminarTags(tagsEliminar);
		}
	}

	@Override
	public void submit(ActionMapping mapping, SubmitForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String[] tags = form.getTagRowSelectionAsArray();
		if(tags!=null && tags.length > 0){
			form.setTagsEliminarAsArray(tags); //Para mostrar los tag a eliminar en la pantalla de confirmación
			TaggingSession taggingSession= this.getTaggingSession(request);
			//guardamos los tag a borrar en sesion para al pasar la pantalla de confirmación 
			//poder borrarlos
			taggingSession.setTagsEliminar(tags);
		}
		else{
			throw new ValidatorException("{tagging.listar.eliminar.exception}");
		}
	}

	@Override
	public String submitConfirmacion(ActionMapping mapping, SubmitConfirmacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String result = null;
		MessageResources resources = MessageResources.getMessageResources("application-resources");
		String action = form.getAccion();
		if(resources.getMessage((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE),"tagging.listar.eliminar.confirmacion.si").equals(action)) {
			result = "Aceptar";
		} else {
			result = "Cancelar";
		}

		return result;
	}









}
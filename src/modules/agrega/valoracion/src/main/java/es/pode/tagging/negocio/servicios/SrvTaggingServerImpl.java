/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.tagging.negocio.servicios;

import java.util.List;
import es.pode.tagging.negocio.dominio.IdUsuarioTagCriteria;
import es.pode.tagging.negocio.dominio.TagCriteria;
import es.pode.tagging.negocio.dominio.Tagging;
import es.pode.tagging.negocio.dominio.TaggingDao;


/**
 * @see es.pode.tagging.negocio.servicios.SrvTaggingServer
 */

public class SrvTaggingServerImpl
    extends es.pode.tagging.negocio.servicios.SrvTaggingServerBase
{

	/**
     * Obtiene las etiquetas utilizadas por un usuario dado.
     * @param idUsuario El identificador del usuario a consultar.     
     * @return 	se retorna un array que contiene principalmente las etiquetas de un usuario
     * @throws Exception
     * 
     */
    protected TagVO[] handleObtenerTagsDeUsuario(java.lang.String idUsuario)
        throws java.lang.Exception
    {
    	if(logger.isDebugEnabled()) logger.debug("Obteniendo los tags asociados al usuario con identificador ["+idUsuario+"]");
    	//Creamos el criterio por el que buscar los tags
    	
    	
    	List tagsLista= this.getTaggingDao().obtenerTagsDistintosDeUsuario(this.getTaggingDao().TRANSFORM_TAGVO, idUsuario);
    	TagVO[] tags=(TagVO[])tagsLista.toArray(new TagVO[tagsLista.size()]);
    	
    	if(tags!=null && tags.length>0)
    	{
    		if(logger.isDebugEnabled()) logger.debug("Se han obtenido ["+tags.length+"] tags");
    		return (tags);
    	}
    	else
    	{
    		logger.debug("No hay tags en la base de datos de Agrega");
//    		return (new String[0]);
    		return (new TagVO[0]);
    	}
    	
    }

    /**
     * Obtiene los odes que un usuario a taggeado con una etiqueta concreta.
     * @param tag La etiqueta que el usuario ha utilizado para etiquetar el ODE.
     * @param idUsuario El identificador del usuario para el cual consultar los ODEs.     
     * @return 	se retorna un array que contiene principalmente las odes de un usuario etiquetados por una etiqueta concreta
     * @throws Exception
     * 
     */
    protected es.pode.tagging.negocio.servicios.TaggingVO[] handleObtenerOdesDeTagYUsuario(java.lang.String tag, java.lang.String idUsuario)
        throws java.lang.Exception
    {
    	if(logger.isDebugEnabled()) logger.debug("Obteniendo los odes asociados al usuario con identificador ["+idUsuario+"] y al tag ["+tag+"]");
    	//Creamos el criterio por el que buscar los tags
    	
    	IdUsuarioTagCriteria criterio = new IdUsuarioTagCriteria();
    	criterio.setIdUsuario(idUsuario);
    	criterio.setTag(tag);
    	
    	//Buscamos los tags asociados a un usuario	
    	List odesLista= this.getTaggingDao().obtenerOdesPorUsuarioYTag(this.getTaggingDao().TRANSFORM_TAGGINGVO, criterio);
    	TaggingVO[] tagsVO=(TaggingVO[])odesLista.toArray(new TaggingVO[0]);
    	
    	if(tagsVO!=null && tagsVO.length>0)
    	{
    		if(logger.isDebugEnabled()) logger.debug("Se han obtenido ["+tagsVO.length+"] odes");
    		return (tagsVO);
    	}
    	else
    	{
    		logger.debug("No hay odes en la base de datos para el usuario ["+idUsuario+"]y al tag ["+tag+"]");
    		return (new TaggingVO[0]);
    	}
    }

    /**
     * Obtiene todas las etiquetas utilizadas en el nodo de Agrega.     
     * @return 	se retorna un array que contiene principalmente todas las etiquetas utilizadas en el nodo de Agrega
     * @throws Exception
     * 
     */
    protected TagVO[] handleObtenerTodosTags()
        throws java.lang.Exception
    {
    	if (logger.isDebugEnabled()) logger.debug("Buscando todos los tags de Agrega");
    	
    	List tagsLista = this.getTaggingDao().obtenerTodosTagsDistintos(this.getTaggingDao().TRANSFORM_TAGVO);
    	TagVO[] tags=(TagVO[])tagsLista.toArray(new TagVO[tagsLista.size()]);
    	
    	if(tags!=null && tags.length>0)
    	{
    		if(logger.isDebugEnabled()) logger.debug("Se han obtenido ["+tags.length+"] tags");
    		return (tags);
    	}
    	else
    	{
    		logger.debug("No hay tags en la base de datos de Agrega");
    		return (new TagVO[0]);
//    		return (new String[0]);
    	}
    	
    }

    /**
     * Obtiene los odes asociados a una etiqueta cualquiera de la plataforma.
     * @param tag La etiqueta para la cual se quieren consultar los ODEs asociados.  
     * @return 	se retorna un array que contiene principalmente las odes etiquetados por una etiqueta concreta
     * @throws Exception
     * 
     */
    protected es.pode.tagging.negocio.servicios.TaggingVO[] handleObtenerOdesDeTag(java.lang.String tag)
        throws java.lang.Exception
    {
    	if(logger.isDebugEnabled()) logger.debug("Obteniendo los odes asociados al tag ["+tag+"]");
    	//Creamos el criterio por el que buscar los tags
    	
    	TagCriteria criterio = new TagCriteria();
    	criterio.setTag(tag);
    	
    	//Buscamos los odes asociados a un tag
    	List odesLista= this.getTaggingDao().obtenerOdesPorTag(this.getTaggingDao().TRANSFORM_TAGGINGVO, criterio);
    	TaggingVO[] tagsVO=(TaggingVO[])odesLista.toArray(new TaggingVO[0]);
    	
    	if(tagsVO!=null && tagsVO.length>0)
    	{
    		if(logger.isDebugEnabled()) logger.debug("Se han obtenido ["+tagsVO.length+"] odes");
    		return (tagsVO);
    	}
    	else
    	{
    		logger.debug("No hay odes en la base de datos para el tag ["+tag+"]");
    		return (new TaggingVO[0]);
    	}
    }


    /**
     * Introduce en la base de datos para un usuario una o varias entradas que contiene el ODE etiquetado y su etiqueta.
     * @param idOde El identificador del ODE que ha sido etiquetado.
     * @param titulo El título del ODE que ha sido etiquetado.
     * @param idiomaCat El idioma de catalogación del ODE etiquetado.
     * @param tags El listado de etiquetas asociadas al ODE.
     * @param idUsuario El identificador del usuario que ha etiquetado el ODE.   
     * @throws Exception
     * 
     */
	protected void handleIntroducirTags(String idOde, String titulo, String idiomaCat, String[] tags, String idUsuario) throws Exception {
		if (logger.isDebugEnabled()) logger.debug("Introducimos los tags con valores idODE ["+idOde+"], idUsuario ["+idUsuario+"]");
		try
		{
			TaggingDao taggingDao = this.getTaggingDao();
			for (int i= 0; i< tags.length; i++){
				String tag= tags[i];
				Tagging tagging = taggingDao.create(idOde, titulo, idiomaCat, tag, idUsuario);
				logger.debug("Se ha insertado el tag [" +tag+ "]");
			}
	
			
		} catch (Exception e)
		{
			logger.error("Error al insertar el comentario", e);
		}
		
	}

	/**
     * Modifica una etiqueta.
     * @param oldTag La etiqueta que el usuario administrador va a modificar.
     * @param newTag El nuevo nombre de la etiqueta que el administrador va a introducir.     
     * @return 	se retorna 'true' si la modificación se ha realizado correctamente y 'false' si no se ha podido modificar
     * @throws Exception
     * 
     */
	protected boolean handleModificarTag(String oldTag, String newTag) throws Exception {

		boolean modificado= false;

		try{
			TaggingVO[] taggingVO= this.obtenerOdesDeTag(oldTag);
			for (int i= 0; i< taggingVO.length; i++){
				
				Tagging tagging= this.getTaggingDao().load(taggingVO[i].getId());
				taggingVO[i].setTag(newTag);
				this.getTaggingDao().fromTaggingVO(taggingVO[i], tagging);
				this.getTaggingDao().update(tagging);	
			}
			modificado= true;
		}
		catch (Exception e){
			logger.error("Error al modificar el tag "+ oldTag, e);
			modificado= false;
		}
		
		return modificado;
	}

	/**
     * Modifica una etiqueta de un usuario concreto.
     * @param oldTag La etiqueta que un usuario va a modificar.
     * @param newTag El nuevo nombre de la etiqueta que el usuario va a introducir.
     * @param idUsuario El identificador del usuario propietario de la etiqueta a modificar.
     * @return 	se retorna 'true' si la modificación se ha realizado correctamente y 'false' si no se ha podido modificar
     * @throws Exception
     * 
     */
	protected boolean handleModificarTagDeUsuario(String oldTag, String newTag, String idUsuario) throws Exception {
		
		boolean modificado= false;

		try{
			TaggingVO[] taggingVO= this.obtenerOdesDeTagYUsuario(oldTag, idUsuario);
			for (int i= 0; i< taggingVO.length; i++){
				
				Tagging tagging= this.getTaggingDao().load(taggingVO[i].getId());
				taggingVO[i].setTag(newTag);
				this.getTaggingDao().fromTaggingVO(taggingVO[i], tagging);
				this.getTaggingDao().update(tagging);	
			}
			modificado= true;
		}
		catch (Exception e){
			logger.error("Error al modificar el tag "+ oldTag, e);
			modificado= false;
		}
		
		return modificado;
	}

	/**
     * Elimina una o varias etiquetas del nodo.
     * @param tagsABorrar Lista de etiquetas a eliminar por el administrador.
     * @return 	se retorna 'true' si el borrado se ha realizado correctamente y 'false' si no se ha podido realizar
     * @throws Exception
     * 
     */
	protected boolean handleEliminarTags(String[] tagsABorrar) throws Exception {

		boolean borrado= false;
		
		if (logger.isDebugEnabled()) logger.debug("Se van a eliminar ["+tagsABorrar.length+"] tags"); 
		try {
			for(int i=0; tagsABorrar != null && i<tagsABorrar.length; i++){	
				Tagging tag;

				TaggingVO[] taggingV0= this.obtenerOdesDeTag(tagsABorrar[i]);
					
				for (int j= 0; j<taggingV0.length; j++){
					tag= this.getTaggingDao().load(taggingV0[j].getId());
						
					if (tag != null){
						logger.debug("Comprobacion de que tag es distinto de null");						
							
						//Eliminamos el tag				
						try {
							this.getTaggingDao().remove(tag.getId());
							borrado= true;
							logger.debug("Tag tiene un valor de ["+tag+"]");
							logger.debug("Tag tiene un valor de identificador de id ["+tag.getId()+"]");
						} catch (Exception e) {
							logger.error("Error eliminando el tag con id["+tag.getId()+"]");
							borrado= false;
						}
							
					}
				}			
			}	
		}catch (Exception e) {
				logger.error("Error al recuperar de la base de datos el tag");	
				borrado= false;
		}

		return borrado;
	}

	/**
     * Elimina una o varias etiquetas de un usuario concreto.
     * @param tagsABorrar Lista de etiquetas a eliminar de un usuario concreto.
     * @param idUsuario El identificador del usuario que va a realizar el borrado de sus etiquetas
     * @return 	se retorna 'true' si el borrado se ha realizado correctamente y 'false' si no se ha podido realizar
     * @throws Exception
     * 
     */
	protected boolean handleEliminarTagsDeUsuario(String[] tagsABorrar, String idUsuario) throws Exception {
		boolean borrado= false;
		
		if (logger.isDebugEnabled()) logger.debug("Se van a eliminar ["+tagsABorrar.length+"] tags"); 
		try {
			for(int i=0; tagsABorrar != null && i<tagsABorrar.length; i++){	
				Tagging tag;

				TaggingVO[] taggingV0= this.obtenerOdesDeTagYUsuario(tagsABorrar[i], idUsuario);
					
				for (int j= 0; j<taggingV0.length; j++){
					tag= this.getTaggingDao().load(taggingV0[j].getId());
						
					if (tag != null){
						logger.debug("Comprobacion de que tag es distinto de null");						
							
						//Eliminamos el tag				
						try {
							this.getTaggingDao().remove(tag.getId());
							borrado= true;
							logger.debug("Tag tiene un valor de ["+tag+"]");
							logger.debug("Tag tiene un valor de identificador de id ["+tag.getId()+"]");
						} catch (Exception e) {
							logger.error("Error eliminando el tag con id["+tag.getId()+"]");
							borrado= false;
						}
							
					}
				}			
			}	
		}catch (Exception e) {
				logger.error("Error al recuperar de la base de datos el tag");	
				borrado= false;
		}

		return borrado;
	}

	/**
     * Obtiene la lista de etiquetas asociadas a un ODE concreto.
     * @param idOde Identificador del ODE para el cual se quieren obtener las etiquetas.
     * @return 	se retorna una lista de etiquetas asociadas al ODE deseado
     * @throws Exception
     * 
     */
	protected String[] handleObtenerTagsDeOde(String idOde) throws Exception {
		// TODO Auto-generated method stub
		if(logger.isDebugEnabled()) logger.debug("Obteniendo los tags asociados al ODE con identificador ["+idOde+"]");
   	
    	
    	List tagsLista= this.getTaggingDao().obtenerTagsDistintosDeOde(this.getTaggingDao().TRANSFORM_NONE, idOde);
    	String[] tags=(String[])tagsLista.toArray(new String[tagsLista.size()]);
    	
    	if(tags!=null && tags.length>0)
    	{
    		if(logger.isDebugEnabled()) logger.debug("Se han obtenido ["+tags.length+"] tags");
    		return (tags);
    	}
    	else
    	{
    		logger.debug("No hay tags en la base de datos de Agrega");
    		return (new String[0]);
    	}
	}

	

}
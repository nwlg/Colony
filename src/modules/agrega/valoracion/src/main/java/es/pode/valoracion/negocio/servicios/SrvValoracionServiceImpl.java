/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.valoracion.negocio.servicios;


import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;

import java.util.List;

import org.apache.log4j.Logger;

import es.pode.publicacion.negocio.servicios.ReindexarODEResultadoVO;
import es.pode.valoracion.negocio.dominio.Comentario;
import es.pode.valoracion.negocio.dominio.ComentarioDao;
import es.pode.valoracion.negocio.dominio.IdODEFechaCriteria;
import es.pode.valoracion.negocio.dominio.IdODEFechaDesdeHastaCriteria;
import es.pode.valoracion.negocio.dominio.Valoracion;
import es.pode.valoracion.negocio.dominio.ValoracionDao;
import es.pode.valoracion.negocio.servicios.auditoria.ValoracionODEVO;



/**
 * @see es.pode.valoracion.negocio.servicios.SrvValoracionService
 */

public class SrvValoracionServiceImpl
    extends es.pode.valoracion.negocio.servicios.SrvValoracionServiceBase
{
	public final static String SIN_ERRORES = "0.0";
	public final static String ERROR_PUBLICACION = "11.1";

	private static Logger logger = Logger.getLogger(SrvValoracionServiceImpl.class);
	



	/**
     * Calcula la valoración media correspondiente a un ODE. 
     * La media se halla con cada valoración existente (distinta de cero) en todos los comentarios asociados al ODE. 
     * Se permite que el usuario al introducir el comentario no lo valore; sin embargo ese comentario
     * no se tiene en cuenta a la hora de realizar la media de la valoración
     * @param idODE El identificador correspondiente al ODE.     
     * @return 	se retorna el valor medio de la valoracion
     * @throws Exception
     * 
     */
    protected java.lang.Float handleConsultarValoracion(java.lang.String idODE)
        throws java.lang.Exception
    {
    	IdODEFechaCriteria criterio=crearCriterioBusqueda(idODE);
    	//Buscamos las valoraciones asociadas a un ODE
    	List valoracionesLista = this.getValoracionDao().buscarValoracionesPorCriterioODE(this.getValoracionDao().TRANSFORM_VALORACIONVO, criterio);
    	ValoracionVO[] valoracionesArray = (ValoracionVO[])valoracionesLista.toArray(new ValoracionVO[0]);    	
    	Float[] valoraciones=new Float[valoracionesArray.length];
    	if(valoraciones.length>0){
    		return calcularValoracion(valoracionesArray, valoraciones);   		
    	}else{
    		return new Float(0.0);
    	}
    	
    	
    }

	/**
     * Este metodo devuelve la valoracion que ha tenido un ODE en un periodo de tiempo dado.
     * @param idODE El identificador correspondiente al ODE.     
     * @param fechaDesde Fecha desde del periodo de tiempo en el que se esta interesado.  
     * @param fechaHasta Fecha hasta del periodo de actividad en el que se esta interesado.
     * @return 	se retorna el valor medio de la valoracion para el periodo dado
     * @throws Exception
     * 
     */
	protected Float handleConsultaValoracionDesdeHasta(String idODE, Calendar fechaDesde, Calendar fechaHasta) throws Exception {
		if (logger.isDebugEnabled()) logger.debug("Buscando las valoraciones del ode con identificador ["+idODE+"], fechaDesde ["+fechaDesde+"] y fechaHasta ["+fechaHasta+"]");
    	IdODEFechaDesdeHastaCriteria criterio= new IdODEFechaDesdeHastaCriteria();
    	criterio.setIdODE(idODE);
    	criterio.setFechaDesde(fechaDesde);
    	criterio.setFechaHasta(fechaHasta);
    	//Buscamos las valoraciones asociadas a un ODE
    	List valoracionesLista = this.getValoracionDao().buscarValoracionesPorCriterioODEDesdeHasta(this.getValoracionDao().TRANSFORM_VALORACIONVO, criterio);
    	
    	ValoracionVO[] valoracionesArray=(ValoracionVO[])valoracionesLista.toArray(new ValoracionVO[0]);
    	Float[] valoraciones=new Float[valoracionesArray.length];
    	if(valoraciones.length>0){
    		return calcularValoracion(valoracionesArray, valoraciones);    		
    	}else{
    		return new Float(0.0);
    	}
		
	}

	private Float calcularValoracion(ValoracionVO[] valoracionesArray, Float[] valoraciones) {
		Float media=new Float(0.0);
		float media_float=media.floatValue();    	
		float num=valoracionesArray.length;
		for (int i = 0; valoracionesArray!=null && i < valoracionesArray.length; i++) {
			if(valoracionesArray[i].getValoracion().floatValue()>=0){  // si hay valoracion, la tengo en cuenta para la nota final
				valoraciones[i]=valoracionesArray[i].getValoracion();
				media_float=media_float + valoraciones[i].floatValue();
			}else{  // si no hay valoracion (valor -1) no lo tengo en cuenta para el total de las valoraciones para calcular la media
				num=num-1;
			}
		}
		if (num == 0)  // si todas las valoraciones que tiene este ODE no tienen nota, tengo que devolver (-1) (sin valorar).
			return new Float(-1.0);
		else  // si existen valoraciones del ODE, las tengo en cuenta para la media.
			return new Float(media_float/num);
	}
	
	private Float calcularValoracion(Valoracion[] valoracionesArray, Float[] valoraciones) {
		Float media=new Float(0.0);
		float media_float=media.floatValue();    	
		float num=valoracionesArray.length;
		for (int i = 0; valoracionesArray!=null && i < valoracionesArray.length; i++) {
			if(valoracionesArray[i].getValoracion().floatValue()>=0){  // si hay valoracion, la tengo en cuenta para la nota final
				valoraciones[i]=valoracionesArray[i].getValoracion();
				media_float=media_float + valoraciones[i].floatValue();
			}else{  // si no hay valoracion (valor -1) no lo tengo en cuenta para el total de las valoraciones para calcular la media
				num=num-1;
			}
		}
		if (num == 0)  // si todas las valoraciones que tiene este ODE no tienen nota, tengo que devolver (-1) (sin valorar).
			return new Float(-1.0);
		else  // si existen valoraciones del ODE, las tengo en cuenta para la media.
			return new Float(media_float/num);
	}	

    /**
     * Este metodo recalcula la valoracion asociada al ODE del que se pasa el identificador.
	 * La finalidad del recalculo es la reindexacion del ODE con esta iformacion.
     * @param idODE El identificador correspondiente al ODE.     
     * @return Devuelve un codigo con el resultado de la operacion.
     * @throws Exception
     */
    protected String handleRecalcularValoracionODE(java.lang.String idODE)
        throws java.lang.Exception
    {
    	Float valoracion=this.handleConsultarValoracion(idODE);
    	ReindexarODEResultadoVO retorno = this.getSrvPublicacionService().reindexarODEPublicado(idODE, valoracion);
    	
    	//Revisar si la accion se ha realizado correctamente ó no
    	if(retorno.getCode() == 0)
    		return SIN_ERRORES;
    	else
    	{
    		logger.error("Error reindexando ode con identificador ["+idODE+"] y valoracion ["+valoracion+"]:Codigo["+retorno.getCode()+"] y causa ["+retorno.getMensaje()+"]");
    		return ERROR_PUBLICACION;
    	}    	
    }

    /**
     * Obtiene todos los comentarios asociados a un ODE.
     * @param idODE El identificador correspondiente al ODE.     
     * @return se retorna la lista de todos los comentarios asociados a un ODE.
     * @throws Exception
     * 
     */
    protected es.pode.valoracion.negocio.servicios.ComentarioVO[] handleObtenerComentarios(java.lang.String idODE)
        throws java.lang.Exception
    {
    	if(logger.isDebugEnabled()) logger.debug("Obteniendo los comentarios asociados al ode con identificador ["+idODE+"]");
    	//Creamos el criterio por el que buscar el ODE
    	IdODEFechaCriteria criterio=crearCriterioBusqueda(idODE);
    	//Buscamos los comentarios asociados a un ODE
    	List comentariosLista=this.getComentarioDao().buscarComentariosPorCriterioODE(this.getComentarioDao().TRANSFORM_COMENTARIOVO, criterio);
    	ComentarioVO[] comentariosVO=(ComentarioVO[])comentariosLista.toArray(new ComentarioVO[0]);
    	
    	if(comentariosVO!=null && comentariosVO.length>0)
    	{
    		if(logger.isDebugEnabled()) logger.debug("Se han obtenido ["+comentariosVO.length+"] comentarios");
    		return (comentariosVO);
    	}
    	else
    	{
    		logger.debug("No hay comentarios en la base de datos");
    		return (new ComentarioVO[0]);
    	}
    	
    }
    
    /**
     * Este metodo elimina los comentarios correspondientes a los identificadores que le pasan.
     * @param id Array de identificadores de los comentarios que se han de eliminar.     
     * @return Devuelve el resultado de la operacion.
     * @throws Exception
     * 
     */
	protected String handleEliminarComentarios(Long[] id) throws Exception {		
		if (logger.isDebugEnabled()) logger.debug("Eliminando ["+id.length+"] comentarios"); 
		
		HashSet idsODE = new HashSet();
		
//		Recorremos el vector que contiene los ids de los comentarios a eliminar y los vamos almacenando en una lista
		for(int i=0; id != null && i<id.length; i++){	
			Comentario comment;
			try {
				comment = this.getComentarioDao().load(id[i]);
				if (comment != null){
					logger.debug("Comprobacion de que comment es distinto de null");						
					//Guardamos el identificadorODE del comentario que se quiere eliminar
					try {
						idsODE.add(comment.getIdODE());
					} catch (Exception e) {
						logger.error("Error añadiendo el idODE["+comment.getIdODE()+"] al collection idsODE");						
					}
					//Eliminamos el comentario				
					try {
						this.getComentarioDao().remove(comment.getId());
						logger.debug("Comment tiene un valor de ["+comment+"]");
						logger.debug("Comment tiene un valor de identificador de id ["+comment.getId()+"]");
					} catch (Exception e) {
						logger.error("Error eliminando el comentario con id["+comment.getId()+"]");						
					}
					
				}	
			} catch (Exception e) {
				logger.error("Error al recuperar de la base de datos el comentario");				
			}
					
		}	
		
		logger.debug("idsODE contiene ["+idsODE.toString()+"]");
		logger.debug("idsODE tiene un tamaño de ["+idsODE.size()+"]");	

		return SIN_ERRORES;	
	}

	private IdODEFechaCriteria crearCriterioBusqueda(java.lang.String idODE){
    	
    	IdODEFechaCriteria criterio = new IdODEFechaCriteria();
    	criterio.setIdODE(idODE);
    	criterio.setFecha(null);
    	
    	return criterio;
    	
    }
	

	/**
     * Este método devuelve la información del ODE  que le pasan con la información de valoración para el periodo en el que se está interesado.
     * @param idODE El identificador correspondiente al ODE.
     * @param fechaDesde Fecha desde la que se está interesado.
     * @param fechaHasta Fecha hasta la que se está interesado.
     * @return 	Devuelve un ValoracionODEVO.
     * @throws Exception
     * 
     */
	protected ValoracionODEVO handleObtenValoracionODEDesdeHasta(String idODE, Calendar fechaDesde, Calendar fechaHasta) throws Exception {
		if (logger.isDebugEnabled()) logger.debug("Buscando las valoraciones del ode con identificador ["+idODE+"], fechaDesde ["+fechaDesde+"] y fechaHasta ["+fechaHasta+"]");
    	IdODEFechaDesdeHastaCriteria criterio= new IdODEFechaDesdeHastaCriteria();
    	criterio.setIdODE(idODE);
    	criterio.setFechaDesde(fechaDesde);
    	criterio.setFechaHasta(fechaHasta);
    	//Buscamos los valoraciones asociadas a un ODE
    	List valoracionesLista = this.getValoracionDao().buscarValoracionesPorCriterioODEDesdeHasta(criterio);
    	
    	if (valoracionesLista == null || valoracionesLista.size()<=0) {
    		logger.error("No hay valoraciones para el ODE["+idODE+"]. Imposible generar informacion.");
    		throw new Exception("No hay valoraciones para el ODE["+idODE+"]. Imposible generar informacion.");
		}
    	
//    	Cogemos el idioma del ODE
    	String idioma = ((Valoracion)valoracionesLista.get(0)).getIdiomaODE();
    	if (logger.isDebugEnabled()) logger.debug("El idioma del ode es ["+idioma+"]");
//    	Preparamos la salida
    	ValoracionODEVO retorno = new ValoracionODEVO();
    	retorno.setIdiomaODE(((Valoracion)valoracionesLista.get(0)).getIdiomaODE());
    	retorno.setIdODE(((Valoracion)valoracionesLista.get(0)).getIdODE());
    	
    	Valoracion[] valoracionesArray = (Valoracion[])valoracionesLista.toArray(new Valoracion[0]);    	
    	Float[] valoraciones=new Float[valoracionesArray.length];
    	if(valoraciones.length>0){
    		retorno.setValoracion(calcularValoracion(valoracionesArray, valoraciones)); 
    		if (logger.isDebugEnabled()) logger.debug("La valoracion del ode obtenido es ["+retorno.getValoracion()+"]");
    	}else{
    		logger.debug("La valoracion del ode es 0.0");
    		retorno.setValoracion(new Float(0.0));
    	}
    	
    	return retorno;
	}

	/**
     * Introducción de un comentario en relación con un ODE. Se introduce el identificador del ODE, 
     * el título del ODE, el comentario propiamente dicho y la valoración que se le da al ODE.
     * @param idODE El identificador correspondiente al ODE.
     * @param titulo El título de ODE.
     * @param comentario El comentario en relación con el ODE.     
     * @param idiomaODE Idioma del ODE.
     * @param usuario Usuario que ha creado el comentario.
     * @return 	Devuelve un codigo con el resultado de la operacion.
     * @throws Exception
     * 
     */	
	protected void handleIntroducirComentario(String idODE, String comentario, String idiomaODE, String usuario) throws Exception {
		
		if (logger.isDebugEnabled()) logger.debug("Introducimos el comentario con valores idODE ["+idODE+"], comentario ["+comentario+"], idiomaODE ["+idiomaODE+"] y usuario ["+usuario+"]");
		try
		{
			//Creamos el comentario
			ComentarioDao comentarioDao = this.getComentarioDao();
			Comentario comen = comentarioDao.create(comentario, new GregorianCalendar(), idODE, idiomaODE, usuario);
		} catch (Exception e)
		{
			logger.error("Error al insertar el comentario", e);
		}		
	}

	protected void handleIntroducirValoracion(Float valoracion, String idODE, String autor, String idiomaODE) throws Exception {
		if (logger.isDebugEnabled()) logger.debug("Introducimos la valoracion con valores idODE ["+idODE+"], valoracion ["+valoracion+"], autor ["+autor+"]");
		try
		{
			//Creamos la valoracion
			ValoracionDao valoracionDao = this.getValoracionDao();
			Valoracion valorac = valoracionDao.create(valoracion, idODE, new GregorianCalendar(), autor, idiomaODE);
			
		}catch (Exception e)
		{
			logger.error("Error al insertar la valoracion", e);
		}	
		
//		Reindexamos el ode con la nueva valoracion
		try
		{
			this.handleRecalcularValoracionODE(idODE);
		} catch (Exception e)
		{
			logger.error("Error al llamar al servicio de valoracion para realizar la reindexacion del Ode con idODE["+idODE+"]",e);
		}
		
	}

	/**
     * Elimina todos las valoraciones relacionados con un ODE
     * @param idODE El identificador correspondiente al ODE.     
     * @return Devuelve un codigo con el resultado de la operacion.
     * @throws Exception
     * 
     */
	protected String handleEliminarTodasValoraciones(String idODE) throws Exception {
//		Creamos el criterio por el que buscar el ODE
    	IdODEFechaCriteria criterio=crearCriterioBusqueda(idODE);
    	//Buscamos las valoraciones asociados a un ODE
    	List valoracionesLista=this.getValoracionDao().buscarValoracionesPorCriterioODE(criterio);    	
    	
    	//Transformo a array la lista
    	Valoracion[] valoracionesArray = (Valoracion[])valoracionesLista.toArray(new Valoracion[0]);    	
    	for (int i = 0; valoracionesArray!=null && i < valoracionesArray.length; i++) {
    		this.getValoracionDao().remove(valoracionesArray[i]);			
		}
//    	No reindexamos el ODE. Nos limitamos a eliminar las valoraciones.
    	return SIN_ERRORES;
	}

	/**
     * Elimina todos los comentarios relacionados con un ODE
     * @param idODE El identificador correspondiente al ODE.     
     * @return Devuelve un codigo con el resultado de la operacion.
     * @throws Exception
     * 
     */
	protected String handleEliminarTodosComentarios(String idODE) throws Exception {
//		Creamos el criterio por el que buscar el ODE
    	IdODEFechaCriteria criterio=crearCriterioBusqueda(idODE);
    	//Buscamos los comentarios asociados a un ODE
    	List comentariosLista=this.getComentarioDao().buscarComentariosPorCriterioODE(criterio);
    	
    	//Transformo a array la lista
    	Comentario[] comentariosArray=(Comentario[])comentariosLista.toArray(new Comentario[0]);
    	for (int i = 0; comentariosArray!=null && i < comentariosArray.length; i++) {
			this.getComentarioDao().remove(comentariosArray[i]);
		}
//    	No reindexamos el ODE. Nos limitamos a eliminar los comentarios.
    	return SIN_ERRORES;
	}	

}
    
    

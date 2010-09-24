/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.auditoria.negocio.dominio;

import java.util.Calendar;
import java.util.List;

/**
 * @see es.pode.auditoria.negocio.dominio.Operacion
 */
public class OperacionDaoImpl
    extends es.pode.auditoria.negocio.dominio.OperacionDaoBase
{
    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#toOperacionVO(es.pode.auditoria.negocio.dominio.Operacion)
     */
    public es.pode.auditoria.negocio.servicios.OperacionVO toOperacionVO(final es.pode.auditoria.negocio.dominio.Operacion entity)
    {
        //default mapping between entity and VO
        //@todo verify or customize behaviour of this mapping
        return (es.pode.auditoria.negocio.servicios.OperacionVO) 
                  this.getBeanMapper().map(entity, es.pode.auditoria.negocio.servicios.OperacionVO.class, DEF_MAPPING_OPERACION_OPERACIONVO);
    }
    

	/**
	 * Copy a VO to a new entity.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 * @see es.pode.auditoria.negocio.dominio.OperacionDao#fromOperacionVO(es.pode.auditoria.negocio.servicios.OperacionVO)
	 */
    public es.pode.auditoria.negocio.dominio.Operacion fromOperacionVO(final es.pode.auditoria.negocio.servicios.OperacionVO vo) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        return super.fromOperacionVO(vo);
    }

	/**
	 * Copy a VO to an existing entity.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 * @see es.pode.auditoria.negocio.dominio.OperacionDao#fromOperacionVO(es.pode.auditoria.negocio.servicios.OperacionVO ,es.pode.auditoria.negocio.dominio.Operacion)	 
	 */
    public void fromOperacionVO(es.pode.auditoria.negocio.servicios.OperacionVO vo, es.pode.auditoria.negocio.dominio.Operacion entity) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        super.fromOperacionVO(vo, entity);
    }
    
    public Object obtenerNumOperacionesDesdeHasta(final int transform, final java.lang.String queryString, final Calendar fechaDesde, final Calendar fechaHasta, final java.lang.String operacion)
    {
    	logger.info("obtenerNumOperacionesDesdeHasta");
        try
        {
            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
		    queryObject.setParameter("fechaDesde", fechaDesde);
			queryObject.setParameter("fechaHasta", fechaHasta);
			queryObject.setParameter("operacion", operacion);  
			logger.info("despues de asignar los parametros");
			logger.info("fechaDesde "+fechaDesde);
			logger.info("fechaHasta "+fechaHasta);
			logger.info("operacion "+operacion);
			logger.info("queryObject.getQueryString() "+queryObject.getQueryString());
			java.util.List results = queryObject.list();
			logger.info("results vale "+results);
			Object result = null;
            if (results != null)
            {
                if (results.size() > 1)
                {
                    throw new org.springframework.dao.InvalidDataAccessResourceUsageException(
                        "More than one instance of 'java.lang.Integer"
                            + "' was found when executing query --> '" + queryString + "'");
                }
                else if (results.size() == 1)
                {
                	logger.info("tamanio 1");
                    result = (Long)results.iterator().next();
                    logger.info("result vale "+result);
                }
            }
            logger.info("result vale "+result);
            result = transformEntity(transform, (Long)result);
            return result;
                       
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }
    
    
  
    
    public java.util.List obtenerOperacionesDesdeHasta(final int transform, final java.lang.String queryString, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta)
    {
        try
        {
            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
            queryObject.setParameter("fechaDesde", fechaDesde);
			queryObject.setParameter("fechaHasta", fechaHasta);
            java.util.List results = queryObject.list();
            transformEntities(transform, results);
            return results;
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }
    
    /**
     * Obtiene la lista con los identificadores de los ods sobre los que se ha realizado una determinada operacion.
	 * @param fechaDesde, fechaHasta y el identificador de la operacion
	 * @return Lista con los identificadores
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerIdOdesOperacionDesdeHasta(int, java.lang.String, java.util.Date, java.util.Date, java.lang.String)
     */
    public java.util.List obtenerIdOdesOperacionDesdeHasta(final int transform, final java.lang.String queryString, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String operacion)
    {
    	logger.debug("obtenerIdOdesOperacionDesdeHasta");
        try
        {
        	org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
			queryObject.setParameter("operacion", operacion);  
			queryObject.setParameter("fechaDesde", fechaDesde);
			queryObject.setParameter("fechaHasta", fechaHasta);
            java.util.List results = queryObject.list();
            logger.debug("queryObject ->"+queryObject);
            transformEntities(transform, results);
            logger.debug("results "+results);
            return results;
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }
    
    /**
     * Obtiene el número de vecesla lista con los identificadores de los ods sobre los que se ha realizado una determinada operacion.
	 * @param fechaDesde, fechaHasta y el identificador de la operacion
	 * @return Lista con los identificadores
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerNumIdOdesOperacion(int, java.lang.String, java.util.Date, java.util.Date, java.lang.String)
     */
    public Object  obtenerNumIdOdesOperacion(final int transform, final java.lang.String queryString, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String idOde, final java.lang.String operacion)
    {
        try
        {
        	logger.debug("[obtenerNumIdOdesOperacion]");
            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
			queryObject.setParameter("idOde", idOde); 
			queryObject.setParameter("fechaDesde", fechaDesde);
			queryObject.setParameter("fechaHasta", fechaHasta);
			queryObject.setParameter("operacion", operacion);
			logger.debug("queryObject "+queryObject);
            List results = queryObject.list();
            logger.debug("results "+results);
            Object result = null;
            if (results != null)
            {
                if (results.size() > 1)
                {
                	logger.info("results.size() > 1");
                    throw new org.springframework.dao.InvalidDataAccessResourceUsageException(
                        "More than one instance of 'java.lang.Integer"
                            + "' was found when executing query --> '" + queryString + "'");
                }
                else if (results.size() == 1)
                {
                	logger.info("tamanio 1");
                    result = (Long)results.iterator().next();
                }
            }
            logger.debug("result vale "+result);
          //  result = transformEntity(transform, (Integer)result);
            return result;
         
            
            //return results;
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }
    
    public java.util.List  obtenerIdOdeOperUsuario(final int transform, final java.lang.String queryString, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String usuario, final java.lang.String operacion)
    {
    	logger.debug("obtenerIdOdeOperUsuario");
    	try
        {
            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
            queryObject.setParameter("fechaDesde", fechaDesde);
			queryObject.setParameter("fechaHasta", fechaHasta);
			queryObject.setParameter("usuario", usuario);
			queryObject.setParameter("operacion", operacion);
			java.util.List results = queryObject.list();
            transformEntities(transform, results);
            return results;
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }
    
    private final void transformEntities(final int transform, final java.util.Collection entities)
    {
        switch (transform)
        {
            case es.pode.auditoria.negocio.dominio.OperacionDao.TRANSFORM_OPERACIONVO :
                toOperacionVOCollection(entities);
                break;
            case TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }
    private final Object transformEntity(final int transform, final Long entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                
                case TRANSFORM_NONE : // fall-through
                default:
                    target = entity;
            }
        }
        return target;
    }
    
    /**
     * Obtiene el número de veces que sea producido esa operacion con ese identificador que se pasan como parametros.
	 * @param el identificador y el idOde de la operacion
	 * @return Integer con el numero
     */
    public Object  obtenerNumeroOperacion(final int transform, final java.lang.String queryString, final java.lang.String idOde, final java.lang.String operacion)
    {
        try
        {
        	logger.debug("[obtenerNumeroOperacion]");
            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
			queryObject.setParameter("idOde", idOde); 
			queryObject.setParameter("operacion", operacion);
			logger.debug("queryObject "+queryObject);
            List results = queryObject.list();
            logger.debug("results "+results);
            Object result = null;
            if (results != null)
            {
                if (results.size() > 1)
                {
                	logger.info("results.size() > 1");
                    throw new org.springframework.dao.InvalidDataAccessResourceUsageException(
                        "More than one instance of 'java.lang.Integer"
                            + "' was found when executing query --> '" + queryString + "'");
                }
                else if (results.size() == 1)
                {
                	logger.info("tamanio 1");
                    result = (Long)results.iterator().next();
                }
            }
            logger.debug("result vale "+result);
          //  result = transformEntity(transform, (Integer)result);
            return result;
         
            
            //return results;
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }



}
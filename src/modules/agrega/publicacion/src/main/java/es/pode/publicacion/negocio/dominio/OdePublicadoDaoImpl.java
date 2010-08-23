/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.publicacion.negocio.dominio;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * @see es.pode.publicacion.negocio.dominio.ODEPublicado
 */
public class OdePublicadoDaoImpl
    extends OdePublicadoDaoBase
{
	
	private Logger logger = Logger.getLogger(this.getClass());
    /**
     * @see es.pode.publicacion.negocio.dominio.ODEPublicadoDao#eliminaODEsPublicadosPorId(java.lang.String)
     */
    protected void handleEliminaODEsPublicadosPorId(java.lang.String idODE) throws Exception
    {
		if (idODE == null || idODE.equals(""))
		{
			logger.error("Imposible eliminar de la lista de ODEs publicados sin identificador.");
			throw new Exception("Imposible eliminar de la lista de ODEs publicados sin identificador.");
		}
		
		IdODEPublicadoCriteria criterio = new IdODEPublicadoCriteria(idODE);
		List resultados = this.obtenODEsPublicadosPorID(criterio);
		if (resultados== null || resultados.size() == 0)
		{
			logger.warn("No hay ODEs que borrar para el identificador["+idODE+"]");
			return;
		}
		this.remove(resultados);
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.ODEPublicadoDao#toPesoODEVO(es.pode.publicacion.negocio.dominio.ODEPublicado)
     */
    public es.pode.publicacion.negocio.servicios.PesoODEVO toPesoODEVO(final es.pode.publicacion.negocio.dominio.OdePublicado entity)
    {
        //default mapping between entity and VO
        //@todo verify or customize behaviour of this mapping
        return (es.pode.publicacion.negocio.servicios.PesoODEVO) 
                  this.getBeanMapper().map(entity, es.pode.publicacion.negocio.servicios.PesoODEVO.class, DEF_MAPPING_ODEPUBLICADO_PESOODEVO);
    }
    

	/**
	 * Copy a VO to a new entity.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 * @see es.pode.publicacion.negocio.dominio.ODEPublicadoDao#fromPesoODEVO(es.pode.publicacion.negocio.servicios.PesoODEVO)
	 */
    public es.pode.publicacion.negocio.dominio.OdePublicado fromPesoODEVO(final es.pode.publicacion.negocio.servicios.PesoODEVO vo) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        return super.fromPesoODEVO(vo);
    }

	/**
	 * Copy a VO to an existing entity.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 * @see es.pode.publicacion.negocio.dominio.ODEPublicadoDao#fromPesoODEVO(es.pode.publicacion.negocio.servicios.PesoODEVO ,es.pode.publicacion.negocio.dominio.ODEPublicado)	 
	 */
    public void fromPesoODEVO(es.pode.publicacion.negocio.servicios.PesoODEVO vo, es.pode.publicacion.negocio.dominio.OdePublicado entity) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        super.fromPesoODEVO(vo, entity);
    }
    /**
     * @see es.pode.publicacion.negocio.dominio.ODEPublicadoDao#toDetallePublicadoODEVO(es.pode.publicacion.negocio.dominio.ODEPublicado)
     */
    public es.pode.publicacion.negocio.servicios.DetallePublicadoODEVO toDetallePublicadoOdeVO(final es.pode.publicacion.negocio.dominio.OdePublicado entity)
    {
        //default mapping between entity and VO
        //@todo verify or customize behaviour of this mapping
        return (es.pode.publicacion.negocio.servicios.DetallePublicadoODEVO) 
                  this.getBeanMapper().map(entity, es.pode.publicacion.negocio.servicios.DetallePublicadoODEVO.class, DEF_MAPPING_ODEPUBLICADO_DETALLEPUBLICADOODEVO);
    }
    

	/**
	 * Copy a VO to a new entity.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 * @see es.pode.publicacion.negocio.dominio.ODEPublicadoDao#fromDetallePublicadoODEVO(es.pode.publicacion.negocio.servicios.DetallePublicadoODEVO)
	 */
    public es.pode.publicacion.negocio.dominio.OdePublicado fromDetallePublicadOdePublicadoVO(final es.pode.publicacion.negocio.servicios.DetallePublicadoODEVO vo) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        return super.fromDetallePublicadoODEVO(vo);
    }

	/**
	 * Copy a VO to an existing entity.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 * @see es.pode.publicacion.negocio.dominio.ODEPublicadoDao#fromDetallePublicadoODEVO(es.pode.publicacion.negocio.servicios.DetallePublicadoODEVO ,es.pode.publicacion.negocio.dominio.ODEPublicado)	 
	 */
    public void fromDetallePublicadoODEVO(es.pode.publicacion.negocio.servicios.DetallePublicadoODEVO vo, es.pode.publicacion.negocio.dominio.OdePublicado entity) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        super.fromDetallePublicadoODEVO(vo, entity);
    }
    /**
     * @see es.pode.publicacion.negocio.dominio.ODEPublicadoDao#toDetallePublicadoODEVO(es.pode.publicacion.negocio.dominio.ODEPublicado)
     */
    public es.pode.publicacion.negocio.servicios.DetallePublicadoODEVO toDetallePublicadoODEVO(final es.pode.publicacion.negocio.dominio.OdePublicado entity)
    {
        //default mapping between entity and VO
        //@todo verify or customize behaviour of this mapping
        return (es.pode.publicacion.negocio.servicios.DetallePublicadoODEVO) 
                  this.getBeanMapper().map(entity, es.pode.publicacion.negocio.servicios.DetallePublicadoODEVO.class, DEF_MAPPING_ODEPUBLICADO_DETALLEPUBLICADOODEVO);
    }
    

	/**
	 * Copy a VO to a new entity.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 * @see es.pode.publicacion.negocio.dominio.ODEPublicadoDao#fromDetallePublicadoODEVO(es.pode.publicacion.negocio.servicios.DetallePublicadoODEVO)
	 */
    public es.pode.publicacion.negocio.dominio.OdePublicado fromDetallePublicadoODEVO(final es.pode.publicacion.negocio.servicios.DetallePublicadoODEVO vo) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        return super.fromDetallePublicadoODEVO(vo);
    }

	public es.pode.publicacion.negocio.servicios.OdePublicadoVO toOdePublicadoVO(OdePublicado entity) {
		
        //default mapping between entity and VO
        //@todo verify or customize behaviour of this mapping
        return (es.pode.publicacion.negocio.servicios.OdePublicadoVO) 
                  this.getBeanMapper().map(entity, es.pode.publicacion.negocio.servicios.OdePublicadoVO.class, DEF_MAPPING_ODEPUBLICADO_ODEPUBLICADOVO);
	}

	/**
     * @see es.pode.publicacion.negocio.dominio.OdePublicado#obtenNumODEsPublicadosPorIdioma(int, java.lang.String, java.lang.String)
     */
    public Object obtenNumODEsPublicadosPorIdioma(final int transform, final java.lang.String queryString, final java.lang.String idioma)
    {
        try
        {
            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
            queryObject.setParameter("idioma", idioma);
            java.util.List results = queryObject.list();
            Object result = null;
            if (results != null)
            {
                if (results.size() > 1)
                {
                    throw new org.springframework.dao.InvalidDataAccessResourceUsageException(
                        "More than one instance of 'java.lang.Long"
                            + "' was found when executing query --> '" + queryString + "'");
                }
                else if (results.size() == 1)
                {
                    result = (Long)results.iterator().next();
                }
            }
            return result;
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.OdePublicado#obtenNumODEsPublicados(int, java.lang.String)
     */
    public Object obtenNumODEsPublicados(final int transform, final java.lang.String queryString)
    {
        try
        {
            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
            java.util.List results = queryObject.list();
            Object result = null;
            if (results != null)
            {
                if (results.size() > 1)
                {
                    throw new org.springframework.dao.InvalidDataAccessResourceUsageException(
                        "More than one instance of 'java.lang.Long"
                            + "' was found when executing query --> '" + queryString + "'");
                }
                else if (results.size() == 1)
                {
                    result = (Long)results.iterator().next();
                }
            }
            return result;
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

	}
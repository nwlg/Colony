/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.auditoria.negocio.dominio;

import java.util.Date;
import java.util.List;

/**
 * @see es.pode.auditoria.negocio.dominio.Valoracion
 */
public class ValoracionDaoImpl
    extends es.pode.auditoria.negocio.dominio.ValoracionDaoBase
{
    /**
     * @see es.pode.auditoria.negocio.dominio.ValoracionDao#toValoracionVO(es.pode.auditoria.negocio.dominio.Valoracion)
     */
    public es.pode.auditoria.negocio.servicios.ValoracionVO toValoracionVO(final es.pode.auditoria.negocio.dominio.Valoracion entity)
    {
        //default mapping between entity and VO
        //@todo verify or customize behaviour of this mapping
        return (es.pode.auditoria.negocio.servicios.ValoracionVO)
                  this.getBeanMapper().map(entity, es.pode.auditoria.negocio.servicios.ValoracionVO.class, DEF_MAPPING_VALORACION_VALORACIONVO);
    }
    

	/**
	 * Copy a VO to a new entity.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 * @see es.pode.auditoria.negocio.dominio.ValoracionDao#fromValoracionVO(es.pode.auditoria.negocio.servicios.ValoracionVO)
	 */
    public es.pode.auditoria.negocio.dominio.Valoracion fromValoracionVO(final es.pode.auditoria.negocio.servicios.ValoracionVO vo) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        return super.fromValoracionVO(vo);
    }

	/**
	 * Copy a VO to an existing entity.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 * @see es.pode.auditoria.negocio.dominio.ValoracionDao#fromValoracionVO(es.pode.auditoria.negocio.servicios.ValoracionVO ,es.pode.auditoria.negocio.dominio.Valoracion)
	 */
    public void fromValoracionVO(es.pode.auditoria.negocio.servicios.ValoracionVO vo, es.pode.auditoria.negocio.dominio.Valoracion entity) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        super.fromValoracionVO(vo, entity);
    }
    /**
     * @see es.pode.auditoria.negocio.dominio.ValoracionDao#toValoracionIdODEVO(es.pode.auditoria.negocio.dominio.Valoracion)
     */
    public es.pode.auditoria.negocio.servicios.ValoracionIdODEVO toValoracionIdODEVO(final es.pode.auditoria.negocio.dominio.Valoracion entity)
    {
        //default mapping between entity and VO
        //@todo verify or customize behaviour of this mapping
        return (es.pode.auditoria.negocio.servicios.ValoracionIdODEVO)
                  this.getBeanMapper().map(entity, es.pode.auditoria.negocio.servicios.ValoracionIdODEVO.class, DEF_MAPPING_VALORACION_VALORACIONIDODEVO);
    }
    

	/**
	 * Copy a VO to a new entity.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 * @see es.pode.auditoria.negocio.dominio.ValoracionDao#fromValoracionIdODEVO(es.pode.auditoria.negocio.servicios.auditoria.ValoracionIdODEVO)
	 */
    public es.pode.auditoria.negocio.dominio.Valoracion fromValoracionIdODEVO(final es.pode.auditoria.negocio.servicios.ValoracionIdODEVO vo) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        return super.fromValoracionIdODEVO(vo);
    }

	/**
	 * Copy a VO to an existing entity.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 * @see es.pode.auditoria.negocio.dominio.ValoracionDao#fromValoracionIdODEVO(es.pode.auditoria.negocio.servicios.ValoracionIdODEVO ,es.pode.auditoria.negocio.dominio.Valoracion)
	 */
    public void fromValoracionIdODEVO(es.pode.auditoria.negocio.servicios.ValoracionIdODEVO vo, es.pode.auditoria.negocio.dominio.Valoracion entity) {
        //default mapping between VO and entity
        //@todo verify or customize behaviour of this mapping
        super.fromValoracionIdODEVO(vo, entity);
    }


	public List listarODEsValoradosDesdeHasta(int transform, String queryString, Date fechaDesde, Date fechaHasta)
	{
		try
		{
		
			org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);		
			queryObject.setParameter("fechaHasta", fechaHasta); 		
			queryObject.setParameter("fechaDesde", fechaDesde); 		
			logger.debug("listarODEsValoradosDesdeHasta["+queryObject.getQueryString()+"]");		
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
            case es.pode.auditoria.negocio.dominio.ValoracionDao.TRANSFORM_VALORACIONVO :
                toValoracionVOCollection(entities);
                break;
            case es.pode.auditoria.negocio.dominio.ValoracionDao.TRANSFORM_VALORACIONIDODEVO :
                toValoracionIdODEVOCollection(entities);
                break;
            case TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }

}
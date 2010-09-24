// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringHibernateDaoBase.vsl in andromda-spring-cartridge.
//
package es.pode.auditoria.negocio.dominio;

import net.sf.dozer.util.mapping.MapperIF;

/**
 * <p>
 * Base Spring DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>es.pode.auditoria.negocio.dominio.Operacion</code>.
 * </p>
 *
 * @see es.pode.auditoria.negocio.dominio.Operacion
 */
public abstract class OperacionDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements es.pode.auditoria.negocio.dominio.OperacionDao
{



	

	/**
	 * Constant that identifies a mapping between an 
	 * entity (Operacion) and a VO (OperacionVO)
	 */
	public final static String DEF_MAPPING_OPERACION_OPERACIONVO = "DEF_MAPPING_OPERACION_OPERACIONVO";
	
	/**
	 * Constant that identifies a mapping between a 
	 * VO (OperacionVO) and an entity (Operacion)
	 */
	public final static String DEF_MAPPING_OPERACIONVO_OPERACION = "DEF_MAPPING_OPERACIONVO_OPERACION";
	
	/**
	 * Reference to the dozer bean mapper used in the application (singleton).
	 */
	private MapperIF beanMapper;
	
	/**
	 * Gets the reference to the dozer bean mapper used in the application (singleton).
	 * @return MapperIF
	 */
    protected MapperIF getBeanMapper() {
		return beanMapper;
	}

    /**
     * Sets the instance of the Dozer bean mapper to be used.
     * @param beanMapper
     */
	public void setBeanMapper(MapperIF beanMapper) {
		this.beanMapper = beanMapper;
	}


    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#load(int, java.lang.Long)
     */
    public Object load(final int transform, final java.lang.Long id)
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "Operacion.load - 'id' can not be null");
        }
        final java.util.List list = this.getHibernateTemplate().find(
            "from es.pode.auditoria.negocio.dominio.Operacion as entity where entity.id = ?", id);
        final Object entity = list != null && !list.isEmpty() ? list.iterator().next() : null;
        return transformEntity(transform, (es.pode.auditoria.negocio.dominio.Operacion)entity);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#load(java.lang.Long)
     */
    public es.pode.auditoria.negocio.dominio.Operacion load(java.lang.Long id)
    {
        return (es.pode.auditoria.negocio.dominio.Operacion)this.load(TRANSFORM_NONE, id);
    }
    
    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#loadAll()
     */
    public java.util.Collection loadAll()
    {
        return this.loadAll(TRANSFORM_NONE);
    }
    
    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#loadAll(int)
     */
    public java.util.Collection loadAll(final int transform)
    {
        final java.util.Collection results = this.getHibernateTemplate().loadAll(es.pode.auditoria.negocio.dominio.OperacionImpl.class);
        this.transformEntities(transform, results);
        return results;
    }
    

    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#create(es.pode.auditoria.negocio.dominio.Operacion)
     */
    public es.pode.auditoria.negocio.dominio.Operacion create(es.pode.auditoria.negocio.dominio.Operacion operacion)
    {
        return (es.pode.auditoria.negocio.dominio.Operacion)this.create(TRANSFORM_NONE, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#create(int transform, es.pode.auditoria.negocio.dominio.Operacion)
     */
    public Object create(final int transform, final es.pode.auditoria.negocio.dominio.Operacion operacion)
    {
        if (operacion == null)
        {
            throw new IllegalArgumentException(
                "Operacion.create - 'operacion' can not be null");
        }
        Object identifier = this.getHibernateTemplate().save(operacion);
        operacion.setId((java.lang.Long)identifier);
        return this.transformEntity(transform, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#create(java.util.Collection)
     */
    public java.util.Collection create(final java.util.Collection entities)
    {
        return create(TRANSFORM_NONE, entities);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#create(int, java.util.Collection)
     */
    public java.util.Collection create(final int transform, final java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Operacion.create - 'entities' can not be null");
        }
        this.getHibernateTemplate().execute(
            new org.springframework.orm.hibernate3.HibernateCallback()
            {
                public Object doInHibernate(org.hibernate.Session session)
                    throws org.hibernate.HibernateException
                {
                    for (java.util.Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
                    {
                        create(transform, (es.pode.auditoria.negocio.dominio.Operacion)entityIterator.next());
                    }
                    return null;
                }
            },
            true);
        return entities;
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#create(int, java.lang.String,java.lang.String,java.lang.String,java.util.Calendar,java.lang.String,java.lang.String)
     */
    public es.pode.auditoria.negocio.dominio.Operacion create(
 java.lang.String idOde, java.lang.String tituloOde, java.lang.String usuario, java.util.Calendar fecha, java.lang.String operacion, java.lang.String idioma)
    {
         return (es.pode.auditoria.negocio.dominio.Operacion)this.create(TRANSFORM_NONE,  idOde, tituloOde, usuario, fecha, operacion, idioma);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#create(int, java.lang.String,java.lang.String,java.lang.String,java.util.Calendar,java.lang.String,java.lang.String)
     */
    public Object create(
        final int transform,
 java.lang.String idOde, java.lang.String tituloOde, java.lang.String usuario, java.util.Calendar fecha, java.lang.String operacion, java.lang.String idioma)
    {
        es.pode.auditoria.negocio.dominio.Operacion entity = new es.pode.auditoria.negocio.dominio.OperacionImpl();
        entity.setIdOde(idOde);
        entity.setTituloOde(tituloOde);
        entity.setUsuario(usuario);
        entity.setFecha(fecha);
        entity.setOperacion(operacion);
        entity.setIdioma(idioma);
        return this.create(transform, entity);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#update(es.pode.auditoria.negocio.dominio.Operacion)
     */
    public void update(es.pode.auditoria.negocio.dominio.Operacion operacion)
    {
        if (operacion == null)
        {
            throw new IllegalArgumentException(
                "Operacion.update - 'operacion' can not be null");
        }
        this.getHibernateTemplate().update(operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#update(java.util.Collection)
     */
    public void update(final java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Operacion.update - 'entities' can not be null");
        }
        this.getHibernateTemplate().execute(
            new org.springframework.orm.hibernate3.HibernateCallback()
            {
                public Object doInHibernate(org.hibernate.Session session)
                    throws org.hibernate.HibernateException
                {
                    for (java.util.Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
                    {
                        update((es.pode.auditoria.negocio.dominio.Operacion)entityIterator.next());
                    }
                    return null;
                }
            },
            true);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#remove(es.pode.auditoria.negocio.dominio.Operacion)
     */
    public void remove(es.pode.auditoria.negocio.dominio.Operacion operacion)
    {
        if (operacion == null)
        {
            throw new IllegalArgumentException(
                "Operacion.remove - 'operacion' can not be null");
        }
        this.getHibernateTemplate().delete(operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#remove(java.lang.Long)
     */
    public void remove(java.lang.Long id)
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "Operacion.remove - 'id' can not be null");
        }
        es.pode.auditoria.negocio.dominio.Operacion entity = this.load(id);
        if (entity != null)
        {
            this.remove(entity);
        }
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#remove(java.util.Collection)
     */
    public void remove(java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Operacion.remove - 'entities' can not be null");
        }
        this.getHibernateTemplate().deleteAll(entities);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerNumOperacionesDesdeHasta(java.util.Calendar, java.util.Calendar, java.lang.String)
     */
    public java.lang.Long obtenerNumOperacionesDesdeHasta(java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String operacion)
    {
        return (java.lang.Long)this.obtenerNumOperacionesDesdeHasta(TRANSFORM_NONE, fechaDesde, fechaHasta, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerNumOperacionesDesdeHasta(java.lang.String, java.util.Calendar, java.util.Calendar, java.lang.String)
     */
    public java.lang.Long obtenerNumOperacionesDesdeHasta(final java.lang.String queryString, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String operacion)
    {
        return (java.lang.Long)this.obtenerNumOperacionesDesdeHasta(TRANSFORM_NONE, queryString, fechaDesde, fechaHasta, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerNumOperacionesDesdeHasta(int, java.util.Calendar, java.util.Calendar, java.lang.String)
     */
    public Object obtenerNumOperacionesDesdeHasta(final int transform, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String operacion)
    {
        return this.obtenerNumOperacionesDesdeHasta(transform, "select count(*) from es.pode.auditoria.negocio.dominio.Operacion as operacion where :fechaHasta>=operacion.fecha AND :fechaDesde<=operacion.fecha AND operacion.operacion = :operacion", fechaDesde, fechaHasta, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerNumOperacionesDesdeHasta(int, java.lang.String, java.util.Calendar, java.util.Calendar, java.lang.String)
     */
    public Object obtenerNumOperacionesDesdeHasta(final int transform, final java.lang.String queryString, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String operacion)
    {
        try
        {
            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
            queryObject.setParameter("fechaDesde", fechaDesde);
            queryObject.setParameter("fechaHasta", fechaHasta);
            queryObject.setParameter("operacion", operacion);
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
                    result = (es.pode.auditoria.negocio.dominio.Operacion)results.iterator().next();
                }
            }
            result = transformEntity(transform, (es.pode.auditoria.negocio.dominio.Operacion)result);
            return result;
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerOdesUsuarioDesdeHasta(es.pode.auditoria.negocio.dominio.TitulosOdePorUsuarioDesdeHastaCriteria)
     */
    public java.util.List obtenerOdesUsuarioDesdeHasta(es.pode.auditoria.negocio.dominio.TitulosOdePorUsuarioDesdeHastaCriteria criterio)
    {
        return this.obtenerOdesUsuarioDesdeHasta(TRANSFORM_NONE, criterio);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerOdesUsuarioDesdeHasta(int, java.lang.String, es.pode.auditoria.negocio.dominio.TitulosOdePorUsuarioDesdeHastaCriteria)
     */
    public java.util.List obtenerOdesUsuarioDesdeHasta(final int transform, final es.pode.auditoria.negocio.dominio.TitulosOdePorUsuarioDesdeHastaCriteria criterio)
    {
        try
        {
            es.pode.auditoria.CriteriaSearch criteriaSearch = new es.pode.auditoria.CriteriaSearch(super.getSession(false), es.pode.auditoria.negocio.dominio.OperacionImpl.class);
            criteriaSearch.getConfiguration().setFirstResult(criterio.getFirstResult());
            criteriaSearch.getConfiguration().setFetchSize(criterio.getFetchSize());
            criteriaSearch.getConfiguration().setMaximumResultSize(criterio.getMaximumResultSize());
							            es.pode.auditoria.CriteriaSearchParameter parameter1 =
                new es.pode.auditoria.CriteriaSearchParameter(
                    criterio.getFechaDesde(),
                    "fecha", es.pode.auditoria.CriteriaSearchParameter.GREATER_THAN_OR_EQUAL_COMPARATOR);
            criteriaSearch.addParameter(parameter1);
							            es.pode.auditoria.CriteriaSearchParameter parameter2 =
                new es.pode.auditoria.CriteriaSearchParameter(
                    criterio.getFechaHasta(),
                    "fecha", es.pode.auditoria.CriteriaSearchParameter.LESS_THAN_OR_EQUAL_COMPARATOR);
            criteriaSearch.addParameter(parameter2);
							            es.pode.auditoria.CriteriaSearchParameter parameter3 =
                new es.pode.auditoria.CriteriaSearchParameter(
                    criterio.getUsuario(),
                    "usuario", es.pode.auditoria.CriteriaSearchParameter.EQUAL_COMPARATOR);
            criteriaSearch.addParameter(parameter3);
							            es.pode.auditoria.CriteriaSearchParameter parameter4 =
                new es.pode.auditoria.CriteriaSearchParameter(
                    criterio.getOperacion(),
                    "operacion", es.pode.auditoria.CriteriaSearchParameter.LIKE_COMPARATOR);
            criteriaSearch.addParameter(parameter4);
            // Call this method to include any modification to the criteria, default implementation is void.
            criteriaSearch = modifyobtenerOdesUsuarioDesdeHasta(criteriaSearch);
            java.util.List results = criteriaSearch.executeAsList();
            transformEntities(transform, results);
            return results;
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }
    
    /**
     * Defauly implementation. Overrride to include any distinct search.
     * 
     * @param criteriaSearch The criteriaSearch to modify.          
     */
    protected es.pode.auditoria.CriteriaSearch modifyobtenerOdesUsuarioDesdeHasta (es.pode.auditoria.CriteriaSearch criteriaSearch){
        return criteriaSearch;
    }
    

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerIdOdesOperacionDesdeHasta(java.util.Calendar, java.util.Calendar, java.lang.String)
     */
    public java.util.List obtenerIdOdesOperacionDesdeHasta(java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String operacion)
    {
        return this.obtenerIdOdesOperacionDesdeHasta(TRANSFORM_NONE, fechaDesde, fechaHasta, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerIdOdesOperacionDesdeHasta(java.lang.String, java.util.Calendar, java.util.Calendar, java.lang.String)
     */
    public java.util.List obtenerIdOdesOperacionDesdeHasta(final java.lang.String queryString, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String operacion)
    {
        return this.obtenerIdOdesOperacionDesdeHasta(TRANSFORM_NONE, queryString, fechaDesde, fechaHasta, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerIdOdesOperacionDesdeHasta(int, java.util.Calendar, java.util.Calendar, java.lang.String)
     */
    public java.util.List obtenerIdOdesOperacionDesdeHasta(final int transform, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String operacion)
    {
        return this.obtenerIdOdesOperacionDesdeHasta(transform, "select distinct(idOde) from es.pode.auditoria.negocio.dominio.Operacion as operacion where :fechaDesde <= operacion.fecha and :fechaHasta >= operacion.fecha and operacion.operacion LIKE :operacion ", fechaDesde, fechaHasta, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerIdOdesOperacionDesdeHasta(int, java.lang.String, java.util.Calendar, java.util.Calendar, java.lang.String)
     */
    public java.util.List obtenerIdOdesOperacionDesdeHasta(final int transform, final java.lang.String queryString, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String operacion)
    {
        try
        {
            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
            queryObject.setParameter("fechaDesde", fechaDesde);
            queryObject.setParameter("fechaHasta", fechaHasta);
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

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerNumIdOdesOperacion(java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)
     */
    public java.lang.Long obtenerNumIdOdesOperacion(java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String idOde, java.lang.String operacion)
    {
        return (java.lang.Long)this.obtenerNumIdOdesOperacion(TRANSFORM_NONE, fechaDesde, fechaHasta, idOde, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerNumIdOdesOperacion(java.lang.String, java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)
     */
    public java.lang.Long obtenerNumIdOdesOperacion(final java.lang.String queryString, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String idOde, final java.lang.String operacion)
    {
        return (java.lang.Long)this.obtenerNumIdOdesOperacion(TRANSFORM_NONE, queryString, fechaDesde, fechaHasta, idOde, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerNumIdOdesOperacion(int, java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)
     */
    public Object obtenerNumIdOdesOperacion(final int transform, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String idOde, final java.lang.String operacion)
    {
        return this.obtenerNumIdOdesOperacion(transform, "select count(*) as cantidad from es.pode.auditoria.negocio.dominio.Operacion as operacion where :fechaHasta>=operacion.fecha AND :fechaDesde<=operacion.fecha AND operacion.idOde = :idOde AND operacion.operacion LIKE :operacion", fechaDesde, fechaHasta, idOde, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerNumIdOdesOperacion(int, java.lang.String, java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)
     */
    public Object obtenerNumIdOdesOperacion(final int transform, final java.lang.String queryString, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String idOde, final java.lang.String operacion)
    {
        try
        {
            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
            queryObject.setParameter("fechaDesde", fechaDesde);
            queryObject.setParameter("fechaHasta", fechaHasta);
            queryObject.setParameter("idOde", idOde);
            queryObject.setParameter("operacion", operacion);
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
                    result = (es.pode.auditoria.negocio.dominio.Operacion)results.iterator().next();
                }
            }
            result = transformEntity(transform, (es.pode.auditoria.negocio.dominio.Operacion)result);
            return result;
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerIdOdeOperUsuario(java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)
     */
    public java.util.List obtenerIdOdeOperUsuario(java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String usuario, java.lang.String operacion)
    {
        return this.obtenerIdOdeOperUsuario(TRANSFORM_NONE, fechaDesde, fechaHasta, usuario, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerIdOdeOperUsuario(java.lang.String, java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)
     */
    public java.util.List obtenerIdOdeOperUsuario(final java.lang.String queryString, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String usuario, final java.lang.String operacion)
    {
        return this.obtenerIdOdeOperUsuario(TRANSFORM_NONE, queryString, fechaDesde, fechaHasta, usuario, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerIdOdeOperUsuario(int, java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)
     */
    public java.util.List obtenerIdOdeOperUsuario(final int transform, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String usuario, final java.lang.String operacion)
    {
        return this.obtenerIdOdeOperUsuario(transform, "from es.pode.auditoria.negocio.dominio.Operacion as operacion where :fechaHasta>=operacion.fecha AND :fechaDesde<=operacion.fecha AND operacion.usuario = :usuario AND operacion.operacion = :operacion", fechaDesde, fechaHasta, usuario, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerIdOdeOperUsuario(int, java.lang.String, java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)
     */
    public java.util.List obtenerIdOdeOperUsuario(final int transform, final java.lang.String queryString, final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String usuario, final java.lang.String operacion)
    {
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

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerIdiomaIdOde(es.pode.auditoria.negocio.dominio.IdiomaOdeDesdeHastaCriteria)
     */
    public java.util.List obtenerIdiomaIdOde(es.pode.auditoria.negocio.dominio.IdiomaOdeDesdeHastaCriteria idiomaOdeDesdeHastaCriteria)
    {
        return this.obtenerIdiomaIdOde(TRANSFORM_NONE, idiomaOdeDesdeHastaCriteria);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerIdiomaIdOde(int, java.lang.String, es.pode.auditoria.negocio.dominio.IdiomaOdeDesdeHastaCriteria)
     */
    public java.util.List obtenerIdiomaIdOde(final int transform, final es.pode.auditoria.negocio.dominio.IdiomaOdeDesdeHastaCriteria idiomaOdeDesdeHastaCriteria)
    {
        try
        {
            es.pode.auditoria.CriteriaSearch criteriaSearch = new es.pode.auditoria.CriteriaSearch(super.getSession(false), es.pode.auditoria.negocio.dominio.OperacionImpl.class);
            criteriaSearch.getConfiguration().setFirstResult(idiomaOdeDesdeHastaCriteria.getFirstResult());
            criteriaSearch.getConfiguration().setFetchSize(idiomaOdeDesdeHastaCriteria.getFetchSize());
            criteriaSearch.getConfiguration().setMaximumResultSize(idiomaOdeDesdeHastaCriteria.getMaximumResultSize());
							            es.pode.auditoria.CriteriaSearchParameter parameter1 =
                new es.pode.auditoria.CriteriaSearchParameter(
                    idiomaOdeDesdeHastaCriteria.getFechaDesde(),
                    "fecha", es.pode.auditoria.CriteriaSearchParameter.GREATER_THAN_OR_EQUAL_COMPARATOR);
            criteriaSearch.addParameter(parameter1);
							            es.pode.auditoria.CriteriaSearchParameter parameter2 =
                new es.pode.auditoria.CriteriaSearchParameter(
                    idiomaOdeDesdeHastaCriteria.getFechaHasta(),
                    "fecha", es.pode.auditoria.CriteriaSearchParameter.LESS_THAN_OR_EQUAL_COMPARATOR);
            criteriaSearch.addParameter(parameter2);
							            es.pode.auditoria.CriteriaSearchParameter parameter3 =
                new es.pode.auditoria.CriteriaSearchParameter(
                    idiomaOdeDesdeHastaCriteria.getIdOde(),
                    "idOde", es.pode.auditoria.CriteriaSearchParameter.EQUAL_COMPARATOR);
            criteriaSearch.addParameter(parameter3);
            // Call this method to include any modification to the criteria, default implementation is void.
            criteriaSearch = modifyobtenerIdiomaIdOde(criteriaSearch);
            java.util.List results = criteriaSearch.executeAsList();
            transformEntities(transform, results);
            return results;
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }
    
    /**
     * Defauly implementation. Overrride to include any distinct search.
     * 
     * @param criteriaSearch The criteriaSearch to modify.          
     */
    protected es.pode.auditoria.CriteriaSearch modifyobtenerIdiomaIdOde (es.pode.auditoria.CriteriaSearch criteriaSearch){
        return criteriaSearch;
    }
    

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerNumeroOperacion(java.lang.String, java.lang.String)
     */
    public java.lang.Long obtenerNumeroOperacion(java.lang.String idOde, java.lang.String operacion)
    {
        return (java.lang.Long)this.obtenerNumeroOperacion(TRANSFORM_NONE, idOde, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerNumeroOperacion(java.lang.String, java.lang.String, java.lang.String)
     */
    public java.lang.Long obtenerNumeroOperacion(final java.lang.String queryString, final java.lang.String idOde, final java.lang.String operacion)
    {
        return (java.lang.Long)this.obtenerNumeroOperacion(TRANSFORM_NONE, queryString, idOde, operacion);
    }

    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerNumeroOperacion(int, java.lang.String, java.lang.String)
     */
    public Object obtenerNumeroOperacion(final int transform, final java.lang.String idOde, final java.lang.String operacion)
    {
        return this.obtenerNumeroOperacion(transform, "select count(*) as numero from es.pode.auditoria.negocio.dominio.Operacion as operacion where operacion.idOde=:idOde AND operacion.operacion LIKE :operacion", idOde, operacion);
    }




    /**
     * @see es.pode.auditoria.negocio.dominio.Operacion#obtenerNumeroOperacion(int, java.lang.String, java.lang.String, java.lang.String)
     */
    public Object obtenerNumeroOperacion(final int transform, final java.lang.String queryString, final java.lang.String idOde, final java.lang.String operacion)
    {
        try
        {
            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
            queryObject.setParameter("idOde", idOde);
            queryObject.setParameter("operacion", operacion);
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
                    result = (es.pode.auditoria.negocio.dominio.Operacion)results.iterator().next();
                }
            }
            result = transformEntity(transform, (es.pode.auditoria.negocio.dominio.Operacion)result);
            return result;
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }
    }

    /**
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>es.pode.auditoria.negocio.dominio.OperacionDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     * <p/>
     * This method will return instances of these types:
     * <ul>
     *   <li>{@link es.pode.auditoria.negocio.dominio.Operacion} - {@link #TRANSFORM_NONE}</li>
     *   <li>{@link es.pode.auditoria.negocio.servicios.OperacionVO} - {@link TRANSFORM_OPERACIONVO}</li>
     * </ul>
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link es.pode.auditoria.negocio.dominio.OperacionDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,java.util.Collection)
     */
    private final Object transformEntity(final int transform, final es.pode.auditoria.negocio.dominio.Operacion entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case es.pode.auditoria.negocio.dominio.OperacionDao.TRANSFORM_OPERACIONVO :
                    target = toOperacionVO(entity);
                    break;
                case TRANSFORM_NONE : // fall-through
                default:
                    target = entity;
            }
        }
        return target;
    }

    /**
     * Transforms a collection of entities using the
     * {@link #transformEntity(int,es.pode.auditoria.negocio.dominio.Operacion)}
     * method. This method does not instantiate a new collection.
     * <p/>
     * This method is to be used internally only.
     *
     * @param transform one of the constants declared in <code>es.pode.auditoria.negocio.dominio.OperacionDao</code>
     * @param entities the collection of entities to transform
     * @return the same collection as the argument, but this time containing the transformed entities
     * @see #transformEntity(int,es.pode.auditoria.negocio.dominio.Operacion)
     */
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

    /**
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#toOperacionVOCollection(java.util.Collection)
     */
    public final void toOperacionVOCollection(java.util.Collection entities)
    {
        if (entities == null)
        {
            entities = java.util.Collections.EMPTY_LIST;
        }
        else
        {
            org.apache.commons.collections.CollectionUtils.transform(entities, OPERACIONVO_TRANSFORMER);
        }
    }

    /**
     * Base implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link OperacionDaoImpl} class if you intend to use reporting queries.
     * @see es.pode.auditoria.negocio.dominio.OperacionDao#toOperacionVO(es.pode.auditoria.negocio.dominio.Operacion)
     */
    protected es.pode.auditoria.negocio.servicios.OperacionVO toOperacionVO(Object[] row)
    {
        return null;
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link es.pode.auditoria.negocio.servicios.OperacionVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private final org.apache.commons.collections.Transformer OPERACIONVO_TRANSFORMER =
        new org.apache.commons.collections.Transformer()
        {
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof es.pode.auditoria.negocio.dominio.Operacion)
                {
                    result = toOperacionVO((es.pode.auditoria.negocio.dominio.Operacion)input);
                }
                else if (input instanceof Object[])
                {
                    result = toOperacionVO((Object[])input);
                }
                return result;
            }
        };

	/**
	 * Copy a VO to a new entity using the default Dozer mappings.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 */
	public es.pode.auditoria.negocio.dominio.Operacion fromOperacionVO(final es.pode.auditoria.negocio.servicios.OperacionVO vo) {
        //default mapping between VO and entity
        return (es.pode.auditoria.negocio.dominio.Operacion) 
                  this.getBeanMapper().map(vo, es.pode.auditoria.negocio.dominio.OperacionImpl.class, DEF_MAPPING_OPERACIONVO_OPERACION);
    }

	/**
	 * Copy a VO to an existing entity using the default Dozer mappings.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 */
    public void fromOperacionVO(es.pode.auditoria.negocio.servicios.OperacionVO vo, es.pode.auditoria.negocio.dominio.Operacion entity) {
        //default mapping between VO and entity
        this.getBeanMapper().map(vo, entity, DEF_MAPPING_OPERACIONVO_OPERACION);
    }
		

    public Object findOdesTitleBetweenDatesByUserByOperation(int transform, String queryString, java.lang.String userId, java.lang.String operacion, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta){

        try
        {
            logger.debug("[findOdesTitleBetweenDatesByUserByOperation(queryString)]");
            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
			queryObject.setParameter("userId", userId);
			queryObject.setParameter("operacion", operacion);
			queryObject.setParameter("fechaDesde", fechaDesde);
			queryObject.setParameter("fechaHasta", fechaHasta);
			logger.debug("queryObject "+queryObject);
            java.util.List results = queryObject.list();
            logger.debug("results "+results);
            return results;
        }
        catch (org.hibernate.HibernateException ex)
        {
            throw super.convertHibernateAccessException(ex);
        }

    }


    public Object findOdesTitleBetweenDatesByUserByOperation(int transform, java.lang.String userId, java.lang.String operacion, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta){
        logger.debug("[findOdesTitleBetweenDatesByUserByOperation]");

        return this.findOdesTitleBetweenDatesByUserByOperation(transform,
                " select odepublicado.titulo, count(*) from es.pode.auditoria.negocio.dominio.Operacion as operacion, es.pode.auditoria.negocio.dominio.OdePublicado as odepublicado " +
                " where operacion.idOde = odepublicado.idODE AND operacion.operacion like :operacion AND " +
                " operacion.usuario=:userId AND :fechaHasta>=operacion.fecha AND :fechaDesde<=operacion.fecha " +
                " group by odepublicado.titulo order by odepublicado.titulo",
                userId, operacion, fechaDesde, fechaHasta);
    }

}
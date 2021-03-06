// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringHibernateDaoBase.vsl in andromda-spring-cartridge.
//
package es.pode.publicacion.negocio.dominio;

import net.sf.dozer.util.mapping.MapperIF;

/**
 * <p>
 * Base Spring DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>es.pode.publicacion.negocio.dominio.Estado</code>.
 * </p>
 *
 * @see es.pode.publicacion.negocio.dominio.Estado
 */
public abstract class EstadoDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements es.pode.publicacion.negocio.dominio.EstadoDao
{



	

	/**
	 * Constant that identifies a mapping between an 
	 * entity (Estado) and a VO (EstadoVO)
	 */
	public final static String DEF_MAPPING_ESTADO_ESTADOVO = "DEF_MAPPING_ESTADO_ESTADOVO";
	
	/**
	 * Constant that identifies a mapping between a 
	 * VO (EstadoVO) and an entity (Estado)
	 */
	public final static String DEF_MAPPING_ESTADOVO_ESTADO = "DEF_MAPPING_ESTADOVO_ESTADO";
	
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
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#load(int, java.lang.Long)
     */
    public Object load(final int transform, final java.lang.Long id)
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "Estado.load - 'id' can not be null");
        }
        final java.util.List list = this.getHibernateTemplate().find(
            "from es.pode.publicacion.negocio.dominio.Estado as entity where entity.id = ?", id);
        final Object entity = list != null && !list.isEmpty() ? list.iterator().next() : null;
        return transformEntity(transform, (es.pode.publicacion.negocio.dominio.Estado)entity);
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#load(java.lang.Long)
     */
    public es.pode.publicacion.negocio.dominio.Estado load(java.lang.Long id)
    {
        return (es.pode.publicacion.negocio.dominio.Estado)this.load(TRANSFORM_NONE, id);
    }
    
    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#loadAll()
     */
    public java.util.Collection loadAll()
    {
        return this.loadAll(TRANSFORM_NONE);
    }
    
    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#loadAll(int)
     */
    public java.util.Collection loadAll(final int transform)
    {
        final java.util.Collection results = this.getHibernateTemplate().loadAll(es.pode.publicacion.negocio.dominio.EstadoImpl.class);
        this.transformEntities(transform, results);
        return results;
    }
    

    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#create(es.pode.publicacion.negocio.dominio.Estado)
     */
    public es.pode.publicacion.negocio.dominio.Estado create(es.pode.publicacion.negocio.dominio.Estado estado)
    {
        return (es.pode.publicacion.negocio.dominio.Estado)this.create(TRANSFORM_NONE, estado);
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#create(int transform, es.pode.publicacion.negocio.dominio.Estado)
     */
    public Object create(final int transform, final es.pode.publicacion.negocio.dominio.Estado estado)
    {
        if (estado == null)
        {
            throw new IllegalArgumentException(
                "Estado.create - 'estado' can not be null");
        }
        Object identifier = this.getHibernateTemplate().save(estado);
        estado.setId((java.lang.Long)identifier);
        return this.transformEntity(transform, estado);
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#create(java.util.Collection)
     */
    public java.util.Collection create(final java.util.Collection entities)
    {
        return create(TRANSFORM_NONE, entities);
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#create(int, java.util.Collection)
     */
    public java.util.Collection create(final int transform, final java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Estado.create - 'entities' can not be null");
        }
        this.getHibernateTemplate().execute(
            new org.springframework.orm.hibernate3.HibernateCallback()
            {
                public Object doInHibernate(org.hibernate.Session session)
                    throws org.hibernate.HibernateException
                {
                    for (java.util.Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
                    {
                        create(transform, (es.pode.publicacion.negocio.dominio.Estado)entityIterator.next());
                    }
                    return null;
                }
            },
            true);
        return entities;
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#create(int, java.lang.String)
     */
    public es.pode.publicacion.negocio.dominio.Estado create(
 java.lang.String nombre)
    {
         return (es.pode.publicacion.negocio.dominio.Estado)this.create(TRANSFORM_NONE,  nombre);
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#create(int, java.lang.String)
     */
    public Object create(
        final int transform,
 java.lang.String nombre)
    {
        es.pode.publicacion.negocio.dominio.Estado entity = new es.pode.publicacion.negocio.dominio.EstadoImpl();
        entity.setNombre(nombre);
        return this.create(transform, entity);
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#update(es.pode.publicacion.negocio.dominio.Estado)
     */
    public void update(es.pode.publicacion.negocio.dominio.Estado estado)
    {
        if (estado == null)
        {
            throw new IllegalArgumentException(
                "Estado.update - 'estado' can not be null");
        }
        this.getHibernateTemplate().update(estado);
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#update(java.util.Collection)
     */
    public void update(final java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Estado.update - 'entities' can not be null");
        }
        this.getHibernateTemplate().execute(
            new org.springframework.orm.hibernate3.HibernateCallback()
            {
                public Object doInHibernate(org.hibernate.Session session)
                    throws org.hibernate.HibernateException
                {
                    for (java.util.Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
                    {
                        update((es.pode.publicacion.negocio.dominio.Estado)entityIterator.next());
                    }
                    return null;
                }
            },
            true);
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#remove(es.pode.publicacion.negocio.dominio.Estado)
     */
    public void remove(es.pode.publicacion.negocio.dominio.Estado estado)
    {
        if (estado == null)
        {
            throw new IllegalArgumentException(
                "Estado.remove - 'estado' can not be null");
        }
        this.getHibernateTemplate().delete(estado);
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#remove(java.lang.Long)
     */
    public void remove(java.lang.Long id)
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "Estado.remove - 'id' can not be null");
        }
        es.pode.publicacion.negocio.dominio.Estado entity = this.load(id);
        if (entity != null)
        {
            this.remove(entity);
        }
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#remove(java.util.Collection)
     */
    public void remove(java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Estado.remove - 'entities' can not be null");
        }
        this.getHibernateTemplate().deleteAll(entities);
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.Estado#obtenEstadoPorNombre(java.lang.String)
     */
    public es.pode.publicacion.negocio.dominio.Estado obtenEstadoPorNombre(java.lang.String nombre)
    {
        return (es.pode.publicacion.negocio.dominio.Estado)this.obtenEstadoPorNombre(TRANSFORM_NONE, nombre);
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.Estado#obtenEstadoPorNombre(java.lang.String, java.lang.String)
     */
    public es.pode.publicacion.negocio.dominio.Estado obtenEstadoPorNombre(final java.lang.String queryString, final java.lang.String nombre)
    {
        return (es.pode.publicacion.negocio.dominio.Estado)this.obtenEstadoPorNombre(TRANSFORM_NONE, queryString, nombre);
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.Estado#obtenEstadoPorNombre(int, java.lang.String)
     */
    public Object obtenEstadoPorNombre(final int transform, final java.lang.String nombre)
    {
        return this.obtenEstadoPorNombre(transform, "from es.pode.publicacion.negocio.dominio.Estado as estado where estado.nombre = :nombre", nombre);
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.Estado#obtenEstadoPorNombre(int, java.lang.String, java.lang.String)
     */
    public Object obtenEstadoPorNombre(final int transform, final java.lang.String queryString, final java.lang.String nombre)
    {
        try
        {
            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
            queryObject.setParameter("nombre", nombre);
            java.util.List results = queryObject.list();
            Object result = null;
            if (results != null)
            {
                if (results.size() > 1)
                {
                    throw new org.springframework.dao.InvalidDataAccessResourceUsageException(
                        "More than one instance of 'es.pode.publicacion.negocio.dominio.Estado"
                            + "' was found when executing query --> '" + queryString + "'");
                }
                else if (results.size() == 1)
                {
                    result = (es.pode.publicacion.negocio.dominio.Estado)results.iterator().next();
                }
            }
            result = transformEntity(transform, (es.pode.publicacion.negocio.dominio.Estado)result);
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
     * flag is set to one of the constants defined in <code>es.pode.publicacion.negocio.dominio.EstadoDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     * <p/>
     * This method will return instances of these types:
     * <ul>
     *   <li>{@link es.pode.publicacion.negocio.dominio.Estado} - {@link #TRANSFORM_NONE}</li>
     *   <li>{@link es.pode.publicacion.negocio.servicios.EstadoVO} - {@link TRANSFORM_ESTADOVO}</li>
     * </ul>
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link es.pode.publicacion.negocio.dominio.EstadoDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,java.util.Collection)
     */
    private final Object transformEntity(final int transform, final es.pode.publicacion.negocio.dominio.Estado entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case es.pode.publicacion.negocio.dominio.EstadoDao.TRANSFORM_ESTADOVO :
                    target = toEstadoVO(entity);
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
     * {@link #transformEntity(int,es.pode.publicacion.negocio.dominio.Estado)}
     * method. This method does not instantiate a new collection.
     * <p/>
     * This method is to be used internally only.
     *
     * @param transform one of the constants declared in <code>es.pode.publicacion.negocio.dominio.EstadoDao</code>
     * @param entities the collection of entities to transform
     * @return the same collection as the argument, but this time containing the transformed entities
     * @see #transformEntity(int,es.pode.publicacion.negocio.dominio.Estado)
     */
    private final void transformEntities(final int transform, final java.util.Collection entities)
    {
        switch (transform)
        {
            case es.pode.publicacion.negocio.dominio.EstadoDao.TRANSFORM_ESTADOVO :
                toEstadoVOCollection(entities);
                break;
            case TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }

    /**
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#toEstadoVOCollection(java.util.Collection)
     */
    public final void toEstadoVOCollection(java.util.Collection entities)
    {
        if (entities == null)
        {
            entities = java.util.Collections.EMPTY_LIST;
        }
        else
        {
            org.apache.commons.collections.CollectionUtils.transform(entities, ESTADOVO_TRANSFORMER);
        }
    }

    /**
     * Base implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link EstadoDaoImpl} class if you intend to use reporting queries.
     * @see es.pode.publicacion.negocio.dominio.EstadoDao#toEstadoVO(es.pode.publicacion.negocio.dominio.Estado)
     */
    protected es.pode.publicacion.negocio.servicios.EstadoVO toEstadoVO(Object[] row)
    {
        return null;
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link es.pode.publicacion.negocio.servicios.EstadoVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private final org.apache.commons.collections.Transformer ESTADOVO_TRANSFORMER =
        new org.apache.commons.collections.Transformer()
        {
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof es.pode.publicacion.negocio.dominio.Estado)
                {
                    result = toEstadoVO((es.pode.publicacion.negocio.dominio.Estado)input);
                }
                else if (input instanceof Object[])
                {
                    result = toEstadoVO((Object[])input);
                }
                return result;
            }
        };

	/**
	 * Copy a VO to a new entity using the default Dozer mappings.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 */
	public es.pode.publicacion.negocio.dominio.Estado fromEstadoVO(final es.pode.publicacion.negocio.servicios.EstadoVO vo) {
        //default mapping between VO and entity
        return (es.pode.publicacion.negocio.dominio.Estado) 
                  this.getBeanMapper().map(vo, es.pode.publicacion.negocio.dominio.EstadoImpl.class, DEF_MAPPING_ESTADOVO_ESTADO);
    }

	/**
	 * Copy a VO to an existing entity using the default Dozer mappings.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 */
    public void fromEstadoVO(es.pode.publicacion.negocio.servicios.EstadoVO vo, es.pode.publicacion.negocio.dominio.Estado entity) {
        //default mapping between VO and entity
        this.getBeanMapper().map(vo, entity, DEF_MAPPING_ESTADOVO_ESTADO);
    }
		
		
}
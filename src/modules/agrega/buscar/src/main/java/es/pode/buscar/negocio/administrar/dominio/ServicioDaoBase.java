// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringHibernateDaoBase.vsl in andromda-spring-cartridge.
//
package es.pode.buscar.negocio.administrar.dominio;

import net.sf.dozer.util.mapping.MapperIF;

/**
 * <p>
 * Base Spring DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>es.pode.buscar.negocio.administrar.dominio.Servicio</code>.
 * </p>
 *
 * @see es.pode.buscar.negocio.administrar.dominio.Servicio
 */
public abstract class ServicioDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements es.pode.buscar.negocio.administrar.dominio.ServicioDao
{



	
	/**
	 * Constant that identifies a mapping between an 
	 * entity (Servicio) and a VO (ServicioVO)
	 */
	public final static String DEF_MAPPING_SERVICIO_SERVICIOVO = "DEF_MAPPING_SERVICIO_SERVICIOVO";
	
	/**
	 * Constant that identifies a mapping between a 
	 * VO (ServicioVO) and an entity (Servicio)
	 */
	public final static String DEF_MAPPING_SERVICIOVO_SERVICIO = "DEF_MAPPING_SERVICIO_SERVICIOVOPRIME";
	
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
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#load(int, java.lang.Long)
     */
    public Object load(final int transform, final java.lang.Long id)
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "Servicio.load - 'id' can not be null");
        }
        final java.util.List list = this.getHibernateTemplate().find(
            "from es.pode.buscar.negocio.administrar.dominio.Servicio as entity where entity.id = ?", id);
        final Object entity = list != null && !list.isEmpty() ? list.iterator().next() : null;
        return transformEntity(transform, (es.pode.buscar.negocio.administrar.dominio.Servicio)entity);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#load(java.lang.Long)
     */
    public es.pode.buscar.negocio.administrar.dominio.Servicio load(java.lang.Long id)
    {
        return (es.pode.buscar.negocio.administrar.dominio.Servicio)this.load(TRANSFORM_NONE, id);
    }
    
    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#loadAll()
     */
    public java.util.Collection loadAll()
    {
        return this.loadAll(TRANSFORM_NONE);
    }
    
    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#loadAll(int)
     */
    public java.util.Collection loadAll(final int transform)
    {
        final java.util.Collection results = this.getHibernateTemplate().loadAll(es.pode.buscar.negocio.administrar.dominio.ServicioImpl.class);
        this.transformEntities(transform, results);
        return results;
    }
    

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#create(es.pode.buscar.negocio.administrar.dominio.Servicio)
     */
    public es.pode.buscar.negocio.administrar.dominio.Servicio create(es.pode.buscar.negocio.administrar.dominio.Servicio servicio)
    {
        return (es.pode.buscar.negocio.administrar.dominio.Servicio)this.create(TRANSFORM_NONE, servicio);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#create(int transform, es.pode.buscar.negocio.administrar.dominio.Servicio)
     */
    public Object create(final int transform, final es.pode.buscar.negocio.administrar.dominio.Servicio servicio)
    {
        if (servicio == null)
        {
            throw new IllegalArgumentException(
                "Servicio.create - 'servicio' can not be null");
        }
        Object identifier = this.getHibernateTemplate().save(servicio);
        servicio.setId((java.lang.Long)identifier);
        return this.transformEntity(transform, servicio);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#create(java.util.Collection)
     */
    public java.util.Collection create(final java.util.Collection entities)
    {
        return create(TRANSFORM_NONE, entities);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#create(int, java.util.Collection)
     */
    public java.util.Collection create(final int transform, final java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Servicio.create - 'entities' can not be null");
        }
        this.getHibernateTemplate().execute(
            new org.springframework.orm.hibernate3.HibernateCallback()
            {
                public Object doInHibernate(org.hibernate.Session session)
                    throws org.hibernate.HibernateException
                {
                    for (java.util.Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
                    {
                        create(transform, (es.pode.buscar.negocio.administrar.dominio.Servicio)entityIterator.next());
                    }
                    return null;
                }
            },
            true);
        return entities;
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#create(java.lang.String, java.lang.String, java.lang.String)
     */
    public es.pode.buscar.negocio.administrar.dominio.Servicio create(
        java.lang.String descripcion,
        java.lang.String url,
        java.lang.String nombre)
    {
        return (es.pode.buscar.negocio.administrar.dominio.Servicio)this.create(TRANSFORM_NONE, descripcion, url, nombre);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#create(int, java.lang.String, java.lang.String, java.lang.String)
     */
    public Object create(
        final int transform,
        java.lang.String descripcion,
        java.lang.String url,
        java.lang.String nombre)
    {
        es.pode.buscar.negocio.administrar.dominio.Servicio entity = new es.pode.buscar.negocio.administrar.dominio.ServicioImpl();
        entity.setDescripcion(descripcion);
        entity.setUrl(url);
        entity.setNombre(nombre);
        return this.create(transform, entity);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#update(es.pode.buscar.negocio.administrar.dominio.Servicio)
     */
    public void update(es.pode.buscar.negocio.administrar.dominio.Servicio servicio)
    {
        if (servicio == null)
        {
            throw new IllegalArgumentException(
                "Servicio.update - 'servicio' can not be null");
        }
        this.getHibernateTemplate().update(servicio);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#update(java.util.Collection)
     */
    public void update(final java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Servicio.update - 'entities' can not be null");
        }
        this.getHibernateTemplate().execute(
            new org.springframework.orm.hibernate3.HibernateCallback()
            {
                public Object doInHibernate(org.hibernate.Session session)
                    throws org.hibernate.HibernateException
                {
                    for (java.util.Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
                    {
                        update((es.pode.buscar.negocio.administrar.dominio.Servicio)entityIterator.next());
                    }
                    return null;
                }
            },
            true);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#remove(es.pode.buscar.negocio.administrar.dominio.Servicio)
     */
    public void remove(es.pode.buscar.negocio.administrar.dominio.Servicio servicio)
    {
        if (servicio == null)
        {
            throw new IllegalArgumentException(
                "Servicio.remove - 'servicio' can not be null");
        }
        this.getHibernateTemplate().delete(servicio);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#remove(java.lang.Long)
     */
    public void remove(java.lang.Long id)
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "Servicio.remove - 'id' can not be null");
        }
        es.pode.buscar.negocio.administrar.dominio.Servicio entity = this.load(id);
        if (entity != null)
        {
            this.remove(entity);
        }
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#remove(java.util.Collection)
     */
    public void remove(java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Servicio.remove - 'entities' can not be null");
        }
        this.getHibernateTemplate().deleteAll(entities);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.Servicio#obtenerServicios()
     */
    public java.util.List obtenerServicios()
    {
        return this.obtenerServicios(TRANSFORM_NONE);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.Servicio#obtenerServicios(java.lang.String)
     */
    public java.util.List obtenerServicios(final java.lang.String queryString)
    {
        return this.obtenerServicios(TRANSFORM_NONE, queryString);
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.Servicio#obtenerServicios(int)
     */
    public java.util.List obtenerServicios(final int transform)
    {
        return this.obtenerServicios(transform, "from es.pode.buscar.negocio.administrar.dominio.Servicio servicio order by servicio.descripcion asc");
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.Servicio#obtenerServicios(int, java.lang.String)
     */
    public java.util.List obtenerServicios(final int transform, final java.lang.String queryString)
    {
        try
        {
            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
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
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>es.pode.buscar.negocio.administrar.dominio.ServicioDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     * <p/>
     * This method will return instances of these types:
     * <ul>
     *   <li>{@link es.pode.buscar.negocio.administrar.dominio.Servicio} - {@link #TRANSFORM_NONE}</li>
     *   <li>{@link es.pode.buscar.negocio.administrar.servicio.ServicioVO} - {@link TRANSFORM_SERVICIOVO}</li>
     * </ul>
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link es.pode.buscar.negocio.administrar.dominio.ServicioDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,java.util.Collection)
     */
    private final Object transformEntity(final int transform, final es.pode.buscar.negocio.administrar.dominio.Servicio entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case es.pode.buscar.negocio.administrar.dominio.ServicioDao.TRANSFORM_SERVICIOVO :
                    target = toServicioVO(entity);
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
     * {@link #transformEntity(int,es.pode.buscar.negocio.administrar.dominio.Servicio)}
     * method. This method does not instantiate a new collection.
     * <p/>
     * This method is to be used internally only.
     *
     * @param transform one of the constants declared in <code>es.pode.buscar.negocio.administrar.dominio.ServicioDao</code>
     * @param entities the collection of entities to transform
     * @return the same collection as the argument, but this time containing the transformed entities
     * @see #transformEntity(int,es.pode.buscar.negocio.administrar.dominio.Servicio)
     */
    private final void transformEntities(final int transform, final java.util.Collection entities)
    {
        switch (transform)
        {
            case es.pode.buscar.negocio.administrar.dominio.ServicioDao.TRANSFORM_SERVICIOVO :
                toServicioVOCollection(entities);
                break;
            case TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }

    /**
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#toServicioVOCollection(java.util.Collection)
     */
    public final void toServicioVOCollection(java.util.Collection entities)
    {
        if (entities == null)
        {
            entities = java.util.Collections.EMPTY_LIST;
        }
        else
        {
            org.apache.commons.collections.CollectionUtils.transform(entities, SERVICIOVO_TRANSFORMER);
        }
    }

    /**
     * Base implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link ServicioDaoImpl} class if you intend to use reporting queries.
     * @see es.pode.buscar.negocio.administrar.dominio.ServicioDao#toServicioVO(es.pode.buscar.negocio.administrar.dominio.Servicio)
     */
    protected es.pode.buscar.negocio.administrar.servicio.ServicioVO toServicioVO(Object[] row)
    {
        return null;
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link es.pode.buscar.negocio.administrar.servicio.ServicioVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private final org.apache.commons.collections.Transformer SERVICIOVO_TRANSFORMER =
        new org.apache.commons.collections.Transformer()
        {
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof es.pode.buscar.negocio.administrar.dominio.Servicio)
                {
                    result = toServicioVO((es.pode.buscar.negocio.administrar.dominio.Servicio)input);
                }
                else if (input instanceof Object[])
                {
                    result = toServicioVO((Object[])input);
                }
                return result;
            }
        };

	/**
	 * Copy a VO to a new entity using the default Dozer mappings.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 */
	public es.pode.buscar.negocio.administrar.dominio.Servicio fromServicioVO(final es.pode.buscar.negocio.administrar.servicio.ServicioVO vo) {
        //default mapping between VO and entity
        return (es.pode.buscar.negocio.administrar.dominio.Servicio) 
                  this.getBeanMapper().map(vo, es.pode.buscar.negocio.administrar.dominio.ServicioImpl.class, DEF_MAPPING_SERVICIOVO_SERVICIO);
    }

	/**
	 * Copy a VO to an existing entity using the default Dozer mappings.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 */
    public void fromServicioVO(es.pode.buscar.negocio.administrar.servicio.ServicioVO vo, es.pode.buscar.negocio.administrar.dominio.Servicio entity) {
        //default mapping between VO and entity
        this.getBeanMapper().map(vo, entity, DEF_MAPPING_SERVICIOVO_SERVICIO);
    }
		
		
}
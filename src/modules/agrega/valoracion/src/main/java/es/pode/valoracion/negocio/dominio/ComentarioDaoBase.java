// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringHibernateDaoBase.vsl in andromda-spring-cartridge.
//
package es.pode.valoracion.negocio.dominio;

import es.pode.valoracion.negocio.servicios.ComentarioVO;
import java.util.ArrayList;
import java.util.Iterator;
import net.sf.dozer.util.mapping.MapperIF;

/**
 * <p>
 * Base Spring DAO Class: is able to create, update, remove, load, and find
 * objects of type <code>es.pode.valoracion.negocio.dominio.Comentario</code>.
 * </p>
 *
 * @see es.pode.valoracion.negocio.dominio.Comentario
 */
public abstract class ComentarioDaoBase
    extends org.springframework.orm.hibernate3.support.HibernateDaoSupport
    implements es.pode.valoracion.negocio.dominio.ComentarioDao
{



	

	/**
	 * Constant that identifies a mapping between an 
	 * entity (Comentario) and a VO (ComentarioVO)
	 */
	public final static String DEF_MAPPING_COMENTARIO_COMENTARIOVO = "DEF_MAPPING_COMENTARIO_COMENTARIOVO";
	
	/**
	 * Constant that identifies a mapping between a 
	 * VO (ComentarioVO) and an entity (Comentario)
	 */
	public final static String DEF_MAPPING_COMENTARIOVO_COMENTARIO = "DEF_MAPPING_COMENTARIOVO_COMENTARIO";
	
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
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#load(int, java.lang.Long)
     */
    public Object load(final int transform, final java.lang.Long id)
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "Comentario.load - 'id' can not be null");
        }
        final java.util.List list = this.getHibernateTemplate().find(
            "from es.pode.valoracion.negocio.dominio.Comentario as entity where entity.id = ?", id);
        final Object entity = list != null && !list.isEmpty() ? list.iterator().next() : null;
        return transformEntity(transform, (es.pode.valoracion.negocio.dominio.Comentario)entity);
    }

    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#load(java.lang.Long)
     */
    public es.pode.valoracion.negocio.dominio.Comentario load(java.lang.Long id)
    {
        return (es.pode.valoracion.negocio.dominio.Comentario)this.load(TRANSFORM_NONE, id);
    }
    
    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#loadAll()
     */
    public java.util.Collection loadAll()
    {
        return this.loadAll(TRANSFORM_NONE);
    }
    
    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#loadAll(int)
     */
    public java.util.Collection loadAll(final int transform)
    {
        final java.util.Collection results = this.getHibernateTemplate().loadAll(es.pode.valoracion.negocio.dominio.ComentarioImpl.class);
        this.transformEntities(transform, results);
        return results;
    }
    

    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#create(es.pode.valoracion.negocio.dominio.Comentario)
     */
    public es.pode.valoracion.negocio.dominio.Comentario create(es.pode.valoracion.negocio.dominio.Comentario comentario)
    {
        return (es.pode.valoracion.negocio.dominio.Comentario)this.create(TRANSFORM_NONE, comentario);
    }

    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#create(int transform, es.pode.valoracion.negocio.dominio.Comentario)
     */
    public Object create(final int transform, final es.pode.valoracion.negocio.dominio.Comentario comentario)
    {
        if (comentario == null)
        {
            throw new IllegalArgumentException(
                "Comentario.create - 'comentario' can not be null");
        }
        Object identifier = this.getHibernateTemplate().save(comentario);
        comentario.setId((java.lang.Long)identifier);
        return this.transformEntity(transform, comentario);
    }

    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#create(java.util.Collection)
     */
    public java.util.Collection create(final java.util.Collection entities)
    {
        return create(TRANSFORM_NONE, entities);
    }

    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#create(int, java.util.Collection)
     */
    public java.util.Collection create(final int transform, final java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Comentario.create - 'entities' can not be null");
        }
        this.getHibernateTemplate().execute(
            new org.springframework.orm.hibernate3.HibernateCallback()
            {
                public Object doInHibernate(org.hibernate.Session session)
                    throws org.hibernate.HibernateException
                {
                    for (java.util.Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
                    {
                        create(transform, (es.pode.valoracion.negocio.dominio.Comentario)entityIterator.next());
                    }
                    return null;
                }
            },
            true);
        return entities;
    }

    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#create(int, java.lang.String,java.util.Calendar,java.lang.String,java.lang.String,java.lang.String)
     */
    public es.pode.valoracion.negocio.dominio.Comentario create(
 java.lang.String comentario, java.util.Calendar fecha, java.lang.String idODE, java.lang.String idiomaODE, java.lang.String usuario)
    {
         return (es.pode.valoracion.negocio.dominio.Comentario)this.create(TRANSFORM_NONE,  comentario, fecha, idODE, idiomaODE, usuario);
    }

    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#create(int, java.lang.String,java.util.Calendar,java.lang.String,java.lang.String,java.lang.String)
     */
    public Object create(
        final int transform,
 java.lang.String comentario, java.util.Calendar fecha, java.lang.String idODE, java.lang.String idiomaODE, java.lang.String usuario)
    {
        es.pode.valoracion.negocio.dominio.Comentario entity = new es.pode.valoracion.negocio.dominio.ComentarioImpl();
        entity.setComentario(comentario);
        entity.setFecha(fecha);
        entity.setIdODE(idODE);
        entity.setIdiomaODE(idiomaODE);
        entity.setUsuario(usuario);
        return this.create(transform, entity);
    }

    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#update(es.pode.valoracion.negocio.dominio.Comentario)
     */
    public void update(es.pode.valoracion.negocio.dominio.Comentario comentario)
    {
        if (comentario == null)
        {
            throw new IllegalArgumentException(
                "Comentario.update - 'comentario' can not be null");
        }
        this.getHibernateTemplate().update(comentario);
    }

    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#update(java.util.Collection)
     */
    public void update(final java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Comentario.update - 'entities' can not be null");
        }
        this.getHibernateTemplate().execute(
            new org.springframework.orm.hibernate3.HibernateCallback()
            {
                public Object doInHibernate(org.hibernate.Session session)
                    throws org.hibernate.HibernateException
                {
                    for (java.util.Iterator entityIterator = entities.iterator(); entityIterator.hasNext();)
                    {
                        update((es.pode.valoracion.negocio.dominio.Comentario)entityIterator.next());
                    }
                    return null;
                }
            },
            true);
    }

    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#remove(es.pode.valoracion.negocio.dominio.Comentario)
     */
    public void remove(es.pode.valoracion.negocio.dominio.Comentario comentario)
    {
        if (comentario == null)
        {
            throw new IllegalArgumentException(
                "Comentario.remove - 'comentario' can not be null");
        }
        this.getHibernateTemplate().delete(comentario);
    }

    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#remove(java.lang.Long)
     */
    public void remove(java.lang.Long id)
    {
        if (id == null)
        {
            throw new IllegalArgumentException(
                "Comentario.remove - 'id' can not be null");
        }
        es.pode.valoracion.negocio.dominio.Comentario entity = this.load(id);
        if (entity != null)
        {
            this.remove(entity);
        }
    }

    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#remove(java.util.Collection)
     */
    public void remove(java.util.Collection entities)
    {
        if (entities == null)
        {
            throw new IllegalArgumentException(
                "Comentario.remove - 'entities' can not be null");
        }
        this.getHibernateTemplate().deleteAll(entities);
    }

    /**
     * @see es.pode.valoracion.negocio.dominio.Comentario#buscarComentariosPorCriterioODE(es.pode.valoracion.negocio.dominio.IdODEFechaCriteria)
     */
    public java.util.List buscarComentariosPorCriterioODE(es.pode.valoracion.negocio.dominio.IdODEFechaCriteria criterio)
    {
        return this.buscarComentariosPorCriterioODE(TRANSFORM_NONE, criterio);
    }

    /**
     * @see es.pode.valoracion.negocio.dominio.Comentario#buscarComentariosPorCriterioODE(int, java.lang.String, es.pode.valoracion.negocio.dominio.IdODEFechaCriteria)
     */
    public java.util.List buscarComentariosPorCriterioODE(final int transform, final es.pode.valoracion.negocio.dominio.IdODEFechaCriteria criterio)
    {
        try
        {
            // 05/10/2010   Fernando Garcia
            //  now your get name and surname like part of the comment
            //  I am trying that this will be compatible with all calls to this service
            String queryString =
                "select usuario.nombre||' '||usuario.apellido1, comentario.id, comentario.fecha ,comentario.idODE ,comentario.usuario ,comentario.comentario  from es.pode.valoracion.negocio.dominio.Comentario as comentario, es.pode.valoracion.negocio.dominio.Usuario as usuario where " +
                " comentario.idODE = :idODE and usuario.usuario = comentario.usuario order by comentario.fecha desc  ";


            org.hibernate.Query queryObject = super.getSession(false).createQuery(queryString);
            queryObject.setParameter("idODE", criterio.getIdODE());

            java.util.List result = queryObject.list();

            ArrayList<ComentarioVO> listComments = new ArrayList<ComentarioVO>(result.size());

            Iterator itResult = result.iterator();
            while (itResult.hasNext()) {
                Object[] comment = (Object[])itResult.next();
                listComments.add(new ComentarioVO(comment[0] + ": " + comment[5], (java.util.Calendar)comment[2],
                        ""+ comment[3] ,(Long)comment[1] ,"" + comment[4]));

            }

            return listComments;

            
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
    protected es.pode.CriteriaSearch modifybuscarComentariosPorCriterioODE (es.pode.CriteriaSearch criteriaSearch){
        return criteriaSearch;
    }
    

    /**
     * Allows transformation of entities into value objects
     * (or something else for that matter), when the <code>transform</code>
     * flag is set to one of the constants defined in <code>es.pode.valoracion.negocio.dominio.ComentarioDao</code>, please note
     * that the {@link #TRANSFORM_NONE} constant denotes no transformation, so the entity itself
     * will be returned.
     * <p/>
     * This method will return instances of these types:
     * <ul>
     *   <li>{@link es.pode.valoracion.negocio.dominio.Comentario} - {@link #TRANSFORM_NONE}</li>
     *   <li>{@link es.pode.valoracion.negocio.servicios.ComentarioVO} - {@link TRANSFORM_COMENTARIOVO}</li>
     * </ul>
     *
     * If the integer argument value is unknown {@link #TRANSFORM_NONE} is assumed.
     *
     * @param transform one of the constants declared in {@link es.pode.valoracion.negocio.dominio.ComentarioDao}
     * @param entity an entity that was found
     * @return the transformed entity (i.e. new value object, etc)
     * @see #transformEntities(int,java.util.Collection)
     */
    private final Object transformEntity(final int transform, final es.pode.valoracion.negocio.dominio.Comentario entity)
    {
        Object target = null;
        if (entity != null)
        {
            switch (transform)
            {
                case es.pode.valoracion.negocio.dominio.ComentarioDao.TRANSFORM_COMENTARIOVO :
                    target = toComentarioVO(entity);
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
     * {@link #transformEntity(int,es.pode.valoracion.negocio.dominio.Comentario)}
     * method. This method does not instantiate a new collection.
     * <p/>
     * This method is to be used internally only.
     *
     * @param transform one of the constants declared in <code>es.pode.valoracion.negocio.dominio.ComentarioDao</code>
     * @param entities the collection of entities to transform
     * @return the same collection as the argument, but this time containing the transformed entities
     * @see #transformEntity(int,es.pode.valoracion.negocio.dominio.Comentario)
     */
    private final void transformEntities(final int transform, final java.util.Collection entities)
    {
        switch (transform)
        {
            case es.pode.valoracion.negocio.dominio.ComentarioDao.TRANSFORM_COMENTARIOVO :
                toComentarioVOCollection(entities);
                break;
            case TRANSFORM_NONE : // fall-through
                default:
                // do nothing;
        }
    }

    /**
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#toComentarioVOCollection(java.util.Collection)
     */
    public final void toComentarioVOCollection(java.util.Collection entities)
    {
        if (entities == null)
        {
            entities = java.util.Collections.EMPTY_LIST;
        }
        else
        {
            org.apache.commons.collections.CollectionUtils.transform(entities, COMENTARIOVO_TRANSFORMER);
        }
    }

    /**
     * Base implementation for transforming the results of a report query into a value object. This
     * implementation exists for convenience reasons only. It needs only be overridden in the
     * {@link ComentarioDaoImpl} class if you intend to use reporting queries.
     * @see es.pode.valoracion.negocio.dominio.ComentarioDao#toComentarioVO(es.pode.valoracion.negocio.dominio.Comentario)
     */
    protected es.pode.valoracion.negocio.servicios.ComentarioVO toComentarioVO(Object[] row)
    {
        return null;
    }

    /**
     * This anonymous transformer is designed to transform entities or report query results
     * (which result in an array of objects) to {@link es.pode.valoracion.negocio.servicios.ComentarioVO}
     * using the Jakarta Commons-Collections Transformation API.
     */
    private final org.apache.commons.collections.Transformer COMENTARIOVO_TRANSFORMER =
        new org.apache.commons.collections.Transformer()
        {
            public Object transform(Object input)
            {
                Object result = null;
                if (input instanceof es.pode.valoracion.negocio.dominio.Comentario)
                {
                    result = toComentarioVO((es.pode.valoracion.negocio.dominio.Comentario)input);
                }
                else if (input instanceof Object[])
                {
                    result = toComentarioVO((Object[])input);
                }
                return result;
            }
        };

	/**
	 * Copy a VO to a new entity using the default Dozer mappings.
	 * @param vo The source bean (VO)
	 * @return A new entity created with the values extracted from the vo.
	 */
	public es.pode.valoracion.negocio.dominio.Comentario fromComentarioVO(final es.pode.valoracion.negocio.servicios.ComentarioVO vo) {
        //default mapping between VO and entity
        return (es.pode.valoracion.negocio.dominio.Comentario) 
                  this.getBeanMapper().map(vo, es.pode.valoracion.negocio.dominio.ComentarioImpl.class, DEF_MAPPING_COMENTARIOVO_COMENTARIO);
    }

	/**
	 * Copy a VO to an existing entity using the default Dozer mappings.
	 * @param vo The source bean (VO)
	 * @param entity The destination bean (an existing entity)
	 */
    public void fromComentarioVO(es.pode.valoracion.negocio.servicios.ComentarioVO vo, es.pode.valoracion.negocio.dominio.Comentario entity) {
        //default mapping between VO and entity
        this.getBeanMapper().map(vo, entity, DEF_MAPPING_COMENTARIOVO_COMENTARIO);
    }
		
		
}
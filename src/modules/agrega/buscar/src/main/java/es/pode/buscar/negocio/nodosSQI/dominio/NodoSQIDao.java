// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringDao.vsl in andromda-spring-cartridge.
//
package es.pode.buscar.negocio.nodosSQI.dominio;

/**
 * @see es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI
 */
public interface NodoSQIDao
{
    /**
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p/>
     * This specific flag denotes no transformation will occur.
     */
    public final static int TRANSFORM_NONE = 0;

    /**
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p/>
     * This specific flag denotes entities must be transformed into objects of type
     * {@link es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO}.
     */
    public final static int TRANSFORM_NODOSQIVO = 1;

    /**
     * Converts this DAO's entity to an object of type {@link es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO}.
     */
    public es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO toNodoSQIVO(es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI entity);

    /**
     * Converts this DAO's entity to a Collection of instances of type {@link es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO}.
     */
    public void toNodoSQIVOCollection(java.util.Collection entities);

    public es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI fromNodoSQIVO(es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO vo);
    
    public void fromNodoSQIVO(es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO vo, es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI entity);    


    /**
     * This constant is used as a transformation flag; entities can be converted automatically into value objects
     * or other types, different methods in a class implementing this interface support this feature: look for
     * an <code>int</code> parameter called <code>transform</code>.
     * <p/>
     * This specific flag denotes entities must be transformed into objects of type
     * {@link es.pode.buscar.negocio.nodosSQI.servicio.NodoDescripcionSQIVO}.
     */
    public final static int TRANSFORM_NODODESCRIPCIONSQIVO = 2;

    /**
     * Converts this DAO's entity to an object of type {@link es.pode.buscar.negocio.nodosSQI.servicio.NodoDescripcionSQIVO}.
     */
    public es.pode.buscar.negocio.nodosSQI.servicio.NodoDescripcionSQIVO toNodoDescripcionSQIVO(es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI entity);

    /**
     * Converts this DAO's entity to a Collection of instances of type {@link es.pode.buscar.negocio.nodosSQI.servicio.NodoDescripcionSQIVO}.
     */
    public void toNodoDescripcionSQIVOCollection(java.util.Collection entities);

    public es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI fromNodoDescripcionSQIVO(es.pode.buscar.negocio.nodosSQI.servicio.NodoDescripcionSQIVO vo);
    
    public void fromNodoDescripcionSQIVO(es.pode.buscar.negocio.nodosSQI.servicio.NodoDescripcionSQIVO vo, es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI entity);    


    /**
     * Loads an instance of es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI from the persistent store.
     */
    public es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI load(java.lang.Long id);

    /**
     * <p>
     *   Does the same thing as {@link #load(java.lang.Long)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined in this class then the result <strong>WILL BE</strong> passed through an operation which can
     *   optionally transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     *
     * @param id the identifier of the entity to load.
     * @return either the entity or the object transformed from the entity.
     */
    public Object load(int transform, java.lang.Long id);
    
    /**
     * Loads all entities of type {@link es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI}. 
     * 
     * @return the loaded entities.
     */
    public java.util.Collection loadAll();
    
    /** 
     * <p>
     *   Does the same thing as {@link #loadAll()} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     * 
     * @param transform the flag indicating what transformation to use.
     * @return the loaded entities.
     */
    public java.util.Collection loadAll(final int transform);

    /**
     * Creates an instance of es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI and adds it to the persistent store.
     */
    public es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI create(es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI nodoSQI);

    /**
     * <p>
     *   Does the same thing as {@link #create(es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public Object create(int transform, es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI nodoSQI);

    /**
     * Creates a new instance of es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI and adds
     * from the passed in <code>entities</code> collection
     *
     * @param entities the collection of es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI
     *        instances to create.
     *
     * @return the created instances.
     */
    public java.util.Collection create(java.util.Collection entities);

    /**
     * <p>
     *   Does the same thing as {@link #create(es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.Collection create(int transform, java.util.Collection entities);

    /**
     * <p>
     *   Creates a new <code>es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI</code>
     *   instance from <strong>all</strong> attributes and adds it to
     *   the persistent store.
     * </p>
     */
    public es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI create(
        java.lang.String urlServicio,
        java.lang.String gestorSesion,
        java.lang.String lenguajeConsulta,
        java.lang.String lenguajeRespuesta,
        java.lang.String descripcionNodo,
        java.lang.String usuario,
        java.lang.String clave,
        java.lang.String identificadorSesion,
        java.lang.String nombreNodo);

    /**
     * <p>
     *   Does the same thing as {@link #create(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public Object create(
        int transform,
        java.lang.String urlServicio,
        java.lang.String gestorSesion,
        java.lang.String lenguajeConsulta,
        java.lang.String lenguajeRespuesta,
        java.lang.String descripcionNodo,
        java.lang.String usuario,
        java.lang.String clave,
        java.lang.String identificadorSesion,
        java.lang.String nombreNodo);


    /**
     * Updates the <code>nodoSQI</code> instance in the persistent store.
     */
    public void update(es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI nodoSQI);

    /**
     * Updates all instances in the <code>entities</code> collection in the persistent store.
     */
    public void update(java.util.Collection entities);

    /**
     * Removes the instance of es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI from the persistent store.
     */
    public void remove(es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI nodoSQI);

    /**
     * Removes the instance of es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI having the given
     * <code>identifier</code> from the persistent store.
     */
    public void remove(java.lang.Long id);

    /**
     * Removes all entities in the given <code>entities<code> collection.
     */
    public void remove(java.util.Collection entities);

    /**
     * <p>
     * Metodo para listar todos los nodos de tipo SQI
     * </p>
     */
    public java.util.List listarNodosSQI();

    /**
     * <p>
     *   Does the same thing as {@link #listarNodosSQI()} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #listarNodosSQI()}.
     * </p>
     */
    public java.util.List listarNodosSQI(String queryString);

    /**
     * <p>
     *   Does the same thing as {@link #listarNodosSQI()} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List listarNodosSQI(int transform);

    /**
     * <p>
     *   Does the same thing as {@link #listarNodosSQI(boolean)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #listarNodosSQI(int)}.
     * </p>
     */
    public java.util.List listarNodosSQI(int transform, String queryString);

    /**
     * <p>
     * Metodo para consultar los nodos de tipo SQI
     * </p>
     */
    public java.util.List consultarNodosSQI(es.pode.buscar.negocio.nodosSQI.dominio.NodosSQIPorIDCriteria criterio);

    /**
     * <p>
     *   Does the same thing as {@link #consultarNodosSQI(es.pode.buscar.negocio.nodosSQI.dominio.NodosSQIPorIDCriteria)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List consultarNodosSQI(final int transform, final es.pode.buscar.negocio.nodosSQI.dominio.NodosSQIPorIDCriteria criterio);

}

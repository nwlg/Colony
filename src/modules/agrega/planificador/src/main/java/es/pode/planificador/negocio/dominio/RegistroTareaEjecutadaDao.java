// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringDao.vsl in andromda-spring-cartridge.
//
package es.pode.planificador.negocio.dominio;

/**
 * @see es.pode.planificador.negocio.dominio.RegistroTareaEjecutada
 */
public interface RegistroTareaEjecutadaDao
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
     * {@link es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO}.
     */
    public final static int TRANSFORM_REGISTROTAREAEJECUTADAVO = 1;
    
    
    /**
     * Converts this DAO's entity to an object of type {@link es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO}.
     * @param entity es.pode.planificador.negocio.dominio.RegistroTareaEjecutada
     * @return es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO     
     */
    public es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO toRegistroTareaEjecutadaVO(es.pode.planificador.negocio.dominio.RegistroTareaEjecutada entity);

    /**
     * Converts this DAO's entity to a Collection of instances of type {@link es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO}.
     * @param entities java.util.Collection
     */
    public void toRegistroTareaEjecutadaVOCollection(java.util.Collection entities);

    public es.pode.planificador.negocio.dominio.RegistroTareaEjecutada fromRegistroTareaEjecutadaVO(es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO vo);
    
    public void fromRegistroTareaEjecutadaVO(es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO vo, es.pode.planificador.negocio.dominio.RegistroTareaEjecutada entity);    


    /**
     * Loads an instance of es.pode.planificador.negocio.dominio.RegistroTareaEjecutada from the persistent store.
     * @param id java.lang.Long
     * @return es.pode.planificador.negocio.dominio.RegistroTareaEjecutada     
     */
    public es.pode.planificador.negocio.dominio.RegistroTareaEjecutada load(java.lang.Long id);

    /**
     * <p>
     *   Does the same thing as {@link #load(java.lang.Long)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined in this class then the result <strong>WILL BE</strong> passed through an operation which can
     *   optionally transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int   
     * @param id the identifier of the entity to load.
     * @return either the entity or the object transformed from the entity.
     */
    public Object load(int transform, java.lang.Long id);
    
    /**
     * Loads all entities of type {@link es.pode.planificador.negocio.dominio.RegistroTareaEjecutada}. 
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
     * Creates an instance of es.pode.planificador.negocio.dominio.RegistroTareaEjecutada and adds it to the persistent store.
     * @param registroTareaEjecutada es.pode.planificador.negocio.dominio.RegistroTareaEjecutada
     * @return es.pode.planificador.negocio.dominio.RegistroTareaEjecutada     
     */
    public es.pode.planificador.negocio.dominio.RegistroTareaEjecutada create(es.pode.planificador.negocio.dominio.RegistroTareaEjecutada registroTareaEjecutada);

    /**
     * <p>
     *   Does the same thing as {@link #create(es.pode.planificador.negocio.dominio.RegistroTareaEjecutada)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int
     * @param registroTareaEjecutada es.pode.planificador.negocio.dominio.RegistroTareaEjecutada
     * @return Object     
     */
    public Object create(int transform, es.pode.planificador.negocio.dominio.RegistroTareaEjecutada registroTareaEjecutada);

    /**
     * Creates a new instance of es.pode.planificador.negocio.dominio.RegistroTareaEjecutada and adds
     * from the passed in <code>entities</code> collection
     *
     * @param entities the collection of es.pode.planificador.negocio.dominio.RegistroTareaEjecutada
     *        instances to create.
     *
     * @return the created instances.
     */
    public java.util.Collection create(java.util.Collection entities);

    /**
     * <p>
     *   Does the same thing as {@link #create(es.pode.planificador.negocio.dominio.RegistroTareaEjecutada)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int
     * @param entities java.util.Collection
     * @return java.util.Collection        
     */
    public java.util.Collection create(int transform, java.util.Collection entities);

    /**
     * <p>
     *   Creates a new <code>es.pode.planificador.negocio.dominio.RegistroTareaEjecutada</code>
     *   instance from <strong>all</strong> attributes and adds it to
     *   the persistent store.
     * </p>
					 * @param descripcion java.lang.String  
						    		 * @param fecha java.util.Calendar  
						    		 * @param estado java.lang.String  
						    		 * @param codigo java.lang.String  
			     * @return es.pode.planificador.negocio.dominio.RegistroTareaEjecutada
     */
    public es.pode.planificador.negocio.dominio.RegistroTareaEjecutada create(
					java.lang.String descripcion 
						,		java.util.Calendar fecha 
						,		java.lang.String estado 
						,		java.lang.String codigo 
			);



    /**
     * <p>
     *   Does the same thing as {@link #create(java.lang.String, java.util.Calendar, java.lang.String, java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param int
					 * @param descripcion java.lang.String 
						    		 * @param fecha java.util.Calendar 
						    		 * @param estado java.lang.String 
						    		 * @param codigo java.lang.String 
			     * @return Object
     */
    public Object create(int transform,
					java.lang.String descripcion 
						,		java.util.Calendar fecha 
						,		java.lang.String estado 
						,		java.lang.String codigo 
			);
    /**
     * <p>
     *  Creates a new <code>es.pode.planificador.negocio.dominio.RegistroTareaEjecutada</code>
     *  instance from only <strong>required</strong> properties (attributes
     *  and association ends) and adds it to the persistent store.
     * </p>
     * @param descripcion java.lang.String
     * @param estado java.lang.String
     * @param fecha java.util.Calendar
     * @param tarea_ejecutada es.pode.planificador.negocio.dominio.TareaEjecutada
     * @return es.pode.planificador.negocio.dominio.RegistroTareaEjecutada
     */
    public es.pode.planificador.negocio.dominio.RegistroTareaEjecutada create(
		java.lang.String descripcion,
		java.util.Calendar fecha,
		java.lang.String estado,
		java.lang.String codigo,
		es.pode.planificador.negocio.dominio.TareaEjecutada tarea_ejecutada);

    /**
     * <p>
     *   Does the same thing as {@link #create(java.lang.String, java.util.Calendar, java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int
     * @param descripcion java.lang.String
     * @param estado java.lang.String
     * @param fecha java.util.Calendar
     * @param tarea_ejecutada es.pode.planificador.negocio.dominio.TareaEjecutada
     * @return Object
     */
    public Object create(
        int transform,
		java.lang.String descripcion,
		java.util.Calendar fecha,
		java.lang.String estado,
		java.lang.String codigo,
		es.pode.planificador.negocio.dominio.TareaEjecutada tarea_ejecutada);



    /**
     * Updates the <code>registroTareaEjecutada</code> instance in the persistent store.
     * @param registroTareaEjecutada es.pode.planificador.negocio.dominio.RegistroTareaEjecutada
     */
    public void update(es.pode.planificador.negocio.dominio.RegistroTareaEjecutada registroTareaEjecutada);

    /**
     * Updates all instances in the <code>entities</code> collection in the persistent store.
     * @param entities java.util.Collection
     */
    public void update(java.util.Collection entities);

    /**
     * Removes the instance of es.pode.planificador.negocio.dominio.RegistroTareaEjecutada from the persistent store.
     * @param registroTareaEjecutada es.pode.planificador.negocio.dominio.RegistroTareaEjecutada  
     */
    public void remove(es.pode.planificador.negocio.dominio.RegistroTareaEjecutada registroTareaEjecutada);

    /**
     * Removes the instance of es.pode.planificador.negocio.dominio.RegistroTareaEjecutada having the given
     * <code>identifier</code> from the persistent store.
     * @param id java.lang.Long
     */
    public void remove(java.lang.Long id);

    /**
     * Removes all entities in the given <code>entities<code> collection.
     * @param entities java.util.Collection
     */
    public void remove(java.util.Collection entities);

  /**
   * <p>
   * Buscamos los trabajos hijos que no se han ejecutado
   * correctamente
   * </p>
      * @return java.util.List
   */
    public java.util.List buscarTrabajosNoCorrectos(es.pode.planificador.negocio.dominio.TrabajosNoCorrectosCriteria criterios);

    /**
     * <p>
     *   Does the same thing as {@link #buscarTrabajosNoCorrectos(es.pode.planificador.negocio.dominio.TrabajosNoCorrectosCriteria)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int
        * @return java.util.List
     */
    public java.util.List buscarTrabajosNoCorrectos(final int transform, final es.pode.planificador.negocio.dominio.TrabajosNoCorrectosCriteria criterios);

}

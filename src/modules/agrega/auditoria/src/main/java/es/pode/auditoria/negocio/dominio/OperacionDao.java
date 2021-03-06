// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringDao.vsl in andromda-spring-cartridge.
//
package es.pode.auditoria.negocio.dominio;

/**
 * @see es.pode.auditoria.negocio.dominio.Operacion
 */
public interface OperacionDao
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
     * {@link es.pode.auditoria.negocio.servicios.OperacionVO}.
     */
    public final static int TRANSFORM_OPERACIONVO = 1;
    
    
    /**
     * Converts this DAO's entity to an object of type {@link es.pode.auditoria.negocio.servicios.OperacionVO}.
     * @param entity es.pode.auditoria.negocio.dominio.Operacion
     * @return es.pode.auditoria.negocio.servicios.OperacionVO     
     */
    public es.pode.auditoria.negocio.servicios.OperacionVO toOperacionVO(es.pode.auditoria.negocio.dominio.Operacion entity);

    /**
     * Converts this DAO's entity to a Collection of instances of type {@link es.pode.auditoria.negocio.servicios.OperacionVO}.
     * @param entities java.util.Collection
     */
    public void toOperacionVOCollection(java.util.Collection entities);

    public es.pode.auditoria.negocio.dominio.Operacion fromOperacionVO(es.pode.auditoria.negocio.servicios.OperacionVO vo);
    
    public void fromOperacionVO(es.pode.auditoria.negocio.servicios.OperacionVO vo, es.pode.auditoria.negocio.dominio.Operacion entity);    


    /**
     * Loads an instance of es.pode.auditoria.negocio.dominio.Operacion from the persistent store.
     * @param id java.lang.Long
     * @return es.pode.auditoria.negocio.dominio.Operacion     
     */
    public es.pode.auditoria.negocio.dominio.Operacion load(java.lang.Long id);

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
     * Loads all entities of type {@link es.pode.auditoria.negocio.dominio.Operacion}. 
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
     * Creates an instance of es.pode.auditoria.negocio.dominio.Operacion and adds it to the persistent store.
     * @param operacion es.pode.auditoria.negocio.dominio.Operacion
     * @return es.pode.auditoria.negocio.dominio.Operacion     
     */
    public es.pode.auditoria.negocio.dominio.Operacion create(es.pode.auditoria.negocio.dominio.Operacion operacion);

    /**
     * <p>
     *   Does the same thing as {@link #create(es.pode.auditoria.negocio.dominio.Operacion)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int
     * @param operacion es.pode.auditoria.negocio.dominio.Operacion
     * @return Object     
     */
    public Object create(int transform, es.pode.auditoria.negocio.dominio.Operacion operacion);

    /**
     * Creates a new instance of es.pode.auditoria.negocio.dominio.Operacion and adds
     * from the passed in <code>entities</code> collection
     *
     * @param entities the collection of es.pode.auditoria.negocio.dominio.Operacion
     *        instances to create.
     *
     * @return the created instances.
     */
    public java.util.Collection create(java.util.Collection entities);

    /**
     * <p>
     *   Does the same thing as {@link #create(es.pode.auditoria.negocio.dominio.Operacion)} with an
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
     *   Creates a new <code>es.pode.auditoria.negocio.dominio.Operacion</code>
     *   instance from <strong>all</strong> attributes and adds it to
     *   the persistent store.
     * </p>
					 * @param idOde java.lang.String  
						    		 * @param tituloOde java.lang.String  
						    		 * @param usuario java.lang.String  
						    		 * @param fecha java.util.Calendar  
						    		 * @param operacion java.lang.String  
						    		 * @param idioma java.lang.String  
			     * @return es.pode.auditoria.negocio.dominio.Operacion
     */
    public es.pode.auditoria.negocio.dominio.Operacion create(
					java.lang.String idOde 
						,		java.lang.String tituloOde 
						,		java.lang.String usuario 
						,		java.util.Calendar fecha 
						,		java.lang.String operacion 
						,		java.lang.String idioma 
			);



    /**
     * <p>
     *   Does the same thing as {@link #create(java.lang.String, java.lang.String, java.lang.String, java.util.Calendar, java.lang.String, java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param int
					 * @param idOde java.lang.String 
						    		 * @param tituloOde java.lang.String 
						    		 * @param usuario java.lang.String 
						    		 * @param fecha java.util.Calendar 
						    		 * @param operacion java.lang.String 
						    		 * @param idioma java.lang.String 
			     * @return Object
     */
    public Object create(int transform,
					java.lang.String idOde 
						,		java.lang.String tituloOde 
						,		java.lang.String usuario 
						,		java.util.Calendar fecha 
						,		java.lang.String operacion 
						,		java.lang.String idioma 
			);



    /**
     * Updates the <code>operacion</code> instance in the persistent store.
     * @param operacion es.pode.auditoria.negocio.dominio.Operacion
     */
    public void update(es.pode.auditoria.negocio.dominio.Operacion operacion);

    /**
     * Updates all instances in the <code>entities</code> collection in the persistent store.
     * @param entities java.util.Collection
     */
    public void update(java.util.Collection entities);

    /**
     * Removes the instance of es.pode.auditoria.negocio.dominio.Operacion from the persistent store.
     * @param operacion es.pode.auditoria.negocio.dominio.Operacion  
     */
    public void remove(es.pode.auditoria.negocio.dominio.Operacion operacion);

    /**
     * Removes the instance of es.pode.auditoria.negocio.dominio.Operacion having the given
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
     * TODO: document it
     * @param transform
     * @param fechaDesde
     * @param fechaHasta
     * @param operacion
     * @return
     */
    public Long obtenerNumOperacionesDesdeHastaLike(final java.util.Calendar fechaDesde, final java.util.Calendar fechaHasta, final java.lang.String operacionLike);

    public java.lang.Long obtenerNumOperacionesDesdeHasta(java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerNumOperacionesDesdeHasta(java.util.Calendar, java.util.Calendar, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerNumOperacionesDesdeHasta(java.util.Calendar, java.util.Calendar, java.lang.String)}.
     * </p>
     * @param queryString String
              * @return java.lang.Long
     */
    public java.lang.Long obtenerNumOperacionesDesdeHasta(String queryString, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerNumOperacionesDesdeHasta(java.util.Calendar, java.util.Calendar, java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int
              * @return Object
     */
    public Object obtenerNumOperacionesDesdeHasta(int transform, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerNumOperacionesDesdeHasta(boolean, java.util.Calendar, java.util.Calendar, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerNumOperacionesDesdeHasta(int, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String operacion)}.
     * </p>
     * @param transform int
     * @param queryString String     
              * @return Object
     */
    public Object obtenerNumOperacionesDesdeHasta(int transform, String queryString, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String operacion);

    public java.util.List obtenerOdesUsuarioDesdeHasta(es.pode.auditoria.negocio.dominio.TitulosOdePorUsuarioDesdeHastaCriteria criterio);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerOdesUsuarioDesdeHasta(es.pode.auditoria.negocio.dominio.TitulosOdePorUsuarioDesdeHastaCriteria)} with an
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
    public java.util.List obtenerOdesUsuarioDesdeHasta(final int transform, final es.pode.auditoria.negocio.dominio.TitulosOdePorUsuarioDesdeHastaCriteria criterio);

    public java.util.List obtenerIdOdesOperacionDesdeHasta(java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerIdOdesOperacionDesdeHasta(java.util.Calendar, java.util.Calendar, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerIdOdesOperacionDesdeHasta(java.util.Calendar, java.util.Calendar, java.lang.String)}.
     * </p>
     * @param queryString String
              * @return java.util.List
     */
    public java.util.List obtenerIdOdesOperacionDesdeHasta(String queryString, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerIdOdesOperacionDesdeHasta(java.util.Calendar, java.util.Calendar, java.lang.String)} with an
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
    public java.util.List obtenerIdOdesOperacionDesdeHasta(int transform, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerIdOdesOperacionDesdeHasta(boolean, java.util.Calendar, java.util.Calendar, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerIdOdesOperacionDesdeHasta(int, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String operacion)}.
     * </p>
     * @param transform int
     * @param queryString String     
              * @return java.util.List
     */
    public java.util.List obtenerIdOdesOperacionDesdeHasta(int transform, String queryString, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String operacion);

    public java.lang.Long obtenerNumIdOdesOperacion(java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String idOde, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerNumIdOdesOperacion(java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerNumIdOdesOperacion(java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)}.
     * </p>
     * @param queryString String
                 * @return java.lang.Long
     */
    public java.lang.Long obtenerNumIdOdesOperacion(String queryString, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String idOde, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerNumIdOdesOperacion(java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int
                 * @return Object
     */
    public Object obtenerNumIdOdesOperacion(int transform, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String idOde, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerNumIdOdesOperacion(boolean, java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerNumIdOdesOperacion(int, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String idOde, java.lang.String operacion)}.
     * </p>
     * @param transform int
     * @param queryString String     
                 * @return Object
     */
    public Object obtenerNumIdOdesOperacion(int transform, String queryString, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String idOde, java.lang.String operacion);

    public java.util.List obtenerIdOdeOperUsuario(java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String usuario, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerIdOdeOperUsuario(java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerIdOdeOperUsuario(java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)}.
     * </p>
     * @param queryString String
                 * @return java.util.List
     */
    public java.util.List obtenerIdOdeOperUsuario(String queryString, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String usuario, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerIdOdeOperUsuario(java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)} with an
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
    public java.util.List obtenerIdOdeOperUsuario(int transform, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String usuario, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerIdOdeOperUsuario(boolean, java.util.Calendar, java.util.Calendar, java.lang.String, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerIdOdeOperUsuario(int, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String usuario, java.lang.String operacion)}.
     * </p>
     * @param transform int
     * @param queryString String     
                 * @return java.util.List
     */
    public java.util.List obtenerIdOdeOperUsuario(int transform, String queryString, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, java.lang.String usuario, java.lang.String operacion);

    public java.util.List obtenerIdiomaIdOde(es.pode.auditoria.negocio.dominio.IdiomaOdeDesdeHastaCriteria idiomaOdeDesdeHastaCriteria);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerIdiomaIdOde(es.pode.auditoria.negocio.dominio.IdiomaOdeDesdeHastaCriteria)} with an
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
    public java.util.List obtenerIdiomaIdOde(final int transform, final es.pode.auditoria.negocio.dominio.IdiomaOdeDesdeHastaCriteria idiomaOdeDesdeHastaCriteria);

  /**
   * <p>
   * Devuelve el numero de visitas que se han realizado a esa
   * operacion
   * </p>
      * @param idOde  El identificador del ODE
         * @param operacion  La operacion que queremos contabilizar
      * @return java.lang.Long
   */
    public java.lang.Long obtenerNumeroOperacion(java.lang.String idOde, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerNumeroOperacion(java.lang.String, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerNumeroOperacion(java.lang.String, java.lang.String)}.
     * </p>
     * @param queryString String
        * @param idOde  El identificador del ODE
           * @param operacion  La operacion que queremos contabilizar
        * @return java.lang.Long
     */
    public java.lang.Long obtenerNumeroOperacion(String queryString, java.lang.String idOde, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerNumeroOperacion(java.lang.String, java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     * @param transform int
        * @param idOde  El identificador del ODE
           * @param operacion  La operacion que queremos contabilizar
        * @return Object
     */
    public Object obtenerNumeroOperacion(int transform, java.lang.String idOde, java.lang.String operacion);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerNumeroOperacion(boolean, java.lang.String, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerNumeroOperacion(int, java.lang.String idOde, java.lang.String operacion)}.
     * </p>
     * @param transform int
     * @param queryString String     
        * @param idOde  El identificador del ODE
           * @param operacion  La operacion que queremos contabilizar
        * @return Object
     */
    public Object obtenerNumeroOperacion(int transform, String queryString, java.lang.String idOde, java.lang.String operacion);



    /**
     * TODO: document it
     * @param transform
     * @param userId
     * @param operacion
     * @param fechaDesde
     * @param fechaHasta
     * @return
     */
    public Object findOdesTitleBetweenDatesByUserByOperation(int transform, java.lang.String userId, java.lang.String operacion, java.util.Calendar fechaDesde, java.util.Calendar fechaHasta);



    /**
     * TODO: document it
     * @param fechaDesde
     * @param fechaHasta
     * @param operacion
     * @return
     */
    public java.util.List listTopUsersOperacion(java.util.Calendar fechaDesde, java.util.Calendar fechaHasta, String operacion);

}

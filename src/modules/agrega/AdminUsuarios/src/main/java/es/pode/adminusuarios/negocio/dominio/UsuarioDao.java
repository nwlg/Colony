// license-header java merge-point
//
// Attention: Generated code! Do not modify by hand!
// Generated by: SpringDao.vsl in andromda-spring-cartridge.
//
package es.pode.adminusuarios.negocio.dominio;

/**
 * @see es.pode.adminusuarios.negocio.dominio.Usuario
 */
public interface UsuarioDao
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
     * {@link es.pode.adminusuarios.negocio.servicios.UsuarioVO}.
     */
    public final static int TRANSFORM_USUARIOVO = 1;
    
    
    /**
     * Converts this DAO's entity to an object of type {@link es.pode.adminusuarios.negocio.servicios.UsuarioVO}.
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioVO toUsuarioVO(es.pode.adminusuarios.negocio.dominio.Usuario entity);

    /**
     * Converts this DAO's entity to a Collection of instances of type {@link es.pode.adminusuarios.negocio.servicios.UsuarioVO}.
     */
    public void toUsuarioVOCollection(java.util.Collection entities);

    public es.pode.adminusuarios.negocio.dominio.Usuario fromUsuarioVO(es.pode.adminusuarios.negocio.servicios.UsuarioVO vo);
    
    public void fromUsuarioVO(es.pode.adminusuarios.negocio.servicios.UsuarioVO vo, es.pode.adminusuarios.negocio.dominio.Usuario entity);    


    /**
     * Loads an instance of es.pode.adminusuarios.negocio.dominio.Usuario from the persistent store.
     */
    public es.pode.adminusuarios.negocio.dominio.Usuario load(java.lang.Long id);

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
     * Loads all entities of type {@link es.pode.adminusuarios.negocio.dominio.Usuario}. 
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
     * Creates an instance of es.pode.adminusuarios.negocio.dominio.Usuario and adds it to the persistent store.
     */
    public es.pode.adminusuarios.negocio.dominio.Usuario create(es.pode.adminusuarios.negocio.dominio.Usuario usuario);

    /**
     * <p>
     *   Does the same thing as {@link #create(es.pode.adminusuarios.negocio.dominio.Usuario)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public Object create(int transform, es.pode.adminusuarios.negocio.dominio.Usuario usuario);

    /**
     * Creates a new instance of es.pode.adminusuarios.negocio.dominio.Usuario and adds
     * from the passed in <code>entities</code> collection
     *
     * @param entities the collection of es.pode.adminusuarios.negocio.dominio.Usuario
     *        instances to create.
     *
     * @return the created instances.
     */
    public java.util.Collection create(java.util.Collection entities);

    /**
     * <p>
     *   Does the same thing as {@link #create(es.pode.adminusuarios.negocio.dominio.Usuario)} with an
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
     *   Creates a new <code>es.pode.adminusuarios.negocio.dominio.Usuario</code>
     *   instance from <strong>all</strong> attributes and adds it to
     *   the persistent store.
     * </p>
     */
    public es.pode.adminusuarios.negocio.dominio.Usuario create(
					java.lang.String nombre 
						,		java.lang.String apellido1 
						,		java.lang.String apellido2 
						,		java.lang.String email 
						,		java.lang.String NIF 
						,		java.lang.String usuario 
						,		java.lang.String clave 
						,		java.lang.String idioma 
						,		java.lang.String idiomaBusqueda 
						,		java.lang.String tipoEmpaquetador 
						,		java.util.Date fechaAlta 
						,		java.util.Date fechaBaja 
						,		java.util.Date fechaSolicitudAlta 
						,		java.lang.String claveEncriptada 
						,		java.util.Date fechaDesactivacion 
						,		java.lang.String tipoCatalogador 
						,		java.lang.Long cuota 
						,		java.lang.String openIdUrl 
			);



    /**
     * <p>
     *   Does the same thing as {@link #create(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.util.Date, java.util.Date, java.lang.String, java.util.Date, java.lang.String, java.lang.Long, java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong> be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public Object create(int transform,
					java.lang.String nombre 
						,		java.lang.String apellido1 
						,		java.lang.String apellido2 
						,		java.lang.String email 
						,		java.lang.String NIF 
						,		java.lang.String usuario 
						,		java.lang.String clave 
						,		java.lang.String idioma 
						,		java.lang.String idiomaBusqueda 
						,		java.lang.String tipoEmpaquetador 
						,		java.util.Date fechaAlta 
						,		java.util.Date fechaBaja 
						,		java.util.Date fechaSolicitudAlta 
						,		java.lang.String claveEncriptada 
						,		java.util.Date fechaDesactivacion 
						,		java.lang.String tipoCatalogador 
						,		java.lang.Long cuota 
						,		java.lang.String openIdUrl 
			);
    /**
     * <p>
     *  Creates a new <code>es.pode.adminusuarios.negocio.dominio.Usuario</code>
     *  instance from only <strong>required</strong> properties (attributes
     *  and association ends) and adds it to the persistent store.
     * </p>
     */
    public es.pode.adminusuarios.negocio.dominio.Usuario create(
		java.lang.String nombre,
		java.lang.String apellido1,
		java.lang.String apellido2,
		java.lang.String email,
		java.lang.String NIF,
		java.lang.String usuario,
		java.lang.String clave,
		java.lang.String idioma,
		java.lang.String idiomaBusqueda,
		java.lang.String tipoEmpaquetador,
		java.util.Date fechaAlta,
		java.util.Date fechaBaja,
		java.util.Date fechaSolicitudAlta,
		java.lang.String claveEncriptada,
		java.util.Date fechaDesactivacion,
		java.lang.String tipoCatalogador,
		java.lang.Long cuota,
		java.lang.String openIdUrl,
		java.util.Collection grupos,
		java.util.Collection grupoTrabajo);

    /**
     * <p>
     *   Does the same thing as {@link #create(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   the returned entity will <strong>NOT</strong be transformed.  If this flag is any of the other constants
     *   defined here then the result <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entity (into a value object for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public Object create(
        int transform,
		java.lang.String nombre,
		java.lang.String apellido1,
		java.lang.String apellido2,
		java.lang.String email,
		java.lang.String NIF,
		java.lang.String usuario,
		java.lang.String clave,
		java.lang.String idioma,
		java.lang.String idiomaBusqueda,
		java.lang.String tipoEmpaquetador,
		java.util.Date fechaAlta,
		java.util.Date fechaBaja,
		java.util.Date fechaSolicitudAlta,
		java.lang.String claveEncriptada,
		java.util.Date fechaDesactivacion,
		java.lang.String tipoCatalogador,
		java.lang.Long cuota,
		java.lang.String openIdUrl,
		java.util.Collection grupos,
		java.util.Collection grupoTrabajo);



    /**
     * Updates the <code>usuario</code> instance in the persistent store.
     */
    public void update(es.pode.adminusuarios.negocio.dominio.Usuario usuario);

    /**
     * Updates all instances in the <code>entities</code> collection in the persistent store.
     */
    public void update(java.util.Collection entities);

    /**
     * Removes the instance of es.pode.adminusuarios.negocio.dominio.Usuario from the persistent store.
     */
    public void remove(es.pode.adminusuarios.negocio.dominio.Usuario usuario);

    /**
     * Removes the instance of es.pode.adminusuarios.negocio.dominio.Usuario having the given
     * <code>identifier</code> from the persistent store.
     */
    public void remove(java.lang.Long id);

    /**
     * Removes all entities in the given <code>entities<code> collection.
     */
    public void remove(java.util.Collection entities);

    /**
     * 
     */
    public java.util.List consultaHQL(java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #consultaHQL(java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #consultaHQL(java.lang.String)}.
     * </p>
     */
    public java.util.List consultaHQL(String queryString, java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #consultaHQL(java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List consultaHQL(int transform, java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #consultaHQL(boolean, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #consultaHQL(int, java.lang.String usuario)}.
     * </p>
     */
    public java.util.List consultaHQL(int transform, String queryString, java.lang.String usuario);

    /**
     * 
     */
    public es.pode.adminusuarios.negocio.dominio.Usuario obtenerDatosUsuario(java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerDatosUsuario(java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerDatosUsuario(java.lang.String)}.
     * </p>
     */
    public es.pode.adminusuarios.negocio.dominio.Usuario obtenerDatosUsuario(String queryString, java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerDatosUsuario(java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public Object obtenerDatosUsuario(int transform, java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerDatosUsuario(boolean, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerDatosUsuario(int, java.lang.String usuario)}.
     * </p>
     */
    public Object obtenerDatosUsuario(int transform, String queryString, java.lang.String usuario);

    /**
     * 
     */
    public java.util.List obtenerUsuariosAdministradores(java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerUsuariosAdministradores(java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerUsuariosAdministradores(java.lang.String)}.
     * </p>
     */
    public java.util.List obtenerUsuariosAdministradores(String queryString, java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerUsuariosAdministradores(java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List obtenerUsuariosAdministradores(int transform, java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerUsuariosAdministradores(boolean, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerUsuariosAdministradores(int, java.lang.String usuario)}.
     * </p>
     */
    public java.util.List obtenerUsuariosAdministradores(int transform, String queryString, java.lang.String usuario);

    /**
     * 
     */
    public java.util.List obtenerNumUsuariosGrupo(java.lang.Long id);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerNumUsuariosGrupo(java.lang.Long)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerNumUsuariosGrupo(java.lang.Long)}.
     * </p>
     */
    public java.util.List obtenerNumUsuariosGrupo(String queryString, java.lang.Long id);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerNumUsuariosGrupo(java.lang.Long)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List obtenerNumUsuariosGrupo(int transform, java.lang.Long id);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerNumUsuariosGrupo(boolean, java.lang.Long)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerNumUsuariosGrupo(int, java.lang.Long id)}.
     * </p>
     */
    public java.util.List obtenerNumUsuariosGrupo(int transform, String queryString, java.lang.Long id);

    /**
     * 
     */
    public es.pode.adminusuarios.negocio.dominio.Usuario obtenerUsuario(java.lang.String NIF);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerUsuario(java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerUsuario(java.lang.String)}.
     * </p>
     */
    public es.pode.adminusuarios.negocio.dominio.Usuario obtenerUsuario(String queryString, java.lang.String NIF);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerUsuario(java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public Object obtenerUsuario(int transform, java.lang.String NIF);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerUsuario(boolean, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerUsuario(int, java.lang.String NIF)}.
     * </p>
     */
    public Object obtenerUsuario(int transform, String queryString, java.lang.String NIF);

    /**
     * 
     */
    public java.util.List obtenerEmailAdmin(java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerEmailAdmin(java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerEmailAdmin(java.lang.String)}.
     * </p>
     */
    public java.util.List obtenerEmailAdmin(String queryString, java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerEmailAdmin(java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List obtenerEmailAdmin(int transform, java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerEmailAdmin(boolean, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerEmailAdmin(int, java.lang.String usuario)}.
     * </p>
     */
    public java.util.List obtenerEmailAdmin(int transform, String queryString, java.lang.String usuario);

    /**
     * <p>
     * m�todo que devuelve los usuarios activos en el sistema (no
     * incluye los inactivos, dados de baja o pendientes de alta)
     * </p>
     */
    public java.util.List getUsuarios();

    /**
     * <p>
     *   Does the same thing as {@link #getUsuarios()} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #getUsuarios()}.
     * </p>
     */
    public java.util.List getUsuarios(String queryString);

    /**
     * <p>
     *   Does the same thing as {@link #getUsuarios()} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List getUsuarios(int transform);

    /**
     * <p>
     *   Does the same thing as {@link #getUsuarios(boolean)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #getUsuarios(int)}.
     * </p>
     */
    public java.util.List getUsuarios(int transform, String queryString);

    /**
     * <p>
     * m�todo que devuelve los usuarios pendientes de dar de alta en el
     * sistema por parte del administrador
     * </p>
     */
    public java.util.List getUsuariosPendientes();

    /**
     * <p>
     *   Does the same thing as {@link #getUsuariosPendientes()} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #getUsuariosPendientes()}.
     * </p>
     */
    public java.util.List getUsuariosPendientes(String queryString);

    /**
     * <p>
     *   Does the same thing as {@link #getUsuariosPendientes()} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List getUsuariosPendientes(int transform);

    /**
     * <p>
     *   Does the same thing as {@link #getUsuariosPendientes(boolean)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #getUsuariosPendientes(int)}.
     * </p>
     */
    public java.util.List getUsuariosPendientes(int transform, String queryString);

    /**
     * <p>
     * M�todo que devuelve un array de UsuariosActivosVO con la
     * informaci�n de los usuarios activos
     * </p>
     */
    public java.util.List usuariosActivos(java.util.Date fechaBaja);

    /**
     * <p>
     *   Does the same thing as {@link #usuariosActivos(java.util.Date)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #usuariosActivos(java.util.Date)}.
     * </p>
     */
    public java.util.List usuariosActivos(String queryString, java.util.Date fechaBaja);

    /**
     * <p>
     *   Does the same thing as {@link #usuariosActivos(java.util.Date)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List usuariosActivos(int transform, java.util.Date fechaBaja);

    /**
     * <p>
     *   Does the same thing as {@link #usuariosActivos(boolean, java.util.Date)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #usuariosActivos(int, java.util.Date fechaBaja)}.
     * </p>
     */
    public java.util.List usuariosActivos(int transform, String queryString, java.util.Date fechaBaja);

    /**
     * <p>
     * m�todo que devuelve todos los usuarios que han sido dados de
     * alta en el sistema: usuarios activos, inactivos y dados de baja.
     * </p>
     */
    public java.util.List getTodosUsuarios();

    /**
     * <p>
     *   Does the same thing as {@link #getTodosUsuarios()} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #getTodosUsuarios()}.
     * </p>
     */
    public java.util.List getTodosUsuarios(String queryString);

    /**
     * <p>
     *   Does the same thing as {@link #getTodosUsuarios()} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List getTodosUsuarios(int transform);

    /**
     * <p>
     *   Does the same thing as {@link #getTodosUsuarios(boolean)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #getTodosUsuarios(int)}.
     * </p>
     */
    public java.util.List getTodosUsuarios(int transform, String queryString);

    /**
     * <p>
     * m�todo que devuelve los usuarios inactivos presentes en el
     * sistema
     * </p>
     */
    public java.util.List getUsuariosInactivos();

    /**
     * <p>
     *   Does the same thing as {@link #getUsuariosInactivos()} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #getUsuariosInactivos()}.
     * </p>
     */
    public java.util.List getUsuariosInactivos(String queryString);

    /**
     * <p>
     *   Does the same thing as {@link #getUsuariosInactivos()} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List getUsuariosInactivos(int transform);

    /**
     * <p>
     *   Does the same thing as {@link #getUsuariosInactivos(boolean)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #getUsuariosInactivos(int)}.
     * </p>
     */
    public java.util.List getUsuariosInactivos(int transform, String queryString);

    /**
     * <p>
     * Obtiene la lista con los usuarios que se encuentran en el mismo
     * grupo de trabajo que el usuario que se pasa como par�metro
     * </p>
     */
    public java.util.List getUsuariosGrupoTrabajo(java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #getUsuariosGrupoTrabajo(java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #getUsuariosGrupoTrabajo(java.lang.String)}.
     * </p>
     */
    public java.util.List getUsuariosGrupoTrabajo(String queryString, java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #getUsuariosGrupoTrabajo(java.lang.String)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List getUsuariosGrupoTrabajo(int transform, java.lang.String usuario);

    /**
     * <p>
     *   Does the same thing as {@link #getUsuariosGrupoTrabajo(boolean, java.lang.String)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #getUsuariosGrupoTrabajo(int, java.lang.String usuario)}.
     * </p>
     */
    public java.util.List getUsuariosGrupoTrabajo(int transform, String queryString, java.lang.String usuario);

    /**
     * <p>
     * Obtiene todos los usuarios que se encuentran en alg�n grupo de
     * trabajo sin tener en cuenta el grupo de trabajo "TODOS"
     * </p>
     */
    public java.util.List getUsuariosTodosGruposTrabajo();

    /**
     * <p>
     *   Does the same thing as {@link #getUsuariosTodosGruposTrabajo()} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #getUsuariosTodosGruposTrabajo()}.
     * </p>
     */
    public java.util.List getUsuariosTodosGruposTrabajo(String queryString);

    /**
     * <p>
     *   Does the same thing as {@link #getUsuariosTodosGruposTrabajo()} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List getUsuariosTodosGruposTrabajo(int transform);

    /**
     * <p>
     *   Does the same thing as {@link #getUsuariosTodosGruposTrabajo(boolean)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #getUsuariosTodosGruposTrabajo(int)}.
     * </p>
     */
    public java.util.List getUsuariosTodosGruposTrabajo(int transform, String queryString);

    /**
     * 
     */
    public java.util.List obtenerUsuariosPertenecenGrupoTrabajo(java.lang.Long id);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerUsuariosPertenecenGrupoTrabajo(java.lang.Long)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerUsuariosPertenecenGrupoTrabajo(java.lang.Long)}.
     * </p>
     */
    public java.util.List obtenerUsuariosPertenecenGrupoTrabajo(String queryString, java.lang.Long id);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerUsuariosPertenecenGrupoTrabajo(java.lang.Long)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List obtenerUsuariosPertenecenGrupoTrabajo(int transform, java.lang.Long id);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerUsuariosPertenecenGrupoTrabajo(boolean, java.lang.Long)} with an
     *   additional argument called <code>queryString</code>.  This <code>queryString</code>
     *   argument allows you to override the query string defined in {@link #obtenerUsuariosPertenecenGrupoTrabajo(int, java.lang.Long id)}.
     * </p>
     */
    public java.util.List obtenerUsuariosPertenecenGrupoTrabajo(int transform, String queryString, java.lang.Long id);

    /**
     * 
     */
    public java.util.List obtenerUsuariosPorOpenId(es.pode.adminusuarios.negocio.servicios.obtenerUsuarioPorOpenIdCriteria openIdCriteria);

    /**
     * <p>
     *   Does the same thing as {@link #obtenerUsuariosPorOpenId(es.pode.adminusuarios.negocio.servicios.obtenerUsuarioPorOpenIdCriteria)} with an
     *   additional flag called <code>transform</code>.  If this flag is set to <code>TRANSFORM_NONE</code> then
     *   finder results will <strong>NOT</strong> be transformed during retrieval.
     *   If this flag is any of the other constants defined here
     *   then finder results <strong>WILL BE</strong> passed through an operation which can optionally
     *   transform the entities (into value objects for example).  By default, transformation does
     *   not occur.
     * </p>
     */
    public java.util.List obtenerUsuariosPorOpenId(final int transform, final es.pode.adminusuarios.negocio.servicios.obtenerUsuarioPorOpenIdCriteria openIdCriteria);

}

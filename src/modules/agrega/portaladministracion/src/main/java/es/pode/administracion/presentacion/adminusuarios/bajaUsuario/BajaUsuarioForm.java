// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.bajaUsuario;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>bajaUsuario</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.adminusuarios.bajaUsuario.BajaUsuarioController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.adminusuarios.bajaUsuario.BajaUsuarioController#bajaUsuario
 */
public interface BajaUsuarioForm
{
    /**
     * Sets the <code>listaId</code> field.
     *
     * 
     */
    public void setListaId(java.lang.String listaId);

    /**
     * Gets the <code>listaId</code> field.
     *
     * 
     */
    public java.lang.String getListaId();
    
    /**
     * Resets the <code>listaId</code> field.
     */
    public void resetListaId();

    /**
     * Sets the <code>usuariosDeleted</code> field.
     *
     * 
     */
    public void setUsuariosDeleted(es.pode.adminusuarios.negocio.servicios.UsuarioVO[] usuariosDeleted);

    /**
     * Gets the <code>usuariosDeleted</code> field.
     *
     * 
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioVO[] getUsuariosDeleted();
    
    /**
     * Resets the <code>usuariosDeleted</code> field.
     */
    public void resetUsuariosDeleted();

    /**
     * Sets the <code>descripcionBaja</code> field.
     *
     * 
     */
    public void setDescripcionBaja(java.lang.String descripcionBaja);

    /**
     * Gets the <code>descripcionBaja</code> field.
     *
     * 
     */
    public java.lang.String getDescripcionBaja();
    
    /**
     * Resets the <code>descripcionBaja</code> field.
     */
    public void resetDescripcionBaja();

}

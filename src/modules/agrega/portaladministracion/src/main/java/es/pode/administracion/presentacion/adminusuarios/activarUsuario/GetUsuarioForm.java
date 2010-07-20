// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.activarUsuario;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>getUsuario</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.adminusuarios.activarUsuario.ActivarUsuarioController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.adminusuarios.activarUsuario.ActivarUsuarioController#getUsuario
 */
public interface GetUsuarioForm
{
    /**
     * Sets the <code>id</code> field.
     *
     * 
     */
    public void setId(java.lang.Long id);

    /**
     * Gets the <code>id</code> field.
     *
     * 
     */
    public java.lang.Long getId();
    
    /**
     * Resets the <code>id</code> field.
     */
    public void resetId();

    /**
     * Sets the <code>usuario</code> field.
     *
     * 
     */
    public void setUsuario(java.lang.String usuario);

    /**
     * Gets the <code>usuario</code> field.
     *
     * 
     */
    public java.lang.String getUsuario();
    
    /**
     * Resets the <code>usuario</code> field.
     */
    public void resetUsuario();

}

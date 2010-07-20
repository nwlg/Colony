// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.modificarUsuario;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>modificarUsuario</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.adminusuarios.modificarUsuario.ModificarUsuarioController</code> controller.
 *
 * <p>
 * almacena los datos del usuario en base de datos
 * </p>
 *
 * @see es.pode.administracion.presentacion.adminusuarios.modificarUsuario.ModificarUsuarioController#modificarUsuario
 */
public interface ModificarUsuarioForm
{
    /**
     * Sets the <code>idModificado</code> field.
     *
     * 
     */
    public void setIdModificado(java.lang.Long idModificado);

    /**
     * Gets the <code>idModificado</code> field.
     *
     * 
     */
    public java.lang.Long getIdModificado();
    
    /**
     * Resets the <code>idModificado</code> field.
     */
    public void resetIdModificado();

    /**
     * Sets the <code>resultado</code> field.
     *
     * 
     */
    public void setResultado(java.lang.String resultado);

    /**
     * Gets the <code>resultado</code> field.
     *
     * 
     */
    public java.lang.String getResultado();
    
    /**
     * Resets the <code>resultado</code> field.
     */
    public void resetResultado();

}

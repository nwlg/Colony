// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.listarUsuarios;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerUsuarios</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.adminusuarios.listarUsuarios.ListarUsuariosController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.adminusuarios.listarUsuarios.ListarUsuariosController#obtenerUsuarios
 */
public interface ObtenerUsuariosForm
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
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setUsuarios#sArray(Object[])
     */
    public void setUsuarios(java.util.Collection usuarios);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getUsuarios#sArray()
     */
    public java.util.Collection getUsuarios();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setUsuarios(java.util.Collection)
     */
    public void setUsuariosAsArray(Object[] usuarios);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getUsuarios()
     */
    public java.lang.Object[] getUsuariosAsArray();

    /**
     * Resets the <code>usuarios</code> field.
     */
    public void resetUsuarios();

}

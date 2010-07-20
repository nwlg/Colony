// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.listarUsuariosInactivos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerUsuariosInactivos</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.adminusuarios.listarUsuariosInactivos.ListarUsuariosInactivosController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.adminusuarios.listarUsuariosInactivos.ListarUsuariosInactivosController#obtenerUsuariosInactivos
 */
public interface ObtenerUsuariosInactivosForm
{
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

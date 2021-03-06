// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.altaGrupo;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarRoles</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.adminusuarios.altaGrupo.AltaGrupoController</code> controller.
 *
 * <p>
 * Recuperación de todos los roles
 * </p>
 *
 * @see es.pode.administracion.presentacion.adminusuarios.altaGrupo.AltaGrupoController#recuperarRoles
 */
public interface RecuperarRolesForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setRoles#sArray(Object[])
     */
    public void setRoles(java.util.Collection roles);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getRoles#sArray()
     */
    public java.util.Collection getRoles();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setRoles(java.util.Collection)
     */
    public void setRolesAsArray(Object[] roles);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getRoles()
     */
    public java.lang.Object[] getRolesAsArray();

    /**
     * Resets the <code>roles</code> field.
     */
    public void resetRoles();

    /**
     * Sets the <code>descripcion</code> field.
     *
     * 
     */
    public void setDescripcion(java.lang.String descripcion);

    /**
     * Gets the <code>descripcion</code> field.
     *
     * 
     */
    public java.lang.String getDescripcion();
    
    /**
     * Resets the <code>descripcion</code> field.
     */
    public void resetDescripcion();

}

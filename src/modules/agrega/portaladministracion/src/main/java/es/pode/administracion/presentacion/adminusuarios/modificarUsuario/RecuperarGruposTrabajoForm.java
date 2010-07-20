// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.modificarUsuario;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarGruposTrabajo</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.adminusuarios.modificarUsuario.ModificarUsuarioController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.adminusuarios.modificarUsuario.ModificarUsuarioController#recuperarGruposTrabajo
 */
public interface RecuperarGruposTrabajoForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setGruposTrabajo#sArray(Object[])
     */
    public void setGruposTrabajo(java.util.Collection gruposTrabajo);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getGruposTrabajo#sArray()
     */
    public java.util.Collection getGruposTrabajo();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setGruposTrabajo(java.util.Collection)
     */
    public void setGruposTrabajoAsArray(Object[] gruposTrabajo);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getGruposTrabajo()
     */
    public java.lang.Object[] getGruposTrabajoAsArray();

    /**
     * Resets the <code>gruposTrabajo</code> field.
     */
    public void resetGruposTrabajo();

}

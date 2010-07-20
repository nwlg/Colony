// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.listarGrupos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarGrupos</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.adminusuarios.listarGrupos.ListarGruposController</code> controller.
 *
 * <p>
 * Devuelve todos los grupos dados de alta en el sistema
 * </p>
 *
 * @see es.pode.administracion.presentacion.adminusuarios.listarGrupos.ListarGruposController#recuperarGrupos
 */
public interface RecuperarGruposForm
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
     * @see #setGrupos#sArray(Object[])
     */
    public void setGrupos(java.util.Collection grupos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getGrupos#sArray()
     */
    public java.util.Collection getGrupos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setGrupos(java.util.Collection)
     */
    public void setGruposAsArray(Object[] grupos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getGrupos()
     */
    public java.lang.Object[] getGruposAsArray();

    /**
     * Resets the <code>grupos</code> field.
     */
    public void resetGrupos();

}

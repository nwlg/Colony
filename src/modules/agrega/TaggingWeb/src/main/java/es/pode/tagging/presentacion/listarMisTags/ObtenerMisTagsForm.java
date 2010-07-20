// license-header java merge-point
package es.pode.tagging.presentacion.listarMisTags;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerMisTags</code> method, which is located on the
 * <code>es.pode.tagging.presentacion.listarMisTags.ListarMisTagsController</code> controller.
 *
 * 
 *
 * @see es.pode.tagging.presentacion.listarMisTags.ListarMisTagsController#obtenerMisTags
 */
public interface ObtenerMisTagsForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setMisTags#sArray(Object[])
     */
    public void setMisTags(java.util.Collection misTags);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getMisTags#sArray()
     */
    public java.util.Collection getMisTags();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setMisTags(java.util.Collection)
     */
    public void setMisTagsAsArray(Object[] misTags);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getMisTags()
     */
    public java.lang.Object[] getMisTagsAsArray();

    /**
     * Resets the <code>misTags</code> field.
     */
    public void resetMisTags();

}

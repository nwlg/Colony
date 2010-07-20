// license-header java merge-point
package es.pode.tagging.presentacion.mostrarOdesMisTags;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerOdesTag</code> method, which is located on the
 * <code>es.pode.tagging.presentacion.mostrarOdesMisTags.MostrarOdesMisTagsController</code> controller.
 *
 * 
 *
 * @see es.pode.tagging.presentacion.mostrarOdesMisTags.MostrarOdesMisTagsController#obtenerOdesTag
 */
public interface ObtenerOdesTagForm
{
    /**
     * Sets the <code>tag</code> field.
     *
     * 
     */
    public void setTag(java.lang.String tag);

    /**
     * Gets the <code>tag</code> field.
     *
     * 
     */
    public java.lang.String getTag();
    
    /**
     * Resets the <code>tag</code> field.
     */
    public void resetTag();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setOdes#sArray(Object[])
     */
    public void setOdes(java.util.Collection odes);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getOdes#sArray()
     */
    public java.util.Collection getOdes();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setOdes(java.util.Collection)
     */
    public void setOdesAsArray(Object[] odes);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getOdes()
     */
    public java.lang.Object[] getOdesAsArray();

    /**
     * Resets the <code>odes</code> field.
     */
    public void resetOdes();

}

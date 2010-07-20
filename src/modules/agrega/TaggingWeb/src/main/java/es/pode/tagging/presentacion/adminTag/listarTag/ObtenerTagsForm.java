// license-header java merge-point
package es.pode.tagging.presentacion.adminTag.listarTag;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerTags</code> method, which is located on the
 * <code>es.pode.tagging.presentacion.adminTag.listarTag.ListarTagController</code> controller.
 *
 * 
 *
 * @see es.pode.tagging.presentacion.adminTag.listarTag.ListarTagController#obtenerTags
 */
public interface ObtenerTagsForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTags#sArray(Object[])
     */
    public void setTags(java.util.Collection tags);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTags#sArray()
     */
    public java.util.Collection getTags();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTags(java.util.Collection)
     */
    public void setTagsAsArray(Object[] tags);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTags()
     */
    public java.lang.Object[] getTagsAsArray();

    /**
     * Resets the <code>tags</code> field.
     */
    public void resetTags();

    /**
     * Sets the <code>newTag</code> field.
     *
     * 
     */
    public void setNewTag(java.lang.String newTag);

    /**
     * Gets the <code>newTag</code> field.
     *
     * 
     */
    public java.lang.String getNewTag();
    
    /**
     * Resets the <code>newTag</code> field.
     */
    public void resetNewTag();

    /**
     * Sets the <code>tagOld</code> field.
     *
     * 
     */
    public void setTagOld(java.lang.String tagOld);

    /**
     * Gets the <code>tagOld</code> field.
     *
     * 
     */
    public java.lang.String getTagOld();
    
    /**
     * Resets the <code>tagOld</code> field.
     */
    public void resetTagOld();

}

// license-header java merge-point
package es.pode.tagging.presentacion.modificarTag;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>modificarTag</code> method, which is located on the
 * <code>es.pode.tagging.presentacion.modificarTag.ModificarTagController</code> controller.
 *
 * 
 *
 * @see es.pode.tagging.presentacion.modificarTag.ModificarTagController#modificarTag
 */
public interface ModificarTagForm
{
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

}

// license-header java merge-point
package es.pode.tagging.presentacion.adminTag.modificar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>modificar</code> method, which is located on the
 * <code>es.pode.tagging.presentacion.adminTag.modificar.ModificarController</code> controller.
 *
 * 
 *
 * @see es.pode.tagging.presentacion.adminTag.modificar.ModificarController#modificar
 */
public interface ModificarForm
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

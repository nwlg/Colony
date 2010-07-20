// license-header java merge-point
package es.pode.tagging.presentacion.modificarTag;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>selectAction</code> method, which is located on the
 * <code>es.pode.tagging.presentacion.modificarTag.ModificarTagController</code> controller.
 *
 * 
 *
 * @see es.pode.tagging.presentacion.modificarTag.ModificarTagController#selectAction
 */
public interface SelectActionForm
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
     * Sets the <code>accion</code> field.
     *
     * 
     */
    public void setAccion(java.lang.String accion);

    /**
     * Gets the <code>accion</code> field.
     *
     * 
     */
    public java.lang.String getAccion();
    
    /**
     * Resets the <code>accion</code> field.
     */
    public void resetAccion();

}

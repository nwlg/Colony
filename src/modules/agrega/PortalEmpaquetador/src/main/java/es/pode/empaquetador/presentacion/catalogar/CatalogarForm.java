// license-header java merge-point
package es.pode.empaquetador.presentacion.catalogar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>catalogar</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.catalogar.CatalogarController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.catalogar.CatalogarController#catalogar
 */
public interface CatalogarForm
{
    /**
     * Sets the <code>identifier</code> field.
     *
     * 
     */
    public void setIdentifier(java.lang.String identifier);

    /**
     * Gets the <code>identifier</code> field.
     *
     * 
     */
    public java.lang.String getIdentifier();
    
    /**
     * Resets the <code>identifier</code> field.
     */
    public void resetIdentifier();

    /**
     * Sets the <code>href</code> field.
     *
     * 
     */
    public void setHref(java.lang.String href);

    /**
     * Gets the <code>href</code> field.
     *
     * 
     */
    public java.lang.String getHref();
    
    /**
     * Resets the <code>href</code> field.
     */
    public void resetHref();

    /**
     * Sets the <code>returnURL</code> field.
     *
     * 
     */
    public void setReturnURL(java.lang.String returnURL);

    /**
     * Gets the <code>returnURL</code> field.
     *
     * 
     */
    public java.lang.String getReturnURL();
    
    /**
     * Resets the <code>returnURL</code> field.
     */
    public void resetReturnURL();

}

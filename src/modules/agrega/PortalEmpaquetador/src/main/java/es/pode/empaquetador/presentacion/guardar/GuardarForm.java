// license-header java merge-point
package es.pode.empaquetador.presentacion.guardar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>guardar</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.guardar.GuardarController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.guardar.GuardarController#guardar
 */
public interface GuardarForm
{
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

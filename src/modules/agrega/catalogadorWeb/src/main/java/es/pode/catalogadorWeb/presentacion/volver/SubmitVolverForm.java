// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.volver;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submitVolver</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.volver.VolverController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.volver.VolverController#submitVolver
 */
public interface SubmitVolverForm
{
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

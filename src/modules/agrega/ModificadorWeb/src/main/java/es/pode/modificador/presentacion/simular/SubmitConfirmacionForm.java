// license-header java merge-point
package es.pode.modificador.presentacion.simular;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submitConfirmacion</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.simular.SimularModificacionController</code> controller.
 *
 * 
 *
 * @see es.pode.modificador.presentacion.simular.SimularModificacionController#submitConfirmacion
 */
public interface SubmitConfirmacionForm
{
    /**
     * Sets the <code>action</code> field.
     *
     * 
     */
    public void setAction(java.lang.String action);

    /**
     * Gets the <code>action</code> field.
     *
     * 
     */
    public java.lang.String getAction();
    
    /**
     * Resets the <code>action</code> field.
     */
    public void resetAction();

    /**
     * Sets the <code>idModificacion</code> field.
     *
     * 
     */
    public void setIdModificacion(java.lang.Long idModificacion);

    /**
     * Gets the <code>idModificacion</code> field.
     *
     * 
     */
    public java.lang.Long getIdModificacion();
    
    /**
     * Resets the <code>idModificacion</code> field.
     */
    public void resetIdModificacion();

}

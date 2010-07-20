// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>selectAction</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar.DesagregarSubmanifiestoController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar.DesagregarSubmanifiestoController#selectAction
 */
public interface SelectActionForm
{
    /**
     * Sets the <code>destino</code> field.
     *
     * 
     */
    public void setDestino(java.lang.String destino);

    /**
     * Gets the <code>destino</code> field.
     *
     * 
     */
    public java.lang.String getDestino();
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     * This method does not take i18n into account so it consistently returns the same value
     * given the same argument.
     */
    public java.lang.String getDestinoOptionValue(int optionIndex);

    /**
     * Resets the <code>destino</code> field.
     */
    public void resetDestino();

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

}

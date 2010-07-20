// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>seleccionarOrigen</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.agregar.AgregarSubmanifiestoController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.agregar.AgregarSubmanifiestoController#seleccionarOrigen
 */
public interface SeleccionarOrigenForm
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
     * Sets the <code>origen</code> field.
     *
     * 
     */
    public void setOrigen(java.lang.String origen);

    /**
     * Gets the <code>origen</code> field.
     *
     * 
     */
    public java.lang.String getOrigen();
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     * This method does not take i18n into account so it consistently returns the same value
     * given the same argument.
     */
    public java.lang.String getOrigenOptionValue(int optionIndex);

    /**
     * Resets the <code>origen</code> field.
     */
    public void resetOrigen();

}

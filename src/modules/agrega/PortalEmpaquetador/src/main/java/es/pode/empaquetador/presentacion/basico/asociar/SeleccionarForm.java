// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>seleccionar</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.basico.asociar.AsociarController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.basico.asociar.AsociarController#seleccionar
 */
public interface SeleccionarForm
{
    /**
     * Sets the <code>tipo</code> field.
     *
     * 
     */
    public void setTipo(java.lang.String tipo);

    /**
     * Gets the <code>tipo</code> field.
     *
     * 
     */
    public java.lang.String getTipo();
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     * This method does not take i18n into account so it consistently returns the same value
     * given the same argument.
     */
    public java.lang.String getTipoOptionValue(int optionIndex);

    /**
     * Resets the <code>tipo</code> field.
     */
    public void resetTipo();

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

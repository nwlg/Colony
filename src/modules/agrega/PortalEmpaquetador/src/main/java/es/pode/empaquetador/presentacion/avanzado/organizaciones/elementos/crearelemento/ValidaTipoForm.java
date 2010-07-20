// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>validaTipo</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoController#validaTipo
 */
public interface ValidaTipoForm
{
    /**
     * Sets the <code>title</code> field.
     *
     * 
     */
    public void setTitle(java.lang.String title);

    /**
     * Gets the <code>title</code> field.
     *
     * 
     */
    public java.lang.String getTitle();
    
    /**
     * Resets the <code>title</code> field.
     */
    public void resetTitle();

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
     * Sets the <code>referenciado</code> field.
     *
     * 
     */
    public void setReferenciado(java.lang.String referenciado);

    /**
     * Gets the <code>referenciado</code> field.
     *
     * 
     */
    public java.lang.String getReferenciado();
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     * This method does not take i18n into account so it consistently returns the same value
     * given the same argument.
     */
    public java.lang.String getReferenciadoOptionValue(int optionIndex);

    /**
     * Resets the <code>referenciado</code> field.
     */
    public void resetReferenciado();

}

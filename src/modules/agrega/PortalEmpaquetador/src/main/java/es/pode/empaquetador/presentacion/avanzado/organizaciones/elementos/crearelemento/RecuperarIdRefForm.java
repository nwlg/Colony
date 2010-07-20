// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarIdRef</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoController#recuperarIdRef
 */
public interface RecuperarIdRefForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Esta lista puede contener recursos o submanifiestos, dependiendo
     * del tipo de elemento que se quiere crear (esRecurso). Los
     * metodos a acceder son getIdentifier (comun a los dos) y
     * dependiendo del tipo de elemento, getFile (para recursos) o
     * getLom().getTitulo() para submanifiesto.
     * </p>
     *
     * @see #setElementos#sArray(Object[])
     */
    public void setElementos(java.util.List elementos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Esta lista puede contener recursos o submanifiestos, dependiendo
     * del tipo de elemento que se quiere crear (esRecurso). Los
     * metodos a acceder son getIdentifier (comun a los dos) y
     * dependiendo del tipo de elemento, getFile (para recursos) o
     * getLom().getTitulo() para submanifiesto.
     * </p>
     *
     * @see #getElementos#sArray()
     */
    public java.util.List getElementos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Esta lista puede contener recursos o submanifiestos, dependiendo
     * del tipo de elemento que se quiere crear (esRecurso). Los
     * metodos a acceder son getIdentifier (comun a los dos) y
     * dependiendo del tipo de elemento, getFile (para recursos) o
     * getLom().getTitulo() para submanifiesto.
     * </p>
     *
     * @see #setElementos(java.util.List)
     */
    public void setElementosAsArray(Object[] elementos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Esta lista puede contener recursos o submanifiestos, dependiendo
     * del tipo de elemento que se quiere crear (esRecurso). Los
     * metodos a acceder son getIdentifier (comun a los dos) y
     * dependiendo del tipo de elemento, getFile (para recursos) o
     * getLom().getTitulo() para submanifiesto.
     * </p>
     *
     * @see #getElementos()
     */
    public java.lang.Object[] getElementosAsArray();

    /**
     * Resets the <code>elementos</code> field.
     */
    public void resetElementos();

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

}

// license-header java merge-point
package es.pode.administracion.presentacion.faqs.faqs;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarFaqs</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.faqs.faqs.FaqsController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.faqs.faqs.FaqsController#cargarFaqs
 */
public interface CargarFaqsForm
{
    /**
     * Sets the <code>idiomaSeleccionado</code> field.
     *
     * 
     */
    public void setIdiomaSeleccionado(java.lang.String idiomaSeleccionado);

    /**
     * Gets the <code>idiomaSeleccionado</code> field.
     *
     * 
     */
    public java.lang.String getIdiomaSeleccionado();
    
    /**
     * Resets the <code>idiomaSeleccionado</code> field.
     */
    public void resetIdiomaSeleccionado();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIdiomas#sArray(Object[])
     */
    public void setIdiomas(java.util.Collection idiomas);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIdiomas#sArray()
     */
    public java.util.Collection getIdiomas();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIdiomas(java.util.Collection)
     */
    public void setIdiomasAsArray(Object[] idiomas);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIdiomas()
     */
    public java.lang.Object[] getIdiomasAsArray();

    /**
     * Resets the <code>idiomas</code> field.
     */
    public void resetIdiomas();

    /**
     * Sets the <code>idModificado</code> field.
     *
     * 
     */
    public void setIdModificado(java.lang.Long idModificado);

    /**
     * Gets the <code>idModificado</code> field.
     *
     * 
     */
    public java.lang.Long getIdModificado();
    
    /**
     * Resets the <code>idModificado</code> field.
     */
    public void resetIdModificado();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setFaqs#sArray(Object[])
     */
    public void setFaqs(java.util.Collection faqs);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getFaqs#sArray()
     */
    public java.util.Collection getFaqs();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setFaqs(java.util.Collection)
     */
    public void setFaqsAsArray(Object[] faqs);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getFaqs()
     */
    public java.lang.Object[] getFaqsAsArray();

    /**
     * Resets the <code>faqs</code> field.
     */
    public void resetFaqs();

}

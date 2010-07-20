// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.tesauros;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargaTesauros</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.tesauros.TesaurosController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.tesauros.TesaurosController#cargaTesauros
 */
public interface CargaTesaurosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setRutaPadrevo#sArray(Object[])
     */
    public void setRutaPadrevo(java.util.Collection rutaPadrevo);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getRutaPadrevo#sArray()
     */
    public java.util.Collection getRutaPadrevo();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setRutaPadrevo(java.util.Collection)
     */
    public void setRutaPadrevoAsArray(Object[] rutaPadrevo);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getRutaPadrevo()
     */
    public java.lang.Object[] getRutaPadrevoAsArray();

    /**
     * Resets the <code>rutaPadrevo</code> field.
     */
    public void resetRutaPadrevo();

    /**
     * Sets the <code>idioma</code> field.
     *
     * 
     */
    public void setIdioma(java.lang.String idioma);

    /**
     * Gets the <code>idioma</code> field.
     *
     * 
     */
    public java.lang.String getIdioma();
    
    /**
     * Resets the <code>idioma</code> field.
     */
    public void resetIdioma();

    /**
     * Sets the <code>vocabName</code> field.
     *
     * 
     */
    public void setVocabName(java.lang.String vocabName);

    /**
     * Gets the <code>vocabName</code> field.
     *
     * 
     */
    public java.lang.String getVocabName();
    
    /**
     * Resets the <code>vocabName</code> field.
     */
    public void resetVocabName();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTaxonesvo#sArray(Object[])
     */
    public void setTaxonesvo(java.util.Collection taxonesvo);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTaxonesvo#sArray()
     */
    public java.util.Collection getTaxonesvo();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTaxonesvo(java.util.Collection)
     */
    public void setTaxonesvoAsArray(Object[] taxonesvo);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTaxonesvo()
     */
    public java.lang.Object[] getTaxonesvoAsArray();

    /**
     * Resets the <code>taxonesvo</code> field.
     */
    public void resetTaxonesvo();

    /**
     * Sets the <code>textoBusqueda</code> field.
     *
     * 
     */
    public void setTextoBusqueda(java.lang.String textoBusqueda);

    /**
     * Gets the <code>textoBusqueda</code> field.
     *
     * 
     */
    public java.lang.String getTextoBusqueda();
    
    /**
     * Resets the <code>textoBusqueda</code> field.
     */
    public void resetTextoBusqueda();

    /**
     * Sets the <code>nomTesauro</code> field.
     *
     * 
     */
    public void setNomTesauro(java.lang.String nomTesauro);

    /**
     * Gets the <code>nomTesauro</code> field.
     *
     * 
     */
    public java.lang.String getNomTesauro();
    
    /**
     * Resets the <code>nomTesauro</code> field.
     */
    public void resetNomTesauro();

}

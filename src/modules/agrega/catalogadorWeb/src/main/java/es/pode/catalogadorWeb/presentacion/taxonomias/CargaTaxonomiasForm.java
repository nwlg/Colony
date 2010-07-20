// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.taxonomias;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargaTaxonomias</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.taxonomias.TaxonomiasController</code> controller.
 *
 * <p>
 * Este metodo hace una llamada a cargarTaxonomia para mostrar el
 * primer nivel de la taxonomia elegida, a partir del cual, sera
 * posible navegar y seleccionar una ruta.
 * </p>
 *
 * @see es.pode.catalogadorWeb.presentacion.taxonomias.TaxonomiasController#cargaTaxonomias
 */
public interface CargaTaxonomiasForm
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
     * Sets the <code>nomTaxonomia</code> field.
     *
     * 
     */
    public void setNomTaxonomia(java.lang.String nomTaxonomia);

    /**
     * Gets the <code>nomTaxonomia</code> field.
     *
     * 
     */
    public java.lang.String getNomTaxonomia();
    
    /**
     * Resets the <code>nomTaxonomia</code> field.
     */
    public void resetNomTaxonomia();

}

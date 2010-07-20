// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.tesauros;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarTesauros</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.avanzado.tesauros.TesaurosController</code> controller.
 *
 * <p>
 * Este método recopila la información necesaria para mostrar el
 * apartado de tesauros, en el buscador avanzado. Tiene en cuenta
 * los valores almacenados en la sesión.
 * </p>
 *
 * @see es.pode.buscador.presentacion.avanzado.tesauros.TesaurosController#cargarTesauros
 */
public interface CargarTesaurosForm
{
    /**
     * Sets the <code>nomTesauros</code> field.
     *
     * 
     */
    public void setNomTesauros(java.lang.String nomTesauros);

    /**
     * Gets the <code>nomTesauros</code> field.
     *
     * 
     */
    public java.lang.String getNomTesauros();
    
    /**
     * Resets the <code>nomTesauros</code> field.
     */
    public void resetNomTesauros();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTaxonesVO#sArray(Object[])
     */
    public void setTaxonesVO(java.util.Collection taxonesVO);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTaxonesVO#sArray()
     */
    public java.util.Collection getTaxonesVO();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTaxonesVO(java.util.Collection)
     */
    public void setTaxonesVOAsArray(Object[] taxonesVO);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTaxonesVO()
     */
    public java.lang.Object[] getTaxonesVOAsArray();

    /**
     * Resets the <code>taxonesVO</code> field.
     */
    public void resetTaxonesVO();

    /**
     * Sets the <code>tituloTesauro</code> field.
     *
     * 
     */
    public void setTituloTesauro(java.lang.String tituloTesauro);

    /**
     * Gets the <code>tituloTesauro</code> field.
     *
     * 
     */
    public java.lang.String getTituloTesauro();
    
    /**
     * Resets the <code>tituloTesauro</code> field.
     */
    public void resetTituloTesauro();

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
     * Sets the <code>tipoLayoutBuscador</code> field.
     *
     * 
     */
    public void setTipoLayoutBuscador(java.lang.String tipoLayoutBuscador);

    /**
     * Gets the <code>tipoLayoutBuscador</code> field.
     *
     * 
     */
    public java.lang.String getTipoLayoutBuscador();
    
    /**
     * Resets the <code>tipoLayoutBuscador</code> field.
     */
    public void resetTipoLayoutBuscador();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setRutaPadreVO#sArray(Object[])
     */
    public void setRutaPadreVO(java.util.Collection rutaPadreVO);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getRutaPadreVO#sArray()
     */
    public java.util.Collection getRutaPadreVO();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setRutaPadreVO(java.util.Collection)
     */
    public void setRutaPadreVOAsArray(Object[] rutaPadreVO);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getRutaPadreVO()
     */
    public java.lang.Object[] getRutaPadreVOAsArray();

    /**
     * Resets the <code>rutaPadreVO</code> field.
     */
    public void resetRutaPadreVO();

}

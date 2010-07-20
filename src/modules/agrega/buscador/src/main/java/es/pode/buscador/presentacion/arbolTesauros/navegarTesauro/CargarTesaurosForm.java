// license-header java merge-point
package es.pode.buscador.presentacion.arbolTesauros.navegarTesauro;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarTesauros</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.NavegarTesauroController</code> controller.
 *
 * <p>
 * Esta actividad solicita la taxonomía del tesauro para el idioma
 * del usuario publicado en el contexto de seguridad.
 * </p>
 * <p>
 * Cuando se selecciona un tesauro para navegar a un nivel más
 * profundo o superior, se pasa un string con el código del
 * tesauro para que el servicio de taxonomías nos devuelva sus
 * hijos, y que el servicio de búsqueda nos devuleva el número de
 * objetos coincidentes en el índice con ese tesauro.
 * </p>
 *
 * @see es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.NavegarTesauroController#cargarTesauros
 */
public interface CargarTesaurosForm
{
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
     * Sets the <code>tipoBusquedaArbol</code> field.
     *
     * 
     */
    public void setTipoBusquedaArbol(java.lang.String tipoBusquedaArbol);

    /**
     * Gets the <code>tipoBusquedaArbol</code> field.
     *
     * 
     */
    public java.lang.String getTipoBusquedaArbol();
    
    /**
     * Resets the <code>tipoBusquedaArbol</code> field.
     */
    public void resetTipoBusquedaArbol();

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
     * Sets the <code>numeroResultados</code> field.
     *
     * 
     */
    public void setNumeroResultados(java.lang.Integer numeroResultados);

    /**
     * Gets the <code>numeroResultados</code> field.
     *
     * 
     */
    public java.lang.Integer getNumeroResultados();
    
    /**
     * Resets the <code>numeroResultados</code> field.
     */
    public void resetNumeroResultados();

    /**
     * Sets the <code>tipoBusqueda</code> field.
     *
     * 
     */
    public void setTipoBusqueda(java.lang.String tipoBusqueda);

    /**
     * Gets the <code>tipoBusqueda</code> field.
     *
     * 
     */
    public java.lang.String getTipoBusqueda();
    
    /**
     * Resets the <code>tipoBusqueda</code> field.
     */
    public void resetTipoBusqueda();

    /**
     * Sets the <code>idiomaBuscador</code> field.
     *
     * 
     */
    public void setIdiomaBuscador(java.lang.String idiomaBuscador);

    /**
     * Gets the <code>idiomaBuscador</code> field.
     *
     * 
     */
    public java.lang.String getIdiomaBuscador();
    
    /**
     * Resets the <code>idiomaBuscador</code> field.
     */
    public void resetIdiomaBuscador();

}

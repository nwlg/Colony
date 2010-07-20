// license-header java merge-point
package es.pode.administracion.presentacion.categorias.verCategoria;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtieneCategoria</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.categorias.verCategoria.ObtenerCategoriaController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.categorias.verCategoria.ObtenerCategoriaController#obtieneCategoria
 */
public interface ObtieneCategoriaForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setNombreCategoria#sArray(Object[])
     */
    public void setNombreCategoria(java.util.Collection nombreCategoria);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getNombreCategoria#sArray()
     */
    public java.util.Collection getNombreCategoria();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setNombreCategoria(java.util.Collection)
     */
    public void setNombreCategoriaAsArray(Object[] nombreCategoria);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getNombreCategoria()
     */
    public java.lang.Object[] getNombreCategoriaAsArray();

    /**
     * Resets the <code>nombreCategoria</code> field.
     */
    public void resetNombreCategoria();

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
     * Sets the <code>idCategoriaNoticia</code> field.
     *
     * 
     */
    public void setIdCategoriaNoticia(java.lang.Long idCategoriaNoticia);

    /**
     * Gets the <code>idCategoriaNoticia</code> field.
     *
     * 
     */
    public java.lang.Long getIdCategoriaNoticia();
    
    /**
     * Resets the <code>idCategoriaNoticia</code> field.
     */
    public void resetIdCategoriaNoticia();

}

// license-header java merge-point
package es.pode.visualizador.presentacion.noticias;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerNoticias</code> method, which is located on the
 * <code>es.pode.visualizador.presentacion.noticias.NoticiasController</code> controller.
 *
 * 
 *
 * @see es.pode.visualizador.presentacion.noticias.NoticiasController#obtenerNoticias
 */
public interface ObtenerNoticiasForm
{
    /**
     * Sets the <code>idCategoria</code> field.
     *
     * 
     */
    public void setIdCategoria(java.lang.Long idCategoria);

    /**
     * Gets the <code>idCategoria</code> field.
     *
     * 
     */
    public java.lang.Long getIdCategoria();
    
    /**
     * Resets the <code>idCategoria</code> field.
     */
    public void resetIdCategoria();

    /**
     * Sets the <code>categoria</code> field.
     *
     * 
     */
    public void setCategoria(java.lang.String categoria);

    /**
     * Gets the <code>categoria</code> field.
     *
     * 
     */
    public java.lang.String getCategoria();
    
    /**
     * Resets the <code>categoria</code> field.
     */
    public void resetCategoria();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setNoticias#sArray(Object[])
     */
    public void setNoticias(java.util.Collection noticias);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getNoticias#sArray()
     */
    public java.util.Collection getNoticias();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setNoticias(java.util.Collection)
     */
    public void setNoticiasAsArray(Object[] noticias);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getNoticias()
     */
    public java.lang.Object[] getNoticiasAsArray();

    /**
     * Resets the <code>noticias</code> field.
     */
    public void resetNoticias();

}

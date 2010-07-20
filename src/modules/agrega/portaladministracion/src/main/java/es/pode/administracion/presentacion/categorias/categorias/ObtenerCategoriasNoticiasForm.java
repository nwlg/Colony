// license-header java merge-point
package es.pode.administracion.presentacion.categorias.categorias;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerCategoriasNoticias</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.categorias.categorias.CategoriasController</code> controller.
 *
 * <p>
 * Obtiene todas las categorías que hay presentes en las noticias.
 * </p>
 *
 * @see es.pode.administracion.presentacion.categorias.categorias.CategoriasController#obtenerCategoriasNoticias
 */
public interface ObtenerCategoriasNoticiasForm
{
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
     * @see #setCategoriasNoticias#sArray(Object[])
     */
    public void setCategoriasNoticias(java.util.Collection categoriasNoticias);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getCategoriasNoticias#sArray()
     */
    public java.util.Collection getCategoriasNoticias();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setCategoriasNoticias(java.util.Collection)
     */
    public void setCategoriasNoticiasAsArray(Object[] categoriasNoticias);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getCategoriasNoticias()
     */
    public java.lang.Object[] getCategoriasNoticiasAsArray();

    /**
     * Resets the <code>categoriasNoticias</code> field.
     */
    public void resetCategoriasNoticias();

}

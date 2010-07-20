// license-header java merge-point
package es.pode.administracion.presentacion.categoriasFaqs.categoriasFaqs;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerCategoriasFaqs</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.categoriasFaqs.categoriasFaqs.CategoriasFaqController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.categoriasFaqs.categoriasFaqs.CategoriasFaqController#obtenerCategoriasFaqs
 */
public interface ObtenerCategoriasFaqsForm
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
     * @see #setCategorias#sArray(Object[])
     */
    public void setCategorias(java.util.Collection categorias);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getCategorias#sArray()
     */
    public java.util.Collection getCategorias();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setCategorias(java.util.Collection)
     */
    public void setCategoriasAsArray(Object[] categorias);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getCategorias()
     */
    public java.lang.Object[] getCategoriasAsArray();

    /**
     * Resets the <code>categorias</code> field.
     */
    public void resetCategorias();

}

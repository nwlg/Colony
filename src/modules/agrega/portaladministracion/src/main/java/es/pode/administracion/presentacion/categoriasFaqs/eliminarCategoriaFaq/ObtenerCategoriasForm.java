// license-header java merge-point
package es.pode.administracion.presentacion.categoriasFaqs.eliminarCategoriaFaq;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerCategorias</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.categoriasFaqs.eliminarCategoriaFaq.EliminarCategoriaFaqController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.categoriasFaqs.eliminarCategoriaFaq.EliminarCategoriaFaqController#obtenerCategorias
 */
public interface ObtenerCategoriasForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setCategoriasFaqs#sArray(Object[])
     */
    public void setCategoriasFaqs(java.util.Collection categoriasFaqs);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getCategoriasFaqs#sArray()
     */
    public java.util.Collection getCategoriasFaqs();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setCategoriasFaqs(java.util.Collection)
     */
    public void setCategoriasFaqsAsArray(Object[] categoriasFaqs);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getCategoriasFaqs()
     */
    public java.lang.Object[] getCategoriasFaqsAsArray();

    /**
     * Resets the <code>categoriasFaqs</code> field.
     */
    public void resetCategoriasFaqs();

    /**
     * Sets the <code>listaIds</code> field.
     *
     * 
     */
    public void setListaIds(java.lang.String listaIds);

    /**
     * Gets the <code>listaIds</code> field.
     *
     * 
     */
    public java.lang.String getListaIds();
    
    /**
     * Resets the <code>listaIds</code> field.
     */
    public void resetListaIds();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIds#sArray(Object[])
     */
    public void setIds(java.util.Collection ids);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIds#sArray()
     */
    public java.util.Collection getIds();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIds(java.util.Collection)
     */
    public void setIdsAsArray(Object[] ids);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIds()
     */
    public java.lang.Object[] getIdsAsArray();

    /**
     * Resets the <code>ids</code> field.
     */
    public void resetIds();

    /**
     * Sets the <code>seleccionado</code> field.
     *
     * 
     */
    public void setSeleccionado(java.lang.String seleccionado);

    /**
     * Gets the <code>seleccionado</code> field.
     *
     * 
     */
    public java.lang.String getSeleccionado();
    
    /**
     * Resets the <code>seleccionado</code> field.
     */
    public void resetSeleccionado();

}

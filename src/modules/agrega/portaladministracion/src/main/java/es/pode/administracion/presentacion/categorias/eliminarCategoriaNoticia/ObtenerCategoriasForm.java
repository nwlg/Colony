// license-header java merge-point
package es.pode.administracion.presentacion.categorias.eliminarCategoriaNoticia;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerCategorias</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.categorias.eliminarCategoriaNoticia.EliminarCategoriaNoticiaController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.categorias.eliminarCategoriaNoticia.EliminarCategoriaNoticiaController#obtenerCategorias
 */
public interface ObtenerCategoriasForm
{
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

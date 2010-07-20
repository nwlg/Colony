// license-header java merge-point
package es.pode.visualizador.presentacion.faqs;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargaFaqs</code> method, which is located on the
 * <code>es.pode.visualizador.presentacion.faqs.FaqsController</code> controller.
 *
 * 
 *
 * @see es.pode.visualizador.presentacion.faqs.FaqsController#cargaFaqs
 */
public interface CargaFaqsForm
{
    /**
     * Sets the <code>categoriaSeleccionada</code> field.
     *
     * <p>
     * el indice en la coleccion categorias de lla categoria que
     * estamos viendo
     * </p>
     */
    public void setCategoriaSeleccionada(java.lang.Long categoriaSeleccionada);

    /**
     * Gets the <code>categoriaSeleccionada</code> field.
     *
     * <p>
     * el indice en la coleccion categorias de lla categoria que
     * estamos viendo
     * </p>
     */
    public java.lang.Long getCategoriaSeleccionada();
    
    /**
     * Resets the <code>categoriaSeleccionada</code> field.
     */
    public void resetCategoriaSeleccionada();

    /**
     * Sets the <code>faqs</code> field.
     *
     * 
     */
    public void setFaqs(es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaVO[] faqs);

    /**
     * Gets the <code>faqs</code> field.
     *
     * 
     */
    public es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaVO[] getFaqs();
    
    /**
     * Resets the <code>faqs</code> field.
     */
    public void resetFaqs();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * las categorias disponibles que hay
     * </p>
     *
     * @see #setCategorias#sArray(Object[])
     */
    public void setCategorias(java.util.Collection categorias);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * las categorias disponibles que hay
     * </p>
     *
     * @see #getCategorias#sArray()
     */
    public java.util.Collection getCategorias();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * las categorias disponibles que hay
     * </p>
     *
     * @see #setCategorias(java.util.Collection)
     */
    public void setCategoriasAsArray(Object[] categorias);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * las categorias disponibles que hay
     * </p>
     *
     * @see #getCategorias()
     */
    public java.lang.Object[] getCategoriasAsArray();

    /**
     * Resets the <code>categorias</code> field.
     */
    public void resetCategorias();

}

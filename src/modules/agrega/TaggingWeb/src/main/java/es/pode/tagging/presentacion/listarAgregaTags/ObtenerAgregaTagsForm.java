// license-header java merge-point
package es.pode.tagging.presentacion.listarAgregaTags;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerAgregaTags</code> method, which is located on the
 * <code>es.pode.tagging.presentacion.listarAgregaTags.ListarAgregaTagsController</code> controller.
 *
 * 
 *
 * @see es.pode.tagging.presentacion.listarAgregaTags.ListarAgregaTagsController#obtenerAgregaTags
 */
public interface ObtenerAgregaTagsForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTags#sArray(Object[])
     */
    public void setTags(java.util.Collection tags);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTags#sArray()
     */
    public java.util.Collection getTags();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTags(java.util.Collection)
     */
    public void setTagsAsArray(Object[] tags);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTags()
     */
    public java.lang.Object[] getTagsAsArray();

    /**
     * Resets the <code>tags</code> field.
     */
    public void resetTags();

    /**
     * Sets the <code>esAnonimo</code> field.
     *
     * 
     */
    public void setEsAnonimo(boolean esAnonimo);

    /**
     * Gets the <code>esAnonimo</code> field.
     *
     * 
     */
    public boolean isEsAnonimo();
    
    /**
     * Resets the <code>esAnonimo</code> field.
     */
    public void resetEsAnonimo();

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

}

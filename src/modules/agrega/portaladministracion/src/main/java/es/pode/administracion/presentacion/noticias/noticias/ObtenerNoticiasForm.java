// license-header java merge-point
package es.pode.administracion.presentacion.noticias.noticias;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerNoticias</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.noticias.noticias.NoticiasController</code> controller.
 *
 * <p>
 * Llama al servicio de Contenidos Portal para obtener un listado
 * de las noticias existentes.
 * </p>
 *
 * @see es.pode.administracion.presentacion.noticias.noticias.NoticiasController#obtenerNoticias
 */
public interface ObtenerNoticiasForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * <p>
     * Listado de noticias existentes en el nodo.
     * </p>
     *
     * @see #setNoticias#sArray(Object[])
     */
    public void setNoticias(java.util.Collection noticias);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * <p>
     * Listado de noticias existentes en el nodo.
     * </p>
     *
     * @see #getNoticias#sArray()
     */
    public java.util.Collection getNoticias();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * <p>
     * Listado de noticias existentes en el nodo.
     * </p>
     *
     * @see #setNoticias(java.util.Collection)
     */
    public void setNoticiasAsArray(Object[] noticias);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * <p>
     * Listado de noticias existentes en el nodo.
     * </p>
     *
     * @see #getNoticias()
     */
    public java.lang.Object[] getNoticiasAsArray();

    /**
     * Resets the <code>noticias</code> field.
     */
    public void resetNoticias();

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

}

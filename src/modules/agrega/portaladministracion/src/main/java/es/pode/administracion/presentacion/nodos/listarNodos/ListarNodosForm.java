// license-header java merge-point
package es.pode.administracion.presentacion.nodos.listarNodos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>listarNodos</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.nodos.listarNodos.ListarNodosController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.nodos.listarNodos.ListarNodosController#listarNodos
 */
public interface ListarNodosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setNodos#sArray(Object[])
     */
    public void setNodos(java.util.Collection nodos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getNodos#sArray()
     */
    public java.util.Collection getNodos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setNodos(java.util.Collection)
     */
    public void setNodosAsArray(Object[] nodos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getNodos()
     */
    public java.lang.Object[] getNodosAsArray();

    /**
     * Resets the <code>nodos</code> field.
     */
    public void resetNodos();

}

// license-header java merge-point
package es.pode.administracion.presentacion.monitorizarnodos.monitorizar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>estadoNodos</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.monitorizarnodos.monitorizar.MonitorizarNodosController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.monitorizarnodos.monitorizar.MonitorizarNodosController#estadoNodos
 */
public interface EstadoNodosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setEstados#sArray(Object[])
     */
    public void setEstados(java.util.Collection estados);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getEstados#sArray()
     */
    public java.util.Collection getEstados();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setEstados(java.util.Collection)
     */
    public void setEstadosAsArray(Object[] estados);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getEstados()
     */
    public java.lang.Object[] getEstadosAsArray();

    /**
     * Resets the <code>estados</code> field.
     */
    public void resetEstados();

}

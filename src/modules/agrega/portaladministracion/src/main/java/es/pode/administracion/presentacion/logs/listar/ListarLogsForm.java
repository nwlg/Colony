// license-header java merge-point
package es.pode.administracion.presentacion.logs.listar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>listarLogs</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.logs.listar.ListarLogController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.logs.listar.ListarLogController#listarLogs
 */
public interface ListarLogsForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setLogs#sArray(Object[])
     */
    public void setLogs(java.util.Collection logs);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getLogs#sArray()
     */
    public java.util.Collection getLogs();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setLogs(java.util.Collection)
     */
    public void setLogsAsArray(Object[] logs);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getLogs()
     */
    public java.lang.Object[] getLogsAsArray();

    /**
     * Resets the <code>logs</code> field.
     */
    public void resetLogs();

}

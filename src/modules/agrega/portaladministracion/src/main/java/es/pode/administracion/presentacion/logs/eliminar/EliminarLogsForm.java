// license-header java merge-point
package es.pode.administracion.presentacion.logs.eliminar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>eliminarLogs</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.logs.eliminar.EliminarLogController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.logs.eliminar.EliminarLogController#eliminarLogs
 */
public interface EliminarLogsForm
{
    /**
     * Sets the <code>listaId</code> field.
     *
     * 
     */
    public void setListaId(java.lang.String listaId);

    /**
     * Gets the <code>listaId</code> field.
     *
     * 
     */
    public java.lang.String getListaId();
    
    /**
     * Resets the <code>listaId</code> field.
     */
    public void resetListaId();

    /**
     * Sets the <code>logs</code> field.
     *
     * 
     */
    public void setLogs(java.lang.String[] logs);

    /**
     * Gets the <code>logs</code> field.
     *
     * 
     */
    public java.lang.String[] getLogs();
    
    /**
     * Resets the <code>logs</code> field.
     */
    public void resetLogs();

    /**
     * The <code>logs</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getLogs()
     * @see #getLogsValueList()
     * @see #getLogsLabelList()
     * @see #setLogsLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getLogsBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * logs property. This method takes a collection of objects, as well as
     * the property names to query on these objects in order to find the corresponding
     * values and labels.
     * <p/>
     * Let's say you have a set of value objects with the following properties:
     * <ul>
     *  <li><code>id</code></li>
     *  <li><code>code</code></li>
     *  <li><code>name</code></li>
     *  <li><code>description</code></li>
     * </ul>
     * But you need to populate the logs backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setLogsBackingList(valueObjects, "id", "name")</code>
     * <p/>
     * This method knows how to handle primitive property types as it simply delegates to
     * <code>org.apache.commons.beanutils.PropertyUtils.getProperty(Object, String)</code>.
     *
     * @param items The items from which to read the properties, if this argument is <code>null</code> this method
     *        will simply clear the existing values and labels
     * @param valueProperty the name of the property to query on each object to retrieve
     *        the corresponding value, cannot be <code>null</code>
     * @throws java.lang.IllegalArgumentException if the valueProperty or labelProperty is <code>null</code>
     * @throws java.lang.RuntimeException if one of the items in the collection is <code>null</code>, or
     *         if the caller does not have access one of the object's properties, if an exception was thrown while
     *         accessing a property or if the property does not exist on at least one of the items
     *
     * @see #getLogs()
     * @see #getLogsValueList()
     * @see #getLogsLabelList()
     * @see #getLogsLabelList()
     */
    public void setLogsBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>logs</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getLogs()
     * @see #getLogsBackingList()
     */
    public java.lang.Object[] getLogsValueList();

    /**
     * The <code>logs</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getLogs()
     * @see #getLogsBackingList()
     */
    public void setLogsValueList(java.lang.Object[] logsValueList);

    /**
     * The <code>logs</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getLogs()
     * @see #getLogsBackingList()
     */
    public java.lang.Object[] getLogsLabelList();

    /**
     * The <code>logs</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getLogs()
     * @see #getLogsBackingList()
     */
    public void setLogsLabelList(java.lang.Object[] logsLabelList);

    /**
     * Sets the <code>logsBorrados</code> field.
     *
     * 
     */
    public void setLogsBorrados(java.lang.String[] logsBorrados);

    /**
     * Gets the <code>logsBorrados</code> field.
     *
     * 
     */
    public java.lang.String[] getLogsBorrados();
    
    /**
     * Resets the <code>logsBorrados</code> field.
     */
    public void resetLogsBorrados();

    /**
     * Sets the <code>resultado</code> field.
     *
     * 
     */
    public void setResultado(java.lang.String resultado);

    /**
     * Gets the <code>resultado</code> field.
     *
     * 
     */
    public java.lang.String getResultado();
    
    /**
     * Resets the <code>resultado</code> field.
     */
    public void resetResultado();

}

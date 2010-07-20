// license-header java merge-point
package es.pode.modificador.presentacion.configurar.modificacion;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submitObjetos</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionController</code> controller.
 *
 * 
 *
 * @see es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionController#submitObjetos
 */
public interface SubmitObjetosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setPaths#sArray(Object[])
     */
    public void setPaths(java.util.List paths);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getPaths#sArray()
     */
    public java.util.List getPaths();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setPaths(java.util.List)
     */
    public void setPathsAsArray(Object[] paths);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getPaths()
     */
    public java.lang.Object[] getPathsAsArray();

    /**
     * Resets the <code>paths</code> field.
     */
    public void resetPaths();

    /**
     * The <code>paths</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getPaths()
     * @see #getPathsValueList()
     * @see #getPathsLabelList()
     * @see #setPathsLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getPathsBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * paths property. This method takes a collection of objects, as well as
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
     * But you need to populate the paths backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setPathsBackingList(valueObjects, "id", "name")</code>
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
     * @see #getPaths()
     * @see #getPathsValueList()
     * @see #getPathsLabelList()
     * @see #getPathsLabelList()
     */
    public void setPathsBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>paths</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getPaths()
     * @see #getPathsBackingList()
     */
    public java.lang.Object[] getPathsValueList();

    /**
     * The <code>paths</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getPaths()
     * @see #getPathsBackingList()
     */
    public void setPathsValueList(java.lang.Object[] pathsValueList);

    /**
     * The <code>paths</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getPaths()
     * @see #getPathsBackingList()
     */
    public java.lang.Object[] getPathsLabelList();

    /**
     * The <code>paths</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getPaths()
     * @see #getPathsBackingList()
     */
    public void setPathsLabelList(java.lang.Object[] pathsLabelList);

    /**
     * Sets the <code>action</code> field.
     *
     * 
     */
    public void setAction(java.lang.String action);

    /**
     * Gets the <code>action</code> field.
     *
     * 
     */
    public java.lang.String getAction();
    
    /**
     * Resets the <code>action</code> field.
     */
    public void resetAction();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it into the form.
     *
     * 
     *
     * @see #setPathRowSelection#sArray(java.lang.String[])
     */
    public void setPathRowSelection(java.util.List pathRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it from the form.
     *
     * 
     *
     * @see #getPathRowSelection#sArray()
     */
    public java.util.List getPathRowSelection();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it as an array into the form, conversion will be
     * automatically performed.
     *
     * 
     *
     * @see #setPathRowSelection(java.util.List)
     */
    public void setPathRowSelectionAsArray(java.lang.String[] pathRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getPathRowSelection()
     */
    public java.lang.String[] getPathRowSelectionAsArray();

    /**
     * Resets the <code>path</code> field.
     */
    public void resetPath();

}

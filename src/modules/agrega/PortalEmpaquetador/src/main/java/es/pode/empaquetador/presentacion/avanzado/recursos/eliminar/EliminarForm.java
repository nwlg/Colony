// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.eliminar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>eliminar</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.recursos.eliminar.EliminarRecursosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.eliminar.EliminarRecursosController#eliminar
 */
public interface EliminarForm
{
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
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setRecursosVO#sArray(Object[])
     */
    public void setRecursosVO(java.util.List recursosVO);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getRecursosVO#sArray()
     */
    public java.util.List getRecursosVO();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setRecursosVO(java.util.List)
     */
    public void setRecursosVOAsArray(Object[] recursosVO);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getRecursosVO()
     */
    public java.lang.Object[] getRecursosVOAsArray();

    /**
     * Resets the <code>recursosVO</code> field.
     */
    public void resetRecursosVO();

    /**
     * The <code>recursosVO</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getRecursosVO()
     * @see #getRecursosVOValueList()
     * @see #getRecursosVOLabelList()
     * @see #setRecursosVOLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getRecursosVOBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * recursosVO property. This method takes a collection of objects, as well as
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
     * But you need to populate the recursosVO backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setRecursosVOBackingList(valueObjects, "id", "name")</code>
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
     * @see #getRecursosVO()
     * @see #getRecursosVOValueList()
     * @see #getRecursosVOLabelList()
     * @see #getRecursosVOLabelList()
     */
    public void setRecursosVOBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>recursosVO</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getRecursosVO()
     * @see #getRecursosVOBackingList()
     */
    public java.lang.Object[] getRecursosVOValueList();

    /**
     * The <code>recursosVO</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getRecursosVO()
     * @see #getRecursosVOBackingList()
     */
    public void setRecursosVOValueList(java.lang.Object[] recursosVOValueList);

    /**
     * The <code>recursosVO</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getRecursosVO()
     * @see #getRecursosVOBackingList()
     */
    public java.lang.Object[] getRecursosVOLabelList();

    /**
     * The <code>recursosVO</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getRecursosVO()
     * @see #getRecursosVOBackingList()
     */
    public void setRecursosVOLabelList(java.lang.Object[] recursosVOLabelList);

}

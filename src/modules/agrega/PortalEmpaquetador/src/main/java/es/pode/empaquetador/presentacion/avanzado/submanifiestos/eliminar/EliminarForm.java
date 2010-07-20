// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>eliminar</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.EliminarSubmanifiestosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar.EliminarSubmanifiestosController#eliminar
 */
public interface EliminarForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIdentificadores#sArray(Object[])
     */
    public void setIdentificadores(java.util.List identificadores);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIdentificadores#sArray()
     */
    public java.util.List getIdentificadores();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIdentificadores(java.util.List)
     */
    public void setIdentificadoresAsArray(Object[] identificadores);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIdentificadores()
     */
    public java.lang.Object[] getIdentificadoresAsArray();

    /**
     * Resets the <code>identificadores</code> field.
     */
    public void resetIdentificadores();

    /**
     * The <code>identificadores</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getIdentificadores()
     * @see #getIdentificadoresValueList()
     * @see #getIdentificadoresLabelList()
     * @see #setIdentificadoresLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getIdentificadoresBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * identificadores property. This method takes a collection of objects, as well as
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
     * But you need to populate the identificadores backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setIdentificadoresBackingList(valueObjects, "id", "name")</code>
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
     * @see #getIdentificadores()
     * @see #getIdentificadoresValueList()
     * @see #getIdentificadoresLabelList()
     * @see #getIdentificadoresLabelList()
     */
    public void setIdentificadoresBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>identificadores</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getIdentificadores()
     * @see #getIdentificadoresBackingList()
     */
    public java.lang.Object[] getIdentificadoresValueList();

    /**
     * The <code>identificadores</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getIdentificadores()
     * @see #getIdentificadoresBackingList()
     */
    public void setIdentificadoresValueList(java.lang.Object[] identificadoresValueList);

    /**
     * The <code>identificadores</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getIdentificadores()
     * @see #getIdentificadoresBackingList()
     */
    public java.lang.Object[] getIdentificadoresLabelList();

    /**
     * The <code>identificadores</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getIdentificadores()
     * @see #getIdentificadoresBackingList()
     */
    public void setIdentificadoresLabelList(java.lang.Object[] identificadoresLabelList);

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

}

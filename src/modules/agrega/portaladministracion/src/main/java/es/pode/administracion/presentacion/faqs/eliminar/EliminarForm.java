// license-header java merge-point
package es.pode.administracion.presentacion.faqs.eliminar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>eliminar</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.faqs.eliminar.EliminarController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.faqs.eliminar.EliminarController#eliminar
 */
public interface EliminarForm
{
    /**
     * Sets the <code>listaIds</code> field.
     *
     * 
     */
    public void setListaIds(java.lang.String listaIds);

    /**
     * Gets the <code>listaIds</code> field.
     *
     * 
     */
    public java.lang.String getListaIds();
    
    /**
     * Resets the <code>listaIds</code> field.
     */
    public void resetListaIds();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setFaqsDeleted#sArray(Object[])
     */
    public void setFaqsDeleted(java.util.Collection faqsDeleted);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getFaqsDeleted#sArray()
     */
    public java.util.Collection getFaqsDeleted();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setFaqsDeleted(java.util.Collection)
     */
    public void setFaqsDeletedAsArray(Object[] faqsDeleted);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getFaqsDeleted()
     */
    public java.lang.Object[] getFaqsDeletedAsArray();

    /**
     * Resets the <code>faqsDeleted</code> field.
     */
    public void resetFaqsDeleted();

    /**
     * The <code>faqsDeleted</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getFaqsDeleted()
     * @see #getFaqsDeletedValueList()
     * @see #getFaqsDeletedLabelList()
     * @see #setFaqsDeletedLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getFaqsDeletedBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * faqsDeleted property. This method takes a collection of objects, as well as
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
     * But you need to populate the faqsDeleted backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setFaqsDeletedBackingList(valueObjects, "id", "name")</code>
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
     * @see #getFaqsDeleted()
     * @see #getFaqsDeletedValueList()
     * @see #getFaqsDeletedLabelList()
     * @see #getFaqsDeletedLabelList()
     */
    public void setFaqsDeletedBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>faqsDeleted</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getFaqsDeleted()
     * @see #getFaqsDeletedBackingList()
     */
    public java.lang.Object[] getFaqsDeletedValueList();

    /**
     * The <code>faqsDeleted</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getFaqsDeleted()
     * @see #getFaqsDeletedBackingList()
     */
    public void setFaqsDeletedValueList(java.lang.Object[] faqsDeletedValueList);

    /**
     * The <code>faqsDeleted</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getFaqsDeleted()
     * @see #getFaqsDeletedBackingList()
     */
    public java.lang.Object[] getFaqsDeletedLabelList();

    /**
     * The <code>faqsDeleted</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getFaqsDeleted()
     * @see #getFaqsDeletedBackingList()
     */
    public void setFaqsDeletedLabelList(java.lang.Object[] faqsDeletedLabelList);

}

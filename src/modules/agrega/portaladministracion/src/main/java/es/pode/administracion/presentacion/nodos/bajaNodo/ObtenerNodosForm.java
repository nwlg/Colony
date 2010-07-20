// license-header java merge-point
package es.pode.administracion.presentacion.nodos.bajaNodo;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerNodos</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.nodos.bajaNodo.BajaNodoController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.nodos.bajaNodo.BajaNodoController#obtenerNodos
 */
public interface ObtenerNodosForm
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
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIds#sArray(Object[])
     */
    public void setIds(java.util.Collection ids);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIds#sArray()
     */
    public java.util.Collection getIds();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIds(java.util.Collection)
     */
    public void setIdsAsArray(Object[] ids);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIds()
     */
    public java.lang.Object[] getIdsAsArray();

    /**
     * Resets the <code>ids</code> field.
     */
    public void resetIds();

    /**
     * Sets the <code>nodos</code> field.
     *
     * 
     */
    public void setNodos(es.pode.buscar.negocio.administrar.servicio.NodoVO[] nodos);

    /**
     * Gets the <code>nodos</code> field.
     *
     * 
     */
    public es.pode.buscar.negocio.administrar.servicio.NodoVO[] getNodos();
    
    /**
     * Resets the <code>nodos</code> field.
     */
    public void resetNodos();

    /**
     * The <code>nodos</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getNodos()
     * @see #getNodosValueList()
     * @see #getNodosLabelList()
     * @see #setNodosLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getNodosBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * nodos property. This method takes a collection of objects, as well as
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
     * But you need to populate the nodos backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setNodosBackingList(valueObjects, "id", "name")</code>
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
     * @see #getNodos()
     * @see #getNodosValueList()
     * @see #getNodosLabelList()
     * @see #getNodosLabelList()
     */
    public void setNodosBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>nodos</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getNodos()
     * @see #getNodosBackingList()
     */
    public java.lang.Object[] getNodosValueList();

    /**
     * The <code>nodos</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getNodos()
     * @see #getNodosBackingList()
     */
    public void setNodosValueList(java.lang.Object[] nodosValueList);

    /**
     * The <code>nodos</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getNodos()
     * @see #getNodosBackingList()
     */
    public java.lang.Object[] getNodosLabelList();

    /**
     * The <code>nodos</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getNodos()
     * @see #getNodosBackingList()
     */
    public void setNodosLabelList(java.lang.Object[] nodosLabelList);

}

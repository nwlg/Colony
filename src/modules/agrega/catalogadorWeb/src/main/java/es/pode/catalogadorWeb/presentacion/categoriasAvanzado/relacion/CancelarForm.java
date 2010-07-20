// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cancelar</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.RelacionController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.RelacionController#cancelar
 */
public interface CancelarForm
{
    /**
     * Sets the <code>identificadorOde</code> field.
     *
     * 
     */
    public void setIdentificadorOde(java.lang.String identificadorOde);

    /**
     * Gets the <code>identificadorOde</code> field.
     *
     * 
     */
    public java.lang.String getIdentificadorOde();
    
    /**
     * Resets the <code>identificadorOde</code> field.
     */
    public void resetIdentificadorOde();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setListadoRelaciones#sArray(Object[])
     */
    public void setListadoRelaciones(java.util.Collection listadoRelaciones);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getListadoRelaciones#sArray()
     */
    public java.util.Collection getListadoRelaciones();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setListadoRelaciones(java.util.Collection)
     */
    public void setListadoRelacionesAsArray(Object[] listadoRelaciones);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getListadoRelaciones()
     */
    public java.lang.Object[] getListadoRelacionesAsArray();

    /**
     * Resets the <code>listadoRelaciones</code> field.
     */
    public void resetListadoRelaciones();

    /**
     * The <code>listadoRelaciones</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getListadoRelaciones()
     * @see #getListadoRelacionesValueList()
     * @see #getListadoRelacionesLabelList()
     * @see #setListadoRelacionesLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getListadoRelacionesBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * listadoRelaciones property. This method takes a collection of objects, as well as
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
     * But you need to populate the listadoRelaciones backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setListadoRelacionesBackingList(valueObjects, "id", "name")</code>
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
     * @see #getListadoRelaciones()
     * @see #getListadoRelacionesValueList()
     * @see #getListadoRelacionesLabelList()
     * @see #getListadoRelacionesLabelList()
     */
    public void setListadoRelacionesBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>listadoRelaciones</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getListadoRelaciones()
     * @see #getListadoRelacionesBackingList()
     */
    public java.lang.Object[] getListadoRelacionesValueList();

    /**
     * The <code>listadoRelaciones</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getListadoRelaciones()
     * @see #getListadoRelacionesBackingList()
     */
    public void setListadoRelacionesValueList(java.lang.Object[] listadoRelacionesValueList);

    /**
     * The <code>listadoRelaciones</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getListadoRelaciones()
     * @see #getListadoRelacionesBackingList()
     */
    public java.lang.Object[] getListadoRelacionesLabelList();

    /**
     * The <code>listadoRelaciones</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getListadoRelaciones()
     * @see #getListadoRelacionesBackingList()
     */
    public void setListadoRelacionesLabelList(java.lang.Object[] listadoRelacionesLabelList);

}

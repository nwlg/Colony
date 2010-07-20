// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>eliminarClasificacion</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionController#eliminarClasificacion
 */
public interface EliminarClasificacionForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setListadoClasificacion#sArray(Object[])
     */
    public void setListadoClasificacion(java.util.Collection listadoClasificacion);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getListadoClasificacion#sArray()
     */
    public java.util.Collection getListadoClasificacion();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setListadoClasificacion(java.util.Collection)
     */
    public void setListadoClasificacionAsArray(Object[] listadoClasificacion);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getListadoClasificacion()
     */
    public java.lang.Object[] getListadoClasificacionAsArray();

    /**
     * Resets the <code>listadoClasificacion</code> field.
     */
    public void resetListadoClasificacion();

    /**
     * The <code>listadoClasificacion</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getListadoClasificacion()
     * @see #getListadoClasificacionValueList()
     * @see #getListadoClasificacionLabelList()
     * @see #setListadoClasificacionLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getListadoClasificacionBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * listadoClasificacion property. This method takes a collection of objects, as well as
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
     * But you need to populate the listadoClasificacion backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setListadoClasificacionBackingList(valueObjects, "id", "name")</code>
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
     * @see #getListadoClasificacion()
     * @see #getListadoClasificacionValueList()
     * @see #getListadoClasificacionLabelList()
     * @see #getListadoClasificacionLabelList()
     */
    public void setListadoClasificacionBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>listadoClasificacion</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getListadoClasificacion()
     * @see #getListadoClasificacionBackingList()
     */
    public java.lang.Object[] getListadoClasificacionValueList();

    /**
     * The <code>listadoClasificacion</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getListadoClasificacion()
     * @see #getListadoClasificacionBackingList()
     */
    public void setListadoClasificacionValueList(java.lang.Object[] listadoClasificacionValueList);

    /**
     * The <code>listadoClasificacion</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getListadoClasificacion()
     * @see #getListadoClasificacionBackingList()
     */
    public java.lang.Object[] getListadoClasificacionLabelList();

    /**
     * The <code>listadoClasificacion</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getListadoClasificacion()
     * @see #getListadoClasificacionBackingList()
     */
    public void setListadoClasificacionLabelList(java.lang.Object[] listadoClasificacionLabelList);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTituloClasificacionRowSelection#sArray(java.lang.String[])
     */
    public void setTituloClasificacionRowSelection(java.util.List tituloClasificacionRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTituloClasificacionRowSelection#sArray()
     */
    public java.util.List getTituloClasificacionRowSelection();

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to set it as an array into the form, conversion will be
     * automatically performed.
     *
     * 
     *
     * @see #setTituloClasificacionRowSelection(java.util.List)
     */
    public void setTituloClasificacionRowSelectionAsArray(java.lang.String[] tituloClasificacionRowSelection);

    /**
     * This field represents a selection of rows from the <em>$field.tableGlobalActionParameter.name</em> table
     * page-variable, this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTituloClasificacionRowSelection()
     */
    public java.lang.String[] getTituloClasificacionRowSelectionAsArray();

    /**
     * Resets the <code>tituloClasificacion</code> field.
     */
    public void resetTituloClasificacion();

}

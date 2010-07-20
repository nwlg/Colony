// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarUsosEducativos</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.verMetadatos.VerMetadatosController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.verMetadatos.VerMetadatosController#cargarUsosEducativos
 */
public interface CargarUsosEducativosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setListadoUsosEdu#sArray(Object[])
     */
    public void setListadoUsosEdu(java.util.Collection listadoUsosEdu);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getListadoUsosEdu#sArray()
     */
    public java.util.Collection getListadoUsosEdu();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setListadoUsosEdu(java.util.Collection)
     */
    public void setListadoUsosEduAsArray(Object[] listadoUsosEdu);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getListadoUsosEdu()
     */
    public java.lang.Object[] getListadoUsosEduAsArray();

    /**
     * Resets the <code>listadoUsosEdu</code> field.
     */
    public void resetListadoUsosEdu();

    /**
     * The <code>listadoUsosEdu</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getListadoUsosEdu()
     * @see #getListadoUsosEduValueList()
     * @see #getListadoUsosEduLabelList()
     * @see #setListadoUsosEduLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getListadoUsosEduBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * listadoUsosEdu property. This method takes a collection of objects, as well as
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
     * But you need to populate the listadoUsosEdu backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setListadoUsosEduBackingList(valueObjects, "id", "name")</code>
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
     * @see #getListadoUsosEdu()
     * @see #getListadoUsosEduValueList()
     * @see #getListadoUsosEduLabelList()
     * @see #getListadoUsosEduLabelList()
     */
    public void setListadoUsosEduBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>listadoUsosEdu</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getListadoUsosEdu()
     * @see #getListadoUsosEduBackingList()
     */
    public java.lang.Object[] getListadoUsosEduValueList();

    /**
     * The <code>listadoUsosEdu</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getListadoUsosEdu()
     * @see #getListadoUsosEduBackingList()
     */
    public void setListadoUsosEduValueList(java.lang.Object[] listadoUsosEduValueList);

    /**
     * The <code>listadoUsosEdu</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getListadoUsosEdu()
     * @see #getListadoUsosEduBackingList()
     */
    public java.lang.Object[] getListadoUsosEduLabelList();

    /**
     * The <code>listadoUsosEdu</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getListadoUsosEdu()
     * @see #getListadoUsosEduBackingList()
     */
    public void setListadoUsosEduLabelList(java.lang.Object[] listadoUsosEduLabelList);

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

}

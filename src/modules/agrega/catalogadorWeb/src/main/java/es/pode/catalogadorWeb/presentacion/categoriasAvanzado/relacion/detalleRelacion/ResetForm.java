// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>reset</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.detalleRelacion.DetalleRelacionController#reset
 */
public interface ResetForm
{
    /**
     * Sets the <code>tituloRelacion</code> field.
     *
     * 
     */
    public void setTituloRelacion(java.lang.String tituloRelacion);

    /**
     * Gets the <code>tituloRelacion</code> field.
     *
     * 
     */
    public java.lang.String getTituloRelacion();
    
    /**
     * Resets the <code>tituloRelacion</code> field.
     */
    public void resetTituloRelacion();

    /**
     * Sets the <code>comboIdioma</code> field.
     *
     * 
     */
    public void setComboIdioma(java.lang.String comboIdioma);

    /**
     * Gets the <code>comboIdioma</code> field.
     *
     * 
     */
    public java.lang.String getComboIdioma();
    
    /**
     * Resets the <code>comboIdioma</code> field.
     */
    public void resetComboIdioma();

    /**
     * The <code>comboIdioma</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboIdioma()
     * @see #getComboIdiomaValueList()
     * @see #getComboIdiomaLabelList()
     * @see #setComboIdiomaLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboIdiomaBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboIdioma property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboIdioma backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboIdiomaBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboIdioma()
     * @see #getComboIdiomaValueList()
     * @see #getComboIdiomaLabelList()
     * @see #getComboIdiomaLabelList()
     */
    public void setComboIdiomaBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboIdioma</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboIdioma()
     * @see #getComboIdiomaBackingList()
     */
    public java.lang.Object[] getComboIdiomaValueList();

    /**
     * The <code>comboIdioma</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboIdioma()
     * @see #getComboIdiomaBackingList()
     */
    public void setComboIdiomaValueList(java.lang.Object[] comboIdiomaValueList);

    /**
     * The <code>comboIdioma</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboIdioma()
     * @see #getComboIdiomaBackingList()
     */
    public java.lang.Object[] getComboIdiomaLabelList();

    /**
     * The <code>comboIdioma</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboIdioma()
     * @see #getComboIdiomaBackingList()
     */
    public void setComboIdiomaLabelList(java.lang.Object[] comboIdiomaLabelList);

    /**
     * Sets the <code>catalogo</code> field.
     *
     * 
     */
    public void setCatalogo(java.lang.String catalogo);

    /**
     * Gets the <code>catalogo</code> field.
     *
     * 
     */
    public java.lang.String getCatalogo();
    
    /**
     * Resets the <code>catalogo</code> field.
     */
    public void resetCatalogo();

    /**
     * Sets the <code>tipo</code> field.
     *
     * 
     */
    public void setTipo(java.lang.String tipo);

    /**
     * Gets the <code>tipo</code> field.
     *
     * 
     */
    public java.lang.String getTipo();
    
    /**
     * Resets the <code>tipo</code> field.
     */
    public void resetTipo();

    /**
     * The <code>tipo</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getTipo()
     * @see #getTipoValueList()
     * @see #getTipoLabelList()
     * @see #setTipoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getTipoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * tipo property. This method takes a collection of objects, as well as
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
     * But you need to populate the tipo backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setTipoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getTipo()
     * @see #getTipoValueList()
     * @see #getTipoLabelList()
     * @see #getTipoLabelList()
     */
    public void setTipoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>tipo</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getTipo()
     * @see #getTipoBackingList()
     */
    public java.lang.Object[] getTipoValueList();

    /**
     * The <code>tipo</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getTipo()
     * @see #getTipoBackingList()
     */
    public void setTipoValueList(java.lang.Object[] tipoValueList);

    /**
     * The <code>tipo</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getTipo()
     * @see #getTipoBackingList()
     */
    public java.lang.Object[] getTipoLabelList();

    /**
     * The <code>tipo</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getTipo()
     * @see #getTipoBackingList()
     */
    public void setTipoLabelList(java.lang.Object[] tipoLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setDescripcion#sArray(Object[])
     */
    public void setDescripcion(java.util.Collection descripcion);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getDescripcion#sArray()
     */
    public java.util.Collection getDescripcion();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setDescripcion(java.util.Collection)
     */
    public void setDescripcionAsArray(Object[] descripcion);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getDescripcion()
     */
    public java.lang.Object[] getDescripcionAsArray();

    /**
     * Resets the <code>descripcion</code> field.
     */
    public void resetDescripcion();

    /**
     * The <code>descripcion</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getDescripcion()
     * @see #getDescripcionValueList()
     * @see #getDescripcionLabelList()
     * @see #setDescripcionLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getDescripcionBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * descripcion property. This method takes a collection of objects, as well as
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
     * But you need to populate the descripcion backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setDescripcionBackingList(valueObjects, "id", "name")</code>
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
     * @see #getDescripcion()
     * @see #getDescripcionValueList()
     * @see #getDescripcionLabelList()
     * @see #getDescripcionLabelList()
     */
    public void setDescripcionBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>descripcion</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getDescripcion()
     * @see #getDescripcionBackingList()
     */
    public java.lang.Object[] getDescripcionValueList();

    /**
     * The <code>descripcion</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getDescripcion()
     * @see #getDescripcionBackingList()
     */
    public void setDescripcionValueList(java.lang.Object[] descripcionValueList);

    /**
     * The <code>descripcion</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getDescripcion()
     * @see #getDescripcionBackingList()
     */
    public java.lang.Object[] getDescripcionLabelList();

    /**
     * The <code>descripcion</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getDescripcion()
     * @see #getDescripcionBackingList()
     */
    public void setDescripcionLabelList(java.lang.Object[] descripcionLabelList);

    /**
     * Sets the <code>entrada</code> field.
     *
     * 
     */
    public void setEntrada(java.lang.String entrada);

    /**
     * Gets the <code>entrada</code> field.
     *
     * 
     */
    public java.lang.String getEntrada();
    
    /**
     * Resets the <code>entrada</code> field.
     */
    public void resetEntrada();

}

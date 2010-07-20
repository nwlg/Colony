// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorAvanzado;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>sonValidosMetadatos</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CatAvanzadoController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CatAvanzadoController#sonValidosMetadatos
 */
public interface SonValidosMetadatosForm
{
    /**
     * Sets the <code>identificador</code> field.
     *
     * 
     */
    public void setIdentificador(java.lang.String identificador);

    /**
     * Gets the <code>identificador</code> field.
     *
     * 
     */
    public java.lang.String getIdentificador();
    
    /**
     * Resets the <code>identificador</code> field.
     */
    public void resetIdentificador();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setDatos#sArray(Object[])
     */
    public void setDatos(java.util.Collection datos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getDatos#sArray()
     */
    public java.util.Collection getDatos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setDatos(java.util.Collection)
     */
    public void setDatosAsArray(Object[] datos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getDatos()
     */
    public java.lang.Object[] getDatosAsArray();

    /**
     * Resets the <code>datos</code> field.
     */
    public void resetDatos();

    /**
     * The <code>datos</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getDatos()
     * @see #getDatosValueList()
     * @see #getDatosLabelList()
     * @see #setDatosLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getDatosBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * datos property. This method takes a collection of objects, as well as
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
     * But you need to populate the datos backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setDatosBackingList(valueObjects, "id", "name")</code>
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
     * @see #getDatos()
     * @see #getDatosValueList()
     * @see #getDatosLabelList()
     * @see #getDatosLabelList()
     */
    public void setDatosBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>datos</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getDatos()
     * @see #getDatosBackingList()
     */
    public java.lang.Object[] getDatosValueList();

    /**
     * The <code>datos</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getDatos()
     * @see #getDatosBackingList()
     */
    public void setDatosValueList(java.lang.Object[] datosValueList);

    /**
     * The <code>datos</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getDatos()
     * @see #getDatosBackingList()
     */
    public java.lang.Object[] getDatosLabelList();

    /**
     * The <code>datos</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getDatos()
     * @see #getDatosBackingList()
     */
    public void setDatosLabelList(java.lang.Object[] datosLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setMensajesError#sArray(Object[])
     */
    public void setMensajesError(java.util.Collection mensajesError);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getMensajesError#sArray()
     */
    public java.util.Collection getMensajesError();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setMensajesError(java.util.Collection)
     */
    public void setMensajesErrorAsArray(Object[] mensajesError);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getMensajesError()
     */
    public java.lang.Object[] getMensajesErrorAsArray();

    /**
     * Resets the <code>mensajesError</code> field.
     */
    public void resetMensajesError();

    /**
     * The <code>mensajesError</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getMensajesError()
     * @see #getMensajesErrorValueList()
     * @see #getMensajesErrorLabelList()
     * @see #setMensajesErrorLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getMensajesErrorBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * mensajesError property. This method takes a collection of objects, as well as
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
     * But you need to populate the mensajesError backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setMensajesErrorBackingList(valueObjects, "id", "name")</code>
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
     * @see #getMensajesError()
     * @see #getMensajesErrorValueList()
     * @see #getMensajesErrorLabelList()
     * @see #getMensajesErrorLabelList()
     */
    public void setMensajesErrorBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>mensajesError</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getMensajesError()
     * @see #getMensajesErrorBackingList()
     */
    public java.lang.Object[] getMensajesErrorValueList();

    /**
     * The <code>mensajesError</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getMensajesError()
     * @see #getMensajesErrorBackingList()
     */
    public void setMensajesErrorValueList(java.lang.Object[] mensajesErrorValueList);

    /**
     * The <code>mensajesError</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getMensajesError()
     * @see #getMensajesErrorBackingList()
     */
    public java.lang.Object[] getMensajesErrorLabelList();

    /**
     * The <code>mensajesError</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getMensajesError()
     * @see #getMensajesErrorBackingList()
     */
    public void setMensajesErrorLabelList(java.lang.Object[] mensajesErrorLabelList);

}

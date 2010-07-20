// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>reset</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleAnotacionController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleAnotacionController#reset
 */
public interface ResetForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setDescripcionFecha#sArray(Object[])
     */
    public void setDescripcionFecha(java.util.Collection descripcionFecha);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getDescripcionFecha#sArray()
     */
    public java.util.Collection getDescripcionFecha();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setDescripcionFecha(java.util.Collection)
     */
    public void setDescripcionFechaAsArray(Object[] descripcionFecha);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getDescripcionFecha()
     */
    public java.lang.Object[] getDescripcionFechaAsArray();

    /**
     * Resets the <code>descripcionFecha</code> field.
     */
    public void resetDescripcionFecha();

    /**
     * The <code>descripcionFecha</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getDescripcionFecha()
     * @see #getDescripcionFechaValueList()
     * @see #getDescripcionFechaLabelList()
     * @see #setDescripcionFechaLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getDescripcionFechaBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * descripcionFecha property. This method takes a collection of objects, as well as
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
     * But you need to populate the descripcionFecha backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setDescripcionFechaBackingList(valueObjects, "id", "name")</code>
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
     * @see #getDescripcionFecha()
     * @see #getDescripcionFechaValueList()
     * @see #getDescripcionFechaLabelList()
     * @see #getDescripcionFechaLabelList()
     */
    public void setDescripcionFechaBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>descripcionFecha</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getDescripcionFecha()
     * @see #getDescripcionFechaBackingList()
     */
    public java.lang.Object[] getDescripcionFechaValueList();

    /**
     * The <code>descripcionFecha</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getDescripcionFecha()
     * @see #getDescripcionFechaBackingList()
     */
    public void setDescripcionFechaValueList(java.lang.Object[] descripcionFechaValueList);

    /**
     * The <code>descripcionFecha</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getDescripcionFecha()
     * @see #getDescripcionFechaBackingList()
     */
    public java.lang.Object[] getDescripcionFechaLabelList();

    /**
     * The <code>descripcionFecha</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getDescripcionFecha()
     * @see #getDescripcionFechaBackingList()
     */
    public void setDescripcionFechaLabelList(java.lang.Object[] descripcionFechaLabelList);

    /**
     * Sets the <code>tsegundoP1</code> field.
     *
     * 
     */
    public void setTsegundoP1(java.lang.String tsegundoP1);

    /**
     * Gets the <code>tsegundoP1</code> field.
     *
     * 
     */
    public java.lang.String getTsegundoP1();
    
    /**
     * Resets the <code>tsegundoP1</code> field.
     */
    public void resetTsegundoP1();

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
     * Sets the <code>tsegundoP2</code> field.
     *
     * 
     */
    public void setTsegundoP2(java.lang.String tsegundoP2);

    /**
     * Gets the <code>tsegundoP2</code> field.
     *
     * 
     */
    public java.lang.String getTsegundoP2();
    
    /**
     * Resets the <code>tsegundoP2</code> field.
     */
    public void resetTsegundoP2();

    /**
     * Sets the <code>formato</code> field.
     *
     * 
     */
    public void setFormato(java.lang.String formato);

    /**
     * Gets the <code>formato</code> field.
     *
     * 
     */
    public java.lang.String getFormato();
    
    /**
     * Resets the <code>formato</code> field.
     */
    public void resetFormato();

    /**
     * Sets the <code>organizacion</code> field.
     *
     * 
     */
    public void setOrganizacion(java.lang.String organizacion);

    /**
     * Gets the <code>organizacion</code> field.
     *
     * 
     */
    public java.lang.String getOrganizacion();
    
    /**
     * Resets the <code>organizacion</code> field.
     */
    public void resetOrganizacion();

    /**
     * Sets the <code>znMinutos</code> field.
     *
     * 
     */
    public void setZnMinutos(java.lang.String znMinutos);

    /**
     * Gets the <code>znMinutos</code> field.
     *
     * 
     */
    public java.lang.String getZnMinutos();
    
    /**
     * Resets the <code>znMinutos</code> field.
     */
    public void resetZnMinutos();

    /**
     * Sets the <code>nombre</code> field.
     *
     * 
     */
    public void setNombre(java.lang.String nombre);

    /**
     * Gets the <code>nombre</code> field.
     *
     * 
     */
    public java.lang.String getNombre();
    
    /**
     * Resets the <code>nombre</code> field.
     */
    public void resetNombre();

    /**
     * Sets the <code>tituloAnotacion</code> field.
     *
     * 
     */
    public void setTituloAnotacion(java.lang.String tituloAnotacion);

    /**
     * Gets the <code>tituloAnotacion</code> field.
     *
     * 
     */
    public java.lang.String getTituloAnotacion();
    
    /**
     * Resets the <code>tituloAnotacion</code> field.
     */
    public void resetTituloAnotacion();

    /**
     * Sets the <code>thora</code> field.
     *
     * 
     */
    public void setThora(java.lang.String thora);

    /**
     * Gets the <code>thora</code> field.
     *
     * 
     */
    public java.lang.String getThora();
    
    /**
     * Resets the <code>thora</code> field.
     */
    public void resetThora();

    /**
     * Sets the <code>email</code> field.
     *
     * 
     */
    public void setEmail(java.lang.String email);

    /**
     * Gets the <code>email</code> field.
     *
     * 
     */
    public java.lang.String getEmail();
    
    /**
     * Resets the <code>email</code> field.
     */
    public void resetEmail();

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
     * Sets the <code>meridianoCero</code> field.
     *
     * 
     */
    public void setMeridianoCero(java.lang.String meridianoCero);

    /**
     * Gets the <code>meridianoCero</code> field.
     *
     * 
     */
    public java.lang.String getMeridianoCero();
    
    /**
     * Resets the <code>meridianoCero</code> field.
     */
    public void resetMeridianoCero();

    /**
     * Sets the <code>offSet</code> field.
     *
     * 
     */
    public void setOffSet(java.lang.String offSet);

    /**
     * Gets the <code>offSet</code> field.
     *
     * 
     */
    public java.lang.String getOffSet();
    
    /**
     * Resets the <code>offSet</code> field.
     */
    public void resetOffSet();

    /**
     * Sets the <code>fechaCorta</code> field.
     *
     * 
     */
    public void setFechaCorta(java.lang.String fechaCorta);

    /**
     * Gets the <code>fechaCorta</code> field.
     *
     * 
     */
    public java.lang.String getFechaCorta();
    
    /**
     * Resets the <code>fechaCorta</code> field.
     */
    public void resetFechaCorta();

    /**
     * Sets the <code>znHora</code> field.
     *
     * 
     */
    public void setZnHora(java.lang.String znHora);

    /**
     * Gets the <code>znHora</code> field.
     *
     * 
     */
    public java.lang.String getZnHora();
    
    /**
     * Resets the <code>znHora</code> field.
     */
    public void resetZnHora();

    /**
     * Sets the <code>comboZonaH</code> field.
     *
     * 
     */
    public void setComboZonaH(java.lang.String comboZonaH);

    /**
     * Gets the <code>comboZonaH</code> field.
     *
     * 
     */
    public java.lang.String getComboZonaH();
    
    /**
     * Resets the <code>comboZonaH</code> field.
     */
    public void resetComboZonaH();

    /**
     * The <code>comboZonaH</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboZonaH()
     * @see #getComboZonaHValueList()
     * @see #getComboZonaHLabelList()
     * @see #setComboZonaHLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboZonaHBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboZonaH property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboZonaH backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboZonaHBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboZonaH()
     * @see #getComboZonaHValueList()
     * @see #getComboZonaHLabelList()
     * @see #getComboZonaHLabelList()
     */
    public void setComboZonaHBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboZonaH</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboZonaH()
     * @see #getComboZonaHBackingList()
     */
    public java.lang.Object[] getComboZonaHValueList();

    /**
     * The <code>comboZonaH</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboZonaH()
     * @see #getComboZonaHBackingList()
     */
    public void setComboZonaHValueList(java.lang.Object[] comboZonaHValueList);

    /**
     * The <code>comboZonaH</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboZonaH()
     * @see #getComboZonaHBackingList()
     */
    public java.lang.Object[] getComboZonaHLabelList();

    /**
     * The <code>comboZonaH</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboZonaH()
     * @see #getComboZonaHBackingList()
     */
    public void setComboZonaHLabelList(java.lang.Object[] comboZonaHLabelList);

    /**
     * Sets the <code>tminuto</code> field.
     *
     * 
     */
    public void setTminuto(java.lang.String tminuto);

    /**
     * Gets the <code>tminuto</code> field.
     *
     * 
     */
    public java.lang.String getTminuto();
    
    /**
     * Resets the <code>tminuto</code> field.
     */
    public void resetTminuto();

}

// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarTechnicalValidar</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.TecnicaController#cargarTechnicalValidar
 */
public interface CargarTechnicalValidarForm
{
    /**
     * Sets the <code>minutos</code> field.
     *
     * 
     */
    public void setMinutos(java.lang.String minutos);

    /**
     * Gets the <code>minutos</code> field.
     *
     * 
     */
    public java.lang.String getMinutos();
    
    /**
     * Resets the <code>minutos</code> field.
     */
    public void resetMinutos();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setDescripcionRequerimientos#sArray(Object[])
     */
    public void setDescripcionRequerimientos(java.util.Collection descripcionRequerimientos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getDescripcionRequerimientos#sArray()
     */
    public java.util.Collection getDescripcionRequerimientos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setDescripcionRequerimientos(java.util.Collection)
     */
    public void setDescripcionRequerimientosAsArray(Object[] descripcionRequerimientos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getDescripcionRequerimientos()
     */
    public java.lang.Object[] getDescripcionRequerimientosAsArray();

    /**
     * Resets the <code>descripcionRequerimientos</code> field.
     */
    public void resetDescripcionRequerimientos();

    /**
     * The <code>descripcionRequerimientos</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getDescripcionRequerimientos()
     * @see #getDescripcionRequerimientosValueList()
     * @see #getDescripcionRequerimientosLabelList()
     * @see #setDescripcionRequerimientosLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getDescripcionRequerimientosBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * descripcionRequerimientos property. This method takes a collection of objects, as well as
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
     * But you need to populate the descripcionRequerimientos backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setDescripcionRequerimientosBackingList(valueObjects, "id", "name")</code>
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
     * @see #getDescripcionRequerimientos()
     * @see #getDescripcionRequerimientosValueList()
     * @see #getDescripcionRequerimientosLabelList()
     * @see #getDescripcionRequerimientosLabelList()
     */
    public void setDescripcionRequerimientosBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>descripcionRequerimientos</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getDescripcionRequerimientos()
     * @see #getDescripcionRequerimientosBackingList()
     */
    public java.lang.Object[] getDescripcionRequerimientosValueList();

    /**
     * The <code>descripcionRequerimientos</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getDescripcionRequerimientos()
     * @see #getDescripcionRequerimientosBackingList()
     */
    public void setDescripcionRequerimientosValueList(java.lang.Object[] descripcionRequerimientosValueList);

    /**
     * The <code>descripcionRequerimientos</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getDescripcionRequerimientos()
     * @see #getDescripcionRequerimientosBackingList()
     */
    public java.lang.Object[] getDescripcionRequerimientosLabelList();

    /**
     * The <code>descripcionRequerimientos</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getDescripcionRequerimientos()
     * @see #getDescripcionRequerimientosBackingList()
     */
    public void setDescripcionRequerimientosLabelList(java.lang.Object[] descripcionRequerimientosLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setRequerimiento#sArray(Object[])
     */
    public void setRequerimiento(java.util.Collection requerimiento);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getRequerimiento#sArray()
     */
    public java.util.Collection getRequerimiento();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setRequerimiento(java.util.Collection)
     */
    public void setRequerimientoAsArray(Object[] requerimiento);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getRequerimiento()
     */
    public java.lang.Object[] getRequerimientoAsArray();

    /**
     * Resets the <code>requerimiento</code> field.
     */
    public void resetRequerimiento();

    /**
     * The <code>requerimiento</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getRequerimiento()
     * @see #getRequerimientoValueList()
     * @see #getRequerimientoLabelList()
     * @see #setRequerimientoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getRequerimientoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * requerimiento property. This method takes a collection of objects, as well as
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
     * But you need to populate the requerimiento backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setRequerimientoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getRequerimiento()
     * @see #getRequerimientoValueList()
     * @see #getRequerimientoLabelList()
     * @see #getRequerimientoLabelList()
     */
    public void setRequerimientoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>requerimiento</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getRequerimiento()
     * @see #getRequerimientoBackingList()
     */
    public java.lang.Object[] getRequerimientoValueList();

    /**
     * The <code>requerimiento</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getRequerimiento()
     * @see #getRequerimientoBackingList()
     */
    public void setRequerimientoValueList(java.lang.Object[] requerimientoValueList);

    /**
     * The <code>requerimiento</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getRequerimiento()
     * @see #getRequerimientoBackingList()
     */
    public java.lang.Object[] getRequerimientoLabelList();

    /**
     * The <code>requerimiento</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getRequerimiento()
     * @see #getRequerimientoBackingList()
     */
    public void setRequerimientoLabelList(java.lang.Object[] requerimientoLabelList);

    /**
     * Sets the <code>comboTipo</code> field.
     *
     * 
     */
    public void setComboTipo(java.lang.String comboTipo);

    /**
     * Gets the <code>comboTipo</code> field.
     *
     * 
     */
    public java.lang.String getComboTipo();
    
    /**
     * Resets the <code>comboTipo</code> field.
     */
    public void resetComboTipo();

    /**
     * The <code>comboTipo</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboTipo()
     * @see #getComboTipoValueList()
     * @see #getComboTipoLabelList()
     * @see #setComboTipoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboTipoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboTipo property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboTipo backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboTipoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboTipo()
     * @see #getComboTipoValueList()
     * @see #getComboTipoLabelList()
     * @see #getComboTipoLabelList()
     */
    public void setComboTipoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboTipo</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboTipo()
     * @see #getComboTipoBackingList()
     */
    public java.lang.Object[] getComboTipoValueList();

    /**
     * The <code>comboTipo</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboTipo()
     * @see #getComboTipoBackingList()
     */
    public void setComboTipoValueList(java.lang.Object[] comboTipoValueList);

    /**
     * The <code>comboTipo</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboTipo()
     * @see #getComboTipoBackingList()
     */
    public java.lang.Object[] getComboTipoLabelList();

    /**
     * The <code>comboTipo</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboTipo()
     * @see #getComboTipoBackingList()
     */
    public void setComboTipoLabelList(java.lang.Object[] comboTipoLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setDescripcionInstalacion#sArray(Object[])
     */
    public void setDescripcionInstalacion(java.util.Collection descripcionInstalacion);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getDescripcionInstalacion#sArray()
     */
    public java.util.Collection getDescripcionInstalacion();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setDescripcionInstalacion(java.util.Collection)
     */
    public void setDescripcionInstalacionAsArray(Object[] descripcionInstalacion);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getDescripcionInstalacion()
     */
    public java.lang.Object[] getDescripcionInstalacionAsArray();

    /**
     * Resets the <code>descripcionInstalacion</code> field.
     */
    public void resetDescripcionInstalacion();

    /**
     * The <code>descripcionInstalacion</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getDescripcionInstalacion()
     * @see #getDescripcionInstalacionValueList()
     * @see #getDescripcionInstalacionLabelList()
     * @see #setDescripcionInstalacionLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getDescripcionInstalacionBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * descripcionInstalacion property. This method takes a collection of objects, as well as
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
     * But you need to populate the descripcionInstalacion backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setDescripcionInstalacionBackingList(valueObjects, "id", "name")</code>
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
     * @see #getDescripcionInstalacion()
     * @see #getDescripcionInstalacionValueList()
     * @see #getDescripcionInstalacionLabelList()
     * @see #getDescripcionInstalacionLabelList()
     */
    public void setDescripcionInstalacionBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>descripcionInstalacion</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getDescripcionInstalacion()
     * @see #getDescripcionInstalacionBackingList()
     */
    public java.lang.Object[] getDescripcionInstalacionValueList();

    /**
     * The <code>descripcionInstalacion</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getDescripcionInstalacion()
     * @see #getDescripcionInstalacionBackingList()
     */
    public void setDescripcionInstalacionValueList(java.lang.Object[] descripcionInstalacionValueList);

    /**
     * The <code>descripcionInstalacion</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getDescripcionInstalacion()
     * @see #getDescripcionInstalacionBackingList()
     */
    public java.lang.Object[] getDescripcionInstalacionLabelList();

    /**
     * The <code>descripcionInstalacion</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getDescripcionInstalacion()
     * @see #getDescripcionInstalacionBackingList()
     */
    public void setDescripcionInstalacionLabelList(java.lang.Object[] descripcionInstalacionLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setDescripcionDuracion#sArray(Object[])
     */
    public void setDescripcionDuracion(java.util.Collection descripcionDuracion);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getDescripcionDuracion#sArray()
     */
    public java.util.Collection getDescripcionDuracion();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setDescripcionDuracion(java.util.Collection)
     */
    public void setDescripcionDuracionAsArray(Object[] descripcionDuracion);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getDescripcionDuracion()
     */
    public java.lang.Object[] getDescripcionDuracionAsArray();

    /**
     * Resets the <code>descripcionDuracion</code> field.
     */
    public void resetDescripcionDuracion();

    /**
     * The <code>descripcionDuracion</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getDescripcionDuracion()
     * @see #getDescripcionDuracionValueList()
     * @see #getDescripcionDuracionLabelList()
     * @see #setDescripcionDuracionLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getDescripcionDuracionBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * descripcionDuracion property. This method takes a collection of objects, as well as
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
     * But you need to populate the descripcionDuracion backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setDescripcionDuracionBackingList(valueObjects, "id", "name")</code>
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
     * @see #getDescripcionDuracion()
     * @see #getDescripcionDuracionValueList()
     * @see #getDescripcionDuracionLabelList()
     * @see #getDescripcionDuracionLabelList()
     */
    public void setDescripcionDuracionBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>descripcionDuracion</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getDescripcionDuracion()
     * @see #getDescripcionDuracionBackingList()
     */
    public java.lang.Object[] getDescripcionDuracionValueList();

    /**
     * The <code>descripcionDuracion</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getDescripcionDuracion()
     * @see #getDescripcionDuracionBackingList()
     */
    public void setDescripcionDuracionValueList(java.lang.Object[] descripcionDuracionValueList);

    /**
     * The <code>descripcionDuracion</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getDescripcionDuracion()
     * @see #getDescripcionDuracionBackingList()
     */
    public java.lang.Object[] getDescripcionDuracionLabelList();

    /**
     * The <code>descripcionDuracion</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getDescripcionDuracion()
     * @see #getDescripcionDuracionBackingList()
     */
    public void setDescripcionDuracionLabelList(java.lang.Object[] descripcionDuracionLabelList);

    /**
     * Sets the <code>segundosP2</code> field.
     *
     * 
     */
    public void setSegundosP2(java.lang.String segundosP2);

    /**
     * Gets the <code>segundosP2</code> field.
     *
     * 
     */
    public java.lang.String getSegundosP2();
    
    /**
     * Resets the <code>segundosP2</code> field.
     */
    public void resetSegundosP2();

    /**
     * Sets the <code>dia</code> field.
     *
     * 
     */
    public void setDia(java.lang.String dia);

    /**
     * Gets the <code>dia</code> field.
     *
     * 
     */
    public java.lang.String getDia();
    
    /**
     * Resets the <code>dia</code> field.
     */
    public void resetDia();

    /**
     * Sets the <code>segundosP1</code> field.
     *
     * 
     */
    public void setSegundosP1(java.lang.String segundosP1);

    /**
     * Gets the <code>segundosP1</code> field.
     *
     * 
     */
    public java.lang.String getSegundosP1();
    
    /**
     * Resets the <code>segundosP1</code> field.
     */
    public void resetSegundosP1();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setDuracion#sArray(Object[])
     */
    public void setDuracion(java.util.Collection duracion);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getDuracion#sArray()
     */
    public java.util.Collection getDuracion();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setDuracion(java.util.Collection)
     */
    public void setDuracionAsArray(Object[] duracion);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getDuracion()
     */
    public java.lang.Object[] getDuracionAsArray();

    /**
     * Resets the <code>duracion</code> field.
     */
    public void resetDuracion();

    /**
     * The <code>duracion</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getDuracion()
     * @see #getDuracionValueList()
     * @see #getDuracionLabelList()
     * @see #setDuracionLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getDuracionBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * duracion property. This method takes a collection of objects, as well as
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
     * But you need to populate the duracion backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setDuracionBackingList(valueObjects, "id", "name")</code>
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
     * @see #getDuracion()
     * @see #getDuracionValueList()
     * @see #getDuracionLabelList()
     * @see #getDuracionLabelList()
     */
    public void setDuracionBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>duracion</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getDuracion()
     * @see #getDuracionBackingList()
     */
    public java.lang.Object[] getDuracionValueList();

    /**
     * The <code>duracion</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getDuracion()
     * @see #getDuracionBackingList()
     */
    public void setDuracionValueList(java.lang.Object[] duracionValueList);

    /**
     * The <code>duracion</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getDuracion()
     * @see #getDuracionBackingList()
     */
    public java.lang.Object[] getDuracionLabelList();

    /**
     * The <code>duracion</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getDuracion()
     * @see #getDuracionBackingList()
     */
    public void setDuracionLabelList(java.lang.Object[] duracionLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setAgregadorOR#sArray(Object[])
     */
    public void setAgregadorOR(java.util.Collection agregadorOR);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getAgregadorOR#sArray()
     */
    public java.util.Collection getAgregadorOR();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setAgregadorOR(java.util.Collection)
     */
    public void setAgregadorORAsArray(Object[] agregadorOR);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getAgregadorOR()
     */
    public java.lang.Object[] getAgregadorORAsArray();

    /**
     * Resets the <code>agregadorOR</code> field.
     */
    public void resetAgregadorOR();

    /**
     * The <code>agregadorOR</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getAgregadorOR()
     * @see #getAgregadorORValueList()
     * @see #getAgregadorORLabelList()
     * @see #setAgregadorORLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getAgregadorORBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * agregadorOR property. This method takes a collection of objects, as well as
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
     * But you need to populate the agregadorOR backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setAgregadorORBackingList(valueObjects, "id", "name")</code>
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
     * @see #getAgregadorOR()
     * @see #getAgregadorORValueList()
     * @see #getAgregadorORLabelList()
     * @see #getAgregadorORLabelList()
     */
    public void setAgregadorORBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>agregadorOR</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getAgregadorOR()
     * @see #getAgregadorORBackingList()
     */
    public java.lang.Object[] getAgregadorORValueList();

    /**
     * The <code>agregadorOR</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getAgregadorOR()
     * @see #getAgregadorORBackingList()
     */
    public void setAgregadorORValueList(java.lang.Object[] agregadorORValueList);

    /**
     * The <code>agregadorOR</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getAgregadorOR()
     * @see #getAgregadorORBackingList()
     */
    public java.lang.Object[] getAgregadorORLabelList();

    /**
     * The <code>agregadorOR</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getAgregadorOR()
     * @see #getAgregadorORBackingList()
     */
    public void setAgregadorORLabelList(java.lang.Object[] agregadorORLabelList);

    /**
     * Sets the <code>hora</code> field.
     *
     * 
     */
    public void setHora(java.lang.String hora);

    /**
     * Gets the <code>hora</code> field.
     *
     * 
     */
    public java.lang.String getHora();
    
    /**
     * Resets the <code>hora</code> field.
     */
    public void resetHora();

    /**
     * Sets the <code>comboNombre</code> field.
     *
     * 
     */
    public void setComboNombre(java.lang.String comboNombre);

    /**
     * Gets the <code>comboNombre</code> field.
     *
     * 
     */
    public java.lang.String getComboNombre();
    
    /**
     * Resets the <code>comboNombre</code> field.
     */
    public void resetComboNombre();

    /**
     * The <code>comboNombre</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboNombre()
     * @see #getComboNombreValueList()
     * @see #getComboNombreLabelList()
     * @see #setComboNombreLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboNombreBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboNombre property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboNombre backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboNombreBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboNombre()
     * @see #getComboNombreValueList()
     * @see #getComboNombreLabelList()
     * @see #getComboNombreLabelList()
     */
    public void setComboNombreBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboNombre</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboNombre()
     * @see #getComboNombreBackingList()
     */
    public java.lang.Object[] getComboNombreValueList();

    /**
     * The <code>comboNombre</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboNombre()
     * @see #getComboNombreBackingList()
     */
    public void setComboNombreValueList(java.lang.Object[] comboNombreValueList);

    /**
     * The <code>comboNombre</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboNombre()
     * @see #getComboNombreBackingList()
     */
    public java.lang.Object[] getComboNombreLabelList();

    /**
     * The <code>comboNombre</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboNombre()
     * @see #getComboNombreBackingList()
     */
    public void setComboNombreLabelList(java.lang.Object[] comboNombreLabelList);

    /**
     * Sets the <code>mes</code> field.
     *
     * 
     */
    public void setMes(java.lang.String mes);

    /**
     * Gets the <code>mes</code> field.
     *
     * 
     */
    public java.lang.String getMes();
    
    /**
     * Resets the <code>mes</code> field.
     */
    public void resetMes();

    /**
     * Sets the <code>tamanio</code> field.
     *
     * 
     */
    public void setTamanio(java.lang.String tamanio);

    /**
     * Gets the <code>tamanio</code> field.
     *
     * 
     */
    public java.lang.String getTamanio();
    
    /**
     * Resets the <code>tamanio</code> field.
     */
    public void resetTamanio();

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
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setLocalizacion#sArray(Object[])
     */
    public void setLocalizacion(java.util.Collection localizacion);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getLocalizacion#sArray()
     */
    public java.util.Collection getLocalizacion();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setLocalizacion(java.util.Collection)
     */
    public void setLocalizacionAsArray(Object[] localizacion);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getLocalizacion()
     */
    public java.lang.Object[] getLocalizacionAsArray();

    /**
     * Resets the <code>localizacion</code> field.
     */
    public void resetLocalizacion();

    /**
     * The <code>localizacion</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getLocalizacion()
     * @see #getLocalizacionValueList()
     * @see #getLocalizacionLabelList()
     * @see #setLocalizacionLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getLocalizacionBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * localizacion property. This method takes a collection of objects, as well as
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
     * But you need to populate the localizacion backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setLocalizacionBackingList(valueObjects, "id", "name")</code>
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
     * @see #getLocalizacion()
     * @see #getLocalizacionValueList()
     * @see #getLocalizacionLabelList()
     * @see #getLocalizacionLabelList()
     */
    public void setLocalizacionBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>localizacion</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getLocalizacion()
     * @see #getLocalizacionBackingList()
     */
    public java.lang.Object[] getLocalizacionValueList();

    /**
     * The <code>localizacion</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getLocalizacion()
     * @see #getLocalizacionBackingList()
     */
    public void setLocalizacionValueList(java.lang.Object[] localizacionValueList);

    /**
     * The <code>localizacion</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getLocalizacion()
     * @see #getLocalizacionBackingList()
     */
    public java.lang.Object[] getLocalizacionLabelList();

    /**
     * The <code>localizacion</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getLocalizacion()
     * @see #getLocalizacionBackingList()
     */
    public void setLocalizacionLabelList(java.lang.Object[] localizacionLabelList);

    /**
     * Sets the <code>anyo</code> field.
     *
     * 
     */
    public void setAnyo(java.lang.String anyo);

    /**
     * Gets the <code>anyo</code> field.
     *
     * 
     */
    public java.lang.String getAnyo();
    
    /**
     * Resets the <code>anyo</code> field.
     */
    public void resetAnyo();

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

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setFormatos#sArray(Object[])
     */
    public void setFormatos(java.util.Collection formatos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getFormatos#sArray()
     */
    public java.util.Collection getFormatos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setFormatos(java.util.Collection)
     */
    public void setFormatosAsArray(Object[] formatos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getFormatos()
     */
    public java.lang.Object[] getFormatosAsArray();

    /**
     * Resets the <code>formatos</code> field.
     */
    public void resetFormatos();

    /**
     * The <code>formatos</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getFormatos()
     * @see #getFormatosValueList()
     * @see #getFormatosLabelList()
     * @see #setFormatosLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getFormatosBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * formatos property. This method takes a collection of objects, as well as
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
     * But you need to populate the formatos backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setFormatosBackingList(valueObjects, "id", "name")</code>
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
     * @see #getFormatos()
     * @see #getFormatosValueList()
     * @see #getFormatosLabelList()
     * @see #getFormatosLabelList()
     */
    public void setFormatosBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>formatos</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getFormatos()
     * @see #getFormatosBackingList()
     */
    public java.lang.Object[] getFormatosValueList();

    /**
     * The <code>formatos</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getFormatos()
     * @see #getFormatosBackingList()
     */
    public void setFormatosValueList(java.lang.Object[] formatosValueList);

    /**
     * The <code>formatos</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getFormatos()
     * @see #getFormatosBackingList()
     */
    public java.lang.Object[] getFormatosLabelList();

    /**
     * The <code>formatos</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getFormatos()
     * @see #getFormatosBackingList()
     */
    public void setFormatosLabelList(java.lang.Object[] formatosLabelList);

    /**
     * Sets the <code>comboFormato</code> field.
     *
     * 
     */
    public void setComboFormato(java.lang.String comboFormato);

    /**
     * Gets the <code>comboFormato</code> field.
     *
     * 
     */
    public java.lang.String getComboFormato();
    
    /**
     * Resets the <code>comboFormato</code> field.
     */
    public void resetComboFormato();

    /**
     * The <code>comboFormato</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboFormato()
     * @see #getComboFormatoValueList()
     * @see #getComboFormatoLabelList()
     * @see #setComboFormatoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboFormatoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboFormato property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboFormato backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboFormatoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboFormato()
     * @see #getComboFormatoValueList()
     * @see #getComboFormatoLabelList()
     * @see #getComboFormatoLabelList()
     */
    public void setComboFormatoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboFormato</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboFormato()
     * @see #getComboFormatoBackingList()
     */
    public java.lang.Object[] getComboFormatoValueList();

    /**
     * The <code>comboFormato</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboFormato()
     * @see #getComboFormatoBackingList()
     */
    public void setComboFormatoValueList(java.lang.Object[] comboFormatoValueList);

    /**
     * The <code>comboFormato</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboFormato()
     * @see #getComboFormatoBackingList()
     */
    public java.lang.Object[] getComboFormatoLabelList();

    /**
     * The <code>comboFormato</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboFormato()
     * @see #getComboFormatoBackingList()
     */
    public void setComboFormatoLabelList(java.lang.Object[] comboFormatoLabelList);

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

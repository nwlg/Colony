// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarDatos</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosController#cargarDatos
 */
public interface CargarDatosForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setListadoNodos#sArray(Object[])
     */
    public void setListadoNodos(java.util.List listadoNodos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getListadoNodos#sArray()
     */
    public java.util.List getListadoNodos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setListadoNodos(java.util.List)
     */
    public void setListadoNodosAsArray(Object[] listadoNodos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getListadoNodos()
     */
    public java.lang.Object[] getListadoNodosAsArray();

    /**
     * Resets the <code>listadoNodos</code> field.
     */
    public void resetListadoNodos();

    /**
     * The <code>listadoNodos</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getListadoNodos()
     * @see #getListadoNodosValueList()
     * @see #getListadoNodosLabelList()
     * @see #setListadoNodosLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getListadoNodosBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * listadoNodos property. This method takes a collection of objects, as well as
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
     * But you need to populate the listadoNodos backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setListadoNodosBackingList(valueObjects, "id", "name")</code>
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
     * @see #getListadoNodos()
     * @see #getListadoNodosValueList()
     * @see #getListadoNodosLabelList()
     * @see #getListadoNodosLabelList()
     */
    public void setListadoNodosBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>listadoNodos</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getListadoNodos()
     * @see #getListadoNodosBackingList()
     */
    public java.lang.Object[] getListadoNodosValueList();

    /**
     * The <code>listadoNodos</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getListadoNodos()
     * @see #getListadoNodosBackingList()
     */
    public void setListadoNodosValueList(java.lang.Object[] listadoNodosValueList);

    /**
     * The <code>listadoNodos</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getListadoNodos()
     * @see #getListadoNodosBackingList()
     */
    public java.lang.Object[] getListadoNodosLabelList();

    /**
     * The <code>listadoNodos</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getListadoNodos()
     * @see #getListadoNodosBackingList()
     */
    public void setListadoNodosLabelList(java.lang.Object[] listadoNodosLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setDescripciones#sArray(Object[])
     */
    public void setDescripciones(java.util.Collection descripciones);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getDescripciones#sArray()
     */
    public java.util.Collection getDescripciones();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setDescripciones(java.util.Collection)
     */
    public void setDescripcionesAsArray(Object[] descripciones);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getDescripciones()
     */
    public java.lang.Object[] getDescripcionesAsArray();

    /**
     * Resets the <code>descripciones</code> field.
     */
    public void resetDescripciones();

    /**
     * The <code>descripciones</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getDescripciones()
     * @see #getDescripcionesValueList()
     * @see #getDescripcionesLabelList()
     * @see #setDescripcionesLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getDescripcionesBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * descripciones property. This method takes a collection of objects, as well as
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
     * But you need to populate the descripciones backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setDescripcionesBackingList(valueObjects, "id", "name")</code>
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
     * @see #getDescripciones()
     * @see #getDescripcionesValueList()
     * @see #getDescripcionesLabelList()
     * @see #getDescripcionesLabelList()
     */
    public void setDescripcionesBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>descripciones</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getDescripciones()
     * @see #getDescripcionesBackingList()
     */
    public java.lang.Object[] getDescripcionesValueList();

    /**
     * The <code>descripciones</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getDescripciones()
     * @see #getDescripcionesBackingList()
     */
    public void setDescripcionesValueList(java.lang.Object[] descripcionesValueList);

    /**
     * The <code>descripciones</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getDescripciones()
     * @see #getDescripcionesBackingList()
     */
    public java.lang.Object[] getDescripcionesLabelList();

    /**
     * The <code>descripciones</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getDescripciones()
     * @see #getDescripcionesBackingList()
     */
    public void setDescripcionesLabelList(java.lang.Object[] descripcionesLabelList);

    /**
     * Sets the <code>tipoAcceso</code> field.
     *
     * 
     */
    public void setTipoAcceso(java.lang.String tipoAcceso);

    /**
     * Gets the <code>tipoAcceso</code> field.
     *
     * 
     */
    public java.lang.String getTipoAcceso();
    
    /**
     * Resets the <code>tipoAcceso</code> field.
     */
    public void resetTipoAcceso();

    /**
     * The <code>tipoAcceso</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getTipoAcceso()
     * @see #getTipoAccesoValueList()
     * @see #getTipoAccesoLabelList()
     * @see #setTipoAccesoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getTipoAccesoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * tipoAcceso property. This method takes a collection of objects, as well as
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
     * But you need to populate the tipoAcceso backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setTipoAccesoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getTipoAcceso()
     * @see #getTipoAccesoValueList()
     * @see #getTipoAccesoLabelList()
     * @see #getTipoAccesoLabelList()
     */
    public void setTipoAccesoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>tipoAcceso</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getTipoAcceso()
     * @see #getTipoAccesoBackingList()
     */
    public java.lang.Object[] getTipoAccesoValueList();

    /**
     * The <code>tipoAcceso</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getTipoAcceso()
     * @see #getTipoAccesoBackingList()
     */
    public void setTipoAccesoValueList(java.lang.Object[] tipoAccesoValueList);

    /**
     * The <code>tipoAcceso</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getTipoAcceso()
     * @see #getTipoAccesoBackingList()
     */
    public java.lang.Object[] getTipoAccesoLabelList();

    /**
     * The <code>tipoAcceso</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getTipoAcceso()
     * @see #getTipoAccesoBackingList()
     */
    public void setTipoAccesoLabelList(java.lang.Object[] tipoAccesoLabelList);

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
     * Sets the <code>copyRestricciones</code> field.
     *
     * 
     */
    public void setCopyRestricciones(java.lang.String copyRestricciones);

    /**
     * Gets the <code>copyRestricciones</code> field.
     *
     * 
     */
    public java.lang.String getCopyRestricciones();
    
    /**
     * Resets the <code>copyRestricciones</code> field.
     */
    public void resetCopyRestricciones();

    /**
     * The <code>copyRestricciones</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getCopyRestricciones()
     * @see #getCopyRestriccionesValueList()
     * @see #getCopyRestriccionesLabelList()
     * @see #setCopyRestriccionesLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getCopyRestriccionesBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * copyRestricciones property. This method takes a collection of objects, as well as
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
     * But you need to populate the copyRestricciones backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setCopyRestriccionesBackingList(valueObjects, "id", "name")</code>
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
     * @see #getCopyRestricciones()
     * @see #getCopyRestriccionesValueList()
     * @see #getCopyRestriccionesLabelList()
     * @see #getCopyRestriccionesLabelList()
     */
    public void setCopyRestriccionesBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>copyRestricciones</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getCopyRestricciones()
     * @see #getCopyRestriccionesBackingList()
     */
    public java.lang.Object[] getCopyRestriccionesValueList();

    /**
     * The <code>copyRestricciones</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getCopyRestricciones()
     * @see #getCopyRestriccionesBackingList()
     */
    public void setCopyRestriccionesValueList(java.lang.Object[] copyRestriccionesValueList);

    /**
     * The <code>copyRestricciones</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getCopyRestricciones()
     * @see #getCopyRestriccionesBackingList()
     */
    public java.lang.Object[] getCopyRestriccionesLabelList();

    /**
     * The <code>copyRestricciones</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getCopyRestricciones()
     * @see #getCopyRestriccionesBackingList()
     */
    public void setCopyRestriccionesLabelList(java.lang.Object[] copyRestriccionesLabelList);

    /**
     * Sets the <code>coste</code> field.
     *
     * 
     */
    public void setCoste(java.lang.String coste);

    /**
     * Gets the <code>coste</code> field.
     *
     * 
     */
    public java.lang.String getCoste();
    
    /**
     * Resets the <code>coste</code> field.
     */
    public void resetCoste();

    /**
     * The <code>coste</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getCoste()
     * @see #getCosteValueList()
     * @see #getCosteLabelList()
     * @see #setCosteLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getCosteBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * coste property. This method takes a collection of objects, as well as
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
     * But you need to populate the coste backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setCosteBackingList(valueObjects, "id", "name")</code>
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
     * @see #getCoste()
     * @see #getCosteValueList()
     * @see #getCosteLabelList()
     * @see #getCosteLabelList()
     */
    public void setCosteBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>coste</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getCoste()
     * @see #getCosteBackingList()
     */
    public java.lang.Object[] getCosteValueList();

    /**
     * The <code>coste</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getCoste()
     * @see #getCosteBackingList()
     */
    public void setCosteValueList(java.lang.Object[] costeValueList);

    /**
     * The <code>coste</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getCoste()
     * @see #getCosteBackingList()
     */
    public java.lang.Object[] getCosteLabelList();

    /**
     * The <code>coste</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getCoste()
     * @see #getCosteBackingList()
     */
    public void setCosteLabelList(java.lang.Object[] costeLabelList);

    /**
     * Sets the <code>listadoComunidades</code> field.
     *
     * 
     */
    public void setListadoComunidades(java.lang.String[] listadoComunidades);

    /**
     * Gets the <code>listadoComunidades</code> field.
     *
     * 
     */
    public java.lang.String[] getListadoComunidades();
    
    /**
     * Resets the <code>listadoComunidades</code> field.
     */
    public void resetListadoComunidades();

    /**
     * The <code>listadoComunidades</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getListadoComunidades()
     * @see #getListadoComunidadesValueList()
     * @see #getListadoComunidadesLabelList()
     * @see #setListadoComunidadesLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getListadoComunidadesBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * listadoComunidades property. This method takes a collection of objects, as well as
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
     * But you need to populate the listadoComunidades backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setListadoComunidadesBackingList(valueObjects, "id", "name")</code>
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
     * @see #getListadoComunidades()
     * @see #getListadoComunidadesValueList()
     * @see #getListadoComunidadesLabelList()
     * @see #getListadoComunidadesLabelList()
     */
    public void setListadoComunidadesBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>listadoComunidades</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getListadoComunidades()
     * @see #getListadoComunidadesBackingList()
     */
    public java.lang.Object[] getListadoComunidadesValueList();

    /**
     * The <code>listadoComunidades</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getListadoComunidades()
     * @see #getListadoComunidadesBackingList()
     */
    public void setListadoComunidadesValueList(java.lang.Object[] listadoComunidadesValueList);

    /**
     * The <code>listadoComunidades</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getListadoComunidades()
     * @see #getListadoComunidadesBackingList()
     */
    public java.lang.Object[] getListadoComunidadesLabelList();

    /**
     * The <code>listadoComunidades</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getListadoComunidades()
     * @see #getListadoComunidadesBackingList()
     */
    public void setListadoComunidadesLabelList(java.lang.Object[] listadoComunidadesLabelList);

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

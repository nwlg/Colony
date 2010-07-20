// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarDetalleUsoEdu</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.verMetadatos.VerMetadatosController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.verMetadatos.VerMetadatosController#cargarDetalleUsoEdu
 */
public interface CargarDetalleUsoEduForm
{
    /**
     * Sets the <code>segundoP2</code> field.
     *
     * 
     */
    public void setSegundoP2(java.lang.String segundoP2);

    /**
     * Gets the <code>segundoP2</code> field.
     *
     * 
     */
    public java.lang.String getSegundoP2();
    
    /**
     * Resets the <code>segundoP2</code> field.
     */
    public void resetSegundoP2();

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
     * Sets the <code>segundoP1</code> field.
     *
     * 
     */
    public void setSegundoP1(java.lang.String segundoP1);

    /**
     * Gets the <code>segundoP1</code> field.
     *
     * 
     */
    public java.lang.String getSegundoP1();
    
    /**
     * Resets the <code>segundoP1</code> field.
     */
    public void resetSegundoP1();

    /**
     * Sets the <code>comboRol</code> field.
     *
     * 
     */
    public void setComboRol(java.lang.String comboRol);

    /**
     * Gets the <code>comboRol</code> field.
     *
     * 
     */
    public java.lang.String getComboRol();
    
    /**
     * Resets the <code>comboRol</code> field.
     */
    public void resetComboRol();

    /**
     * The <code>comboRol</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboRol()
     * @see #getComboRolValueList()
     * @see #getComboRolLabelList()
     * @see #setComboRolLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboRolBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboRol property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboRol backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboRolBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboRol()
     * @see #getComboRolValueList()
     * @see #getComboRolLabelList()
     * @see #getComboRolLabelList()
     */
    public void setComboRolBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboRol</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboRol()
     * @see #getComboRolBackingList()
     */
    public java.lang.Object[] getComboRolValueList();

    /**
     * The <code>comboRol</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboRol()
     * @see #getComboRolBackingList()
     */
    public void setComboRolValueList(java.lang.Object[] comboRolValueList);

    /**
     * The <code>comboRol</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboRol()
     * @see #getComboRolBackingList()
     */
    public java.lang.Object[] getComboRolLabelList();

    /**
     * The <code>comboRol</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboRol()
     * @see #getComboRolBackingList()
     */
    public void setComboRolLabelList(java.lang.Object[] comboRolLabelList);

    /**
     * Sets the <code>comboProceso</code> field.
     *
     * 
     */
    public void setComboProceso(java.lang.String comboProceso);

    /**
     * Gets the <code>comboProceso</code> field.
     *
     * 
     */
    public java.lang.String getComboProceso();
    
    /**
     * Resets the <code>comboProceso</code> field.
     */
    public void resetComboProceso();

    /**
     * The <code>comboProceso</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboProceso()
     * @see #getComboProcesoValueList()
     * @see #getComboProcesoLabelList()
     * @see #setComboProcesoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboProcesoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboProceso property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboProceso backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboProcesoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboProceso()
     * @see #getComboProcesoValueList()
     * @see #getComboProcesoLabelList()
     * @see #getComboProcesoLabelList()
     */
    public void setComboProcesoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboProceso</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboProceso()
     * @see #getComboProcesoBackingList()
     */
    public java.lang.Object[] getComboProcesoValueList();

    /**
     * The <code>comboProceso</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboProceso()
     * @see #getComboProcesoBackingList()
     */
    public void setComboProcesoValueList(java.lang.Object[] comboProcesoValueList);

    /**
     * The <code>comboProceso</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboProceso()
     * @see #getComboProcesoBackingList()
     */
    public java.lang.Object[] getComboProcesoLabelList();

    /**
     * The <code>comboProceso</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboProceso()
     * @see #getComboProcesoBackingList()
     */
    public void setComboProcesoLabelList(java.lang.Object[] comboProcesoLabelList);

    /**
     * Sets the <code>dificultad</code> field.
     *
     * 
     */
    public void setDificultad(java.lang.String dificultad);

    /**
     * Gets the <code>dificultad</code> field.
     *
     * 
     */
    public java.lang.String getDificultad();
    
    /**
     * Resets the <code>dificultad</code> field.
     */
    public void resetDificultad();

    /**
     * The <code>dificultad</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getDificultad()
     * @see #getDificultadValueList()
     * @see #getDificultadLabelList()
     * @see #setDificultadLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getDificultadBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * dificultad property. This method takes a collection of objects, as well as
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
     * But you need to populate the dificultad backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setDificultadBackingList(valueObjects, "id", "name")</code>
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
     * @see #getDificultad()
     * @see #getDificultadValueList()
     * @see #getDificultadLabelList()
     * @see #getDificultadLabelList()
     */
    public void setDificultadBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>dificultad</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getDificultad()
     * @see #getDificultadBackingList()
     */
    public java.lang.Object[] getDificultadValueList();

    /**
     * The <code>dificultad</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getDificultad()
     * @see #getDificultadBackingList()
     */
    public void setDificultadValueList(java.lang.Object[] dificultadValueList);

    /**
     * The <code>dificultad</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getDificultad()
     * @see #getDificultadBackingList()
     */
    public java.lang.Object[] getDificultadLabelList();

    /**
     * The <code>dificultad</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getDificultad()
     * @see #getDificultadBackingList()
     */
    public void setDificultadLabelList(java.lang.Object[] dificultadLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTipoRecurso#sArray(Object[])
     */
    public void setTipoRecurso(java.util.Collection tipoRecurso);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTipoRecurso#sArray()
     */
    public java.util.Collection getTipoRecurso();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTipoRecurso(java.util.Collection)
     */
    public void setTipoRecursoAsArray(Object[] tipoRecurso);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTipoRecurso()
     */
    public java.lang.Object[] getTipoRecursoAsArray();

    /**
     * Resets the <code>tipoRecurso</code> field.
     */
    public void resetTipoRecurso();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIdiomas#sArray(Object[])
     */
    public void setIdiomas(java.util.Collection idiomas);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIdiomas#sArray()
     */
    public java.util.Collection getIdiomas();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIdiomas(java.util.Collection)
     */
    public void setIdiomasAsArray(Object[] idiomas);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIdiomas()
     */
    public java.lang.Object[] getIdiomasAsArray();

    /**
     * Resets the <code>idiomas</code> field.
     */
    public void resetIdiomas();

    /**
     * The <code>idiomas</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getIdiomas()
     * @see #getIdiomasValueList()
     * @see #getIdiomasLabelList()
     * @see #setIdiomasLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getIdiomasBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * idiomas property. This method takes a collection of objects, as well as
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
     * But you need to populate the idiomas backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setIdiomasBackingList(valueObjects, "id", "name")</code>
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
     * @see #getIdiomas()
     * @see #getIdiomasValueList()
     * @see #getIdiomasLabelList()
     * @see #getIdiomasLabelList()
     */
    public void setIdiomasBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>idiomas</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getIdiomas()
     * @see #getIdiomasBackingList()
     */
    public java.lang.Object[] getIdiomasValueList();

    /**
     * The <code>idiomas</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getIdiomas()
     * @see #getIdiomasBackingList()
     */
    public void setIdiomasValueList(java.lang.Object[] idiomasValueList);

    /**
     * The <code>idiomas</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getIdiomas()
     * @see #getIdiomasBackingList()
     */
    public java.lang.Object[] getIdiomasLabelList();

    /**
     * The <code>idiomas</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getIdiomas()
     * @see #getIdiomasBackingList()
     */
    public void setIdiomasLabelList(java.lang.Object[] idiomasLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTiempoAprendizaje#sArray(Object[])
     */
    public void setTiempoAprendizaje(java.util.Collection tiempoAprendizaje);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTiempoAprendizaje#sArray()
     */
    public java.util.Collection getTiempoAprendizaje();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTiempoAprendizaje(java.util.Collection)
     */
    public void setTiempoAprendizajeAsArray(Object[] tiempoAprendizaje);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTiempoAprendizaje()
     */
    public java.lang.Object[] getTiempoAprendizajeAsArray();

    /**
     * Resets the <code>tiempoAprendizaje</code> field.
     */
    public void resetTiempoAprendizaje();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTiempoApDescripcion#sArray(Object[])
     */
    public void setTiempoApDescripcion(java.util.Collection tiempoApDescripcion);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTiempoApDescripcion#sArray()
     */
    public java.util.Collection getTiempoApDescripcion();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTiempoApDescripcion(java.util.Collection)
     */
    public void setTiempoApDescripcionAsArray(Object[] tiempoApDescripcion);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTiempoApDescripcion()
     */
    public java.lang.Object[] getTiempoApDescripcionAsArray();

    /**
     * Resets the <code>tiempoApDescripcion</code> field.
     */
    public void resetTiempoApDescripcion();

    /**
     * Sets the <code>comboContexto</code> field.
     *
     * 
     */
    public void setComboContexto(java.lang.String comboContexto);

    /**
     * Gets the <code>comboContexto</code> field.
     *
     * 
     */
    public java.lang.String getComboContexto();
    
    /**
     * Resets the <code>comboContexto</code> field.
     */
    public void resetComboContexto();

    /**
     * The <code>comboContexto</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboContexto()
     * @see #getComboContextoValueList()
     * @see #getComboContextoLabelList()
     * @see #setComboContextoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboContextoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboContexto property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboContexto backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboContextoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboContexto()
     * @see #getComboContextoValueList()
     * @see #getComboContextoLabelList()
     * @see #getComboContextoLabelList()
     */
    public void setComboContextoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboContexto</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboContexto()
     * @see #getComboContextoBackingList()
     */
    public java.lang.Object[] getComboContextoValueList();

    /**
     * The <code>comboContexto</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboContexto()
     * @see #getComboContextoBackingList()
     */
    public void setComboContextoValueList(java.lang.Object[] comboContextoValueList);

    /**
     * The <code>comboContexto</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboContexto()
     * @see #getComboContextoBackingList()
     */
    public java.lang.Object[] getComboContextoLabelList();

    /**
     * The <code>comboContexto</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboContexto()
     * @see #getComboContextoBackingList()
     */
    public void setComboContextoLabelList(java.lang.Object[] comboContextoLabelList);

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
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setEdadTipica#sArray(Object[])
     */
    public void setEdadTipica(java.util.Collection edadTipica);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getEdadTipica#sArray()
     */
    public java.util.Collection getEdadTipica();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setEdadTipica(java.util.Collection)
     */
    public void setEdadTipicaAsArray(Object[] edadTipica);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getEdadTipica()
     */
    public java.lang.Object[] getEdadTipicaAsArray();

    /**
     * Resets the <code>edadTipica</code> field.
     */
    public void resetEdadTipica();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setContexto#sArray(Object[])
     */
    public void setContexto(java.util.Collection contexto);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getContexto#sArray()
     */
    public java.util.Collection getContexto();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setContexto(java.util.Collection)
     */
    public void setContextoAsArray(Object[] contexto);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getContexto()
     */
    public java.lang.Object[] getContextoAsArray();

    /**
     * Resets the <code>contexto</code> field.
     */
    public void resetContexto();

    /**
     * Sets the <code>tituloUsoEducativo</code> field.
     *
     * 
     */
    public void setTituloUsoEducativo(java.lang.String tituloUsoEducativo);

    /**
     * Gets the <code>tituloUsoEducativo</code> field.
     *
     * 
     */
    public java.lang.String getTituloUsoEducativo();
    
    /**
     * Resets the <code>tituloUsoEducativo</code> field.
     */
    public void resetTituloUsoEducativo();

    /**
     * Sets the <code>botonPulsado</code> field.
     *
     * 
     */
    public void setBotonPulsado(java.lang.String botonPulsado);

    /**
     * Gets the <code>botonPulsado</code> field.
     *
     * 
     */
    public java.lang.String getBotonPulsado();
    
    /**
     * Resets the <code>botonPulsado</code> field.
     */
    public void resetBotonPulsado();

    /**
     * Sets the <code>tipoInteractividad</code> field.
     *
     * 
     */
    public void setTipoInteractividad(java.lang.String tipoInteractividad);

    /**
     * Gets the <code>tipoInteractividad</code> field.
     *
     * 
     */
    public java.lang.String getTipoInteractividad();
    
    /**
     * Resets the <code>tipoInteractividad</code> field.
     */
    public void resetTipoInteractividad();

    /**
     * The <code>tipoInteractividad</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getTipoInteractividad()
     * @see #getTipoInteractividadValueList()
     * @see #getTipoInteractividadLabelList()
     * @see #setTipoInteractividadLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getTipoInteractividadBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * tipoInteractividad property. This method takes a collection of objects, as well as
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
     * But you need to populate the tipoInteractividad backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setTipoInteractividadBackingList(valueObjects, "id", "name")</code>
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
     * @see #getTipoInteractividad()
     * @see #getTipoInteractividadValueList()
     * @see #getTipoInteractividadLabelList()
     * @see #getTipoInteractividadLabelList()
     */
    public void setTipoInteractividadBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>tipoInteractividad</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getTipoInteractividad()
     * @see #getTipoInteractividadBackingList()
     */
    public java.lang.Object[] getTipoInteractividadValueList();

    /**
     * The <code>tipoInteractividad</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getTipoInteractividad()
     * @see #getTipoInteractividadBackingList()
     */
    public void setTipoInteractividadValueList(java.lang.Object[] tipoInteractividadValueList);

    /**
     * The <code>tipoInteractividad</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getTipoInteractividad()
     * @see #getTipoInteractividadBackingList()
     */
    public java.lang.Object[] getTipoInteractividadLabelList();

    /**
     * The <code>tipoInteractividad</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getTipoInteractividad()
     * @see #getTipoInteractividadBackingList()
     */
    public void setTipoInteractividadLabelList(java.lang.Object[] tipoInteractividadLabelList);

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
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setProcesoCognitivo#sArray(Object[])
     */
    public void setProcesoCognitivo(java.util.Collection procesoCognitivo);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getProcesoCognitivo#sArray()
     */
    public java.util.Collection getProcesoCognitivo();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setProcesoCognitivo(java.util.Collection)
     */
    public void setProcesoCognitivoAsArray(Object[] procesoCognitivo);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getProcesoCognitivo()
     */
    public java.lang.Object[] getProcesoCognitivoAsArray();

    /**
     * Resets the <code>procesoCognitivo</code> field.
     */
    public void resetProcesoCognitivo();

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
     * Sets the <code>comboTipoRecurso</code> field.
     *
     * 
     */
    public void setComboTipoRecurso(java.lang.String comboTipoRecurso);

    /**
     * Gets the <code>comboTipoRecurso</code> field.
     *
     * 
     */
    public java.lang.String getComboTipoRecurso();
    
    /**
     * Resets the <code>comboTipoRecurso</code> field.
     */
    public void resetComboTipoRecurso();

    /**
     * The <code>comboTipoRecurso</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboTipoRecurso()
     * @see #getComboTipoRecursoValueList()
     * @see #getComboTipoRecursoLabelList()
     * @see #setComboTipoRecursoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboTipoRecursoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboTipoRecurso property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboTipoRecurso backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboTipoRecursoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboTipoRecurso()
     * @see #getComboTipoRecursoValueList()
     * @see #getComboTipoRecursoLabelList()
     * @see #getComboTipoRecursoLabelList()
     */
    public void setComboTipoRecursoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboTipoRecurso</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboTipoRecurso()
     * @see #getComboTipoRecursoBackingList()
     */
    public java.lang.Object[] getComboTipoRecursoValueList();

    /**
     * The <code>comboTipoRecurso</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboTipoRecurso()
     * @see #getComboTipoRecursoBackingList()
     */
    public void setComboTipoRecursoValueList(java.lang.Object[] comboTipoRecursoValueList);

    /**
     * The <code>comboTipoRecurso</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboTipoRecurso()
     * @see #getComboTipoRecursoBackingList()
     */
    public java.lang.Object[] getComboTipoRecursoLabelList();

    /**
     * The <code>comboTipoRecurso</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboTipoRecurso()
     * @see #getComboTipoRecursoBackingList()
     */
    public void setComboTipoRecursoLabelList(java.lang.Object[] comboTipoRecursoLabelList);

    /**
     * Sets the <code>nivelInteractividad</code> field.
     *
     * 
     */
    public void setNivelInteractividad(java.lang.String nivelInteractividad);

    /**
     * Gets the <code>nivelInteractividad</code> field.
     *
     * 
     */
    public java.lang.String getNivelInteractividad();
    
    /**
     * Resets the <code>nivelInteractividad</code> field.
     */
    public void resetNivelInteractividad();

    /**
     * The <code>nivelInteractividad</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getNivelInteractividad()
     * @see #getNivelInteractividadValueList()
     * @see #getNivelInteractividadLabelList()
     * @see #setNivelInteractividadLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getNivelInteractividadBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * nivelInteractividad property. This method takes a collection of objects, as well as
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
     * But you need to populate the nivelInteractividad backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setNivelInteractividadBackingList(valueObjects, "id", "name")</code>
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
     * @see #getNivelInteractividad()
     * @see #getNivelInteractividadValueList()
     * @see #getNivelInteractividadLabelList()
     * @see #getNivelInteractividadLabelList()
     */
    public void setNivelInteractividadBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>nivelInteractividad</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getNivelInteractividad()
     * @see #getNivelInteractividadBackingList()
     */
    public java.lang.Object[] getNivelInteractividadValueList();

    /**
     * The <code>nivelInteractividad</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getNivelInteractividad()
     * @see #getNivelInteractividadBackingList()
     */
    public void setNivelInteractividadValueList(java.lang.Object[] nivelInteractividadValueList);

    /**
     * The <code>nivelInteractividad</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getNivelInteractividad()
     * @see #getNivelInteractividadBackingList()
     */
    public java.lang.Object[] getNivelInteractividadLabelList();

    /**
     * The <code>nivelInteractividad</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getNivelInteractividad()
     * @see #getNivelInteractividadBackingList()
     */
    public void setNivelInteractividadLabelList(java.lang.Object[] nivelInteractividadLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setRolUsuario#sArray(Object[])
     */
    public void setRolUsuario(java.util.Collection rolUsuario);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getRolUsuario#sArray()
     */
    public java.util.Collection getRolUsuario();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setRolUsuario(java.util.Collection)
     */
    public void setRolUsuarioAsArray(Object[] rolUsuario);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getRolUsuario()
     */
    public java.lang.Object[] getRolUsuarioAsArray();

    /**
     * Resets the <code>rolUsuario</code> field.
     */
    public void resetRolUsuario();

    /**
     * Sets the <code>densidadSemantica</code> field.
     *
     * 
     */
    public void setDensidadSemantica(java.lang.String densidadSemantica);

    /**
     * Gets the <code>densidadSemantica</code> field.
     *
     * 
     */
    public java.lang.String getDensidadSemantica();
    
    /**
     * Resets the <code>densidadSemantica</code> field.
     */
    public void resetDensidadSemantica();

    /**
     * The <code>densidadSemantica</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getDensidadSemantica()
     * @see #getDensidadSemanticaValueList()
     * @see #getDensidadSemanticaLabelList()
     * @see #setDensidadSemanticaLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getDensidadSemanticaBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * densidadSemantica property. This method takes a collection of objects, as well as
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
     * But you need to populate the densidadSemantica backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setDensidadSemanticaBackingList(valueObjects, "id", "name")</code>
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
     * @see #getDensidadSemantica()
     * @see #getDensidadSemanticaValueList()
     * @see #getDensidadSemanticaLabelList()
     * @see #getDensidadSemanticaLabelList()
     */
    public void setDensidadSemanticaBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>densidadSemantica</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getDensidadSemantica()
     * @see #getDensidadSemanticaBackingList()
     */
    public java.lang.Object[] getDensidadSemanticaValueList();

    /**
     * The <code>densidadSemantica</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getDensidadSemantica()
     * @see #getDensidadSemanticaBackingList()
     */
    public void setDensidadSemanticaValueList(java.lang.Object[] densidadSemanticaValueList);

    /**
     * The <code>densidadSemantica</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getDensidadSemantica()
     * @see #getDensidadSemanticaBackingList()
     */
    public java.lang.Object[] getDensidadSemanticaLabelList();

    /**
     * The <code>densidadSemantica</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getDensidadSemantica()
     * @see #getDensidadSemanticaBackingList()
     */
    public void setDensidadSemanticaLabelList(java.lang.Object[] densidadSemanticaLabelList);

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

}

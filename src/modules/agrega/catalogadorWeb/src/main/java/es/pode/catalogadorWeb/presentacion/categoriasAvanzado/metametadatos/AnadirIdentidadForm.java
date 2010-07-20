// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.metametadatos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>anadirIdentidad</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.metametadatos.MetametadatosController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.metametadatos.MetametadatosController#anadirIdentidad
 */
public interface AnadirIdentidadForm
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
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIdentificadores#sArray(Object[])
     */
    public void setIdentificadores(java.util.Collection identificadores);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIdentificadores#sArray()
     */
    public java.util.Collection getIdentificadores();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIdentificadores(java.util.Collection)
     */
    public void setIdentificadoresAsArray(Object[] identificadores);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIdentificadores()
     */
    public java.lang.Object[] getIdentificadoresAsArray();

    /**
     * Resets the <code>identificadores</code> field.
     */
    public void resetIdentificadores();

    /**
     * The <code>identificadores</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getIdentificadores()
     * @see #getIdentificadoresValueList()
     * @see #getIdentificadoresLabelList()
     * @see #setIdentificadoresLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getIdentificadoresBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * identificadores property. This method takes a collection of objects, as well as
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
     * But you need to populate the identificadores backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setIdentificadoresBackingList(valueObjects, "id", "name")</code>
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
     * @see #getIdentificadores()
     * @see #getIdentificadoresValueList()
     * @see #getIdentificadoresLabelList()
     * @see #getIdentificadoresLabelList()
     */
    public void setIdentificadoresBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>identificadores</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getIdentificadores()
     * @see #getIdentificadoresBackingList()
     */
    public java.lang.Object[] getIdentificadoresValueList();

    /**
     * The <code>identificadores</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getIdentificadores()
     * @see #getIdentificadoresBackingList()
     */
    public void setIdentificadoresValueList(java.lang.Object[] identificadoresValueList);

    /**
     * The <code>identificadores</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getIdentificadores()
     * @see #getIdentificadoresBackingList()
     */
    public java.lang.Object[] getIdentificadoresLabelList();

    /**
     * The <code>identificadores</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getIdentificadores()
     * @see #getIdentificadoresBackingList()
     */
    public void setIdentificadoresLabelList(java.lang.Object[] identificadoresLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setCidentidad#sArray(Object[])
     */
    public void setCidentidad(java.util.Collection cidentidad);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getCidentidad#sArray()
     */
    public java.util.Collection getCidentidad();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setCidentidad(java.util.Collection)
     */
    public void setCidentidadAsArray(Object[] cidentidad);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getCidentidad()
     */
    public java.lang.Object[] getCidentidadAsArray();

    /**
     * Resets the <code>cidentidad</code> field.
     */
    public void resetCidentidad();

    /**
     * The <code>cidentidad</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getCidentidad()
     * @see #getCidentidadValueList()
     * @see #getCidentidadLabelList()
     * @see #setCidentidadLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getCidentidadBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * cidentidad property. This method takes a collection of objects, as well as
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
     * But you need to populate the cidentidad backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setCidentidadBackingList(valueObjects, "id", "name")</code>
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
     * @see #getCidentidad()
     * @see #getCidentidadValueList()
     * @see #getCidentidadLabelList()
     * @see #getCidentidadLabelList()
     */
    public void setCidentidadBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>cidentidad</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getCidentidad()
     * @see #getCidentidadBackingList()
     */
    public java.lang.Object[] getCidentidadValueList();

    /**
     * The <code>cidentidad</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getCidentidad()
     * @see #getCidentidadBackingList()
     */
    public void setCidentidadValueList(java.lang.Object[] cidentidadValueList);

    /**
     * The <code>cidentidad</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getCidentidad()
     * @see #getCidentidadBackingList()
     */
    public java.lang.Object[] getCidentidadLabelList();

    /**
     * The <code>cidentidad</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getCidentidad()
     * @see #getCidentidadBackingList()
     */
    public void setCidentidadLabelList(java.lang.Object[] cidentidadLabelList);

    /**
     * Sets the <code>meridianocero</code> field.
     *
     * 
     */
    public void setMeridianocero(java.lang.String meridianocero);

    /**
     * Gets the <code>meridianocero</code> field.
     *
     * 
     */
    public java.lang.String getMeridianocero();
    
    /**
     * Resets the <code>meridianocero</code> field.
     */
    public void resetMeridianocero();

    /**
     * Sets the <code>comboIdiomaMeta</code> field.
     *
     * 
     */
    public void setComboIdiomaMeta(java.lang.String comboIdiomaMeta);

    /**
     * Gets the <code>comboIdiomaMeta</code> field.
     *
     * 
     */
    public java.lang.String getComboIdiomaMeta();
    
    /**
     * Resets the <code>comboIdiomaMeta</code> field.
     */
    public void resetComboIdiomaMeta();

    /**
     * The <code>comboIdiomaMeta</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboIdiomaMeta()
     * @see #getComboIdiomaMetaValueList()
     * @see #getComboIdiomaMetaLabelList()
     * @see #setComboIdiomaMetaLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboIdiomaMetaBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboIdiomaMeta property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboIdiomaMeta backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboIdiomaMetaBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboIdiomaMeta()
     * @see #getComboIdiomaMetaValueList()
     * @see #getComboIdiomaMetaLabelList()
     * @see #getComboIdiomaMetaLabelList()
     */
    public void setComboIdiomaMetaBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboIdiomaMeta</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboIdiomaMeta()
     * @see #getComboIdiomaMetaBackingList()
     */
    public java.lang.Object[] getComboIdiomaMetaValueList();

    /**
     * The <code>comboIdiomaMeta</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboIdiomaMeta()
     * @see #getComboIdiomaMetaBackingList()
     */
    public void setComboIdiomaMetaValueList(java.lang.Object[] comboIdiomaMetaValueList);

    /**
     * The <code>comboIdiomaMeta</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboIdiomaMeta()
     * @see #getComboIdiomaMetaBackingList()
     */
    public java.lang.Object[] getComboIdiomaMetaLabelList();

    /**
     * The <code>comboIdiomaMeta</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboIdiomaMeta()
     * @see #getComboIdiomaMetaBackingList()
     */
    public void setComboIdiomaMetaLabelList(java.lang.Object[] comboIdiomaMetaLabelList);

    /**
     * Sets the <code>zhHora</code> field.
     *
     * 
     */
    public void setZhHora(java.lang.String zhHora);

    /**
     * Gets the <code>zhHora</code> field.
     *
     * 
     */
    public java.lang.String getZhHora();
    
    /**
     * Resets the <code>zhHora</code> field.
     */
    public void resetZhHora();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setEsquemasMeta#sArray(Object[])
     */
    public void setEsquemasMeta(java.util.Collection esquemasMeta);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getEsquemasMeta#sArray()
     */
    public java.util.Collection getEsquemasMeta();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setEsquemasMeta(java.util.Collection)
     */
    public void setEsquemasMetaAsArray(Object[] esquemasMeta);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getEsquemasMeta()
     */
    public java.lang.Object[] getEsquemasMetaAsArray();

    /**
     * Resets the <code>esquemasMeta</code> field.
     */
    public void resetEsquemasMeta();

    /**
     * The <code>esquemasMeta</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getEsquemasMeta()
     * @see #getEsquemasMetaValueList()
     * @see #getEsquemasMetaLabelList()
     * @see #setEsquemasMetaLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getEsquemasMetaBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * esquemasMeta property. This method takes a collection of objects, as well as
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
     * But you need to populate the esquemasMeta backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setEsquemasMetaBackingList(valueObjects, "id", "name")</code>
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
     * @see #getEsquemasMeta()
     * @see #getEsquemasMetaValueList()
     * @see #getEsquemasMetaLabelList()
     * @see #getEsquemasMetaLabelList()
     */
    public void setEsquemasMetaBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>esquemasMeta</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getEsquemasMeta()
     * @see #getEsquemasMetaBackingList()
     */
    public java.lang.Object[] getEsquemasMetaValueList();

    /**
     * The <code>esquemasMeta</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getEsquemasMeta()
     * @see #getEsquemasMetaBackingList()
     */
    public void setEsquemasMetaValueList(java.lang.Object[] esquemasMetaValueList);

    /**
     * The <code>esquemasMeta</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getEsquemasMeta()
     * @see #getEsquemasMetaBackingList()
     */
    public java.lang.Object[] getEsquemasMetaLabelList();

    /**
     * The <code>esquemasMeta</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getEsquemasMeta()
     * @see #getEsquemasMetaBackingList()
     */
    public void setEsquemasMetaLabelList(java.lang.Object[] esquemasMetaLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setContribucion#sArray(Object[])
     */
    public void setContribucion(java.util.Collection contribucion);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getContribucion#sArray()
     */
    public java.util.Collection getContribucion();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setContribucion(java.util.Collection)
     */
    public void setContribucionAsArray(Object[] contribucion);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getContribucion()
     */
    public java.lang.Object[] getContribucionAsArray();

    /**
     * Resets the <code>contribucion</code> field.
     */
    public void resetContribucion();

    /**
     * The <code>contribucion</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getContribucion()
     * @see #getContribucionValueList()
     * @see #getContribucionLabelList()
     * @see #setContribucionLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getContribucionBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * contribucion property. This method takes a collection of objects, as well as
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
     * But you need to populate the contribucion backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setContribucionBackingList(valueObjects, "id", "name")</code>
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
     * @see #getContribucion()
     * @see #getContribucionValueList()
     * @see #getContribucionLabelList()
     * @see #getContribucionLabelList()
     */
    public void setContribucionBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>contribucion</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getContribucion()
     * @see #getContribucionBackingList()
     */
    public java.lang.Object[] getContribucionValueList();

    /**
     * The <code>contribucion</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getContribucion()
     * @see #getContribucionBackingList()
     */
    public void setContribucionValueList(java.lang.Object[] contribucionValueList);

    /**
     * The <code>contribucion</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getContribucion()
     * @see #getContribucionBackingList()
     */
    public java.lang.Object[] getContribucionLabelList();

    /**
     * The <code>contribucion</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getContribucion()
     * @see #getContribucionBackingList()
     */
    public void setContribucionLabelList(java.lang.Object[] contribucionLabelList);

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
     * Sets the <code>crol</code> field.
     *
     * 
     */
    public void setCrol(java.lang.String crol);

    /**
     * Gets the <code>crol</code> field.
     *
     * 
     */
    public java.lang.String getCrol();
    
    /**
     * Resets the <code>crol</code> field.
     */
    public void resetCrol();

    /**
     * The <code>crol</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getCrol()
     * @see #getCrolValueList()
     * @see #getCrolLabelList()
     * @see #setCrolLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getCrolBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * crol property. This method takes a collection of objects, as well as
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
     * But you need to populate the crol backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setCrolBackingList(valueObjects, "id", "name")</code>
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
     * @see #getCrol()
     * @see #getCrolValueList()
     * @see #getCrolLabelList()
     * @see #getCrolLabelList()
     */
    public void setCrolBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>crol</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getCrol()
     * @see #getCrolBackingList()
     */
    public java.lang.Object[] getCrolValueList();

    /**
     * The <code>crol</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getCrol()
     * @see #getCrolBackingList()
     */
    public void setCrolValueList(java.lang.Object[] crolValueList);

    /**
     * The <code>crol</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getCrol()
     * @see #getCrolBackingList()
     */
    public java.lang.Object[] getCrolLabelList();

    /**
     * The <code>crol</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getCrol()
     * @see #getCrolBackingList()
     */
    public void setCrolLabelList(java.lang.Object[] crolLabelList);

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
     * Sets the <code>zhMinutos</code> field.
     *
     * 
     */
    public void setZhMinutos(java.lang.String zhMinutos);

    /**
     * Gets the <code>zhMinutos</code> field.
     *
     * 
     */
    public java.lang.String getZhMinutos();
    
    /**
     * Resets the <code>zhMinutos</code> field.
     */
    public void resetZhMinutos();

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

// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>guardarCicloVida</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController#guardarCicloVida
 */
public interface GuardarCicloVidaForm
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
     * Sets the <code>fecha</code> field.
     *
     * 
     */
    public void setFecha(java.lang.String fecha);

    /**
     * Gets the <code>fecha</code> field.
     *
     * 
     */
    public java.lang.String getFecha();
    
    /**
     * Resets the <code>fecha</code> field.
     */
    public void resetFecha();

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
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setVersiones#sArray(Object[])
     */
    public void setVersiones(java.util.Collection versiones);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getVersiones#sArray()
     */
    public java.util.Collection getVersiones();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setVersiones(java.util.Collection)
     */
    public void setVersionesAsArray(Object[] versiones);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getVersiones()
     */
    public java.lang.Object[] getVersionesAsArray();

    /**
     * Resets the <code>versiones</code> field.
     */
    public void resetVersiones();

    /**
     * The <code>versiones</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getVersiones()
     * @see #getVersionesValueList()
     * @see #getVersionesLabelList()
     * @see #setVersionesLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getVersionesBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * versiones property. This method takes a collection of objects, as well as
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
     * But you need to populate the versiones backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setVersionesBackingList(valueObjects, "id", "name")</code>
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
     * @see #getVersiones()
     * @see #getVersionesValueList()
     * @see #getVersionesLabelList()
     * @see #getVersionesLabelList()
     */
    public void setVersionesBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>versiones</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getVersiones()
     * @see #getVersionesBackingList()
     */
    public java.lang.Object[] getVersionesValueList();

    /**
     * The <code>versiones</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getVersiones()
     * @see #getVersionesBackingList()
     */
    public void setVersionesValueList(java.lang.Object[] versionesValueList);

    /**
     * The <code>versiones</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getVersiones()
     * @see #getVersionesBackingList()
     */
    public java.lang.Object[] getVersionesLabelList();

    /**
     * The <code>versiones</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getVersiones()
     * @see #getVersionesBackingList()
     */
    public void setVersionesLabelList(java.lang.Object[] versionesLabelList);

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
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setContribuciones#sArray(Object[])
     */
    public void setContribuciones(java.util.Collection contribuciones);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getContribuciones#sArray()
     */
    public java.util.Collection getContribuciones();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setContribuciones(java.util.Collection)
     */
    public void setContribucionesAsArray(Object[] contribuciones);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getContribuciones()
     */
    public java.lang.Object[] getContribucionesAsArray();

    /**
     * Resets the <code>contribuciones</code> field.
     */
    public void resetContribuciones();

    /**
     * The <code>contribuciones</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getContribuciones()
     * @see #getContribucionesValueList()
     * @see #getContribucionesLabelList()
     * @see #setContribucionesLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getContribucionesBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * contribuciones property. This method takes a collection of objects, as well as
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
     * But you need to populate the contribuciones backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setContribucionesBackingList(valueObjects, "id", "name")</code>
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
     * @see #getContribuciones()
     * @see #getContribucionesValueList()
     * @see #getContribucionesLabelList()
     * @see #getContribucionesLabelList()
     */
    public void setContribucionesBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>contribuciones</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getContribuciones()
     * @see #getContribucionesBackingList()
     */
    public java.lang.Object[] getContribucionesValueList();

    /**
     * The <code>contribuciones</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getContribuciones()
     * @see #getContribucionesBackingList()
     */
    public void setContribucionesValueList(java.lang.Object[] contribucionesValueList);

    /**
     * The <code>contribuciones</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getContribuciones()
     * @see #getContribucionesBackingList()
     */
    public java.lang.Object[] getContribucionesLabelList();

    /**
     * The <code>contribuciones</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getContribuciones()
     * @see #getContribucionesBackingList()
     */
    public void setContribucionesLabelList(java.lang.Object[] contribucionesLabelList);

    /**
     * Sets the <code>estatus</code> field.
     *
     * 
     */
    public void setEstatus(java.lang.String estatus);

    /**
     * Gets the <code>estatus</code> field.
     *
     * 
     */
    public java.lang.String getEstatus();
    
    /**
     * Resets the <code>estatus</code> field.
     */
    public void resetEstatus();

    /**
     * The <code>estatus</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getEstatus()
     * @see #getEstatusValueList()
     * @see #getEstatusLabelList()
     * @see #setEstatusLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getEstatusBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * estatus property. This method takes a collection of objects, as well as
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
     * But you need to populate the estatus backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setEstatusBackingList(valueObjects, "id", "name")</code>
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
     * @see #getEstatus()
     * @see #getEstatusValueList()
     * @see #getEstatusLabelList()
     * @see #getEstatusLabelList()
     */
    public void setEstatusBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>estatus</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getEstatus()
     * @see #getEstatusBackingList()
     */
    public java.lang.Object[] getEstatusValueList();

    /**
     * The <code>estatus</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getEstatus()
     * @see #getEstatusBackingList()
     */
    public void setEstatusValueList(java.lang.Object[] estatusValueList);

    /**
     * The <code>estatus</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getEstatus()
     * @see #getEstatusBackingList()
     */
    public java.lang.Object[] getEstatusLabelList();

    /**
     * The <code>estatus</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getEstatus()
     * @see #getEstatusBackingList()
     */
    public void setEstatusLabelList(java.lang.Object[] estatusLabelList);

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

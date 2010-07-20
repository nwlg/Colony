// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>esValidoGeneral</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralController#esValidoGeneral
 */
public interface EsValidoGeneralForm
{
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
     * Sets the <code>comboCaractEstructuraFormal</code> field.
     *
     * 
     */
    public void setComboCaractEstructuraFormal(java.lang.String comboCaractEstructuraFormal);

    /**
     * Gets the <code>comboCaractEstructuraFormal</code> field.
     *
     * 
     */
    public java.lang.String getComboCaractEstructuraFormal();
    
    /**
     * Resets the <code>comboCaractEstructuraFormal</code> field.
     */
    public void resetComboCaractEstructuraFormal();

    /**
     * The <code>comboCaractEstructuraFormal</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboCaractEstructuraFormal()
     * @see #getComboCaractEstructuraFormalValueList()
     * @see #getComboCaractEstructuraFormalLabelList()
     * @see #setComboCaractEstructuraFormalLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboCaractEstructuraFormalBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboCaractEstructuraFormal property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboCaractEstructuraFormal backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboCaractEstructuraFormalBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboCaractEstructuraFormal()
     * @see #getComboCaractEstructuraFormalValueList()
     * @see #getComboCaractEstructuraFormalLabelList()
     * @see #getComboCaractEstructuraFormalLabelList()
     */
    public void setComboCaractEstructuraFormalBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboCaractEstructuraFormal</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboCaractEstructuraFormal()
     * @see #getComboCaractEstructuraFormalBackingList()
     */
    public java.lang.Object[] getComboCaractEstructuraFormalValueList();

    /**
     * The <code>comboCaractEstructuraFormal</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboCaractEstructuraFormal()
     * @see #getComboCaractEstructuraFormalBackingList()
     */
    public void setComboCaractEstructuraFormalValueList(java.lang.Object[] comboCaractEstructuraFormalValueList);

    /**
     * The <code>comboCaractEstructuraFormal</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboCaractEstructuraFormal()
     * @see #getComboCaractEstructuraFormalBackingList()
     */
    public java.lang.Object[] getComboCaractEstructuraFormalLabelList();

    /**
     * The <code>comboCaractEstructuraFormal</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboCaractEstructuraFormal()
     * @see #getComboCaractEstructuraFormalBackingList()
     */
    public void setComboCaractEstructuraFormalLabelList(java.lang.Object[] comboCaractEstructuraFormalLabelList);

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
     * @see #setPalabrasClave#sArray(Object[])
     */
    public void setPalabrasClave(java.util.Collection palabrasClave);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getPalabrasClave#sArray()
     */
    public java.util.Collection getPalabrasClave();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setPalabrasClave(java.util.Collection)
     */
    public void setPalabrasClaveAsArray(Object[] palabrasClave);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getPalabrasClave()
     */
    public java.lang.Object[] getPalabrasClaveAsArray();

    /**
     * Resets the <code>palabrasClave</code> field.
     */
    public void resetPalabrasClave();

    /**
     * The <code>palabrasClave</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getPalabrasClave()
     * @see #getPalabrasClaveValueList()
     * @see #getPalabrasClaveLabelList()
     * @see #setPalabrasClaveLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getPalabrasClaveBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * palabrasClave property. This method takes a collection of objects, as well as
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
     * But you need to populate the palabrasClave backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setPalabrasClaveBackingList(valueObjects, "id", "name")</code>
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
     * @see #getPalabrasClave()
     * @see #getPalabrasClaveValueList()
     * @see #getPalabrasClaveLabelList()
     * @see #getPalabrasClaveLabelList()
     */
    public void setPalabrasClaveBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>palabrasClave</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getPalabrasClave()
     * @see #getPalabrasClaveBackingList()
     */
    public java.lang.Object[] getPalabrasClaveValueList();

    /**
     * The <code>palabrasClave</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getPalabrasClave()
     * @see #getPalabrasClaveBackingList()
     */
    public void setPalabrasClaveValueList(java.lang.Object[] palabrasClaveValueList);

    /**
     * The <code>palabrasClave</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getPalabrasClave()
     * @see #getPalabrasClaveBackingList()
     */
    public java.lang.Object[] getPalabrasClaveLabelList();

    /**
     * The <code>palabrasClave</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getPalabrasClave()
     * @see #getPalabrasClaveBackingList()
     */
    public void setPalabrasClaveLabelList(java.lang.Object[] palabrasClaveLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setAmbitos#sArray(Object[])
     */
    public void setAmbitos(java.util.Collection ambitos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getAmbitos#sArray()
     */
    public java.util.Collection getAmbitos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setAmbitos(java.util.Collection)
     */
    public void setAmbitosAsArray(Object[] ambitos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getAmbitos()
     */
    public java.lang.Object[] getAmbitosAsArray();

    /**
     * Resets the <code>ambitos</code> field.
     */
    public void resetAmbitos();

    /**
     * The <code>ambitos</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getAmbitos()
     * @see #getAmbitosValueList()
     * @see #getAmbitosLabelList()
     * @see #setAmbitosLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getAmbitosBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * ambitos property. This method takes a collection of objects, as well as
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
     * But you need to populate the ambitos backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setAmbitosBackingList(valueObjects, "id", "name")</code>
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
     * @see #getAmbitos()
     * @see #getAmbitosValueList()
     * @see #getAmbitosLabelList()
     * @see #getAmbitosLabelList()
     */
    public void setAmbitosBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>ambitos</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getAmbitos()
     * @see #getAmbitosBackingList()
     */
    public java.lang.Object[] getAmbitosValueList();

    /**
     * The <code>ambitos</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getAmbitos()
     * @see #getAmbitosBackingList()
     */
    public void setAmbitosValueList(java.lang.Object[] ambitosValueList);

    /**
     * The <code>ambitos</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getAmbitos()
     * @see #getAmbitosBackingList()
     */
    public java.lang.Object[] getAmbitosLabelList();

    /**
     * The <code>ambitos</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getAmbitos()
     * @see #getAmbitosBackingList()
     */
    public void setAmbitosLabelList(java.lang.Object[] ambitosLabelList);

    /**
     * Sets the <code>estructura</code> field.
     *
     * 
     */
    public void setEstructura(java.lang.String estructura);

    /**
     * Gets the <code>estructura</code> field.
     *
     * 
     */
    public java.lang.String getEstructura();
    
    /**
     * Resets the <code>estructura</code> field.
     */
    public void resetEstructura();

    /**
     * The <code>estructura</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getEstructura()
     * @see #getEstructuraValueList()
     * @see #getEstructuraLabelList()
     * @see #setEstructuraLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getEstructuraBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * estructura property. This method takes a collection of objects, as well as
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
     * But you need to populate the estructura backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setEstructuraBackingList(valueObjects, "id", "name")</code>
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
     * @see #getEstructura()
     * @see #getEstructuraValueList()
     * @see #getEstructuraLabelList()
     * @see #getEstructuraLabelList()
     */
    public void setEstructuraBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>estructura</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getEstructura()
     * @see #getEstructuraBackingList()
     */
    public java.lang.Object[] getEstructuraValueList();

    /**
     * The <code>estructura</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getEstructura()
     * @see #getEstructuraBackingList()
     */
    public void setEstructuraValueList(java.lang.Object[] estructuraValueList);

    /**
     * The <code>estructura</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getEstructura()
     * @see #getEstructuraBackingList()
     */
    public java.lang.Object[] getEstructuraLabelList();

    /**
     * The <code>estructura</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getEstructura()
     * @see #getEstructuraBackingList()
     */
    public void setEstructuraLabelList(java.lang.Object[] estructuraLabelList);

    /**
     * Sets the <code>comboCaractAngulacion</code> field.
     *
     * 
     */
    public void setComboCaractAngulacion(java.lang.String comboCaractAngulacion);

    /**
     * Gets the <code>comboCaractAngulacion</code> field.
     *
     * 
     */
    public java.lang.String getComboCaractAngulacion();
    
    /**
     * Resets the <code>comboCaractAngulacion</code> field.
     */
    public void resetComboCaractAngulacion();

    /**
     * The <code>comboCaractAngulacion</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboCaractAngulacion()
     * @see #getComboCaractAngulacionValueList()
     * @see #getComboCaractAngulacionLabelList()
     * @see #setComboCaractAngulacionLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboCaractAngulacionBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboCaractAngulacion property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboCaractAngulacion backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboCaractAngulacionBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboCaractAngulacion()
     * @see #getComboCaractAngulacionValueList()
     * @see #getComboCaractAngulacionLabelList()
     * @see #getComboCaractAngulacionLabelList()
     */
    public void setComboCaractAngulacionBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboCaractAngulacion</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboCaractAngulacion()
     * @see #getComboCaractAngulacionBackingList()
     */
    public java.lang.Object[] getComboCaractAngulacionValueList();

    /**
     * The <code>comboCaractAngulacion</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboCaractAngulacion()
     * @see #getComboCaractAngulacionBackingList()
     */
    public void setComboCaractAngulacionValueList(java.lang.Object[] comboCaractAngulacionValueList);

    /**
     * The <code>comboCaractAngulacion</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboCaractAngulacion()
     * @see #getComboCaractAngulacionBackingList()
     */
    public java.lang.Object[] getComboCaractAngulacionLabelList();

    /**
     * The <code>comboCaractAngulacion</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboCaractAngulacion()
     * @see #getComboCaractAngulacionBackingList()
     */
    public void setComboCaractAngulacionLabelList(java.lang.Object[] comboCaractAngulacionLabelList);

    /**
     * Sets the <code>nivelAgregacion</code> field.
     *
     * 
     */
    public void setNivelAgregacion(java.lang.String nivelAgregacion);

    /**
     * Gets the <code>nivelAgregacion</code> field.
     *
     * 
     */
    public java.lang.String getNivelAgregacion();
    
    /**
     * Resets the <code>nivelAgregacion</code> field.
     */
    public void resetNivelAgregacion();

    /**
     * The <code>nivelAgregacion</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getNivelAgregacion()
     * @see #getNivelAgregacionValueList()
     * @see #getNivelAgregacionLabelList()
     * @see #setNivelAgregacionLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getNivelAgregacionBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * nivelAgregacion property. This method takes a collection of objects, as well as
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
     * But you need to populate the nivelAgregacion backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setNivelAgregacionBackingList(valueObjects, "id", "name")</code>
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
     * @see #getNivelAgregacion()
     * @see #getNivelAgregacionValueList()
     * @see #getNivelAgregacionLabelList()
     * @see #getNivelAgregacionLabelList()
     */
    public void setNivelAgregacionBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>nivelAgregacion</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getNivelAgregacion()
     * @see #getNivelAgregacionBackingList()
     */
    public java.lang.Object[] getNivelAgregacionValueList();

    /**
     * The <code>nivelAgregacion</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getNivelAgregacion()
     * @see #getNivelAgregacionBackingList()
     */
    public void setNivelAgregacionValueList(java.lang.Object[] nivelAgregacionValueList);

    /**
     * The <code>nivelAgregacion</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getNivelAgregacion()
     * @see #getNivelAgregacionBackingList()
     */
    public java.lang.Object[] getNivelAgregacionLabelList();

    /**
     * The <code>nivelAgregacion</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getNivelAgregacion()
     * @see #getNivelAgregacionBackingList()
     */
    public void setNivelAgregacionLabelList(java.lang.Object[] nivelAgregacionLabelList);

    /**
     * Sets the <code>comboCaractTipoPlano</code> field.
     *
     * 
     */
    public void setComboCaractTipoPlano(java.lang.String comboCaractTipoPlano);

    /**
     * Gets the <code>comboCaractTipoPlano</code> field.
     *
     * 
     */
    public java.lang.String getComboCaractTipoPlano();
    
    /**
     * Resets the <code>comboCaractTipoPlano</code> field.
     */
    public void resetComboCaractTipoPlano();

    /**
     * The <code>comboCaractTipoPlano</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboCaractTipoPlano()
     * @see #getComboCaractTipoPlanoValueList()
     * @see #getComboCaractTipoPlanoLabelList()
     * @see #setComboCaractTipoPlanoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboCaractTipoPlanoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboCaractTipoPlano property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboCaractTipoPlano backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboCaractTipoPlanoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboCaractTipoPlano()
     * @see #getComboCaractTipoPlanoValueList()
     * @see #getComboCaractTipoPlanoLabelList()
     * @see #getComboCaractTipoPlanoLabelList()
     */
    public void setComboCaractTipoPlanoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboCaractTipoPlano</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboCaractTipoPlano()
     * @see #getComboCaractTipoPlanoBackingList()
     */
    public java.lang.Object[] getComboCaractTipoPlanoValueList();

    /**
     * The <code>comboCaractTipoPlano</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboCaractTipoPlano()
     * @see #getComboCaractTipoPlanoBackingList()
     */
    public void setComboCaractTipoPlanoValueList(java.lang.Object[] comboCaractTipoPlanoValueList);

    /**
     * The <code>comboCaractTipoPlano</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboCaractTipoPlano()
     * @see #getComboCaractTipoPlanoBackingList()
     */
    public java.lang.Object[] getComboCaractTipoPlanoLabelList();

    /**
     * The <code>comboCaractTipoPlano</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboCaractTipoPlano()
     * @see #getComboCaractTipoPlanoBackingList()
     */
    public void setComboCaractTipoPlanoLabelList(java.lang.Object[] comboCaractTipoPlanoLabelList);

    /**
     * Sets the <code>comboCaractBandaSonora</code> field.
     *
     * 
     */
    public void setComboCaractBandaSonora(java.lang.String comboCaractBandaSonora);

    /**
     * Gets the <code>comboCaractBandaSonora</code> field.
     *
     * 
     */
    public java.lang.String getComboCaractBandaSonora();
    
    /**
     * Resets the <code>comboCaractBandaSonora</code> field.
     */
    public void resetComboCaractBandaSonora();

    /**
     * The <code>comboCaractBandaSonora</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboCaractBandaSonora()
     * @see #getComboCaractBandaSonoraValueList()
     * @see #getComboCaractBandaSonoraLabelList()
     * @see #setComboCaractBandaSonoraLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboCaractBandaSonoraBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboCaractBandaSonora property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboCaractBandaSonora backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboCaractBandaSonoraBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboCaractBandaSonora()
     * @see #getComboCaractBandaSonoraValueList()
     * @see #getComboCaractBandaSonoraLabelList()
     * @see #getComboCaractBandaSonoraLabelList()
     */
    public void setComboCaractBandaSonoraBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboCaractBandaSonora</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboCaractBandaSonora()
     * @see #getComboCaractBandaSonoraBackingList()
     */
    public java.lang.Object[] getComboCaractBandaSonoraValueList();

    /**
     * The <code>comboCaractBandaSonora</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboCaractBandaSonora()
     * @see #getComboCaractBandaSonoraBackingList()
     */
    public void setComboCaractBandaSonoraValueList(java.lang.Object[] comboCaractBandaSonoraValueList);

    /**
     * The <code>comboCaractBandaSonora</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboCaractBandaSonora()
     * @see #getComboCaractBandaSonoraBackingList()
     */
    public java.lang.Object[] getComboCaractBandaSonoraLabelList();

    /**
     * The <code>comboCaractBandaSonora</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboCaractBandaSonora()
     * @see #getComboCaractBandaSonoraBackingList()
     */
    public void setComboCaractBandaSonoraLabelList(java.lang.Object[] comboCaractBandaSonoraLabelList);

    /**
     * Sets the <code>comboCaractLuz</code> field.
     *
     * 
     */
    public void setComboCaractLuz(java.lang.String comboCaractLuz);

    /**
     * Gets the <code>comboCaractLuz</code> field.
     *
     * 
     */
    public java.lang.String getComboCaractLuz();
    
    /**
     * Resets the <code>comboCaractLuz</code> field.
     */
    public void resetComboCaractLuz();

    /**
     * The <code>comboCaractLuz</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboCaractLuz()
     * @see #getComboCaractLuzValueList()
     * @see #getComboCaractLuzLabelList()
     * @see #setComboCaractLuzLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboCaractLuzBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboCaractLuz property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboCaractLuz backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboCaractLuzBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboCaractLuz()
     * @see #getComboCaractLuzValueList()
     * @see #getComboCaractLuzLabelList()
     * @see #getComboCaractLuzLabelList()
     */
    public void setComboCaractLuzBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboCaractLuz</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboCaractLuz()
     * @see #getComboCaractLuzBackingList()
     */
    public java.lang.Object[] getComboCaractLuzValueList();

    /**
     * The <code>comboCaractLuz</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboCaractLuz()
     * @see #getComboCaractLuzBackingList()
     */
    public void setComboCaractLuzValueList(java.lang.Object[] comboCaractLuzValueList);

    /**
     * The <code>comboCaractLuz</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboCaractLuz()
     * @see #getComboCaractLuzBackingList()
     */
    public java.lang.Object[] getComboCaractLuzLabelList();

    /**
     * The <code>comboCaractLuz</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboCaractLuz()
     * @see #getComboCaractLuzBackingList()
     */
    public void setComboCaractLuzLabelList(java.lang.Object[] comboCaractLuzLabelList);

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
     * Sets the <code>comboCaractFormato</code> field.
     *
     * 
     */
    public void setComboCaractFormato(java.lang.String comboCaractFormato);

    /**
     * Gets the <code>comboCaractFormato</code> field.
     *
     * 
     */
    public java.lang.String getComboCaractFormato();
    
    /**
     * Resets the <code>comboCaractFormato</code> field.
     */
    public void resetComboCaractFormato();

    /**
     * The <code>comboCaractFormato</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboCaractFormato()
     * @see #getComboCaractFormatoValueList()
     * @see #getComboCaractFormatoLabelList()
     * @see #setComboCaractFormatoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboCaractFormatoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboCaractFormato property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboCaractFormato backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboCaractFormatoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboCaractFormato()
     * @see #getComboCaractFormatoValueList()
     * @see #getComboCaractFormatoLabelList()
     * @see #getComboCaractFormatoLabelList()
     */
    public void setComboCaractFormatoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboCaractFormato</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboCaractFormato()
     * @see #getComboCaractFormatoBackingList()
     */
    public java.lang.Object[] getComboCaractFormatoValueList();

    /**
     * The <code>comboCaractFormato</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboCaractFormato()
     * @see #getComboCaractFormatoBackingList()
     */
    public void setComboCaractFormatoValueList(java.lang.Object[] comboCaractFormatoValueList);

    /**
     * The <code>comboCaractFormato</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboCaractFormato()
     * @see #getComboCaractFormatoBackingList()
     */
    public java.lang.Object[] getComboCaractFormatoLabelList();

    /**
     * The <code>comboCaractFormato</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboCaractFormato()
     * @see #getComboCaractFormatoBackingList()
     */
    public void setComboCaractFormatoLabelList(java.lang.Object[] comboCaractFormatoLabelList);

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
     * @see #setCaracteristicas#sArray(Object[])
     */
    public void setCaracteristicas(java.util.Collection caracteristicas);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getCaracteristicas#sArray()
     */
    public java.util.Collection getCaracteristicas();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setCaracteristicas(java.util.Collection)
     */
    public void setCaracteristicasAsArray(Object[] caracteristicas);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getCaracteristicas()
     */
    public java.lang.Object[] getCaracteristicasAsArray();

    /**
     * Resets the <code>caracteristicas</code> field.
     */
    public void resetCaracteristicas();

    /**
     * The <code>caracteristicas</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getCaracteristicas()
     * @see #getCaracteristicasValueList()
     * @see #getCaracteristicasLabelList()
     * @see #setCaracteristicasLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getCaracteristicasBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * caracteristicas property. This method takes a collection of objects, as well as
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
     * But you need to populate the caracteristicas backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setCaracteristicasBackingList(valueObjects, "id", "name")</code>
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
     * @see #getCaracteristicas()
     * @see #getCaracteristicasValueList()
     * @see #getCaracteristicasLabelList()
     * @see #getCaracteristicasLabelList()
     */
    public void setCaracteristicasBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>caracteristicas</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getCaracteristicas()
     * @see #getCaracteristicasBackingList()
     */
    public java.lang.Object[] getCaracteristicasValueList();

    /**
     * The <code>caracteristicas</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getCaracteristicas()
     * @see #getCaracteristicasBackingList()
     */
    public void setCaracteristicasValueList(java.lang.Object[] caracteristicasValueList);

    /**
     * The <code>caracteristicas</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getCaracteristicas()
     * @see #getCaracteristicasBackingList()
     */
    public java.lang.Object[] getCaracteristicasLabelList();

    /**
     * The <code>caracteristicas</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getCaracteristicas()
     * @see #getCaracteristicasBackingList()
     */
    public void setCaracteristicasLabelList(java.lang.Object[] caracteristicasLabelList);

    /**
     * Sets the <code>comboCaractDimension</code> field.
     *
     * 
     */
    public void setComboCaractDimension(java.lang.String comboCaractDimension);

    /**
     * Gets the <code>comboCaractDimension</code> field.
     *
     * 
     */
    public java.lang.String getComboCaractDimension();
    
    /**
     * Resets the <code>comboCaractDimension</code> field.
     */
    public void resetComboCaractDimension();

    /**
     * The <code>comboCaractDimension</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboCaractDimension()
     * @see #getComboCaractDimensionValueList()
     * @see #getComboCaractDimensionLabelList()
     * @see #setComboCaractDimensionLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboCaractDimensionBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboCaractDimension property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboCaractDimension backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboCaractDimensionBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboCaractDimension()
     * @see #getComboCaractDimensionValueList()
     * @see #getComboCaractDimensionLabelList()
     * @see #getComboCaractDimensionLabelList()
     */
    public void setComboCaractDimensionBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboCaractDimension</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboCaractDimension()
     * @see #getComboCaractDimensionBackingList()
     */
    public java.lang.Object[] getComboCaractDimensionValueList();

    /**
     * The <code>comboCaractDimension</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboCaractDimension()
     * @see #getComboCaractDimensionBackingList()
     */
    public void setComboCaractDimensionValueList(java.lang.Object[] comboCaractDimensionValueList);

    /**
     * The <code>comboCaractDimension</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboCaractDimension()
     * @see #getComboCaractDimensionBackingList()
     */
    public java.lang.Object[] getComboCaractDimensionLabelList();

    /**
     * The <code>comboCaractDimension</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboCaractDimension()
     * @see #getComboCaractDimensionBackingList()
     */
    public void setComboCaractDimensionLabelList(java.lang.Object[] comboCaractDimensionLabelList);

    /**
     * Sets the <code>comboCaractColor</code> field.
     *
     * 
     */
    public void setComboCaractColor(java.lang.String comboCaractColor);

    /**
     * Gets the <code>comboCaractColor</code> field.
     *
     * 
     */
    public java.lang.String getComboCaractColor();
    
    /**
     * Resets the <code>comboCaractColor</code> field.
     */
    public void resetComboCaractColor();

    /**
     * The <code>comboCaractColor</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComboCaractColor()
     * @see #getComboCaractColorValueList()
     * @see #getComboCaractColorLabelList()
     * @see #setComboCaractColorLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComboCaractColorBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comboCaractColor property. This method takes a collection of objects, as well as
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
     * But you need to populate the comboCaractColor backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComboCaractColorBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComboCaractColor()
     * @see #getComboCaractColorValueList()
     * @see #getComboCaractColorLabelList()
     * @see #getComboCaractColorLabelList()
     */
    public void setComboCaractColorBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comboCaractColor</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComboCaractColor()
     * @see #getComboCaractColorBackingList()
     */
    public java.lang.Object[] getComboCaractColorValueList();

    /**
     * The <code>comboCaractColor</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComboCaractColor()
     * @see #getComboCaractColorBackingList()
     */
    public void setComboCaractColorValueList(java.lang.Object[] comboCaractColorValueList);

    /**
     * The <code>comboCaractColor</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComboCaractColor()
     * @see #getComboCaractColorBackingList()
     */
    public java.lang.Object[] getComboCaractColorLabelList();

    /**
     * The <code>comboCaractColor</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComboCaractColor()
     * @see #getComboCaractColorBackingList()
     */
    public void setComboCaractColorLabelList(java.lang.Object[] comboCaractColorLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTitulos#sArray(Object[])
     */
    public void setTitulos(java.util.Collection titulos);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTitulos#sArray()
     */
    public java.util.Collection getTitulos();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTitulos(java.util.Collection)
     */
    public void setTitulosAsArray(Object[] titulos);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTitulos()
     */
    public java.lang.Object[] getTitulosAsArray();

    /**
     * Resets the <code>titulos</code> field.
     */
    public void resetTitulos();

    /**
     * The <code>titulos</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getTitulos()
     * @see #getTitulosValueList()
     * @see #getTitulosLabelList()
     * @see #setTitulosLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getTitulosBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * titulos property. This method takes a collection of objects, as well as
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
     * But you need to populate the titulos backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setTitulosBackingList(valueObjects, "id", "name")</code>
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
     * @see #getTitulos()
     * @see #getTitulosValueList()
     * @see #getTitulosLabelList()
     * @see #getTitulosLabelList()
     */
    public void setTitulosBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>titulos</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getTitulos()
     * @see #getTitulosBackingList()
     */
    public java.lang.Object[] getTitulosValueList();

    /**
     * The <code>titulos</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getTitulos()
     * @see #getTitulosBackingList()
     */
    public void setTitulosValueList(java.lang.Object[] titulosValueList);

    /**
     * The <code>titulos</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getTitulos()
     * @see #getTitulosBackingList()
     */
    public java.lang.Object[] getTitulosLabelList();

    /**
     * The <code>titulos</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getTitulos()
     * @see #getTitulosBackingList()
     */
    public void setTitulosLabelList(java.lang.Object[] titulosLabelList);

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

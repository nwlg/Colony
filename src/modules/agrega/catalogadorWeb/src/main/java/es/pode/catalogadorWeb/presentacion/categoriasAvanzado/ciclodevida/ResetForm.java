// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>reset</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CiclodevidaController#reset
 */
public interface ResetForm
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

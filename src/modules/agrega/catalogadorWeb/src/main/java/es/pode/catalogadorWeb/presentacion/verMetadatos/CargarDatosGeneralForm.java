// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarDatosGeneral</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.verMetadatos.VerMetadatosController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.verMetadatos.VerMetadatosController#cargarDatosGeneral
 */
public interface CargarDatosGeneralForm
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

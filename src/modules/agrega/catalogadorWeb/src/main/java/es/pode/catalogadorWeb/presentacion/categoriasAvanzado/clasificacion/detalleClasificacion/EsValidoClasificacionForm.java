// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>esValidoClasificacion</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.DetalleClasificacionController#esValidoClasificacion
 */
public interface EsValidoClasificacionForm
{
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
     * Sets the <code>source</code> field.
     *
     * 
     */
    public void setSource(java.lang.String source);

    /**
     * Gets the <code>source</code> field.
     *
     * 
     */
    public java.lang.String getSource();
    
    /**
     * Resets the <code>source</code> field.
     */
    public void resetSource();

    /**
     * The <code>source</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getSource()
     * @see #getSourceValueList()
     * @see #getSourceLabelList()
     * @see #setSourceLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getSourceBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * source property. This method takes a collection of objects, as well as
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
     * But you need to populate the source backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setSourceBackingList(valueObjects, "id", "name")</code>
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
     * @see #getSource()
     * @see #getSourceValueList()
     * @see #getSourceLabelList()
     * @see #getSourceLabelList()
     */
    public void setSourceBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>source</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getSource()
     * @see #getSourceBackingList()
     */
    public java.lang.Object[] getSourceValueList();

    /**
     * The <code>source</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getSource()
     * @see #getSourceBackingList()
     */
    public void setSourceValueList(java.lang.Object[] sourceValueList);

    /**
     * The <code>source</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getSource()
     * @see #getSourceBackingList()
     */
    public java.lang.Object[] getSourceLabelList();

    /**
     * The <code>source</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getSource()
     * @see #getSourceBackingList()
     */
    public void setSourceLabelList(java.lang.Object[] sourceLabelList);

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
     * Sets the <code>tituloClasificacion</code> field.
     *
     * 
     */
    public void setTituloClasificacion(java.lang.String tituloClasificacion);

    /**
     * Gets the <code>tituloClasificacion</code> field.
     *
     * 
     */
    public java.lang.String getTituloClasificacion();
    
    /**
     * Resets the <code>tituloClasificacion</code> field.
     */
    public void resetTituloClasificacion();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setRutaTaxonomica#sArray(Object[])
     */
    public void setRutaTaxonomica(java.util.Collection rutaTaxonomica);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getRutaTaxonomica#sArray()
     */
    public java.util.Collection getRutaTaxonomica();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setRutaTaxonomica(java.util.Collection)
     */
    public void setRutaTaxonomicaAsArray(Object[] rutaTaxonomica);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getRutaTaxonomica()
     */
    public java.lang.Object[] getRutaTaxonomicaAsArray();

    /**
     * Resets the <code>rutaTaxonomica</code> field.
     */
    public void resetRutaTaxonomica();

    /**
     * The <code>rutaTaxonomica</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getRutaTaxonomica()
     * @see #getRutaTaxonomicaValueList()
     * @see #getRutaTaxonomicaLabelList()
     * @see #setRutaTaxonomicaLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getRutaTaxonomicaBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * rutaTaxonomica property. This method takes a collection of objects, as well as
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
     * But you need to populate the rutaTaxonomica backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setRutaTaxonomicaBackingList(valueObjects, "id", "name")</code>
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
     * @see #getRutaTaxonomica()
     * @see #getRutaTaxonomicaValueList()
     * @see #getRutaTaxonomicaLabelList()
     * @see #getRutaTaxonomicaLabelList()
     */
    public void setRutaTaxonomicaBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>rutaTaxonomica</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getRutaTaxonomica()
     * @see #getRutaTaxonomicaBackingList()
     */
    public java.lang.Object[] getRutaTaxonomicaValueList();

    /**
     * The <code>rutaTaxonomica</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getRutaTaxonomica()
     * @see #getRutaTaxonomicaBackingList()
     */
    public void setRutaTaxonomicaValueList(java.lang.Object[] rutaTaxonomicaValueList);

    /**
     * The <code>rutaTaxonomica</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getRutaTaxonomica()
     * @see #getRutaTaxonomicaBackingList()
     */
    public java.lang.Object[] getRutaTaxonomicaLabelList();

    /**
     * The <code>rutaTaxonomica</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getRutaTaxonomica()
     * @see #getRutaTaxonomicaBackingList()
     */
    public void setRutaTaxonomicaLabelList(java.lang.Object[] rutaTaxonomicaLabelList);

    /**
     * Sets the <code>razon</code> field.
     *
     * 
     */
    public void setRazon(java.lang.String razon);

    /**
     * Gets the <code>razon</code> field.
     *
     * 
     */
    public java.lang.String getRazon();
    
    /**
     * Resets the <code>razon</code> field.
     */
    public void resetRazon();

    /**
     * The <code>razon</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getRazon()
     * @see #getRazonValueList()
     * @see #getRazonLabelList()
     * @see #setRazonLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getRazonBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * razon property. This method takes a collection of objects, as well as
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
     * But you need to populate the razon backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setRazonBackingList(valueObjects, "id", "name")</code>
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
     * @see #getRazon()
     * @see #getRazonValueList()
     * @see #getRazonLabelList()
     * @see #getRazonLabelList()
     */
    public void setRazonBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>razon</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getRazon()
     * @see #getRazonBackingList()
     */
    public java.lang.Object[] getRazonValueList();

    /**
     * The <code>razon</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getRazon()
     * @see #getRazonBackingList()
     */
    public void setRazonValueList(java.lang.Object[] razonValueList);

    /**
     * The <code>razon</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getRazon()
     * @see #getRazonBackingList()
     */
    public java.lang.Object[] getRazonLabelList();

    /**
     * The <code>razon</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getRazon()
     * @see #getRazonBackingList()
     */
    public void setRazonLabelList(java.lang.Object[] razonLabelList);

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

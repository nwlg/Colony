// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.tesauros;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cambiarJerarquiaSesion</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.tesauros.TesaurosController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.tesauros.TesaurosController#cambiarJerarquiaSesion
 */
public interface CambiarJerarquiaSesionForm
{
    /**
     * Sets the <code>id</code> field.
     *
     * 
     */
    public void setId(java.lang.String id);

    /**
     * Gets the <code>id</code> field.
     *
     * 
     */
    public java.lang.String getId();
    
    /**
     * Resets the <code>id</code> field.
     */
    public void resetId();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setRutaPadrevo#sArray(Object[])
     */
    public void setRutaPadrevo(java.util.Collection rutaPadrevo);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getRutaPadrevo#sArray()
     */
    public java.util.Collection getRutaPadrevo();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setRutaPadrevo(java.util.Collection)
     */
    public void setRutaPadrevoAsArray(Object[] rutaPadrevo);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getRutaPadrevo()
     */
    public java.lang.Object[] getRutaPadrevoAsArray();

    /**
     * Resets the <code>rutaPadrevo</code> field.
     */
    public void resetRutaPadrevo();

    /**
     * The <code>rutaPadrevo</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getRutaPadrevo()
     * @see #getRutaPadrevoValueList()
     * @see #getRutaPadrevoLabelList()
     * @see #setRutaPadrevoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getRutaPadrevoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * rutaPadrevo property. This method takes a collection of objects, as well as
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
     * But you need to populate the rutaPadrevo backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setRutaPadrevoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getRutaPadrevo()
     * @see #getRutaPadrevoValueList()
     * @see #getRutaPadrevoLabelList()
     * @see #getRutaPadrevoLabelList()
     */
    public void setRutaPadrevoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>rutaPadrevo</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getRutaPadrevo()
     * @see #getRutaPadrevoBackingList()
     */
    public java.lang.Object[] getRutaPadrevoValueList();

    /**
     * The <code>rutaPadrevo</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getRutaPadrevo()
     * @see #getRutaPadrevoBackingList()
     */
    public void setRutaPadrevoValueList(java.lang.Object[] rutaPadrevoValueList);

    /**
     * The <code>rutaPadrevo</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getRutaPadrevo()
     * @see #getRutaPadrevoBackingList()
     */
    public java.lang.Object[] getRutaPadrevoLabelList();

    /**
     * The <code>rutaPadrevo</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getRutaPadrevo()
     * @see #getRutaPadrevoBackingList()
     */
    public void setRutaPadrevoLabelList(java.lang.Object[] rutaPadrevoLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setJerarquias#sArray(Object[])
     */
    public void setJerarquias(java.util.Collection jerarquias);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getJerarquias#sArray()
     */
    public java.util.Collection getJerarquias();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setJerarquias(java.util.Collection)
     */
    public void setJerarquiasAsArray(Object[] jerarquias);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getJerarquias()
     */
    public java.lang.Object[] getJerarquiasAsArray();

    /**
     * Resets the <code>jerarquias</code> field.
     */
    public void resetJerarquias();

    /**
     * The <code>jerarquias</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getJerarquias()
     * @see #getJerarquiasValueList()
     * @see #getJerarquiasLabelList()
     * @see #setJerarquiasLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getJerarquiasBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * jerarquias property. This method takes a collection of objects, as well as
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
     * But you need to populate the jerarquias backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setJerarquiasBackingList(valueObjects, "id", "name")</code>
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
     * @see #getJerarquias()
     * @see #getJerarquiasValueList()
     * @see #getJerarquiasLabelList()
     * @see #getJerarquiasLabelList()
     */
    public void setJerarquiasBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>jerarquias</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getJerarquias()
     * @see #getJerarquiasBackingList()
     */
    public java.lang.Object[] getJerarquiasValueList();

    /**
     * The <code>jerarquias</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getJerarquias()
     * @see #getJerarquiasBackingList()
     */
    public void setJerarquiasValueList(java.lang.Object[] jerarquiasValueList);

    /**
     * The <code>jerarquias</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getJerarquias()
     * @see #getJerarquiasBackingList()
     */
    public java.lang.Object[] getJerarquiasLabelList();

    /**
     * The <code>jerarquias</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getJerarquias()
     * @see #getJerarquiasBackingList()
     */
    public void setJerarquiasLabelList(java.lang.Object[] jerarquiasLabelList);

    /**
     * Sets the <code>idioma</code> field.
     *
     * 
     */
    public void setIdioma(java.lang.String idioma);

    /**
     * Gets the <code>idioma</code> field.
     *
     * 
     */
    public java.lang.String getIdioma();
    
    /**
     * Resets the <code>idioma</code> field.
     */
    public void resetIdioma();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTaxonesvo#sArray(Object[])
     */
    public void setTaxonesvo(java.util.Collection taxonesvo);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTaxonesvo#sArray()
     */
    public java.util.Collection getTaxonesvo();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTaxonesvo(java.util.Collection)
     */
    public void setTaxonesvoAsArray(Object[] taxonesvo);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTaxonesvo()
     */
    public java.lang.Object[] getTaxonesvoAsArray();

    /**
     * Resets the <code>taxonesvo</code> field.
     */
    public void resetTaxonesvo();

    /**
     * The <code>taxonesvo</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getTaxonesvo()
     * @see #getTaxonesvoValueList()
     * @see #getTaxonesvoLabelList()
     * @see #setTaxonesvoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getTaxonesvoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * taxonesvo property. This method takes a collection of objects, as well as
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
     * But you need to populate the taxonesvo backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setTaxonesvoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getTaxonesvo()
     * @see #getTaxonesvoValueList()
     * @see #getTaxonesvoLabelList()
     * @see #getTaxonesvoLabelList()
     */
    public void setTaxonesvoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>taxonesvo</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getTaxonesvo()
     * @see #getTaxonesvoBackingList()
     */
    public java.lang.Object[] getTaxonesvoValueList();

    /**
     * The <code>taxonesvo</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getTaxonesvo()
     * @see #getTaxonesvoBackingList()
     */
    public void setTaxonesvoValueList(java.lang.Object[] taxonesvoValueList);

    /**
     * The <code>taxonesvo</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getTaxonesvo()
     * @see #getTaxonesvoBackingList()
     */
    public java.lang.Object[] getTaxonesvoLabelList();

    /**
     * The <code>taxonesvo</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getTaxonesvo()
     * @see #getTaxonesvoBackingList()
     */
    public void setTaxonesvoLabelList(java.lang.Object[] taxonesvoLabelList);

    /**
     * Sets the <code>nomTesauro</code> field.
     *
     * 
     */
    public void setNomTesauro(java.lang.String nomTesauro);

    /**
     * Gets the <code>nomTesauro</code> field.
     *
     * 
     */
    public java.lang.String getNomTesauro();
    
    /**
     * Resets the <code>nomTesauro</code> field.
     */
    public void resetNomTesauro();

}

// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.tesauros;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>buscarTerminos</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.avanzado.tesauros.TesaurosController</code> controller.
 *
 * <p>
 * Método que se encarga de realizar la búsqueda de los términos
 * del tesauro relacionados con el valor a buscar que se introduce
 * en la caja de texto
 * </p>
 *
 * @see es.pode.buscador.presentacion.avanzado.tesauros.TesaurosController#buscarTerminos
 */
public interface BuscarTerminosForm
{
    /**
     * Sets the <code>esRuta</code> field.
     *
     * 
     */
    public void setEsRuta(boolean esRuta);

    /**
     * Gets the <code>esRuta</code> field.
     *
     * 
     */
    public boolean isEsRuta();
    
    /**
     * Resets the <code>esRuta</code> field.
     */
    public void resetEsRuta();

    /**
     * Sets the <code>nomTesauros</code> field.
     *
     * 
     */
    public void setNomTesauros(java.lang.String nomTesauros);

    /**
     * Gets the <code>nomTesauros</code> field.
     *
     * 
     */
    public java.lang.String getNomTesauros();
    
    /**
     * Resets the <code>nomTesauros</code> field.
     */
    public void resetNomTesauros();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTaxonesVO#sArray(Object[])
     */
    public void setTaxonesVO(java.util.Collection taxonesVO);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTaxonesVO#sArray()
     */
    public java.util.Collection getTaxonesVO();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTaxonesVO(java.util.Collection)
     */
    public void setTaxonesVOAsArray(Object[] taxonesVO);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTaxonesVO()
     */
    public java.lang.Object[] getTaxonesVOAsArray();

    /**
     * Resets the <code>taxonesVO</code> field.
     */
    public void resetTaxonesVO();

    /**
     * The <code>taxonesVO</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getTaxonesVO()
     * @see #getTaxonesVOValueList()
     * @see #getTaxonesVOLabelList()
     * @see #setTaxonesVOLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getTaxonesVOBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * taxonesVO property. This method takes a collection of objects, as well as
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
     * But you need to populate the taxonesVO backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setTaxonesVOBackingList(valueObjects, "id", "name")</code>
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
     * @see #getTaxonesVO()
     * @see #getTaxonesVOValueList()
     * @see #getTaxonesVOLabelList()
     * @see #getTaxonesVOLabelList()
     */
    public void setTaxonesVOBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>taxonesVO</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getTaxonesVO()
     * @see #getTaxonesVOBackingList()
     */
    public java.lang.Object[] getTaxonesVOValueList();

    /**
     * The <code>taxonesVO</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getTaxonesVO()
     * @see #getTaxonesVOBackingList()
     */
    public void setTaxonesVOValueList(java.lang.Object[] taxonesVOValueList);

    /**
     * The <code>taxonesVO</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getTaxonesVO()
     * @see #getTaxonesVOBackingList()
     */
    public java.lang.Object[] getTaxonesVOLabelList();

    /**
     * The <code>taxonesVO</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getTaxonesVO()
     * @see #getTaxonesVOBackingList()
     */
    public void setTaxonesVOLabelList(java.lang.Object[] taxonesVOLabelList);

    /**
     * Sets the <code>tituloTesauro</code> field.
     *
     * 
     */
    public void setTituloTesauro(java.lang.String tituloTesauro);

    /**
     * Gets the <code>tituloTesauro</code> field.
     *
     * 
     */
    public java.lang.String getTituloTesauro();
    
    /**
     * Resets the <code>tituloTesauro</code> field.
     */
    public void resetTituloTesauro();

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
     * Sets the <code>textoBusqueda</code> field.
     *
     * 
     */
    public void setTextoBusqueda(java.lang.String textoBusqueda);

    /**
     * Gets the <code>textoBusqueda</code> field.
     *
     * 
     */
    public java.lang.String getTextoBusqueda();
    
    /**
     * Resets the <code>textoBusqueda</code> field.
     */
    public void resetTextoBusqueda();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setRutaPadreVO#sArray(Object[])
     */
    public void setRutaPadreVO(java.util.Collection rutaPadreVO);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getRutaPadreVO#sArray()
     */
    public java.util.Collection getRutaPadreVO();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setRutaPadreVO(java.util.Collection)
     */
    public void setRutaPadreVOAsArray(Object[] rutaPadreVO);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getRutaPadreVO()
     */
    public java.lang.Object[] getRutaPadreVOAsArray();

    /**
     * Resets the <code>rutaPadreVO</code> field.
     */
    public void resetRutaPadreVO();

    /**
     * The <code>rutaPadreVO</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getRutaPadreVO()
     * @see #getRutaPadreVOValueList()
     * @see #getRutaPadreVOLabelList()
     * @see #setRutaPadreVOLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getRutaPadreVOBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * rutaPadreVO property. This method takes a collection of objects, as well as
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
     * But you need to populate the rutaPadreVO backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setRutaPadreVOBackingList(valueObjects, "id", "name")</code>
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
     * @see #getRutaPadreVO()
     * @see #getRutaPadreVOValueList()
     * @see #getRutaPadreVOLabelList()
     * @see #getRutaPadreVOLabelList()
     */
    public void setRutaPadreVOBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>rutaPadreVO</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getRutaPadreVO()
     * @see #getRutaPadreVOBackingList()
     */
    public java.lang.Object[] getRutaPadreVOValueList();

    /**
     * The <code>rutaPadreVO</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getRutaPadreVO()
     * @see #getRutaPadreVOBackingList()
     */
    public void setRutaPadreVOValueList(java.lang.Object[] rutaPadreVOValueList);

    /**
     * The <code>rutaPadreVO</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getRutaPadreVO()
     * @see #getRutaPadreVOBackingList()
     */
    public java.lang.Object[] getRutaPadreVOLabelList();

    /**
     * The <code>rutaPadreVO</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getRutaPadreVO()
     * @see #getRutaPadreVOBackingList()
     */
    public void setRutaPadreVOLabelList(java.lang.Object[] rutaPadreVOLabelList);

    /**
     * Sets the <code>idTesauro</code> field.
     *
     * 
     */
    public void setIdTesauro(java.lang.String idTesauro);

    /**
     * Gets the <code>idTesauro</code> field.
     *
     * 
     */
    public java.lang.String getIdTesauro();
    
    /**
     * Resets the <code>idTesauro</code> field.
     */
    public void resetIdTesauro();

}

// license-header java merge-point
package es.pode.administracion.presentacion.categorias.modificarCategoriaNoticia;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>validarFormulario</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.categorias.modificarCategoriaNoticia.ModificarCategoriaNoticiaController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.categorias.modificarCategoriaNoticia.ModificarCategoriaNoticiaController#validarFormulario
 */
public interface ValidarFormularioForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setNombreCategoria#sArray(Object[])
     */
    public void setNombreCategoria(java.util.Collection nombreCategoria);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getNombreCategoria#sArray()
     */
    public java.util.Collection getNombreCategoria();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setNombreCategoria(java.util.Collection)
     */
    public void setNombreCategoriaAsArray(Object[] nombreCategoria);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getNombreCategoria()
     */
    public java.lang.Object[] getNombreCategoriaAsArray();

    /**
     * Resets the <code>nombreCategoria</code> field.
     */
    public void resetNombreCategoria();

    /**
     * The <code>nombreCategoria</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getNombreCategoria()
     * @see #getNombreCategoriaValueList()
     * @see #getNombreCategoriaLabelList()
     * @see #setNombreCategoriaLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getNombreCategoriaBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * nombreCategoria property. This method takes a collection of objects, as well as
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
     * But you need to populate the nombreCategoria backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setNombreCategoriaBackingList(valueObjects, "id", "name")</code>
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
     * @see #getNombreCategoria()
     * @see #getNombreCategoriaValueList()
     * @see #getNombreCategoriaLabelList()
     * @see #getNombreCategoriaLabelList()
     */
    public void setNombreCategoriaBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>nombreCategoria</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getNombreCategoria()
     * @see #getNombreCategoriaBackingList()
     */
    public java.lang.Object[] getNombreCategoriaValueList();

    /**
     * The <code>nombreCategoria</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getNombreCategoria()
     * @see #getNombreCategoriaBackingList()
     */
    public void setNombreCategoriaValueList(java.lang.Object[] nombreCategoriaValueList);

    /**
     * The <code>nombreCategoria</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getNombreCategoria()
     * @see #getNombreCategoriaBackingList()
     */
    public java.lang.Object[] getNombreCategoriaLabelList();

    /**
     * The <code>nombreCategoria</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getNombreCategoria()
     * @see #getNombreCategoriaBackingList()
     */
    public void setNombreCategoriaLabelList(java.lang.Object[] nombreCategoriaLabelList);

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
     * Sets the <code>idCategoriaNoticia</code> field.
     *
     * 
     */
    public void setIdCategoriaNoticia(java.lang.Long idCategoriaNoticia);

    /**
     * Gets the <code>idCategoriaNoticia</code> field.
     *
     * 
     */
    public java.lang.Long getIdCategoriaNoticia();
    
    /**
     * Resets the <code>idCategoriaNoticia</code> field.
     */
    public void resetIdCategoriaNoticia();

    /**
     * Sets the <code>valido</code> field.
     *
     * 
     */
    public void setValido(java.lang.String valido);

    /**
     * Gets the <code>valido</code> field.
     *
     * 
     */
    public java.lang.String getValido();
    
    /**
     * Resets the <code>valido</code> field.
     */
    public void resetValido();

}

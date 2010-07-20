// license-header java merge-point
package es.pode.visualizador.presentacion.agregaSlider;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>construirCodigo</code> method, which is located on the
 * <code>es.pode.visualizador.presentacion.agregaSlider.AgregaSliderController</code> controller.
 *
 * 
 *
 * @see es.pode.visualizador.presentacion.agregaSlider.AgregaSliderController#construirCodigo
 */
public interface ConstruirCodigoForm
{
    /**
     * Sets the <code>codigo</code> field.
     *
     * 
     */
    public void setCodigo(java.lang.String codigo);

    /**
     * Gets the <code>codigo</code> field.
     *
     * 
     */
    public java.lang.String getCodigo();
    
    /**
     * Resets the <code>codigo</code> field.
     */
    public void resetCodigo();

    /**
     * Sets the <code>keywords</code> field.
     *
     * 
     */
    public void setKeywords(java.lang.String keywords);

    /**
     * Gets the <code>keywords</code> field.
     *
     * 
     */
    public java.lang.String getKeywords();
    
    /**
     * Resets the <code>keywords</code> field.
     */
    public void resetKeywords();

    /**
     * Sets the <code>idiomasCombo</code> field.
     *
     * 
     */
    public void setIdiomasCombo(java.lang.String idiomasCombo);

    /**
     * Gets the <code>idiomasCombo</code> field.
     *
     * 
     */
    public java.lang.String getIdiomasCombo();
    
    /**
     * Resets the <code>idiomasCombo</code> field.
     */
    public void resetIdiomasCombo();

    /**
     * The <code>idiomasCombo</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getIdiomasCombo()
     * @see #getIdiomasComboValueList()
     * @see #getIdiomasComboLabelList()
     * @see #setIdiomasComboLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getIdiomasComboBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * idiomasCombo property. This method takes a collection of objects, as well as
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
     * But you need to populate the idiomasCombo backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setIdiomasComboBackingList(valueObjects, "id", "name")</code>
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
     * @see #getIdiomasCombo()
     * @see #getIdiomasComboValueList()
     * @see #getIdiomasComboLabelList()
     * @see #getIdiomasComboLabelList()
     */
    public void setIdiomasComboBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>idiomasCombo</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getIdiomasCombo()
     * @see #getIdiomasComboBackingList()
     */
    public java.lang.Object[] getIdiomasComboValueList();

    /**
     * The <code>idiomasCombo</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getIdiomasCombo()
     * @see #getIdiomasComboBackingList()
     */
    public void setIdiomasComboValueList(java.lang.Object[] idiomasComboValueList);

    /**
     * The <code>idiomasCombo</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getIdiomasCombo()
     * @see #getIdiomasComboBackingList()
     */
    public java.lang.Object[] getIdiomasComboLabelList();

    /**
     * The <code>idiomasCombo</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getIdiomasCombo()
     * @see #getIdiomasComboBackingList()
     */
    public void setIdiomasComboLabelList(java.lang.Object[] idiomasComboLabelList);

}

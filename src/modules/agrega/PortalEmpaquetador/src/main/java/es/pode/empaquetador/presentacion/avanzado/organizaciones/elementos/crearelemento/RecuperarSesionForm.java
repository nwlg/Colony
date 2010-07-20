// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarSesion</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoController#recuperarSesion
 */
public interface RecuperarSesionForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTimeLimit#sArray(Object[])
     */
    public void setTimeLimit(java.util.Collection timeLimit);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTimeLimit#sArray()
     */
    public java.util.Collection getTimeLimit();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTimeLimit(java.util.Collection)
     */
    public void setTimeLimitAsArray(Object[] timeLimit);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTimeLimit()
     */
    public java.lang.Object[] getTimeLimitAsArray();

    /**
     * Resets the <code>timeLimit</code> field.
     */
    public void resetTimeLimit();

    /**
     * Sets the <code>title</code> field.
     *
     * 
     */
    public void setTitle(java.lang.String title);

    /**
     * Gets the <code>title</code> field.
     *
     * 
     */
    public java.lang.String getTitle();
    
    /**
     * Resets the <code>title</code> field.
     */
    public void resetTitle();

    /**
     * Sets the <code>completionThreshold</code> field.
     *
     * 
     */
    public void setCompletionThreshold(java.lang.String completionThreshold);

    /**
     * Gets the <code>completionThreshold</code> field.
     *
     * 
     */
    public java.lang.String getCompletionThreshold();
    
    /**
     * Resets the <code>completionThreshold</code> field.
     */
    public void resetCompletionThreshold();

    /**
     * Sets the <code>isVisible</code> field.
     *
     * 
     */
    public void setIsVisible(java.lang.Boolean isVisible);

    /**
     * Gets the <code>isVisible</code> field.
     *
     * 
     */
    public java.lang.Boolean getIsVisible();
    
    /**
     * Resets the <code>isVisible</code> field.
     */
    public void resetIsVisible();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setPresentation#sArray(Object[])
     */
    public void setPresentation(java.util.Collection presentation);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getPresentation#sArray()
     */
    public java.util.Collection getPresentation();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setPresentation(java.util.Collection)
     */
    public void setPresentationAsArray(Object[] presentation);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getPresentation()
     */
    public java.lang.Object[] getPresentationAsArray();

    /**
     * Resets the <code>presentation</code> field.
     */
    public void resetPresentation();

    /**
     * Sets the <code>selectPresentation</code> field.
     *
     * 
     */
    public void setSelectPresentation(java.lang.String[] selectPresentation);

    /**
     * Gets the <code>selectPresentation</code> field.
     *
     * 
     */
    public java.lang.String[] getSelectPresentation();
    
    /**
     * Resets the <code>selectPresentation</code> field.
     */
    public void resetSelectPresentation();

    /**
     * The <code>selectPresentation</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getSelectPresentation()
     * @see #getSelectPresentationValueList()
     * @see #getSelectPresentationLabelList()
     * @see #setSelectPresentationLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getSelectPresentationBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * selectPresentation property. This method takes a collection of objects, as well as
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
     * But you need to populate the selectPresentation backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setSelectPresentationBackingList(valueObjects, "id", "name")</code>
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
     * @see #getSelectPresentation()
     * @see #getSelectPresentationValueList()
     * @see #getSelectPresentationLabelList()
     * @see #getSelectPresentationLabelList()
     */
    public void setSelectPresentationBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>selectPresentation</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getSelectPresentation()
     * @see #getSelectPresentationBackingList()
     */
    public java.lang.Object[] getSelectPresentationValueList();

    /**
     * The <code>selectPresentation</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getSelectPresentation()
     * @see #getSelectPresentationBackingList()
     */
    public void setSelectPresentationValueList(java.lang.Object[] selectPresentationValueList);

    /**
     * The <code>selectPresentation</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getSelectPresentation()
     * @see #getSelectPresentationBackingList()
     */
    public java.lang.Object[] getSelectPresentationLabelList();

    /**
     * The <code>selectPresentation</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getSelectPresentation()
     * @see #getSelectPresentationBackingList()
     */
    public void setSelectPresentationLabelList(java.lang.Object[] selectPresentationLabelList);

    /**
     * Sets the <code>referenciado</code> field.
     *
     * 
     */
    public void setReferenciado(java.lang.String referenciado);

    /**
     * Gets the <code>referenciado</code> field.
     *
     * 
     */
    public java.lang.String getReferenciado();
    
    /**
     * Resets the <code>referenciado</code> field.
     */
    public void resetReferenciado();

    /**
     * Sets the <code>timeLimitAction</code> field.
     *
     * 
     */
    public void setTimeLimitAction(java.lang.String timeLimitAction);

    /**
     * Gets the <code>timeLimitAction</code> field.
     *
     * 
     */
    public java.lang.String getTimeLimitAction();
    
    /**
     * Resets the <code>timeLimitAction</code> field.
     */
    public void resetTimeLimitAction();

    /**
     * Sets the <code>dataFromLMS</code> field.
     *
     * 
     */
    public void setDataFromLMS(java.lang.String dataFromLMS);

    /**
     * Gets the <code>dataFromLMS</code> field.
     *
     * 
     */
    public java.lang.String getDataFromLMS();
    
    /**
     * Resets the <code>dataFromLMS</code> field.
     */
    public void resetDataFromLMS();

}

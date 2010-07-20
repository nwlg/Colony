// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.modificar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>selectAction</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.configurar.cambios.modificar.ModificarTerminoController</code> controller.
 *
 * 
 *
 * @see es.pode.modificador.presentacion.configurar.cambios.modificar.ModificarTerminoController#selectAction
 */
public interface SelectActionForm
{
    /**
     * Sets the <code>alcanceTermino</code> field.
     *
     * 
     */
    public void setAlcanceTermino(java.lang.String alcanceTermino);

    /**
     * Gets the <code>alcanceTermino</code> field.
     *
     * 
     */
    public java.lang.String getAlcanceTermino();
    
    /**
     * Resets the <code>alcanceTermino</code> field.
     */
    public void resetAlcanceTermino();

    /**
     * Sets the <code>alcanceMetadatos</code> field.
     *
     * 
     */
    public void setAlcanceMetadatos(java.lang.String alcanceMetadatos);

    /**
     * Gets the <code>alcanceMetadatos</code> field.
     *
     * 
     */
    public java.lang.String getAlcanceMetadatos();
    
    /**
     * Resets the <code>alcanceMetadatos</code> field.
     */
    public void resetAlcanceMetadatos();

    /**
     * Sets the <code>action</code> field.
     *
     * 
     */
    public void setAction(java.lang.String action);

    /**
     * Gets the <code>action</code> field.
     *
     * 
     */
    public java.lang.String getAction();
    
    /**
     * Resets the <code>action</code> field.
     */
    public void resetAction();

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
     * Sets the <code>valorViejo</code> field.
     *
     * 
     */
    public void setValorViejo(java.lang.String valorViejo);

    /**
     * Gets the <code>valorViejo</code> field.
     *
     * 
     */
    public java.lang.String getValorViejo();
    
    /**
     * Resets the <code>valorViejo</code> field.
     */
    public void resetValorViejo();

    /**
     * Sets the <code>valorNuevo</code> field.
     *
     * 
     */
    public void setValorNuevo(java.lang.String valorNuevo);

    /**
     * Gets the <code>valorNuevo</code> field.
     *
     * 
     */
    public java.lang.String getValorNuevo();
    
    /**
     * Resets the <code>valorNuevo</code> field.
     */
    public void resetValorNuevo();

    /**
     * The <code>valorNuevo</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getValorNuevo()
     * @see #getValorNuevoValueList()
     * @see #getValorNuevoLabelList()
     * @see #setValorNuevoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getValorNuevoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * valorNuevo property. This method takes a collection of objects, as well as
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
     * But you need to populate the valorNuevo backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setValorNuevoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getValorNuevo()
     * @see #getValorNuevoValueList()
     * @see #getValorNuevoLabelList()
     * @see #getValorNuevoLabelList()
     */
    public void setValorNuevoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>valorNuevo</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getValorNuevo()
     * @see #getValorNuevoBackingList()
     */
    public java.lang.Object[] getValorNuevoValueList();

    /**
     * The <code>valorNuevo</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getValorNuevo()
     * @see #getValorNuevoBackingList()
     */
    public void setValorNuevoValueList(java.lang.Object[] valorNuevoValueList);

    /**
     * The <code>valorNuevo</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getValorNuevo()
     * @see #getValorNuevoBackingList()
     */
    public java.lang.Object[] getValorNuevoLabelList();

    /**
     * The <code>valorNuevo</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getValorNuevo()
     * @see #getValorNuevoBackingList()
     */
    public void setValorNuevoLabelList(java.lang.Object[] valorNuevoLabelList);

    /**
     * Sets the <code>exprReg</code> field.
     *
     * 
     */
    public void setExprReg(java.lang.String exprReg);

    /**
     * Gets the <code>exprReg</code> field.
     *
     * 
     */
    public java.lang.String getExprReg();
    
    /**
     * Resets the <code>exprReg</code> field.
     */
    public void resetExprReg();

}

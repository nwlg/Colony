// license-header java merge-point
package es.pode.modificador.presentacion.configurar.modificacion;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>eliminarCambios</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionController</code> controller.
 *
 * 
 *
 * @see es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionController#eliminarCambios
 */
public interface EliminarCambiosForm
{
    /**
     * Sets the <code>posiciones</code> field.
     *
     * 
     */
    public void setPosiciones(int[] posiciones);

    /**
     * Gets the <code>posiciones</code> field.
     *
     * 
     */
    public int[] getPosiciones();
    
    /**
     * Resets the <code>posiciones</code> field.
     */
    public void resetPosiciones();

    /**
     * The <code>posiciones</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getPosiciones()
     * @see #getPosicionesValueList()
     * @see #getPosicionesLabelList()
     * @see #setPosicionesLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getPosicionesBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * posiciones property. This method takes a collection of objects, as well as
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
     * But you need to populate the posiciones backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setPosicionesBackingList(valueObjects, "id", "name")</code>
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
     * @see #getPosiciones()
     * @see #getPosicionesValueList()
     * @see #getPosicionesLabelList()
     * @see #getPosicionesLabelList()
     */
    public void setPosicionesBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>posiciones</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getPosiciones()
     * @see #getPosicionesBackingList()
     */
    public java.lang.Object[] getPosicionesValueList();

    /**
     * The <code>posiciones</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getPosiciones()
     * @see #getPosicionesBackingList()
     */
    public void setPosicionesValueList(java.lang.Object[] posicionesValueList);

    /**
     * The <code>posiciones</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getPosiciones()
     * @see #getPosicionesBackingList()
     */
    public java.lang.Object[] getPosicionesLabelList();

    /**
     * The <code>posiciones</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getPosiciones()
     * @see #getPosicionesBackingList()
     */
    public void setPosicionesLabelList(java.lang.Object[] posicionesLabelList);

}

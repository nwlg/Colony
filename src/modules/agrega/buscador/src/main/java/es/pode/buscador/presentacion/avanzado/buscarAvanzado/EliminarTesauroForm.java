// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>eliminarTesauro</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController</code> controller.
 *
 * <p>
 * Se elimina del formulario el tesauro para que al recargar el
 * formulario no lo muestre.
 * </p>
 *
 * @see es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController#eliminarTesauro
 */
public interface EliminarTesauroForm
{
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
     * Sets the <code>comunidadesSeleccionadas</code> field.
     *
     * 
     */
    public void setComunidadesSeleccionadas(java.lang.String[] comunidadesSeleccionadas);

    /**
     * Gets the <code>comunidadesSeleccionadas</code> field.
     *
     * 
     */
    public java.lang.String[] getComunidadesSeleccionadas();
    
    /**
     * Resets the <code>comunidadesSeleccionadas</code> field.
     */
    public void resetComunidadesSeleccionadas();

    /**
     * The <code>comunidadesSeleccionadas</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComunidadesSeleccionadas()
     * @see #getComunidadesSeleccionadasValueList()
     * @see #getComunidadesSeleccionadasLabelList()
     * @see #setComunidadesSeleccionadasLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComunidadesSeleccionadasBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comunidadesSeleccionadas property. This method takes a collection of objects, as well as
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
     * But you need to populate the comunidadesSeleccionadas backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComunidadesSeleccionadasBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComunidadesSeleccionadas()
     * @see #getComunidadesSeleccionadasValueList()
     * @see #getComunidadesSeleccionadasLabelList()
     * @see #getComunidadesSeleccionadasLabelList()
     */
    public void setComunidadesSeleccionadasBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comunidadesSeleccionadas</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComunidadesSeleccionadas()
     * @see #getComunidadesSeleccionadasBackingList()
     */
    public java.lang.Object[] getComunidadesSeleccionadasValueList();

    /**
     * The <code>comunidadesSeleccionadas</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComunidadesSeleccionadas()
     * @see #getComunidadesSeleccionadasBackingList()
     */
    public void setComunidadesSeleccionadasValueList(java.lang.Object[] comunidadesSeleccionadasValueList);

    /**
     * The <code>comunidadesSeleccionadas</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComunidadesSeleccionadas()
     * @see #getComunidadesSeleccionadasBackingList()
     */
    public java.lang.Object[] getComunidadesSeleccionadasLabelList();

    /**
     * The <code>comunidadesSeleccionadas</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComunidadesSeleccionadas()
     * @see #getComunidadesSeleccionadasBackingList()
     */
    public void setComunidadesSeleccionadasLabelList(java.lang.Object[] comunidadesSeleccionadasLabelList);

    /**
     * Sets the <code>enlaceComunidadesSeleccionadas</code> field.
     *
     * 
     */
    public void setEnlaceComunidadesSeleccionadas(java.lang.String enlaceComunidadesSeleccionadas);

    /**
     * Gets the <code>enlaceComunidadesSeleccionadas</code> field.
     *
     * 
     */
    public java.lang.String getEnlaceComunidadesSeleccionadas();
    
    /**
     * Resets the <code>enlaceComunidadesSeleccionadas</code> field.
     */
    public void resetEnlaceComunidadesSeleccionadas();

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

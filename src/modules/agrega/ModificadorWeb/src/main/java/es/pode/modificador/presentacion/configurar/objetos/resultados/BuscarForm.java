// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos.resultados;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>buscar</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.configurar.objetos.resultados.ResultadosBuscarObjetoController</code> controller.
 *
 * 
 *
 * @see es.pode.modificador.presentacion.configurar.objetos.resultados.ResultadosBuscarObjetoController#buscar
 */
public interface BuscarForm
{
    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setResultados#sArray(Object[])
     */
    public void setResultados(java.util.List resultados);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getResultados#sArray()
     */
    public java.util.List getResultados();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setResultados(java.util.List)
     */
    public void setResultadosAsArray(Object[] resultados);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getResultados()
     */
    public java.lang.Object[] getResultadosAsArray();

    /**
     * Resets the <code>resultados</code> field.
     */
    public void resetResultados();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setSeleccionados#sArray(Object[])
     */
    public void setSeleccionados(java.util.List seleccionados);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getSeleccionados#sArray()
     */
    public java.util.List getSeleccionados();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setSeleccionados(java.util.List)
     */
    public void setSeleccionadosAsArray(Object[] seleccionados);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getSeleccionados()
     */
    public java.lang.Object[] getSeleccionadosAsArray();

    /**
     * Resets the <code>seleccionados</code> field.
     */
    public void resetSeleccionados();

    /**
     * Sets the <code>idiomaBuscador</code> field.
     *
     * 
     */
    public void setIdiomaBuscador(java.lang.String idiomaBuscador);

    /**
     * Gets the <code>idiomaBuscador</code> field.
     *
     * 
     */
    public java.lang.String getIdiomaBuscador();
    
    /**
     * Resets the <code>idiomaBuscador</code> field.
     */
    public void resetIdiomaBuscador();

    /**
     * The <code>idiomaBuscador</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getIdiomaBuscador()
     * @see #getIdiomaBuscadorValueList()
     * @see #getIdiomaBuscadorLabelList()
     * @see #setIdiomaBuscadorLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getIdiomaBuscadorBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * idiomaBuscador property. This method takes a collection of objects, as well as
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
     * But you need to populate the idiomaBuscador backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setIdiomaBuscadorBackingList(valueObjects, "id", "name")</code>
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
     * @see #getIdiomaBuscador()
     * @see #getIdiomaBuscadorValueList()
     * @see #getIdiomaBuscadorLabelList()
     * @see #getIdiomaBuscadorLabelList()
     */
    public void setIdiomaBuscadorBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>idiomaBuscador</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getIdiomaBuscador()
     * @see #getIdiomaBuscadorBackingList()
     */
    public java.lang.Object[] getIdiomaBuscadorValueList();

    /**
     * The <code>idiomaBuscador</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getIdiomaBuscador()
     * @see #getIdiomaBuscadorBackingList()
     */
    public void setIdiomaBuscadorValueList(java.lang.Object[] idiomaBuscadorValueList);

    /**
     * The <code>idiomaBuscador</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getIdiomaBuscador()
     * @see #getIdiomaBuscadorBackingList()
     */
    public java.lang.Object[] getIdiomaBuscadorLabelList();

    /**
     * The <code>idiomaBuscador</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getIdiomaBuscador()
     * @see #getIdiomaBuscadorBackingList()
     */
    public void setIdiomaBuscadorLabelList(java.lang.Object[] idiomaBuscadorLabelList);

}

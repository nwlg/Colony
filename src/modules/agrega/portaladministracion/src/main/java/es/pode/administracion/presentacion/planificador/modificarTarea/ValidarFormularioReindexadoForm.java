// license-header java merge-point
package es.pode.administracion.presentacion.planificador.modificarTarea;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>validarFormularioReindexado</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaController#validarFormularioReindexado
 */
public interface ValidarFormularioReindexadoForm
{
    /**
     * Sets the <code>repositorio</code> field.
     *
     * 
     */
    public void setRepositorio(java.lang.String repositorio);

    /**
     * Gets the <code>repositorio</code> field.
     *
     * 
     */
    public java.lang.String getRepositorio();
    
    /**
     * Resets the <code>repositorio</code> field.
     */
    public void resetRepositorio();

    /**
     * The <code>repositorio</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getRepositorio()
     * @see #getRepositorioValueList()
     * @see #getRepositorioLabelList()
     * @see #setRepositorioLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getRepositorioBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * repositorio property. This method takes a collection of objects, as well as
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
     * But you need to populate the repositorio backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setRepositorioBackingList(valueObjects, "id", "name")</code>
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
     * @see #getRepositorio()
     * @see #getRepositorioValueList()
     * @see #getRepositorioLabelList()
     * @see #getRepositorioLabelList()
     */
    public void setRepositorioBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>repositorio</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getRepositorio()
     * @see #getRepositorioBackingList()
     */
    public java.lang.Object[] getRepositorioValueList();

    /**
     * The <code>repositorio</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getRepositorio()
     * @see #getRepositorioBackingList()
     */
    public void setRepositorioValueList(java.lang.Object[] repositorioValueList);

    /**
     * The <code>repositorio</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getRepositorio()
     * @see #getRepositorioBackingList()
     */
    public java.lang.Object[] getRepositorioLabelList();

    /**
     * The <code>repositorio</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getRepositorio()
     * @see #getRepositorioBackingList()
     */
    public void setRepositorioLabelList(java.lang.Object[] repositorioLabelList);

}

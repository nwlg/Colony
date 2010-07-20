// license-header java merge-point
package es.pode.administracion.presentacion.catalogacion.bajaCatalogadores;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>bajaCatalogadores</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.catalogacion.bajaCatalogadores.BajaCatalogadoresController</code> controller.
 *
 * <p>
 * elimina los grupos de catalogadores que se han especificado
 * </p>
 *
 * @see es.pode.administracion.presentacion.catalogacion.bajaCatalogadores.BajaCatalogadoresController#bajaCatalogadores
 */
public interface BajaCatalogadoresForm
{
    /**
     * Sets the <code>listaId</code> field.
     *
     * 
     */
    public void setListaId(java.lang.String listaId);

    /**
     * Gets the <code>listaId</code> field.
     *
     * 
     */
    public java.lang.String getListaId();
    
    /**
     * Resets the <code>listaId</code> field.
     */
    public void resetListaId();

    /**
     * Sets the <code>gruposTrabajoBorrados</code> field.
     *
     * 
     */
    public void setGruposTrabajoBorrados(es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO[] gruposTrabajoBorrados);

    /**
     * Gets the <code>gruposTrabajoBorrados</code> field.
     *
     * 
     */
    public es.pode.adminusuarios.negocio.servicios.GrupoTrabajoVO[] getGruposTrabajoBorrados();
    
    /**
     * Resets the <code>gruposTrabajoBorrados</code> field.
     */
    public void resetGruposTrabajoBorrados();

    /**
     * The <code>gruposTrabajoBorrados</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getGruposTrabajoBorrados()
     * @see #getGruposTrabajoBorradosValueList()
     * @see #getGruposTrabajoBorradosLabelList()
     * @see #setGruposTrabajoBorradosLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getGruposTrabajoBorradosBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * gruposTrabajoBorrados property. This method takes a collection of objects, as well as
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
     * But you need to populate the gruposTrabajoBorrados backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setGruposTrabajoBorradosBackingList(valueObjects, "id", "name")</code>
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
     * @see #getGruposTrabajoBorrados()
     * @see #getGruposTrabajoBorradosValueList()
     * @see #getGruposTrabajoBorradosLabelList()
     * @see #getGruposTrabajoBorradosLabelList()
     */
    public void setGruposTrabajoBorradosBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>gruposTrabajoBorrados</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getGruposTrabajoBorrados()
     * @see #getGruposTrabajoBorradosBackingList()
     */
    public java.lang.Object[] getGruposTrabajoBorradosValueList();

    /**
     * The <code>gruposTrabajoBorrados</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getGruposTrabajoBorrados()
     * @see #getGruposTrabajoBorradosBackingList()
     */
    public void setGruposTrabajoBorradosValueList(java.lang.Object[] gruposTrabajoBorradosValueList);

    /**
     * The <code>gruposTrabajoBorrados</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getGruposTrabajoBorrados()
     * @see #getGruposTrabajoBorradosBackingList()
     */
    public java.lang.Object[] getGruposTrabajoBorradosLabelList();

    /**
     * The <code>gruposTrabajoBorrados</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getGruposTrabajoBorrados()
     * @see #getGruposTrabajoBorradosBackingList()
     */
    public void setGruposTrabajoBorradosLabelList(java.lang.Object[] gruposTrabajoBorradosLabelList);

    /**
     * Sets the <code>descripcionBaja</code> field.
     *
     * 
     */
    public void setDescripcionBaja(java.lang.String descripcionBaja);

    /**
     * Gets the <code>descripcionBaja</code> field.
     *
     * 
     */
    public java.lang.String getDescripcionBaja();
    
    /**
     * Resets the <code>descripcionBaja</code> field.
     */
    public void resetDescripcionBaja();

}

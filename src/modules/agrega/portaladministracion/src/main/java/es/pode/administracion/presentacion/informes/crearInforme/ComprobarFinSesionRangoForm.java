// license-header java merge-point
package es.pode.administracion.presentacion.informes.crearInforme;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>comprobarFinSesionRango</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.informes.crearInforme.CrearInformeController</code> controller.
 *
 * <p>
 * Método que comprobará si ha finalizado la sesión del usuario
 * durante la generación de un informe de rango
 * </p>
 *
 * @see es.pode.administracion.presentacion.informes.crearInforme.CrearInformeController#comprobarFinSesionRango
 */
public interface ComprobarFinSesionRangoForm
{
    /**
     * Sets the <code>anioDesde</code> field.
     *
     * 
     */
    public void setAnioDesde(java.lang.String anioDesde);

    /**
     * Gets the <code>anioDesde</code> field.
     *
     * 
     */
    public java.lang.String getAnioDesde();
    
    /**
     * Resets the <code>anioDesde</code> field.
     */
    public void resetAnioDesde();

    /**
     * Sets the <code>anioHasta</code> field.
     *
     * 
     */
    public void setAnioHasta(java.lang.String anioHasta);

    /**
     * Gets the <code>anioHasta</code> field.
     *
     * 
     */
    public java.lang.String getAnioHasta();
    
    /**
     * Resets the <code>anioHasta</code> field.
     */
    public void resetAnioHasta();

    /**
     * Sets the <code>informe</code> field.
     *
     * 
     */
    public void setInforme(java.lang.String informe);

    /**
     * Gets the <code>informe</code> field.
     *
     * 
     */
    public java.lang.String getInforme();
    
    /**
     * Resets the <code>informe</code> field.
     */
    public void resetInforme();

    /**
     * Sets the <code>mesHasta</code> field.
     *
     * 
     */
    public void setMesHasta(java.lang.String mesHasta);

    /**
     * Gets the <code>mesHasta</code> field.
     *
     * 
     */
    public java.lang.String getMesHasta();
    
    /**
     * Resets the <code>mesHasta</code> field.
     */
    public void resetMesHasta();

    /**
     * Sets the <code>rango</code> field.
     *
     * 
     */
    public void setRango(java.lang.String rango);

    /**
     * Gets the <code>rango</code> field.
     *
     * 
     */
    public java.lang.String getRango();
    
    /**
     * Resets the <code>rango</code> field.
     */
    public void resetRango();

    /**
     * The <code>rango</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getRango()
     * @see #getRangoValueList()
     * @see #getRangoLabelList()
     * @see #setRangoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getRangoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * rango property. This method takes a collection of objects, as well as
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
     * But you need to populate the rango backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setRangoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getRango()
     * @see #getRangoValueList()
     * @see #getRangoLabelList()
     * @see #getRangoLabelList()
     */
    public void setRangoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>rango</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getRango()
     * @see #getRangoBackingList()
     */
    public java.lang.Object[] getRangoValueList();

    /**
     * The <code>rango</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getRango()
     * @see #getRangoBackingList()
     */
    public void setRangoValueList(java.lang.Object[] rangoValueList);

    /**
     * The <code>rango</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getRango()
     * @see #getRangoBackingList()
     */
    public java.lang.Object[] getRangoLabelList();

    /**
     * The <code>rango</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getRango()
     * @see #getRangoBackingList()
     */
    public void setRangoLabelList(java.lang.Object[] rangoLabelList);

    /**
     * Sets the <code>formato</code> field.
     *
     * 
     */
    public void setFormato(java.lang.String formato);

    /**
     * Gets the <code>formato</code> field.
     *
     * 
     */
    public java.lang.String getFormato();
    
    /**
     * Resets the <code>formato</code> field.
     */
    public void resetFormato();

    /**
     * Sets the <code>diaDesde</code> field.
     *
     * 
     */
    public void setDiaDesde(java.lang.String diaDesde);

    /**
     * Gets the <code>diaDesde</code> field.
     *
     * 
     */
    public java.lang.String getDiaDesde();
    
    /**
     * Resets the <code>diaDesde</code> field.
     */
    public void resetDiaDesde();

    /**
     * Sets the <code>mesDesde</code> field.
     *
     * 
     */
    public void setMesDesde(java.lang.String mesDesde);

    /**
     * Gets the <code>mesDesde</code> field.
     *
     * 
     */
    public java.lang.String getMesDesde();
    
    /**
     * Resets the <code>mesDesde</code> field.
     */
    public void resetMesDesde();

    /**
     * Sets the <code>diaHasta</code> field.
     *
     * 
     */
    public void setDiaHasta(java.lang.String diaHasta);

    /**
     * Gets the <code>diaHasta</code> field.
     *
     * 
     */
    public java.lang.String getDiaHasta();
    
    /**
     * Resets the <code>diaHasta</code> field.
     */
    public void resetDiaHasta();

}

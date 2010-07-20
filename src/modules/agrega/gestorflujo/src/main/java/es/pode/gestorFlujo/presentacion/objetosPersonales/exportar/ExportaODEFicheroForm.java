// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.exportar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>exportaODEFichero</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPersonales.exportar.ExportarController</code> controller.
 *
 * <p>
 * Este metodo genera el fichero del ODE seleccionado en el formato
 * que se haya escogido. Devuelve un String indicando como ha ido
 * el resultado y en el form indica los posibles mensajes de error.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.exportar.ExportarController#exportaODEFichero
 */
public interface ExportaODEFicheroForm
{
    /**
     * Sets the <code>titulo</code> field.
     *
     * 
     */
    public void setTitulo(java.lang.String titulo);

    /**
     * Gets the <code>titulo</code> field.
     *
     * 
     */
    public java.lang.String getTitulo();
    
    /**
     * Resets the <code>titulo</code> field.
     */
    public void resetTitulo();

    /**
     * Sets the <code>mensajes</code> field.
     *
     * 
     */
    public void setMensajes(java.lang.String[] mensajes);

    /**
     * Gets the <code>mensajes</code> field.
     *
     * 
     */
    public java.lang.String[] getMensajes();
    
    /**
     * Resets the <code>mensajes</code> field.
     */
    public void resetMensajes();

    /**
     * The <code>mensajes</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getMensajes()
     * @see #getMensajesValueList()
     * @see #getMensajesLabelList()
     * @see #setMensajesLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getMensajesBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * mensajes property. This method takes a collection of objects, as well as
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
     * But you need to populate the mensajes backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setMensajesBackingList(valueObjects, "id", "name")</code>
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
     * @see #getMensajes()
     * @see #getMensajesValueList()
     * @see #getMensajesLabelList()
     * @see #getMensajesLabelList()
     */
    public void setMensajesBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>mensajes</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getMensajes()
     * @see #getMensajesBackingList()
     */
    public java.lang.Object[] getMensajesValueList();

    /**
     * The <code>mensajes</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getMensajes()
     * @see #getMensajesBackingList()
     */
    public void setMensajesValueList(java.lang.Object[] mensajesValueList);

    /**
     * The <code>mensajes</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getMensajes()
     * @see #getMensajesBackingList()
     */
    public java.lang.Object[] getMensajesLabelList();

    /**
     * The <code>mensajes</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getMensajes()
     * @see #getMensajesBackingList()
     */
    public void setMensajesLabelList(java.lang.Object[] mensajesLabelList);

    /**
     * Sets the <code>formatoExportacion</code> field.
     *
     * 
     */
    public void setFormatoExportacion(java.lang.String formatoExportacion);

    /**
     * Gets the <code>formatoExportacion</code> field.
     *
     * 
     */
    public java.lang.String getFormatoExportacion();
    
    /**
     * Resets the <code>formatoExportacion</code> field.
     */
    public void resetFormatoExportacion();

    /**
     * The <code>formatoExportacion</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getFormatoExportacion()
     * @see #getFormatoExportacionValueList()
     * @see #getFormatoExportacionLabelList()
     * @see #setFormatoExportacionLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getFormatoExportacionBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * formatoExportacion property. This method takes a collection of objects, as well as
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
     * But you need to populate the formatoExportacion backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setFormatoExportacionBackingList(valueObjects, "id", "name")</code>
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
     * @see #getFormatoExportacion()
     * @see #getFormatoExportacionValueList()
     * @see #getFormatoExportacionLabelList()
     * @see #getFormatoExportacionLabelList()
     */
    public void setFormatoExportacionBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>formatoExportacion</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getFormatoExportacion()
     * @see #getFormatoExportacionBackingList()
     */
    public java.lang.Object[] getFormatoExportacionValueList();

    /**
     * The <code>formatoExportacion</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getFormatoExportacion()
     * @see #getFormatoExportacionBackingList()
     */
    public void setFormatoExportacionValueList(java.lang.Object[] formatoExportacionValueList);

    /**
     * The <code>formatoExportacion</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getFormatoExportacion()
     * @see #getFormatoExportacionBackingList()
     */
    public java.lang.Object[] getFormatoExportacionLabelList();

    /**
     * The <code>formatoExportacion</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getFormatoExportacion()
     * @see #getFormatoExportacionBackingList()
     */
    public void setFormatoExportacionLabelList(java.lang.Object[] formatoExportacionLabelList);

    /**
     * Sets the <code>idODE</code> field.
     *
     * <p>
     * Identificador alfanumerico del ODE que se quiere exportar.
     * </p>
     */
    public void setIdODE(java.lang.String idODE);

    /**
     * Gets the <code>idODE</code> field.
     *
     * <p>
     * Identificador alfanumerico del ODE que se quiere exportar.
     * </p>
     */
    public java.lang.String getIdODE();
    
    /**
     * Resets the <code>idODE</code> field.
     */
    public void resetIdODE();

    /**
     * Sets the <code>href</code> field.
     *
     * 
     */
    public void setHref(java.lang.String href);

    /**
     * Gets the <code>href</code> field.
     *
     * 
     */
    public java.lang.String getHref();
    
    /**
     * Resets the <code>href</code> field.
     */
    public void resetHref();

}

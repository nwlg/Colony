// license-header java merge-point
package es.pode.buscador.presentacion.basico.introducirComentarios;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>eliminarComentarios</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.introducirComentarios.IntroducirComentariosController</code> controller.
 *
 * <p>
 * Este metodo elimina los comentarios asociados a un ODE.
 * </p>
 * <p>
 * La eliminacion de los comentarios de un ODE lleva implicito el
 * recalculo de su valoracion deacuerdo a los comentarios que aun
 * tenga.
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.introducirComentarios.IntroducirComentariosController#eliminarComentarios
 */
public interface EliminarComentariosForm
{
    /**
     * Sets the <code>urlODE</code> field.
     *
     * 
     */
    public void setUrlODE(java.lang.String urlODE);

    /**
     * Gets the <code>urlODE</code> field.
     *
     * 
     */
    public java.lang.String getUrlODE();
    
    /**
     * Resets the <code>urlODE</code> field.
     */
    public void resetUrlODE();

    /**
     * Sets the <code>mostrarVuelta</code> field.
     *
     * 
     */
    public void setMostrarVuelta(java.lang.Boolean mostrarVuelta);

    /**
     * Gets the <code>mostrarVuelta</code> field.
     *
     * 
     */
    public java.lang.Boolean getMostrarVuelta();
    
    /**
     * Resets the <code>mostrarVuelta</code> field.
     */
    public void resetMostrarVuelta();

    /**
     * Sets the <code>imagen</code> field.
     *
     * 
     */
    public void setImagen(java.lang.String imagen);

    /**
     * Gets the <code>imagen</code> field.
     *
     * 
     */
    public java.lang.String getImagen();
    
    /**
     * Resets the <code>imagen</code> field.
     */
    public void resetImagen();

    /**
     * Sets the <code>busquedaSimpleAvanzada</code> field.
     *
     * 
     */
    public void setBusquedaSimpleAvanzada(java.lang.String busquedaSimpleAvanzada);

    /**
     * Gets the <code>busquedaSimpleAvanzada</code> field.
     *
     * 
     */
    public java.lang.String getBusquedaSimpleAvanzada();
    
    /**
     * Resets the <code>busquedaSimpleAvanzada</code> field.
     */
    public void resetBusquedaSimpleAvanzada();

    /**
     * Sets the <code>idODE</code> field.
     *
     * 
     */
    public void setIdODE(java.lang.String idODE);

    /**
     * Gets the <code>idODE</code> field.
     *
     * 
     */
    public java.lang.String getIdODE();
    
    /**
     * Resets the <code>idODE</code> field.
     */
    public void resetIdODE();

    /**
     * Sets the <code>ids</code> field.
     *
     * 
     */
    public void setIds(java.lang.Long[] ids);

    /**
     * Gets the <code>ids</code> field.
     *
     * 
     */
    public java.lang.Long[] getIds();
    
    /**
     * Resets the <code>ids</code> field.
     */
    public void resetIds();

    /**
     * The <code>ids</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getIds()
     * @see #getIdsValueList()
     * @see #getIdsLabelList()
     * @see #setIdsLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getIdsBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * ids property. This method takes a collection of objects, as well as
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
     * But you need to populate the ids backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setIdsBackingList(valueObjects, "id", "name")</code>
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
     * @see #getIds()
     * @see #getIdsValueList()
     * @see #getIdsLabelList()
     * @see #getIdsLabelList()
     */
    public void setIdsBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>ids</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getIds()
     * @see #getIdsBackingList()
     */
    public java.lang.Object[] getIdsValueList();

    /**
     * The <code>ids</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getIds()
     * @see #getIdsBackingList()
     */
    public void setIdsValueList(java.lang.Object[] idsValueList);

    /**
     * The <code>ids</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getIds()
     * @see #getIdsBackingList()
     */
    public java.lang.Object[] getIdsLabelList();

    /**
     * The <code>ids</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getIds()
     * @see #getIdsBackingList()
     */
    public void setIdsLabelList(java.lang.Object[] idsLabelList);

    /**
     * Sets the <code>tituloODE</code> field.
     *
     * 
     */
    public void setTituloODE(java.lang.String tituloODE);

    /**
     * Gets the <code>tituloODE</code> field.
     *
     * 
     */
    public java.lang.String getTituloODE();
    
    /**
     * Resets the <code>tituloODE</code> field.
     */
    public void resetTituloODE();

    /**
     * Sets the <code>tipoLayoutBuscador</code> field.
     *
     * 
     */
    public void setTipoLayoutBuscador(java.lang.String tipoLayoutBuscador);

    /**
     * Gets the <code>tipoLayoutBuscador</code> field.
     *
     * 
     */
    public java.lang.String getTipoLayoutBuscador();
    
    /**
     * Resets the <code>tipoLayoutBuscador</code> field.
     */
    public void resetTipoLayoutBuscador();

}

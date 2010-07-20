// license-header java merge-point
package es.pode.buscador.presentacion.basico.introducirComentarios;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarComentariosODE</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.introducirComentarios.IntroducirComentariosController</code> controller.
 *
 * <p>
 * Este metodo recupera los comentarios relativos a un ODE.
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.introducirComentarios.IntroducirComentariosController#recuperarComentariosODE
 */
public interface RecuperarComentariosODEForm
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
     * Sets the <code>conInaprop</code> field.
     *
     * 
     */
    public void setConInaprop(java.lang.Boolean conInaprop);

    /**
     * Gets the <code>conInaprop</code> field.
     *
     * 
     */
    public java.lang.Boolean getConInaprop();
    
    /**
     * Resets the <code>conInaprop</code> field.
     */
    public void resetConInaprop();

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
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setComentarios#sArray(Object[])
     */
    public void setComentarios(java.util.Collection comentarios);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getComentarios#sArray()
     */
    public java.util.Collection getComentarios();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setComentarios(java.util.Collection)
     */
    public void setComentariosAsArray(Object[] comentarios);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getComentarios()
     */
    public java.lang.Object[] getComentariosAsArray();

    /**
     * Resets the <code>comentarios</code> field.
     */
    public void resetComentarios();

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

    /**
     * Sets the <code>comentario</code> field.
     *
     * 
     */
    public void setComentario(java.lang.String comentario);

    /**
     * Gets the <code>comentario</code> field.
     *
     * 
     */
    public java.lang.String getComentario();
    
    /**
     * Resets the <code>comentario</code> field.
     */
    public void resetComentario();

    /**
     * Sets the <code>usuarioAdministrador</code> field.
     *
     * 
     */
    public void setUsuarioAdministrador(java.lang.Boolean usuarioAdministrador);

    /**
     * Gets the <code>usuarioAdministrador</code> field.
     *
     * 
     */
    public java.lang.Boolean getUsuarioAdministrador();
    
    /**
     * Resets the <code>usuarioAdministrador</code> field.
     */
    public void resetUsuarioAdministrador();

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
     * Sets the <code>valoracion</code> field.
     *
     * 
     */
    public void setValoracion(java.lang.String valoracion);

    /**
     * Gets the <code>valoracion</code> field.
     *
     * 
     */
    public java.lang.String getValoracion();
    
    /**
     * Resets the <code>valoracion</code> field.
     */
    public void resetValoracion();

    /**
     * The <code>valoracion</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getValoracion()
     * @see #getValoracionValueList()
     * @see #getValoracionLabelList()
     * @see #setValoracionLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getValoracionBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * valoracion property. This method takes a collection of objects, as well as
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
     * But you need to populate the valoracion backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setValoracionBackingList(valueObjects, "id", "name")</code>
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
     * @see #getValoracion()
     * @see #getValoracionValueList()
     * @see #getValoracionLabelList()
     * @see #getValoracionLabelList()
     */
    public void setValoracionBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>valoracion</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getValoracion()
     * @see #getValoracionBackingList()
     */
    public java.lang.Object[] getValoracionValueList();

    /**
     * The <code>valoracion</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getValoracion()
     * @see #getValoracionBackingList()
     */
    public void setValoracionValueList(java.lang.Object[] valoracionValueList);

    /**
     * The <code>valoracion</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getValoracion()
     * @see #getValoracionBackingList()
     */
    public java.lang.Object[] getValoracionLabelList();

    /**
     * The <code>valoracion</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getValoracion()
     * @see #getValoracionBackingList()
     */
    public void setValoracionLabelList(java.lang.Object[] valoracionLabelList);

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
     * Sets the <code>idiomaODE</code> field.
     *
     * 
     */
    public void setIdiomaODE(java.lang.String idiomaODE);

    /**
     * Gets the <code>idiomaODE</code> field.
     *
     * 
     */
    public java.lang.String getIdiomaODE();
    
    /**
     * Resets the <code>idiomaODE</code> field.
     */
    public void resetIdiomaODE();

    /**
     * Sets the <code>listaVacia</code> field.
     *
     * 
     */
    public void setListaVacia(java.lang.Boolean listaVacia);

    /**
     * Gets the <code>listaVacia</code> field.
     *
     * 
     */
    public java.lang.Boolean getListaVacia();
    
    /**
     * Resets the <code>listaVacia</code> field.
     */
    public void resetListaVacia();

}

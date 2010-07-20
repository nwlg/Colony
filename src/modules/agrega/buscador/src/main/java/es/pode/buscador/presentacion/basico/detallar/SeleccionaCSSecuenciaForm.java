// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>seleccionaCSSecuencia</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.detallar.DetallarController</code> controller.
 *
 * <p>
 * Este metodo sirve para cargar la informacion necesaria en la
 * pagina de seleccion de C/S secuencia previa a la
 * previsualizacion.
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#seleccionaCSSecuencia
 */
public interface SeleccionaCSSecuenciaForm
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
     * Sets the <code>idLocalizador</code> field.
     *
     * <p>
     * Identificador del localizador del ODE.
     * </p>
     */
    public void setIdLocalizador(java.lang.String idLocalizador);

    /**
     * Gets the <code>idLocalizador</code> field.
     *
     * <p>
     * Identificador del localizador del ODE.
     * </p>
     */
    public java.lang.String getIdLocalizador();
    
    /**
     * Resets the <code>idLocalizador</code> field.
     */
    public void resetIdLocalizador();

    /**
     * Sets the <code>idUsuario</code> field.
     *
     * 
     */
    public void setIdUsuario(java.lang.String idUsuario);

    /**
     * Gets the <code>idUsuario</code> field.
     *
     * 
     */
    public java.lang.String getIdUsuario();
    
    /**
     * Resets the <code>idUsuario</code> field.
     */
    public void resetIdUsuario();

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
     * Sets the <code>localizadorODE</code> field.
     *
     * 
     */
    public void setLocalizadorODE(java.lang.String localizadorODE);

    /**
     * Gets the <code>localizadorODE</code> field.
     *
     * 
     */
    public java.lang.String getLocalizadorODE();
    
    /**
     * Resets the <code>localizadorODE</code> field.
     */
    public void resetLocalizadorODE();

    /**
     * Sets the <code>identificadorODE</code> field.
     *
     * <p>
     * Identificador alfanumerico del ODE.
     * </p>
     */
    public void setIdentificadorODE(java.lang.String identificadorODE);

    /**
     * Gets the <code>identificadorODE</code> field.
     *
     * <p>
     * Identificador alfanumerico del ODE.
     * </p>
     */
    public java.lang.String getIdentificadorODE();
    
    /**
     * Resets the <code>identificadorODE</code> field.
     */
    public void resetIdentificadorODE();

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
     * Sets the <code>tipoBusqueda</code> field.
     *
     * 
     */
    public void setTipoBusqueda(java.lang.String tipoBusqueda);

    /**
     * Gets the <code>tipoBusqueda</code> field.
     *
     * 
     */
    public java.lang.String getTipoBusqueda();
    
    /**
     * Resets the <code>tipoBusqueda</code> field.
     */
    public void resetTipoBusqueda();

    /**
     * Sets the <code>idiomaBuscador</code> field.
     *
     * <p>
     * El idioma de busqueda es un select en la parte de buscador.
     * </p>
     */
    public void setIdiomaBuscador(java.lang.String idiomaBuscador);

    /**
     * Gets the <code>idiomaBuscador</code> field.
     *
     * <p>
     * El idioma de busqueda es un select en la parte de buscador.
     * </p>
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

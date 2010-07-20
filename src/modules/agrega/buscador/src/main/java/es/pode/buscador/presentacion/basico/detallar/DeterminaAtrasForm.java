// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>determinaAtras</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.detallar.DetallarController</code> controller.
 *
 * <p>
 * Este metodo determina dependiendo del parametro que envie el
 * boton de atras de la pantalla de detalles, si se vuelve al
 * listado de resultados de la busqueda avanzada o al de la simple.
 * </p>
 * <p>
 * Consulta en la sesion la ultima busqueda realizada (avanzada o
 * basica) y rellena el formulario con los datos adecuados para
 * repetir la busqueda.
 * </p>
 * <p>
 * Devuelve el indicador del tipo de retorno desde el detalle
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#determinaAtras
 */
public interface DeterminaAtrasForm
{
    /**
     * Sets the <code>pagina</code> field.
     *
     * <p>
     * Se trata de la pagina en la que se encuentra el resultado de
     * busqueda del que se estan mostrando los detalles.
     * </p>
     */
    public void setPagina(java.lang.String pagina);

    /**
     * Gets the <code>pagina</code> field.
     *
     * <p>
     * Se trata de la pagina en la que se encuentra el resultado de
     * busqueda del que se estan mostrando los detalles.
     * </p>
     */
    public java.lang.String getPagina();
    
    /**
     * Resets the <code>pagina</code> field.
     */
    public void resetPagina();

    /**
     * Sets the <code>busquedaSimpleAvanzada</code> field.
     *
     * <p>
     * Este parametro determina si el detalle de la busqueda se ha
     * alcanzado desde el listado de resultados producidos por una
     * busqueda basica o avanzada.
     * </p>
     */
    public void setBusquedaSimpleAvanzada(java.lang.String busquedaSimpleAvanzada);

    /**
     * Gets the <code>busquedaSimpleAvanzada</code> field.
     *
     * <p>
     * Este parametro determina si el detalle de la busqueda se ha
     * alcanzado desde el listado de resultados producidos por una
     * busqueda basica o avanzada.
     * </p>
     */
    public java.lang.String getBusquedaSimpleAvanzada();
    
    /**
     * Resets the <code>busquedaSimpleAvanzada</code> field.
     */
    public void resetBusquedaSimpleAvanzada();

    /**
     * Sets the <code>buscadorContenido</code> field.
     *
     * <p>
     * Se trata del contenido de la caja de busqueda que ha llevado a
     * este resultado de busqueda.
     * </p>
     */
    public void setBuscadorContenido(java.lang.String buscadorContenido);

    /**
     * Gets the <code>buscadorContenido</code> field.
     *
     * <p>
     * Se trata del contenido de la caja de busqueda que ha llevado a
     * este resultado de busqueda.
     * </p>
     */
    public java.lang.String getBuscadorContenido();
    
    /**
     * Resets the <code>buscadorContenido</code> field.
     */
    public void resetBuscadorContenido();

    /**
     * Sets the <code>tipoVisualizacion</code> field.
     *
     * 
     */
    public void setTipoVisualizacion(java.lang.String tipoVisualizacion);

    /**
     * Gets the <code>tipoVisualizacion</code> field.
     *
     * 
     */
    public java.lang.String getTipoVisualizacion();
    
    /**
     * Resets the <code>tipoVisualizacion</code> field.
     */
    public void resetTipoVisualizacion();

    /**
     * Sets the <code>areaCurricularBusqueda</code> field.
     *
     * 
     */
    public void setAreaCurricularBusqueda(java.lang.String areaCurricularBusqueda);

    /**
     * Gets the <code>areaCurricularBusqueda</code> field.
     *
     * 
     */
    public java.lang.String getAreaCurricularBusqueda();
    
    /**
     * Resets the <code>areaCurricularBusqueda</code> field.
     */
    public void resetAreaCurricularBusqueda();

    /**
     * Sets the <code>tipoBusquedaArbol</code> field.
     *
     * 
     */
    public void setTipoBusquedaArbol(java.lang.String tipoBusquedaArbol);

    /**
     * Gets the <code>tipoBusquedaArbol</code> field.
     *
     * 
     */
    public java.lang.String getTipoBusquedaArbol();
    
    /**
     * Resets the <code>tipoBusquedaArbol</code> field.
     */
    public void resetTipoBusquedaArbol();

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
     * Sets the <code>tesauroBusqueda</code> field.
     *
     * 
     */
    public void setTesauroBusqueda(java.lang.String tesauroBusqueda);

    /**
     * Gets the <code>tesauroBusqueda</code> field.
     *
     * 
     */
    public java.lang.String getTesauroBusqueda();
    
    /**
     * Resets the <code>tesauroBusqueda</code> field.
     */
    public void resetTesauroBusqueda();

    /**
     * Sets the <code>idiomaBuscador</code> field.
     *
     * <p>
     * Se trata del idioma seleccionado en la pantalla del buscador.
     * </p>
     */
    public void setIdiomaBuscador(java.lang.String idiomaBuscador);

    /**
     * Gets the <code>idiomaBuscador</code> field.
     *
     * <p>
     * Se trata del idioma seleccionado en la pantalla del buscador.
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

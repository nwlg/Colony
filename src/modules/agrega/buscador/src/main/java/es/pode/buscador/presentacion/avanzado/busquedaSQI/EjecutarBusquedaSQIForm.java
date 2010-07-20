// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.busquedaSQI;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>ejecutarBusquedaSQI</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.avanzado.busquedaSQI.BusquedaSQIController</code> controller.
 *
 * <p>
 * realiza la busqueda en los nodos SQI
 * </p>
 *
 * @see es.pode.buscador.presentacion.avanzado.busquedaSQI.BusquedaSQIController#ejecutarBusquedaSQI
 */
public interface EjecutarBusquedaSQIForm
{
    /**
     * Sets the <code>resultadosDesde</code> field.
     *
     * 
     */
    public void setResultadosDesde(int resultadosDesde);

    /**
     * Gets the <code>resultadosDesde</code> field.
     *
     * 
     */
    public int getResultadosDesde();
    
    /**
     * Resets the <code>resultadosDesde</code> field.
     */
    public void resetResultadosDesde();

    /**
     * Sets the <code>siguiente</code> field.
     *
     * 
     */
    public void setSiguiente(java.lang.String siguiente);

    /**
     * Gets the <code>siguiente</code> field.
     *
     * 
     */
    public java.lang.String getSiguiente();
    
    /**
     * Resets the <code>siguiente</code> field.
     */
    public void resetSiguiente();

    /**
     * Sets the <code>buscadorContenido</code> field.
     *
     * 
     */
    public void setBuscadorContenido(java.lang.String buscadorContenido);

    /**
     * Gets the <code>buscadorContenido</code> field.
     *
     * 
     */
    public java.lang.String getBuscadorContenido();
    
    /**
     * Resets the <code>buscadorContenido</code> field.
     */
    public void resetBuscadorContenido();

    /**
     * Sets the <code>buscadorContenidoSolo</code> field.
     *
     * 
     */
    public void setBuscadorContenidoSolo(java.lang.String buscadorContenidoSolo);

    /**
     * Gets the <code>buscadorContenidoSolo</code> field.
     *
     * 
     */
    public java.lang.String getBuscadorContenidoSolo();
    
    /**
     * Resets the <code>buscadorContenidoSolo</code> field.
     */
    public void resetBuscadorContenidoSolo();

    /**
     * Sets the <code>keyword</code> field.
     *
     * 
     */
    public void setKeyword(java.lang.String keyword);

    /**
     * Gets the <code>keyword</code> field.
     *
     * 
     */
    public java.lang.String getKeyword();
    
    /**
     * Resets the <code>keyword</code> field.
     */
    public void resetKeyword();

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
     * idioma seleccionado por el usuario para realizar la búsqueda
     * </p>
     */
    public void setIdiomaBuscador(java.lang.String idiomaBuscador);

    /**
     * Gets the <code>idiomaBuscador</code> field.
     *
     * <p>
     * idioma seleccionado por el usuario para realizar la búsqueda
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
     * Sets the <code>mostrarAmbito</code> field.
     *
     * 
     */
    public void setMostrarAmbito(java.lang.Boolean mostrarAmbito);

    /**
     * Gets the <code>mostrarAmbito</code> field.
     *
     * 
     */
    public java.lang.Boolean getMostrarAmbito();
    
    /**
     * Resets the <code>mostrarAmbito</code> field.
     */
    public void resetMostrarAmbito();

    /**
     * Sets the <code>anterior</code> field.
     *
     * 
     */
    public void setAnterior(java.lang.String anterior);

    /**
     * Gets the <code>anterior</code> field.
     *
     * 
     */
    public java.lang.String getAnterior();
    
    /**
     * Resets the <code>anterior</code> field.
     */
    public void resetAnterior();

    /**
     * Sets the <code>pagina</code> field.
     *
     * 
     */
    public void setPagina(java.lang.String pagina);

    /**
     * Gets the <code>pagina</code> field.
     *
     * 
     */
    public java.lang.String getPagina();
    
    /**
     * Resets the <code>pagina</code> field.
     */
    public void resetPagina();

    /**
     * Sets the <code>numMaxRes</code> field.
     *
     * 
     */
    public void setNumMaxRes(java.lang.String numMaxRes);

    /**
     * Gets the <code>numMaxRes</code> field.
     *
     * 
     */
    public java.lang.String getNumMaxRes();
    
    /**
     * Resets the <code>numMaxRes</code> field.
     */
    public void resetNumMaxRes();

    /**
     * Sets the <code>resultadosHasta</code> field.
     *
     * 
     */
    public void setResultadosHasta(java.lang.String resultadosHasta);

    /**
     * Gets the <code>resultadosHasta</code> field.
     *
     * 
     */
    public java.lang.String getResultadosHasta();
    
    /**
     * Resets the <code>resultadosHasta</code> field.
     */
    public void resetResultadosHasta();

    /**
     * Sets the <code>buscadorContenidoEnlace</code> field.
     *
     * 
     */
    public void setBuscadorContenidoEnlace(java.lang.String buscadorContenidoEnlace);

    /**
     * Gets the <code>buscadorContenidoEnlace</code> field.
     *
     * 
     */
    public java.lang.String getBuscadorContenidoEnlace();
    
    /**
     * Resets the <code>buscadorContenidoEnlace</code> field.
     */
    public void resetBuscadorContenidoEnlace();

    /**
     * Sets the <code>numeroResultados</code> field.
     *
     * <p>
     * numero de resultados a mostrar por página
     * </p>
     */
    public void setNumeroResultados(java.lang.String numeroResultados);

    /**
     * Gets the <code>numeroResultados</code> field.
     *
     * <p>
     * numero de resultados a mostrar por página
     * </p>
     */
    public java.lang.String getNumeroResultados();
    
    /**
     * Resets the <code>numeroResultados</code> field.
     */
    public void resetNumeroResultados();

    /**
     * The <code>numeroResultados</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getNumeroResultados()
     * @see #getNumeroResultadosValueList()
     * @see #getNumeroResultadosLabelList()
     * @see #setNumeroResultadosLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getNumeroResultadosBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * numeroResultados property. This method takes a collection of objects, as well as
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
     * But you need to populate the numeroResultados backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setNumeroResultadosBackingList(valueObjects, "id", "name")</code>
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
     * @see #getNumeroResultados()
     * @see #getNumeroResultadosValueList()
     * @see #getNumeroResultadosLabelList()
     * @see #getNumeroResultadosLabelList()
     */
    public void setNumeroResultadosBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>numeroResultados</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getNumeroResultados()
     * @see #getNumeroResultadosBackingList()
     */
    public java.lang.Object[] getNumeroResultadosValueList();

    /**
     * The <code>numeroResultados</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getNumeroResultados()
     * @see #getNumeroResultadosBackingList()
     */
    public void setNumeroResultadosValueList(java.lang.Object[] numeroResultadosValueList);

    /**
     * The <code>numeroResultados</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getNumeroResultados()
     * @see #getNumeroResultadosBackingList()
     */
    public java.lang.Object[] getNumeroResultadosLabelList();

    /**
     * The <code>numeroResultados</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getNumeroResultados()
     * @see #getNumeroResultadosBackingList()
     */
    public void setNumeroResultadosLabelList(java.lang.Object[] numeroResultadosLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setLomEsVO#sArray(Object[])
     */
    public void setLomEsVO(java.util.Collection lomEsVO);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getLomEsVO#sArray()
     */
    public java.util.Collection getLomEsVO();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setLomEsVO(java.util.Collection)
     */
    public void setLomEsVOAsArray(Object[] lomEsVO);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getLomEsVO()
     */
    public java.lang.Object[] getLomEsVOAsArray();

    /**
     * Resets the <code>lomEsVO</code> field.
     */
    public void resetLomEsVO();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setPaginas#sArray(Object[])
     */
    public void setPaginas(java.util.Collection paginas);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getPaginas#sArray()
     */
    public java.util.Collection getPaginas();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setPaginas(java.util.Collection)
     */
    public void setPaginasAsArray(Object[] paginas);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getPaginas()
     */
    public java.lang.Object[] getPaginasAsArray();

    /**
     * Resets the <code>paginas</code> field.
     */
    public void resetPaginas();

}

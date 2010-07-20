// license-header java merge-point
package es.pode.buscador.presentacion.arbolTesauros.listarODETesauro;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>buscarDocumentosTesauro</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.ListarODETesauroController</code> controller.
 *
 * <p>
 * Este método efectua la busqueda de resultados para la consulta
 * que se ha configurado en el buscador por tesauro de la
 * aplicación.
 * </p>
 * <p>
 * Los parámetros de busqueda de la consulta que tiene que
 * realizar se los pasan por la URL de la invocación y se mapean
 * al formulario que recibe como parametro.
 * </p>
 * <p>
 * También se encarga de resolver la paginación sobre una
 * búsqueda ya realizada.
 * </p>
 *
 * @see es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.ListarODETesauroController#buscarDocumentosTesauro
 */
public interface BuscarDocumentosTesauroForm
{
    /**
     * Sets the <code>resultadosDesde</code> field.
     *
     * 
     */
    public void setResultadosDesde(java.lang.String resultadosDesde);

    /**
     * Gets the <code>resultadosDesde</code> field.
     *
     * 
     */
    public java.lang.String getResultadosDesde();
    
    /**
     * Resets the <code>resultadosDesde</code> field.
     */
    public void resetResultadosDesde();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setRutaTesauro#sArray(Object[])
     */
    public void setRutaTesauro(java.util.Collection rutaTesauro);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getRutaTesauro#sArray()
     */
    public java.util.Collection getRutaTesauro();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setRutaTesauro(java.util.Collection)
     */
    public void setRutaTesauroAsArray(Object[] rutaTesauro);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getRutaTesauro()
     */
    public java.lang.Object[] getRutaTesauroAsArray();

    /**
     * Resets the <code>rutaTesauro</code> field.
     */
    public void resetRutaTesauro();

    /**
     * The <code>rutaTesauro</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getRutaTesauro()
     * @see #getRutaTesauroValueList()
     * @see #getRutaTesauroLabelList()
     * @see #setRutaTesauroLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getRutaTesauroBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * rutaTesauro property. This method takes a collection of objects, as well as
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
     * But you need to populate the rutaTesauro backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setRutaTesauroBackingList(valueObjects, "id", "name")</code>
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
     * @see #getRutaTesauro()
     * @see #getRutaTesauroValueList()
     * @see #getRutaTesauroLabelList()
     * @see #getRutaTesauroLabelList()
     */
    public void setRutaTesauroBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>rutaTesauro</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getRutaTesauro()
     * @see #getRutaTesauroBackingList()
     */
    public java.lang.Object[] getRutaTesauroValueList();

    /**
     * The <code>rutaTesauro</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getRutaTesauro()
     * @see #getRutaTesauroBackingList()
     */
    public void setRutaTesauroValueList(java.lang.Object[] rutaTesauroValueList);

    /**
     * The <code>rutaTesauro</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getRutaTesauro()
     * @see #getRutaTesauroBackingList()
     */
    public java.lang.Object[] getRutaTesauroLabelList();

    /**
     * The <code>rutaTesauro</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getRutaTesauro()
     * @see #getRutaTesauroBackingList()
     */
    public void setRutaTesauroLabelList(java.lang.Object[] rutaTesauroLabelList);

    /**
     * Sets the <code>nodoOrigen</code> field.
     *
     * 
     */
    public void setNodoOrigen(java.lang.String nodoOrigen);

    /**
     * Gets the <code>nodoOrigen</code> field.
     *
     * 
     */
    public java.lang.String getNodoOrigen();
    
    /**
     * Resets the <code>nodoOrigen</code> field.
     */
    public void resetNodoOrigen();

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
     * Sets the <code>tituloTesauro</code> field.
     *
     * 
     */
    public void setTituloTesauro(java.lang.String tituloTesauro);

    /**
     * Gets the <code>tituloTesauro</code> field.
     *
     * 
     */
    public java.lang.String getTituloTesauro();
    
    /**
     * Resets the <code>tituloTesauro</code> field.
     */
    public void resetTituloTesauro();

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
     * Sets the <code>idBusqueda</code> field.
     *
     * 
     */
    public void setIdBusqueda(java.lang.String idBusqueda);

    /**
     * Gets the <code>idBusqueda</code> field.
     *
     * 
     */
    public java.lang.String getIdBusqueda();
    
    /**
     * Resets the <code>idBusqueda</code> field.
     */
    public void resetIdBusqueda();

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
     * Sets the <code>resultadosVO</code> field.
     *
     * 
     */
    public void setResultadosVO(es.pode.buscar.negocio.buscar.servicios.ValoresBusquedaVO[] resultadosVO);

    /**
     * Gets the <code>resultadosVO</code> field.
     *
     * 
     */
    public es.pode.buscar.negocio.buscar.servicios.ValoresBusquedaVO[] getResultadosVO();
    
    /**
     * Resets the <code>resultadosVO</code> field.
     */
    public void resetResultadosVO();

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
     * Sets the <code>esRuta</code> field.
     *
     * 
     */
    public void setEsRuta(boolean esRuta);

    /**
     * Gets the <code>esRuta</code> field.
     *
     * 
     */
    public boolean isEsRuta();
    
    /**
     * Resets the <code>esRuta</code> field.
     */
    public void resetEsRuta();

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
     * Sets the <code>numMaxResultados</code> field.
     *
     * 
     */
    public void setNumMaxResultados(java.lang.Integer numMaxResultados);

    /**
     * Gets the <code>numMaxResultados</code> field.
     *
     * 
     */
    public java.lang.Integer getNumMaxResultados();
    
    /**
     * Resets the <code>numMaxResultados</code> field.
     */
    public void resetNumMaxResultados();

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
     * Sets the <code>nodoDestino</code> field.
     *
     * 
     */
    public void setNodoDestino(java.lang.String nodoDestino);

    /**
     * Gets the <code>nodoDestino</code> field.
     *
     * 
     */
    public java.lang.String getNodoDestino();
    
    /**
     * Resets the <code>nodoDestino</code> field.
     */
    public void resetNodoDestino();

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

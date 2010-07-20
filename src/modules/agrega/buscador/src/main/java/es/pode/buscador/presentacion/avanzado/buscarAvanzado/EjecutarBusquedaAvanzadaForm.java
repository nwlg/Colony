// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>ejecutarBusquedaAvanzada</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController</code> controller.
 *
 * <p>
 * Este metodo realiza la busqueda con los parrametros de busqueda
 * avanzados que se le pasan.
 * </p>
 * <p>
 * Tambien introduce en la sesion los parametros de la busqueda
 * avanzada que se han seleccionado.
 * </p>
 *
 * @see es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController#ejecutarBusquedaAvanzada
 */
public interface EjecutarBusquedaAvanzadaForm
{
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
     * The <code>formato</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getFormato()
     * @see #getFormatoValueList()
     * @see #getFormatoLabelList()
     * @see #setFormatoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getFormatoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * formato property. This method takes a collection of objects, as well as
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
     * But you need to populate the formato backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setFormatoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getFormato()
     * @see #getFormatoValueList()
     * @see #getFormatoLabelList()
     * @see #getFormatoLabelList()
     */
    public void setFormatoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>formato</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getFormato()
     * @see #getFormatoBackingList()
     */
    public java.lang.Object[] getFormatoValueList();

    /**
     * The <code>formato</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getFormato()
     * @see #getFormatoBackingList()
     */
    public void setFormatoValueList(java.lang.Object[] formatoValueList);

    /**
     * The <code>formato</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getFormato()
     * @see #getFormatoBackingList()
     */
    public java.lang.Object[] getFormatoLabelList();

    /**
     * The <code>formato</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getFormato()
     * @see #getFormatoBackingList()
     */
    public void setFormatoLabelList(java.lang.Object[] formatoLabelList);

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
     * Sets the <code>idTesauro</code> field.
     *
     * 
     */
    public void setIdTesauro(java.lang.String idTesauro);

    /**
     * Gets the <code>idTesauro</code> field.
     *
     * 
     */
    public java.lang.String getIdTesauro();
    
    /**
     * Resets the <code>idTesauro</code> field.
     */
    public void resetIdTesauro();

    /**
     * Sets the <code>anyoPublicacion</code> field.
     *
     * 
     */
    public void setAnyoPublicacion(java.lang.String anyoPublicacion);

    /**
     * Gets the <code>anyoPublicacion</code> field.
     *
     * 
     */
    public java.lang.String getAnyoPublicacion();
    
    /**
     * Resets the <code>anyoPublicacion</code> field.
     */
    public void resetAnyoPublicacion();

    /**
     * Sets the <code>areaCurricular</code> field.
     *
     * 
     */
    public void setAreaCurricular(java.lang.String areaCurricular);

    /**
     * Gets the <code>areaCurricular</code> field.
     *
     * 
     */
    public java.lang.String getAreaCurricular();
    
    /**
     * Resets the <code>areaCurricular</code> field.
     */
    public void resetAreaCurricular();

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
     * Sets the <code>comunidadesSeleccionadas</code> field.
     *
     * 
     */
    public void setComunidadesSeleccionadas(java.lang.String[] comunidadesSeleccionadas);

    /**
     * Gets the <code>comunidadesSeleccionadas</code> field.
     *
     * 
     */
    public java.lang.String[] getComunidadesSeleccionadas();
    
    /**
     * Resets the <code>comunidadesSeleccionadas</code> field.
     */
    public void resetComunidadesSeleccionadas();

    /**
     * The <code>comunidadesSeleccionadas</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getComunidadesSeleccionadas()
     * @see #getComunidadesSeleccionadasValueList()
     * @see #getComunidadesSeleccionadasLabelList()
     * @see #setComunidadesSeleccionadasLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getComunidadesSeleccionadasBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * comunidadesSeleccionadas property. This method takes a collection of objects, as well as
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
     * But you need to populate the comunidadesSeleccionadas backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setComunidadesSeleccionadasBackingList(valueObjects, "id", "name")</code>
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
     * @see #getComunidadesSeleccionadas()
     * @see #getComunidadesSeleccionadasValueList()
     * @see #getComunidadesSeleccionadasLabelList()
     * @see #getComunidadesSeleccionadasLabelList()
     */
    public void setComunidadesSeleccionadasBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>comunidadesSeleccionadas</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getComunidadesSeleccionadas()
     * @see #getComunidadesSeleccionadasBackingList()
     */
    public java.lang.Object[] getComunidadesSeleccionadasValueList();

    /**
     * The <code>comunidadesSeleccionadas</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getComunidadesSeleccionadas()
     * @see #getComunidadesSeleccionadasBackingList()
     */
    public void setComunidadesSeleccionadasValueList(java.lang.Object[] comunidadesSeleccionadasValueList);

    /**
     * The <code>comunidadesSeleccionadas</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getComunidadesSeleccionadas()
     * @see #getComunidadesSeleccionadasBackingList()
     */
    public java.lang.Object[] getComunidadesSeleccionadasLabelList();

    /**
     * The <code>comunidadesSeleccionadas</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getComunidadesSeleccionadas()
     * @see #getComunidadesSeleccionadasBackingList()
     */
    public void setComunidadesSeleccionadasLabelList(java.lang.Object[] comunidadesSeleccionadasLabelList);

    /**
     * Sets the <code>edad</code> field.
     *
     * 
     */
    public void setEdad(java.lang.String edad);

    /**
     * Gets the <code>edad</code> field.
     *
     * 
     */
    public java.lang.String getEdad();
    
    /**
     * Resets the <code>edad</code> field.
     */
    public void resetEdad();

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
     * Sets the <code>contadorODE</code> field.
     *
     * 
     */
    public void setContadorODE(java.lang.String contadorODE);

    /**
     * Gets the <code>contadorODE</code> field.
     *
     * 
     */
    public java.lang.String getContadorODE();
    
    /**
     * Resets the <code>contadorODE</code> field.
     */
    public void resetContadorODE();

    /**
     * Sets the <code>c_s_secuencia</code> field.
     *
     * 
     */
    public void setC_s_secuencia(java.lang.String c_s_secuencia);

    /**
     * Gets the <code>c_s_secuencia</code> field.
     *
     * 
     */
    public java.lang.String getC_s_secuencia();
    
    /**
     * Resets the <code>c_s_secuencia</code> field.
     */
    public void resetC_s_secuencia();

    /**
     * The <code>c_s_secuencia</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getC_s_secuencia()
     * @see #getC_s_secuenciaValueList()
     * @see #getC_s_secuenciaLabelList()
     * @see #setC_s_secuenciaLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getC_s_secuenciaBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * c_s_secuencia property. This method takes a collection of objects, as well as
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
     * But you need to populate the c_s_secuencia backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setC_s_secuenciaBackingList(valueObjects, "id", "name")</code>
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
     * @see #getC_s_secuencia()
     * @see #getC_s_secuenciaValueList()
     * @see #getC_s_secuenciaLabelList()
     * @see #getC_s_secuenciaLabelList()
     */
    public void setC_s_secuenciaBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>c_s_secuencia</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getC_s_secuencia()
     * @see #getC_s_secuenciaBackingList()
     */
    public java.lang.Object[] getC_s_secuenciaValueList();

    /**
     * The <code>c_s_secuencia</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getC_s_secuencia()
     * @see #getC_s_secuenciaBackingList()
     */
    public void setC_s_secuenciaValueList(java.lang.Object[] c_s_secuenciaValueList);

    /**
     * The <code>c_s_secuencia</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getC_s_secuencia()
     * @see #getC_s_secuenciaBackingList()
     */
    public java.lang.Object[] getC_s_secuenciaLabelList();

    /**
     * The <code>c_s_secuencia</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getC_s_secuencia()
     * @see #getC_s_secuenciaBackingList()
     */
    public void setC_s_secuenciaLabelList(java.lang.Object[] c_s_secuenciaLabelList);

    /**
     * Sets the <code>enlaceComunidadesSeleccionadas</code> field.
     *
     * 
     */
    public void setEnlaceComunidadesSeleccionadas(java.lang.String enlaceComunidadesSeleccionadas);

    /**
     * Gets the <code>enlaceComunidadesSeleccionadas</code> field.
     *
     * 
     */
    public java.lang.String getEnlaceComunidadesSeleccionadas();
    
    /**
     * Resets the <code>enlaceComunidadesSeleccionadas</code> field.
     */
    public void resetEnlaceComunidadesSeleccionadas();

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
     * Sets the <code>recurso</code> field.
     *
     * 
     */
    public void setRecurso(java.lang.String recurso);

    /**
     * Gets the <code>recurso</code> field.
     *
     * 
     */
    public java.lang.String getRecurso();
    
    /**
     * Resets the <code>recurso</code> field.
     */
    public void resetRecurso();

    /**
     * The <code>recurso</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getRecurso()
     * @see #getRecursoValueList()
     * @see #getRecursoLabelList()
     * @see #setRecursoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getRecursoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * recurso property. This method takes a collection of objects, as well as
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
     * But you need to populate the recurso backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setRecursoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getRecurso()
     * @see #getRecursoValueList()
     * @see #getRecursoLabelList()
     * @see #getRecursoLabelList()
     */
    public void setRecursoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>recurso</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getRecurso()
     * @see #getRecursoBackingList()
     */
    public java.lang.Object[] getRecursoValueList();

    /**
     * The <code>recurso</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getRecurso()
     * @see #getRecursoBackingList()
     */
    public void setRecursoValueList(java.lang.Object[] recursoValueList);

    /**
     * The <code>recurso</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getRecurso()
     * @see #getRecursoBackingList()
     */
    public java.lang.Object[] getRecursoLabelList();

    /**
     * The <code>recurso</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getRecurso()
     * @see #getRecursoBackingList()
     */
    public void setRecursoLabelList(java.lang.Object[] recursoLabelList);

    /**
     * Sets the <code>diaPublicacion</code> field.
     *
     * 
     */
    public void setDiaPublicacion(java.lang.String diaPublicacion);

    /**
     * Gets the <code>diaPublicacion</code> field.
     *
     * 
     */
    public java.lang.String getDiaPublicacion();
    
    /**
     * Resets the <code>diaPublicacion</code> field.
     */
    public void resetDiaPublicacion();

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

    /**
     * Sets the <code>contexto</code> field.
     *
     * 
     */
    public void setContexto(java.lang.String contexto);

    /**
     * Gets the <code>contexto</code> field.
     *
     * 
     */
    public java.lang.String getContexto();
    
    /**
     * Resets the <code>contexto</code> field.
     */
    public void resetContexto();

    /**
     * The <code>contexto</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getContexto()
     * @see #getContextoValueList()
     * @see #getContextoLabelList()
     * @see #setContextoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getContextoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * contexto property. This method takes a collection of objects, as well as
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
     * But you need to populate the contexto backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setContextoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getContexto()
     * @see #getContextoValueList()
     * @see #getContextoLabelList()
     * @see #getContextoLabelList()
     */
    public void setContextoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>contexto</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getContexto()
     * @see #getContextoBackingList()
     */
    public java.lang.Object[] getContextoValueList();

    /**
     * The <code>contexto</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getContexto()
     * @see #getContextoBackingList()
     */
    public void setContextoValueList(java.lang.Object[] contextoValueList);

    /**
     * The <code>contexto</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getContexto()
     * @see #getContextoBackingList()
     */
    public java.lang.Object[] getContextoLabelList();

    /**
     * The <code>contexto</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getContexto()
     * @see #getContextoBackingList()
     */
    public void setContextoLabelList(java.lang.Object[] contextoLabelList);

    /**
     * Sets the <code>idTesauroSugerencia</code> field.
     *
     * <p>
     * Identificador de tesauro por el que se filtra despues de
     * seleccionarlo en las sugerencias de tesauro
     * </p>
     */
    public void setIdTesauroSugerencia(java.lang.String idTesauroSugerencia);

    /**
     * Gets the <code>idTesauroSugerencia</code> field.
     *
     * <p>
     * Identificador de tesauro por el que se filtra despues de
     * seleccionarlo en las sugerencias de tesauro
     * </p>
     */
    public java.lang.String getIdTesauroSugerencia();
    
    /**
     * Resets the <code>idTesauroSugerencia</code> field.
     */
    public void resetIdTesauroSugerencia();

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
     * Sets the <code>autor</code> field.
     *
     * 
     */
    public void setAutor(java.lang.String autor);

    /**
     * Gets the <code>autor</code> field.
     *
     * 
     */
    public java.lang.String getAutor();
    
    /**
     * Resets the <code>autor</code> field.
     */
    public void resetAutor();

    /**
     * Sets the <code>destinatarios</code> field.
     *
     * 
     */
    public void setDestinatarios(java.lang.String destinatarios);

    /**
     * Gets the <code>destinatarios</code> field.
     *
     * 
     */
    public java.lang.String getDestinatarios();
    
    /**
     * Resets the <code>destinatarios</code> field.
     */
    public void resetDestinatarios();

    /**
     * The <code>destinatarios</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getDestinatarios()
     * @see #getDestinatariosValueList()
     * @see #getDestinatariosLabelList()
     * @see #setDestinatariosLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getDestinatariosBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * destinatarios property. This method takes a collection of objects, as well as
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
     * But you need to populate the destinatarios backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setDestinatariosBackingList(valueObjects, "id", "name")</code>
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
     * @see #getDestinatarios()
     * @see #getDestinatariosValueList()
     * @see #getDestinatariosLabelList()
     * @see #getDestinatariosLabelList()
     */
    public void setDestinatariosBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>destinatarios</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getDestinatarios()
     * @see #getDestinatariosBackingList()
     */
    public java.lang.Object[] getDestinatariosValueList();

    /**
     * The <code>destinatarios</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getDestinatarios()
     * @see #getDestinatariosBackingList()
     */
    public void setDestinatariosValueList(java.lang.Object[] destinatariosValueList);

    /**
     * The <code>destinatarios</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getDestinatarios()
     * @see #getDestinatariosBackingList()
     */
    public java.lang.Object[] getDestinatariosLabelList();

    /**
     * The <code>destinatarios</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getDestinatarios()
     * @see #getDestinatariosBackingList()
     */
    public void setDestinatariosLabelList(java.lang.Object[] destinatariosLabelList);

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
     * Sets the <code>pulsacion</code> field.
     *
     * 
     */
    public void setPulsacion(java.lang.String pulsacion);

    /**
     * Gets the <code>pulsacion</code> field.
     *
     * 
     */
    public java.lang.String getPulsacion();
    
    /**
     * Resets the <code>pulsacion</code> field.
     */
    public void resetPulsacion();

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
     * Sets the <code>descripcion</code> field.
     *
     * 
     */
    public void setDescripcion(java.lang.String descripcion);

    /**
     * Gets the <code>descripcion</code> field.
     *
     * 
     */
    public java.lang.String getDescripcion();
    
    /**
     * Resets the <code>descripcion</code> field.
     */
    public void resetDescripcion();

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
     * Sets the <code>nivelAgregacion</code> field.
     *
     * 
     */
    public void setNivelAgregacion(java.lang.String nivelAgregacion);

    /**
     * Gets the <code>nivelAgregacion</code> field.
     *
     * 
     */
    public java.lang.String getNivelAgregacion();
    
    /**
     * Resets the <code>nivelAgregacion</code> field.
     */
    public void resetNivelAgregacion();

    /**
     * The <code>nivelAgregacion</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getNivelAgregacion()
     * @see #getNivelAgregacionValueList()
     * @see #getNivelAgregacionLabelList()
     * @see #setNivelAgregacionLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getNivelAgregacionBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * nivelAgregacion property. This method takes a collection of objects, as well as
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
     * But you need to populate the nivelAgregacion backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setNivelAgregacionBackingList(valueObjects, "id", "name")</code>
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
     * @see #getNivelAgregacion()
     * @see #getNivelAgregacionValueList()
     * @see #getNivelAgregacionLabelList()
     * @see #getNivelAgregacionLabelList()
     */
    public void setNivelAgregacionBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>nivelAgregacion</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getNivelAgregacion()
     * @see #getNivelAgregacionBackingList()
     */
    public java.lang.Object[] getNivelAgregacionValueList();

    /**
     * The <code>nivelAgregacion</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getNivelAgregacion()
     * @see #getNivelAgregacionBackingList()
     */
    public void setNivelAgregacionValueList(java.lang.Object[] nivelAgregacionValueList);

    /**
     * The <code>nivelAgregacion</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getNivelAgregacion()
     * @see #getNivelAgregacionBackingList()
     */
    public java.lang.Object[] getNivelAgregacionLabelList();

    /**
     * The <code>nivelAgregacion</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getNivelAgregacion()
     * @see #getNivelAgregacionBackingList()
     */
    public void setNivelAgregacionLabelList(java.lang.Object[] nivelAgregacionLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setResultadosVO#sArray(Object[])
     */
    public void setResultadosVO(java.util.Collection resultadosVO);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getResultadosVO#sArray()
     */
    public java.util.Collection getResultadosVO();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setResultadosVO(java.util.Collection)
     */
    public void setResultadosVOAsArray(Object[] resultadosVO);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getResultadosVO()
     */
    public java.lang.Object[] getResultadosVOAsArray();

    /**
     * Resets the <code>resultadosVO</code> field.
     */
    public void resetResultadosVO();

    /**
     * Sets the <code>procesoCognitivo</code> field.
     *
     * 
     */
    public void setProcesoCognitivo(java.lang.String procesoCognitivo);

    /**
     * Gets the <code>procesoCognitivo</code> field.
     *
     * 
     */
    public java.lang.String getProcesoCognitivo();
    
    /**
     * Resets the <code>procesoCognitivo</code> field.
     */
    public void resetProcesoCognitivo();

    /**
     * The <code>procesoCognitivo</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getProcesoCognitivo()
     * @see #getProcesoCognitivoValueList()
     * @see #getProcesoCognitivoLabelList()
     * @see #setProcesoCognitivoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getProcesoCognitivoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * procesoCognitivo property. This method takes a collection of objects, as well as
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
     * But you need to populate the procesoCognitivo backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setProcesoCognitivoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getProcesoCognitivo()
     * @see #getProcesoCognitivoValueList()
     * @see #getProcesoCognitivoLabelList()
     * @see #getProcesoCognitivoLabelList()
     */
    public void setProcesoCognitivoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>procesoCognitivo</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getProcesoCognitivo()
     * @see #getProcesoCognitivoBackingList()
     */
    public java.lang.Object[] getProcesoCognitivoValueList();

    /**
     * The <code>procesoCognitivo</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getProcesoCognitivo()
     * @see #getProcesoCognitivoBackingList()
     */
    public void setProcesoCognitivoValueList(java.lang.Object[] procesoCognitivoValueList);

    /**
     * The <code>procesoCognitivo</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getProcesoCognitivo()
     * @see #getProcesoCognitivoBackingList()
     */
    public java.lang.Object[] getProcesoCognitivoLabelList();

    /**
     * The <code>procesoCognitivo</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getProcesoCognitivo()
     * @see #getProcesoCognitivoBackingList()
     */
    public void setProcesoCognitivoLabelList(java.lang.Object[] procesoCognitivoLabelList);

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
     * Sets the <code>quisoDecir</code> field.
     *
     * 
     */
    public void setQuisoDecir(java.lang.String[] quisoDecir);

    /**
     * Gets the <code>quisoDecir</code> field.
     *
     * 
     */
    public java.lang.String[] getQuisoDecir();
    
    /**
     * Resets the <code>quisoDecir</code> field.
     */
    public void resetQuisoDecir();

    /**
     * Sets the <code>enlaceTodoAgrega</code> field.
     *
     * 
     */
    public void setEnlaceTodoAgrega(java.lang.String enlaceTodoAgrega);

    /**
     * Gets the <code>enlaceTodoAgrega</code> field.
     *
     * 
     */
    public java.lang.String getEnlaceTodoAgrega();
    
    /**
     * Resets the <code>enlaceTodoAgrega</code> field.
     */
    public void resetEnlaceTodoAgrega();

    /**
     * Sets the <code>numeroResultados</code> field.
     *
     * 
     */
    public void setNumeroResultados(java.lang.String numeroResultados);

    /**
     * Gets the <code>numeroResultados</code> field.
     *
     * 
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
     * Sets the <code>mesPublicacion</code> field.
     *
     * 
     */
    public void setMesPublicacion(java.lang.String mesPublicacion);

    /**
     * Gets the <code>mesPublicacion</code> field.
     *
     * 
     */
    public java.lang.String getMesPublicacion();
    
    /**
     * Resets the <code>mesPublicacion</code> field.
     */
    public void resetMesPublicacion();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setComunidades#sArray(Object[])
     */
    public void setComunidades(java.util.List comunidades);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getComunidades#sArray()
     */
    public java.util.List getComunidades();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setComunidades(java.util.List)
     */
    public void setComunidadesAsArray(Object[] comunidades);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getComunidades()
     */
    public java.lang.Object[] getComunidadesAsArray();

    /**
     * Resets the <code>comunidades</code> field.
     */
    public void resetComunidades();

    /**
     * Sets the <code>nodosSQI</code> field.
     *
     * <p>
     * indica si hay algún dato cargado en la tabla de nodos_SQI
     * </p>
     */
    public void setNodosSQI(java.lang.Boolean nodosSQI);

    /**
     * Gets the <code>nodosSQI</code> field.
     *
     * <p>
     * indica si hay algún dato cargado en la tabla de nodos_SQI
     * </p>
     */
    public java.lang.Boolean getNodosSQI();
    
    /**
     * Resets the <code>nodosSQI</code> field.
     */
    public void resetNodosSQI();

    /**
     * Sets the <code>tesauros</code> field.
     *
     * 
     */
    public void setTesauros(es.pode.buscar.negocio.buscar.servicios.ResultadosTaxonVO[] tesauros);

    /**
     * Gets the <code>tesauros</code> field.
     *
     * 
     */
    public es.pode.buscar.negocio.buscar.servicios.ResultadosTaxonVO[] getTesauros();
    
    /**
     * Resets the <code>tesauros</code> field.
     */
    public void resetTesauros();


    /*
     * Search filters
     */
    
    /**
     * Sets the <code>subjectSearchFilter</code> field.
     *
     * 
     */
    public void setSubjectSearchFilter(java.lang.String subjectSearchFilter);

    /**
     * Gets the <code>subjectSearchFilter</code> field.
     *
     * 
     */
    public java.lang.String getSubjectSearchFilter();

    /**
     * Sets the <code>keystageSearchFilter</code> field.
     *
     * 
     */
    public void setKeystageSearchFilter(java.lang.String keystageSearchFilter);

    /**
     * Gets the <code>keystageSearchFilter</code> field.
     *
     * 
     */
    public java.lang.String getKeystageSearchFilter();
    
    /**
     * Sets the <code>learningTimeSearchFilter</code> field.
     *
     * 
     */
    public void setLearningTimeSearchFilter(java.lang.String learningTimeSearchFilter);

    /**
     * Gets the <code>learningTimeSearchFilter</code> field.
     *
     * 
     */
    public java.lang.String getLearningTimeSearchFilter();
    
    /**
     * Sets the <code>intendedEndUserRoleSearchFilter</code> field.
     *
     * 
     */
    public void setIntendedEndUserRoleSearchFilter(java.lang.String intendedEndUserRoleSearchFilter);

    /**
     * Gets the <code>intendedEndUserRoleSearchFilter</code> field.
     *
     * 
     */
    public java.lang.String getIntendedEndUserRoleSearchFilter();    
    
}

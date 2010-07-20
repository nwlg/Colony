// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>buscarDetalleODE</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.detallar.DetallarController</code> controller.
 *
 * <p>
 * Metodo que busca en el buscador el detalle del ODE que le han
 * encargado detallar.
 * </p>
 * <p>
 * Este metodo solo tiene que llamar al servicio de Buscar,
 * preguntarle por el identificador que le pasan, este le devuelve
 * los detalles del objeto a mostrar y se rellenan los campos del
 * formulario.
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#buscarDetalleODE
 */
public interface BuscarDetalleODEForm
{
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
     * Sets the <code>licencias</code> field.
     *
     * 
     */
    public void setLicencias(java.lang.String licencias);

    /**
     * Gets the <code>licencias</code> field.
     *
     * 
     */
    public java.lang.String getLicencias();
    
    /**
     * Resets the <code>licencias</code> field.
     */
    public void resetLicencias();

    /**
     * Sets the <code>posicionamientoAnterior</code> field.
     *
     * 
     */
    public void setPosicionamientoAnterior(java.lang.String posicionamientoAnterior);

    /**
     * Gets the <code>posicionamientoAnterior</code> field.
     *
     * 
     */
    public java.lang.String getPosicionamientoAnterior();
    
    /**
     * Resets the <code>posicionamientoAnterior</code> field.
     */
    public void resetPosicionamientoAnterior();

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
     * Sets the <code>posicionamientoSiguiente</code> field.
     *
     * 
     */
    public void setPosicionamientoSiguiente(java.lang.String posicionamientoSiguiente);

    /**
     * Gets the <code>posicionamientoSiguiente</code> field.
     *
     * 
     */
    public java.lang.String getPosicionamientoSiguiente();
    
    /**
     * Resets the <code>posicionamientoSiguiente</code> field.
     */
    public void resetPosicionamientoSiguiente();

    /**
     * Sets the <code>numVecesVisto</code> field.
     *
     * 
     */
    public void setNumVecesVisto(java.lang.String numVecesVisto);

    /**
     * Gets the <code>numVecesVisto</code> field.
     *
     * 
     */
    public java.lang.String getNumVecesVisto();
    
    /**
     * Resets the <code>numVecesVisto</code> field.
     */
    public void resetNumVecesVisto();

    /**
     * Sets the <code>agregarFederado</code> field.
     *
     * 
     */
    public void setAgregarFederado(java.lang.Boolean agregarFederado);

    /**
     * Gets the <code>agregarFederado</code> field.
     *
     * 
     */
    public java.lang.Boolean getAgregarFederado();
    
    /**
     * Resets the <code>agregarFederado</code> field.
     */
    public void resetAgregarFederado();

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
     * Sets the <code>numVecesDescargado</code> field.
     *
     * 
     */
    public void setNumVecesDescargado(java.lang.String numVecesDescargado);

    /**
     * Gets the <code>numVecesDescargado</code> field.
     *
     * 
     */
    public java.lang.String getNumVecesDescargado();
    
    /**
     * Resets the <code>numVecesDescargado</code> field.
     */
    public void resetNumVecesDescargado();

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
     * Sets the <code>tamanio</code> field.
     *
     * 
     */
    public void setTamanio(java.lang.String tamanio);

    /**
     * Gets the <code>tamanio</code> field.
     *
     * 
     */
    public java.lang.String getTamanio();
    
    /**
     * Resets the <code>tamanio</code> field.
     */
    public void resetTamanio();

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
     * Sets the <code>identificadorODE</code> field.
     *
     * 
     */
    public void setIdentificadorODE(java.lang.String identificadorODE);

    /**
     * Gets the <code>identificadorODE</code> field.
     *
     * 
     */
    public java.lang.String getIdentificadorODE();
    
    /**
     * Resets the <code>identificadorODE</code> field.
     */
    public void resetIdentificadorODE();

    /**
     * Sets the <code>existeSesion</code> field.
     *
     * 
     */
    public void setExisteSesion(java.lang.Boolean existeSesion);

    /**
     * Gets the <code>existeSesion</code> field.
     *
     * 
     */
    public java.lang.Boolean getExisteSesion();
    
    /**
     * Resets the <code>existeSesion</code> field.
     */
    public void resetExisteSesion();

    /**
     * Sets the <code>imagenAmpliada</code> field.
     *
     * 
     */
    public void setImagenAmpliada(java.lang.String imagenAmpliada);

    /**
     * Gets the <code>imagenAmpliada</code> field.
     *
     * 
     */
    public java.lang.String getImagenAmpliada();
    
    /**
     * Resets the <code>imagenAmpliada</code> field.
     */
    public void resetImagenAmpliada();

    /**
     * Sets the <code>seleccionarSecuencia</code> field.
     *
     * 
     */
    public void setSeleccionarSecuencia(java.lang.Boolean seleccionarSecuencia);

    /**
     * Gets the <code>seleccionarSecuencia</code> field.
     *
     * 
     */
    public java.lang.Boolean getSeleccionarSecuencia();
    
    /**
     * Resets the <code>seleccionarSecuencia</code> field.
     */
    public void resetSeleccionarSecuencia();

    /**
     * Sets the <code>numVecesEnviado</code> field.
     *
     * 
     */
    public void setNumVecesEnviado(java.lang.String numVecesEnviado);

    /**
     * Gets the <code>numVecesEnviado</code> field.
     *
     * 
     */
    public java.lang.String getNumVecesEnviado();
    
    /**
     * Resets the <code>numVecesEnviado</code> field.
     */
    public void resetNumVecesEnviado();

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
     * Sets the <code>nrComentarios</code> field.
     *
     * 
     */
    public void setNrComentarios(String nrComentarios);

    /**
     * Gets the <code>nrComentarios</code> field.
     *
     * 
     */
    public String getNrComentarios();
    
    /**
     * Resets the <code>nrComentarios</code> field.
     */
    public void resetNrComentarios();

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
     * Sets the <code>ambito</code> field.
     *
     * 
     */
    public void setAmbito(java.lang.String ambito);

    /**
     * Gets the <code>ambito</code> field.
     *
     * 
     */
    public java.lang.String getAmbito();
    
    /**
     * Resets the <code>ambito</code> field.
     */
    public void resetAmbito();

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

    /**
     * Sets the <code>usuarioLogado</code> field.
     *
     * <p>
     * Devuelve true/false en función de si el usuario LDAP está
     * conectado.
     * </p>
     */
    public void setUsuarioLogado(java.lang.Boolean usuarioLogado);

    /**
     * Gets the <code>usuarioLogado</code> field.
     *
     * <p>
     * Devuelve true/false en función de si el usuario LDAP está
     * conectado.
     * </p>
     */
    public java.lang.Boolean getUsuarioLogado();
    
    /**
     * Resets the <code>usuarioLogado</code> field.
     */
    public void resetUsuarioLogado();

    /**
     * Sets the <code>existenEtiquetas</code> field.
     *
     * <p>
     * indica si existen etiquetas sociales asociadas al ODE
     * </p>
     */
    public void setExistenEtiquetas(java.lang.Boolean existenEtiquetas);

    /**
     * Gets the <code>existenEtiquetas</code> field.
     *
     * <p>
     * indica si existen etiquetas sociales asociadas al ODE
     * </p>
     */
    public java.lang.Boolean getExistenEtiquetas();
    
    /**
     * Resets the <code>existenEtiquetas</code> field.
     */
    public void resetExistenEtiquetas();

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
     * Sets the <code>fechaPublicacion</code> field.
     *
     * 
     */
    public void setFechaPublicacion(java.lang.String fechaPublicacion);

    /**
     * Gets the <code>fechaPublicacion</code> field.
     *
     * 
     */
    public java.lang.String getFechaPublicacion();
    
    /**
     * Resets the <code>fechaPublicacion</code> field.
     */
    public void resetFechaPublicacion();

    /**
     * Sets the <code>numVecesPrevisualizado</code> field.
     *
     * 
     */
    public void setNumVecesPrevisualizado(java.lang.String numVecesPrevisualizado);

    /**
     * Gets the <code>numVecesPrevisualizado</code> field.
     *
     * 
     */
    public java.lang.String getNumVecesPrevisualizado();
    
    /**
     * Resets the <code>numVecesPrevisualizado</code> field.
     */
    public void resetNumVecesPrevisualizado();

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
     * Sets the <code>etiquetas</code> field.
     *
     * <p>
     * etiquetas sociales asociadas al ODE
     * </p>
     */
    public void setEtiquetas(java.lang.String[] etiquetas);

    /**
     * Gets the <code>etiquetas</code> field.
     *
     * <p>
     * etiquetas sociales asociadas al ODE
     * </p>
     */
    public java.lang.String[] getEtiquetas();
    
    /**
     * Resets the <code>etiquetas</code> field.
     */
    public void resetEtiquetas();


    /**
     * Sets the <code>size</code> field.
     *
     * <p>
     * size sociales asociadas al ODE
     * </p>
     */
    public void setSize(java.lang.String size);

    /**
     * Gets the <code>size</code> field.
     *
     * <p>
     * size sociales asociadas al ODE
     * </p>
     */
    public java.lang.String getSize();
    
    /**
     * Resets the <code>size</code> field.
     */
    public void resetSize();

    /**
     * Sets the <code>learningResourceType</code> field.
     *
     * <p>
     * learningResourceType sociales asociadas al ODE
     * </p>
     */
    public void setLearningResourceType(java.lang.String learningResourceType);

    /**
     * Gets the <code>learningResourceType</code> field.
     *
     * <p>
     * learningResourceType sociales asociadas al ODE
     * </p>
     */
    public java.lang.String getLearningResourceType();
    
    /**
     * Resets the <code>learningResourceType</code> field.
     */
    public void resetLearningResourceType();

    /**
     * Sets the <code>annotation</code> field.
     *
     * <p>
     * annotation sociales asociadas al ODE
     * </p>
     */
    public void setAnnotation(java.lang.String annotation);

    /**
     * Gets the <code>annotation</code> field.
     *
     * <p>
     * annotation sociales asociadas al ODE
     * </p>
     */
    public java.lang.String getAnnotation();
    
    /**
     * Resets the <code>annotation</code> field.
     */
    public void resetAnnotation();

}

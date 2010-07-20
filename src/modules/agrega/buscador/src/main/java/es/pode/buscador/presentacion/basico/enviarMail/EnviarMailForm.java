// license-header java merge-point
package es.pode.buscador.presentacion.basico.enviarMail;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>enviarMail</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.enviarMail.EnviarMailController</code> controller.
 *
 * <p>
 * Valida el formulario de envio y, en caso de ser correcto, envía
 * los mails con la url del ode.
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.enviarMail.EnviarMailController#enviarMail
 */
public interface EnviarMailForm
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
     * Sets the <code>urlImagen</code> field.
     *
     * 
     */
    public void setUrlImagen(java.lang.String urlImagen);

    /**
     * Gets the <code>urlImagen</code> field.
     *
     * 
     */
    public java.lang.String getUrlImagen();
    
    /**
     * Resets the <code>urlImagen</code> field.
     */
    public void resetUrlImagen();

    /**
     * Sets the <code>enviarRemitente</code> field.
     *
     * 
     */
    public void setEnviarRemitente(java.lang.Boolean enviarRemitente);

    /**
     * Gets the <code>enviarRemitente</code> field.
     *
     * 
     */
    public java.lang.Boolean getEnviarRemitente();
    
    /**
     * Resets the <code>enviarRemitente</code> field.
     */
    public void resetEnviarRemitente();

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
     * Sets the <code>correosHasta</code> field.
     *
     * 
     */
    public void setCorreosHasta(java.lang.String correosHasta);

    /**
     * Gets the <code>correosHasta</code> field.
     *
     * 
     */
    public java.lang.String getCorreosHasta();
    
    /**
     * Resets the <code>correosHasta</code> field.
     */
    public void resetCorreosHasta();

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
     * Sets the <code>resumen</code> field.
     *
     * 
     */
    public void setResumen(java.lang.String resumen);

    /**
     * Gets the <code>resumen</code> field.
     *
     * 
     */
    public java.lang.String getResumen();
    
    /**
     * Resets the <code>resumen</code> field.
     */
    public void resetResumen();

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
     * Sets the <code>nombresHasta</code> field.
     *
     * 
     */
    public void setNombresHasta(java.lang.String nombresHasta);

    /**
     * Gets the <code>nombresHasta</code> field.
     *
     * 
     */
    public java.lang.String getNombresHasta();
    
    /**
     * Resets the <code>nombresHasta</code> field.
     */
    public void resetNombresHasta();

    /**
     * Sets the <code>correoDesde</code> field.
     *
     * 
     */
    public void setCorreoDesde(java.lang.String correoDesde);

    /**
     * Gets the <code>correoDesde</code> field.
     *
     * 
     */
    public java.lang.String getCorreoDesde();
    
    /**
     * Resets the <code>correoDesde</code> field.
     */
    public void resetCorreoDesde();

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
     * Sets the <code>nombreDesde</code> field.
     *
     * 
     */
    public void setNombreDesde(java.lang.String nombreDesde);

    /**
     * Gets the <code>nombreDesde</code> field.
     *
     * 
     */
    public java.lang.String getNombreDesde();
    
    /**
     * Resets the <code>nombreDesde</code> field.
     */
    public void resetNombreDesde();

    /**
     * Sets the <code>resultadoValidacion</code> field.
     *
     * 
     */
    public void setResultadoValidacion(java.lang.String resultadoValidacion);

    /**
     * Gets the <code>resultadoValidacion</code> field.
     *
     * 
     */
    public java.lang.String getResultadoValidacion();
    
    /**
     * Resets the <code>resultadoValidacion</code> field.
     */
    public void resetResultadoValidacion();

}

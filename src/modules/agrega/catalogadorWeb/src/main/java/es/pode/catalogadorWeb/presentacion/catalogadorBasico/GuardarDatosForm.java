// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasico;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>guardarDatos</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatBasicoController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatBasicoController#guardarDatos
 */
public interface GuardarDatosForm
{
    /**
     * Sets the <code>idiomaDestinatario</code> field.
     *
     * 
     */
    public void setIdiomaDestinatario(java.lang.String idiomaDestinatario);

    /**
     * Gets the <code>idiomaDestinatario</code> field.
     *
     * 
     */
    public java.lang.String getIdiomaDestinatario();
    
    /**
     * Resets the <code>idiomaDestinatario</code> field.
     */
    public void resetIdiomaDestinatario();

    /**
     * Sets the <code>tipoRecurso</code> field.
     *
     * 
     */
    public void setTipoRecurso(java.lang.String tipoRecurso);

    /**
     * Gets the <code>tipoRecurso</code> field.
     *
     * 
     */
    public java.lang.String getTipoRecurso();
    
    /**
     * Resets the <code>tipoRecurso</code> field.
     */
    public void resetTipoRecurso();

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
     * Sets the <code>usuario</code> field.
     *
     * 
     */
    public void setUsuario(java.lang.String usuario);

    /**
     * Gets the <code>usuario</code> field.
     *
     * 
     */
    public java.lang.String getUsuario();
    
    /**
     * Resets the <code>usuario</code> field.
     */
    public void resetUsuario();

    /**
     * Sets the <code>identificador</code> field.
     *
     * 
     */
    public void setIdentificador(java.lang.String identificador);

    /**
     * Gets the <code>identificador</code> field.
     *
     * 
     */
    public java.lang.String getIdentificador();
    
    /**
     * Resets the <code>identificador</code> field.
     */
    public void resetIdentificador();

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
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setArboles#sArray(Object[])
     */
    public void setArboles(java.util.Collection arboles);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getArboles#sArray()
     */
    public java.util.Collection getArboles();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setArboles(java.util.Collection)
     */
    public void setArbolesAsArray(Object[] arboles);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getArboles()
     */
    public java.lang.Object[] getArbolesAsArray();

    /**
     * Resets the <code>arboles</code> field.
     */
    public void resetArboles();

    /**
     * The <code>arboles</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getArboles()
     * @see #getArbolesValueList()
     * @see #getArbolesLabelList()
     * @see #setArbolesLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getArbolesBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * arboles property. This method takes a collection of objects, as well as
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
     * But you need to populate the arboles backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setArbolesBackingList(valueObjects, "id", "name")</code>
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
     * @see #getArboles()
     * @see #getArbolesValueList()
     * @see #getArbolesLabelList()
     * @see #getArbolesLabelList()
     */
    public void setArbolesBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>arboles</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getArboles()
     * @see #getArbolesBackingList()
     */
    public java.lang.Object[] getArbolesValueList();

    /**
     * The <code>arboles</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getArboles()
     * @see #getArbolesBackingList()
     */
    public void setArbolesValueList(java.lang.Object[] arbolesValueList);

    /**
     * The <code>arboles</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getArboles()
     * @see #getArbolesBackingList()
     */
    public java.lang.Object[] getArbolesLabelList();

    /**
     * The <code>arboles</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getArboles()
     * @see #getArbolesBackingList()
     */
    public void setArbolesLabelList(java.lang.Object[] arbolesLabelList);

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
     * Sets the <code>accion</code> field.
     *
     * 
     */
    public void setAccion(java.lang.String accion);

    /**
     * Gets the <code>accion</code> field.
     *
     * 
     */
    public java.lang.String getAccion();
    
    /**
     * Resets the <code>accion</code> field.
     */
    public void resetAccion();

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

}

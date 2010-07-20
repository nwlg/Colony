// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasico;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargarDatos</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatBasicoController</code> controller.
 *
 * <p>
 * Metodo que realiza una llamada al metodo obtenerCombos del
 * servicio SrvVocabulariosControladosService y al metodo
 * obtenerLomBasico  que devuelve un LomBasicoVO del servicio
 * SrvCatalogacionBasicaService.
 * </p>
 * <p>
 * Una vez obtenido un LomBasicoVO se podran rellenar los campos
 * los campos del formulario.
 * </p>
 * <p>
 * Si el objeto de sesion esta vacio, el metodo cargarDatos
 * obtendra los datos del objeto Lom guardado en la tabla hash. Sin
 * embargo, si el objeto de sesion contiene datos, el metodo
 * cargarDatos obtendra los datos del mismo.
 * </p>
 *
 * @see es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatBasicoController#cargarDatos
 */
public interface CargarDatosForm
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
     * The <code>idiomaDestinatario</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getIdiomaDestinatario()
     * @see #getIdiomaDestinatarioValueList()
     * @see #getIdiomaDestinatarioLabelList()
     * @see #setIdiomaDestinatarioLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getIdiomaDestinatarioBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * idiomaDestinatario property. This method takes a collection of objects, as well as
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
     * But you need to populate the idiomaDestinatario backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setIdiomaDestinatarioBackingList(valueObjects, "id", "name")</code>
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
     * @see #getIdiomaDestinatario()
     * @see #getIdiomaDestinatarioValueList()
     * @see #getIdiomaDestinatarioLabelList()
     * @see #getIdiomaDestinatarioLabelList()
     */
    public void setIdiomaDestinatarioBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>idiomaDestinatario</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getIdiomaDestinatario()
     * @see #getIdiomaDestinatarioBackingList()
     */
    public java.lang.Object[] getIdiomaDestinatarioValueList();

    /**
     * The <code>idiomaDestinatario</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getIdiomaDestinatario()
     * @see #getIdiomaDestinatarioBackingList()
     */
    public void setIdiomaDestinatarioValueList(java.lang.Object[] idiomaDestinatarioValueList);

    /**
     * The <code>idiomaDestinatario</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getIdiomaDestinatario()
     * @see #getIdiomaDestinatarioBackingList()
     */
    public java.lang.Object[] getIdiomaDestinatarioLabelList();

    /**
     * The <code>idiomaDestinatario</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getIdiomaDestinatario()
     * @see #getIdiomaDestinatarioBackingList()
     */
    public void setIdiomaDestinatarioLabelList(java.lang.Object[] idiomaDestinatarioLabelList);

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
     * The <code>tipoRecurso</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getTipoRecurso()
     * @see #getTipoRecursoValueList()
     * @see #getTipoRecursoLabelList()
     * @see #setTipoRecursoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getTipoRecursoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * tipoRecurso property. This method takes a collection of objects, as well as
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
     * But you need to populate the tipoRecurso backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setTipoRecursoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getTipoRecurso()
     * @see #getTipoRecursoValueList()
     * @see #getTipoRecursoLabelList()
     * @see #getTipoRecursoLabelList()
     */
    public void setTipoRecursoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>tipoRecurso</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getTipoRecurso()
     * @see #getTipoRecursoBackingList()
     */
    public java.lang.Object[] getTipoRecursoValueList();

    /**
     * The <code>tipoRecurso</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getTipoRecurso()
     * @see #getTipoRecursoBackingList()
     */
    public void setTipoRecursoValueList(java.lang.Object[] tipoRecursoValueList);

    /**
     * The <code>tipoRecurso</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getTipoRecurso()
     * @see #getTipoRecursoBackingList()
     */
    public java.lang.Object[] getTipoRecursoLabelList();

    /**
     * The <code>tipoRecurso</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getTipoRecurso()
     * @see #getTipoRecursoBackingList()
     */
    public void setTipoRecursoLabelList(java.lang.Object[] tipoRecursoLabelList);

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
     * The <code>idioma</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getIdioma()
     * @see #getIdiomaValueList()
     * @see #getIdiomaLabelList()
     * @see #setIdiomaLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getIdiomaBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * idioma property. This method takes a collection of objects, as well as
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
     * But you need to populate the idioma backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setIdiomaBackingList(valueObjects, "id", "name")</code>
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
     * @see #getIdioma()
     * @see #getIdiomaValueList()
     * @see #getIdiomaLabelList()
     * @see #getIdiomaLabelList()
     */
    public void setIdiomaBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>idioma</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getIdioma()
     * @see #getIdiomaBackingList()
     */
    public java.lang.Object[] getIdiomaValueList();

    /**
     * The <code>idioma</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getIdioma()
     * @see #getIdiomaBackingList()
     */
    public void setIdiomaValueList(java.lang.Object[] idiomaValueList);

    /**
     * The <code>idioma</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getIdioma()
     * @see #getIdiomaBackingList()
     */
    public java.lang.Object[] getIdiomaLabelList();

    /**
     * The <code>idioma</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getIdioma()
     * @see #getIdiomaBackingList()
     */
    public void setIdiomaLabelList(java.lang.Object[] idiomaLabelList);

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
     * Sets the <code>idiomaPortal</code> field.
     *
     * 
     */
    public void setIdiomaPortal(java.lang.String idiomaPortal);

    /**
     * Gets the <code>idiomaPortal</code> field.
     *
     * 
     */
    public java.lang.String getIdiomaPortal();
    
    /**
     * Resets the <code>idiomaPortal</code> field.
     */
    public void resetIdiomaPortal();

    /**
     * Sets the <code>returnURL</code> field.
     *
     * 
     */
    public void setReturnURL(java.lang.String returnURL);

    /**
     * Gets the <code>returnURL</code> field.
     *
     * 
     */
    public java.lang.String getReturnURL();
    
    /**
     * Resets the <code>returnURL</code> field.
     */
    public void resetReturnURL();

}

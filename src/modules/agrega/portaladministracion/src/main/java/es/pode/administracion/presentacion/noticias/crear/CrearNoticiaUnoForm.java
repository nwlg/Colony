// license-header java merge-point
package es.pode.administracion.presentacion.noticias.crear;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>crearNoticiaUno</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.noticias.crear.CrearController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.noticias.crear.CrearController#crearNoticiaUno
 */
public interface CrearNoticiaUnoForm
{
    /**
     * Sets the <code>alineamiento</code> field.
     *
     * 
     */
    public void setAlineamiento(java.lang.Integer alineamiento);

    /**
     * Gets the <code>alineamiento</code> field.
     *
     * 
     */
    public java.lang.Integer getAlineamiento();
    
    /**
     * Resets the <code>alineamiento</code> field.
     */
    public void resetAlineamiento();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIdiomasAlta#sArray(Object[])
     */
    public void setIdiomasAlta(java.util.Collection idiomasAlta);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIdiomasAlta#sArray()
     */
    public java.util.Collection getIdiomasAlta();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIdiomasAlta(java.util.Collection)
     */
    public void setIdiomasAltaAsArray(Object[] idiomasAlta);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIdiomasAlta()
     */
    public java.lang.Object[] getIdiomasAltaAsArray();

    /**
     * Resets the <code>idiomasAlta</code> field.
     */
    public void resetIdiomasAlta();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIdiomasCategoriasBBDD#sArray(Object[])
     */
    public void setIdiomasCategoriasBBDD(java.util.Collection idiomasCategoriasBBDD);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIdiomasCategoriasBBDD#sArray()
     */
    public java.util.Collection getIdiomasCategoriasBBDD();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIdiomasCategoriasBBDD(java.util.Collection)
     */
    public void setIdiomasCategoriasBBDDAsArray(Object[] idiomasCategoriasBBDD);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIdiomasCategoriasBBDD()
     */
    public java.lang.Object[] getIdiomasCategoriasBBDDAsArray();

    /**
     * Resets the <code>idiomasCategoriasBBDD</code> field.
     */
    public void resetIdiomasCategoriasBBDD();

    /**
     * Sets the <code>catalan</code> field.
     *
     * 
     */
    public void setCatalan(java.lang.String[] catalan);

    /**
     * Gets the <code>catalan</code> field.
     *
     * 
     */
    public java.lang.String[] getCatalan();
    
    /**
     * Resets the <code>catalan</code> field.
     */
    public void resetCatalan();

    /**
     * The <code>catalan</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getCatalan()
     * @see #getCatalanValueList()
     * @see #getCatalanLabelList()
     * @see #setCatalanLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getCatalanBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * catalan property. This method takes a collection of objects, as well as
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
     * But you need to populate the catalan backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setCatalanBackingList(valueObjects, "id", "name")</code>
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
     * @see #getCatalan()
     * @see #getCatalanValueList()
     * @see #getCatalanLabelList()
     * @see #getCatalanLabelList()
     */
    public void setCatalanBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>catalan</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getCatalan()
     * @see #getCatalanBackingList()
     */
    public java.lang.Object[] getCatalanValueList();

    /**
     * The <code>catalan</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getCatalan()
     * @see #getCatalanBackingList()
     */
    public void setCatalanValueList(java.lang.Object[] catalanValueList);

    /**
     * The <code>catalan</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getCatalan()
     * @see #getCatalanBackingList()
     */
    public java.lang.Object[] getCatalanLabelList();

    /**
     * The <code>catalan</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getCatalan()
     * @see #getCatalanBackingList()
     */
    public void setCatalanLabelList(java.lang.Object[] catalanLabelList);

    /**
     * Sets the <code>gallego</code> field.
     *
     * 
     */
    public void setGallego(java.lang.String[] gallego);

    /**
     * Gets the <code>gallego</code> field.
     *
     * 
     */
    public java.lang.String[] getGallego();
    
    /**
     * Resets the <code>gallego</code> field.
     */
    public void resetGallego();

    /**
     * The <code>gallego</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getGallego()
     * @see #getGallegoValueList()
     * @see #getGallegoLabelList()
     * @see #setGallegoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getGallegoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * gallego property. This method takes a collection of objects, as well as
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
     * But you need to populate the gallego backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setGallegoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getGallego()
     * @see #getGallegoValueList()
     * @see #getGallegoLabelList()
     * @see #getGallegoLabelList()
     */
    public void setGallegoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>gallego</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getGallego()
     * @see #getGallegoBackingList()
     */
    public java.lang.Object[] getGallegoValueList();

    /**
     * The <code>gallego</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getGallego()
     * @see #getGallegoBackingList()
     */
    public void setGallegoValueList(java.lang.Object[] gallegoValueList);

    /**
     * The <code>gallego</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getGallego()
     * @see #getGallegoBackingList()
     */
    public java.lang.Object[] getGallegoLabelList();

    /**
     * The <code>gallego</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getGallego()
     * @see #getGallegoBackingList()
     */
    public void setGallegoLabelList(java.lang.Object[] gallegoLabelList);

    /**
     * Sets the <code>activarImagen</code> field.
     *
     * 
     */
    public void setActivarImagen(java.lang.Integer activarImagen);

    /**
     * Gets the <code>activarImagen</code> field.
     *
     * 
     */
    public java.lang.Integer getActivarImagen();
    
    /**
     * Resets the <code>activarImagen</code> field.
     */
    public void resetActivarImagen();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setResumen#sArray(Object[])
     */
    public void setResumen(java.util.Collection resumen);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getResumen#sArray()
     */
    public java.util.Collection getResumen();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setResumen(java.util.Collection)
     */
    public void setResumenAsArray(Object[] resumen);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getResumen()
     */
    public java.lang.Object[] getResumenAsArray();

    /**
     * Resets the <code>resumen</code> field.
     */
    public void resetResumen();

    /**
     * Sets the <code>categoria</code> field.
     *
     * 
     */
    public void setCategoria(java.lang.Long categoria);

    /**
     * Gets the <code>categoria</code> field.
     *
     * 
     */
    public java.lang.Long getCategoria();
    
    /**
     * Resets the <code>categoria</code> field.
     */
    public void resetCategoria();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setNombreCategoria#sArray(Object[])
     */
    public void setNombreCategoria(java.util.Collection nombreCategoria);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getNombreCategoria#sArray()
     */
    public java.util.Collection getNombreCategoria();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setNombreCategoria(java.util.Collection)
     */
    public void setNombreCategoriaAsArray(Object[] nombreCategoria);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getNombreCategoria()
     */
    public java.lang.Object[] getNombreCategoriaAsArray();

    /**
     * Resets the <code>nombreCategoria</code> field.
     */
    public void resetNombreCategoria();

    /**
     * Sets the <code>imagen</code> Struts FormFile field to the specified value.
     *
     * 
     */
    public void setImagen(org.apache.struts.upload.FormFile imagen);


    /**
     * Gets the <code>imagen</code> Struts FormFile field value.
     *
     * 
     */
    public org.apache.struts.upload.FormFile getImagen();

    /**
     * Resets the <code>imagen</code> field.
     */
    public void resetImagen();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setTitulo#sArray(Object[])
     */
    public void setTitulo(java.util.Collection titulo);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getTitulo#sArray()
     */
    public java.util.Collection getTitulo();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setTitulo(java.util.Collection)
     */
    public void setTituloAsArray(Object[] titulo);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getTitulo()
     */
    public java.lang.Object[] getTituloAsArray();

    /**
     * Resets the <code>titulo</code> field.
     */
    public void resetTitulo();

    /**
     * Sets the <code>castellano</code> field.
     *
     * 
     */
    public void setCastellano(java.lang.String[] castellano);

    /**
     * Gets the <code>castellano</code> field.
     *
     * 
     */
    public java.lang.String[] getCastellano();
    
    /**
     * Resets the <code>castellano</code> field.
     */
    public void resetCastellano();

    /**
     * The <code>castellano</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getCastellano()
     * @see #getCastellanoValueList()
     * @see #getCastellanoLabelList()
     * @see #setCastellanoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getCastellanoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * castellano property. This method takes a collection of objects, as well as
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
     * But you need to populate the castellano backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setCastellanoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getCastellano()
     * @see #getCastellanoValueList()
     * @see #getCastellanoLabelList()
     * @see #getCastellanoLabelList()
     */
    public void setCastellanoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>castellano</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getCastellano()
     * @see #getCastellanoBackingList()
     */
    public java.lang.Object[] getCastellanoValueList();

    /**
     * The <code>castellano</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getCastellano()
     * @see #getCastellanoBackingList()
     */
    public void setCastellanoValueList(java.lang.Object[] castellanoValueList);

    /**
     * The <code>castellano</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getCastellano()
     * @see #getCastellanoBackingList()
     */
    public java.lang.Object[] getCastellanoLabelList();

    /**
     * The <code>castellano</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getCastellano()
     * @see #getCastellanoBackingList()
     */
    public void setCastellanoLabelList(java.lang.Object[] castellanoLabelList);

    /**
     * Sets the <code>ingles</code> field.
     *
     * 
     */
    public void setIngles(java.lang.String[] ingles);

    /**
     * Gets the <code>ingles</code> field.
     *
     * 
     */
    public java.lang.String[] getIngles();
    
    /**
     * Resets the <code>ingles</code> field.
     */
    public void resetIngles();

    /**
     * The <code>ingles</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getIngles()
     * @see #getInglesValueList()
     * @see #getInglesLabelList()
     * @see #setInglesLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getInglesBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * ingles property. This method takes a collection of objects, as well as
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
     * But you need to populate the ingles backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setInglesBackingList(valueObjects, "id", "name")</code>
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
     * @see #getIngles()
     * @see #getInglesValueList()
     * @see #getInglesLabelList()
     * @see #getInglesLabelList()
     */
    public void setInglesBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>ingles</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getIngles()
     * @see #getInglesBackingList()
     */
    public java.lang.Object[] getInglesValueList();

    /**
     * The <code>ingles</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getIngles()
     * @see #getInglesBackingList()
     */
    public void setInglesValueList(java.lang.Object[] inglesValueList);

    /**
     * The <code>ingles</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getIngles()
     * @see #getInglesBackingList()
     */
    public java.lang.Object[] getInglesLabelList();

    /**
     * The <code>ingles</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getIngles()
     * @see #getInglesBackingList()
     */
    public void setInglesLabelList(java.lang.Object[] inglesLabelList);

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setIdiomas#sArray(Object[])
     */
    public void setIdiomas(java.util.Collection idiomas);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getIdiomas#sArray()
     */
    public java.util.Collection getIdiomas();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setIdiomas(java.util.Collection)
     */
    public void setIdiomasAsArray(Object[] idiomas);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getIdiomas()
     */
    public java.lang.Object[] getIdiomasAsArray();

    /**
     * Resets the <code>idiomas</code> field.
     */
    public void resetIdiomas();

    /**
     * Sets the <code>estado</code> field.
     *
     * 
     */
    public void setEstado(java.lang.Boolean estado);

    /**
     * Gets the <code>estado</code> field.
     *
     * 
     */
    public java.lang.Boolean getEstado();
    
    /**
     * Resets the <code>estado</code> field.
     */
    public void resetEstado();

    /**
     * Sets the <code>valenciano</code> field.
     *
     * 
     */
    public void setValenciano(java.lang.String[] valenciano);

    /**
     * Gets the <code>valenciano</code> field.
     *
     * 
     */
    public java.lang.String[] getValenciano();
    
    /**
     * Resets the <code>valenciano</code> field.
     */
    public void resetValenciano();

    /**
     * The <code>valenciano</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getValenciano()
     * @see #getValencianoValueList()
     * @see #getValencianoLabelList()
     * @see #setValencianoLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getValencianoBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * valenciano property. This method takes a collection of objects, as well as
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
     * But you need to populate the valenciano backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setValencianoBackingList(valueObjects, "id", "name")</code>
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
     * @see #getValenciano()
     * @see #getValencianoValueList()
     * @see #getValencianoLabelList()
     * @see #getValencianoLabelList()
     */
    public void setValencianoBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>valenciano</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getValenciano()
     * @see #getValencianoBackingList()
     */
    public java.lang.Object[] getValencianoValueList();

    /**
     * The <code>valenciano</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getValenciano()
     * @see #getValencianoBackingList()
     */
    public void setValencianoValueList(java.lang.Object[] valencianoValueList);

    /**
     * The <code>valenciano</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getValenciano()
     * @see #getValencianoBackingList()
     */
    public java.lang.Object[] getValencianoLabelList();

    /**
     * The <code>valenciano</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getValenciano()
     * @see #getValencianoBackingList()
     */
    public void setValencianoLabelList(java.lang.Object[] valencianoLabelList);

    /**
     * Sets the <code>euskera</code> field.
     *
     * 
     */
    public void setEuskera(java.lang.String[] euskera);

    /**
     * Gets the <code>euskera</code> field.
     *
     * 
     */
    public java.lang.String[] getEuskera();
    
    /**
     * Resets the <code>euskera</code> field.
     */
    public void resetEuskera();

    /**
     * The <code>euskera</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getEuskera()
     * @see #getEuskeraValueList()
     * @see #getEuskeraLabelList()
     * @see #setEuskeraLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getEuskeraBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * euskera property. This method takes a collection of objects, as well as
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
     * But you need to populate the euskera backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setEuskeraBackingList(valueObjects, "id", "name")</code>
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
     * @see #getEuskera()
     * @see #getEuskeraValueList()
     * @see #getEuskeraLabelList()
     * @see #getEuskeraLabelList()
     */
    public void setEuskeraBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>euskera</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getEuskera()
     * @see #getEuskeraBackingList()
     */
    public java.lang.Object[] getEuskeraValueList();

    /**
     * The <code>euskera</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getEuskera()
     * @see #getEuskeraBackingList()
     */
    public void setEuskeraValueList(java.lang.Object[] euskeraValueList);

    /**
     * The <code>euskera</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getEuskera()
     * @see #getEuskeraBackingList()
     */
    public java.lang.Object[] getEuskeraLabelList();

    /**
     * The <code>euskera</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getEuskera()
     * @see #getEuskeraBackingList()
     */
    public void setEuskeraLabelList(java.lang.Object[] euskeraLabelList);

    /**
     * Sets the <code>nombreImagen</code> field.
     *
     * 
     */
    public void setNombreImagen(java.lang.String nombreImagen);

    /**
     * Gets the <code>nombreImagen</code> field.
     *
     * 
     */
    public java.lang.String getNombreImagen();
    
    /**
     * Resets the <code>nombreImagen</code> field.
     */
    public void resetNombreImagen();

    /**
     * This field is a collection type, and this method allows you to set it into the form.
     *
     * 
     *
     * @see #setCuerpo#sArray(Object[])
     */
    public void setCuerpo(java.util.Collection cuerpo);

    /**
     * This field is a collection type, and this method allows you to get it from the form.
     *
     * 
     *
     * @see #getCuerpo#sArray()
     */
    public java.util.Collection getCuerpo();

    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setCuerpo(java.util.Collection)
     */
    public void setCuerpoAsArray(Object[] cuerpo);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getCuerpo()
     */
    public java.lang.Object[] getCuerpoAsArray();

    /**
     * Resets the <code>cuerpo</code> field.
     */
    public void resetCuerpo();

}

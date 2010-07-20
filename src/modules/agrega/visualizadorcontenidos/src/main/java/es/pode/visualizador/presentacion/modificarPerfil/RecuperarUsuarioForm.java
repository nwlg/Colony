// license-header java merge-point
package es.pode.visualizador.presentacion.modificarPerfil;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarUsuario</code> method, which is located on the
 * <code>es.pode.visualizador.presentacion.modificarPerfil.ModificarPerfilController</code> controller.
 *
 * 
 *
 * @see es.pode.visualizador.presentacion.modificarPerfil.ModificarPerfilController#recuperarUsuario
 */
public interface RecuperarUsuarioForm
{
    /**
     * Sets the <code>apellido2</code> field.
     *
     * 
     */
    public void setApellido2(java.lang.String apellido2);

    /**
     * Gets the <code>apellido2</code> field.
     *
     * 
     */
    public java.lang.String getApellido2();
    
    /**
     * Resets the <code>apellido2</code> field.
     */
    public void resetApellido2();

    /**
     * Sets the <code>openIdUrl</code> field.
     *
     * 
     */
    public void setOpenIdUrl(java.lang.String openIdUrl);

    /**
     * Gets the <code>openIdUrl</code> field.
     *
     * 
     */
    public java.lang.String getOpenIdUrl();
    
    /**
     * Resets the <code>openIdUrl</code> field.
     */
    public void resetOpenIdUrl();

    /**
     * Sets the <code>tipoCatalogador</code> field.
     *
     * 
     */
    public void setTipoCatalogador(java.lang.String tipoCatalogador);

    /**
     * Gets the <code>tipoCatalogador</code> field.
     *
     * 
     */
    public java.lang.String getTipoCatalogador();
    
    /**
     * Resets the <code>tipoCatalogador</code> field.
     */
    public void resetTipoCatalogador();

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
     * Sets the <code>apellido1</code> field.
     *
     * 
     */
    public void setApellido1(java.lang.String apellido1);

    /**
     * Gets the <code>apellido1</code> field.
     *
     * 
     */
    public java.lang.String getApellido1();
    
    /**
     * Resets the <code>apellido1</code> field.
     */
    public void resetApellido1();

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
     * Sets the <code>cuota</code> field.
     *
     * 
     */
    public void setCuota(long cuota);

    /**
     * Gets the <code>cuota</code> field.
     *
     * 
     */
    public long getCuota();
    
    /**
     * Resets the <code>cuota</code> field.
     */
    public void resetCuota();

    /**
     * Sets the <code>nombre</code> field.
     *
     * 
     */
    public void setNombre(java.lang.String nombre);

    /**
     * Gets the <code>nombre</code> field.
     *
     * 
     */
    public java.lang.String getNombre();
    
    /**
     * Resets the <code>nombre</code> field.
     */
    public void resetNombre();

    /**
     * Sets the <code>id</code> field.
     *
     * 
     */
    public void setId(java.lang.Long id);

    /**
     * Gets the <code>id</code> field.
     *
     * 
     */
    public java.lang.Long getId();
    
    /**
     * Resets the <code>id</code> field.
     */
    public void resetId();

    /**
     * Sets the <code>rolEmpaquetador</code> field.
     *
     * 
     */
    public void setRolEmpaquetador(java.lang.String rolEmpaquetador);

    /**
     * Gets the <code>rolEmpaquetador</code> field.
     *
     * 
     */
    public java.lang.String getRolEmpaquetador();
    
    /**
     * Resets the <code>rolEmpaquetador</code> field.
     */
    public void resetRolEmpaquetador();

    /**
     * Sets the <code>tipoEmpaquetador</code> field.
     *
     * 
     */
    public void setTipoEmpaquetador(java.lang.String tipoEmpaquetador);

    /**
     * Gets the <code>tipoEmpaquetador</code> field.
     *
     * 
     */
    public java.lang.String getTipoEmpaquetador();
    
    /**
     * Resets the <code>tipoEmpaquetador</code> field.
     */
    public void resetTipoEmpaquetador();

    /**
     * The <code>tipoEmpaquetador</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getTipoEmpaquetador()
     * @see #getTipoEmpaquetadorValueList()
     * @see #getTipoEmpaquetadorLabelList()
     * @see #setTipoEmpaquetadorLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getTipoEmpaquetadorBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * tipoEmpaquetador property. This method takes a collection of objects, as well as
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
     * But you need to populate the tipoEmpaquetador backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setTipoEmpaquetadorBackingList(valueObjects, "id", "name")</code>
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
     * @see #getTipoEmpaquetador()
     * @see #getTipoEmpaquetadorValueList()
     * @see #getTipoEmpaquetadorLabelList()
     * @see #getTipoEmpaquetadorLabelList()
     */
    public void setTipoEmpaquetadorBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>tipoEmpaquetador</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getTipoEmpaquetador()
     * @see #getTipoEmpaquetadorBackingList()
     */
    public java.lang.Object[] getTipoEmpaquetadorValueList();

    /**
     * The <code>tipoEmpaquetador</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getTipoEmpaquetador()
     * @see #getTipoEmpaquetadorBackingList()
     */
    public void setTipoEmpaquetadorValueList(java.lang.Object[] tipoEmpaquetadorValueList);

    /**
     * The <code>tipoEmpaquetador</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getTipoEmpaquetador()
     * @see #getTipoEmpaquetadorBackingList()
     */
    public java.lang.Object[] getTipoEmpaquetadorLabelList();

    /**
     * The <code>tipoEmpaquetador</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getTipoEmpaquetador()
     * @see #getTipoEmpaquetadorBackingList()
     */
    public void setTipoEmpaquetadorLabelList(java.lang.Object[] tipoEmpaquetadorLabelList);

    /**
     * Sets the <code>rolCatalogador</code> field.
     *
     * 
     */
    public void setRolCatalogador(java.lang.String rolCatalogador);

    /**
     * Gets the <code>rolCatalogador</code> field.
     *
     * 
     */
    public java.lang.String getRolCatalogador();
    
    /**
     * Resets the <code>rolCatalogador</code> field.
     */
    public void resetRolCatalogador();

    /**
     * Sets the <code>email</code> field.
     *
     * 
     */
    public void setEmail(java.lang.String email);

    /**
     * Gets the <code>email</code> field.
     *
     * 
     */
    public java.lang.String getEmail();
    
    /**
     * Resets the <code>email</code> field.
     */
    public void resetEmail();

    /**
     * Sets the <code>clave</code> field.
     *
     * 
     */
    public void setClave(java.lang.String clave);

    /**
     * Gets the <code>clave</code> field.
     *
     * 
     */
    public java.lang.String getClave();
    
    /**
     * Resets the <code>clave</code> field.
     */
    public void resetClave();

    /**
     * Sets the <code>NIF</code> field.
     *
     * 
     */
    public void setNIF(java.lang.String NIF);

    /**
     * Gets the <code>NIF</code> field.
     *
     * 
     */
    public java.lang.String getNIF();
    
    /**
     * Resets the <code>NIF</code> field.
     */
    public void resetNIF();

    /**
     * Sets the <code>idiomaBusqueda</code> field.
     *
     * 
     */
    public void setIdiomaBusqueda(java.lang.String idiomaBusqueda);

    /**
     * Gets the <code>idiomaBusqueda</code> field.
     *
     * 
     */
    public java.lang.String getIdiomaBusqueda();
    
    /**
     * Resets the <code>idiomaBusqueda</code> field.
     */
    public void resetIdiomaBusqueda();

    /**
     * The <code>idiomaBusqueda</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getIdiomaBusqueda()
     * @see #getIdiomaBusquedaValueList()
     * @see #getIdiomaBusquedaLabelList()
     * @see #setIdiomaBusquedaLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getIdiomaBusquedaBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * idiomaBusqueda property. This method takes a collection of objects, as well as
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
     * But you need to populate the idiomaBusqueda backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setIdiomaBusquedaBackingList(valueObjects, "id", "name")</code>
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
     * @see #getIdiomaBusqueda()
     * @see #getIdiomaBusquedaValueList()
     * @see #getIdiomaBusquedaLabelList()
     * @see #getIdiomaBusquedaLabelList()
     */
    public void setIdiomaBusquedaBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>idiomaBusqueda</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getIdiomaBusqueda()
     * @see #getIdiomaBusquedaBackingList()
     */
    public java.lang.Object[] getIdiomaBusquedaValueList();

    /**
     * The <code>idiomaBusqueda</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getIdiomaBusqueda()
     * @see #getIdiomaBusquedaBackingList()
     */
    public void setIdiomaBusquedaValueList(java.lang.Object[] idiomaBusquedaValueList);

    /**
     * The <code>idiomaBusqueda</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getIdiomaBusqueda()
     * @see #getIdiomaBusquedaBackingList()
     */
    public java.lang.Object[] getIdiomaBusquedaLabelList();

    /**
     * The <code>idiomaBusqueda</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getIdiomaBusqueda()
     * @see #getIdiomaBusquedaBackingList()
     */
    public void setIdiomaBusquedaLabelList(java.lang.Object[] idiomaBusquedaLabelList);

    /**
     * Sets the <code>rolAdministrador</code> field.
     *
     * 
     */
    public void setRolAdministrador(java.lang.String rolAdministrador);

    /**
     * Gets the <code>rolAdministrador</code> field.
     *
     * 
     */
    public java.lang.String getRolAdministrador();
    
    /**
     * Resets the <code>rolAdministrador</code> field.
     */
    public void resetRolAdministrador();

    /**
     * Sets the <code>repitaClave</code> field.
     *
     * 
     */
    public void setRepitaClave(java.lang.String repitaClave);

    /**
     * Gets the <code>repitaClave</code> field.
     *
     * 
     */
    public java.lang.String getRepitaClave();
    
    /**
     * Resets the <code>repitaClave</code> field.
     */
    public void resetRepitaClave();

}

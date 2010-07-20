package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

/*
 * Global interface containing all of the form fields. By using this as a superclass
 * we can shared more code in the controllers/forms and hence rid ourselves of a lot
 * of unnecessary code duplication
 */

public interface CatalogadorBasicPlusForm {

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
     * Sets the <code>description</code> field.
     *
     * 
     */
    public void setDescription(java.lang.String description);

    /**
     * Gets the <code>description</code> field.
     *
     * 
     */
    public java.lang.String getDescription();
    
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
     * Sets the <code>aggregationLevel</code> field.
     *
     * 
     */
    public void setAggregationLevel(java.lang.String aggregationLevel);

    /**
     * Gets the <code>aggregationLevel</code> field.
     *
     * 
     */
    public java.lang.String getAggregationLevel();
    
    
    /**
     * The <code>aggregation level</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getAggregationLevel()
     * @see #getAggregationLevelValueList()
     * @see #getAggregationLevelLabelList()
     * @see #setAggregationLevelLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getAggregationLevelBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * aggregation level property. This method takes a collection of objects, as well as
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
     * But you need to populate the aggregation level backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setAggregationLevelBackingList(valueObjects, "id", "name")</code>
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
     * @see #getAggregationLevel()
     * @see #getAggregationLevelValueList()
     * @see #getAggregationLevelLabelList()
     * @see #getAggregationLevelLabelList()
     */
    public void setAggregationLevelBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>aggregation level</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getAggregationLevel()
     * @see #getAggregationLevelBackingList()
     */
    public java.lang.Object[] getAggregationLevelValueList();

    /**
     * The <code>aggregation level</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getAggregationLevel()
     * @see #getAggregationLevelBackingList()
     */
    public void setAggregationLevelValueList(java.lang.Object[] aggregationLevelValueList);

    /**
     * The <code>aggregation level</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getAggregationLevel()
     * @see #getAggregationLevelBackingList()
     */
    public java.lang.Object[] getAggregationLevelLabelList();

    /**
     * The <code>aggregation level</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getAggregationLevel()
     * @see #getAggregationLevelBackingList()
     */
    public void setAggregationLevelLabelList(java.lang.Object[] aggregationLevelLabelList);

    /**
     * Sets the <code>authorFullName</code> field.
     *
     * 
     */
    public void setAuthorFullName(java.lang.String fullname);

    /**
     * Gets the <code>authorFullName</code> field.
     *
     * 
     */
    public java.lang.String getAuthorFullName();

    /**
     * Sets the <code>authorOrganisation</code> field.
     *
     * 
     */
    public void setAuthorOrganisation(java.lang.String organisation);

    /**
     * Gets the <code>authorOrganisation</code> field.
     *
     * 
     */
    public java.lang.String getAuthorOrganisation();

    /**
     * Sets the <code>providerFullName</code> field.
     *
     * 
     */
    public void setProviderFullName(java.lang.String fullname);

    /**
     * Gets the <code>providerFullName</code> field.
     *
     * 
     */
    public java.lang.String getProviderFullName();

    /**
     * Sets the <code>technicalOrCompositeType</code> field.
     *
     * 
     */
    public void setTechnicalOrCompositeType(java.lang.String technicalOrCompositeType);

    /**
     * Gets the <code>technicalOrCompositeType</code> field.
     *
     * 
     */
    public java.lang.String getTechnicalOrCompositeType();
    
    /**
     * The <code>technicalOrCompositeType</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getTechnicalOrCompositeType()
     * @see #getTechnicalOrCompositeTypeValueList()
     * @see #getTechnicalOrCompositeTypeLabelList()
     * @see #setTechnicalOrCompositeTypeLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getTechnicalOrCompositeTypeBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * TechnicalOrCompositeType property. This method takes a collection of objects, as well as
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
     * <code>setTechnicalOrCompositeTypeBackingList(valueObjects, "id", "name")</code>
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
     * @see #getTechnicalOrCompositeType()
     * @see #getTechnicalOrCompositeTypeValueList()
     * @see #getTechnicalOrCompositeTypeLabelList()
     * @see #getTechnicalOrCompositeTypeLabelList()
     */
    public void setTechnicalOrCompositeTypeBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>TechnicalOrCompositeType</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getTechnicalOrCompositeType()
     * @see #getTechnicalOrCompositeTypeBackingList()
     */
    public java.lang.Object[] getTechnicalOrCompositeTypeValueList();

    /**
     * The <code>TechnicalOrCompositeType</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getTechnicalOrCompositeType()
     * @see #getTechnicalOrCompositeTypeBackingList()
     */
    public void setTechnicalOrCompositeTypeValueList(java.lang.Object[] TechnicalOrCompositeTypeValueList);

    /**
     * The <code>TechnicalOrCompositeType</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getTechnicalOrCompositeType()
     * @see #getTechnicalOrCompositeTypeBackingList()
     */
    public java.lang.Object[] getTechnicalOrCompositeTypeLabelList();

    /**
     * The <code>TechnicalOrCompositeType</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getTechnicalOrCompositeType()
     * @see #getTechnicalOrCompositeTypeBackingList()
     */
    public void setTechnicalOrCompositeTypeLabelList(java.lang.Object[] TechnicalOrCompositeTypeLabelList);

    /**
     * Sets the <code>technicalOrCompositeName</code> field.
     *
     * 
     */
    public void setTechnicalOrCompositeName(java.lang.String technicalOrCompositeName);

    /**
     * Gets the <code>technicalOrCompositeName</code> field.
     *
     * 
     */
    public java.lang.String getTechnicalOrCompositeName();
    
    /**
     * The <code>technicalOrCompositeName</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getTechnicalOrCompositeName()
     * @see #getTechnicalOrCompositeNameValueList()
     * @see #getTechnicalOrCompositeNameLabelList()
     * @see #setTechnicalOrCompositeNameLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getTechnicalOrCompositeNameBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * TechnicalOrCompositeName property. This method takes a collection of objects, as well as
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
     * <code>setTechnicalOrCompositeNameBackingList(valueObjects, "id", "name")</code>
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
     * @see #getTechnicalOrCompositeName()
     * @see #getTechnicalOrCompositeNameValueList()
     * @see #getTechnicalOrCompositeNameLabelList()
     * @see #getTechnicalOrCompositeNameLabelList()
     */
    public void setTechnicalOrCompositeNameBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>TechnicalOrCompositeName</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getTechnicalOrCompositeName()
     * @see #getTechnicalOrCompositeNameBackingList()
     */
    public java.lang.Object[] getTechnicalOrCompositeNameValueList();

    /**
     * The <code>TechnicalOrCompositeName</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getTechnicalOrCompositeName()
     * @see #getTechnicalOrCompositeNameBackingList()
     */
    public void setTechnicalOrCompositeNameValueList(java.lang.Object[] TechnicalOrCompositeNameValueList);

    /**
     * The <code>TechnicalOrCompositeName</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getTechnicalOrCompositeName()
     * @see #getTechnicalOrCompositeNameBackingList()
     */
    public java.lang.Object[] getTechnicalOrCompositeNameLabelList();

    /**
     * The <code>TechnicalOrCompositeName</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getTechnicalOrCompositeName()
     * @see #getTechnicalOrCompositeNameBackingList()
     */
    public void setTechnicalOrCompositeNameLabelList(java.lang.Object[] TechnicalOrCompositeNameLabelList);
        
    /**
     * Sets the <code>installationNotes</code> field.
     *
     * 
     */
    public void setInstallationNotes(java.lang.String installationNotes);

    /**
     * Gets the <code>installationNotes</code> field.
     *
     * 
     */
    public java.lang.String getInstallationNotes();
    
    /**
     * Sets the <code>platformRequirements</code> field.
     *
     * 
     */
    public void setPlatformRequirements(java.lang.String platformRequirements);

    /**
     * Gets the <code>platformRequirements</code> field.
     *
     * 
     */
    public java.lang.String getPlatformRequirements();

    /**
     * Sets the <code>durationYears</code> field.
     *
     * 
     */
    public void setDurationYears(java.lang.String durationYears);

    /**
     * Gets the <code>durationYears</code> field.
     *
     * 
     */
    public java.lang.String getDurationYears();

    /**
     * Sets the <code>durationMonths</code> field.
     *
     * 
     */
    public void setDurationMonths(java.lang.String durationMonths);

    /**
     * Gets the <code>durationDays</code> field.
     *
     * 
     */
    public java.lang.String getDurationDays();

    /**
     * Sets the <code>durationDays</code> field.
     *
     * 
     */
    public void setDurationDays(java.lang.String durationDays);

    /**
     * Gets the <code>durationMonths</code> field.
     *
     * 
     */
    public java.lang.String getDurationMonths();
    
    /**
     * Sets the <code>durationHours</code> field.
     *
     * 
     */
    public void setDurationHours(java.lang.String durationHours);

    /**
     * Gets the <code>durationHours</code> field.
     *
     * 
     */
    public java.lang.String getDurationHours();

    /**
     * Sets the <code>durationMinutes</code> field.
     *
     * 
     */
    public void setDurationMinutes(java.lang.String durationMinutes);

    /**
     * Gets the <code>durationMinutes</code> field.
     *
     * 
     */
    public java.lang.String getDurationMinutes();
    
    /**
     * Sets the <code>durationSeconds</code> field.
     *
     * 
     */
    public void setDurationSeconds(java.lang.String durationSeconds);

    /**
     * Gets the <code>durationSeconds</code> field.
     *
     * 
     */
    public java.lang.String getDurationSeconds();

    /**
     * Sets the <code>notes</code> field.
     *
     * 
     */
    public void setNotes(java.lang.String notes);

    /**
     * Gets the <code>notes</code> field.
     *
     * 
     */
    public java.lang.String getNotes();

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
     * Sets the <code>intendedEndUserRole</code> field.
     *
     * 
     */
    public void setIntendedEndUserRole(java.lang.String intendedEndUserRole);
    
    /**
     * Gets the <code>intendedEndUserRole</code> field.
     *
     * 
     */
    public java.lang.String getIntendedEndUserRole();
    
    /**
     * The <code>intendedEndUserRole</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getIntendedEndUserRole()
     * @see #getIntendedEndUserRoleValueList()
     * @see #getIntendedEndUserRoleLabelList()
     * @see #setIntendedEndUserRoleLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getIntendedEndUserRoleBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * intendedEndUserRole property. This method takes a collection of objects, as well as
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
     * <code>setIntendedEndUserRoleBackingList(valueObjects, "id", "name")</code>
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
     * @see #getIntendedEndUserRole()
     * @see #getIntendedEndUserRoleValueList()
     * @see #getIntendedEndUserRoleLabelList()
     * @see #getIntendedEndUserRoleLabelList()
     */
    public void setIntendedEndUserRoleBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>intendedEndUserRole</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getIntendedEndUserRole()
     * @see #getIntendedEndUserRoleBackingList()
     */
    public java.lang.Object[] getIntendedEndUserRoleValueList();

    /**
     * The <code>intendedEndUserRole</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getIntendedEndUserRole()
     * @see #getIntendedEndUserRoleBackingList()
     */
    public void setIntendedEndUserRoleValueList(java.lang.Object[] intendedEndUserRoleValueList);

    /**
     * The <code>intendedEndUserRole</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getIntendedEndUserRole()
     * @see #getIntendedEndUserRoleBackingList()
     */
    public java.lang.Object[] getIntendedEndUserRoleLabelList();

    /**
     * The <code>intendedEndUserRole</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getIntendedEndUserRole()
     * @see #getIntendedEndUserRoleBackingList()
     */
    public void setIntendedEndUserRoleLabelList(java.lang.Object[] intendedEndUserRole);

    /**
     * Sets the <code>format</code> field.
     *
     * 
     */
    public void setFormat(java.lang.String format);
    
    /**
     * Gets the <code>format</code> field.
     *
     * 
     */
    public java.lang.String getFormat();
    
    /**
     * The <code>format</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getFormat()
     * @see #getFormatValueList()
     * @see #getFormatLabelList()
     * @see #setFormatLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getFormatBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * format property. This method takes a collection of objects, as well as
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
     * But you need to populate the format backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setFormatBackingList(valueObjects, "id", "name")</code>
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
     * @see #getFormat()
     * @see #getFormatValueList()
     * @see #getFormatLabelList()
     * @see #getFormatLabelList()
     */
    public void setFormatBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>format</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getFormat()
     * @see #getFormatBackingList()
     */
    public java.lang.Object[] getFormatValueList();

    /**
     * The <code>format</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getFormat()
     * @see #getFormatBackingList()
     */
    public void setFormatValueList(java.lang.Object[] formatValueList);

    /**
     * The <code>format</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getFormat()
     * @see #getFormatBackingList()
     */
    public java.lang.Object[] getFormatLabelList();

    /**
     * The <code>format</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getFormat()
     * @see #getFormatBackingList()
     */
    public void setFormatLabelList(java.lang.Object[] formatLabelList);

    
    /**
     * Sets the <code>typicalLearningTimeYears</code> field.
     *
     * 
     */
    public void setTypicalLearningTimeYears(java.lang.String typicalLearningTimeYears);

    /**
     * Gets the <code>typicalLearningTimeYears</code> field.
     *
     * 
     */
    public java.lang.String getTypicalLearningTimeYears();

    /**
     * Sets the <code>typicalLearningTimeMonths</code> field.
     *
     * 
     */
    public void setTypicalLearningTimeMonths(java.lang.String typicalLearningTimeMonths);

    /**
     * Gets the <code>typicalLearningTimeDays</code> field.
     *
     * 
     */
    public java.lang.String getTypicalLearningTimeDays();

    /**
     * Sets the <code>typicalLearningTimeDays</code> field.
     *
     * 
     */
    public void setTypicalLearningTimeDays(java.lang.String typicalLearningTimeDays);

    /**
     * Gets the <code>typicalLearningTimeMonths</code> field.
     *
     * 
     */
    public java.lang.String getTypicalLearningTimeMonths();
    
    /**
     * Sets the <code>typicalLearningTimeHours</code> field.
     *
     * 
     */
    public void setTypicalLearningTimeHours(java.lang.String typicalLearningTimeHours);

    /**
     * Gets the <code>typicalLearningTimeHours</code> field.
     *
     * 
     */
    public java.lang.String getTypicalLearningTimeHours();

    /**
     * Sets the <code>typicalLearningTimeMinutes</code> field.
     *
     * 
     */
    public void setTypicalLearningTimeMinutes(java.lang.String typicalLearningTimeMinutes);

    /**
     * Gets the <code>typicalLearningTimeMinutes</code> field.
     *
     * 
     */
    public java.lang.String getTypicalLearningTimeMinutes();
    
    /**
     * Sets the <code>typicalLearningTimeFull</code> field.
     *
     * 
     */
    public void setTypicalLearningTimeFull(java.lang.String typicalLearningTimeFull);
    
    /**
     * Gets the <code>typicalLearningTimeFull</code> field.
     *
     * 
     */
    public java.lang.String getTypicalLearningTimeFull();
    
    /**
     * The <code>typicalLearningTimeFull</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getTypicalLearningTimeFull()
     * @see #getTypicalLearningTimeFullValueList()
     * @see #getTypicalLearningTimeFullLabelList()
     * @see #setTypicalLearningTimeFullLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getTypicalLearningTimeFullBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * typicalLearningTimeFull property. This method takes a collection of objects, as well as
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
     * But you need to populate the typicalLearningTimeFull backing list with the <code>id</code> properties as the values and the
     * <code>name</code> properties as the labels then you would make a call like this:
     * <code>setTypicalLearningTimeFullBackingList(valueObjects, "id", "name")</code>
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
     * @see #getTypicalLearningTimeFull()
     * @see #getTypicalLearningTimeFullValueList()
     * @see #getTypicalLearningTimeFullLabelList()
     * @see #getTypicalLearningTimeFullLabelList()
     */
    public void setTypicalLearningTimeFullBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>typicalLearningTimeFull</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getTypicalLearningTimeFull()
     * @see #getTypicalLearningTimeFullBackingList()
     */
    public java.lang.Object[] getTypicalLearningTimeFullValueList();

    /**
     * The <code>typicalLearningTimeFull</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getTypicalLearningTimeFull()
     * @see #getTypicalLearningTimeFullBackingList()
     */
    public void setTypicalLearningTimeFullValueList(java.lang.Object[] typicalLearningTimeFullValueList);

    /**
     * The <code>typicalLearningTimeFull</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getTypicalLearningTimeFull()
     * @see #getTypicalLearningTimeFullBackingList()
     */
    public java.lang.Object[] getTypicalLearningTimeFullLabelList();

    /**
     * The <code>typicalLearningTimeFull</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getTypicalLearningTimeFull()
     * @see #getTypicalLearningTimeFullBackingList()
     */
    public void setTypicalLearningTimeFullLabelList(java.lang.Object[] idiomaLabelList);    
    
    /**
     * Sets the <code>relationKind</code> field.
     *
     * 
     */
    public void setRelationKind(java.lang.String relationKind);
    
    /**
     * Gets the <code>relationKind</code> field.
     *
     * 
     */
    public java.lang.String getRelationKind();
    
    /**
     * The <code>relationKind</code> field can be selected from a list,
     * this method allows you to retrieve the current elements from that list.
     * <p/>
     * <i>Please note that the elements from that list are key value pairs, so you will
     * need to call <code>getLabel()</code> and <code>getValue()</code> to get the label and
     * value for this entry respectively.</i>
     *
     * @see #getRelationKind()
     * @see #getRelationKindValueList()
     * @see #getRelationKindLabelList()
     * @see #setRelationKindLabelList(java.util.Collection,java.lang.String,java.lang.String)
     */
    public java.lang.Object[] getRelationKindBackingList();

    /**
     * Convenient method to quickly set the value and label backinglist for the
     * relationKind property. This method takes a collection of objects, as well as
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
     * <code>setRelationKindBackingList(valueObjects, "id", "name")</code>
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
     * @see #getRelationKindRole()
     * @see #getRelationKindValueList()
     * @see #getRelationKindLabelList()
     * @see #getRelationKindLabelList()
     */
    public void setRelationKindBackingList(java.util.Collection items, String valueProperty, String labelProperty);

    /**
     * The <code>relationKind</code> field can be selected from a list,
     * this method allows you to retrieve the values from that list.
     *
     * @see #getRelationKindRole()
     * @see #getRelationKindBackingList()
     */
    public java.lang.Object[] getRelationKindValueList();

    /**
     * The <code>relationKindRole</code> field can be selected from a list,
     * this method allows you to set the values for that list.
     *
     * @see #getRelationKindRole()
     * @see #getRelationKindBackingList()
     */
    public void setRelationKindValueList(java.lang.Object[] relationKindValueList);

    /**
     * The <code>relationKind</code> field can be selected from a list,
     * this method allows you to retrieve the labels from that list.
     *
     * @see #getRelationKindRole()
     * @see #getRelationKindBackingList()
     */
    public java.lang.Object[] getRelationKindLabelList();

    /**
     * The <code>relationKindRole</code> field can be selected from a list,
     * this method allows you to set the labels for that list.
     *
     * @see #getRelationKindRole()
     * @see #getRelationKindBackingList()
     */
    public void setRelationKindLabelList(java.lang.Object[] relationKind);

    /**
     * Sets the <code>relationKindEntry</code> field.
     *
     * 
     */
    public void setRelationKindEntry(java.lang.String entry);

    /**
     * Gets the <code>relationKindEntry</code> field.
     *
     * 
     */
    public java.lang.String getRelationKindEntry();
    
    
    /**
     * Sets the <code>relationKindDescription</code> field.
     *
     * 
     */
    public void setRelationKindDescription(java.lang.String description);

    /**
     * Gets the <code>relationKindDescription</code> field.
     *
     * 
     */
    public java.lang.String getRelationKindDescription();
	
    /**
     * This field is a collection type, and this method allows you to set it as an
     * array into the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #setCurriculumTrees(java.util.Collection)
     */
    public void setCurriculumTreesAsArray(Object[] curriculumTrees);

    /**
     * This field is a collection type, and this method allows you to get it as an
     * array from the form, conversion will be automatically performed.
     *
     * 
     *
     * @see #getCurriculumTrees()
     */
    public java.lang.Object[] getCurriculumTreesAsArray();
}


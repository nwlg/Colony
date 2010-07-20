// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

public class CatalogadorBasicPlusFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatalogadorBasicPlusForm
        , es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CargarDatosForm
        , es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.EliminarArbolForm
{
    private java.lang.String titulo;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.lang.String description;
    private java.lang.String keyword;
    private java.lang.String aggregationLevel;
    private java.lang.Object[] aggregationLevelValueList;
    private java.lang.Object[] aggregationLevelLabelList;
    private java.lang.String authorFullName;
    private java.lang.String authorOrganisation;
    private java.lang.String providerFullName;
    private java.lang.String technicalOrCompositeType;
    private java.lang.Object[] technicalOrCompositeTypeValueList;
    private java.lang.Object[] technicalOrCompositeTypeLabelList;
    private java.lang.String technicalOrCompositeName;
    private java.lang.Object[] technicalOrCompositeNameValueList;
    private java.lang.Object[] technicalOrCompositeNameLabelList;
    private java.lang.String installationNotes;
    private java.lang.String platformRequirements;
    private java.lang.String durationYears;
    private java.lang.String durationMonths;
    private java.lang.String durationDays;
    private java.lang.String durationHours;
    private java.lang.String durationMinutes;
    private java.lang.String durationSeconds;
    private java.lang.String notes;
    private java.lang.String tipoRecurso;
    private java.lang.Object[] tipoRecursoValueList;
    private java.lang.Object[] tipoRecursoLabelList;
    private java.lang.String format;
    private java.lang.Object[] formatValueList;
    private java.lang.Object[] formatLabelList;
    private java.lang.String intendedEndUserRole;
    private java.lang.Object[] intendedEndUserRoleValueList;
    private java.lang.Object[] intendedEndUserRoleLabelList;
    private java.lang.String typicalLearningTimeYears;
    private java.lang.String typicalLearningTimeMonths;
    private java.lang.String typicalLearningTimeDays;
    private java.lang.String typicalLearningTimeHours;
    private java.lang.String typicalLearningTimeMinutes;
    private java.lang.String typicalLearningTimeFull;
    private java.lang.Object[] typicalLearningTimeFullValueList;
    private java.lang.Object[] typicalLearningTimeFullLabelList;
    private java.lang.String relationKind;
    private java.lang.Object[] relationKindValueList;
    private java.lang.Object[] relationKindLabelList;
    private java.lang.String relationKindEntry;
    private java.lang.String relationKindDescription;
    
    // Curriculum Trees
    private java.util.Collection curriculumTrees;

    // Form Tree Ids specified for deletion
    private java.lang.String idArbol;
    
    
    public CatalogadorBasicPlusFormImpl()
    {
    }

    public void setTitulo(java.lang.String titulo)
    {
        this.titulo = titulo;
    }

    /**
     * 
     */
    public java.lang.String getTitulo()
    {
        return this.titulo;
    }
    
    public void setIdioma(java.lang.String idioma)
    {
        this.idioma = idioma;
    }

    /**
     * 
     */
    public java.lang.String getIdioma()
    {
        return this.idioma;
    }
    
    /*
     * Get BackingList containing the list of language labels/values
     */
    public java.lang.Object[] getIdiomaBackingList()
    {
        java.lang.Object[] values = this.idiomaValueList;
        java.lang.Object[] labels = this.idiomaLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getIdiomaValueList()
    {
        return this.idiomaValueList;
    }

    public void setIdiomaValueList(java.lang.Object[] idiomaValueList)
    {
        this.idiomaValueList = idiomaValueList;
    }

    public java.lang.Object[] getIdiomaLabelList()
    {
        return this.idiomaLabelList;
    }

    public void setIdiomaLabelList(java.lang.Object[] idiomaLabelList)
    {
        this.idiomaLabelList = idiomaLabelList;
    }

    /*
     * Set BackingList required for language labels
     */
    
    public void setIdiomaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CatalogadorBasicoFormImpl.setIdiomaBackingList requires non-null property arguments");
        }

        this.idiomaValueList = null;
        this.idiomaLabelList = null;

        if (items != null)
        {
            this.idiomaValueList = new java.lang.Object[items.size()];
            this.idiomaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CatalogadorBasicoFormImpl.setIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Set the description field
     */
    public void setDescription(java.lang.String description)
    {
        this.description = description;
    }

    /**
     * Get the description field
     */
    public java.lang.String getDescription()
    {
        return this.description;
    }
    
    /**
     * Set the keyword field
     */
    public void setKeyword(java.lang.String keyword)
    {
        this.keyword = keyword;
    }

    /**
     * Get the keyword field
     */
    public java.lang.String getKeyword()
    {
        return this.keyword;
    }
    
    /**
     * Set the aggregationLevel field
     */
    public void setAggregationLevel(java.lang.String aggregationLevel)
    {
        this.aggregationLevel = aggregationLevel;
    }

    /**
     * Get the aggregationLevel field
     */
    public java.lang.String getAggregationLevel()
    {
        return this.aggregationLevel;
    }
    
    
    /*
     * Get BackingList containing the list of aggregation level labels/values
     */
    public java.lang.Object[] getAggregationLevelBackingList()
    {
        java.lang.Object[] values = this.aggregationLevelValueList;
        java.lang.Object[] labels = this.aggregationLevelLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getAggregationLevelValueList()
    {
        return this.aggregationLevelValueList;
    }

    public void setAggregationLevelValueList(java.lang.Object[] aggregationLevelValueList)
    {
        this.aggregationLevelValueList = aggregationLevelValueList;
    }

    public java.lang.Object[] getAggregationLevelLabelList()
    {
        return this.aggregationLevelLabelList;
    }

    public void setAggregationLevelLabelList(java.lang.Object[] aggregationLevelLabelList)
    {
        this.aggregationLevelLabelList = aggregationLevelLabelList;
    }

    /*
     * Set BackingList required for aggregation level labels
     */
    
    public void setAggregationLevelBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CatalogadorBasicoFormImpl.setAggregationLevelBackingList requires non-null property arguments");
        }

        this.aggregationLevelValueList = null;
        this.aggregationLevelLabelList = null;

        if (items != null)
        {
            this.aggregationLevelValueList = new java.lang.Object[items.size()];
            this.aggregationLevelLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.aggregationLevelValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.aggregationLevelLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CatalogadorBasicoFormImpl.setAggregationLevelBackingList encountered an exception", ex);
            }
        }
    }
    
    
    /**
     * Set the authorFullName field
     */
    public void setAuthorFullName(java.lang.String fullname)
    {
        this.authorFullName = fullname;
    }

    /**
     * Get the authorFullName field
     */
    public java.lang.String getAuthorFullName()
    {
        return this.authorFullName;
    }

    
    /**
     * Set the authorOrganisation field
     */
    public void setAuthorOrganisation(java.lang.String organisation)
    {
        this.authorOrganisation = organisation;
    }

    /**
     * Get the authorOrganisation field
     */
    public java.lang.String getAuthorOrganisation()
    {
        return this.authorOrganisation;
    }

    /**
     * Set the providerFullName field
     */
    public void setProviderFullName(java.lang.String fullname)
    {
        this.providerFullName = fullname;
    }

    /**
     * Get the providerFullName field
     */
    public java.lang.String getProviderFullName()
    {
        return this.providerFullName;
    }
    
    /**
     * Set the technicalOrCompositeType field
     */
    public void setTechnicalOrCompositeType(java.lang.String technicalOrCompositeType)
    {
        this.technicalOrCompositeType = technicalOrCompositeType;
    }

    /**
     * Get the technicalOrCompositeType field
     */
    public java.lang.String getTechnicalOrCompositeType()
    {
        return this.technicalOrCompositeType;
    }    
    
    /*
     * Set BackingList required for technicalOrComposite type labels
     */
    public java.lang.Object[] getTechnicalOrCompositeTypeBackingList()
    {
        java.lang.Object[] values = this.technicalOrCompositeTypeValueList;
        java.lang.Object[] labels = this.technicalOrCompositeTypeLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getTechnicalOrCompositeTypeValueList()
    {
        return this.technicalOrCompositeTypeValueList;
    }

    public void setTechnicalOrCompositeTypeValueList(java.lang.Object[] technicalOrCompositeTypeValueList)
    {
        this.technicalOrCompositeTypeValueList = technicalOrCompositeTypeValueList;
    }

    public java.lang.Object[] getTechnicalOrCompositeTypeLabelList()
    {
        return this.technicalOrCompositeTypeLabelList;
    }

    public void setTechnicalOrCompositeTypeLabelList(java.lang.Object[] technicalOrCompositeTypeLabelList)
    {
        this.technicalOrCompositeTypeLabelList = technicalOrCompositeTypeLabelList;
    }

    public void setTechnicalOrCompositeTypeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CatalogadorBasicPlusFormImpl.setTechnicalOrCompositeTypeBackingList requires non-null property arguments");
        }

        this.technicalOrCompositeTypeValueList = null;
        this.technicalOrCompositeTypeLabelList = null;

        if (items != null)
        {
            this.technicalOrCompositeTypeValueList = new java.lang.Object[items.size()];
            this.technicalOrCompositeTypeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.technicalOrCompositeTypeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.technicalOrCompositeTypeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CatalogadorBasicPlusFormImpl.setTechnicalOrCompositeTypeBackingList encountered an exception", ex);
            }
        }
    }
    
    /**
     * Set the technicalOrCompositeName field
     */
    public void setTechnicalOrCompositeName(java.lang.String technicalOrCompositeName)
    {
        this.technicalOrCompositeName = technicalOrCompositeName;
    }

    /**
     * Get the technicalOrCompositeName field
     */
    public java.lang.String getTechnicalOrCompositeName()
    {
        return this.technicalOrCompositeName;
    }    
    
    /*
     * Set BackingList required for technicalOrComposite name labels
     */
    public java.lang.Object[] getTechnicalOrCompositeNameBackingList()
    {
        java.lang.Object[] values = this.technicalOrCompositeNameValueList;
        java.lang.Object[] labels = this.technicalOrCompositeNameLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getTechnicalOrCompositeNameValueList()
    {
        return this.technicalOrCompositeNameValueList;
    }

    public void setTechnicalOrCompositeNameValueList(java.lang.Object[] technicalOrCompositeNameValueList)
    {
        this.technicalOrCompositeNameValueList = technicalOrCompositeNameValueList;
    }

    public java.lang.Object[] getTechnicalOrCompositeNameLabelList()
    {
        return this.technicalOrCompositeNameLabelList;
    }

    public void setTechnicalOrCompositeNameLabelList(java.lang.Object[] technicalOrCompositeNameLabelList)
    {
        this.technicalOrCompositeNameLabelList = technicalOrCompositeNameLabelList;
    }

    public void setTechnicalOrCompositeNameBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CatalogadorBasicPlusFormImpl.setTechnicalOrCompositeNameBackingList requires non-null property arguments");
        }

        this.technicalOrCompositeNameValueList = null;
        this.technicalOrCompositeNameLabelList = null;

        if (items != null)
        {
            this.technicalOrCompositeNameValueList = new java.lang.Object[items.size()];
            this.technicalOrCompositeNameLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.technicalOrCompositeNameValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.technicalOrCompositeNameLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CatalogadorBasicPlusFormImpl.setTechnicalOrCompositeNameBackingList encountered an exception", ex);
            }
        }
    }
    
    /**
     * Get the resource type field
     */
    public java.lang.String getTipoRecurso()
    {
        return this.tipoRecurso;
    }

    /**
     * Set the resource type field
     */
    public void setTipoRecurso(String tipoRecurso)
    {
        this.tipoRecurso = tipoRecurso;
    }
    
    public java.lang.Object[] getTipoRecursoBackingList()
    {
        java.lang.Object[] values = this.tipoRecursoValueList;
        java.lang.Object[] labels = this.tipoRecursoLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getTipoRecursoValueList()
    {
        return this.tipoRecursoValueList;
    }

    public void setTipoRecursoValueList(java.lang.Object[] tipoRecursoValueList)
    {
        this.tipoRecursoValueList = tipoRecursoValueList;
    }

    public java.lang.Object[] getTipoRecursoLabelList()
    {
        return this.tipoRecursoLabelList;
    }

    public void setTipoRecursoLabelList(java.lang.Object[] tipoRecursoLabelList)
    {
        this.tipoRecursoLabelList = tipoRecursoLabelList;
    }

    public void setTipoRecursoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CatalogadorBasicPlusFormImpl.setTipoRecursoBackingList requires non-null property arguments");
        }

        this.tipoRecursoValueList = null;
        this.tipoRecursoLabelList = null;

        if (items != null)
        {
            this.tipoRecursoValueList = new java.lang.Object[items.size()];
            this.tipoRecursoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoRecursoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoRecursoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CatalogadorBasicPlusFormImpl.setTipoRecursoBackingList encountered an exception", ex);
            }
        }
    }

    
    /**
     * Get the resource type field
     */
    public java.lang.String getFormat()
    {
        return this.format;
    }

    /**
     * Set the resource type field
     */
    public void setFormat(String format)
    {
        this.format = format;
    }
    
    public java.lang.Object[] getFormatBackingList()
    {
        java.lang.Object[] values = this.formatValueList;
        java.lang.Object[] labels = this.formatLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getFormatValueList()
    {
        return this.formatValueList;
    }

    public void setFormatValueList(java.lang.Object[] formatValueList)
    {
        this.formatValueList = formatValueList;
    }

    public java.lang.Object[] getFormatLabelList()
    {
        return this.formatLabelList;
    }

    public void setFormatLabelList(java.lang.Object[] formatLabelList)
    {
        this.formatLabelList = formatLabelList;
    }

    public void setFormatBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CatalogadorBasicPlusFormImpl.setFormatBackingList requires non-null property arguments");
        }

        this.formatValueList = null;
        this.formatLabelList = null;

        if (items != null)
        {
            this.formatValueList = new java.lang.Object[items.size()];
            this.formatLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.formatValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.formatLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CatalogadorBasicPlusFormImpl.setFormatBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Set the installatioNotes field
     */
    public void setInstallationNotes(java.lang.String installationNotes)
    {
        this.installationNotes = installationNotes;
    }

    /**
     * Get the installationNotes field
     */
    public java.lang.String getInstallationNotes()
    {
        return this.installationNotes;
    }
    
    /**
     * Set the platformRequirements field
     */
    public void setPlatformRequirements(java.lang.String platformRequirements)
    {
        this.platformRequirements = platformRequirements;
    }

    /**
     * Get the platformRequirements field
     */
    public java.lang.String getPlatformRequirements()
    {
        return this.platformRequirements;
    }

    /**
     * Set the durationYears field
     */
    public void setDurationYears(java.lang.String durationYears)
    {
        this.durationYears = durationYears;
    }

    /**
     * Get the durationYears field
     */
    public java.lang.String getDurationYears()
    {
        return this.durationYears;
    }

    /**
     * Set the durationMonths field
     */
    public void setDurationMonths(java.lang.String durationMonths)
    {
        this.durationMonths = durationMonths;
    }

    /**
     * Get the durationMonths field
     */
    public java.lang.String getDurationMonths()
    {
        return this.durationMonths;
    }

    /**
     * Set the durationDays field
     */
    public void setDurationDays(java.lang.String durationDays)
    {
        this.durationDays = durationDays;
    }

    /**
     * Get the durationDays field
     */
    public java.lang.String getDurationDays()
    {
        return this.durationDays;
    }
    
    /**
     * Set the durationHours field
     */
    public void setDurationHours(java.lang.String durationHours)
    {
        this.durationHours = durationHours;
    }

    /**
     * Get the durationHours field
     */
    public java.lang.String getDurationHours()
    {
        return this.durationHours;
    }

    /**
     * Set the durationMinutes field
     */
    public void setDurationMinutes(java.lang.String durationMinutes)
    {
        this.durationMinutes = durationMinutes;
    }

    /**
     * Get the durationMinutes field
     */
    public java.lang.String getDurationMinutes()
    {
        return this.durationMinutes;
    }
    
    /**
     * Set the durationSeconds field
     */
    public void setDurationSeconds(java.lang.String durationSeconds)
    {
        this.durationSeconds = durationSeconds;
    }

    /**
     * Get the durationSeconds field
     */
    public java.lang.String getDurationSeconds()
    {
        return this.durationSeconds;
    }

    /**
     * Set the notes field
     */
    public void setNotes(java.lang.String notes)
    {
        this.notes = notes;
    }

    /**
     * Get the notes field
     */
    public java.lang.String getNotes()
    {
        return this.notes;
    }

    /**
     * Get the intended end user role field
     */
    public java.lang.String getIntendedEndUserRole()
    {
        return this.intendedEndUserRole;
    }

    /**
     * Set the intended end user role field
     */
    public void setIntendedEndUserRole(String intendedEndUserRole)
    {
        this.intendedEndUserRole = intendedEndUserRole;
    }
    
    public java.lang.Object[] getIntendedEndUserRoleBackingList()
    {
        java.lang.Object[] values = this.intendedEndUserRoleValueList;
        java.lang.Object[] labels = this.intendedEndUserRoleLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getIntendedEndUserRoleValueList()
    {
        return this.intendedEndUserRoleValueList;
    }

    public void setIntendedEndUserRoleValueList(java.lang.Object[] intendedEndUserRoleValueList)
    {
        this.intendedEndUserRoleValueList = intendedEndUserRoleValueList;
    }

    public java.lang.Object[] getIntendedEndUserRoleLabelList()
    {
        return this.intendedEndUserRoleLabelList;
    }

    public void setIntendedEndUserRoleLabelList(java.lang.Object[] intendedEndUserRoleLabelList)
    {
        this.intendedEndUserRoleLabelList = intendedEndUserRoleLabelList;
    }

    public void setIntendedEndUserRoleBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CatalogadorBasicPlusFormImpl.setIntendedEndUserRoleBackingList requires non-null property arguments");
        }

        this.intendedEndUserRoleValueList = null;
        this.intendedEndUserRoleLabelList = null;

        if (items != null)
        {
            this.intendedEndUserRoleValueList = new java.lang.Object[items.size()];
            this.intendedEndUserRoleLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.intendedEndUserRoleValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.intendedEndUserRoleLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CatalogadorBasicPlusFormImpl.setIntendedEndUserRoleBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Set the typicalLearningTimeYears field
     */
    public void setTypicalLearningTimeYears(java.lang.String typicalLearningTimeYears)
    {
        this.typicalLearningTimeYears = typicalLearningTimeYears;
    }

    /**
     * Get the typicalLearningTimeYears field
     */
    public java.lang.String getTypicalLearningTimeYears()
    {
        return this.typicalLearningTimeYears;
    }

    /**
     * Set the typicalLearningTimeMonths field
     */
    public void setTypicalLearningTimeMonths(java.lang.String typicalLearningTimeMonths)
    {
        this.typicalLearningTimeMonths = typicalLearningTimeMonths;
    }

    /**
     * Get the typicalLearningTimeMonths field
     */
    public java.lang.String getTypicalLearningTimeMonths()
    {
        return this.typicalLearningTimeMonths;
    }

    /**
     * Set the typicalLearningTimeDays field
     */
    public void setTypicalLearningTimeDays(java.lang.String typicalLearningTimeDays)
    {
        this.typicalLearningTimeDays = typicalLearningTimeDays;
    }

    /**
     * Get the typicalLearningTimeDays field
     */
    public java.lang.String getTypicalLearningTimeDays()
    {
        return this.typicalLearningTimeDays;
    }
    
    /**
     * Set the typicalLearningTimeHours field
     */
    public void setTypicalLearningTimeHours(java.lang.String typicalLearningTimeHours)
    {
        this.typicalLearningTimeHours = typicalLearningTimeHours;
    }

    /**
     * Get the typicalLearningTimeHours field
     */
    public java.lang.String getTypicalLearningTimeHours()
    {
        return this.typicalLearningTimeHours;
    }

    /**
     * Set the typicalLearningTimeMinutes field
     */
    public void setTypicalLearningTimeMinutes(java.lang.String typicalLearningTimeMinutes)
    {
        this.typicalLearningTimeMinutes = typicalLearningTimeMinutes;
    }

    /**
     * Get the typicalLearningTimeMinutes field
     */
    public java.lang.String getTypicalLearningTimeMinutes()
    {
        return this.typicalLearningTimeMinutes;
    }
    
    /**
     * Get the relation kind field
     */
    public java.lang.String getRelationKind()
    {
        return this.relationKind;
    }

    /**
     * Set the relation kind field
     */
    public void setRelationKind(String relationKind)
    {
        this.relationKind = relationKind;
    }
    
    public java.lang.Object[] getRelationKindBackingList()
    {
        java.lang.Object[] values = this.relationKindValueList;
        java.lang.Object[] labels = this.relationKindLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getRelationKindValueList()
    {
        return this.relationKindValueList;
    }

    public void setRelationKindValueList(java.lang.Object[] relationKindValueList)
    {
        this.relationKindValueList = relationKindValueList;
    }

    public java.lang.Object[] getRelationKindLabelList()
    {
        return this.relationKindLabelList;
    }

    public void setRelationKindLabelList(java.lang.Object[] relationKindLabelList)
    {
        this.relationKindLabelList = relationKindLabelList;
    }

    public void setRelationKindBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CatalogadorBasicPlusFormImpl.setRelationKindBackingList requires non-null property arguments");
        }

        this.relationKindValueList = null;
        this.relationKindLabelList = null;

        if (items != null)
        {
            this.relationKindValueList = new java.lang.Object[items.size()];
            this.relationKindLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.relationKindValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.relationKindLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CatalogadorBasicPlusFormImpl.setRelationKindBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Set the relationKindEntry field
     */
    public void setRelationKindEntry(java.lang.String relationKindEntry)
    {
        this.relationKindEntry = relationKindEntry;
    }

    /**
     * Get the relationKindEntry field
     */
    public java.lang.String getRelationKindEntry()
    {
        return this.relationKindEntry;
    }
    
    /**
     * Set the relationKindDescription field
     */
    public void setRelationKindDescription(java.lang.String relationKindDescription)
    {
        this.relationKindDescription = relationKindDescription;
    }

    /**
     * Get the relationKindDescription field
     */
    public java.lang.String getRelationKindDescription()
    {
        return this.relationKindDescription;
    }
    

    /**
     *  Curriculum Tree information
     */

    public void setCurriculumTrees(java.util.Collection curriculumTrees)
    {
        this.curriculumTrees = curriculumTrees;
    }

    public java.util.Collection getCurriculumTrees()
    {
        return this.curriculumTrees;
    }    
    
    /* MCA: Looks like these helper functions are used since the form JSPs expect
     * collections rather than arrays...
     * @see es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatalogadorBasicPlusForm#setCurriculumTreesAsArray(java.lang.Object[])
     */
    
    public void setCurriculumTreesAsArray(Object[] curriculumTrees)
    {
        this.curriculumTrees = (curriculumTrees == null) ? null : java.util.Arrays.asList(curriculumTrees);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatalogadorBasicPlusFormImpl#getArboles
     */
    public java.lang.Object[] getCurriculumTreesAsArray()
    {
        return (curriculumTrees == null) ? null : curriculumTrees.toArray();
    }
    
    public void setIdArbol(java.lang.String idArbol)
    {
        this.idArbol = idArbol;
    }

    /**
     * 
     */
    public java.lang.String getIdArbol()
    {
        return this.idArbol;
    }
    
    
    
    /*
     * Set the typicalLearningTimeFull field
     * @see es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatalogadorBasicPlusForm#setIdioma(java.lang.String)
     */
 
    public void setTypicalLearningTimeFull(java.lang.String typicalLearningTimeFull)
    {
        this.typicalLearningTimeFull = typicalLearningTimeFull;
    }

    /**
     * 
     */
    public java.lang.String getTypicalLearningTimeFull()
    {
        return this.typicalLearningTimeFull;
    }
    
    /*
     * Get BackingList containing the list of typicalLearningTimeFull labels/values
     */
    public java.lang.Object[] getTypicalLearningTimeFullBackingList()
    {
        java.lang.Object[] values = this.typicalLearningTimeFullValueList;
        java.lang.Object[] labels = this.typicalLearningTimeFullLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getTypicalLearningTimeFullValueList()
    {
        return this.typicalLearningTimeFullValueList;
    }

    public void setTypicalLearningTimeFullValueList(java.lang.Object[] typicalLearningTimeFullValueList)
    {
        this.typicalLearningTimeFullValueList = typicalLearningTimeFullValueList;
    }

    public java.lang.Object[] getTypicalLearningTimeFullLabelList()
    {
        return this.typicalLearningTimeFullLabelList;
    }

    public void setTypicalLearningTimeFullLabelList(java.lang.Object[] typicalLearningTimeFullLabelList)
    {
        this.typicalLearningTimeFullLabelList = typicalLearningTimeFullLabelList;
    }

    /*
     * Set BackingList required for typicalLearningTimeFull labels
     */
    
    public void setTypicalLearningTimeFullBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CatalogadorBasicoFormImpl.setTypicalLearningTimeFullBackingList requires non-null property arguments");
        }

        this.typicalLearningTimeFullValueList = null;
        this.typicalLearningTimeFullLabelList = null;

        if (items != null)
        {
            this.typicalLearningTimeFullValueList = new java.lang.Object[items.size()];
            this.typicalLearningTimeFullLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.typicalLearningTimeFullValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.typicalLearningTimeFullLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CatalogadorBasicoFormImpl.setTypicalLearningTimeFullBackingList encountered an exception", ex);
            }
        }
    }
    
 
    /**
     * Dummy routine for testing so the JSP page doesn't crash!
     * @return
     */
    public java.lang.String getDummyBackingList()
    {
    	return null;
    }
    
    /**
     * Dummy routine for testing so the JSP page doesn't crash!
     * @return
     */
    public java.lang.String getDummy()
    {
    	return null;
    }
    
    

    /**
     * Override to provide population of current form with request parameters when validation fails.
     *
     * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
     */
    public org.apache.struts.action.ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        final org.apache.struts.action.ActionErrors errors = super.validate(mapping, request);
        if (errors != null && !errors.isEmpty())
        {
            // we populate the current form with only the request parameters
            Object currentForm = request.getSession().getAttribute("form");
            // if we can't get the 'form' from the session, try from the request
            if (currentForm == null)
            {
                currentForm = request.getAttribute("form");
            }
            if (currentForm != null)
            {
                final java.util.Map parameters = new java.util.HashMap();
                for (final java.util.Enumeration names = request.getParameterNames(); names.hasMoreElements();)
                {
                    final String name = String.valueOf(names.nextElement());
                    parameters.put(name, request.getParameter(name));
                }
                try
                {
                    org.apache.commons.beanutils.BeanUtils.populate(currentForm, parameters);
                }
                catch (java.lang.Exception populateException)
                {
                    // ignore if we have an exception here (we just don't populate).
                }
            }
        }
        return errors;
    }

    public final static class LabelValue
    {
        private java.lang.Object label = null;
        private java.lang.Object value = null;

        public LabelValue(Object label, java.lang.Object value)
        {
            this.label = label;
            this.value = value;
        }

        public java.lang.Object getLabel()
        {
            return this.label;
        }

        public java.lang.Object getValue()
        {
            return this.value;
        }

        public java.lang.String toString()
        {
            return label + "=" + value;
        }
    }
}
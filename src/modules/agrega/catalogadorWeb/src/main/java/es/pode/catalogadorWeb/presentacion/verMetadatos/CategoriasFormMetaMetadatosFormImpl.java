// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

public class CategoriasFormMetaMetadatosFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosMetaMetadatosForm
{
    private java.lang.String minutos;
    private java.lang.Object[] minutosValueList;
    private java.lang.Object[] minutosLabelList;
    private java.lang.String segundoP2;
    private java.lang.Object[] segundoP2ValueList;
    private java.lang.Object[] segundoP2LabelList;
    private java.util.Collection descripciones;
    private java.lang.Object[] descripcionesValueList;
    private java.lang.Object[] descripcionesLabelList;
    private java.lang.String segundoP1;
    private java.lang.Object[] segundoP1ValueList;
    private java.lang.Object[] segundoP1LabelList;
    private java.util.Collection identificadores;
    private java.lang.Object[] identificadoresValueList;
    private java.lang.Object[] identificadoresLabelList;
    private java.util.Collection cidentidad;
    private java.lang.Object[] cidentidadValueList;
    private java.lang.Object[] cidentidadLabelList;
    private java.lang.String meridianocero;
    private java.lang.Object[] meridianoceroValueList;
    private java.lang.Object[] meridianoceroLabelList;
    private java.lang.String comboIdiomaMeta;
    private java.lang.Object[] comboIdiomaMetaValueList;
    private java.lang.Object[] comboIdiomaMetaLabelList;
    private java.lang.String zhHora;
    private java.lang.Object[] zhHoraValueList;
    private java.lang.Object[] zhHoraLabelList;
    private java.util.Collection esquemasMeta;
    private java.lang.Object[] esquemasMetaValueList;
    private java.lang.Object[] esquemasMetaLabelList;
    private java.util.Collection contribucion;
    private java.lang.Object[] contribucionValueList;
    private java.lang.Object[] contribucionLabelList;
    private java.lang.String hora;
    private java.lang.Object[] horaValueList;
    private java.lang.Object[] horaLabelList;
    private java.lang.String crol;
    private java.lang.Object[] crolValueList;
    private java.lang.Object[] crolLabelList;
    private java.lang.String comboIdioma;
    private java.lang.Object[] comboIdiomaValueList;
    private java.lang.Object[] comboIdiomaLabelList;
    private java.lang.String zhMinutos;
    private java.lang.Object[] zhMinutosValueList;
    private java.lang.Object[] zhMinutosLabelList;
    private java.util.Collection datos;
    private java.lang.Object[] datosValueList;
    private java.lang.Object[] datosLabelList;
    private java.lang.String fechaCorta;
    private java.lang.Object[] fechaCortaValueList;
    private java.lang.Object[] fechaCortaLabelList;
    private java.lang.String comboZonaH;
    private java.lang.Object[] comboZonaHValueList;
    private java.lang.Object[] comboZonaHLabelList;
    private java.lang.String returnURL;
    private java.lang.Object[] returnURLValueList;
    private java.lang.Object[] returnURLLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;

    public CategoriasFormMetaMetadatosFormImpl()
    {
    }

    /**
     * Resets the given <code>minutos</code>.
     */
    public void resetMinutos()
    {
        this.minutos = null;
    }

    public void setMinutos(java.lang.String minutos)
    {
        this.minutos = minutos;
    }

    /**
     * 
     */
    public java.lang.String getMinutos()
    {
        return this.minutos;
    }
    
    public java.lang.Object[] getMinutosBackingList()
    {
        java.lang.Object[] values = this.minutosValueList;
        java.lang.Object[] labels = this.minutosLabelList;

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

    public java.lang.Object[] getMinutosValueList()
    {
        return this.minutosValueList;
    }

    public void setMinutosValueList(java.lang.Object[] minutosValueList)
    {
        this.minutosValueList = minutosValueList;
    }

    public java.lang.Object[] getMinutosLabelList()
    {
        return this.minutosLabelList;
    }

    public void setMinutosLabelList(java.lang.Object[] minutosLabelList)
    {
        this.minutosLabelList = minutosLabelList;
    }

    public void setMinutosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setMinutosBackingList requires non-null property arguments");
        }

        this.minutosValueList = null;
        this.minutosLabelList = null;

        if (items != null)
        {
            this.minutosValueList = new java.lang.Object[items.size()];
            this.minutosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.minutosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.minutosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setMinutosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>segundoP2</code>.
     */
    public void resetSegundoP2()
    {
        this.segundoP2 = null;
    }

    public void setSegundoP2(java.lang.String segundoP2)
    {
        this.segundoP2 = segundoP2;
    }

    /**
     * 
     */
    public java.lang.String getSegundoP2()
    {
        return this.segundoP2;
    }
    
    public java.lang.Object[] getSegundoP2BackingList()
    {
        java.lang.Object[] values = this.segundoP2ValueList;
        java.lang.Object[] labels = this.segundoP2LabelList;

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

    public java.lang.Object[] getSegundoP2ValueList()
    {
        return this.segundoP2ValueList;
    }

    public void setSegundoP2ValueList(java.lang.Object[] segundoP2ValueList)
    {
        this.segundoP2ValueList = segundoP2ValueList;
    }

    public java.lang.Object[] getSegundoP2LabelList()
    {
        return this.segundoP2LabelList;
    }

    public void setSegundoP2LabelList(java.lang.Object[] segundoP2LabelList)
    {
        this.segundoP2LabelList = segundoP2LabelList;
    }

    public void setSegundoP2BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setSegundoP2BackingList requires non-null property arguments");
        }

        this.segundoP2ValueList = null;
        this.segundoP2LabelList = null;

        if (items != null)
        {
            this.segundoP2ValueList = new java.lang.Object[items.size()];
            this.segundoP2LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.segundoP2ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.segundoP2LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setSegundoP2BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripciones</code>.
     */
    public void resetDescripciones()
    {
        this.descripciones = null;
    }

    public void setDescripciones(java.util.Collection descripciones)
    {
        this.descripciones = descripciones;
    }

    /**
     * 
     */
    public java.util.Collection getDescripciones()
    {
        return this.descripciones;
    }

    public void setDescripcionesAsArray(Object[] descripciones)
    {
        this.descripciones = (descripciones == null) ? null : java.util.Arrays.asList(descripciones);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormMetaMetadatosFormImpl#getDescripciones
     */
    public java.lang.Object[] getDescripcionesAsArray()
    {
        return (descripciones == null) ? null : descripciones.toArray();
    }
    
    public java.lang.Object[] getDescripcionesBackingList()
    {
        java.lang.Object[] values = this.descripcionesValueList;
        java.lang.Object[] labels = this.descripcionesLabelList;

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

    public java.lang.Object[] getDescripcionesValueList()
    {
        return this.descripcionesValueList;
    }

    public void setDescripcionesValueList(java.lang.Object[] descripcionesValueList)
    {
        this.descripcionesValueList = descripcionesValueList;
    }

    public java.lang.Object[] getDescripcionesLabelList()
    {
        return this.descripcionesLabelList;
    }

    public void setDescripcionesLabelList(java.lang.Object[] descripcionesLabelList)
    {
        this.descripcionesLabelList = descripcionesLabelList;
    }

    public void setDescripcionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setDescripcionesBackingList requires non-null property arguments");
        }

        this.descripcionesValueList = null;
        this.descripcionesLabelList = null;

        if (items != null)
        {
            this.descripcionesValueList = new java.lang.Object[items.size()];
            this.descripcionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setDescripcionesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>segundoP1</code>.
     */
    public void resetSegundoP1()
    {
        this.segundoP1 = null;
    }

    public void setSegundoP1(java.lang.String segundoP1)
    {
        this.segundoP1 = segundoP1;
    }

    /**
     * 
     */
    public java.lang.String getSegundoP1()
    {
        return this.segundoP1;
    }
    
    public java.lang.Object[] getSegundoP1BackingList()
    {
        java.lang.Object[] values = this.segundoP1ValueList;
        java.lang.Object[] labels = this.segundoP1LabelList;

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

    public java.lang.Object[] getSegundoP1ValueList()
    {
        return this.segundoP1ValueList;
    }

    public void setSegundoP1ValueList(java.lang.Object[] segundoP1ValueList)
    {
        this.segundoP1ValueList = segundoP1ValueList;
    }

    public java.lang.Object[] getSegundoP1LabelList()
    {
        return this.segundoP1LabelList;
    }

    public void setSegundoP1LabelList(java.lang.Object[] segundoP1LabelList)
    {
        this.segundoP1LabelList = segundoP1LabelList;
    }

    public void setSegundoP1BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setSegundoP1BackingList requires non-null property arguments");
        }

        this.segundoP1ValueList = null;
        this.segundoP1LabelList = null;

        if (items != null)
        {
            this.segundoP1ValueList = new java.lang.Object[items.size()];
            this.segundoP1LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.segundoP1ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.segundoP1LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setSegundoP1BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificadores</code>.
     */
    public void resetIdentificadores()
    {
        this.identificadores = null;
    }

    public void setIdentificadores(java.util.Collection identificadores)
    {
        this.identificadores = identificadores;
    }

    /**
     * 
     */
    public java.util.Collection getIdentificadores()
    {
        return this.identificadores;
    }

    public void setIdentificadoresAsArray(Object[] identificadores)
    {
        this.identificadores = (identificadores == null) ? null : java.util.Arrays.asList(identificadores);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormMetaMetadatosFormImpl#getIdentificadores
     */
    public java.lang.Object[] getIdentificadoresAsArray()
    {
        return (identificadores == null) ? null : identificadores.toArray();
    }
    
    public java.lang.Object[] getIdentificadoresBackingList()
    {
        java.lang.Object[] values = this.identificadoresValueList;
        java.lang.Object[] labels = this.identificadoresLabelList;

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

    public java.lang.Object[] getIdentificadoresValueList()
    {
        return this.identificadoresValueList;
    }

    public void setIdentificadoresValueList(java.lang.Object[] identificadoresValueList)
    {
        this.identificadoresValueList = identificadoresValueList;
    }

    public java.lang.Object[] getIdentificadoresLabelList()
    {
        return this.identificadoresLabelList;
    }

    public void setIdentificadoresLabelList(java.lang.Object[] identificadoresLabelList)
    {
        this.identificadoresLabelList = identificadoresLabelList;
    }

    public void setIdentificadoresBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setIdentificadoresBackingList requires non-null property arguments");
        }

        this.identificadoresValueList = null;
        this.identificadoresLabelList = null;

        if (items != null)
        {
            this.identificadoresValueList = new java.lang.Object[items.size()];
            this.identificadoresLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadoresValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadoresLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setIdentificadoresBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>cidentidad</code>.
     */
    public void resetCidentidad()
    {
        this.cidentidad = null;
    }

    public void setCidentidad(java.util.Collection cidentidad)
    {
        this.cidentidad = cidentidad;
    }

    /**
     * 
     */
    public java.util.Collection getCidentidad()
    {
        return this.cidentidad;
    }

    public void setCidentidadAsArray(Object[] cidentidad)
    {
        this.cidentidad = (cidentidad == null) ? null : java.util.Arrays.asList(cidentidad);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormMetaMetadatosFormImpl#getCidentidad
     */
    public java.lang.Object[] getCidentidadAsArray()
    {
        return (cidentidad == null) ? null : cidentidad.toArray();
    }
    
    public java.lang.Object[] getCidentidadBackingList()
    {
        java.lang.Object[] values = this.cidentidadValueList;
        java.lang.Object[] labels = this.cidentidadLabelList;

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

    public java.lang.Object[] getCidentidadValueList()
    {
        return this.cidentidadValueList;
    }

    public void setCidentidadValueList(java.lang.Object[] cidentidadValueList)
    {
        this.cidentidadValueList = cidentidadValueList;
    }

    public java.lang.Object[] getCidentidadLabelList()
    {
        return this.cidentidadLabelList;
    }

    public void setCidentidadLabelList(java.lang.Object[] cidentidadLabelList)
    {
        this.cidentidadLabelList = cidentidadLabelList;
    }

    public void setCidentidadBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setCidentidadBackingList requires non-null property arguments");
        }

        this.cidentidadValueList = null;
        this.cidentidadLabelList = null;

        if (items != null)
        {
            this.cidentidadValueList = new java.lang.Object[items.size()];
            this.cidentidadLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.cidentidadValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.cidentidadLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setCidentidadBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>meridianocero</code>.
     */
    public void resetMeridianocero()
    {
        this.meridianocero = null;
    }

    public void setMeridianocero(java.lang.String meridianocero)
    {
        this.meridianocero = meridianocero;
    }

    /**
     * 
     */
    public java.lang.String getMeridianocero()
    {
        return this.meridianocero;
    }
    
    public java.lang.Object[] getMeridianoceroBackingList()
    {
        java.lang.Object[] values = this.meridianoceroValueList;
        java.lang.Object[] labels = this.meridianoceroLabelList;

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

    public java.lang.Object[] getMeridianoceroValueList()
    {
        return this.meridianoceroValueList;
    }

    public void setMeridianoceroValueList(java.lang.Object[] meridianoceroValueList)
    {
        this.meridianoceroValueList = meridianoceroValueList;
    }

    public java.lang.Object[] getMeridianoceroLabelList()
    {
        return this.meridianoceroLabelList;
    }

    public void setMeridianoceroLabelList(java.lang.Object[] meridianoceroLabelList)
    {
        this.meridianoceroLabelList = meridianoceroLabelList;
    }

    public void setMeridianoceroBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setMeridianoceroBackingList requires non-null property arguments");
        }

        this.meridianoceroValueList = null;
        this.meridianoceroLabelList = null;

        if (items != null)
        {
            this.meridianoceroValueList = new java.lang.Object[items.size()];
            this.meridianoceroLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.meridianoceroValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.meridianoceroLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setMeridianoceroBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboIdiomaMeta</code>.
     */
    public void resetComboIdiomaMeta()
    {
        this.comboIdiomaMeta = null;
    }

    public void setComboIdiomaMeta(java.lang.String comboIdiomaMeta)
    {
        this.comboIdiomaMeta = comboIdiomaMeta;
    }

    /**
     * 
     */
    public java.lang.String getComboIdiomaMeta()
    {
        return this.comboIdiomaMeta;
    }
    
    public java.lang.Object[] getComboIdiomaMetaBackingList()
    {
        java.lang.Object[] values = this.comboIdiomaMetaValueList;
        java.lang.Object[] labels = this.comboIdiomaMetaLabelList;

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

    public java.lang.Object[] getComboIdiomaMetaValueList()
    {
        return this.comboIdiomaMetaValueList;
    }

    public void setComboIdiomaMetaValueList(java.lang.Object[] comboIdiomaMetaValueList)
    {
        this.comboIdiomaMetaValueList = comboIdiomaMetaValueList;
    }

    public java.lang.Object[] getComboIdiomaMetaLabelList()
    {
        return this.comboIdiomaMetaLabelList;
    }

    public void setComboIdiomaMetaLabelList(java.lang.Object[] comboIdiomaMetaLabelList)
    {
        this.comboIdiomaMetaLabelList = comboIdiomaMetaLabelList;
    }

    public void setComboIdiomaMetaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setComboIdiomaMetaBackingList requires non-null property arguments");
        }

        this.comboIdiomaMetaValueList = null;
        this.comboIdiomaMetaLabelList = null;

        if (items != null)
        {
            this.comboIdiomaMetaValueList = new java.lang.Object[items.size()];
            this.comboIdiomaMetaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboIdiomaMetaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboIdiomaMetaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setComboIdiomaMetaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>zhHora</code>.
     */
    public void resetZhHora()
    {
        this.zhHora = null;
    }

    public void setZhHora(java.lang.String zhHora)
    {
        this.zhHora = zhHora;
    }

    /**
     * 
     */
    public java.lang.String getZhHora()
    {
        return this.zhHora;
    }
    
    public java.lang.Object[] getZhHoraBackingList()
    {
        java.lang.Object[] values = this.zhHoraValueList;
        java.lang.Object[] labels = this.zhHoraLabelList;

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

    public java.lang.Object[] getZhHoraValueList()
    {
        return this.zhHoraValueList;
    }

    public void setZhHoraValueList(java.lang.Object[] zhHoraValueList)
    {
        this.zhHoraValueList = zhHoraValueList;
    }

    public java.lang.Object[] getZhHoraLabelList()
    {
        return this.zhHoraLabelList;
    }

    public void setZhHoraLabelList(java.lang.Object[] zhHoraLabelList)
    {
        this.zhHoraLabelList = zhHoraLabelList;
    }

    public void setZhHoraBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setZhHoraBackingList requires non-null property arguments");
        }

        this.zhHoraValueList = null;
        this.zhHoraLabelList = null;

        if (items != null)
        {
            this.zhHoraValueList = new java.lang.Object[items.size()];
            this.zhHoraLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.zhHoraValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.zhHoraLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setZhHoraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>esquemasMeta</code>.
     */
    public void resetEsquemasMeta()
    {
        this.esquemasMeta = null;
    }

    public void setEsquemasMeta(java.util.Collection esquemasMeta)
    {
        this.esquemasMeta = esquemasMeta;
    }

    /**
     * 
     */
    public java.util.Collection getEsquemasMeta()
    {
        return this.esquemasMeta;
    }

    public void setEsquemasMetaAsArray(Object[] esquemasMeta)
    {
        this.esquemasMeta = (esquemasMeta == null) ? null : java.util.Arrays.asList(esquemasMeta);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormMetaMetadatosFormImpl#getEsquemasMeta
     */
    public java.lang.Object[] getEsquemasMetaAsArray()
    {
        return (esquemasMeta == null) ? null : esquemasMeta.toArray();
    }
    
    public java.lang.Object[] getEsquemasMetaBackingList()
    {
        java.lang.Object[] values = this.esquemasMetaValueList;
        java.lang.Object[] labels = this.esquemasMetaLabelList;

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

    public java.lang.Object[] getEsquemasMetaValueList()
    {
        return this.esquemasMetaValueList;
    }

    public void setEsquemasMetaValueList(java.lang.Object[] esquemasMetaValueList)
    {
        this.esquemasMetaValueList = esquemasMetaValueList;
    }

    public java.lang.Object[] getEsquemasMetaLabelList()
    {
        return this.esquemasMetaLabelList;
    }

    public void setEsquemasMetaLabelList(java.lang.Object[] esquemasMetaLabelList)
    {
        this.esquemasMetaLabelList = esquemasMetaLabelList;
    }

    public void setEsquemasMetaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setEsquemasMetaBackingList requires non-null property arguments");
        }

        this.esquemasMetaValueList = null;
        this.esquemasMetaLabelList = null;

        if (items != null)
        {
            this.esquemasMetaValueList = new java.lang.Object[items.size()];
            this.esquemasMetaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.esquemasMetaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.esquemasMetaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setEsquemasMetaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>contribucion</code>.
     */
    public void resetContribucion()
    {
        this.contribucion = null;
    }

    public void setContribucion(java.util.Collection contribucion)
    {
        this.contribucion = contribucion;
    }

    /**
     * 
     */
    public java.util.Collection getContribucion()
    {
        return this.contribucion;
    }

    public void setContribucionAsArray(Object[] contribucion)
    {
        this.contribucion = (contribucion == null) ? null : java.util.Arrays.asList(contribucion);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormMetaMetadatosFormImpl#getContribucion
     */
    public java.lang.Object[] getContribucionAsArray()
    {
        return (contribucion == null) ? null : contribucion.toArray();
    }
    
    public java.lang.Object[] getContribucionBackingList()
    {
        java.lang.Object[] values = this.contribucionValueList;
        java.lang.Object[] labels = this.contribucionLabelList;

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

    public java.lang.Object[] getContribucionValueList()
    {
        return this.contribucionValueList;
    }

    public void setContribucionValueList(java.lang.Object[] contribucionValueList)
    {
        this.contribucionValueList = contribucionValueList;
    }

    public java.lang.Object[] getContribucionLabelList()
    {
        return this.contribucionLabelList;
    }

    public void setContribucionLabelList(java.lang.Object[] contribucionLabelList)
    {
        this.contribucionLabelList = contribucionLabelList;
    }

    public void setContribucionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setContribucionBackingList requires non-null property arguments");
        }

        this.contribucionValueList = null;
        this.contribucionLabelList = null;

        if (items != null)
        {
            this.contribucionValueList = new java.lang.Object[items.size()];
            this.contribucionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.contribucionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.contribucionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setContribucionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>hora</code>.
     */
    public void resetHora()
    {
        this.hora = null;
    }

    public void setHora(java.lang.String hora)
    {
        this.hora = hora;
    }

    /**
     * 
     */
    public java.lang.String getHora()
    {
        return this.hora;
    }
    
    public java.lang.Object[] getHoraBackingList()
    {
        java.lang.Object[] values = this.horaValueList;
        java.lang.Object[] labels = this.horaLabelList;

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

    public java.lang.Object[] getHoraValueList()
    {
        return this.horaValueList;
    }

    public void setHoraValueList(java.lang.Object[] horaValueList)
    {
        this.horaValueList = horaValueList;
    }

    public java.lang.Object[] getHoraLabelList()
    {
        return this.horaLabelList;
    }

    public void setHoraLabelList(java.lang.Object[] horaLabelList)
    {
        this.horaLabelList = horaLabelList;
    }

    public void setHoraBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setHoraBackingList requires non-null property arguments");
        }

        this.horaValueList = null;
        this.horaLabelList = null;

        if (items != null)
        {
            this.horaValueList = new java.lang.Object[items.size()];
            this.horaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.horaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.horaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setHoraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>crol</code>.
     */
    public void resetCrol()
    {
        this.crol = null;
    }

    public void setCrol(java.lang.String crol)
    {
        this.crol = crol;
    }

    /**
     * 
     */
    public java.lang.String getCrol()
    {
        return this.crol;
    }
    
    public java.lang.Object[] getCrolBackingList()
    {
        java.lang.Object[] values = this.crolValueList;
        java.lang.Object[] labels = this.crolLabelList;

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

    public java.lang.Object[] getCrolValueList()
    {
        return this.crolValueList;
    }

    public void setCrolValueList(java.lang.Object[] crolValueList)
    {
        this.crolValueList = crolValueList;
    }

    public java.lang.Object[] getCrolLabelList()
    {
        return this.crolLabelList;
    }

    public void setCrolLabelList(java.lang.Object[] crolLabelList)
    {
        this.crolLabelList = crolLabelList;
    }

    public void setCrolBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setCrolBackingList requires non-null property arguments");
        }

        this.crolValueList = null;
        this.crolLabelList = null;

        if (items != null)
        {
            this.crolValueList = new java.lang.Object[items.size()];
            this.crolLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.crolValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.crolLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setCrolBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboIdioma</code>.
     */
    public void resetComboIdioma()
    {
        this.comboIdioma = null;
    }

    public void setComboIdioma(java.lang.String comboIdioma)
    {
        this.comboIdioma = comboIdioma;
    }

    /**
     * 
     */
    public java.lang.String getComboIdioma()
    {
        return this.comboIdioma;
    }
    
    public java.lang.Object[] getComboIdiomaBackingList()
    {
        java.lang.Object[] values = this.comboIdiomaValueList;
        java.lang.Object[] labels = this.comboIdiomaLabelList;

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

    public java.lang.Object[] getComboIdiomaValueList()
    {
        return this.comboIdiomaValueList;
    }

    public void setComboIdiomaValueList(java.lang.Object[] comboIdiomaValueList)
    {
        this.comboIdiomaValueList = comboIdiomaValueList;
    }

    public java.lang.Object[] getComboIdiomaLabelList()
    {
        return this.comboIdiomaLabelList;
    }

    public void setComboIdiomaLabelList(java.lang.Object[] comboIdiomaLabelList)
    {
        this.comboIdiomaLabelList = comboIdiomaLabelList;
    }

    public void setComboIdiomaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setComboIdiomaBackingList requires non-null property arguments");
        }

        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;

        if (items != null)
        {
            this.comboIdiomaValueList = new java.lang.Object[items.size()];
            this.comboIdiomaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboIdiomaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboIdiomaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setComboIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>zhMinutos</code>.
     */
    public void resetZhMinutos()
    {
        this.zhMinutos = null;
    }

    public void setZhMinutos(java.lang.String zhMinutos)
    {
        this.zhMinutos = zhMinutos;
    }

    /**
     * 
     */
    public java.lang.String getZhMinutos()
    {
        return this.zhMinutos;
    }
    
    public java.lang.Object[] getZhMinutosBackingList()
    {
        java.lang.Object[] values = this.zhMinutosValueList;
        java.lang.Object[] labels = this.zhMinutosLabelList;

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

    public java.lang.Object[] getZhMinutosValueList()
    {
        return this.zhMinutosValueList;
    }

    public void setZhMinutosValueList(java.lang.Object[] zhMinutosValueList)
    {
        this.zhMinutosValueList = zhMinutosValueList;
    }

    public java.lang.Object[] getZhMinutosLabelList()
    {
        return this.zhMinutosLabelList;
    }

    public void setZhMinutosLabelList(java.lang.Object[] zhMinutosLabelList)
    {
        this.zhMinutosLabelList = zhMinutosLabelList;
    }

    public void setZhMinutosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setZhMinutosBackingList requires non-null property arguments");
        }

        this.zhMinutosValueList = null;
        this.zhMinutosLabelList = null;

        if (items != null)
        {
            this.zhMinutosValueList = new java.lang.Object[items.size()];
            this.zhMinutosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.zhMinutosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.zhMinutosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setZhMinutosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>datos</code>.
     */
    public void resetDatos()
    {
        this.datos = null;
    }

    public void setDatos(java.util.Collection datos)
    {
        this.datos = datos;
    }

    /**
     * 
     */
    public java.util.Collection getDatos()
    {
        return this.datos;
    }

    public void setDatosAsArray(Object[] datos)
    {
        this.datos = (datos == null) ? null : java.util.Arrays.asList(datos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormMetaMetadatosFormImpl#getDatos
     */
    public java.lang.Object[] getDatosAsArray()
    {
        return (datos == null) ? null : datos.toArray();
    }
    
    public java.lang.Object[] getDatosBackingList()
    {
        java.lang.Object[] values = this.datosValueList;
        java.lang.Object[] labels = this.datosLabelList;

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

    public java.lang.Object[] getDatosValueList()
    {
        return this.datosValueList;
    }

    public void setDatosValueList(java.lang.Object[] datosValueList)
    {
        this.datosValueList = datosValueList;
    }

    public java.lang.Object[] getDatosLabelList()
    {
        return this.datosLabelList;
    }

    public void setDatosLabelList(java.lang.Object[] datosLabelList)
    {
        this.datosLabelList = datosLabelList;
    }

    public void setDatosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setDatosBackingList requires non-null property arguments");
        }

        this.datosValueList = null;
        this.datosLabelList = null;

        if (items != null)
        {
            this.datosValueList = new java.lang.Object[items.size()];
            this.datosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.datosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.datosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setDatosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>fechaCorta</code>.
     */
    public void resetFechaCorta()
    {
        this.fechaCorta = null;
    }

    public void setFechaCorta(java.lang.String fechaCorta)
    {
        this.fechaCorta = fechaCorta;
    }

    /**
     * 
     */
    public java.lang.String getFechaCorta()
    {
        return this.fechaCorta;
    }
    
    public java.lang.Object[] getFechaCortaBackingList()
    {
        java.lang.Object[] values = this.fechaCortaValueList;
        java.lang.Object[] labels = this.fechaCortaLabelList;

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

    public java.lang.Object[] getFechaCortaValueList()
    {
        return this.fechaCortaValueList;
    }

    public void setFechaCortaValueList(java.lang.Object[] fechaCortaValueList)
    {
        this.fechaCortaValueList = fechaCortaValueList;
    }

    public java.lang.Object[] getFechaCortaLabelList()
    {
        return this.fechaCortaLabelList;
    }

    public void setFechaCortaLabelList(java.lang.Object[] fechaCortaLabelList)
    {
        this.fechaCortaLabelList = fechaCortaLabelList;
    }

    public void setFechaCortaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setFechaCortaBackingList requires non-null property arguments");
        }

        this.fechaCortaValueList = null;
        this.fechaCortaLabelList = null;

        if (items != null)
        {
            this.fechaCortaValueList = new java.lang.Object[items.size()];
            this.fechaCortaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.fechaCortaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.fechaCortaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setFechaCortaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboZonaH</code>.
     */
    public void resetComboZonaH()
    {
        this.comboZonaH = null;
    }

    public void setComboZonaH(java.lang.String comboZonaH)
    {
        this.comboZonaH = comboZonaH;
    }

    /**
     * 
     */
    public java.lang.String getComboZonaH()
    {
        return this.comboZonaH;
    }
    
    public java.lang.Object[] getComboZonaHBackingList()
    {
        java.lang.Object[] values = this.comboZonaHValueList;
        java.lang.Object[] labels = this.comboZonaHLabelList;

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

    public java.lang.Object[] getComboZonaHValueList()
    {
        return this.comboZonaHValueList;
    }

    public void setComboZonaHValueList(java.lang.Object[] comboZonaHValueList)
    {
        this.comboZonaHValueList = comboZonaHValueList;
    }

    public java.lang.Object[] getComboZonaHLabelList()
    {
        return this.comboZonaHLabelList;
    }

    public void setComboZonaHLabelList(java.lang.Object[] comboZonaHLabelList)
    {
        this.comboZonaHLabelList = comboZonaHLabelList;
    }

    public void setComboZonaHBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setComboZonaHBackingList requires non-null property arguments");
        }

        this.comboZonaHValueList = null;
        this.comboZonaHLabelList = null;

        if (items != null)
        {
            this.comboZonaHValueList = new java.lang.Object[items.size()];
            this.comboZonaHLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboZonaHValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboZonaHLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setComboZonaHBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>returnURL</code>.
     */
    public void resetReturnURL()
    {
        this.returnURL = null;
    }

    public void setReturnURL(java.lang.String returnURL)
    {
        this.returnURL = returnURL;
    }

    /**
     * 
     */
    public java.lang.String getReturnURL()
    {
        return this.returnURL;
    }
    
    public java.lang.Object[] getReturnURLBackingList()
    {
        java.lang.Object[] values = this.returnURLValueList;
        java.lang.Object[] labels = this.returnURLLabelList;

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

    public java.lang.Object[] getReturnURLValueList()
    {
        return this.returnURLValueList;
    }

    public void setReturnURLValueList(java.lang.Object[] returnURLValueList)
    {
        this.returnURLValueList = returnURLValueList;
    }

    public java.lang.Object[] getReturnURLLabelList()
    {
        return this.returnURLLabelList;
    }

    public void setReturnURLLabelList(java.lang.Object[] returnURLLabelList)
    {
        this.returnURLLabelList = returnURLLabelList;
    }

    public void setReturnURLBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setReturnURLBackingList requires non-null property arguments");
        }

        this.returnURLValueList = null;
        this.returnURLLabelList = null;

        if (items != null)
        {
            this.returnURLValueList = new java.lang.Object[items.size()];
            this.returnURLLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.returnURLValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.returnURLLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setReturnURLBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificadorOde</code>.
     */
    public void resetIdentificadorOde()
    {
        this.identificadorOde = null;
    }

    public void setIdentificadorOde(java.lang.String identificadorOde)
    {
        this.identificadorOde = identificadorOde;
    }

    /**
     * 
     */
    public java.lang.String getIdentificadorOde()
    {
        return this.identificadorOde;
    }
    
    public java.lang.Object[] getIdentificadorOdeBackingList()
    {
        java.lang.Object[] values = this.identificadorOdeValueList;
        java.lang.Object[] labels = this.identificadorOdeLabelList;

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

    public java.lang.Object[] getIdentificadorOdeValueList()
    {
        return this.identificadorOdeValueList;
    }

    public void setIdentificadorOdeValueList(java.lang.Object[] identificadorOdeValueList)
    {
        this.identificadorOdeValueList = identificadorOdeValueList;
    }

    public java.lang.Object[] getIdentificadorOdeLabelList()
    {
        return this.identificadorOdeLabelList;
    }

    public void setIdentificadorOdeLabelList(java.lang.Object[] identificadorOdeLabelList)
    {
        this.identificadorOdeLabelList = identificadorOdeLabelList;
    }

    public void setIdentificadorOdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormMetaMetadatosFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
        }

        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;

        if (items != null)
        {
            this.identificadorOdeValueList = new java.lang.Object[items.size()];
            this.identificadorOdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadorOdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadorOdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormMetaMetadatosFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.comboIdiomaMeta = null;
        this.crol = null;
        this.comboIdioma = null;
        this.datos = null;
        this.datosValueList = new java.lang.Object[0];
        this.datosLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("minutos", this.minutos);
        builder.append("segundoP2", this.segundoP2);
        builder.append("descripciones", this.descripciones);
        builder.append("segundoP1", this.segundoP1);
        builder.append("identificadores", this.identificadores);
        builder.append("cidentidad", this.cidentidad);
        builder.append("meridianocero", this.meridianocero);
        builder.append("comboIdiomaMeta", this.comboIdiomaMeta);
        builder.append("zhHora", this.zhHora);
        builder.append("esquemasMeta", this.esquemasMeta);
        builder.append("contribucion", this.contribucion);
        builder.append("hora", this.hora);
        builder.append("crol", this.crol);
        builder.append("comboIdioma", this.comboIdioma);
        builder.append("zhMinutos", this.zhMinutos);
        builder.append("datos", this.datos);
        builder.append("fechaCorta", this.fechaCorta);
        builder.append("comboZonaH", this.comboZonaH);
        builder.append("returnURL", this.returnURL);
        builder.append("identificadorOde", this.identificadorOde);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.minutos = null;
        this.minutosValueList = null;
        this.minutosLabelList = null;
        this.segundoP2 = null;
        this.segundoP2ValueList = null;
        this.segundoP2LabelList = null;
        this.descripciones = null;
        this.descripcionesValueList = null;
        this.descripcionesLabelList = null;
        this.segundoP1 = null;
        this.segundoP1ValueList = null;
        this.segundoP1LabelList = null;
        this.identificadores = null;
        this.identificadoresValueList = null;
        this.identificadoresLabelList = null;
        this.cidentidad = null;
        this.cidentidadValueList = null;
        this.cidentidadLabelList = null;
        this.meridianocero = null;
        this.meridianoceroValueList = null;
        this.meridianoceroLabelList = null;
        this.comboIdiomaMeta = null;
        this.comboIdiomaMetaValueList = null;
        this.comboIdiomaMetaLabelList = null;
        this.zhHora = null;
        this.zhHoraValueList = null;
        this.zhHoraLabelList = null;
        this.esquemasMeta = null;
        this.esquemasMetaValueList = null;
        this.esquemasMetaLabelList = null;
        this.contribucion = null;
        this.contribucionValueList = null;
        this.contribucionLabelList = null;
        this.hora = null;
        this.horaValueList = null;
        this.horaLabelList = null;
        this.crol = null;
        this.crolValueList = null;
        this.crolLabelList = null;
        this.comboIdioma = null;
        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;
        this.zhMinutos = null;
        this.zhMinutosValueList = null;
        this.zhMinutosLabelList = null;
        this.datos = null;
        this.datosValueList = null;
        this.datosLabelList = null;
        this.fechaCorta = null;
        this.fechaCortaValueList = null;
        this.fechaCortaLabelList = null;
        this.comboZonaH = null;
        this.comboZonaHValueList = null;
        this.comboZonaHLabelList = null;
        this.returnURL = null;
        this.returnURLValueList = null;
        this.returnURLLabelList = null;
        this.identificadorOde = null;
        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;
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
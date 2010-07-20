// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

public class CategoriasFormTecnicaFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosTecnicaForm
{
    private java.lang.String segundoP2;
    private java.lang.Object[] segundoP2ValueList;
    private java.lang.Object[] segundoP2LabelList;
    private java.lang.String minutos;
    private java.lang.Object[] minutosValueList;
    private java.lang.Object[] minutosLabelList;
    private java.lang.String segundoP1;
    private java.lang.Object[] segundoP1ValueList;
    private java.lang.Object[] segundoP1LabelList;
    private java.util.Collection descripcionRequerimientos;
    private java.lang.Object[] descripcionRequerimientosValueList;
    private java.lang.Object[] descripcionRequerimientosLabelList;
    private java.util.Collection requerimiento;
    private java.lang.Object[] requerimientoValueList;
    private java.lang.Object[] requerimientoLabelList;
    private java.lang.String comboTipo;
    private java.lang.Object[] comboTipoValueList;
    private java.lang.Object[] comboTipoLabelList;
    private java.util.Collection descripcionInstalacion;
    private java.lang.Object[] descripcionInstalacionValueList;
    private java.lang.Object[] descripcionInstalacionLabelList;
    private java.util.Collection descripcionDuracion;
    private java.lang.Object[] descripcionDuracionValueList;
    private java.lang.Object[] descripcionDuracionLabelList;
    private java.lang.String dia;
    private java.lang.Object[] diaValueList;
    private java.lang.Object[] diaLabelList;
    private java.util.Collection duracion;
    private java.lang.Object[] duracionValueList;
    private java.lang.Object[] duracionLabelList;
    private java.util.Collection agregadorOR;
    private java.lang.Object[] agregadorORValueList;
    private java.lang.Object[] agregadorORLabelList;
    private java.lang.String hora;
    private java.lang.Object[] horaValueList;
    private java.lang.Object[] horaLabelList;
    private java.lang.String comboNombre;
    private java.lang.Object[] comboNombreValueList;
    private java.lang.Object[] comboNombreLabelList;
    private java.lang.String mes;
    private java.lang.Object[] mesValueList;
    private java.lang.Object[] mesLabelList;
    private java.lang.String tamanio;
    private java.lang.Object[] tamanioValueList;
    private java.lang.Object[] tamanioLabelList;
    private java.lang.String comboIdioma;
    private java.lang.Object[] comboIdiomaValueList;
    private java.lang.Object[] comboIdiomaLabelList;
    private java.util.Collection localizacion;
    private java.lang.Object[] localizacionValueList;
    private java.lang.Object[] localizacionLabelList;
    private java.util.Collection datos;
    private java.lang.Object[] datosValueList;
    private java.lang.Object[] datosLabelList;
    private java.lang.String anyo;
    private java.lang.Object[] anyoValueList;
    private java.lang.Object[] anyoLabelList;
    private java.util.Collection formatos;
    private java.lang.Object[] formatosValueList;
    private java.lang.Object[] formatosLabelList;
    private java.lang.String comboFormato;
    private java.lang.Object[] comboFormatoValueList;
    private java.lang.Object[] comboFormatoLabelList;
    private java.lang.String returnURL;
    private java.lang.Object[] returnURLValueList;
    private java.lang.Object[] returnURLLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;

    public CategoriasFormTecnicaFormImpl()
    {
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
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setSegundoP2BackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setSegundoP2BackingList encountered an exception", ex);
            }
        }
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
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setMinutosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setMinutosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setSegundoP1BackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setSegundoP1BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcionRequerimientos</code>.
     */
    public void resetDescripcionRequerimientos()
    {
        this.descripcionRequerimientos = null;
    }

    public void setDescripcionRequerimientos(java.util.Collection descripcionRequerimientos)
    {
        this.descripcionRequerimientos = descripcionRequerimientos;
    }

    /**
     * 
     */
    public java.util.Collection getDescripcionRequerimientos()
    {
        return this.descripcionRequerimientos;
    }

    public void setDescripcionRequerimientosAsArray(Object[] descripcionRequerimientos)
    {
        this.descripcionRequerimientos = (descripcionRequerimientos == null) ? null : java.util.Arrays.asList(descripcionRequerimientos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormTecnicaFormImpl#getDescripcionRequerimientos
     */
    public java.lang.Object[] getDescripcionRequerimientosAsArray()
    {
        return (descripcionRequerimientos == null) ? null : descripcionRequerimientos.toArray();
    }
    
    public java.lang.Object[] getDescripcionRequerimientosBackingList()
    {
        java.lang.Object[] values = this.descripcionRequerimientosValueList;
        java.lang.Object[] labels = this.descripcionRequerimientosLabelList;

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

    public java.lang.Object[] getDescripcionRequerimientosValueList()
    {
        return this.descripcionRequerimientosValueList;
    }

    public void setDescripcionRequerimientosValueList(java.lang.Object[] descripcionRequerimientosValueList)
    {
        this.descripcionRequerimientosValueList = descripcionRequerimientosValueList;
    }

    public java.lang.Object[] getDescripcionRequerimientosLabelList()
    {
        return this.descripcionRequerimientosLabelList;
    }

    public void setDescripcionRequerimientosLabelList(java.lang.Object[] descripcionRequerimientosLabelList)
    {
        this.descripcionRequerimientosLabelList = descripcionRequerimientosLabelList;
    }

    public void setDescripcionRequerimientosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setDescripcionRequerimientosBackingList requires non-null property arguments");
        }

        this.descripcionRequerimientosValueList = null;
        this.descripcionRequerimientosLabelList = null;

        if (items != null)
        {
            this.descripcionRequerimientosValueList = new java.lang.Object[items.size()];
            this.descripcionRequerimientosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionRequerimientosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionRequerimientosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setDescripcionRequerimientosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>requerimiento</code>.
     */
    public void resetRequerimiento()
    {
        this.requerimiento = null;
    }

    public void setRequerimiento(java.util.Collection requerimiento)
    {
        this.requerimiento = requerimiento;
    }

    /**
     * 
     */
    public java.util.Collection getRequerimiento()
    {
        return this.requerimiento;
    }

    public void setRequerimientoAsArray(Object[] requerimiento)
    {
        this.requerimiento = (requerimiento == null) ? null : java.util.Arrays.asList(requerimiento);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormTecnicaFormImpl#getRequerimiento
     */
    public java.lang.Object[] getRequerimientoAsArray()
    {
        return (requerimiento == null) ? null : requerimiento.toArray();
    }
    
    public java.lang.Object[] getRequerimientoBackingList()
    {
        java.lang.Object[] values = this.requerimientoValueList;
        java.lang.Object[] labels = this.requerimientoLabelList;

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

    public java.lang.Object[] getRequerimientoValueList()
    {
        return this.requerimientoValueList;
    }

    public void setRequerimientoValueList(java.lang.Object[] requerimientoValueList)
    {
        this.requerimientoValueList = requerimientoValueList;
    }

    public java.lang.Object[] getRequerimientoLabelList()
    {
        return this.requerimientoLabelList;
    }

    public void setRequerimientoLabelList(java.lang.Object[] requerimientoLabelList)
    {
        this.requerimientoLabelList = requerimientoLabelList;
    }

    public void setRequerimientoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setRequerimientoBackingList requires non-null property arguments");
        }

        this.requerimientoValueList = null;
        this.requerimientoLabelList = null;

        if (items != null)
        {
            this.requerimientoValueList = new java.lang.Object[items.size()];
            this.requerimientoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.requerimientoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.requerimientoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setRequerimientoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboTipo</code>.
     */
    public void resetComboTipo()
    {
        this.comboTipo = null;
    }

    public void setComboTipo(java.lang.String comboTipo)
    {
        this.comboTipo = comboTipo;
    }

    /**
     * 
     */
    public java.lang.String getComboTipo()
    {
        return this.comboTipo;
    }
    
    public java.lang.Object[] getComboTipoBackingList()
    {
        java.lang.Object[] values = this.comboTipoValueList;
        java.lang.Object[] labels = this.comboTipoLabelList;

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

    public java.lang.Object[] getComboTipoValueList()
    {
        return this.comboTipoValueList;
    }

    public void setComboTipoValueList(java.lang.Object[] comboTipoValueList)
    {
        this.comboTipoValueList = comboTipoValueList;
    }

    public java.lang.Object[] getComboTipoLabelList()
    {
        return this.comboTipoLabelList;
    }

    public void setComboTipoLabelList(java.lang.Object[] comboTipoLabelList)
    {
        this.comboTipoLabelList = comboTipoLabelList;
    }

    public void setComboTipoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setComboTipoBackingList requires non-null property arguments");
        }

        this.comboTipoValueList = null;
        this.comboTipoLabelList = null;

        if (items != null)
        {
            this.comboTipoValueList = new java.lang.Object[items.size()];
            this.comboTipoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboTipoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboTipoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setComboTipoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcionInstalacion</code>.
     */
    public void resetDescripcionInstalacion()
    {
        this.descripcionInstalacion = null;
    }

    public void setDescripcionInstalacion(java.util.Collection descripcionInstalacion)
    {
        this.descripcionInstalacion = descripcionInstalacion;
    }

    /**
     * 
     */
    public java.util.Collection getDescripcionInstalacion()
    {
        return this.descripcionInstalacion;
    }

    public void setDescripcionInstalacionAsArray(Object[] descripcionInstalacion)
    {
        this.descripcionInstalacion = (descripcionInstalacion == null) ? null : java.util.Arrays.asList(descripcionInstalacion);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormTecnicaFormImpl#getDescripcionInstalacion
     */
    public java.lang.Object[] getDescripcionInstalacionAsArray()
    {
        return (descripcionInstalacion == null) ? null : descripcionInstalacion.toArray();
    }
    
    public java.lang.Object[] getDescripcionInstalacionBackingList()
    {
        java.lang.Object[] values = this.descripcionInstalacionValueList;
        java.lang.Object[] labels = this.descripcionInstalacionLabelList;

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

    public java.lang.Object[] getDescripcionInstalacionValueList()
    {
        return this.descripcionInstalacionValueList;
    }

    public void setDescripcionInstalacionValueList(java.lang.Object[] descripcionInstalacionValueList)
    {
        this.descripcionInstalacionValueList = descripcionInstalacionValueList;
    }

    public java.lang.Object[] getDescripcionInstalacionLabelList()
    {
        return this.descripcionInstalacionLabelList;
    }

    public void setDescripcionInstalacionLabelList(java.lang.Object[] descripcionInstalacionLabelList)
    {
        this.descripcionInstalacionLabelList = descripcionInstalacionLabelList;
    }

    public void setDescripcionInstalacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setDescripcionInstalacionBackingList requires non-null property arguments");
        }

        this.descripcionInstalacionValueList = null;
        this.descripcionInstalacionLabelList = null;

        if (items != null)
        {
            this.descripcionInstalacionValueList = new java.lang.Object[items.size()];
            this.descripcionInstalacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionInstalacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionInstalacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setDescripcionInstalacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcionDuracion</code>.
     */
    public void resetDescripcionDuracion()
    {
        this.descripcionDuracion = null;
    }

    public void setDescripcionDuracion(java.util.Collection descripcionDuracion)
    {
        this.descripcionDuracion = descripcionDuracion;
    }

    /**
     * 
     */
    public java.util.Collection getDescripcionDuracion()
    {
        return this.descripcionDuracion;
    }

    public void setDescripcionDuracionAsArray(Object[] descripcionDuracion)
    {
        this.descripcionDuracion = (descripcionDuracion == null) ? null : java.util.Arrays.asList(descripcionDuracion);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormTecnicaFormImpl#getDescripcionDuracion
     */
    public java.lang.Object[] getDescripcionDuracionAsArray()
    {
        return (descripcionDuracion == null) ? null : descripcionDuracion.toArray();
    }
    
    public java.lang.Object[] getDescripcionDuracionBackingList()
    {
        java.lang.Object[] values = this.descripcionDuracionValueList;
        java.lang.Object[] labels = this.descripcionDuracionLabelList;

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

    public java.lang.Object[] getDescripcionDuracionValueList()
    {
        return this.descripcionDuracionValueList;
    }

    public void setDescripcionDuracionValueList(java.lang.Object[] descripcionDuracionValueList)
    {
        this.descripcionDuracionValueList = descripcionDuracionValueList;
    }

    public java.lang.Object[] getDescripcionDuracionLabelList()
    {
        return this.descripcionDuracionLabelList;
    }

    public void setDescripcionDuracionLabelList(java.lang.Object[] descripcionDuracionLabelList)
    {
        this.descripcionDuracionLabelList = descripcionDuracionLabelList;
    }

    public void setDescripcionDuracionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setDescripcionDuracionBackingList requires non-null property arguments");
        }

        this.descripcionDuracionValueList = null;
        this.descripcionDuracionLabelList = null;

        if (items != null)
        {
            this.descripcionDuracionValueList = new java.lang.Object[items.size()];
            this.descripcionDuracionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionDuracionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionDuracionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setDescripcionDuracionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>dia</code>.
     */
    public void resetDia()
    {
        this.dia = null;
    }

    public void setDia(java.lang.String dia)
    {
        this.dia = dia;
    }

    /**
     * 
     */
    public java.lang.String getDia()
    {
        return this.dia;
    }
    
    public java.lang.Object[] getDiaBackingList()
    {
        java.lang.Object[] values = this.diaValueList;
        java.lang.Object[] labels = this.diaLabelList;

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

    public java.lang.Object[] getDiaValueList()
    {
        return this.diaValueList;
    }

    public void setDiaValueList(java.lang.Object[] diaValueList)
    {
        this.diaValueList = diaValueList;
    }

    public java.lang.Object[] getDiaLabelList()
    {
        return this.diaLabelList;
    }

    public void setDiaLabelList(java.lang.Object[] diaLabelList)
    {
        this.diaLabelList = diaLabelList;
    }

    public void setDiaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setDiaBackingList requires non-null property arguments");
        }

        this.diaValueList = null;
        this.diaLabelList = null;

        if (items != null)
        {
            this.diaValueList = new java.lang.Object[items.size()];
            this.diaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.diaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.diaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setDiaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>duracion</code>.
     */
    public void resetDuracion()
    {
        this.duracion = null;
    }

    public void setDuracion(java.util.Collection duracion)
    {
        this.duracion = duracion;
    }

    /**
     * 
     */
    public java.util.Collection getDuracion()
    {
        return this.duracion;
    }

    public void setDuracionAsArray(Object[] duracion)
    {
        this.duracion = (duracion == null) ? null : java.util.Arrays.asList(duracion);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormTecnicaFormImpl#getDuracion
     */
    public java.lang.Object[] getDuracionAsArray()
    {
        return (duracion == null) ? null : duracion.toArray();
    }
    
    public java.lang.Object[] getDuracionBackingList()
    {
        java.lang.Object[] values = this.duracionValueList;
        java.lang.Object[] labels = this.duracionLabelList;

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

    public java.lang.Object[] getDuracionValueList()
    {
        return this.duracionValueList;
    }

    public void setDuracionValueList(java.lang.Object[] duracionValueList)
    {
        this.duracionValueList = duracionValueList;
    }

    public java.lang.Object[] getDuracionLabelList()
    {
        return this.duracionLabelList;
    }

    public void setDuracionLabelList(java.lang.Object[] duracionLabelList)
    {
        this.duracionLabelList = duracionLabelList;
    }

    public void setDuracionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setDuracionBackingList requires non-null property arguments");
        }

        this.duracionValueList = null;
        this.duracionLabelList = null;

        if (items != null)
        {
            this.duracionValueList = new java.lang.Object[items.size()];
            this.duracionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.duracionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.duracionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setDuracionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>agregadorOR</code>.
     */
    public void resetAgregadorOR()
    {
        this.agregadorOR = null;
    }

    public void setAgregadorOR(java.util.Collection agregadorOR)
    {
        this.agregadorOR = agregadorOR;
    }

    /**
     * 
     */
    public java.util.Collection getAgregadorOR()
    {
        return this.agregadorOR;
    }

    public void setAgregadorORAsArray(Object[] agregadorOR)
    {
        this.agregadorOR = (agregadorOR == null) ? null : java.util.Arrays.asList(agregadorOR);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormTecnicaFormImpl#getAgregadorOR
     */
    public java.lang.Object[] getAgregadorORAsArray()
    {
        return (agregadorOR == null) ? null : agregadorOR.toArray();
    }
    
    public java.lang.Object[] getAgregadorORBackingList()
    {
        java.lang.Object[] values = this.agregadorORValueList;
        java.lang.Object[] labels = this.agregadorORLabelList;

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

    public java.lang.Object[] getAgregadorORValueList()
    {
        return this.agregadorORValueList;
    }

    public void setAgregadorORValueList(java.lang.Object[] agregadorORValueList)
    {
        this.agregadorORValueList = agregadorORValueList;
    }

    public java.lang.Object[] getAgregadorORLabelList()
    {
        return this.agregadorORLabelList;
    }

    public void setAgregadorORLabelList(java.lang.Object[] agregadorORLabelList)
    {
        this.agregadorORLabelList = agregadorORLabelList;
    }

    public void setAgregadorORBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setAgregadorORBackingList requires non-null property arguments");
        }

        this.agregadorORValueList = null;
        this.agregadorORLabelList = null;

        if (items != null)
        {
            this.agregadorORValueList = new java.lang.Object[items.size()];
            this.agregadorORLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.agregadorORValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.agregadorORLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setAgregadorORBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setHoraBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setHoraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboNombre</code>.
     */
    public void resetComboNombre()
    {
        this.comboNombre = null;
    }

    public void setComboNombre(java.lang.String comboNombre)
    {
        this.comboNombre = comboNombre;
    }

    /**
     * 
     */
    public java.lang.String getComboNombre()
    {
        return this.comboNombre;
    }
    
    public java.lang.Object[] getComboNombreBackingList()
    {
        java.lang.Object[] values = this.comboNombreValueList;
        java.lang.Object[] labels = this.comboNombreLabelList;

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

    public java.lang.Object[] getComboNombreValueList()
    {
        return this.comboNombreValueList;
    }

    public void setComboNombreValueList(java.lang.Object[] comboNombreValueList)
    {
        this.comboNombreValueList = comboNombreValueList;
    }

    public java.lang.Object[] getComboNombreLabelList()
    {
        return this.comboNombreLabelList;
    }

    public void setComboNombreLabelList(java.lang.Object[] comboNombreLabelList)
    {
        this.comboNombreLabelList = comboNombreLabelList;
    }

    public void setComboNombreBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setComboNombreBackingList requires non-null property arguments");
        }

        this.comboNombreValueList = null;
        this.comboNombreLabelList = null;

        if (items != null)
        {
            this.comboNombreValueList = new java.lang.Object[items.size()];
            this.comboNombreLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboNombreValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboNombreLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setComboNombreBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>mes</code>.
     */
    public void resetMes()
    {
        this.mes = null;
    }

    public void setMes(java.lang.String mes)
    {
        this.mes = mes;
    }

    /**
     * 
     */
    public java.lang.String getMes()
    {
        return this.mes;
    }
    
    public java.lang.Object[] getMesBackingList()
    {
        java.lang.Object[] values = this.mesValueList;
        java.lang.Object[] labels = this.mesLabelList;

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

    public java.lang.Object[] getMesValueList()
    {
        return this.mesValueList;
    }

    public void setMesValueList(java.lang.Object[] mesValueList)
    {
        this.mesValueList = mesValueList;
    }

    public java.lang.Object[] getMesLabelList()
    {
        return this.mesLabelList;
    }

    public void setMesLabelList(java.lang.Object[] mesLabelList)
    {
        this.mesLabelList = mesLabelList;
    }

    public void setMesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setMesBackingList requires non-null property arguments");
        }

        this.mesValueList = null;
        this.mesLabelList = null;

        if (items != null)
        {
            this.mesValueList = new java.lang.Object[items.size()];
            this.mesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setMesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tamanio</code>.
     */
    public void resetTamanio()
    {
        this.tamanio = null;
    }

    public void setTamanio(java.lang.String tamanio)
    {
        this.tamanio = tamanio;
    }

    /**
     * 
     */
    public java.lang.String getTamanio()
    {
        return this.tamanio;
    }
    
    public java.lang.Object[] getTamanioBackingList()
    {
        java.lang.Object[] values = this.tamanioValueList;
        java.lang.Object[] labels = this.tamanioLabelList;

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

    public java.lang.Object[] getTamanioValueList()
    {
        return this.tamanioValueList;
    }

    public void setTamanioValueList(java.lang.Object[] tamanioValueList)
    {
        this.tamanioValueList = tamanioValueList;
    }

    public java.lang.Object[] getTamanioLabelList()
    {
        return this.tamanioLabelList;
    }

    public void setTamanioLabelList(java.lang.Object[] tamanioLabelList)
    {
        this.tamanioLabelList = tamanioLabelList;
    }

    public void setTamanioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setTamanioBackingList requires non-null property arguments");
        }

        this.tamanioValueList = null;
        this.tamanioLabelList = null;

        if (items != null)
        {
            this.tamanioValueList = new java.lang.Object[items.size()];
            this.tamanioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tamanioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tamanioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setTamanioBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setComboIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setComboIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>localizacion</code>.
     */
    public void resetLocalizacion()
    {
        this.localizacion = null;
    }

    public void setLocalizacion(java.util.Collection localizacion)
    {
        this.localizacion = localizacion;
    }

    /**
     * 
     */
    public java.util.Collection getLocalizacion()
    {
        return this.localizacion;
    }

    public void setLocalizacionAsArray(Object[] localizacion)
    {
        this.localizacion = (localizacion == null) ? null : java.util.Arrays.asList(localizacion);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormTecnicaFormImpl#getLocalizacion
     */
    public java.lang.Object[] getLocalizacionAsArray()
    {
        return (localizacion == null) ? null : localizacion.toArray();
    }
    
    public java.lang.Object[] getLocalizacionBackingList()
    {
        java.lang.Object[] values = this.localizacionValueList;
        java.lang.Object[] labels = this.localizacionLabelList;

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

    public java.lang.Object[] getLocalizacionValueList()
    {
        return this.localizacionValueList;
    }

    public void setLocalizacionValueList(java.lang.Object[] localizacionValueList)
    {
        this.localizacionValueList = localizacionValueList;
    }

    public java.lang.Object[] getLocalizacionLabelList()
    {
        return this.localizacionLabelList;
    }

    public void setLocalizacionLabelList(java.lang.Object[] localizacionLabelList)
    {
        this.localizacionLabelList = localizacionLabelList;
    }

    public void setLocalizacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setLocalizacionBackingList requires non-null property arguments");
        }

        this.localizacionValueList = null;
        this.localizacionLabelList = null;

        if (items != null)
        {
            this.localizacionValueList = new java.lang.Object[items.size()];
            this.localizacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.localizacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.localizacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setLocalizacionBackingList encountered an exception", ex);
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
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormTecnicaFormImpl#getDatos
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
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setDatosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setDatosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>anyo</code>.
     */
    public void resetAnyo()
    {
        this.anyo = null;
    }

    public void setAnyo(java.lang.String anyo)
    {
        this.anyo = anyo;
    }

    /**
     * 
     */
    public java.lang.String getAnyo()
    {
        return this.anyo;
    }
    
    public java.lang.Object[] getAnyoBackingList()
    {
        java.lang.Object[] values = this.anyoValueList;
        java.lang.Object[] labels = this.anyoLabelList;

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

    public java.lang.Object[] getAnyoValueList()
    {
        return this.anyoValueList;
    }

    public void setAnyoValueList(java.lang.Object[] anyoValueList)
    {
        this.anyoValueList = anyoValueList;
    }

    public java.lang.Object[] getAnyoLabelList()
    {
        return this.anyoLabelList;
    }

    public void setAnyoLabelList(java.lang.Object[] anyoLabelList)
    {
        this.anyoLabelList = anyoLabelList;
    }

    public void setAnyoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setAnyoBackingList requires non-null property arguments");
        }

        this.anyoValueList = null;
        this.anyoLabelList = null;

        if (items != null)
        {
            this.anyoValueList = new java.lang.Object[items.size()];
            this.anyoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.anyoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.anyoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setAnyoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>formatos</code>.
     */
    public void resetFormatos()
    {
        this.formatos = null;
    }

    public void setFormatos(java.util.Collection formatos)
    {
        this.formatos = formatos;
    }

    /**
     * 
     */
    public java.util.Collection getFormatos()
    {
        return this.formatos;
    }

    public void setFormatosAsArray(Object[] formatos)
    {
        this.formatos = (formatos == null) ? null : java.util.Arrays.asList(formatos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.CategoriasFormTecnicaFormImpl#getFormatos
     */
    public java.lang.Object[] getFormatosAsArray()
    {
        return (formatos == null) ? null : formatos.toArray();
    }
    
    public java.lang.Object[] getFormatosBackingList()
    {
        java.lang.Object[] values = this.formatosValueList;
        java.lang.Object[] labels = this.formatosLabelList;

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

    public java.lang.Object[] getFormatosValueList()
    {
        return this.formatosValueList;
    }

    public void setFormatosValueList(java.lang.Object[] formatosValueList)
    {
        this.formatosValueList = formatosValueList;
    }

    public java.lang.Object[] getFormatosLabelList()
    {
        return this.formatosLabelList;
    }

    public void setFormatosLabelList(java.lang.Object[] formatosLabelList)
    {
        this.formatosLabelList = formatosLabelList;
    }

    public void setFormatosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setFormatosBackingList requires non-null property arguments");
        }

        this.formatosValueList = null;
        this.formatosLabelList = null;

        if (items != null)
        {
            this.formatosValueList = new java.lang.Object[items.size()];
            this.formatosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.formatosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.formatosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setFormatosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboFormato</code>.
     */
    public void resetComboFormato()
    {
        this.comboFormato = null;
    }

    public void setComboFormato(java.lang.String comboFormato)
    {
        this.comboFormato = comboFormato;
    }

    /**
     * 
     */
    public java.lang.String getComboFormato()
    {
        return this.comboFormato;
    }
    
    public java.lang.Object[] getComboFormatoBackingList()
    {
        java.lang.Object[] values = this.comboFormatoValueList;
        java.lang.Object[] labels = this.comboFormatoLabelList;

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

    public java.lang.Object[] getComboFormatoValueList()
    {
        return this.comboFormatoValueList;
    }

    public void setComboFormatoValueList(java.lang.Object[] comboFormatoValueList)
    {
        this.comboFormatoValueList = comboFormatoValueList;
    }

    public java.lang.Object[] getComboFormatoLabelList()
    {
        return this.comboFormatoLabelList;
    }

    public void setComboFormatoLabelList(java.lang.Object[] comboFormatoLabelList)
    {
        this.comboFormatoLabelList = comboFormatoLabelList;
    }

    public void setComboFormatoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setComboFormatoBackingList requires non-null property arguments");
        }

        this.comboFormatoValueList = null;
        this.comboFormatoLabelList = null;

        if (items != null)
        {
            this.comboFormatoValueList = new java.lang.Object[items.size()];
            this.comboFormatoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboFormatoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboFormatoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setComboFormatoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setReturnURLBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setReturnURLBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CategoriasFormTecnicaFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CategoriasFormTecnicaFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.comboTipo = null;
        this.comboNombre = null;
        this.comboIdioma = null;
        this.datos = null;
        this.datosValueList = new java.lang.Object[0];
        this.datosLabelList = new java.lang.Object[0];
        this.formatos = null;
        this.formatosValueList = new java.lang.Object[0];
        this.formatosLabelList = new java.lang.Object[0];
        this.comboFormato = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("segundoP2", this.segundoP2);
        builder.append("minutos", this.minutos);
        builder.append("segundoP1", this.segundoP1);
        builder.append("descripcionRequerimientos", this.descripcionRequerimientos);
        builder.append("requerimiento", this.requerimiento);
        builder.append("comboTipo", this.comboTipo);
        builder.append("descripcionInstalacion", this.descripcionInstalacion);
        builder.append("descripcionDuracion", this.descripcionDuracion);
        builder.append("dia", this.dia);
        builder.append("duracion", this.duracion);
        builder.append("agregadorOR", this.agregadorOR);
        builder.append("hora", this.hora);
        builder.append("comboNombre", this.comboNombre);
        builder.append("mes", this.mes);
        builder.append("tamanio", this.tamanio);
        builder.append("comboIdioma", this.comboIdioma);
        builder.append("localizacion", this.localizacion);
        builder.append("datos", this.datos);
        builder.append("anyo", this.anyo);
        builder.append("formatos", this.formatos);
        builder.append("comboFormato", this.comboFormato);
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
        this.segundoP2 = null;
        this.segundoP2ValueList = null;
        this.segundoP2LabelList = null;
        this.minutos = null;
        this.minutosValueList = null;
        this.minutosLabelList = null;
        this.segundoP1 = null;
        this.segundoP1ValueList = null;
        this.segundoP1LabelList = null;
        this.descripcionRequerimientos = null;
        this.descripcionRequerimientosValueList = null;
        this.descripcionRequerimientosLabelList = null;
        this.requerimiento = null;
        this.requerimientoValueList = null;
        this.requerimientoLabelList = null;
        this.comboTipo = null;
        this.comboTipoValueList = null;
        this.comboTipoLabelList = null;
        this.descripcionInstalacion = null;
        this.descripcionInstalacionValueList = null;
        this.descripcionInstalacionLabelList = null;
        this.descripcionDuracion = null;
        this.descripcionDuracionValueList = null;
        this.descripcionDuracionLabelList = null;
        this.dia = null;
        this.diaValueList = null;
        this.diaLabelList = null;
        this.duracion = null;
        this.duracionValueList = null;
        this.duracionLabelList = null;
        this.agregadorOR = null;
        this.agregadorORValueList = null;
        this.agregadorORLabelList = null;
        this.hora = null;
        this.horaValueList = null;
        this.horaLabelList = null;
        this.comboNombre = null;
        this.comboNombreValueList = null;
        this.comboNombreLabelList = null;
        this.mes = null;
        this.mesValueList = null;
        this.mesLabelList = null;
        this.tamanio = null;
        this.tamanioValueList = null;
        this.tamanioLabelList = null;
        this.comboIdioma = null;
        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;
        this.localizacion = null;
        this.localizacionValueList = null;
        this.localizacionLabelList = null;
        this.datos = null;
        this.datosValueList = null;
        this.datosLabelList = null;
        this.anyo = null;
        this.anyoValueList = null;
        this.anyoLabelList = null;
        this.formatos = null;
        this.formatosValueList = null;
        this.formatosLabelList = null;
        this.comboFormato = null;
        this.comboFormatoValueList = null;
        this.comboFormatoLabelList = null;
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
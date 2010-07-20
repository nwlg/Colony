// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida;

public class CicloValidoVolverFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CargarLifeCycleValidarForm
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
    private java.lang.String fecha;
    private java.lang.Object[] fechaValueList;
    private java.lang.Object[] fechaLabelList;
    private java.util.Collection cidentidad;
    private java.lang.Object[] cidentidadValueList;
    private java.lang.Object[] cidentidadLabelList;
    private java.lang.String meridianocero;
    private java.lang.Object[] meridianoceroValueList;
    private java.lang.Object[] meridianoceroLabelList;
    private java.lang.String dia;
    private java.lang.Object[] diaValueList;
    private java.lang.Object[] diaLabelList;
    private java.lang.String accion;
    private java.lang.Object[] accionValueList;
    private java.lang.Object[] accionLabelList;
    private java.lang.String zhHora;
    private java.lang.Object[] zhHoraValueList;
    private java.lang.Object[] zhHoraLabelList;
    private java.lang.String hora;
    private java.lang.Object[] horaValueList;
    private java.lang.Object[] horaLabelList;
    private java.util.Collection versiones;
    private java.lang.Object[] versionesValueList;
    private java.lang.Object[] versionesLabelList;
    private java.lang.String crol;
    private java.lang.Object[] crolValueList;
    private java.lang.Object[] crolLabelList;
    private java.lang.String comboIdioma;
    private java.lang.Object[] comboIdiomaValueList;
    private java.lang.Object[] comboIdiomaLabelList;
    private java.lang.String mes;
    private java.lang.Object[] mesValueList;
    private java.lang.Object[] mesLabelList;
    private java.lang.String zhMinutos;
    private java.lang.Object[] zhMinutosValueList;
    private java.lang.Object[] zhMinutosLabelList;
    private java.util.Collection contribuciones;
    private java.lang.Object[] contribucionesValueList;
    private java.lang.Object[] contribucionesLabelList;
    private java.lang.String anyo;
    private java.lang.Object[] anyoValueList;
    private java.lang.Object[] anyoLabelList;
    private java.lang.String estatus;
    private java.lang.Object[] estatusValueList;
    private java.lang.Object[] estatusLabelList;
    private java.lang.String comboZonaH;
    private java.lang.Object[] comboZonaHValueList;
    private java.lang.Object[] comboZonaHLabelList;
    private java.util.Collection mensajesError;
    private java.lang.Object[] mensajesErrorValueList;
    private java.lang.Object[] mensajesErrorLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;

    public CicloValidoVolverFormImpl()
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setMinutosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setMinutosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setSegundoP2BackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setSegundoP2BackingList encountered an exception", ex);
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CicloValidoVolverFormImpl#getDescripciones
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setDescripcionesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setDescripcionesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setSegundoP1BackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setSegundoP1BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>fecha</code>.
     */
    public void resetFecha()
    {
        this.fecha = null;
    }

    public void setFecha(java.lang.String fecha)
    {
        this.fecha = fecha;
    }

    /**
     * 
     */
    public java.lang.String getFecha()
    {
        return this.fecha;
    }
    
    public java.lang.Object[] getFechaBackingList()
    {
        java.lang.Object[] values = this.fechaValueList;
        java.lang.Object[] labels = this.fechaLabelList;

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

    public java.lang.Object[] getFechaValueList()
    {
        return this.fechaValueList;
    }

    public void setFechaValueList(java.lang.Object[] fechaValueList)
    {
        this.fechaValueList = fechaValueList;
    }

    public java.lang.Object[] getFechaLabelList()
    {
        return this.fechaLabelList;
    }

    public void setFechaLabelList(java.lang.Object[] fechaLabelList)
    {
        this.fechaLabelList = fechaLabelList;
    }

    public void setFechaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setFechaBackingList requires non-null property arguments");
        }

        this.fechaValueList = null;
        this.fechaLabelList = null;

        if (items != null)
        {
            this.fechaValueList = new java.lang.Object[items.size()];
            this.fechaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.fechaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.fechaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setFechaBackingList encountered an exception", ex);
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CicloValidoVolverFormImpl#getCidentidad
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setCidentidadBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setCidentidadBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setMeridianoceroBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setMeridianoceroBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setDiaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setDiaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>accion</code>.
     */
    public void resetAccion()
    {
        this.accion = null;
    }

    public void setAccion(java.lang.String accion)
    {
        this.accion = accion;
    }

    /**
     * 
     */
    public java.lang.String getAccion()
    {
        return this.accion;
    }
    
    public java.lang.Object[] getAccionBackingList()
    {
        java.lang.Object[] values = this.accionValueList;
        java.lang.Object[] labels = this.accionLabelList;

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

    public java.lang.Object[] getAccionValueList()
    {
        return this.accionValueList;
    }

    public void setAccionValueList(java.lang.Object[] accionValueList)
    {
        this.accionValueList = accionValueList;
    }

    public java.lang.Object[] getAccionLabelList()
    {
        return this.accionLabelList;
    }

    public void setAccionLabelList(java.lang.Object[] accionLabelList)
    {
        this.accionLabelList = accionLabelList;
    }

    public void setAccionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setAccionBackingList requires non-null property arguments");
        }

        this.accionValueList = null;
        this.accionLabelList = null;

        if (items != null)
        {
            this.accionValueList = new java.lang.Object[items.size()];
            this.accionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.accionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.accionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setAccionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setZhHoraBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setZhHoraBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setHoraBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setHoraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>versiones</code>.
     */
    public void resetVersiones()
    {
        this.versiones = null;
    }

    public void setVersiones(java.util.Collection versiones)
    {
        this.versiones = versiones;
    }

    /**
     * 
     */
    public java.util.Collection getVersiones()
    {
        return this.versiones;
    }

    public void setVersionesAsArray(Object[] versiones)
    {
        this.versiones = (versiones == null) ? null : java.util.Arrays.asList(versiones);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CicloValidoVolverFormImpl#getVersiones
     */
    public java.lang.Object[] getVersionesAsArray()
    {
        return (versiones == null) ? null : versiones.toArray();
    }
    
    public java.lang.Object[] getVersionesBackingList()
    {
        java.lang.Object[] values = this.versionesValueList;
        java.lang.Object[] labels = this.versionesLabelList;

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

    public java.lang.Object[] getVersionesValueList()
    {
        return this.versionesValueList;
    }

    public void setVersionesValueList(java.lang.Object[] versionesValueList)
    {
        this.versionesValueList = versionesValueList;
    }

    public java.lang.Object[] getVersionesLabelList()
    {
        return this.versionesLabelList;
    }

    public void setVersionesLabelList(java.lang.Object[] versionesLabelList)
    {
        this.versionesLabelList = versionesLabelList;
    }

    public void setVersionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setVersionesBackingList requires non-null property arguments");
        }

        this.versionesValueList = null;
        this.versionesLabelList = null;

        if (items != null)
        {
            this.versionesValueList = new java.lang.Object[items.size()];
            this.versionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.versionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.versionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setVersionesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setCrolBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setCrolBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setComboIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setComboIdiomaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setMesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setMesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setZhMinutosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setZhMinutosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>contribuciones</code>.
     */
    public void resetContribuciones()
    {
        this.contribuciones = null;
    }

    public void setContribuciones(java.util.Collection contribuciones)
    {
        this.contribuciones = contribuciones;
    }

    /**
     * 
     */
    public java.util.Collection getContribuciones()
    {
        return this.contribuciones;
    }

    public void setContribucionesAsArray(Object[] contribuciones)
    {
        this.contribuciones = (contribuciones == null) ? null : java.util.Arrays.asList(contribuciones);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CicloValidoVolverFormImpl#getContribuciones
     */
    public java.lang.Object[] getContribucionesAsArray()
    {
        return (contribuciones == null) ? null : contribuciones.toArray();
    }
    
    public java.lang.Object[] getContribucionesBackingList()
    {
        java.lang.Object[] values = this.contribucionesValueList;
        java.lang.Object[] labels = this.contribucionesLabelList;

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

    public java.lang.Object[] getContribucionesValueList()
    {
        return this.contribucionesValueList;
    }

    public void setContribucionesValueList(java.lang.Object[] contribucionesValueList)
    {
        this.contribucionesValueList = contribucionesValueList;
    }

    public java.lang.Object[] getContribucionesLabelList()
    {
        return this.contribucionesLabelList;
    }

    public void setContribucionesLabelList(java.lang.Object[] contribucionesLabelList)
    {
        this.contribucionesLabelList = contribucionesLabelList;
    }

    public void setContribucionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setContribucionesBackingList requires non-null property arguments");
        }

        this.contribucionesValueList = null;
        this.contribucionesLabelList = null;

        if (items != null)
        {
            this.contribucionesValueList = new java.lang.Object[items.size()];
            this.contribucionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.contribucionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.contribucionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setContribucionesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setAnyoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setAnyoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>estatus</code>.
     */
    public void resetEstatus()
    {
        this.estatus = null;
    }

    public void setEstatus(java.lang.String estatus)
    {
        this.estatus = estatus;
    }

    /**
     * 
     */
    public java.lang.String getEstatus()
    {
        return this.estatus;
    }
    
    public java.lang.Object[] getEstatusBackingList()
    {
        java.lang.Object[] values = this.estatusValueList;
        java.lang.Object[] labels = this.estatusLabelList;

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

    public java.lang.Object[] getEstatusValueList()
    {
        return this.estatusValueList;
    }

    public void setEstatusValueList(java.lang.Object[] estatusValueList)
    {
        this.estatusValueList = estatusValueList;
    }

    public java.lang.Object[] getEstatusLabelList()
    {
        return this.estatusLabelList;
    }

    public void setEstatusLabelList(java.lang.Object[] estatusLabelList)
    {
        this.estatusLabelList = estatusLabelList;
    }

    public void setEstatusBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setEstatusBackingList requires non-null property arguments");
        }

        this.estatusValueList = null;
        this.estatusLabelList = null;

        if (items != null)
        {
            this.estatusValueList = new java.lang.Object[items.size()];
            this.estatusLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.estatusValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.estatusLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setEstatusBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setComboZonaHBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setComboZonaHBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>mensajesError</code>.
     */
    public void resetMensajesError()
    {
        this.mensajesError = null;
    }

    public void setMensajesError(java.util.Collection mensajesError)
    {
        this.mensajesError = mensajesError;
    }

    /**
     * 
     */
    public java.util.Collection getMensajesError()
    {
        return this.mensajesError;
    }

    public void setMensajesErrorAsArray(Object[] mensajesError)
    {
        this.mensajesError = (mensajesError == null) ? null : java.util.Arrays.asList(mensajesError);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.ciclodevida.CicloValidoVolverFormImpl#getMensajesError
     */
    public java.lang.Object[] getMensajesErrorAsArray()
    {
        return (mensajesError == null) ? null : mensajesError.toArray();
    }
    
    public java.lang.Object[] getMensajesErrorBackingList()
    {
        java.lang.Object[] values = this.mensajesErrorValueList;
        java.lang.Object[] labels = this.mensajesErrorLabelList;

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

    public java.lang.Object[] getMensajesErrorValueList()
    {
        return this.mensajesErrorValueList;
    }

    public void setMensajesErrorValueList(java.lang.Object[] mensajesErrorValueList)
    {
        this.mensajesErrorValueList = mensajesErrorValueList;
    }

    public java.lang.Object[] getMensajesErrorLabelList()
    {
        return this.mensajesErrorLabelList;
    }

    public void setMensajesErrorLabelList(java.lang.Object[] mensajesErrorLabelList)
    {
        this.mensajesErrorLabelList = mensajesErrorLabelList;
    }

    public void setMensajesErrorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setMensajesErrorBackingList requires non-null property arguments");
        }

        this.mensajesErrorValueList = null;
        this.mensajesErrorLabelList = null;

        if (items != null)
        {
            this.mensajesErrorValueList = new java.lang.Object[items.size()];
            this.mensajesErrorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mensajesErrorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mensajesErrorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setMensajesErrorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CicloValidoVolverFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CicloValidoVolverFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.descripciones = null;
        this.descripcionesValueList = new java.lang.Object[0];
        this.descripcionesLabelList = new java.lang.Object[0];
        this.cidentidad = null;
        this.cidentidadValueList = new java.lang.Object[0];
        this.cidentidadLabelList = new java.lang.Object[0];
        this.versiones = null;
        this.versionesValueList = new java.lang.Object[0];
        this.versionesLabelList = new java.lang.Object[0];
        this.crol = null;
        this.comboIdioma = null;
        this.contribuciones = null;
        this.contribucionesValueList = new java.lang.Object[0];
        this.contribucionesLabelList = new java.lang.Object[0];
        this.estatus = null;
        this.comboZonaH = null;
        this.mensajesError = null;
        this.mensajesErrorValueList = new java.lang.Object[0];
        this.mensajesErrorLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("minutos", this.minutos);
        builder.append("segundoP2", this.segundoP2);
        builder.append("descripciones", this.descripciones);
        builder.append("segundoP1", this.segundoP1);
        builder.append("fecha", this.fecha);
        builder.append("cidentidad", this.cidentidad);
        builder.append("meridianocero", this.meridianocero);
        builder.append("dia", this.dia);
        builder.append("accion", this.accion);
        builder.append("zhHora", this.zhHora);
        builder.append("hora", this.hora);
        builder.append("versiones", this.versiones);
        builder.append("crol", this.crol);
        builder.append("comboIdioma", this.comboIdioma);
        builder.append("mes", this.mes);
        builder.append("zhMinutos", this.zhMinutos);
        builder.append("contribuciones", this.contribuciones);
        builder.append("anyo", this.anyo);
        builder.append("estatus", this.estatus);
        builder.append("comboZonaH", this.comboZonaH);
        builder.append("mensajesError", this.mensajesError);
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
        this.fecha = null;
        this.fechaValueList = null;
        this.fechaLabelList = null;
        this.cidentidad = null;
        this.cidentidadValueList = null;
        this.cidentidadLabelList = null;
        this.meridianocero = null;
        this.meridianoceroValueList = null;
        this.meridianoceroLabelList = null;
        this.dia = null;
        this.diaValueList = null;
        this.diaLabelList = null;
        this.accion = null;
        this.accionValueList = null;
        this.accionLabelList = null;
        this.zhHora = null;
        this.zhHoraValueList = null;
        this.zhHoraLabelList = null;
        this.hora = null;
        this.horaValueList = null;
        this.horaLabelList = null;
        this.versiones = null;
        this.versionesValueList = null;
        this.versionesLabelList = null;
        this.crol = null;
        this.crolValueList = null;
        this.crolLabelList = null;
        this.comboIdioma = null;
        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;
        this.mes = null;
        this.mesValueList = null;
        this.mesLabelList = null;
        this.zhMinutos = null;
        this.zhMinutosValueList = null;
        this.zhMinutosLabelList = null;
        this.contribuciones = null;
        this.contribucionesValueList = null;
        this.contribucionesLabelList = null;
        this.anyo = null;
        this.anyoValueList = null;
        this.anyoLabelList = null;
        this.estatus = null;
        this.estatusValueList = null;
        this.estatusLabelList = null;
        this.comboZonaH = null;
        this.comboZonaHValueList = null;
        this.comboZonaHLabelList = null;
        this.mensajesError = null;
        this.mensajesErrorValueList = null;
        this.mensajesErrorLabelList = null;
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
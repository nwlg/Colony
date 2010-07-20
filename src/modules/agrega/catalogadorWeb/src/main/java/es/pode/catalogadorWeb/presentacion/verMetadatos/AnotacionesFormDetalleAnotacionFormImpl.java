// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

public class AnotacionesFormDetalleAnotacionFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDetalleAnotacionForm
{
    private java.lang.String minutos;
    private java.lang.Object[] minutosValueList;
    private java.lang.Object[] minutosLabelList;
    private java.lang.String segundoP2;
    private java.lang.Object[] segundoP2ValueList;
    private java.lang.Object[] segundoP2LabelList;
    private java.lang.String botonPulsado;
    private java.lang.Object[] botonPulsadoValueList;
    private java.lang.Object[] botonPulsadoLabelList;
    private java.lang.String segundoP1;
    private java.lang.Object[] segundoP1ValueList;
    private java.lang.Object[] segundoP1LabelList;
    private java.util.Collection descripcionFecha;
    private java.lang.Object[] descripcionFechaValueList;
    private java.lang.Object[] descripcionFechaLabelList;
    private java.util.Collection descripcion;
    private java.lang.Object[] descripcionValueList;
    private java.lang.Object[] descripcionLabelList;
    private java.lang.String meridianocero;
    private java.lang.Object[] meridianoceroValueList;
    private java.lang.Object[] meridianoceroLabelList;
    private java.lang.String organizacion;
    private java.lang.Object[] organizacionValueList;
    private java.lang.Object[] organizacionLabelList;
    private java.util.Collection listadoAnotaciones;
    private java.lang.Object[] listadoAnotacionesValueList;
    private java.lang.Object[] listadoAnotacionesLabelList;
    private java.lang.String zhHora;
    private java.lang.Object[] zhHoraValueList;
    private java.lang.Object[] zhHoraLabelList;
    private java.lang.String nombre;
    private java.lang.Object[] nombreValueList;
    private java.lang.Object[] nombreLabelList;
    private java.lang.String hora;
    private java.lang.Object[] horaValueList;
    private java.lang.Object[] horaLabelList;
    private java.lang.String tituloAnotacion;
    private java.lang.Object[] tituloAnotacionValueList;
    private java.lang.Object[] tituloAnotacionLabelList;
    private java.lang.String email;
    private java.lang.Object[] emailValueList;
    private java.lang.Object[] emailLabelList;
    private java.lang.String comboIdioma;
    private java.lang.Object[] comboIdiomaValueList;
    private java.lang.Object[] comboIdiomaLabelList;
    private java.lang.String zhMinutos;
    private java.lang.Object[] zhMinutosValueList;
    private java.lang.Object[] zhMinutosLabelList;
    private java.lang.String fechaCorta;
    private java.lang.Object[] fechaCortaValueList;
    private java.lang.Object[] fechaCortaLabelList;
    private java.lang.String comboZonaH;
    private java.lang.Object[] comboZonaHValueList;
    private java.lang.Object[] comboZonaHLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;

    public AnotacionesFormDetalleAnotacionFormImpl()
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
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setMinutosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setMinutosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setSegundoP2BackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setSegundoP2BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>botonPulsado</code>.
     */
    public void resetBotonPulsado()
    {
        this.botonPulsado = null;
    }

    public void setBotonPulsado(java.lang.String botonPulsado)
    {
        this.botonPulsado = botonPulsado;
    }

    /**
     * 
     */
    public java.lang.String getBotonPulsado()
    {
        return this.botonPulsado;
    }
    
    public java.lang.Object[] getBotonPulsadoBackingList()
    {
        java.lang.Object[] values = this.botonPulsadoValueList;
        java.lang.Object[] labels = this.botonPulsadoLabelList;

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

    public java.lang.Object[] getBotonPulsadoValueList()
    {
        return this.botonPulsadoValueList;
    }

    public void setBotonPulsadoValueList(java.lang.Object[] botonPulsadoValueList)
    {
        this.botonPulsadoValueList = botonPulsadoValueList;
    }

    public java.lang.Object[] getBotonPulsadoLabelList()
    {
        return this.botonPulsadoLabelList;
    }

    public void setBotonPulsadoLabelList(java.lang.Object[] botonPulsadoLabelList)
    {
        this.botonPulsadoLabelList = botonPulsadoLabelList;
    }

    public void setBotonPulsadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setBotonPulsadoBackingList requires non-null property arguments");
        }

        this.botonPulsadoValueList = null;
        this.botonPulsadoLabelList = null;

        if (items != null)
        {
            this.botonPulsadoValueList = new java.lang.Object[items.size()];
            this.botonPulsadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.botonPulsadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.botonPulsadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setBotonPulsadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setSegundoP1BackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setSegundoP1BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcionFecha</code>.
     */
    public void resetDescripcionFecha()
    {
        this.descripcionFecha = null;
    }

    public void setDescripcionFecha(java.util.Collection descripcionFecha)
    {
        this.descripcionFecha = descripcionFecha;
    }

    /**
     * 
     */
    public java.util.Collection getDescripcionFecha()
    {
        return this.descripcionFecha;
    }

    public void setDescripcionFechaAsArray(Object[] descripcionFecha)
    {
        this.descripcionFecha = (descripcionFecha == null) ? null : java.util.Arrays.asList(descripcionFecha);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.AnotacionesFormDetalleAnotacionFormImpl#getDescripcionFecha
     */
    public java.lang.Object[] getDescripcionFechaAsArray()
    {
        return (descripcionFecha == null) ? null : descripcionFecha.toArray();
    }
    
    public java.lang.Object[] getDescripcionFechaBackingList()
    {
        java.lang.Object[] values = this.descripcionFechaValueList;
        java.lang.Object[] labels = this.descripcionFechaLabelList;

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

    public java.lang.Object[] getDescripcionFechaValueList()
    {
        return this.descripcionFechaValueList;
    }

    public void setDescripcionFechaValueList(java.lang.Object[] descripcionFechaValueList)
    {
        this.descripcionFechaValueList = descripcionFechaValueList;
    }

    public java.lang.Object[] getDescripcionFechaLabelList()
    {
        return this.descripcionFechaLabelList;
    }

    public void setDescripcionFechaLabelList(java.lang.Object[] descripcionFechaLabelList)
    {
        this.descripcionFechaLabelList = descripcionFechaLabelList;
    }

    public void setDescripcionFechaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setDescripcionFechaBackingList requires non-null property arguments");
        }

        this.descripcionFechaValueList = null;
        this.descripcionFechaLabelList = null;

        if (items != null)
        {
            this.descripcionFechaValueList = new java.lang.Object[items.size()];
            this.descripcionFechaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionFechaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionFechaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setDescripcionFechaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcion</code>.
     */
    public void resetDescripcion()
    {
        this.descripcion = null;
    }

    public void setDescripcion(java.util.Collection descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * 
     */
    public java.util.Collection getDescripcion()
    {
        return this.descripcion;
    }

    public void setDescripcionAsArray(Object[] descripcion)
    {
        this.descripcion = (descripcion == null) ? null : java.util.Arrays.asList(descripcion);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.AnotacionesFormDetalleAnotacionFormImpl#getDescripcion
     */
    public java.lang.Object[] getDescripcionAsArray()
    {
        return (descripcion == null) ? null : descripcion.toArray();
    }
    
    public java.lang.Object[] getDescripcionBackingList()
    {
        java.lang.Object[] values = this.descripcionValueList;
        java.lang.Object[] labels = this.descripcionLabelList;

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

    public java.lang.Object[] getDescripcionValueList()
    {
        return this.descripcionValueList;
    }

    public void setDescripcionValueList(java.lang.Object[] descripcionValueList)
    {
        this.descripcionValueList = descripcionValueList;
    }

    public java.lang.Object[] getDescripcionLabelList()
    {
        return this.descripcionLabelList;
    }

    public void setDescripcionLabelList(java.lang.Object[] descripcionLabelList)
    {
        this.descripcionLabelList = descripcionLabelList;
    }

    public void setDescripcionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setDescripcionBackingList requires non-null property arguments");
        }

        this.descripcionValueList = null;
        this.descripcionLabelList = null;

        if (items != null)
        {
            this.descripcionValueList = new java.lang.Object[items.size()];
            this.descripcionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setDescripcionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setMeridianoceroBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setMeridianoceroBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>organizacion</code>.
     */
    public void resetOrganizacion()
    {
        this.organizacion = null;
    }

    public void setOrganizacion(java.lang.String organizacion)
    {
        this.organizacion = organizacion;
    }

    /**
     * 
     */
    public java.lang.String getOrganizacion()
    {
        return this.organizacion;
    }
    
    public java.lang.Object[] getOrganizacionBackingList()
    {
        java.lang.Object[] values = this.organizacionValueList;
        java.lang.Object[] labels = this.organizacionLabelList;

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

    public java.lang.Object[] getOrganizacionValueList()
    {
        return this.organizacionValueList;
    }

    public void setOrganizacionValueList(java.lang.Object[] organizacionValueList)
    {
        this.organizacionValueList = organizacionValueList;
    }

    public java.lang.Object[] getOrganizacionLabelList()
    {
        return this.organizacionLabelList;
    }

    public void setOrganizacionLabelList(java.lang.Object[] organizacionLabelList)
    {
        this.organizacionLabelList = organizacionLabelList;
    }

    public void setOrganizacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setOrganizacionBackingList requires non-null property arguments");
        }

        this.organizacionValueList = null;
        this.organizacionLabelList = null;

        if (items != null)
        {
            this.organizacionValueList = new java.lang.Object[items.size()];
            this.organizacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.organizacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.organizacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setOrganizacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listadoAnotaciones</code>.
     */
    public void resetListadoAnotaciones()
    {
        this.listadoAnotaciones = null;
    }

    public void setListadoAnotaciones(java.util.Collection listadoAnotaciones)
    {
        this.listadoAnotaciones = listadoAnotaciones;
    }

    /**
     * 
     */
    public java.util.Collection getListadoAnotaciones()
    {
        return this.listadoAnotaciones;
    }

    public void setListadoAnotacionesAsArray(Object[] listadoAnotaciones)
    {
        this.listadoAnotaciones = (listadoAnotaciones == null) ? null : java.util.Arrays.asList(listadoAnotaciones);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.AnotacionesFormDetalleAnotacionFormImpl#getListadoAnotaciones
     */
    public java.lang.Object[] getListadoAnotacionesAsArray()
    {
        return (listadoAnotaciones == null) ? null : listadoAnotaciones.toArray();
    }
    
    public java.lang.Object[] getListadoAnotacionesBackingList()
    {
        java.lang.Object[] values = this.listadoAnotacionesValueList;
        java.lang.Object[] labels = this.listadoAnotacionesLabelList;

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

    public java.lang.Object[] getListadoAnotacionesValueList()
    {
        return this.listadoAnotacionesValueList;
    }

    public void setListadoAnotacionesValueList(java.lang.Object[] listadoAnotacionesValueList)
    {
        this.listadoAnotacionesValueList = listadoAnotacionesValueList;
    }

    public java.lang.Object[] getListadoAnotacionesLabelList()
    {
        return this.listadoAnotacionesLabelList;
    }

    public void setListadoAnotacionesLabelList(java.lang.Object[] listadoAnotacionesLabelList)
    {
        this.listadoAnotacionesLabelList = listadoAnotacionesLabelList;
    }

    public void setListadoAnotacionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setListadoAnotacionesBackingList requires non-null property arguments");
        }

        this.listadoAnotacionesValueList = null;
        this.listadoAnotacionesLabelList = null;

        if (items != null)
        {
            this.listadoAnotacionesValueList = new java.lang.Object[items.size()];
            this.listadoAnotacionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listadoAnotacionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listadoAnotacionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setListadoAnotacionesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setZhHoraBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setZhHoraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nombre</code>.
     */
    public void resetNombre()
    {
        this.nombre = null;
    }

    public void setNombre(java.lang.String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * 
     */
    public java.lang.String getNombre()
    {
        return this.nombre;
    }
    
    public java.lang.Object[] getNombreBackingList()
    {
        java.lang.Object[] values = this.nombreValueList;
        java.lang.Object[] labels = this.nombreLabelList;

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

    public java.lang.Object[] getNombreValueList()
    {
        return this.nombreValueList;
    }

    public void setNombreValueList(java.lang.Object[] nombreValueList)
    {
        this.nombreValueList = nombreValueList;
    }

    public java.lang.Object[] getNombreLabelList()
    {
        return this.nombreLabelList;
    }

    public void setNombreLabelList(java.lang.Object[] nombreLabelList)
    {
        this.nombreLabelList = nombreLabelList;
    }

    public void setNombreBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setNombreBackingList requires non-null property arguments");
        }

        this.nombreValueList = null;
        this.nombreLabelList = null;

        if (items != null)
        {
            this.nombreValueList = new java.lang.Object[items.size()];
            this.nombreLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nombreValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nombreLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setNombreBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setHoraBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setHoraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tituloAnotacion</code>.
     */
    public void resetTituloAnotacion()
    {
        this.tituloAnotacion = null;
    }

    public void setTituloAnotacion(java.lang.String tituloAnotacion)
    {
        this.tituloAnotacion = tituloAnotacion;
    }

    /**
     * 
     */
    public java.lang.String getTituloAnotacion()
    {
        return this.tituloAnotacion;
    }
    
    public java.lang.Object[] getTituloAnotacionBackingList()
    {
        java.lang.Object[] values = this.tituloAnotacionValueList;
        java.lang.Object[] labels = this.tituloAnotacionLabelList;

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

    public java.lang.Object[] getTituloAnotacionValueList()
    {
        return this.tituloAnotacionValueList;
    }

    public void setTituloAnotacionValueList(java.lang.Object[] tituloAnotacionValueList)
    {
        this.tituloAnotacionValueList = tituloAnotacionValueList;
    }

    public java.lang.Object[] getTituloAnotacionLabelList()
    {
        return this.tituloAnotacionLabelList;
    }

    public void setTituloAnotacionLabelList(java.lang.Object[] tituloAnotacionLabelList)
    {
        this.tituloAnotacionLabelList = tituloAnotacionLabelList;
    }

    public void setTituloAnotacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setTituloAnotacionBackingList requires non-null property arguments");
        }

        this.tituloAnotacionValueList = null;
        this.tituloAnotacionLabelList = null;

        if (items != null)
        {
            this.tituloAnotacionValueList = new java.lang.Object[items.size()];
            this.tituloAnotacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tituloAnotacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tituloAnotacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setTituloAnotacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>email</code>.
     */
    public void resetEmail()
    {
        this.email = null;
    }

    public void setEmail(java.lang.String email)
    {
        this.email = email;
    }

    /**
     * 
     */
    public java.lang.String getEmail()
    {
        return this.email;
    }
    
    public java.lang.Object[] getEmailBackingList()
    {
        java.lang.Object[] values = this.emailValueList;
        java.lang.Object[] labels = this.emailLabelList;

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

    public java.lang.Object[] getEmailValueList()
    {
        return this.emailValueList;
    }

    public void setEmailValueList(java.lang.Object[] emailValueList)
    {
        this.emailValueList = emailValueList;
    }

    public java.lang.Object[] getEmailLabelList()
    {
        return this.emailLabelList;
    }

    public void setEmailLabelList(java.lang.Object[] emailLabelList)
    {
        this.emailLabelList = emailLabelList;
    }

    public void setEmailBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setEmailBackingList requires non-null property arguments");
        }

        this.emailValueList = null;
        this.emailLabelList = null;

        if (items != null)
        {
            this.emailValueList = new java.lang.Object[items.size()];
            this.emailLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.emailValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.emailLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setEmailBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setComboIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setComboIdiomaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setZhMinutosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setZhMinutosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setFechaCortaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setFechaCortaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setComboZonaHBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setComboZonaHBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("AnotacionesFormDetalleAnotacionFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AnotacionesFormDetalleAnotacionFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.listadoAnotaciones = null;
        this.listadoAnotacionesValueList = new java.lang.Object[0];
        this.listadoAnotacionesLabelList = new java.lang.Object[0];
        this.comboIdioma = null;
        this.comboZonaH = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("minutos", this.minutos);
        builder.append("segundoP2", this.segundoP2);
        builder.append("botonPulsado", this.botonPulsado);
        builder.append("segundoP1", this.segundoP1);
        builder.append("descripcionFecha", this.descripcionFecha);
        builder.append("descripcion", this.descripcion);
        builder.append("meridianocero", this.meridianocero);
        builder.append("organizacion", this.organizacion);
        builder.append("listadoAnotaciones", this.listadoAnotaciones);
        builder.append("zhHora", this.zhHora);
        builder.append("nombre", this.nombre);
        builder.append("hora", this.hora);
        builder.append("tituloAnotacion", this.tituloAnotacion);
        builder.append("email", this.email);
        builder.append("comboIdioma", this.comboIdioma);
        builder.append("zhMinutos", this.zhMinutos);
        builder.append("fechaCorta", this.fechaCorta);
        builder.append("comboZonaH", this.comboZonaH);
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
        this.botonPulsado = null;
        this.botonPulsadoValueList = null;
        this.botonPulsadoLabelList = null;
        this.segundoP1 = null;
        this.segundoP1ValueList = null;
        this.segundoP1LabelList = null;
        this.descripcionFecha = null;
        this.descripcionFechaValueList = null;
        this.descripcionFechaLabelList = null;
        this.descripcion = null;
        this.descripcionValueList = null;
        this.descripcionLabelList = null;
        this.meridianocero = null;
        this.meridianoceroValueList = null;
        this.meridianoceroLabelList = null;
        this.organizacion = null;
        this.organizacionValueList = null;
        this.organizacionLabelList = null;
        this.listadoAnotaciones = null;
        this.listadoAnotacionesValueList = null;
        this.listadoAnotacionesLabelList = null;
        this.zhHora = null;
        this.zhHoraValueList = null;
        this.zhHoraLabelList = null;
        this.nombre = null;
        this.nombreValueList = null;
        this.nombreLabelList = null;
        this.hora = null;
        this.horaValueList = null;
        this.horaLabelList = null;
        this.tituloAnotacion = null;
        this.tituloAnotacionValueList = null;
        this.tituloAnotacionLabelList = null;
        this.email = null;
        this.emailValueList = null;
        this.emailLabelList = null;
        this.comboIdioma = null;
        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;
        this.zhMinutos = null;
        this.zhMinutosValueList = null;
        this.zhMinutosLabelList = null;
        this.fechaCorta = null;
        this.fechaCortaValueList = null;
        this.fechaCortaLabelList = null;
        this.comboZonaH = null;
        this.comboZonaHValueList = null;
        this.comboZonaHLabelList = null;
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
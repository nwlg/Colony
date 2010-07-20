// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion;

public class DetalleFormSubmitFormFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.GuardarAnotacionForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.EliminarDescripcionForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.AnadirDescripcionForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.EliminarDescripcionFechaForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.AnadirDescripcionFechaForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.ResetForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.CancelarForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.HayAnotacionesForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.HayAnotacionesGuardarForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.AccionSubmitForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.EsValidaAnotacionForm
{
    private java.lang.String formato;
    private java.lang.Object[] formatoValueList;
    private java.lang.Object[] formatoLabelList;
    private java.lang.String nombre;
    private java.lang.Object[] nombreValueList;
    private java.lang.Object[] nombreLabelList;
    private java.lang.String tituloAnotacion;
    private java.lang.Object[] tituloAnotacionValueList;
    private java.lang.Object[] tituloAnotacionLabelList;
    private java.lang.String comboIdioma;
    private java.lang.Object[] comboIdiomaValueList;
    private java.lang.Object[] comboIdiomaLabelList;
    private java.lang.String mes;
    private java.lang.Object[] mesValueList;
    private java.lang.Object[] mesLabelList;
    private java.lang.String zhMinutos;
    private java.lang.Object[] zhMinutosValueList;
    private java.lang.Object[] zhMinutosLabelList;
    private java.lang.String znHora;
    private java.lang.Object[] znHoraValueList;
    private java.lang.Object[] znHoraLabelList;
    private java.lang.String tminuto;
    private java.lang.Object[] tminutoValueList;
    private java.lang.Object[] tminutoLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;
    private java.lang.String botonPulsado;
    private java.lang.Object[] botonPulsadoValueList;
    private java.lang.Object[] botonPulsadoLabelList;
    private java.util.Collection descripcionFecha;
    private java.lang.Object[] descripcionFechaValueList;
    private java.lang.Object[] descripcionFechaLabelList;
    private java.lang.String tsegundoP1;
    private java.lang.Object[] tsegundoP1ValueList;
    private java.lang.Object[] tsegundoP1LabelList;
    private java.util.Collection descripcion;
    private java.lang.Object[] descripcionValueList;
    private java.lang.Object[] descripcionLabelList;
    private java.lang.String tsegundoP2;
    private java.lang.Object[] tsegundoP2ValueList;
    private java.lang.Object[] tsegundoP2LabelList;
    private java.lang.String dia;
    private java.lang.Object[] diaValueList;
    private java.lang.Object[] diaLabelList;
    private java.lang.String organizacion;
    private java.lang.Object[] organizacionValueList;
    private java.lang.Object[] organizacionLabelList;
    private java.lang.String accion;
    private java.lang.Object[] accionValueList;
    private java.lang.Object[] accionLabelList;
    private java.lang.String znMinutos;
    private java.lang.Object[] znMinutosValueList;
    private java.lang.Object[] znMinutosLabelList;
    private java.lang.String zhHora;
    private java.lang.Object[] zhHoraValueList;
    private java.lang.Object[] zhHoraLabelList;
    private java.lang.String thora;
    private java.lang.Object[] thoraValueList;
    private java.lang.Object[] thoraLabelList;
    private java.lang.String email;
    private java.lang.Object[] emailValueList;
    private java.lang.Object[] emailLabelList;
    private java.lang.String meridianoCero;
    private java.lang.Object[] meridianoCeroValueList;
    private java.lang.Object[] meridianoCeroLabelList;
    private java.lang.String offSet;
    private java.lang.Object[] offSetValueList;
    private java.lang.Object[] offSetLabelList;
    private java.lang.String fechaCorta;
    private java.lang.Object[] fechaCortaValueList;
    private java.lang.Object[] fechaCortaLabelList;
    private java.lang.String anyo;
    private java.lang.Object[] anyoValueList;
    private java.lang.Object[] anyoLabelList;
    private java.util.Collection mensajesError;
    private java.lang.Object[] mensajesErrorValueList;
    private java.lang.Object[] mensajesErrorLabelList;
    private java.lang.String comboZonaH;
    private java.lang.Object[] comboZonaHValueList;
    private java.lang.Object[] comboZonaHLabelList;

    public DetalleFormSubmitFormFormImpl()
    {
    }

    /**
     * Resets the given <code>formato</code>.
     */
    public void resetFormato()
    {
        this.formato = null;
    }

    public void setFormato(java.lang.String formato)
    {
        this.formato = formato;
    }

    /**
     * 
     */
    public java.lang.String getFormato()
    {
        return this.formato;
    }
    
    public java.lang.Object[] getFormatoBackingList()
    {
        java.lang.Object[] values = this.formatoValueList;
        java.lang.Object[] labels = this.formatoLabelList;

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

    public java.lang.Object[] getFormatoValueList()
    {
        return this.formatoValueList;
    }

    public void setFormatoValueList(java.lang.Object[] formatoValueList)
    {
        this.formatoValueList = formatoValueList;
    }

    public java.lang.Object[] getFormatoLabelList()
    {
        return this.formatoLabelList;
    }

    public void setFormatoLabelList(java.lang.Object[] formatoLabelList)
    {
        this.formatoLabelList = formatoLabelList;
    }

    public void setFormatoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setFormatoBackingList requires non-null property arguments");
        }

        this.formatoValueList = null;
        this.formatoLabelList = null;

        if (items != null)
        {
            this.formatoValueList = new java.lang.Object[items.size()];
            this.formatoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.formatoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.formatoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setFormatoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setNombreBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setNombreBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setTituloAnotacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setTituloAnotacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setComboIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setComboIdiomaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setMesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setMesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setZhMinutosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setZhMinutosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>znHora</code>.
     */
    public void resetZnHora()
    {
        this.znHora = null;
    }

    public void setZnHora(java.lang.String znHora)
    {
        this.znHora = znHora;
    }

    /**
     * 
     */
    public java.lang.String getZnHora()
    {
        return this.znHora;
    }
    
    public java.lang.Object[] getZnHoraBackingList()
    {
        java.lang.Object[] values = this.znHoraValueList;
        java.lang.Object[] labels = this.znHoraLabelList;

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

    public java.lang.Object[] getZnHoraValueList()
    {
        return this.znHoraValueList;
    }

    public void setZnHoraValueList(java.lang.Object[] znHoraValueList)
    {
        this.znHoraValueList = znHoraValueList;
    }

    public java.lang.Object[] getZnHoraLabelList()
    {
        return this.znHoraLabelList;
    }

    public void setZnHoraLabelList(java.lang.Object[] znHoraLabelList)
    {
        this.znHoraLabelList = znHoraLabelList;
    }

    public void setZnHoraBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setZnHoraBackingList requires non-null property arguments");
        }

        this.znHoraValueList = null;
        this.znHoraLabelList = null;

        if (items != null)
        {
            this.znHoraValueList = new java.lang.Object[items.size()];
            this.znHoraLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.znHoraValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.znHoraLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setZnHoraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tminuto</code>.
     */
    public void resetTminuto()
    {
        this.tminuto = null;
    }

    public void setTminuto(java.lang.String tminuto)
    {
        this.tminuto = tminuto;
    }

    /**
     * 
     */
    public java.lang.String getTminuto()
    {
        return this.tminuto;
    }
    
    public java.lang.Object[] getTminutoBackingList()
    {
        java.lang.Object[] values = this.tminutoValueList;
        java.lang.Object[] labels = this.tminutoLabelList;

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

    public java.lang.Object[] getTminutoValueList()
    {
        return this.tminutoValueList;
    }

    public void setTminutoValueList(java.lang.Object[] tminutoValueList)
    {
        this.tminutoValueList = tminutoValueList;
    }

    public java.lang.Object[] getTminutoLabelList()
    {
        return this.tminutoLabelList;
    }

    public void setTminutoLabelList(java.lang.Object[] tminutoLabelList)
    {
        this.tminutoLabelList = tminutoLabelList;
    }

    public void setTminutoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setTminutoBackingList requires non-null property arguments");
        }

        this.tminutoValueList = null;
        this.tminutoLabelList = null;

        if (items != null)
        {
            this.tminutoValueList = new java.lang.Object[items.size()];
            this.tminutoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tminutoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tminutoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setTminutoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setBotonPulsadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setBotonPulsadoBackingList encountered an exception", ex);
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleFormSubmitFormFormImpl#getDescripcionFecha
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setDescripcionFechaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setDescripcionFechaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tsegundoP1</code>.
     */
    public void resetTsegundoP1()
    {
        this.tsegundoP1 = null;
    }

    public void setTsegundoP1(java.lang.String tsegundoP1)
    {
        this.tsegundoP1 = tsegundoP1;
    }

    /**
     * 
     */
    public java.lang.String getTsegundoP1()
    {
        return this.tsegundoP1;
    }
    
    public java.lang.Object[] getTsegundoP1BackingList()
    {
        java.lang.Object[] values = this.tsegundoP1ValueList;
        java.lang.Object[] labels = this.tsegundoP1LabelList;

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

    public java.lang.Object[] getTsegundoP1ValueList()
    {
        return this.tsegundoP1ValueList;
    }

    public void setTsegundoP1ValueList(java.lang.Object[] tsegundoP1ValueList)
    {
        this.tsegundoP1ValueList = tsegundoP1ValueList;
    }

    public java.lang.Object[] getTsegundoP1LabelList()
    {
        return this.tsegundoP1LabelList;
    }

    public void setTsegundoP1LabelList(java.lang.Object[] tsegundoP1LabelList)
    {
        this.tsegundoP1LabelList = tsegundoP1LabelList;
    }

    public void setTsegundoP1BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setTsegundoP1BackingList requires non-null property arguments");
        }

        this.tsegundoP1ValueList = null;
        this.tsegundoP1LabelList = null;

        if (items != null)
        {
            this.tsegundoP1ValueList = new java.lang.Object[items.size()];
            this.tsegundoP1LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tsegundoP1ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tsegundoP1LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setTsegundoP1BackingList encountered an exception", ex);
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleFormSubmitFormFormImpl#getDescripcion
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setDescripcionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setDescripcionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tsegundoP2</code>.
     */
    public void resetTsegundoP2()
    {
        this.tsegundoP2 = null;
    }

    public void setTsegundoP2(java.lang.String tsegundoP2)
    {
        this.tsegundoP2 = tsegundoP2;
    }

    /**
     * 
     */
    public java.lang.String getTsegundoP2()
    {
        return this.tsegundoP2;
    }
    
    public java.lang.Object[] getTsegundoP2BackingList()
    {
        java.lang.Object[] values = this.tsegundoP2ValueList;
        java.lang.Object[] labels = this.tsegundoP2LabelList;

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

    public java.lang.Object[] getTsegundoP2ValueList()
    {
        return this.tsegundoP2ValueList;
    }

    public void setTsegundoP2ValueList(java.lang.Object[] tsegundoP2ValueList)
    {
        this.tsegundoP2ValueList = tsegundoP2ValueList;
    }

    public java.lang.Object[] getTsegundoP2LabelList()
    {
        return this.tsegundoP2LabelList;
    }

    public void setTsegundoP2LabelList(java.lang.Object[] tsegundoP2LabelList)
    {
        this.tsegundoP2LabelList = tsegundoP2LabelList;
    }

    public void setTsegundoP2BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setTsegundoP2BackingList requires non-null property arguments");
        }

        this.tsegundoP2ValueList = null;
        this.tsegundoP2LabelList = null;

        if (items != null)
        {
            this.tsegundoP2ValueList = new java.lang.Object[items.size()];
            this.tsegundoP2LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tsegundoP2ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tsegundoP2LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setTsegundoP2BackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setDiaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setDiaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setOrganizacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setOrganizacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setAccionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setAccionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>znMinutos</code>.
     */
    public void resetZnMinutos()
    {
        this.znMinutos = null;
    }

    public void setZnMinutos(java.lang.String znMinutos)
    {
        this.znMinutos = znMinutos;
    }

    /**
     * 
     */
    public java.lang.String getZnMinutos()
    {
        return this.znMinutos;
    }
    
    public java.lang.Object[] getZnMinutosBackingList()
    {
        java.lang.Object[] values = this.znMinutosValueList;
        java.lang.Object[] labels = this.znMinutosLabelList;

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

    public java.lang.Object[] getZnMinutosValueList()
    {
        return this.znMinutosValueList;
    }

    public void setZnMinutosValueList(java.lang.Object[] znMinutosValueList)
    {
        this.znMinutosValueList = znMinutosValueList;
    }

    public java.lang.Object[] getZnMinutosLabelList()
    {
        return this.znMinutosLabelList;
    }

    public void setZnMinutosLabelList(java.lang.Object[] znMinutosLabelList)
    {
        this.znMinutosLabelList = znMinutosLabelList;
    }

    public void setZnMinutosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setZnMinutosBackingList requires non-null property arguments");
        }

        this.znMinutosValueList = null;
        this.znMinutosLabelList = null;

        if (items != null)
        {
            this.znMinutosValueList = new java.lang.Object[items.size()];
            this.znMinutosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.znMinutosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.znMinutosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setZnMinutosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setZhHoraBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setZhHoraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>thora</code>.
     */
    public void resetThora()
    {
        this.thora = null;
    }

    public void setThora(java.lang.String thora)
    {
        this.thora = thora;
    }

    /**
     * 
     */
    public java.lang.String getThora()
    {
        return this.thora;
    }
    
    public java.lang.Object[] getThoraBackingList()
    {
        java.lang.Object[] values = this.thoraValueList;
        java.lang.Object[] labels = this.thoraLabelList;

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

    public java.lang.Object[] getThoraValueList()
    {
        return this.thoraValueList;
    }

    public void setThoraValueList(java.lang.Object[] thoraValueList)
    {
        this.thoraValueList = thoraValueList;
    }

    public java.lang.Object[] getThoraLabelList()
    {
        return this.thoraLabelList;
    }

    public void setThoraLabelList(java.lang.Object[] thoraLabelList)
    {
        this.thoraLabelList = thoraLabelList;
    }

    public void setThoraBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setThoraBackingList requires non-null property arguments");
        }

        this.thoraValueList = null;
        this.thoraLabelList = null;

        if (items != null)
        {
            this.thoraValueList = new java.lang.Object[items.size()];
            this.thoraLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.thoraValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.thoraLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setThoraBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setEmailBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setEmailBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>meridianoCero</code>.
     */
    public void resetMeridianoCero()
    {
        this.meridianoCero = null;
    }

    public void setMeridianoCero(java.lang.String meridianoCero)
    {
        this.meridianoCero = meridianoCero;
    }

    /**
     * 
     */
    public java.lang.String getMeridianoCero()
    {
        return this.meridianoCero;
    }
    
    public java.lang.Object[] getMeridianoCeroBackingList()
    {
        java.lang.Object[] values = this.meridianoCeroValueList;
        java.lang.Object[] labels = this.meridianoCeroLabelList;

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

    public java.lang.Object[] getMeridianoCeroValueList()
    {
        return this.meridianoCeroValueList;
    }

    public void setMeridianoCeroValueList(java.lang.Object[] meridianoCeroValueList)
    {
        this.meridianoCeroValueList = meridianoCeroValueList;
    }

    public java.lang.Object[] getMeridianoCeroLabelList()
    {
        return this.meridianoCeroLabelList;
    }

    public void setMeridianoCeroLabelList(java.lang.Object[] meridianoCeroLabelList)
    {
        this.meridianoCeroLabelList = meridianoCeroLabelList;
    }

    public void setMeridianoCeroBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setMeridianoCeroBackingList requires non-null property arguments");
        }

        this.meridianoCeroValueList = null;
        this.meridianoCeroLabelList = null;

        if (items != null)
        {
            this.meridianoCeroValueList = new java.lang.Object[items.size()];
            this.meridianoCeroLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.meridianoCeroValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.meridianoCeroLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setMeridianoCeroBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>offSet</code>.
     */
    public void resetOffSet()
    {
        this.offSet = null;
    }

    public void setOffSet(java.lang.String offSet)
    {
        this.offSet = offSet;
    }

    /**
     * 
     */
    public java.lang.String getOffSet()
    {
        return this.offSet;
    }
    
    public java.lang.Object[] getOffSetBackingList()
    {
        java.lang.Object[] values = this.offSetValueList;
        java.lang.Object[] labels = this.offSetLabelList;

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

    public java.lang.Object[] getOffSetValueList()
    {
        return this.offSetValueList;
    }

    public void setOffSetValueList(java.lang.Object[] offSetValueList)
    {
        this.offSetValueList = offSetValueList;
    }

    public java.lang.Object[] getOffSetLabelList()
    {
        return this.offSetLabelList;
    }

    public void setOffSetLabelList(java.lang.Object[] offSetLabelList)
    {
        this.offSetLabelList = offSetLabelList;
    }

    public void setOffSetBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setOffSetBackingList requires non-null property arguments");
        }

        this.offSetValueList = null;
        this.offSetLabelList = null;

        if (items != null)
        {
            this.offSetValueList = new java.lang.Object[items.size()];
            this.offSetLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.offSetValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.offSetLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setOffSetBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setFechaCortaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setFechaCortaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setAnyoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setAnyoBackingList encountered an exception", ex);
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.detalleAnotacion.DetalleFormSubmitFormFormImpl#getMensajesError
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setMensajesErrorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setMensajesErrorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleFormSubmitFormFormImpl.setComboZonaHBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleFormSubmitFormFormImpl.setComboZonaHBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.comboIdioma = null;
        this.descripcionFecha = null;
        this.descripcionFechaValueList = new java.lang.Object[0];
        this.descripcionFechaLabelList = new java.lang.Object[0];
        this.descripcion = null;
        this.descripcionValueList = new java.lang.Object[0];
        this.descripcionLabelList = new java.lang.Object[0];
        this.mensajesError = null;
        this.mensajesErrorValueList = new java.lang.Object[0];
        this.mensajesErrorLabelList = new java.lang.Object[0];
        this.comboZonaH = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("formato", this.formato);
        builder.append("nombre", this.nombre);
        builder.append("tituloAnotacion", this.tituloAnotacion);
        builder.append("comboIdioma", this.comboIdioma);
        builder.append("mes", this.mes);
        builder.append("zhMinutos", this.zhMinutos);
        builder.append("znHora", this.znHora);
        builder.append("tminuto", this.tminuto);
        builder.append("identificadorOde", this.identificadorOde);
        builder.append("botonPulsado", this.botonPulsado);
        builder.append("descripcionFecha", this.descripcionFecha);
        builder.append("tsegundoP1", this.tsegundoP1);
        builder.append("descripcion", this.descripcion);
        builder.append("tsegundoP2", this.tsegundoP2);
        builder.append("dia", this.dia);
        builder.append("organizacion", this.organizacion);
        builder.append("accion", this.accion);
        builder.append("znMinutos", this.znMinutos);
        builder.append("zhHora", this.zhHora);
        builder.append("thora", this.thora);
        builder.append("email", this.email);
        builder.append("meridianoCero", this.meridianoCero);
        builder.append("offSet", this.offSet);
        builder.append("fechaCorta", this.fechaCorta);
        builder.append("anyo", this.anyo);
        builder.append("mensajesError", this.mensajesError);
        builder.append("comboZonaH", this.comboZonaH);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.formato = null;
        this.formatoValueList = null;
        this.formatoLabelList = null;
        this.nombre = null;
        this.nombreValueList = null;
        this.nombreLabelList = null;
        this.tituloAnotacion = null;
        this.tituloAnotacionValueList = null;
        this.tituloAnotacionLabelList = null;
        this.comboIdioma = null;
        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;
        this.mes = null;
        this.mesValueList = null;
        this.mesLabelList = null;
        this.zhMinutos = null;
        this.zhMinutosValueList = null;
        this.zhMinutosLabelList = null;
        this.znHora = null;
        this.znHoraValueList = null;
        this.znHoraLabelList = null;
        this.tminuto = null;
        this.tminutoValueList = null;
        this.tminutoLabelList = null;
        this.identificadorOde = null;
        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;
        this.botonPulsado = null;
        this.botonPulsadoValueList = null;
        this.botonPulsadoLabelList = null;
        this.descripcionFecha = null;
        this.descripcionFechaValueList = null;
        this.descripcionFechaLabelList = null;
        this.tsegundoP1 = null;
        this.tsegundoP1ValueList = null;
        this.tsegundoP1LabelList = null;
        this.descripcion = null;
        this.descripcionValueList = null;
        this.descripcionLabelList = null;
        this.tsegundoP2 = null;
        this.tsegundoP2ValueList = null;
        this.tsegundoP2LabelList = null;
        this.dia = null;
        this.diaValueList = null;
        this.diaLabelList = null;
        this.organizacion = null;
        this.organizacionValueList = null;
        this.organizacionLabelList = null;
        this.accion = null;
        this.accionValueList = null;
        this.accionLabelList = null;
        this.znMinutos = null;
        this.znMinutosValueList = null;
        this.znMinutosLabelList = null;
        this.zhHora = null;
        this.zhHoraValueList = null;
        this.zhHoraLabelList = null;
        this.thora = null;
        this.thoraValueList = null;
        this.thoraLabelList = null;
        this.email = null;
        this.emailValueList = null;
        this.emailLabelList = null;
        this.meridianoCero = null;
        this.meridianoCeroValueList = null;
        this.meridianoCeroLabelList = null;
        this.offSet = null;
        this.offSetValueList = null;
        this.offSetLabelList = null;
        this.fechaCorta = null;
        this.fechaCortaValueList = null;
        this.fechaCortaLabelList = null;
        this.anyo = null;
        this.anyoValueList = null;
        this.anyoLabelList = null;
        this.mensajesError = null;
        this.mensajesErrorValueList = null;
        this.mensajesErrorLabelList = null;
        this.comboZonaH = null;
        this.comboZonaHValueList = null;
        this.comboZonaHLabelList = null;
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
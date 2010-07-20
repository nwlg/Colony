// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

public class DerechosFormVuelveDeDerechosFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosAvForm
{
    private java.lang.String tipoAcceso;
    private java.lang.Object[] tipoAccesoValueList;
    private java.lang.Object[] tipoAccesoLabelList;
    private java.lang.String comboIdioma;
    private java.lang.Object[] comboIdiomaValueList;
    private java.lang.Object[] comboIdiomaLabelList;
    private java.lang.String copyRestricciones;
    private java.lang.Object[] copyRestriccionesValueList;
    private java.lang.Object[] copyRestriccionesLabelList;
    private java.lang.String identificador;
    private java.lang.Object[] identificadorValueList;
    private java.lang.Object[] identificadorLabelList;
    private java.lang.String coste;
    private java.lang.Object[] costeValueList;
    private java.lang.Object[] costeLabelList;
    private java.util.Collection datos;
    private java.lang.Object[] datosValueList;
    private java.lang.Object[] datosLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;
    private java.lang.String returnURL;
    private java.lang.Object[] returnURLValueList;
    private java.lang.Object[] returnURLLabelList;

    public DerechosFormVuelveDeDerechosFormImpl()
    {
    }

    /**
     * Resets the given <code>tipoAcceso</code>.
     */
    public void resetTipoAcceso()
    {
        this.tipoAcceso = null;
    }

    public void setTipoAcceso(java.lang.String tipoAcceso)
    {
        this.tipoAcceso = tipoAcceso;
    }

    /**
     * 
     */
    public java.lang.String getTipoAcceso()
    {
        return this.tipoAcceso;
    }
    
    public java.lang.Object[] getTipoAccesoBackingList()
    {
        java.lang.Object[] values = this.tipoAccesoValueList;
        java.lang.Object[] labels = this.tipoAccesoLabelList;

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

    public java.lang.Object[] getTipoAccesoValueList()
    {
        return this.tipoAccesoValueList;
    }

    public void setTipoAccesoValueList(java.lang.Object[] tipoAccesoValueList)
    {
        this.tipoAccesoValueList = tipoAccesoValueList;
    }

    public java.lang.Object[] getTipoAccesoLabelList()
    {
        return this.tipoAccesoLabelList;
    }

    public void setTipoAccesoLabelList(java.lang.Object[] tipoAccesoLabelList)
    {
        this.tipoAccesoLabelList = tipoAccesoLabelList;
    }

    public void setTipoAccesoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DerechosFormVuelveDeDerechosFormImpl.setTipoAccesoBackingList requires non-null property arguments");
        }

        this.tipoAccesoValueList = null;
        this.tipoAccesoLabelList = null;

        if (items != null)
        {
            this.tipoAccesoValueList = new java.lang.Object[items.size()];
            this.tipoAccesoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoAccesoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoAccesoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DerechosFormVuelveDeDerechosFormImpl.setTipoAccesoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DerechosFormVuelveDeDerechosFormImpl.setComboIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DerechosFormVuelveDeDerechosFormImpl.setComboIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>copyRestricciones</code>.
     */
    public void resetCopyRestricciones()
    {
        this.copyRestricciones = null;
    }

    public void setCopyRestricciones(java.lang.String copyRestricciones)
    {
        this.copyRestricciones = copyRestricciones;
    }

    /**
     * 
     */
    public java.lang.String getCopyRestricciones()
    {
        return this.copyRestricciones;
    }
    
    public java.lang.Object[] getCopyRestriccionesBackingList()
    {
        java.lang.Object[] values = this.copyRestriccionesValueList;
        java.lang.Object[] labels = this.copyRestriccionesLabelList;

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

    public java.lang.Object[] getCopyRestriccionesValueList()
    {
        return this.copyRestriccionesValueList;
    }

    public void setCopyRestriccionesValueList(java.lang.Object[] copyRestriccionesValueList)
    {
        this.copyRestriccionesValueList = copyRestriccionesValueList;
    }

    public java.lang.Object[] getCopyRestriccionesLabelList()
    {
        return this.copyRestriccionesLabelList;
    }

    public void setCopyRestriccionesLabelList(java.lang.Object[] copyRestriccionesLabelList)
    {
        this.copyRestriccionesLabelList = copyRestriccionesLabelList;
    }

    public void setCopyRestriccionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DerechosFormVuelveDeDerechosFormImpl.setCopyRestriccionesBackingList requires non-null property arguments");
        }

        this.copyRestriccionesValueList = null;
        this.copyRestriccionesLabelList = null;

        if (items != null)
        {
            this.copyRestriccionesValueList = new java.lang.Object[items.size()];
            this.copyRestriccionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.copyRestriccionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.copyRestriccionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DerechosFormVuelveDeDerechosFormImpl.setCopyRestriccionesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificador</code>.
     */
    public void resetIdentificador()
    {
        this.identificador = null;
    }

    public void setIdentificador(java.lang.String identificador)
    {
        this.identificador = identificador;
    }

    /**
     * 
     */
    public java.lang.String getIdentificador()
    {
        return this.identificador;
    }
    
    public java.lang.Object[] getIdentificadorBackingList()
    {
        java.lang.Object[] values = this.identificadorValueList;
        java.lang.Object[] labels = this.identificadorLabelList;

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

    public java.lang.Object[] getIdentificadorValueList()
    {
        return this.identificadorValueList;
    }

    public void setIdentificadorValueList(java.lang.Object[] identificadorValueList)
    {
        this.identificadorValueList = identificadorValueList;
    }

    public java.lang.Object[] getIdentificadorLabelList()
    {
        return this.identificadorLabelList;
    }

    public void setIdentificadorLabelList(java.lang.Object[] identificadorLabelList)
    {
        this.identificadorLabelList = identificadorLabelList;
    }

    public void setIdentificadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DerechosFormVuelveDeDerechosFormImpl.setIdentificadorBackingList requires non-null property arguments");
        }

        this.identificadorValueList = null;
        this.identificadorLabelList = null;

        if (items != null)
        {
            this.identificadorValueList = new java.lang.Object[items.size()];
            this.identificadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DerechosFormVuelveDeDerechosFormImpl.setIdentificadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>coste</code>.
     */
    public void resetCoste()
    {
        this.coste = null;
    }

    public void setCoste(java.lang.String coste)
    {
        this.coste = coste;
    }

    /**
     * 
     */
    public java.lang.String getCoste()
    {
        return this.coste;
    }
    
    public java.lang.Object[] getCosteBackingList()
    {
        java.lang.Object[] values = this.costeValueList;
        java.lang.Object[] labels = this.costeLabelList;

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

    public java.lang.Object[] getCosteValueList()
    {
        return this.costeValueList;
    }

    public void setCosteValueList(java.lang.Object[] costeValueList)
    {
        this.costeValueList = costeValueList;
    }

    public java.lang.Object[] getCosteLabelList()
    {
        return this.costeLabelList;
    }

    public void setCosteLabelList(java.lang.Object[] costeLabelList)
    {
        this.costeLabelList = costeLabelList;
    }

    public void setCosteBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DerechosFormVuelveDeDerechosFormImpl.setCosteBackingList requires non-null property arguments");
        }

        this.costeValueList = null;
        this.costeLabelList = null;

        if (items != null)
        {
            this.costeValueList = new java.lang.Object[items.size()];
            this.costeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.costeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.costeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DerechosFormVuelveDeDerechosFormImpl.setCosteBackingList encountered an exception", ex);
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
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.DerechosFormVuelveDeDerechosFormImpl#getDatos
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
            throw new IllegalArgumentException("DerechosFormVuelveDeDerechosFormImpl.setDatosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DerechosFormVuelveDeDerechosFormImpl.setDatosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DerechosFormVuelveDeDerechosFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DerechosFormVuelveDeDerechosFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DerechosFormVuelveDeDerechosFormImpl.setReturnURLBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DerechosFormVuelveDeDerechosFormImpl.setReturnURLBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.tipoAcceso = null;
        this.comboIdioma = null;
        this.copyRestricciones = null;
        this.coste = null;
        this.datos = null;
        this.datosValueList = new java.lang.Object[0];
        this.datosLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("tipoAcceso", this.tipoAcceso);
        builder.append("comboIdioma", this.comboIdioma);
        builder.append("copyRestricciones", this.copyRestricciones);
        builder.append("identificador", this.identificador);
        builder.append("coste", this.coste);
        builder.append("datos", this.datos);
        builder.append("identificadorOde", this.identificadorOde);
        builder.append("returnURL", this.returnURL);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.tipoAcceso = null;
        this.tipoAccesoValueList = null;
        this.tipoAccesoLabelList = null;
        this.comboIdioma = null;
        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;
        this.copyRestricciones = null;
        this.copyRestriccionesValueList = null;
        this.copyRestriccionesLabelList = null;
        this.identificador = null;
        this.identificadorValueList = null;
        this.identificadorLabelList = null;
        this.coste = null;
        this.costeValueList = null;
        this.costeLabelList = null;
        this.datos = null;
        this.datosValueList = null;
        this.datosLabelList = null;
        this.identificadorOde = null;
        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;
        this.returnURL = null;
        this.returnURLValueList = null;
        this.returnURLLabelList = null;
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
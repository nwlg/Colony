// license-header java merge-point
package es.pode.administracion.presentacion.informes.crearInforme;

public class ListadoFechasAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.informes.crearInforme.ComprobarFinSesionFechasForm
        , es.pode.administracion.presentacion.informes.crearInforme.CargarInformeFechasForm
{
    private java.lang.String anioHasta;
    private java.lang.Object[] anioHastaValueList;
    private java.lang.Object[] anioHastaLabelList;
    private java.lang.String anioDesde;
    private java.lang.Object[] anioDesdeValueList;
    private java.lang.Object[] anioDesdeLabelList;
    private java.lang.String informe;
    private java.lang.Object[] informeValueList;
    private java.lang.Object[] informeLabelList;
    private java.lang.String mesHasta;
    private java.lang.Object[] mesHastaValueList;
    private java.lang.Object[] mesHastaLabelList;
    private java.lang.String formato;
    private java.lang.Object[] formatoValueList;
    private java.lang.Object[] formatoLabelList;
    private java.lang.String diaHasta;
    private java.lang.Object[] diaHastaValueList;
    private java.lang.Object[] diaHastaLabelList;
    private java.lang.String mesDesde;
    private java.lang.Object[] mesDesdeValueList;
    private java.lang.Object[] mesDesdeLabelList;
    private java.lang.String diaDesde;
    private java.lang.Object[] diaDesdeValueList;
    private java.lang.Object[] diaDesdeLabelList;

    public ListadoFechasAceptarFormImpl()
    {
    }

    /**
     * Resets the given <code>anioHasta</code>.
     */
    public void resetAnioHasta()
    {
        this.anioHasta = null;
    }

    public void setAnioHasta(java.lang.String anioHasta)
    {
        this.anioHasta = anioHasta;
    }

    /**
     * 
     */
    public java.lang.String getAnioHasta()
    {
        return this.anioHasta;
    }
    
    public java.lang.Object[] getAnioHastaBackingList()
    {
        java.lang.Object[] values = this.anioHastaValueList;
        java.lang.Object[] labels = this.anioHastaLabelList;

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

    public java.lang.Object[] getAnioHastaValueList()
    {
        return this.anioHastaValueList;
    }

    public void setAnioHastaValueList(java.lang.Object[] anioHastaValueList)
    {
        this.anioHastaValueList = anioHastaValueList;
    }

    public java.lang.Object[] getAnioHastaLabelList()
    {
        return this.anioHastaLabelList;
    }

    public void setAnioHastaLabelList(java.lang.Object[] anioHastaLabelList)
    {
        this.anioHastaLabelList = anioHastaLabelList;
    }

    public void setAnioHastaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoFechasAceptarFormImpl.setAnioHastaBackingList requires non-null property arguments");
        }

        this.anioHastaValueList = null;
        this.anioHastaLabelList = null;

        if (items != null)
        {
            this.anioHastaValueList = new java.lang.Object[items.size()];
            this.anioHastaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.anioHastaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.anioHastaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoFechasAceptarFormImpl.setAnioHastaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>anioDesde</code>.
     */
    public void resetAnioDesde()
    {
        this.anioDesde = null;
    }

    public void setAnioDesde(java.lang.String anioDesde)
    {
        this.anioDesde = anioDesde;
    }

    /**
     * 
     */
    public java.lang.String getAnioDesde()
    {
        return this.anioDesde;
    }
    
    public java.lang.Object[] getAnioDesdeBackingList()
    {
        java.lang.Object[] values = this.anioDesdeValueList;
        java.lang.Object[] labels = this.anioDesdeLabelList;

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

    public java.lang.Object[] getAnioDesdeValueList()
    {
        return this.anioDesdeValueList;
    }

    public void setAnioDesdeValueList(java.lang.Object[] anioDesdeValueList)
    {
        this.anioDesdeValueList = anioDesdeValueList;
    }

    public java.lang.Object[] getAnioDesdeLabelList()
    {
        return this.anioDesdeLabelList;
    }

    public void setAnioDesdeLabelList(java.lang.Object[] anioDesdeLabelList)
    {
        this.anioDesdeLabelList = anioDesdeLabelList;
    }

    public void setAnioDesdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoFechasAceptarFormImpl.setAnioDesdeBackingList requires non-null property arguments");
        }

        this.anioDesdeValueList = null;
        this.anioDesdeLabelList = null;

        if (items != null)
        {
            this.anioDesdeValueList = new java.lang.Object[items.size()];
            this.anioDesdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.anioDesdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.anioDesdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoFechasAceptarFormImpl.setAnioDesdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>informe</code>.
     */
    public void resetInforme()
    {
        this.informe = null;
    }

    public void setInforme(java.lang.String informe)
    {
        this.informe = informe;
    }

    /**
     * 
     */
    public java.lang.String getInforme()
    {
        return this.informe;
    }
    
    public java.lang.Object[] getInformeBackingList()
    {
        java.lang.Object[] values = this.informeValueList;
        java.lang.Object[] labels = this.informeLabelList;

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

    public java.lang.Object[] getInformeValueList()
    {
        return this.informeValueList;
    }

    public void setInformeValueList(java.lang.Object[] informeValueList)
    {
        this.informeValueList = informeValueList;
    }

    public java.lang.Object[] getInformeLabelList()
    {
        return this.informeLabelList;
    }

    public void setInformeLabelList(java.lang.Object[] informeLabelList)
    {
        this.informeLabelList = informeLabelList;
    }

    public void setInformeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoFechasAceptarFormImpl.setInformeBackingList requires non-null property arguments");
        }

        this.informeValueList = null;
        this.informeLabelList = null;

        if (items != null)
        {
            this.informeValueList = new java.lang.Object[items.size()];
            this.informeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.informeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.informeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoFechasAceptarFormImpl.setInformeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>mesHasta</code>.
     */
    public void resetMesHasta()
    {
        this.mesHasta = null;
    }

    public void setMesHasta(java.lang.String mesHasta)
    {
        this.mesHasta = mesHasta;
    }

    /**
     * 
     */
    public java.lang.String getMesHasta()
    {
        return this.mesHasta;
    }
    
    public java.lang.Object[] getMesHastaBackingList()
    {
        java.lang.Object[] values = this.mesHastaValueList;
        java.lang.Object[] labels = this.mesHastaLabelList;

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

    public java.lang.Object[] getMesHastaValueList()
    {
        return this.mesHastaValueList;
    }

    public void setMesHastaValueList(java.lang.Object[] mesHastaValueList)
    {
        this.mesHastaValueList = mesHastaValueList;
    }

    public java.lang.Object[] getMesHastaLabelList()
    {
        return this.mesHastaLabelList;
    }

    public void setMesHastaLabelList(java.lang.Object[] mesHastaLabelList)
    {
        this.mesHastaLabelList = mesHastaLabelList;
    }

    public void setMesHastaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoFechasAceptarFormImpl.setMesHastaBackingList requires non-null property arguments");
        }

        this.mesHastaValueList = null;
        this.mesHastaLabelList = null;

        if (items != null)
        {
            this.mesHastaValueList = new java.lang.Object[items.size()];
            this.mesHastaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mesHastaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mesHastaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoFechasAceptarFormImpl.setMesHastaBackingList encountered an exception", ex);
            }
        }
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
            throw new IllegalArgumentException("ListadoFechasAceptarFormImpl.setFormatoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoFechasAceptarFormImpl.setFormatoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>diaHasta</code>.
     */
    public void resetDiaHasta()
    {
        this.diaHasta = null;
    }

    public void setDiaHasta(java.lang.String diaHasta)
    {
        this.diaHasta = diaHasta;
    }

    /**
     * 
     */
    public java.lang.String getDiaHasta()
    {
        return this.diaHasta;
    }
    
    public java.lang.Object[] getDiaHastaBackingList()
    {
        java.lang.Object[] values = this.diaHastaValueList;
        java.lang.Object[] labels = this.diaHastaLabelList;

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

    public java.lang.Object[] getDiaHastaValueList()
    {
        return this.diaHastaValueList;
    }

    public void setDiaHastaValueList(java.lang.Object[] diaHastaValueList)
    {
        this.diaHastaValueList = diaHastaValueList;
    }

    public java.lang.Object[] getDiaHastaLabelList()
    {
        return this.diaHastaLabelList;
    }

    public void setDiaHastaLabelList(java.lang.Object[] diaHastaLabelList)
    {
        this.diaHastaLabelList = diaHastaLabelList;
    }

    public void setDiaHastaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoFechasAceptarFormImpl.setDiaHastaBackingList requires non-null property arguments");
        }

        this.diaHastaValueList = null;
        this.diaHastaLabelList = null;

        if (items != null)
        {
            this.diaHastaValueList = new java.lang.Object[items.size()];
            this.diaHastaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.diaHastaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.diaHastaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoFechasAceptarFormImpl.setDiaHastaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>mesDesde</code>.
     */
    public void resetMesDesde()
    {
        this.mesDesde = null;
    }

    public void setMesDesde(java.lang.String mesDesde)
    {
        this.mesDesde = mesDesde;
    }

    /**
     * 
     */
    public java.lang.String getMesDesde()
    {
        return this.mesDesde;
    }
    
    public java.lang.Object[] getMesDesdeBackingList()
    {
        java.lang.Object[] values = this.mesDesdeValueList;
        java.lang.Object[] labels = this.mesDesdeLabelList;

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

    public java.lang.Object[] getMesDesdeValueList()
    {
        return this.mesDesdeValueList;
    }

    public void setMesDesdeValueList(java.lang.Object[] mesDesdeValueList)
    {
        this.mesDesdeValueList = mesDesdeValueList;
    }

    public java.lang.Object[] getMesDesdeLabelList()
    {
        return this.mesDesdeLabelList;
    }

    public void setMesDesdeLabelList(java.lang.Object[] mesDesdeLabelList)
    {
        this.mesDesdeLabelList = mesDesdeLabelList;
    }

    public void setMesDesdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoFechasAceptarFormImpl.setMesDesdeBackingList requires non-null property arguments");
        }

        this.mesDesdeValueList = null;
        this.mesDesdeLabelList = null;

        if (items != null)
        {
            this.mesDesdeValueList = new java.lang.Object[items.size()];
            this.mesDesdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mesDesdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mesDesdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoFechasAceptarFormImpl.setMesDesdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>diaDesde</code>.
     */
    public void resetDiaDesde()
    {
        this.diaDesde = null;
    }

    public void setDiaDesde(java.lang.String diaDesde)
    {
        this.diaDesde = diaDesde;
    }

    /**
     * 
     */
    public java.lang.String getDiaDesde()
    {
        return this.diaDesde;
    }
    
    public java.lang.Object[] getDiaDesdeBackingList()
    {
        java.lang.Object[] values = this.diaDesdeValueList;
        java.lang.Object[] labels = this.diaDesdeLabelList;

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

    public java.lang.Object[] getDiaDesdeValueList()
    {
        return this.diaDesdeValueList;
    }

    public void setDiaDesdeValueList(java.lang.Object[] diaDesdeValueList)
    {
        this.diaDesdeValueList = diaDesdeValueList;
    }

    public java.lang.Object[] getDiaDesdeLabelList()
    {
        return this.diaDesdeLabelList;
    }

    public void setDiaDesdeLabelList(java.lang.Object[] diaDesdeLabelList)
    {
        this.diaDesdeLabelList = diaDesdeLabelList;
    }

    public void setDiaDesdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoFechasAceptarFormImpl.setDiaDesdeBackingList requires non-null property arguments");
        }

        this.diaDesdeValueList = null;
        this.diaDesdeLabelList = null;

        if (items != null)
        {
            this.diaDesdeValueList = new java.lang.Object[items.size()];
            this.diaDesdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.diaDesdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.diaDesdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoFechasAceptarFormImpl.setDiaDesdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("anioHasta", this.anioHasta);
        builder.append("anioDesde", this.anioDesde);
        builder.append("informe", this.informe);
        builder.append("mesHasta", this.mesHasta);
        builder.append("formato", this.formato);
        builder.append("diaHasta", this.diaHasta);
        builder.append("mesDesde", this.mesDesde);
        builder.append("diaDesde", this.diaDesde);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.anioHasta = null;
        this.anioHastaValueList = null;
        this.anioHastaLabelList = null;
        this.anioDesde = null;
        this.anioDesdeValueList = null;
        this.anioDesdeLabelList = null;
        this.informe = null;
        this.informeValueList = null;
        this.informeLabelList = null;
        this.mesHasta = null;
        this.mesHastaValueList = null;
        this.mesHastaLabelList = null;
        this.formato = null;
        this.formatoValueList = null;
        this.formatoLabelList = null;
        this.diaHasta = null;
        this.diaHastaValueList = null;
        this.diaHastaLabelList = null;
        this.mesDesde = null;
        this.mesDesdeValueList = null;
        this.mesDesdeLabelList = null;
        this.diaDesde = null;
        this.diaDesdeValueList = null;
        this.diaDesdeLabelList = null;
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
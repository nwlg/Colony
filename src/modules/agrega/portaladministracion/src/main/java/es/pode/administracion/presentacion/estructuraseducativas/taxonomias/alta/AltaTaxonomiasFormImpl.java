// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.taxonomias.alta;

public class AltaTaxonomiasFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.estructuraseducativas.taxonomias.alta.ObtenerIdiomasForm
{
    private org.apache.struts.upload.FormFile fichero1 = null;
    private java.lang.Object[] fichero1ValueList;
    private java.lang.Object[] fichero1LabelList;
    private org.apache.struts.upload.FormFile fichero2 = null;
    private java.lang.Object[] fichero2ValueList;
    private java.lang.Object[] fichero2LabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private org.apache.struts.upload.FormFile fichero3 = null;
    private java.lang.Object[] fichero3ValueList;
    private java.lang.Object[] fichero3LabelList;
    private org.apache.struts.upload.FormFile fichero4 = null;
    private java.lang.Object[] fichero4ValueList;
    private java.lang.Object[] fichero4LabelList;
    private org.apache.struts.upload.FormFile fichero5 = null;
    private java.lang.Object[] fichero5ValueList;
    private java.lang.Object[] fichero5LabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;

    public AltaTaxonomiasFormImpl()
    {
    }

    /**
     * Resets the given <code>fichero1</code>.
     */
    public void resetFichero1()
    {
        this.fichero1 = null;
    }

    public void setFichero1(org.apache.struts.upload.FormFile fichero1)
    {
        this.fichero1 = fichero1;
    }

    /**
     * 
     */
    public org.apache.struts.upload.FormFile getFichero1()
    {
        return this.fichero1;
    }
    public java.lang.Object[] getFichero1BackingList()
    {
        java.lang.Object[] values = this.fichero1ValueList;
        java.lang.Object[] labels = this.fichero1LabelList;

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

    public java.lang.Object[] getFichero1ValueList()
    {
        return this.fichero1ValueList;
    }

    public void setFichero1ValueList(java.lang.Object[] fichero1ValueList)
    {
        this.fichero1ValueList = fichero1ValueList;
    }

    public java.lang.Object[] getFichero1LabelList()
    {
        return this.fichero1LabelList;
    }

    public void setFichero1LabelList(java.lang.Object[] fichero1LabelList)
    {
        this.fichero1LabelList = fichero1LabelList;
    }

    public void setFichero1BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AltaTaxonomiasFormImpl.setFichero1BackingList requires non-null property arguments");
        }

        this.fichero1ValueList = null;
        this.fichero1LabelList = null;

        if (items != null)
        {
            this.fichero1ValueList = new java.lang.Object[items.size()];
            this.fichero1LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.fichero1ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.fichero1LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AltaTaxonomiasFormImpl.setFichero1BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>fichero2</code>.
     */
    public void resetFichero2()
    {
        this.fichero2 = null;
    }

    public void setFichero2(org.apache.struts.upload.FormFile fichero2)
    {
        this.fichero2 = fichero2;
    }

    /**
     * 
     */
    public org.apache.struts.upload.FormFile getFichero2()
    {
        return this.fichero2;
    }
    public java.lang.Object[] getFichero2BackingList()
    {
        java.lang.Object[] values = this.fichero2ValueList;
        java.lang.Object[] labels = this.fichero2LabelList;

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

    public java.lang.Object[] getFichero2ValueList()
    {
        return this.fichero2ValueList;
    }

    public void setFichero2ValueList(java.lang.Object[] fichero2ValueList)
    {
        this.fichero2ValueList = fichero2ValueList;
    }

    public java.lang.Object[] getFichero2LabelList()
    {
        return this.fichero2LabelList;
    }

    public void setFichero2LabelList(java.lang.Object[] fichero2LabelList)
    {
        this.fichero2LabelList = fichero2LabelList;
    }

    public void setFichero2BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AltaTaxonomiasFormImpl.setFichero2BackingList requires non-null property arguments");
        }

        this.fichero2ValueList = null;
        this.fichero2LabelList = null;

        if (items != null)
        {
            this.fichero2ValueList = new java.lang.Object[items.size()];
            this.fichero2LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.fichero2ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.fichero2LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AltaTaxonomiasFormImpl.setFichero2BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>action</code>.
     */
    public void resetAction()
    {
        this.action = null;
    }

    public void setAction(java.lang.String action)
    {
        this.action = action;
    }

    /**
     * 
     */
    public java.lang.String getAction()
    {
        return this.action;
    }
    
    public java.lang.Object[] getActionBackingList()
    {
        java.lang.Object[] values = this.actionValueList;
        java.lang.Object[] labels = this.actionLabelList;

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

    public java.lang.Object[] getActionValueList()
    {
        return this.actionValueList;
    }

    public void setActionValueList(java.lang.Object[] actionValueList)
    {
        this.actionValueList = actionValueList;
    }

    public java.lang.Object[] getActionLabelList()
    {
        return this.actionLabelList;
    }

    public void setActionLabelList(java.lang.Object[] actionLabelList)
    {
        this.actionLabelList = actionLabelList;
    }

    public void setActionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AltaTaxonomiasFormImpl.setActionBackingList requires non-null property arguments");
        }

        this.actionValueList = null;
        this.actionLabelList = null;

        if (items != null)
        {
            this.actionValueList = new java.lang.Object[items.size()];
            this.actionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.actionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.actionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AltaTaxonomiasFormImpl.setActionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>fichero3</code>.
     */
    public void resetFichero3()
    {
        this.fichero3 = null;
    }

    public void setFichero3(org.apache.struts.upload.FormFile fichero3)
    {
        this.fichero3 = fichero3;
    }

    /**
     * 
     */
    public org.apache.struts.upload.FormFile getFichero3()
    {
        return this.fichero3;
    }
    public java.lang.Object[] getFichero3BackingList()
    {
        java.lang.Object[] values = this.fichero3ValueList;
        java.lang.Object[] labels = this.fichero3LabelList;

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

    public java.lang.Object[] getFichero3ValueList()
    {
        return this.fichero3ValueList;
    }

    public void setFichero3ValueList(java.lang.Object[] fichero3ValueList)
    {
        this.fichero3ValueList = fichero3ValueList;
    }

    public java.lang.Object[] getFichero3LabelList()
    {
        return this.fichero3LabelList;
    }

    public void setFichero3LabelList(java.lang.Object[] fichero3LabelList)
    {
        this.fichero3LabelList = fichero3LabelList;
    }

    public void setFichero3BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AltaTaxonomiasFormImpl.setFichero3BackingList requires non-null property arguments");
        }

        this.fichero3ValueList = null;
        this.fichero3LabelList = null;

        if (items != null)
        {
            this.fichero3ValueList = new java.lang.Object[items.size()];
            this.fichero3LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.fichero3ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.fichero3LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AltaTaxonomiasFormImpl.setFichero3BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>fichero4</code>.
     */
    public void resetFichero4()
    {
        this.fichero4 = null;
    }

    public void setFichero4(org.apache.struts.upload.FormFile fichero4)
    {
        this.fichero4 = fichero4;
    }

    /**
     * 
     */
    public org.apache.struts.upload.FormFile getFichero4()
    {
        return this.fichero4;
    }
    public java.lang.Object[] getFichero4BackingList()
    {
        java.lang.Object[] values = this.fichero4ValueList;
        java.lang.Object[] labels = this.fichero4LabelList;

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

    public java.lang.Object[] getFichero4ValueList()
    {
        return this.fichero4ValueList;
    }

    public void setFichero4ValueList(java.lang.Object[] fichero4ValueList)
    {
        this.fichero4ValueList = fichero4ValueList;
    }

    public java.lang.Object[] getFichero4LabelList()
    {
        return this.fichero4LabelList;
    }

    public void setFichero4LabelList(java.lang.Object[] fichero4LabelList)
    {
        this.fichero4LabelList = fichero4LabelList;
    }

    public void setFichero4BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AltaTaxonomiasFormImpl.setFichero4BackingList requires non-null property arguments");
        }

        this.fichero4ValueList = null;
        this.fichero4LabelList = null;

        if (items != null)
        {
            this.fichero4ValueList = new java.lang.Object[items.size()];
            this.fichero4LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.fichero4ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.fichero4LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AltaTaxonomiasFormImpl.setFichero4BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>fichero5</code>.
     */
    public void resetFichero5()
    {
        this.fichero5 = null;
    }

    public void setFichero5(org.apache.struts.upload.FormFile fichero5)
    {
        this.fichero5 = fichero5;
    }

    /**
     * 
     */
    public org.apache.struts.upload.FormFile getFichero5()
    {
        return this.fichero5;
    }
    public java.lang.Object[] getFichero5BackingList()
    {
        java.lang.Object[] values = this.fichero5ValueList;
        java.lang.Object[] labels = this.fichero5LabelList;

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

    public java.lang.Object[] getFichero5ValueList()
    {
        return this.fichero5ValueList;
    }

    public void setFichero5ValueList(java.lang.Object[] fichero5ValueList)
    {
        this.fichero5ValueList = fichero5ValueList;
    }

    public java.lang.Object[] getFichero5LabelList()
    {
        return this.fichero5LabelList;
    }

    public void setFichero5LabelList(java.lang.Object[] fichero5LabelList)
    {
        this.fichero5LabelList = fichero5LabelList;
    }

    public void setFichero5BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AltaTaxonomiasFormImpl.setFichero5BackingList requires non-null property arguments");
        }

        this.fichero5ValueList = null;
        this.fichero5LabelList = null;

        if (items != null)
        {
            this.fichero5ValueList = new java.lang.Object[items.size()];
            this.fichero5LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.fichero5ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.fichero5LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AltaTaxonomiasFormImpl.setFichero5BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoBusqueda</code>.
     */
    public void resetTipoBusqueda()
    {
        this.tipoBusqueda = null;
    }

    public void setTipoBusqueda(java.lang.String tipoBusqueda)
    {
        this.tipoBusqueda = tipoBusqueda;
    }

    /**
     * 
     */
    public java.lang.String getTipoBusqueda()
    {
        return this.tipoBusqueda;
    }
    
    public java.lang.Object[] getTipoBusquedaBackingList()
    {
        java.lang.Object[] values = this.tipoBusquedaValueList;
        java.lang.Object[] labels = this.tipoBusquedaLabelList;

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

    public java.lang.Object[] getTipoBusquedaValueList()
    {
        return this.tipoBusquedaValueList;
    }

    public void setTipoBusquedaValueList(java.lang.Object[] tipoBusquedaValueList)
    {
        this.tipoBusquedaValueList = tipoBusquedaValueList;
    }

    public java.lang.Object[] getTipoBusquedaLabelList()
    {
        return this.tipoBusquedaLabelList;
    }

    public void setTipoBusquedaLabelList(java.lang.Object[] tipoBusquedaLabelList)
    {
        this.tipoBusquedaLabelList = tipoBusquedaLabelList;
    }

    public void setTipoBusquedaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AltaTaxonomiasFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
        }

        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;

        if (items != null)
        {
            this.tipoBusquedaValueList = new java.lang.Object[items.size()];
            this.tipoBusquedaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoBusquedaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoBusquedaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AltaTaxonomiasFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomaBuscador</code>.
     */
    public void resetIdiomaBuscador()
    {
        this.idiomaBuscador = null;
    }

    public void setIdiomaBuscador(java.lang.String idiomaBuscador)
    {
        this.idiomaBuscador = idiomaBuscador;
    }

    /**
     * 
     */
    public java.lang.String getIdiomaBuscador()
    {
        return this.idiomaBuscador;
    }
    
    public java.lang.Object[] getIdiomaBuscadorBackingList()
    {
        java.lang.Object[] values = this.idiomaBuscadorValueList;
        java.lang.Object[] labels = this.idiomaBuscadorLabelList;

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

    public java.lang.Object[] getIdiomaBuscadorValueList()
    {
        return this.idiomaBuscadorValueList;
    }

    public void setIdiomaBuscadorValueList(java.lang.Object[] idiomaBuscadorValueList)
    {
        this.idiomaBuscadorValueList = idiomaBuscadorValueList;
    }

    public java.lang.Object[] getIdiomaBuscadorLabelList()
    {
        return this.idiomaBuscadorLabelList;
    }

    public void setIdiomaBuscadorLabelList(java.lang.Object[] idiomaBuscadorLabelList)
    {
        this.idiomaBuscadorLabelList = idiomaBuscadorLabelList;
    }

    public void setIdiomaBuscadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AltaTaxonomiasFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
        }

        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;

        if (items != null)
        {
            this.idiomaBuscadorValueList = new java.lang.Object[items.size()];
            this.idiomaBuscadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomaBuscadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomaBuscadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AltaTaxonomiasFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.fichero1 = null;
        this.fichero2 = null;
        this.fichero3 = null;
        this.fichero4 = null;
        this.fichero5 = null;
        this.idiomaBuscador = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("fichero1", this.fichero1);
        builder.append("fichero2", this.fichero2);
        builder.append("action", this.action);
        builder.append("fichero3", this.fichero3);
        builder.append("fichero4", this.fichero4);
        builder.append("fichero5", this.fichero5);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.fichero1 = null;
        this.fichero1ValueList = null;
        this.fichero1LabelList = null;
        this.fichero2 = null;
        this.fichero2ValueList = null;
        this.fichero2LabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.fichero3 = null;
        this.fichero3ValueList = null;
        this.fichero3LabelList = null;
        this.fichero4 = null;
        this.fichero4ValueList = null;
        this.fichero4LabelList = null;
        this.fichero5 = null;
        this.fichero5ValueList = null;
        this.fichero5LabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
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
// license-header java merge-point
package es.pode.administracion.presentacion.descargas.activas;

public class ActivasDesactivarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.descargas.activas.ObtenerDatosForm
        , es.pode.administracion.presentacion.descargas.activas.DesactivarForm
{
    private java.lang.String identificador;
    private java.lang.Object[] identificadorValueList;
    private java.lang.Object[] identificadorLabelList;
    private java.lang.Long idModificada;
    private java.lang.Object[] idModificadaValueList;
    private java.lang.Object[] idModificadaLabelList;
    private java.util.List descargas = null;
    private java.lang.Object[] descargasValueList;
    private java.lang.Object[] descargasLabelList;

    public ActivasDesactivarFormImpl()
    {
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
            throw new IllegalArgumentException("ActivasDesactivarFormImpl.setIdentificadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ActivasDesactivarFormImpl.setIdentificadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idModificada</code>.
     */
    public void resetIdModificada()
    {
        this.idModificada = null;
    }

    public void setIdModificada(java.lang.Long idModificada)
    {
        this.idModificada = idModificada;
    }

    /**
     * 
     */
    public java.lang.Long getIdModificada()
    {
        return this.idModificada;
    }
    
    public java.lang.Object[] getIdModificadaBackingList()
    {
        java.lang.Object[] values = this.idModificadaValueList;
        java.lang.Object[] labels = this.idModificadaLabelList;

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

    public java.lang.Object[] getIdModificadaValueList()
    {
        return this.idModificadaValueList;
    }

    public void setIdModificadaValueList(java.lang.Object[] idModificadaValueList)
    {
        this.idModificadaValueList = idModificadaValueList;
    }

    public java.lang.Object[] getIdModificadaLabelList()
    {
        return this.idModificadaLabelList;
    }

    public void setIdModificadaLabelList(java.lang.Object[] idModificadaLabelList)
    {
        this.idModificadaLabelList = idModificadaLabelList;
    }

    public void setIdModificadaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ActivasDesactivarFormImpl.setIdModificadaBackingList requires non-null property arguments");
        }

        this.idModificadaValueList = null;
        this.idModificadaLabelList = null;

        if (items != null)
        {
            this.idModificadaValueList = new java.lang.Object[items.size()];
            this.idModificadaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idModificadaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idModificadaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ActivasDesactivarFormImpl.setIdModificadaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descargas</code>.
     */
    public void resetDescargas()
    {
        this.descargas = null;
    }

    public void setDescargas(java.util.List descargas)
    {
        this.descargas = descargas;
    }

    /**
     * 
     */
    public java.util.List getDescargas()
    {
        return this.descargas;
    }

    public void setDescargasAsArray(Object[] descargas)
    {
        this.descargas = (descargas == null) ? null : java.util.Arrays.asList(descargas);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.descargas.activas.ActivasDesactivarFormImpl#getDescargas
     */
    public java.lang.Object[] getDescargasAsArray()
    {
        return (descargas == null) ? null : descargas.toArray();
    }
    
    public java.lang.Object[] getDescargasBackingList()
    {
        java.lang.Object[] values = this.descargasValueList;
        java.lang.Object[] labels = this.descargasLabelList;

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

    public java.lang.Object[] getDescargasValueList()
    {
        return this.descargasValueList;
    }

    public void setDescargasValueList(java.lang.Object[] descargasValueList)
    {
        this.descargasValueList = descargasValueList;
    }

    public java.lang.Object[] getDescargasLabelList()
    {
        return this.descargasLabelList;
    }

    public void setDescargasLabelList(java.lang.Object[] descargasLabelList)
    {
        this.descargasLabelList = descargasLabelList;
    }

    public void setDescargasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ActivasDesactivarFormImpl.setDescargasBackingList requires non-null property arguments");
        }

        this.descargasValueList = null;
        this.descargasLabelList = null;

        if (items != null)
        {
            this.descargasValueList = new java.lang.Object[items.size()];
            this.descargasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descargasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descargasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ActivasDesactivarFormImpl.setDescargasBackingList encountered an exception", ex);
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
        builder.append("identificador", this.identificador);
        builder.append("idModificada", this.idModificada);
        builder.append("descargas", this.descargas);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.identificador = null;
        this.identificadorValueList = null;
        this.identificadorLabelList = null;
        this.idModificada = null;
        this.idModificadaValueList = null;
        this.idModificadaLabelList = null;
        this.descargas = null;
        this.descargasValueList = null;
        this.descargasLabelList = null;
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
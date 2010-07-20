// license-header java merge-point
package es.pode.administracion.presentacion.informes.eliminarInformesFederados;

public class ConfirmarFederadosAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.informes.eliminarInformesFederados.EliminarInformeFederadoForm
{
    private java.lang.String[] informes;
    private java.lang.Object[] informesValueList;
    private java.lang.Object[] informesLabelList;
    private java.lang.String listaId;
    private java.lang.Object[] listaIdValueList;
    private java.lang.Object[] listaIdLabelList;
    private java.lang.String resultado;
    private java.lang.Object[] resultadoValueList;
    private java.lang.Object[] resultadoLabelList;
    private java.lang.String[] informesBorrados;
    private java.lang.Object[] informesBorradosValueList;
    private java.lang.Object[] informesBorradosLabelList;

    public ConfirmarFederadosAceptarFormImpl()
    {
    }

    /**
     * Resets the given <code>informes</code>.
     */
    public void resetInformes()
    {
        this.informes = null;
    }

    public void setInformes(java.lang.String[] informes)
    {
        this.informes = informes;
    }

    /**
     * 
     */
    public java.lang.String[] getInformes()
    {
        return this.informes;
    }
    
    public java.lang.Object[] getInformesBackingList()
    {
        java.lang.Object[] values = this.informesValueList;
        java.lang.Object[] labels = this.informesLabelList;

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

    public java.lang.Object[] getInformesValueList()
    {
        return this.informesValueList;
    }

    public void setInformesValueList(java.lang.Object[] informesValueList)
    {
        this.informesValueList = informesValueList;
    }

    public java.lang.Object[] getInformesLabelList()
    {
        return this.informesLabelList;
    }

    public void setInformesLabelList(java.lang.Object[] informesLabelList)
    {
        this.informesLabelList = informesLabelList;
    }

    public void setInformesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmarFederadosAceptarFormImpl.setInformesBackingList requires non-null property arguments");
        }

        this.informesValueList = null;
        this.informesLabelList = null;

        if (items != null)
        {
            this.informesValueList = new java.lang.Object[items.size()];
            this.informesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.informesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.informesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmarFederadosAceptarFormImpl.setInformesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listaId</code>.
     */
    public void resetListaId()
    {
        this.listaId = null;
    }

    public void setListaId(java.lang.String listaId)
    {
        this.listaId = listaId;
    }

    /**
     * 
     */
    public java.lang.String getListaId()
    {
        return this.listaId;
    }
    
    public java.lang.Object[] getListaIdBackingList()
    {
        java.lang.Object[] values = this.listaIdValueList;
        java.lang.Object[] labels = this.listaIdLabelList;

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

    public java.lang.Object[] getListaIdValueList()
    {
        return this.listaIdValueList;
    }

    public void setListaIdValueList(java.lang.Object[] listaIdValueList)
    {
        this.listaIdValueList = listaIdValueList;
    }

    public java.lang.Object[] getListaIdLabelList()
    {
        return this.listaIdLabelList;
    }

    public void setListaIdLabelList(java.lang.Object[] listaIdLabelList)
    {
        this.listaIdLabelList = listaIdLabelList;
    }

    public void setListaIdBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmarFederadosAceptarFormImpl.setListaIdBackingList requires non-null property arguments");
        }

        this.listaIdValueList = null;
        this.listaIdLabelList = null;

        if (items != null)
        {
            this.listaIdValueList = new java.lang.Object[items.size()];
            this.listaIdLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listaIdValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listaIdLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmarFederadosAceptarFormImpl.setListaIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>resultado</code>.
     */
    public void resetResultado()
    {
        this.resultado = null;
    }

    public void setResultado(java.lang.String resultado)
    {
        this.resultado = resultado;
    }

    /**
     * 
     */
    public java.lang.String getResultado()
    {
        return this.resultado;
    }
    
    public java.lang.Object[] getResultadoBackingList()
    {
        java.lang.Object[] values = this.resultadoValueList;
        java.lang.Object[] labels = this.resultadoLabelList;

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

    public java.lang.Object[] getResultadoValueList()
    {
        return this.resultadoValueList;
    }

    public void setResultadoValueList(java.lang.Object[] resultadoValueList)
    {
        this.resultadoValueList = resultadoValueList;
    }

    public java.lang.Object[] getResultadoLabelList()
    {
        return this.resultadoLabelList;
    }

    public void setResultadoLabelList(java.lang.Object[] resultadoLabelList)
    {
        this.resultadoLabelList = resultadoLabelList;
    }

    public void setResultadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmarFederadosAceptarFormImpl.setResultadoBackingList requires non-null property arguments");
        }

        this.resultadoValueList = null;
        this.resultadoLabelList = null;

        if (items != null)
        {
            this.resultadoValueList = new java.lang.Object[items.size()];
            this.resultadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resultadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resultadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmarFederadosAceptarFormImpl.setResultadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>informesBorrados</code>.
     */
    public void resetInformesBorrados()
    {
        this.informesBorrados = null;
    }

    public void setInformesBorrados(java.lang.String[] informesBorrados)
    {
        this.informesBorrados = informesBorrados;
    }

    /**
     * 
     */
    public java.lang.String[] getInformesBorrados()
    {
        return this.informesBorrados;
    }
    
    public java.lang.Object[] getInformesBorradosBackingList()
    {
        java.lang.Object[] values = this.informesBorradosValueList;
        java.lang.Object[] labels = this.informesBorradosLabelList;

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

    public java.lang.Object[] getInformesBorradosValueList()
    {
        return this.informesBorradosValueList;
    }

    public void setInformesBorradosValueList(java.lang.Object[] informesBorradosValueList)
    {
        this.informesBorradosValueList = informesBorradosValueList;
    }

    public java.lang.Object[] getInformesBorradosLabelList()
    {
        return this.informesBorradosLabelList;
    }

    public void setInformesBorradosLabelList(java.lang.Object[] informesBorradosLabelList)
    {
        this.informesBorradosLabelList = informesBorradosLabelList;
    }

    public void setInformesBorradosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmarFederadosAceptarFormImpl.setInformesBorradosBackingList requires non-null property arguments");
        }

        this.informesBorradosValueList = null;
        this.informesBorradosLabelList = null;

        if (items != null)
        {
            this.informesBorradosValueList = new java.lang.Object[items.size()];
            this.informesBorradosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.informesBorradosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.informesBorradosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmarFederadosAceptarFormImpl.setInformesBorradosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.informes = null;
        this.informesValueList = new java.lang.Object[0];
        this.informesLabelList = new java.lang.Object[0];
        this.informesBorrados = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("informes", this.informes);
        builder.append("listaId", this.listaId);
        builder.append("resultado", this.resultado);
        builder.append("informesBorrados", this.informesBorrados);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.informes = null;
        this.informesValueList = null;
        this.informesLabelList = null;
        this.listaId = null;
        this.listaIdValueList = null;
        this.listaIdLabelList = null;
        this.resultado = null;
        this.resultadoValueList = null;
        this.resultadoLabelList = null;
        this.informesBorrados = null;
        this.informesBorradosValueList = null;
        this.informesBorradosLabelList = null;
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
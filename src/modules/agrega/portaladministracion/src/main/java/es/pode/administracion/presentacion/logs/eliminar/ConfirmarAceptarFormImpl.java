// license-header java merge-point
package es.pode.administracion.presentacion.logs.eliminar;

public class ConfirmarAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.logs.eliminar.EliminarLogsForm
{
    private java.lang.String listaId;
    private java.lang.Object[] listaIdValueList;
    private java.lang.Object[] listaIdLabelList;
    private java.lang.String[] logs;
    private java.lang.Object[] logsValueList;
    private java.lang.Object[] logsLabelList;
    private java.lang.String resultado;
    private java.lang.Object[] resultadoValueList;
    private java.lang.Object[] resultadoLabelList;
    private java.lang.String[] logsBorrados;
    private java.lang.Object[] logsBorradosValueList;
    private java.lang.Object[] logsBorradosLabelList;

    public ConfirmarAceptarFormImpl()
    {
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
            throw new IllegalArgumentException("ConfirmarAceptarFormImpl.setListaIdBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ConfirmarAceptarFormImpl.setListaIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>logs</code>.
     */
    public void resetLogs()
    {
        this.logs = null;
    }

    public void setLogs(java.lang.String[] logs)
    {
        this.logs = logs;
    }

    /**
     * 
     */
    public java.lang.String[] getLogs()
    {
        return this.logs;
    }
    
    public java.lang.Object[] getLogsBackingList()
    {
        java.lang.Object[] values = this.logsValueList;
        java.lang.Object[] labels = this.logsLabelList;

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

    public java.lang.Object[] getLogsValueList()
    {
        return this.logsValueList;
    }

    public void setLogsValueList(java.lang.Object[] logsValueList)
    {
        this.logsValueList = logsValueList;
    }

    public java.lang.Object[] getLogsLabelList()
    {
        return this.logsLabelList;
    }

    public void setLogsLabelList(java.lang.Object[] logsLabelList)
    {
        this.logsLabelList = logsLabelList;
    }

    public void setLogsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmarAceptarFormImpl.setLogsBackingList requires non-null property arguments");
        }

        this.logsValueList = null;
        this.logsLabelList = null;

        if (items != null)
        {
            this.logsValueList = new java.lang.Object[items.size()];
            this.logsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.logsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.logsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmarAceptarFormImpl.setLogsBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ConfirmarAceptarFormImpl.setResultadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ConfirmarAceptarFormImpl.setResultadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>logsBorrados</code>.
     */
    public void resetLogsBorrados()
    {
        this.logsBorrados = null;
    }

    public void setLogsBorrados(java.lang.String[] logsBorrados)
    {
        this.logsBorrados = logsBorrados;
    }

    /**
     * 
     */
    public java.lang.String[] getLogsBorrados()
    {
        return this.logsBorrados;
    }
    
    public java.lang.Object[] getLogsBorradosBackingList()
    {
        java.lang.Object[] values = this.logsBorradosValueList;
        java.lang.Object[] labels = this.logsBorradosLabelList;

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

    public java.lang.Object[] getLogsBorradosValueList()
    {
        return this.logsBorradosValueList;
    }

    public void setLogsBorradosValueList(java.lang.Object[] logsBorradosValueList)
    {
        this.logsBorradosValueList = logsBorradosValueList;
    }

    public java.lang.Object[] getLogsBorradosLabelList()
    {
        return this.logsBorradosLabelList;
    }

    public void setLogsBorradosLabelList(java.lang.Object[] logsBorradosLabelList)
    {
        this.logsBorradosLabelList = logsBorradosLabelList;
    }

    public void setLogsBorradosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmarAceptarFormImpl.setLogsBorradosBackingList requires non-null property arguments");
        }

        this.logsBorradosValueList = null;
        this.logsBorradosLabelList = null;

        if (items != null)
        {
            this.logsBorradosValueList = new java.lang.Object[items.size()];
            this.logsBorradosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.logsBorradosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.logsBorradosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmarAceptarFormImpl.setLogsBorradosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.logs = null;
        this.logsValueList = new java.lang.Object[0];
        this.logsLabelList = new java.lang.Object[0];
        this.logsBorrados = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("listaId", this.listaId);
        builder.append("logs", this.logs);
        builder.append("resultado", this.resultado);
        builder.append("logsBorrados", this.logsBorrados);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.listaId = null;
        this.listaIdValueList = null;
        this.listaIdLabelList = null;
        this.logs = null;
        this.logsValueList = null;
        this.logsLabelList = null;
        this.resultado = null;
        this.resultadoValueList = null;
        this.resultadoLabelList = null;
        this.logsBorrados = null;
        this.logsBorradosValueList = null;
        this.logsBorradosLabelList = null;
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
// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar;

public class ObjectSubmitFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.basico.asociar.CrearObjectForm
        , es.pode.empaquetador.presentacion.basico.asociar.SelectActionObjectForm
{
    private java.lang.String texto;
    private java.lang.Object[] textoValueList;
    private java.lang.Object[] textoLabelList;
    private java.lang.String tipo;
    private java.lang.Object[] tipoValueList;
    private java.lang.Object[] tipoLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;

    public ObjectSubmitFormImpl()
    {
    }

    /**
     * Resets the given <code>texto</code>.
     */
    public void resetTexto()
    {
        this.texto = null;
    }

    public void setTexto(java.lang.String texto)
    {
        this.texto = texto;
    }

    /**
     * 
     */
    public java.lang.String getTexto()
    {
        return this.texto;
    }
    
    public java.lang.Object[] getTextoBackingList()
    {
        java.lang.Object[] values = this.textoValueList;
        java.lang.Object[] labels = this.textoLabelList;

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

    public java.lang.Object[] getTextoValueList()
    {
        return this.textoValueList;
    }

    public void setTextoValueList(java.lang.Object[] textoValueList)
    {
        this.textoValueList = textoValueList;
    }

    public java.lang.Object[] getTextoLabelList()
    {
        return this.textoLabelList;
    }

    public void setTextoLabelList(java.lang.Object[] textoLabelList)
    {
        this.textoLabelList = textoLabelList;
    }

    public void setTextoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObjectSubmitFormImpl.setTextoBackingList requires non-null property arguments");
        }

        this.textoValueList = null;
        this.textoLabelList = null;

        if (items != null)
        {
            this.textoValueList = new java.lang.Object[items.size()];
            this.textoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.textoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.textoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObjectSubmitFormImpl.setTextoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipo</code>.
     */
    public void resetTipo()
    {
        this.tipo = null;
    }

    public void setTipo(java.lang.String tipo)
    {
        this.tipo = tipo;
    }

    /**
     * 
     */
    public java.lang.String getTipo()
    {
        return this.tipo;
    }
    
    public java.lang.Object[] getTipoBackingList()
    {
        java.lang.Object[] values = this.tipoValueList;
        java.lang.Object[] labels = this.tipoLabelList;

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

    public java.lang.Object[] getTipoValueList()
    {
        return this.tipoValueList;
    }

    public void setTipoValueList(java.lang.Object[] tipoValueList)
    {
        this.tipoValueList = tipoValueList;
    }

    public java.lang.Object[] getTipoLabelList()
    {
        return this.tipoLabelList;
    }

    public void setTipoLabelList(java.lang.Object[] tipoLabelList)
    {
        this.tipoLabelList = tipoLabelList;
    }

    public void setTipoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObjectSubmitFormImpl.setTipoBackingList requires non-null property arguments");
        }

        this.tipoValueList = null;
        this.tipoLabelList = null;

        if (items != null)
        {
            this.tipoValueList = new java.lang.Object[items.size()];
            this.tipoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObjectSubmitFormImpl.setTipoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ObjectSubmitFormImpl.setActionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObjectSubmitFormImpl.setActionBackingList encountered an exception", ex);
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
        builder.append("texto", this.texto);
        builder.append("tipo", this.tipo);
        builder.append("action", this.action);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.texto = null;
        this.textoValueList = null;
        this.textoLabelList = null;
        this.tipo = null;
        this.tipoValueList = null;
        this.tipoLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
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
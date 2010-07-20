// license-header java merge-point
package es.pode.administracion.presentacion.monitorizarnodos.monitorizar;

public class MonitorizarNodosFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.monitorizarnodos.monitorizar.EstadoNodosForm
{
    private java.util.Collection estados;
    private java.lang.Object[] estadosValueList;
    private java.lang.Object[] estadosLabelList;

    public MonitorizarNodosFormImpl()
    {
    }

    /**
     * Resets the given <code>estados</code>.
     */
    public void resetEstados()
    {
        this.estados = null;
    }

    public void setEstados(java.util.Collection estados)
    {
        this.estados = estados;
    }

    /**
     * 
     */
    public java.util.Collection getEstados()
    {
        return this.estados;
    }

    public void setEstadosAsArray(Object[] estados)
    {
        this.estados = (estados == null) ? null : java.util.Arrays.asList(estados);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.monitorizarnodos.monitorizar.MonitorizarNodosFormImpl#getEstados
     */
    public java.lang.Object[] getEstadosAsArray()
    {
        return (estados == null) ? null : estados.toArray();
    }
    
    public java.lang.Object[] getEstadosBackingList()
    {
        java.lang.Object[] values = this.estadosValueList;
        java.lang.Object[] labels = this.estadosLabelList;

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

    public java.lang.Object[] getEstadosValueList()
    {
        return this.estadosValueList;
    }

    public void setEstadosValueList(java.lang.Object[] estadosValueList)
    {
        this.estadosValueList = estadosValueList;
    }

    public java.lang.Object[] getEstadosLabelList()
    {
        return this.estadosLabelList;
    }

    public void setEstadosLabelList(java.lang.Object[] estadosLabelList)
    {
        this.estadosLabelList = estadosLabelList;
    }

    public void setEstadosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MonitorizarNodosFormImpl.setEstadosBackingList requires non-null property arguments");
        }

        this.estadosValueList = null;
        this.estadosLabelList = null;

        if (items != null)
        {
            this.estadosValueList = new java.lang.Object[items.size()];
            this.estadosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.estadosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.estadosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MonitorizarNodosFormImpl.setEstadosBackingList encountered an exception", ex);
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
        builder.append("estados", this.estados);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.estados = null;
        this.estadosValueList = null;
        this.estadosLabelList = null;
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
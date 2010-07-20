// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar;

public class AgregarSubmanifiestoFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.lang.String origen;
    private java.lang.Object[] origenValueList;
    private java.lang.Object[] origenLabelList;

    public AgregarSubmanifiestoFormImpl()
    {
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
            throw new IllegalArgumentException("AgregarSubmanifiestoFormImpl.setActionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AgregarSubmanifiestoFormImpl.setActionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>origen</code>.
     */
    public void resetOrigen()
    {
        this.origen = null;
    }

    public void setOrigen(java.lang.String origen)
    {
        this.origen = origen;
    }

    /**
     * 
     */
    public java.lang.String getOrigen()
    {
        return this.origen;
    }
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     */
    public java.lang.String getOrigenOptionValue(int optionIndex)
    {
        switch(optionIndex)
        {
            case 0 : return "repositorio";
            case 1 : return "personales";
            case 2 : return "local";
            default:
                throw new java.lang.ArrayIndexOutOfBoundsException(
                    "Cannot access option "+optionIndex+", please specify a value in the range [0-2]");
        }
    }

    public java.lang.Object[] getOrigenBackingList()
    {
        java.lang.Object[] values = this.origenValueList;
        java.lang.Object[] labels = this.origenLabelList;

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

    public java.lang.Object[] getOrigenValueList()
    {
        return this.origenValueList;
    }

    public void setOrigenValueList(java.lang.Object[] origenValueList)
    {
        this.origenValueList = origenValueList;
    }

    public java.lang.Object[] getOrigenLabelList()
    {
        return this.origenLabelList;
    }

    public void setOrigenLabelList(java.lang.Object[] origenLabelList)
    {
        this.origenLabelList = origenLabelList;
    }

    public void setOrigenBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AgregarSubmanifiestoFormImpl.setOrigenBackingList requires non-null property arguments");
        }

        this.origenValueList = null;
        this.origenLabelList = null;

        if (items != null)
        {
            this.origenValueList = new java.lang.Object[items.size()];
            this.origenLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.origenValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.origenLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AgregarSubmanifiestoFormImpl.setOrigenBackingList encountered an exception", ex);
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
        builder.append("action", this.action);
        builder.append("origen", this.origen);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.origen = null;
        this.origenValueList = null;
        this.origenLabelList = null;
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
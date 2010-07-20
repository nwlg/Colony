// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.principal;

public class PrincipalSubmitFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.basico.principal.FijarPrincipalForm
{
    private java.lang.String principal;
    private java.lang.Object[] principalValueList;
    private java.lang.Object[] principalLabelList;
    private java.lang.String idRecurso;
    private java.lang.Object[] idRecursoValueList;
    private java.lang.Object[] idRecursoLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;

    public PrincipalSubmitFormImpl()
    {
    }

    /**
     * Resets the given <code>principal</code>.
     */
    public void resetPrincipal()
    {
        this.principal = null;
    }

    public void setPrincipal(java.lang.String principal)
    {
        this.principal = principal;
    }

    /**
     * 
     */
    public java.lang.String getPrincipal()
    {
        return this.principal;
    }
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     */
    public java.lang.String getPrincipalOptionValue(int optionIndex)
    {
        switch(optionIndex)
        {
            case 0 : return "0";
            case 1 : return "1";
            case 2 : return "2";
            default:
                throw new java.lang.ArrayIndexOutOfBoundsException(
                    "Cannot access option "+optionIndex+", please specify a value in the range [0-2]");
        }
    }

    public java.lang.Object[] getPrincipalBackingList()
    {
        java.lang.Object[] values = this.principalValueList;
        java.lang.Object[] labels = this.principalLabelList;

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

    public java.lang.Object[] getPrincipalValueList()
    {
        return this.principalValueList;
    }

    public void setPrincipalValueList(java.lang.Object[] principalValueList)
    {
        this.principalValueList = principalValueList;
    }

    public java.lang.Object[] getPrincipalLabelList()
    {
        return this.principalLabelList;
    }

    public void setPrincipalLabelList(java.lang.Object[] principalLabelList)
    {
        this.principalLabelList = principalLabelList;
    }

    public void setPrincipalBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PrincipalSubmitFormImpl.setPrincipalBackingList requires non-null property arguments");
        }

        this.principalValueList = null;
        this.principalLabelList = null;

        if (items != null)
        {
            this.principalValueList = new java.lang.Object[items.size()];
            this.principalLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.principalValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.principalLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PrincipalSubmitFormImpl.setPrincipalBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idRecurso</code>.
     */
    public void resetIdRecurso()
    {
        this.idRecurso = null;
    }

    public void setIdRecurso(java.lang.String idRecurso)
    {
        this.idRecurso = idRecurso;
    }

    /**
     * 
     */
    public java.lang.String getIdRecurso()
    {
        return this.idRecurso;
    }
    
    public java.lang.Object[] getIdRecursoBackingList()
    {
        java.lang.Object[] values = this.idRecursoValueList;
        java.lang.Object[] labels = this.idRecursoLabelList;

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

    public java.lang.Object[] getIdRecursoValueList()
    {
        return this.idRecursoValueList;
    }

    public void setIdRecursoValueList(java.lang.Object[] idRecursoValueList)
    {
        this.idRecursoValueList = idRecursoValueList;
    }

    public java.lang.Object[] getIdRecursoLabelList()
    {
        return this.idRecursoLabelList;
    }

    public void setIdRecursoLabelList(java.lang.Object[] idRecursoLabelList)
    {
        this.idRecursoLabelList = idRecursoLabelList;
    }

    public void setIdRecursoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PrincipalSubmitFormImpl.setIdRecursoBackingList requires non-null property arguments");
        }

        this.idRecursoValueList = null;
        this.idRecursoLabelList = null;

        if (items != null)
        {
            this.idRecursoValueList = new java.lang.Object[items.size()];
            this.idRecursoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idRecursoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idRecursoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PrincipalSubmitFormImpl.setIdRecursoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("PrincipalSubmitFormImpl.setActionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PrincipalSubmitFormImpl.setActionBackingList encountered an exception", ex);
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
        builder.append("principal", this.principal);
        builder.append("idRecurso", this.idRecurso);
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
        this.principal = null;
        this.principalValueList = null;
        this.principalLabelList = null;
        this.idRecurso = null;
        this.idRecursoValueList = null;
        this.idRecursoLabelList = null;
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
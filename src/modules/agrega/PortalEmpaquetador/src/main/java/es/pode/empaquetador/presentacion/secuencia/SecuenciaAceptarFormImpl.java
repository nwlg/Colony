// license-header java merge-point
package es.pode.empaquetador.presentacion.secuencia;

public class SecuenciaAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.secuencia.AsociarSecuenciaForm
        , es.pode.empaquetador.presentacion.secuencia.FijarPorDefectoForm
        , es.pode.empaquetador.presentacion.secuencia.SelectActionForm
        , es.pode.empaquetador.presentacion.secuencia.TipoEmpaquetadorForm
{
    private java.lang.Boolean forwardOnly;
    private java.lang.Object[] forwardOnlyValueList;
    private java.lang.Object[] forwardOnlyLabelList;
    private java.lang.Boolean choice;
    private java.lang.Object[] choiceValueList;
    private java.lang.Object[] choiceLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.lang.Boolean choiceExit;
    private java.lang.Object[] choiceExitValueList;
    private java.lang.Object[] choiceExitLabelList;
    private java.lang.Boolean flow;
    private java.lang.Object[] flowValueList;
    private java.lang.Object[] flowLabelList;

    public SecuenciaAceptarFormImpl()
    {
    }

    /**
     * Resets the given <code>forwardOnly</code>.
     */
    public void resetForwardOnly()
    {
        this.forwardOnly = null;
    }

    public void setForwardOnly(java.lang.Boolean forwardOnly)
    {
        this.forwardOnly = forwardOnly;
    }

    /**
     * 
     */
    public java.lang.Boolean getForwardOnly()
    {
        return this.forwardOnly;
    }
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     */
    public java.lang.Boolean getForwardOnlyOptionValue(int optionIndex)
    {
        switch(optionIndex)
        {
            case 0 : return new java.lang.Boolean("true");
            case 1 : return new java.lang.Boolean("false");
            default:
                throw new java.lang.ArrayIndexOutOfBoundsException(
                    "Cannot access option "+optionIndex+", please specify a value in the range [0-1]");
        }
    }

    public java.lang.Object[] getForwardOnlyBackingList()
    {
        java.lang.Object[] values = this.forwardOnlyValueList;
        java.lang.Object[] labels = this.forwardOnlyLabelList;

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

    public java.lang.Object[] getForwardOnlyValueList()
    {
        return this.forwardOnlyValueList;
    }

    public void setForwardOnlyValueList(java.lang.Object[] forwardOnlyValueList)
    {
        this.forwardOnlyValueList = forwardOnlyValueList;
    }

    public java.lang.Object[] getForwardOnlyLabelList()
    {
        return this.forwardOnlyLabelList;
    }

    public void setForwardOnlyLabelList(java.lang.Object[] forwardOnlyLabelList)
    {
        this.forwardOnlyLabelList = forwardOnlyLabelList;
    }

    public void setForwardOnlyBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SecuenciaAceptarFormImpl.setForwardOnlyBackingList requires non-null property arguments");
        }

        this.forwardOnlyValueList = null;
        this.forwardOnlyLabelList = null;

        if (items != null)
        {
            this.forwardOnlyValueList = new java.lang.Object[items.size()];
            this.forwardOnlyLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.forwardOnlyValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.forwardOnlyLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SecuenciaAceptarFormImpl.setForwardOnlyBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>choice</code>.
     */
    public void resetChoice()
    {
        this.choice = null;
    }

    public void setChoice(java.lang.Boolean choice)
    {
        this.choice = choice;
    }

    /**
     * 
     */
    public java.lang.Boolean getChoice()
    {
        return this.choice;
    }
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     */
    public java.lang.Boolean getChoiceOptionValue(int optionIndex)
    {
        switch(optionIndex)
        {
            case 0 : return new java.lang.Boolean("true");
            case 1 : return new java.lang.Boolean("false");
            default:
                throw new java.lang.ArrayIndexOutOfBoundsException(
                    "Cannot access option "+optionIndex+", please specify a value in the range [0-1]");
        }
    }

    public java.lang.Object[] getChoiceBackingList()
    {
        java.lang.Object[] values = this.choiceValueList;
        java.lang.Object[] labels = this.choiceLabelList;

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

    public java.lang.Object[] getChoiceValueList()
    {
        return this.choiceValueList;
    }

    public void setChoiceValueList(java.lang.Object[] choiceValueList)
    {
        this.choiceValueList = choiceValueList;
    }

    public java.lang.Object[] getChoiceLabelList()
    {
        return this.choiceLabelList;
    }

    public void setChoiceLabelList(java.lang.Object[] choiceLabelList)
    {
        this.choiceLabelList = choiceLabelList;
    }

    public void setChoiceBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SecuenciaAceptarFormImpl.setChoiceBackingList requires non-null property arguments");
        }

        this.choiceValueList = null;
        this.choiceLabelList = null;

        if (items != null)
        {
            this.choiceValueList = new java.lang.Object[items.size()];
            this.choiceLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.choiceValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.choiceLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SecuenciaAceptarFormImpl.setChoiceBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SecuenciaAceptarFormImpl.setActionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SecuenciaAceptarFormImpl.setActionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>choiceExit</code>.
     */
    public void resetChoiceExit()
    {
        this.choiceExit = null;
    }

    public void setChoiceExit(java.lang.Boolean choiceExit)
    {
        this.choiceExit = choiceExit;
    }

    /**
     * 
     */
    public java.lang.Boolean getChoiceExit()
    {
        return this.choiceExit;
    }
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     */
    public java.lang.Boolean getChoiceExitOptionValue(int optionIndex)
    {
        switch(optionIndex)
        {
            case 0 : return new java.lang.Boolean("true");
            case 1 : return new java.lang.Boolean("false");
            default:
                throw new java.lang.ArrayIndexOutOfBoundsException(
                    "Cannot access option "+optionIndex+", please specify a value in the range [0-1]");
        }
    }

    public java.lang.Object[] getChoiceExitBackingList()
    {
        java.lang.Object[] values = this.choiceExitValueList;
        java.lang.Object[] labels = this.choiceExitLabelList;

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

    public java.lang.Object[] getChoiceExitValueList()
    {
        return this.choiceExitValueList;
    }

    public void setChoiceExitValueList(java.lang.Object[] choiceExitValueList)
    {
        this.choiceExitValueList = choiceExitValueList;
    }

    public java.lang.Object[] getChoiceExitLabelList()
    {
        return this.choiceExitLabelList;
    }

    public void setChoiceExitLabelList(java.lang.Object[] choiceExitLabelList)
    {
        this.choiceExitLabelList = choiceExitLabelList;
    }

    public void setChoiceExitBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SecuenciaAceptarFormImpl.setChoiceExitBackingList requires non-null property arguments");
        }

        this.choiceExitValueList = null;
        this.choiceExitLabelList = null;

        if (items != null)
        {
            this.choiceExitValueList = new java.lang.Object[items.size()];
            this.choiceExitLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.choiceExitValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.choiceExitLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SecuenciaAceptarFormImpl.setChoiceExitBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>flow</code>.
     */
    public void resetFlow()
    {
        this.flow = null;
    }

    public void setFlow(java.lang.Boolean flow)
    {
        this.flow = flow;
    }

    /**
     * 
     */
    public java.lang.Boolean getFlow()
    {
        return this.flow;
    }
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     */
    public java.lang.Boolean getFlowOptionValue(int optionIndex)
    {
        switch(optionIndex)
        {
            case 0 : return new java.lang.Boolean("true");
            case 1 : return new java.lang.Boolean("false");
            default:
                throw new java.lang.ArrayIndexOutOfBoundsException(
                    "Cannot access option "+optionIndex+", please specify a value in the range [0-1]");
        }
    }

    public java.lang.Object[] getFlowBackingList()
    {
        java.lang.Object[] values = this.flowValueList;
        java.lang.Object[] labels = this.flowLabelList;

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

    public java.lang.Object[] getFlowValueList()
    {
        return this.flowValueList;
    }

    public void setFlowValueList(java.lang.Object[] flowValueList)
    {
        this.flowValueList = flowValueList;
    }

    public java.lang.Object[] getFlowLabelList()
    {
        return this.flowLabelList;
    }

    public void setFlowLabelList(java.lang.Object[] flowLabelList)
    {
        this.flowLabelList = flowLabelList;
    }

    public void setFlowBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SecuenciaAceptarFormImpl.setFlowBackingList requires non-null property arguments");
        }

        this.flowValueList = null;
        this.flowLabelList = null;

        if (items != null)
        {
            this.flowValueList = new java.lang.Object[items.size()];
            this.flowLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.flowValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.flowLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SecuenciaAceptarFormImpl.setFlowBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.forwardOnly = null;
        this.choice = null;
        this.choiceExit = null;
        this.flow = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("forwardOnly", this.forwardOnly);
        builder.append("choice", this.choice);
        builder.append("action", this.action);
        builder.append("choiceExit", this.choiceExit);
        builder.append("flow", this.flow);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.forwardOnly = null;
        this.forwardOnlyValueList = null;
        this.forwardOnlyLabelList = null;
        this.choice = null;
        this.choiceValueList = null;
        this.choiceLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.choiceExit = null;
        this.choiceExitValueList = null;
        this.choiceExitLabelList = null;
        this.flow = null;
        this.flowValueList = null;
        this.flowLabelList = null;
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
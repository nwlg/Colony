// license-header java merge-point
package es.pode.visualizador.presentacion.agregaSlider;

public class AgregaSliderFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.visualizador.presentacion.agregaSlider.CargarIdiomaForm
{
    private java.lang.String keywords;
    private java.lang.Object[] keywordsValueList;
    private java.lang.Object[] keywordsLabelList;
    private java.lang.String idiomasCombo;
    private java.lang.Object[] idiomasComboValueList;
    private java.lang.Object[] idiomasComboLabelList;

    public AgregaSliderFormImpl()
    {
    }

    /**
     * Resets the given <code>keywords</code>.
     */
    public void resetKeywords()
    {
        this.keywords = null;
    }

    public void setKeywords(java.lang.String keywords)
    {
        this.keywords = keywords;
    }

    /**
     * 
     */
    public java.lang.String getKeywords()
    {
        return this.keywords;
    }
    
    public java.lang.Object[] getKeywordsBackingList()
    {
        java.lang.Object[] values = this.keywordsValueList;
        java.lang.Object[] labels = this.keywordsLabelList;

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

    public java.lang.Object[] getKeywordsValueList()
    {
        return this.keywordsValueList;
    }

    public void setKeywordsValueList(java.lang.Object[] keywordsValueList)
    {
        this.keywordsValueList = keywordsValueList;
    }

    public java.lang.Object[] getKeywordsLabelList()
    {
        return this.keywordsLabelList;
    }

    public void setKeywordsLabelList(java.lang.Object[] keywordsLabelList)
    {
        this.keywordsLabelList = keywordsLabelList;
    }

    public void setKeywordsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AgregaSliderFormImpl.setKeywordsBackingList requires non-null property arguments");
        }

        this.keywordsValueList = null;
        this.keywordsLabelList = null;

        if (items != null)
        {
            this.keywordsValueList = new java.lang.Object[items.size()];
            this.keywordsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.keywordsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.keywordsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AgregaSliderFormImpl.setKeywordsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomasCombo</code>.
     */
    public void resetIdiomasCombo()
    {
        this.idiomasCombo = null;
    }

    public void setIdiomasCombo(java.lang.String idiomasCombo)
    {
        this.idiomasCombo = idiomasCombo;
    }

    /**
     * 
     */
    public java.lang.String getIdiomasCombo()
    {
        return this.idiomasCombo;
    }
    
    public java.lang.Object[] getIdiomasComboBackingList()
    {
        java.lang.Object[] values = this.idiomasComboValueList;
        java.lang.Object[] labels = this.idiomasComboLabelList;

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

    public java.lang.Object[] getIdiomasComboValueList()
    {
        return this.idiomasComboValueList;
    }

    public void setIdiomasComboValueList(java.lang.Object[] idiomasComboValueList)
    {
        this.idiomasComboValueList = idiomasComboValueList;
    }

    public java.lang.Object[] getIdiomasComboLabelList()
    {
        return this.idiomasComboLabelList;
    }

    public void setIdiomasComboLabelList(java.lang.Object[] idiomasComboLabelList)
    {
        this.idiomasComboLabelList = idiomasComboLabelList;
    }

    public void setIdiomasComboBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AgregaSliderFormImpl.setIdiomasComboBackingList requires non-null property arguments");
        }

        this.idiomasComboValueList = null;
        this.idiomasComboLabelList = null;

        if (items != null)
        {
            this.idiomasComboValueList = new java.lang.Object[items.size()];
            this.idiomasComboLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomasComboValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomasComboLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AgregaSliderFormImpl.setIdiomasComboBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.idiomasCombo = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("keywords", this.keywords);
        builder.append("idiomasCombo", this.idiomasCombo);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.keywords = null;
        this.keywordsValueList = null;
        this.keywordsLabelList = null;
        this.idiomasCombo = null;
        this.idiomasComboValueList = null;
        this.idiomasComboLabelList = null;
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
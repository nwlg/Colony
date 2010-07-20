// license-header java merge-point
package es.pode.buscador.presentacion.basico.anadirCarpetaPersonal;

public class MostrarResultadoResultadoFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
    private java.lang.String idiomaODE;
    private java.lang.Object[] idiomaODEValueList;
    private java.lang.Object[] idiomaODELabelList;
    private java.lang.String identificadorODE;
    private java.lang.Object[] identificadorODEValueList;
    private java.lang.Object[] identificadorODELabelList;

    public MostrarResultadoResultadoFormImpl()
    {
    }

    /**
     * Resets the given <code>idiomaODE</code>.
     */
    public void resetIdiomaODE()
    {
        this.idiomaODE = null;
    }

    public void setIdiomaODE(java.lang.String idiomaODE)
    {
        this.idiomaODE = idiomaODE;
    }

    /**
     * 
     */
    public java.lang.String getIdiomaODE()
    {
        return this.idiomaODE;
    }
    
    public java.lang.Object[] getIdiomaODEBackingList()
    {
        java.lang.Object[] values = this.idiomaODEValueList;
        java.lang.Object[] labels = this.idiomaODELabelList;

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

    public java.lang.Object[] getIdiomaODEValueList()
    {
        return this.idiomaODEValueList;
    }

    public void setIdiomaODEValueList(java.lang.Object[] idiomaODEValueList)
    {
        this.idiomaODEValueList = idiomaODEValueList;
    }

    public java.lang.Object[] getIdiomaODELabelList()
    {
        return this.idiomaODELabelList;
    }

    public void setIdiomaODELabelList(java.lang.Object[] idiomaODELabelList)
    {
        this.idiomaODELabelList = idiomaODELabelList;
    }

    public void setIdiomaODEBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadoResultadoFormImpl.setIdiomaODEBackingList requires non-null property arguments");
        }

        this.idiomaODEValueList = null;
        this.idiomaODELabelList = null;

        if (items != null)
        {
            this.idiomaODEValueList = new java.lang.Object[items.size()];
            this.idiomaODELabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomaODEValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomaODELabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadoResultadoFormImpl.setIdiomaODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificadorODE</code>.
     */
    public void resetIdentificadorODE()
    {
        this.identificadorODE = null;
    }

    public void setIdentificadorODE(java.lang.String identificadorODE)
    {
        this.identificadorODE = identificadorODE;
    }

    /**
     * 
     */
    public java.lang.String getIdentificadorODE()
    {
        return this.identificadorODE;
    }
    
    public java.lang.Object[] getIdentificadorODEBackingList()
    {
        java.lang.Object[] values = this.identificadorODEValueList;
        java.lang.Object[] labels = this.identificadorODELabelList;

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

    public java.lang.Object[] getIdentificadorODEValueList()
    {
        return this.identificadorODEValueList;
    }

    public void setIdentificadorODEValueList(java.lang.Object[] identificadorODEValueList)
    {
        this.identificadorODEValueList = identificadorODEValueList;
    }

    public java.lang.Object[] getIdentificadorODELabelList()
    {
        return this.identificadorODELabelList;
    }

    public void setIdentificadorODELabelList(java.lang.Object[] identificadorODELabelList)
    {
        this.identificadorODELabelList = identificadorODELabelList;
    }

    public void setIdentificadorODEBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadoResultadoFormImpl.setIdentificadorODEBackingList requires non-null property arguments");
        }

        this.identificadorODEValueList = null;
        this.identificadorODELabelList = null;

        if (items != null)
        {
            this.identificadorODEValueList = new java.lang.Object[items.size()];
            this.identificadorODELabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadorODEValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadorODELabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadoResultadoFormImpl.setIdentificadorODEBackingList encountered an exception", ex);
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
        builder.append("idiomaODE", this.idiomaODE);
        builder.append("identificadorODE", this.identificadorODE);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.idiomaODE = null;
        this.idiomaODEValueList = null;
        this.idiomaODELabelList = null;
        this.identificadorODE = null;
        this.identificadorODEValueList = null;
        this.identificadorODELabelList = null;
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
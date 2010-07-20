// license-header java merge-point
package es.pode.visualizador.presentacion.informes;

public class InformesFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.visualizador.presentacion.informes.ListarInformesForm
{
    private java.util.Collection informes = null;
    private java.lang.Object[] informesValueList;
    private java.lang.Object[] informesLabelList;
    private java.lang.String pathInformes;
    private java.lang.Object[] pathInformesValueList;
    private java.lang.Object[] pathInformesLabelList;

    public InformesFormImpl()
    {
    }

    /**
     * Resets the given <code>informes</code>.
     */
    public void resetInformes()
    {
        this.informes = null;
    }

    public void setInformes(java.util.Collection informes)
    {
        this.informes = informes;
    }

    /**
     * 
     */
    public java.util.Collection getInformes()
    {
        return this.informes;
    }

    public void setInformesAsArray(Object[] informes)
    {
        this.informes = (informes == null) ? null : java.util.Arrays.asList(informes);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.visualizador.presentacion.informes.InformesFormImpl#getInformes
     */
    public java.lang.Object[] getInformesAsArray()
    {
        return (informes == null) ? null : informes.toArray();
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
            throw new IllegalArgumentException("InformesFormImpl.setInformesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("InformesFormImpl.setInformesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>pathInformes</code>.
     */
    public void resetPathInformes()
    {
        this.pathInformes = null;
    }

    public void setPathInformes(java.lang.String pathInformes)
    {
        this.pathInformes = pathInformes;
    }

    /**
     * 
     */
    public java.lang.String getPathInformes()
    {
        return this.pathInformes;
    }
    
    public java.lang.Object[] getPathInformesBackingList()
    {
        java.lang.Object[] values = this.pathInformesValueList;
        java.lang.Object[] labels = this.pathInformesLabelList;

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

    public java.lang.Object[] getPathInformesValueList()
    {
        return this.pathInformesValueList;
    }

    public void setPathInformesValueList(java.lang.Object[] pathInformesValueList)
    {
        this.pathInformesValueList = pathInformesValueList;
    }

    public java.lang.Object[] getPathInformesLabelList()
    {
        return this.pathInformesLabelList;
    }

    public void setPathInformesLabelList(java.lang.Object[] pathInformesLabelList)
    {
        this.pathInformesLabelList = pathInformesLabelList;
    }

    public void setPathInformesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("InformesFormImpl.setPathInformesBackingList requires non-null property arguments");
        }

        this.pathInformesValueList = null;
        this.pathInformesLabelList = null;

        if (items != null)
        {
            this.pathInformesValueList = new java.lang.Object[items.size()];
            this.pathInformesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.pathInformesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.pathInformesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("InformesFormImpl.setPathInformesBackingList encountered an exception", ex);
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
        builder.append("informes", this.informes);
        builder.append("pathInformes", this.pathInformes);
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
        this.pathInformes = null;
        this.pathInformesValueList = null;
        this.pathInformesLabelList = null;
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
// license-header java merge-point
package es.pode.administracion.presentacion.informes.listarInformesFederados;

public class ListarInformesFederadosFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.informes.listarInformesFederados.ListarInformesFederadosForm
{
    private java.util.List nombreRowSelection = null;
    private java.lang.Object[] nombreValueList;
    private java.lang.Object[] nombreLabelList;
    private java.util.Collection informes = null;
    private java.lang.Object[] informesValueList;
    private java.lang.Object[] informesLabelList;

    public ListarInformesFederadosFormImpl()
    {
    }

    /**
     * Resets the given <code>nombreRowSelection</code>.
     */
    public void resetNombre()
    {
        this.nombreRowSelection = null;
    }

    public void setNombreRowSelection(java.util.List nombreRowSelection)
    {
        this.nombreRowSelection = nombreRowSelection;
    }

    public java.util.List getNombreRowSelection()
    {
        return this.nombreRowSelection;
    }

    public void setNombreRowSelectionAsArray(java.lang.String[] nombreRowSelection)
    {
        this.nombreRowSelection = (nombreRowSelection == null) ? null : java.util.Arrays.asList(nombreRowSelection);
    }

    public java.lang.String[] getNombreRowSelectionAsArray()
    {
        return (nombreRowSelection == null) ? null : (java.lang.String[])nombreRowSelection.toArray(new java.lang.String[nombreRowSelection.size()]);
    }

    public java.lang.Object[] getNombreBackingList()
    {
        java.lang.Object[] values = this.nombreValueList;
        java.lang.Object[] labels = this.nombreLabelList;

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

    public java.lang.Object[] getNombreValueList()
    {
        return this.nombreValueList;
    }

    public void setNombreValueList(java.lang.Object[] nombreValueList)
    {
        this.nombreValueList = nombreValueList;
    }

    public java.lang.Object[] getNombreLabelList()
    {
        return this.nombreLabelList;
    }

    public void setNombreLabelList(java.lang.Object[] nombreLabelList)
    {
        this.nombreLabelList = nombreLabelList;
    }

    public void setNombreBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListarInformesFederadosFormImpl.setNombreBackingList requires non-null property arguments");
        }

        this.nombreValueList = null;
        this.nombreLabelList = null;

        if (items != null)
        {
            this.nombreValueList = new java.lang.Object[items.size()];
            this.nombreLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nombreValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nombreLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListarInformesFederadosFormImpl.setNombreBackingList encountered an exception", ex);
            }
        }
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
     * @see es.pode.administracion.presentacion.informes.listarInformesFederados.ListarInformesFederadosFormImpl#getInformes
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
            throw new IllegalArgumentException("ListarInformesFederadosFormImpl.setInformesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarInformesFederadosFormImpl.setInformesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.nombreRowSelection = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("nombreRowSelection", this.nombreRowSelection);
        builder.append("informes", this.informes);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.nombreRowSelection = null;
        this.informes = null;
        this.informesValueList = null;
        this.informesLabelList = null;
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
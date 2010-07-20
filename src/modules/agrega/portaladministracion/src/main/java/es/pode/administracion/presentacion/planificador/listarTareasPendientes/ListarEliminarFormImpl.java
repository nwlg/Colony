// license-header java merge-point
package es.pode.administracion.presentacion.planificador.listarTareasPendientes;

public class ListarEliminarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.planificador.listarTareasPendientes.ObtenerNombresTrabajosForm
{
    private java.util.List trabajoRowSelection = null;
    private java.lang.Object[] trabajoValueList;
    private java.lang.Object[] trabajoLabelList;
    private java.util.Collection trabajos;
    private java.lang.Object[] trabajosValueList;
    private java.lang.Object[] trabajosLabelList;

    public ListarEliminarFormImpl()
    {
    }

    /**
     * Resets the given <code>trabajoRowSelection</code>.
     */
    public void resetTrabajo()
    {
        this.trabajoRowSelection = null;
    }

    public void setTrabajoRowSelection(java.util.List trabajoRowSelection)
    {
        this.trabajoRowSelection = trabajoRowSelection;
    }

    public java.util.List getTrabajoRowSelection()
    {
        return this.trabajoRowSelection;
    }

    public void setTrabajoRowSelectionAsArray(java.lang.String[] trabajoRowSelection)
    {
        this.trabajoRowSelection = (trabajoRowSelection == null) ? null : java.util.Arrays.asList(trabajoRowSelection);
    }

    public java.lang.String[] getTrabajoRowSelectionAsArray()
    {
        return (trabajoRowSelection == null) ? null : (java.lang.String[])trabajoRowSelection.toArray(new java.lang.String[trabajoRowSelection.size()]);
    }

    public java.lang.Object[] getTrabajoBackingList()
    {
        java.lang.Object[] values = this.trabajoValueList;
        java.lang.Object[] labels = this.trabajoLabelList;

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

    public java.lang.Object[] getTrabajoValueList()
    {
        return this.trabajoValueList;
    }

    public void setTrabajoValueList(java.lang.Object[] trabajoValueList)
    {
        this.trabajoValueList = trabajoValueList;
    }

    public java.lang.Object[] getTrabajoLabelList()
    {
        return this.trabajoLabelList;
    }

    public void setTrabajoLabelList(java.lang.Object[] trabajoLabelList)
    {
        this.trabajoLabelList = trabajoLabelList;
    }

    public void setTrabajoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListarEliminarFormImpl.setTrabajoBackingList requires non-null property arguments");
        }

        this.trabajoValueList = null;
        this.trabajoLabelList = null;

        if (items != null)
        {
            this.trabajoValueList = new java.lang.Object[items.size()];
            this.trabajoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.trabajoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.trabajoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListarEliminarFormImpl.setTrabajoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>trabajos</code>.
     */
    public void resetTrabajos()
    {
        this.trabajos = null;
    }

    public void setTrabajos(java.util.Collection trabajos)
    {
        this.trabajos = trabajos;
    }

    /**
     * 
     */
    public java.util.Collection getTrabajos()
    {
        return this.trabajos;
    }

    public void setTrabajosAsArray(Object[] trabajos)
    {
        this.trabajos = (trabajos == null) ? null : java.util.Arrays.asList(trabajos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.planificador.listarTareasPendientes.ListarEliminarFormImpl#getTrabajos
     */
    public java.lang.Object[] getTrabajosAsArray()
    {
        return (trabajos == null) ? null : trabajos.toArray();
    }
    
    public java.lang.Object[] getTrabajosBackingList()
    {
        java.lang.Object[] values = this.trabajosValueList;
        java.lang.Object[] labels = this.trabajosLabelList;

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

    public java.lang.Object[] getTrabajosValueList()
    {
        return this.trabajosValueList;
    }

    public void setTrabajosValueList(java.lang.Object[] trabajosValueList)
    {
        this.trabajosValueList = trabajosValueList;
    }

    public java.lang.Object[] getTrabajosLabelList()
    {
        return this.trabajosLabelList;
    }

    public void setTrabajosLabelList(java.lang.Object[] trabajosLabelList)
    {
        this.trabajosLabelList = trabajosLabelList;
    }

    public void setTrabajosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListarEliminarFormImpl.setTrabajosBackingList requires non-null property arguments");
        }

        this.trabajosValueList = null;
        this.trabajosLabelList = null;

        if (items != null)
        {
            this.trabajosValueList = new java.lang.Object[items.size()];
            this.trabajosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.trabajosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.trabajosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListarEliminarFormImpl.setTrabajosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.trabajoRowSelection = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("trabajoRowSelection", this.trabajoRowSelection);
        builder.append("trabajos", this.trabajos);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.trabajoRowSelection = null;
        this.trabajos = null;
        this.trabajosValueList = null;
        this.trabajosLabelList = null;
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
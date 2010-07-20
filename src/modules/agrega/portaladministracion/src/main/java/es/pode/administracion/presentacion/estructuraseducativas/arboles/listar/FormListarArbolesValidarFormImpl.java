// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.arboles.listar;

public class FormListarArbolesValidarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.estructuraseducativas.arboles.listar.ValidarSeleccionadosForm
{
    private java.util.List seleccionadoRowSelection = null;
    private java.lang.Object[] seleccionadoValueList;
    private java.lang.Object[] seleccionadoLabelList;

    public FormListarArbolesValidarFormImpl()
    {
    }

    /**
     * Resets the given <code>seleccionadoRowSelection</code>.
     */
    public void resetSeleccionado()
    {
        this.seleccionadoRowSelection = null;
    }

    public void setSeleccionadoRowSelection(java.util.List seleccionadoRowSelection)
    {
        this.seleccionadoRowSelection = seleccionadoRowSelection;
    }

    public java.util.List getSeleccionadoRowSelection()
    {
        return this.seleccionadoRowSelection;
    }

    public void setSeleccionadoRowSelectionAsArray(java.lang.String[] seleccionadoRowSelection)
    {
        this.seleccionadoRowSelection = (seleccionadoRowSelection == null) ? null : java.util.Arrays.asList(seleccionadoRowSelection);
    }

    public java.lang.String[] getSeleccionadoRowSelectionAsArray()
    {
        return (seleccionadoRowSelection == null) ? null : (java.lang.String[])seleccionadoRowSelection.toArray(new java.lang.String[seleccionadoRowSelection.size()]);
    }

    public java.lang.Object[] getSeleccionadoBackingList()
    {
        java.lang.Object[] values = this.seleccionadoValueList;
        java.lang.Object[] labels = this.seleccionadoLabelList;

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

    public java.lang.Object[] getSeleccionadoValueList()
    {
        return this.seleccionadoValueList;
    }

    public void setSeleccionadoValueList(java.lang.Object[] seleccionadoValueList)
    {
        this.seleccionadoValueList = seleccionadoValueList;
    }

    public java.lang.Object[] getSeleccionadoLabelList()
    {
        return this.seleccionadoLabelList;
    }

    public void setSeleccionadoLabelList(java.lang.Object[] seleccionadoLabelList)
    {
        this.seleccionadoLabelList = seleccionadoLabelList;
    }

    public void setSeleccionadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormListarArbolesValidarFormImpl.setSeleccionadoBackingList requires non-null property arguments");
        }

        this.seleccionadoValueList = null;
        this.seleccionadoLabelList = null;

        if (items != null)
        {
            this.seleccionadoValueList = new java.lang.Object[items.size()];
            this.seleccionadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.seleccionadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.seleccionadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormListarArbolesValidarFormImpl.setSeleccionadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.seleccionadoRowSelection = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("seleccionadoRowSelection", this.seleccionadoRowSelection);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.seleccionadoRowSelection = null;
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
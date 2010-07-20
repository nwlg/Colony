// license-header java merge-point
package es.pode.administracion.presentacion.categoriasFaqs.eliminarCategoriaFaq;

public class ConfirmarBajaAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.categoriasFaqs.eliminarCategoriaFaq.EliminarCategoriaFaqForm
{
    private java.lang.String listaIds;
    private java.lang.Object[] listaIdsValueList;
    private java.lang.Object[] listaIdsLabelList;
    private java.util.Collection categoriasBorradas;
    private java.lang.Object[] categoriasBorradasValueList;
    private java.lang.Object[] categoriasBorradasLabelList;

    public ConfirmarBajaAceptarFormImpl()
    {
    }

    /**
     * Resets the given <code>listaIds</code>.
     */
    public void resetListaIds()
    {
        this.listaIds = null;
    }

    public void setListaIds(java.lang.String listaIds)
    {
        this.listaIds = listaIds;
    }

    /**
     * 
     */
    public java.lang.String getListaIds()
    {
        return this.listaIds;
    }
    
    public java.lang.Object[] getListaIdsBackingList()
    {
        java.lang.Object[] values = this.listaIdsValueList;
        java.lang.Object[] labels = this.listaIdsLabelList;

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

    public java.lang.Object[] getListaIdsValueList()
    {
        return this.listaIdsValueList;
    }

    public void setListaIdsValueList(java.lang.Object[] listaIdsValueList)
    {
        this.listaIdsValueList = listaIdsValueList;
    }

    public java.lang.Object[] getListaIdsLabelList()
    {
        return this.listaIdsLabelList;
    }

    public void setListaIdsLabelList(java.lang.Object[] listaIdsLabelList)
    {
        this.listaIdsLabelList = listaIdsLabelList;
    }

    public void setListaIdsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmarBajaAceptarFormImpl.setListaIdsBackingList requires non-null property arguments");
        }

        this.listaIdsValueList = null;
        this.listaIdsLabelList = null;

        if (items != null)
        {
            this.listaIdsValueList = new java.lang.Object[items.size()];
            this.listaIdsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listaIdsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listaIdsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmarBajaAceptarFormImpl.setListaIdsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>categoriasBorradas</code>.
     */
    public void resetCategoriasBorradas()
    {
        this.categoriasBorradas = null;
    }

    public void setCategoriasBorradas(java.util.Collection categoriasBorradas)
    {
        this.categoriasBorradas = categoriasBorradas;
    }

    /**
     * 
     */
    public java.util.Collection getCategoriasBorradas()
    {
        return this.categoriasBorradas;
    }

    public void setCategoriasBorradasAsArray(Object[] categoriasBorradas)
    {
        this.categoriasBorradas = (categoriasBorradas == null) ? null : java.util.Arrays.asList(categoriasBorradas);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.categoriasFaqs.eliminarCategoriaFaq.ConfirmarBajaAceptarFormImpl#getCategoriasBorradas
     */
    public java.lang.Object[] getCategoriasBorradasAsArray()
    {
        return (categoriasBorradas == null) ? null : categoriasBorradas.toArray();
    }
    
    public java.lang.Object[] getCategoriasBorradasBackingList()
    {
        java.lang.Object[] values = this.categoriasBorradasValueList;
        java.lang.Object[] labels = this.categoriasBorradasLabelList;

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

    public java.lang.Object[] getCategoriasBorradasValueList()
    {
        return this.categoriasBorradasValueList;
    }

    public void setCategoriasBorradasValueList(java.lang.Object[] categoriasBorradasValueList)
    {
        this.categoriasBorradasValueList = categoriasBorradasValueList;
    }

    public java.lang.Object[] getCategoriasBorradasLabelList()
    {
        return this.categoriasBorradasLabelList;
    }

    public void setCategoriasBorradasLabelList(java.lang.Object[] categoriasBorradasLabelList)
    {
        this.categoriasBorradasLabelList = categoriasBorradasLabelList;
    }

    public void setCategoriasBorradasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmarBajaAceptarFormImpl.setCategoriasBorradasBackingList requires non-null property arguments");
        }

        this.categoriasBorradasValueList = null;
        this.categoriasBorradasLabelList = null;

        if (items != null)
        {
            this.categoriasBorradasValueList = new java.lang.Object[items.size()];
            this.categoriasBorradasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.categoriasBorradasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.categoriasBorradasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmarBajaAceptarFormImpl.setCategoriasBorradasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.categoriasBorradas = null;
        this.categoriasBorradasValueList = new java.lang.Object[0];
        this.categoriasBorradasLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("listaIds", this.listaIds);
        builder.append("categoriasBorradas", this.categoriasBorradas);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.listaIds = null;
        this.listaIdsValueList = null;
        this.listaIdsLabelList = null;
        this.categoriasBorradas = null;
        this.categoriasBorradasValueList = null;
        this.categoriasBorradasLabelList = null;
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
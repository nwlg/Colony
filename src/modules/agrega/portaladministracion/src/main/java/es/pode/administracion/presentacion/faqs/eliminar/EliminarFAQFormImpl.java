// license-header java merge-point
package es.pode.administracion.presentacion.faqs.eliminar;

public class EliminarFAQFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.faqs.eliminar.ObtenerIdiomasForm
        , es.pode.administracion.presentacion.faqs.eliminar.ValidarSeleccionForm
{
    private java.lang.String listaIds;
    private java.lang.Object[] listaIdsValueList;
    private java.lang.Object[] listaIdsLabelList;
    private java.util.Collection ids;
    private java.lang.Object[] idsValueList;
    private java.lang.Object[] idsLabelList;
    private java.util.Collection faqs;
    private java.lang.Object[] faqsValueList;
    private java.lang.Object[] faqsLabelList;
    private java.lang.String seleccionado;
    private java.lang.Object[] seleccionadoValueList;
    private java.lang.Object[] seleccionadoLabelList;
    private java.util.Collection faqsDeleted;
    private java.lang.Object[] faqsDeletedValueList;
    private java.lang.Object[] faqsDeletedLabelList;

    public EliminarFAQFormImpl()
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
            throw new IllegalArgumentException("EliminarFAQFormImpl.setListaIdsBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EliminarFAQFormImpl.setListaIdsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ids</code>.
     */
    public void resetIds()
    {
        this.ids = null;
    }

    public void setIds(java.util.Collection ids)
    {
        this.ids = ids;
    }

    /**
     * 
     */
    public java.util.Collection getIds()
    {
        return this.ids;
    }

    public void setIdsAsArray(Object[] ids)
    {
        this.ids = (ids == null) ? null : java.util.Arrays.asList(ids);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.faqs.eliminar.EliminarFAQFormImpl#getIds
     */
    public java.lang.Object[] getIdsAsArray()
    {
        return (ids == null) ? null : ids.toArray();
    }
    
    public java.lang.Object[] getIdsBackingList()
    {
        java.lang.Object[] values = this.idsValueList;
        java.lang.Object[] labels = this.idsLabelList;

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

    public java.lang.Object[] getIdsValueList()
    {
        return this.idsValueList;
    }

    public void setIdsValueList(java.lang.Object[] idsValueList)
    {
        this.idsValueList = idsValueList;
    }

    public java.lang.Object[] getIdsLabelList()
    {
        return this.idsLabelList;
    }

    public void setIdsLabelList(java.lang.Object[] idsLabelList)
    {
        this.idsLabelList = idsLabelList;
    }

    public void setIdsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarFAQFormImpl.setIdsBackingList requires non-null property arguments");
        }

        this.idsValueList = null;
        this.idsLabelList = null;

        if (items != null)
        {
            this.idsValueList = new java.lang.Object[items.size()];
            this.idsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarFAQFormImpl.setIdsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>faqs</code>.
     */
    public void resetFaqs()
    {
        this.faqs = null;
    }

    public void setFaqs(java.util.Collection faqs)
    {
        this.faqs = faqs;
    }

    /**
     * 
     */
    public java.util.Collection getFaqs()
    {
        return this.faqs;
    }

    public void setFaqsAsArray(Object[] faqs)
    {
        this.faqs = (faqs == null) ? null : java.util.Arrays.asList(faqs);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.faqs.eliminar.EliminarFAQFormImpl#getFaqs
     */
    public java.lang.Object[] getFaqsAsArray()
    {
        return (faqs == null) ? null : faqs.toArray();
    }
    
    public java.lang.Object[] getFaqsBackingList()
    {
        java.lang.Object[] values = this.faqsValueList;
        java.lang.Object[] labels = this.faqsLabelList;

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

    public java.lang.Object[] getFaqsValueList()
    {
        return this.faqsValueList;
    }

    public void setFaqsValueList(java.lang.Object[] faqsValueList)
    {
        this.faqsValueList = faqsValueList;
    }

    public java.lang.Object[] getFaqsLabelList()
    {
        return this.faqsLabelList;
    }

    public void setFaqsLabelList(java.lang.Object[] faqsLabelList)
    {
        this.faqsLabelList = faqsLabelList;
    }

    public void setFaqsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarFAQFormImpl.setFaqsBackingList requires non-null property arguments");
        }

        this.faqsValueList = null;
        this.faqsLabelList = null;

        if (items != null)
        {
            this.faqsValueList = new java.lang.Object[items.size()];
            this.faqsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.faqsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.faqsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarFAQFormImpl.setFaqsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>seleccionado</code>.
     */
    public void resetSeleccionado()
    {
        this.seleccionado = null;
    }

    public void setSeleccionado(java.lang.String seleccionado)
    {
        this.seleccionado = seleccionado;
    }

    /**
     * 
     */
    public java.lang.String getSeleccionado()
    {
        return this.seleccionado;
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
            throw new IllegalArgumentException("EliminarFAQFormImpl.setSeleccionadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EliminarFAQFormImpl.setSeleccionadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>faqsDeleted</code>.
     */
    public void resetFaqsDeleted()
    {
        this.faqsDeleted = null;
    }

    public void setFaqsDeleted(java.util.Collection faqsDeleted)
    {
        this.faqsDeleted = faqsDeleted;
    }

    /**
     * 
     */
    public java.util.Collection getFaqsDeleted()
    {
        return this.faqsDeleted;
    }

    public void setFaqsDeletedAsArray(Object[] faqsDeleted)
    {
        this.faqsDeleted = (faqsDeleted == null) ? null : java.util.Arrays.asList(faqsDeleted);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.faqs.eliminar.EliminarFAQFormImpl#getFaqsDeleted
     */
    public java.lang.Object[] getFaqsDeletedAsArray()
    {
        return (faqsDeleted == null) ? null : faqsDeleted.toArray();
    }
    
    public java.lang.Object[] getFaqsDeletedBackingList()
    {
        java.lang.Object[] values = this.faqsDeletedValueList;
        java.lang.Object[] labels = this.faqsDeletedLabelList;

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

    public java.lang.Object[] getFaqsDeletedValueList()
    {
        return this.faqsDeletedValueList;
    }

    public void setFaqsDeletedValueList(java.lang.Object[] faqsDeletedValueList)
    {
        this.faqsDeletedValueList = faqsDeletedValueList;
    }

    public java.lang.Object[] getFaqsDeletedLabelList()
    {
        return this.faqsDeletedLabelList;
    }

    public void setFaqsDeletedLabelList(java.lang.Object[] faqsDeletedLabelList)
    {
        this.faqsDeletedLabelList = faqsDeletedLabelList;
    }

    public void setFaqsDeletedBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarFAQFormImpl.setFaqsDeletedBackingList requires non-null property arguments");
        }

        this.faqsDeletedValueList = null;
        this.faqsDeletedLabelList = null;

        if (items != null)
        {
            this.faqsDeletedValueList = new java.lang.Object[items.size()];
            this.faqsDeletedLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.faqsDeletedValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.faqsDeletedLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarFAQFormImpl.setFaqsDeletedBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.faqsDeleted = null;
        this.faqsDeletedValueList = new java.lang.Object[0];
        this.faqsDeletedLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("listaIds", this.listaIds);
        builder.append("ids", this.ids);
        builder.append("faqs", this.faqs);
        builder.append("seleccionado", this.seleccionado);
        builder.append("faqsDeleted", this.faqsDeleted);
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
        this.ids = null;
        this.idsValueList = null;
        this.idsLabelList = null;
        this.faqs = null;
        this.faqsValueList = null;
        this.faqsLabelList = null;
        this.seleccionado = null;
        this.seleccionadoValueList = null;
        this.seleccionadoLabelList = null;
        this.faqsDeleted = null;
        this.faqsDeletedValueList = null;
        this.faqsDeletedLabelList = null;
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
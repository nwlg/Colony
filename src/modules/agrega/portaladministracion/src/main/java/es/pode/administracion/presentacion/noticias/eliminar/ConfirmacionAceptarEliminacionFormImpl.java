// license-header java merge-point
package es.pode.administracion.presentacion.noticias.eliminar;

public class ConfirmacionAceptarEliminacionFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.noticias.eliminar.EliminarForm
{
    private java.lang.String listaIds;
    private java.lang.Object[] listaIdsValueList;
    private java.lang.Object[] listaIdsLabelList;
    private java.util.Collection noticiasDeleted;
    private java.lang.Object[] noticiasDeletedValueList;
    private java.lang.Object[] noticiasDeletedLabelList;

    public ConfirmacionAceptarEliminacionFormImpl()
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
            throw new IllegalArgumentException("ConfirmacionAceptarEliminacionFormImpl.setListaIdsBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ConfirmacionAceptarEliminacionFormImpl.setListaIdsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>noticiasDeleted</code>.
     */
    public void resetNoticiasDeleted()
    {
        this.noticiasDeleted = null;
    }

    public void setNoticiasDeleted(java.util.Collection noticiasDeleted)
    {
        this.noticiasDeleted = noticiasDeleted;
    }

    /**
     * 
     */
    public java.util.Collection getNoticiasDeleted()
    {
        return this.noticiasDeleted;
    }

    public void setNoticiasDeletedAsArray(Object[] noticiasDeleted)
    {
        this.noticiasDeleted = (noticiasDeleted == null) ? null : java.util.Arrays.asList(noticiasDeleted);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.noticias.eliminar.ConfirmacionAceptarEliminacionFormImpl#getNoticiasDeleted
     */
    public java.lang.Object[] getNoticiasDeletedAsArray()
    {
        return (noticiasDeleted == null) ? null : noticiasDeleted.toArray();
    }
    
    public java.lang.Object[] getNoticiasDeletedBackingList()
    {
        java.lang.Object[] values = this.noticiasDeletedValueList;
        java.lang.Object[] labels = this.noticiasDeletedLabelList;

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

    public java.lang.Object[] getNoticiasDeletedValueList()
    {
        return this.noticiasDeletedValueList;
    }

    public void setNoticiasDeletedValueList(java.lang.Object[] noticiasDeletedValueList)
    {
        this.noticiasDeletedValueList = noticiasDeletedValueList;
    }

    public java.lang.Object[] getNoticiasDeletedLabelList()
    {
        return this.noticiasDeletedLabelList;
    }

    public void setNoticiasDeletedLabelList(java.lang.Object[] noticiasDeletedLabelList)
    {
        this.noticiasDeletedLabelList = noticiasDeletedLabelList;
    }

    public void setNoticiasDeletedBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionAceptarEliminacionFormImpl.setNoticiasDeletedBackingList requires non-null property arguments");
        }

        this.noticiasDeletedValueList = null;
        this.noticiasDeletedLabelList = null;

        if (items != null)
        {
            this.noticiasDeletedValueList = new java.lang.Object[items.size()];
            this.noticiasDeletedLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.noticiasDeletedValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.noticiasDeletedLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionAceptarEliminacionFormImpl.setNoticiasDeletedBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.noticiasDeleted = null;
        this.noticiasDeletedValueList = new java.lang.Object[0];
        this.noticiasDeletedLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("listaIds", this.listaIds);
        builder.append("noticiasDeleted", this.noticiasDeleted);
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
        this.noticiasDeleted = null;
        this.noticiasDeletedValueList = null;
        this.noticiasDeletedLabelList = null;
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
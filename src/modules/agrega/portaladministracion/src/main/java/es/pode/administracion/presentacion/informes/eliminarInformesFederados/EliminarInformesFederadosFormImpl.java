// license-header java merge-point
package es.pode.administracion.presentacion.informes.eliminarInformesFederados;

public class EliminarInformesFederadosFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.informes.eliminarInformesFederados.ObtenerInformeFederadoForm
{
    private java.lang.String[] informes;
    private java.lang.Object[] informesValueList;
    private java.lang.Object[] informesLabelList;
    private java.lang.String listaId;
    private java.lang.Object[] listaIdValueList;
    private java.lang.Object[] listaIdLabelList;
    private java.util.Collection ids;
    private java.lang.Object[] idsValueList;
    private java.lang.Object[] idsLabelList;

    public EliminarInformesFederadosFormImpl()
    {
    }

    /**
     * Resets the given <code>informes</code>.
     */
    public void resetInformes()
    {
        this.informes = null;
    }

    public void setInformes(java.lang.String[] informes)
    {
        this.informes = informes;
    }

    /**
     * 
     */
    public java.lang.String[] getInformes()
    {
        return this.informes;
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
            throw new IllegalArgumentException("EliminarInformesFederadosFormImpl.setInformesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EliminarInformesFederadosFormImpl.setInformesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listaId</code>.
     */
    public void resetListaId()
    {
        this.listaId = null;
    }

    public void setListaId(java.lang.String listaId)
    {
        this.listaId = listaId;
    }

    /**
     * 
     */
    public java.lang.String getListaId()
    {
        return this.listaId;
    }
    
    public java.lang.Object[] getListaIdBackingList()
    {
        java.lang.Object[] values = this.listaIdValueList;
        java.lang.Object[] labels = this.listaIdLabelList;

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

    public java.lang.Object[] getListaIdValueList()
    {
        return this.listaIdValueList;
    }

    public void setListaIdValueList(java.lang.Object[] listaIdValueList)
    {
        this.listaIdValueList = listaIdValueList;
    }

    public java.lang.Object[] getListaIdLabelList()
    {
        return this.listaIdLabelList;
    }

    public void setListaIdLabelList(java.lang.Object[] listaIdLabelList)
    {
        this.listaIdLabelList = listaIdLabelList;
    }

    public void setListaIdBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarInformesFederadosFormImpl.setListaIdBackingList requires non-null property arguments");
        }

        this.listaIdValueList = null;
        this.listaIdLabelList = null;

        if (items != null)
        {
            this.listaIdValueList = new java.lang.Object[items.size()];
            this.listaIdLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listaIdValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listaIdLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarInformesFederadosFormImpl.setListaIdBackingList encountered an exception", ex);
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
     * @see es.pode.administracion.presentacion.informes.eliminarInformesFederados.EliminarInformesFederadosFormImpl#getIds
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
            throw new IllegalArgumentException("EliminarInformesFederadosFormImpl.setIdsBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EliminarInformesFederadosFormImpl.setIdsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.informes = null;
        this.informesValueList = new java.lang.Object[0];
        this.informesLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("informes", this.informes);
        builder.append("listaId", this.listaId);
        builder.append("ids", this.ids);
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
        this.listaId = null;
        this.listaIdValueList = null;
        this.listaIdLabelList = null;
        this.ids = null;
        this.idsValueList = null;
        this.idsLabelList = null;
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
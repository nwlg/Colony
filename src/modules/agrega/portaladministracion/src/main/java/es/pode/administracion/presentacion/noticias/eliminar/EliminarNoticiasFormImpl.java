// license-header java merge-point
package es.pode.administracion.presentacion.noticias.eliminar;

public class EliminarNoticiasFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.noticias.eliminar.ObtenerIdiomasForm
        , es.pode.administracion.presentacion.noticias.eliminar.ValidarSeleccionForm
{
    private java.util.Collection noticias;
    private java.lang.Object[] noticiasValueList;
    private java.lang.Object[] noticiasLabelList;
    private java.lang.String listaIds;
    private java.lang.Object[] listaIdsValueList;
    private java.lang.Object[] listaIdsLabelList;
    private java.util.Collection ids;
    private java.lang.Object[] idsValueList;
    private java.lang.Object[] idsLabelList;
    private java.util.Collection noticiasDeleted;
    private java.lang.Object[] noticiasDeletedValueList;
    private java.lang.Object[] noticiasDeletedLabelList;
    private java.lang.String seleccionado;
    private java.lang.Object[] seleccionadoValueList;
    private java.lang.Object[] seleccionadoLabelList;

    public EliminarNoticiasFormImpl()
    {
    }

    /**
     * Resets the given <code>noticias</code>.
     */
    public void resetNoticias()
    {
        this.noticias = null;
    }

    public void setNoticias(java.util.Collection noticias)
    {
        this.noticias = noticias;
    }

    /**
     * 
     */
    public java.util.Collection getNoticias()
    {
        return this.noticias;
    }

    public void setNoticiasAsArray(Object[] noticias)
    {
        this.noticias = (noticias == null) ? null : java.util.Arrays.asList(noticias);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.noticias.eliminar.EliminarNoticiasFormImpl#getNoticias
     */
    public java.lang.Object[] getNoticiasAsArray()
    {
        return (noticias == null) ? null : noticias.toArray();
    }
    
    public java.lang.Object[] getNoticiasBackingList()
    {
        java.lang.Object[] values = this.noticiasValueList;
        java.lang.Object[] labels = this.noticiasLabelList;

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

    public java.lang.Object[] getNoticiasValueList()
    {
        return this.noticiasValueList;
    }

    public void setNoticiasValueList(java.lang.Object[] noticiasValueList)
    {
        this.noticiasValueList = noticiasValueList;
    }

    public java.lang.Object[] getNoticiasLabelList()
    {
        return this.noticiasLabelList;
    }

    public void setNoticiasLabelList(java.lang.Object[] noticiasLabelList)
    {
        this.noticiasLabelList = noticiasLabelList;
    }

    public void setNoticiasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarNoticiasFormImpl.setNoticiasBackingList requires non-null property arguments");
        }

        this.noticiasValueList = null;
        this.noticiasLabelList = null;

        if (items != null)
        {
            this.noticiasValueList = new java.lang.Object[items.size()];
            this.noticiasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.noticiasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.noticiasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarNoticiasFormImpl.setNoticiasBackingList encountered an exception", ex);
            }
        }
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
            throw new IllegalArgumentException("EliminarNoticiasFormImpl.setListaIdsBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EliminarNoticiasFormImpl.setListaIdsBackingList encountered an exception", ex);
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
     * @see es.pode.administracion.presentacion.noticias.eliminar.EliminarNoticiasFormImpl#getIds
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
            throw new IllegalArgumentException("EliminarNoticiasFormImpl.setIdsBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EliminarNoticiasFormImpl.setIdsBackingList encountered an exception", ex);
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
     * @see es.pode.administracion.presentacion.noticias.eliminar.EliminarNoticiasFormImpl#getNoticiasDeleted
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
            throw new IllegalArgumentException("EliminarNoticiasFormImpl.setNoticiasDeletedBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EliminarNoticiasFormImpl.setNoticiasDeletedBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("EliminarNoticiasFormImpl.setSeleccionadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EliminarNoticiasFormImpl.setSeleccionadoBackingList encountered an exception", ex);
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
        builder.append("noticias", this.noticias);
        builder.append("listaIds", this.listaIds);
        builder.append("ids", this.ids);
        builder.append("noticiasDeleted", this.noticiasDeleted);
        builder.append("seleccionado", this.seleccionado);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.noticias = null;
        this.noticiasValueList = null;
        this.noticiasLabelList = null;
        this.listaIds = null;
        this.listaIdsValueList = null;
        this.listaIdsLabelList = null;
        this.ids = null;
        this.idsValueList = null;
        this.idsLabelList = null;
        this.noticiasDeleted = null;
        this.noticiasDeletedValueList = null;
        this.noticiasDeletedLabelList = null;
        this.seleccionado = null;
        this.seleccionadoValueList = null;
        this.seleccionadoLabelList = null;
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
// license-header java merge-point
package es.pode.tagging.presentacion.listarAgregaTags;

public class ListarAgregaTagsFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.tagging.presentacion.listarAgregaTags.ObtenerAgregaTagsForm
{
    private java.util.Collection tags;
    private java.lang.Object[] tagsValueList;
    private java.lang.Object[] tagsLabelList;
    private java.lang.String tag;
    private java.lang.Object[] tagValueList;
    private java.lang.Object[] tagLabelList;
    private boolean esAnonimo;
    private java.lang.Object[] esAnonimoValueList;
    private java.lang.Object[] esAnonimoLabelList;
    private java.lang.String tipoLayoutBuscador;
    private java.lang.Object[] tipoLayoutBuscadorValueList;
    private java.lang.Object[] tipoLayoutBuscadorLabelList;

    public ListarAgregaTagsFormImpl()
    {
    }

    /**
     * Resets the given <code>tags</code>.
     */
    public void resetTags()
    {
        this.tags = null;
    }

    public void setTags(java.util.Collection tags)
    {
        this.tags = tags;
    }

    /**
     * 
     */
    public java.util.Collection getTags()
    {
        return this.tags;
    }

    public void setTagsAsArray(Object[] tags)
    {
        this.tags = (tags == null) ? null : java.util.Arrays.asList(tags);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.tagging.presentacion.listarAgregaTags.ListarAgregaTagsFormImpl#getTags
     */
    public java.lang.Object[] getTagsAsArray()
    {
        return (tags == null) ? null : tags.toArray();
    }
    
    public java.lang.Object[] getTagsBackingList()
    {
        java.lang.Object[] values = this.tagsValueList;
        java.lang.Object[] labels = this.tagsLabelList;

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

    public java.lang.Object[] getTagsValueList()
    {
        return this.tagsValueList;
    }

    public void setTagsValueList(java.lang.Object[] tagsValueList)
    {
        this.tagsValueList = tagsValueList;
    }

    public java.lang.Object[] getTagsLabelList()
    {
        return this.tagsLabelList;
    }

    public void setTagsLabelList(java.lang.Object[] tagsLabelList)
    {
        this.tagsLabelList = tagsLabelList;
    }

    public void setTagsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListarAgregaTagsFormImpl.setTagsBackingList requires non-null property arguments");
        }

        this.tagsValueList = null;
        this.tagsLabelList = null;

        if (items != null)
        {
            this.tagsValueList = new java.lang.Object[items.size()];
            this.tagsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tagsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tagsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListarAgregaTagsFormImpl.setTagsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tag</code>.
     */
    public void resetTag()
    {
        this.tag = null;
    }

    public void setTag(java.lang.String tag)
    {
        this.tag = tag;
    }

    /**
     * 
     */
    public java.lang.String getTag()
    {
        return this.tag;
    }
    
    public java.lang.Object[] getTagBackingList()
    {
        java.lang.Object[] values = this.tagValueList;
        java.lang.Object[] labels = this.tagLabelList;

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

    public java.lang.Object[] getTagValueList()
    {
        return this.tagValueList;
    }

    public void setTagValueList(java.lang.Object[] tagValueList)
    {
        this.tagValueList = tagValueList;
    }

    public java.lang.Object[] getTagLabelList()
    {
        return this.tagLabelList;
    }

    public void setTagLabelList(java.lang.Object[] tagLabelList)
    {
        this.tagLabelList = tagLabelList;
    }

    public void setTagBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListarAgregaTagsFormImpl.setTagBackingList requires non-null property arguments");
        }

        this.tagValueList = null;
        this.tagLabelList = null;

        if (items != null)
        {
            this.tagValueList = new java.lang.Object[items.size()];
            this.tagLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tagValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tagLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListarAgregaTagsFormImpl.setTagBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>esAnonimo</code>.
     */
    public void resetEsAnonimo()
    {
        this.esAnonimo = false;
    }

    public void setEsAnonimo(boolean esAnonimo)
    {
        this.esAnonimo = esAnonimo;
    }

    /**
     * 
     */
    public boolean isEsAnonimo()
    {
        return this.esAnonimo;
    }
    
    public java.lang.Object[] getEsAnonimoBackingList()
    {
        java.lang.Object[] values = this.esAnonimoValueList;
        java.lang.Object[] labels = this.esAnonimoLabelList;

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

    public java.lang.Object[] getEsAnonimoValueList()
    {
        return this.esAnonimoValueList;
    }

    public void setEsAnonimoValueList(java.lang.Object[] esAnonimoValueList)
    {
        this.esAnonimoValueList = esAnonimoValueList;
    }

    public java.lang.Object[] getEsAnonimoLabelList()
    {
        return this.esAnonimoLabelList;
    }

    public void setEsAnonimoLabelList(java.lang.Object[] esAnonimoLabelList)
    {
        this.esAnonimoLabelList = esAnonimoLabelList;
    }

    public void setEsAnonimoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListarAgregaTagsFormImpl.setEsAnonimoBackingList requires non-null property arguments");
        }

        this.esAnonimoValueList = null;
        this.esAnonimoLabelList = null;

        if (items != null)
        {
            this.esAnonimoValueList = new java.lang.Object[items.size()];
            this.esAnonimoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.esAnonimoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.esAnonimoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListarAgregaTagsFormImpl.setEsAnonimoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoLayoutBuscador</code>.
     */
    public void resetTipoLayoutBuscador()
    {
        this.tipoLayoutBuscador = null;
    }

    public void setTipoLayoutBuscador(java.lang.String tipoLayoutBuscador)
    {
        this.tipoLayoutBuscador = tipoLayoutBuscador;
    }

    /**
     * 
     */
    public java.lang.String getTipoLayoutBuscador()
    {
        return this.tipoLayoutBuscador;
    }
    
    public java.lang.Object[] getTipoLayoutBuscadorBackingList()
    {
        java.lang.Object[] values = this.tipoLayoutBuscadorValueList;
        java.lang.Object[] labels = this.tipoLayoutBuscadorLabelList;

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

    public java.lang.Object[] getTipoLayoutBuscadorValueList()
    {
        return this.tipoLayoutBuscadorValueList;
    }

    public void setTipoLayoutBuscadorValueList(java.lang.Object[] tipoLayoutBuscadorValueList)
    {
        this.tipoLayoutBuscadorValueList = tipoLayoutBuscadorValueList;
    }

    public java.lang.Object[] getTipoLayoutBuscadorLabelList()
    {
        return this.tipoLayoutBuscadorLabelList;
    }

    public void setTipoLayoutBuscadorLabelList(java.lang.Object[] tipoLayoutBuscadorLabelList)
    {
        this.tipoLayoutBuscadorLabelList = tipoLayoutBuscadorLabelList;
    }

    public void setTipoLayoutBuscadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListarAgregaTagsFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
        }

        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;

        if (items != null)
        {
            this.tipoLayoutBuscadorValueList = new java.lang.Object[items.size()];
            this.tipoLayoutBuscadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoLayoutBuscadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoLayoutBuscadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListarAgregaTagsFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.esAnonimo = false;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("tags", this.tags);
        builder.append("tag", this.tag);
        builder.append("esAnonimo", this.esAnonimo);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.tags = null;
        this.tagsValueList = null;
        this.tagsLabelList = null;
        this.tag = null;
        this.tagValueList = null;
        this.tagLabelList = null;
        this.esAnonimo = false;
        this.esAnonimoValueList = null;
        this.esAnonimoLabelList = null;
        this.tipoLayoutBuscador = null;
        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;
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
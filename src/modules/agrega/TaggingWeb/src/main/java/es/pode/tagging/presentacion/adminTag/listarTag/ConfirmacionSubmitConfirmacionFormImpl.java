// license-header java merge-point
package es.pode.tagging.presentacion.adminTag.listarTag;

public class ConfirmacionSubmitConfirmacionFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.tagging.presentacion.adminTag.listarTag.EliminarForm
        , es.pode.tagging.presentacion.adminTag.listarTag.ObtenerTagsForm
        , es.pode.tagging.presentacion.adminTag.listarTag.SubmitConfirmacionForm
{
    private java.util.Collection tags = null;
    private java.lang.Object[] tagsValueList;
    private java.lang.Object[] tagsLabelList;
    private java.lang.String newTag;
    private java.lang.Object[] newTagValueList;
    private java.lang.Object[] newTagLabelList;
    private java.util.List tagRowSelection = null;
    private java.lang.Object[] tagValueList;
    private java.lang.Object[] tagLabelList;
    private java.lang.String accion;
    private java.lang.Object[] accionValueList;
    private java.lang.Object[] accionLabelList;
    private java.lang.String tagOld;
    private java.lang.Object[] tagOldValueList;
    private java.lang.Object[] tagOldLabelList;

    public ConfirmacionSubmitConfirmacionFormImpl()
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
     * @see es.pode.tagging.presentacion.adminTag.listarTag.ConfirmacionSubmitConfirmacionFormImpl#getTags
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
            throw new IllegalArgumentException("ConfirmacionSubmitConfirmacionFormImpl.setTagsBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ConfirmacionSubmitConfirmacionFormImpl.setTagsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>newTag</code>.
     */
    public void resetNewTag()
    {
        this.newTag = null;
    }

    public void setNewTag(java.lang.String newTag)
    {
        this.newTag = newTag;
    }

    /**
     * 
     */
    public java.lang.String getNewTag()
    {
        return this.newTag;
    }
    
    public java.lang.Object[] getNewTagBackingList()
    {
        java.lang.Object[] values = this.newTagValueList;
        java.lang.Object[] labels = this.newTagLabelList;

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

    public java.lang.Object[] getNewTagValueList()
    {
        return this.newTagValueList;
    }

    public void setNewTagValueList(java.lang.Object[] newTagValueList)
    {
        this.newTagValueList = newTagValueList;
    }

    public java.lang.Object[] getNewTagLabelList()
    {
        return this.newTagLabelList;
    }

    public void setNewTagLabelList(java.lang.Object[] newTagLabelList)
    {
        this.newTagLabelList = newTagLabelList;
    }

    public void setNewTagBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionSubmitConfirmacionFormImpl.setNewTagBackingList requires non-null property arguments");
        }

        this.newTagValueList = null;
        this.newTagLabelList = null;

        if (items != null)
        {
            this.newTagValueList = new java.lang.Object[items.size()];
            this.newTagLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.newTagValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.newTagLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionSubmitConfirmacionFormImpl.setNewTagBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tagRowSelection</code>.
     */
    public void resetTag()
    {
        this.tagRowSelection = null;
    }

    public void setTagRowSelection(java.util.List tagRowSelection)
    {
        this.tagRowSelection = tagRowSelection;
    }

    public java.util.List getTagRowSelection()
    {
        return this.tagRowSelection;
    }

    public void setTagRowSelectionAsArray(java.lang.String[] tagRowSelection)
    {
        this.tagRowSelection = (tagRowSelection == null) ? null : java.util.Arrays.asList(tagRowSelection);
    }

    public java.lang.String[] getTagRowSelectionAsArray()
    {
        return (tagRowSelection == null) ? null : (java.lang.String[])tagRowSelection.toArray(new java.lang.String[tagRowSelection.size()]);
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
            throw new IllegalArgumentException("ConfirmacionSubmitConfirmacionFormImpl.setTagBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ConfirmacionSubmitConfirmacionFormImpl.setTagBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>accion</code>.
     */
    public void resetAccion()
    {
        this.accion = null;
    }

    public void setAccion(java.lang.String accion)
    {
        this.accion = accion;
    }

    /**
     * 
     */
    public java.lang.String getAccion()
    {
        return this.accion;
    }
    
    public java.lang.Object[] getAccionBackingList()
    {
        java.lang.Object[] values = this.accionValueList;
        java.lang.Object[] labels = this.accionLabelList;

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

    public java.lang.Object[] getAccionValueList()
    {
        return this.accionValueList;
    }

    public void setAccionValueList(java.lang.Object[] accionValueList)
    {
        this.accionValueList = accionValueList;
    }

    public java.lang.Object[] getAccionLabelList()
    {
        return this.accionLabelList;
    }

    public void setAccionLabelList(java.lang.Object[] accionLabelList)
    {
        this.accionLabelList = accionLabelList;
    }

    public void setAccionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionSubmitConfirmacionFormImpl.setAccionBackingList requires non-null property arguments");
        }

        this.accionValueList = null;
        this.accionLabelList = null;

        if (items != null)
        {
            this.accionValueList = new java.lang.Object[items.size()];
            this.accionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.accionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.accionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionSubmitConfirmacionFormImpl.setAccionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tagOld</code>.
     */
    public void resetTagOld()
    {
        this.tagOld = null;
    }

    public void setTagOld(java.lang.String tagOld)
    {
        this.tagOld = tagOld;
    }

    /**
     * 
     */
    public java.lang.String getTagOld()
    {
        return this.tagOld;
    }
    
    public java.lang.Object[] getTagOldBackingList()
    {
        java.lang.Object[] values = this.tagOldValueList;
        java.lang.Object[] labels = this.tagOldLabelList;

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

    public java.lang.Object[] getTagOldValueList()
    {
        return this.tagOldValueList;
    }

    public void setTagOldValueList(java.lang.Object[] tagOldValueList)
    {
        this.tagOldValueList = tagOldValueList;
    }

    public java.lang.Object[] getTagOldLabelList()
    {
        return this.tagOldLabelList;
    }

    public void setTagOldLabelList(java.lang.Object[] tagOldLabelList)
    {
        this.tagOldLabelList = tagOldLabelList;
    }

    public void setTagOldBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionSubmitConfirmacionFormImpl.setTagOldBackingList requires non-null property arguments");
        }

        this.tagOldValueList = null;
        this.tagOldLabelList = null;

        if (items != null)
        {
            this.tagOldValueList = new java.lang.Object[items.size()];
            this.tagOldLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tagOldValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tagOldLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionSubmitConfirmacionFormImpl.setTagOldBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.tagRowSelection = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("tags", this.tags);
        builder.append("newTag", this.newTag);
        builder.append("tagRowSelection", this.tagRowSelection);
        builder.append("accion", this.accion);
        builder.append("tagOld", this.tagOld);
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
        this.newTag = null;
        this.newTagValueList = null;
        this.newTagLabelList = null;
        this.tagRowSelection = null;
        this.accion = null;
        this.accionValueList = null;
        this.accionLabelList = null;
        this.tagOld = null;
        this.tagOldValueList = null;
        this.tagOldLabelList = null;
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
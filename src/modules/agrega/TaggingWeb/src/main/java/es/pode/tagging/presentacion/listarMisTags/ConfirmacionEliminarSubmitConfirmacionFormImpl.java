// license-header java merge-point
package es.pode.tagging.presentacion.listarMisTags;

public class ConfirmacionEliminarSubmitConfirmacionFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.tagging.presentacion.listarMisTags.EliminarTagsForm
        , es.pode.tagging.presentacion.listarMisTags.ObtenerMisTagsForm
        , es.pode.tagging.presentacion.listarMisTags.SubmitConfirmacionForm
{
    private java.lang.String tag;
    private java.lang.Object[] tagValueList;
    private java.lang.Object[] tagLabelList;
    private java.util.Collection misTags = null;
    private java.lang.Object[] misTagsValueList;
    private java.lang.Object[] misTagsLabelList;
    private java.lang.String accion;
    private java.lang.Object[] accionValueList;
    private java.lang.Object[] accionLabelList;

    public ConfirmacionEliminarSubmitConfirmacionFormImpl()
    {
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
            throw new IllegalArgumentException("ConfirmacionEliminarSubmitConfirmacionFormImpl.setTagBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ConfirmacionEliminarSubmitConfirmacionFormImpl.setTagBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>misTags</code>.
     */
    public void resetMisTags()
    {
        this.misTags = null;
    }

    public void setMisTags(java.util.Collection misTags)
    {
        this.misTags = misTags;
    }

    /**
     * 
     */
    public java.util.Collection getMisTags()
    {
        return this.misTags;
    }

    public void setMisTagsAsArray(Object[] misTags)
    {
        this.misTags = (misTags == null) ? null : java.util.Arrays.asList(misTags);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.tagging.presentacion.listarMisTags.ConfirmacionEliminarSubmitConfirmacionFormImpl#getMisTags
     */
    public java.lang.Object[] getMisTagsAsArray()
    {
        return (misTags == null) ? null : misTags.toArray();
    }
    
    public java.lang.Object[] getMisTagsBackingList()
    {
        java.lang.Object[] values = this.misTagsValueList;
        java.lang.Object[] labels = this.misTagsLabelList;

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

    public java.lang.Object[] getMisTagsValueList()
    {
        return this.misTagsValueList;
    }

    public void setMisTagsValueList(java.lang.Object[] misTagsValueList)
    {
        this.misTagsValueList = misTagsValueList;
    }

    public java.lang.Object[] getMisTagsLabelList()
    {
        return this.misTagsLabelList;
    }

    public void setMisTagsLabelList(java.lang.Object[] misTagsLabelList)
    {
        this.misTagsLabelList = misTagsLabelList;
    }

    public void setMisTagsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionEliminarSubmitConfirmacionFormImpl.setMisTagsBackingList requires non-null property arguments");
        }

        this.misTagsValueList = null;
        this.misTagsLabelList = null;

        if (items != null)
        {
            this.misTagsValueList = new java.lang.Object[items.size()];
            this.misTagsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.misTagsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.misTagsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionEliminarSubmitConfirmacionFormImpl.setMisTagsBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ConfirmacionEliminarSubmitConfirmacionFormImpl.setAccionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ConfirmacionEliminarSubmitConfirmacionFormImpl.setAccionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("tag", this.tag);
        builder.append("misTags", this.misTags);
        builder.append("accion", this.accion);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.tag = null;
        this.tagValueList = null;
        this.tagLabelList = null;
        this.misTags = null;
        this.misTagsValueList = null;
        this.misTagsLabelList = null;
        this.accion = null;
        this.accionValueList = null;
        this.accionLabelList = null;
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
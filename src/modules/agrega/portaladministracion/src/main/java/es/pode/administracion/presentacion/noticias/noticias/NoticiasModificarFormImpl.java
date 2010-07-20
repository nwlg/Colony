// license-header java merge-point
package es.pode.administracion.presentacion.noticias.noticias;

public class NoticiasModificarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
    private java.lang.Long idNoticia;
    private java.lang.Object[] idNoticiaValueList;
    private java.lang.Object[] idNoticiaLabelList;

    public NoticiasModificarFormImpl()
    {
    }

    /**
     * Resets the given <code>idNoticia</code>.
     */
    public void resetIdNoticia()
    {
        this.idNoticia = null;
    }

    public void setIdNoticia(java.lang.Long idNoticia)
    {
        this.idNoticia = idNoticia;
    }

    /**
     * <p>
     * Id de la noticia.
     * </p>
     */
    public java.lang.Long getIdNoticia()
    {
        return this.idNoticia;
    }
    
    public java.lang.Object[] getIdNoticiaBackingList()
    {
        java.lang.Object[] values = this.idNoticiaValueList;
        java.lang.Object[] labels = this.idNoticiaLabelList;

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

    public java.lang.Object[] getIdNoticiaValueList()
    {
        return this.idNoticiaValueList;
    }

    public void setIdNoticiaValueList(java.lang.Object[] idNoticiaValueList)
    {
        this.idNoticiaValueList = idNoticiaValueList;
    }

    public java.lang.Object[] getIdNoticiaLabelList()
    {
        return this.idNoticiaLabelList;
    }

    public void setIdNoticiaLabelList(java.lang.Object[] idNoticiaLabelList)
    {
        this.idNoticiaLabelList = idNoticiaLabelList;
    }

    public void setIdNoticiaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NoticiasModificarFormImpl.setIdNoticiaBackingList requires non-null property arguments");
        }

        this.idNoticiaValueList = null;
        this.idNoticiaLabelList = null;

        if (items != null)
        {
            this.idNoticiaValueList = new java.lang.Object[items.size()];
            this.idNoticiaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idNoticiaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idNoticiaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NoticiasModificarFormImpl.setIdNoticiaBackingList encountered an exception", ex);
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
        builder.append("idNoticia", this.idNoticia);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.idNoticia = null;
        this.idNoticiaValueList = null;
        this.idNoticiaLabelList = null;
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
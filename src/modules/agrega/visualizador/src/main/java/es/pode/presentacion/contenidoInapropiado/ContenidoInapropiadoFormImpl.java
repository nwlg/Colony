// license-header java merge-point
package es.pode.presentacion.contenidoInapropiado;

public class ContenidoInapropiadoFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.presentacion.contenidoInapropiado.EnviarMensajeForm
{
    private java.lang.String comentario;
    private java.lang.Object[] comentarioValueList;
    private java.lang.Object[] comentarioLabelList;

    public ContenidoInapropiadoFormImpl()
    {
    }

    /**
     * Resets the given <code>comentario</code>.
     */
    public void resetComentario()
    {
        this.comentario = null;
    }

    public void setComentario(java.lang.String comentario)
    {
        this.comentario = comentario;
    }

    /**
     * 
     */
    public java.lang.String getComentario()
    {
        return this.comentario;
    }
    
    public java.lang.Object[] getComentarioBackingList()
    {
        java.lang.Object[] values = this.comentarioValueList;
        java.lang.Object[] labels = this.comentarioLabelList;

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

    public java.lang.Object[] getComentarioValueList()
    {
        return this.comentarioValueList;
    }

    public void setComentarioValueList(java.lang.Object[] comentarioValueList)
    {
        this.comentarioValueList = comentarioValueList;
    }

    public java.lang.Object[] getComentarioLabelList()
    {
        return this.comentarioLabelList;
    }

    public void setComentarioLabelList(java.lang.Object[] comentarioLabelList)
    {
        this.comentarioLabelList = comentarioLabelList;
    }

    public void setComentarioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ContenidoInapropiadoFormImpl.setComentarioBackingList requires non-null property arguments");
        }

        this.comentarioValueList = null;
        this.comentarioLabelList = null;

        if (items != null)
        {
            this.comentarioValueList = new java.lang.Object[items.size()];
            this.comentarioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comentarioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comentarioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ContenidoInapropiadoFormImpl.setComentarioBackingList encountered an exception", ex);
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
        builder.append("comentario", this.comentario);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.comentario = null;
        this.comentarioValueList = null;
        this.comentarioLabelList = null;
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
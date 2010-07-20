// license-header java merge-point
package es.pode.empaquetador.presentacion.validar;

public class ValidarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.validar.ValidarForm
        , es.pode.empaquetador.presentacion.validar.EsValidoForm
{
    private es.pode.empaquetador.negocio.servicio.ValidaVO validaVO;
    private java.lang.Object[] validaVOValueList;
    private java.lang.Object[] validaVOLabelList;
    private java.util.List mensajesError;
    private java.lang.Object[] mensajesErrorValueList;
    private java.lang.Object[] mensajesErrorLabelList;

    public ValidarFormImpl()
    {
    }

    /**
     * Resets the given <code>validaVO</code>.
     */
    public void resetValidaVO()
    {
        this.validaVO = null;
    }

    public void setValidaVO(es.pode.empaquetador.negocio.servicio.ValidaVO validaVO)
    {
        this.validaVO = validaVO;
    }

    /**
     * 
     */
    public es.pode.empaquetador.negocio.servicio.ValidaVO getValidaVO()
    {
        return this.validaVO;
    }
    
    public java.lang.Object[] getValidaVOBackingList()
    {
        java.lang.Object[] values = this.validaVOValueList;
        java.lang.Object[] labels = this.validaVOLabelList;

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

    public java.lang.Object[] getValidaVOValueList()
    {
        return this.validaVOValueList;
    }

    public void setValidaVOValueList(java.lang.Object[] validaVOValueList)
    {
        this.validaVOValueList = validaVOValueList;
    }

    public java.lang.Object[] getValidaVOLabelList()
    {
        return this.validaVOLabelList;
    }

    public void setValidaVOLabelList(java.lang.Object[] validaVOLabelList)
    {
        this.validaVOLabelList = validaVOLabelList;
    }

    public void setValidaVOBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ValidarFormImpl.setValidaVOBackingList requires non-null property arguments");
        }

        this.validaVOValueList = null;
        this.validaVOLabelList = null;

        if (items != null)
        {
            this.validaVOValueList = new java.lang.Object[items.size()];
            this.validaVOLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.validaVOValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.validaVOLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ValidarFormImpl.setValidaVOBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>mensajesError</code>.
     */
    public void resetMensajesError()
    {
        this.mensajesError = null;
    }

    public void setMensajesError(java.util.List mensajesError)
    {
        this.mensajesError = mensajesError;
    }

    /**
     * 
     */
    public java.util.List getMensajesError()
    {
        return this.mensajesError;
    }

    public void setMensajesErrorAsArray(Object[] mensajesError)
    {
        this.mensajesError = (mensajesError == null) ? null : java.util.Arrays.asList(mensajesError);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.validar.ValidarFormImpl#getMensajesError
     */
    public java.lang.Object[] getMensajesErrorAsArray()
    {
        return (mensajesError == null) ? null : mensajesError.toArray();
    }
    
    public java.lang.Object[] getMensajesErrorBackingList()
    {
        java.lang.Object[] values = this.mensajesErrorValueList;
        java.lang.Object[] labels = this.mensajesErrorLabelList;

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

    public java.lang.Object[] getMensajesErrorValueList()
    {
        return this.mensajesErrorValueList;
    }

    public void setMensajesErrorValueList(java.lang.Object[] mensajesErrorValueList)
    {
        this.mensajesErrorValueList = mensajesErrorValueList;
    }

    public java.lang.Object[] getMensajesErrorLabelList()
    {
        return this.mensajesErrorLabelList;
    }

    public void setMensajesErrorLabelList(java.lang.Object[] mensajesErrorLabelList)
    {
        this.mensajesErrorLabelList = mensajesErrorLabelList;
    }

    public void setMensajesErrorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ValidarFormImpl.setMensajesErrorBackingList requires non-null property arguments");
        }

        this.mensajesErrorValueList = null;
        this.mensajesErrorLabelList = null;

        if (items != null)
        {
            this.mensajesErrorValueList = new java.lang.Object[items.size()];
            this.mensajesErrorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mensajesErrorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mensajesErrorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ValidarFormImpl.setMensajesErrorBackingList encountered an exception", ex);
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
        builder.append("validaVO", this.validaVO);
        builder.append("mensajesError", this.mensajesError);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.validaVO = null;
        this.validaVOValueList = null;
        this.validaVOLabelList = null;
        this.mensajesError = null;
        this.mensajesErrorValueList = null;
        this.mensajesErrorLabelList = null;
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
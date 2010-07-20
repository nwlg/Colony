// license-header java merge-point
package es.pode.visualizador.presentacion.solicitarBajaUsuario;

public class SolicitarBajaUsuarioFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
    private java.lang.String resultadoEnvio;
    private java.lang.Object[] resultadoEnvioValueList;
    private java.lang.Object[] resultadoEnvioLabelList;
    private java.lang.String usuario;
    private java.lang.Object[] usuarioValueList;
    private java.lang.Object[] usuarioLabelList;

    public SolicitarBajaUsuarioFormImpl()
    {
    }

    /**
     * Resets the given <code>resultadoEnvio</code>.
     */
    public void resetResultadoEnvio()
    {
        this.resultadoEnvio = null;
    }

    public void setResultadoEnvio(java.lang.String resultadoEnvio)
    {
        this.resultadoEnvio = resultadoEnvio;
    }

    /**
     * 
     */
    public java.lang.String getResultadoEnvio()
    {
        return this.resultadoEnvio;
    }
    
    public java.lang.Object[] getResultadoEnvioBackingList()
    {
        java.lang.Object[] values = this.resultadoEnvioValueList;
        java.lang.Object[] labels = this.resultadoEnvioLabelList;

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

    public java.lang.Object[] getResultadoEnvioValueList()
    {
        return this.resultadoEnvioValueList;
    }

    public void setResultadoEnvioValueList(java.lang.Object[] resultadoEnvioValueList)
    {
        this.resultadoEnvioValueList = resultadoEnvioValueList;
    }

    public java.lang.Object[] getResultadoEnvioLabelList()
    {
        return this.resultadoEnvioLabelList;
    }

    public void setResultadoEnvioLabelList(java.lang.Object[] resultadoEnvioLabelList)
    {
        this.resultadoEnvioLabelList = resultadoEnvioLabelList;
    }

    public void setResultadoEnvioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SolicitarBajaUsuarioFormImpl.setResultadoEnvioBackingList requires non-null property arguments");
        }

        this.resultadoEnvioValueList = null;
        this.resultadoEnvioLabelList = null;

        if (items != null)
        {
            this.resultadoEnvioValueList = new java.lang.Object[items.size()];
            this.resultadoEnvioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resultadoEnvioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resultadoEnvioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SolicitarBajaUsuarioFormImpl.setResultadoEnvioBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>usuario</code>.
     */
    public void resetUsuario()
    {
        this.usuario = null;
    }

    public void setUsuario(java.lang.String usuario)
    {
        this.usuario = usuario;
    }

    /**
     * 
     */
    public java.lang.String getUsuario()
    {
        return this.usuario;
    }
    
    public java.lang.Object[] getUsuarioBackingList()
    {
        java.lang.Object[] values = this.usuarioValueList;
        java.lang.Object[] labels = this.usuarioLabelList;

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

    public java.lang.Object[] getUsuarioValueList()
    {
        return this.usuarioValueList;
    }

    public void setUsuarioValueList(java.lang.Object[] usuarioValueList)
    {
        this.usuarioValueList = usuarioValueList;
    }

    public java.lang.Object[] getUsuarioLabelList()
    {
        return this.usuarioLabelList;
    }

    public void setUsuarioLabelList(java.lang.Object[] usuarioLabelList)
    {
        this.usuarioLabelList = usuarioLabelList;
    }

    public void setUsuarioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SolicitarBajaUsuarioFormImpl.setUsuarioBackingList requires non-null property arguments");
        }

        this.usuarioValueList = null;
        this.usuarioLabelList = null;

        if (items != null)
        {
            this.usuarioValueList = new java.lang.Object[items.size()];
            this.usuarioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.usuarioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.usuarioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SolicitarBajaUsuarioFormImpl.setUsuarioBackingList encountered an exception", ex);
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
        builder.append("resultadoEnvio", this.resultadoEnvio);
        builder.append("usuario", this.usuario);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.resultadoEnvio = null;
        this.resultadoEnvioValueList = null;
        this.resultadoEnvioLabelList = null;
        this.usuario = null;
        this.usuarioValueList = null;
        this.usuarioLabelList = null;
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
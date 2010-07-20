// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar.repositorio;

public class AbrirBuscadorFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.agregar.repositorio.PrepararParametrosForm
{
    private java.lang.String idDestino;
    private java.lang.Object[] idDestinoValueList;
    private java.lang.Object[] idDestinoLabelList;
    private java.lang.String tipoEmpaquetador;
    private java.lang.Object[] tipoEmpaquetadorValueList;
    private java.lang.Object[] tipoEmpaquetadorLabelList;
    private java.lang.String idOde;
    private java.lang.Object[] idOdeValueList;
    private java.lang.Object[] idOdeLabelList;

    public AbrirBuscadorFormImpl()
    {
    }

    /**
     * Resets the given <code>idDestino</code>.
     */
    public void resetIdDestino()
    {
        this.idDestino = null;
    }

    public void setIdDestino(java.lang.String idDestino)
    {
        this.idDestino = idDestino;
    }

    /**
     * 
     */
    public java.lang.String getIdDestino()
    {
        return this.idDestino;
    }
    
    public java.lang.Object[] getIdDestinoBackingList()
    {
        java.lang.Object[] values = this.idDestinoValueList;
        java.lang.Object[] labels = this.idDestinoLabelList;

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

    public java.lang.Object[] getIdDestinoValueList()
    {
        return this.idDestinoValueList;
    }

    public void setIdDestinoValueList(java.lang.Object[] idDestinoValueList)
    {
        this.idDestinoValueList = idDestinoValueList;
    }

    public java.lang.Object[] getIdDestinoLabelList()
    {
        return this.idDestinoLabelList;
    }

    public void setIdDestinoLabelList(java.lang.Object[] idDestinoLabelList)
    {
        this.idDestinoLabelList = idDestinoLabelList;
    }

    public void setIdDestinoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AbrirBuscadorFormImpl.setIdDestinoBackingList requires non-null property arguments");
        }

        this.idDestinoValueList = null;
        this.idDestinoLabelList = null;

        if (items != null)
        {
            this.idDestinoValueList = new java.lang.Object[items.size()];
            this.idDestinoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idDestinoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idDestinoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AbrirBuscadorFormImpl.setIdDestinoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoEmpaquetador</code>.
     */
    public void resetTipoEmpaquetador()
    {
        this.tipoEmpaquetador = null;
    }

    public void setTipoEmpaquetador(java.lang.String tipoEmpaquetador)
    {
        this.tipoEmpaquetador = tipoEmpaquetador;
    }

    /**
     * 
     */
    public java.lang.String getTipoEmpaquetador()
    {
        return this.tipoEmpaquetador;
    }
    
    public java.lang.Object[] getTipoEmpaquetadorBackingList()
    {
        java.lang.Object[] values = this.tipoEmpaquetadorValueList;
        java.lang.Object[] labels = this.tipoEmpaquetadorLabelList;

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

    public java.lang.Object[] getTipoEmpaquetadorValueList()
    {
        return this.tipoEmpaquetadorValueList;
    }

    public void setTipoEmpaquetadorValueList(java.lang.Object[] tipoEmpaquetadorValueList)
    {
        this.tipoEmpaquetadorValueList = tipoEmpaquetadorValueList;
    }

    public java.lang.Object[] getTipoEmpaquetadorLabelList()
    {
        return this.tipoEmpaquetadorLabelList;
    }

    public void setTipoEmpaquetadorLabelList(java.lang.Object[] tipoEmpaquetadorLabelList)
    {
        this.tipoEmpaquetadorLabelList = tipoEmpaquetadorLabelList;
    }

    public void setTipoEmpaquetadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AbrirBuscadorFormImpl.setTipoEmpaquetadorBackingList requires non-null property arguments");
        }

        this.tipoEmpaquetadorValueList = null;
        this.tipoEmpaquetadorLabelList = null;

        if (items != null)
        {
            this.tipoEmpaquetadorValueList = new java.lang.Object[items.size()];
            this.tipoEmpaquetadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoEmpaquetadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoEmpaquetadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AbrirBuscadorFormImpl.setTipoEmpaquetadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idOde</code>.
     */
    public void resetIdOde()
    {
        this.idOde = null;
    }

    public void setIdOde(java.lang.String idOde)
    {
        this.idOde = idOde;
    }

    /**
     * 
     */
    public java.lang.String getIdOde()
    {
        return this.idOde;
    }
    
    public java.lang.Object[] getIdOdeBackingList()
    {
        java.lang.Object[] values = this.idOdeValueList;
        java.lang.Object[] labels = this.idOdeLabelList;

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

    public java.lang.Object[] getIdOdeValueList()
    {
        return this.idOdeValueList;
    }

    public void setIdOdeValueList(java.lang.Object[] idOdeValueList)
    {
        this.idOdeValueList = idOdeValueList;
    }

    public java.lang.Object[] getIdOdeLabelList()
    {
        return this.idOdeLabelList;
    }

    public void setIdOdeLabelList(java.lang.Object[] idOdeLabelList)
    {
        this.idOdeLabelList = idOdeLabelList;
    }

    public void setIdOdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AbrirBuscadorFormImpl.setIdOdeBackingList requires non-null property arguments");
        }

        this.idOdeValueList = null;
        this.idOdeLabelList = null;

        if (items != null)
        {
            this.idOdeValueList = new java.lang.Object[items.size()];
            this.idOdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idOdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idOdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AbrirBuscadorFormImpl.setIdOdeBackingList encountered an exception", ex);
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
        builder.append("idDestino", this.idDestino);
        builder.append("tipoEmpaquetador", this.tipoEmpaquetador);
        builder.append("idOde", this.idOde);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.idDestino = null;
        this.idDestinoValueList = null;
        this.idDestinoLabelList = null;
        this.tipoEmpaquetador = null;
        this.tipoEmpaquetadorValueList = null;
        this.tipoEmpaquetadorLabelList = null;
        this.idOde = null;
        this.idOdeValueList = null;
        this.idOdeLabelList = null;
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
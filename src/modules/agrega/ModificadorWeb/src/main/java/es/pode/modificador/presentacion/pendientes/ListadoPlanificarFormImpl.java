// license-header java merge-point
package es.pode.modificador.presentacion.pendientes;

public class ListadoPlanificarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
    private java.lang.String idPlanificador;
    private java.lang.Object[] idPlanificadorValueList;
    private java.lang.Object[] idPlanificadorLabelList;
    private java.lang.String idModificacion;
    private java.lang.Object[] idModificacionValueList;
    private java.lang.Object[] idModificacionLabelList;

    public ListadoPlanificarFormImpl()
    {
    }

    /**
     * Resets the given <code>idPlanificador</code>.
     */
    public void resetIdPlanificador()
    {
        this.idPlanificador = null;
    }

    public void setIdPlanificador(java.lang.String idPlanificador)
    {
        this.idPlanificador = idPlanificador;
    }

    /**
     * 
     */
    public java.lang.String getIdPlanificador()
    {
        return this.idPlanificador;
    }
    
    public java.lang.Object[] getIdPlanificadorBackingList()
    {
        java.lang.Object[] values = this.idPlanificadorValueList;
        java.lang.Object[] labels = this.idPlanificadorLabelList;

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

    public java.lang.Object[] getIdPlanificadorValueList()
    {
        return this.idPlanificadorValueList;
    }

    public void setIdPlanificadorValueList(java.lang.Object[] idPlanificadorValueList)
    {
        this.idPlanificadorValueList = idPlanificadorValueList;
    }

    public java.lang.Object[] getIdPlanificadorLabelList()
    {
        return this.idPlanificadorLabelList;
    }

    public void setIdPlanificadorLabelList(java.lang.Object[] idPlanificadorLabelList)
    {
        this.idPlanificadorLabelList = idPlanificadorLabelList;
    }

    public void setIdPlanificadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoPlanificarFormImpl.setIdPlanificadorBackingList requires non-null property arguments");
        }

        this.idPlanificadorValueList = null;
        this.idPlanificadorLabelList = null;

        if (items != null)
        {
            this.idPlanificadorValueList = new java.lang.Object[items.size()];
            this.idPlanificadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idPlanificadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idPlanificadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoPlanificarFormImpl.setIdPlanificadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idModificacion</code>.
     */
    public void resetIdModificacion()
    {
        this.idModificacion = null;
    }

    public void setIdModificacion(java.lang.String idModificacion)
    {
        this.idModificacion = idModificacion;
    }

    /**
     * 
     */
    public java.lang.String getIdModificacion()
    {
        return this.idModificacion;
    }
    
    public java.lang.Object[] getIdModificacionBackingList()
    {
        java.lang.Object[] values = this.idModificacionValueList;
        java.lang.Object[] labels = this.idModificacionLabelList;

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

    public java.lang.Object[] getIdModificacionValueList()
    {
        return this.idModificacionValueList;
    }

    public void setIdModificacionValueList(java.lang.Object[] idModificacionValueList)
    {
        this.idModificacionValueList = idModificacionValueList;
    }

    public java.lang.Object[] getIdModificacionLabelList()
    {
        return this.idModificacionLabelList;
    }

    public void setIdModificacionLabelList(java.lang.Object[] idModificacionLabelList)
    {
        this.idModificacionLabelList = idModificacionLabelList;
    }

    public void setIdModificacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoPlanificarFormImpl.setIdModificacionBackingList requires non-null property arguments");
        }

        this.idModificacionValueList = null;
        this.idModificacionLabelList = null;

        if (items != null)
        {
            this.idModificacionValueList = new java.lang.Object[items.size()];
            this.idModificacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idModificacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idModificacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoPlanificarFormImpl.setIdModificacionBackingList encountered an exception", ex);
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
        builder.append("idPlanificador", this.idPlanificador);
        builder.append("idModificacion", this.idModificacion);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.idPlanificador = null;
        this.idPlanificadorValueList = null;
        this.idPlanificadorLabelList = null;
        this.idModificacion = null;
        this.idModificacionValueList = null;
        this.idModificacionLabelList = null;
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
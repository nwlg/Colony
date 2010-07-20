// license-header java merge-point
package es.pode.administracion.presentacion.planificador.eliminarTarea;

public class ConfirmacionEliminacionAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.planificador.eliminarTarea.EliminarTareasAdmForm
{
    private java.lang.String listaTrabajoPlana;
    private java.lang.Object[] listaTrabajoPlanaValueList;
    private java.lang.Object[] listaTrabajoPlanaLabelList;
    private java.lang.String resultado;
    private java.lang.Object[] resultadoValueList;
    private java.lang.Object[] resultadoLabelList;
    private java.lang.String descripcionBaja;
    private java.lang.Object[] descripcionBajaValueList;
    private java.lang.Object[] descripcionBajaLabelList;

    public ConfirmacionEliminacionAceptarFormImpl()
    {
    }

    /**
     * Resets the given <code>listaTrabajoPlana</code>.
     */
    public void resetListaTrabajoPlana()
    {
        this.listaTrabajoPlana = null;
    }

    public void setListaTrabajoPlana(java.lang.String listaTrabajoPlana)
    {
        this.listaTrabajoPlana = listaTrabajoPlana;
    }

    /**
     * 
     */
    public java.lang.String getListaTrabajoPlana()
    {
        return this.listaTrabajoPlana;
    }
    
    public java.lang.Object[] getListaTrabajoPlanaBackingList()
    {
        java.lang.Object[] values = this.listaTrabajoPlanaValueList;
        java.lang.Object[] labels = this.listaTrabajoPlanaLabelList;

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

    public java.lang.Object[] getListaTrabajoPlanaValueList()
    {
        return this.listaTrabajoPlanaValueList;
    }

    public void setListaTrabajoPlanaValueList(java.lang.Object[] listaTrabajoPlanaValueList)
    {
        this.listaTrabajoPlanaValueList = listaTrabajoPlanaValueList;
    }

    public java.lang.Object[] getListaTrabajoPlanaLabelList()
    {
        return this.listaTrabajoPlanaLabelList;
    }

    public void setListaTrabajoPlanaLabelList(java.lang.Object[] listaTrabajoPlanaLabelList)
    {
        this.listaTrabajoPlanaLabelList = listaTrabajoPlanaLabelList;
    }

    public void setListaTrabajoPlanaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionEliminacionAceptarFormImpl.setListaTrabajoPlanaBackingList requires non-null property arguments");
        }

        this.listaTrabajoPlanaValueList = null;
        this.listaTrabajoPlanaLabelList = null;

        if (items != null)
        {
            this.listaTrabajoPlanaValueList = new java.lang.Object[items.size()];
            this.listaTrabajoPlanaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listaTrabajoPlanaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listaTrabajoPlanaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionEliminacionAceptarFormImpl.setListaTrabajoPlanaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>resultado</code>.
     */
    public void resetResultado()
    {
        this.resultado = null;
    }

    public void setResultado(java.lang.String resultado)
    {
        this.resultado = resultado;
    }

    /**
     * 
     */
    public java.lang.String getResultado()
    {
        return this.resultado;
    }
    
    public java.lang.Object[] getResultadoBackingList()
    {
        java.lang.Object[] values = this.resultadoValueList;
        java.lang.Object[] labels = this.resultadoLabelList;

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

    public java.lang.Object[] getResultadoValueList()
    {
        return this.resultadoValueList;
    }

    public void setResultadoValueList(java.lang.Object[] resultadoValueList)
    {
        this.resultadoValueList = resultadoValueList;
    }

    public java.lang.Object[] getResultadoLabelList()
    {
        return this.resultadoLabelList;
    }

    public void setResultadoLabelList(java.lang.Object[] resultadoLabelList)
    {
        this.resultadoLabelList = resultadoLabelList;
    }

    public void setResultadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionEliminacionAceptarFormImpl.setResultadoBackingList requires non-null property arguments");
        }

        this.resultadoValueList = null;
        this.resultadoLabelList = null;

        if (items != null)
        {
            this.resultadoValueList = new java.lang.Object[items.size()];
            this.resultadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resultadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resultadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionEliminacionAceptarFormImpl.setResultadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcionBaja</code>.
     */
    public void resetDescripcionBaja()
    {
        this.descripcionBaja = null;
    }

    public void setDescripcionBaja(java.lang.String descripcionBaja)
    {
        this.descripcionBaja = descripcionBaja;
    }

    /**
     * 
     */
    public java.lang.String getDescripcionBaja()
    {
        return this.descripcionBaja;
    }
    
    public java.lang.Object[] getDescripcionBajaBackingList()
    {
        java.lang.Object[] values = this.descripcionBajaValueList;
        java.lang.Object[] labels = this.descripcionBajaLabelList;

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

    public java.lang.Object[] getDescripcionBajaValueList()
    {
        return this.descripcionBajaValueList;
    }

    public void setDescripcionBajaValueList(java.lang.Object[] descripcionBajaValueList)
    {
        this.descripcionBajaValueList = descripcionBajaValueList;
    }

    public java.lang.Object[] getDescripcionBajaLabelList()
    {
        return this.descripcionBajaLabelList;
    }

    public void setDescripcionBajaLabelList(java.lang.Object[] descripcionBajaLabelList)
    {
        this.descripcionBajaLabelList = descripcionBajaLabelList;
    }

    public void setDescripcionBajaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionEliminacionAceptarFormImpl.setDescripcionBajaBackingList requires non-null property arguments");
        }

        this.descripcionBajaValueList = null;
        this.descripcionBajaLabelList = null;

        if (items != null)
        {
            this.descripcionBajaValueList = new java.lang.Object[items.size()];
            this.descripcionBajaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionBajaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionBajaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionEliminacionAceptarFormImpl.setDescripcionBajaBackingList encountered an exception", ex);
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
        builder.append("listaTrabajoPlana", this.listaTrabajoPlana);
        builder.append("resultado", this.resultado);
        builder.append("descripcionBaja", this.descripcionBaja);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.listaTrabajoPlana = null;
        this.listaTrabajoPlanaValueList = null;
        this.listaTrabajoPlanaLabelList = null;
        this.resultado = null;
        this.resultadoValueList = null;
        this.resultadoLabelList = null;
        this.descripcionBaja = null;
        this.descripcionBajaValueList = null;
        this.descripcionBajaLabelList = null;
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
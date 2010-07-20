// license-header java merge-point
package es.pode.modificador.presentacion.informes.ode;

public class InformeODEFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.modificador.presentacion.informes.ode.ObtenerDatosForm
{
    private es.pode.modificador.negocio.servicio.ResultadoModificacionVO ode;
    private java.lang.Object[] odeValueList;
    private java.lang.Object[] odeLabelList;
    private java.lang.String resultadoTarea;
    private java.lang.Object[] resultadoTareaValueList;
    private java.lang.Object[] resultadoTareaLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.String nombreTarea;
    private java.lang.Object[] nombreTareaValueList;
    private java.lang.Object[] nombreTareaLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private java.lang.String descResultado;
    private java.lang.Object[] descResultadoValueList;
    private java.lang.Object[] descResultadoLabelList;

    public InformeODEFormImpl()
    {
    }

    /**
     * Resets the given <code>ode</code>.
     */
    public void resetOde()
    {
        this.ode = null;
    }

    public void setOde(es.pode.modificador.negocio.servicio.ResultadoModificacionVO ode)
    {
        this.ode = ode;
    }

    /**
     * 
     */
    public es.pode.modificador.negocio.servicio.ResultadoModificacionVO getOde()
    {
        return this.ode;
    }
    
    public java.lang.Object[] getOdeBackingList()
    {
        java.lang.Object[] values = this.odeValueList;
        java.lang.Object[] labels = this.odeLabelList;

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

    public java.lang.Object[] getOdeValueList()
    {
        return this.odeValueList;
    }

    public void setOdeValueList(java.lang.Object[] odeValueList)
    {
        this.odeValueList = odeValueList;
    }

    public java.lang.Object[] getOdeLabelList()
    {
        return this.odeLabelList;
    }

    public void setOdeLabelList(java.lang.Object[] odeLabelList)
    {
        this.odeLabelList = odeLabelList;
    }

    public void setOdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("InformeODEFormImpl.setOdeBackingList requires non-null property arguments");
        }

        this.odeValueList = null;
        this.odeLabelList = null;

        if (items != null)
        {
            this.odeValueList = new java.lang.Object[items.size()];
            this.odeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.odeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.odeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("InformeODEFormImpl.setOdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>resultadoTarea</code>.
     */
    public void resetResultadoTarea()
    {
        this.resultadoTarea = null;
    }

    public void setResultadoTarea(java.lang.String resultadoTarea)
    {
        this.resultadoTarea = resultadoTarea;
    }

    /**
     * 
     */
    public java.lang.String getResultadoTarea()
    {
        return this.resultadoTarea;
    }
    
    public java.lang.Object[] getResultadoTareaBackingList()
    {
        java.lang.Object[] values = this.resultadoTareaValueList;
        java.lang.Object[] labels = this.resultadoTareaLabelList;

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

    public java.lang.Object[] getResultadoTareaValueList()
    {
        return this.resultadoTareaValueList;
    }

    public void setResultadoTareaValueList(java.lang.Object[] resultadoTareaValueList)
    {
        this.resultadoTareaValueList = resultadoTareaValueList;
    }

    public java.lang.Object[] getResultadoTareaLabelList()
    {
        return this.resultadoTareaLabelList;
    }

    public void setResultadoTareaLabelList(java.lang.Object[] resultadoTareaLabelList)
    {
        this.resultadoTareaLabelList = resultadoTareaLabelList;
    }

    public void setResultadoTareaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("InformeODEFormImpl.setResultadoTareaBackingList requires non-null property arguments");
        }

        this.resultadoTareaValueList = null;
        this.resultadoTareaLabelList = null;

        if (items != null)
        {
            this.resultadoTareaValueList = new java.lang.Object[items.size()];
            this.resultadoTareaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resultadoTareaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resultadoTareaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("InformeODEFormImpl.setResultadoTareaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoBusqueda</code>.
     */
    public void resetTipoBusqueda()
    {
        this.tipoBusqueda = null;
    }

    public void setTipoBusqueda(java.lang.String tipoBusqueda)
    {
        this.tipoBusqueda = tipoBusqueda;
    }

    /**
     * 
     */
    public java.lang.String getTipoBusqueda()
    {
        return this.tipoBusqueda;
    }
    
    public java.lang.Object[] getTipoBusquedaBackingList()
    {
        java.lang.Object[] values = this.tipoBusquedaValueList;
        java.lang.Object[] labels = this.tipoBusquedaLabelList;

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

    public java.lang.Object[] getTipoBusquedaValueList()
    {
        return this.tipoBusquedaValueList;
    }

    public void setTipoBusquedaValueList(java.lang.Object[] tipoBusquedaValueList)
    {
        this.tipoBusquedaValueList = tipoBusquedaValueList;
    }

    public java.lang.Object[] getTipoBusquedaLabelList()
    {
        return this.tipoBusquedaLabelList;
    }

    public void setTipoBusquedaLabelList(java.lang.Object[] tipoBusquedaLabelList)
    {
        this.tipoBusquedaLabelList = tipoBusquedaLabelList;
    }

    public void setTipoBusquedaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("InformeODEFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
        }

        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;

        if (items != null)
        {
            this.tipoBusquedaValueList = new java.lang.Object[items.size()];
            this.tipoBusquedaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoBusquedaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoBusquedaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("InformeODEFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nombreTarea</code>.
     */
    public void resetNombreTarea()
    {
        this.nombreTarea = null;
    }

    public void setNombreTarea(java.lang.String nombreTarea)
    {
        this.nombreTarea = nombreTarea;
    }

    /**
     * 
     */
    public java.lang.String getNombreTarea()
    {
        return this.nombreTarea;
    }
    
    public java.lang.Object[] getNombreTareaBackingList()
    {
        java.lang.Object[] values = this.nombreTareaValueList;
        java.lang.Object[] labels = this.nombreTareaLabelList;

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

    public java.lang.Object[] getNombreTareaValueList()
    {
        return this.nombreTareaValueList;
    }

    public void setNombreTareaValueList(java.lang.Object[] nombreTareaValueList)
    {
        this.nombreTareaValueList = nombreTareaValueList;
    }

    public java.lang.Object[] getNombreTareaLabelList()
    {
        return this.nombreTareaLabelList;
    }

    public void setNombreTareaLabelList(java.lang.Object[] nombreTareaLabelList)
    {
        this.nombreTareaLabelList = nombreTareaLabelList;
    }

    public void setNombreTareaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("InformeODEFormImpl.setNombreTareaBackingList requires non-null property arguments");
        }

        this.nombreTareaValueList = null;
        this.nombreTareaLabelList = null;

        if (items != null)
        {
            this.nombreTareaValueList = new java.lang.Object[items.size()];
            this.nombreTareaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nombreTareaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nombreTareaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("InformeODEFormImpl.setNombreTareaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomaBuscador</code>.
     */
    public void resetIdiomaBuscador()
    {
        this.idiomaBuscador = null;
    }

    public void setIdiomaBuscador(java.lang.String idiomaBuscador)
    {
        this.idiomaBuscador = idiomaBuscador;
    }

    /**
     * 
     */
    public java.lang.String getIdiomaBuscador()
    {
        return this.idiomaBuscador;
    }
    
    public java.lang.Object[] getIdiomaBuscadorBackingList()
    {
        java.lang.Object[] values = this.idiomaBuscadorValueList;
        java.lang.Object[] labels = this.idiomaBuscadorLabelList;

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

    public java.lang.Object[] getIdiomaBuscadorValueList()
    {
        return this.idiomaBuscadorValueList;
    }

    public void setIdiomaBuscadorValueList(java.lang.Object[] idiomaBuscadorValueList)
    {
        this.idiomaBuscadorValueList = idiomaBuscadorValueList;
    }

    public java.lang.Object[] getIdiomaBuscadorLabelList()
    {
        return this.idiomaBuscadorLabelList;
    }

    public void setIdiomaBuscadorLabelList(java.lang.Object[] idiomaBuscadorLabelList)
    {
        this.idiomaBuscadorLabelList = idiomaBuscadorLabelList;
    }

    public void setIdiomaBuscadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("InformeODEFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
        }

        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;

        if (items != null)
        {
            this.idiomaBuscadorValueList = new java.lang.Object[items.size()];
            this.idiomaBuscadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomaBuscadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomaBuscadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("InformeODEFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descResultado</code>.
     */
    public void resetDescResultado()
    {
        this.descResultado = null;
    }

    public void setDescResultado(java.lang.String descResultado)
    {
        this.descResultado = descResultado;
    }

    /**
     * 
     */
    public java.lang.String getDescResultado()
    {
        return this.descResultado;
    }
    
    public java.lang.Object[] getDescResultadoBackingList()
    {
        java.lang.Object[] values = this.descResultadoValueList;
        java.lang.Object[] labels = this.descResultadoLabelList;

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

    public java.lang.Object[] getDescResultadoValueList()
    {
        return this.descResultadoValueList;
    }

    public void setDescResultadoValueList(java.lang.Object[] descResultadoValueList)
    {
        this.descResultadoValueList = descResultadoValueList;
    }

    public java.lang.Object[] getDescResultadoLabelList()
    {
        return this.descResultadoLabelList;
    }

    public void setDescResultadoLabelList(java.lang.Object[] descResultadoLabelList)
    {
        this.descResultadoLabelList = descResultadoLabelList;
    }

    public void setDescResultadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("InformeODEFormImpl.setDescResultadoBackingList requires non-null property arguments");
        }

        this.descResultadoValueList = null;
        this.descResultadoLabelList = null;

        if (items != null)
        {
            this.descResultadoValueList = new java.lang.Object[items.size()];
            this.descResultadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descResultadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descResultadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("InformeODEFormImpl.setDescResultadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.idiomaBuscador = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("ode", this.ode);
        builder.append("resultadoTarea", this.resultadoTarea);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("nombreTarea", this.nombreTarea);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        builder.append("descResultado", this.descResultado);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.ode = null;
        this.odeValueList = null;
        this.odeLabelList = null;
        this.resultadoTarea = null;
        this.resultadoTareaValueList = null;
        this.resultadoTareaLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.nombreTarea = null;
        this.nombreTareaValueList = null;
        this.nombreTareaLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
        this.descResultado = null;
        this.descResultadoValueList = null;
        this.descResultadoLabelList = null;
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
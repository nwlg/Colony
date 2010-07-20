// license-header java merge-point
package es.pode.buscador.presentacion.seleccionTipoBusqueda;

public class SeleccionTipoBusquedaCUFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.buscador.presentacion.seleccionTipoBusqueda.PrepararConsultaForm
{
    private java.lang.Boolean mostrarAmbito;
    private java.lang.Object[] mostrarAmbitoValueList;
    private java.lang.Object[] mostrarAmbitoLabelList;
    private java.lang.String tipoNavegacion;
    private java.lang.Object[] tipoNavegacionValueList;
    private java.lang.Object[] tipoNavegacionLabelList;
    private java.lang.String tituloTesauro;
    private java.lang.Object[] tituloTesauroValueList;
    private java.lang.Object[] tituloTesauroLabelList;
    private java.lang.String tipoBusquedaArbol;
    private java.lang.Object[] tipoBusquedaArbolValueList;
    private java.lang.Object[] tipoBusquedaArbolLabelList;
    private java.lang.String tipoLayoutBuscador;
    private java.lang.Object[] tipoLayoutBuscadorValueList;
    private java.lang.Object[] tipoLayoutBuscadorLabelList;

    public SeleccionTipoBusquedaCUFormImpl()
    {
    }

    /**
     * Resets the given <code>mostrarAmbito</code>.
     */
    public void resetMostrarAmbito()
    {
        this.mostrarAmbito = null;
    }

    public void setMostrarAmbito(java.lang.Boolean mostrarAmbito)
    {
        this.mostrarAmbito = mostrarAmbito;
    }

    /**
     * 
     */
    public java.lang.Boolean getMostrarAmbito()
    {
        return this.mostrarAmbito;
    }
    
    public java.lang.Object[] getMostrarAmbitoBackingList()
    {
        java.lang.Object[] values = this.mostrarAmbitoValueList;
        java.lang.Object[] labels = this.mostrarAmbitoLabelList;

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

    public java.lang.Object[] getMostrarAmbitoValueList()
    {
        return this.mostrarAmbitoValueList;
    }

    public void setMostrarAmbitoValueList(java.lang.Object[] mostrarAmbitoValueList)
    {
        this.mostrarAmbitoValueList = mostrarAmbitoValueList;
    }

    public java.lang.Object[] getMostrarAmbitoLabelList()
    {
        return this.mostrarAmbitoLabelList;
    }

    public void setMostrarAmbitoLabelList(java.lang.Object[] mostrarAmbitoLabelList)
    {
        this.mostrarAmbitoLabelList = mostrarAmbitoLabelList;
    }

    public void setMostrarAmbitoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionTipoBusquedaCUFormImpl.setMostrarAmbitoBackingList requires non-null property arguments");
        }

        this.mostrarAmbitoValueList = null;
        this.mostrarAmbitoLabelList = null;

        if (items != null)
        {
            this.mostrarAmbitoValueList = new java.lang.Object[items.size()];
            this.mostrarAmbitoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mostrarAmbitoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mostrarAmbitoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionTipoBusquedaCUFormImpl.setMostrarAmbitoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoNavegacion</code>.
     */
    public void resetTipoNavegacion()
    {
        this.tipoNavegacion = null;
    }

    public void setTipoNavegacion(java.lang.String tipoNavegacion)
    {
        this.tipoNavegacion = tipoNavegacion;
    }

    /**
     * 
     */
    public java.lang.String getTipoNavegacion()
    {
        return this.tipoNavegacion;
    }
    
    public java.lang.Object[] getTipoNavegacionBackingList()
    {
        java.lang.Object[] values = this.tipoNavegacionValueList;
        java.lang.Object[] labels = this.tipoNavegacionLabelList;

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

    public java.lang.Object[] getTipoNavegacionValueList()
    {
        return this.tipoNavegacionValueList;
    }

    public void setTipoNavegacionValueList(java.lang.Object[] tipoNavegacionValueList)
    {
        this.tipoNavegacionValueList = tipoNavegacionValueList;
    }

    public java.lang.Object[] getTipoNavegacionLabelList()
    {
        return this.tipoNavegacionLabelList;
    }

    public void setTipoNavegacionLabelList(java.lang.Object[] tipoNavegacionLabelList)
    {
        this.tipoNavegacionLabelList = tipoNavegacionLabelList;
    }

    public void setTipoNavegacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionTipoBusquedaCUFormImpl.setTipoNavegacionBackingList requires non-null property arguments");
        }

        this.tipoNavegacionValueList = null;
        this.tipoNavegacionLabelList = null;

        if (items != null)
        {
            this.tipoNavegacionValueList = new java.lang.Object[items.size()];
            this.tipoNavegacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoNavegacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoNavegacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionTipoBusquedaCUFormImpl.setTipoNavegacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tituloTesauro</code>.
     */
    public void resetTituloTesauro()
    {
        this.tituloTesauro = null;
    }

    public void setTituloTesauro(java.lang.String tituloTesauro)
    {
        this.tituloTesauro = tituloTesauro;
    }

    /**
     * 
     */
    public java.lang.String getTituloTesauro()
    {
        return this.tituloTesauro;
    }
    
    public java.lang.Object[] getTituloTesauroBackingList()
    {
        java.lang.Object[] values = this.tituloTesauroValueList;
        java.lang.Object[] labels = this.tituloTesauroLabelList;

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

    public java.lang.Object[] getTituloTesauroValueList()
    {
        return this.tituloTesauroValueList;
    }

    public void setTituloTesauroValueList(java.lang.Object[] tituloTesauroValueList)
    {
        this.tituloTesauroValueList = tituloTesauroValueList;
    }

    public java.lang.Object[] getTituloTesauroLabelList()
    {
        return this.tituloTesauroLabelList;
    }

    public void setTituloTesauroLabelList(java.lang.Object[] tituloTesauroLabelList)
    {
        this.tituloTesauroLabelList = tituloTesauroLabelList;
    }

    public void setTituloTesauroBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionTipoBusquedaCUFormImpl.setTituloTesauroBackingList requires non-null property arguments");
        }

        this.tituloTesauroValueList = null;
        this.tituloTesauroLabelList = null;

        if (items != null)
        {
            this.tituloTesauroValueList = new java.lang.Object[items.size()];
            this.tituloTesauroLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tituloTesauroValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tituloTesauroLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionTipoBusquedaCUFormImpl.setTituloTesauroBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoBusquedaArbol</code>.
     */
    public void resetTipoBusquedaArbol()
    {
        this.tipoBusquedaArbol = null;
    }

    public void setTipoBusquedaArbol(java.lang.String tipoBusquedaArbol)
    {
        this.tipoBusquedaArbol = tipoBusquedaArbol;
    }

    /**
     * 
     */
    public java.lang.String getTipoBusquedaArbol()
    {
        return this.tipoBusquedaArbol;
    }
    
    public java.lang.Object[] getTipoBusquedaArbolBackingList()
    {
        java.lang.Object[] values = this.tipoBusquedaArbolValueList;
        java.lang.Object[] labels = this.tipoBusquedaArbolLabelList;

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

    public java.lang.Object[] getTipoBusquedaArbolValueList()
    {
        return this.tipoBusquedaArbolValueList;
    }

    public void setTipoBusquedaArbolValueList(java.lang.Object[] tipoBusquedaArbolValueList)
    {
        this.tipoBusquedaArbolValueList = tipoBusquedaArbolValueList;
    }

    public java.lang.Object[] getTipoBusquedaArbolLabelList()
    {
        return this.tipoBusquedaArbolLabelList;
    }

    public void setTipoBusquedaArbolLabelList(java.lang.Object[] tipoBusquedaArbolLabelList)
    {
        this.tipoBusquedaArbolLabelList = tipoBusquedaArbolLabelList;
    }

    public void setTipoBusquedaArbolBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionTipoBusquedaCUFormImpl.setTipoBusquedaArbolBackingList requires non-null property arguments");
        }

        this.tipoBusquedaArbolValueList = null;
        this.tipoBusquedaArbolLabelList = null;

        if (items != null)
        {
            this.tipoBusquedaArbolValueList = new java.lang.Object[items.size()];
            this.tipoBusquedaArbolLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoBusquedaArbolValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoBusquedaArbolLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionTipoBusquedaCUFormImpl.setTipoBusquedaArbolBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoLayoutBuscador</code>.
     */
    public void resetTipoLayoutBuscador()
    {
        this.tipoLayoutBuscador = null;
    }

    public void setTipoLayoutBuscador(java.lang.String tipoLayoutBuscador)
    {
        this.tipoLayoutBuscador = tipoLayoutBuscador;
    }

    /**
     * 
     */
    public java.lang.String getTipoLayoutBuscador()
    {
        return this.tipoLayoutBuscador;
    }
    
    public java.lang.Object[] getTipoLayoutBuscadorBackingList()
    {
        java.lang.Object[] values = this.tipoLayoutBuscadorValueList;
        java.lang.Object[] labels = this.tipoLayoutBuscadorLabelList;

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

    public java.lang.Object[] getTipoLayoutBuscadorValueList()
    {
        return this.tipoLayoutBuscadorValueList;
    }

    public void setTipoLayoutBuscadorValueList(java.lang.Object[] tipoLayoutBuscadorValueList)
    {
        this.tipoLayoutBuscadorValueList = tipoLayoutBuscadorValueList;
    }

    public java.lang.Object[] getTipoLayoutBuscadorLabelList()
    {
        return this.tipoLayoutBuscadorLabelList;
    }

    public void setTipoLayoutBuscadorLabelList(java.lang.Object[] tipoLayoutBuscadorLabelList)
    {
        this.tipoLayoutBuscadorLabelList = tipoLayoutBuscadorLabelList;
    }

    public void setTipoLayoutBuscadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionTipoBusquedaCUFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
        }

        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;

        if (items != null)
        {
            this.tipoLayoutBuscadorValueList = new java.lang.Object[items.size()];
            this.tipoLayoutBuscadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoLayoutBuscadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoLayoutBuscadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionTipoBusquedaCUFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.mostrarAmbito = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("mostrarAmbito", this.mostrarAmbito);
        builder.append("tipoNavegacion", this.tipoNavegacion);
        builder.append("tituloTesauro", this.tituloTesauro);
        builder.append("tipoBusquedaArbol", this.tipoBusquedaArbol);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.mostrarAmbito = null;
        this.mostrarAmbitoValueList = null;
        this.mostrarAmbitoLabelList = null;
        this.tipoNavegacion = null;
        this.tipoNavegacionValueList = null;
        this.tipoNavegacionLabelList = null;
        this.tituloTesauro = null;
        this.tituloTesauroValueList = null;
        this.tituloTesauroLabelList = null;
        this.tipoBusquedaArbol = null;
        this.tipoBusquedaArbolValueList = null;
        this.tipoBusquedaArbolLabelList = null;
        this.tipoLayoutBuscador = null;
        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;
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
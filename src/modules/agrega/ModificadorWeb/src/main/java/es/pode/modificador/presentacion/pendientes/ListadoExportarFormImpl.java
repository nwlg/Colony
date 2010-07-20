// license-header java merge-point
package es.pode.modificador.presentacion.pendientes;

public class ListadoExportarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.modificador.presentacion.pendientes.RecuperarModificacionesForm
        , es.pode.modificador.presentacion.pendientes.ExportarTareaForm
{
    private java.lang.String idPlanificador;
    private java.lang.Object[] idPlanificadorValueList;
    private java.lang.Object[] idPlanificadorLabelList;
    private java.util.List modificaciones = null;
    private java.lang.Object[] modificacionesValueList;
    private java.lang.Object[] modificacionesLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.Long idModificacion;
    private java.lang.Object[] idModificacionValueList;
    private java.lang.Object[] idModificacionLabelList;
    private boolean offline;
    private java.lang.Object[] offlineValueList;
    private java.lang.Object[] offlineLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;

    public ListadoExportarFormImpl()
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
            throw new IllegalArgumentException("ListadoExportarFormImpl.setIdPlanificadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoExportarFormImpl.setIdPlanificadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>modificaciones</code>.
     */
    public void resetModificaciones()
    {
        this.modificaciones = null;
    }

    public void setModificaciones(java.util.List modificaciones)
    {
        this.modificaciones = modificaciones;
    }

    /**
     * 
     */
    public java.util.List getModificaciones()
    {
        return this.modificaciones;
    }

    public void setModificacionesAsArray(Object[] modificaciones)
    {
        this.modificaciones = (modificaciones == null) ? null : java.util.Arrays.asList(modificaciones);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.modificador.presentacion.pendientes.ListadoExportarFormImpl#getModificaciones
     */
    public java.lang.Object[] getModificacionesAsArray()
    {
        return (modificaciones == null) ? null : modificaciones.toArray();
    }
    
    public java.lang.Object[] getModificacionesBackingList()
    {
        java.lang.Object[] values = this.modificacionesValueList;
        java.lang.Object[] labels = this.modificacionesLabelList;

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

    public java.lang.Object[] getModificacionesValueList()
    {
        return this.modificacionesValueList;
    }

    public void setModificacionesValueList(java.lang.Object[] modificacionesValueList)
    {
        this.modificacionesValueList = modificacionesValueList;
    }

    public java.lang.Object[] getModificacionesLabelList()
    {
        return this.modificacionesLabelList;
    }

    public void setModificacionesLabelList(java.lang.Object[] modificacionesLabelList)
    {
        this.modificacionesLabelList = modificacionesLabelList;
    }

    public void setModificacionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoExportarFormImpl.setModificacionesBackingList requires non-null property arguments");
        }

        this.modificacionesValueList = null;
        this.modificacionesLabelList = null;

        if (items != null)
        {
            this.modificacionesValueList = new java.lang.Object[items.size()];
            this.modificacionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.modificacionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.modificacionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoExportarFormImpl.setModificacionesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListadoExportarFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoExportarFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
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

    public void setIdModificacion(java.lang.Long idModificacion)
    {
        this.idModificacion = idModificacion;
    }

    /**
     * 
     */
    public java.lang.Long getIdModificacion()
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
            throw new IllegalArgumentException("ListadoExportarFormImpl.setIdModificacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoExportarFormImpl.setIdModificacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>offline</code>.
     */
    public void resetOffline()
    {
        this.offline = false;
    }

    public void setOffline(boolean offline)
    {
        this.offline = offline;
    }

    /**
     * <p>
     * Variable de decision para mostrar o no la opcion planificar.
     * </p>
     */
    public boolean isOffline()
    {
        return this.offline;
    }
    
    public java.lang.Object[] getOfflineBackingList()
    {
        java.lang.Object[] values = this.offlineValueList;
        java.lang.Object[] labels = this.offlineLabelList;

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

    public java.lang.Object[] getOfflineValueList()
    {
        return this.offlineValueList;
    }

    public void setOfflineValueList(java.lang.Object[] offlineValueList)
    {
        this.offlineValueList = offlineValueList;
    }

    public java.lang.Object[] getOfflineLabelList()
    {
        return this.offlineLabelList;
    }

    public void setOfflineLabelList(java.lang.Object[] offlineLabelList)
    {
        this.offlineLabelList = offlineLabelList;
    }

    public void setOfflineBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoExportarFormImpl.setOfflineBackingList requires non-null property arguments");
        }

        this.offlineValueList = null;
        this.offlineLabelList = null;

        if (items != null)
        {
            this.offlineValueList = new java.lang.Object[items.size()];
            this.offlineLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.offlineValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.offlineLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoExportarFormImpl.setOfflineBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListadoExportarFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoExportarFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.offline = false;
        this.idiomaBuscador = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("idPlanificador", this.idPlanificador);
        builder.append("modificaciones", this.modificaciones);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("idModificacion", this.idModificacion);
        builder.append("offline", this.offline);
        builder.append("idiomaBuscador", this.idiomaBuscador);
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
        this.modificaciones = null;
        this.modificacionesValueList = null;
        this.modificacionesLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.idModificacion = null;
        this.idModificacionValueList = null;
        this.idModificacionLabelList = null;
        this.offline = false;
        this.offlineValueList = null;
        this.offlineLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
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
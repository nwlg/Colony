// license-header java merge-point
package es.pode.modificador.presentacion.pendientes;

public class ListadoSubmitFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.modificador.presentacion.pendientes.IniciarTareaForm
        , es.pode.modificador.presentacion.pendientes.SubmitForm
        , es.pode.modificador.presentacion.pendientes.SelectActionForm
{
    private es.pode.modificador.negocio.servicio.ConfiguracionTarea tarea;
    private java.lang.Object[] tareaValueList;
    private java.lang.Object[] tareaLabelList;
    private java.util.List identificadores;
    private java.lang.Object[] identificadoresValueList;
    private java.lang.Object[] identificadoresLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.util.List idModificacionRowSelection = null;
    private java.lang.Object[] idModificacionValueList;
    private java.lang.Object[] idModificacionLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;

    public ListadoSubmitFormImpl()
    {
    }

    /**
     * Resets the given <code>tarea</code>.
     */
    public void resetTarea()
    {
        this.tarea = null;
    }

    public void setTarea(es.pode.modificador.negocio.servicio.ConfiguracionTarea tarea)
    {
        this.tarea = tarea;
    }

    /**
     * 
     */
    public es.pode.modificador.negocio.servicio.ConfiguracionTarea getTarea()
    {
        return this.tarea;
    }
    
    public java.lang.Object[] getTareaBackingList()
    {
        java.lang.Object[] values = this.tareaValueList;
        java.lang.Object[] labels = this.tareaLabelList;

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

    public java.lang.Object[] getTareaValueList()
    {
        return this.tareaValueList;
    }

    public void setTareaValueList(java.lang.Object[] tareaValueList)
    {
        this.tareaValueList = tareaValueList;
    }

    public java.lang.Object[] getTareaLabelList()
    {
        return this.tareaLabelList;
    }

    public void setTareaLabelList(java.lang.Object[] tareaLabelList)
    {
        this.tareaLabelList = tareaLabelList;
    }

    public void setTareaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoSubmitFormImpl.setTareaBackingList requires non-null property arguments");
        }

        this.tareaValueList = null;
        this.tareaLabelList = null;

        if (items != null)
        {
            this.tareaValueList = new java.lang.Object[items.size()];
            this.tareaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tareaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tareaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoSubmitFormImpl.setTareaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificadores</code>.
     */
    public void resetIdentificadores()
    {
        this.identificadores = null;
    }

    public void setIdentificadores(java.util.List identificadores)
    {
        this.identificadores = identificadores;
    }

    /**
     * 
     */
    public java.util.List getIdentificadores()
    {
        return this.identificadores;
    }

    public void setIdentificadoresAsArray(Object[] identificadores)
    {
        this.identificadores = (identificadores == null) ? null : java.util.Arrays.asList(identificadores);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.modificador.presentacion.pendientes.ListadoSubmitFormImpl#getIdentificadores
     */
    public java.lang.Object[] getIdentificadoresAsArray()
    {
        return (identificadores == null) ? null : identificadores.toArray();
    }
    
    public java.lang.Object[] getIdentificadoresBackingList()
    {
        java.lang.Object[] values = this.identificadoresValueList;
        java.lang.Object[] labels = this.identificadoresLabelList;

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

    public java.lang.Object[] getIdentificadoresValueList()
    {
        return this.identificadoresValueList;
    }

    public void setIdentificadoresValueList(java.lang.Object[] identificadoresValueList)
    {
        this.identificadoresValueList = identificadoresValueList;
    }

    public java.lang.Object[] getIdentificadoresLabelList()
    {
        return this.identificadoresLabelList;
    }

    public void setIdentificadoresLabelList(java.lang.Object[] identificadoresLabelList)
    {
        this.identificadoresLabelList = identificadoresLabelList;
    }

    public void setIdentificadoresBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoSubmitFormImpl.setIdentificadoresBackingList requires non-null property arguments");
        }

        this.identificadoresValueList = null;
        this.identificadoresLabelList = null;

        if (items != null)
        {
            this.identificadoresValueList = new java.lang.Object[items.size()];
            this.identificadoresLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadoresValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadoresLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoSubmitFormImpl.setIdentificadoresBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>action</code>.
     */
    public void resetAction()
    {
        this.action = null;
    }

    public void setAction(java.lang.String action)
    {
        this.action = action;
    }

    /**
     * 
     */
    public java.lang.String getAction()
    {
        return this.action;
    }
    
    public java.lang.Object[] getActionBackingList()
    {
        java.lang.Object[] values = this.actionValueList;
        java.lang.Object[] labels = this.actionLabelList;

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

    public java.lang.Object[] getActionValueList()
    {
        return this.actionValueList;
    }

    public void setActionValueList(java.lang.Object[] actionValueList)
    {
        this.actionValueList = actionValueList;
    }

    public java.lang.Object[] getActionLabelList()
    {
        return this.actionLabelList;
    }

    public void setActionLabelList(java.lang.Object[] actionLabelList)
    {
        this.actionLabelList = actionLabelList;
    }

    public void setActionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoSubmitFormImpl.setActionBackingList requires non-null property arguments");
        }

        this.actionValueList = null;
        this.actionLabelList = null;

        if (items != null)
        {
            this.actionValueList = new java.lang.Object[items.size()];
            this.actionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.actionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.actionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoSubmitFormImpl.setActionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListadoSubmitFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoSubmitFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idModificacionRowSelection</code>.
     */
    public void resetIdModificacion()
    {
        this.idModificacionRowSelection = null;
    }

    public void setIdModificacionRowSelection(java.util.List idModificacionRowSelection)
    {
        this.idModificacionRowSelection = idModificacionRowSelection;
    }

    public java.util.List getIdModificacionRowSelection()
    {
        return this.idModificacionRowSelection;
    }

    public void setIdModificacionRowSelectionAsArray(java.lang.String[] idModificacionRowSelection)
    {
        this.idModificacionRowSelection = (idModificacionRowSelection == null) ? null : java.util.Arrays.asList(idModificacionRowSelection);
    }

    public java.lang.String[] getIdModificacionRowSelectionAsArray()
    {
        return (idModificacionRowSelection == null) ? null : (java.lang.String[])idModificacionRowSelection.toArray(new java.lang.String[idModificacionRowSelection.size()]);
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
            throw new IllegalArgumentException("ListadoSubmitFormImpl.setIdModificacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoSubmitFormImpl.setIdModificacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListadoSubmitFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoSubmitFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.identificadores = null;
        this.identificadoresValueList = new java.lang.Object[0];
        this.identificadoresLabelList = new java.lang.Object[0];
        this.idModificacionRowSelection = null;
        this.idiomaBuscador = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("tarea", this.tarea);
        builder.append("identificadores", this.identificadores);
        builder.append("action", this.action);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("idModificacionRowSelection", this.idModificacionRowSelection);
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
        this.tarea = null;
        this.tareaValueList = null;
        this.tareaLabelList = null;
        this.identificadores = null;
        this.identificadoresValueList = null;
        this.identificadoresLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.idModificacionRowSelection = null;
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
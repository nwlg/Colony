// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos.resultados;

public class ResultadosBusquedaEliminarTodosFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.modificador.presentacion.configurar.objetos.resultados.BuscarForm
        , es.pode.modificador.presentacion.configurar.objetos.resultados.EliminarTodosForm
{
    private java.util.List resultados = null;
    private java.lang.Object[] resultadosValueList;
    private java.lang.Object[] resultadosLabelList;
    private java.util.List localizadorODERowSelection = null;
    private java.lang.Object[] localizadorODEValueList;
    private java.lang.Object[] localizadorODELabelList;
    private java.lang.String path;
    private java.lang.Object[] pathValueList;
    private java.lang.Object[] pathLabelList;
    private java.util.List seleccionados = null;
    private java.lang.Object[] seleccionadosValueList;
    private java.lang.Object[] seleccionadosLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;

    public ResultadosBusquedaEliminarTodosFormImpl()
    {
    }

    /**
     * Resets the given <code>resultados</code>.
     */
    public void resetResultados()
    {
        this.resultados = null;
    }

    public void setResultados(java.util.List resultados)
    {
        this.resultados = resultados;
    }

    /**
     * 
     */
    public java.util.List getResultados()
    {
        return this.resultados;
    }

    public void setResultadosAsArray(Object[] resultados)
    {
        this.resultados = (resultados == null) ? null : java.util.Arrays.asList(resultados);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.modificador.presentacion.configurar.objetos.resultados.ResultadosBusquedaEliminarTodosFormImpl#getResultados
     */
    public java.lang.Object[] getResultadosAsArray()
    {
        return (resultados == null) ? null : resultados.toArray();
    }
    
    public java.lang.Object[] getResultadosBackingList()
    {
        java.lang.Object[] values = this.resultadosValueList;
        java.lang.Object[] labels = this.resultadosLabelList;

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

    public java.lang.Object[] getResultadosValueList()
    {
        return this.resultadosValueList;
    }

    public void setResultadosValueList(java.lang.Object[] resultadosValueList)
    {
        this.resultadosValueList = resultadosValueList;
    }

    public java.lang.Object[] getResultadosLabelList()
    {
        return this.resultadosLabelList;
    }

    public void setResultadosLabelList(java.lang.Object[] resultadosLabelList)
    {
        this.resultadosLabelList = resultadosLabelList;
    }

    public void setResultadosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ResultadosBusquedaEliminarTodosFormImpl.setResultadosBackingList requires non-null property arguments");
        }

        this.resultadosValueList = null;
        this.resultadosLabelList = null;

        if (items != null)
        {
            this.resultadosValueList = new java.lang.Object[items.size()];
            this.resultadosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resultadosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resultadosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ResultadosBusquedaEliminarTodosFormImpl.setResultadosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>localizadorODERowSelection</code>.
     */
    public void resetLocalizadorODE()
    {
        this.localizadorODERowSelection = null;
    }

    public void setLocalizadorODERowSelection(java.util.List localizadorODERowSelection)
    {
        this.localizadorODERowSelection = localizadorODERowSelection;
    }

    public java.util.List getLocalizadorODERowSelection()
    {
        return this.localizadorODERowSelection;
    }

    public void setLocalizadorODERowSelectionAsArray(java.lang.String[] localizadorODERowSelection)
    {
        this.localizadorODERowSelection = (localizadorODERowSelection == null) ? null : java.util.Arrays.asList(localizadorODERowSelection);
    }

    public java.lang.String[] getLocalizadorODERowSelectionAsArray()
    {
        return (localizadorODERowSelection == null) ? null : (java.lang.String[])localizadorODERowSelection.toArray(new java.lang.String[localizadorODERowSelection.size()]);
    }

    public java.lang.Object[] getLocalizadorODEBackingList()
    {
        java.lang.Object[] values = this.localizadorODEValueList;
        java.lang.Object[] labels = this.localizadorODELabelList;

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

    public java.lang.Object[] getLocalizadorODEValueList()
    {
        return this.localizadorODEValueList;
    }

    public void setLocalizadorODEValueList(java.lang.Object[] localizadorODEValueList)
    {
        this.localizadorODEValueList = localizadorODEValueList;
    }

    public java.lang.Object[] getLocalizadorODELabelList()
    {
        return this.localizadorODELabelList;
    }

    public void setLocalizadorODELabelList(java.lang.Object[] localizadorODELabelList)
    {
        this.localizadorODELabelList = localizadorODELabelList;
    }

    public void setLocalizadorODEBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ResultadosBusquedaEliminarTodosFormImpl.setLocalizadorODEBackingList requires non-null property arguments");
        }

        this.localizadorODEValueList = null;
        this.localizadorODELabelList = null;

        if (items != null)
        {
            this.localizadorODEValueList = new java.lang.Object[items.size()];
            this.localizadorODELabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.localizadorODEValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.localizadorODELabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ResultadosBusquedaEliminarTodosFormImpl.setLocalizadorODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>path</code>.
     */
    public void resetPath()
    {
        this.path = null;
    }

    public void setPath(java.lang.String path)
    {
        this.path = path;
    }

    /**
     * 
     */
    public java.lang.String getPath()
    {
        return this.path;
    }
    
    public java.lang.Object[] getPathBackingList()
    {
        java.lang.Object[] values = this.pathValueList;
        java.lang.Object[] labels = this.pathLabelList;

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

    public java.lang.Object[] getPathValueList()
    {
        return this.pathValueList;
    }

    public void setPathValueList(java.lang.Object[] pathValueList)
    {
        this.pathValueList = pathValueList;
    }

    public java.lang.Object[] getPathLabelList()
    {
        return this.pathLabelList;
    }

    public void setPathLabelList(java.lang.Object[] pathLabelList)
    {
        this.pathLabelList = pathLabelList;
    }

    public void setPathBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ResultadosBusquedaEliminarTodosFormImpl.setPathBackingList requires non-null property arguments");
        }

        this.pathValueList = null;
        this.pathLabelList = null;

        if (items != null)
        {
            this.pathValueList = new java.lang.Object[items.size()];
            this.pathLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.pathValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.pathLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ResultadosBusquedaEliminarTodosFormImpl.setPathBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>seleccionados</code>.
     */
    public void resetSeleccionados()
    {
        this.seleccionados = null;
    }

    public void setSeleccionados(java.util.List seleccionados)
    {
        this.seleccionados = seleccionados;
    }

    /**
     * 
     */
    public java.util.List getSeleccionados()
    {
        return this.seleccionados;
    }

    public void setSeleccionadosAsArray(Object[] seleccionados)
    {
        this.seleccionados = (seleccionados == null) ? null : java.util.Arrays.asList(seleccionados);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.modificador.presentacion.configurar.objetos.resultados.ResultadosBusquedaEliminarTodosFormImpl#getSeleccionados
     */
    public java.lang.Object[] getSeleccionadosAsArray()
    {
        return (seleccionados == null) ? null : seleccionados.toArray();
    }
    
    public java.lang.Object[] getSeleccionadosBackingList()
    {
        java.lang.Object[] values = this.seleccionadosValueList;
        java.lang.Object[] labels = this.seleccionadosLabelList;

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

    public java.lang.Object[] getSeleccionadosValueList()
    {
        return this.seleccionadosValueList;
    }

    public void setSeleccionadosValueList(java.lang.Object[] seleccionadosValueList)
    {
        this.seleccionadosValueList = seleccionadosValueList;
    }

    public java.lang.Object[] getSeleccionadosLabelList()
    {
        return this.seleccionadosLabelList;
    }

    public void setSeleccionadosLabelList(java.lang.Object[] seleccionadosLabelList)
    {
        this.seleccionadosLabelList = seleccionadosLabelList;
    }

    public void setSeleccionadosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ResultadosBusquedaEliminarTodosFormImpl.setSeleccionadosBackingList requires non-null property arguments");
        }

        this.seleccionadosValueList = null;
        this.seleccionadosLabelList = null;

        if (items != null)
        {
            this.seleccionadosValueList = new java.lang.Object[items.size()];
            this.seleccionadosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.seleccionadosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.seleccionadosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ResultadosBusquedaEliminarTodosFormImpl.setSeleccionadosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ResultadosBusquedaEliminarTodosFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ResultadosBusquedaEliminarTodosFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ResultadosBusquedaEliminarTodosFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ResultadosBusquedaEliminarTodosFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.localizadorODERowSelection = null;
        this.idiomaBuscador = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("resultados", this.resultados);
        builder.append("localizadorODERowSelection", this.localizadorODERowSelection);
        builder.append("path", this.path);
        builder.append("seleccionados", this.seleccionados);
        builder.append("tipoBusqueda", this.tipoBusqueda);
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
        this.resultados = null;
        this.resultadosValueList = null;
        this.resultadosLabelList = null;
        this.localizadorODERowSelection = null;
        this.path = null;
        this.pathValueList = null;
        this.pathLabelList = null;
        this.seleccionados = null;
        this.seleccionadosValueList = null;
        this.seleccionadosLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
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
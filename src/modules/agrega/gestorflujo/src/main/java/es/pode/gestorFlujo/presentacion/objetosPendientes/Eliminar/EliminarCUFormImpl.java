// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes.Eliminar;

public class EliminarCUFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.gestorFlujo.presentacion.objetosPendientes.Eliminar.CargarDatosForm
        , es.pode.gestorFlujo.presentacion.objetosPendientes.Eliminar.AnalizaSelecForm
{
    private java.lang.String[] ids;
    private java.lang.Object[] idsValueList;
    private java.lang.Object[] idsLabelList;
    private java.lang.String[] listODEs;
    private java.lang.Object[] listODEsValueList;
    private java.lang.Object[] listODEsLabelList;
    private java.lang.String seleccion;
    private java.lang.Object[] seleccionValueList;
    private java.lang.Object[] seleccionLabelList;
    private java.lang.String[] titulos;
    private java.lang.Object[] titulosValueList;
    private java.lang.Object[] titulosLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private java.lang.String origen;
    private java.lang.Object[] origenValueList;
    private java.lang.Object[] origenLabelList;

    public EliminarCUFormImpl()
    {
    }

    /**
     * Resets the given <code>ids</code>.
     */
    public void resetIds()
    {
        this.ids = null;
    }

    public void setIds(java.lang.String[] ids)
    {
        this.ids = ids;
    }

    /**
     * 
     */
    public java.lang.String[] getIds()
    {
        return this.ids;
    }
    
    public java.lang.Object[] getIdsBackingList()
    {
        java.lang.Object[] values = this.idsValueList;
        java.lang.Object[] labels = this.idsLabelList;

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

    public java.lang.Object[] getIdsValueList()
    {
        return this.idsValueList;
    }

    public void setIdsValueList(java.lang.Object[] idsValueList)
    {
        this.idsValueList = idsValueList;
    }

    public java.lang.Object[] getIdsLabelList()
    {
        return this.idsLabelList;
    }

    public void setIdsLabelList(java.lang.Object[] idsLabelList)
    {
        this.idsLabelList = idsLabelList;
    }

    public void setIdsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarCUFormImpl.setIdsBackingList requires non-null property arguments");
        }

        this.idsValueList = null;
        this.idsLabelList = null;

        if (items != null)
        {
            this.idsValueList = new java.lang.Object[items.size()];
            this.idsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarCUFormImpl.setIdsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listODEs</code>.
     */
    public void resetListODEs()
    {
        this.listODEs = null;
    }

    public void setListODEs(java.lang.String[] listODEs)
    {
        this.listODEs = listODEs;
    }

    /**
     * 
     */
    public java.lang.String[] getListODEs()
    {
        return this.listODEs;
    }
    
    public java.lang.Object[] getListODEsBackingList()
    {
        java.lang.Object[] values = this.listODEsValueList;
        java.lang.Object[] labels = this.listODEsLabelList;

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

    public java.lang.Object[] getListODEsValueList()
    {
        return this.listODEsValueList;
    }

    public void setListODEsValueList(java.lang.Object[] listODEsValueList)
    {
        this.listODEsValueList = listODEsValueList;
    }

    public java.lang.Object[] getListODEsLabelList()
    {
        return this.listODEsLabelList;
    }

    public void setListODEsLabelList(java.lang.Object[] listODEsLabelList)
    {
        this.listODEsLabelList = listODEsLabelList;
    }

    public void setListODEsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarCUFormImpl.setListODEsBackingList requires non-null property arguments");
        }

        this.listODEsValueList = null;
        this.listODEsLabelList = null;

        if (items != null)
        {
            this.listODEsValueList = new java.lang.Object[items.size()];
            this.listODEsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listODEsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listODEsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarCUFormImpl.setListODEsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>seleccion</code>.
     */
    public void resetSeleccion()
    {
        this.seleccion = null;
    }

    public void setSeleccion(java.lang.String seleccion)
    {
        this.seleccion = seleccion;
    }

    /**
     * 
     */
    public java.lang.String getSeleccion()
    {
        return this.seleccion;
    }
    
    public java.lang.Object[] getSeleccionBackingList()
    {
        java.lang.Object[] values = this.seleccionValueList;
        java.lang.Object[] labels = this.seleccionLabelList;

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

    public java.lang.Object[] getSeleccionValueList()
    {
        return this.seleccionValueList;
    }

    public void setSeleccionValueList(java.lang.Object[] seleccionValueList)
    {
        this.seleccionValueList = seleccionValueList;
    }

    public java.lang.Object[] getSeleccionLabelList()
    {
        return this.seleccionLabelList;
    }

    public void setSeleccionLabelList(java.lang.Object[] seleccionLabelList)
    {
        this.seleccionLabelList = seleccionLabelList;
    }

    public void setSeleccionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarCUFormImpl.setSeleccionBackingList requires non-null property arguments");
        }

        this.seleccionValueList = null;
        this.seleccionLabelList = null;

        if (items != null)
        {
            this.seleccionValueList = new java.lang.Object[items.size()];
            this.seleccionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.seleccionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.seleccionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarCUFormImpl.setSeleccionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>titulos</code>.
     */
    public void resetTitulos()
    {
        this.titulos = null;
    }

    public void setTitulos(java.lang.String[] titulos)
    {
        this.titulos = titulos;
    }

    /**
     * 
     */
    public java.lang.String[] getTitulos()
    {
        return this.titulos;
    }
    
    public java.lang.Object[] getTitulosBackingList()
    {
        java.lang.Object[] values = this.titulosValueList;
        java.lang.Object[] labels = this.titulosLabelList;

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

    public java.lang.Object[] getTitulosValueList()
    {
        return this.titulosValueList;
    }

    public void setTitulosValueList(java.lang.Object[] titulosValueList)
    {
        this.titulosValueList = titulosValueList;
    }

    public java.lang.Object[] getTitulosLabelList()
    {
        return this.titulosLabelList;
    }

    public void setTitulosLabelList(java.lang.Object[] titulosLabelList)
    {
        this.titulosLabelList = titulosLabelList;
    }

    public void setTitulosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarCUFormImpl.setTitulosBackingList requires non-null property arguments");
        }

        this.titulosValueList = null;
        this.titulosLabelList = null;

        if (items != null)
        {
            this.titulosValueList = new java.lang.Object[items.size()];
            this.titulosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.titulosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.titulosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarCUFormImpl.setTitulosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("EliminarCUFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EliminarCUFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>origen</code>.
     */
    public void resetOrigen()
    {
        this.origen = null;
    }

    public void setOrigen(java.lang.String origen)
    {
        this.origen = origen;
    }

    /**
     * 
     */
    public java.lang.String getOrigen()
    {
        return this.origen;
    }
    
    public java.lang.Object[] getOrigenBackingList()
    {
        java.lang.Object[] values = this.origenValueList;
        java.lang.Object[] labels = this.origenLabelList;

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

    public java.lang.Object[] getOrigenValueList()
    {
        return this.origenValueList;
    }

    public void setOrigenValueList(java.lang.Object[] origenValueList)
    {
        this.origenValueList = origenValueList;
    }

    public java.lang.Object[] getOrigenLabelList()
    {
        return this.origenLabelList;
    }

    public void setOrigenLabelList(java.lang.Object[] origenLabelList)
    {
        this.origenLabelList = origenLabelList;
    }

    public void setOrigenBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarCUFormImpl.setOrigenBackingList requires non-null property arguments");
        }

        this.origenValueList = null;
        this.origenLabelList = null;

        if (items != null)
        {
            this.origenValueList = new java.lang.Object[items.size()];
            this.origenLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.origenValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.origenLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarCUFormImpl.setOrigenBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.ids = null;
        this.listODEs = null;
        this.titulos = null;
        this.idiomaBuscador = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("ids", this.ids);
        builder.append("listODEs", this.listODEs);
        builder.append("seleccion", this.seleccion);
        builder.append("titulos", this.titulos);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        builder.append("origen", this.origen);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.ids = null;
        this.idsValueList = null;
        this.idsLabelList = null;
        this.listODEs = null;
        this.listODEsValueList = null;
        this.listODEsLabelList = null;
        this.seleccion = null;
        this.seleccionValueList = null;
        this.seleccionLabelList = null;
        this.titulos = null;
        this.titulosValueList = null;
        this.titulosLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
        this.origen = null;
        this.origenValueList = null;
        this.origenLabelList = null;
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
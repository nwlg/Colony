// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion;

public class ClasificacionFormEliminarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.EliminarClasificacionForm
{
    private java.util.Collection listadoClasificacion;
    private java.lang.Object[] listadoClasificacionValueList;
    private java.lang.Object[] listadoClasificacionLabelList;
    private java.util.List tituloClasificacionRowSelection = null;
    private java.lang.Object[] tituloClasificacionValueList;
    private java.lang.Object[] tituloClasificacionLabelList;

    public ClasificacionFormEliminarFormImpl()
    {
    }

    /**
     * Resets the given <code>listadoClasificacion</code>.
     */
    public void resetListadoClasificacion()
    {
        this.listadoClasificacion = null;
    }

    public void setListadoClasificacion(java.util.Collection listadoClasificacion)
    {
        this.listadoClasificacion = listadoClasificacion;
    }

    /**
     * 
     */
    public java.util.Collection getListadoClasificacion()
    {
        return this.listadoClasificacion;
    }

    public void setListadoClasificacionAsArray(Object[] listadoClasificacion)
    {
        this.listadoClasificacion = (listadoClasificacion == null) ? null : java.util.Arrays.asList(listadoClasificacion);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ClasificacionFormEliminarFormImpl#getListadoClasificacion
     */
    public java.lang.Object[] getListadoClasificacionAsArray()
    {
        return (listadoClasificacion == null) ? null : listadoClasificacion.toArray();
    }
    
    public java.lang.Object[] getListadoClasificacionBackingList()
    {
        java.lang.Object[] values = this.listadoClasificacionValueList;
        java.lang.Object[] labels = this.listadoClasificacionLabelList;

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

    public java.lang.Object[] getListadoClasificacionValueList()
    {
        return this.listadoClasificacionValueList;
    }

    public void setListadoClasificacionValueList(java.lang.Object[] listadoClasificacionValueList)
    {
        this.listadoClasificacionValueList = listadoClasificacionValueList;
    }

    public java.lang.Object[] getListadoClasificacionLabelList()
    {
        return this.listadoClasificacionLabelList;
    }

    public void setListadoClasificacionLabelList(java.lang.Object[] listadoClasificacionLabelList)
    {
        this.listadoClasificacionLabelList = listadoClasificacionLabelList;
    }

    public void setListadoClasificacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ClasificacionFormEliminarFormImpl.setListadoClasificacionBackingList requires non-null property arguments");
        }

        this.listadoClasificacionValueList = null;
        this.listadoClasificacionLabelList = null;

        if (items != null)
        {
            this.listadoClasificacionValueList = new java.lang.Object[items.size()];
            this.listadoClasificacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listadoClasificacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listadoClasificacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ClasificacionFormEliminarFormImpl.setListadoClasificacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tituloClasificacionRowSelection</code>.
     */
    public void resetTituloClasificacion()
    {
        this.tituloClasificacionRowSelection = null;
    }

    public void setTituloClasificacionRowSelection(java.util.List tituloClasificacionRowSelection)
    {
        this.tituloClasificacionRowSelection = tituloClasificacionRowSelection;
    }

    public java.util.List getTituloClasificacionRowSelection()
    {
        return this.tituloClasificacionRowSelection;
    }

    public void setTituloClasificacionRowSelectionAsArray(java.lang.String[] tituloClasificacionRowSelection)
    {
        this.tituloClasificacionRowSelection = (tituloClasificacionRowSelection == null) ? null : java.util.Arrays.asList(tituloClasificacionRowSelection);
    }

    public java.lang.String[] getTituloClasificacionRowSelectionAsArray()
    {
        return (tituloClasificacionRowSelection == null) ? null : (java.lang.String[])tituloClasificacionRowSelection.toArray(new java.lang.String[tituloClasificacionRowSelection.size()]);
    }

    public java.lang.Object[] getTituloClasificacionBackingList()
    {
        java.lang.Object[] values = this.tituloClasificacionValueList;
        java.lang.Object[] labels = this.tituloClasificacionLabelList;

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

    public java.lang.Object[] getTituloClasificacionValueList()
    {
        return this.tituloClasificacionValueList;
    }

    public void setTituloClasificacionValueList(java.lang.Object[] tituloClasificacionValueList)
    {
        this.tituloClasificacionValueList = tituloClasificacionValueList;
    }

    public java.lang.Object[] getTituloClasificacionLabelList()
    {
        return this.tituloClasificacionLabelList;
    }

    public void setTituloClasificacionLabelList(java.lang.Object[] tituloClasificacionLabelList)
    {
        this.tituloClasificacionLabelList = tituloClasificacionLabelList;
    }

    public void setTituloClasificacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ClasificacionFormEliminarFormImpl.setTituloClasificacionBackingList requires non-null property arguments");
        }

        this.tituloClasificacionValueList = null;
        this.tituloClasificacionLabelList = null;

        if (items != null)
        {
            this.tituloClasificacionValueList = new java.lang.Object[items.size()];
            this.tituloClasificacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tituloClasificacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tituloClasificacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ClasificacionFormEliminarFormImpl.setTituloClasificacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.listadoClasificacion = null;
        this.listadoClasificacionValueList = new java.lang.Object[0];
        this.listadoClasificacionLabelList = new java.lang.Object[0];
        this.tituloClasificacionRowSelection = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("listadoClasificacion", this.listadoClasificacion);
        builder.append("tituloClasificacionRowSelection", this.tituloClasificacionRowSelection);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.listadoClasificacion = null;
        this.listadoClasificacionValueList = null;
        this.listadoClasificacionLabelList = null;
        this.tituloClasificacionRowSelection = null;
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
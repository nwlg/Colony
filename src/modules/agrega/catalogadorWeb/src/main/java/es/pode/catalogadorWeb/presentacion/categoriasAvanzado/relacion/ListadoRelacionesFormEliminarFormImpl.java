// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion;

public class ListadoRelacionesFormEliminarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.EliminarRelacionForm
{
    private java.util.List tituloRelacionRowSelection = null;
    private java.lang.Object[] tituloRelacionValueList;
    private java.lang.Object[] tituloRelacionLabelList;
    private java.util.Collection listadoRelaciones;
    private java.lang.Object[] listadoRelacionesValueList;
    private java.lang.Object[] listadoRelacionesLabelList;
    private java.util.Collection listadoRelacion;
    private java.lang.Object[] listadoRelacionValueList;
    private java.lang.Object[] listadoRelacionLabelList;

    public ListadoRelacionesFormEliminarFormImpl()
    {
    }

    /**
     * Resets the given <code>tituloRelacionRowSelection</code>.
     */
    public void resetTituloRelacion()
    {
        this.tituloRelacionRowSelection = null;
    }

    public void setTituloRelacionRowSelection(java.util.List tituloRelacionRowSelection)
    {
        this.tituloRelacionRowSelection = tituloRelacionRowSelection;
    }

    public java.util.List getTituloRelacionRowSelection()
    {
        return this.tituloRelacionRowSelection;
    }

    public void setTituloRelacionRowSelectionAsArray(java.lang.String[] tituloRelacionRowSelection)
    {
        this.tituloRelacionRowSelection = (tituloRelacionRowSelection == null) ? null : java.util.Arrays.asList(tituloRelacionRowSelection);
    }

    public java.lang.String[] getTituloRelacionRowSelectionAsArray()
    {
        return (tituloRelacionRowSelection == null) ? null : (java.lang.String[])tituloRelacionRowSelection.toArray(new java.lang.String[tituloRelacionRowSelection.size()]);
    }

    public java.lang.Object[] getTituloRelacionBackingList()
    {
        java.lang.Object[] values = this.tituloRelacionValueList;
        java.lang.Object[] labels = this.tituloRelacionLabelList;

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

    public java.lang.Object[] getTituloRelacionValueList()
    {
        return this.tituloRelacionValueList;
    }

    public void setTituloRelacionValueList(java.lang.Object[] tituloRelacionValueList)
    {
        this.tituloRelacionValueList = tituloRelacionValueList;
    }

    public java.lang.Object[] getTituloRelacionLabelList()
    {
        return this.tituloRelacionLabelList;
    }

    public void setTituloRelacionLabelList(java.lang.Object[] tituloRelacionLabelList)
    {
        this.tituloRelacionLabelList = tituloRelacionLabelList;
    }

    public void setTituloRelacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoRelacionesFormEliminarFormImpl.setTituloRelacionBackingList requires non-null property arguments");
        }

        this.tituloRelacionValueList = null;
        this.tituloRelacionLabelList = null;

        if (items != null)
        {
            this.tituloRelacionValueList = new java.lang.Object[items.size()];
            this.tituloRelacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tituloRelacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tituloRelacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoRelacionesFormEliminarFormImpl.setTituloRelacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listadoRelaciones</code>.
     */
    public void resetListadoRelaciones()
    {
        this.listadoRelaciones = null;
    }

    public void setListadoRelaciones(java.util.Collection listadoRelaciones)
    {
        this.listadoRelaciones = listadoRelaciones;
    }

    /**
     * 
     */
    public java.util.Collection getListadoRelaciones()
    {
        return this.listadoRelaciones;
    }

    public void setListadoRelacionesAsArray(Object[] listadoRelaciones)
    {
        this.listadoRelaciones = (listadoRelaciones == null) ? null : java.util.Arrays.asList(listadoRelaciones);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.ListadoRelacionesFormEliminarFormImpl#getListadoRelaciones
     */
    public java.lang.Object[] getListadoRelacionesAsArray()
    {
        return (listadoRelaciones == null) ? null : listadoRelaciones.toArray();
    }
    
    public java.lang.Object[] getListadoRelacionesBackingList()
    {
        java.lang.Object[] values = this.listadoRelacionesValueList;
        java.lang.Object[] labels = this.listadoRelacionesLabelList;

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

    public java.lang.Object[] getListadoRelacionesValueList()
    {
        return this.listadoRelacionesValueList;
    }

    public void setListadoRelacionesValueList(java.lang.Object[] listadoRelacionesValueList)
    {
        this.listadoRelacionesValueList = listadoRelacionesValueList;
    }

    public java.lang.Object[] getListadoRelacionesLabelList()
    {
        return this.listadoRelacionesLabelList;
    }

    public void setListadoRelacionesLabelList(java.lang.Object[] listadoRelacionesLabelList)
    {
        this.listadoRelacionesLabelList = listadoRelacionesLabelList;
    }

    public void setListadoRelacionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoRelacionesFormEliminarFormImpl.setListadoRelacionesBackingList requires non-null property arguments");
        }

        this.listadoRelacionesValueList = null;
        this.listadoRelacionesLabelList = null;

        if (items != null)
        {
            this.listadoRelacionesValueList = new java.lang.Object[items.size()];
            this.listadoRelacionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listadoRelacionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listadoRelacionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoRelacionesFormEliminarFormImpl.setListadoRelacionesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listadoRelacion</code>.
     */
    public void resetListadoRelacion()
    {
        this.listadoRelacion = null;
    }

    public void setListadoRelacion(java.util.Collection listadoRelacion)
    {
        this.listadoRelacion = listadoRelacion;
    }

    /**
     * 
     */
    public java.util.Collection getListadoRelacion()
    {
        return this.listadoRelacion;
    }

    public void setListadoRelacionAsArray(Object[] listadoRelacion)
    {
        this.listadoRelacion = (listadoRelacion == null) ? null : java.util.Arrays.asList(listadoRelacion);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.ListadoRelacionesFormEliminarFormImpl#getListadoRelacion
     */
    public java.lang.Object[] getListadoRelacionAsArray()
    {
        return (listadoRelacion == null) ? null : listadoRelacion.toArray();
    }
    
    public java.lang.Object[] getListadoRelacionBackingList()
    {
        java.lang.Object[] values = this.listadoRelacionValueList;
        java.lang.Object[] labels = this.listadoRelacionLabelList;

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

    public java.lang.Object[] getListadoRelacionValueList()
    {
        return this.listadoRelacionValueList;
    }

    public void setListadoRelacionValueList(java.lang.Object[] listadoRelacionValueList)
    {
        this.listadoRelacionValueList = listadoRelacionValueList;
    }

    public java.lang.Object[] getListadoRelacionLabelList()
    {
        return this.listadoRelacionLabelList;
    }

    public void setListadoRelacionLabelList(java.lang.Object[] listadoRelacionLabelList)
    {
        this.listadoRelacionLabelList = listadoRelacionLabelList;
    }

    public void setListadoRelacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoRelacionesFormEliminarFormImpl.setListadoRelacionBackingList requires non-null property arguments");
        }

        this.listadoRelacionValueList = null;
        this.listadoRelacionLabelList = null;

        if (items != null)
        {
            this.listadoRelacionValueList = new java.lang.Object[items.size()];
            this.listadoRelacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listadoRelacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listadoRelacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoRelacionesFormEliminarFormImpl.setListadoRelacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.tituloRelacionRowSelection = null;
        this.listadoRelaciones = null;
        this.listadoRelacionesValueList = new java.lang.Object[0];
        this.listadoRelacionesLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("tituloRelacionRowSelection", this.tituloRelacionRowSelection);
        builder.append("listadoRelaciones", this.listadoRelaciones);
        builder.append("listadoRelacion", this.listadoRelacion);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.tituloRelacionRowSelection = null;
        this.listadoRelaciones = null;
        this.listadoRelacionesValueList = null;
        this.listadoRelacionesLabelList = null;
        this.listadoRelacion = null;
        this.listadoRelacionValueList = null;
        this.listadoRelacionLabelList = null;
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
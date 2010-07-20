// license-header java merge-point
package es.pode.administracion.presentacion.nodos.bajaNodo;

public class ConfirmarAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.nodos.bajaNodo.BajaNodoForm
{
    private es.pode.buscar.negocio.administrar.servicio.NodoVO[] nodosBorrados;
    private java.lang.Object[] nodosBorradosValueList;
    private java.lang.Object[] nodosBorradosLabelList;
    private java.lang.String listaId;
    private java.lang.Object[] listaIdValueList;
    private java.lang.Object[] listaIdLabelList;
    private es.pode.buscar.negocio.administrar.servicio.NodoVO[] nodos;
    private java.lang.Object[] nodosValueList;
    private java.lang.Object[] nodosLabelList;
    private java.lang.String descripcionBaja;
    private java.lang.Object[] descripcionBajaValueList;
    private java.lang.Object[] descripcionBajaLabelList;

    public ConfirmarAceptarFormImpl()
    {
    }

    /**
     * Resets the given <code>nodosBorrados</code>.
     */
    public void resetNodosBorrados()
    {
        this.nodosBorrados = null;
    }

    public void setNodosBorrados(es.pode.buscar.negocio.administrar.servicio.NodoVO[] nodosBorrados)
    {
        this.nodosBorrados = nodosBorrados;
    }

    /**
     * 
     */
    public es.pode.buscar.negocio.administrar.servicio.NodoVO[] getNodosBorrados()
    {
        return this.nodosBorrados;
    }
    
    public java.lang.Object[] getNodosBorradosBackingList()
    {
        java.lang.Object[] values = this.nodosBorradosValueList;
        java.lang.Object[] labels = this.nodosBorradosLabelList;

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

    public java.lang.Object[] getNodosBorradosValueList()
    {
        return this.nodosBorradosValueList;
    }

    public void setNodosBorradosValueList(java.lang.Object[] nodosBorradosValueList)
    {
        this.nodosBorradosValueList = nodosBorradosValueList;
    }

    public java.lang.Object[] getNodosBorradosLabelList()
    {
        return this.nodosBorradosLabelList;
    }

    public void setNodosBorradosLabelList(java.lang.Object[] nodosBorradosLabelList)
    {
        this.nodosBorradosLabelList = nodosBorradosLabelList;
    }

    public void setNodosBorradosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmarAceptarFormImpl.setNodosBorradosBackingList requires non-null property arguments");
        }

        this.nodosBorradosValueList = null;
        this.nodosBorradosLabelList = null;

        if (items != null)
        {
            this.nodosBorradosValueList = new java.lang.Object[items.size()];
            this.nodosBorradosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nodosBorradosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nodosBorradosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmarAceptarFormImpl.setNodosBorradosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listaId</code>.
     */
    public void resetListaId()
    {
        this.listaId = null;
    }

    public void setListaId(java.lang.String listaId)
    {
        this.listaId = listaId;
    }

    /**
     * 
     */
    public java.lang.String getListaId()
    {
        return this.listaId;
    }
    
    public java.lang.Object[] getListaIdBackingList()
    {
        java.lang.Object[] values = this.listaIdValueList;
        java.lang.Object[] labels = this.listaIdLabelList;

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

    public java.lang.Object[] getListaIdValueList()
    {
        return this.listaIdValueList;
    }

    public void setListaIdValueList(java.lang.Object[] listaIdValueList)
    {
        this.listaIdValueList = listaIdValueList;
    }

    public java.lang.Object[] getListaIdLabelList()
    {
        return this.listaIdLabelList;
    }

    public void setListaIdLabelList(java.lang.Object[] listaIdLabelList)
    {
        this.listaIdLabelList = listaIdLabelList;
    }

    public void setListaIdBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmarAceptarFormImpl.setListaIdBackingList requires non-null property arguments");
        }

        this.listaIdValueList = null;
        this.listaIdLabelList = null;

        if (items != null)
        {
            this.listaIdValueList = new java.lang.Object[items.size()];
            this.listaIdLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listaIdValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listaIdLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmarAceptarFormImpl.setListaIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nodos</code>.
     */
    public void resetNodos()
    {
        this.nodos = null;
    }

    public void setNodos(es.pode.buscar.negocio.administrar.servicio.NodoVO[] nodos)
    {
        this.nodos = nodos;
    }

    /**
     * 
     */
    public es.pode.buscar.negocio.administrar.servicio.NodoVO[] getNodos()
    {
        return this.nodos;
    }
    
    public java.lang.Object[] getNodosBackingList()
    {
        java.lang.Object[] values = this.nodosValueList;
        java.lang.Object[] labels = this.nodosLabelList;

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

    public java.lang.Object[] getNodosValueList()
    {
        return this.nodosValueList;
    }

    public void setNodosValueList(java.lang.Object[] nodosValueList)
    {
        this.nodosValueList = nodosValueList;
    }

    public java.lang.Object[] getNodosLabelList()
    {
        return this.nodosLabelList;
    }

    public void setNodosLabelList(java.lang.Object[] nodosLabelList)
    {
        this.nodosLabelList = nodosLabelList;
    }

    public void setNodosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmarAceptarFormImpl.setNodosBackingList requires non-null property arguments");
        }

        this.nodosValueList = null;
        this.nodosLabelList = null;

        if (items != null)
        {
            this.nodosValueList = new java.lang.Object[items.size()];
            this.nodosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nodosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nodosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmarAceptarFormImpl.setNodosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ConfirmarAceptarFormImpl.setDescripcionBajaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ConfirmarAceptarFormImpl.setDescripcionBajaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.nodosBorrados = null;
        this.nodos = null;
        this.nodosValueList = new java.lang.Object[0];
        this.nodosLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("nodosBorrados", this.nodosBorrados);
        builder.append("listaId", this.listaId);
        builder.append("nodos", this.nodos);
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
        this.nodosBorrados = null;
        this.nodosBorradosValueList = null;
        this.nodosBorradosLabelList = null;
        this.listaId = null;
        this.listaIdValueList = null;
        this.listaIdLabelList = null;
        this.nodos = null;
        this.nodosValueList = null;
        this.nodosLabelList = null;
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
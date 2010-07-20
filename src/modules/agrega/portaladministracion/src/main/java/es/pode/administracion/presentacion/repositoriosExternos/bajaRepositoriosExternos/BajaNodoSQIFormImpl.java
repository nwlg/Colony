// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.bajaRepositoriosExternos;

public class BajaNodoSQIFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.repositoriosExternos.bajaRepositoriosExternos.ObtenerNodosSQIForm
{
    private java.lang.String listaId;
    private java.lang.Object[] listaIdValueList;
    private java.lang.Object[] listaIdLabelList;
    private java.util.Collection ids;
    private java.lang.Object[] idsValueList;
    private java.lang.Object[] idsLabelList;
    private java.util.Collection nodosSQIEliminar;
    private java.lang.Object[] nodosSQIEliminarValueList;
    private java.lang.Object[] nodosSQIEliminarLabelList;
    private es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO[] nodosSQI;
    private java.lang.Object[] nodosSQIValueList;
    private java.lang.Object[] nodosSQILabelList;

    public BajaNodoSQIFormImpl()
    {
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
     * <p>
     * Lista de identificadores para dar de baja
     * </p>
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
            throw new IllegalArgumentException("BajaNodoSQIFormImpl.setListaIdBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("BajaNodoSQIFormImpl.setListaIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ids</code>.
     */
    public void resetIds()
    {
        this.ids = null;
    }

    public void setIds(java.util.Collection ids)
    {
        this.ids = ids;
    }

    /**
     * <p>
     * Coleccion de identificadores
     * </p>
     */
    public java.util.Collection getIds()
    {
        return this.ids;
    }

    public void setIdsAsArray(Object[] ids)
    {
        this.ids = (ids == null) ? null : java.util.Arrays.asList(ids);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.repositoriosExternos.bajaRepositoriosExternos.BajaNodoSQIFormImpl#getIds
     */
    public java.lang.Object[] getIdsAsArray()
    {
        return (ids == null) ? null : ids.toArray();
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
            throw new IllegalArgumentException("BajaNodoSQIFormImpl.setIdsBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("BajaNodoSQIFormImpl.setIdsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nodosSQIEliminar</code>.
     */
    public void resetNodosSQIEliminar()
    {
        this.nodosSQIEliminar = null;
    }

    public void setNodosSQIEliminar(java.util.Collection nodosSQIEliminar)
    {
        this.nodosSQIEliminar = nodosSQIEliminar;
    }

    /**
     * <p>
     * Nodos de tipo SQI que se quieren eliminar
     * </p>
     */
    public java.util.Collection getNodosSQIEliminar()
    {
        return this.nodosSQIEliminar;
    }

    public void setNodosSQIEliminarAsArray(Object[] nodosSQIEliminar)
    {
        this.nodosSQIEliminar = (nodosSQIEliminar == null) ? null : java.util.Arrays.asList(nodosSQIEliminar);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.repositoriosExternos.bajaRepositoriosExternos.BajaNodoSQIFormImpl#getNodosSQIEliminar
     */
    public java.lang.Object[] getNodosSQIEliminarAsArray()
    {
        return (nodosSQIEliminar == null) ? null : nodosSQIEliminar.toArray();
    }
    
    public java.lang.Object[] getNodosSQIEliminarBackingList()
    {
        java.lang.Object[] values = this.nodosSQIEliminarValueList;
        java.lang.Object[] labels = this.nodosSQIEliminarLabelList;

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

    public java.lang.Object[] getNodosSQIEliminarValueList()
    {
        return this.nodosSQIEliminarValueList;
    }

    public void setNodosSQIEliminarValueList(java.lang.Object[] nodosSQIEliminarValueList)
    {
        this.nodosSQIEliminarValueList = nodosSQIEliminarValueList;
    }

    public java.lang.Object[] getNodosSQIEliminarLabelList()
    {
        return this.nodosSQIEliminarLabelList;
    }

    public void setNodosSQIEliminarLabelList(java.lang.Object[] nodosSQIEliminarLabelList)
    {
        this.nodosSQIEliminarLabelList = nodosSQIEliminarLabelList;
    }

    public void setNodosSQIEliminarBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("BajaNodoSQIFormImpl.setNodosSQIEliminarBackingList requires non-null property arguments");
        }

        this.nodosSQIEliminarValueList = null;
        this.nodosSQIEliminarLabelList = null;

        if (items != null)
        {
            this.nodosSQIEliminarValueList = new java.lang.Object[items.size()];
            this.nodosSQIEliminarLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nodosSQIEliminarValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nodosSQIEliminarLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("BajaNodoSQIFormImpl.setNodosSQIEliminarBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nodosSQI</code>.
     */
    public void resetNodosSQI()
    {
        this.nodosSQI = null;
    }

    public void setNodosSQI(es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO[] nodosSQI)
    {
        this.nodosSQI = nodosSQI;
    }

    /**
     * <p>
     * Nodos de tipo SQI
     * </p>
     */
    public es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO[] getNodosSQI()
    {
        return this.nodosSQI;
    }
    
    public java.lang.Object[] getNodosSQIBackingList()
    {
        java.lang.Object[] values = this.nodosSQIValueList;
        java.lang.Object[] labels = this.nodosSQILabelList;

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

    public java.lang.Object[] getNodosSQIValueList()
    {
        return this.nodosSQIValueList;
    }

    public void setNodosSQIValueList(java.lang.Object[] nodosSQIValueList)
    {
        this.nodosSQIValueList = nodosSQIValueList;
    }

    public java.lang.Object[] getNodosSQILabelList()
    {
        return this.nodosSQILabelList;
    }

    public void setNodosSQILabelList(java.lang.Object[] nodosSQILabelList)
    {
        this.nodosSQILabelList = nodosSQILabelList;
    }

    public void setNodosSQIBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("BajaNodoSQIFormImpl.setNodosSQIBackingList requires non-null property arguments");
        }

        this.nodosSQIValueList = null;
        this.nodosSQILabelList = null;

        if (items != null)
        {
            this.nodosSQIValueList = new java.lang.Object[items.size()];
            this.nodosSQILabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nodosSQIValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nodosSQILabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("BajaNodoSQIFormImpl.setNodosSQIBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.nodosSQIEliminar = null;
        this.nodosSQIEliminarValueList = new java.lang.Object[0];
        this.nodosSQIEliminarLabelList = new java.lang.Object[0];
        this.nodosSQI = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("listaId", this.listaId);
        builder.append("ids", this.ids);
        builder.append("nodosSQIEliminar", this.nodosSQIEliminar);
        builder.append("nodosSQI", this.nodosSQI);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.listaId = null;
        this.listaIdValueList = null;
        this.listaIdLabelList = null;
        this.ids = null;
        this.idsValueList = null;
        this.idsLabelList = null;
        this.nodosSQIEliminar = null;
        this.nodosSQIEliminarValueList = null;
        this.nodosSQIEliminarLabelList = null;
        this.nodosSQI = null;
        this.nodosSQIValueList = null;
        this.nodosSQILabelList = null;
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
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion;

public class ConfirmacionEliminarDatosASesionFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.GuardarEnSesionForm
{
    private java.lang.String botonPulsado;
    private java.lang.Object[] botonPulsadoValueList;
    private java.lang.Object[] botonPulsadoLabelList;
    private java.util.Collection listadoClasificacion;
    private java.lang.Object[] listadoClasificacionValueList;
    private java.lang.Object[] listadoClasificacionLabelList;
    private java.lang.String tituloClasificacion;
    private java.lang.Object[] tituloClasificacionValueList;
    private java.lang.Object[] tituloClasificacionLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;

    public ConfirmacionEliminarDatosASesionFormImpl()
    {
    }

    /**
     * Resets the given <code>botonPulsado</code>.
     */
    public void resetBotonPulsado()
    {
        this.botonPulsado = null;
    }

    public void setBotonPulsado(java.lang.String botonPulsado)
    {
        this.botonPulsado = botonPulsado;
    }

    /**
     * 
     */
    public java.lang.String getBotonPulsado()
    {
        return this.botonPulsado;
    }
    
    public java.lang.Object[] getBotonPulsadoBackingList()
    {
        java.lang.Object[] values = this.botonPulsadoValueList;
        java.lang.Object[] labels = this.botonPulsadoLabelList;

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

    public java.lang.Object[] getBotonPulsadoValueList()
    {
        return this.botonPulsadoValueList;
    }

    public void setBotonPulsadoValueList(java.lang.Object[] botonPulsadoValueList)
    {
        this.botonPulsadoValueList = botonPulsadoValueList;
    }

    public java.lang.Object[] getBotonPulsadoLabelList()
    {
        return this.botonPulsadoLabelList;
    }

    public void setBotonPulsadoLabelList(java.lang.Object[] botonPulsadoLabelList)
    {
        this.botonPulsadoLabelList = botonPulsadoLabelList;
    }

    public void setBotonPulsadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionEliminarDatosASesionFormImpl.setBotonPulsadoBackingList requires non-null property arguments");
        }

        this.botonPulsadoValueList = null;
        this.botonPulsadoLabelList = null;

        if (items != null)
        {
            this.botonPulsadoValueList = new java.lang.Object[items.size()];
            this.botonPulsadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.botonPulsadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.botonPulsadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionEliminarDatosASesionFormImpl.setBotonPulsadoBackingList encountered an exception", ex);
            }
        }
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.ConfirmacionEliminarDatosASesionFormImpl#getListadoClasificacion
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
            throw new IllegalArgumentException("ConfirmacionEliminarDatosASesionFormImpl.setListadoClasificacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ConfirmacionEliminarDatosASesionFormImpl.setListadoClasificacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tituloClasificacion</code>.
     */
    public void resetTituloClasificacion()
    {
        this.tituloClasificacion = null;
    }

    public void setTituloClasificacion(java.lang.String tituloClasificacion)
    {
        this.tituloClasificacion = tituloClasificacion;
    }

    /**
     * 
     */
    public java.lang.String getTituloClasificacion()
    {
        return this.tituloClasificacion;
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
            throw new IllegalArgumentException("ConfirmacionEliminarDatosASesionFormImpl.setTituloClasificacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ConfirmacionEliminarDatosASesionFormImpl.setTituloClasificacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificadorOde</code>.
     */
    public void resetIdentificadorOde()
    {
        this.identificadorOde = null;
    }

    public void setIdentificadorOde(java.lang.String identificadorOde)
    {
        this.identificadorOde = identificadorOde;
    }

    /**
     * 
     */
    public java.lang.String getIdentificadorOde()
    {
        return this.identificadorOde;
    }
    
    public java.lang.Object[] getIdentificadorOdeBackingList()
    {
        java.lang.Object[] values = this.identificadorOdeValueList;
        java.lang.Object[] labels = this.identificadorOdeLabelList;

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

    public java.lang.Object[] getIdentificadorOdeValueList()
    {
        return this.identificadorOdeValueList;
    }

    public void setIdentificadorOdeValueList(java.lang.Object[] identificadorOdeValueList)
    {
        this.identificadorOdeValueList = identificadorOdeValueList;
    }

    public java.lang.Object[] getIdentificadorOdeLabelList()
    {
        return this.identificadorOdeLabelList;
    }

    public void setIdentificadorOdeLabelList(java.lang.Object[] identificadorOdeLabelList)
    {
        this.identificadorOdeLabelList = identificadorOdeLabelList;
    }

    public void setIdentificadorOdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionEliminarDatosASesionFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
        }

        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;

        if (items != null)
        {
            this.identificadorOdeValueList = new java.lang.Object[items.size()];
            this.identificadorOdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadorOdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadorOdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionEliminarDatosASesionFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
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
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("botonPulsado", this.botonPulsado);
        builder.append("listadoClasificacion", this.listadoClasificacion);
        builder.append("tituloClasificacion", this.tituloClasificacion);
        builder.append("identificadorOde", this.identificadorOde);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.botonPulsado = null;
        this.botonPulsadoValueList = null;
        this.botonPulsadoLabelList = null;
        this.listadoClasificacion = null;
        this.listadoClasificacionValueList = null;
        this.listadoClasificacionLabelList = null;
        this.tituloClasificacion = null;
        this.tituloClasificacionValueList = null;
        this.tituloClasificacionLabelList = null;
        this.identificadorOde = null;
        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;
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
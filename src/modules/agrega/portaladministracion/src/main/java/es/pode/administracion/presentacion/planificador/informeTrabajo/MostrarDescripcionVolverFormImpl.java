// license-header java merge-point
package es.pode.administracion.presentacion.planificador.informeTrabajo;

public class MostrarDescripcionVolverFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.planificador.informeTrabajo.ObtenerInformeTrabajoForm
{
    private java.lang.Long id;
    private java.lang.Object[] idValueList;
    private java.lang.Object[] idLabelList;
    private java.lang.String trabajo;
    private java.lang.Object[] trabajoValueList;
    private java.lang.Object[] trabajoLabelList;
    private java.lang.String descripcion;
    private java.lang.Object[] descripcionValueList;
    private java.lang.Object[] descripcionLabelList;
    private java.lang.String fechaFin;
    private java.lang.Object[] fechaFinValueList;
    private java.lang.Object[] fechaFinLabelList;
    private java.util.Collection informeTrabajo = null;
    private java.lang.Object[] informeTrabajoValueList;
    private java.lang.Object[] informeTrabajoLabelList;
    private java.lang.String fechaInicio;
    private java.lang.Object[] fechaInicioValueList;
    private java.lang.Object[] fechaInicioLabelList;

    public MostrarDescripcionVolverFormImpl()
    {
    }

    /**
     * Resets the given <code>id</code>.
     */
    public void resetId()
    {
        this.id = null;
    }

    public void setId(java.lang.Long id)
    {
        this.id = id;
    }

    /**
     * 
     */
    public java.lang.Long getId()
    {
        return this.id;
    }
    
    public java.lang.Object[] getIdBackingList()
    {
        java.lang.Object[] values = this.idValueList;
        java.lang.Object[] labels = this.idLabelList;

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

    public java.lang.Object[] getIdValueList()
    {
        return this.idValueList;
    }

    public void setIdValueList(java.lang.Object[] idValueList)
    {
        this.idValueList = idValueList;
    }

    public java.lang.Object[] getIdLabelList()
    {
        return this.idLabelList;
    }

    public void setIdLabelList(java.lang.Object[] idLabelList)
    {
        this.idLabelList = idLabelList;
    }

    public void setIdBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDescripcionVolverFormImpl.setIdBackingList requires non-null property arguments");
        }

        this.idValueList = null;
        this.idLabelList = null;

        if (items != null)
        {
            this.idValueList = new java.lang.Object[items.size()];
            this.idLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDescripcionVolverFormImpl.setIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>trabajo</code>.
     */
    public void resetTrabajo()
    {
        this.trabajo = null;
    }

    public void setTrabajo(java.lang.String trabajo)
    {
        this.trabajo = trabajo;
    }

    /**
     * 
     */
    public java.lang.String getTrabajo()
    {
        return this.trabajo;
    }
    
    public java.lang.Object[] getTrabajoBackingList()
    {
        java.lang.Object[] values = this.trabajoValueList;
        java.lang.Object[] labels = this.trabajoLabelList;

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

    public java.lang.Object[] getTrabajoValueList()
    {
        return this.trabajoValueList;
    }

    public void setTrabajoValueList(java.lang.Object[] trabajoValueList)
    {
        this.trabajoValueList = trabajoValueList;
    }

    public java.lang.Object[] getTrabajoLabelList()
    {
        return this.trabajoLabelList;
    }

    public void setTrabajoLabelList(java.lang.Object[] trabajoLabelList)
    {
        this.trabajoLabelList = trabajoLabelList;
    }

    public void setTrabajoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDescripcionVolverFormImpl.setTrabajoBackingList requires non-null property arguments");
        }

        this.trabajoValueList = null;
        this.trabajoLabelList = null;

        if (items != null)
        {
            this.trabajoValueList = new java.lang.Object[items.size()];
            this.trabajoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.trabajoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.trabajoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDescripcionVolverFormImpl.setTrabajoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcion</code>.
     */
    public void resetDescripcion()
    {
        this.descripcion = null;
    }

    public void setDescripcion(java.lang.String descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * 
     */
    public java.lang.String getDescripcion()
    {
        return this.descripcion;
    }
    
    public java.lang.Object[] getDescripcionBackingList()
    {
        java.lang.Object[] values = this.descripcionValueList;
        java.lang.Object[] labels = this.descripcionLabelList;

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

    public java.lang.Object[] getDescripcionValueList()
    {
        return this.descripcionValueList;
    }

    public void setDescripcionValueList(java.lang.Object[] descripcionValueList)
    {
        this.descripcionValueList = descripcionValueList;
    }

    public java.lang.Object[] getDescripcionLabelList()
    {
        return this.descripcionLabelList;
    }

    public void setDescripcionLabelList(java.lang.Object[] descripcionLabelList)
    {
        this.descripcionLabelList = descripcionLabelList;
    }

    public void setDescripcionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDescripcionVolverFormImpl.setDescripcionBackingList requires non-null property arguments");
        }

        this.descripcionValueList = null;
        this.descripcionLabelList = null;

        if (items != null)
        {
            this.descripcionValueList = new java.lang.Object[items.size()];
            this.descripcionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDescripcionVolverFormImpl.setDescripcionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>fechaFin</code>.
     */
    public void resetFechaFin()
    {
        this.fechaFin = null;
    }

    public void setFechaFin(java.lang.String fechaFin)
    {
        this.fechaFin = fechaFin;
    }

    /**
     * 
     */
    public java.lang.String getFechaFin()
    {
        return this.fechaFin;
    }
    
    public java.lang.Object[] getFechaFinBackingList()
    {
        java.lang.Object[] values = this.fechaFinValueList;
        java.lang.Object[] labels = this.fechaFinLabelList;

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

    public java.lang.Object[] getFechaFinValueList()
    {
        return this.fechaFinValueList;
    }

    public void setFechaFinValueList(java.lang.Object[] fechaFinValueList)
    {
        this.fechaFinValueList = fechaFinValueList;
    }

    public java.lang.Object[] getFechaFinLabelList()
    {
        return this.fechaFinLabelList;
    }

    public void setFechaFinLabelList(java.lang.Object[] fechaFinLabelList)
    {
        this.fechaFinLabelList = fechaFinLabelList;
    }

    public void setFechaFinBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDescripcionVolverFormImpl.setFechaFinBackingList requires non-null property arguments");
        }

        this.fechaFinValueList = null;
        this.fechaFinLabelList = null;

        if (items != null)
        {
            this.fechaFinValueList = new java.lang.Object[items.size()];
            this.fechaFinLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.fechaFinValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.fechaFinLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDescripcionVolverFormImpl.setFechaFinBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>informeTrabajo</code>.
     */
    public void resetInformeTrabajo()
    {
        this.informeTrabajo = null;
    }

    public void setInformeTrabajo(java.util.Collection informeTrabajo)
    {
        this.informeTrabajo = informeTrabajo;
    }

    /**
     * 
     */
    public java.util.Collection getInformeTrabajo()
    {
        return this.informeTrabajo;
    }

    public void setInformeTrabajoAsArray(Object[] informeTrabajo)
    {
        this.informeTrabajo = (informeTrabajo == null) ? null : java.util.Arrays.asList(informeTrabajo);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.planificador.informeTrabajo.MostrarDescripcionVolverFormImpl#getInformeTrabajo
     */
    public java.lang.Object[] getInformeTrabajoAsArray()
    {
        return (informeTrabajo == null) ? null : informeTrabajo.toArray();
    }
    
    public java.lang.Object[] getInformeTrabajoBackingList()
    {
        java.lang.Object[] values = this.informeTrabajoValueList;
        java.lang.Object[] labels = this.informeTrabajoLabelList;

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

    public java.lang.Object[] getInformeTrabajoValueList()
    {
        return this.informeTrabajoValueList;
    }

    public void setInformeTrabajoValueList(java.lang.Object[] informeTrabajoValueList)
    {
        this.informeTrabajoValueList = informeTrabajoValueList;
    }

    public java.lang.Object[] getInformeTrabajoLabelList()
    {
        return this.informeTrabajoLabelList;
    }

    public void setInformeTrabajoLabelList(java.lang.Object[] informeTrabajoLabelList)
    {
        this.informeTrabajoLabelList = informeTrabajoLabelList;
    }

    public void setInformeTrabajoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDescripcionVolverFormImpl.setInformeTrabajoBackingList requires non-null property arguments");
        }

        this.informeTrabajoValueList = null;
        this.informeTrabajoLabelList = null;

        if (items != null)
        {
            this.informeTrabajoValueList = new java.lang.Object[items.size()];
            this.informeTrabajoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.informeTrabajoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.informeTrabajoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDescripcionVolverFormImpl.setInformeTrabajoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>fechaInicio</code>.
     */
    public void resetFechaInicio()
    {
        this.fechaInicio = null;
    }

    public void setFechaInicio(java.lang.String fechaInicio)
    {
        this.fechaInicio = fechaInicio;
    }

    /**
     * 
     */
    public java.lang.String getFechaInicio()
    {
        return this.fechaInicio;
    }
    
    public java.lang.Object[] getFechaInicioBackingList()
    {
        java.lang.Object[] values = this.fechaInicioValueList;
        java.lang.Object[] labels = this.fechaInicioLabelList;

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

    public java.lang.Object[] getFechaInicioValueList()
    {
        return this.fechaInicioValueList;
    }

    public void setFechaInicioValueList(java.lang.Object[] fechaInicioValueList)
    {
        this.fechaInicioValueList = fechaInicioValueList;
    }

    public java.lang.Object[] getFechaInicioLabelList()
    {
        return this.fechaInicioLabelList;
    }

    public void setFechaInicioLabelList(java.lang.Object[] fechaInicioLabelList)
    {
        this.fechaInicioLabelList = fechaInicioLabelList;
    }

    public void setFechaInicioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDescripcionVolverFormImpl.setFechaInicioBackingList requires non-null property arguments");
        }

        this.fechaInicioValueList = null;
        this.fechaInicioLabelList = null;

        if (items != null)
        {
            this.fechaInicioValueList = new java.lang.Object[items.size()];
            this.fechaInicioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.fechaInicioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.fechaInicioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDescripcionVolverFormImpl.setFechaInicioBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("id", this.id);
        builder.append("trabajo", this.trabajo);
        builder.append("descripcion", this.descripcion);
        builder.append("fechaFin", this.fechaFin);
        builder.append("informeTrabajo", this.informeTrabajo);
        builder.append("fechaInicio", this.fechaInicio);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.id = null;
        this.idValueList = null;
        this.idLabelList = null;
        this.trabajo = null;
        this.trabajoValueList = null;
        this.trabajoLabelList = null;
        this.descripcion = null;
        this.descripcionValueList = null;
        this.descripcionLabelList = null;
        this.fechaFin = null;
        this.fechaFinValueList = null;
        this.fechaFinLabelList = null;
        this.informeTrabajo = null;
        this.informeTrabajoValueList = null;
        this.informeTrabajoLabelList = null;
        this.fechaInicio = null;
        this.fechaInicioValueList = null;
        this.fechaInicioLabelList = null;
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
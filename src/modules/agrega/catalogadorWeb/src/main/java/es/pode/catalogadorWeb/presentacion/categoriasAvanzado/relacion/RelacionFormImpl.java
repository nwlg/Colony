// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion;

public class RelacionFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.CargarRelacionesForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.HayRelacionesForm
{
    private java.lang.String botonPulsado;
    private java.lang.Object[] botonPulsadoValueList;
    private java.lang.Object[] botonPulsadoLabelList;
    private java.lang.String tituloRelacion;
    private java.lang.Object[] tituloRelacionValueList;
    private java.lang.Object[] tituloRelacionLabelList;
    private java.lang.String identificador;
    private java.lang.Object[] identificadorValueList;
    private java.lang.Object[] identificadorLabelList;
    private java.util.Collection datos;
    private java.lang.Object[] datosValueList;
    private java.lang.Object[] datosLabelList;
    private java.util.Collection listadoRelaciones;
    private java.lang.Object[] listadoRelacionesValueList;
    private java.lang.Object[] listadoRelacionesLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;
    private java.lang.String returnURL;
    private java.lang.Object[] returnURLValueList;
    private java.lang.Object[] returnURLLabelList;

    public RelacionFormImpl()
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
            throw new IllegalArgumentException("RelacionFormImpl.setBotonPulsadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("RelacionFormImpl.setBotonPulsadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tituloRelacion</code>.
     */
    public void resetTituloRelacion()
    {
        this.tituloRelacion = null;
    }

    public void setTituloRelacion(java.lang.String tituloRelacion)
    {
        this.tituloRelacion = tituloRelacion;
    }

    /**
     * 
     */
    public java.lang.String getTituloRelacion()
    {
        return this.tituloRelacion;
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
            throw new IllegalArgumentException("RelacionFormImpl.setTituloRelacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("RelacionFormImpl.setTituloRelacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificador</code>.
     */
    public void resetIdentificador()
    {
        this.identificador = null;
    }

    public void setIdentificador(java.lang.String identificador)
    {
        this.identificador = identificador;
    }

    /**
     * 
     */
    public java.lang.String getIdentificador()
    {
        return this.identificador;
    }
    
    public java.lang.Object[] getIdentificadorBackingList()
    {
        java.lang.Object[] values = this.identificadorValueList;
        java.lang.Object[] labels = this.identificadorLabelList;

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

    public java.lang.Object[] getIdentificadorValueList()
    {
        return this.identificadorValueList;
    }

    public void setIdentificadorValueList(java.lang.Object[] identificadorValueList)
    {
        this.identificadorValueList = identificadorValueList;
    }

    public java.lang.Object[] getIdentificadorLabelList()
    {
        return this.identificadorLabelList;
    }

    public void setIdentificadorLabelList(java.lang.Object[] identificadorLabelList)
    {
        this.identificadorLabelList = identificadorLabelList;
    }

    public void setIdentificadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RelacionFormImpl.setIdentificadorBackingList requires non-null property arguments");
        }

        this.identificadorValueList = null;
        this.identificadorLabelList = null;

        if (items != null)
        {
            this.identificadorValueList = new java.lang.Object[items.size()];
            this.identificadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RelacionFormImpl.setIdentificadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>datos</code>.
     */
    public void resetDatos()
    {
        this.datos = null;
    }

    public void setDatos(java.util.Collection datos)
    {
        this.datos = datos;
    }

    /**
     * 
     */
    public java.util.Collection getDatos()
    {
        return this.datos;
    }

    public void setDatosAsArray(Object[] datos)
    {
        this.datos = (datos == null) ? null : java.util.Arrays.asList(datos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.RelacionFormImpl#getDatos
     */
    public java.lang.Object[] getDatosAsArray()
    {
        return (datos == null) ? null : datos.toArray();
    }
    
    public java.lang.Object[] getDatosBackingList()
    {
        java.lang.Object[] values = this.datosValueList;
        java.lang.Object[] labels = this.datosLabelList;

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

    public java.lang.Object[] getDatosValueList()
    {
        return this.datosValueList;
    }

    public void setDatosValueList(java.lang.Object[] datosValueList)
    {
        this.datosValueList = datosValueList;
    }

    public java.lang.Object[] getDatosLabelList()
    {
        return this.datosLabelList;
    }

    public void setDatosLabelList(java.lang.Object[] datosLabelList)
    {
        this.datosLabelList = datosLabelList;
    }

    public void setDatosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RelacionFormImpl.setDatosBackingList requires non-null property arguments");
        }

        this.datosValueList = null;
        this.datosLabelList = null;

        if (items != null)
        {
            this.datosValueList = new java.lang.Object[items.size()];
            this.datosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.datosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.datosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RelacionFormImpl.setDatosBackingList encountered an exception", ex);
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.relacion.RelacionFormImpl#getListadoRelaciones
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
            throw new IllegalArgumentException("RelacionFormImpl.setListadoRelacionesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("RelacionFormImpl.setListadoRelacionesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("RelacionFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("RelacionFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>returnURL</code>.
     */
    public void resetReturnURL()
    {
        this.returnURL = null;
    }

    public void setReturnURL(java.lang.String returnURL)
    {
        this.returnURL = returnURL;
    }

    /**
     * 
     */
    public java.lang.String getReturnURL()
    {
        return this.returnURL;
    }
    
    public java.lang.Object[] getReturnURLBackingList()
    {
        java.lang.Object[] values = this.returnURLValueList;
        java.lang.Object[] labels = this.returnURLLabelList;

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

    public java.lang.Object[] getReturnURLValueList()
    {
        return this.returnURLValueList;
    }

    public void setReturnURLValueList(java.lang.Object[] returnURLValueList)
    {
        this.returnURLValueList = returnURLValueList;
    }

    public java.lang.Object[] getReturnURLLabelList()
    {
        return this.returnURLLabelList;
    }

    public void setReturnURLLabelList(java.lang.Object[] returnURLLabelList)
    {
        this.returnURLLabelList = returnURLLabelList;
    }

    public void setReturnURLBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RelacionFormImpl.setReturnURLBackingList requires non-null property arguments");
        }

        this.returnURLValueList = null;
        this.returnURLLabelList = null;

        if (items != null)
        {
            this.returnURLValueList = new java.lang.Object[items.size()];
            this.returnURLLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.returnURLValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.returnURLLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RelacionFormImpl.setReturnURLBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.datos = null;
        this.datosValueList = new java.lang.Object[0];
        this.datosLabelList = new java.lang.Object[0];
        this.listadoRelaciones = null;
        this.listadoRelacionesValueList = new java.lang.Object[0];
        this.listadoRelacionesLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("botonPulsado", this.botonPulsado);
        builder.append("tituloRelacion", this.tituloRelacion);
        builder.append("identificador", this.identificador);
        builder.append("datos", this.datos);
        builder.append("listadoRelaciones", this.listadoRelaciones);
        builder.append("identificadorOde", this.identificadorOde);
        builder.append("returnURL", this.returnURL);
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
        this.tituloRelacion = null;
        this.tituloRelacionValueList = null;
        this.tituloRelacionLabelList = null;
        this.identificador = null;
        this.identificadorValueList = null;
        this.identificadorLabelList = null;
        this.datos = null;
        this.datosValueList = null;
        this.datosLabelList = null;
        this.listadoRelaciones = null;
        this.listadoRelacionesValueList = null;
        this.listadoRelacionesLabelList = null;
        this.identificadorOde = null;
        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;
        this.returnURL = null;
        this.returnURLValueList = null;
        this.returnURLLabelList = null;
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
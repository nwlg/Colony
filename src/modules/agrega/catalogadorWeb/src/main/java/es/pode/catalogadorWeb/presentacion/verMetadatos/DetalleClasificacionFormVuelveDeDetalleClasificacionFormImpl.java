// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

public class DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.verMetadatos.CargarClasificacionesForm
{
    private java.lang.String botonPulsado;
    private java.lang.Object[] botonPulsadoValueList;
    private java.lang.Object[] botonPulsadoLabelList;
    private java.lang.String source;
    private java.lang.Object[] sourceValueList;
    private java.lang.Object[] sourceLabelList;
    private java.lang.String comboIdioma;
    private java.lang.Object[] comboIdiomaValueList;
    private java.lang.Object[] comboIdiomaLabelList;
    private java.util.Collection listadoClasificaciones;
    private java.lang.Object[] listadoClasificacionesValueList;
    private java.lang.Object[] listadoClasificacionesLabelList;
    private java.lang.String proposito;
    private java.lang.Object[] propositoValueList;
    private java.lang.Object[] propositoLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;

    public DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl()
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
            throw new IllegalArgumentException("DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl.setBotonPulsadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl.setBotonPulsadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>source</code>.
     */
    public void resetSource()
    {
        this.source = null;
    }

    public void setSource(java.lang.String source)
    {
        this.source = source;
    }

    /**
     * 
     */
    public java.lang.String getSource()
    {
        return this.source;
    }
    
    public java.lang.Object[] getSourceBackingList()
    {
        java.lang.Object[] values = this.sourceValueList;
        java.lang.Object[] labels = this.sourceLabelList;

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

    public java.lang.Object[] getSourceValueList()
    {
        return this.sourceValueList;
    }

    public void setSourceValueList(java.lang.Object[] sourceValueList)
    {
        this.sourceValueList = sourceValueList;
    }

    public java.lang.Object[] getSourceLabelList()
    {
        return this.sourceLabelList;
    }

    public void setSourceLabelList(java.lang.Object[] sourceLabelList)
    {
        this.sourceLabelList = sourceLabelList;
    }

    public void setSourceBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl.setSourceBackingList requires non-null property arguments");
        }

        this.sourceValueList = null;
        this.sourceLabelList = null;

        if (items != null)
        {
            this.sourceValueList = new java.lang.Object[items.size()];
            this.sourceLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.sourceValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.sourceLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl.setSourceBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboIdioma</code>.
     */
    public void resetComboIdioma()
    {
        this.comboIdioma = null;
    }

    public void setComboIdioma(java.lang.String comboIdioma)
    {
        this.comboIdioma = comboIdioma;
    }

    /**
     * 
     */
    public java.lang.String getComboIdioma()
    {
        return this.comboIdioma;
    }
    
    public java.lang.Object[] getComboIdiomaBackingList()
    {
        java.lang.Object[] values = this.comboIdiomaValueList;
        java.lang.Object[] labels = this.comboIdiomaLabelList;

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

    public java.lang.Object[] getComboIdiomaValueList()
    {
        return this.comboIdiomaValueList;
    }

    public void setComboIdiomaValueList(java.lang.Object[] comboIdiomaValueList)
    {
        this.comboIdiomaValueList = comboIdiomaValueList;
    }

    public java.lang.Object[] getComboIdiomaLabelList()
    {
        return this.comboIdiomaLabelList;
    }

    public void setComboIdiomaLabelList(java.lang.Object[] comboIdiomaLabelList)
    {
        this.comboIdiomaLabelList = comboIdiomaLabelList;
    }

    public void setComboIdiomaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl.setComboIdiomaBackingList requires non-null property arguments");
        }

        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;

        if (items != null)
        {
            this.comboIdiomaValueList = new java.lang.Object[items.size()];
            this.comboIdiomaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboIdiomaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboIdiomaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl.setComboIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listadoClasificaciones</code>.
     */
    public void resetListadoClasificaciones()
    {
        this.listadoClasificaciones = null;
    }

    public void setListadoClasificaciones(java.util.Collection listadoClasificaciones)
    {
        this.listadoClasificaciones = listadoClasificaciones;
    }

    /**
     * 
     */
    public java.util.Collection getListadoClasificaciones()
    {
        return this.listadoClasificaciones;
    }

    public void setListadoClasificacionesAsArray(Object[] listadoClasificaciones)
    {
        this.listadoClasificaciones = (listadoClasificaciones == null) ? null : java.util.Arrays.asList(listadoClasificaciones);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl#getListadoClasificaciones
     */
    public java.lang.Object[] getListadoClasificacionesAsArray()
    {
        return (listadoClasificaciones == null) ? null : listadoClasificaciones.toArray();
    }
    
    public java.lang.Object[] getListadoClasificacionesBackingList()
    {
        java.lang.Object[] values = this.listadoClasificacionesValueList;
        java.lang.Object[] labels = this.listadoClasificacionesLabelList;

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

    public java.lang.Object[] getListadoClasificacionesValueList()
    {
        return this.listadoClasificacionesValueList;
    }

    public void setListadoClasificacionesValueList(java.lang.Object[] listadoClasificacionesValueList)
    {
        this.listadoClasificacionesValueList = listadoClasificacionesValueList;
    }

    public java.lang.Object[] getListadoClasificacionesLabelList()
    {
        return this.listadoClasificacionesLabelList;
    }

    public void setListadoClasificacionesLabelList(java.lang.Object[] listadoClasificacionesLabelList)
    {
        this.listadoClasificacionesLabelList = listadoClasificacionesLabelList;
    }

    public void setListadoClasificacionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl.setListadoClasificacionesBackingList requires non-null property arguments");
        }

        this.listadoClasificacionesValueList = null;
        this.listadoClasificacionesLabelList = null;

        if (items != null)
        {
            this.listadoClasificacionesValueList = new java.lang.Object[items.size()];
            this.listadoClasificacionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listadoClasificacionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listadoClasificacionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl.setListadoClasificacionesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>proposito</code>.
     */
    public void resetProposito()
    {
        this.proposito = null;
    }

    public void setProposito(java.lang.String proposito)
    {
        this.proposito = proposito;
    }

    /**
     * 
     */
    public java.lang.String getProposito()
    {
        return this.proposito;
    }
    
    public java.lang.Object[] getPropositoBackingList()
    {
        java.lang.Object[] values = this.propositoValueList;
        java.lang.Object[] labels = this.propositoLabelList;

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

    public java.lang.Object[] getPropositoValueList()
    {
        return this.propositoValueList;
    }

    public void setPropositoValueList(java.lang.Object[] propositoValueList)
    {
        this.propositoValueList = propositoValueList;
    }

    public java.lang.Object[] getPropositoLabelList()
    {
        return this.propositoLabelList;
    }

    public void setPropositoLabelList(java.lang.Object[] propositoLabelList)
    {
        this.propositoLabelList = propositoLabelList;
    }

    public void setPropositoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl.setPropositoBackingList requires non-null property arguments");
        }

        this.propositoValueList = null;
        this.propositoLabelList = null;

        if (items != null)
        {
            this.propositoValueList = new java.lang.Object[items.size()];
            this.propositoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.propositoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.propositoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl.setPropositoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleClasificacionFormVuelveDeDetalleClasificacionFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.source = null;
        this.comboIdioma = null;
        this.listadoClasificaciones = null;
        this.listadoClasificacionesValueList = new java.lang.Object[0];
        this.listadoClasificacionesLabelList = new java.lang.Object[0];
        this.proposito = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("botonPulsado", this.botonPulsado);
        builder.append("source", this.source);
        builder.append("comboIdioma", this.comboIdioma);
        builder.append("listadoClasificaciones", this.listadoClasificaciones);
        builder.append("proposito", this.proposito);
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
        this.source = null;
        this.sourceValueList = null;
        this.sourceLabelList = null;
        this.comboIdioma = null;
        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;
        this.listadoClasificaciones = null;
        this.listadoClasificacionesValueList = null;
        this.listadoClasificacionesLabelList = null;
        this.proposito = null;
        this.propositoValueList = null;
        this.propositoLabelList = null;
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
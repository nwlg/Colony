// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.tesauros;

public class RelacionesJerarquicasFormDatosRelacionFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.tesauros.AsociaRelacionForm
{
    private java.lang.String id;
    private java.lang.Object[] idValueList;
    private java.lang.Object[] idLabelList;
    private java.util.Collection rutaPadrevo;
    private java.lang.Object[] rutaPadrevoValueList;
    private java.lang.Object[] rutaPadrevoLabelList;
    private java.util.Collection jerarquias;
    private java.lang.Object[] jerarquiasValueList;
    private java.lang.Object[] jerarquiasLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.util.Collection taxonesvo;
    private java.lang.Object[] taxonesvoValueList;
    private java.lang.Object[] taxonesvoLabelList;
    private java.lang.String nomTesauro;
    private java.lang.Object[] nomTesauroValueList;
    private java.lang.Object[] nomTesauroLabelList;

    public RelacionesJerarquicasFormDatosRelacionFormImpl()
    {
    }

    /**
     * Resets the given <code>id</code>.
     */
    public void resetId()
    {
        this.id = null;
    }

    public void setId(java.lang.String id)
    {
        this.id = id;
    }

    /**
     * 
     */
    public java.lang.String getId()
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
            throw new IllegalArgumentException("RelacionesJerarquicasFormDatosRelacionFormImpl.setIdBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("RelacionesJerarquicasFormDatosRelacionFormImpl.setIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>rutaPadrevo</code>.
     */
    public void resetRutaPadrevo()
    {
        this.rutaPadrevo = null;
    }

    public void setRutaPadrevo(java.util.Collection rutaPadrevo)
    {
        this.rutaPadrevo = rutaPadrevo;
    }

    /**
     * 
     */
    public java.util.Collection getRutaPadrevo()
    {
        return this.rutaPadrevo;
    }

    public void setRutaPadrevoAsArray(Object[] rutaPadrevo)
    {
        this.rutaPadrevo = (rutaPadrevo == null) ? null : java.util.Arrays.asList(rutaPadrevo);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.tesauros.RelacionesJerarquicasFormDatosRelacionFormImpl#getRutaPadrevo
     */
    public java.lang.Object[] getRutaPadrevoAsArray()
    {
        return (rutaPadrevo == null) ? null : rutaPadrevo.toArray();
    }
    
    public java.lang.Object[] getRutaPadrevoBackingList()
    {
        java.lang.Object[] values = this.rutaPadrevoValueList;
        java.lang.Object[] labels = this.rutaPadrevoLabelList;

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

    public java.lang.Object[] getRutaPadrevoValueList()
    {
        return this.rutaPadrevoValueList;
    }

    public void setRutaPadrevoValueList(java.lang.Object[] rutaPadrevoValueList)
    {
        this.rutaPadrevoValueList = rutaPadrevoValueList;
    }

    public java.lang.Object[] getRutaPadrevoLabelList()
    {
        return this.rutaPadrevoLabelList;
    }

    public void setRutaPadrevoLabelList(java.lang.Object[] rutaPadrevoLabelList)
    {
        this.rutaPadrevoLabelList = rutaPadrevoLabelList;
    }

    public void setRutaPadrevoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RelacionesJerarquicasFormDatosRelacionFormImpl.setRutaPadrevoBackingList requires non-null property arguments");
        }

        this.rutaPadrevoValueList = null;
        this.rutaPadrevoLabelList = null;

        if (items != null)
        {
            this.rutaPadrevoValueList = new java.lang.Object[items.size()];
            this.rutaPadrevoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.rutaPadrevoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.rutaPadrevoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RelacionesJerarquicasFormDatosRelacionFormImpl.setRutaPadrevoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>jerarquias</code>.
     */
    public void resetJerarquias()
    {
        this.jerarquias = null;
    }

    public void setJerarquias(java.util.Collection jerarquias)
    {
        this.jerarquias = jerarquias;
    }

    /**
     * 
     */
    public java.util.Collection getJerarquias()
    {
        return this.jerarquias;
    }

    public void setJerarquiasAsArray(Object[] jerarquias)
    {
        this.jerarquias = (jerarquias == null) ? null : java.util.Arrays.asList(jerarquias);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.tesauros.RelacionesJerarquicasFormDatosRelacionFormImpl#getJerarquias
     */
    public java.lang.Object[] getJerarquiasAsArray()
    {
        return (jerarquias == null) ? null : jerarquias.toArray();
    }
    
    public java.lang.Object[] getJerarquiasBackingList()
    {
        java.lang.Object[] values = this.jerarquiasValueList;
        java.lang.Object[] labels = this.jerarquiasLabelList;

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

    public java.lang.Object[] getJerarquiasValueList()
    {
        return this.jerarquiasValueList;
    }

    public void setJerarquiasValueList(java.lang.Object[] jerarquiasValueList)
    {
        this.jerarquiasValueList = jerarquiasValueList;
    }

    public java.lang.Object[] getJerarquiasLabelList()
    {
        return this.jerarquiasLabelList;
    }

    public void setJerarquiasLabelList(java.lang.Object[] jerarquiasLabelList)
    {
        this.jerarquiasLabelList = jerarquiasLabelList;
    }

    public void setJerarquiasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RelacionesJerarquicasFormDatosRelacionFormImpl.setJerarquiasBackingList requires non-null property arguments");
        }

        this.jerarquiasValueList = null;
        this.jerarquiasLabelList = null;

        if (items != null)
        {
            this.jerarquiasValueList = new java.lang.Object[items.size()];
            this.jerarquiasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.jerarquiasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.jerarquiasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RelacionesJerarquicasFormDatosRelacionFormImpl.setJerarquiasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idioma</code>.
     */
    public void resetIdioma()
    {
        this.idioma = null;
    }

    public void setIdioma(java.lang.String idioma)
    {
        this.idioma = idioma;
    }

    /**
     * 
     */
    public java.lang.String getIdioma()
    {
        return this.idioma;
    }
    
    public java.lang.Object[] getIdiomaBackingList()
    {
        java.lang.Object[] values = this.idiomaValueList;
        java.lang.Object[] labels = this.idiomaLabelList;

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

    public java.lang.Object[] getIdiomaValueList()
    {
        return this.idiomaValueList;
    }

    public void setIdiomaValueList(java.lang.Object[] idiomaValueList)
    {
        this.idiomaValueList = idiomaValueList;
    }

    public java.lang.Object[] getIdiomaLabelList()
    {
        return this.idiomaLabelList;
    }

    public void setIdiomaLabelList(java.lang.Object[] idiomaLabelList)
    {
        this.idiomaLabelList = idiomaLabelList;
    }

    public void setIdiomaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RelacionesJerarquicasFormDatosRelacionFormImpl.setIdiomaBackingList requires non-null property arguments");
        }

        this.idiomaValueList = null;
        this.idiomaLabelList = null;

        if (items != null)
        {
            this.idiomaValueList = new java.lang.Object[items.size()];
            this.idiomaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RelacionesJerarquicasFormDatosRelacionFormImpl.setIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>taxonesvo</code>.
     */
    public void resetTaxonesvo()
    {
        this.taxonesvo = null;
    }

    public void setTaxonesvo(java.util.Collection taxonesvo)
    {
        this.taxonesvo = taxonesvo;
    }

    /**
     * 
     */
    public java.util.Collection getTaxonesvo()
    {
        return this.taxonesvo;
    }

    public void setTaxonesvoAsArray(Object[] taxonesvo)
    {
        this.taxonesvo = (taxonesvo == null) ? null : java.util.Arrays.asList(taxonesvo);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.tesauros.RelacionesJerarquicasFormDatosRelacionFormImpl#getTaxonesvo
     */
    public java.lang.Object[] getTaxonesvoAsArray()
    {
        return (taxonesvo == null) ? null : taxonesvo.toArray();
    }
    
    public java.lang.Object[] getTaxonesvoBackingList()
    {
        java.lang.Object[] values = this.taxonesvoValueList;
        java.lang.Object[] labels = this.taxonesvoLabelList;

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

    public java.lang.Object[] getTaxonesvoValueList()
    {
        return this.taxonesvoValueList;
    }

    public void setTaxonesvoValueList(java.lang.Object[] taxonesvoValueList)
    {
        this.taxonesvoValueList = taxonesvoValueList;
    }

    public java.lang.Object[] getTaxonesvoLabelList()
    {
        return this.taxonesvoLabelList;
    }

    public void setTaxonesvoLabelList(java.lang.Object[] taxonesvoLabelList)
    {
        this.taxonesvoLabelList = taxonesvoLabelList;
    }

    public void setTaxonesvoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RelacionesJerarquicasFormDatosRelacionFormImpl.setTaxonesvoBackingList requires non-null property arguments");
        }

        this.taxonesvoValueList = null;
        this.taxonesvoLabelList = null;

        if (items != null)
        {
            this.taxonesvoValueList = new java.lang.Object[items.size()];
            this.taxonesvoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.taxonesvoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.taxonesvoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RelacionesJerarquicasFormDatosRelacionFormImpl.setTaxonesvoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nomTesauro</code>.
     */
    public void resetNomTesauro()
    {
        this.nomTesauro = null;
    }

    public void setNomTesauro(java.lang.String nomTesauro)
    {
        this.nomTesauro = nomTesauro;
    }

    /**
     * 
     */
    public java.lang.String getNomTesauro()
    {
        return this.nomTesauro;
    }
    
    public java.lang.Object[] getNomTesauroBackingList()
    {
        java.lang.Object[] values = this.nomTesauroValueList;
        java.lang.Object[] labels = this.nomTesauroLabelList;

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

    public java.lang.Object[] getNomTesauroValueList()
    {
        return this.nomTesauroValueList;
    }

    public void setNomTesauroValueList(java.lang.Object[] nomTesauroValueList)
    {
        this.nomTesauroValueList = nomTesauroValueList;
    }

    public java.lang.Object[] getNomTesauroLabelList()
    {
        return this.nomTesauroLabelList;
    }

    public void setNomTesauroLabelList(java.lang.Object[] nomTesauroLabelList)
    {
        this.nomTesauroLabelList = nomTesauroLabelList;
    }

    public void setNomTesauroBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RelacionesJerarquicasFormDatosRelacionFormImpl.setNomTesauroBackingList requires non-null property arguments");
        }

        this.nomTesauroValueList = null;
        this.nomTesauroLabelList = null;

        if (items != null)
        {
            this.nomTesauroValueList = new java.lang.Object[items.size()];
            this.nomTesauroLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nomTesauroValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nomTesauroLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RelacionesJerarquicasFormDatosRelacionFormImpl.setNomTesauroBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.rutaPadrevo = null;
        this.rutaPadrevoValueList = new java.lang.Object[0];
        this.rutaPadrevoLabelList = new java.lang.Object[0];
        this.jerarquias = null;
        this.jerarquiasValueList = new java.lang.Object[0];
        this.jerarquiasLabelList = new java.lang.Object[0];
        this.taxonesvo = null;
        this.taxonesvoValueList = new java.lang.Object[0];
        this.taxonesvoLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("id", this.id);
        builder.append("rutaPadrevo", this.rutaPadrevo);
        builder.append("jerarquias", this.jerarquias);
        builder.append("idioma", this.idioma);
        builder.append("taxonesvo", this.taxonesvo);
        builder.append("nomTesauro", this.nomTesauro);
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
        this.rutaPadrevo = null;
        this.rutaPadrevoValueList = null;
        this.rutaPadrevoLabelList = null;
        this.jerarquias = null;
        this.jerarquiasValueList = null;
        this.jerarquiasLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.taxonesvo = null;
        this.taxonesvoValueList = null;
        this.taxonesvoLabelList = null;
        this.nomTesauro = null;
        this.nomTesauroValueList = null;
        this.nomTesauroLabelList = null;
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
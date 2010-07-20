// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor;

public class GestorSubmanifiestosFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.RecuperarDatosForm
{
    private java.util.List barraSubmanifiestos = null;
    private java.lang.Object[] barraSubmanifiestosValueList;
    private java.lang.Object[] barraSubmanifiestosLabelList;
    private java.util.List submanifiestos = null;
    private java.lang.Object[] submanifiestosValueList;
    private java.lang.Object[] submanifiestosLabelList;
    private java.lang.String identifier;
    private java.lang.Object[] identifierValueList;
    private java.lang.Object[] identifierLabelList;
    private java.lang.String returnURL;
    private java.lang.Object[] returnURLValueList;
    private java.lang.Object[] returnURLLabelList;

    public GestorSubmanifiestosFormImpl()
    {
    }

    /**
     * Resets the given <code>barraSubmanifiestos</code>.
     */
    public void resetBarraSubmanifiestos()
    {
        this.barraSubmanifiestos = null;
    }

    public void setBarraSubmanifiestos(java.util.List barraSubmanifiestos)
    {
        this.barraSubmanifiestos = barraSubmanifiestos;
    }

    /**
     * <p>
     * Lista de manifests para la barra superior de navegacion. Nos
     * indica en que Manifests estamos navegando, siendo la posición 0
     * el Manifest principal y los Manifest que le siguen su
     * submanifiesto, el submanifiesto de su submanifiesto, etc...
     * </p>
     */
    public java.util.List getBarraSubmanifiestos()
    {
        return this.barraSubmanifiestos;
    }

    public void setBarraSubmanifiestosAsArray(Object[] barraSubmanifiestos)
    {
        this.barraSubmanifiestos = (barraSubmanifiestos == null) ? null : java.util.Arrays.asList(barraSubmanifiestos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosFormImpl#getBarraSubmanifiestos
     */
    public java.lang.Object[] getBarraSubmanifiestosAsArray()
    {
        return (barraSubmanifiestos == null) ? null : barraSubmanifiestos.toArray();
    }
    
    public java.lang.Object[] getBarraSubmanifiestosBackingList()
    {
        java.lang.Object[] values = this.barraSubmanifiestosValueList;
        java.lang.Object[] labels = this.barraSubmanifiestosLabelList;

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

    public java.lang.Object[] getBarraSubmanifiestosValueList()
    {
        return this.barraSubmanifiestosValueList;
    }

    public void setBarraSubmanifiestosValueList(java.lang.Object[] barraSubmanifiestosValueList)
    {
        this.barraSubmanifiestosValueList = barraSubmanifiestosValueList;
    }

    public java.lang.Object[] getBarraSubmanifiestosLabelList()
    {
        return this.barraSubmanifiestosLabelList;
    }

    public void setBarraSubmanifiestosLabelList(java.lang.Object[] barraSubmanifiestosLabelList)
    {
        this.barraSubmanifiestosLabelList = barraSubmanifiestosLabelList;
    }

    public void setBarraSubmanifiestosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorSubmanifiestosFormImpl.setBarraSubmanifiestosBackingList requires non-null property arguments");
        }

        this.barraSubmanifiestosValueList = null;
        this.barraSubmanifiestosLabelList = null;

        if (items != null)
        {
            this.barraSubmanifiestosValueList = new java.lang.Object[items.size()];
            this.barraSubmanifiestosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.barraSubmanifiestosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.barraSubmanifiestosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorSubmanifiestosFormImpl.setBarraSubmanifiestosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>submanifiestos</code>.
     */
    public void resetSubmanifiestos()
    {
        this.submanifiestos = null;
    }

    public void setSubmanifiestos(java.util.List submanifiestos)
    {
        this.submanifiestos = submanifiestos;
    }

    /**
     * 
     */
    public java.util.List getSubmanifiestos()
    {
        return this.submanifiestos;
    }

    public void setSubmanifiestosAsArray(Object[] submanifiestos)
    {
        this.submanifiestos = (submanifiestos == null) ? null : java.util.Arrays.asList(submanifiestos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosFormImpl#getSubmanifiestos
     */
    public java.lang.Object[] getSubmanifiestosAsArray()
    {
        return (submanifiestos == null) ? null : submanifiestos.toArray();
    }
    
    public java.lang.Object[] getSubmanifiestosBackingList()
    {
        java.lang.Object[] values = this.submanifiestosValueList;
        java.lang.Object[] labels = this.submanifiestosLabelList;

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

    public java.lang.Object[] getSubmanifiestosValueList()
    {
        return this.submanifiestosValueList;
    }

    public void setSubmanifiestosValueList(java.lang.Object[] submanifiestosValueList)
    {
        this.submanifiestosValueList = submanifiestosValueList;
    }

    public java.lang.Object[] getSubmanifiestosLabelList()
    {
        return this.submanifiestosLabelList;
    }

    public void setSubmanifiestosLabelList(java.lang.Object[] submanifiestosLabelList)
    {
        this.submanifiestosLabelList = submanifiestosLabelList;
    }

    public void setSubmanifiestosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorSubmanifiestosFormImpl.setSubmanifiestosBackingList requires non-null property arguments");
        }

        this.submanifiestosValueList = null;
        this.submanifiestosLabelList = null;

        if (items != null)
        {
            this.submanifiestosValueList = new java.lang.Object[items.size()];
            this.submanifiestosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.submanifiestosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.submanifiestosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorSubmanifiestosFormImpl.setSubmanifiestosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identifier</code>.
     */
    public void resetIdentifier()
    {
        this.identifier = null;
    }

    public void setIdentifier(java.lang.String identifier)
    {
        this.identifier = identifier;
    }

    /**
     * 
     */
    public java.lang.String getIdentifier()
    {
        return this.identifier;
    }
    
    public java.lang.Object[] getIdentifierBackingList()
    {
        java.lang.Object[] values = this.identifierValueList;
        java.lang.Object[] labels = this.identifierLabelList;

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

    public java.lang.Object[] getIdentifierValueList()
    {
        return this.identifierValueList;
    }

    public void setIdentifierValueList(java.lang.Object[] identifierValueList)
    {
        this.identifierValueList = identifierValueList;
    }

    public java.lang.Object[] getIdentifierLabelList()
    {
        return this.identifierLabelList;
    }

    public void setIdentifierLabelList(java.lang.Object[] identifierLabelList)
    {
        this.identifierLabelList = identifierLabelList;
    }

    public void setIdentifierBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorSubmanifiestosFormImpl.setIdentifierBackingList requires non-null property arguments");
        }

        this.identifierValueList = null;
        this.identifierLabelList = null;

        if (items != null)
        {
            this.identifierValueList = new java.lang.Object[items.size()];
            this.identifierLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identifierValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identifierLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorSubmanifiestosFormImpl.setIdentifierBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("GestorSubmanifiestosFormImpl.setReturnURLBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("GestorSubmanifiestosFormImpl.setReturnURLBackingList encountered an exception", ex);
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
        builder.append("barraSubmanifiestos", this.barraSubmanifiestos);
        builder.append("submanifiestos", this.submanifiestos);
        builder.append("identifier", this.identifier);
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
        this.barraSubmanifiestos = null;
        this.barraSubmanifiestosValueList = null;
        this.barraSubmanifiestosLabelList = null;
        this.submanifiestos = null;
        this.submanifiestosValueList = null;
        this.submanifiestosLabelList = null;
        this.identifier = null;
        this.identifierValueList = null;
        this.identifierLabelList = null;
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
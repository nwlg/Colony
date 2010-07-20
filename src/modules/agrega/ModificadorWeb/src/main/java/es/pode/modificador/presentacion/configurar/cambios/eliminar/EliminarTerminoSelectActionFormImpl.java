// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.eliminar;

public class EliminarTerminoSelectActionFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.modificador.presentacion.configurar.cambios.eliminar.EliminarForm
        , es.pode.modificador.presentacion.configurar.cambios.eliminar.BorrarSesionForm
        , es.pode.modificador.presentacion.configurar.cambios.eliminar.RecuperarIdTerminoForm
        , es.pode.modificador.presentacion.configurar.cambios.eliminar.SelectActionForm
{
    private java.lang.Boolean alcance;
    private java.lang.Object[] alcanceValueList;
    private java.lang.Object[] alcanceLabelList;
    private java.lang.String valor;
    private java.lang.Object[] valorValueList;
    private java.lang.Object[] valorLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.lang.String idTermino;
    private java.lang.Object[] idTerminoValueList;
    private java.lang.Object[] idTerminoLabelList;
    private java.lang.Boolean exprReg;
    private java.lang.Object[] exprRegValueList;
    private java.lang.Object[] exprRegLabelList;

    public EliminarTerminoSelectActionFormImpl()
    {
    }

    /**
     * Resets the given <code>alcance</code>.
     */
    public void resetAlcance()
    {
        this.alcance = null;
    }

    public void setAlcance(java.lang.Boolean alcance)
    {
        this.alcance = alcance;
    }

    /**
     * 
     */
    public java.lang.Boolean getAlcance()
    {
        return this.alcance;
    }
    
    public java.lang.Object[] getAlcanceBackingList()
    {
        java.lang.Object[] values = this.alcanceValueList;
        java.lang.Object[] labels = this.alcanceLabelList;

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

    public java.lang.Object[] getAlcanceValueList()
    {
        return this.alcanceValueList;
    }

    public void setAlcanceValueList(java.lang.Object[] alcanceValueList)
    {
        this.alcanceValueList = alcanceValueList;
    }

    public java.lang.Object[] getAlcanceLabelList()
    {
        return this.alcanceLabelList;
    }

    public void setAlcanceLabelList(java.lang.Object[] alcanceLabelList)
    {
        this.alcanceLabelList = alcanceLabelList;
    }

    public void setAlcanceBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarTerminoSelectActionFormImpl.setAlcanceBackingList requires non-null property arguments");
        }

        this.alcanceValueList = null;
        this.alcanceLabelList = null;

        if (items != null)
        {
            this.alcanceValueList = new java.lang.Object[items.size()];
            this.alcanceLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.alcanceValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.alcanceLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarTerminoSelectActionFormImpl.setAlcanceBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>valor</code>.
     */
    public void resetValor()
    {
        this.valor = null;
    }

    public void setValor(java.lang.String valor)
    {
        this.valor = valor;
    }

    /**
     * 
     */
    public java.lang.String getValor()
    {
        return this.valor;
    }
    
    public java.lang.Object[] getValorBackingList()
    {
        java.lang.Object[] values = this.valorValueList;
        java.lang.Object[] labels = this.valorLabelList;

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

    public java.lang.Object[] getValorValueList()
    {
        return this.valorValueList;
    }

    public void setValorValueList(java.lang.Object[] valorValueList)
    {
        this.valorValueList = valorValueList;
    }

    public java.lang.Object[] getValorLabelList()
    {
        return this.valorLabelList;
    }

    public void setValorLabelList(java.lang.Object[] valorLabelList)
    {
        this.valorLabelList = valorLabelList;
    }

    public void setValorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarTerminoSelectActionFormImpl.setValorBackingList requires non-null property arguments");
        }

        this.valorValueList = null;
        this.valorLabelList = null;

        if (items != null)
        {
            this.valorValueList = new java.lang.Object[items.size()];
            this.valorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.valorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.valorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarTerminoSelectActionFormImpl.setValorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>action</code>.
     */
    public void resetAction()
    {
        this.action = null;
    }

    public void setAction(java.lang.String action)
    {
        this.action = action;
    }

    /**
     * 
     */
    public java.lang.String getAction()
    {
        return this.action;
    }
    
    public java.lang.Object[] getActionBackingList()
    {
        java.lang.Object[] values = this.actionValueList;
        java.lang.Object[] labels = this.actionLabelList;

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

    public java.lang.Object[] getActionValueList()
    {
        return this.actionValueList;
    }

    public void setActionValueList(java.lang.Object[] actionValueList)
    {
        this.actionValueList = actionValueList;
    }

    public java.lang.Object[] getActionLabelList()
    {
        return this.actionLabelList;
    }

    public void setActionLabelList(java.lang.Object[] actionLabelList)
    {
        this.actionLabelList = actionLabelList;
    }

    public void setActionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarTerminoSelectActionFormImpl.setActionBackingList requires non-null property arguments");
        }

        this.actionValueList = null;
        this.actionLabelList = null;

        if (items != null)
        {
            this.actionValueList = new java.lang.Object[items.size()];
            this.actionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.actionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.actionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarTerminoSelectActionFormImpl.setActionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("EliminarTerminoSelectActionFormImpl.setIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EliminarTerminoSelectActionFormImpl.setIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idTermino</code>.
     */
    public void resetIdTermino()
    {
        this.idTermino = null;
    }

    public void setIdTermino(java.lang.String idTermino)
    {
        this.idTermino = idTermino;
    }

    /**
     * 
     */
    public java.lang.String getIdTermino()
    {
        return this.idTermino;
    }
    
    public java.lang.Object[] getIdTerminoBackingList()
    {
        java.lang.Object[] values = this.idTerminoValueList;
        java.lang.Object[] labels = this.idTerminoLabelList;

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

    public java.lang.Object[] getIdTerminoValueList()
    {
        return this.idTerminoValueList;
    }

    public void setIdTerminoValueList(java.lang.Object[] idTerminoValueList)
    {
        this.idTerminoValueList = idTerminoValueList;
    }

    public java.lang.Object[] getIdTerminoLabelList()
    {
        return this.idTerminoLabelList;
    }

    public void setIdTerminoLabelList(java.lang.Object[] idTerminoLabelList)
    {
        this.idTerminoLabelList = idTerminoLabelList;
    }

    public void setIdTerminoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarTerminoSelectActionFormImpl.setIdTerminoBackingList requires non-null property arguments");
        }

        this.idTerminoValueList = null;
        this.idTerminoLabelList = null;

        if (items != null)
        {
            this.idTerminoValueList = new java.lang.Object[items.size()];
            this.idTerminoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idTerminoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idTerminoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarTerminoSelectActionFormImpl.setIdTerminoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>exprReg</code>.
     */
    public void resetExprReg()
    {
        this.exprReg = null;
    }

    public void setExprReg(java.lang.Boolean exprReg)
    {
        this.exprReg = exprReg;
    }

    /**
     * 
     */
    public java.lang.Boolean getExprReg()
    {
        return this.exprReg;
    }
    
    public java.lang.Object[] getExprRegBackingList()
    {
        java.lang.Object[] values = this.exprRegValueList;
        java.lang.Object[] labels = this.exprRegLabelList;

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

    public java.lang.Object[] getExprRegValueList()
    {
        return this.exprRegValueList;
    }

    public void setExprRegValueList(java.lang.Object[] exprRegValueList)
    {
        this.exprRegValueList = exprRegValueList;
    }

    public java.lang.Object[] getExprRegLabelList()
    {
        return this.exprRegLabelList;
    }

    public void setExprRegLabelList(java.lang.Object[] exprRegLabelList)
    {
        this.exprRegLabelList = exprRegLabelList;
    }

    public void setExprRegBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EliminarTerminoSelectActionFormImpl.setExprRegBackingList requires non-null property arguments");
        }

        this.exprRegValueList = null;
        this.exprRegLabelList = null;

        if (items != null)
        {
            this.exprRegValueList = new java.lang.Object[items.size()];
            this.exprRegLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.exprRegValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.exprRegLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EliminarTerminoSelectActionFormImpl.setExprRegBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.alcance = null;
        this.exprReg = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("alcance", this.alcance);
        builder.append("valor", this.valor);
        builder.append("action", this.action);
        builder.append("idioma", this.idioma);
        builder.append("idTermino", this.idTermino);
        builder.append("exprReg", this.exprReg);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.alcance = null;
        this.alcanceValueList = null;
        this.alcanceLabelList = null;
        this.valor = null;
        this.valorValueList = null;
        this.valorLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.idTermino = null;
        this.idTerminoValueList = null;
        this.idTerminoLabelList = null;
        this.exprReg = null;
        this.exprRegValueList = null;
        this.exprRegLabelList = null;
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
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.add;

public class TipoAnadirSelectActionFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.modificador.presentacion.configurar.cambios.add.SelectActionForm
        , es.pode.modificador.presentacion.configurar.cambios.add.SelectTipoForm
{
    private java.lang.Boolean alcance;
    private java.lang.Object[] alcanceValueList;
    private java.lang.Object[] alcanceLabelList;
    private java.lang.String tipoAniadir;
    private java.lang.Object[] tipoAniadirValueList;
    private java.lang.Object[] tipoAniadirLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.lang.String idTermino;
    private java.lang.Object[] idTerminoValueList;
    private java.lang.Object[] idTerminoLabelList;

    public TipoAnadirSelectActionFormImpl()
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
            throw new IllegalArgumentException("TipoAnadirSelectActionFormImpl.setAlcanceBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("TipoAnadirSelectActionFormImpl.setAlcanceBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoAniadir</code>.
     */
    public void resetTipoAniadir()
    {
        this.tipoAniadir = null;
    }

    public void setTipoAniadir(java.lang.String tipoAniadir)
    {
        this.tipoAniadir = tipoAniadir;
    }

    /**
     * 
     */
    public java.lang.String getTipoAniadir()
    {
        return this.tipoAniadir;
    }
    
    public java.lang.Object[] getTipoAniadirBackingList()
    {
        java.lang.Object[] values = this.tipoAniadirValueList;
        java.lang.Object[] labels = this.tipoAniadirLabelList;

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

    public java.lang.Object[] getTipoAniadirValueList()
    {
        return this.tipoAniadirValueList;
    }

    public void setTipoAniadirValueList(java.lang.Object[] tipoAniadirValueList)
    {
        this.tipoAniadirValueList = tipoAniadirValueList;
    }

    public java.lang.Object[] getTipoAniadirLabelList()
    {
        return this.tipoAniadirLabelList;
    }

    public void setTipoAniadirLabelList(java.lang.Object[] tipoAniadirLabelList)
    {
        this.tipoAniadirLabelList = tipoAniadirLabelList;
    }

    public void setTipoAniadirBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("TipoAnadirSelectActionFormImpl.setTipoAniadirBackingList requires non-null property arguments");
        }

        this.tipoAniadirValueList = null;
        this.tipoAniadirLabelList = null;

        if (items != null)
        {
            this.tipoAniadirValueList = new java.lang.Object[items.size()];
            this.tipoAniadirLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoAniadirValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoAniadirLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("TipoAnadirSelectActionFormImpl.setTipoAniadirBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("TipoAnadirSelectActionFormImpl.setActionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("TipoAnadirSelectActionFormImpl.setActionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("TipoAnadirSelectActionFormImpl.setIdTerminoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("TipoAnadirSelectActionFormImpl.setIdTerminoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.alcance = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("alcance", this.alcance);
        builder.append("tipoAniadir", this.tipoAniadir);
        builder.append("action", this.action);
        builder.append("idTermino", this.idTermino);
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
        this.tipoAniadir = null;
        this.tipoAniadirValueList = null;
        this.tipoAniadirLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.idTermino = null;
        this.idTerminoValueList = null;
        this.idTerminoLabelList = null;
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
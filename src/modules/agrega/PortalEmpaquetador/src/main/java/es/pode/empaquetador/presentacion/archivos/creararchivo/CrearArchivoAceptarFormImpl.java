// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.creararchivo;

public class CrearArchivoAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.archivos.creararchivo.CrearArchivoForm
{
    private java.lang.String tipo1;
    private java.lang.Object[] tipo1ValueList;
    private java.lang.Object[] tipo1LabelList;
    private java.lang.String tipo3;
    private java.lang.Object[] tipo3ValueList;
    private java.lang.Object[] tipo3LabelList;
    private java.lang.String tipo2;
    private java.lang.Object[] tipo2ValueList;
    private java.lang.Object[] tipo2LabelList;
    private org.apache.struts.upload.FormFile fichero1 = null;
    private java.lang.Object[] fichero1ValueList;
    private java.lang.Object[] fichero1LabelList;
    private org.apache.struts.upload.FormFile fichero2 = null;
    private java.lang.Object[] fichero2ValueList;
    private java.lang.Object[] fichero2LabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private org.apache.struts.upload.FormFile fichero3 = null;
    private java.lang.Object[] fichero3ValueList;
    private java.lang.Object[] fichero3LabelList;

    public CrearArchivoAceptarFormImpl()
    {
    }

    /**
     * Resets the given <code>tipo1</code>.
     */
    public void resetTipo1()
    {
        this.tipo1 = null;
    }

    public void setTipo1(java.lang.String tipo1)
    {
        this.tipo1 = tipo1;
    }

    /**
     * <p>
     * Valores posibles: ZIP, FICHERO
     * </p>
     */
    public java.lang.String getTipo1()
    {
        return this.tipo1;
    }
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     */
    public java.lang.String getTipo1OptionValue(int optionIndex)
    {
        switch(optionIndex)
        {
            case 0 : return "fichero";
            case 1 : return "zip";
            default:
                throw new java.lang.ArrayIndexOutOfBoundsException(
                    "Cannot access option "+optionIndex+", please specify a value in the range [0-1]");
        }
    }

    public java.lang.Object[] getTipo1BackingList()
    {
        java.lang.Object[] values = this.tipo1ValueList;
        java.lang.Object[] labels = this.tipo1LabelList;

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

    public java.lang.Object[] getTipo1ValueList()
    {
        return this.tipo1ValueList;
    }

    public void setTipo1ValueList(java.lang.Object[] tipo1ValueList)
    {
        this.tipo1ValueList = tipo1ValueList;
    }

    public java.lang.Object[] getTipo1LabelList()
    {
        return this.tipo1LabelList;
    }

    public void setTipo1LabelList(java.lang.Object[] tipo1LabelList)
    {
        this.tipo1LabelList = tipo1LabelList;
    }

    public void setTipo1BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearArchivoAceptarFormImpl.setTipo1BackingList requires non-null property arguments");
        }

        this.tipo1ValueList = null;
        this.tipo1LabelList = null;

        if (items != null)
        {
            this.tipo1ValueList = new java.lang.Object[items.size()];
            this.tipo1LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipo1ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipo1LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearArchivoAceptarFormImpl.setTipo1BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipo3</code>.
     */
    public void resetTipo3()
    {
        this.tipo3 = null;
    }

    public void setTipo3(java.lang.String tipo3)
    {
        this.tipo3 = tipo3;
    }

    /**
     * 
     */
    public java.lang.String getTipo3()
    {
        return this.tipo3;
    }
    
    public java.lang.Object[] getTipo3BackingList()
    {
        java.lang.Object[] values = this.tipo3ValueList;
        java.lang.Object[] labels = this.tipo3LabelList;

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

    public java.lang.Object[] getTipo3ValueList()
    {
        return this.tipo3ValueList;
    }

    public void setTipo3ValueList(java.lang.Object[] tipo3ValueList)
    {
        this.tipo3ValueList = tipo3ValueList;
    }

    public java.lang.Object[] getTipo3LabelList()
    {
        return this.tipo3LabelList;
    }

    public void setTipo3LabelList(java.lang.Object[] tipo3LabelList)
    {
        this.tipo3LabelList = tipo3LabelList;
    }

    public void setTipo3BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearArchivoAceptarFormImpl.setTipo3BackingList requires non-null property arguments");
        }

        this.tipo3ValueList = null;
        this.tipo3LabelList = null;

        if (items != null)
        {
            this.tipo3ValueList = new java.lang.Object[items.size()];
            this.tipo3LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipo3ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipo3LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearArchivoAceptarFormImpl.setTipo3BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipo2</code>.
     */
    public void resetTipo2()
    {
        this.tipo2 = null;
    }

    public void setTipo2(java.lang.String tipo2)
    {
        this.tipo2 = tipo2;
    }

    /**
     * 
     */
    public java.lang.String getTipo2()
    {
        return this.tipo2;
    }
    
    public java.lang.Object[] getTipo2BackingList()
    {
        java.lang.Object[] values = this.tipo2ValueList;
        java.lang.Object[] labels = this.tipo2LabelList;

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

    public java.lang.Object[] getTipo2ValueList()
    {
        return this.tipo2ValueList;
    }

    public void setTipo2ValueList(java.lang.Object[] tipo2ValueList)
    {
        this.tipo2ValueList = tipo2ValueList;
    }

    public java.lang.Object[] getTipo2LabelList()
    {
        return this.tipo2LabelList;
    }

    public void setTipo2LabelList(java.lang.Object[] tipo2LabelList)
    {
        this.tipo2LabelList = tipo2LabelList;
    }

    public void setTipo2BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearArchivoAceptarFormImpl.setTipo2BackingList requires non-null property arguments");
        }

        this.tipo2ValueList = null;
        this.tipo2LabelList = null;

        if (items != null)
        {
            this.tipo2ValueList = new java.lang.Object[items.size()];
            this.tipo2LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipo2ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipo2LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearArchivoAceptarFormImpl.setTipo2BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>fichero1</code>.
     */
    public void resetFichero1()
    {
        this.fichero1 = null;
    }

    public void setFichero1(org.apache.struts.upload.FormFile fichero1)
    {
        this.fichero1 = fichero1;
    }

    /**
     * 
     */
    public org.apache.struts.upload.FormFile getFichero1()
    {
        return this.fichero1;
    }
    public java.lang.Object[] getFichero1BackingList()
    {
        java.lang.Object[] values = this.fichero1ValueList;
        java.lang.Object[] labels = this.fichero1LabelList;

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

    public java.lang.Object[] getFichero1ValueList()
    {
        return this.fichero1ValueList;
    }

    public void setFichero1ValueList(java.lang.Object[] fichero1ValueList)
    {
        this.fichero1ValueList = fichero1ValueList;
    }

    public java.lang.Object[] getFichero1LabelList()
    {
        return this.fichero1LabelList;
    }

    public void setFichero1LabelList(java.lang.Object[] fichero1LabelList)
    {
        this.fichero1LabelList = fichero1LabelList;
    }

    public void setFichero1BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearArchivoAceptarFormImpl.setFichero1BackingList requires non-null property arguments");
        }

        this.fichero1ValueList = null;
        this.fichero1LabelList = null;

        if (items != null)
        {
            this.fichero1ValueList = new java.lang.Object[items.size()];
            this.fichero1LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.fichero1ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.fichero1LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearArchivoAceptarFormImpl.setFichero1BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>fichero2</code>.
     */
    public void resetFichero2()
    {
        this.fichero2 = null;
    }

    public void setFichero2(org.apache.struts.upload.FormFile fichero2)
    {
        this.fichero2 = fichero2;
    }

    /**
     * 
     */
    public org.apache.struts.upload.FormFile getFichero2()
    {
        return this.fichero2;
    }
    public java.lang.Object[] getFichero2BackingList()
    {
        java.lang.Object[] values = this.fichero2ValueList;
        java.lang.Object[] labels = this.fichero2LabelList;

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

    public java.lang.Object[] getFichero2ValueList()
    {
        return this.fichero2ValueList;
    }

    public void setFichero2ValueList(java.lang.Object[] fichero2ValueList)
    {
        this.fichero2ValueList = fichero2ValueList;
    }

    public java.lang.Object[] getFichero2LabelList()
    {
        return this.fichero2LabelList;
    }

    public void setFichero2LabelList(java.lang.Object[] fichero2LabelList)
    {
        this.fichero2LabelList = fichero2LabelList;
    }

    public void setFichero2BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearArchivoAceptarFormImpl.setFichero2BackingList requires non-null property arguments");
        }

        this.fichero2ValueList = null;
        this.fichero2LabelList = null;

        if (items != null)
        {
            this.fichero2ValueList = new java.lang.Object[items.size()];
            this.fichero2LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.fichero2ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.fichero2LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearArchivoAceptarFormImpl.setFichero2BackingList encountered an exception", ex);
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
     * <p>
     * Valor del boton de submit.
     * </p>
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
            throw new IllegalArgumentException("CrearArchivoAceptarFormImpl.setActionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CrearArchivoAceptarFormImpl.setActionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>fichero3</code>.
     */
    public void resetFichero3()
    {
        this.fichero3 = null;
    }

    public void setFichero3(org.apache.struts.upload.FormFile fichero3)
    {
        this.fichero3 = fichero3;
    }

    /**
     * 
     */
    public org.apache.struts.upload.FormFile getFichero3()
    {
        return this.fichero3;
    }
    public java.lang.Object[] getFichero3BackingList()
    {
        java.lang.Object[] values = this.fichero3ValueList;
        java.lang.Object[] labels = this.fichero3LabelList;

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

    public java.lang.Object[] getFichero3ValueList()
    {
        return this.fichero3ValueList;
    }

    public void setFichero3ValueList(java.lang.Object[] fichero3ValueList)
    {
        this.fichero3ValueList = fichero3ValueList;
    }

    public java.lang.Object[] getFichero3LabelList()
    {
        return this.fichero3LabelList;
    }

    public void setFichero3LabelList(java.lang.Object[] fichero3LabelList)
    {
        this.fichero3LabelList = fichero3LabelList;
    }

    public void setFichero3BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearArchivoAceptarFormImpl.setFichero3BackingList requires non-null property arguments");
        }

        this.fichero3ValueList = null;
        this.fichero3LabelList = null;

        if (items != null)
        {
            this.fichero3ValueList = new java.lang.Object[items.size()];
            this.fichero3LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.fichero3ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.fichero3LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearArchivoAceptarFormImpl.setFichero3BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.fichero1 = null;
        this.fichero2 = null;
        this.fichero3 = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("tipo1", this.tipo1);
        builder.append("tipo3", this.tipo3);
        builder.append("tipo2", this.tipo2);
        builder.append("fichero1", this.fichero1);
        builder.append("fichero2", this.fichero2);
        builder.append("action", this.action);
        builder.append("fichero3", this.fichero3);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.tipo1 = null;
        this.tipo1ValueList = null;
        this.tipo1LabelList = null;
        this.tipo3 = null;
        this.tipo3ValueList = null;
        this.tipo3LabelList = null;
        this.tipo2 = null;
        this.tipo2ValueList = null;
        this.tipo2LabelList = null;
        this.fichero1 = null;
        this.fichero1ValueList = null;
        this.fichero1LabelList = null;
        this.fichero2 = null;
        this.fichero2ValueList = null;
        this.fichero2LabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.fichero3 = null;
        this.fichero3ValueList = null;
        this.fichero3LabelList = null;
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
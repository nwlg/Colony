// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.importar;

public class SeleccionarRecursoImportadoAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.gestorFlujo.presentacion.objetosPersonales.importar.ImportarODEForm
{
    private java.lang.Long espacioLibre;
    private java.lang.Object[] espacioLibreValueList;
    private java.lang.Object[] espacioLibreLabelList;
    private org.apache.struts.upload.FormFile ficheroODE4 = null;
    private java.lang.Object[] ficheroODE4ValueList;
    private java.lang.Object[] ficheroODE4LabelList;
    private org.apache.struts.upload.FormFile ficheroODE5 = null;
    private java.lang.Object[] ficheroODE5ValueList;
    private java.lang.Object[] ficheroODE5LabelList;
    private java.util.Collection resultado;
    private java.lang.Object[] resultadoValueList;
    private java.lang.Object[] resultadoLabelList;
    private org.apache.struts.upload.FormFile ficheroODE2 = null;
    private java.lang.Object[] ficheroODE2ValueList;
    private java.lang.Object[] ficheroODE2LabelList;
    private org.apache.struts.upload.FormFile ficheroODE3 = null;
    private java.lang.Object[] ficheroODE3ValueList;
    private java.lang.Object[] ficheroODE3LabelList;
    private org.apache.struts.upload.FormFile ficheroODE1 = null;
    private java.lang.Object[] ficheroODE1ValueList;
    private java.lang.Object[] ficheroODE1LabelList;

    public SeleccionarRecursoImportadoAceptarFormImpl()
    {
    }

    /**
     * Resets the given <code>espacioLibre</code>.
     */
    public void resetEspacioLibre()
    {
        this.espacioLibre = null;
    }

    public void setEspacioLibre(java.lang.Long espacioLibre)
    {
        this.espacioLibre = espacioLibre;
    }

    /**
     * <p>
     * El espacio del que dispone el usuario para la importacion
     * </p>
     */
    public java.lang.Long getEspacioLibre()
    {
        return this.espacioLibre;
    }
    
    public java.lang.Object[] getEspacioLibreBackingList()
    {
        java.lang.Object[] values = this.espacioLibreValueList;
        java.lang.Object[] labels = this.espacioLibreLabelList;

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

    public java.lang.Object[] getEspacioLibreValueList()
    {
        return this.espacioLibreValueList;
    }

    public void setEspacioLibreValueList(java.lang.Object[] espacioLibreValueList)
    {
        this.espacioLibreValueList = espacioLibreValueList;
    }

    public java.lang.Object[] getEspacioLibreLabelList()
    {
        return this.espacioLibreLabelList;
    }

    public void setEspacioLibreLabelList(java.lang.Object[] espacioLibreLabelList)
    {
        this.espacioLibreLabelList = espacioLibreLabelList;
    }

    public void setEspacioLibreBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionarRecursoImportadoAceptarFormImpl.setEspacioLibreBackingList requires non-null property arguments");
        }

        this.espacioLibreValueList = null;
        this.espacioLibreLabelList = null;

        if (items != null)
        {
            this.espacioLibreValueList = new java.lang.Object[items.size()];
            this.espacioLibreLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.espacioLibreValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.espacioLibreLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionarRecursoImportadoAceptarFormImpl.setEspacioLibreBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ficheroODE4</code>.
     */
    public void resetFicheroODE4()
    {
        this.ficheroODE4 = null;
    }

    public void setFicheroODE4(org.apache.struts.upload.FormFile ficheroODE4)
    {
        this.ficheroODE4 = ficheroODE4;
    }

    /**
     * 
     */
    public org.apache.struts.upload.FormFile getFicheroODE4()
    {
        return this.ficheroODE4;
    }
    public java.lang.Object[] getFicheroODE4BackingList()
    {
        java.lang.Object[] values = this.ficheroODE4ValueList;
        java.lang.Object[] labels = this.ficheroODE4LabelList;

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

    public java.lang.Object[] getFicheroODE4ValueList()
    {
        return this.ficheroODE4ValueList;
    }

    public void setFicheroODE4ValueList(java.lang.Object[] ficheroODE4ValueList)
    {
        this.ficheroODE4ValueList = ficheroODE4ValueList;
    }

    public java.lang.Object[] getFicheroODE4LabelList()
    {
        return this.ficheroODE4LabelList;
    }

    public void setFicheroODE4LabelList(java.lang.Object[] ficheroODE4LabelList)
    {
        this.ficheroODE4LabelList = ficheroODE4LabelList;
    }

    public void setFicheroODE4BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionarRecursoImportadoAceptarFormImpl.setFicheroODE4BackingList requires non-null property arguments");
        }

        this.ficheroODE4ValueList = null;
        this.ficheroODE4LabelList = null;

        if (items != null)
        {
            this.ficheroODE4ValueList = new java.lang.Object[items.size()];
            this.ficheroODE4LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.ficheroODE4ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.ficheroODE4LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionarRecursoImportadoAceptarFormImpl.setFicheroODE4BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ficheroODE5</code>.
     */
    public void resetFicheroODE5()
    {
        this.ficheroODE5 = null;
    }

    public void setFicheroODE5(org.apache.struts.upload.FormFile ficheroODE5)
    {
        this.ficheroODE5 = ficheroODE5;
    }

    /**
     * 
     */
    public org.apache.struts.upload.FormFile getFicheroODE5()
    {
        return this.ficheroODE5;
    }
    public java.lang.Object[] getFicheroODE5BackingList()
    {
        java.lang.Object[] values = this.ficheroODE5ValueList;
        java.lang.Object[] labels = this.ficheroODE5LabelList;

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

    public java.lang.Object[] getFicheroODE5ValueList()
    {
        return this.ficheroODE5ValueList;
    }

    public void setFicheroODE5ValueList(java.lang.Object[] ficheroODE5ValueList)
    {
        this.ficheroODE5ValueList = ficheroODE5ValueList;
    }

    public java.lang.Object[] getFicheroODE5LabelList()
    {
        return this.ficheroODE5LabelList;
    }

    public void setFicheroODE5LabelList(java.lang.Object[] ficheroODE5LabelList)
    {
        this.ficheroODE5LabelList = ficheroODE5LabelList;
    }

    public void setFicheroODE5BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionarRecursoImportadoAceptarFormImpl.setFicheroODE5BackingList requires non-null property arguments");
        }

        this.ficheroODE5ValueList = null;
        this.ficheroODE5LabelList = null;

        if (items != null)
        {
            this.ficheroODE5ValueList = new java.lang.Object[items.size()];
            this.ficheroODE5LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.ficheroODE5ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.ficheroODE5LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionarRecursoImportadoAceptarFormImpl.setFicheroODE5BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>resultado</code>.
     */
    public void resetResultado()
    {
        this.resultado = null;
    }

    public void setResultado(java.util.Collection resultado)
    {
        this.resultado = resultado;
    }

    /**
     * 
     */
    public java.util.Collection getResultado()
    {
        return this.resultado;
    }

    public void setResultadoAsArray(Object[] resultado)
    {
        this.resultado = (resultado == null) ? null : java.util.Arrays.asList(resultado);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.gestorFlujo.presentacion.objetosPersonales.importar.SeleccionarRecursoImportadoAceptarFormImpl#getResultado
     */
    public java.lang.Object[] getResultadoAsArray()
    {
        return (resultado == null) ? null : resultado.toArray();
    }
    
    public java.lang.Object[] getResultadoBackingList()
    {
        java.lang.Object[] values = this.resultadoValueList;
        java.lang.Object[] labels = this.resultadoLabelList;

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

    public java.lang.Object[] getResultadoValueList()
    {
        return this.resultadoValueList;
    }

    public void setResultadoValueList(java.lang.Object[] resultadoValueList)
    {
        this.resultadoValueList = resultadoValueList;
    }

    public java.lang.Object[] getResultadoLabelList()
    {
        return this.resultadoLabelList;
    }

    public void setResultadoLabelList(java.lang.Object[] resultadoLabelList)
    {
        this.resultadoLabelList = resultadoLabelList;
    }

    public void setResultadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionarRecursoImportadoAceptarFormImpl.setResultadoBackingList requires non-null property arguments");
        }

        this.resultadoValueList = null;
        this.resultadoLabelList = null;

        if (items != null)
        {
            this.resultadoValueList = new java.lang.Object[items.size()];
            this.resultadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resultadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resultadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionarRecursoImportadoAceptarFormImpl.setResultadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ficheroODE2</code>.
     */
    public void resetFicheroODE2()
    {
        this.ficheroODE2 = null;
    }

    public void setFicheroODE2(org.apache.struts.upload.FormFile ficheroODE2)
    {
        this.ficheroODE2 = ficheroODE2;
    }

    /**
     * 
     */
    public org.apache.struts.upload.FormFile getFicheroODE2()
    {
        return this.ficheroODE2;
    }
    public java.lang.Object[] getFicheroODE2BackingList()
    {
        java.lang.Object[] values = this.ficheroODE2ValueList;
        java.lang.Object[] labels = this.ficheroODE2LabelList;

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

    public java.lang.Object[] getFicheroODE2ValueList()
    {
        return this.ficheroODE2ValueList;
    }

    public void setFicheroODE2ValueList(java.lang.Object[] ficheroODE2ValueList)
    {
        this.ficheroODE2ValueList = ficheroODE2ValueList;
    }

    public java.lang.Object[] getFicheroODE2LabelList()
    {
        return this.ficheroODE2LabelList;
    }

    public void setFicheroODE2LabelList(java.lang.Object[] ficheroODE2LabelList)
    {
        this.ficheroODE2LabelList = ficheroODE2LabelList;
    }

    public void setFicheroODE2BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionarRecursoImportadoAceptarFormImpl.setFicheroODE2BackingList requires non-null property arguments");
        }

        this.ficheroODE2ValueList = null;
        this.ficheroODE2LabelList = null;

        if (items != null)
        {
            this.ficheroODE2ValueList = new java.lang.Object[items.size()];
            this.ficheroODE2LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.ficheroODE2ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.ficheroODE2LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionarRecursoImportadoAceptarFormImpl.setFicheroODE2BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ficheroODE3</code>.
     */
    public void resetFicheroODE3()
    {
        this.ficheroODE3 = null;
    }

    public void setFicheroODE3(org.apache.struts.upload.FormFile ficheroODE3)
    {
        this.ficheroODE3 = ficheroODE3;
    }

    /**
     * 
     */
    public org.apache.struts.upload.FormFile getFicheroODE3()
    {
        return this.ficheroODE3;
    }
    public java.lang.Object[] getFicheroODE3BackingList()
    {
        java.lang.Object[] values = this.ficheroODE3ValueList;
        java.lang.Object[] labels = this.ficheroODE3LabelList;

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

    public java.lang.Object[] getFicheroODE3ValueList()
    {
        return this.ficheroODE3ValueList;
    }

    public void setFicheroODE3ValueList(java.lang.Object[] ficheroODE3ValueList)
    {
        this.ficheroODE3ValueList = ficheroODE3ValueList;
    }

    public java.lang.Object[] getFicheroODE3LabelList()
    {
        return this.ficheroODE3LabelList;
    }

    public void setFicheroODE3LabelList(java.lang.Object[] ficheroODE3LabelList)
    {
        this.ficheroODE3LabelList = ficheroODE3LabelList;
    }

    public void setFicheroODE3BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionarRecursoImportadoAceptarFormImpl.setFicheroODE3BackingList requires non-null property arguments");
        }

        this.ficheroODE3ValueList = null;
        this.ficheroODE3LabelList = null;

        if (items != null)
        {
            this.ficheroODE3ValueList = new java.lang.Object[items.size()];
            this.ficheroODE3LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.ficheroODE3ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.ficheroODE3LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionarRecursoImportadoAceptarFormImpl.setFicheroODE3BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ficheroODE1</code>.
     */
    public void resetFicheroODE1()
    {
        this.ficheroODE1 = null;
    }

    public void setFicheroODE1(org.apache.struts.upload.FormFile ficheroODE1)
    {
        this.ficheroODE1 = ficheroODE1;
    }

    /**
     * <p>
     * Se trata del fichero conteniendo el ODE importado.
     * </p>
     */
    public org.apache.struts.upload.FormFile getFicheroODE1()
    {
        return this.ficheroODE1;
    }
    public java.lang.Object[] getFicheroODE1BackingList()
    {
        java.lang.Object[] values = this.ficheroODE1ValueList;
        java.lang.Object[] labels = this.ficheroODE1LabelList;

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

    public java.lang.Object[] getFicheroODE1ValueList()
    {
        return this.ficheroODE1ValueList;
    }

    public void setFicheroODE1ValueList(java.lang.Object[] ficheroODE1ValueList)
    {
        this.ficheroODE1ValueList = ficheroODE1ValueList;
    }

    public java.lang.Object[] getFicheroODE1LabelList()
    {
        return this.ficheroODE1LabelList;
    }

    public void setFicheroODE1LabelList(java.lang.Object[] ficheroODE1LabelList)
    {
        this.ficheroODE1LabelList = ficheroODE1LabelList;
    }

    public void setFicheroODE1BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionarRecursoImportadoAceptarFormImpl.setFicheroODE1BackingList requires non-null property arguments");
        }

        this.ficheroODE1ValueList = null;
        this.ficheroODE1LabelList = null;

        if (items != null)
        {
            this.ficheroODE1ValueList = new java.lang.Object[items.size()];
            this.ficheroODE1LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.ficheroODE1ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.ficheroODE1LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionarRecursoImportadoAceptarFormImpl.setFicheroODE1BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.ficheroODE4 = null;
        this.ficheroODE5 = null;
        this.ficheroODE2 = null;
        this.ficheroODE3 = null;
        this.ficheroODE1 = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("espacioLibre", this.espacioLibre);
        builder.append("ficheroODE4", this.ficheroODE4);
        builder.append("ficheroODE5", this.ficheroODE5);
        builder.append("resultado", this.resultado);
        builder.append("ficheroODE2", this.ficheroODE2);
        builder.append("ficheroODE3", this.ficheroODE3);
        builder.append("ficheroODE1", this.ficheroODE1);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.espacioLibre = null;
        this.espacioLibreValueList = null;
        this.espacioLibreLabelList = null;
        this.ficheroODE4 = null;
        this.ficheroODE4ValueList = null;
        this.ficheroODE4LabelList = null;
        this.ficheroODE5 = null;
        this.ficheroODE5ValueList = null;
        this.ficheroODE5LabelList = null;
        this.resultado = null;
        this.resultadoValueList = null;
        this.resultadoLabelList = null;
        this.ficheroODE2 = null;
        this.ficheroODE2ValueList = null;
        this.ficheroODE2LabelList = null;
        this.ficheroODE3 = null;
        this.ficheroODE3ValueList = null;
        this.ficheroODE3LabelList = null;
        this.ficheroODE1 = null;
        this.ficheroODE1ValueList = null;
        this.ficheroODE1LabelList = null;
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
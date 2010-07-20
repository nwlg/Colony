// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento;

public class CrearElemento01SubmitFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.RecuperarIdRefForm
        , es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.TerminarSesionForm
        , es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearForm
        , es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.Submit01Form
        , es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.SelectAction01Form
        , es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.ValidaTipoForm
{
    private java.lang.String completionThreshold;
    private java.lang.Object[] completionThresholdValueList;
    private java.lang.Object[] completionThresholdLabelList;
    private java.lang.String title;
    private java.lang.Object[] titleValueList;
    private java.lang.Object[] titleLabelList;
    private java.util.List elementos = null;
    private java.lang.Object[] elementosValueList;
    private java.lang.Object[] elementosLabelList;
    private java.lang.Boolean isVisible;
    private java.lang.Object[] isVisibleValueList;
    private java.lang.Object[] isVisibleLabelList;
    private java.lang.String[] selectPresentation;
    private java.lang.Object[] selectPresentationValueList;
    private java.lang.Object[] selectPresentationLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.lang.String referenciado;
    private java.lang.Object[] referenciadoValueList;
    private java.lang.Object[] referenciadoLabelList;
    private java.lang.String timeLimitAction;
    private java.lang.Object[] timeLimitActionValueList;
    private java.lang.Object[] timeLimitActionLabelList;
    private java.lang.String identifier;
    private java.lang.Object[] identifierValueList;
    private java.lang.Object[] identifierLabelList;
    private java.lang.String dataFromLMS;
    private java.lang.Object[] dataFromLMSValueList;
    private java.lang.Object[] dataFromLMSLabelList;

    public CrearElemento01SubmitFormImpl()
    {
    }

    /**
     * Resets the given <code>completionThreshold</code>.
     */
    public void resetCompletionThreshold()
    {
        this.completionThreshold = null;
    }

    public void setCompletionThreshold(java.lang.String completionThreshold)
    {
        this.completionThreshold = completionThreshold;
    }

    /**
     * 
     */
    public java.lang.String getCompletionThreshold()
    {
        return this.completionThreshold;
    }
    
    public java.lang.Object[] getCompletionThresholdBackingList()
    {
        java.lang.Object[] values = this.completionThresholdValueList;
        java.lang.Object[] labels = this.completionThresholdLabelList;

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

    public java.lang.Object[] getCompletionThresholdValueList()
    {
        return this.completionThresholdValueList;
    }

    public void setCompletionThresholdValueList(java.lang.Object[] completionThresholdValueList)
    {
        this.completionThresholdValueList = completionThresholdValueList;
    }

    public java.lang.Object[] getCompletionThresholdLabelList()
    {
        return this.completionThresholdLabelList;
    }

    public void setCompletionThresholdLabelList(java.lang.Object[] completionThresholdLabelList)
    {
        this.completionThresholdLabelList = completionThresholdLabelList;
    }

    public void setCompletionThresholdBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearElemento01SubmitFormImpl.setCompletionThresholdBackingList requires non-null property arguments");
        }

        this.completionThresholdValueList = null;
        this.completionThresholdLabelList = null;

        if (items != null)
        {
            this.completionThresholdValueList = new java.lang.Object[items.size()];
            this.completionThresholdLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.completionThresholdValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.completionThresholdLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearElemento01SubmitFormImpl.setCompletionThresholdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>title</code>.
     */
    public void resetTitle()
    {
        this.title = null;
    }

    public void setTitle(java.lang.String title)
    {
        this.title = title;
    }

    /**
     * 
     */
    public java.lang.String getTitle()
    {
        return this.title;
    }
    
    public java.lang.Object[] getTitleBackingList()
    {
        java.lang.Object[] values = this.titleValueList;
        java.lang.Object[] labels = this.titleLabelList;

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

    public java.lang.Object[] getTitleValueList()
    {
        return this.titleValueList;
    }

    public void setTitleValueList(java.lang.Object[] titleValueList)
    {
        this.titleValueList = titleValueList;
    }

    public java.lang.Object[] getTitleLabelList()
    {
        return this.titleLabelList;
    }

    public void setTitleLabelList(java.lang.Object[] titleLabelList)
    {
        this.titleLabelList = titleLabelList;
    }

    public void setTitleBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearElemento01SubmitFormImpl.setTitleBackingList requires non-null property arguments");
        }

        this.titleValueList = null;
        this.titleLabelList = null;

        if (items != null)
        {
            this.titleValueList = new java.lang.Object[items.size()];
            this.titleLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.titleValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.titleLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearElemento01SubmitFormImpl.setTitleBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>elementos</code>.
     */
    public void resetElementos()
    {
        this.elementos = null;
    }

    public void setElementos(java.util.List elementos)
    {
        this.elementos = elementos;
    }

    /**
     * <p>
     * Esta lista puede contener recursos o submanifiestos, dependiendo
     * del tipo de elemento que se quiere crear (esRecurso). Los
     * metodos a acceder son getIdentifier (comun a los dos) y
     * dependiendo del tipo de elemento, getFile (para recursos) o
     * getLom().getTitulo() para submanifiesto.
     * </p>
     */
    public java.util.List getElementos()
    {
        return this.elementos;
    }

    public void setElementosAsArray(Object[] elementos)
    {
        this.elementos = (elementos == null) ? null : java.util.Arrays.asList(elementos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElemento01SubmitFormImpl#getElementos
     */
    public java.lang.Object[] getElementosAsArray()
    {
        return (elementos == null) ? null : elementos.toArray();
    }
    
    public java.lang.Object[] getElementosBackingList()
    {
        java.lang.Object[] values = this.elementosValueList;
        java.lang.Object[] labels = this.elementosLabelList;

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

    public java.lang.Object[] getElementosValueList()
    {
        return this.elementosValueList;
    }

    public void setElementosValueList(java.lang.Object[] elementosValueList)
    {
        this.elementosValueList = elementosValueList;
    }

    public java.lang.Object[] getElementosLabelList()
    {
        return this.elementosLabelList;
    }

    public void setElementosLabelList(java.lang.Object[] elementosLabelList)
    {
        this.elementosLabelList = elementosLabelList;
    }

    public void setElementosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearElemento01SubmitFormImpl.setElementosBackingList requires non-null property arguments");
        }

        this.elementosValueList = null;
        this.elementosLabelList = null;

        if (items != null)
        {
            this.elementosValueList = new java.lang.Object[items.size()];
            this.elementosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.elementosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.elementosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearElemento01SubmitFormImpl.setElementosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>isVisible</code>.
     */
    public void resetIsVisible()
    {
        this.isVisible = null;
    }

    public void setIsVisible(java.lang.Boolean isVisible)
    {
        this.isVisible = isVisible;
    }

    /**
     * 
     */
    public java.lang.Boolean getIsVisible()
    {
        return this.isVisible;
    }
    
    public java.lang.Object[] getIsVisibleBackingList()
    {
        java.lang.Object[] values = this.isVisibleValueList;
        java.lang.Object[] labels = this.isVisibleLabelList;

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

    public java.lang.Object[] getIsVisibleValueList()
    {
        return this.isVisibleValueList;
    }

    public void setIsVisibleValueList(java.lang.Object[] isVisibleValueList)
    {
        this.isVisibleValueList = isVisibleValueList;
    }

    public java.lang.Object[] getIsVisibleLabelList()
    {
        return this.isVisibleLabelList;
    }

    public void setIsVisibleLabelList(java.lang.Object[] isVisibleLabelList)
    {
        this.isVisibleLabelList = isVisibleLabelList;
    }

    public void setIsVisibleBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearElemento01SubmitFormImpl.setIsVisibleBackingList requires non-null property arguments");
        }

        this.isVisibleValueList = null;
        this.isVisibleLabelList = null;

        if (items != null)
        {
            this.isVisibleValueList = new java.lang.Object[items.size()];
            this.isVisibleLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.isVisibleValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.isVisibleLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearElemento01SubmitFormImpl.setIsVisibleBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>selectPresentation</code>.
     */
    public void resetSelectPresentation()
    {
        this.selectPresentation = null;
    }

    public void setSelectPresentation(java.lang.String[] selectPresentation)
    {
        this.selectPresentation = selectPresentation;
    }

    /**
     * 
     */
    public java.lang.String[] getSelectPresentation()
    {
        return this.selectPresentation;
    }
    
    public java.lang.Object[] getSelectPresentationBackingList()
    {
        java.lang.Object[] values = this.selectPresentationValueList;
        java.lang.Object[] labels = this.selectPresentationLabelList;

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

    public java.lang.Object[] getSelectPresentationValueList()
    {
        return this.selectPresentationValueList;
    }

    public void setSelectPresentationValueList(java.lang.Object[] selectPresentationValueList)
    {
        this.selectPresentationValueList = selectPresentationValueList;
    }

    public java.lang.Object[] getSelectPresentationLabelList()
    {
        return this.selectPresentationLabelList;
    }

    public void setSelectPresentationLabelList(java.lang.Object[] selectPresentationLabelList)
    {
        this.selectPresentationLabelList = selectPresentationLabelList;
    }

    public void setSelectPresentationBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearElemento01SubmitFormImpl.setSelectPresentationBackingList requires non-null property arguments");
        }

        this.selectPresentationValueList = null;
        this.selectPresentationLabelList = null;

        if (items != null)
        {
            this.selectPresentationValueList = new java.lang.Object[items.size()];
            this.selectPresentationLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.selectPresentationValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.selectPresentationLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearElemento01SubmitFormImpl.setSelectPresentationBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CrearElemento01SubmitFormImpl.setActionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CrearElemento01SubmitFormImpl.setActionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>referenciado</code>.
     */
    public void resetReferenciado()
    {
        this.referenciado = null;
    }

    public void setReferenciado(java.lang.String referenciado)
    {
        this.referenciado = referenciado;
    }

    /**
     * 
     */
    public java.lang.String getReferenciado()
    {
        return this.referenciado;
    }
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     */
    public java.lang.String getReferenciadoOptionValue(int optionIndex)
    {
        switch(optionIndex)
        {
            case 0 : return "Ninguno";
            case 1 : return "Recurso";
            case 2 : return "Submanifiesto";
            default:
                throw new java.lang.ArrayIndexOutOfBoundsException(
                    "Cannot access option "+optionIndex+", please specify a value in the range [0-2]");
        }
    }

    public java.lang.Object[] getReferenciadoBackingList()
    {
        java.lang.Object[] values = this.referenciadoValueList;
        java.lang.Object[] labels = this.referenciadoLabelList;

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

    public java.lang.Object[] getReferenciadoValueList()
    {
        return this.referenciadoValueList;
    }

    public void setReferenciadoValueList(java.lang.Object[] referenciadoValueList)
    {
        this.referenciadoValueList = referenciadoValueList;
    }

    public java.lang.Object[] getReferenciadoLabelList()
    {
        return this.referenciadoLabelList;
    }

    public void setReferenciadoLabelList(java.lang.Object[] referenciadoLabelList)
    {
        this.referenciadoLabelList = referenciadoLabelList;
    }

    public void setReferenciadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearElemento01SubmitFormImpl.setReferenciadoBackingList requires non-null property arguments");
        }

        this.referenciadoValueList = null;
        this.referenciadoLabelList = null;

        if (items != null)
        {
            this.referenciadoValueList = new java.lang.Object[items.size()];
            this.referenciadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.referenciadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.referenciadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearElemento01SubmitFormImpl.setReferenciadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>timeLimitAction</code>.
     */
    public void resetTimeLimitAction()
    {
        this.timeLimitAction = null;
    }

    public void setTimeLimitAction(java.lang.String timeLimitAction)
    {
        this.timeLimitAction = timeLimitAction;
    }

    /**
     * 
     */
    public java.lang.String getTimeLimitAction()
    {
        return this.timeLimitAction;
    }
    
    public java.lang.Object[] getTimeLimitActionBackingList()
    {
        java.lang.Object[] values = this.timeLimitActionValueList;
        java.lang.Object[] labels = this.timeLimitActionLabelList;

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

    public java.lang.Object[] getTimeLimitActionValueList()
    {
        return this.timeLimitActionValueList;
    }

    public void setTimeLimitActionValueList(java.lang.Object[] timeLimitActionValueList)
    {
        this.timeLimitActionValueList = timeLimitActionValueList;
    }

    public java.lang.Object[] getTimeLimitActionLabelList()
    {
        return this.timeLimitActionLabelList;
    }

    public void setTimeLimitActionLabelList(java.lang.Object[] timeLimitActionLabelList)
    {
        this.timeLimitActionLabelList = timeLimitActionLabelList;
    }

    public void setTimeLimitActionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearElemento01SubmitFormImpl.setTimeLimitActionBackingList requires non-null property arguments");
        }

        this.timeLimitActionValueList = null;
        this.timeLimitActionLabelList = null;

        if (items != null)
        {
            this.timeLimitActionValueList = new java.lang.Object[items.size()];
            this.timeLimitActionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.timeLimitActionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.timeLimitActionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearElemento01SubmitFormImpl.setTimeLimitActionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CrearElemento01SubmitFormImpl.setIdentifierBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CrearElemento01SubmitFormImpl.setIdentifierBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>dataFromLMS</code>.
     */
    public void resetDataFromLMS()
    {
        this.dataFromLMS = null;
    }

    public void setDataFromLMS(java.lang.String dataFromLMS)
    {
        this.dataFromLMS = dataFromLMS;
    }

    /**
     * 
     */
    public java.lang.String getDataFromLMS()
    {
        return this.dataFromLMS;
    }
    
    public java.lang.Object[] getDataFromLMSBackingList()
    {
        java.lang.Object[] values = this.dataFromLMSValueList;
        java.lang.Object[] labels = this.dataFromLMSLabelList;

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

    public java.lang.Object[] getDataFromLMSValueList()
    {
        return this.dataFromLMSValueList;
    }

    public void setDataFromLMSValueList(java.lang.Object[] dataFromLMSValueList)
    {
        this.dataFromLMSValueList = dataFromLMSValueList;
    }

    public java.lang.Object[] getDataFromLMSLabelList()
    {
        return this.dataFromLMSLabelList;
    }

    public void setDataFromLMSLabelList(java.lang.Object[] dataFromLMSLabelList)
    {
        this.dataFromLMSLabelList = dataFromLMSLabelList;
    }

    public void setDataFromLMSBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearElemento01SubmitFormImpl.setDataFromLMSBackingList requires non-null property arguments");
        }

        this.dataFromLMSValueList = null;
        this.dataFromLMSLabelList = null;

        if (items != null)
        {
            this.dataFromLMSValueList = new java.lang.Object[items.size()];
            this.dataFromLMSLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.dataFromLMSValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.dataFromLMSLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearElemento01SubmitFormImpl.setDataFromLMSBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.isVisible = null;
        this.selectPresentation = null;
        this.selectPresentationValueList = new java.lang.Object[0];
        this.selectPresentationLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("completionThreshold", this.completionThreshold);
        builder.append("title", this.title);
        builder.append("elementos", this.elementos);
        builder.append("isVisible", this.isVisible);
        builder.append("selectPresentation", this.selectPresentation);
        builder.append("action", this.action);
        builder.append("referenciado", this.referenciado);
        builder.append("timeLimitAction", this.timeLimitAction);
        builder.append("identifier", this.identifier);
        builder.append("dataFromLMS", this.dataFromLMS);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.completionThreshold = null;
        this.completionThresholdValueList = null;
        this.completionThresholdLabelList = null;
        this.title = null;
        this.titleValueList = null;
        this.titleLabelList = null;
        this.elementos = null;
        this.elementosValueList = null;
        this.elementosLabelList = null;
        this.isVisible = null;
        this.isVisibleValueList = null;
        this.isVisibleLabelList = null;
        this.selectPresentation = null;
        this.selectPresentationValueList = null;
        this.selectPresentationLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.referenciado = null;
        this.referenciadoValueList = null;
        this.referenciadoLabelList = null;
        this.timeLimitAction = null;
        this.timeLimitActionValueList = null;
        this.timeLimitActionLabelList = null;
        this.identifier = null;
        this.identifierValueList = null;
        this.identifierLabelList = null;
        this.dataFromLMS = null;
        this.dataFromLMSValueList = null;
        this.dataFromLMSLabelList = null;
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
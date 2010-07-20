// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.gestor;

public class GestorBasicoSubmitFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.basico.gestor.RecuperarDatosForm
        , es.pode.empaquetador.presentacion.basico.gestor.SubmitForm
        , es.pode.empaquetador.presentacion.basico.gestor.PegarForm
        , es.pode.empaquetador.presentacion.basico.gestor.CopiarForm
        , es.pode.empaquetador.presentacion.basico.gestor.EliminarForm
        , es.pode.empaquetador.presentacion.basico.gestor.CortarForm
        , es.pode.empaquetador.presentacion.basico.gestor.VaciarPortapapelesForm
        , es.pode.empaquetador.presentacion.basico.gestor.SelectActionForm
{
    private java.util.List identificadores;
    private java.lang.Object[] identificadoresValueList;
    private java.lang.Object[] identificadoresLabelList;
    private es.pode.empaquetador.negocio.servicio.OrganizacionVO organizacion;
    private java.lang.Object[] organizacionValueList;
    private java.lang.Object[] organizacionLabelList;
    private java.util.List actionComboValues;
    private java.lang.Object[] actionComboValuesValueList;
    private java.lang.Object[] actionComboValuesLabelList;
    private java.util.List idCollection = null;
    private java.lang.Object[] idCollectionValueList;
    private java.lang.Object[] idCollectionLabelList;
    private boolean vistaCarpeta;
    private java.lang.Object[] vistaCarpetaValueList;
    private java.lang.Object[] vistaCarpetaLabelList;
    private java.lang.String actionSubmit;
    private java.lang.Object[] actionSubmitValueList;
    private java.lang.Object[] actionSubmitLabelList;
    private boolean esModificar;
    private java.lang.Object[] esModificarValueList;
    private java.lang.Object[] esModificarLabelList;
    private java.lang.String actionCombo;
    private java.lang.Object[] actionComboValueList;
    private java.lang.Object[] actionComboLabelList;
    private java.util.List portapapeles = null;
    private java.lang.Object[] portapapelesValueList;
    private java.lang.Object[] portapapelesLabelList;
    private es.pode.empaquetador.negocio.servicio.ControlModeVO controlMode;
    private java.lang.Object[] controlModeValueList;
    private java.lang.Object[] controlModeLabelList;
    private java.util.List identifierRowSelection = null;
    private java.lang.Object[] identifierValueList;
    private java.lang.Object[] identifierLabelList;
    private java.util.List grupos = null;
    private java.lang.Object[] gruposValueList;
    private java.lang.Object[] gruposLabelList;
    private java.lang.String returnURL;
    private java.lang.Object[] returnURLValueList;
    private java.lang.Object[] returnURLLabelList;

    public GestorBasicoSubmitFormImpl()
    {
    }

    /**
     * Resets the given <code>identificadores</code>.
     */
    public void resetIdentificadores()
    {
        this.identificadores = null;
    }

    public void setIdentificadores(java.util.List identificadores)
    {
        this.identificadores = identificadores;
    }

    /**
     * 
     */
    public java.util.List getIdentificadores()
    {
        return this.identificadores;
    }

    public void setIdentificadoresAsArray(Object[] identificadores)
    {
        this.identificadores = (identificadores == null) ? null : java.util.Arrays.asList(identificadores);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoSubmitFormImpl#getIdentificadores
     */
    public java.lang.Object[] getIdentificadoresAsArray()
    {
        return (identificadores == null) ? null : identificadores.toArray();
    }
    
    public java.lang.Object[] getIdentificadoresBackingList()
    {
        java.lang.Object[] values = this.identificadoresValueList;
        java.lang.Object[] labels = this.identificadoresLabelList;

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

    public java.lang.Object[] getIdentificadoresValueList()
    {
        return this.identificadoresValueList;
    }

    public void setIdentificadoresValueList(java.lang.Object[] identificadoresValueList)
    {
        this.identificadoresValueList = identificadoresValueList;
    }

    public java.lang.Object[] getIdentificadoresLabelList()
    {
        return this.identificadoresLabelList;
    }

    public void setIdentificadoresLabelList(java.lang.Object[] identificadoresLabelList)
    {
        this.identificadoresLabelList = identificadoresLabelList;
    }

    public void setIdentificadoresBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorBasicoSubmitFormImpl.setIdentificadoresBackingList requires non-null property arguments");
        }

        this.identificadoresValueList = null;
        this.identificadoresLabelList = null;

        if (items != null)
        {
            this.identificadoresValueList = new java.lang.Object[items.size()];
            this.identificadoresLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadoresValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadoresLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorBasicoSubmitFormImpl.setIdentificadoresBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>organizacion</code>.
     */
    public void resetOrganizacion()
    {
        this.organizacion = null;
    }

    public void setOrganizacion(es.pode.empaquetador.negocio.servicio.OrganizacionVO organizacion)
    {
        this.organizacion = organizacion;
    }

    /**
     * 
     */
    public es.pode.empaquetador.negocio.servicio.OrganizacionVO getOrganizacion()
    {
        return this.organizacion;
    }
    
    public java.lang.Object[] getOrganizacionBackingList()
    {
        java.lang.Object[] values = this.organizacionValueList;
        java.lang.Object[] labels = this.organizacionLabelList;

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

    public java.lang.Object[] getOrganizacionValueList()
    {
        return this.organizacionValueList;
    }

    public void setOrganizacionValueList(java.lang.Object[] organizacionValueList)
    {
        this.organizacionValueList = organizacionValueList;
    }

    public java.lang.Object[] getOrganizacionLabelList()
    {
        return this.organizacionLabelList;
    }

    public void setOrganizacionLabelList(java.lang.Object[] organizacionLabelList)
    {
        this.organizacionLabelList = organizacionLabelList;
    }

    public void setOrganizacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorBasicoSubmitFormImpl.setOrganizacionBackingList requires non-null property arguments");
        }

        this.organizacionValueList = null;
        this.organizacionLabelList = null;

        if (items != null)
        {
            this.organizacionValueList = new java.lang.Object[items.size()];
            this.organizacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.organizacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.organizacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorBasicoSubmitFormImpl.setOrganizacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>actionComboValues</code>.
     */
    public void resetActionComboValues()
    {
        this.actionComboValues = null;
    }

    public void setActionComboValues(java.util.List actionComboValues)
    {
        this.actionComboValues = actionComboValues;
    }

    /**
     * 
     */
    public java.util.List getActionComboValues()
    {
        return this.actionComboValues;
    }

    public void setActionComboValuesAsArray(Object[] actionComboValues)
    {
        this.actionComboValues = (actionComboValues == null) ? null : java.util.Arrays.asList(actionComboValues);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoSubmitFormImpl#getActionComboValues
     */
    public java.lang.Object[] getActionComboValuesAsArray()
    {
        return (actionComboValues == null) ? null : actionComboValues.toArray();
    }
    
    public java.lang.Object[] getActionComboValuesBackingList()
    {
        java.lang.Object[] values = this.actionComboValuesValueList;
        java.lang.Object[] labels = this.actionComboValuesLabelList;

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

    public java.lang.Object[] getActionComboValuesValueList()
    {
        return this.actionComboValuesValueList;
    }

    public void setActionComboValuesValueList(java.lang.Object[] actionComboValuesValueList)
    {
        this.actionComboValuesValueList = actionComboValuesValueList;
    }

    public java.lang.Object[] getActionComboValuesLabelList()
    {
        return this.actionComboValuesLabelList;
    }

    public void setActionComboValuesLabelList(java.lang.Object[] actionComboValuesLabelList)
    {
        this.actionComboValuesLabelList = actionComboValuesLabelList;
    }

    public void setActionComboValuesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorBasicoSubmitFormImpl.setActionComboValuesBackingList requires non-null property arguments");
        }

        this.actionComboValuesValueList = null;
        this.actionComboValuesLabelList = null;

        if (items != null)
        {
            this.actionComboValuesValueList = new java.lang.Object[items.size()];
            this.actionComboValuesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.actionComboValuesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.actionComboValuesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorBasicoSubmitFormImpl.setActionComboValuesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idCollection</code>.
     */
    public void resetIdCollection()
    {
        this.idCollection = null;
    }

    public void setIdCollection(java.util.List idCollection)
    {
        this.idCollection = idCollection;
    }

    /**
     * 
     */
    public java.util.List getIdCollection()
    {
        return this.idCollection;
    }

    public void setIdCollectionAsArray(Object[] idCollection)
    {
        this.idCollection = (idCollection == null) ? null : java.util.Arrays.asList(idCollection);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoSubmitFormImpl#getIdCollection
     */
    public java.lang.Object[] getIdCollectionAsArray()
    {
        return (idCollection == null) ? null : idCollection.toArray();
    }
    
    public java.lang.Object[] getIdCollectionBackingList()
    {
        java.lang.Object[] values = this.idCollectionValueList;
        java.lang.Object[] labels = this.idCollectionLabelList;

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

    public java.lang.Object[] getIdCollectionValueList()
    {
        return this.idCollectionValueList;
    }

    public void setIdCollectionValueList(java.lang.Object[] idCollectionValueList)
    {
        this.idCollectionValueList = idCollectionValueList;
    }

    public java.lang.Object[] getIdCollectionLabelList()
    {
        return this.idCollectionLabelList;
    }

    public void setIdCollectionLabelList(java.lang.Object[] idCollectionLabelList)
    {
        this.idCollectionLabelList = idCollectionLabelList;
    }

    public void setIdCollectionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorBasicoSubmitFormImpl.setIdCollectionBackingList requires non-null property arguments");
        }

        this.idCollectionValueList = null;
        this.idCollectionLabelList = null;

        if (items != null)
        {
            this.idCollectionValueList = new java.lang.Object[items.size()];
            this.idCollectionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idCollectionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idCollectionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorBasicoSubmitFormImpl.setIdCollectionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>vistaCarpeta</code>.
     */
    public void resetVistaCarpeta()
    {
        this.vistaCarpeta = false;
    }

    public void setVistaCarpeta(boolean vistaCarpeta)
    {
        this.vistaCarpeta = vistaCarpeta;
    }

    /**
     * 
     */
    public boolean isVistaCarpeta()
    {
        return this.vistaCarpeta;
    }
    
    public java.lang.Object[] getVistaCarpetaBackingList()
    {
        java.lang.Object[] values = this.vistaCarpetaValueList;
        java.lang.Object[] labels = this.vistaCarpetaLabelList;

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

    public java.lang.Object[] getVistaCarpetaValueList()
    {
        return this.vistaCarpetaValueList;
    }

    public void setVistaCarpetaValueList(java.lang.Object[] vistaCarpetaValueList)
    {
        this.vistaCarpetaValueList = vistaCarpetaValueList;
    }

    public java.lang.Object[] getVistaCarpetaLabelList()
    {
        return this.vistaCarpetaLabelList;
    }

    public void setVistaCarpetaLabelList(java.lang.Object[] vistaCarpetaLabelList)
    {
        this.vistaCarpetaLabelList = vistaCarpetaLabelList;
    }

    public void setVistaCarpetaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorBasicoSubmitFormImpl.setVistaCarpetaBackingList requires non-null property arguments");
        }

        this.vistaCarpetaValueList = null;
        this.vistaCarpetaLabelList = null;

        if (items != null)
        {
            this.vistaCarpetaValueList = new java.lang.Object[items.size()];
            this.vistaCarpetaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.vistaCarpetaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.vistaCarpetaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorBasicoSubmitFormImpl.setVistaCarpetaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>actionSubmit</code>.
     */
    public void resetActionSubmit()
    {
        this.actionSubmit = null;
    }

    public void setActionSubmit(java.lang.String actionSubmit)
    {
        this.actionSubmit = actionSubmit;
    }

    /**
     * 
     */
    public java.lang.String getActionSubmit()
    {
        return this.actionSubmit;
    }
    
    public java.lang.Object[] getActionSubmitBackingList()
    {
        java.lang.Object[] values = this.actionSubmitValueList;
        java.lang.Object[] labels = this.actionSubmitLabelList;

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

    public java.lang.Object[] getActionSubmitValueList()
    {
        return this.actionSubmitValueList;
    }

    public void setActionSubmitValueList(java.lang.Object[] actionSubmitValueList)
    {
        this.actionSubmitValueList = actionSubmitValueList;
    }

    public java.lang.Object[] getActionSubmitLabelList()
    {
        return this.actionSubmitLabelList;
    }

    public void setActionSubmitLabelList(java.lang.Object[] actionSubmitLabelList)
    {
        this.actionSubmitLabelList = actionSubmitLabelList;
    }

    public void setActionSubmitBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorBasicoSubmitFormImpl.setActionSubmitBackingList requires non-null property arguments");
        }

        this.actionSubmitValueList = null;
        this.actionSubmitLabelList = null;

        if (items != null)
        {
            this.actionSubmitValueList = new java.lang.Object[items.size()];
            this.actionSubmitLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.actionSubmitValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.actionSubmitLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorBasicoSubmitFormImpl.setActionSubmitBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>esModificar</code>.
     */
    public void resetEsModificar()
    {
        this.esModificar = false;
    }

    public void setEsModificar(boolean esModificar)
    {
        this.esModificar = esModificar;
    }

    /**
     * 
     */
    public boolean isEsModificar()
    {
        return this.esModificar;
    }
    
    public java.lang.Object[] getEsModificarBackingList()
    {
        java.lang.Object[] values = this.esModificarValueList;
        java.lang.Object[] labels = this.esModificarLabelList;

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

    public java.lang.Object[] getEsModificarValueList()
    {
        return this.esModificarValueList;
    }

    public void setEsModificarValueList(java.lang.Object[] esModificarValueList)
    {
        this.esModificarValueList = esModificarValueList;
    }

    public java.lang.Object[] getEsModificarLabelList()
    {
        return this.esModificarLabelList;
    }

    public void setEsModificarLabelList(java.lang.Object[] esModificarLabelList)
    {
        this.esModificarLabelList = esModificarLabelList;
    }

    public void setEsModificarBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorBasicoSubmitFormImpl.setEsModificarBackingList requires non-null property arguments");
        }

        this.esModificarValueList = null;
        this.esModificarLabelList = null;

        if (items != null)
        {
            this.esModificarValueList = new java.lang.Object[items.size()];
            this.esModificarLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.esModificarValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.esModificarLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorBasicoSubmitFormImpl.setEsModificarBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>actionCombo</code>.
     */
    public void resetActionCombo()
    {
        this.actionCombo = null;
    }

    public void setActionCombo(java.lang.String actionCombo)
    {
        this.actionCombo = actionCombo;
    }

    /**
     * 
     */
    public java.lang.String getActionCombo()
    {
        return this.actionCombo;
    }
    
    public java.lang.Object[] getActionComboBackingList()
    {
        java.lang.Object[] values = this.actionComboValueList;
        java.lang.Object[] labels = this.actionComboLabelList;

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

    public java.lang.Object[] getActionComboValueList()
    {
        return this.actionComboValueList;
    }

    public void setActionComboValueList(java.lang.Object[] actionComboValueList)
    {
        this.actionComboValueList = actionComboValueList;
    }

    public java.lang.Object[] getActionComboLabelList()
    {
        return this.actionComboLabelList;
    }

    public void setActionComboLabelList(java.lang.Object[] actionComboLabelList)
    {
        this.actionComboLabelList = actionComboLabelList;
    }

    public void setActionComboBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorBasicoSubmitFormImpl.setActionComboBackingList requires non-null property arguments");
        }

        this.actionComboValueList = null;
        this.actionComboLabelList = null;

        if (items != null)
        {
            this.actionComboValueList = new java.lang.Object[items.size()];
            this.actionComboLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.actionComboValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.actionComboLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorBasicoSubmitFormImpl.setActionComboBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>portapapeles</code>.
     */
    public void resetPortapapeles()
    {
        this.portapapeles = null;
    }

    public void setPortapapeles(java.util.List portapapeles)
    {
        this.portapapeles = portapapeles;
    }

    /**
     * 
     */
    public java.util.List getPortapapeles()
    {
        return this.portapapeles;
    }

    public void setPortapapelesAsArray(Object[] portapapeles)
    {
        this.portapapeles = (portapapeles == null) ? null : java.util.Arrays.asList(portapapeles);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoSubmitFormImpl#getPortapapeles
     */
    public java.lang.Object[] getPortapapelesAsArray()
    {
        return (portapapeles == null) ? null : portapapeles.toArray();
    }
    
    public java.lang.Object[] getPortapapelesBackingList()
    {
        java.lang.Object[] values = this.portapapelesValueList;
        java.lang.Object[] labels = this.portapapelesLabelList;

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

    public java.lang.Object[] getPortapapelesValueList()
    {
        return this.portapapelesValueList;
    }

    public void setPortapapelesValueList(java.lang.Object[] portapapelesValueList)
    {
        this.portapapelesValueList = portapapelesValueList;
    }

    public java.lang.Object[] getPortapapelesLabelList()
    {
        return this.portapapelesLabelList;
    }

    public void setPortapapelesLabelList(java.lang.Object[] portapapelesLabelList)
    {
        this.portapapelesLabelList = portapapelesLabelList;
    }

    public void setPortapapelesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorBasicoSubmitFormImpl.setPortapapelesBackingList requires non-null property arguments");
        }

        this.portapapelesValueList = null;
        this.portapapelesLabelList = null;

        if (items != null)
        {
            this.portapapelesValueList = new java.lang.Object[items.size()];
            this.portapapelesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.portapapelesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.portapapelesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorBasicoSubmitFormImpl.setPortapapelesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>controlMode</code>.
     */
    public void resetControlMode()
    {
        this.controlMode = null;
    }

    public void setControlMode(es.pode.empaquetador.negocio.servicio.ControlModeVO controlMode)
    {
        this.controlMode = controlMode;
    }

    /**
     * 
     */
    public es.pode.empaquetador.negocio.servicio.ControlModeVO getControlMode()
    {
        return this.controlMode;
    }
    
    public java.lang.Object[] getControlModeBackingList()
    {
        java.lang.Object[] values = this.controlModeValueList;
        java.lang.Object[] labels = this.controlModeLabelList;

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

    public java.lang.Object[] getControlModeValueList()
    {
        return this.controlModeValueList;
    }

    public void setControlModeValueList(java.lang.Object[] controlModeValueList)
    {
        this.controlModeValueList = controlModeValueList;
    }

    public java.lang.Object[] getControlModeLabelList()
    {
        return this.controlModeLabelList;
    }

    public void setControlModeLabelList(java.lang.Object[] controlModeLabelList)
    {
        this.controlModeLabelList = controlModeLabelList;
    }

    public void setControlModeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorBasicoSubmitFormImpl.setControlModeBackingList requires non-null property arguments");
        }

        this.controlModeValueList = null;
        this.controlModeLabelList = null;

        if (items != null)
        {
            this.controlModeValueList = new java.lang.Object[items.size()];
            this.controlModeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.controlModeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.controlModeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorBasicoSubmitFormImpl.setControlModeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identifierRowSelection</code>.
     */
    public void resetIdentifier()
    {
        this.identifierRowSelection = null;
    }

    public void setIdentifierRowSelection(java.util.List identifierRowSelection)
    {
        this.identifierRowSelection = identifierRowSelection;
    }

    public java.util.List getIdentifierRowSelection()
    {
        return this.identifierRowSelection;
    }

    public void setIdentifierRowSelectionAsArray(java.lang.String[] identifierRowSelection)
    {
        this.identifierRowSelection = (identifierRowSelection == null) ? null : java.util.Arrays.asList(identifierRowSelection);
    }

    public java.lang.String[] getIdentifierRowSelectionAsArray()
    {
        return (identifierRowSelection == null) ? null : (java.lang.String[])identifierRowSelection.toArray(new java.lang.String[identifierRowSelection.size()]);
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
            throw new IllegalArgumentException("GestorBasicoSubmitFormImpl.setIdentifierBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("GestorBasicoSubmitFormImpl.setIdentifierBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>grupos</code>.
     */
    public void resetGrupos()
    {
        this.grupos = null;
    }

    public void setGrupos(java.util.List grupos)
    {
        this.grupos = grupos;
    }

    /**
     * 
     */
    public java.util.List getGrupos()
    {
        return this.grupos;
    }

    public void setGruposAsArray(Object[] grupos)
    {
        this.grupos = (grupos == null) ? null : java.util.Arrays.asList(grupos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoSubmitFormImpl#getGrupos
     */
    public java.lang.Object[] getGruposAsArray()
    {
        return (grupos == null) ? null : grupos.toArray();
    }
    
    public java.lang.Object[] getGruposBackingList()
    {
        java.lang.Object[] values = this.gruposValueList;
        java.lang.Object[] labels = this.gruposLabelList;

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

    public java.lang.Object[] getGruposValueList()
    {
        return this.gruposValueList;
    }

    public void setGruposValueList(java.lang.Object[] gruposValueList)
    {
        this.gruposValueList = gruposValueList;
    }

    public java.lang.Object[] getGruposLabelList()
    {
        return this.gruposLabelList;
    }

    public void setGruposLabelList(java.lang.Object[] gruposLabelList)
    {
        this.gruposLabelList = gruposLabelList;
    }

    public void setGruposBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorBasicoSubmitFormImpl.setGruposBackingList requires non-null property arguments");
        }

        this.gruposValueList = null;
        this.gruposLabelList = null;

        if (items != null)
        {
            this.gruposValueList = new java.lang.Object[items.size()];
            this.gruposLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.gruposValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.gruposLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorBasicoSubmitFormImpl.setGruposBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("GestorBasicoSubmitFormImpl.setReturnURLBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("GestorBasicoSubmitFormImpl.setReturnURLBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.vistaCarpeta = false;
        this.esModificar = false;
        this.identifierRowSelection = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("identificadores", this.identificadores);
        builder.append("organizacion", this.organizacion);
        builder.append("actionComboValues", this.actionComboValues);
        builder.append("idCollection", this.idCollection);
        builder.append("vistaCarpeta", this.vistaCarpeta);
        builder.append("actionSubmit", this.actionSubmit);
        builder.append("esModificar", this.esModificar);
        builder.append("actionCombo", this.actionCombo);
        builder.append("portapapeles", this.portapapeles);
        builder.append("controlMode", this.controlMode);
        builder.append("identifierRowSelection", this.identifierRowSelection);
        builder.append("grupos", this.grupos);
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
        this.identificadores = null;
        this.identificadoresValueList = null;
        this.identificadoresLabelList = null;
        this.organizacion = null;
        this.organizacionValueList = null;
        this.organizacionLabelList = null;
        this.actionComboValues = null;
        this.actionComboValuesValueList = null;
        this.actionComboValuesLabelList = null;
        this.idCollection = null;
        this.idCollectionValueList = null;
        this.idCollectionLabelList = null;
        this.vistaCarpeta = false;
        this.vistaCarpetaValueList = null;
        this.vistaCarpetaLabelList = null;
        this.actionSubmit = null;
        this.actionSubmitValueList = null;
        this.actionSubmitLabelList = null;
        this.esModificar = false;
        this.esModificarValueList = null;
        this.esModificarLabelList = null;
        this.actionCombo = null;
        this.actionComboValueList = null;
        this.actionComboLabelList = null;
        this.portapapeles = null;
        this.portapapelesValueList = null;
        this.portapapelesLabelList = null;
        this.controlMode = null;
        this.controlModeValueList = null;
        this.controlModeLabelList = null;
        this.identifierRowSelection = null;
        this.grupos = null;
        this.gruposValueList = null;
        this.gruposLabelList = null;
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
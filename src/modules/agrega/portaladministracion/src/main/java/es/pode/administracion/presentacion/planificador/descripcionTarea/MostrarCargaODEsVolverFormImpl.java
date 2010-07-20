// license-header java merge-point
package es.pode.administracion.presentacion.planificador.descripcionTarea;

public class MostrarCargaODEsVolverFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
    private java.lang.Integer anio;
    private java.lang.Object[] anioValueList;
    private java.lang.Object[] anioLabelList;
    private java.lang.Integer minutos;
    private java.lang.Object[] minutosValueList;
    private java.lang.Object[] minutosLabelList;
    private java.lang.String msgPublicado;
    private java.lang.Object[] msgPublicadoValueList;
    private java.lang.Object[] msgPublicadoLabelList;
    private java.lang.String trigger;
    private java.lang.Object[] triggerValueList;
    private java.lang.Object[] triggerLabelList;
    private java.lang.String grupoTrigger;
    private java.lang.Object[] grupoTriggerValueList;
    private java.lang.Object[] grupoTriggerLabelList;
    private java.lang.String msgDescCargaODEs;
    private java.lang.Object[] msgDescCargaODEsValueList;
    private java.lang.Object[] msgDescCargaODEsLabelList;
    private java.lang.String grupoTrabajo;
    private java.lang.Object[] grupoTrabajoValueList;
    private java.lang.Object[] grupoTrabajoLabelList;
    private java.lang.String tipoTarea;
    private java.lang.Object[] tipoTareaValueList;
    private java.lang.Object[] tipoTareaLabelList;
    private java.lang.Integer dia;
    private java.lang.Object[] diaValueList;
    private java.lang.Object[] diaLabelList;
    private java.lang.String pathODEsCargados;
    private java.lang.Object[] pathODEsCargadosValueList;
    private java.lang.Object[] pathODEsCargadosLabelList;
    private java.lang.String pathODEsNoCargados;
    private java.lang.Object[] pathODEsNoCargadosValueList;
    private java.lang.Object[] pathODEsNoCargadosLabelList;
    private java.lang.Integer hora;
    private java.lang.Object[] horaValueList;
    private java.lang.Object[] horaLabelList;
    private java.lang.String msgNoPublicado;
    private java.lang.Object[] msgNoPublicadoValueList;
    private java.lang.Object[] msgNoPublicadoLabelList;
    private java.lang.Integer mes;
    private java.lang.Object[] mesValueList;
    private java.lang.Object[] mesLabelList;
    private java.lang.String periodicidad;
    private java.lang.Object[] periodicidadValueList;
    private java.lang.Object[] periodicidadLabelList;
    private java.lang.String pathODEs;
    private java.lang.Object[] pathODEsValueList;
    private java.lang.Object[] pathODEsLabelList;

    public MostrarCargaODEsVolverFormImpl()
    {
    }

    /**
     * Resets the given <code>anio</code>.
     */
    public void resetAnio()
    {
        this.anio = null;
    }

    public void setAnio(java.lang.Integer anio)
    {
        this.anio = anio;
    }

    /**
     * 
     */
    public java.lang.Integer getAnio()
    {
        return this.anio;
    }
    
    public java.lang.Object[] getAnioBackingList()
    {
        java.lang.Object[] values = this.anioValueList;
        java.lang.Object[] labels = this.anioLabelList;

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

    public java.lang.Object[] getAnioValueList()
    {
        return this.anioValueList;
    }

    public void setAnioValueList(java.lang.Object[] anioValueList)
    {
        this.anioValueList = anioValueList;
    }

    public java.lang.Object[] getAnioLabelList()
    {
        return this.anioLabelList;
    }

    public void setAnioLabelList(java.lang.Object[] anioLabelList)
    {
        this.anioLabelList = anioLabelList;
    }

    public void setAnioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setAnioBackingList requires non-null property arguments");
        }

        this.anioValueList = null;
        this.anioLabelList = null;

        if (items != null)
        {
            this.anioValueList = new java.lang.Object[items.size()];
            this.anioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.anioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.anioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setAnioBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>minutos</code>.
     */
    public void resetMinutos()
    {
        this.minutos = null;
    }

    public void setMinutos(java.lang.Integer minutos)
    {
        this.minutos = minutos;
    }

    /**
     * 
     */
    public java.lang.Integer getMinutos()
    {
        return this.minutos;
    }
    
    public java.lang.Object[] getMinutosBackingList()
    {
        java.lang.Object[] values = this.minutosValueList;
        java.lang.Object[] labels = this.minutosLabelList;

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

    public java.lang.Object[] getMinutosValueList()
    {
        return this.minutosValueList;
    }

    public void setMinutosValueList(java.lang.Object[] minutosValueList)
    {
        this.minutosValueList = minutosValueList;
    }

    public java.lang.Object[] getMinutosLabelList()
    {
        return this.minutosLabelList;
    }

    public void setMinutosLabelList(java.lang.Object[] minutosLabelList)
    {
        this.minutosLabelList = minutosLabelList;
    }

    public void setMinutosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setMinutosBackingList requires non-null property arguments");
        }

        this.minutosValueList = null;
        this.minutosLabelList = null;

        if (items != null)
        {
            this.minutosValueList = new java.lang.Object[items.size()];
            this.minutosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.minutosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.minutosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setMinutosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>msgPublicado</code>.
     */
    public void resetMsgPublicado()
    {
        this.msgPublicado = null;
    }

    public void setMsgPublicado(java.lang.String msgPublicado)
    {
        this.msgPublicado = msgPublicado;
    }

    /**
     * 
     */
    public java.lang.String getMsgPublicado()
    {
        return this.msgPublicado;
    }
    
    public java.lang.Object[] getMsgPublicadoBackingList()
    {
        java.lang.Object[] values = this.msgPublicadoValueList;
        java.lang.Object[] labels = this.msgPublicadoLabelList;

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

    public java.lang.Object[] getMsgPublicadoValueList()
    {
        return this.msgPublicadoValueList;
    }

    public void setMsgPublicadoValueList(java.lang.Object[] msgPublicadoValueList)
    {
        this.msgPublicadoValueList = msgPublicadoValueList;
    }

    public java.lang.Object[] getMsgPublicadoLabelList()
    {
        return this.msgPublicadoLabelList;
    }

    public void setMsgPublicadoLabelList(java.lang.Object[] msgPublicadoLabelList)
    {
        this.msgPublicadoLabelList = msgPublicadoLabelList;
    }

    public void setMsgPublicadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setMsgPublicadoBackingList requires non-null property arguments");
        }

        this.msgPublicadoValueList = null;
        this.msgPublicadoLabelList = null;

        if (items != null)
        {
            this.msgPublicadoValueList = new java.lang.Object[items.size()];
            this.msgPublicadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.msgPublicadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.msgPublicadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setMsgPublicadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>trigger</code>.
     */
    public void resetTrigger()
    {
        this.trigger = null;
    }

    public void setTrigger(java.lang.String trigger)
    {
        this.trigger = trigger;
    }

    /**
     * 
     */
    public java.lang.String getTrigger()
    {
        return this.trigger;
    }
    
    public java.lang.Object[] getTriggerBackingList()
    {
        java.lang.Object[] values = this.triggerValueList;
        java.lang.Object[] labels = this.triggerLabelList;

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

    public java.lang.Object[] getTriggerValueList()
    {
        return this.triggerValueList;
    }

    public void setTriggerValueList(java.lang.Object[] triggerValueList)
    {
        this.triggerValueList = triggerValueList;
    }

    public java.lang.Object[] getTriggerLabelList()
    {
        return this.triggerLabelList;
    }

    public void setTriggerLabelList(java.lang.Object[] triggerLabelList)
    {
        this.triggerLabelList = triggerLabelList;
    }

    public void setTriggerBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setTriggerBackingList requires non-null property arguments");
        }

        this.triggerValueList = null;
        this.triggerLabelList = null;

        if (items != null)
        {
            this.triggerValueList = new java.lang.Object[items.size()];
            this.triggerLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.triggerValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.triggerLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setTriggerBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>grupoTrigger</code>.
     */
    public void resetGrupoTrigger()
    {
        this.grupoTrigger = null;
    }

    public void setGrupoTrigger(java.lang.String grupoTrigger)
    {
        this.grupoTrigger = grupoTrigger;
    }

    /**
     * 
     */
    public java.lang.String getGrupoTrigger()
    {
        return this.grupoTrigger;
    }
    
    public java.lang.Object[] getGrupoTriggerBackingList()
    {
        java.lang.Object[] values = this.grupoTriggerValueList;
        java.lang.Object[] labels = this.grupoTriggerLabelList;

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

    public java.lang.Object[] getGrupoTriggerValueList()
    {
        return this.grupoTriggerValueList;
    }

    public void setGrupoTriggerValueList(java.lang.Object[] grupoTriggerValueList)
    {
        this.grupoTriggerValueList = grupoTriggerValueList;
    }

    public java.lang.Object[] getGrupoTriggerLabelList()
    {
        return this.grupoTriggerLabelList;
    }

    public void setGrupoTriggerLabelList(java.lang.Object[] grupoTriggerLabelList)
    {
        this.grupoTriggerLabelList = grupoTriggerLabelList;
    }

    public void setGrupoTriggerBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setGrupoTriggerBackingList requires non-null property arguments");
        }

        this.grupoTriggerValueList = null;
        this.grupoTriggerLabelList = null;

        if (items != null)
        {
            this.grupoTriggerValueList = new java.lang.Object[items.size()];
            this.grupoTriggerLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.grupoTriggerValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.grupoTriggerLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setGrupoTriggerBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>msgDescCargaODEs</code>.
     */
    public void resetMsgDescCargaODEs()
    {
        this.msgDescCargaODEs = null;
    }

    public void setMsgDescCargaODEs(java.lang.String msgDescCargaODEs)
    {
        this.msgDescCargaODEs = msgDescCargaODEs;
    }

    /**
     * 
     */
    public java.lang.String getMsgDescCargaODEs()
    {
        return this.msgDescCargaODEs;
    }
    
    public java.lang.Object[] getMsgDescCargaODEsBackingList()
    {
        java.lang.Object[] values = this.msgDescCargaODEsValueList;
        java.lang.Object[] labels = this.msgDescCargaODEsLabelList;

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

    public java.lang.Object[] getMsgDescCargaODEsValueList()
    {
        return this.msgDescCargaODEsValueList;
    }

    public void setMsgDescCargaODEsValueList(java.lang.Object[] msgDescCargaODEsValueList)
    {
        this.msgDescCargaODEsValueList = msgDescCargaODEsValueList;
    }

    public java.lang.Object[] getMsgDescCargaODEsLabelList()
    {
        return this.msgDescCargaODEsLabelList;
    }

    public void setMsgDescCargaODEsLabelList(java.lang.Object[] msgDescCargaODEsLabelList)
    {
        this.msgDescCargaODEsLabelList = msgDescCargaODEsLabelList;
    }

    public void setMsgDescCargaODEsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setMsgDescCargaODEsBackingList requires non-null property arguments");
        }

        this.msgDescCargaODEsValueList = null;
        this.msgDescCargaODEsLabelList = null;

        if (items != null)
        {
            this.msgDescCargaODEsValueList = new java.lang.Object[items.size()];
            this.msgDescCargaODEsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.msgDescCargaODEsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.msgDescCargaODEsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setMsgDescCargaODEsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>grupoTrabajo</code>.
     */
    public void resetGrupoTrabajo()
    {
        this.grupoTrabajo = null;
    }

    public void setGrupoTrabajo(java.lang.String grupoTrabajo)
    {
        this.grupoTrabajo = grupoTrabajo;
    }

    /**
     * 
     */
    public java.lang.String getGrupoTrabajo()
    {
        return this.grupoTrabajo;
    }
    
    public java.lang.Object[] getGrupoTrabajoBackingList()
    {
        java.lang.Object[] values = this.grupoTrabajoValueList;
        java.lang.Object[] labels = this.grupoTrabajoLabelList;

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

    public java.lang.Object[] getGrupoTrabajoValueList()
    {
        return this.grupoTrabajoValueList;
    }

    public void setGrupoTrabajoValueList(java.lang.Object[] grupoTrabajoValueList)
    {
        this.grupoTrabajoValueList = grupoTrabajoValueList;
    }

    public java.lang.Object[] getGrupoTrabajoLabelList()
    {
        return this.grupoTrabajoLabelList;
    }

    public void setGrupoTrabajoLabelList(java.lang.Object[] grupoTrabajoLabelList)
    {
        this.grupoTrabajoLabelList = grupoTrabajoLabelList;
    }

    public void setGrupoTrabajoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setGrupoTrabajoBackingList requires non-null property arguments");
        }

        this.grupoTrabajoValueList = null;
        this.grupoTrabajoLabelList = null;

        if (items != null)
        {
            this.grupoTrabajoValueList = new java.lang.Object[items.size()];
            this.grupoTrabajoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.grupoTrabajoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.grupoTrabajoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setGrupoTrabajoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoTarea</code>.
     */
    public void resetTipoTarea()
    {
        this.tipoTarea = null;
    }

    public void setTipoTarea(java.lang.String tipoTarea)
    {
        this.tipoTarea = tipoTarea;
    }

    /**
     * 
     */
    public java.lang.String getTipoTarea()
    {
        return this.tipoTarea;
    }
    
    public java.lang.Object[] getTipoTareaBackingList()
    {
        java.lang.Object[] values = this.tipoTareaValueList;
        java.lang.Object[] labels = this.tipoTareaLabelList;

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

    public java.lang.Object[] getTipoTareaValueList()
    {
        return this.tipoTareaValueList;
    }

    public void setTipoTareaValueList(java.lang.Object[] tipoTareaValueList)
    {
        this.tipoTareaValueList = tipoTareaValueList;
    }

    public java.lang.Object[] getTipoTareaLabelList()
    {
        return this.tipoTareaLabelList;
    }

    public void setTipoTareaLabelList(java.lang.Object[] tipoTareaLabelList)
    {
        this.tipoTareaLabelList = tipoTareaLabelList;
    }

    public void setTipoTareaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setTipoTareaBackingList requires non-null property arguments");
        }

        this.tipoTareaValueList = null;
        this.tipoTareaLabelList = null;

        if (items != null)
        {
            this.tipoTareaValueList = new java.lang.Object[items.size()];
            this.tipoTareaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoTareaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoTareaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setTipoTareaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>dia</code>.
     */
    public void resetDia()
    {
        this.dia = null;
    }

    public void setDia(java.lang.Integer dia)
    {
        this.dia = dia;
    }

    /**
     * 
     */
    public java.lang.Integer getDia()
    {
        return this.dia;
    }
    
    public java.lang.Object[] getDiaBackingList()
    {
        java.lang.Object[] values = this.diaValueList;
        java.lang.Object[] labels = this.diaLabelList;

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

    public java.lang.Object[] getDiaValueList()
    {
        return this.diaValueList;
    }

    public void setDiaValueList(java.lang.Object[] diaValueList)
    {
        this.diaValueList = diaValueList;
    }

    public java.lang.Object[] getDiaLabelList()
    {
        return this.diaLabelList;
    }

    public void setDiaLabelList(java.lang.Object[] diaLabelList)
    {
        this.diaLabelList = diaLabelList;
    }

    public void setDiaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setDiaBackingList requires non-null property arguments");
        }

        this.diaValueList = null;
        this.diaLabelList = null;

        if (items != null)
        {
            this.diaValueList = new java.lang.Object[items.size()];
            this.diaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.diaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.diaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setDiaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>pathODEsCargados</code>.
     */
    public void resetPathODEsCargados()
    {
        this.pathODEsCargados = null;
    }

    public void setPathODEsCargados(java.lang.String pathODEsCargados)
    {
        this.pathODEsCargados = pathODEsCargados;
    }

    /**
     * 
     */
    public java.lang.String getPathODEsCargados()
    {
        return this.pathODEsCargados;
    }
    
    public java.lang.Object[] getPathODEsCargadosBackingList()
    {
        java.lang.Object[] values = this.pathODEsCargadosValueList;
        java.lang.Object[] labels = this.pathODEsCargadosLabelList;

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

    public java.lang.Object[] getPathODEsCargadosValueList()
    {
        return this.pathODEsCargadosValueList;
    }

    public void setPathODEsCargadosValueList(java.lang.Object[] pathODEsCargadosValueList)
    {
        this.pathODEsCargadosValueList = pathODEsCargadosValueList;
    }

    public java.lang.Object[] getPathODEsCargadosLabelList()
    {
        return this.pathODEsCargadosLabelList;
    }

    public void setPathODEsCargadosLabelList(java.lang.Object[] pathODEsCargadosLabelList)
    {
        this.pathODEsCargadosLabelList = pathODEsCargadosLabelList;
    }

    public void setPathODEsCargadosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setPathODEsCargadosBackingList requires non-null property arguments");
        }

        this.pathODEsCargadosValueList = null;
        this.pathODEsCargadosLabelList = null;

        if (items != null)
        {
            this.pathODEsCargadosValueList = new java.lang.Object[items.size()];
            this.pathODEsCargadosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.pathODEsCargadosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.pathODEsCargadosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setPathODEsCargadosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>pathODEsNoCargados</code>.
     */
    public void resetPathODEsNoCargados()
    {
        this.pathODEsNoCargados = null;
    }

    public void setPathODEsNoCargados(java.lang.String pathODEsNoCargados)
    {
        this.pathODEsNoCargados = pathODEsNoCargados;
    }

    /**
     * 
     */
    public java.lang.String getPathODEsNoCargados()
    {
        return this.pathODEsNoCargados;
    }
    
    public java.lang.Object[] getPathODEsNoCargadosBackingList()
    {
        java.lang.Object[] values = this.pathODEsNoCargadosValueList;
        java.lang.Object[] labels = this.pathODEsNoCargadosLabelList;

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

    public java.lang.Object[] getPathODEsNoCargadosValueList()
    {
        return this.pathODEsNoCargadosValueList;
    }

    public void setPathODEsNoCargadosValueList(java.lang.Object[] pathODEsNoCargadosValueList)
    {
        this.pathODEsNoCargadosValueList = pathODEsNoCargadosValueList;
    }

    public java.lang.Object[] getPathODEsNoCargadosLabelList()
    {
        return this.pathODEsNoCargadosLabelList;
    }

    public void setPathODEsNoCargadosLabelList(java.lang.Object[] pathODEsNoCargadosLabelList)
    {
        this.pathODEsNoCargadosLabelList = pathODEsNoCargadosLabelList;
    }

    public void setPathODEsNoCargadosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setPathODEsNoCargadosBackingList requires non-null property arguments");
        }

        this.pathODEsNoCargadosValueList = null;
        this.pathODEsNoCargadosLabelList = null;

        if (items != null)
        {
            this.pathODEsNoCargadosValueList = new java.lang.Object[items.size()];
            this.pathODEsNoCargadosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.pathODEsNoCargadosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.pathODEsNoCargadosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setPathODEsNoCargadosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>hora</code>.
     */
    public void resetHora()
    {
        this.hora = null;
    }

    public void setHora(java.lang.Integer hora)
    {
        this.hora = hora;
    }

    /**
     * 
     */
    public java.lang.Integer getHora()
    {
        return this.hora;
    }
    
    public java.lang.Object[] getHoraBackingList()
    {
        java.lang.Object[] values = this.horaValueList;
        java.lang.Object[] labels = this.horaLabelList;

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

    public java.lang.Object[] getHoraValueList()
    {
        return this.horaValueList;
    }

    public void setHoraValueList(java.lang.Object[] horaValueList)
    {
        this.horaValueList = horaValueList;
    }

    public java.lang.Object[] getHoraLabelList()
    {
        return this.horaLabelList;
    }

    public void setHoraLabelList(java.lang.Object[] horaLabelList)
    {
        this.horaLabelList = horaLabelList;
    }

    public void setHoraBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setHoraBackingList requires non-null property arguments");
        }

        this.horaValueList = null;
        this.horaLabelList = null;

        if (items != null)
        {
            this.horaValueList = new java.lang.Object[items.size()];
            this.horaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.horaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.horaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setHoraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>msgNoPublicado</code>.
     */
    public void resetMsgNoPublicado()
    {
        this.msgNoPublicado = null;
    }

    public void setMsgNoPublicado(java.lang.String msgNoPublicado)
    {
        this.msgNoPublicado = msgNoPublicado;
    }

    /**
     * 
     */
    public java.lang.String getMsgNoPublicado()
    {
        return this.msgNoPublicado;
    }
    
    public java.lang.Object[] getMsgNoPublicadoBackingList()
    {
        java.lang.Object[] values = this.msgNoPublicadoValueList;
        java.lang.Object[] labels = this.msgNoPublicadoLabelList;

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

    public java.lang.Object[] getMsgNoPublicadoValueList()
    {
        return this.msgNoPublicadoValueList;
    }

    public void setMsgNoPublicadoValueList(java.lang.Object[] msgNoPublicadoValueList)
    {
        this.msgNoPublicadoValueList = msgNoPublicadoValueList;
    }

    public java.lang.Object[] getMsgNoPublicadoLabelList()
    {
        return this.msgNoPublicadoLabelList;
    }

    public void setMsgNoPublicadoLabelList(java.lang.Object[] msgNoPublicadoLabelList)
    {
        this.msgNoPublicadoLabelList = msgNoPublicadoLabelList;
    }

    public void setMsgNoPublicadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setMsgNoPublicadoBackingList requires non-null property arguments");
        }

        this.msgNoPublicadoValueList = null;
        this.msgNoPublicadoLabelList = null;

        if (items != null)
        {
            this.msgNoPublicadoValueList = new java.lang.Object[items.size()];
            this.msgNoPublicadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.msgNoPublicadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.msgNoPublicadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setMsgNoPublicadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>mes</code>.
     */
    public void resetMes()
    {
        this.mes = null;
    }

    public void setMes(java.lang.Integer mes)
    {
        this.mes = mes;
    }

    /**
     * 
     */
    public java.lang.Integer getMes()
    {
        return this.mes;
    }
    
    public java.lang.Object[] getMesBackingList()
    {
        java.lang.Object[] values = this.mesValueList;
        java.lang.Object[] labels = this.mesLabelList;

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

    public java.lang.Object[] getMesValueList()
    {
        return this.mesValueList;
    }

    public void setMesValueList(java.lang.Object[] mesValueList)
    {
        this.mesValueList = mesValueList;
    }

    public java.lang.Object[] getMesLabelList()
    {
        return this.mesLabelList;
    }

    public void setMesLabelList(java.lang.Object[] mesLabelList)
    {
        this.mesLabelList = mesLabelList;
    }

    public void setMesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setMesBackingList requires non-null property arguments");
        }

        this.mesValueList = null;
        this.mesLabelList = null;

        if (items != null)
        {
            this.mesValueList = new java.lang.Object[items.size()];
            this.mesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setMesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>periodicidad</code>.
     */
    public void resetPeriodicidad()
    {
        this.periodicidad = null;
    }

    public void setPeriodicidad(java.lang.String periodicidad)
    {
        this.periodicidad = periodicidad;
    }

    /**
     * 
     */
    public java.lang.String getPeriodicidad()
    {
        return this.periodicidad;
    }
    
    public java.lang.Object[] getPeriodicidadBackingList()
    {
        java.lang.Object[] values = this.periodicidadValueList;
        java.lang.Object[] labels = this.periodicidadLabelList;

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

    public java.lang.Object[] getPeriodicidadValueList()
    {
        return this.periodicidadValueList;
    }

    public void setPeriodicidadValueList(java.lang.Object[] periodicidadValueList)
    {
        this.periodicidadValueList = periodicidadValueList;
    }

    public java.lang.Object[] getPeriodicidadLabelList()
    {
        return this.periodicidadLabelList;
    }

    public void setPeriodicidadLabelList(java.lang.Object[] periodicidadLabelList)
    {
        this.periodicidadLabelList = periodicidadLabelList;
    }

    public void setPeriodicidadBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setPeriodicidadBackingList requires non-null property arguments");
        }

        this.periodicidadValueList = null;
        this.periodicidadLabelList = null;

        if (items != null)
        {
            this.periodicidadValueList = new java.lang.Object[items.size()];
            this.periodicidadLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.periodicidadValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.periodicidadLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setPeriodicidadBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>pathODEs</code>.
     */
    public void resetPathODEs()
    {
        this.pathODEs = null;
    }

    public void setPathODEs(java.lang.String pathODEs)
    {
        this.pathODEs = pathODEs;
    }

    /**
     * 
     */
    public java.lang.String getPathODEs()
    {
        return this.pathODEs;
    }
    
    public java.lang.Object[] getPathODEsBackingList()
    {
        java.lang.Object[] values = this.pathODEsValueList;
        java.lang.Object[] labels = this.pathODEsLabelList;

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

    public java.lang.Object[] getPathODEsValueList()
    {
        return this.pathODEsValueList;
    }

    public void setPathODEsValueList(java.lang.Object[] pathODEsValueList)
    {
        this.pathODEsValueList = pathODEsValueList;
    }

    public java.lang.Object[] getPathODEsLabelList()
    {
        return this.pathODEsLabelList;
    }

    public void setPathODEsLabelList(java.lang.Object[] pathODEsLabelList)
    {
        this.pathODEsLabelList = pathODEsLabelList;
    }

    public void setPathODEsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarCargaODEsVolverFormImpl.setPathODEsBackingList requires non-null property arguments");
        }

        this.pathODEsValueList = null;
        this.pathODEsLabelList = null;

        if (items != null)
        {
            this.pathODEsValueList = new java.lang.Object[items.size()];
            this.pathODEsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.pathODEsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.pathODEsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarCargaODEsVolverFormImpl.setPathODEsBackingList encountered an exception", ex);
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
        builder.append("anio", this.anio);
        builder.append("minutos", this.minutos);
        builder.append("msgPublicado", this.msgPublicado);
        builder.append("trigger", this.trigger);
        builder.append("grupoTrigger", this.grupoTrigger);
        builder.append("msgDescCargaODEs", this.msgDescCargaODEs);
        builder.append("grupoTrabajo", this.grupoTrabajo);
        builder.append("tipoTarea", this.tipoTarea);
        builder.append("dia", this.dia);
        builder.append("pathODEsCargados", this.pathODEsCargados);
        builder.append("pathODEsNoCargados", this.pathODEsNoCargados);
        builder.append("hora", this.hora);
        builder.append("msgNoPublicado", this.msgNoPublicado);
        builder.append("mes", this.mes);
        builder.append("periodicidad", this.periodicidad);
        builder.append("pathODEs", this.pathODEs);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.anio = null;
        this.anioValueList = null;
        this.anioLabelList = null;
        this.minutos = null;
        this.minutosValueList = null;
        this.minutosLabelList = null;
        this.msgPublicado = null;
        this.msgPublicadoValueList = null;
        this.msgPublicadoLabelList = null;
        this.trigger = null;
        this.triggerValueList = null;
        this.triggerLabelList = null;
        this.grupoTrigger = null;
        this.grupoTriggerValueList = null;
        this.grupoTriggerLabelList = null;
        this.msgDescCargaODEs = null;
        this.msgDescCargaODEsValueList = null;
        this.msgDescCargaODEsLabelList = null;
        this.grupoTrabajo = null;
        this.grupoTrabajoValueList = null;
        this.grupoTrabajoLabelList = null;
        this.tipoTarea = null;
        this.tipoTareaValueList = null;
        this.tipoTareaLabelList = null;
        this.dia = null;
        this.diaValueList = null;
        this.diaLabelList = null;
        this.pathODEsCargados = null;
        this.pathODEsCargadosValueList = null;
        this.pathODEsCargadosLabelList = null;
        this.pathODEsNoCargados = null;
        this.pathODEsNoCargadosValueList = null;
        this.pathODEsNoCargadosLabelList = null;
        this.hora = null;
        this.horaValueList = null;
        this.horaLabelList = null;
        this.msgNoPublicado = null;
        this.msgNoPublicadoValueList = null;
        this.msgNoPublicadoLabelList = null;
        this.mes = null;
        this.mesValueList = null;
        this.mesLabelList = null;
        this.periodicidad = null;
        this.periodicidadValueList = null;
        this.periodicidadLabelList = null;
        this.pathODEs = null;
        this.pathODEsValueList = null;
        this.pathODEsLabelList = null;
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
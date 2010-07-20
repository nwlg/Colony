// license-header java merge-point
package es.pode.administracion.presentacion.planificador.modificarTarea;

public class ObtenerTCargaODEsFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaModificarCargaODEsForm
        , es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFechaUsuarioForm
        , es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTipoTareaForm
        , es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFechaForm
        , es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFederadoForm
        , es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaNoDisponibleForm
        , es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFechaRangoForm
        , es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaReindexadoForm
        , es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeCatalogoForm
{
    private java.lang.String minutos;
    private java.lang.Object[] minutosValueList;
    private java.lang.Object[] minutosLabelList;
    private java.lang.String anio;
    private java.lang.Object[] anioValueList;
    private java.lang.Object[] anioLabelList;
    private java.lang.String anioHasta;
    private java.lang.Object[] anioHastaValueList;
    private java.lang.Object[] anioHastaLabelList;
    private java.lang.String grupoTrigger;
    private java.lang.Object[] grupoTriggerValueList;
    private java.lang.Object[] grupoTriggerLabelList;
    private java.lang.String grupoTrabajo;
    private java.lang.Object[] grupoTrabajoValueList;
    private java.lang.Object[] grupoTrabajoLabelList;
    private java.lang.String usuario;
    private java.lang.Object[] usuarioValueList;
    private java.lang.Object[] usuarioLabelList;
    private java.lang.String msgReindexado;
    private java.lang.Object[] msgReindexadoValueList;
    private java.lang.Object[] msgReindexadoLabelList;
    private java.lang.String pathODEsNoCarg;
    private java.lang.Object[] pathODEsNoCargValueList;
    private java.lang.Object[] pathODEsNoCargLabelList;
    private java.lang.String formato;
    private java.lang.Object[] formatoValueList;
    private java.lang.Object[] formatoLabelList;
    private java.lang.String sobrescribir;
    private java.lang.Object[] sobrescribirValueList;
    private java.lang.Object[] sobrescribirLabelList;
    private java.lang.String anioDesde;
    private java.lang.Object[] anioDesdeValueList;
    private java.lang.Object[] anioDesdeLabelList;
    private java.lang.String msgInforme;
    private java.lang.Object[] msgInformeValueList;
    private java.lang.Object[] msgInformeLabelList;
    private java.lang.String mes;
    private java.lang.Object[] mesValueList;
    private java.lang.Object[] mesLabelList;
    private java.lang.String msgNoPublicado;
    private java.lang.Object[] msgNoPublicadoValueList;
    private java.lang.Object[] msgNoPublicadoLabelList;
    private java.lang.String pathODEsCarg;
    private java.lang.Object[] pathODEsCargValueList;
    private java.lang.Object[] pathODEsCargLabelList;
    private java.lang.String periodicidad;
    private java.lang.Object[] periodicidadValueList;
    private java.lang.Object[] periodicidadLabelList;
    private java.lang.Integer aniohasta;
    private java.lang.Object[] aniohastaValueList;
    private java.lang.Object[] aniohastaLabelList;
    private java.lang.String trigger;
    private java.lang.Object[] triggerValueList;
    private java.lang.Object[] triggerLabelList;
    private java.lang.String msgPublicado;
    private java.lang.Object[] msgPublicadoValueList;
    private java.lang.Object[] msgPublicadoLabelList;
    private java.lang.String tipoTarea;
    private java.lang.Object[] tipoTareaValueList;
    private java.lang.Object[] tipoTareaLabelList;
    private java.lang.String msgDescCargaODEs;
    private java.lang.Object[] msgDescCargaODEsValueList;
    private java.lang.Object[] msgDescCargaODEsLabelList;
    private java.lang.String informe;
    private java.lang.Object[] informeValueList;
    private java.lang.Object[] informeLabelList;
    private java.lang.String dia;
    private java.lang.Object[] diaValueList;
    private java.lang.Object[] diaLabelList;
    private java.lang.String msgNoEliminado;
    private java.lang.Object[] msgNoEliminadoValueList;
    private java.lang.Object[] msgNoEliminadoLabelList;
    private java.lang.String diaHasta;
    private java.lang.Object[] diaHastaValueList;
    private java.lang.Object[] diaHastaLabelList;
    private java.lang.String msgEliminado;
    private java.lang.Object[] msgEliminadoValueList;
    private java.lang.Object[] msgEliminadoLabelList;
    private java.lang.String hora;
    private java.lang.Object[] horaValueList;
    private java.lang.Object[] horaLabelList;
    private java.lang.String msgNoInforme;
    private java.lang.Object[] msgNoInformeValueList;
    private java.lang.Object[] msgNoInformeLabelList;
    private java.lang.String msgDescTrabajo;
    private java.lang.Object[] msgDescTrabajoValueList;
    private java.lang.Object[] msgDescTrabajoLabelList;
    private java.lang.String trabajo;
    private java.lang.Object[] trabajoValueList;
    private java.lang.Object[] trabajoLabelList;
    private java.lang.String msgNoReindexado;
    private java.lang.Object[] msgNoReindexadoValueList;
    private java.lang.Object[] msgNoReindexadoLabelList;
    private java.lang.String msgDescReindexado;
    private java.lang.Object[] msgDescReindexadoValueList;
    private java.lang.Object[] msgDescReindexadoLabelList;
    private java.lang.Integer rango;
    private java.lang.Object[] rangoValueList;
    private java.lang.Object[] rangoLabelList;
    private java.lang.String mesHasta;
    private java.lang.Object[] mesHastaValueList;
    private java.lang.Object[] mesHastaLabelList;
    private java.lang.String repositorio;
    private java.lang.Object[] repositorioValueList;
    private java.lang.Object[] repositorioLabelList;
    private java.lang.String pathODEs;
    private java.lang.Object[] pathODEsValueList;
    private java.lang.Object[] pathODEsLabelList;
    private java.lang.String mesDesde;
    private java.lang.Object[] mesDesdeValueList;
    private java.lang.Object[] mesDesdeLabelList;
    private java.lang.String diaDesde;
    private java.lang.Object[] diaDesdeValueList;
    private java.lang.Object[] diaDesdeLabelList;

    public ObtenerTCargaODEsFormImpl()
    {
    }

    /**
     * Resets the given <code>minutos</code>.
     */
    public void resetMinutos()
    {
        this.minutos = null;
    }

    public void setMinutos(java.lang.String minutos)
    {
        this.minutos = minutos;
    }

    /**
     * 
     */
    public java.lang.String getMinutos()
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
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMinutosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMinutosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>anio</code>.
     */
    public void resetAnio()
    {
        this.anio = null;
    }

    public void setAnio(java.lang.String anio)
    {
        this.anio = anio;
    }

    /**
     * 
     */
    public java.lang.String getAnio()
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
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setAnioBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setAnioBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>anioHasta</code>.
     */
    public void resetAnioHasta()
    {
        this.anioHasta = null;
    }

    public void setAnioHasta(java.lang.String anioHasta)
    {
        this.anioHasta = anioHasta;
    }

    /**
     * 
     */
    public java.lang.String getAnioHasta()
    {
        return this.anioHasta;
    }
    
    public java.lang.Object[] getAnioHastaBackingList()
    {
        java.lang.Object[] values = this.anioHastaValueList;
        java.lang.Object[] labels = this.anioHastaLabelList;

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

    public java.lang.Object[] getAnioHastaValueList()
    {
        return this.anioHastaValueList;
    }

    public void setAnioHastaValueList(java.lang.Object[] anioHastaValueList)
    {
        this.anioHastaValueList = anioHastaValueList;
    }

    public java.lang.Object[] getAnioHastaLabelList()
    {
        return this.anioHastaLabelList;
    }

    public void setAnioHastaLabelList(java.lang.Object[] anioHastaLabelList)
    {
        this.anioHastaLabelList = anioHastaLabelList;
    }

    public void setAnioHastaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setAnioHastaBackingList requires non-null property arguments");
        }

        this.anioHastaValueList = null;
        this.anioHastaLabelList = null;

        if (items != null)
        {
            this.anioHastaValueList = new java.lang.Object[items.size()];
            this.anioHastaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.anioHastaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.anioHastaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setAnioHastaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setGrupoTriggerBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setGrupoTriggerBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setGrupoTrabajoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setGrupoTrabajoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>usuario</code>.
     */
    public void resetUsuario()
    {
        this.usuario = null;
    }

    public void setUsuario(java.lang.String usuario)
    {
        this.usuario = usuario;
    }

    /**
     * 
     */
    public java.lang.String getUsuario()
    {
        return this.usuario;
    }
    
    public java.lang.Object[] getUsuarioBackingList()
    {
        java.lang.Object[] values = this.usuarioValueList;
        java.lang.Object[] labels = this.usuarioLabelList;

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

    public java.lang.Object[] getUsuarioValueList()
    {
        return this.usuarioValueList;
    }

    public void setUsuarioValueList(java.lang.Object[] usuarioValueList)
    {
        this.usuarioValueList = usuarioValueList;
    }

    public java.lang.Object[] getUsuarioLabelList()
    {
        return this.usuarioLabelList;
    }

    public void setUsuarioLabelList(java.lang.Object[] usuarioLabelList)
    {
        this.usuarioLabelList = usuarioLabelList;
    }

    public void setUsuarioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setUsuarioBackingList requires non-null property arguments");
        }

        this.usuarioValueList = null;
        this.usuarioLabelList = null;

        if (items != null)
        {
            this.usuarioValueList = new java.lang.Object[items.size()];
            this.usuarioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.usuarioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.usuarioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setUsuarioBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>msgReindexado</code>.
     */
    public void resetMsgReindexado()
    {
        this.msgReindexado = null;
    }

    public void setMsgReindexado(java.lang.String msgReindexado)
    {
        this.msgReindexado = msgReindexado;
    }

    /**
     * 
     */
    public java.lang.String getMsgReindexado()
    {
        return this.msgReindexado;
    }
    
    public java.lang.Object[] getMsgReindexadoBackingList()
    {
        java.lang.Object[] values = this.msgReindexadoValueList;
        java.lang.Object[] labels = this.msgReindexadoLabelList;

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

    public java.lang.Object[] getMsgReindexadoValueList()
    {
        return this.msgReindexadoValueList;
    }

    public void setMsgReindexadoValueList(java.lang.Object[] msgReindexadoValueList)
    {
        this.msgReindexadoValueList = msgReindexadoValueList;
    }

    public java.lang.Object[] getMsgReindexadoLabelList()
    {
        return this.msgReindexadoLabelList;
    }

    public void setMsgReindexadoLabelList(java.lang.Object[] msgReindexadoLabelList)
    {
        this.msgReindexadoLabelList = msgReindexadoLabelList;
    }

    public void setMsgReindexadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMsgReindexadoBackingList requires non-null property arguments");
        }

        this.msgReindexadoValueList = null;
        this.msgReindexadoLabelList = null;

        if (items != null)
        {
            this.msgReindexadoValueList = new java.lang.Object[items.size()];
            this.msgReindexadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.msgReindexadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.msgReindexadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMsgReindexadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>pathODEsNoCarg</code>.
     */
    public void resetPathODEsNoCarg()
    {
        this.pathODEsNoCarg = null;
    }

    public void setPathODEsNoCarg(java.lang.String pathODEsNoCarg)
    {
        this.pathODEsNoCarg = pathODEsNoCarg;
    }

    /**
     * 
     */
    public java.lang.String getPathODEsNoCarg()
    {
        return this.pathODEsNoCarg;
    }
    
    public java.lang.Object[] getPathODEsNoCargBackingList()
    {
        java.lang.Object[] values = this.pathODEsNoCargValueList;
        java.lang.Object[] labels = this.pathODEsNoCargLabelList;

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

    public java.lang.Object[] getPathODEsNoCargValueList()
    {
        return this.pathODEsNoCargValueList;
    }

    public void setPathODEsNoCargValueList(java.lang.Object[] pathODEsNoCargValueList)
    {
        this.pathODEsNoCargValueList = pathODEsNoCargValueList;
    }

    public java.lang.Object[] getPathODEsNoCargLabelList()
    {
        return this.pathODEsNoCargLabelList;
    }

    public void setPathODEsNoCargLabelList(java.lang.Object[] pathODEsNoCargLabelList)
    {
        this.pathODEsNoCargLabelList = pathODEsNoCargLabelList;
    }

    public void setPathODEsNoCargBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setPathODEsNoCargBackingList requires non-null property arguments");
        }

        this.pathODEsNoCargValueList = null;
        this.pathODEsNoCargLabelList = null;

        if (items != null)
        {
            this.pathODEsNoCargValueList = new java.lang.Object[items.size()];
            this.pathODEsNoCargLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.pathODEsNoCargValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.pathODEsNoCargLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setPathODEsNoCargBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>formato</code>.
     */
    public void resetFormato()
    {
        this.formato = null;
    }

    public void setFormato(java.lang.String formato)
    {
        this.formato = formato;
    }

    /**
     * 
     */
    public java.lang.String getFormato()
    {
        return this.formato;
    }
    
    public java.lang.Object[] getFormatoBackingList()
    {
        java.lang.Object[] values = this.formatoValueList;
        java.lang.Object[] labels = this.formatoLabelList;

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

    public java.lang.Object[] getFormatoValueList()
    {
        return this.formatoValueList;
    }

    public void setFormatoValueList(java.lang.Object[] formatoValueList)
    {
        this.formatoValueList = formatoValueList;
    }

    public java.lang.Object[] getFormatoLabelList()
    {
        return this.formatoLabelList;
    }

    public void setFormatoLabelList(java.lang.Object[] formatoLabelList)
    {
        this.formatoLabelList = formatoLabelList;
    }

    public void setFormatoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setFormatoBackingList requires non-null property arguments");
        }

        this.formatoValueList = null;
        this.formatoLabelList = null;

        if (items != null)
        {
            this.formatoValueList = new java.lang.Object[items.size()];
            this.formatoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.formatoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.formatoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setFormatoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>sobrescribir</code>.
     */
    public void resetSobrescribir()
    {
        this.sobrescribir = null;
    }

    public void setSobrescribir(java.lang.String sobrescribir)
    {
        this.sobrescribir = sobrescribir;
    }

    /**
     * 
     */
    public java.lang.String getSobrescribir()
    {
        return this.sobrescribir;
    }
    
    public java.lang.Object[] getSobrescribirBackingList()
    {
        java.lang.Object[] values = this.sobrescribirValueList;
        java.lang.Object[] labels = this.sobrescribirLabelList;

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

    public java.lang.Object[] getSobrescribirValueList()
    {
        return this.sobrescribirValueList;
    }

    public void setSobrescribirValueList(java.lang.Object[] sobrescribirValueList)
    {
        this.sobrescribirValueList = sobrescribirValueList;
    }

    public java.lang.Object[] getSobrescribirLabelList()
    {
        return this.sobrescribirLabelList;
    }

    public void setSobrescribirLabelList(java.lang.Object[] sobrescribirLabelList)
    {
        this.sobrescribirLabelList = sobrescribirLabelList;
    }

    public void setSobrescribirBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setSobrescribirBackingList requires non-null property arguments");
        }

        this.sobrescribirValueList = null;
        this.sobrescribirLabelList = null;

        if (items != null)
        {
            this.sobrescribirValueList = new java.lang.Object[items.size()];
            this.sobrescribirLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.sobrescribirValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.sobrescribirLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setSobrescribirBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>anioDesde</code>.
     */
    public void resetAnioDesde()
    {
        this.anioDesde = null;
    }

    public void setAnioDesde(java.lang.String anioDesde)
    {
        this.anioDesde = anioDesde;
    }

    /**
     * 
     */
    public java.lang.String getAnioDesde()
    {
        return this.anioDesde;
    }
    
    public java.lang.Object[] getAnioDesdeBackingList()
    {
        java.lang.Object[] values = this.anioDesdeValueList;
        java.lang.Object[] labels = this.anioDesdeLabelList;

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

    public java.lang.Object[] getAnioDesdeValueList()
    {
        return this.anioDesdeValueList;
    }

    public void setAnioDesdeValueList(java.lang.Object[] anioDesdeValueList)
    {
        this.anioDesdeValueList = anioDesdeValueList;
    }

    public java.lang.Object[] getAnioDesdeLabelList()
    {
        return this.anioDesdeLabelList;
    }

    public void setAnioDesdeLabelList(java.lang.Object[] anioDesdeLabelList)
    {
        this.anioDesdeLabelList = anioDesdeLabelList;
    }

    public void setAnioDesdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setAnioDesdeBackingList requires non-null property arguments");
        }

        this.anioDesdeValueList = null;
        this.anioDesdeLabelList = null;

        if (items != null)
        {
            this.anioDesdeValueList = new java.lang.Object[items.size()];
            this.anioDesdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.anioDesdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.anioDesdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setAnioDesdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>msgInforme</code>.
     */
    public void resetMsgInforme()
    {
        this.msgInforme = null;
    }

    public void setMsgInforme(java.lang.String msgInforme)
    {
        this.msgInforme = msgInforme;
    }

    /**
     * 
     */
    public java.lang.String getMsgInforme()
    {
        return this.msgInforme;
    }
    
    public java.lang.Object[] getMsgInformeBackingList()
    {
        java.lang.Object[] values = this.msgInformeValueList;
        java.lang.Object[] labels = this.msgInformeLabelList;

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

    public java.lang.Object[] getMsgInformeValueList()
    {
        return this.msgInformeValueList;
    }

    public void setMsgInformeValueList(java.lang.Object[] msgInformeValueList)
    {
        this.msgInformeValueList = msgInformeValueList;
    }

    public java.lang.Object[] getMsgInformeLabelList()
    {
        return this.msgInformeLabelList;
    }

    public void setMsgInformeLabelList(java.lang.Object[] msgInformeLabelList)
    {
        this.msgInformeLabelList = msgInformeLabelList;
    }

    public void setMsgInformeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMsgInformeBackingList requires non-null property arguments");
        }

        this.msgInformeValueList = null;
        this.msgInformeLabelList = null;

        if (items != null)
        {
            this.msgInformeValueList = new java.lang.Object[items.size()];
            this.msgInformeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.msgInformeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.msgInformeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMsgInformeBackingList encountered an exception", ex);
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

    public void setMes(java.lang.String mes)
    {
        this.mes = mes;
    }

    /**
     * 
     */
    public java.lang.String getMes()
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
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMsgNoPublicadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMsgNoPublicadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>pathODEsCarg</code>.
     */
    public void resetPathODEsCarg()
    {
        this.pathODEsCarg = null;
    }

    public void setPathODEsCarg(java.lang.String pathODEsCarg)
    {
        this.pathODEsCarg = pathODEsCarg;
    }

    /**
     * 
     */
    public java.lang.String getPathODEsCarg()
    {
        return this.pathODEsCarg;
    }
    
    public java.lang.Object[] getPathODEsCargBackingList()
    {
        java.lang.Object[] values = this.pathODEsCargValueList;
        java.lang.Object[] labels = this.pathODEsCargLabelList;

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

    public java.lang.Object[] getPathODEsCargValueList()
    {
        return this.pathODEsCargValueList;
    }

    public void setPathODEsCargValueList(java.lang.Object[] pathODEsCargValueList)
    {
        this.pathODEsCargValueList = pathODEsCargValueList;
    }

    public java.lang.Object[] getPathODEsCargLabelList()
    {
        return this.pathODEsCargLabelList;
    }

    public void setPathODEsCargLabelList(java.lang.Object[] pathODEsCargLabelList)
    {
        this.pathODEsCargLabelList = pathODEsCargLabelList;
    }

    public void setPathODEsCargBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setPathODEsCargBackingList requires non-null property arguments");
        }

        this.pathODEsCargValueList = null;
        this.pathODEsCargLabelList = null;

        if (items != null)
        {
            this.pathODEsCargValueList = new java.lang.Object[items.size()];
            this.pathODEsCargLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.pathODEsCargValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.pathODEsCargLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setPathODEsCargBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setPeriodicidadBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setPeriodicidadBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>aniohasta</code>.
     */
    public void resetAniohasta()
    {
        this.aniohasta = null;
    }

    public void setAniohasta(java.lang.Integer aniohasta)
    {
        this.aniohasta = aniohasta;
    }

    /**
     * 
     */
    public java.lang.Integer getAniohasta()
    {
        return this.aniohasta;
    }
    
    public java.lang.Object[] getAniohastaBackingList()
    {
        java.lang.Object[] values = this.aniohastaValueList;
        java.lang.Object[] labels = this.aniohastaLabelList;

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

    public java.lang.Object[] getAniohastaValueList()
    {
        return this.aniohastaValueList;
    }

    public void setAniohastaValueList(java.lang.Object[] aniohastaValueList)
    {
        this.aniohastaValueList = aniohastaValueList;
    }

    public java.lang.Object[] getAniohastaLabelList()
    {
        return this.aniohastaLabelList;
    }

    public void setAniohastaLabelList(java.lang.Object[] aniohastaLabelList)
    {
        this.aniohastaLabelList = aniohastaLabelList;
    }

    public void setAniohastaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setAniohastaBackingList requires non-null property arguments");
        }

        this.aniohastaValueList = null;
        this.aniohastaLabelList = null;

        if (items != null)
        {
            this.aniohastaValueList = new java.lang.Object[items.size()];
            this.aniohastaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.aniohastaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.aniohastaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setAniohastaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setTriggerBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setTriggerBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMsgPublicadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMsgPublicadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setTipoTareaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setTipoTareaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMsgDescCargaODEsBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMsgDescCargaODEsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>informe</code>.
     */
    public void resetInforme()
    {
        this.informe = null;
    }

    public void setInforme(java.lang.String informe)
    {
        this.informe = informe;
    }

    /**
     * 
     */
    public java.lang.String getInforme()
    {
        return this.informe;
    }
    
    public java.lang.Object[] getInformeBackingList()
    {
        java.lang.Object[] values = this.informeValueList;
        java.lang.Object[] labels = this.informeLabelList;

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

    public java.lang.Object[] getInformeValueList()
    {
        return this.informeValueList;
    }

    public void setInformeValueList(java.lang.Object[] informeValueList)
    {
        this.informeValueList = informeValueList;
    }

    public java.lang.Object[] getInformeLabelList()
    {
        return this.informeLabelList;
    }

    public void setInformeLabelList(java.lang.Object[] informeLabelList)
    {
        this.informeLabelList = informeLabelList;
    }

    public void setInformeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setInformeBackingList requires non-null property arguments");
        }

        this.informeValueList = null;
        this.informeLabelList = null;

        if (items != null)
        {
            this.informeValueList = new java.lang.Object[items.size()];
            this.informeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.informeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.informeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setInformeBackingList encountered an exception", ex);
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

    public void setDia(java.lang.String dia)
    {
        this.dia = dia;
    }

    /**
     * 
     */
    public java.lang.String getDia()
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
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setDiaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setDiaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>msgNoEliminado</code>.
     */
    public void resetMsgNoEliminado()
    {
        this.msgNoEliminado = null;
    }

    public void setMsgNoEliminado(java.lang.String msgNoEliminado)
    {
        this.msgNoEliminado = msgNoEliminado;
    }

    /**
     * 
     */
    public java.lang.String getMsgNoEliminado()
    {
        return this.msgNoEliminado;
    }
    
    public java.lang.Object[] getMsgNoEliminadoBackingList()
    {
        java.lang.Object[] values = this.msgNoEliminadoValueList;
        java.lang.Object[] labels = this.msgNoEliminadoLabelList;

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

    public java.lang.Object[] getMsgNoEliminadoValueList()
    {
        return this.msgNoEliminadoValueList;
    }

    public void setMsgNoEliminadoValueList(java.lang.Object[] msgNoEliminadoValueList)
    {
        this.msgNoEliminadoValueList = msgNoEliminadoValueList;
    }

    public java.lang.Object[] getMsgNoEliminadoLabelList()
    {
        return this.msgNoEliminadoLabelList;
    }

    public void setMsgNoEliminadoLabelList(java.lang.Object[] msgNoEliminadoLabelList)
    {
        this.msgNoEliminadoLabelList = msgNoEliminadoLabelList;
    }

    public void setMsgNoEliminadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMsgNoEliminadoBackingList requires non-null property arguments");
        }

        this.msgNoEliminadoValueList = null;
        this.msgNoEliminadoLabelList = null;

        if (items != null)
        {
            this.msgNoEliminadoValueList = new java.lang.Object[items.size()];
            this.msgNoEliminadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.msgNoEliminadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.msgNoEliminadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMsgNoEliminadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>diaHasta</code>.
     */
    public void resetDiaHasta()
    {
        this.diaHasta = null;
    }

    public void setDiaHasta(java.lang.String diaHasta)
    {
        this.diaHasta = diaHasta;
    }

    /**
     * 
     */
    public java.lang.String getDiaHasta()
    {
        return this.diaHasta;
    }
    
    public java.lang.Object[] getDiaHastaBackingList()
    {
        java.lang.Object[] values = this.diaHastaValueList;
        java.lang.Object[] labels = this.diaHastaLabelList;

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

    public java.lang.Object[] getDiaHastaValueList()
    {
        return this.diaHastaValueList;
    }

    public void setDiaHastaValueList(java.lang.Object[] diaHastaValueList)
    {
        this.diaHastaValueList = diaHastaValueList;
    }

    public java.lang.Object[] getDiaHastaLabelList()
    {
        return this.diaHastaLabelList;
    }

    public void setDiaHastaLabelList(java.lang.Object[] diaHastaLabelList)
    {
        this.diaHastaLabelList = diaHastaLabelList;
    }

    public void setDiaHastaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setDiaHastaBackingList requires non-null property arguments");
        }

        this.diaHastaValueList = null;
        this.diaHastaLabelList = null;

        if (items != null)
        {
            this.diaHastaValueList = new java.lang.Object[items.size()];
            this.diaHastaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.diaHastaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.diaHastaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setDiaHastaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>msgEliminado</code>.
     */
    public void resetMsgEliminado()
    {
        this.msgEliminado = null;
    }

    public void setMsgEliminado(java.lang.String msgEliminado)
    {
        this.msgEliminado = msgEliminado;
    }

    /**
     * 
     */
    public java.lang.String getMsgEliminado()
    {
        return this.msgEliminado;
    }
    
    public java.lang.Object[] getMsgEliminadoBackingList()
    {
        java.lang.Object[] values = this.msgEliminadoValueList;
        java.lang.Object[] labels = this.msgEliminadoLabelList;

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

    public java.lang.Object[] getMsgEliminadoValueList()
    {
        return this.msgEliminadoValueList;
    }

    public void setMsgEliminadoValueList(java.lang.Object[] msgEliminadoValueList)
    {
        this.msgEliminadoValueList = msgEliminadoValueList;
    }

    public java.lang.Object[] getMsgEliminadoLabelList()
    {
        return this.msgEliminadoLabelList;
    }

    public void setMsgEliminadoLabelList(java.lang.Object[] msgEliminadoLabelList)
    {
        this.msgEliminadoLabelList = msgEliminadoLabelList;
    }

    public void setMsgEliminadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMsgEliminadoBackingList requires non-null property arguments");
        }

        this.msgEliminadoValueList = null;
        this.msgEliminadoLabelList = null;

        if (items != null)
        {
            this.msgEliminadoValueList = new java.lang.Object[items.size()];
            this.msgEliminadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.msgEliminadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.msgEliminadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMsgEliminadoBackingList encountered an exception", ex);
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

    public void setHora(java.lang.String hora)
    {
        this.hora = hora;
    }

    /**
     * 
     */
    public java.lang.String getHora()
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
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setHoraBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setHoraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>msgNoInforme</code>.
     */
    public void resetMsgNoInforme()
    {
        this.msgNoInforme = null;
    }

    public void setMsgNoInforme(java.lang.String msgNoInforme)
    {
        this.msgNoInforme = msgNoInforme;
    }

    /**
     * 
     */
    public java.lang.String getMsgNoInforme()
    {
        return this.msgNoInforme;
    }
    
    public java.lang.Object[] getMsgNoInformeBackingList()
    {
        java.lang.Object[] values = this.msgNoInformeValueList;
        java.lang.Object[] labels = this.msgNoInformeLabelList;

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

    public java.lang.Object[] getMsgNoInformeValueList()
    {
        return this.msgNoInformeValueList;
    }

    public void setMsgNoInformeValueList(java.lang.Object[] msgNoInformeValueList)
    {
        this.msgNoInformeValueList = msgNoInformeValueList;
    }

    public java.lang.Object[] getMsgNoInformeLabelList()
    {
        return this.msgNoInformeLabelList;
    }

    public void setMsgNoInformeLabelList(java.lang.Object[] msgNoInformeLabelList)
    {
        this.msgNoInformeLabelList = msgNoInformeLabelList;
    }

    public void setMsgNoInformeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMsgNoInformeBackingList requires non-null property arguments");
        }

        this.msgNoInformeValueList = null;
        this.msgNoInformeLabelList = null;

        if (items != null)
        {
            this.msgNoInformeValueList = new java.lang.Object[items.size()];
            this.msgNoInformeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.msgNoInformeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.msgNoInformeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMsgNoInformeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>msgDescTrabajo</code>.
     */
    public void resetMsgDescTrabajo()
    {
        this.msgDescTrabajo = null;
    }

    public void setMsgDescTrabajo(java.lang.String msgDescTrabajo)
    {
        this.msgDescTrabajo = msgDescTrabajo;
    }

    /**
     * 
     */
    public java.lang.String getMsgDescTrabajo()
    {
        return this.msgDescTrabajo;
    }
    
    public java.lang.Object[] getMsgDescTrabajoBackingList()
    {
        java.lang.Object[] values = this.msgDescTrabajoValueList;
        java.lang.Object[] labels = this.msgDescTrabajoLabelList;

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

    public java.lang.Object[] getMsgDescTrabajoValueList()
    {
        return this.msgDescTrabajoValueList;
    }

    public void setMsgDescTrabajoValueList(java.lang.Object[] msgDescTrabajoValueList)
    {
        this.msgDescTrabajoValueList = msgDescTrabajoValueList;
    }

    public java.lang.Object[] getMsgDescTrabajoLabelList()
    {
        return this.msgDescTrabajoLabelList;
    }

    public void setMsgDescTrabajoLabelList(java.lang.Object[] msgDescTrabajoLabelList)
    {
        this.msgDescTrabajoLabelList = msgDescTrabajoLabelList;
    }

    public void setMsgDescTrabajoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMsgDescTrabajoBackingList requires non-null property arguments");
        }

        this.msgDescTrabajoValueList = null;
        this.msgDescTrabajoLabelList = null;

        if (items != null)
        {
            this.msgDescTrabajoValueList = new java.lang.Object[items.size()];
            this.msgDescTrabajoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.msgDescTrabajoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.msgDescTrabajoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMsgDescTrabajoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>trabajo</code>.
     */
    public void resetTrabajo()
    {
        this.trabajo = null;
    }

    public void setTrabajo(java.lang.String trabajo)
    {
        this.trabajo = trabajo;
    }

    /**
     * 
     */
    public java.lang.String getTrabajo()
    {
        return this.trabajo;
    }
    
    public java.lang.Object[] getTrabajoBackingList()
    {
        java.lang.Object[] values = this.trabajoValueList;
        java.lang.Object[] labels = this.trabajoLabelList;

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

    public java.lang.Object[] getTrabajoValueList()
    {
        return this.trabajoValueList;
    }

    public void setTrabajoValueList(java.lang.Object[] trabajoValueList)
    {
        this.trabajoValueList = trabajoValueList;
    }

    public java.lang.Object[] getTrabajoLabelList()
    {
        return this.trabajoLabelList;
    }

    public void setTrabajoLabelList(java.lang.Object[] trabajoLabelList)
    {
        this.trabajoLabelList = trabajoLabelList;
    }

    public void setTrabajoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setTrabajoBackingList requires non-null property arguments");
        }

        this.trabajoValueList = null;
        this.trabajoLabelList = null;

        if (items != null)
        {
            this.trabajoValueList = new java.lang.Object[items.size()];
            this.trabajoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.trabajoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.trabajoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setTrabajoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>msgNoReindexado</code>.
     */
    public void resetMsgNoReindexado()
    {
        this.msgNoReindexado = null;
    }

    public void setMsgNoReindexado(java.lang.String msgNoReindexado)
    {
        this.msgNoReindexado = msgNoReindexado;
    }

    /**
     * 
     */
    public java.lang.String getMsgNoReindexado()
    {
        return this.msgNoReindexado;
    }
    
    public java.lang.Object[] getMsgNoReindexadoBackingList()
    {
        java.lang.Object[] values = this.msgNoReindexadoValueList;
        java.lang.Object[] labels = this.msgNoReindexadoLabelList;

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

    public java.lang.Object[] getMsgNoReindexadoValueList()
    {
        return this.msgNoReindexadoValueList;
    }

    public void setMsgNoReindexadoValueList(java.lang.Object[] msgNoReindexadoValueList)
    {
        this.msgNoReindexadoValueList = msgNoReindexadoValueList;
    }

    public java.lang.Object[] getMsgNoReindexadoLabelList()
    {
        return this.msgNoReindexadoLabelList;
    }

    public void setMsgNoReindexadoLabelList(java.lang.Object[] msgNoReindexadoLabelList)
    {
        this.msgNoReindexadoLabelList = msgNoReindexadoLabelList;
    }

    public void setMsgNoReindexadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMsgNoReindexadoBackingList requires non-null property arguments");
        }

        this.msgNoReindexadoValueList = null;
        this.msgNoReindexadoLabelList = null;

        if (items != null)
        {
            this.msgNoReindexadoValueList = new java.lang.Object[items.size()];
            this.msgNoReindexadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.msgNoReindexadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.msgNoReindexadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMsgNoReindexadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>msgDescReindexado</code>.
     */
    public void resetMsgDescReindexado()
    {
        this.msgDescReindexado = null;
    }

    public void setMsgDescReindexado(java.lang.String msgDescReindexado)
    {
        this.msgDescReindexado = msgDescReindexado;
    }

    /**
     * 
     */
    public java.lang.String getMsgDescReindexado()
    {
        return this.msgDescReindexado;
    }
    
    public java.lang.Object[] getMsgDescReindexadoBackingList()
    {
        java.lang.Object[] values = this.msgDescReindexadoValueList;
        java.lang.Object[] labels = this.msgDescReindexadoLabelList;

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

    public java.lang.Object[] getMsgDescReindexadoValueList()
    {
        return this.msgDescReindexadoValueList;
    }

    public void setMsgDescReindexadoValueList(java.lang.Object[] msgDescReindexadoValueList)
    {
        this.msgDescReindexadoValueList = msgDescReindexadoValueList;
    }

    public java.lang.Object[] getMsgDescReindexadoLabelList()
    {
        return this.msgDescReindexadoLabelList;
    }

    public void setMsgDescReindexadoLabelList(java.lang.Object[] msgDescReindexadoLabelList)
    {
        this.msgDescReindexadoLabelList = msgDescReindexadoLabelList;
    }

    public void setMsgDescReindexadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMsgDescReindexadoBackingList requires non-null property arguments");
        }

        this.msgDescReindexadoValueList = null;
        this.msgDescReindexadoLabelList = null;

        if (items != null)
        {
            this.msgDescReindexadoValueList = new java.lang.Object[items.size()];
            this.msgDescReindexadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.msgDescReindexadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.msgDescReindexadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMsgDescReindexadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>rango</code>.
     */
    public void resetRango()
    {
        this.rango = null;
    }

    public void setRango(java.lang.Integer rango)
    {
        this.rango = rango;
    }

    /**
     * 
     */
    public java.lang.Integer getRango()
    {
        return this.rango;
    }
    
    public java.lang.Object[] getRangoBackingList()
    {
        java.lang.Object[] values = this.rangoValueList;
        java.lang.Object[] labels = this.rangoLabelList;

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

    public java.lang.Object[] getRangoValueList()
    {
        return this.rangoValueList;
    }

    public void setRangoValueList(java.lang.Object[] rangoValueList)
    {
        this.rangoValueList = rangoValueList;
    }

    public java.lang.Object[] getRangoLabelList()
    {
        return this.rangoLabelList;
    }

    public void setRangoLabelList(java.lang.Object[] rangoLabelList)
    {
        this.rangoLabelList = rangoLabelList;
    }

    public void setRangoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setRangoBackingList requires non-null property arguments");
        }

        this.rangoValueList = null;
        this.rangoLabelList = null;

        if (items != null)
        {
            this.rangoValueList = new java.lang.Object[items.size()];
            this.rangoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.rangoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.rangoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setRangoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>mesHasta</code>.
     */
    public void resetMesHasta()
    {
        this.mesHasta = null;
    }

    public void setMesHasta(java.lang.String mesHasta)
    {
        this.mesHasta = mesHasta;
    }

    /**
     * 
     */
    public java.lang.String getMesHasta()
    {
        return this.mesHasta;
    }
    
    public java.lang.Object[] getMesHastaBackingList()
    {
        java.lang.Object[] values = this.mesHastaValueList;
        java.lang.Object[] labels = this.mesHastaLabelList;

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

    public java.lang.Object[] getMesHastaValueList()
    {
        return this.mesHastaValueList;
    }

    public void setMesHastaValueList(java.lang.Object[] mesHastaValueList)
    {
        this.mesHastaValueList = mesHastaValueList;
    }

    public java.lang.Object[] getMesHastaLabelList()
    {
        return this.mesHastaLabelList;
    }

    public void setMesHastaLabelList(java.lang.Object[] mesHastaLabelList)
    {
        this.mesHastaLabelList = mesHastaLabelList;
    }

    public void setMesHastaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMesHastaBackingList requires non-null property arguments");
        }

        this.mesHastaValueList = null;
        this.mesHastaLabelList = null;

        if (items != null)
        {
            this.mesHastaValueList = new java.lang.Object[items.size()];
            this.mesHastaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mesHastaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mesHastaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMesHastaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>repositorio</code>.
     */
    public void resetRepositorio()
    {
        this.repositorio = null;
    }

    public void setRepositorio(java.lang.String repositorio)
    {
        this.repositorio = repositorio;
    }

    /**
     * 
     */
    public java.lang.String getRepositorio()
    {
        return this.repositorio;
    }
    
    public java.lang.Object[] getRepositorioBackingList()
    {
        java.lang.Object[] values = this.repositorioValueList;
        java.lang.Object[] labels = this.repositorioLabelList;

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

    public java.lang.Object[] getRepositorioValueList()
    {
        return this.repositorioValueList;
    }

    public void setRepositorioValueList(java.lang.Object[] repositorioValueList)
    {
        this.repositorioValueList = repositorioValueList;
    }

    public java.lang.Object[] getRepositorioLabelList()
    {
        return this.repositorioLabelList;
    }

    public void setRepositorioLabelList(java.lang.Object[] repositorioLabelList)
    {
        this.repositorioLabelList = repositorioLabelList;
    }

    public void setRepositorioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setRepositorioBackingList requires non-null property arguments");
        }

        this.repositorioValueList = null;
        this.repositorioLabelList = null;

        if (items != null)
        {
            this.repositorioValueList = new java.lang.Object[items.size()];
            this.repositorioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.repositorioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.repositorioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setRepositorioBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setPathODEsBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setPathODEsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>mesDesde</code>.
     */
    public void resetMesDesde()
    {
        this.mesDesde = null;
    }

    public void setMesDesde(java.lang.String mesDesde)
    {
        this.mesDesde = mesDesde;
    }

    /**
     * 
     */
    public java.lang.String getMesDesde()
    {
        return this.mesDesde;
    }
    
    public java.lang.Object[] getMesDesdeBackingList()
    {
        java.lang.Object[] values = this.mesDesdeValueList;
        java.lang.Object[] labels = this.mesDesdeLabelList;

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

    public java.lang.Object[] getMesDesdeValueList()
    {
        return this.mesDesdeValueList;
    }

    public void setMesDesdeValueList(java.lang.Object[] mesDesdeValueList)
    {
        this.mesDesdeValueList = mesDesdeValueList;
    }

    public java.lang.Object[] getMesDesdeLabelList()
    {
        return this.mesDesdeLabelList;
    }

    public void setMesDesdeLabelList(java.lang.Object[] mesDesdeLabelList)
    {
        this.mesDesdeLabelList = mesDesdeLabelList;
    }

    public void setMesDesdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setMesDesdeBackingList requires non-null property arguments");
        }

        this.mesDesdeValueList = null;
        this.mesDesdeLabelList = null;

        if (items != null)
        {
            this.mesDesdeValueList = new java.lang.Object[items.size()];
            this.mesDesdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mesDesdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mesDesdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setMesDesdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>diaDesde</code>.
     */
    public void resetDiaDesde()
    {
        this.diaDesde = null;
    }

    public void setDiaDesde(java.lang.String diaDesde)
    {
        this.diaDesde = diaDesde;
    }

    /**
     * 
     */
    public java.lang.String getDiaDesde()
    {
        return this.diaDesde;
    }
    
    public java.lang.Object[] getDiaDesdeBackingList()
    {
        java.lang.Object[] values = this.diaDesdeValueList;
        java.lang.Object[] labels = this.diaDesdeLabelList;

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

    public java.lang.Object[] getDiaDesdeValueList()
    {
        return this.diaDesdeValueList;
    }

    public void setDiaDesdeValueList(java.lang.Object[] diaDesdeValueList)
    {
        this.diaDesdeValueList = diaDesdeValueList;
    }

    public java.lang.Object[] getDiaDesdeLabelList()
    {
        return this.diaDesdeLabelList;
    }

    public void setDiaDesdeLabelList(java.lang.Object[] diaDesdeLabelList)
    {
        this.diaDesdeLabelList = diaDesdeLabelList;
    }

    public void setDiaDesdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObtenerTCargaODEsFormImpl.setDiaDesdeBackingList requires non-null property arguments");
        }

        this.diaDesdeValueList = null;
        this.diaDesdeLabelList = null;

        if (items != null)
        {
            this.diaDesdeValueList = new java.lang.Object[items.size()];
            this.diaDesdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.diaDesdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.diaDesdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObtenerTCargaODEsFormImpl.setDiaDesdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.usuario = null;
        this.repositorio = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("minutos", this.minutos);
        builder.append("anio", this.anio);
        builder.append("anioHasta", this.anioHasta);
        builder.append("grupoTrigger", this.grupoTrigger);
        builder.append("grupoTrabajo", this.grupoTrabajo);
        builder.append("usuario", this.usuario);
        builder.append("msgReindexado", this.msgReindexado);
        builder.append("pathODEsNoCarg", this.pathODEsNoCarg);
        builder.append("formato", this.formato);
        builder.append("sobrescribir", this.sobrescribir);
        builder.append("anioDesde", this.anioDesde);
        builder.append("msgInforme", this.msgInforme);
        builder.append("mes", this.mes);
        builder.append("msgNoPublicado", this.msgNoPublicado);
        builder.append("pathODEsCarg", this.pathODEsCarg);
        builder.append("periodicidad", this.periodicidad);
        builder.append("aniohasta", this.aniohasta);
        builder.append("trigger", this.trigger);
        builder.append("msgPublicado", this.msgPublicado);
        builder.append("tipoTarea", this.tipoTarea);
        builder.append("msgDescCargaODEs", this.msgDescCargaODEs);
        builder.append("informe", this.informe);
        builder.append("dia", this.dia);
        builder.append("msgNoEliminado", this.msgNoEliminado);
        builder.append("diaHasta", this.diaHasta);
        builder.append("msgEliminado", this.msgEliminado);
        builder.append("hora", this.hora);
        builder.append("msgNoInforme", this.msgNoInforme);
        builder.append("msgDescTrabajo", this.msgDescTrabajo);
        builder.append("trabajo", this.trabajo);
        builder.append("msgNoReindexado", this.msgNoReindexado);
        builder.append("msgDescReindexado", this.msgDescReindexado);
        builder.append("rango", this.rango);
        builder.append("mesHasta", this.mesHasta);
        builder.append("repositorio", this.repositorio);
        builder.append("pathODEs", this.pathODEs);
        builder.append("mesDesde", this.mesDesde);
        builder.append("diaDesde", this.diaDesde);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.minutos = null;
        this.minutosValueList = null;
        this.minutosLabelList = null;
        this.anio = null;
        this.anioValueList = null;
        this.anioLabelList = null;
        this.anioHasta = null;
        this.anioHastaValueList = null;
        this.anioHastaLabelList = null;
        this.grupoTrigger = null;
        this.grupoTriggerValueList = null;
        this.grupoTriggerLabelList = null;
        this.grupoTrabajo = null;
        this.grupoTrabajoValueList = null;
        this.grupoTrabajoLabelList = null;
        this.usuario = null;
        this.usuarioValueList = null;
        this.usuarioLabelList = null;
        this.msgReindexado = null;
        this.msgReindexadoValueList = null;
        this.msgReindexadoLabelList = null;
        this.pathODEsNoCarg = null;
        this.pathODEsNoCargValueList = null;
        this.pathODEsNoCargLabelList = null;
        this.formato = null;
        this.formatoValueList = null;
        this.formatoLabelList = null;
        this.sobrescribir = null;
        this.sobrescribirValueList = null;
        this.sobrescribirLabelList = null;
        this.anioDesde = null;
        this.anioDesdeValueList = null;
        this.anioDesdeLabelList = null;
        this.msgInforme = null;
        this.msgInformeValueList = null;
        this.msgInformeLabelList = null;
        this.mes = null;
        this.mesValueList = null;
        this.mesLabelList = null;
        this.msgNoPublicado = null;
        this.msgNoPublicadoValueList = null;
        this.msgNoPublicadoLabelList = null;
        this.pathODEsCarg = null;
        this.pathODEsCargValueList = null;
        this.pathODEsCargLabelList = null;
        this.periodicidad = null;
        this.periodicidadValueList = null;
        this.periodicidadLabelList = null;
        this.aniohasta = null;
        this.aniohastaValueList = null;
        this.aniohastaLabelList = null;
        this.trigger = null;
        this.triggerValueList = null;
        this.triggerLabelList = null;
        this.msgPublicado = null;
        this.msgPublicadoValueList = null;
        this.msgPublicadoLabelList = null;
        this.tipoTarea = null;
        this.tipoTareaValueList = null;
        this.tipoTareaLabelList = null;
        this.msgDescCargaODEs = null;
        this.msgDescCargaODEsValueList = null;
        this.msgDescCargaODEsLabelList = null;
        this.informe = null;
        this.informeValueList = null;
        this.informeLabelList = null;
        this.dia = null;
        this.diaValueList = null;
        this.diaLabelList = null;
        this.msgNoEliminado = null;
        this.msgNoEliminadoValueList = null;
        this.msgNoEliminadoLabelList = null;
        this.diaHasta = null;
        this.diaHastaValueList = null;
        this.diaHastaLabelList = null;
        this.msgEliminado = null;
        this.msgEliminadoValueList = null;
        this.msgEliminadoLabelList = null;
        this.hora = null;
        this.horaValueList = null;
        this.horaLabelList = null;
        this.msgNoInforme = null;
        this.msgNoInformeValueList = null;
        this.msgNoInformeLabelList = null;
        this.msgDescTrabajo = null;
        this.msgDescTrabajoValueList = null;
        this.msgDescTrabajoLabelList = null;
        this.trabajo = null;
        this.trabajoValueList = null;
        this.trabajoLabelList = null;
        this.msgNoReindexado = null;
        this.msgNoReindexadoValueList = null;
        this.msgNoReindexadoLabelList = null;
        this.msgDescReindexado = null;
        this.msgDescReindexadoValueList = null;
        this.msgDescReindexadoLabelList = null;
        this.rango = null;
        this.rangoValueList = null;
        this.rangoLabelList = null;
        this.mesHasta = null;
        this.mesHastaValueList = null;
        this.mesHastaLabelList = null;
        this.repositorio = null;
        this.repositorioValueList = null;
        this.repositorioLabelList = null;
        this.pathODEs = null;
        this.pathODEsValueList = null;
        this.pathODEsLabelList = null;
        this.mesDesde = null;
        this.mesDesdeValueList = null;
        this.mesDesdeLabelList = null;
        this.diaDesde = null;
        this.diaDesdeValueList = null;
        this.diaDesdeLabelList = null;
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
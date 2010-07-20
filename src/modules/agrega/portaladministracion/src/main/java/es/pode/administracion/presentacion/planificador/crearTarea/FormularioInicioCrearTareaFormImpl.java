// license-header java merge-point
package es.pode.administracion.presentacion.planificador.crearTarea;

public class FormularioInicioCrearTareaFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaInformeCatalogoForm
        , es.pode.administracion.presentacion.planificador.crearTarea.CargarIdiomaReindexadoForm
        , es.pode.administracion.presentacion.planificador.crearTarea.ObtenerUsuariosForm
        , es.pode.administracion.presentacion.planificador.crearTarea.CrearTareaForm
{
    private java.lang.String anioHasta;
    private java.lang.Object[] anioHastaValueList;
    private java.lang.Object[] anioHastaLabelList;
    private java.lang.String minutos;
    private java.lang.Object[] minutosValueList;
    private java.lang.Object[] minutosLabelList;
    private java.lang.String anio;
    private java.lang.Object[] anioValueList;
    private java.lang.Object[] anioLabelList;
    private java.lang.String repositorioIndices;
    private java.lang.Object[] repositorioIndicesValueList;
    private java.lang.Object[] repositorioIndicesLabelList;
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
    private java.lang.String tareaModificada;
    private java.lang.Object[] tareaModificadaValueList;
    private java.lang.Object[] tareaModificadaLabelList;
    private java.lang.String periodicidad;
    private java.lang.Object[] periodicidadValueList;
    private java.lang.Object[] periodicidadLabelList;
    private java.lang.String pathODEsCarg;
    private java.lang.Object[] pathODEsCargValueList;
    private java.lang.Object[] pathODEsCargLabelList;
    private java.lang.String trigger;
    private java.lang.Object[] triggerValueList;
    private java.lang.Object[] triggerLabelList;
    private java.lang.String msgPublicado;
    private java.lang.Object[] msgPublicadoValueList;
    private java.lang.Object[] msgPublicadoLabelList;
    private java.lang.String tipoTarea;
    private java.lang.Object[] tipoTareaValueList;
    private java.lang.Object[] tipoTareaLabelList;
    private java.lang.String informe;
    private java.lang.Object[] informeValueList;
    private java.lang.Object[] informeLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
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
    private java.lang.String trabajo;
    private java.lang.Object[] trabajoValueList;
    private java.lang.Object[] trabajoLabelList;
    private java.lang.String msgDescTrabajo;
    private java.lang.Object[] msgDescTrabajoValueList;
    private java.lang.Object[] msgDescTrabajoLabelList;
    private java.lang.String msgNoReindexado;
    private java.lang.Object[] msgNoReindexadoValueList;
    private java.lang.Object[] msgNoReindexadoLabelList;
    private java.lang.Integer rango;
    private java.lang.Object[] rangoValueList;
    private java.lang.Object[] rangoLabelList;
    private java.lang.String mesHasta;
    private java.lang.Object[] mesHastaValueList;
    private java.lang.Object[] mesHastaLabelList;
    private java.lang.String pathODEs;
    private java.lang.Object[] pathODEsValueList;
    private java.lang.Object[] pathODEsLabelList;
    private java.lang.String diaDesde;
    private java.lang.Object[] diaDesdeValueList;
    private java.lang.Object[] diaDesdeLabelList;
    private java.lang.String usuarios;
    private java.lang.Object[] usuariosValueList;
    private java.lang.Object[] usuariosLabelList;
    private java.lang.String mesDesde;
    private java.lang.Object[] mesDesdeValueList;
    private java.lang.Object[] mesDesdeLabelList;

    public FormularioInicioCrearTareaFormImpl()
    {
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setAnioHastaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setAnioHastaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setMinutosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setMinutosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setAnioBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setAnioBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>repositorioIndices</code>.
     */
    public void resetRepositorioIndices()
    {
        this.repositorioIndices = null;
    }

    public void setRepositorioIndices(java.lang.String repositorioIndices)
    {
        this.repositorioIndices = repositorioIndices;
    }

    /**
     * 
     */
    public java.lang.String getRepositorioIndices()
    {
        return this.repositorioIndices;
    }
    
    public java.lang.Object[] getRepositorioIndicesBackingList()
    {
        java.lang.Object[] values = this.repositorioIndicesValueList;
        java.lang.Object[] labels = this.repositorioIndicesLabelList;

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

    public java.lang.Object[] getRepositorioIndicesValueList()
    {
        return this.repositorioIndicesValueList;
    }

    public void setRepositorioIndicesValueList(java.lang.Object[] repositorioIndicesValueList)
    {
        this.repositorioIndicesValueList = repositorioIndicesValueList;
    }

    public java.lang.Object[] getRepositorioIndicesLabelList()
    {
        return this.repositorioIndicesLabelList;
    }

    public void setRepositorioIndicesLabelList(java.lang.Object[] repositorioIndicesLabelList)
    {
        this.repositorioIndicesLabelList = repositorioIndicesLabelList;
    }

    public void setRepositorioIndicesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setRepositorioIndicesBackingList requires non-null property arguments");
        }

        this.repositorioIndicesValueList = null;
        this.repositorioIndicesLabelList = null;

        if (items != null)
        {
            this.repositorioIndicesValueList = new java.lang.Object[items.size()];
            this.repositorioIndicesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.repositorioIndicesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.repositorioIndicesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setRepositorioIndicesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setMsgReindexadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setMsgReindexadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setPathODEsNoCargBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setPathODEsNoCargBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setFormatoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setFormatoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setSobrescribirBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setSobrescribirBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setAnioDesdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setAnioDesdeBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setMsgInformeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setMsgInformeBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setMesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setMesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setMsgNoPublicadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setMsgNoPublicadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tareaModificada</code>.
     */
    public void resetTareaModificada()
    {
        this.tareaModificada = null;
    }

    public void setTareaModificada(java.lang.String tareaModificada)
    {
        this.tareaModificada = tareaModificada;
    }

    /**
     * 
     */
    public java.lang.String getTareaModificada()
    {
        return this.tareaModificada;
    }
    
    public java.lang.Object[] getTareaModificadaBackingList()
    {
        java.lang.Object[] values = this.tareaModificadaValueList;
        java.lang.Object[] labels = this.tareaModificadaLabelList;

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

    public java.lang.Object[] getTareaModificadaValueList()
    {
        return this.tareaModificadaValueList;
    }

    public void setTareaModificadaValueList(java.lang.Object[] tareaModificadaValueList)
    {
        this.tareaModificadaValueList = tareaModificadaValueList;
    }

    public java.lang.Object[] getTareaModificadaLabelList()
    {
        return this.tareaModificadaLabelList;
    }

    public void setTareaModificadaLabelList(java.lang.Object[] tareaModificadaLabelList)
    {
        this.tareaModificadaLabelList = tareaModificadaLabelList;
    }

    public void setTareaModificadaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setTareaModificadaBackingList requires non-null property arguments");
        }

        this.tareaModificadaValueList = null;
        this.tareaModificadaLabelList = null;

        if (items != null)
        {
            this.tareaModificadaValueList = new java.lang.Object[items.size()];
            this.tareaModificadaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tareaModificadaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tareaModificadaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setTareaModificadaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setPeriodicidadBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setPeriodicidadBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setPathODEsCargBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setPathODEsCargBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setTriggerBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setTriggerBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setMsgPublicadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setMsgPublicadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setTipoTareaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setTipoTareaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setInformeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setInformeBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setIdiomaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setDiaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setDiaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setMsgNoEliminadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setMsgNoEliminadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setDiaHastaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setDiaHastaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setMsgEliminadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setMsgEliminadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setHoraBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setHoraBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setMsgNoInformeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setMsgNoInformeBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setTrabajoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setTrabajoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setMsgDescTrabajoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setMsgDescTrabajoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setMsgNoReindexadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setMsgNoReindexadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setRangoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setRangoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setMesHastaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setMesHastaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setPathODEsBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setPathODEsBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setDiaDesdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setDiaDesdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>usuarios</code>.
     */
    public void resetUsuarios()
    {
        this.usuarios = null;
    }

    public void setUsuarios(java.lang.String usuarios)
    {
        this.usuarios = usuarios;
    }

    /**
     * 
     */
    public java.lang.String getUsuarios()
    {
        return this.usuarios;
    }
    
    public java.lang.Object[] getUsuariosBackingList()
    {
        java.lang.Object[] values = this.usuariosValueList;
        java.lang.Object[] labels = this.usuariosLabelList;

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

    public java.lang.Object[] getUsuariosValueList()
    {
        return this.usuariosValueList;
    }

    public void setUsuariosValueList(java.lang.Object[] usuariosValueList)
    {
        this.usuariosValueList = usuariosValueList;
    }

    public java.lang.Object[] getUsuariosLabelList()
    {
        return this.usuariosLabelList;
    }

    public void setUsuariosLabelList(java.lang.Object[] usuariosLabelList)
    {
        this.usuariosLabelList = usuariosLabelList;
    }

    public void setUsuariosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setUsuariosBackingList requires non-null property arguments");
        }

        this.usuariosValueList = null;
        this.usuariosLabelList = null;

        if (items != null)
        {
            this.usuariosValueList = new java.lang.Object[items.size()];
            this.usuariosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.usuariosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.usuariosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setUsuariosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioInicioCrearTareaFormImpl.setMesDesdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioInicioCrearTareaFormImpl.setMesDesdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.idioma = null;
        this.usuarios = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("anioHasta", this.anioHasta);
        builder.append("minutos", this.minutos);
        builder.append("anio", this.anio);
        builder.append("repositorioIndices", this.repositorioIndices);
        builder.append("msgReindexado", this.msgReindexado);
        builder.append("pathODEsNoCarg", this.pathODEsNoCarg);
        builder.append("formato", this.formato);
        builder.append("sobrescribir", this.sobrescribir);
        builder.append("anioDesde", this.anioDesde);
        builder.append("msgInforme", this.msgInforme);
        builder.append("mes", this.mes);
        builder.append("msgNoPublicado", this.msgNoPublicado);
        builder.append("tareaModificada", this.tareaModificada);
        builder.append("periodicidad", this.periodicidad);
        builder.append("pathODEsCarg", this.pathODEsCarg);
        builder.append("trigger", this.trigger);
        builder.append("msgPublicado", this.msgPublicado);
        builder.append("tipoTarea", this.tipoTarea);
        builder.append("informe", this.informe);
        builder.append("idioma", this.idioma);
        builder.append("dia", this.dia);
        builder.append("msgNoEliminado", this.msgNoEliminado);
        builder.append("diaHasta", this.diaHasta);
        builder.append("msgEliminado", this.msgEliminado);
        builder.append("hora", this.hora);
        builder.append("msgNoInforme", this.msgNoInforme);
        builder.append("trabajo", this.trabajo);
        builder.append("msgDescTrabajo", this.msgDescTrabajo);
        builder.append("msgNoReindexado", this.msgNoReindexado);
        builder.append("rango", this.rango);
        builder.append("mesHasta", this.mesHasta);
        builder.append("pathODEs", this.pathODEs);
        builder.append("diaDesde", this.diaDesde);
        builder.append("usuarios", this.usuarios);
        builder.append("mesDesde", this.mesDesde);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.anioHasta = null;
        this.anioHastaValueList = null;
        this.anioHastaLabelList = null;
        this.minutos = null;
        this.minutosValueList = null;
        this.minutosLabelList = null;
        this.anio = null;
        this.anioValueList = null;
        this.anioLabelList = null;
        this.repositorioIndices = null;
        this.repositorioIndicesValueList = null;
        this.repositorioIndicesLabelList = null;
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
        this.tareaModificada = null;
        this.tareaModificadaValueList = null;
        this.tareaModificadaLabelList = null;
        this.periodicidad = null;
        this.periodicidadValueList = null;
        this.periodicidadLabelList = null;
        this.pathODEsCarg = null;
        this.pathODEsCargValueList = null;
        this.pathODEsCargLabelList = null;
        this.trigger = null;
        this.triggerValueList = null;
        this.triggerLabelList = null;
        this.msgPublicado = null;
        this.msgPublicadoValueList = null;
        this.msgPublicadoLabelList = null;
        this.tipoTarea = null;
        this.tipoTareaValueList = null;
        this.tipoTareaLabelList = null;
        this.informe = null;
        this.informeValueList = null;
        this.informeLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
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
        this.trabajo = null;
        this.trabajoValueList = null;
        this.trabajoLabelList = null;
        this.msgDescTrabajo = null;
        this.msgDescTrabajoValueList = null;
        this.msgDescTrabajoLabelList = null;
        this.msgNoReindexado = null;
        this.msgNoReindexadoValueList = null;
        this.msgNoReindexadoLabelList = null;
        this.rango = null;
        this.rangoValueList = null;
        this.rangoLabelList = null;
        this.mesHasta = null;
        this.mesHastaValueList = null;
        this.mesHastaLabelList = null;
        this.pathODEs = null;
        this.pathODEsValueList = null;
        this.pathODEsLabelList = null;
        this.diaDesde = null;
        this.diaDesdeValueList = null;
        this.diaDesdeLabelList = null;
        this.usuarios = null;
        this.usuariosValueList = null;
        this.usuariosLabelList = null;
        this.mesDesde = null;
        this.mesDesdeValueList = null;
        this.mesDesdeLabelList = null;
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
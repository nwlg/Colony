// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo;

public class DetalleUsoEducativoSubmitFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.EliminarProcesoCognitivoForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.GuardarUsoEducativoForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.EliminarContenidoDescripcionForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.AnadirIdiomaForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.EliminarIdiomaForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.AnadirProcesoCognitivoForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.ResetForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.CancelarForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.AnadirContextoForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.EliminarRolUsuarioForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.AnadirEdadTipicaForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.EliminarContextoForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.AnadirTipoRecursoForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.AnadirRolUsuarioForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.EliminarTipoRecursoForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.AnadirDescripcionForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.EliminarDescTiempoApForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.AnadirContenidoDescripcionForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.EliminarDescripcionForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.AnadirContenidoEdadTipicaForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.EliminarEdadTipicaForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.AnadirDescTiempoApForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.EliminarContenidoEdadTipicaForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.EliminarDescripcionCatForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.AnadirDescripcionCatForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.HayUsosEducativosForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.EsValidoUsoEduForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.HayUsosEducativosGuardarForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.AccionSubmitForm
{
    private java.lang.String minutos;
    private java.lang.Object[] minutosValueList;
    private java.lang.Object[] minutosLabelList;
    private java.util.Collection descripciones;
    private java.lang.Object[] descripcionesValueList;
    private java.lang.Object[] descripcionesLabelList;
    private java.lang.String segundosP2;
    private java.lang.Object[] segundosP2ValueList;
    private java.lang.Object[] segundosP2LabelList;
    private java.lang.String comboRol;
    private java.lang.Object[] comboRolValueList;
    private java.lang.Object[] comboRolLabelList;
    private java.lang.String comboProceso;
    private java.lang.Object[] comboProcesoValueList;
    private java.lang.Object[] comboProcesoLabelList;
    private java.lang.String segundosP1;
    private java.lang.Object[] segundosP1ValueList;
    private java.lang.Object[] segundosP1LabelList;
    private java.util.Collection descripcionesCat;
    private java.lang.Object[] descripcionesCatValueList;
    private java.lang.Object[] descripcionesCatLabelList;
    private java.lang.String dificultad;
    private java.lang.Object[] dificultadValueList;
    private java.lang.Object[] dificultadLabelList;
    private java.util.Collection tipoRecurso;
    private java.lang.Object[] tipoRecursoValueList;
    private java.lang.Object[] tipoRecursoLabelList;
    private java.util.Collection idiomas;
    private java.lang.Object[] idiomasValueList;
    private java.lang.Object[] idiomasLabelList;
    private java.util.Collection tiempoAprendizaje;
    private java.lang.Object[] tiempoAprendizajeValueList;
    private java.lang.Object[] tiempoAprendizajeLabelList;
    private java.lang.String comboContexto;
    private java.lang.Object[] comboContextoValueList;
    private java.lang.Object[] comboContextoLabelList;
    private java.util.Collection tiempoApDescripcion;
    private java.lang.Object[] tiempoApDescripcionValueList;
    private java.lang.Object[] tiempoApDescripcionLabelList;
    private java.lang.String comboIdioma;
    private java.lang.Object[] comboIdiomaValueList;
    private java.lang.Object[] comboIdiomaLabelList;
    private java.lang.String mes;
    private java.lang.Object[] mesValueList;
    private java.lang.Object[] mesLabelList;
    private java.util.Collection edadTipica;
    private java.lang.Object[] edadTipicaValueList;
    private java.lang.Object[] edadTipicaLabelList;
    private java.util.Collection contexto;
    private java.lang.Object[] contextoValueList;
    private java.lang.Object[] contextoLabelList;
    private java.lang.String tituloUsoEducativo;
    private java.lang.Object[] tituloUsoEducativoValueList;
    private java.lang.Object[] tituloUsoEducativoLabelList;
    private java.lang.String botonPulsado;
    private java.lang.Object[] botonPulsadoValueList;
    private java.lang.Object[] botonPulsadoLabelList;
    private java.util.Collection descripcionTipoConocimiento;
    private java.lang.Object[] descripcionTipoConocimientoValueList;
    private java.lang.Object[] descripcionTipoConocimientoLabelList;
    private java.util.Collection descripcionCat;
    private java.lang.Object[] descripcionCatValueList;
    private java.lang.Object[] descripcionCatLabelList;
    private java.lang.String tipoInteractividad;
    private java.lang.Object[] tipoInteractividadValueList;
    private java.lang.Object[] tipoInteractividadLabelList;
    private java.lang.String dia;
    private java.lang.Object[] diaValueList;
    private java.lang.Object[] diaLabelList;
    private java.lang.String accion;
    private java.lang.Object[] accionValueList;
    private java.lang.Object[] accionLabelList;
    private java.util.Collection procesoCognitivo;
    private java.lang.Object[] procesoCognitivoValueList;
    private java.lang.Object[] procesoCognitivoLabelList;
    private java.lang.String hora;
    private java.lang.Object[] horaValueList;
    private java.lang.Object[] horaLabelList;
    private java.lang.String comboTipoRecurso;
    private java.lang.Object[] comboTipoRecursoValueList;
    private java.lang.Object[] comboTipoRecursoLabelList;
    private java.lang.String nivelInteractividad;
    private java.lang.Object[] nivelInteractividadValueList;
    private java.lang.Object[] nivelInteractividadLabelList;
    private java.util.Collection rolUsuario;
    private java.lang.Object[] rolUsuarioValueList;
    private java.lang.Object[] rolUsuarioLabelList;
    private java.lang.String densidadSemantica;
    private java.lang.Object[] densidadSemanticaValueList;
    private java.lang.Object[] densidadSemanticaLabelList;
    private java.util.Collection tiempoApAprendizaje;
    private java.lang.Object[] tiempoApAprendizajeValueList;
    private java.lang.Object[] tiempoApAprendizajeLabelList;
    private java.lang.String anyo;
    private java.lang.Object[] anyoValueList;
    private java.lang.Object[] anyoLabelList;
    private java.util.Collection mensajesError;
    private java.lang.Object[] mensajesErrorValueList;
    private java.lang.Object[] mensajesErrorLabelList;

    public DetalleUsoEducativoSubmitFormImpl()
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
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setMinutosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setMinutosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripciones</code>.
     */
    public void resetDescripciones()
    {
        this.descripciones = null;
    }

    public void setDescripciones(java.util.Collection descripciones)
    {
        this.descripciones = descripciones;
    }

    /**
     * 
     */
    public java.util.Collection getDescripciones()
    {
        return this.descripciones;
    }

    public void setDescripcionesAsArray(Object[] descripciones)
    {
        this.descripciones = (descripciones == null) ? null : java.util.Arrays.asList(descripciones);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl#getDescripciones
     */
    public java.lang.Object[] getDescripcionesAsArray()
    {
        return (descripciones == null) ? null : descripciones.toArray();
    }
    
    public java.lang.Object[] getDescripcionesBackingList()
    {
        java.lang.Object[] values = this.descripcionesValueList;
        java.lang.Object[] labels = this.descripcionesLabelList;

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

    public java.lang.Object[] getDescripcionesValueList()
    {
        return this.descripcionesValueList;
    }

    public void setDescripcionesValueList(java.lang.Object[] descripcionesValueList)
    {
        this.descripcionesValueList = descripcionesValueList;
    }

    public java.lang.Object[] getDescripcionesLabelList()
    {
        return this.descripcionesLabelList;
    }

    public void setDescripcionesLabelList(java.lang.Object[] descripcionesLabelList)
    {
        this.descripcionesLabelList = descripcionesLabelList;
    }

    public void setDescripcionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setDescripcionesBackingList requires non-null property arguments");
        }

        this.descripcionesValueList = null;
        this.descripcionesLabelList = null;

        if (items != null)
        {
            this.descripcionesValueList = new java.lang.Object[items.size()];
            this.descripcionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setDescripcionesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>segundosP2</code>.
     */
    public void resetSegundosP2()
    {
        this.segundosP2 = null;
    }

    public void setSegundosP2(java.lang.String segundosP2)
    {
        this.segundosP2 = segundosP2;
    }

    /**
     * 
     */
    public java.lang.String getSegundosP2()
    {
        return this.segundosP2;
    }
    
    public java.lang.Object[] getSegundosP2BackingList()
    {
        java.lang.Object[] values = this.segundosP2ValueList;
        java.lang.Object[] labels = this.segundosP2LabelList;

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

    public java.lang.Object[] getSegundosP2ValueList()
    {
        return this.segundosP2ValueList;
    }

    public void setSegundosP2ValueList(java.lang.Object[] segundosP2ValueList)
    {
        this.segundosP2ValueList = segundosP2ValueList;
    }

    public java.lang.Object[] getSegundosP2LabelList()
    {
        return this.segundosP2LabelList;
    }

    public void setSegundosP2LabelList(java.lang.Object[] segundosP2LabelList)
    {
        this.segundosP2LabelList = segundosP2LabelList;
    }

    public void setSegundosP2BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setSegundosP2BackingList requires non-null property arguments");
        }

        this.segundosP2ValueList = null;
        this.segundosP2LabelList = null;

        if (items != null)
        {
            this.segundosP2ValueList = new java.lang.Object[items.size()];
            this.segundosP2LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.segundosP2ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.segundosP2LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setSegundosP2BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboRol</code>.
     */
    public void resetComboRol()
    {
        this.comboRol = null;
    }

    public void setComboRol(java.lang.String comboRol)
    {
        this.comboRol = comboRol;
    }

    /**
     * 
     */
    public java.lang.String getComboRol()
    {
        return this.comboRol;
    }
    
    public java.lang.Object[] getComboRolBackingList()
    {
        java.lang.Object[] values = this.comboRolValueList;
        java.lang.Object[] labels = this.comboRolLabelList;

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

    public java.lang.Object[] getComboRolValueList()
    {
        return this.comboRolValueList;
    }

    public void setComboRolValueList(java.lang.Object[] comboRolValueList)
    {
        this.comboRolValueList = comboRolValueList;
    }

    public java.lang.Object[] getComboRolLabelList()
    {
        return this.comboRolLabelList;
    }

    public void setComboRolLabelList(java.lang.Object[] comboRolLabelList)
    {
        this.comboRolLabelList = comboRolLabelList;
    }

    public void setComboRolBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setComboRolBackingList requires non-null property arguments");
        }

        this.comboRolValueList = null;
        this.comboRolLabelList = null;

        if (items != null)
        {
            this.comboRolValueList = new java.lang.Object[items.size()];
            this.comboRolLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboRolValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboRolLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setComboRolBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboProceso</code>.
     */
    public void resetComboProceso()
    {
        this.comboProceso = null;
    }

    public void setComboProceso(java.lang.String comboProceso)
    {
        this.comboProceso = comboProceso;
    }

    /**
     * 
     */
    public java.lang.String getComboProceso()
    {
        return this.comboProceso;
    }
    
    public java.lang.Object[] getComboProcesoBackingList()
    {
        java.lang.Object[] values = this.comboProcesoValueList;
        java.lang.Object[] labels = this.comboProcesoLabelList;

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

    public java.lang.Object[] getComboProcesoValueList()
    {
        return this.comboProcesoValueList;
    }

    public void setComboProcesoValueList(java.lang.Object[] comboProcesoValueList)
    {
        this.comboProcesoValueList = comboProcesoValueList;
    }

    public java.lang.Object[] getComboProcesoLabelList()
    {
        return this.comboProcesoLabelList;
    }

    public void setComboProcesoLabelList(java.lang.Object[] comboProcesoLabelList)
    {
        this.comboProcesoLabelList = comboProcesoLabelList;
    }

    public void setComboProcesoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setComboProcesoBackingList requires non-null property arguments");
        }

        this.comboProcesoValueList = null;
        this.comboProcesoLabelList = null;

        if (items != null)
        {
            this.comboProcesoValueList = new java.lang.Object[items.size()];
            this.comboProcesoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboProcesoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboProcesoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setComboProcesoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>segundosP1</code>.
     */
    public void resetSegundosP1()
    {
        this.segundosP1 = null;
    }

    public void setSegundosP1(java.lang.String segundosP1)
    {
        this.segundosP1 = segundosP1;
    }

    /**
     * 
     */
    public java.lang.String getSegundosP1()
    {
        return this.segundosP1;
    }
    
    public java.lang.Object[] getSegundosP1BackingList()
    {
        java.lang.Object[] values = this.segundosP1ValueList;
        java.lang.Object[] labels = this.segundosP1LabelList;

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

    public java.lang.Object[] getSegundosP1ValueList()
    {
        return this.segundosP1ValueList;
    }

    public void setSegundosP1ValueList(java.lang.Object[] segundosP1ValueList)
    {
        this.segundosP1ValueList = segundosP1ValueList;
    }

    public java.lang.Object[] getSegundosP1LabelList()
    {
        return this.segundosP1LabelList;
    }

    public void setSegundosP1LabelList(java.lang.Object[] segundosP1LabelList)
    {
        this.segundosP1LabelList = segundosP1LabelList;
    }

    public void setSegundosP1BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setSegundosP1BackingList requires non-null property arguments");
        }

        this.segundosP1ValueList = null;
        this.segundosP1LabelList = null;

        if (items != null)
        {
            this.segundosP1ValueList = new java.lang.Object[items.size()];
            this.segundosP1LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.segundosP1ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.segundosP1LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setSegundosP1BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcionesCat</code>.
     */
    public void resetDescripcionesCat()
    {
        this.descripcionesCat = null;
    }

    public void setDescripcionesCat(java.util.Collection descripcionesCat)
    {
        this.descripcionesCat = descripcionesCat;
    }

    /**
     * 
     */
    public java.util.Collection getDescripcionesCat()
    {
        return this.descripcionesCat;
    }

    public void setDescripcionesCatAsArray(Object[] descripcionesCat)
    {
        this.descripcionesCat = (descripcionesCat == null) ? null : java.util.Arrays.asList(descripcionesCat);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl#getDescripcionesCat
     */
    public java.lang.Object[] getDescripcionesCatAsArray()
    {
        return (descripcionesCat == null) ? null : descripcionesCat.toArray();
    }
    
    public java.lang.Object[] getDescripcionesCatBackingList()
    {
        java.lang.Object[] values = this.descripcionesCatValueList;
        java.lang.Object[] labels = this.descripcionesCatLabelList;

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

    public java.lang.Object[] getDescripcionesCatValueList()
    {
        return this.descripcionesCatValueList;
    }

    public void setDescripcionesCatValueList(java.lang.Object[] descripcionesCatValueList)
    {
        this.descripcionesCatValueList = descripcionesCatValueList;
    }

    public java.lang.Object[] getDescripcionesCatLabelList()
    {
        return this.descripcionesCatLabelList;
    }

    public void setDescripcionesCatLabelList(java.lang.Object[] descripcionesCatLabelList)
    {
        this.descripcionesCatLabelList = descripcionesCatLabelList;
    }

    public void setDescripcionesCatBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setDescripcionesCatBackingList requires non-null property arguments");
        }

        this.descripcionesCatValueList = null;
        this.descripcionesCatLabelList = null;

        if (items != null)
        {
            this.descripcionesCatValueList = new java.lang.Object[items.size()];
            this.descripcionesCatLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionesCatValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionesCatLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setDescripcionesCatBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>dificultad</code>.
     */
    public void resetDificultad()
    {
        this.dificultad = null;
    }

    public void setDificultad(java.lang.String dificultad)
    {
        this.dificultad = dificultad;
    }

    /**
     * 
     */
    public java.lang.String getDificultad()
    {
        return this.dificultad;
    }
    
    public java.lang.Object[] getDificultadBackingList()
    {
        java.lang.Object[] values = this.dificultadValueList;
        java.lang.Object[] labels = this.dificultadLabelList;

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

    public java.lang.Object[] getDificultadValueList()
    {
        return this.dificultadValueList;
    }

    public void setDificultadValueList(java.lang.Object[] dificultadValueList)
    {
        this.dificultadValueList = dificultadValueList;
    }

    public java.lang.Object[] getDificultadLabelList()
    {
        return this.dificultadLabelList;
    }

    public void setDificultadLabelList(java.lang.Object[] dificultadLabelList)
    {
        this.dificultadLabelList = dificultadLabelList;
    }

    public void setDificultadBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setDificultadBackingList requires non-null property arguments");
        }

        this.dificultadValueList = null;
        this.dificultadLabelList = null;

        if (items != null)
        {
            this.dificultadValueList = new java.lang.Object[items.size()];
            this.dificultadLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.dificultadValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.dificultadLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setDificultadBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoRecurso</code>.
     */
    public void resetTipoRecurso()
    {
        this.tipoRecurso = null;
    }

    public void setTipoRecurso(java.util.Collection tipoRecurso)
    {
        this.tipoRecurso = tipoRecurso;
    }

    /**
     * 
     */
    public java.util.Collection getTipoRecurso()
    {
        return this.tipoRecurso;
    }

    public void setTipoRecursoAsArray(Object[] tipoRecurso)
    {
        this.tipoRecurso = (tipoRecurso == null) ? null : java.util.Arrays.asList(tipoRecurso);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl#getTipoRecurso
     */
    public java.lang.Object[] getTipoRecursoAsArray()
    {
        return (tipoRecurso == null) ? null : tipoRecurso.toArray();
    }
    
    public java.lang.Object[] getTipoRecursoBackingList()
    {
        java.lang.Object[] values = this.tipoRecursoValueList;
        java.lang.Object[] labels = this.tipoRecursoLabelList;

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

    public java.lang.Object[] getTipoRecursoValueList()
    {
        return this.tipoRecursoValueList;
    }

    public void setTipoRecursoValueList(java.lang.Object[] tipoRecursoValueList)
    {
        this.tipoRecursoValueList = tipoRecursoValueList;
    }

    public java.lang.Object[] getTipoRecursoLabelList()
    {
        return this.tipoRecursoLabelList;
    }

    public void setTipoRecursoLabelList(java.lang.Object[] tipoRecursoLabelList)
    {
        this.tipoRecursoLabelList = tipoRecursoLabelList;
    }

    public void setTipoRecursoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setTipoRecursoBackingList requires non-null property arguments");
        }

        this.tipoRecursoValueList = null;
        this.tipoRecursoLabelList = null;

        if (items != null)
        {
            this.tipoRecursoValueList = new java.lang.Object[items.size()];
            this.tipoRecursoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoRecursoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoRecursoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setTipoRecursoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomas</code>.
     */
    public void resetIdiomas()
    {
        this.idiomas = null;
    }

    public void setIdiomas(java.util.Collection idiomas)
    {
        this.idiomas = idiomas;
    }

    /**
     * 
     */
    public java.util.Collection getIdiomas()
    {
        return this.idiomas;
    }

    public void setIdiomasAsArray(Object[] idiomas)
    {
        this.idiomas = (idiomas == null) ? null : java.util.Arrays.asList(idiomas);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl#getIdiomas
     */
    public java.lang.Object[] getIdiomasAsArray()
    {
        return (idiomas == null) ? null : idiomas.toArray();
    }
    
    public java.lang.Object[] getIdiomasBackingList()
    {
        java.lang.Object[] values = this.idiomasValueList;
        java.lang.Object[] labels = this.idiomasLabelList;

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

    public java.lang.Object[] getIdiomasValueList()
    {
        return this.idiomasValueList;
    }

    public void setIdiomasValueList(java.lang.Object[] idiomasValueList)
    {
        this.idiomasValueList = idiomasValueList;
    }

    public java.lang.Object[] getIdiomasLabelList()
    {
        return this.idiomasLabelList;
    }

    public void setIdiomasLabelList(java.lang.Object[] idiomasLabelList)
    {
        this.idiomasLabelList = idiomasLabelList;
    }

    public void setIdiomasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setIdiomasBackingList requires non-null property arguments");
        }

        this.idiomasValueList = null;
        this.idiomasLabelList = null;

        if (items != null)
        {
            this.idiomasValueList = new java.lang.Object[items.size()];
            this.idiomasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setIdiomasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tiempoAprendizaje</code>.
     */
    public void resetTiempoAprendizaje()
    {
        this.tiempoAprendizaje = null;
    }

    public void setTiempoAprendizaje(java.util.Collection tiempoAprendizaje)
    {
        this.tiempoAprendizaje = tiempoAprendizaje;
    }

    /**
     * 
     */
    public java.util.Collection getTiempoAprendizaje()
    {
        return this.tiempoAprendizaje;
    }

    public void setTiempoAprendizajeAsArray(Object[] tiempoAprendizaje)
    {
        this.tiempoAprendizaje = (tiempoAprendizaje == null) ? null : java.util.Arrays.asList(tiempoAprendizaje);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl#getTiempoAprendizaje
     */
    public java.lang.Object[] getTiempoAprendizajeAsArray()
    {
        return (tiempoAprendizaje == null) ? null : tiempoAprendizaje.toArray();
    }
    
    public java.lang.Object[] getTiempoAprendizajeBackingList()
    {
        java.lang.Object[] values = this.tiempoAprendizajeValueList;
        java.lang.Object[] labels = this.tiempoAprendizajeLabelList;

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

    public java.lang.Object[] getTiempoAprendizajeValueList()
    {
        return this.tiempoAprendizajeValueList;
    }

    public void setTiempoAprendizajeValueList(java.lang.Object[] tiempoAprendizajeValueList)
    {
        this.tiempoAprendizajeValueList = tiempoAprendizajeValueList;
    }

    public java.lang.Object[] getTiempoAprendizajeLabelList()
    {
        return this.tiempoAprendizajeLabelList;
    }

    public void setTiempoAprendizajeLabelList(java.lang.Object[] tiempoAprendizajeLabelList)
    {
        this.tiempoAprendizajeLabelList = tiempoAprendizajeLabelList;
    }

    public void setTiempoAprendizajeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setTiempoAprendizajeBackingList requires non-null property arguments");
        }

        this.tiempoAprendizajeValueList = null;
        this.tiempoAprendizajeLabelList = null;

        if (items != null)
        {
            this.tiempoAprendizajeValueList = new java.lang.Object[items.size()];
            this.tiempoAprendizajeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tiempoAprendizajeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tiempoAprendizajeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setTiempoAprendizajeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboContexto</code>.
     */
    public void resetComboContexto()
    {
        this.comboContexto = null;
    }

    public void setComboContexto(java.lang.String comboContexto)
    {
        this.comboContexto = comboContexto;
    }

    /**
     * 
     */
    public java.lang.String getComboContexto()
    {
        return this.comboContexto;
    }
    
    public java.lang.Object[] getComboContextoBackingList()
    {
        java.lang.Object[] values = this.comboContextoValueList;
        java.lang.Object[] labels = this.comboContextoLabelList;

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

    public java.lang.Object[] getComboContextoValueList()
    {
        return this.comboContextoValueList;
    }

    public void setComboContextoValueList(java.lang.Object[] comboContextoValueList)
    {
        this.comboContextoValueList = comboContextoValueList;
    }

    public java.lang.Object[] getComboContextoLabelList()
    {
        return this.comboContextoLabelList;
    }

    public void setComboContextoLabelList(java.lang.Object[] comboContextoLabelList)
    {
        this.comboContextoLabelList = comboContextoLabelList;
    }

    public void setComboContextoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setComboContextoBackingList requires non-null property arguments");
        }

        this.comboContextoValueList = null;
        this.comboContextoLabelList = null;

        if (items != null)
        {
            this.comboContextoValueList = new java.lang.Object[items.size()];
            this.comboContextoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboContextoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboContextoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setComboContextoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tiempoApDescripcion</code>.
     */
    public void resetTiempoApDescripcion()
    {
        this.tiempoApDescripcion = null;
    }

    public void setTiempoApDescripcion(java.util.Collection tiempoApDescripcion)
    {
        this.tiempoApDescripcion = tiempoApDescripcion;
    }

    /**
     * 
     */
    public java.util.Collection getTiempoApDescripcion()
    {
        return this.tiempoApDescripcion;
    }

    public void setTiempoApDescripcionAsArray(Object[] tiempoApDescripcion)
    {
        this.tiempoApDescripcion = (tiempoApDescripcion == null) ? null : java.util.Arrays.asList(tiempoApDescripcion);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl#getTiempoApDescripcion
     */
    public java.lang.Object[] getTiempoApDescripcionAsArray()
    {
        return (tiempoApDescripcion == null) ? null : tiempoApDescripcion.toArray();
    }
    
    public java.lang.Object[] getTiempoApDescripcionBackingList()
    {
        java.lang.Object[] values = this.tiempoApDescripcionValueList;
        java.lang.Object[] labels = this.tiempoApDescripcionLabelList;

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

    public java.lang.Object[] getTiempoApDescripcionValueList()
    {
        return this.tiempoApDescripcionValueList;
    }

    public void setTiempoApDescripcionValueList(java.lang.Object[] tiempoApDescripcionValueList)
    {
        this.tiempoApDescripcionValueList = tiempoApDescripcionValueList;
    }

    public java.lang.Object[] getTiempoApDescripcionLabelList()
    {
        return this.tiempoApDescripcionLabelList;
    }

    public void setTiempoApDescripcionLabelList(java.lang.Object[] tiempoApDescripcionLabelList)
    {
        this.tiempoApDescripcionLabelList = tiempoApDescripcionLabelList;
    }

    public void setTiempoApDescripcionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setTiempoApDescripcionBackingList requires non-null property arguments");
        }

        this.tiempoApDescripcionValueList = null;
        this.tiempoApDescripcionLabelList = null;

        if (items != null)
        {
            this.tiempoApDescripcionValueList = new java.lang.Object[items.size()];
            this.tiempoApDescripcionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tiempoApDescripcionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tiempoApDescripcionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setTiempoApDescripcionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboIdioma</code>.
     */
    public void resetComboIdioma()
    {
        this.comboIdioma = null;
    }

    public void setComboIdioma(java.lang.String comboIdioma)
    {
        this.comboIdioma = comboIdioma;
    }

    /**
     * 
     */
    public java.lang.String getComboIdioma()
    {
        return this.comboIdioma;
    }
    
    public java.lang.Object[] getComboIdiomaBackingList()
    {
        java.lang.Object[] values = this.comboIdiomaValueList;
        java.lang.Object[] labels = this.comboIdiomaLabelList;

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

    public java.lang.Object[] getComboIdiomaValueList()
    {
        return this.comboIdiomaValueList;
    }

    public void setComboIdiomaValueList(java.lang.Object[] comboIdiomaValueList)
    {
        this.comboIdiomaValueList = comboIdiomaValueList;
    }

    public java.lang.Object[] getComboIdiomaLabelList()
    {
        return this.comboIdiomaLabelList;
    }

    public void setComboIdiomaLabelList(java.lang.Object[] comboIdiomaLabelList)
    {
        this.comboIdiomaLabelList = comboIdiomaLabelList;
    }

    public void setComboIdiomaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setComboIdiomaBackingList requires non-null property arguments");
        }

        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;

        if (items != null)
        {
            this.comboIdiomaValueList = new java.lang.Object[items.size()];
            this.comboIdiomaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboIdiomaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboIdiomaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setComboIdiomaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setMesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setMesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>edadTipica</code>.
     */
    public void resetEdadTipica()
    {
        this.edadTipica = null;
    }

    public void setEdadTipica(java.util.Collection edadTipica)
    {
        this.edadTipica = edadTipica;
    }

    /**
     * 
     */
    public java.util.Collection getEdadTipica()
    {
        return this.edadTipica;
    }

    public void setEdadTipicaAsArray(Object[] edadTipica)
    {
        this.edadTipica = (edadTipica == null) ? null : java.util.Arrays.asList(edadTipica);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl#getEdadTipica
     */
    public java.lang.Object[] getEdadTipicaAsArray()
    {
        return (edadTipica == null) ? null : edadTipica.toArray();
    }
    
    public java.lang.Object[] getEdadTipicaBackingList()
    {
        java.lang.Object[] values = this.edadTipicaValueList;
        java.lang.Object[] labels = this.edadTipicaLabelList;

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

    public java.lang.Object[] getEdadTipicaValueList()
    {
        return this.edadTipicaValueList;
    }

    public void setEdadTipicaValueList(java.lang.Object[] edadTipicaValueList)
    {
        this.edadTipicaValueList = edadTipicaValueList;
    }

    public java.lang.Object[] getEdadTipicaLabelList()
    {
        return this.edadTipicaLabelList;
    }

    public void setEdadTipicaLabelList(java.lang.Object[] edadTipicaLabelList)
    {
        this.edadTipicaLabelList = edadTipicaLabelList;
    }

    public void setEdadTipicaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setEdadTipicaBackingList requires non-null property arguments");
        }

        this.edadTipicaValueList = null;
        this.edadTipicaLabelList = null;

        if (items != null)
        {
            this.edadTipicaValueList = new java.lang.Object[items.size()];
            this.edadTipicaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.edadTipicaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.edadTipicaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setEdadTipicaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>contexto</code>.
     */
    public void resetContexto()
    {
        this.contexto = null;
    }

    public void setContexto(java.util.Collection contexto)
    {
        this.contexto = contexto;
    }

    /**
     * 
     */
    public java.util.Collection getContexto()
    {
        return this.contexto;
    }

    public void setContextoAsArray(Object[] contexto)
    {
        this.contexto = (contexto == null) ? null : java.util.Arrays.asList(contexto);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl#getContexto
     */
    public java.lang.Object[] getContextoAsArray()
    {
        return (contexto == null) ? null : contexto.toArray();
    }
    
    public java.lang.Object[] getContextoBackingList()
    {
        java.lang.Object[] values = this.contextoValueList;
        java.lang.Object[] labels = this.contextoLabelList;

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

    public java.lang.Object[] getContextoValueList()
    {
        return this.contextoValueList;
    }

    public void setContextoValueList(java.lang.Object[] contextoValueList)
    {
        this.contextoValueList = contextoValueList;
    }

    public java.lang.Object[] getContextoLabelList()
    {
        return this.contextoLabelList;
    }

    public void setContextoLabelList(java.lang.Object[] contextoLabelList)
    {
        this.contextoLabelList = contextoLabelList;
    }

    public void setContextoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setContextoBackingList requires non-null property arguments");
        }

        this.contextoValueList = null;
        this.contextoLabelList = null;

        if (items != null)
        {
            this.contextoValueList = new java.lang.Object[items.size()];
            this.contextoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.contextoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.contextoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setContextoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tituloUsoEducativo</code>.
     */
    public void resetTituloUsoEducativo()
    {
        this.tituloUsoEducativo = null;
    }

    public void setTituloUsoEducativo(java.lang.String tituloUsoEducativo)
    {
        this.tituloUsoEducativo = tituloUsoEducativo;
    }

    /**
     * 
     */
    public java.lang.String getTituloUsoEducativo()
    {
        return this.tituloUsoEducativo;
    }
    
    public java.lang.Object[] getTituloUsoEducativoBackingList()
    {
        java.lang.Object[] values = this.tituloUsoEducativoValueList;
        java.lang.Object[] labels = this.tituloUsoEducativoLabelList;

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

    public java.lang.Object[] getTituloUsoEducativoValueList()
    {
        return this.tituloUsoEducativoValueList;
    }

    public void setTituloUsoEducativoValueList(java.lang.Object[] tituloUsoEducativoValueList)
    {
        this.tituloUsoEducativoValueList = tituloUsoEducativoValueList;
    }

    public java.lang.Object[] getTituloUsoEducativoLabelList()
    {
        return this.tituloUsoEducativoLabelList;
    }

    public void setTituloUsoEducativoLabelList(java.lang.Object[] tituloUsoEducativoLabelList)
    {
        this.tituloUsoEducativoLabelList = tituloUsoEducativoLabelList;
    }

    public void setTituloUsoEducativoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setTituloUsoEducativoBackingList requires non-null property arguments");
        }

        this.tituloUsoEducativoValueList = null;
        this.tituloUsoEducativoLabelList = null;

        if (items != null)
        {
            this.tituloUsoEducativoValueList = new java.lang.Object[items.size()];
            this.tituloUsoEducativoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tituloUsoEducativoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tituloUsoEducativoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setTituloUsoEducativoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>botonPulsado</code>.
     */
    public void resetBotonPulsado()
    {
        this.botonPulsado = null;
    }

    public void setBotonPulsado(java.lang.String botonPulsado)
    {
        this.botonPulsado = botonPulsado;
    }

    /**
     * 
     */
    public java.lang.String getBotonPulsado()
    {
        return this.botonPulsado;
    }
    
    public java.lang.Object[] getBotonPulsadoBackingList()
    {
        java.lang.Object[] values = this.botonPulsadoValueList;
        java.lang.Object[] labels = this.botonPulsadoLabelList;

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

    public java.lang.Object[] getBotonPulsadoValueList()
    {
        return this.botonPulsadoValueList;
    }

    public void setBotonPulsadoValueList(java.lang.Object[] botonPulsadoValueList)
    {
        this.botonPulsadoValueList = botonPulsadoValueList;
    }

    public java.lang.Object[] getBotonPulsadoLabelList()
    {
        return this.botonPulsadoLabelList;
    }

    public void setBotonPulsadoLabelList(java.lang.Object[] botonPulsadoLabelList)
    {
        this.botonPulsadoLabelList = botonPulsadoLabelList;
    }

    public void setBotonPulsadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setBotonPulsadoBackingList requires non-null property arguments");
        }

        this.botonPulsadoValueList = null;
        this.botonPulsadoLabelList = null;

        if (items != null)
        {
            this.botonPulsadoValueList = new java.lang.Object[items.size()];
            this.botonPulsadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.botonPulsadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.botonPulsadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setBotonPulsadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcionTipoConocimiento</code>.
     */
    public void resetDescripcionTipoConocimiento()
    {
        this.descripcionTipoConocimiento = null;
    }

    public void setDescripcionTipoConocimiento(java.util.Collection descripcionTipoConocimiento)
    {
        this.descripcionTipoConocimiento = descripcionTipoConocimiento;
    }

    /**
     * 
     */
    public java.util.Collection getDescripcionTipoConocimiento()
    {
        return this.descripcionTipoConocimiento;
    }

    public void setDescripcionTipoConocimientoAsArray(Object[] descripcionTipoConocimiento)
    {
        this.descripcionTipoConocimiento = (descripcionTipoConocimiento == null) ? null : java.util.Arrays.asList(descripcionTipoConocimiento);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl#getDescripcionTipoConocimiento
     */
    public java.lang.Object[] getDescripcionTipoConocimientoAsArray()
    {
        return (descripcionTipoConocimiento == null) ? null : descripcionTipoConocimiento.toArray();
    }
    
    public java.lang.Object[] getDescripcionTipoConocimientoBackingList()
    {
        java.lang.Object[] values = this.descripcionTipoConocimientoValueList;
        java.lang.Object[] labels = this.descripcionTipoConocimientoLabelList;

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

    public java.lang.Object[] getDescripcionTipoConocimientoValueList()
    {
        return this.descripcionTipoConocimientoValueList;
    }

    public void setDescripcionTipoConocimientoValueList(java.lang.Object[] descripcionTipoConocimientoValueList)
    {
        this.descripcionTipoConocimientoValueList = descripcionTipoConocimientoValueList;
    }

    public java.lang.Object[] getDescripcionTipoConocimientoLabelList()
    {
        return this.descripcionTipoConocimientoLabelList;
    }

    public void setDescripcionTipoConocimientoLabelList(java.lang.Object[] descripcionTipoConocimientoLabelList)
    {
        this.descripcionTipoConocimientoLabelList = descripcionTipoConocimientoLabelList;
    }

    public void setDescripcionTipoConocimientoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setDescripcionTipoConocimientoBackingList requires non-null property arguments");
        }

        this.descripcionTipoConocimientoValueList = null;
        this.descripcionTipoConocimientoLabelList = null;

        if (items != null)
        {
            this.descripcionTipoConocimientoValueList = new java.lang.Object[items.size()];
            this.descripcionTipoConocimientoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionTipoConocimientoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionTipoConocimientoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setDescripcionTipoConocimientoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcionCat</code>.
     */
    public void resetDescripcionCat()
    {
        this.descripcionCat = null;
    }

    public void setDescripcionCat(java.util.Collection descripcionCat)
    {
        this.descripcionCat = descripcionCat;
    }

    /**
     * 
     */
    public java.util.Collection getDescripcionCat()
    {
        return this.descripcionCat;
    }

    public void setDescripcionCatAsArray(Object[] descripcionCat)
    {
        this.descripcionCat = (descripcionCat == null) ? null : java.util.Arrays.asList(descripcionCat);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl#getDescripcionCat
     */
    public java.lang.Object[] getDescripcionCatAsArray()
    {
        return (descripcionCat == null) ? null : descripcionCat.toArray();
    }
    
    public java.lang.Object[] getDescripcionCatBackingList()
    {
        java.lang.Object[] values = this.descripcionCatValueList;
        java.lang.Object[] labels = this.descripcionCatLabelList;

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

    public java.lang.Object[] getDescripcionCatValueList()
    {
        return this.descripcionCatValueList;
    }

    public void setDescripcionCatValueList(java.lang.Object[] descripcionCatValueList)
    {
        this.descripcionCatValueList = descripcionCatValueList;
    }

    public java.lang.Object[] getDescripcionCatLabelList()
    {
        return this.descripcionCatLabelList;
    }

    public void setDescripcionCatLabelList(java.lang.Object[] descripcionCatLabelList)
    {
        this.descripcionCatLabelList = descripcionCatLabelList;
    }

    public void setDescripcionCatBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setDescripcionCatBackingList requires non-null property arguments");
        }

        this.descripcionCatValueList = null;
        this.descripcionCatLabelList = null;

        if (items != null)
        {
            this.descripcionCatValueList = new java.lang.Object[items.size()];
            this.descripcionCatLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionCatValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionCatLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setDescripcionCatBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoInteractividad</code>.
     */
    public void resetTipoInteractividad()
    {
        this.tipoInteractividad = null;
    }

    public void setTipoInteractividad(java.lang.String tipoInteractividad)
    {
        this.tipoInteractividad = tipoInteractividad;
    }

    /**
     * 
     */
    public java.lang.String getTipoInteractividad()
    {
        return this.tipoInteractividad;
    }
    
    public java.lang.Object[] getTipoInteractividadBackingList()
    {
        java.lang.Object[] values = this.tipoInteractividadValueList;
        java.lang.Object[] labels = this.tipoInteractividadLabelList;

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

    public java.lang.Object[] getTipoInteractividadValueList()
    {
        return this.tipoInteractividadValueList;
    }

    public void setTipoInteractividadValueList(java.lang.Object[] tipoInteractividadValueList)
    {
        this.tipoInteractividadValueList = tipoInteractividadValueList;
    }

    public java.lang.Object[] getTipoInteractividadLabelList()
    {
        return this.tipoInteractividadLabelList;
    }

    public void setTipoInteractividadLabelList(java.lang.Object[] tipoInteractividadLabelList)
    {
        this.tipoInteractividadLabelList = tipoInteractividadLabelList;
    }

    public void setTipoInteractividadBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setTipoInteractividadBackingList requires non-null property arguments");
        }

        this.tipoInteractividadValueList = null;
        this.tipoInteractividadLabelList = null;

        if (items != null)
        {
            this.tipoInteractividadValueList = new java.lang.Object[items.size()];
            this.tipoInteractividadLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoInteractividadValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoInteractividadLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setTipoInteractividadBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setDiaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setDiaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>accion</code>.
     */
    public void resetAccion()
    {
        this.accion = null;
    }

    public void setAccion(java.lang.String accion)
    {
        this.accion = accion;
    }

    /**
     * 
     */
    public java.lang.String getAccion()
    {
        return this.accion;
    }
    
    public java.lang.Object[] getAccionBackingList()
    {
        java.lang.Object[] values = this.accionValueList;
        java.lang.Object[] labels = this.accionLabelList;

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

    public java.lang.Object[] getAccionValueList()
    {
        return this.accionValueList;
    }

    public void setAccionValueList(java.lang.Object[] accionValueList)
    {
        this.accionValueList = accionValueList;
    }

    public java.lang.Object[] getAccionLabelList()
    {
        return this.accionLabelList;
    }

    public void setAccionLabelList(java.lang.Object[] accionLabelList)
    {
        this.accionLabelList = accionLabelList;
    }

    public void setAccionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setAccionBackingList requires non-null property arguments");
        }

        this.accionValueList = null;
        this.accionLabelList = null;

        if (items != null)
        {
            this.accionValueList = new java.lang.Object[items.size()];
            this.accionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.accionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.accionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setAccionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>procesoCognitivo</code>.
     */
    public void resetProcesoCognitivo()
    {
        this.procesoCognitivo = null;
    }

    public void setProcesoCognitivo(java.util.Collection procesoCognitivo)
    {
        this.procesoCognitivo = procesoCognitivo;
    }

    /**
     * 
     */
    public java.util.Collection getProcesoCognitivo()
    {
        return this.procesoCognitivo;
    }

    public void setProcesoCognitivoAsArray(Object[] procesoCognitivo)
    {
        this.procesoCognitivo = (procesoCognitivo == null) ? null : java.util.Arrays.asList(procesoCognitivo);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl#getProcesoCognitivo
     */
    public java.lang.Object[] getProcesoCognitivoAsArray()
    {
        return (procesoCognitivo == null) ? null : procesoCognitivo.toArray();
    }
    
    public java.lang.Object[] getProcesoCognitivoBackingList()
    {
        java.lang.Object[] values = this.procesoCognitivoValueList;
        java.lang.Object[] labels = this.procesoCognitivoLabelList;

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

    public java.lang.Object[] getProcesoCognitivoValueList()
    {
        return this.procesoCognitivoValueList;
    }

    public void setProcesoCognitivoValueList(java.lang.Object[] procesoCognitivoValueList)
    {
        this.procesoCognitivoValueList = procesoCognitivoValueList;
    }

    public java.lang.Object[] getProcesoCognitivoLabelList()
    {
        return this.procesoCognitivoLabelList;
    }

    public void setProcesoCognitivoLabelList(java.lang.Object[] procesoCognitivoLabelList)
    {
        this.procesoCognitivoLabelList = procesoCognitivoLabelList;
    }

    public void setProcesoCognitivoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setProcesoCognitivoBackingList requires non-null property arguments");
        }

        this.procesoCognitivoValueList = null;
        this.procesoCognitivoLabelList = null;

        if (items != null)
        {
            this.procesoCognitivoValueList = new java.lang.Object[items.size()];
            this.procesoCognitivoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.procesoCognitivoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.procesoCognitivoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setProcesoCognitivoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setHoraBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setHoraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboTipoRecurso</code>.
     */
    public void resetComboTipoRecurso()
    {
        this.comboTipoRecurso = null;
    }

    public void setComboTipoRecurso(java.lang.String comboTipoRecurso)
    {
        this.comboTipoRecurso = comboTipoRecurso;
    }

    /**
     * 
     */
    public java.lang.String getComboTipoRecurso()
    {
        return this.comboTipoRecurso;
    }
    
    public java.lang.Object[] getComboTipoRecursoBackingList()
    {
        java.lang.Object[] values = this.comboTipoRecursoValueList;
        java.lang.Object[] labels = this.comboTipoRecursoLabelList;

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

    public java.lang.Object[] getComboTipoRecursoValueList()
    {
        return this.comboTipoRecursoValueList;
    }

    public void setComboTipoRecursoValueList(java.lang.Object[] comboTipoRecursoValueList)
    {
        this.comboTipoRecursoValueList = comboTipoRecursoValueList;
    }

    public java.lang.Object[] getComboTipoRecursoLabelList()
    {
        return this.comboTipoRecursoLabelList;
    }

    public void setComboTipoRecursoLabelList(java.lang.Object[] comboTipoRecursoLabelList)
    {
        this.comboTipoRecursoLabelList = comboTipoRecursoLabelList;
    }

    public void setComboTipoRecursoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setComboTipoRecursoBackingList requires non-null property arguments");
        }

        this.comboTipoRecursoValueList = null;
        this.comboTipoRecursoLabelList = null;

        if (items != null)
        {
            this.comboTipoRecursoValueList = new java.lang.Object[items.size()];
            this.comboTipoRecursoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboTipoRecursoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboTipoRecursoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setComboTipoRecursoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nivelInteractividad</code>.
     */
    public void resetNivelInteractividad()
    {
        this.nivelInteractividad = null;
    }

    public void setNivelInteractividad(java.lang.String nivelInteractividad)
    {
        this.nivelInteractividad = nivelInteractividad;
    }

    /**
     * 
     */
    public java.lang.String getNivelInteractividad()
    {
        return this.nivelInteractividad;
    }
    
    public java.lang.Object[] getNivelInteractividadBackingList()
    {
        java.lang.Object[] values = this.nivelInteractividadValueList;
        java.lang.Object[] labels = this.nivelInteractividadLabelList;

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

    public java.lang.Object[] getNivelInteractividadValueList()
    {
        return this.nivelInteractividadValueList;
    }

    public void setNivelInteractividadValueList(java.lang.Object[] nivelInteractividadValueList)
    {
        this.nivelInteractividadValueList = nivelInteractividadValueList;
    }

    public java.lang.Object[] getNivelInteractividadLabelList()
    {
        return this.nivelInteractividadLabelList;
    }

    public void setNivelInteractividadLabelList(java.lang.Object[] nivelInteractividadLabelList)
    {
        this.nivelInteractividadLabelList = nivelInteractividadLabelList;
    }

    public void setNivelInteractividadBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setNivelInteractividadBackingList requires non-null property arguments");
        }

        this.nivelInteractividadValueList = null;
        this.nivelInteractividadLabelList = null;

        if (items != null)
        {
            this.nivelInteractividadValueList = new java.lang.Object[items.size()];
            this.nivelInteractividadLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nivelInteractividadValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nivelInteractividadLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setNivelInteractividadBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>rolUsuario</code>.
     */
    public void resetRolUsuario()
    {
        this.rolUsuario = null;
    }

    public void setRolUsuario(java.util.Collection rolUsuario)
    {
        this.rolUsuario = rolUsuario;
    }

    /**
     * 
     */
    public java.util.Collection getRolUsuario()
    {
        return this.rolUsuario;
    }

    public void setRolUsuarioAsArray(Object[] rolUsuario)
    {
        this.rolUsuario = (rolUsuario == null) ? null : java.util.Arrays.asList(rolUsuario);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl#getRolUsuario
     */
    public java.lang.Object[] getRolUsuarioAsArray()
    {
        return (rolUsuario == null) ? null : rolUsuario.toArray();
    }
    
    public java.lang.Object[] getRolUsuarioBackingList()
    {
        java.lang.Object[] values = this.rolUsuarioValueList;
        java.lang.Object[] labels = this.rolUsuarioLabelList;

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

    public java.lang.Object[] getRolUsuarioValueList()
    {
        return this.rolUsuarioValueList;
    }

    public void setRolUsuarioValueList(java.lang.Object[] rolUsuarioValueList)
    {
        this.rolUsuarioValueList = rolUsuarioValueList;
    }

    public java.lang.Object[] getRolUsuarioLabelList()
    {
        return this.rolUsuarioLabelList;
    }

    public void setRolUsuarioLabelList(java.lang.Object[] rolUsuarioLabelList)
    {
        this.rolUsuarioLabelList = rolUsuarioLabelList;
    }

    public void setRolUsuarioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setRolUsuarioBackingList requires non-null property arguments");
        }

        this.rolUsuarioValueList = null;
        this.rolUsuarioLabelList = null;

        if (items != null)
        {
            this.rolUsuarioValueList = new java.lang.Object[items.size()];
            this.rolUsuarioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.rolUsuarioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.rolUsuarioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setRolUsuarioBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>densidadSemantica</code>.
     */
    public void resetDensidadSemantica()
    {
        this.densidadSemantica = null;
    }

    public void setDensidadSemantica(java.lang.String densidadSemantica)
    {
        this.densidadSemantica = densidadSemantica;
    }

    /**
     * 
     */
    public java.lang.String getDensidadSemantica()
    {
        return this.densidadSemantica;
    }
    
    public java.lang.Object[] getDensidadSemanticaBackingList()
    {
        java.lang.Object[] values = this.densidadSemanticaValueList;
        java.lang.Object[] labels = this.densidadSemanticaLabelList;

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

    public java.lang.Object[] getDensidadSemanticaValueList()
    {
        return this.densidadSemanticaValueList;
    }

    public void setDensidadSemanticaValueList(java.lang.Object[] densidadSemanticaValueList)
    {
        this.densidadSemanticaValueList = densidadSemanticaValueList;
    }

    public java.lang.Object[] getDensidadSemanticaLabelList()
    {
        return this.densidadSemanticaLabelList;
    }

    public void setDensidadSemanticaLabelList(java.lang.Object[] densidadSemanticaLabelList)
    {
        this.densidadSemanticaLabelList = densidadSemanticaLabelList;
    }

    public void setDensidadSemanticaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setDensidadSemanticaBackingList requires non-null property arguments");
        }

        this.densidadSemanticaValueList = null;
        this.densidadSemanticaLabelList = null;

        if (items != null)
        {
            this.densidadSemanticaValueList = new java.lang.Object[items.size()];
            this.densidadSemanticaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.densidadSemanticaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.densidadSemanticaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setDensidadSemanticaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tiempoApAprendizaje</code>.
     */
    public void resetTiempoApAprendizaje()
    {
        this.tiempoApAprendizaje = null;
    }

    public void setTiempoApAprendizaje(java.util.Collection tiempoApAprendizaje)
    {
        this.tiempoApAprendizaje = tiempoApAprendizaje;
    }

    /**
     * 
     */
    public java.util.Collection getTiempoApAprendizaje()
    {
        return this.tiempoApAprendizaje;
    }

    public void setTiempoApAprendizajeAsArray(Object[] tiempoApAprendizaje)
    {
        this.tiempoApAprendizaje = (tiempoApAprendizaje == null) ? null : java.util.Arrays.asList(tiempoApAprendizaje);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl#getTiempoApAprendizaje
     */
    public java.lang.Object[] getTiempoApAprendizajeAsArray()
    {
        return (tiempoApAprendizaje == null) ? null : tiempoApAprendizaje.toArray();
    }
    
    public java.lang.Object[] getTiempoApAprendizajeBackingList()
    {
        java.lang.Object[] values = this.tiempoApAprendizajeValueList;
        java.lang.Object[] labels = this.tiempoApAprendizajeLabelList;

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

    public java.lang.Object[] getTiempoApAprendizajeValueList()
    {
        return this.tiempoApAprendizajeValueList;
    }

    public void setTiempoApAprendizajeValueList(java.lang.Object[] tiempoApAprendizajeValueList)
    {
        this.tiempoApAprendizajeValueList = tiempoApAprendizajeValueList;
    }

    public java.lang.Object[] getTiempoApAprendizajeLabelList()
    {
        return this.tiempoApAprendizajeLabelList;
    }

    public void setTiempoApAprendizajeLabelList(java.lang.Object[] tiempoApAprendizajeLabelList)
    {
        this.tiempoApAprendizajeLabelList = tiempoApAprendizajeLabelList;
    }

    public void setTiempoApAprendizajeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setTiempoApAprendizajeBackingList requires non-null property arguments");
        }

        this.tiempoApAprendizajeValueList = null;
        this.tiempoApAprendizajeLabelList = null;

        if (items != null)
        {
            this.tiempoApAprendizajeValueList = new java.lang.Object[items.size()];
            this.tiempoApAprendizajeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tiempoApAprendizajeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tiempoApAprendizajeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setTiempoApAprendizajeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>anyo</code>.
     */
    public void resetAnyo()
    {
        this.anyo = null;
    }

    public void setAnyo(java.lang.String anyo)
    {
        this.anyo = anyo;
    }

    /**
     * 
     */
    public java.lang.String getAnyo()
    {
        return this.anyo;
    }
    
    public java.lang.Object[] getAnyoBackingList()
    {
        java.lang.Object[] values = this.anyoValueList;
        java.lang.Object[] labels = this.anyoLabelList;

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

    public java.lang.Object[] getAnyoValueList()
    {
        return this.anyoValueList;
    }

    public void setAnyoValueList(java.lang.Object[] anyoValueList)
    {
        this.anyoValueList = anyoValueList;
    }

    public java.lang.Object[] getAnyoLabelList()
    {
        return this.anyoLabelList;
    }

    public void setAnyoLabelList(java.lang.Object[] anyoLabelList)
    {
        this.anyoLabelList = anyoLabelList;
    }

    public void setAnyoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setAnyoBackingList requires non-null property arguments");
        }

        this.anyoValueList = null;
        this.anyoLabelList = null;

        if (items != null)
        {
            this.anyoValueList = new java.lang.Object[items.size()];
            this.anyoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.anyoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.anyoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setAnyoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>mensajesError</code>.
     */
    public void resetMensajesError()
    {
        this.mensajesError = null;
    }

    public void setMensajesError(java.util.Collection mensajesError)
    {
        this.mensajesError = mensajesError;
    }

    /**
     * 
     */
    public java.util.Collection getMensajesError()
    {
        return this.mensajesError;
    }

    public void setMensajesErrorAsArray(Object[] mensajesError)
    {
        this.mensajesError = (mensajesError == null) ? null : java.util.Arrays.asList(mensajesError);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.detalleUsoEducativo.DetalleUsoEducativoSubmitFormImpl#getMensajesError
     */
    public java.lang.Object[] getMensajesErrorAsArray()
    {
        return (mensajesError == null) ? null : mensajesError.toArray();
    }
    
    public java.lang.Object[] getMensajesErrorBackingList()
    {
        java.lang.Object[] values = this.mensajesErrorValueList;
        java.lang.Object[] labels = this.mensajesErrorLabelList;

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

    public java.lang.Object[] getMensajesErrorValueList()
    {
        return this.mensajesErrorValueList;
    }

    public void setMensajesErrorValueList(java.lang.Object[] mensajesErrorValueList)
    {
        this.mensajesErrorValueList = mensajesErrorValueList;
    }

    public java.lang.Object[] getMensajesErrorLabelList()
    {
        return this.mensajesErrorLabelList;
    }

    public void setMensajesErrorLabelList(java.lang.Object[] mensajesErrorLabelList)
    {
        this.mensajesErrorLabelList = mensajesErrorLabelList;
    }

    public void setMensajesErrorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoSubmitFormImpl.setMensajesErrorBackingList requires non-null property arguments");
        }

        this.mensajesErrorValueList = null;
        this.mensajesErrorLabelList = null;

        if (items != null)
        {
            this.mensajesErrorValueList = new java.lang.Object[items.size()];
            this.mensajesErrorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mensajesErrorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mensajesErrorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoSubmitFormImpl.setMensajesErrorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.descripciones = null;
        this.descripcionesValueList = new java.lang.Object[0];
        this.descripcionesLabelList = new java.lang.Object[0];
        this.comboRol = null;
        this.comboProceso = null;
        this.dificultad = null;
        this.tipoRecurso = null;
        this.tipoRecursoValueList = new java.lang.Object[0];
        this.tipoRecursoLabelList = new java.lang.Object[0];
        this.idiomas = null;
        this.idiomasValueList = new java.lang.Object[0];
        this.idiomasLabelList = new java.lang.Object[0];
        this.tiempoAprendizaje = null;
        this.tiempoAprendizajeValueList = new java.lang.Object[0];
        this.tiempoAprendizajeLabelList = new java.lang.Object[0];
        this.comboContexto = null;
        this.tiempoApDescripcion = null;
        this.tiempoApDescripcionValueList = new java.lang.Object[0];
        this.tiempoApDescripcionLabelList = new java.lang.Object[0];
        this.comboIdioma = null;
        this.edadTipica = null;
        this.edadTipicaValueList = new java.lang.Object[0];
        this.edadTipicaLabelList = new java.lang.Object[0];
        this.contexto = null;
        this.contextoValueList = new java.lang.Object[0];
        this.contextoLabelList = new java.lang.Object[0];
        this.descripcionTipoConocimiento = null;
        this.descripcionTipoConocimientoValueList = new java.lang.Object[0];
        this.descripcionTipoConocimientoLabelList = new java.lang.Object[0];
        this.descripcionCat = null;
        this.descripcionCatValueList = new java.lang.Object[0];
        this.descripcionCatLabelList = new java.lang.Object[0];
        this.tipoInteractividad = null;
        this.procesoCognitivo = null;
        this.procesoCognitivoValueList = new java.lang.Object[0];
        this.procesoCognitivoLabelList = new java.lang.Object[0];
        this.comboTipoRecurso = null;
        this.nivelInteractividad = null;
        this.rolUsuario = null;
        this.rolUsuarioValueList = new java.lang.Object[0];
        this.rolUsuarioLabelList = new java.lang.Object[0];
        this.densidadSemantica = null;
        this.tiempoApAprendizaje = null;
        this.tiempoApAprendizajeValueList = new java.lang.Object[0];
        this.tiempoApAprendizajeLabelList = new java.lang.Object[0];
        this.mensajesError = null;
        this.mensajesErrorValueList = new java.lang.Object[0];
        this.mensajesErrorLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("minutos", this.minutos);
        builder.append("descripciones", this.descripciones);
        builder.append("segundosP2", this.segundosP2);
        builder.append("comboRol", this.comboRol);
        builder.append("comboProceso", this.comboProceso);
        builder.append("segundosP1", this.segundosP1);
        builder.append("descripcionesCat", this.descripcionesCat);
        builder.append("dificultad", this.dificultad);
        builder.append("tipoRecurso", this.tipoRecurso);
        builder.append("idiomas", this.idiomas);
        builder.append("tiempoAprendizaje", this.tiempoAprendizaje);
        builder.append("comboContexto", this.comboContexto);
        builder.append("tiempoApDescripcion", this.tiempoApDescripcion);
        builder.append("comboIdioma", this.comboIdioma);
        builder.append("mes", this.mes);
        builder.append("edadTipica", this.edadTipica);
        builder.append("contexto", this.contexto);
        builder.append("tituloUsoEducativo", this.tituloUsoEducativo);
        builder.append("botonPulsado", this.botonPulsado);
        builder.append("descripcionTipoConocimiento", this.descripcionTipoConocimiento);
        builder.append("descripcionCat", this.descripcionCat);
        builder.append("tipoInteractividad", this.tipoInteractividad);
        builder.append("dia", this.dia);
        builder.append("accion", this.accion);
        builder.append("procesoCognitivo", this.procesoCognitivo);
        builder.append("hora", this.hora);
        builder.append("comboTipoRecurso", this.comboTipoRecurso);
        builder.append("nivelInteractividad", this.nivelInteractividad);
        builder.append("rolUsuario", this.rolUsuario);
        builder.append("densidadSemantica", this.densidadSemantica);
        builder.append("tiempoApAprendizaje", this.tiempoApAprendizaje);
        builder.append("anyo", this.anyo);
        builder.append("mensajesError", this.mensajesError);
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
        this.descripciones = null;
        this.descripcionesValueList = null;
        this.descripcionesLabelList = null;
        this.segundosP2 = null;
        this.segundosP2ValueList = null;
        this.segundosP2LabelList = null;
        this.comboRol = null;
        this.comboRolValueList = null;
        this.comboRolLabelList = null;
        this.comboProceso = null;
        this.comboProcesoValueList = null;
        this.comboProcesoLabelList = null;
        this.segundosP1 = null;
        this.segundosP1ValueList = null;
        this.segundosP1LabelList = null;
        this.descripcionesCat = null;
        this.descripcionesCatValueList = null;
        this.descripcionesCatLabelList = null;
        this.dificultad = null;
        this.dificultadValueList = null;
        this.dificultadLabelList = null;
        this.tipoRecurso = null;
        this.tipoRecursoValueList = null;
        this.tipoRecursoLabelList = null;
        this.idiomas = null;
        this.idiomasValueList = null;
        this.idiomasLabelList = null;
        this.tiempoAprendizaje = null;
        this.tiempoAprendizajeValueList = null;
        this.tiempoAprendizajeLabelList = null;
        this.comboContexto = null;
        this.comboContextoValueList = null;
        this.comboContextoLabelList = null;
        this.tiempoApDescripcion = null;
        this.tiempoApDescripcionValueList = null;
        this.tiempoApDescripcionLabelList = null;
        this.comboIdioma = null;
        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;
        this.mes = null;
        this.mesValueList = null;
        this.mesLabelList = null;
        this.edadTipica = null;
        this.edadTipicaValueList = null;
        this.edadTipicaLabelList = null;
        this.contexto = null;
        this.contextoValueList = null;
        this.contextoLabelList = null;
        this.tituloUsoEducativo = null;
        this.tituloUsoEducativoValueList = null;
        this.tituloUsoEducativoLabelList = null;
        this.botonPulsado = null;
        this.botonPulsadoValueList = null;
        this.botonPulsadoLabelList = null;
        this.descripcionTipoConocimiento = null;
        this.descripcionTipoConocimientoValueList = null;
        this.descripcionTipoConocimientoLabelList = null;
        this.descripcionCat = null;
        this.descripcionCatValueList = null;
        this.descripcionCatLabelList = null;
        this.tipoInteractividad = null;
        this.tipoInteractividadValueList = null;
        this.tipoInteractividadLabelList = null;
        this.dia = null;
        this.diaValueList = null;
        this.diaLabelList = null;
        this.accion = null;
        this.accionValueList = null;
        this.accionLabelList = null;
        this.procesoCognitivo = null;
        this.procesoCognitivoValueList = null;
        this.procesoCognitivoLabelList = null;
        this.hora = null;
        this.horaValueList = null;
        this.horaLabelList = null;
        this.comboTipoRecurso = null;
        this.comboTipoRecursoValueList = null;
        this.comboTipoRecursoLabelList = null;
        this.nivelInteractividad = null;
        this.nivelInteractividadValueList = null;
        this.nivelInteractividadLabelList = null;
        this.rolUsuario = null;
        this.rolUsuarioValueList = null;
        this.rolUsuarioLabelList = null;
        this.densidadSemantica = null;
        this.densidadSemanticaValueList = null;
        this.densidadSemanticaLabelList = null;
        this.tiempoApAprendizaje = null;
        this.tiempoApAprendizajeValueList = null;
        this.tiempoApAprendizajeLabelList = null;
        this.anyo = null;
        this.anyoValueList = null;
        this.anyoLabelList = null;
        this.mensajesError = null;
        this.mensajesErrorValueList = null;
        this.mensajesErrorLabelList = null;
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
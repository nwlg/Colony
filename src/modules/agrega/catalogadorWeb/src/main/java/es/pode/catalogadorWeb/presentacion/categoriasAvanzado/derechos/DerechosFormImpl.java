// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos;

public class DerechosFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.CargarDatosForm
{
    private java.util.Collection descripciones;
    private java.lang.Object[] descripcionesValueList;
    private java.lang.Object[] descripcionesLabelList;
    private java.lang.String copyRestricciones;
    private java.lang.Object[] copyRestriccionesValueList;
    private java.lang.Object[] copyRestriccionesLabelList;
    private java.lang.String accion;
    private java.lang.Object[] accionValueList;
    private java.lang.Object[] accionLabelList;
    private java.lang.String[] listadoComunidades;
    private java.lang.Object[] listadoComunidadesValueList;
    private java.lang.Object[] listadoComunidadesLabelList;
    private java.lang.String idEliminado;
    private java.lang.Object[] idEliminadoValueList;
    private java.lang.Object[] idEliminadoLabelList;
    private java.util.List listadoNodos;
    private java.lang.Object[] listadoNodosValueList;
    private java.lang.Object[] listadoNodosLabelList;
    private java.lang.String tipoAcceso;
    private java.lang.Object[] tipoAccesoValueList;
    private java.lang.Object[] tipoAccesoLabelList;
    private java.lang.String identificador;
    private java.lang.Object[] identificadorValueList;
    private java.lang.Object[] identificadorLabelList;
    private java.lang.String comboIdioma;
    private java.lang.Object[] comboIdiomaValueList;
    private java.lang.Object[] comboIdiomaLabelList;
    private java.lang.String coste;
    private java.lang.Object[] costeValueList;
    private java.lang.Object[] costeLabelList;
    private java.util.Collection datos;
    private java.lang.Object[] datosValueList;
    private java.lang.Object[] datosLabelList;
    private java.util.Collection mensajesError;
    private java.lang.Object[] mensajesErrorValueList;
    private java.lang.Object[] mensajesErrorLabelList;
    private java.lang.String returnURL;
    private java.lang.Object[] returnURLValueList;
    private java.lang.Object[] returnURLLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;
    private java.lang.String coypRestricciones;
    private java.lang.Object[] coypRestriccionesValueList;
    private java.lang.Object[] coypRestriccionesLabelList;

    public DerechosFormImpl()
    {
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosFormImpl#getDescripciones
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
            throw new IllegalArgumentException("DerechosFormImpl.setDescripcionesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DerechosFormImpl.setDescripcionesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>copyRestricciones</code>.
     */
    public void resetCopyRestricciones()
    {
        this.copyRestricciones = null;
    }

    public void setCopyRestricciones(java.lang.String copyRestricciones)
    {
        this.copyRestricciones = copyRestricciones;
    }

    /**
     * 
     */
    public java.lang.String getCopyRestricciones()
    {
        return this.copyRestricciones;
    }
    
    public java.lang.Object[] getCopyRestriccionesBackingList()
    {
        java.lang.Object[] values = this.copyRestriccionesValueList;
        java.lang.Object[] labels = this.copyRestriccionesLabelList;

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

    public java.lang.Object[] getCopyRestriccionesValueList()
    {
        return this.copyRestriccionesValueList;
    }

    public void setCopyRestriccionesValueList(java.lang.Object[] copyRestriccionesValueList)
    {
        this.copyRestriccionesValueList = copyRestriccionesValueList;
    }

    public java.lang.Object[] getCopyRestriccionesLabelList()
    {
        return this.copyRestriccionesLabelList;
    }

    public void setCopyRestriccionesLabelList(java.lang.Object[] copyRestriccionesLabelList)
    {
        this.copyRestriccionesLabelList = copyRestriccionesLabelList;
    }

    public void setCopyRestriccionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DerechosFormImpl.setCopyRestriccionesBackingList requires non-null property arguments");
        }

        this.copyRestriccionesValueList = null;
        this.copyRestriccionesLabelList = null;

        if (items != null)
        {
            this.copyRestriccionesValueList = new java.lang.Object[items.size()];
            this.copyRestriccionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.copyRestriccionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.copyRestriccionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DerechosFormImpl.setCopyRestriccionesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DerechosFormImpl.setAccionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DerechosFormImpl.setAccionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listadoComunidades</code>.
     */
    public void resetListadoComunidades()
    {
        this.listadoComunidades = null;
    }

    public void setListadoComunidades(java.lang.String[] listadoComunidades)
    {
        this.listadoComunidades = listadoComunidades;
    }

    /**
     * 
     */
    public java.lang.String[] getListadoComunidades()
    {
        return this.listadoComunidades;
    }
    
    public java.lang.Object[] getListadoComunidadesBackingList()
    {
        java.lang.Object[] values = this.listadoComunidadesValueList;
        java.lang.Object[] labels = this.listadoComunidadesLabelList;

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

    public java.lang.Object[] getListadoComunidadesValueList()
    {
        return this.listadoComunidadesValueList;
    }

    public void setListadoComunidadesValueList(java.lang.Object[] listadoComunidadesValueList)
    {
        this.listadoComunidadesValueList = listadoComunidadesValueList;
    }

    public java.lang.Object[] getListadoComunidadesLabelList()
    {
        return this.listadoComunidadesLabelList;
    }

    public void setListadoComunidadesLabelList(java.lang.Object[] listadoComunidadesLabelList)
    {
        this.listadoComunidadesLabelList = listadoComunidadesLabelList;
    }

    public void setListadoComunidadesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DerechosFormImpl.setListadoComunidadesBackingList requires non-null property arguments");
        }

        this.listadoComunidadesValueList = null;
        this.listadoComunidadesLabelList = null;

        if (items != null)
        {
            this.listadoComunidadesValueList = new java.lang.Object[items.size()];
            this.listadoComunidadesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listadoComunidadesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listadoComunidadesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DerechosFormImpl.setListadoComunidadesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idEliminado</code>.
     */
    public void resetIdEliminado()
    {
        this.idEliminado = null;
    }

    public void setIdEliminado(java.lang.String idEliminado)
    {
        this.idEliminado = idEliminado;
    }

    /**
     * 
     */
    public java.lang.String getIdEliminado()
    {
        return this.idEliminado;
    }
    
    public java.lang.Object[] getIdEliminadoBackingList()
    {
        java.lang.Object[] values = this.idEliminadoValueList;
        java.lang.Object[] labels = this.idEliminadoLabelList;

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

    public java.lang.Object[] getIdEliminadoValueList()
    {
        return this.idEliminadoValueList;
    }

    public void setIdEliminadoValueList(java.lang.Object[] idEliminadoValueList)
    {
        this.idEliminadoValueList = idEliminadoValueList;
    }

    public java.lang.Object[] getIdEliminadoLabelList()
    {
        return this.idEliminadoLabelList;
    }

    public void setIdEliminadoLabelList(java.lang.Object[] idEliminadoLabelList)
    {
        this.idEliminadoLabelList = idEliminadoLabelList;
    }

    public void setIdEliminadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DerechosFormImpl.setIdEliminadoBackingList requires non-null property arguments");
        }

        this.idEliminadoValueList = null;
        this.idEliminadoLabelList = null;

        if (items != null)
        {
            this.idEliminadoValueList = new java.lang.Object[items.size()];
            this.idEliminadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idEliminadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idEliminadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DerechosFormImpl.setIdEliminadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listadoNodos</code>.
     */
    public void resetListadoNodos()
    {
        this.listadoNodos = null;
    }

    public void setListadoNodos(java.util.List listadoNodos)
    {
        this.listadoNodos = listadoNodos;
    }

    /**
     * 
     */
    public java.util.List getListadoNodos()
    {
        return this.listadoNodos;
    }

    public void setListadoNodosAsArray(Object[] listadoNodos)
    {
        this.listadoNodos = (listadoNodos == null) ? null : java.util.Arrays.asList(listadoNodos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosFormImpl#getListadoNodos
     */
    public java.lang.Object[] getListadoNodosAsArray()
    {
        return (listadoNodos == null) ? null : listadoNodos.toArray();
    }
    
    public java.lang.Object[] getListadoNodosBackingList()
    {
        java.lang.Object[] values = this.listadoNodosValueList;
        java.lang.Object[] labels = this.listadoNodosLabelList;

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

    public java.lang.Object[] getListadoNodosValueList()
    {
        return this.listadoNodosValueList;
    }

    public void setListadoNodosValueList(java.lang.Object[] listadoNodosValueList)
    {
        this.listadoNodosValueList = listadoNodosValueList;
    }

    public java.lang.Object[] getListadoNodosLabelList()
    {
        return this.listadoNodosLabelList;
    }

    public void setListadoNodosLabelList(java.lang.Object[] listadoNodosLabelList)
    {
        this.listadoNodosLabelList = listadoNodosLabelList;
    }

    public void setListadoNodosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DerechosFormImpl.setListadoNodosBackingList requires non-null property arguments");
        }

        this.listadoNodosValueList = null;
        this.listadoNodosLabelList = null;

        if (items != null)
        {
            this.listadoNodosValueList = new java.lang.Object[items.size()];
            this.listadoNodosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listadoNodosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listadoNodosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DerechosFormImpl.setListadoNodosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoAcceso</code>.
     */
    public void resetTipoAcceso()
    {
        this.tipoAcceso = null;
    }

    public void setTipoAcceso(java.lang.String tipoAcceso)
    {
        this.tipoAcceso = tipoAcceso;
    }

    /**
     * 
     */
    public java.lang.String getTipoAcceso()
    {
        return this.tipoAcceso;
    }
    
    public java.lang.Object[] getTipoAccesoBackingList()
    {
        java.lang.Object[] values = this.tipoAccesoValueList;
        java.lang.Object[] labels = this.tipoAccesoLabelList;

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

    public java.lang.Object[] getTipoAccesoValueList()
    {
        return this.tipoAccesoValueList;
    }

    public void setTipoAccesoValueList(java.lang.Object[] tipoAccesoValueList)
    {
        this.tipoAccesoValueList = tipoAccesoValueList;
    }

    public java.lang.Object[] getTipoAccesoLabelList()
    {
        return this.tipoAccesoLabelList;
    }

    public void setTipoAccesoLabelList(java.lang.Object[] tipoAccesoLabelList)
    {
        this.tipoAccesoLabelList = tipoAccesoLabelList;
    }

    public void setTipoAccesoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DerechosFormImpl.setTipoAccesoBackingList requires non-null property arguments");
        }

        this.tipoAccesoValueList = null;
        this.tipoAccesoLabelList = null;

        if (items != null)
        {
            this.tipoAccesoValueList = new java.lang.Object[items.size()];
            this.tipoAccesoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoAccesoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoAccesoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DerechosFormImpl.setTipoAccesoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificador</code>.
     */
    public void resetIdentificador()
    {
        this.identificador = null;
    }

    public void setIdentificador(java.lang.String identificador)
    {
        this.identificador = identificador;
    }

    /**
     * 
     */
    public java.lang.String getIdentificador()
    {
        return this.identificador;
    }
    
    public java.lang.Object[] getIdentificadorBackingList()
    {
        java.lang.Object[] values = this.identificadorValueList;
        java.lang.Object[] labels = this.identificadorLabelList;

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

    public java.lang.Object[] getIdentificadorValueList()
    {
        return this.identificadorValueList;
    }

    public void setIdentificadorValueList(java.lang.Object[] identificadorValueList)
    {
        this.identificadorValueList = identificadorValueList;
    }

    public java.lang.Object[] getIdentificadorLabelList()
    {
        return this.identificadorLabelList;
    }

    public void setIdentificadorLabelList(java.lang.Object[] identificadorLabelList)
    {
        this.identificadorLabelList = identificadorLabelList;
    }

    public void setIdentificadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DerechosFormImpl.setIdentificadorBackingList requires non-null property arguments");
        }

        this.identificadorValueList = null;
        this.identificadorLabelList = null;

        if (items != null)
        {
            this.identificadorValueList = new java.lang.Object[items.size()];
            this.identificadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DerechosFormImpl.setIdentificadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DerechosFormImpl.setComboIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DerechosFormImpl.setComboIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>coste</code>.
     */
    public void resetCoste()
    {
        this.coste = null;
    }

    public void setCoste(java.lang.String coste)
    {
        this.coste = coste;
    }

    /**
     * 
     */
    public java.lang.String getCoste()
    {
        return this.coste;
    }
    
    public java.lang.Object[] getCosteBackingList()
    {
        java.lang.Object[] values = this.costeValueList;
        java.lang.Object[] labels = this.costeLabelList;

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

    public java.lang.Object[] getCosteValueList()
    {
        return this.costeValueList;
    }

    public void setCosteValueList(java.lang.Object[] costeValueList)
    {
        this.costeValueList = costeValueList;
    }

    public java.lang.Object[] getCosteLabelList()
    {
        return this.costeLabelList;
    }

    public void setCosteLabelList(java.lang.Object[] costeLabelList)
    {
        this.costeLabelList = costeLabelList;
    }

    public void setCosteBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DerechosFormImpl.setCosteBackingList requires non-null property arguments");
        }

        this.costeValueList = null;
        this.costeLabelList = null;

        if (items != null)
        {
            this.costeValueList = new java.lang.Object[items.size()];
            this.costeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.costeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.costeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DerechosFormImpl.setCosteBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>datos</code>.
     */
    public void resetDatos()
    {
        this.datos = null;
    }

    public void setDatos(java.util.Collection datos)
    {
        this.datos = datos;
    }

    /**
     * 
     */
    public java.util.Collection getDatos()
    {
        return this.datos;
    }

    public void setDatosAsArray(Object[] datos)
    {
        this.datos = (datos == null) ? null : java.util.Arrays.asList(datos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosFormImpl#getDatos
     */
    public java.lang.Object[] getDatosAsArray()
    {
        return (datos == null) ? null : datos.toArray();
    }
    
    public java.lang.Object[] getDatosBackingList()
    {
        java.lang.Object[] values = this.datosValueList;
        java.lang.Object[] labels = this.datosLabelList;

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

    public java.lang.Object[] getDatosValueList()
    {
        return this.datosValueList;
    }

    public void setDatosValueList(java.lang.Object[] datosValueList)
    {
        this.datosValueList = datosValueList;
    }

    public java.lang.Object[] getDatosLabelList()
    {
        return this.datosLabelList;
    }

    public void setDatosLabelList(java.lang.Object[] datosLabelList)
    {
        this.datosLabelList = datosLabelList;
    }

    public void setDatosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DerechosFormImpl.setDatosBackingList requires non-null property arguments");
        }

        this.datosValueList = null;
        this.datosLabelList = null;

        if (items != null)
        {
            this.datosValueList = new java.lang.Object[items.size()];
            this.datosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.datosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.datosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DerechosFormImpl.setDatosBackingList encountered an exception", ex);
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosFormImpl#getMensajesError
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
            throw new IllegalArgumentException("DerechosFormImpl.setMensajesErrorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DerechosFormImpl.setMensajesErrorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DerechosFormImpl.setReturnURLBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DerechosFormImpl.setReturnURLBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificadorOde</code>.
     */
    public void resetIdentificadorOde()
    {
        this.identificadorOde = null;
    }

    public void setIdentificadorOde(java.lang.String identificadorOde)
    {
        this.identificadorOde = identificadorOde;
    }

    /**
     * 
     */
    public java.lang.String getIdentificadorOde()
    {
        return this.identificadorOde;
    }
    
    public java.lang.Object[] getIdentificadorOdeBackingList()
    {
        java.lang.Object[] values = this.identificadorOdeValueList;
        java.lang.Object[] labels = this.identificadorOdeLabelList;

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

    public java.lang.Object[] getIdentificadorOdeValueList()
    {
        return this.identificadorOdeValueList;
    }

    public void setIdentificadorOdeValueList(java.lang.Object[] identificadorOdeValueList)
    {
        this.identificadorOdeValueList = identificadorOdeValueList;
    }

    public java.lang.Object[] getIdentificadorOdeLabelList()
    {
        return this.identificadorOdeLabelList;
    }

    public void setIdentificadorOdeLabelList(java.lang.Object[] identificadorOdeLabelList)
    {
        this.identificadorOdeLabelList = identificadorOdeLabelList;
    }

    public void setIdentificadorOdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DerechosFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
        }

        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;

        if (items != null)
        {
            this.identificadorOdeValueList = new java.lang.Object[items.size()];
            this.identificadorOdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadorOdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadorOdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DerechosFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>coypRestricciones</code>.
     */
    public void resetCoypRestricciones()
    {
        this.coypRestricciones = null;
    }

    public void setCoypRestricciones(java.lang.String coypRestricciones)
    {
        this.coypRestricciones = coypRestricciones;
    }

    /**
     * 
     */
    public java.lang.String getCoypRestricciones()
    {
        return this.coypRestricciones;
    }
    
    public java.lang.Object[] getCoypRestriccionesBackingList()
    {
        java.lang.Object[] values = this.coypRestriccionesValueList;
        java.lang.Object[] labels = this.coypRestriccionesLabelList;

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

    public java.lang.Object[] getCoypRestriccionesValueList()
    {
        return this.coypRestriccionesValueList;
    }

    public void setCoypRestriccionesValueList(java.lang.Object[] coypRestriccionesValueList)
    {
        this.coypRestriccionesValueList = coypRestriccionesValueList;
    }

    public java.lang.Object[] getCoypRestriccionesLabelList()
    {
        return this.coypRestriccionesLabelList;
    }

    public void setCoypRestriccionesLabelList(java.lang.Object[] coypRestriccionesLabelList)
    {
        this.coypRestriccionesLabelList = coypRestriccionesLabelList;
    }

    public void setCoypRestriccionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DerechosFormImpl.setCoypRestriccionesBackingList requires non-null property arguments");
        }

        this.coypRestriccionesValueList = null;
        this.coypRestriccionesLabelList = null;

        if (items != null)
        {
            this.coypRestriccionesValueList = new java.lang.Object[items.size()];
            this.coypRestriccionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.coypRestriccionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.coypRestriccionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DerechosFormImpl.setCoypRestriccionesBackingList encountered an exception", ex);
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
        this.copyRestricciones = null;
        this.listadoComunidades = null;
        this.listadoComunidadesValueList = new java.lang.Object[0];
        this.listadoComunidadesLabelList = new java.lang.Object[0];
        this.listadoNodos = null;
        this.listadoNodosValueList = new java.lang.Object[0];
        this.listadoNodosLabelList = new java.lang.Object[0];
        this.tipoAcceso = null;
        this.comboIdioma = null;
        this.coste = null;
        this.datos = null;
        this.datosValueList = new java.lang.Object[0];
        this.datosLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("descripciones", this.descripciones);
        builder.append("copyRestricciones", this.copyRestricciones);
        builder.append("accion", this.accion);
        builder.append("listadoComunidades", this.listadoComunidades);
        builder.append("idEliminado", this.idEliminado);
        builder.append("listadoNodos", this.listadoNodos);
        builder.append("tipoAcceso", this.tipoAcceso);
        builder.append("identificador", this.identificador);
        builder.append("comboIdioma", this.comboIdioma);
        builder.append("coste", this.coste);
        builder.append("datos", this.datos);
        builder.append("mensajesError", this.mensajesError);
        builder.append("returnURL", this.returnURL);
        builder.append("identificadorOde", this.identificadorOde);
        builder.append("coypRestricciones", this.coypRestricciones);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.descripciones = null;
        this.descripcionesValueList = null;
        this.descripcionesLabelList = null;
        this.copyRestricciones = null;
        this.copyRestriccionesValueList = null;
        this.copyRestriccionesLabelList = null;
        this.accion = null;
        this.accionValueList = null;
        this.accionLabelList = null;
        this.listadoComunidades = null;
        this.listadoComunidadesValueList = null;
        this.listadoComunidadesLabelList = null;
        this.idEliminado = null;
        this.idEliminadoValueList = null;
        this.idEliminadoLabelList = null;
        this.listadoNodos = null;
        this.listadoNodosValueList = null;
        this.listadoNodosLabelList = null;
        this.tipoAcceso = null;
        this.tipoAccesoValueList = null;
        this.tipoAccesoLabelList = null;
        this.identificador = null;
        this.identificadorValueList = null;
        this.identificadorLabelList = null;
        this.comboIdioma = null;
        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;
        this.coste = null;
        this.costeValueList = null;
        this.costeLabelList = null;
        this.datos = null;
        this.datosValueList = null;
        this.datosLabelList = null;
        this.mensajesError = null;
        this.mensajesErrorValueList = null;
        this.mensajesErrorLabelList = null;
        this.returnURL = null;
        this.returnURLValueList = null;
        this.returnURLLabelList = null;
        this.identificadorOde = null;
        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;
        this.coypRestricciones = null;
        this.coypRestriccionesValueList = null;
        this.coypRestriccionesLabelList = null;
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
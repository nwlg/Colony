// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos;

public class ValidoNoOKVolverFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.CargarDerechosValidarForm
{
    private java.util.List listadoNodos;
    private java.lang.Object[] listadoNodosValueList;
    private java.lang.Object[] listadoNodosLabelList;
    private java.util.Collection descripciones;
    private java.lang.Object[] descripcionesValueList;
    private java.lang.Object[] descripcionesLabelList;
    private java.lang.String tipoAcceso;
    private java.lang.Object[] tipoAccesoValueList;
    private java.lang.Object[] tipoAccesoLabelList;
    private java.lang.String copyRestricciones;
    private java.lang.Object[] copyRestriccionesValueList;
    private java.lang.Object[] copyRestriccionesLabelList;
    private java.lang.String comboIdioma;
    private java.lang.Object[] comboIdiomaValueList;
    private java.lang.Object[] comboIdiomaLabelList;
    private java.lang.String coste;
    private java.lang.Object[] costeValueList;
    private java.lang.Object[] costeLabelList;
    private java.lang.String accion;
    private java.lang.Object[] accionValueList;
    private java.lang.Object[] accionLabelList;
    private java.lang.String[] listadoComunidades;
    private java.lang.Object[] listadoComunidadesValueList;
    private java.lang.Object[] listadoComunidadesLabelList;
    private java.lang.String idEliminado;
    private java.lang.Object[] idEliminadoValueList;
    private java.lang.Object[] idEliminadoLabelList;
    private java.util.Collection mensajesError;
    private java.lang.Object[] mensajesErrorValueList;
    private java.lang.Object[] mensajesErrorLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;
    private java.lang.String coypRestricciones;
    private java.lang.Object[] coypRestriccionesValueList;
    private java.lang.Object[] coypRestriccionesLabelList;

    public ValidoNoOKVolverFormImpl()
    {
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.ValidoNoOKVolverFormImpl#getListadoNodos
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
            throw new IllegalArgumentException("ValidoNoOKVolverFormImpl.setListadoNodosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ValidoNoOKVolverFormImpl.setListadoNodosBackingList encountered an exception", ex);
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.ValidoNoOKVolverFormImpl#getDescripciones
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
            throw new IllegalArgumentException("ValidoNoOKVolverFormImpl.setDescripcionesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ValidoNoOKVolverFormImpl.setDescripcionesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ValidoNoOKVolverFormImpl.setTipoAccesoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ValidoNoOKVolverFormImpl.setTipoAccesoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ValidoNoOKVolverFormImpl.setCopyRestriccionesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ValidoNoOKVolverFormImpl.setCopyRestriccionesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ValidoNoOKVolverFormImpl.setComboIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ValidoNoOKVolverFormImpl.setComboIdiomaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ValidoNoOKVolverFormImpl.setCosteBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ValidoNoOKVolverFormImpl.setCosteBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ValidoNoOKVolverFormImpl.setAccionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ValidoNoOKVolverFormImpl.setAccionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ValidoNoOKVolverFormImpl.setListadoComunidadesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ValidoNoOKVolverFormImpl.setListadoComunidadesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ValidoNoOKVolverFormImpl.setIdEliminadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ValidoNoOKVolverFormImpl.setIdEliminadoBackingList encountered an exception", ex);
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.ValidoNoOKVolverFormImpl#getMensajesError
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
            throw new IllegalArgumentException("ValidoNoOKVolverFormImpl.setMensajesErrorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ValidoNoOKVolverFormImpl.setMensajesErrorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ValidoNoOKVolverFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ValidoNoOKVolverFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ValidoNoOKVolverFormImpl.setCoypRestriccionesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ValidoNoOKVolverFormImpl.setCoypRestriccionesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.listadoNodos = null;
        this.listadoNodosValueList = new java.lang.Object[0];
        this.listadoNodosLabelList = new java.lang.Object[0];
        this.descripciones = null;
        this.descripcionesValueList = new java.lang.Object[0];
        this.descripcionesLabelList = new java.lang.Object[0];
        this.tipoAcceso = null;
        this.copyRestricciones = null;
        this.comboIdioma = null;
        this.coste = null;
        this.listadoComunidades = null;
        this.listadoComunidadesValueList = new java.lang.Object[0];
        this.listadoComunidadesLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("listadoNodos", this.listadoNodos);
        builder.append("descripciones", this.descripciones);
        builder.append("tipoAcceso", this.tipoAcceso);
        builder.append("copyRestricciones", this.copyRestricciones);
        builder.append("comboIdioma", this.comboIdioma);
        builder.append("coste", this.coste);
        builder.append("accion", this.accion);
        builder.append("listadoComunidades", this.listadoComunidades);
        builder.append("idEliminado", this.idEliminado);
        builder.append("mensajesError", this.mensajesError);
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
        this.listadoNodos = null;
        this.listadoNodosValueList = null;
        this.listadoNodosLabelList = null;
        this.descripciones = null;
        this.descripcionesValueList = null;
        this.descripcionesLabelList = null;
        this.tipoAcceso = null;
        this.tipoAccesoValueList = null;
        this.tipoAccesoLabelList = null;
        this.copyRestricciones = null;
        this.copyRestriccionesValueList = null;
        this.copyRestriccionesLabelList = null;
        this.comboIdioma = null;
        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;
        this.coste = null;
        this.costeValueList = null;
        this.costeLabelList = null;
        this.accion = null;
        this.accionValueList = null;
        this.accionLabelList = null;
        this.listadoComunidades = null;
        this.listadoComunidadesValueList = null;
        this.listadoComunidadesLabelList = null;
        this.idEliminado = null;
        this.idEliminadoValueList = null;
        this.idEliminadoLabelList = null;
        this.mensajesError = null;
        this.mensajesErrorValueList = null;
        this.mensajesErrorLabelList = null;
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
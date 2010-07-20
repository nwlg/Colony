// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

public class DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.verMetadatos.CargarUsosEducativosForm
{
    private java.lang.String botonPulsado;
    private java.lang.Object[] botonPulsadoValueList;
    private java.lang.Object[] botonPulsadoLabelList;
    private java.util.Collection listadoUsosEdu;
    private java.lang.Object[] listadoUsosEduValueList;
    private java.lang.Object[] listadoUsosEduLabelList;
    private java.lang.String tipoInteractividad;
    private java.lang.Object[] tipoInteractividadValueList;
    private java.lang.Object[] tipoInteractividadLabelList;
    private java.lang.String comboRol;
    private java.lang.Object[] comboRolValueList;
    private java.lang.Object[] comboRolLabelList;
    private java.lang.String comboProceso;
    private java.lang.Object[] comboProcesoValueList;
    private java.lang.Object[] comboProcesoLabelList;
    private java.lang.String dificultad;
    private java.lang.Object[] dificultadValueList;
    private java.lang.Object[] dificultadLabelList;
    private java.lang.String comboTipoRecurso;
    private java.lang.Object[] comboTipoRecursoValueList;
    private java.lang.Object[] comboTipoRecursoLabelList;
    private java.util.Collection idiomas;
    private java.lang.Object[] idiomasValueList;
    private java.lang.Object[] idiomasLabelList;
    private java.lang.String comboContexto;
    private java.lang.Object[] comboContextoValueList;
    private java.lang.Object[] comboContextoLabelList;
    private java.lang.String comboIdioma;
    private java.lang.Object[] comboIdiomaValueList;
    private java.lang.Object[] comboIdiomaLabelList;
    private java.lang.String nivelInteractividad;
    private java.lang.Object[] nivelInteractividadValueList;
    private java.lang.Object[] nivelInteractividadLabelList;
    private java.lang.String densidadSemantica;
    private java.lang.Object[] densidadSemanticaValueList;
    private java.lang.Object[] densidadSemanticaLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;

    public DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl()
    {
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
            throw new IllegalArgumentException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setBotonPulsadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setBotonPulsadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listadoUsosEdu</code>.
     */
    public void resetListadoUsosEdu()
    {
        this.listadoUsosEdu = null;
    }

    public void setListadoUsosEdu(java.util.Collection listadoUsosEdu)
    {
        this.listadoUsosEdu = listadoUsosEdu;
    }

    /**
     * 
     */
    public java.util.Collection getListadoUsosEdu()
    {
        return this.listadoUsosEdu;
    }

    public void setListadoUsosEduAsArray(Object[] listadoUsosEdu)
    {
        this.listadoUsosEdu = (listadoUsosEdu == null) ? null : java.util.Arrays.asList(listadoUsosEdu);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl#getListadoUsosEdu
     */
    public java.lang.Object[] getListadoUsosEduAsArray()
    {
        return (listadoUsosEdu == null) ? null : listadoUsosEdu.toArray();
    }
    
    public java.lang.Object[] getListadoUsosEduBackingList()
    {
        java.lang.Object[] values = this.listadoUsosEduValueList;
        java.lang.Object[] labels = this.listadoUsosEduLabelList;

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

    public java.lang.Object[] getListadoUsosEduValueList()
    {
        return this.listadoUsosEduValueList;
    }

    public void setListadoUsosEduValueList(java.lang.Object[] listadoUsosEduValueList)
    {
        this.listadoUsosEduValueList = listadoUsosEduValueList;
    }

    public java.lang.Object[] getListadoUsosEduLabelList()
    {
        return this.listadoUsosEduLabelList;
    }

    public void setListadoUsosEduLabelList(java.lang.Object[] listadoUsosEduLabelList)
    {
        this.listadoUsosEduLabelList = listadoUsosEduLabelList;
    }

    public void setListadoUsosEduBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setListadoUsosEduBackingList requires non-null property arguments");
        }

        this.listadoUsosEduValueList = null;
        this.listadoUsosEduLabelList = null;

        if (items != null)
        {
            this.listadoUsosEduValueList = new java.lang.Object[items.size()];
            this.listadoUsosEduLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listadoUsosEduValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listadoUsosEduLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setListadoUsosEduBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setTipoInteractividadBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setTipoInteractividadBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setComboRolBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setComboRolBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setComboProcesoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setComboProcesoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setDificultadBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setDificultadBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setComboTipoRecursoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setComboTipoRecursoBackingList encountered an exception", ex);
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
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl#getIdiomas
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
            throw new IllegalArgumentException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setIdiomasBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setIdiomasBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setComboContextoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setComboContextoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setComboIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setComboIdiomaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setNivelInteractividadBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setNivelInteractividadBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setDensidadSemanticaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setDensidadSemanticaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("DetalleUsoEducativoFormVuelveDeDetalleUsoEducativoFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.listadoUsosEdu = null;
        this.listadoUsosEduValueList = new java.lang.Object[0];
        this.listadoUsosEduLabelList = new java.lang.Object[0];
        this.tipoInteractividad = null;
        this.comboRol = null;
        this.comboProceso = null;
        this.dificultad = null;
        this.comboTipoRecurso = null;
        this.idiomas = null;
        this.idiomasValueList = new java.lang.Object[0];
        this.idiomasLabelList = new java.lang.Object[0];
        this.comboContexto = null;
        this.comboIdioma = null;
        this.nivelInteractividad = null;
        this.densidadSemantica = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("botonPulsado", this.botonPulsado);
        builder.append("listadoUsosEdu", this.listadoUsosEdu);
        builder.append("tipoInteractividad", this.tipoInteractividad);
        builder.append("comboRol", this.comboRol);
        builder.append("comboProceso", this.comboProceso);
        builder.append("dificultad", this.dificultad);
        builder.append("comboTipoRecurso", this.comboTipoRecurso);
        builder.append("idiomas", this.idiomas);
        builder.append("comboContexto", this.comboContexto);
        builder.append("comboIdioma", this.comboIdioma);
        builder.append("nivelInteractividad", this.nivelInteractividad);
        builder.append("densidadSemantica", this.densidadSemantica);
        builder.append("identificadorOde", this.identificadorOde);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.botonPulsado = null;
        this.botonPulsadoValueList = null;
        this.botonPulsadoLabelList = null;
        this.listadoUsosEdu = null;
        this.listadoUsosEduValueList = null;
        this.listadoUsosEduLabelList = null;
        this.tipoInteractividad = null;
        this.tipoInteractividadValueList = null;
        this.tipoInteractividadLabelList = null;
        this.comboRol = null;
        this.comboRolValueList = null;
        this.comboRolLabelList = null;
        this.comboProceso = null;
        this.comboProcesoValueList = null;
        this.comboProcesoLabelList = null;
        this.dificultad = null;
        this.dificultadValueList = null;
        this.dificultadLabelList = null;
        this.comboTipoRecurso = null;
        this.comboTipoRecursoValueList = null;
        this.comboTipoRecursoLabelList = null;
        this.idiomas = null;
        this.idiomasValueList = null;
        this.idiomasLabelList = null;
        this.comboContexto = null;
        this.comboContextoValueList = null;
        this.comboContextoLabelList = null;
        this.comboIdioma = null;
        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;
        this.nivelInteractividad = null;
        this.nivelInteractividadValueList = null;
        this.nivelInteractividadLabelList = null;
        this.densidadSemantica = null;
        this.densidadSemanticaValueList = null;
        this.densidadSemanticaLabelList = null;
        this.identificadorOde = null;
        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;
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
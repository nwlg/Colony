// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

public class RelacionesFormDetalleRelacionFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDetalleRelacionForm
{
    private java.lang.String botonPulsado;
    private java.lang.Object[] botonPulsadoValueList;
    private java.lang.Object[] botonPulsadoLabelList;
    private java.lang.String tituloRelacion;
    private java.lang.Object[] tituloRelacionValueList;
    private java.lang.Object[] tituloRelacionLabelList;
    private java.lang.String catalogo;
    private java.lang.Object[] catalogoValueList;
    private java.lang.Object[] catalogoLabelList;
    private java.lang.String comboIdioma;
    private java.lang.Object[] comboIdiomaValueList;
    private java.lang.Object[] comboIdiomaLabelList;
    private java.lang.String tipo;
    private java.lang.Object[] tipoValueList;
    private java.lang.Object[] tipoLabelList;
    private java.util.Collection descripcion;
    private java.lang.Object[] descripcionValueList;
    private java.lang.Object[] descripcionLabelList;
    private java.lang.String entrada;
    private java.lang.Object[] entradaValueList;
    private java.lang.Object[] entradaLabelList;
    private java.util.Collection listadoRelaciones;
    private java.lang.Object[] listadoRelacionesValueList;
    private java.lang.Object[] listadoRelacionesLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;

    public RelacionesFormDetalleRelacionFormImpl()
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
            throw new IllegalArgumentException("RelacionesFormDetalleRelacionFormImpl.setBotonPulsadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("RelacionesFormDetalleRelacionFormImpl.setBotonPulsadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tituloRelacion</code>.
     */
    public void resetTituloRelacion()
    {
        this.tituloRelacion = null;
    }

    public void setTituloRelacion(java.lang.String tituloRelacion)
    {
        this.tituloRelacion = tituloRelacion;
    }

    /**
     * 
     */
    public java.lang.String getTituloRelacion()
    {
        return this.tituloRelacion;
    }
    
    public java.lang.Object[] getTituloRelacionBackingList()
    {
        java.lang.Object[] values = this.tituloRelacionValueList;
        java.lang.Object[] labels = this.tituloRelacionLabelList;

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

    public java.lang.Object[] getTituloRelacionValueList()
    {
        return this.tituloRelacionValueList;
    }

    public void setTituloRelacionValueList(java.lang.Object[] tituloRelacionValueList)
    {
        this.tituloRelacionValueList = tituloRelacionValueList;
    }

    public java.lang.Object[] getTituloRelacionLabelList()
    {
        return this.tituloRelacionLabelList;
    }

    public void setTituloRelacionLabelList(java.lang.Object[] tituloRelacionLabelList)
    {
        this.tituloRelacionLabelList = tituloRelacionLabelList;
    }

    public void setTituloRelacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RelacionesFormDetalleRelacionFormImpl.setTituloRelacionBackingList requires non-null property arguments");
        }

        this.tituloRelacionValueList = null;
        this.tituloRelacionLabelList = null;

        if (items != null)
        {
            this.tituloRelacionValueList = new java.lang.Object[items.size()];
            this.tituloRelacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tituloRelacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tituloRelacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RelacionesFormDetalleRelacionFormImpl.setTituloRelacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>catalogo</code>.
     */
    public void resetCatalogo()
    {
        this.catalogo = null;
    }

    public void setCatalogo(java.lang.String catalogo)
    {
        this.catalogo = catalogo;
    }

    /**
     * 
     */
    public java.lang.String getCatalogo()
    {
        return this.catalogo;
    }
    
    public java.lang.Object[] getCatalogoBackingList()
    {
        java.lang.Object[] values = this.catalogoValueList;
        java.lang.Object[] labels = this.catalogoLabelList;

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

    public java.lang.Object[] getCatalogoValueList()
    {
        return this.catalogoValueList;
    }

    public void setCatalogoValueList(java.lang.Object[] catalogoValueList)
    {
        this.catalogoValueList = catalogoValueList;
    }

    public java.lang.Object[] getCatalogoLabelList()
    {
        return this.catalogoLabelList;
    }

    public void setCatalogoLabelList(java.lang.Object[] catalogoLabelList)
    {
        this.catalogoLabelList = catalogoLabelList;
    }

    public void setCatalogoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RelacionesFormDetalleRelacionFormImpl.setCatalogoBackingList requires non-null property arguments");
        }

        this.catalogoValueList = null;
        this.catalogoLabelList = null;

        if (items != null)
        {
            this.catalogoValueList = new java.lang.Object[items.size()];
            this.catalogoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.catalogoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.catalogoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RelacionesFormDetalleRelacionFormImpl.setCatalogoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("RelacionesFormDetalleRelacionFormImpl.setComboIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("RelacionesFormDetalleRelacionFormImpl.setComboIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipo</code>.
     */
    public void resetTipo()
    {
        this.tipo = null;
    }

    public void setTipo(java.lang.String tipo)
    {
        this.tipo = tipo;
    }

    /**
     * 
     */
    public java.lang.String getTipo()
    {
        return this.tipo;
    }
    
    public java.lang.Object[] getTipoBackingList()
    {
        java.lang.Object[] values = this.tipoValueList;
        java.lang.Object[] labels = this.tipoLabelList;

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

    public java.lang.Object[] getTipoValueList()
    {
        return this.tipoValueList;
    }

    public void setTipoValueList(java.lang.Object[] tipoValueList)
    {
        this.tipoValueList = tipoValueList;
    }

    public java.lang.Object[] getTipoLabelList()
    {
        return this.tipoLabelList;
    }

    public void setTipoLabelList(java.lang.Object[] tipoLabelList)
    {
        this.tipoLabelList = tipoLabelList;
    }

    public void setTipoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RelacionesFormDetalleRelacionFormImpl.setTipoBackingList requires non-null property arguments");
        }

        this.tipoValueList = null;
        this.tipoLabelList = null;

        if (items != null)
        {
            this.tipoValueList = new java.lang.Object[items.size()];
            this.tipoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RelacionesFormDetalleRelacionFormImpl.setTipoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcion</code>.
     */
    public void resetDescripcion()
    {
        this.descripcion = null;
    }

    public void setDescripcion(java.util.Collection descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * 
     */
    public java.util.Collection getDescripcion()
    {
        return this.descripcion;
    }

    public void setDescripcionAsArray(Object[] descripcion)
    {
        this.descripcion = (descripcion == null) ? null : java.util.Arrays.asList(descripcion);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.RelacionesFormDetalleRelacionFormImpl#getDescripcion
     */
    public java.lang.Object[] getDescripcionAsArray()
    {
        return (descripcion == null) ? null : descripcion.toArray();
    }
    
    public java.lang.Object[] getDescripcionBackingList()
    {
        java.lang.Object[] values = this.descripcionValueList;
        java.lang.Object[] labels = this.descripcionLabelList;

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

    public java.lang.Object[] getDescripcionValueList()
    {
        return this.descripcionValueList;
    }

    public void setDescripcionValueList(java.lang.Object[] descripcionValueList)
    {
        this.descripcionValueList = descripcionValueList;
    }

    public java.lang.Object[] getDescripcionLabelList()
    {
        return this.descripcionLabelList;
    }

    public void setDescripcionLabelList(java.lang.Object[] descripcionLabelList)
    {
        this.descripcionLabelList = descripcionLabelList;
    }

    public void setDescripcionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RelacionesFormDetalleRelacionFormImpl.setDescripcionBackingList requires non-null property arguments");
        }

        this.descripcionValueList = null;
        this.descripcionLabelList = null;

        if (items != null)
        {
            this.descripcionValueList = new java.lang.Object[items.size()];
            this.descripcionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RelacionesFormDetalleRelacionFormImpl.setDescripcionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>entrada</code>.
     */
    public void resetEntrada()
    {
        this.entrada = null;
    }

    public void setEntrada(java.lang.String entrada)
    {
        this.entrada = entrada;
    }

    /**
     * 
     */
    public java.lang.String getEntrada()
    {
        return this.entrada;
    }
    
    public java.lang.Object[] getEntradaBackingList()
    {
        java.lang.Object[] values = this.entradaValueList;
        java.lang.Object[] labels = this.entradaLabelList;

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

    public java.lang.Object[] getEntradaValueList()
    {
        return this.entradaValueList;
    }

    public void setEntradaValueList(java.lang.Object[] entradaValueList)
    {
        this.entradaValueList = entradaValueList;
    }

    public java.lang.Object[] getEntradaLabelList()
    {
        return this.entradaLabelList;
    }

    public void setEntradaLabelList(java.lang.Object[] entradaLabelList)
    {
        this.entradaLabelList = entradaLabelList;
    }

    public void setEntradaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RelacionesFormDetalleRelacionFormImpl.setEntradaBackingList requires non-null property arguments");
        }

        this.entradaValueList = null;
        this.entradaLabelList = null;

        if (items != null)
        {
            this.entradaValueList = new java.lang.Object[items.size()];
            this.entradaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.entradaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.entradaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RelacionesFormDetalleRelacionFormImpl.setEntradaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listadoRelaciones</code>.
     */
    public void resetListadoRelaciones()
    {
        this.listadoRelaciones = null;
    }

    public void setListadoRelaciones(java.util.Collection listadoRelaciones)
    {
        this.listadoRelaciones = listadoRelaciones;
    }

    /**
     * 
     */
    public java.util.Collection getListadoRelaciones()
    {
        return this.listadoRelaciones;
    }

    public void setListadoRelacionesAsArray(Object[] listadoRelaciones)
    {
        this.listadoRelaciones = (listadoRelaciones == null) ? null : java.util.Arrays.asList(listadoRelaciones);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.RelacionesFormDetalleRelacionFormImpl#getListadoRelaciones
     */
    public java.lang.Object[] getListadoRelacionesAsArray()
    {
        return (listadoRelaciones == null) ? null : listadoRelaciones.toArray();
    }
    
    public java.lang.Object[] getListadoRelacionesBackingList()
    {
        java.lang.Object[] values = this.listadoRelacionesValueList;
        java.lang.Object[] labels = this.listadoRelacionesLabelList;

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

    public java.lang.Object[] getListadoRelacionesValueList()
    {
        return this.listadoRelacionesValueList;
    }

    public void setListadoRelacionesValueList(java.lang.Object[] listadoRelacionesValueList)
    {
        this.listadoRelacionesValueList = listadoRelacionesValueList;
    }

    public java.lang.Object[] getListadoRelacionesLabelList()
    {
        return this.listadoRelacionesLabelList;
    }

    public void setListadoRelacionesLabelList(java.lang.Object[] listadoRelacionesLabelList)
    {
        this.listadoRelacionesLabelList = listadoRelacionesLabelList;
    }

    public void setListadoRelacionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RelacionesFormDetalleRelacionFormImpl.setListadoRelacionesBackingList requires non-null property arguments");
        }

        this.listadoRelacionesValueList = null;
        this.listadoRelacionesLabelList = null;

        if (items != null)
        {
            this.listadoRelacionesValueList = new java.lang.Object[items.size()];
            this.listadoRelacionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listadoRelacionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listadoRelacionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RelacionesFormDetalleRelacionFormImpl.setListadoRelacionesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("RelacionesFormDetalleRelacionFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("RelacionesFormDetalleRelacionFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.comboIdioma = null;
        this.tipo = null;
        this.listadoRelaciones = null;
        this.listadoRelacionesValueList = new java.lang.Object[0];
        this.listadoRelacionesLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("botonPulsado", this.botonPulsado);
        builder.append("tituloRelacion", this.tituloRelacion);
        builder.append("catalogo", this.catalogo);
        builder.append("comboIdioma", this.comboIdioma);
        builder.append("tipo", this.tipo);
        builder.append("descripcion", this.descripcion);
        builder.append("entrada", this.entrada);
        builder.append("listadoRelaciones", this.listadoRelaciones);
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
        this.tituloRelacion = null;
        this.tituloRelacionValueList = null;
        this.tituloRelacionLabelList = null;
        this.catalogo = null;
        this.catalogoValueList = null;
        this.catalogoLabelList = null;
        this.comboIdioma = null;
        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;
        this.tipo = null;
        this.tipoValueList = null;
        this.tipoLabelList = null;
        this.descripcion = null;
        this.descripcionValueList = null;
        this.descripcionLabelList = null;
        this.entrada = null;
        this.entradaValueList = null;
        this.entradaLabelList = null;
        this.listadoRelaciones = null;
        this.listadoRelacionesValueList = null;
        this.listadoRelacionesLabelList = null;
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
// license-header java merge-point
package es.pode.administracion.presentacion.faqs.modificar;

public class ModificarDosValidarFormuFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.faqs.modificar.ModificarFaqDosForm
        , es.pode.administracion.presentacion.faqs.modificar.ModificarFaqUnoForm
        , es.pode.administracion.presentacion.faqs.modificar.ValidarFormularioForm
        , es.pode.administracion.presentacion.faqs.modificar.AnalizaValidacionForm
{
    private java.lang.String valido;
    private java.lang.Object[] validoValueList;
    private java.lang.Object[] validoLabelList;
    private java.util.Collection valuePosicion;
    private java.lang.Object[] valuePosicionValueList;
    private java.lang.Object[] valuePosicionLabelList;
    private java.util.Collection idiomasAlta;
    private java.lang.Object[] idiomasAltaValueList;
    private java.lang.Object[] idiomasAltaLabelList;
    private java.lang.Long idModificado;
    private java.lang.Object[] idModificadoValueList;
    private java.lang.Object[] idModificadoLabelList;
    private java.util.Collection descripcion;
    private java.lang.Object[] descripcionValueList;
    private java.lang.Object[] descripcionLabelList;
    private java.util.Collection posicionesValenciano;
    private java.lang.Object[] posicionesValencianoValueList;
    private java.lang.Object[] posicionesValencianoLabelList;
    private java.lang.String[] catalan;
    private java.lang.Object[] catalanValueList;
    private java.lang.Object[] catalanLabelList;
    private java.util.Collection idiomasCategoriasBBDD;
    private java.lang.Object[] idiomasCategoriasBBDDValueList;
    private java.lang.Object[] idiomasCategoriasBBDDLabelList;
    private java.util.Collection posicionesCatalan;
    private java.lang.Object[] posicionesCatalanValueList;
    private java.lang.Object[] posicionesCatalanLabelList;
    private java.lang.String[] gallego;
    private java.lang.Object[] gallegoValueList;
    private java.lang.Object[] gallegoLabelList;
    private java.util.Collection posicionesEuskera;
    private java.lang.Object[] posicionesEuskeraValueList;
    private java.lang.Object[] posicionesEuskeraLabelList;
    private java.lang.Long id;
    private java.lang.Object[] idValueList;
    private java.lang.Object[] idLabelList;
    private java.lang.Long categoria;
    private java.lang.Object[] categoriaValueList;
    private java.lang.Object[] categoriaLabelList;
    private java.util.Collection nombreCategoria;
    private java.lang.Object[] nombreCategoriaValueList;
    private java.lang.Object[] nombreCategoriaLabelList;
    private java.lang.String[] ingles;
    private java.lang.Object[] inglesValueList;
    private java.lang.Object[] inglesLabelList;
    private java.lang.String[] castellano;
    private java.lang.Object[] castellanoValueList;
    private java.lang.Object[] castellanoLabelList;
    private java.util.Collection titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.util.Collection idiomas;
    private java.lang.Object[] idiomasValueList;
    private java.lang.Object[] idiomasLabelList;
    private java.util.Collection posicionesIngles;
    private java.lang.Object[] posicionesInglesValueList;
    private java.lang.Object[] posicionesInglesLabelList;
    private java.lang.String[] valenciano;
    private java.lang.Object[] valencianoValueList;
    private java.lang.Object[] valencianoLabelList;
    private java.lang.String[] euskera;
    private java.lang.Object[] euskeraValueList;
    private java.lang.Object[] euskeraLabelList;
    private java.util.Collection posicionesGallego;
    private java.lang.Object[] posicionesGallegoValueList;
    private java.lang.Object[] posicionesGallegoLabelList;
    private java.util.Collection posicionesCastellano;
    private java.lang.Object[] posicionesCastellanoValueList;
    private java.lang.Object[] posicionesCastellanoLabelList;

    public ModificarDosValidarFormuFormImpl()
    {
    }

    /**
     * Resets the given <code>valido</code>.
     */
    public void resetValido()
    {
        this.valido = null;
    }

    public void setValido(java.lang.String valido)
    {
        this.valido = valido;
    }

    /**
     * 
     */
    public java.lang.String getValido()
    {
        return this.valido;
    }
    
    public java.lang.Object[] getValidoBackingList()
    {
        java.lang.Object[] values = this.validoValueList;
        java.lang.Object[] labels = this.validoLabelList;

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

    public java.lang.Object[] getValidoValueList()
    {
        return this.validoValueList;
    }

    public void setValidoValueList(java.lang.Object[] validoValueList)
    {
        this.validoValueList = validoValueList;
    }

    public java.lang.Object[] getValidoLabelList()
    {
        return this.validoLabelList;
    }

    public void setValidoLabelList(java.lang.Object[] validoLabelList)
    {
        this.validoLabelList = validoLabelList;
    }

    public void setValidoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setValidoBackingList requires non-null property arguments");
        }

        this.validoValueList = null;
        this.validoLabelList = null;

        if (items != null)
        {
            this.validoValueList = new java.lang.Object[items.size()];
            this.validoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.validoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.validoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setValidoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>valuePosicion</code>.
     */
    public void resetValuePosicion()
    {
        this.valuePosicion = null;
    }

    public void setValuePosicion(java.util.Collection valuePosicion)
    {
        this.valuePosicion = valuePosicion;
    }

    /**
     * 
     */
    public java.util.Collection getValuePosicion()
    {
        return this.valuePosicion;
    }

    public void setValuePosicionAsArray(Object[] valuePosicion)
    {
        this.valuePosicion = (valuePosicion == null) ? null : java.util.Arrays.asList(valuePosicion);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarDosValidarFormuFormImpl#getValuePosicion
     */
    public java.lang.Object[] getValuePosicionAsArray()
    {
        return (valuePosicion == null) ? null : valuePosicion.toArray();
    }
    
    public java.lang.Object[] getValuePosicionBackingList()
    {
        java.lang.Object[] values = this.valuePosicionValueList;
        java.lang.Object[] labels = this.valuePosicionLabelList;

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

    public java.lang.Object[] getValuePosicionValueList()
    {
        return this.valuePosicionValueList;
    }

    public void setValuePosicionValueList(java.lang.Object[] valuePosicionValueList)
    {
        this.valuePosicionValueList = valuePosicionValueList;
    }

    public java.lang.Object[] getValuePosicionLabelList()
    {
        return this.valuePosicionLabelList;
    }

    public void setValuePosicionLabelList(java.lang.Object[] valuePosicionLabelList)
    {
        this.valuePosicionLabelList = valuePosicionLabelList;
    }

    public void setValuePosicionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setValuePosicionBackingList requires non-null property arguments");
        }

        this.valuePosicionValueList = null;
        this.valuePosicionLabelList = null;

        if (items != null)
        {
            this.valuePosicionValueList = new java.lang.Object[items.size()];
            this.valuePosicionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.valuePosicionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.valuePosicionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setValuePosicionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomasAlta</code>.
     */
    public void resetIdiomasAlta()
    {
        this.idiomasAlta = null;
    }

    public void setIdiomasAlta(java.util.Collection idiomasAlta)
    {
        this.idiomasAlta = idiomasAlta;
    }

    /**
     * 
     */
    public java.util.Collection getIdiomasAlta()
    {
        return this.idiomasAlta;
    }

    public void setIdiomasAltaAsArray(Object[] idiomasAlta)
    {
        this.idiomasAlta = (idiomasAlta == null) ? null : java.util.Arrays.asList(idiomasAlta);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarDosValidarFormuFormImpl#getIdiomasAlta
     */
    public java.lang.Object[] getIdiomasAltaAsArray()
    {
        return (idiomasAlta == null) ? null : idiomasAlta.toArray();
    }
    
    public java.lang.Object[] getIdiomasAltaBackingList()
    {
        java.lang.Object[] values = this.idiomasAltaValueList;
        java.lang.Object[] labels = this.idiomasAltaLabelList;

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

    public java.lang.Object[] getIdiomasAltaValueList()
    {
        return this.idiomasAltaValueList;
    }

    public void setIdiomasAltaValueList(java.lang.Object[] idiomasAltaValueList)
    {
        this.idiomasAltaValueList = idiomasAltaValueList;
    }

    public java.lang.Object[] getIdiomasAltaLabelList()
    {
        return this.idiomasAltaLabelList;
    }

    public void setIdiomasAltaLabelList(java.lang.Object[] idiomasAltaLabelList)
    {
        this.idiomasAltaLabelList = idiomasAltaLabelList;
    }

    public void setIdiomasAltaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setIdiomasAltaBackingList requires non-null property arguments");
        }

        this.idiomasAltaValueList = null;
        this.idiomasAltaLabelList = null;

        if (items != null)
        {
            this.idiomasAltaValueList = new java.lang.Object[items.size()];
            this.idiomasAltaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomasAltaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomasAltaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setIdiomasAltaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idModificado</code>.
     */
    public void resetIdModificado()
    {
        this.idModificado = null;
    }

    public void setIdModificado(java.lang.Long idModificado)
    {
        this.idModificado = idModificado;
    }

    /**
     * 
     */
    public java.lang.Long getIdModificado()
    {
        return this.idModificado;
    }
    
    public java.lang.Object[] getIdModificadoBackingList()
    {
        java.lang.Object[] values = this.idModificadoValueList;
        java.lang.Object[] labels = this.idModificadoLabelList;

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

    public java.lang.Object[] getIdModificadoValueList()
    {
        return this.idModificadoValueList;
    }

    public void setIdModificadoValueList(java.lang.Object[] idModificadoValueList)
    {
        this.idModificadoValueList = idModificadoValueList;
    }

    public java.lang.Object[] getIdModificadoLabelList()
    {
        return this.idModificadoLabelList;
    }

    public void setIdModificadoLabelList(java.lang.Object[] idModificadoLabelList)
    {
        this.idModificadoLabelList = idModificadoLabelList;
    }

    public void setIdModificadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setIdModificadoBackingList requires non-null property arguments");
        }

        this.idModificadoValueList = null;
        this.idModificadoLabelList = null;

        if (items != null)
        {
            this.idModificadoValueList = new java.lang.Object[items.size()];
            this.idModificadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idModificadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idModificadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setIdModificadoBackingList encountered an exception", ex);
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
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarDosValidarFormuFormImpl#getDescripcion
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
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setDescripcionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setDescripcionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>posicionesValenciano</code>.
     */
    public void resetPosicionesValenciano()
    {
        this.posicionesValenciano = null;
    }

    public void setPosicionesValenciano(java.util.Collection posicionesValenciano)
    {
        this.posicionesValenciano = posicionesValenciano;
    }

    /**
     * 
     */
    public java.util.Collection getPosicionesValenciano()
    {
        return this.posicionesValenciano;
    }

    public void setPosicionesValencianoAsArray(Object[] posicionesValenciano)
    {
        this.posicionesValenciano = (posicionesValenciano == null) ? null : java.util.Arrays.asList(posicionesValenciano);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarDosValidarFormuFormImpl#getPosicionesValenciano
     */
    public java.lang.Object[] getPosicionesValencianoAsArray()
    {
        return (posicionesValenciano == null) ? null : posicionesValenciano.toArray();
    }
    
    public java.lang.Object[] getPosicionesValencianoBackingList()
    {
        java.lang.Object[] values = this.posicionesValencianoValueList;
        java.lang.Object[] labels = this.posicionesValencianoLabelList;

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

    public java.lang.Object[] getPosicionesValencianoValueList()
    {
        return this.posicionesValencianoValueList;
    }

    public void setPosicionesValencianoValueList(java.lang.Object[] posicionesValencianoValueList)
    {
        this.posicionesValencianoValueList = posicionesValencianoValueList;
    }

    public java.lang.Object[] getPosicionesValencianoLabelList()
    {
        return this.posicionesValencianoLabelList;
    }

    public void setPosicionesValencianoLabelList(java.lang.Object[] posicionesValencianoLabelList)
    {
        this.posicionesValencianoLabelList = posicionesValencianoLabelList;
    }

    public void setPosicionesValencianoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setPosicionesValencianoBackingList requires non-null property arguments");
        }

        this.posicionesValencianoValueList = null;
        this.posicionesValencianoLabelList = null;

        if (items != null)
        {
            this.posicionesValencianoValueList = new java.lang.Object[items.size()];
            this.posicionesValencianoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.posicionesValencianoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.posicionesValencianoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setPosicionesValencianoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>catalan</code>.
     */
    public void resetCatalan()
    {
        this.catalan = null;
    }

    public void setCatalan(java.lang.String[] catalan)
    {
        this.catalan = catalan;
    }

    /**
     * 
     */
    public java.lang.String[] getCatalan()
    {
        return this.catalan;
    }
    
    public java.lang.Object[] getCatalanBackingList()
    {
        java.lang.Object[] values = this.catalanValueList;
        java.lang.Object[] labels = this.catalanLabelList;

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

    public java.lang.Object[] getCatalanValueList()
    {
        return this.catalanValueList;
    }

    public void setCatalanValueList(java.lang.Object[] catalanValueList)
    {
        this.catalanValueList = catalanValueList;
    }

    public java.lang.Object[] getCatalanLabelList()
    {
        return this.catalanLabelList;
    }

    public void setCatalanLabelList(java.lang.Object[] catalanLabelList)
    {
        this.catalanLabelList = catalanLabelList;
    }

    public void setCatalanBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setCatalanBackingList requires non-null property arguments");
        }

        this.catalanValueList = null;
        this.catalanLabelList = null;

        if (items != null)
        {
            this.catalanValueList = new java.lang.Object[items.size()];
            this.catalanLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.catalanValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.catalanLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setCatalanBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomasCategoriasBBDD</code>.
     */
    public void resetIdiomasCategoriasBBDD()
    {
        this.idiomasCategoriasBBDD = null;
    }

    public void setIdiomasCategoriasBBDD(java.util.Collection idiomasCategoriasBBDD)
    {
        this.idiomasCategoriasBBDD = idiomasCategoriasBBDD;
    }

    /**
     * 
     */
    public java.util.Collection getIdiomasCategoriasBBDD()
    {
        return this.idiomasCategoriasBBDD;
    }

    public void setIdiomasCategoriasBBDDAsArray(Object[] idiomasCategoriasBBDD)
    {
        this.idiomasCategoriasBBDD = (idiomasCategoriasBBDD == null) ? null : java.util.Arrays.asList(idiomasCategoriasBBDD);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarDosValidarFormuFormImpl#getIdiomasCategoriasBBDD
     */
    public java.lang.Object[] getIdiomasCategoriasBBDDAsArray()
    {
        return (idiomasCategoriasBBDD == null) ? null : idiomasCategoriasBBDD.toArray();
    }
    
    public java.lang.Object[] getIdiomasCategoriasBBDDBackingList()
    {
        java.lang.Object[] values = this.idiomasCategoriasBBDDValueList;
        java.lang.Object[] labels = this.idiomasCategoriasBBDDLabelList;

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

    public java.lang.Object[] getIdiomasCategoriasBBDDValueList()
    {
        return this.idiomasCategoriasBBDDValueList;
    }

    public void setIdiomasCategoriasBBDDValueList(java.lang.Object[] idiomasCategoriasBBDDValueList)
    {
        this.idiomasCategoriasBBDDValueList = idiomasCategoriasBBDDValueList;
    }

    public java.lang.Object[] getIdiomasCategoriasBBDDLabelList()
    {
        return this.idiomasCategoriasBBDDLabelList;
    }

    public void setIdiomasCategoriasBBDDLabelList(java.lang.Object[] idiomasCategoriasBBDDLabelList)
    {
        this.idiomasCategoriasBBDDLabelList = idiomasCategoriasBBDDLabelList;
    }

    public void setIdiomasCategoriasBBDDBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setIdiomasCategoriasBBDDBackingList requires non-null property arguments");
        }

        this.idiomasCategoriasBBDDValueList = null;
        this.idiomasCategoriasBBDDLabelList = null;

        if (items != null)
        {
            this.idiomasCategoriasBBDDValueList = new java.lang.Object[items.size()];
            this.idiomasCategoriasBBDDLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomasCategoriasBBDDValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomasCategoriasBBDDLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setIdiomasCategoriasBBDDBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>posicionesCatalan</code>.
     */
    public void resetPosicionesCatalan()
    {
        this.posicionesCatalan = null;
    }

    public void setPosicionesCatalan(java.util.Collection posicionesCatalan)
    {
        this.posicionesCatalan = posicionesCatalan;
    }

    /**
     * 
     */
    public java.util.Collection getPosicionesCatalan()
    {
        return this.posicionesCatalan;
    }

    public void setPosicionesCatalanAsArray(Object[] posicionesCatalan)
    {
        this.posicionesCatalan = (posicionesCatalan == null) ? null : java.util.Arrays.asList(posicionesCatalan);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarDosValidarFormuFormImpl#getPosicionesCatalan
     */
    public java.lang.Object[] getPosicionesCatalanAsArray()
    {
        return (posicionesCatalan == null) ? null : posicionesCatalan.toArray();
    }
    
    public java.lang.Object[] getPosicionesCatalanBackingList()
    {
        java.lang.Object[] values = this.posicionesCatalanValueList;
        java.lang.Object[] labels = this.posicionesCatalanLabelList;

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

    public java.lang.Object[] getPosicionesCatalanValueList()
    {
        return this.posicionesCatalanValueList;
    }

    public void setPosicionesCatalanValueList(java.lang.Object[] posicionesCatalanValueList)
    {
        this.posicionesCatalanValueList = posicionesCatalanValueList;
    }

    public java.lang.Object[] getPosicionesCatalanLabelList()
    {
        return this.posicionesCatalanLabelList;
    }

    public void setPosicionesCatalanLabelList(java.lang.Object[] posicionesCatalanLabelList)
    {
        this.posicionesCatalanLabelList = posicionesCatalanLabelList;
    }

    public void setPosicionesCatalanBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setPosicionesCatalanBackingList requires non-null property arguments");
        }

        this.posicionesCatalanValueList = null;
        this.posicionesCatalanLabelList = null;

        if (items != null)
        {
            this.posicionesCatalanValueList = new java.lang.Object[items.size()];
            this.posicionesCatalanLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.posicionesCatalanValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.posicionesCatalanLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setPosicionesCatalanBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>gallego</code>.
     */
    public void resetGallego()
    {
        this.gallego = null;
    }

    public void setGallego(java.lang.String[] gallego)
    {
        this.gallego = gallego;
    }

    /**
     * 
     */
    public java.lang.String[] getGallego()
    {
        return this.gallego;
    }
    
    public java.lang.Object[] getGallegoBackingList()
    {
        java.lang.Object[] values = this.gallegoValueList;
        java.lang.Object[] labels = this.gallegoLabelList;

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

    public java.lang.Object[] getGallegoValueList()
    {
        return this.gallegoValueList;
    }

    public void setGallegoValueList(java.lang.Object[] gallegoValueList)
    {
        this.gallegoValueList = gallegoValueList;
    }

    public java.lang.Object[] getGallegoLabelList()
    {
        return this.gallegoLabelList;
    }

    public void setGallegoLabelList(java.lang.Object[] gallegoLabelList)
    {
        this.gallegoLabelList = gallegoLabelList;
    }

    public void setGallegoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setGallegoBackingList requires non-null property arguments");
        }

        this.gallegoValueList = null;
        this.gallegoLabelList = null;

        if (items != null)
        {
            this.gallegoValueList = new java.lang.Object[items.size()];
            this.gallegoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.gallegoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.gallegoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setGallegoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>posicionesEuskera</code>.
     */
    public void resetPosicionesEuskera()
    {
        this.posicionesEuskera = null;
    }

    public void setPosicionesEuskera(java.util.Collection posicionesEuskera)
    {
        this.posicionesEuskera = posicionesEuskera;
    }

    /**
     * 
     */
    public java.util.Collection getPosicionesEuskera()
    {
        return this.posicionesEuskera;
    }

    public void setPosicionesEuskeraAsArray(Object[] posicionesEuskera)
    {
        this.posicionesEuskera = (posicionesEuskera == null) ? null : java.util.Arrays.asList(posicionesEuskera);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarDosValidarFormuFormImpl#getPosicionesEuskera
     */
    public java.lang.Object[] getPosicionesEuskeraAsArray()
    {
        return (posicionesEuskera == null) ? null : posicionesEuskera.toArray();
    }
    
    public java.lang.Object[] getPosicionesEuskeraBackingList()
    {
        java.lang.Object[] values = this.posicionesEuskeraValueList;
        java.lang.Object[] labels = this.posicionesEuskeraLabelList;

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

    public java.lang.Object[] getPosicionesEuskeraValueList()
    {
        return this.posicionesEuskeraValueList;
    }

    public void setPosicionesEuskeraValueList(java.lang.Object[] posicionesEuskeraValueList)
    {
        this.posicionesEuskeraValueList = posicionesEuskeraValueList;
    }

    public java.lang.Object[] getPosicionesEuskeraLabelList()
    {
        return this.posicionesEuskeraLabelList;
    }

    public void setPosicionesEuskeraLabelList(java.lang.Object[] posicionesEuskeraLabelList)
    {
        this.posicionesEuskeraLabelList = posicionesEuskeraLabelList;
    }

    public void setPosicionesEuskeraBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setPosicionesEuskeraBackingList requires non-null property arguments");
        }

        this.posicionesEuskeraValueList = null;
        this.posicionesEuskeraLabelList = null;

        if (items != null)
        {
            this.posicionesEuskeraValueList = new java.lang.Object[items.size()];
            this.posicionesEuskeraLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.posicionesEuskeraValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.posicionesEuskeraLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setPosicionesEuskeraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>id</code>.
     */
    public void resetId()
    {
        this.id = null;
    }

    public void setId(java.lang.Long id)
    {
        this.id = id;
    }

    /**
     * 
     */
    public java.lang.Long getId()
    {
        return this.id;
    }
    
    public java.lang.Object[] getIdBackingList()
    {
        java.lang.Object[] values = this.idValueList;
        java.lang.Object[] labels = this.idLabelList;

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

    public java.lang.Object[] getIdValueList()
    {
        return this.idValueList;
    }

    public void setIdValueList(java.lang.Object[] idValueList)
    {
        this.idValueList = idValueList;
    }

    public java.lang.Object[] getIdLabelList()
    {
        return this.idLabelList;
    }

    public void setIdLabelList(java.lang.Object[] idLabelList)
    {
        this.idLabelList = idLabelList;
    }

    public void setIdBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setIdBackingList requires non-null property arguments");
        }

        this.idValueList = null;
        this.idLabelList = null;

        if (items != null)
        {
            this.idValueList = new java.lang.Object[items.size()];
            this.idLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>categoria</code>.
     */
    public void resetCategoria()
    {
        this.categoria = null;
    }

    public void setCategoria(java.lang.Long categoria)
    {
        this.categoria = categoria;
    }

    /**
     * 
     */
    public java.lang.Long getCategoria()
    {
        return this.categoria;
    }
    
    public java.lang.Object[] getCategoriaBackingList()
    {
        java.lang.Object[] values = this.categoriaValueList;
        java.lang.Object[] labels = this.categoriaLabelList;

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

    public java.lang.Object[] getCategoriaValueList()
    {
        return this.categoriaValueList;
    }

    public void setCategoriaValueList(java.lang.Object[] categoriaValueList)
    {
        this.categoriaValueList = categoriaValueList;
    }

    public java.lang.Object[] getCategoriaLabelList()
    {
        return this.categoriaLabelList;
    }

    public void setCategoriaLabelList(java.lang.Object[] categoriaLabelList)
    {
        this.categoriaLabelList = categoriaLabelList;
    }

    public void setCategoriaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setCategoriaBackingList requires non-null property arguments");
        }

        this.categoriaValueList = null;
        this.categoriaLabelList = null;

        if (items != null)
        {
            this.categoriaValueList = new java.lang.Object[items.size()];
            this.categoriaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.categoriaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.categoriaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setCategoriaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nombreCategoria</code>.
     */
    public void resetNombreCategoria()
    {
        this.nombreCategoria = null;
    }

    public void setNombreCategoria(java.util.Collection nombreCategoria)
    {
        this.nombreCategoria = nombreCategoria;
    }

    /**
     * 
     */
    public java.util.Collection getNombreCategoria()
    {
        return this.nombreCategoria;
    }

    public void setNombreCategoriaAsArray(Object[] nombreCategoria)
    {
        this.nombreCategoria = (nombreCategoria == null) ? null : java.util.Arrays.asList(nombreCategoria);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarDosValidarFormuFormImpl#getNombreCategoria
     */
    public java.lang.Object[] getNombreCategoriaAsArray()
    {
        return (nombreCategoria == null) ? null : nombreCategoria.toArray();
    }
    
    public java.lang.Object[] getNombreCategoriaBackingList()
    {
        java.lang.Object[] values = this.nombreCategoriaValueList;
        java.lang.Object[] labels = this.nombreCategoriaLabelList;

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

    public java.lang.Object[] getNombreCategoriaValueList()
    {
        return this.nombreCategoriaValueList;
    }

    public void setNombreCategoriaValueList(java.lang.Object[] nombreCategoriaValueList)
    {
        this.nombreCategoriaValueList = nombreCategoriaValueList;
    }

    public java.lang.Object[] getNombreCategoriaLabelList()
    {
        return this.nombreCategoriaLabelList;
    }

    public void setNombreCategoriaLabelList(java.lang.Object[] nombreCategoriaLabelList)
    {
        this.nombreCategoriaLabelList = nombreCategoriaLabelList;
    }

    public void setNombreCategoriaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setNombreCategoriaBackingList requires non-null property arguments");
        }

        this.nombreCategoriaValueList = null;
        this.nombreCategoriaLabelList = null;

        if (items != null)
        {
            this.nombreCategoriaValueList = new java.lang.Object[items.size()];
            this.nombreCategoriaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nombreCategoriaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nombreCategoriaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setNombreCategoriaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ingles</code>.
     */
    public void resetIngles()
    {
        this.ingles = null;
    }

    public void setIngles(java.lang.String[] ingles)
    {
        this.ingles = ingles;
    }

    /**
     * 
     */
    public java.lang.String[] getIngles()
    {
        return this.ingles;
    }
    
    public java.lang.Object[] getInglesBackingList()
    {
        java.lang.Object[] values = this.inglesValueList;
        java.lang.Object[] labels = this.inglesLabelList;

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

    public java.lang.Object[] getInglesValueList()
    {
        return this.inglesValueList;
    }

    public void setInglesValueList(java.lang.Object[] inglesValueList)
    {
        this.inglesValueList = inglesValueList;
    }

    public java.lang.Object[] getInglesLabelList()
    {
        return this.inglesLabelList;
    }

    public void setInglesLabelList(java.lang.Object[] inglesLabelList)
    {
        this.inglesLabelList = inglesLabelList;
    }

    public void setInglesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setInglesBackingList requires non-null property arguments");
        }

        this.inglesValueList = null;
        this.inglesLabelList = null;

        if (items != null)
        {
            this.inglesValueList = new java.lang.Object[items.size()];
            this.inglesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.inglesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.inglesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setInglesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>castellano</code>.
     */
    public void resetCastellano()
    {
        this.castellano = null;
    }

    public void setCastellano(java.lang.String[] castellano)
    {
        this.castellano = castellano;
    }

    /**
     * 
     */
    public java.lang.String[] getCastellano()
    {
        return this.castellano;
    }
    
    public java.lang.Object[] getCastellanoBackingList()
    {
        java.lang.Object[] values = this.castellanoValueList;
        java.lang.Object[] labels = this.castellanoLabelList;

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

    public java.lang.Object[] getCastellanoValueList()
    {
        return this.castellanoValueList;
    }

    public void setCastellanoValueList(java.lang.Object[] castellanoValueList)
    {
        this.castellanoValueList = castellanoValueList;
    }

    public java.lang.Object[] getCastellanoLabelList()
    {
        return this.castellanoLabelList;
    }

    public void setCastellanoLabelList(java.lang.Object[] castellanoLabelList)
    {
        this.castellanoLabelList = castellanoLabelList;
    }

    public void setCastellanoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setCastellanoBackingList requires non-null property arguments");
        }

        this.castellanoValueList = null;
        this.castellanoLabelList = null;

        if (items != null)
        {
            this.castellanoValueList = new java.lang.Object[items.size()];
            this.castellanoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.castellanoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.castellanoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setCastellanoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>titulo</code>.
     */
    public void resetTitulo()
    {
        this.titulo = null;
    }

    public void setTitulo(java.util.Collection titulo)
    {
        this.titulo = titulo;
    }

    /**
     * 
     */
    public java.util.Collection getTitulo()
    {
        return this.titulo;
    }

    public void setTituloAsArray(Object[] titulo)
    {
        this.titulo = (titulo == null) ? null : java.util.Arrays.asList(titulo);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarDosValidarFormuFormImpl#getTitulo
     */
    public java.lang.Object[] getTituloAsArray()
    {
        return (titulo == null) ? null : titulo.toArray();
    }
    
    public java.lang.Object[] getTituloBackingList()
    {
        java.lang.Object[] values = this.tituloValueList;
        java.lang.Object[] labels = this.tituloLabelList;

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

    public java.lang.Object[] getTituloValueList()
    {
        return this.tituloValueList;
    }

    public void setTituloValueList(java.lang.Object[] tituloValueList)
    {
        this.tituloValueList = tituloValueList;
    }

    public java.lang.Object[] getTituloLabelList()
    {
        return this.tituloLabelList;
    }

    public void setTituloLabelList(java.lang.Object[] tituloLabelList)
    {
        this.tituloLabelList = tituloLabelList;
    }

    public void setTituloBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setTituloBackingList requires non-null property arguments");
        }

        this.tituloValueList = null;
        this.tituloLabelList = null;

        if (items != null)
        {
            this.tituloValueList = new java.lang.Object[items.size()];
            this.tituloLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tituloValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tituloLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setTituloBackingList encountered an exception", ex);
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
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarDosValidarFormuFormImpl#getIdiomas
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
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setIdiomasBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setIdiomasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>posicionesIngles</code>.
     */
    public void resetPosicionesIngles()
    {
        this.posicionesIngles = null;
    }

    public void setPosicionesIngles(java.util.Collection posicionesIngles)
    {
        this.posicionesIngles = posicionesIngles;
    }

    /**
     * 
     */
    public java.util.Collection getPosicionesIngles()
    {
        return this.posicionesIngles;
    }

    public void setPosicionesInglesAsArray(Object[] posicionesIngles)
    {
        this.posicionesIngles = (posicionesIngles == null) ? null : java.util.Arrays.asList(posicionesIngles);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarDosValidarFormuFormImpl#getPosicionesIngles
     */
    public java.lang.Object[] getPosicionesInglesAsArray()
    {
        return (posicionesIngles == null) ? null : posicionesIngles.toArray();
    }
    
    public java.lang.Object[] getPosicionesInglesBackingList()
    {
        java.lang.Object[] values = this.posicionesInglesValueList;
        java.lang.Object[] labels = this.posicionesInglesLabelList;

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

    public java.lang.Object[] getPosicionesInglesValueList()
    {
        return this.posicionesInglesValueList;
    }

    public void setPosicionesInglesValueList(java.lang.Object[] posicionesInglesValueList)
    {
        this.posicionesInglesValueList = posicionesInglesValueList;
    }

    public java.lang.Object[] getPosicionesInglesLabelList()
    {
        return this.posicionesInglesLabelList;
    }

    public void setPosicionesInglesLabelList(java.lang.Object[] posicionesInglesLabelList)
    {
        this.posicionesInglesLabelList = posicionesInglesLabelList;
    }

    public void setPosicionesInglesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setPosicionesInglesBackingList requires non-null property arguments");
        }

        this.posicionesInglesValueList = null;
        this.posicionesInglesLabelList = null;

        if (items != null)
        {
            this.posicionesInglesValueList = new java.lang.Object[items.size()];
            this.posicionesInglesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.posicionesInglesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.posicionesInglesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setPosicionesInglesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>valenciano</code>.
     */
    public void resetValenciano()
    {
        this.valenciano = null;
    }

    public void setValenciano(java.lang.String[] valenciano)
    {
        this.valenciano = valenciano;
    }

    /**
     * 
     */
    public java.lang.String[] getValenciano()
    {
        return this.valenciano;
    }
    
    public java.lang.Object[] getValencianoBackingList()
    {
        java.lang.Object[] values = this.valencianoValueList;
        java.lang.Object[] labels = this.valencianoLabelList;

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

    public java.lang.Object[] getValencianoValueList()
    {
        return this.valencianoValueList;
    }

    public void setValencianoValueList(java.lang.Object[] valencianoValueList)
    {
        this.valencianoValueList = valencianoValueList;
    }

    public java.lang.Object[] getValencianoLabelList()
    {
        return this.valencianoLabelList;
    }

    public void setValencianoLabelList(java.lang.Object[] valencianoLabelList)
    {
        this.valencianoLabelList = valencianoLabelList;
    }

    public void setValencianoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setValencianoBackingList requires non-null property arguments");
        }

        this.valencianoValueList = null;
        this.valencianoLabelList = null;

        if (items != null)
        {
            this.valencianoValueList = new java.lang.Object[items.size()];
            this.valencianoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.valencianoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.valencianoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setValencianoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>euskera</code>.
     */
    public void resetEuskera()
    {
        this.euskera = null;
    }

    public void setEuskera(java.lang.String[] euskera)
    {
        this.euskera = euskera;
    }

    /**
     * 
     */
    public java.lang.String[] getEuskera()
    {
        return this.euskera;
    }
    
    public java.lang.Object[] getEuskeraBackingList()
    {
        java.lang.Object[] values = this.euskeraValueList;
        java.lang.Object[] labels = this.euskeraLabelList;

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

    public java.lang.Object[] getEuskeraValueList()
    {
        return this.euskeraValueList;
    }

    public void setEuskeraValueList(java.lang.Object[] euskeraValueList)
    {
        this.euskeraValueList = euskeraValueList;
    }

    public java.lang.Object[] getEuskeraLabelList()
    {
        return this.euskeraLabelList;
    }

    public void setEuskeraLabelList(java.lang.Object[] euskeraLabelList)
    {
        this.euskeraLabelList = euskeraLabelList;
    }

    public void setEuskeraBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setEuskeraBackingList requires non-null property arguments");
        }

        this.euskeraValueList = null;
        this.euskeraLabelList = null;

        if (items != null)
        {
            this.euskeraValueList = new java.lang.Object[items.size()];
            this.euskeraLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.euskeraValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.euskeraLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setEuskeraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>posicionesGallego</code>.
     */
    public void resetPosicionesGallego()
    {
        this.posicionesGallego = null;
    }

    public void setPosicionesGallego(java.util.Collection posicionesGallego)
    {
        this.posicionesGallego = posicionesGallego;
    }

    /**
     * 
     */
    public java.util.Collection getPosicionesGallego()
    {
        return this.posicionesGallego;
    }

    public void setPosicionesGallegoAsArray(Object[] posicionesGallego)
    {
        this.posicionesGallego = (posicionesGallego == null) ? null : java.util.Arrays.asList(posicionesGallego);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarDosValidarFormuFormImpl#getPosicionesGallego
     */
    public java.lang.Object[] getPosicionesGallegoAsArray()
    {
        return (posicionesGallego == null) ? null : posicionesGallego.toArray();
    }
    
    public java.lang.Object[] getPosicionesGallegoBackingList()
    {
        java.lang.Object[] values = this.posicionesGallegoValueList;
        java.lang.Object[] labels = this.posicionesGallegoLabelList;

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

    public java.lang.Object[] getPosicionesGallegoValueList()
    {
        return this.posicionesGallegoValueList;
    }

    public void setPosicionesGallegoValueList(java.lang.Object[] posicionesGallegoValueList)
    {
        this.posicionesGallegoValueList = posicionesGallegoValueList;
    }

    public java.lang.Object[] getPosicionesGallegoLabelList()
    {
        return this.posicionesGallegoLabelList;
    }

    public void setPosicionesGallegoLabelList(java.lang.Object[] posicionesGallegoLabelList)
    {
        this.posicionesGallegoLabelList = posicionesGallegoLabelList;
    }

    public void setPosicionesGallegoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setPosicionesGallegoBackingList requires non-null property arguments");
        }

        this.posicionesGallegoValueList = null;
        this.posicionesGallegoLabelList = null;

        if (items != null)
        {
            this.posicionesGallegoValueList = new java.lang.Object[items.size()];
            this.posicionesGallegoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.posicionesGallegoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.posicionesGallegoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setPosicionesGallegoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>posicionesCastellano</code>.
     */
    public void resetPosicionesCastellano()
    {
        this.posicionesCastellano = null;
    }

    public void setPosicionesCastellano(java.util.Collection posicionesCastellano)
    {
        this.posicionesCastellano = posicionesCastellano;
    }

    /**
     * 
     */
    public java.util.Collection getPosicionesCastellano()
    {
        return this.posicionesCastellano;
    }

    public void setPosicionesCastellanoAsArray(Object[] posicionesCastellano)
    {
        this.posicionesCastellano = (posicionesCastellano == null) ? null : java.util.Arrays.asList(posicionesCastellano);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.faqs.modificar.ModificarDosValidarFormuFormImpl#getPosicionesCastellano
     */
    public java.lang.Object[] getPosicionesCastellanoAsArray()
    {
        return (posicionesCastellano == null) ? null : posicionesCastellano.toArray();
    }
    
    public java.lang.Object[] getPosicionesCastellanoBackingList()
    {
        java.lang.Object[] values = this.posicionesCastellanoValueList;
        java.lang.Object[] labels = this.posicionesCastellanoLabelList;

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

    public java.lang.Object[] getPosicionesCastellanoValueList()
    {
        return this.posicionesCastellanoValueList;
    }

    public void setPosicionesCastellanoValueList(java.lang.Object[] posicionesCastellanoValueList)
    {
        this.posicionesCastellanoValueList = posicionesCastellanoValueList;
    }

    public java.lang.Object[] getPosicionesCastellanoLabelList()
    {
        return this.posicionesCastellanoLabelList;
    }

    public void setPosicionesCastellanoLabelList(java.lang.Object[] posicionesCastellanoLabelList)
    {
        this.posicionesCastellanoLabelList = posicionesCastellanoLabelList;
    }

    public void setPosicionesCastellanoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarDosValidarFormuFormImpl.setPosicionesCastellanoBackingList requires non-null property arguments");
        }

        this.posicionesCastellanoValueList = null;
        this.posicionesCastellanoLabelList = null;

        if (items != null)
        {
            this.posicionesCastellanoValueList = new java.lang.Object[items.size()];
            this.posicionesCastellanoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.posicionesCastellanoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.posicionesCastellanoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarDosValidarFormuFormImpl.setPosicionesCastellanoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.catalan = null;
        this.catalanValueList = new java.lang.Object[0];
        this.catalanLabelList = new java.lang.Object[0];
        this.gallego = null;
        this.gallegoValueList = new java.lang.Object[0];
        this.gallegoLabelList = new java.lang.Object[0];
        this.ingles = null;
        this.inglesValueList = new java.lang.Object[0];
        this.inglesLabelList = new java.lang.Object[0];
        this.castellano = null;
        this.castellanoValueList = new java.lang.Object[0];
        this.castellanoLabelList = new java.lang.Object[0];
        this.valenciano = null;
        this.valencianoValueList = new java.lang.Object[0];
        this.valencianoLabelList = new java.lang.Object[0];
        this.euskera = null;
        this.euskeraValueList = new java.lang.Object[0];
        this.euskeraLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("valido", this.valido);
        builder.append("valuePosicion", this.valuePosicion);
        builder.append("idiomasAlta", this.idiomasAlta);
        builder.append("idModificado", this.idModificado);
        builder.append("descripcion", this.descripcion);
        builder.append("posicionesValenciano", this.posicionesValenciano);
        builder.append("catalan", this.catalan);
        builder.append("idiomasCategoriasBBDD", this.idiomasCategoriasBBDD);
        builder.append("posicionesCatalan", this.posicionesCatalan);
        builder.append("gallego", this.gallego);
        builder.append("posicionesEuskera", this.posicionesEuskera);
        builder.append("id", this.id);
        builder.append("categoria", this.categoria);
        builder.append("nombreCategoria", this.nombreCategoria);
        builder.append("ingles", this.ingles);
        builder.append("castellano", this.castellano);
        builder.append("titulo", this.titulo);
        builder.append("idiomas", this.idiomas);
        builder.append("posicionesIngles", this.posicionesIngles);
        builder.append("valenciano", this.valenciano);
        builder.append("euskera", this.euskera);
        builder.append("posicionesGallego", this.posicionesGallego);
        builder.append("posicionesCastellano", this.posicionesCastellano);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.valido = null;
        this.validoValueList = null;
        this.validoLabelList = null;
        this.valuePosicion = null;
        this.valuePosicionValueList = null;
        this.valuePosicionLabelList = null;
        this.idiomasAlta = null;
        this.idiomasAltaValueList = null;
        this.idiomasAltaLabelList = null;
        this.idModificado = null;
        this.idModificadoValueList = null;
        this.idModificadoLabelList = null;
        this.descripcion = null;
        this.descripcionValueList = null;
        this.descripcionLabelList = null;
        this.posicionesValenciano = null;
        this.posicionesValencianoValueList = null;
        this.posicionesValencianoLabelList = null;
        this.catalan = null;
        this.catalanValueList = null;
        this.catalanLabelList = null;
        this.idiomasCategoriasBBDD = null;
        this.idiomasCategoriasBBDDValueList = null;
        this.idiomasCategoriasBBDDLabelList = null;
        this.posicionesCatalan = null;
        this.posicionesCatalanValueList = null;
        this.posicionesCatalanLabelList = null;
        this.gallego = null;
        this.gallegoValueList = null;
        this.gallegoLabelList = null;
        this.posicionesEuskera = null;
        this.posicionesEuskeraValueList = null;
        this.posicionesEuskeraLabelList = null;
        this.id = null;
        this.idValueList = null;
        this.idLabelList = null;
        this.categoria = null;
        this.categoriaValueList = null;
        this.categoriaLabelList = null;
        this.nombreCategoria = null;
        this.nombreCategoriaValueList = null;
        this.nombreCategoriaLabelList = null;
        this.ingles = null;
        this.inglesValueList = null;
        this.inglesLabelList = null;
        this.castellano = null;
        this.castellanoValueList = null;
        this.castellanoLabelList = null;
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.idiomas = null;
        this.idiomasValueList = null;
        this.idiomasLabelList = null;
        this.posicionesIngles = null;
        this.posicionesInglesValueList = null;
        this.posicionesInglesLabelList = null;
        this.valenciano = null;
        this.valencianoValueList = null;
        this.valencianoLabelList = null;
        this.euskera = null;
        this.euskeraValueList = null;
        this.euskeraLabelList = null;
        this.posicionesGallego = null;
        this.posicionesGallegoValueList = null;
        this.posicionesGallegoLabelList = null;
        this.posicionesCastellano = null;
        this.posicionesCastellanoValueList = null;
        this.posicionesCastellanoLabelList = null;
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
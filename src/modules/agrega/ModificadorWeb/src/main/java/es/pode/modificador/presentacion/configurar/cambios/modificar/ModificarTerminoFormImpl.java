// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.modificar;

public class ModificarTerminoFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.modificador.presentacion.configurar.cambios.modificar.ObtenerValoresForm
{
    private java.lang.String alcanceTermino;
    private java.lang.Object[] alcanceTerminoValueList;
    private java.lang.Object[] alcanceTerminoLabelList;
    private es.pode.modificador.negocio.servicio.FormularioModificarVO formulario;
    private java.lang.Object[] formularioValueList;
    private java.lang.Object[] formularioLabelList;
    private java.lang.String alcanceMetadatos;
    private java.lang.Object[] alcanceMetadatosValueList;
    private java.lang.Object[] alcanceMetadatosLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.String valorNuevo;
    private java.lang.Object[] valorNuevoValueList;
    private java.lang.Object[] valorNuevoLabelList;
    private java.lang.String valorViejo;
    private java.lang.Object[] valorViejoValueList;
    private java.lang.Object[] valorViejoLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private java.lang.String exprReg;
    private java.lang.Object[] exprRegValueList;
    private java.lang.Object[] exprRegLabelList;

    public ModificarTerminoFormImpl()
    {
    }

    /**
     * Resets the given <code>alcanceTermino</code>.
     */
    public void resetAlcanceTermino()
    {
        this.alcanceTermino = null;
    }

    public void setAlcanceTermino(java.lang.String alcanceTermino)
    {
        this.alcanceTermino = alcanceTermino;
    }

    /**
     * 
     */
    public java.lang.String getAlcanceTermino()
    {
        return this.alcanceTermino;
    }
    
    public java.lang.Object[] getAlcanceTerminoBackingList()
    {
        java.lang.Object[] values = this.alcanceTerminoValueList;
        java.lang.Object[] labels = this.alcanceTerminoLabelList;

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

    public java.lang.Object[] getAlcanceTerminoValueList()
    {
        return this.alcanceTerminoValueList;
    }

    public void setAlcanceTerminoValueList(java.lang.Object[] alcanceTerminoValueList)
    {
        this.alcanceTerminoValueList = alcanceTerminoValueList;
    }

    public java.lang.Object[] getAlcanceTerminoLabelList()
    {
        return this.alcanceTerminoLabelList;
    }

    public void setAlcanceTerminoLabelList(java.lang.Object[] alcanceTerminoLabelList)
    {
        this.alcanceTerminoLabelList = alcanceTerminoLabelList;
    }

    public void setAlcanceTerminoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarTerminoFormImpl.setAlcanceTerminoBackingList requires non-null property arguments");
        }

        this.alcanceTerminoValueList = null;
        this.alcanceTerminoLabelList = null;

        if (items != null)
        {
            this.alcanceTerminoValueList = new java.lang.Object[items.size()];
            this.alcanceTerminoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.alcanceTerminoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.alcanceTerminoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarTerminoFormImpl.setAlcanceTerminoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>formulario</code>.
     */
    public void resetFormulario()
    {
        this.formulario = null;
    }

    public void setFormulario(es.pode.modificador.negocio.servicio.FormularioModificarVO formulario)
    {
        this.formulario = formulario;
    }

    /**
     * 
     */
    public es.pode.modificador.negocio.servicio.FormularioModificarVO getFormulario()
    {
        return this.formulario;
    }
    
    public java.lang.Object[] getFormularioBackingList()
    {
        java.lang.Object[] values = this.formularioValueList;
        java.lang.Object[] labels = this.formularioLabelList;

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

    public java.lang.Object[] getFormularioValueList()
    {
        return this.formularioValueList;
    }

    public void setFormularioValueList(java.lang.Object[] formularioValueList)
    {
        this.formularioValueList = formularioValueList;
    }

    public java.lang.Object[] getFormularioLabelList()
    {
        return this.formularioLabelList;
    }

    public void setFormularioLabelList(java.lang.Object[] formularioLabelList)
    {
        this.formularioLabelList = formularioLabelList;
    }

    public void setFormularioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarTerminoFormImpl.setFormularioBackingList requires non-null property arguments");
        }

        this.formularioValueList = null;
        this.formularioLabelList = null;

        if (items != null)
        {
            this.formularioValueList = new java.lang.Object[items.size()];
            this.formularioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.formularioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.formularioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarTerminoFormImpl.setFormularioBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>alcanceMetadatos</code>.
     */
    public void resetAlcanceMetadatos()
    {
        this.alcanceMetadatos = null;
    }

    public void setAlcanceMetadatos(java.lang.String alcanceMetadatos)
    {
        this.alcanceMetadatos = alcanceMetadatos;
    }

    /**
     * 
     */
    public java.lang.String getAlcanceMetadatos()
    {
        return this.alcanceMetadatos;
    }
    
    public java.lang.Object[] getAlcanceMetadatosBackingList()
    {
        java.lang.Object[] values = this.alcanceMetadatosValueList;
        java.lang.Object[] labels = this.alcanceMetadatosLabelList;

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

    public java.lang.Object[] getAlcanceMetadatosValueList()
    {
        return this.alcanceMetadatosValueList;
    }

    public void setAlcanceMetadatosValueList(java.lang.Object[] alcanceMetadatosValueList)
    {
        this.alcanceMetadatosValueList = alcanceMetadatosValueList;
    }

    public java.lang.Object[] getAlcanceMetadatosLabelList()
    {
        return this.alcanceMetadatosLabelList;
    }

    public void setAlcanceMetadatosLabelList(java.lang.Object[] alcanceMetadatosLabelList)
    {
        this.alcanceMetadatosLabelList = alcanceMetadatosLabelList;
    }

    public void setAlcanceMetadatosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarTerminoFormImpl.setAlcanceMetadatosBackingList requires non-null property arguments");
        }

        this.alcanceMetadatosValueList = null;
        this.alcanceMetadatosLabelList = null;

        if (items != null)
        {
            this.alcanceMetadatosValueList = new java.lang.Object[items.size()];
            this.alcanceMetadatosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.alcanceMetadatosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.alcanceMetadatosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarTerminoFormImpl.setAlcanceMetadatosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>action</code>.
     */
    public void resetAction()
    {
        this.action = null;
    }

    public void setAction(java.lang.String action)
    {
        this.action = action;
    }

    /**
     * 
     */
    public java.lang.String getAction()
    {
        return this.action;
    }
    
    public java.lang.Object[] getActionBackingList()
    {
        java.lang.Object[] values = this.actionValueList;
        java.lang.Object[] labels = this.actionLabelList;

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

    public java.lang.Object[] getActionValueList()
    {
        return this.actionValueList;
    }

    public void setActionValueList(java.lang.Object[] actionValueList)
    {
        this.actionValueList = actionValueList;
    }

    public java.lang.Object[] getActionLabelList()
    {
        return this.actionLabelList;
    }

    public void setActionLabelList(java.lang.Object[] actionLabelList)
    {
        this.actionLabelList = actionLabelList;
    }

    public void setActionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarTerminoFormImpl.setActionBackingList requires non-null property arguments");
        }

        this.actionValueList = null;
        this.actionLabelList = null;

        if (items != null)
        {
            this.actionValueList = new java.lang.Object[items.size()];
            this.actionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.actionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.actionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarTerminoFormImpl.setActionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ModificarTerminoFormImpl.setIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ModificarTerminoFormImpl.setIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoBusqueda</code>.
     */
    public void resetTipoBusqueda()
    {
        this.tipoBusqueda = null;
    }

    public void setTipoBusqueda(java.lang.String tipoBusqueda)
    {
        this.tipoBusqueda = tipoBusqueda;
    }

    /**
     * 
     */
    public java.lang.String getTipoBusqueda()
    {
        return this.tipoBusqueda;
    }
    
    public java.lang.Object[] getTipoBusquedaBackingList()
    {
        java.lang.Object[] values = this.tipoBusquedaValueList;
        java.lang.Object[] labels = this.tipoBusquedaLabelList;

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

    public java.lang.Object[] getTipoBusquedaValueList()
    {
        return this.tipoBusquedaValueList;
    }

    public void setTipoBusquedaValueList(java.lang.Object[] tipoBusquedaValueList)
    {
        this.tipoBusquedaValueList = tipoBusquedaValueList;
    }

    public java.lang.Object[] getTipoBusquedaLabelList()
    {
        return this.tipoBusquedaLabelList;
    }

    public void setTipoBusquedaLabelList(java.lang.Object[] tipoBusquedaLabelList)
    {
        this.tipoBusquedaLabelList = tipoBusquedaLabelList;
    }

    public void setTipoBusquedaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarTerminoFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
        }

        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;

        if (items != null)
        {
            this.tipoBusquedaValueList = new java.lang.Object[items.size()];
            this.tipoBusquedaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoBusquedaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoBusquedaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarTerminoFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>valorNuevo</code>.
     */
    public void resetValorNuevo()
    {
        this.valorNuevo = null;
    }

    public void setValorNuevo(java.lang.String valorNuevo)
    {
        this.valorNuevo = valorNuevo;
    }

    /**
     * 
     */
    public java.lang.String getValorNuevo()
    {
        return this.valorNuevo;
    }
    
    public java.lang.Object[] getValorNuevoBackingList()
    {
        java.lang.Object[] values = this.valorNuevoValueList;
        java.lang.Object[] labels = this.valorNuevoLabelList;

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

    public java.lang.Object[] getValorNuevoValueList()
    {
        return this.valorNuevoValueList;
    }

    public void setValorNuevoValueList(java.lang.Object[] valorNuevoValueList)
    {
        this.valorNuevoValueList = valorNuevoValueList;
    }

    public java.lang.Object[] getValorNuevoLabelList()
    {
        return this.valorNuevoLabelList;
    }

    public void setValorNuevoLabelList(java.lang.Object[] valorNuevoLabelList)
    {
        this.valorNuevoLabelList = valorNuevoLabelList;
    }

    public void setValorNuevoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarTerminoFormImpl.setValorNuevoBackingList requires non-null property arguments");
        }

        this.valorNuevoValueList = null;
        this.valorNuevoLabelList = null;

        if (items != null)
        {
            this.valorNuevoValueList = new java.lang.Object[items.size()];
            this.valorNuevoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.valorNuevoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.valorNuevoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarTerminoFormImpl.setValorNuevoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>valorViejo</code>.
     */
    public void resetValorViejo()
    {
        this.valorViejo = null;
    }

    public void setValorViejo(java.lang.String valorViejo)
    {
        this.valorViejo = valorViejo;
    }

    /**
     * 
     */
    public java.lang.String getValorViejo()
    {
        return this.valorViejo;
    }
    
    public java.lang.Object[] getValorViejoBackingList()
    {
        java.lang.Object[] values = this.valorViejoValueList;
        java.lang.Object[] labels = this.valorViejoLabelList;

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

    public java.lang.Object[] getValorViejoValueList()
    {
        return this.valorViejoValueList;
    }

    public void setValorViejoValueList(java.lang.Object[] valorViejoValueList)
    {
        this.valorViejoValueList = valorViejoValueList;
    }

    public java.lang.Object[] getValorViejoLabelList()
    {
        return this.valorViejoLabelList;
    }

    public void setValorViejoLabelList(java.lang.Object[] valorViejoLabelList)
    {
        this.valorViejoLabelList = valorViejoLabelList;
    }

    public void setValorViejoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarTerminoFormImpl.setValorViejoBackingList requires non-null property arguments");
        }

        this.valorViejoValueList = null;
        this.valorViejoLabelList = null;

        if (items != null)
        {
            this.valorViejoValueList = new java.lang.Object[items.size()];
            this.valorViejoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.valorViejoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.valorViejoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarTerminoFormImpl.setValorViejoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomaBuscador</code>.
     */
    public void resetIdiomaBuscador()
    {
        this.idiomaBuscador = null;
    }

    public void setIdiomaBuscador(java.lang.String idiomaBuscador)
    {
        this.idiomaBuscador = idiomaBuscador;
    }

    /**
     * 
     */
    public java.lang.String getIdiomaBuscador()
    {
        return this.idiomaBuscador;
    }
    
    public java.lang.Object[] getIdiomaBuscadorBackingList()
    {
        java.lang.Object[] values = this.idiomaBuscadorValueList;
        java.lang.Object[] labels = this.idiomaBuscadorLabelList;

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

    public java.lang.Object[] getIdiomaBuscadorValueList()
    {
        return this.idiomaBuscadorValueList;
    }

    public void setIdiomaBuscadorValueList(java.lang.Object[] idiomaBuscadorValueList)
    {
        this.idiomaBuscadorValueList = idiomaBuscadorValueList;
    }

    public java.lang.Object[] getIdiomaBuscadorLabelList()
    {
        return this.idiomaBuscadorLabelList;
    }

    public void setIdiomaBuscadorLabelList(java.lang.Object[] idiomaBuscadorLabelList)
    {
        this.idiomaBuscadorLabelList = idiomaBuscadorLabelList;
    }

    public void setIdiomaBuscadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarTerminoFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
        }

        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;

        if (items != null)
        {
            this.idiomaBuscadorValueList = new java.lang.Object[items.size()];
            this.idiomaBuscadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomaBuscadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomaBuscadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarTerminoFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>exprReg</code>.
     */
    public void resetExprReg()
    {
        this.exprReg = null;
    }

    public void setExprReg(java.lang.String exprReg)
    {
        this.exprReg = exprReg;
    }

    /**
     * 
     */
    public java.lang.String getExprReg()
    {
        return this.exprReg;
    }
    
    public java.lang.Object[] getExprRegBackingList()
    {
        java.lang.Object[] values = this.exprRegValueList;
        java.lang.Object[] labels = this.exprRegLabelList;

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

    public java.lang.Object[] getExprRegValueList()
    {
        return this.exprRegValueList;
    }

    public void setExprRegValueList(java.lang.Object[] exprRegValueList)
    {
        this.exprRegValueList = exprRegValueList;
    }

    public java.lang.Object[] getExprRegLabelList()
    {
        return this.exprRegLabelList;
    }

    public void setExprRegLabelList(java.lang.Object[] exprRegLabelList)
    {
        this.exprRegLabelList = exprRegLabelList;
    }

    public void setExprRegBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarTerminoFormImpl.setExprRegBackingList requires non-null property arguments");
        }

        this.exprRegValueList = null;
        this.exprRegLabelList = null;

        if (items != null)
        {
            this.exprRegValueList = new java.lang.Object[items.size()];
            this.exprRegLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.exprRegValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.exprRegLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarTerminoFormImpl.setExprRegBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.valorNuevo = null;
        this.idiomaBuscador = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("alcanceTermino", this.alcanceTermino);
        builder.append("formulario", this.formulario);
        builder.append("alcanceMetadatos", this.alcanceMetadatos);
        builder.append("action", this.action);
        builder.append("idioma", this.idioma);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("valorNuevo", this.valorNuevo);
        builder.append("valorViejo", this.valorViejo);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        builder.append("exprReg", this.exprReg);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.alcanceTermino = null;
        this.alcanceTerminoValueList = null;
        this.alcanceTerminoLabelList = null;
        this.formulario = null;
        this.formularioValueList = null;
        this.formularioLabelList = null;
        this.alcanceMetadatos = null;
        this.alcanceMetadatosValueList = null;
        this.alcanceMetadatosLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.valorNuevo = null;
        this.valorNuevoValueList = null;
        this.valorNuevoLabelList = null;
        this.valorViejo = null;
        this.valorViejoValueList = null;
        this.valorViejoLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
        this.exprReg = null;
        this.exprRegValueList = null;
        this.exprRegLabelList = null;
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
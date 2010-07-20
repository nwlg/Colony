// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

public class MostrarDetalleODEPrevisualizarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.buscador.presentacion.basico.detallar.SeleccionaCSSecuenciaForm
        , es.pode.buscador.presentacion.basico.detallar.DeterminaLogadoForm
{
    private java.lang.String idLocalizador;
    private java.lang.Object[] idLocalizadorValueList;
    private java.lang.Object[] idLocalizadorLabelList;
    private java.lang.String busquedaSimpleAvanzada;
    private java.lang.Object[] busquedaSimpleAvanzadaValueList;
    private java.lang.Object[] busquedaSimpleAvanzadaLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.lang.String localzadorODE;
    private java.lang.Object[] localzadorODEValueList;
    private java.lang.Object[] localzadorODELabelList;
    private java.lang.String tipoLayoutBuscador;
    private java.lang.Object[] tipoLayoutBuscadorValueList;
    private java.lang.Object[] tipoLayoutBuscadorLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private java.lang.String titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.lang.Boolean mostrarVuelta;
    private java.lang.Object[] mostrarVueltaValueList;
    private java.lang.Object[] mostrarVueltaLabelList;
    private java.lang.String idUsuario;
    private java.lang.Object[] idUsuarioValueList;
    private java.lang.Object[] idUsuarioLabelList;
    private java.lang.String tipoVisualizador;
    private java.lang.Object[] tipoVisualizadorValueList;
    private java.lang.Object[] tipoVisualizadorLabelList;
    private java.lang.String localizadorODE;
    private java.lang.Object[] localizadorODEValueList;
    private java.lang.Object[] localizadorODELabelList;
    private java.lang.String identificadorODE;
    private java.lang.Object[] identificadorODEValueList;
    private java.lang.Object[] identificadorODELabelList;
    private java.lang.Boolean seleccionarSecuencia;
    private java.lang.Object[] seleccionarSecuenciaValueList;
    private java.lang.Object[] seleccionarSecuenciaLabelList;

    public MostrarDetalleODEPrevisualizarFormImpl()
    {
    }

    /**
     * Resets the given <code>idLocalizador</code>.
     */
    public void resetIdLocalizador()
    {
        this.idLocalizador = null;
    }

    public void setIdLocalizador(java.lang.String idLocalizador)
    {
        this.idLocalizador = idLocalizador;
    }

    /**
     * <p>
     * Identificador del localizador del ODE.
     * </p>
     */
    public java.lang.String getIdLocalizador()
    {
        return this.idLocalizador;
    }
    
    public java.lang.Object[] getIdLocalizadorBackingList()
    {
        java.lang.Object[] values = this.idLocalizadorValueList;
        java.lang.Object[] labels = this.idLocalizadorLabelList;

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

    public java.lang.Object[] getIdLocalizadorValueList()
    {
        return this.idLocalizadorValueList;
    }

    public void setIdLocalizadorValueList(java.lang.Object[] idLocalizadorValueList)
    {
        this.idLocalizadorValueList = idLocalizadorValueList;
    }

    public java.lang.Object[] getIdLocalizadorLabelList()
    {
        return this.idLocalizadorLabelList;
    }

    public void setIdLocalizadorLabelList(java.lang.Object[] idLocalizadorLabelList)
    {
        this.idLocalizadorLabelList = idLocalizadorLabelList;
    }

    public void setIdLocalizadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDetalleODEPrevisualizarFormImpl.setIdLocalizadorBackingList requires non-null property arguments");
        }

        this.idLocalizadorValueList = null;
        this.idLocalizadorLabelList = null;

        if (items != null)
        {
            this.idLocalizadorValueList = new java.lang.Object[items.size()];
            this.idLocalizadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idLocalizadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idLocalizadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDetalleODEPrevisualizarFormImpl.setIdLocalizadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>busquedaSimpleAvanzada</code>.
     */
    public void resetBusquedaSimpleAvanzada()
    {
        this.busquedaSimpleAvanzada = null;
    }

    public void setBusquedaSimpleAvanzada(java.lang.String busquedaSimpleAvanzada)
    {
        this.busquedaSimpleAvanzada = busquedaSimpleAvanzada;
    }

    /**
     * 
     */
    public java.lang.String getBusquedaSimpleAvanzada()
    {
        return this.busquedaSimpleAvanzada;
    }
    
    public java.lang.Object[] getBusquedaSimpleAvanzadaBackingList()
    {
        java.lang.Object[] values = this.busquedaSimpleAvanzadaValueList;
        java.lang.Object[] labels = this.busquedaSimpleAvanzadaLabelList;

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

    public java.lang.Object[] getBusquedaSimpleAvanzadaValueList()
    {
        return this.busquedaSimpleAvanzadaValueList;
    }

    public void setBusquedaSimpleAvanzadaValueList(java.lang.Object[] busquedaSimpleAvanzadaValueList)
    {
        this.busquedaSimpleAvanzadaValueList = busquedaSimpleAvanzadaValueList;
    }

    public java.lang.Object[] getBusquedaSimpleAvanzadaLabelList()
    {
        return this.busquedaSimpleAvanzadaLabelList;
    }

    public void setBusquedaSimpleAvanzadaLabelList(java.lang.Object[] busquedaSimpleAvanzadaLabelList)
    {
        this.busquedaSimpleAvanzadaLabelList = busquedaSimpleAvanzadaLabelList;
    }

    public void setBusquedaSimpleAvanzadaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDetalleODEPrevisualizarFormImpl.setBusquedaSimpleAvanzadaBackingList requires non-null property arguments");
        }

        this.busquedaSimpleAvanzadaValueList = null;
        this.busquedaSimpleAvanzadaLabelList = null;

        if (items != null)
        {
            this.busquedaSimpleAvanzadaValueList = new java.lang.Object[items.size()];
            this.busquedaSimpleAvanzadaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.busquedaSimpleAvanzadaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.busquedaSimpleAvanzadaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDetalleODEPrevisualizarFormImpl.setBusquedaSimpleAvanzadaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEPrevisualizarFormImpl.setIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEPrevisualizarFormImpl.setIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>localzadorODE</code>.
     */
    public void resetLocalzadorODE()
    {
        this.localzadorODE = null;
    }

    public void setLocalzadorODE(java.lang.String localzadorODE)
    {
        this.localzadorODE = localzadorODE;
    }

    /**
     * 
     */
    public java.lang.String getLocalzadorODE()
    {
        return this.localzadorODE;
    }
    
    public java.lang.Object[] getLocalzadorODEBackingList()
    {
        java.lang.Object[] values = this.localzadorODEValueList;
        java.lang.Object[] labels = this.localzadorODELabelList;

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

    public java.lang.Object[] getLocalzadorODEValueList()
    {
        return this.localzadorODEValueList;
    }

    public void setLocalzadorODEValueList(java.lang.Object[] localzadorODEValueList)
    {
        this.localzadorODEValueList = localzadorODEValueList;
    }

    public java.lang.Object[] getLocalzadorODELabelList()
    {
        return this.localzadorODELabelList;
    }

    public void setLocalzadorODELabelList(java.lang.Object[] localzadorODELabelList)
    {
        this.localzadorODELabelList = localzadorODELabelList;
    }

    public void setLocalzadorODEBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDetalleODEPrevisualizarFormImpl.setLocalzadorODEBackingList requires non-null property arguments");
        }

        this.localzadorODEValueList = null;
        this.localzadorODELabelList = null;

        if (items != null)
        {
            this.localzadorODEValueList = new java.lang.Object[items.size()];
            this.localzadorODELabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.localzadorODEValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.localzadorODELabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDetalleODEPrevisualizarFormImpl.setLocalzadorODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoLayoutBuscador</code>.
     */
    public void resetTipoLayoutBuscador()
    {
        this.tipoLayoutBuscador = null;
    }

    public void setTipoLayoutBuscador(java.lang.String tipoLayoutBuscador)
    {
        this.tipoLayoutBuscador = tipoLayoutBuscador;
    }

    /**
     * 
     */
    public java.lang.String getTipoLayoutBuscador()
    {
        return this.tipoLayoutBuscador;
    }
    
    public java.lang.Object[] getTipoLayoutBuscadorBackingList()
    {
        java.lang.Object[] values = this.tipoLayoutBuscadorValueList;
        java.lang.Object[] labels = this.tipoLayoutBuscadorLabelList;

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

    public java.lang.Object[] getTipoLayoutBuscadorValueList()
    {
        return this.tipoLayoutBuscadorValueList;
    }

    public void setTipoLayoutBuscadorValueList(java.lang.Object[] tipoLayoutBuscadorValueList)
    {
        this.tipoLayoutBuscadorValueList = tipoLayoutBuscadorValueList;
    }

    public java.lang.Object[] getTipoLayoutBuscadorLabelList()
    {
        return this.tipoLayoutBuscadorLabelList;
    }

    public void setTipoLayoutBuscadorLabelList(java.lang.Object[] tipoLayoutBuscadorLabelList)
    {
        this.tipoLayoutBuscadorLabelList = tipoLayoutBuscadorLabelList;
    }

    public void setTipoLayoutBuscadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDetalleODEPrevisualizarFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
        }

        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;

        if (items != null)
        {
            this.tipoLayoutBuscadorValueList = new java.lang.Object[items.size()];
            this.tipoLayoutBuscadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoLayoutBuscadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoLayoutBuscadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDetalleODEPrevisualizarFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEPrevisualizarFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEPrevisualizarFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
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
     * <p>
     * El idioma de busqueda es un select en la parte de buscador.
     * </p>
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
            throw new IllegalArgumentException("MostrarDetalleODEPrevisualizarFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEPrevisualizarFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
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

    public void setTitulo(java.lang.String titulo)
    {
        this.titulo = titulo;
    }

    /**
     * 
     */
    public java.lang.String getTitulo()
    {
        return this.titulo;
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
            throw new IllegalArgumentException("MostrarDetalleODEPrevisualizarFormImpl.setTituloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEPrevisualizarFormImpl.setTituloBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>mostrarVuelta</code>.
     */
    public void resetMostrarVuelta()
    {
        this.mostrarVuelta = null;
    }

    public void setMostrarVuelta(java.lang.Boolean mostrarVuelta)
    {
        this.mostrarVuelta = mostrarVuelta;
    }

    /**
     * 
     */
    public java.lang.Boolean getMostrarVuelta()
    {
        return this.mostrarVuelta;
    }
    
    public java.lang.Object[] getMostrarVueltaBackingList()
    {
        java.lang.Object[] values = this.mostrarVueltaValueList;
        java.lang.Object[] labels = this.mostrarVueltaLabelList;

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

    public java.lang.Object[] getMostrarVueltaValueList()
    {
        return this.mostrarVueltaValueList;
    }

    public void setMostrarVueltaValueList(java.lang.Object[] mostrarVueltaValueList)
    {
        this.mostrarVueltaValueList = mostrarVueltaValueList;
    }

    public java.lang.Object[] getMostrarVueltaLabelList()
    {
        return this.mostrarVueltaLabelList;
    }

    public void setMostrarVueltaLabelList(java.lang.Object[] mostrarVueltaLabelList)
    {
        this.mostrarVueltaLabelList = mostrarVueltaLabelList;
    }

    public void setMostrarVueltaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDetalleODEPrevisualizarFormImpl.setMostrarVueltaBackingList requires non-null property arguments");
        }

        this.mostrarVueltaValueList = null;
        this.mostrarVueltaLabelList = null;

        if (items != null)
        {
            this.mostrarVueltaValueList = new java.lang.Object[items.size()];
            this.mostrarVueltaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mostrarVueltaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mostrarVueltaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDetalleODEPrevisualizarFormImpl.setMostrarVueltaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idUsuario</code>.
     */
    public void resetIdUsuario()
    {
        this.idUsuario = null;
    }

    public void setIdUsuario(java.lang.String idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    /**
     * 
     */
    public java.lang.String getIdUsuario()
    {
        return this.idUsuario;
    }
    
    public java.lang.Object[] getIdUsuarioBackingList()
    {
        java.lang.Object[] values = this.idUsuarioValueList;
        java.lang.Object[] labels = this.idUsuarioLabelList;

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

    public java.lang.Object[] getIdUsuarioValueList()
    {
        return this.idUsuarioValueList;
    }

    public void setIdUsuarioValueList(java.lang.Object[] idUsuarioValueList)
    {
        this.idUsuarioValueList = idUsuarioValueList;
    }

    public java.lang.Object[] getIdUsuarioLabelList()
    {
        return this.idUsuarioLabelList;
    }

    public void setIdUsuarioLabelList(java.lang.Object[] idUsuarioLabelList)
    {
        this.idUsuarioLabelList = idUsuarioLabelList;
    }

    public void setIdUsuarioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDetalleODEPrevisualizarFormImpl.setIdUsuarioBackingList requires non-null property arguments");
        }

        this.idUsuarioValueList = null;
        this.idUsuarioLabelList = null;

        if (items != null)
        {
            this.idUsuarioValueList = new java.lang.Object[items.size()];
            this.idUsuarioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idUsuarioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idUsuarioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDetalleODEPrevisualizarFormImpl.setIdUsuarioBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoVisualizador</code>.
     */
    public void resetTipoVisualizador()
    {
        this.tipoVisualizador = null;
    }

    public void setTipoVisualizador(java.lang.String tipoVisualizador)
    {
        this.tipoVisualizador = tipoVisualizador;
    }

    /**
     * 
     */
    public java.lang.String getTipoVisualizador()
    {
        return this.tipoVisualizador;
    }
    
    public java.lang.Object[] getTipoVisualizadorBackingList()
    {
        java.lang.Object[] values = this.tipoVisualizadorValueList;
        java.lang.Object[] labels = this.tipoVisualizadorLabelList;

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

    public java.lang.Object[] getTipoVisualizadorValueList()
    {
        return this.tipoVisualizadorValueList;
    }

    public void setTipoVisualizadorValueList(java.lang.Object[] tipoVisualizadorValueList)
    {
        this.tipoVisualizadorValueList = tipoVisualizadorValueList;
    }

    public java.lang.Object[] getTipoVisualizadorLabelList()
    {
        return this.tipoVisualizadorLabelList;
    }

    public void setTipoVisualizadorLabelList(java.lang.Object[] tipoVisualizadorLabelList)
    {
        this.tipoVisualizadorLabelList = tipoVisualizadorLabelList;
    }

    public void setTipoVisualizadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDetalleODEPrevisualizarFormImpl.setTipoVisualizadorBackingList requires non-null property arguments");
        }

        this.tipoVisualizadorValueList = null;
        this.tipoVisualizadorLabelList = null;

        if (items != null)
        {
            this.tipoVisualizadorValueList = new java.lang.Object[items.size()];
            this.tipoVisualizadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoVisualizadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoVisualizadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDetalleODEPrevisualizarFormImpl.setTipoVisualizadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>localizadorODE</code>.
     */
    public void resetLocalizadorODE()
    {
        this.localizadorODE = null;
    }

    public void setLocalizadorODE(java.lang.String localizadorODE)
    {
        this.localizadorODE = localizadorODE;
    }

    /**
     * 
     */
    public java.lang.String getLocalizadorODE()
    {
        return this.localizadorODE;
    }
    
    public java.lang.Object[] getLocalizadorODEBackingList()
    {
        java.lang.Object[] values = this.localizadorODEValueList;
        java.lang.Object[] labels = this.localizadorODELabelList;

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

    public java.lang.Object[] getLocalizadorODEValueList()
    {
        return this.localizadorODEValueList;
    }

    public void setLocalizadorODEValueList(java.lang.Object[] localizadorODEValueList)
    {
        this.localizadorODEValueList = localizadorODEValueList;
    }

    public java.lang.Object[] getLocalizadorODELabelList()
    {
        return this.localizadorODELabelList;
    }

    public void setLocalizadorODELabelList(java.lang.Object[] localizadorODELabelList)
    {
        this.localizadorODELabelList = localizadorODELabelList;
    }

    public void setLocalizadorODEBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDetalleODEPrevisualizarFormImpl.setLocalizadorODEBackingList requires non-null property arguments");
        }

        this.localizadorODEValueList = null;
        this.localizadorODELabelList = null;

        if (items != null)
        {
            this.localizadorODEValueList = new java.lang.Object[items.size()];
            this.localizadorODELabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.localizadorODEValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.localizadorODELabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDetalleODEPrevisualizarFormImpl.setLocalizadorODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificadorODE</code>.
     */
    public void resetIdentificadorODE()
    {
        this.identificadorODE = null;
    }

    public void setIdentificadorODE(java.lang.String identificadorODE)
    {
        this.identificadorODE = identificadorODE;
    }

    /**
     * <p>
     * Identificador alfanumerico del ODE.
     * </p>
     */
    public java.lang.String getIdentificadorODE()
    {
        return this.identificadorODE;
    }
    
    public java.lang.Object[] getIdentificadorODEBackingList()
    {
        java.lang.Object[] values = this.identificadorODEValueList;
        java.lang.Object[] labels = this.identificadorODELabelList;

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

    public java.lang.Object[] getIdentificadorODEValueList()
    {
        return this.identificadorODEValueList;
    }

    public void setIdentificadorODEValueList(java.lang.Object[] identificadorODEValueList)
    {
        this.identificadorODEValueList = identificadorODEValueList;
    }

    public java.lang.Object[] getIdentificadorODELabelList()
    {
        return this.identificadorODELabelList;
    }

    public void setIdentificadorODELabelList(java.lang.Object[] identificadorODELabelList)
    {
        this.identificadorODELabelList = identificadorODELabelList;
    }

    public void setIdentificadorODEBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDetalleODEPrevisualizarFormImpl.setIdentificadorODEBackingList requires non-null property arguments");
        }

        this.identificadorODEValueList = null;
        this.identificadorODELabelList = null;

        if (items != null)
        {
            this.identificadorODEValueList = new java.lang.Object[items.size()];
            this.identificadorODELabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadorODEValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadorODELabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDetalleODEPrevisualizarFormImpl.setIdentificadorODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>seleccionarSecuencia</code>.
     */
    public void resetSeleccionarSecuencia()
    {
        this.seleccionarSecuencia = null;
    }

    public void setSeleccionarSecuencia(java.lang.Boolean seleccionarSecuencia)
    {
        this.seleccionarSecuencia = seleccionarSecuencia;
    }

    /**
     * 
     */
    public java.lang.Boolean getSeleccionarSecuencia()
    {
        return this.seleccionarSecuencia;
    }
    
    public java.lang.Object[] getSeleccionarSecuenciaBackingList()
    {
        java.lang.Object[] values = this.seleccionarSecuenciaValueList;
        java.lang.Object[] labels = this.seleccionarSecuenciaLabelList;

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

    public java.lang.Object[] getSeleccionarSecuenciaValueList()
    {
        return this.seleccionarSecuenciaValueList;
    }

    public void setSeleccionarSecuenciaValueList(java.lang.Object[] seleccionarSecuenciaValueList)
    {
        this.seleccionarSecuenciaValueList = seleccionarSecuenciaValueList;
    }

    public java.lang.Object[] getSeleccionarSecuenciaLabelList()
    {
        return this.seleccionarSecuenciaLabelList;
    }

    public void setSeleccionarSecuenciaLabelList(java.lang.Object[] seleccionarSecuenciaLabelList)
    {
        this.seleccionarSecuenciaLabelList = seleccionarSecuenciaLabelList;
    }

    public void setSeleccionarSecuenciaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarDetalleODEPrevisualizarFormImpl.setSeleccionarSecuenciaBackingList requires non-null property arguments");
        }

        this.seleccionarSecuenciaValueList = null;
        this.seleccionarSecuenciaLabelList = null;

        if (items != null)
        {
            this.seleccionarSecuenciaValueList = new java.lang.Object[items.size()];
            this.seleccionarSecuenciaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.seleccionarSecuenciaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.seleccionarSecuenciaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarDetalleODEPrevisualizarFormImpl.setSeleccionarSecuenciaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.idiomaBuscador = null;
        this.mostrarVuelta = null;
        this.seleccionarSecuencia = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("idLocalizador", this.idLocalizador);
        builder.append("busquedaSimpleAvanzada", this.busquedaSimpleAvanzada);
        builder.append("idioma", this.idioma);
        builder.append("localzadorODE", this.localzadorODE);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        builder.append("titulo", this.titulo);
        builder.append("mostrarVuelta", this.mostrarVuelta);
        builder.append("idUsuario", this.idUsuario);
        builder.append("tipoVisualizador", this.tipoVisualizador);
        builder.append("localizadorODE", this.localizadorODE);
        builder.append("identificadorODE", this.identificadorODE);
        builder.append("seleccionarSecuencia", this.seleccionarSecuencia);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.idLocalizador = null;
        this.idLocalizadorValueList = null;
        this.idLocalizadorLabelList = null;
        this.busquedaSimpleAvanzada = null;
        this.busquedaSimpleAvanzadaValueList = null;
        this.busquedaSimpleAvanzadaLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.localzadorODE = null;
        this.localzadorODEValueList = null;
        this.localzadorODELabelList = null;
        this.tipoLayoutBuscador = null;
        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.mostrarVuelta = null;
        this.mostrarVueltaValueList = null;
        this.mostrarVueltaLabelList = null;
        this.idUsuario = null;
        this.idUsuarioValueList = null;
        this.idUsuarioLabelList = null;
        this.tipoVisualizador = null;
        this.tipoVisualizadorValueList = null;
        this.tipoVisualizadorLabelList = null;
        this.localizadorODE = null;
        this.localizadorODEValueList = null;
        this.localizadorODELabelList = null;
        this.identificadorODE = null;
        this.identificadorODEValueList = null;
        this.identificadorODELabelList = null;
        this.seleccionarSecuencia = null;
        this.seleccionarSecuenciaValueList = null;
        this.seleccionarSecuenciaLabelList = null;
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
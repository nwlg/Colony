// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

public class MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.buscador.presentacion.avanzado.buscarAvanzado.GuardarBusquedaEnSesionForm
{
    private java.lang.String nomTesauros;
    private java.lang.Object[] nomTesaurosValueList;
    private java.lang.Object[] nomTesaurosLabelList;
    private java.lang.String buscadorContenido;
    private java.lang.Object[] buscadorContenidoValueList;
    private java.lang.Object[] buscadorContenidoLabelList;
    private java.lang.String tipoVisualizacion;
    private java.lang.Object[] tipoVisualizacionValueList;
    private java.lang.Object[] tipoVisualizacionLabelList;
    private java.lang.String tipoLayoutBuscador;
    private java.lang.Object[] tipoLayoutBuscadorValueList;
    private java.lang.Object[] tipoLayoutBuscadorLabelList;
    private java.lang.String formato;
    private java.lang.Object[] formatoValueList;
    private java.lang.Object[] formatoLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.String idTesauro;
    private java.lang.Object[] idTesauroValueList;
    private java.lang.Object[] idTesauroLabelList;
    private java.lang.String anyoPublicacion;
    private java.lang.Object[] anyoPublicacionValueList;
    private java.lang.Object[] anyoPublicacionLabelList;
    private java.lang.String areaCurricular;
    private java.lang.Object[] areaCurricularValueList;
    private java.lang.Object[] areaCurricularLabelList;
    private java.lang.String valoracion;
    private java.lang.Object[] valoracionValueList;
    private java.lang.Object[] valoracionLabelList;
    private java.lang.String pagina;
    private java.lang.Object[] paginaValueList;
    private java.lang.Object[] paginaLabelList;
    private java.lang.String[] comunidadesSeleccionadas;
    private java.lang.Object[] comunidadesSeleccionadasValueList;
    private java.lang.Object[] comunidadesSeleccionadasLabelList;
    private java.lang.String edad;
    private java.lang.Object[] edadValueList;
    private java.lang.Object[] edadLabelList;
    private java.lang.String nodoDestino;
    private java.lang.Object[] nodoDestinoValueList;
    private java.lang.Object[] nodoDestinoLabelList;
    private java.lang.String identificadorODE;
    private java.lang.Object[] identificadorODEValueList;
    private java.lang.Object[] identificadorODELabelList;
    private java.lang.String c_s_secuencia;
    private java.lang.Object[] c_s_secuenciaValueList;
    private java.lang.Object[] c_s_secuenciaLabelList;
    private java.lang.String enlaceComunidadesSeleccionadas;
    private java.lang.Object[] enlaceComunidadesSeleccionadasValueList;
    private java.lang.Object[] enlaceComunidadesSeleccionadasLabelList;
    private java.lang.String recurso;
    private java.lang.Object[] recursoValueList;
    private java.lang.Object[] recursoLabelList;
    private java.lang.String diaPublicacion;
    private java.lang.Object[] diaPublicacionValueList;
    private java.lang.Object[] diaPublicacionLabelList;
    private java.lang.String contexto;
    private java.lang.Object[] contextoValueList;
    private java.lang.Object[] contextoLabelList;
    private java.lang.String idTesauroSugerencia;
    private java.lang.Object[] idTesauroSugerenciaValueList;
    private java.lang.Object[] idTesauroSugerenciaLabelList;
    private java.lang.String busquedaSimpleAvanzada;
    private java.lang.Object[] busquedaSimpleAvanzadaValueList;
    private java.lang.Object[] busquedaSimpleAvanzadaLabelList;
    private java.lang.String autor;
    private java.lang.Object[] autorValueList;
    private java.lang.Object[] autorLabelList;
    private java.lang.String destinatarios;
    private java.lang.Object[] destinatariosValueList;
    private java.lang.Object[] destinatariosLabelList;
    private java.lang.String listaIds;
    private java.lang.Object[] listaIdsValueList;
    private java.lang.Object[] listaIdsLabelList;
    private java.lang.String keyword;
    private java.lang.Object[] keywordValueList;
    private java.lang.Object[] keywordLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.lang.String nivelAgregacion;
    private java.lang.Object[] nivelAgregacionValueList;
    private java.lang.Object[] nivelAgregacionLabelList;
    private java.lang.String procesoCognitivo;
    private java.lang.Object[] procesoCognitivoValueList;
    private java.lang.Object[] procesoCognitivoLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private java.lang.String enlaceTodoAgrega;
    private java.lang.Object[] enlaceTodoAgregaValueList;
    private java.lang.Object[] enlaceTodoAgregaLabelList;
    private java.lang.String numeroResultados;
    private java.lang.Object[] numeroResultadosValueList;
    private java.lang.Object[] numeroResultadosLabelList;
    private java.lang.String mesPublicacion;
    private java.lang.Object[] mesPublicacionValueList;
    private java.lang.Object[] mesPublicacionLabelList;


    //24/11/2010    Fernando Garcia
    //              Adding sorting method
    private  java.lang.String sortingMethod;

    public MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl()
    {
    }

    /**
     * Resets the given <code>nomTesauros</code>.
     */
    public void resetNomTesauros()
    {
        this.nomTesauros = null;
    }

    public void setNomTesauros(java.lang.String nomTesauros)
    {
        this.nomTesauros = nomTesauros;
    }

    /**
     * 
     */
    public java.lang.String getNomTesauros()
    {
        return this.nomTesauros;
    }
    
    public java.lang.Object[] getNomTesaurosBackingList()
    {
        java.lang.Object[] values = this.nomTesaurosValueList;
        java.lang.Object[] labels = this.nomTesaurosLabelList;

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

    public java.lang.Object[] getNomTesaurosValueList()
    {
        return this.nomTesaurosValueList;
    }

    public void setNomTesaurosValueList(java.lang.Object[] nomTesaurosValueList)
    {
        this.nomTesaurosValueList = nomTesaurosValueList;
    }

    public java.lang.Object[] getNomTesaurosLabelList()
    {
        return this.nomTesaurosLabelList;
    }

    public void setNomTesaurosLabelList(java.lang.Object[] nomTesaurosLabelList)
    {
        this.nomTesaurosLabelList = nomTesaurosLabelList;
    }

    public void setNomTesaurosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setNomTesaurosBackingList requires non-null property arguments");
        }

        this.nomTesaurosValueList = null;
        this.nomTesaurosLabelList = null;

        if (items != null)
        {
            this.nomTesaurosValueList = new java.lang.Object[items.size()];
            this.nomTesaurosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nomTesaurosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nomTesaurosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setNomTesaurosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>buscadorContenido</code>.
     */
    public void resetBuscadorContenido()
    {
        this.buscadorContenido = null;
    }

    public void setBuscadorContenido(java.lang.String buscadorContenido)
    {
        this.buscadorContenido = buscadorContenido;
    }

    /**
     * 
     */
    public java.lang.String getBuscadorContenido()
    {
        return this.buscadorContenido;
    }
    
    public java.lang.Object[] getBuscadorContenidoBackingList()
    {
        java.lang.Object[] values = this.buscadorContenidoValueList;
        java.lang.Object[] labels = this.buscadorContenidoLabelList;

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

    public java.lang.Object[] getBuscadorContenidoValueList()
    {
        return this.buscadorContenidoValueList;
    }

    public void setBuscadorContenidoValueList(java.lang.Object[] buscadorContenidoValueList)
    {
        this.buscadorContenidoValueList = buscadorContenidoValueList;
    }

    public java.lang.Object[] getBuscadorContenidoLabelList()
    {
        return this.buscadorContenidoLabelList;
    }

    public void setBuscadorContenidoLabelList(java.lang.Object[] buscadorContenidoLabelList)
    {
        this.buscadorContenidoLabelList = buscadorContenidoLabelList;
    }

    public void setBuscadorContenidoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setBuscadorContenidoBackingList requires non-null property arguments");
        }

        this.buscadorContenidoValueList = null;
        this.buscadorContenidoLabelList = null;

        if (items != null)
        {
            this.buscadorContenidoValueList = new java.lang.Object[items.size()];
            this.buscadorContenidoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.buscadorContenidoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.buscadorContenidoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setBuscadorContenidoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoVisualizacion</code>.
     */
    public void resetTipoVisualizacion()
    {
        this.tipoVisualizacion = null;
    }

    public void setTipoVisualizacion(java.lang.String tipoVisualizacion)
    {
        this.tipoVisualizacion = tipoVisualizacion;
    }

    /**
     * 
     */
    public java.lang.String getTipoVisualizacion()
    {
        return this.tipoVisualizacion;
    }
    
    public java.lang.Object[] getTipoVisualizacionBackingList()
    {
        java.lang.Object[] values = this.tipoVisualizacionValueList;
        java.lang.Object[] labels = this.tipoVisualizacionLabelList;

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

    public java.lang.Object[] getTipoVisualizacionValueList()
    {
        return this.tipoVisualizacionValueList;
    }

    public void setTipoVisualizacionValueList(java.lang.Object[] tipoVisualizacionValueList)
    {
        this.tipoVisualizacionValueList = tipoVisualizacionValueList;
    }

    public java.lang.Object[] getTipoVisualizacionLabelList()
    {
        return this.tipoVisualizacionLabelList;
    }

    public void setTipoVisualizacionLabelList(java.lang.Object[] tipoVisualizacionLabelList)
    {
        this.tipoVisualizacionLabelList = tipoVisualizacionLabelList;
    }

    public void setTipoVisualizacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setTipoVisualizacionBackingList requires non-null property arguments");
        }

        this.tipoVisualizacionValueList = null;
        this.tipoVisualizacionLabelList = null;

        if (items != null)
        {
            this.tipoVisualizacionValueList = new java.lang.Object[items.size()];
            this.tipoVisualizacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoVisualizacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoVisualizacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setTipoVisualizacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setFormatoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setFormatoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idTesauro</code>.
     */
    public void resetIdTesauro()
    {
        this.idTesauro = null;
    }

    public void setIdTesauro(java.lang.String idTesauro)
    {
        this.idTesauro = idTesauro;
    }

    /**
     * 
     */
    public java.lang.String getIdTesauro()
    {
        return this.idTesauro;
    }
    
    public java.lang.Object[] getIdTesauroBackingList()
    {
        java.lang.Object[] values = this.idTesauroValueList;
        java.lang.Object[] labels = this.idTesauroLabelList;

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

    public java.lang.Object[] getIdTesauroValueList()
    {
        return this.idTesauroValueList;
    }

    public void setIdTesauroValueList(java.lang.Object[] idTesauroValueList)
    {
        this.idTesauroValueList = idTesauroValueList;
    }

    public java.lang.Object[] getIdTesauroLabelList()
    {
        return this.idTesauroLabelList;
    }

    public void setIdTesauroLabelList(java.lang.Object[] idTesauroLabelList)
    {
        this.idTesauroLabelList = idTesauroLabelList;
    }

    public void setIdTesauroBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setIdTesauroBackingList requires non-null property arguments");
        }

        this.idTesauroValueList = null;
        this.idTesauroLabelList = null;

        if (items != null)
        {
            this.idTesauroValueList = new java.lang.Object[items.size()];
            this.idTesauroLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idTesauroValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idTesauroLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setIdTesauroBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>anyoPublicacion</code>.
     */
    public void resetAnyoPublicacion()
    {
        this.anyoPublicacion = null;
    }

    public void setAnyoPublicacion(java.lang.String anyoPublicacion)
    {
        this.anyoPublicacion = anyoPublicacion;
    }

    /**
     * 
     */
    public java.lang.String getAnyoPublicacion()
    {
        return this.anyoPublicacion;
    }
    
    public java.lang.Object[] getAnyoPublicacionBackingList()
    {
        java.lang.Object[] values = this.anyoPublicacionValueList;
        java.lang.Object[] labels = this.anyoPublicacionLabelList;

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

    public java.lang.Object[] getAnyoPublicacionValueList()
    {
        return this.anyoPublicacionValueList;
    }

    public void setAnyoPublicacionValueList(java.lang.Object[] anyoPublicacionValueList)
    {
        this.anyoPublicacionValueList = anyoPublicacionValueList;
    }

    public java.lang.Object[] getAnyoPublicacionLabelList()
    {
        return this.anyoPublicacionLabelList;
    }

    public void setAnyoPublicacionLabelList(java.lang.Object[] anyoPublicacionLabelList)
    {
        this.anyoPublicacionLabelList = anyoPublicacionLabelList;
    }

    public void setAnyoPublicacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setAnyoPublicacionBackingList requires non-null property arguments");
        }

        this.anyoPublicacionValueList = null;
        this.anyoPublicacionLabelList = null;

        if (items != null)
        {
            this.anyoPublicacionValueList = new java.lang.Object[items.size()];
            this.anyoPublicacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.anyoPublicacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.anyoPublicacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setAnyoPublicacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>areaCurricular</code>.
     */
    public void resetAreaCurricular()
    {
        this.areaCurricular = null;
    }

    public void setAreaCurricular(java.lang.String areaCurricular)
    {
        this.areaCurricular = areaCurricular;
    }

    /**
     * 
     */
    public java.lang.String getAreaCurricular()
    {
        return this.areaCurricular;
    }
    
    public java.lang.Object[] getAreaCurricularBackingList()
    {
        java.lang.Object[] values = this.areaCurricularValueList;
        java.lang.Object[] labels = this.areaCurricularLabelList;

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

    public java.lang.Object[] getAreaCurricularValueList()
    {
        return this.areaCurricularValueList;
    }

    public void setAreaCurricularValueList(java.lang.Object[] areaCurricularValueList)
    {
        this.areaCurricularValueList = areaCurricularValueList;
    }

    public java.lang.Object[] getAreaCurricularLabelList()
    {
        return this.areaCurricularLabelList;
    }

    public void setAreaCurricularLabelList(java.lang.Object[] areaCurricularLabelList)
    {
        this.areaCurricularLabelList = areaCurricularLabelList;
    }

    public void setAreaCurricularBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setAreaCurricularBackingList requires non-null property arguments");
        }

        this.areaCurricularValueList = null;
        this.areaCurricularLabelList = null;

        if (items != null)
        {
            this.areaCurricularValueList = new java.lang.Object[items.size()];
            this.areaCurricularLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.areaCurricularValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.areaCurricularLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setAreaCurricularBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>valoracion</code>.
     */
    public void resetValoracion()
    {
        this.valoracion = null;
    }

    public void setValoracion(java.lang.String valoracion)
    {
        this.valoracion = valoracion;
    }

    /**
     * 
     */
    public java.lang.String getValoracion()
    {
        return this.valoracion;
    }
    
    public java.lang.Object[] getValoracionBackingList()
    {
        java.lang.Object[] values = this.valoracionValueList;
        java.lang.Object[] labels = this.valoracionLabelList;

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

    public java.lang.Object[] getValoracionValueList()
    {
        return this.valoracionValueList;
    }

    public void setValoracionValueList(java.lang.Object[] valoracionValueList)
    {
        this.valoracionValueList = valoracionValueList;
    }

    public java.lang.Object[] getValoracionLabelList()
    {
        return this.valoracionLabelList;
    }

    public void setValoracionLabelList(java.lang.Object[] valoracionLabelList)
    {
        this.valoracionLabelList = valoracionLabelList;
    }

    public void setValoracionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setValoracionBackingList requires non-null property arguments");
        }

        this.valoracionValueList = null;
        this.valoracionLabelList = null;

        if (items != null)
        {
            this.valoracionValueList = new java.lang.Object[items.size()];
            this.valoracionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.valoracionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.valoracionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setValoracionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>pagina</code>.
     */
    public void resetPagina()
    {
        this.pagina = null;
    }

    public void setPagina(java.lang.String pagina)
    {
        this.pagina = pagina;
    }

    /**
     * 
     */
    public java.lang.String getPagina()
    {
        return this.pagina;
    }
    
    public java.lang.Object[] getPaginaBackingList()
    {
        java.lang.Object[] values = this.paginaValueList;
        java.lang.Object[] labels = this.paginaLabelList;

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

    public java.lang.Object[] getPaginaValueList()
    {
        return this.paginaValueList;
    }

    public void setPaginaValueList(java.lang.Object[] paginaValueList)
    {
        this.paginaValueList = paginaValueList;
    }

    public java.lang.Object[] getPaginaLabelList()
    {
        return this.paginaLabelList;
    }

    public void setPaginaLabelList(java.lang.Object[] paginaLabelList)
    {
        this.paginaLabelList = paginaLabelList;
    }

    public void setPaginaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setPaginaBackingList requires non-null property arguments");
        }

        this.paginaValueList = null;
        this.paginaLabelList = null;

        if (items != null)
        {
            this.paginaValueList = new java.lang.Object[items.size()];
            this.paginaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.paginaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.paginaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setPaginaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comunidadesSeleccionadas</code>.
     */
    public void resetComunidadesSeleccionadas()
    {
        this.comunidadesSeleccionadas = null;
    }

    public void setComunidadesSeleccionadas(java.lang.String[] comunidadesSeleccionadas)
    {
        this.comunidadesSeleccionadas = comunidadesSeleccionadas;
    }

    /**
     * 
     */
    public java.lang.String[] getComunidadesSeleccionadas()
    {
        return this.comunidadesSeleccionadas;
    }
    
    public java.lang.Object[] getComunidadesSeleccionadasBackingList()
    {
        java.lang.Object[] values = this.comunidadesSeleccionadasValueList;
        java.lang.Object[] labels = this.comunidadesSeleccionadasLabelList;

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

    public java.lang.Object[] getComunidadesSeleccionadasValueList()
    {
        return this.comunidadesSeleccionadasValueList;
    }

    public void setComunidadesSeleccionadasValueList(java.lang.Object[] comunidadesSeleccionadasValueList)
    {
        this.comunidadesSeleccionadasValueList = comunidadesSeleccionadasValueList;
    }

    public java.lang.Object[] getComunidadesSeleccionadasLabelList()
    {
        return this.comunidadesSeleccionadasLabelList;
    }

    public void setComunidadesSeleccionadasLabelList(java.lang.Object[] comunidadesSeleccionadasLabelList)
    {
        this.comunidadesSeleccionadasLabelList = comunidadesSeleccionadasLabelList;
    }

    public void setComunidadesSeleccionadasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setComunidadesSeleccionadasBackingList requires non-null property arguments");
        }

        this.comunidadesSeleccionadasValueList = null;
        this.comunidadesSeleccionadasLabelList = null;

        if (items != null)
        {
            this.comunidadesSeleccionadasValueList = new java.lang.Object[items.size()];
            this.comunidadesSeleccionadasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comunidadesSeleccionadasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comunidadesSeleccionadasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setComunidadesSeleccionadasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>edad</code>.
     */
    public void resetEdad()
    {
        this.edad = null;
    }

    public void setEdad(java.lang.String edad)
    {
        this.edad = edad;
    }

    /**
     * 
     */
    public java.lang.String getEdad()
    {
        return this.edad;
    }
    
    public java.lang.Object[] getEdadBackingList()
    {
        java.lang.Object[] values = this.edadValueList;
        java.lang.Object[] labels = this.edadLabelList;

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

    public java.lang.Object[] getEdadValueList()
    {
        return this.edadValueList;
    }

    public void setEdadValueList(java.lang.Object[] edadValueList)
    {
        this.edadValueList = edadValueList;
    }

    public java.lang.Object[] getEdadLabelList()
    {
        return this.edadLabelList;
    }

    public void setEdadLabelList(java.lang.Object[] edadLabelList)
    {
        this.edadLabelList = edadLabelList;
    }

    public void setEdadBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setEdadBackingList requires non-null property arguments");
        }

        this.edadValueList = null;
        this.edadLabelList = null;

        if (items != null)
        {
            this.edadValueList = new java.lang.Object[items.size()];
            this.edadLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.edadValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.edadLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setEdadBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nodoDestino</code>.
     */
    public void resetNodoDestino()
    {
        this.nodoDestino = null;
    }

    public void setNodoDestino(java.lang.String nodoDestino)
    {
        this.nodoDestino = nodoDestino;
    }

    /**
     * 
     */
    public java.lang.String getNodoDestino()
    {
        return this.nodoDestino;
    }
    
    public java.lang.Object[] getNodoDestinoBackingList()
    {
        java.lang.Object[] values = this.nodoDestinoValueList;
        java.lang.Object[] labels = this.nodoDestinoLabelList;

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

    public java.lang.Object[] getNodoDestinoValueList()
    {
        return this.nodoDestinoValueList;
    }

    public void setNodoDestinoValueList(java.lang.Object[] nodoDestinoValueList)
    {
        this.nodoDestinoValueList = nodoDestinoValueList;
    }

    public java.lang.Object[] getNodoDestinoLabelList()
    {
        return this.nodoDestinoLabelList;
    }

    public void setNodoDestinoLabelList(java.lang.Object[] nodoDestinoLabelList)
    {
        this.nodoDestinoLabelList = nodoDestinoLabelList;
    }

    public void setNodoDestinoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setNodoDestinoBackingList requires non-null property arguments");
        }

        this.nodoDestinoValueList = null;
        this.nodoDestinoLabelList = null;

        if (items != null)
        {
            this.nodoDestinoValueList = new java.lang.Object[items.size()];
            this.nodoDestinoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nodoDestinoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nodoDestinoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setNodoDestinoBackingList encountered an exception", ex);
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
     * 
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
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setIdentificadorODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setIdentificadorODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>c_s_secuencia</code>.
     */
    public void resetC_s_secuencia()
    {
        this.c_s_secuencia = null;
    }

    public void setC_s_secuencia(java.lang.String c_s_secuencia)
    {
        this.c_s_secuencia = c_s_secuencia;
    }

    /**
     * 
     */
    public java.lang.String getC_s_secuencia()
    {
        return this.c_s_secuencia;
    }
    
    public java.lang.Object[] getC_s_secuenciaBackingList()
    {
        java.lang.Object[] values = this.c_s_secuenciaValueList;
        java.lang.Object[] labels = this.c_s_secuenciaLabelList;

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

    public java.lang.Object[] getC_s_secuenciaValueList()
    {
        return this.c_s_secuenciaValueList;
    }

    public void setC_s_secuenciaValueList(java.lang.Object[] c_s_secuenciaValueList)
    {
        this.c_s_secuenciaValueList = c_s_secuenciaValueList;
    }

    public java.lang.Object[] getC_s_secuenciaLabelList()
    {
        return this.c_s_secuenciaLabelList;
    }

    public void setC_s_secuenciaLabelList(java.lang.Object[] c_s_secuenciaLabelList)
    {
        this.c_s_secuenciaLabelList = c_s_secuenciaLabelList;
    }

    public void setC_s_secuenciaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setC_s_secuenciaBackingList requires non-null property arguments");
        }

        this.c_s_secuenciaValueList = null;
        this.c_s_secuenciaLabelList = null;

        if (items != null)
        {
            this.c_s_secuenciaValueList = new java.lang.Object[items.size()];
            this.c_s_secuenciaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.c_s_secuenciaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.c_s_secuenciaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setC_s_secuenciaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>enlaceComunidadesSeleccionadas</code>.
     */
    public void resetEnlaceComunidadesSeleccionadas()
    {
        this.enlaceComunidadesSeleccionadas = null;
    }

    public void setEnlaceComunidadesSeleccionadas(java.lang.String enlaceComunidadesSeleccionadas)
    {
        this.enlaceComunidadesSeleccionadas = enlaceComunidadesSeleccionadas;
    }

    /**
     * 
     */
    public java.lang.String getEnlaceComunidadesSeleccionadas()
    {
        return this.enlaceComunidadesSeleccionadas;
    }
    
    public java.lang.Object[] getEnlaceComunidadesSeleccionadasBackingList()
    {
        java.lang.Object[] values = this.enlaceComunidadesSeleccionadasValueList;
        java.lang.Object[] labels = this.enlaceComunidadesSeleccionadasLabelList;

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

    public java.lang.Object[] getEnlaceComunidadesSeleccionadasValueList()
    {
        return this.enlaceComunidadesSeleccionadasValueList;
    }

    public void setEnlaceComunidadesSeleccionadasValueList(java.lang.Object[] enlaceComunidadesSeleccionadasValueList)
    {
        this.enlaceComunidadesSeleccionadasValueList = enlaceComunidadesSeleccionadasValueList;
    }

    public java.lang.Object[] getEnlaceComunidadesSeleccionadasLabelList()
    {
        return this.enlaceComunidadesSeleccionadasLabelList;
    }

    public void setEnlaceComunidadesSeleccionadasLabelList(java.lang.Object[] enlaceComunidadesSeleccionadasLabelList)
    {
        this.enlaceComunidadesSeleccionadasLabelList = enlaceComunidadesSeleccionadasLabelList;
    }

    public void setEnlaceComunidadesSeleccionadasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setEnlaceComunidadesSeleccionadasBackingList requires non-null property arguments");
        }

        this.enlaceComunidadesSeleccionadasValueList = null;
        this.enlaceComunidadesSeleccionadasLabelList = null;

        if (items != null)
        {
            this.enlaceComunidadesSeleccionadasValueList = new java.lang.Object[items.size()];
            this.enlaceComunidadesSeleccionadasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.enlaceComunidadesSeleccionadasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.enlaceComunidadesSeleccionadasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setEnlaceComunidadesSeleccionadasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>recurso</code>.
     */
    public void resetRecurso()
    {
        this.recurso = null;
    }

    public void setRecurso(java.lang.String recurso)
    {
        this.recurso = recurso;
    }

    /**
     * 
     */
    public java.lang.String getRecurso()
    {
        return this.recurso;
    }
    
    public java.lang.Object[] getRecursoBackingList()
    {
        java.lang.Object[] values = this.recursoValueList;
        java.lang.Object[] labels = this.recursoLabelList;

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

    public java.lang.Object[] getRecursoValueList()
    {
        return this.recursoValueList;
    }

    public void setRecursoValueList(java.lang.Object[] recursoValueList)
    {
        this.recursoValueList = recursoValueList;
    }

    public java.lang.Object[] getRecursoLabelList()
    {
        return this.recursoLabelList;
    }

    public void setRecursoLabelList(java.lang.Object[] recursoLabelList)
    {
        this.recursoLabelList = recursoLabelList;
    }

    public void setRecursoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setRecursoBackingList requires non-null property arguments");
        }

        this.recursoValueList = null;
        this.recursoLabelList = null;

        if (items != null)
        {
            this.recursoValueList = new java.lang.Object[items.size()];
            this.recursoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.recursoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.recursoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setRecursoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>diaPublicacion</code>.
     */
    public void resetDiaPublicacion()
    {
        this.diaPublicacion = null;
    }

    public void setDiaPublicacion(java.lang.String diaPublicacion)
    {
        this.diaPublicacion = diaPublicacion;
    }

    /**
     * 
     */
    public java.lang.String getDiaPublicacion()
    {
        return this.diaPublicacion;
    }
    
    public java.lang.Object[] getDiaPublicacionBackingList()
    {
        java.lang.Object[] values = this.diaPublicacionValueList;
        java.lang.Object[] labels = this.diaPublicacionLabelList;

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

    public java.lang.Object[] getDiaPublicacionValueList()
    {
        return this.diaPublicacionValueList;
    }

    public void setDiaPublicacionValueList(java.lang.Object[] diaPublicacionValueList)
    {
        this.diaPublicacionValueList = diaPublicacionValueList;
    }

    public java.lang.Object[] getDiaPublicacionLabelList()
    {
        return this.diaPublicacionLabelList;
    }

    public void setDiaPublicacionLabelList(java.lang.Object[] diaPublicacionLabelList)
    {
        this.diaPublicacionLabelList = diaPublicacionLabelList;
    }

    public void setDiaPublicacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setDiaPublicacionBackingList requires non-null property arguments");
        }

        this.diaPublicacionValueList = null;
        this.diaPublicacionLabelList = null;

        if (items != null)
        {
            this.diaPublicacionValueList = new java.lang.Object[items.size()];
            this.diaPublicacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.diaPublicacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.diaPublicacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setDiaPublicacionBackingList encountered an exception", ex);
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

    public void setContexto(java.lang.String contexto)
    {
        this.contexto = contexto;
    }

    /**
     * 
     */
    public java.lang.String getContexto()
    {
        return this.contexto;
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
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setContextoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setContextoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idTesauroSugerencia</code>.
     */
    public void resetIdTesauroSugerencia()
    {
        this.idTesauroSugerencia = null;
    }

    public void setIdTesauroSugerencia(java.lang.String idTesauroSugerencia)
    {
        this.idTesauroSugerencia = idTesauroSugerencia;
    }

    /**
     * <p>
     * Identificador de tesauro por el que se filtra despues de
     * seleccionarlo en las sugerencias de tesauro
     * </p>
     */
    public java.lang.String getIdTesauroSugerencia()
    {
        return this.idTesauroSugerencia;
    }
    
    public java.lang.Object[] getIdTesauroSugerenciaBackingList()
    {
        java.lang.Object[] values = this.idTesauroSugerenciaValueList;
        java.lang.Object[] labels = this.idTesauroSugerenciaLabelList;

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

    public java.lang.Object[] getIdTesauroSugerenciaValueList()
    {
        return this.idTesauroSugerenciaValueList;
    }

    public void setIdTesauroSugerenciaValueList(java.lang.Object[] idTesauroSugerenciaValueList)
    {
        this.idTesauroSugerenciaValueList = idTesauroSugerenciaValueList;
    }

    public java.lang.Object[] getIdTesauroSugerenciaLabelList()
    {
        return this.idTesauroSugerenciaLabelList;
    }

    public void setIdTesauroSugerenciaLabelList(java.lang.Object[] idTesauroSugerenciaLabelList)
    {
        this.idTesauroSugerenciaLabelList = idTesauroSugerenciaLabelList;
    }

    public void setIdTesauroSugerenciaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setIdTesauroSugerenciaBackingList requires non-null property arguments");
        }

        this.idTesauroSugerenciaValueList = null;
        this.idTesauroSugerenciaLabelList = null;

        if (items != null)
        {
            this.idTesauroSugerenciaValueList = new java.lang.Object[items.size()];
            this.idTesauroSugerenciaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idTesauroSugerenciaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idTesauroSugerenciaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setIdTesauroSugerenciaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setBusquedaSimpleAvanzadaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setBusquedaSimpleAvanzadaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>autor</code>.
     */
    public void resetAutor()
    {
        this.autor = null;
    }

    public void setAutor(java.lang.String autor)
    {
        this.autor = autor;
    }

    /**
     * 
     */
    public java.lang.String getAutor()
    {
        return this.autor;
    }
    
    public java.lang.Object[] getAutorBackingList()
    {
        java.lang.Object[] values = this.autorValueList;
        java.lang.Object[] labels = this.autorLabelList;

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

    public java.lang.Object[] getAutorValueList()
    {
        return this.autorValueList;
    }

    public void setAutorValueList(java.lang.Object[] autorValueList)
    {
        this.autorValueList = autorValueList;
    }

    public java.lang.Object[] getAutorLabelList()
    {
        return this.autorLabelList;
    }

    public void setAutorLabelList(java.lang.Object[] autorLabelList)
    {
        this.autorLabelList = autorLabelList;
    }

    public void setAutorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setAutorBackingList requires non-null property arguments");
        }

        this.autorValueList = null;
        this.autorLabelList = null;

        if (items != null)
        {
            this.autorValueList = new java.lang.Object[items.size()];
            this.autorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.autorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.autorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setAutorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>destinatarios</code>.
     */
    public void resetDestinatarios()
    {
        this.destinatarios = null;
    }

    public void setDestinatarios(java.lang.String destinatarios)
    {
        this.destinatarios = destinatarios;
    }

    /**
     * 
     */
    public java.lang.String getDestinatarios()
    {
        return this.destinatarios;
    }
    
    public java.lang.Object[] getDestinatariosBackingList()
    {
        java.lang.Object[] values = this.destinatariosValueList;
        java.lang.Object[] labels = this.destinatariosLabelList;

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

    public java.lang.Object[] getDestinatariosValueList()
    {
        return this.destinatariosValueList;
    }

    public void setDestinatariosValueList(java.lang.Object[] destinatariosValueList)
    {
        this.destinatariosValueList = destinatariosValueList;
    }

    public java.lang.Object[] getDestinatariosLabelList()
    {
        return this.destinatariosLabelList;
    }

    public void setDestinatariosLabelList(java.lang.Object[] destinatariosLabelList)
    {
        this.destinatariosLabelList = destinatariosLabelList;
    }

    public void setDestinatariosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setDestinatariosBackingList requires non-null property arguments");
        }

        this.destinatariosValueList = null;
        this.destinatariosLabelList = null;

        if (items != null)
        {
            this.destinatariosValueList = new java.lang.Object[items.size()];
            this.destinatariosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.destinatariosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.destinatariosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setDestinatariosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listaIds</code>.
     */
    public void resetListaIds()
    {
        this.listaIds = null;
    }

    public void setListaIds(java.lang.String listaIds)
    {
        this.listaIds = listaIds;
    }

    /**
     * 
     */
    public java.lang.String getListaIds()
    {
        return this.listaIds;
    }
    
    public java.lang.Object[] getListaIdsBackingList()
    {
        java.lang.Object[] values = this.listaIdsValueList;
        java.lang.Object[] labels = this.listaIdsLabelList;

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

    public java.lang.Object[] getListaIdsValueList()
    {
        return this.listaIdsValueList;
    }

    public void setListaIdsValueList(java.lang.Object[] listaIdsValueList)
    {
        this.listaIdsValueList = listaIdsValueList;
    }

    public java.lang.Object[] getListaIdsLabelList()
    {
        return this.listaIdsLabelList;
    }

    public void setListaIdsLabelList(java.lang.Object[] listaIdsLabelList)
    {
        this.listaIdsLabelList = listaIdsLabelList;
    }

    public void setListaIdsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setListaIdsBackingList requires non-null property arguments");
        }

        this.listaIdsValueList = null;
        this.listaIdsLabelList = null;

        if (items != null)
        {
            this.listaIdsValueList = new java.lang.Object[items.size()];
            this.listaIdsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listaIdsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listaIdsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setListaIdsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>keyword</code>.
     */
    public void resetKeyword()
    {
        this.keyword = null;
    }

    public void setKeyword(java.lang.String keyword)
    {
        this.keyword = keyword;
    }

    /**
     * 
     */
    public java.lang.String getKeyword()
    {
        return this.keyword;
    }
    
    public java.lang.Object[] getKeywordBackingList()
    {
        java.lang.Object[] values = this.keywordValueList;
        java.lang.Object[] labels = this.keywordLabelList;

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

    public java.lang.Object[] getKeywordValueList()
    {
        return this.keywordValueList;
    }

    public void setKeywordValueList(java.lang.Object[] keywordValueList)
    {
        this.keywordValueList = keywordValueList;
    }

    public java.lang.Object[] getKeywordLabelList()
    {
        return this.keywordLabelList;
    }

    public void setKeywordLabelList(java.lang.Object[] keywordLabelList)
    {
        this.keywordLabelList = keywordLabelList;
    }

    public void setKeywordBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setKeywordBackingList requires non-null property arguments");
        }

        this.keywordValueList = null;
        this.keywordLabelList = null;

        if (items != null)
        {
            this.keywordValueList = new java.lang.Object[items.size()];
            this.keywordLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.keywordValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.keywordLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setKeywordBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nivelAgregacion</code>.
     */
    public void resetNivelAgregacion()
    {
        this.nivelAgregacion = null;
    }

    public void setNivelAgregacion(java.lang.String nivelAgregacion)
    {
        this.nivelAgregacion = nivelAgregacion;
    }

    /**
     * 
     */
    public java.lang.String getNivelAgregacion()
    {
        return this.nivelAgregacion;
    }
    
    public java.lang.Object[] getNivelAgregacionBackingList()
    {
        java.lang.Object[] values = this.nivelAgregacionValueList;
        java.lang.Object[] labels = this.nivelAgregacionLabelList;

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

    public java.lang.Object[] getNivelAgregacionValueList()
    {
        return this.nivelAgregacionValueList;
    }

    public void setNivelAgregacionValueList(java.lang.Object[] nivelAgregacionValueList)
    {
        this.nivelAgregacionValueList = nivelAgregacionValueList;
    }

    public java.lang.Object[] getNivelAgregacionLabelList()
    {
        return this.nivelAgregacionLabelList;
    }

    public void setNivelAgregacionLabelList(java.lang.Object[] nivelAgregacionLabelList)
    {
        this.nivelAgregacionLabelList = nivelAgregacionLabelList;
    }

    public void setNivelAgregacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setNivelAgregacionBackingList requires non-null property arguments");
        }

        this.nivelAgregacionValueList = null;
        this.nivelAgregacionLabelList = null;

        if (items != null)
        {
            this.nivelAgregacionValueList = new java.lang.Object[items.size()];
            this.nivelAgregacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nivelAgregacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nivelAgregacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setNivelAgregacionBackingList encountered an exception", ex);
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

    public void setProcesoCognitivo(java.lang.String procesoCognitivo)
    {
        this.procesoCognitivo = procesoCognitivo;
    }

    /**
     * 
     */
    public java.lang.String getProcesoCognitivo()
    {
        return this.procesoCognitivo;
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
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setProcesoCognitivoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setProcesoCognitivoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>enlaceTodoAgrega</code>.
     */
    public void resetEnlaceTodoAgrega()
    {
        this.enlaceTodoAgrega = null;
    }

    public void setEnlaceTodoAgrega(java.lang.String enlaceTodoAgrega)
    {
        this.enlaceTodoAgrega = enlaceTodoAgrega;
    }

    /**
     * 
     */
    public java.lang.String getEnlaceTodoAgrega()
    {
        return this.enlaceTodoAgrega;
    }
    
    public java.lang.Object[] getEnlaceTodoAgregaBackingList()
    {
        java.lang.Object[] values = this.enlaceTodoAgregaValueList;
        java.lang.Object[] labels = this.enlaceTodoAgregaLabelList;

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

    public java.lang.Object[] getEnlaceTodoAgregaValueList()
    {
        return this.enlaceTodoAgregaValueList;
    }

    public void setEnlaceTodoAgregaValueList(java.lang.Object[] enlaceTodoAgregaValueList)
    {
        this.enlaceTodoAgregaValueList = enlaceTodoAgregaValueList;
    }

    public java.lang.Object[] getEnlaceTodoAgregaLabelList()
    {
        return this.enlaceTodoAgregaLabelList;
    }

    public void setEnlaceTodoAgregaLabelList(java.lang.Object[] enlaceTodoAgregaLabelList)
    {
        this.enlaceTodoAgregaLabelList = enlaceTodoAgregaLabelList;
    }

    public void setEnlaceTodoAgregaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setEnlaceTodoAgregaBackingList requires non-null property arguments");
        }

        this.enlaceTodoAgregaValueList = null;
        this.enlaceTodoAgregaLabelList = null;

        if (items != null)
        {
            this.enlaceTodoAgregaValueList = new java.lang.Object[items.size()];
            this.enlaceTodoAgregaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.enlaceTodoAgregaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.enlaceTodoAgregaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setEnlaceTodoAgregaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>numeroResultados</code>.
     */
    public void resetNumeroResultados()
    {
        this.numeroResultados = null;
    }

    public void setNumeroResultados(java.lang.String numeroResultados)
    {
        this.numeroResultados = numeroResultados;
    }

    /**
     * 
     */
    public java.lang.String getNumeroResultados()
    {
        return this.numeroResultados;
    }
    
    public java.lang.Object[] getNumeroResultadosBackingList()
    {
        java.lang.Object[] values = this.numeroResultadosValueList;
        java.lang.Object[] labels = this.numeroResultadosLabelList;

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

    public java.lang.Object[] getNumeroResultadosValueList()
    {
        return this.numeroResultadosValueList;
    }

    public void setNumeroResultadosValueList(java.lang.Object[] numeroResultadosValueList)
    {
        this.numeroResultadosValueList = numeroResultadosValueList;
    }

    public java.lang.Object[] getNumeroResultadosLabelList()
    {
        return this.numeroResultadosLabelList;
    }

    public void setNumeroResultadosLabelList(java.lang.Object[] numeroResultadosLabelList)
    {
        this.numeroResultadosLabelList = numeroResultadosLabelList;
    }

    public void setNumeroResultadosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setNumeroResultadosBackingList requires non-null property arguments");
        }

        this.numeroResultadosValueList = null;
        this.numeroResultadosLabelList = null;

        if (items != null)
        {
            this.numeroResultadosValueList = new java.lang.Object[items.size()];
            this.numeroResultadosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.numeroResultadosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.numeroResultadosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setNumeroResultadosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>mesPublicacion</code>.
     */
    public void resetMesPublicacion()
    {
        this.mesPublicacion = null;
    }

    public void setMesPublicacion(java.lang.String mesPublicacion)
    {
        this.mesPublicacion = mesPublicacion;
    }

    /**
     * 
     */
    public java.lang.String getMesPublicacion()
    {
        return this.mesPublicacion;
    }
    
    public java.lang.Object[] getMesPublicacionBackingList()
    {
        java.lang.Object[] values = this.mesPublicacionValueList;
        java.lang.Object[] labels = this.mesPublicacionLabelList;

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

    public java.lang.Object[] getMesPublicacionValueList()
    {
        return this.mesPublicacionValueList;
    }

    public void setMesPublicacionValueList(java.lang.Object[] mesPublicacionValueList)
    {
        this.mesPublicacionValueList = mesPublicacionValueList;
    }

    public java.lang.Object[] getMesPublicacionLabelList()
    {
        return this.mesPublicacionLabelList;
    }

    public void setMesPublicacionLabelList(java.lang.Object[] mesPublicacionLabelList)
    {
        this.mesPublicacionLabelList = mesPublicacionLabelList;
    }

    public void setMesPublicacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setMesPublicacionBackingList requires non-null property arguments");
        }

        this.mesPublicacionValueList = null;
        this.mesPublicacionLabelList = null;

        if (items != null)
        {
            this.mesPublicacionValueList = new java.lang.Object[items.size()];
            this.mesPublicacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mesPublicacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mesPublicacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesPrepararRetornoDetalleImagenesFormImpl.setMesPublicacionBackingList encountered an exception", ex);
            }
        }
    }



  //24/11/2010    Fernando Garcia
    //              Adding sorting method

    public String getSortingMethod() {
        return sortingMethod;
    }

    public void setSortingMethod(String sortingMethod) {
        this.sortingMethod = sortingMethod;
    }


    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.comunidadesSeleccionadas = null;
        this.comunidadesSeleccionadasValueList = new java.lang.Object[0];
        this.comunidadesSeleccionadasLabelList = new java.lang.Object[0];
        this.nivelAgregacion = null;
        this.numeroResultados = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("nomTesauros", this.nomTesauros);
        builder.append("buscadorContenido", this.buscadorContenido);
        builder.append("tipoVisualizacion", this.tipoVisualizacion);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        builder.append("formato", this.formato);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("idTesauro", this.idTesauro);
        builder.append("anyoPublicacion", this.anyoPublicacion);
        builder.append("areaCurricular", this.areaCurricular);
        builder.append("valoracion", this.valoracion);
        builder.append("pagina", this.pagina);
        builder.append("comunidadesSeleccionadas", this.comunidadesSeleccionadas);
        builder.append("edad", this.edad);
        builder.append("nodoDestino", this.nodoDestino);
        builder.append("identificadorODE", this.identificadorODE);
        builder.append("c_s_secuencia", this.c_s_secuencia);
        builder.append("enlaceComunidadesSeleccionadas", this.enlaceComunidadesSeleccionadas);
        builder.append("recurso", this.recurso);
        builder.append("diaPublicacion", this.diaPublicacion);
        builder.append("contexto", this.contexto);
        builder.append("idTesauroSugerencia", this.idTesauroSugerencia);
        builder.append("busquedaSimpleAvanzada", this.busquedaSimpleAvanzada);
        builder.append("autor", this.autor);
        builder.append("destinatarios", this.destinatarios);
        builder.append("listaIds", this.listaIds);
        builder.append("keyword", this.keyword);
        builder.append("idioma", this.idioma);
        builder.append("nivelAgregacion", this.nivelAgregacion);
        builder.append("procesoCognitivo", this.procesoCognitivo);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        builder.append("enlaceTodoAgrega", this.enlaceTodoAgrega);
        builder.append("numeroResultados", this.numeroResultados);
        builder.append("mesPublicacion", this.mesPublicacion);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.nomTesauros = null;
        this.nomTesaurosValueList = null;
        this.nomTesaurosLabelList = null;
        this.buscadorContenido = null;
        this.buscadorContenidoValueList = null;
        this.buscadorContenidoLabelList = null;
        this.tipoVisualizacion = null;
        this.tipoVisualizacionValueList = null;
        this.tipoVisualizacionLabelList = null;
        this.tipoLayoutBuscador = null;
        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;
        this.formato = null;
        this.formatoValueList = null;
        this.formatoLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.idTesauro = null;
        this.idTesauroValueList = null;
        this.idTesauroLabelList = null;
        this.anyoPublicacion = null;
        this.anyoPublicacionValueList = null;
        this.anyoPublicacionLabelList = null;
        this.areaCurricular = null;
        this.areaCurricularValueList = null;
        this.areaCurricularLabelList = null;
        this.valoracion = null;
        this.valoracionValueList = null;
        this.valoracionLabelList = null;
        this.pagina = null;
        this.paginaValueList = null;
        this.paginaLabelList = null;
        this.comunidadesSeleccionadas = null;
        this.comunidadesSeleccionadasValueList = null;
        this.comunidadesSeleccionadasLabelList = null;
        this.edad = null;
        this.edadValueList = null;
        this.edadLabelList = null;
        this.nodoDestino = null;
        this.nodoDestinoValueList = null;
        this.nodoDestinoLabelList = null;
        this.identificadorODE = null;
        this.identificadorODEValueList = null;
        this.identificadorODELabelList = null;
        this.c_s_secuencia = null;
        this.c_s_secuenciaValueList = null;
        this.c_s_secuenciaLabelList = null;
        this.enlaceComunidadesSeleccionadas = null;
        this.enlaceComunidadesSeleccionadasValueList = null;
        this.enlaceComunidadesSeleccionadasLabelList = null;
        this.recurso = null;
        this.recursoValueList = null;
        this.recursoLabelList = null;
        this.diaPublicacion = null;
        this.diaPublicacionValueList = null;
        this.diaPublicacionLabelList = null;
        this.contexto = null;
        this.contextoValueList = null;
        this.contextoLabelList = null;
        this.idTesauroSugerencia = null;
        this.idTesauroSugerenciaValueList = null;
        this.idTesauroSugerenciaLabelList = null;
        this.busquedaSimpleAvanzada = null;
        this.busquedaSimpleAvanzadaValueList = null;
        this.busquedaSimpleAvanzadaLabelList = null;
        this.autor = null;
        this.autorValueList = null;
        this.autorLabelList = null;
        this.destinatarios = null;
        this.destinatariosValueList = null;
        this.destinatariosLabelList = null;
        this.listaIds = null;
        this.listaIdsValueList = null;
        this.listaIdsLabelList = null;
        this.keyword = null;
        this.keywordValueList = null;
        this.keywordLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.nivelAgregacion = null;
        this.nivelAgregacionValueList = null;
        this.nivelAgregacionLabelList = null;
        this.procesoCognitivo = null;
        this.procesoCognitivoValueList = null;
        this.procesoCognitivoLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
        this.enlaceTodoAgrega = null;
        this.enlaceTodoAgregaValueList = null;
        this.enlaceTodoAgregaLabelList = null;
        this.numeroResultados = null;
        this.numeroResultadosValueList = null;
        this.numeroResultadosLabelList = null;
        this.mesPublicacion = null;
        this.mesPublicacionValueList = null;
        this.mesPublicacionLabelList = null;
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
// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.busquedaSQI;

public class MostrarResultadosPaginarSQIFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.buscador.presentacion.avanzado.busquedaSQI.EjecutarBusquedaSQIForm
        , es.pode.buscador.presentacion.avanzado.busquedaSQI.AnalizarFormularioForm
{
    private int resultadosDesde;
    private java.lang.Object[] resultadosDesdeValueList;
    private java.lang.Object[] resultadosDesdeLabelList;
    private java.lang.String siguiente;
    private java.lang.Object[] siguienteValueList;
    private java.lang.Object[] siguienteLabelList;
    private java.lang.String buscadorContenido;
    private java.lang.Object[] buscadorContenidoValueList;
    private java.lang.Object[] buscadorContenidoLabelList;
    private java.lang.String buscadorContenidoSolo;
    private java.lang.Object[] buscadorContenidoSoloValueList;
    private java.lang.Object[] buscadorContenidoSoloLabelList;
    private java.lang.String keyword;
    private java.lang.Object[] keywordValueList;
    private java.lang.Object[] keywordLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.lang.String tipoLayoutBuscador;
    private java.lang.Object[] tipoLayoutBuscadorValueList;
    private java.lang.Object[] tipoLayoutBuscadorLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private java.lang.Boolean usuarioAdministrador;
    private java.lang.Object[] usuarioAdministradorValueList;
    private java.lang.Object[] usuarioAdministradorLabelList;
    private java.lang.Boolean mostrarAmbito;
    private java.lang.Object[] mostrarAmbitoValueList;
    private java.lang.Object[] mostrarAmbitoLabelList;
    private java.lang.String anterior;
    private java.lang.Object[] anteriorValueList;
    private java.lang.Object[] anteriorLabelList;
    private java.util.Collection lomESVO;
    private java.lang.Object[] lomESVOValueList;
    private java.lang.Object[] lomESVOLabelList;
    private java.lang.String pagina;
    private java.lang.Object[] paginaValueList;
    private java.lang.Object[] paginaLabelList;
    private java.lang.String numMaxRes;
    private java.lang.Object[] numMaxResValueList;
    private java.lang.Object[] numMaxResLabelList;
    private java.lang.String resultadosHasta;
    private java.lang.Object[] resultadosHastaValueList;
    private java.lang.Object[] resultadosHastaLabelList;
    private java.lang.String buscadorContenidoEnlace;
    private java.lang.Object[] buscadorContenidoEnlaceValueList;
    private java.lang.Object[] buscadorContenidoEnlaceLabelList;
    private java.lang.String numeroResultados;
    private java.lang.Object[] numeroResultadosValueList;
    private java.lang.Object[] numeroResultadosLabelList;
    private java.util.Collection paginas;
    private java.lang.Object[] paginasValueList;
    private java.lang.Object[] paginasLabelList;
    private java.util.Collection lomEsVO;
    private java.lang.Object[] lomEsVOValueList;
    private java.lang.Object[] lomEsVOLabelList;

    public MostrarResultadosPaginarSQIFormImpl()
    {
    }

    /**
     * Resets the given <code>resultadosDesde</code>.
     */
    public void resetResultadosDesde()
    {
        this.resultadosDesde = 0;
    }

    public void setResultadosDesde(int resultadosDesde)
    {
        this.resultadosDesde = resultadosDesde;
    }

    /**
     * 
     */
    public int getResultadosDesde()
    {
        return this.resultadosDesde;
    }
    
    public java.lang.Object[] getResultadosDesdeBackingList()
    {
        java.lang.Object[] values = this.resultadosDesdeValueList;
        java.lang.Object[] labels = this.resultadosDesdeLabelList;

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

    public java.lang.Object[] getResultadosDesdeValueList()
    {
        return this.resultadosDesdeValueList;
    }

    public void setResultadosDesdeValueList(java.lang.Object[] resultadosDesdeValueList)
    {
        this.resultadosDesdeValueList = resultadosDesdeValueList;
    }

    public java.lang.Object[] getResultadosDesdeLabelList()
    {
        return this.resultadosDesdeLabelList;
    }

    public void setResultadosDesdeLabelList(java.lang.Object[] resultadosDesdeLabelList)
    {
        this.resultadosDesdeLabelList = resultadosDesdeLabelList;
    }

    public void setResultadosDesdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setResultadosDesdeBackingList requires non-null property arguments");
        }

        this.resultadosDesdeValueList = null;
        this.resultadosDesdeLabelList = null;

        if (items != null)
        {
            this.resultadosDesdeValueList = new java.lang.Object[items.size()];
            this.resultadosDesdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resultadosDesdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resultadosDesdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setResultadosDesdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>siguiente</code>.
     */
    public void resetSiguiente()
    {
        this.siguiente = null;
    }

    public void setSiguiente(java.lang.String siguiente)
    {
        this.siguiente = siguiente;
    }

    /**
     * 
     */
    public java.lang.String getSiguiente()
    {
        return this.siguiente;
    }
    
    public java.lang.Object[] getSiguienteBackingList()
    {
        java.lang.Object[] values = this.siguienteValueList;
        java.lang.Object[] labels = this.siguienteLabelList;

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

    public java.lang.Object[] getSiguienteValueList()
    {
        return this.siguienteValueList;
    }

    public void setSiguienteValueList(java.lang.Object[] siguienteValueList)
    {
        this.siguienteValueList = siguienteValueList;
    }

    public java.lang.Object[] getSiguienteLabelList()
    {
        return this.siguienteLabelList;
    }

    public void setSiguienteLabelList(java.lang.Object[] siguienteLabelList)
    {
        this.siguienteLabelList = siguienteLabelList;
    }

    public void setSiguienteBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setSiguienteBackingList requires non-null property arguments");
        }

        this.siguienteValueList = null;
        this.siguienteLabelList = null;

        if (items != null)
        {
            this.siguienteValueList = new java.lang.Object[items.size()];
            this.siguienteLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.siguienteValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.siguienteLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setSiguienteBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setBuscadorContenidoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setBuscadorContenidoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>buscadorContenidoSolo</code>.
     */
    public void resetBuscadorContenidoSolo()
    {
        this.buscadorContenidoSolo = null;
    }

    public void setBuscadorContenidoSolo(java.lang.String buscadorContenidoSolo)
    {
        this.buscadorContenidoSolo = buscadorContenidoSolo;
    }

    /**
     * 
     */
    public java.lang.String getBuscadorContenidoSolo()
    {
        return this.buscadorContenidoSolo;
    }
    
    public java.lang.Object[] getBuscadorContenidoSoloBackingList()
    {
        java.lang.Object[] values = this.buscadorContenidoSoloValueList;
        java.lang.Object[] labels = this.buscadorContenidoSoloLabelList;

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

    public java.lang.Object[] getBuscadorContenidoSoloValueList()
    {
        return this.buscadorContenidoSoloValueList;
    }

    public void setBuscadorContenidoSoloValueList(java.lang.Object[] buscadorContenidoSoloValueList)
    {
        this.buscadorContenidoSoloValueList = buscadorContenidoSoloValueList;
    }

    public java.lang.Object[] getBuscadorContenidoSoloLabelList()
    {
        return this.buscadorContenidoSoloLabelList;
    }

    public void setBuscadorContenidoSoloLabelList(java.lang.Object[] buscadorContenidoSoloLabelList)
    {
        this.buscadorContenidoSoloLabelList = buscadorContenidoSoloLabelList;
    }

    public void setBuscadorContenidoSoloBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setBuscadorContenidoSoloBackingList requires non-null property arguments");
        }

        this.buscadorContenidoSoloValueList = null;
        this.buscadorContenidoSoloLabelList = null;

        if (items != null)
        {
            this.buscadorContenidoSoloValueList = new java.lang.Object[items.size()];
            this.buscadorContenidoSoloLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.buscadorContenidoSoloValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.buscadorContenidoSoloLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setBuscadorContenidoSoloBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setKeywordBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setKeywordBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setIdiomaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
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
     * idioma seleccionado por el usuario para realizar la búsqueda
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
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>usuarioAdministrador</code>.
     */
    public void resetUsuarioAdministrador()
    {
        this.usuarioAdministrador = null;
    }

    public void setUsuarioAdministrador(java.lang.Boolean usuarioAdministrador)
    {
        this.usuarioAdministrador = usuarioAdministrador;
    }

    /**
     * 
     */
    public java.lang.Boolean getUsuarioAdministrador()
    {
        return this.usuarioAdministrador;
    }
    
    public java.lang.Object[] getUsuarioAdministradorBackingList()
    {
        java.lang.Object[] values = this.usuarioAdministradorValueList;
        java.lang.Object[] labels = this.usuarioAdministradorLabelList;

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

    public java.lang.Object[] getUsuarioAdministradorValueList()
    {
        return this.usuarioAdministradorValueList;
    }

    public void setUsuarioAdministradorValueList(java.lang.Object[] usuarioAdministradorValueList)
    {
        this.usuarioAdministradorValueList = usuarioAdministradorValueList;
    }

    public java.lang.Object[] getUsuarioAdministradorLabelList()
    {
        return this.usuarioAdministradorLabelList;
    }

    public void setUsuarioAdministradorLabelList(java.lang.Object[] usuarioAdministradorLabelList)
    {
        this.usuarioAdministradorLabelList = usuarioAdministradorLabelList;
    }

    public void setUsuarioAdministradorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setUsuarioAdministradorBackingList requires non-null property arguments");
        }

        this.usuarioAdministradorValueList = null;
        this.usuarioAdministradorLabelList = null;

        if (items != null)
        {
            this.usuarioAdministradorValueList = new java.lang.Object[items.size()];
            this.usuarioAdministradorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.usuarioAdministradorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.usuarioAdministradorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setUsuarioAdministradorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>mostrarAmbito</code>.
     */
    public void resetMostrarAmbito()
    {
        this.mostrarAmbito = null;
    }

    public void setMostrarAmbito(java.lang.Boolean mostrarAmbito)
    {
        this.mostrarAmbito = mostrarAmbito;
    }

    /**
     * 
     */
    public java.lang.Boolean getMostrarAmbito()
    {
        return this.mostrarAmbito;
    }
    
    public java.lang.Object[] getMostrarAmbitoBackingList()
    {
        java.lang.Object[] values = this.mostrarAmbitoValueList;
        java.lang.Object[] labels = this.mostrarAmbitoLabelList;

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

    public java.lang.Object[] getMostrarAmbitoValueList()
    {
        return this.mostrarAmbitoValueList;
    }

    public void setMostrarAmbitoValueList(java.lang.Object[] mostrarAmbitoValueList)
    {
        this.mostrarAmbitoValueList = mostrarAmbitoValueList;
    }

    public java.lang.Object[] getMostrarAmbitoLabelList()
    {
        return this.mostrarAmbitoLabelList;
    }

    public void setMostrarAmbitoLabelList(java.lang.Object[] mostrarAmbitoLabelList)
    {
        this.mostrarAmbitoLabelList = mostrarAmbitoLabelList;
    }

    public void setMostrarAmbitoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setMostrarAmbitoBackingList requires non-null property arguments");
        }

        this.mostrarAmbitoValueList = null;
        this.mostrarAmbitoLabelList = null;

        if (items != null)
        {
            this.mostrarAmbitoValueList = new java.lang.Object[items.size()];
            this.mostrarAmbitoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mostrarAmbitoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mostrarAmbitoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setMostrarAmbitoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>anterior</code>.
     */
    public void resetAnterior()
    {
        this.anterior = null;
    }

    public void setAnterior(java.lang.String anterior)
    {
        this.anterior = anterior;
    }

    /**
     * 
     */
    public java.lang.String getAnterior()
    {
        return this.anterior;
    }
    
    public java.lang.Object[] getAnteriorBackingList()
    {
        java.lang.Object[] values = this.anteriorValueList;
        java.lang.Object[] labels = this.anteriorLabelList;

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

    public java.lang.Object[] getAnteriorValueList()
    {
        return this.anteriorValueList;
    }

    public void setAnteriorValueList(java.lang.Object[] anteriorValueList)
    {
        this.anteriorValueList = anteriorValueList;
    }

    public java.lang.Object[] getAnteriorLabelList()
    {
        return this.anteriorLabelList;
    }

    public void setAnteriorLabelList(java.lang.Object[] anteriorLabelList)
    {
        this.anteriorLabelList = anteriorLabelList;
    }

    public void setAnteriorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setAnteriorBackingList requires non-null property arguments");
        }

        this.anteriorValueList = null;
        this.anteriorLabelList = null;

        if (items != null)
        {
            this.anteriorValueList = new java.lang.Object[items.size()];
            this.anteriorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.anteriorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.anteriorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setAnteriorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>lomESVO</code>.
     */
    public void resetLomESVO()
    {
        this.lomESVO = null;
    }

    public void setLomESVO(java.util.Collection lomESVO)
    {
        this.lomESVO = lomESVO;
    }

    /**
     * 
     */
    public java.util.Collection getLomESVO()
    {
        return this.lomESVO;
    }

    public void setLomESVOAsArray(Object[] lomESVO)
    {
        this.lomESVO = (lomESVO == null) ? null : java.util.Arrays.asList(lomESVO);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.buscador.presentacion.avanzado.busquedaSQI.MostrarResultadosPaginarSQIFormImpl#getLomESVO
     */
    public java.lang.Object[] getLomESVOAsArray()
    {
        return (lomESVO == null) ? null : lomESVO.toArray();
    }
    
    public java.lang.Object[] getLomESVOBackingList()
    {
        java.lang.Object[] values = this.lomESVOValueList;
        java.lang.Object[] labels = this.lomESVOLabelList;

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

    public java.lang.Object[] getLomESVOValueList()
    {
        return this.lomESVOValueList;
    }

    public void setLomESVOValueList(java.lang.Object[] lomESVOValueList)
    {
        this.lomESVOValueList = lomESVOValueList;
    }

    public java.lang.Object[] getLomESVOLabelList()
    {
        return this.lomESVOLabelList;
    }

    public void setLomESVOLabelList(java.lang.Object[] lomESVOLabelList)
    {
        this.lomESVOLabelList = lomESVOLabelList;
    }

    public void setLomESVOBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setLomESVOBackingList requires non-null property arguments");
        }

        this.lomESVOValueList = null;
        this.lomESVOLabelList = null;

        if (items != null)
        {
            this.lomESVOValueList = new java.lang.Object[items.size()];
            this.lomESVOLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.lomESVOValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.lomESVOLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setLomESVOBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setPaginaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setPaginaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>numMaxRes</code>.
     */
    public void resetNumMaxRes()
    {
        this.numMaxRes = null;
    }

    public void setNumMaxRes(java.lang.String numMaxRes)
    {
        this.numMaxRes = numMaxRes;
    }

    /**
     * 
     */
    public java.lang.String getNumMaxRes()
    {
        return this.numMaxRes;
    }
    
    public java.lang.Object[] getNumMaxResBackingList()
    {
        java.lang.Object[] values = this.numMaxResValueList;
        java.lang.Object[] labels = this.numMaxResLabelList;

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

    public java.lang.Object[] getNumMaxResValueList()
    {
        return this.numMaxResValueList;
    }

    public void setNumMaxResValueList(java.lang.Object[] numMaxResValueList)
    {
        this.numMaxResValueList = numMaxResValueList;
    }

    public java.lang.Object[] getNumMaxResLabelList()
    {
        return this.numMaxResLabelList;
    }

    public void setNumMaxResLabelList(java.lang.Object[] numMaxResLabelList)
    {
        this.numMaxResLabelList = numMaxResLabelList;
    }

    public void setNumMaxResBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setNumMaxResBackingList requires non-null property arguments");
        }

        this.numMaxResValueList = null;
        this.numMaxResLabelList = null;

        if (items != null)
        {
            this.numMaxResValueList = new java.lang.Object[items.size()];
            this.numMaxResLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.numMaxResValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.numMaxResLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setNumMaxResBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>resultadosHasta</code>.
     */
    public void resetResultadosHasta()
    {
        this.resultadosHasta = null;
    }

    public void setResultadosHasta(java.lang.String resultadosHasta)
    {
        this.resultadosHasta = resultadosHasta;
    }

    /**
     * 
     */
    public java.lang.String getResultadosHasta()
    {
        return this.resultadosHasta;
    }
    
    public java.lang.Object[] getResultadosHastaBackingList()
    {
        java.lang.Object[] values = this.resultadosHastaValueList;
        java.lang.Object[] labels = this.resultadosHastaLabelList;

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

    public java.lang.Object[] getResultadosHastaValueList()
    {
        return this.resultadosHastaValueList;
    }

    public void setResultadosHastaValueList(java.lang.Object[] resultadosHastaValueList)
    {
        this.resultadosHastaValueList = resultadosHastaValueList;
    }

    public java.lang.Object[] getResultadosHastaLabelList()
    {
        return this.resultadosHastaLabelList;
    }

    public void setResultadosHastaLabelList(java.lang.Object[] resultadosHastaLabelList)
    {
        this.resultadosHastaLabelList = resultadosHastaLabelList;
    }

    public void setResultadosHastaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setResultadosHastaBackingList requires non-null property arguments");
        }

        this.resultadosHastaValueList = null;
        this.resultadosHastaLabelList = null;

        if (items != null)
        {
            this.resultadosHastaValueList = new java.lang.Object[items.size()];
            this.resultadosHastaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resultadosHastaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resultadosHastaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setResultadosHastaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>buscadorContenidoEnlace</code>.
     */
    public void resetBuscadorContenidoEnlace()
    {
        this.buscadorContenidoEnlace = null;
    }

    public void setBuscadorContenidoEnlace(java.lang.String buscadorContenidoEnlace)
    {
        this.buscadorContenidoEnlace = buscadorContenidoEnlace;
    }

    /**
     * 
     */
    public java.lang.String getBuscadorContenidoEnlace()
    {
        return this.buscadorContenidoEnlace;
    }
    
    public java.lang.Object[] getBuscadorContenidoEnlaceBackingList()
    {
        java.lang.Object[] values = this.buscadorContenidoEnlaceValueList;
        java.lang.Object[] labels = this.buscadorContenidoEnlaceLabelList;

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

    public java.lang.Object[] getBuscadorContenidoEnlaceValueList()
    {
        return this.buscadorContenidoEnlaceValueList;
    }

    public void setBuscadorContenidoEnlaceValueList(java.lang.Object[] buscadorContenidoEnlaceValueList)
    {
        this.buscadorContenidoEnlaceValueList = buscadorContenidoEnlaceValueList;
    }

    public java.lang.Object[] getBuscadorContenidoEnlaceLabelList()
    {
        return this.buscadorContenidoEnlaceLabelList;
    }

    public void setBuscadorContenidoEnlaceLabelList(java.lang.Object[] buscadorContenidoEnlaceLabelList)
    {
        this.buscadorContenidoEnlaceLabelList = buscadorContenidoEnlaceLabelList;
    }

    public void setBuscadorContenidoEnlaceBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setBuscadorContenidoEnlaceBackingList requires non-null property arguments");
        }

        this.buscadorContenidoEnlaceValueList = null;
        this.buscadorContenidoEnlaceLabelList = null;

        if (items != null)
        {
            this.buscadorContenidoEnlaceValueList = new java.lang.Object[items.size()];
            this.buscadorContenidoEnlaceLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.buscadorContenidoEnlaceValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.buscadorContenidoEnlaceLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setBuscadorContenidoEnlaceBackingList encountered an exception", ex);
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
     * <p>
     * numero de resultados a mostrar por página
     * </p>
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
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setNumeroResultadosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setNumeroResultadosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>paginas</code>.
     */
    public void resetPaginas()
    {
        this.paginas = null;
    }

    public void setPaginas(java.util.Collection paginas)
    {
        this.paginas = paginas;
    }

    /**
     * 
     */
    public java.util.Collection getPaginas()
    {
        return this.paginas;
    }

    public void setPaginasAsArray(Object[] paginas)
    {
        this.paginas = (paginas == null) ? null : java.util.Arrays.asList(paginas);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.buscador.presentacion.avanzado.busquedaSQI.MostrarResultadosPaginarSQIFormImpl#getPaginas
     */
    public java.lang.Object[] getPaginasAsArray()
    {
        return (paginas == null) ? null : paginas.toArray();
    }
    
    public java.lang.Object[] getPaginasBackingList()
    {
        java.lang.Object[] values = this.paginasValueList;
        java.lang.Object[] labels = this.paginasLabelList;

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

    public java.lang.Object[] getPaginasValueList()
    {
        return this.paginasValueList;
    }

    public void setPaginasValueList(java.lang.Object[] paginasValueList)
    {
        this.paginasValueList = paginasValueList;
    }

    public java.lang.Object[] getPaginasLabelList()
    {
        return this.paginasLabelList;
    }

    public void setPaginasLabelList(java.lang.Object[] paginasLabelList)
    {
        this.paginasLabelList = paginasLabelList;
    }

    public void setPaginasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setPaginasBackingList requires non-null property arguments");
        }

        this.paginasValueList = null;
        this.paginasLabelList = null;

        if (items != null)
        {
            this.paginasValueList = new java.lang.Object[items.size()];
            this.paginasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.paginasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.paginasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setPaginasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>lomEsVO</code>.
     */
    public void resetLomEsVO()
    {
        this.lomEsVO = null;
    }

    public void setLomEsVO(java.util.Collection lomEsVO)
    {
        this.lomEsVO = lomEsVO;
    }

    /**
     * 
     */
    public java.util.Collection getLomEsVO()
    {
        return this.lomEsVO;
    }

    public void setLomEsVOAsArray(Object[] lomEsVO)
    {
        this.lomEsVO = (lomEsVO == null) ? null : java.util.Arrays.asList(lomEsVO);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.buscador.presentacion.avanzado.busquedaSQI.MostrarResultadosPaginarSQIFormImpl#getLomEsVO
     */
    public java.lang.Object[] getLomEsVOAsArray()
    {
        return (lomEsVO == null) ? null : lomEsVO.toArray();
    }
    
    public java.lang.Object[] getLomEsVOBackingList()
    {
        java.lang.Object[] values = this.lomEsVOValueList;
        java.lang.Object[] labels = this.lomEsVOLabelList;

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

    public java.lang.Object[] getLomEsVOValueList()
    {
        return this.lomEsVOValueList;
    }

    public void setLomEsVOValueList(java.lang.Object[] lomEsVOValueList)
    {
        this.lomEsVOValueList = lomEsVOValueList;
    }

    public java.lang.Object[] getLomEsVOLabelList()
    {
        return this.lomEsVOLabelList;
    }

    public void setLomEsVOLabelList(java.lang.Object[] lomEsVOLabelList)
    {
        this.lomEsVOLabelList = lomEsVOLabelList;
    }

    public void setLomEsVOBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosPaginarSQIFormImpl.setLomEsVOBackingList requires non-null property arguments");
        }

        this.lomEsVOValueList = null;
        this.lomEsVOLabelList = null;

        if (items != null)
        {
            this.lomEsVOValueList = new java.lang.Object[items.size()];
            this.lomEsVOLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.lomEsVOValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.lomEsVOLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosPaginarSQIFormImpl.setLomEsVOBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.idiomaBuscador = null;
        this.usuarioAdministrador = null;
        this.mostrarAmbito = null;
        this.numeroResultados = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("resultadosDesde", this.resultadosDesde);
        builder.append("siguiente", this.siguiente);
        builder.append("buscadorContenido", this.buscadorContenido);
        builder.append("buscadorContenidoSolo", this.buscadorContenidoSolo);
        builder.append("keyword", this.keyword);
        builder.append("idioma", this.idioma);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        builder.append("usuarioAdministrador", this.usuarioAdministrador);
        builder.append("mostrarAmbito", this.mostrarAmbito);
        builder.append("anterior", this.anterior);
        builder.append("lomESVO", this.lomESVO);
        builder.append("pagina", this.pagina);
        builder.append("numMaxRes", this.numMaxRes);
        builder.append("resultadosHasta", this.resultadosHasta);
        builder.append("buscadorContenidoEnlace", this.buscadorContenidoEnlace);
        builder.append("numeroResultados", this.numeroResultados);
        builder.append("paginas", this.paginas);
        builder.append("lomEsVO", this.lomEsVO);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.resultadosDesde = 0;
        this.resultadosDesdeValueList = null;
        this.resultadosDesdeLabelList = null;
        this.siguiente = null;
        this.siguienteValueList = null;
        this.siguienteLabelList = null;
        this.buscadorContenido = null;
        this.buscadorContenidoValueList = null;
        this.buscadorContenidoLabelList = null;
        this.buscadorContenidoSolo = null;
        this.buscadorContenidoSoloValueList = null;
        this.buscadorContenidoSoloLabelList = null;
        this.keyword = null;
        this.keywordValueList = null;
        this.keywordLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.tipoLayoutBuscador = null;
        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
        this.usuarioAdministrador = null;
        this.usuarioAdministradorValueList = null;
        this.usuarioAdministradorLabelList = null;
        this.mostrarAmbito = null;
        this.mostrarAmbitoValueList = null;
        this.mostrarAmbitoLabelList = null;
        this.anterior = null;
        this.anteriorValueList = null;
        this.anteriorLabelList = null;
        this.lomESVO = null;
        this.lomESVOValueList = null;
        this.lomESVOLabelList = null;
        this.pagina = null;
        this.paginaValueList = null;
        this.paginaLabelList = null;
        this.numMaxRes = null;
        this.numMaxResValueList = null;
        this.numMaxResLabelList = null;
        this.resultadosHasta = null;
        this.resultadosHastaValueList = null;
        this.resultadosHastaLabelList = null;
        this.buscadorContenidoEnlace = null;
        this.buscadorContenidoEnlaceValueList = null;
        this.buscadorContenidoEnlaceLabelList = null;
        this.numeroResultados = null;
        this.numeroResultadosValueList = null;
        this.numeroResultadosLabelList = null;
        this.paginas = null;
        this.paginasValueList = null;
        this.paginasLabelList = null;
        this.lomEsVO = null;
        this.lomEsVOValueList = null;
        this.lomEsVOLabelList = null;
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
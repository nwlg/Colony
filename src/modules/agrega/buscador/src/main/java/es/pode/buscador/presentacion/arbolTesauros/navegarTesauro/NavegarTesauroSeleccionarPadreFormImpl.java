// license-header java merge-point
package es.pode.buscador.presentacion.arbolTesauros.navegarTesauro;

public class NavegarTesauroSeleccionarPadreFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.ConsultarPadreTaxonForm
{
    private java.util.Collection taxonesVO;
    private java.lang.Object[] taxonesVOValueList;
    private java.lang.Object[] taxonesVOLabelList;
    private java.lang.String tituloTesauro;
    private java.lang.Object[] tituloTesauroValueList;
    private java.lang.Object[] tituloTesauroLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.lang.String tipoLayoutBuscador;
    private java.lang.Object[] tipoLayoutBuscadorValueList;
    private java.lang.Object[] tipoLayoutBuscadorLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.String idTesauro;
    private java.lang.Object[] idTesauroValueList;
    private java.lang.Object[] idTesauroLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private boolean esRuta;
    private java.lang.Object[] esRutaValueList;
    private java.lang.Object[] esRutaLabelList;
    private java.lang.Integer numMaxResultados;
    private java.lang.Object[] numMaxResultadosValueList;
    private java.lang.Object[] numMaxResultadosLabelList;
    private java.lang.String tipoBusquedaArbol;
    private java.lang.Object[] tipoBusquedaArbolValueList;
    private java.lang.Object[] tipoBusquedaArbolLabelList;
    private java.lang.String textoBusqueda;
    private java.lang.Object[] textoBusquedaValueList;
    private java.lang.Object[] textoBusquedaLabelList;
    private java.util.Collection rutaPadreVO;
    private java.lang.Object[] rutaPadreVOValueList;
    private java.lang.Object[] rutaPadreVOLabelList;
    private java.lang.Integer numeroResultados;
    private java.lang.Object[] numeroResultadosValueList;
    private java.lang.Object[] numeroResultadosLabelList;
    private java.lang.String nomTesauro;
    private java.lang.Object[] nomTesauroValueList;
    private java.lang.Object[] nomTesauroLabelList;
    private java.lang.String tipoLayoutbuscador;
    private java.lang.Object[] tipoLayoutbuscadorValueList;
    private java.lang.Object[] tipoLayoutbuscadorLabelList;

    public NavegarTesauroSeleccionarPadreFormImpl()
    {
    }

    /**
     * Resets the given <code>taxonesVO</code>.
     */
    public void resetTaxonesVO()
    {
        this.taxonesVO = null;
    }

    public void setTaxonesVO(java.util.Collection taxonesVO)
    {
        this.taxonesVO = taxonesVO;
    }

    /**
     * 
     */
    public java.util.Collection getTaxonesVO()
    {
        return this.taxonesVO;
    }

    public void setTaxonesVOAsArray(Object[] taxonesVO)
    {
        this.taxonesVO = (taxonesVO == null) ? null : java.util.Arrays.asList(taxonesVO);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.NavegarTesauroSeleccionarPadreFormImpl#getTaxonesVO
     */
    public java.lang.Object[] getTaxonesVOAsArray()
    {
        return (taxonesVO == null) ? null : taxonesVO.toArray();
    }
    
    public java.lang.Object[] getTaxonesVOBackingList()
    {
        java.lang.Object[] values = this.taxonesVOValueList;
        java.lang.Object[] labels = this.taxonesVOLabelList;

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

    public java.lang.Object[] getTaxonesVOValueList()
    {
        return this.taxonesVOValueList;
    }

    public void setTaxonesVOValueList(java.lang.Object[] taxonesVOValueList)
    {
        this.taxonesVOValueList = taxonesVOValueList;
    }

    public java.lang.Object[] getTaxonesVOLabelList()
    {
        return this.taxonesVOLabelList;
    }

    public void setTaxonesVOLabelList(java.lang.Object[] taxonesVOLabelList)
    {
        this.taxonesVOLabelList = taxonesVOLabelList;
    }

    public void setTaxonesVOBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setTaxonesVOBackingList requires non-null property arguments");
        }

        this.taxonesVOValueList = null;
        this.taxonesVOLabelList = null;

        if (items != null)
        {
            this.taxonesVOValueList = new java.lang.Object[items.size()];
            this.taxonesVOLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.taxonesVOValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.taxonesVOLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setTaxonesVOBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tituloTesauro</code>.
     */
    public void resetTituloTesauro()
    {
        this.tituloTesauro = null;
    }

    public void setTituloTesauro(java.lang.String tituloTesauro)
    {
        this.tituloTesauro = tituloTesauro;
    }

    /**
     * 
     */
    public java.lang.String getTituloTesauro()
    {
        return this.tituloTesauro;
    }
    
    public java.lang.Object[] getTituloTesauroBackingList()
    {
        java.lang.Object[] values = this.tituloTesauroValueList;
        java.lang.Object[] labels = this.tituloTesauroLabelList;

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

    public java.lang.Object[] getTituloTesauroValueList()
    {
        return this.tituloTesauroValueList;
    }

    public void setTituloTesauroValueList(java.lang.Object[] tituloTesauroValueList)
    {
        this.tituloTesauroValueList = tituloTesauroValueList;
    }

    public java.lang.Object[] getTituloTesauroLabelList()
    {
        return this.tituloTesauroLabelList;
    }

    public void setTituloTesauroLabelList(java.lang.Object[] tituloTesauroLabelList)
    {
        this.tituloTesauroLabelList = tituloTesauroLabelList;
    }

    public void setTituloTesauroBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setTituloTesauroBackingList requires non-null property arguments");
        }

        this.tituloTesauroValueList = null;
        this.tituloTesauroLabelList = null;

        if (items != null)
        {
            this.tituloTesauroValueList = new java.lang.Object[items.size()];
            this.tituloTesauroLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tituloTesauroValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tituloTesauroLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setTituloTesauroBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setIdiomaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setIdTesauroBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setIdTesauroBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>esRuta</code>.
     */
    public void resetEsRuta()
    {
        this.esRuta = false;
    }

    public void setEsRuta(boolean esRuta)
    {
        this.esRuta = esRuta;
    }

    /**
     * 
     */
    public boolean isEsRuta()
    {
        return this.esRuta;
    }
    
    public java.lang.Object[] getEsRutaBackingList()
    {
        java.lang.Object[] values = this.esRutaValueList;
        java.lang.Object[] labels = this.esRutaLabelList;

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

    public java.lang.Object[] getEsRutaValueList()
    {
        return this.esRutaValueList;
    }

    public void setEsRutaValueList(java.lang.Object[] esRutaValueList)
    {
        this.esRutaValueList = esRutaValueList;
    }

    public java.lang.Object[] getEsRutaLabelList()
    {
        return this.esRutaLabelList;
    }

    public void setEsRutaLabelList(java.lang.Object[] esRutaLabelList)
    {
        this.esRutaLabelList = esRutaLabelList;
    }

    public void setEsRutaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setEsRutaBackingList requires non-null property arguments");
        }

        this.esRutaValueList = null;
        this.esRutaLabelList = null;

        if (items != null)
        {
            this.esRutaValueList = new java.lang.Object[items.size()];
            this.esRutaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.esRutaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.esRutaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setEsRutaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>numMaxResultados</code>.
     */
    public void resetNumMaxResultados()
    {
        this.numMaxResultados = null;
    }

    public void setNumMaxResultados(java.lang.Integer numMaxResultados)
    {
        this.numMaxResultados = numMaxResultados;
    }

    /**
     * 
     */
    public java.lang.Integer getNumMaxResultados()
    {
        return this.numMaxResultados;
    }
    
    public java.lang.Object[] getNumMaxResultadosBackingList()
    {
        java.lang.Object[] values = this.numMaxResultadosValueList;
        java.lang.Object[] labels = this.numMaxResultadosLabelList;

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

    public java.lang.Object[] getNumMaxResultadosValueList()
    {
        return this.numMaxResultadosValueList;
    }

    public void setNumMaxResultadosValueList(java.lang.Object[] numMaxResultadosValueList)
    {
        this.numMaxResultadosValueList = numMaxResultadosValueList;
    }

    public java.lang.Object[] getNumMaxResultadosLabelList()
    {
        return this.numMaxResultadosLabelList;
    }

    public void setNumMaxResultadosLabelList(java.lang.Object[] numMaxResultadosLabelList)
    {
        this.numMaxResultadosLabelList = numMaxResultadosLabelList;
    }

    public void setNumMaxResultadosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setNumMaxResultadosBackingList requires non-null property arguments");
        }

        this.numMaxResultadosValueList = null;
        this.numMaxResultadosLabelList = null;

        if (items != null)
        {
            this.numMaxResultadosValueList = new java.lang.Object[items.size()];
            this.numMaxResultadosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.numMaxResultadosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.numMaxResultadosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setNumMaxResultadosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoBusquedaArbol</code>.
     */
    public void resetTipoBusquedaArbol()
    {
        this.tipoBusquedaArbol = null;
    }

    public void setTipoBusquedaArbol(java.lang.String tipoBusquedaArbol)
    {
        this.tipoBusquedaArbol = tipoBusquedaArbol;
    }

    /**
     * 
     */
    public java.lang.String getTipoBusquedaArbol()
    {
        return this.tipoBusquedaArbol;
    }
    
    public java.lang.Object[] getTipoBusquedaArbolBackingList()
    {
        java.lang.Object[] values = this.tipoBusquedaArbolValueList;
        java.lang.Object[] labels = this.tipoBusquedaArbolLabelList;

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

    public java.lang.Object[] getTipoBusquedaArbolValueList()
    {
        return this.tipoBusquedaArbolValueList;
    }

    public void setTipoBusquedaArbolValueList(java.lang.Object[] tipoBusquedaArbolValueList)
    {
        this.tipoBusquedaArbolValueList = tipoBusquedaArbolValueList;
    }

    public java.lang.Object[] getTipoBusquedaArbolLabelList()
    {
        return this.tipoBusquedaArbolLabelList;
    }

    public void setTipoBusquedaArbolLabelList(java.lang.Object[] tipoBusquedaArbolLabelList)
    {
        this.tipoBusquedaArbolLabelList = tipoBusquedaArbolLabelList;
    }

    public void setTipoBusquedaArbolBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setTipoBusquedaArbolBackingList requires non-null property arguments");
        }

        this.tipoBusquedaArbolValueList = null;
        this.tipoBusquedaArbolLabelList = null;

        if (items != null)
        {
            this.tipoBusquedaArbolValueList = new java.lang.Object[items.size()];
            this.tipoBusquedaArbolLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoBusquedaArbolValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoBusquedaArbolLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setTipoBusquedaArbolBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>textoBusqueda</code>.
     */
    public void resetTextoBusqueda()
    {
        this.textoBusqueda = null;
    }

    public void setTextoBusqueda(java.lang.String textoBusqueda)
    {
        this.textoBusqueda = textoBusqueda;
    }

    /**
     * 
     */
    public java.lang.String getTextoBusqueda()
    {
        return this.textoBusqueda;
    }
    
    public java.lang.Object[] getTextoBusquedaBackingList()
    {
        java.lang.Object[] values = this.textoBusquedaValueList;
        java.lang.Object[] labels = this.textoBusquedaLabelList;

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

    public java.lang.Object[] getTextoBusquedaValueList()
    {
        return this.textoBusquedaValueList;
    }

    public void setTextoBusquedaValueList(java.lang.Object[] textoBusquedaValueList)
    {
        this.textoBusquedaValueList = textoBusquedaValueList;
    }

    public java.lang.Object[] getTextoBusquedaLabelList()
    {
        return this.textoBusquedaLabelList;
    }

    public void setTextoBusquedaLabelList(java.lang.Object[] textoBusquedaLabelList)
    {
        this.textoBusquedaLabelList = textoBusquedaLabelList;
    }

    public void setTextoBusquedaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setTextoBusquedaBackingList requires non-null property arguments");
        }

        this.textoBusquedaValueList = null;
        this.textoBusquedaLabelList = null;

        if (items != null)
        {
            this.textoBusquedaValueList = new java.lang.Object[items.size()];
            this.textoBusquedaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.textoBusquedaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.textoBusquedaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setTextoBusquedaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>rutaPadreVO</code>.
     */
    public void resetRutaPadreVO()
    {
        this.rutaPadreVO = null;
    }

    public void setRutaPadreVO(java.util.Collection rutaPadreVO)
    {
        this.rutaPadreVO = rutaPadreVO;
    }

    /**
     * 
     */
    public java.util.Collection getRutaPadreVO()
    {
        return this.rutaPadreVO;
    }

    public void setRutaPadreVOAsArray(Object[] rutaPadreVO)
    {
        this.rutaPadreVO = (rutaPadreVO == null) ? null : java.util.Arrays.asList(rutaPadreVO);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.NavegarTesauroSeleccionarPadreFormImpl#getRutaPadreVO
     */
    public java.lang.Object[] getRutaPadreVOAsArray()
    {
        return (rutaPadreVO == null) ? null : rutaPadreVO.toArray();
    }
    
    public java.lang.Object[] getRutaPadreVOBackingList()
    {
        java.lang.Object[] values = this.rutaPadreVOValueList;
        java.lang.Object[] labels = this.rutaPadreVOLabelList;

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

    public java.lang.Object[] getRutaPadreVOValueList()
    {
        return this.rutaPadreVOValueList;
    }

    public void setRutaPadreVOValueList(java.lang.Object[] rutaPadreVOValueList)
    {
        this.rutaPadreVOValueList = rutaPadreVOValueList;
    }

    public java.lang.Object[] getRutaPadreVOLabelList()
    {
        return this.rutaPadreVOLabelList;
    }

    public void setRutaPadreVOLabelList(java.lang.Object[] rutaPadreVOLabelList)
    {
        this.rutaPadreVOLabelList = rutaPadreVOLabelList;
    }

    public void setRutaPadreVOBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setRutaPadreVOBackingList requires non-null property arguments");
        }

        this.rutaPadreVOValueList = null;
        this.rutaPadreVOLabelList = null;

        if (items != null)
        {
            this.rutaPadreVOValueList = new java.lang.Object[items.size()];
            this.rutaPadreVOLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.rutaPadreVOValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.rutaPadreVOLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setRutaPadreVOBackingList encountered an exception", ex);
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

    public void setNumeroResultados(java.lang.Integer numeroResultados)
    {
        this.numeroResultados = numeroResultados;
    }

    /**
     * 
     */
    public java.lang.Integer getNumeroResultados()
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
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setNumeroResultadosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setNumeroResultadosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nomTesauro</code>.
     */
    public void resetNomTesauro()
    {
        this.nomTesauro = null;
    }

    public void setNomTesauro(java.lang.String nomTesauro)
    {
        this.nomTesauro = nomTesauro;
    }

    /**
     * 
     */
    public java.lang.String getNomTesauro()
    {
        return this.nomTesauro;
    }
    
    public java.lang.Object[] getNomTesauroBackingList()
    {
        java.lang.Object[] values = this.nomTesauroValueList;
        java.lang.Object[] labels = this.nomTesauroLabelList;

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

    public java.lang.Object[] getNomTesauroValueList()
    {
        return this.nomTesauroValueList;
    }

    public void setNomTesauroValueList(java.lang.Object[] nomTesauroValueList)
    {
        this.nomTesauroValueList = nomTesauroValueList;
    }

    public java.lang.Object[] getNomTesauroLabelList()
    {
        return this.nomTesauroLabelList;
    }

    public void setNomTesauroLabelList(java.lang.Object[] nomTesauroLabelList)
    {
        this.nomTesauroLabelList = nomTesauroLabelList;
    }

    public void setNomTesauroBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setNomTesauroBackingList requires non-null property arguments");
        }

        this.nomTesauroValueList = null;
        this.nomTesauroLabelList = null;

        if (items != null)
        {
            this.nomTesauroValueList = new java.lang.Object[items.size()];
            this.nomTesauroLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nomTesauroValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nomTesauroLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setNomTesauroBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoLayoutbuscador</code>.
     */
    public void resetTipoLayoutbuscador()
    {
        this.tipoLayoutbuscador = null;
    }

    public void setTipoLayoutbuscador(java.lang.String tipoLayoutbuscador)
    {
        this.tipoLayoutbuscador = tipoLayoutbuscador;
    }

    /**
     * 
     */
    public java.lang.String getTipoLayoutbuscador()
    {
        return this.tipoLayoutbuscador;
    }
    
    public java.lang.Object[] getTipoLayoutbuscadorBackingList()
    {
        java.lang.Object[] values = this.tipoLayoutbuscadorValueList;
        java.lang.Object[] labels = this.tipoLayoutbuscadorLabelList;

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

    public java.lang.Object[] getTipoLayoutbuscadorValueList()
    {
        return this.tipoLayoutbuscadorValueList;
    }

    public void setTipoLayoutbuscadorValueList(java.lang.Object[] tipoLayoutbuscadorValueList)
    {
        this.tipoLayoutbuscadorValueList = tipoLayoutbuscadorValueList;
    }

    public java.lang.Object[] getTipoLayoutbuscadorLabelList()
    {
        return this.tipoLayoutbuscadorLabelList;
    }

    public void setTipoLayoutbuscadorLabelList(java.lang.Object[] tipoLayoutbuscadorLabelList)
    {
        this.tipoLayoutbuscadorLabelList = tipoLayoutbuscadorLabelList;
    }

    public void setTipoLayoutbuscadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NavegarTesauroSeleccionarPadreFormImpl.setTipoLayoutbuscadorBackingList requires non-null property arguments");
        }

        this.tipoLayoutbuscadorValueList = null;
        this.tipoLayoutbuscadorLabelList = null;

        if (items != null)
        {
            this.tipoLayoutbuscadorValueList = new java.lang.Object[items.size()];
            this.tipoLayoutbuscadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoLayoutbuscadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoLayoutbuscadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NavegarTesauroSeleccionarPadreFormImpl.setTipoLayoutbuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.taxonesVO = null;
        this.taxonesVOValueList = new java.lang.Object[0];
        this.taxonesVOLabelList = new java.lang.Object[0];
        this.esRuta = false;
        this.rutaPadreVO = null;
        this.rutaPadreVOValueList = new java.lang.Object[0];
        this.rutaPadreVOLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("taxonesVO", this.taxonesVO);
        builder.append("tituloTesauro", this.tituloTesauro);
        builder.append("idioma", this.idioma);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("idTesauro", this.idTesauro);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        builder.append("esRuta", this.esRuta);
        builder.append("numMaxResultados", this.numMaxResultados);
        builder.append("tipoBusquedaArbol", this.tipoBusquedaArbol);
        builder.append("textoBusqueda", this.textoBusqueda);
        builder.append("rutaPadreVO", this.rutaPadreVO);
        builder.append("numeroResultados", this.numeroResultados);
        builder.append("nomTesauro", this.nomTesauro);
        builder.append("tipoLayoutbuscador", this.tipoLayoutbuscador);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.taxonesVO = null;
        this.taxonesVOValueList = null;
        this.taxonesVOLabelList = null;
        this.tituloTesauro = null;
        this.tituloTesauroValueList = null;
        this.tituloTesauroLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.tipoLayoutBuscador = null;
        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.idTesauro = null;
        this.idTesauroValueList = null;
        this.idTesauroLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
        this.esRuta = false;
        this.esRutaValueList = null;
        this.esRutaLabelList = null;
        this.numMaxResultados = null;
        this.numMaxResultadosValueList = null;
        this.numMaxResultadosLabelList = null;
        this.tipoBusquedaArbol = null;
        this.tipoBusquedaArbolValueList = null;
        this.tipoBusquedaArbolLabelList = null;
        this.textoBusqueda = null;
        this.textoBusquedaValueList = null;
        this.textoBusquedaLabelList = null;
        this.rutaPadreVO = null;
        this.rutaPadreVOValueList = null;
        this.rutaPadreVOLabelList = null;
        this.numeroResultados = null;
        this.numeroResultadosValueList = null;
        this.numeroResultadosLabelList = null;
        this.nomTesauro = null;
        this.nomTesauroValueList = null;
        this.nomTesauroLabelList = null;
        this.tipoLayoutbuscador = null;
        this.tipoLayoutbuscadorValueList = null;
        this.tipoLayoutbuscadorLabelList = null;
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
// license-header java merge-point
package es.pode.buscador.presentacion.arbolTesauros.listarODETesauro;

public class ListarODETesauroCUFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.BuscarDocumentosTesauroForm
{
    private java.util.Collection rutaTesauro;
    private java.lang.Object[] rutaTesauroValueList;
    private java.lang.Object[] rutaTesauroLabelList;
    private java.lang.String siguiente;
    private java.lang.Object[] siguienteValueList;
    private java.lang.Object[] siguienteLabelList;
    private java.lang.String tipoLayoutBuscador;
    private java.lang.Object[] tipoLayoutBuscadorValueList;
    private java.lang.Object[] tipoLayoutBuscadorLabelList;
    private java.lang.String idBusqueda;
    private java.lang.Object[] idBusquedaValueList;
    private java.lang.Object[] idBusquedaLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.String idTesauro;
    private java.lang.Object[] idTesauroValueList;
    private java.lang.Object[] idTesauroLabelList;
    private java.lang.String tesauroBusqueda;
    private java.lang.Object[] tesauroBusquedaValueList;
    private java.lang.Object[] tesauroBusquedaLabelList;
    private boolean esRuta;
    private java.lang.Object[] esRutaValueList;
    private java.lang.Object[] esRutaLabelList;
    private java.lang.String anterior;
    private java.lang.Object[] anteriorValueList;
    private java.lang.Object[] anteriorLabelList;
    private java.lang.String pagina;
    private java.lang.Object[] paginaValueList;
    private java.lang.Object[] paginaLabelList;
    private java.lang.Integer numMaxResultados;
    private java.lang.Object[] numMaxResultadosValueList;
    private java.lang.Object[] numMaxResultadosLabelList;
    private java.lang.String resultadosHasta;
    private java.lang.Object[] resultadosHastaValueList;
    private java.lang.Object[] resultadosHastaLabelList;
    private java.lang.String nodoDestino;
    private java.lang.Object[] nodoDestinoValueList;
    private java.lang.Object[] nodoDestinoLabelList;
    private java.lang.String identificadorODE;
    private java.lang.Object[] identificadorODEValueList;
    private java.lang.Object[] identificadorODELabelList;
    private java.util.Collection rutaPadreVO;
    private java.lang.Object[] rutaPadreVOValueList;
    private java.lang.Object[] rutaPadreVOLabelList;
    private java.util.Collection paginas;
    private java.lang.Object[] paginasValueList;
    private java.lang.Object[] paginasLabelList;
    private java.lang.String resultadosDesde;
    private java.lang.Object[] resultadosDesdeValueList;
    private java.lang.Object[] resultadosDesdeLabelList;
    private java.lang.String nodoOrigen;
    private java.lang.Object[] nodoOrigenValueList;
    private java.lang.Object[] nodoOrigenLabelList;
    private java.lang.String busquedaSimpleAvanzada;
    private java.lang.Object[] busquedaSimpleAvanzadaValueList;
    private java.lang.Object[] busquedaSimpleAvanzadaLabelList;
    private java.lang.String tituloTesauro;
    private java.lang.Object[] tituloTesauroValueList;
    private java.lang.Object[] tituloTesauroLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private es.pode.buscar.negocio.buscar.servicios.ValoresBusquedaVO[] resultadosVO;
    private java.lang.Object[] resultadosVOValueList;
    private java.lang.Object[] resultadosVOLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private boolean esHoja;
    private java.lang.Object[] esHojaValueList;
    private java.lang.Object[] esHojaLabelList;
    private java.lang.String tipoBusquedaArbol;
    private java.lang.Object[] tipoBusquedaArbolValueList;
    private java.lang.Object[] tipoBusquedaArbolLabelList;
    private java.lang.String nodo;
    private java.lang.Object[] nodoValueList;
    private java.lang.Object[] nodoLabelList;

    public ListarODETesauroCUFormImpl()
    {
    }

    /**
     * Resets the given <code>rutaTesauro</code>.
     */
    public void resetRutaTesauro()
    {
        this.rutaTesauro = null;
    }

    public void setRutaTesauro(java.util.Collection rutaTesauro)
    {
        this.rutaTesauro = rutaTesauro;
    }

    /**
     * 
     */
    public java.util.Collection getRutaTesauro()
    {
        return this.rutaTesauro;
    }

    public void setRutaTesauroAsArray(Object[] rutaTesauro)
    {
        this.rutaTesauro = (rutaTesauro == null) ? null : java.util.Arrays.asList(rutaTesauro);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.ListarODETesauroCUFormImpl#getRutaTesauro
     */
    public java.lang.Object[] getRutaTesauroAsArray()
    {
        return (rutaTesauro == null) ? null : rutaTesauro.toArray();
    }
    
    public java.lang.Object[] getRutaTesauroBackingList()
    {
        java.lang.Object[] values = this.rutaTesauroValueList;
        java.lang.Object[] labels = this.rutaTesauroLabelList;

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

    public java.lang.Object[] getRutaTesauroValueList()
    {
        return this.rutaTesauroValueList;
    }

    public void setRutaTesauroValueList(java.lang.Object[] rutaTesauroValueList)
    {
        this.rutaTesauroValueList = rutaTesauroValueList;
    }

    public java.lang.Object[] getRutaTesauroLabelList()
    {
        return this.rutaTesauroLabelList;
    }

    public void setRutaTesauroLabelList(java.lang.Object[] rutaTesauroLabelList)
    {
        this.rutaTesauroLabelList = rutaTesauroLabelList;
    }

    public void setRutaTesauroBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setRutaTesauroBackingList requires non-null property arguments");
        }

        this.rutaTesauroValueList = null;
        this.rutaTesauroLabelList = null;

        if (items != null)
        {
            this.rutaTesauroValueList = new java.lang.Object[items.size()];
            this.rutaTesauroLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.rutaTesauroValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.rutaTesauroLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setRutaTesauroBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setSiguienteBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setSiguienteBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idBusqueda</code>.
     */
    public void resetIdBusqueda()
    {
        this.idBusqueda = null;
    }

    public void setIdBusqueda(java.lang.String idBusqueda)
    {
        this.idBusqueda = idBusqueda;
    }

    /**
     * 
     */
    public java.lang.String getIdBusqueda()
    {
        return this.idBusqueda;
    }
    
    public java.lang.Object[] getIdBusquedaBackingList()
    {
        java.lang.Object[] values = this.idBusquedaValueList;
        java.lang.Object[] labels = this.idBusquedaLabelList;

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

    public java.lang.Object[] getIdBusquedaValueList()
    {
        return this.idBusquedaValueList;
    }

    public void setIdBusquedaValueList(java.lang.Object[] idBusquedaValueList)
    {
        this.idBusquedaValueList = idBusquedaValueList;
    }

    public java.lang.Object[] getIdBusquedaLabelList()
    {
        return this.idBusquedaLabelList;
    }

    public void setIdBusquedaLabelList(java.lang.Object[] idBusquedaLabelList)
    {
        this.idBusquedaLabelList = idBusquedaLabelList;
    }

    public void setIdBusquedaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setIdBusquedaBackingList requires non-null property arguments");
        }

        this.idBusquedaValueList = null;
        this.idBusquedaLabelList = null;

        if (items != null)
        {
            this.idBusquedaValueList = new java.lang.Object[items.size()];
            this.idBusquedaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idBusquedaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idBusquedaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setIdBusquedaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setIdTesauroBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setIdTesauroBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tesauroBusqueda</code>.
     */
    public void resetTesauroBusqueda()
    {
        this.tesauroBusqueda = null;
    }

    public void setTesauroBusqueda(java.lang.String tesauroBusqueda)
    {
        this.tesauroBusqueda = tesauroBusqueda;
    }

    /**
     * 
     */
    public java.lang.String getTesauroBusqueda()
    {
        return this.tesauroBusqueda;
    }
    
    public java.lang.Object[] getTesauroBusquedaBackingList()
    {
        java.lang.Object[] values = this.tesauroBusquedaValueList;
        java.lang.Object[] labels = this.tesauroBusquedaLabelList;

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

    public java.lang.Object[] getTesauroBusquedaValueList()
    {
        return this.tesauroBusquedaValueList;
    }

    public void setTesauroBusquedaValueList(java.lang.Object[] tesauroBusquedaValueList)
    {
        this.tesauroBusquedaValueList = tesauroBusquedaValueList;
    }

    public java.lang.Object[] getTesauroBusquedaLabelList()
    {
        return this.tesauroBusquedaLabelList;
    }

    public void setTesauroBusquedaLabelList(java.lang.Object[] tesauroBusquedaLabelList)
    {
        this.tesauroBusquedaLabelList = tesauroBusquedaLabelList;
    }

    public void setTesauroBusquedaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setTesauroBusquedaBackingList requires non-null property arguments");
        }

        this.tesauroBusquedaValueList = null;
        this.tesauroBusquedaLabelList = null;

        if (items != null)
        {
            this.tesauroBusquedaValueList = new java.lang.Object[items.size()];
            this.tesauroBusquedaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tesauroBusquedaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tesauroBusquedaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setTesauroBusquedaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setEsRutaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setEsRutaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setAnteriorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setAnteriorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setPaginaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setPaginaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setNumMaxResultadosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setNumMaxResultadosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setResultadosHastaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setResultadosHastaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setNodoDestinoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setNodoDestinoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setIdentificadorODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setIdentificadorODEBackingList encountered an exception", ex);
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
     * @see es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.ListarODETesauroCUFormImpl#getRutaPadreVO
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setRutaPadreVOBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setRutaPadreVOBackingList encountered an exception", ex);
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
     * @see es.pode.buscador.presentacion.arbolTesauros.listarODETesauro.ListarODETesauroCUFormImpl#getPaginas
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setPaginasBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setPaginasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>resultadosDesde</code>.
     */
    public void resetResultadosDesde()
    {
        this.resultadosDesde = null;
    }

    public void setResultadosDesde(java.lang.String resultadosDesde)
    {
        this.resultadosDesde = resultadosDesde;
    }

    /**
     * 
     */
    public java.lang.String getResultadosDesde()
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setResultadosDesdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setResultadosDesdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nodoOrigen</code>.
     */
    public void resetNodoOrigen()
    {
        this.nodoOrigen = null;
    }

    public void setNodoOrigen(java.lang.String nodoOrigen)
    {
        this.nodoOrigen = nodoOrigen;
    }

    /**
     * 
     */
    public java.lang.String getNodoOrigen()
    {
        return this.nodoOrigen;
    }
    
    public java.lang.Object[] getNodoOrigenBackingList()
    {
        java.lang.Object[] values = this.nodoOrigenValueList;
        java.lang.Object[] labels = this.nodoOrigenLabelList;

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

    public java.lang.Object[] getNodoOrigenValueList()
    {
        return this.nodoOrigenValueList;
    }

    public void setNodoOrigenValueList(java.lang.Object[] nodoOrigenValueList)
    {
        this.nodoOrigenValueList = nodoOrigenValueList;
    }

    public java.lang.Object[] getNodoOrigenLabelList()
    {
        return this.nodoOrigenLabelList;
    }

    public void setNodoOrigenLabelList(java.lang.Object[] nodoOrigenLabelList)
    {
        this.nodoOrigenLabelList = nodoOrigenLabelList;
    }

    public void setNodoOrigenBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setNodoOrigenBackingList requires non-null property arguments");
        }

        this.nodoOrigenValueList = null;
        this.nodoOrigenLabelList = null;

        if (items != null)
        {
            this.nodoOrigenValueList = new java.lang.Object[items.size()];
            this.nodoOrigenLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nodoOrigenValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nodoOrigenLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setNodoOrigenBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setBusquedaSimpleAvanzadaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setBusquedaSimpleAvanzadaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setTituloTesauroBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setTituloTesauroBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>resultadosVO</code>.
     */
    public void resetResultadosVO()
    {
        this.resultadosVO = null;
    }

    public void setResultadosVO(es.pode.buscar.negocio.buscar.servicios.ValoresBusquedaVO[] resultadosVO)
    {
        this.resultadosVO = resultadosVO;
    }

    /**
     * 
     */
    public es.pode.buscar.negocio.buscar.servicios.ValoresBusquedaVO[] getResultadosVO()
    {
        return this.resultadosVO;
    }
    
    public java.lang.Object[] getResultadosVOBackingList()
    {
        java.lang.Object[] values = this.resultadosVOValueList;
        java.lang.Object[] labels = this.resultadosVOLabelList;

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

    public java.lang.Object[] getResultadosVOValueList()
    {
        return this.resultadosVOValueList;
    }

    public void setResultadosVOValueList(java.lang.Object[] resultadosVOValueList)
    {
        this.resultadosVOValueList = resultadosVOValueList;
    }

    public java.lang.Object[] getResultadosVOLabelList()
    {
        return this.resultadosVOLabelList;
    }

    public void setResultadosVOLabelList(java.lang.Object[] resultadosVOLabelList)
    {
        this.resultadosVOLabelList = resultadosVOLabelList;
    }

    public void setResultadosVOBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setResultadosVOBackingList requires non-null property arguments");
        }

        this.resultadosVOValueList = null;
        this.resultadosVOLabelList = null;

        if (items != null)
        {
            this.resultadosVOValueList = new java.lang.Object[items.size()];
            this.resultadosVOLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resultadosVOValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resultadosVOLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setResultadosVOBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>esHoja</code>.
     */
    public void resetEsHoja()
    {
        this.esHoja = false;
    }

    public void setEsHoja(boolean esHoja)
    {
        this.esHoja = esHoja;
    }

    /**
     * 
     */
    public boolean isEsHoja()
    {
        return this.esHoja;
    }
    
    public java.lang.Object[] getEsHojaBackingList()
    {
        java.lang.Object[] values = this.esHojaValueList;
        java.lang.Object[] labels = this.esHojaLabelList;

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

    public java.lang.Object[] getEsHojaValueList()
    {
        return this.esHojaValueList;
    }

    public void setEsHojaValueList(java.lang.Object[] esHojaValueList)
    {
        this.esHojaValueList = esHojaValueList;
    }

    public java.lang.Object[] getEsHojaLabelList()
    {
        return this.esHojaLabelList;
    }

    public void setEsHojaLabelList(java.lang.Object[] esHojaLabelList)
    {
        this.esHojaLabelList = esHojaLabelList;
    }

    public void setEsHojaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setEsHojaBackingList requires non-null property arguments");
        }

        this.esHojaValueList = null;
        this.esHojaLabelList = null;

        if (items != null)
        {
            this.esHojaValueList = new java.lang.Object[items.size()];
            this.esHojaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.esHojaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.esHojaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setEsHojaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setTipoBusquedaArbolBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setTipoBusquedaArbolBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nodo</code>.
     */
    public void resetNodo()
    {
        this.nodo = null;
    }

    public void setNodo(java.lang.String nodo)
    {
        this.nodo = nodo;
    }

    /**
     * 
     */
    public java.lang.String getNodo()
    {
        return this.nodo;
    }
    
    public java.lang.Object[] getNodoBackingList()
    {
        java.lang.Object[] values = this.nodoValueList;
        java.lang.Object[] labels = this.nodoLabelList;

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

    public java.lang.Object[] getNodoValueList()
    {
        return this.nodoValueList;
    }

    public void setNodoValueList(java.lang.Object[] nodoValueList)
    {
        this.nodoValueList = nodoValueList;
    }

    public java.lang.Object[] getNodoLabelList()
    {
        return this.nodoLabelList;
    }

    public void setNodoLabelList(java.lang.Object[] nodoLabelList)
    {
        this.nodoLabelList = nodoLabelList;
    }

    public void setNodoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListarODETesauroCUFormImpl.setNodoBackingList requires non-null property arguments");
        }

        this.nodoValueList = null;
        this.nodoLabelList = null;

        if (items != null)
        {
            this.nodoValueList = new java.lang.Object[items.size()];
            this.nodoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nodoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nodoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListarODETesauroCUFormImpl.setNodoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.rutaTesauro = null;
        this.rutaTesauroValueList = new java.lang.Object[0];
        this.rutaTesauroLabelList = new java.lang.Object[0];
        this.esRuta = false;
        this.rutaPadreVO = null;
        this.rutaPadreVOValueList = new java.lang.Object[0];
        this.rutaPadreVOLabelList = new java.lang.Object[0];
        this.resultadosVO = null;
        this.esHoja = false;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("rutaTesauro", this.rutaTesauro);
        builder.append("siguiente", this.siguiente);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        builder.append("idBusqueda", this.idBusqueda);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("idTesauro", this.idTesauro);
        builder.append("tesauroBusqueda", this.tesauroBusqueda);
        builder.append("esRuta", this.esRuta);
        builder.append("anterior", this.anterior);
        builder.append("pagina", this.pagina);
        builder.append("numMaxResultados", this.numMaxResultados);
        builder.append("resultadosHasta", this.resultadosHasta);
        builder.append("nodoDestino", this.nodoDestino);
        builder.append("identificadorODE", this.identificadorODE);
        builder.append("rutaPadreVO", this.rutaPadreVO);
        builder.append("paginas", this.paginas);
        builder.append("resultadosDesde", this.resultadosDesde);
        builder.append("nodoOrigen", this.nodoOrigen);
        builder.append("busquedaSimpleAvanzada", this.busquedaSimpleAvanzada);
        builder.append("tituloTesauro", this.tituloTesauro);
        builder.append("idioma", this.idioma);
        builder.append("resultadosVO", this.resultadosVO);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        builder.append("esHoja", this.esHoja);
        builder.append("tipoBusquedaArbol", this.tipoBusquedaArbol);
        builder.append("nodo", this.nodo);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.rutaTesauro = null;
        this.rutaTesauroValueList = null;
        this.rutaTesauroLabelList = null;
        this.siguiente = null;
        this.siguienteValueList = null;
        this.siguienteLabelList = null;
        this.tipoLayoutBuscador = null;
        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;
        this.idBusqueda = null;
        this.idBusquedaValueList = null;
        this.idBusquedaLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.idTesauro = null;
        this.idTesauroValueList = null;
        this.idTesauroLabelList = null;
        this.tesauroBusqueda = null;
        this.tesauroBusquedaValueList = null;
        this.tesauroBusquedaLabelList = null;
        this.esRuta = false;
        this.esRutaValueList = null;
        this.esRutaLabelList = null;
        this.anterior = null;
        this.anteriorValueList = null;
        this.anteriorLabelList = null;
        this.pagina = null;
        this.paginaValueList = null;
        this.paginaLabelList = null;
        this.numMaxResultados = null;
        this.numMaxResultadosValueList = null;
        this.numMaxResultadosLabelList = null;
        this.resultadosHasta = null;
        this.resultadosHastaValueList = null;
        this.resultadosHastaLabelList = null;
        this.nodoDestino = null;
        this.nodoDestinoValueList = null;
        this.nodoDestinoLabelList = null;
        this.identificadorODE = null;
        this.identificadorODEValueList = null;
        this.identificadorODELabelList = null;
        this.rutaPadreVO = null;
        this.rutaPadreVOValueList = null;
        this.rutaPadreVOLabelList = null;
        this.paginas = null;
        this.paginasValueList = null;
        this.paginasLabelList = null;
        this.resultadosDesde = null;
        this.resultadosDesdeValueList = null;
        this.resultadosDesdeLabelList = null;
        this.nodoOrigen = null;
        this.nodoOrigenValueList = null;
        this.nodoOrigenLabelList = null;
        this.busquedaSimpleAvanzada = null;
        this.busquedaSimpleAvanzadaValueList = null;
        this.busquedaSimpleAvanzadaLabelList = null;
        this.tituloTesauro = null;
        this.tituloTesauroValueList = null;
        this.tituloTesauroLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.resultadosVO = null;
        this.resultadosVOValueList = null;
        this.resultadosVOLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
        this.esHoja = false;
        this.esHojaValueList = null;
        this.esHojaLabelList = null;
        this.tipoBusquedaArbol = null;
        this.tipoBusquedaArbolValueList = null;
        this.tipoBusquedaArbolLabelList = null;
        this.nodo = null;
        this.nodoValueList = null;
        this.nodoLabelList = null;
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
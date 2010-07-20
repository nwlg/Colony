// license-header java merge-point
package es.pode.buscador.presentacion.arbolCurricular.listarODEArea;

public class ListadoODEDecidirSalidaFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.buscador.presentacion.arbolCurricular.listarODEArea.DecidirSalidaForm
{
    private java.lang.String busquedaSimpleAvanzada;
    private java.lang.Object[] busquedaSimpleAvanzadaValueList;
    private java.lang.Object[] busquedaSimpleAvanzadaLabelList;
    private java.lang.String pagina;
    private java.lang.Object[] paginaValueList;
    private java.lang.Object[] paginaLabelList;
    private java.lang.String identificadorODE;
    private java.lang.Object[] identificadorODEValueList;
    private java.lang.Object[] identificadorODELabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.lang.String areaCurricularBusqueda;
    private java.lang.Object[] areaCurricularBusquedaValueList;
    private java.lang.Object[] areaCurricularBusquedaLabelList;
    private java.util.Collection rutaArbol;
    private java.lang.Object[] rutaArbolValueList;
    private java.lang.Object[] rutaArbolLabelList;
    private java.lang.String tipoBusquedaArbol;
    private java.lang.Object[] tipoBusquedaArbolValueList;
    private java.lang.Object[] tipoBusquedaArbolLabelList;
    private java.lang.String nodo;
    private java.lang.Object[] nodoValueList;
    private java.lang.Object[] nodoLabelList;
    private java.lang.String idiomaBusqueda;
    private java.lang.Object[] idiomaBusquedaValueList;
    private java.lang.Object[] idiomaBusquedaLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;

    public ListadoODEDecidirSalidaFormImpl()
    {
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
            throw new IllegalArgumentException("ListadoODEDecidirSalidaFormImpl.setBusquedaSimpleAvanzadaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoODEDecidirSalidaFormImpl.setBusquedaSimpleAvanzadaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListadoODEDecidirSalidaFormImpl.setPaginaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoODEDecidirSalidaFormImpl.setPaginaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListadoODEDecidirSalidaFormImpl.setIdentificadorODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoODEDecidirSalidaFormImpl.setIdentificadorODEBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListadoODEDecidirSalidaFormImpl.setIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoODEDecidirSalidaFormImpl.setIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>areaCurricularBusqueda</code>.
     */
    public void resetAreaCurricularBusqueda()
    {
        this.areaCurricularBusqueda = null;
    }

    public void setAreaCurricularBusqueda(java.lang.String areaCurricularBusqueda)
    {
        this.areaCurricularBusqueda = areaCurricularBusqueda;
    }

    /**
     * 
     */
    public java.lang.String getAreaCurricularBusqueda()
    {
        return this.areaCurricularBusqueda;
    }
    
    public java.lang.Object[] getAreaCurricularBusquedaBackingList()
    {
        java.lang.Object[] values = this.areaCurricularBusquedaValueList;
        java.lang.Object[] labels = this.areaCurricularBusquedaLabelList;

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

    public java.lang.Object[] getAreaCurricularBusquedaValueList()
    {
        return this.areaCurricularBusquedaValueList;
    }

    public void setAreaCurricularBusquedaValueList(java.lang.Object[] areaCurricularBusquedaValueList)
    {
        this.areaCurricularBusquedaValueList = areaCurricularBusquedaValueList;
    }

    public java.lang.Object[] getAreaCurricularBusquedaLabelList()
    {
        return this.areaCurricularBusquedaLabelList;
    }

    public void setAreaCurricularBusquedaLabelList(java.lang.Object[] areaCurricularBusquedaLabelList)
    {
        this.areaCurricularBusquedaLabelList = areaCurricularBusquedaLabelList;
    }

    public void setAreaCurricularBusquedaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoODEDecidirSalidaFormImpl.setAreaCurricularBusquedaBackingList requires non-null property arguments");
        }

        this.areaCurricularBusquedaValueList = null;
        this.areaCurricularBusquedaLabelList = null;

        if (items != null)
        {
            this.areaCurricularBusquedaValueList = new java.lang.Object[items.size()];
            this.areaCurricularBusquedaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.areaCurricularBusquedaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.areaCurricularBusquedaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoODEDecidirSalidaFormImpl.setAreaCurricularBusquedaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>rutaArbol</code>.
     */
    public void resetRutaArbol()
    {
        this.rutaArbol = null;
    }

    public void setRutaArbol(java.util.Collection rutaArbol)
    {
        this.rutaArbol = rutaArbol;
    }

    /**
     * 
     */
    public java.util.Collection getRutaArbol()
    {
        return this.rutaArbol;
    }

    public void setRutaArbolAsArray(Object[] rutaArbol)
    {
        this.rutaArbol = (rutaArbol == null) ? null : java.util.Arrays.asList(rutaArbol);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.buscador.presentacion.arbolCurricular.listarODEArea.ListadoODEDecidirSalidaFormImpl#getRutaArbol
     */
    public java.lang.Object[] getRutaArbolAsArray()
    {
        return (rutaArbol == null) ? null : rutaArbol.toArray();
    }
    
    public java.lang.Object[] getRutaArbolBackingList()
    {
        java.lang.Object[] values = this.rutaArbolValueList;
        java.lang.Object[] labels = this.rutaArbolLabelList;

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

    public java.lang.Object[] getRutaArbolValueList()
    {
        return this.rutaArbolValueList;
    }

    public void setRutaArbolValueList(java.lang.Object[] rutaArbolValueList)
    {
        this.rutaArbolValueList = rutaArbolValueList;
    }

    public java.lang.Object[] getRutaArbolLabelList()
    {
        return this.rutaArbolLabelList;
    }

    public void setRutaArbolLabelList(java.lang.Object[] rutaArbolLabelList)
    {
        this.rutaArbolLabelList = rutaArbolLabelList;
    }

    public void setRutaArbolBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoODEDecidirSalidaFormImpl.setRutaArbolBackingList requires non-null property arguments");
        }

        this.rutaArbolValueList = null;
        this.rutaArbolLabelList = null;

        if (items != null)
        {
            this.rutaArbolValueList = new java.lang.Object[items.size()];
            this.rutaArbolLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.rutaArbolValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.rutaArbolLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoODEDecidirSalidaFormImpl.setRutaArbolBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListadoODEDecidirSalidaFormImpl.setTipoBusquedaArbolBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoODEDecidirSalidaFormImpl.setTipoBusquedaArbolBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListadoODEDecidirSalidaFormImpl.setNodoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoODEDecidirSalidaFormImpl.setNodoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomaBusqueda</code>.
     */
    public void resetIdiomaBusqueda()
    {
        this.idiomaBusqueda = null;
    }

    public void setIdiomaBusqueda(java.lang.String idiomaBusqueda)
    {
        this.idiomaBusqueda = idiomaBusqueda;
    }

    /**
     * 
     */
    public java.lang.String getIdiomaBusqueda()
    {
        return this.idiomaBusqueda;
    }
    
    public java.lang.Object[] getIdiomaBusquedaBackingList()
    {
        java.lang.Object[] values = this.idiomaBusquedaValueList;
        java.lang.Object[] labels = this.idiomaBusquedaLabelList;

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

    public java.lang.Object[] getIdiomaBusquedaValueList()
    {
        return this.idiomaBusquedaValueList;
    }

    public void setIdiomaBusquedaValueList(java.lang.Object[] idiomaBusquedaValueList)
    {
        this.idiomaBusquedaValueList = idiomaBusquedaValueList;
    }

    public java.lang.Object[] getIdiomaBusquedaLabelList()
    {
        return this.idiomaBusquedaLabelList;
    }

    public void setIdiomaBusquedaLabelList(java.lang.Object[] idiomaBusquedaLabelList)
    {
        this.idiomaBusquedaLabelList = idiomaBusquedaLabelList;
    }

    public void setIdiomaBusquedaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoODEDecidirSalidaFormImpl.setIdiomaBusquedaBackingList requires non-null property arguments");
        }

        this.idiomaBusquedaValueList = null;
        this.idiomaBusquedaLabelList = null;

        if (items != null)
        {
            this.idiomaBusquedaValueList = new java.lang.Object[items.size()];
            this.idiomaBusquedaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomaBusquedaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomaBusquedaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoODEDecidirSalidaFormImpl.setIdiomaBusquedaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListadoODEDecidirSalidaFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoODEDecidirSalidaFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.rutaArbol = null;
        this.rutaArbolValueList = new java.lang.Object[0];
        this.rutaArbolLabelList = new java.lang.Object[0];
        this.idiomaBuscador = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("busquedaSimpleAvanzada", this.busquedaSimpleAvanzada);
        builder.append("pagina", this.pagina);
        builder.append("identificadorODE", this.identificadorODE);
        builder.append("idioma", this.idioma);
        builder.append("areaCurricularBusqueda", this.areaCurricularBusqueda);
        builder.append("rutaArbol", this.rutaArbol);
        builder.append("tipoBusquedaArbol", this.tipoBusquedaArbol);
        builder.append("nodo", this.nodo);
        builder.append("idiomaBusqueda", this.idiomaBusqueda);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.busquedaSimpleAvanzada = null;
        this.busquedaSimpleAvanzadaValueList = null;
        this.busquedaSimpleAvanzadaLabelList = null;
        this.pagina = null;
        this.paginaValueList = null;
        this.paginaLabelList = null;
        this.identificadorODE = null;
        this.identificadorODEValueList = null;
        this.identificadorODELabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.areaCurricularBusqueda = null;
        this.areaCurricularBusquedaValueList = null;
        this.areaCurricularBusquedaLabelList = null;
        this.rutaArbol = null;
        this.rutaArbolValueList = null;
        this.rutaArbolLabelList = null;
        this.tipoBusquedaArbol = null;
        this.tipoBusquedaArbolValueList = null;
        this.tipoBusquedaArbolLabelList = null;
        this.nodo = null;
        this.nodoValueList = null;
        this.nodoLabelList = null;
        this.idiomaBusqueda = null;
        this.idiomaBusquedaValueList = null;
        this.idiomaBusquedaLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
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
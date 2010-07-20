// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

public class MostrarDetalleODEVolverBusquedaFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.buscador.presentacion.basico.detallar.DeterminaAtrasForm
{
    private java.lang.String busquedaSimpleAvanzada;
    private java.lang.Object[] busquedaSimpleAvanzadaValueList;
    private java.lang.Object[] busquedaSimpleAvanzadaLabelList;
    private java.lang.String autor;
    private java.lang.Object[] autorValueList;
    private java.lang.Object[] autorLabelList;
    private java.lang.String buscadorContenido;
    private java.lang.Object[] buscadorContenidoValueList;
    private java.lang.Object[] buscadorContenidoLabelList;
    private java.lang.String areaCurricularBusqueda;
    private java.lang.Object[] areaCurricularBusquedaValueList;
    private java.lang.Object[] areaCurricularBusquedaLabelList;
    private java.lang.String tipoVisualizacion;
    private java.lang.Object[] tipoVisualizacionValueList;
    private java.lang.Object[] tipoVisualizacionLabelList;
    private java.lang.String descripcion;
    private java.lang.Object[] descripcionValueList;
    private java.lang.Object[] descripcionLabelList;
    private java.lang.String tipoLayoutBuscador;
    private java.lang.Object[] tipoLayoutBuscadorValueList;
    private java.lang.Object[] tipoLayoutBuscadorLabelList;
    private java.lang.String formato;
    private java.lang.Object[] formatoValueList;
    private java.lang.Object[] formatoLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.String anyoPublicacion;
    private java.lang.Object[] anyoPublicacionValueList;
    private java.lang.Object[] anyoPublicacionLabelList;
    private java.lang.String procesoCognitivo;
    private java.lang.Object[] procesoCognitivoValueList;
    private java.lang.Object[] procesoCognitivoLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private java.lang.String tesauroBusqueda;
    private java.lang.Object[] tesauroBusquedaValueList;
    private java.lang.Object[] tesauroBusquedaLabelList;
    private java.lang.String areaCurricular;
    private java.lang.Object[] areaCurricularValueList;
    private java.lang.Object[] areaCurricularLabelList;
    private java.lang.String titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.lang.String valoracion;
    private java.lang.Object[] valoracionValueList;
    private java.lang.Object[] valoracionLabelList;
    private java.lang.String pagina;
    private java.lang.Object[] paginaValueList;
    private java.lang.Object[] paginaLabelList;
    private java.lang.String edad;
    private java.lang.Object[] edadValueList;
    private java.lang.Object[] edadLabelList;
    private java.lang.String tipoBusquedaArbol;
    private java.lang.Object[] tipoBusquedaArbolValueList;
    private java.lang.Object[] tipoBusquedaArbolLabelList;
    private java.lang.String c_s_secuencia;
    private java.lang.Object[] c_s_secuenciaValueList;
    private java.lang.Object[] c_s_secuenciaLabelList;
    private java.lang.String diaPublicacion;
    private java.lang.Object[] diaPublicacionValueList;
    private java.lang.Object[] diaPublicacionLabelList;
    private java.lang.String mesPublicacion;
    private java.lang.Object[] mesPublicacionValueList;
    private java.lang.Object[] mesPublicacionLabelList;
    private java.lang.String recurso;
    private java.lang.Object[] recursoValueList;
    private java.lang.Object[] recursoLabelList;
    private java.lang.String contexto;
    private java.lang.Object[] contextoValueList;
    private java.lang.Object[] contextoLabelList;

    public MostrarDetalleODEVolverBusquedaFormImpl()
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
     * <p>
     * Este parametro determina si el detalle de la busqueda se ha
     * alcanzado desde el listado de resultados producidos por una
     * busqueda basica o avanzada.
     * </p>
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setBusquedaSimpleAvanzadaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setBusquedaSimpleAvanzadaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setAutorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setAutorBackingList encountered an exception", ex);
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
     * <p>
     * Se trata del contenido de la caja de busqueda que ha llevado a
     * este resultado de busqueda.
     * </p>
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setBuscadorContenidoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setBuscadorContenidoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setAreaCurricularBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setAreaCurricularBusquedaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setTipoVisualizacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setTipoVisualizacionBackingList encountered an exception", ex);
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

    public void setDescripcion(java.lang.String descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * 
     */
    public java.lang.String getDescripcion()
    {
        return this.descripcion;
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setDescripcionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setDescripcionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setFormatoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setFormatoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setAnyoPublicacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setAnyoPublicacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setProcesoCognitivoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setProcesoCognitivoBackingList encountered an exception", ex);
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
     * Se trata del idioma seleccionado en la pantalla del buscador.
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setTesauroBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setTesauroBusquedaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setAreaCurricularBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setAreaCurricularBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setTituloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setTituloBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setValoracionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setValoracionBackingList encountered an exception", ex);
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
     * <p>
     * Se trata de la pagina en la que se encuentra el resultado de
     * busqueda del que se estan mostrando los detalles.
     * </p>
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setPaginaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setPaginaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setEdadBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setEdadBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setTipoBusquedaArbolBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setTipoBusquedaArbolBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setC_s_secuenciaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setC_s_secuenciaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setDiaPublicacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setDiaPublicacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setMesPublicacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setMesPublicacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setRecursoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setRecursoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEVolverBusquedaFormImpl.setContextoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEVolverBusquedaFormImpl.setContextoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.idiomaBuscador = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("busquedaSimpleAvanzada", this.busquedaSimpleAvanzada);
        builder.append("autor", this.autor);
        builder.append("buscadorContenido", this.buscadorContenido);
        builder.append("areaCurricularBusqueda", this.areaCurricularBusqueda);
        builder.append("tipoVisualizacion", this.tipoVisualizacion);
        builder.append("descripcion", this.descripcion);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        builder.append("formato", this.formato);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("anyoPublicacion", this.anyoPublicacion);
        builder.append("procesoCognitivo", this.procesoCognitivo);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        builder.append("tesauroBusqueda", this.tesauroBusqueda);
        builder.append("areaCurricular", this.areaCurricular);
        builder.append("titulo", this.titulo);
        builder.append("valoracion", this.valoracion);
        builder.append("pagina", this.pagina);
        builder.append("edad", this.edad);
        builder.append("tipoBusquedaArbol", this.tipoBusquedaArbol);
        builder.append("c_s_secuencia", this.c_s_secuencia);
        builder.append("diaPublicacion", this.diaPublicacion);
        builder.append("mesPublicacion", this.mesPublicacion);
        builder.append("recurso", this.recurso);
        builder.append("contexto", this.contexto);
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
        this.autor = null;
        this.autorValueList = null;
        this.autorLabelList = null;
        this.buscadorContenido = null;
        this.buscadorContenidoValueList = null;
        this.buscadorContenidoLabelList = null;
        this.areaCurricularBusqueda = null;
        this.areaCurricularBusquedaValueList = null;
        this.areaCurricularBusquedaLabelList = null;
        this.tipoVisualizacion = null;
        this.tipoVisualizacionValueList = null;
        this.tipoVisualizacionLabelList = null;
        this.descripcion = null;
        this.descripcionValueList = null;
        this.descripcionLabelList = null;
        this.tipoLayoutBuscador = null;
        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;
        this.formato = null;
        this.formatoValueList = null;
        this.formatoLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.anyoPublicacion = null;
        this.anyoPublicacionValueList = null;
        this.anyoPublicacionLabelList = null;
        this.procesoCognitivo = null;
        this.procesoCognitivoValueList = null;
        this.procesoCognitivoLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
        this.tesauroBusqueda = null;
        this.tesauroBusquedaValueList = null;
        this.tesauroBusquedaLabelList = null;
        this.areaCurricular = null;
        this.areaCurricularValueList = null;
        this.areaCurricularLabelList = null;
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.valoracion = null;
        this.valoracionValueList = null;
        this.valoracionLabelList = null;
        this.pagina = null;
        this.paginaValueList = null;
        this.paginaLabelList = null;
        this.edad = null;
        this.edadValueList = null;
        this.edadLabelList = null;
        this.tipoBusquedaArbol = null;
        this.tipoBusquedaArbolValueList = null;
        this.tipoBusquedaArbolLabelList = null;
        this.c_s_secuencia = null;
        this.c_s_secuenciaValueList = null;
        this.c_s_secuenciaLabelList = null;
        this.diaPublicacion = null;
        this.diaPublicacionValueList = null;
        this.diaPublicacionLabelList = null;
        this.mesPublicacion = null;
        this.mesPublicacionValueList = null;
        this.mesPublicacionLabelList = null;
        this.recurso = null;
        this.recursoValueList = null;
        this.recursoLabelList = null;
        this.contexto = null;
        this.contextoValueList = null;
        this.contextoLabelList = null;
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
// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

public class MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.buscador.presentacion.avanzado.buscarAvanzado.CargaFormularioBusquedaAvanzadaForm
{
    private java.lang.String nomTesauros;
    private java.lang.Object[] nomTesaurosValueList;
    private java.lang.Object[] nomTesaurosLabelList;
    private java.lang.String buscadorContenido;
    private java.lang.Object[] buscadorContenidoValueList;
    private java.lang.Object[] buscadorContenidoLabelList;
    private java.lang.String contadorAmbito;
    private java.lang.Object[] contadorAmbitoValueList;
    private java.lang.Object[] contadorAmbitoLabelList;
    private java.lang.String tipoLayoutBuscador;
    private java.lang.Object[] tipoLayoutBuscadorValueList;
    private java.lang.Object[] tipoLayoutBuscadorLabelList;
    private java.lang.String formato;
    private java.lang.Object[] formatoValueList;
    private java.lang.Object[] formatoLabelList;
    private java.lang.String contadorTesauros;
    private java.lang.Object[] contadorTesaurosValueList;
    private java.lang.Object[] contadorTesaurosLabelList;
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
    private java.lang.String anterior;
    private java.lang.Object[] anteriorValueList;
    private java.lang.Object[] anteriorLabelList;
    private java.lang.String valoracion;
    private java.lang.Object[] valoracionValueList;
    private java.lang.Object[] valoracionLabelList;
    private java.lang.String[] comunidadesSeleccionadas;
    private java.lang.Object[] comunidadesSeleccionadasValueList;
    private java.lang.Object[] comunidadesSeleccionadasLabelList;
    private java.lang.String validado;
    private java.lang.Object[] validadoValueList;
    private java.lang.Object[] validadoLabelList;
    private java.lang.String contadorPropiedadesContenido;
    private java.lang.Object[] contadorPropiedadesContenidoValueList;
    private java.lang.Object[] contadorPropiedadesContenidoLabelList;
    private java.lang.String edad;
    private java.lang.Object[] edadValueList;
    private java.lang.Object[] edadLabelList;
    private java.lang.String c_s_secuencia;
    private java.lang.Object[] c_s_secuenciaValueList;
    private java.lang.Object[] c_s_secuenciaLabelList;
    private java.lang.String enlaceComunidadesSeleccionadas;
    private java.lang.Object[] enlaceComunidadesSeleccionadasValueList;
    private java.lang.Object[] enlaceComunidadesSeleccionadasLabelList;
    private java.lang.String diaPublicacion;
    private java.lang.Object[] diaPublicacionValueList;
    private java.lang.Object[] diaPublicacionLabelList;
    private java.lang.String recurso;
    private java.lang.Object[] recursoValueList;
    private java.lang.Object[] recursoLabelList;
    private java.lang.String areaCurricularTexto;
    private java.lang.Object[] areaCurricularTextoValueList;
    private java.lang.Object[] areaCurricularTextoLabelList;
    private java.lang.String contexto;
    private java.lang.Object[] contextoValueList;
    private java.lang.Object[] contextoLabelList;
    private java.lang.String destinatarios;
    private java.lang.Object[] destinatariosValueList;
    private java.lang.Object[] destinatariosLabelList;
    private java.lang.String autor;
    private java.lang.Object[] autorValueList;
    private java.lang.Object[] autorLabelList;
    private java.lang.String descripcion;
    private java.lang.Object[] descripcionValueList;
    private java.lang.Object[] descripcionLabelList;
    private java.lang.String nivelAgregacion;
    private java.lang.Object[] nivelAgregacionValueList;
    private java.lang.Object[] nivelAgregacionLabelList;
    private java.lang.String horaPublicacion;
    private java.lang.Object[] horaPublicacionValueList;
    private java.lang.Object[] horaPublicacionLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private java.lang.String procesoCognitivo;
    private java.lang.Object[] procesoCognitivoValueList;
    private java.lang.Object[] procesoCognitivoLabelList;
    private java.lang.Boolean mostrarAmbito;
    private java.lang.Object[] mostrarAmbitoValueList;
    private java.lang.Object[] mostrarAmbitoLabelList;
    private java.lang.String titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.lang.String contadorAreasCurriculares;
    private java.lang.Object[] contadorAreasCurricularesValueList;
    private java.lang.Object[] contadorAreasCurricularesLabelList;
    private java.lang.String enlaceTodoAgrega;
    private java.lang.Object[] enlaceTodoAgregaValueList;
    private java.lang.Object[] enlaceTodoAgregaLabelList;
    private java.lang.String mesPublicacion;
    private java.lang.Object[] mesPublicacionValueList;
    private java.lang.Object[] mesPublicacionLabelList;
    private java.util.List comunidades;
    private java.lang.Object[] comunidadesValueList;
    private java.lang.Object[] comunidadesLabelList;
    private boolean sinResultados;
    private java.lang.Object[] sinResultadosValueList;
    private java.lang.Object[] sinResultadosLabelList;

    public MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl()
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setNomTesaurosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setNomTesaurosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setBuscadorContenidoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setBuscadorContenidoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>contadorAmbito</code>.
     */
    public void resetContadorAmbito()
    {
        this.contadorAmbito = null;
    }

    public void setContadorAmbito(java.lang.String contadorAmbito)
    {
        this.contadorAmbito = contadorAmbito;
    }

    /**
     * 
     */
    public java.lang.String getContadorAmbito()
    {
        return this.contadorAmbito;
    }
    
    public java.lang.Object[] getContadorAmbitoBackingList()
    {
        java.lang.Object[] values = this.contadorAmbitoValueList;
        java.lang.Object[] labels = this.contadorAmbitoLabelList;

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

    public java.lang.Object[] getContadorAmbitoValueList()
    {
        return this.contadorAmbitoValueList;
    }

    public void setContadorAmbitoValueList(java.lang.Object[] contadorAmbitoValueList)
    {
        this.contadorAmbitoValueList = contadorAmbitoValueList;
    }

    public java.lang.Object[] getContadorAmbitoLabelList()
    {
        return this.contadorAmbitoLabelList;
    }

    public void setContadorAmbitoLabelList(java.lang.Object[] contadorAmbitoLabelList)
    {
        this.contadorAmbitoLabelList = contadorAmbitoLabelList;
    }

    public void setContadorAmbitoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setContadorAmbitoBackingList requires non-null property arguments");
        }

        this.contadorAmbitoValueList = null;
        this.contadorAmbitoLabelList = null;

        if (items != null)
        {
            this.contadorAmbitoValueList = new java.lang.Object[items.size()];
            this.contadorAmbitoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.contadorAmbitoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.contadorAmbitoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setContadorAmbitoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setFormatoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setFormatoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>contadorTesauros</code>.
     */
    public void resetContadorTesauros()
    {
        this.contadorTesauros = null;
    }

    public void setContadorTesauros(java.lang.String contadorTesauros)
    {
        this.contadorTesauros = contadorTesauros;
    }

    /**
     * 
     */
    public java.lang.String getContadorTesauros()
    {
        return this.contadorTesauros;
    }
    
    public java.lang.Object[] getContadorTesaurosBackingList()
    {
        java.lang.Object[] values = this.contadorTesaurosValueList;
        java.lang.Object[] labels = this.contadorTesaurosLabelList;

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

    public java.lang.Object[] getContadorTesaurosValueList()
    {
        return this.contadorTesaurosValueList;
    }

    public void setContadorTesaurosValueList(java.lang.Object[] contadorTesaurosValueList)
    {
        this.contadorTesaurosValueList = contadorTesaurosValueList;
    }

    public java.lang.Object[] getContadorTesaurosLabelList()
    {
        return this.contadorTesaurosLabelList;
    }

    public void setContadorTesaurosLabelList(java.lang.Object[] contadorTesaurosLabelList)
    {
        this.contadorTesaurosLabelList = contadorTesaurosLabelList;
    }

    public void setContadorTesaurosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setContadorTesaurosBackingList requires non-null property arguments");
        }

        this.contadorTesaurosValueList = null;
        this.contadorTesaurosLabelList = null;

        if (items != null)
        {
            this.contadorTesaurosValueList = new java.lang.Object[items.size()];
            this.contadorTesaurosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.contadorTesaurosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.contadorTesaurosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setContadorTesaurosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setIdTesauroBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setIdTesauroBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setAnyoPublicacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setAnyoPublicacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setAreaCurricularBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setAreaCurricularBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setAnteriorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setAnteriorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setValoracionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setValoracionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setComunidadesSeleccionadasBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setComunidadesSeleccionadasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>validado</code>.
     */
    public void resetValidado()
    {
        this.validado = null;
    }

    public void setValidado(java.lang.String validado)
    {
        this.validado = validado;
    }

    /**
     * 
     */
    public java.lang.String getValidado()
    {
        return this.validado;
    }
    
    public java.lang.Object[] getValidadoBackingList()
    {
        java.lang.Object[] values = this.validadoValueList;
        java.lang.Object[] labels = this.validadoLabelList;

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

    public java.lang.Object[] getValidadoValueList()
    {
        return this.validadoValueList;
    }

    public void setValidadoValueList(java.lang.Object[] validadoValueList)
    {
        this.validadoValueList = validadoValueList;
    }

    public java.lang.Object[] getValidadoLabelList()
    {
        return this.validadoLabelList;
    }

    public void setValidadoLabelList(java.lang.Object[] validadoLabelList)
    {
        this.validadoLabelList = validadoLabelList;
    }

    public void setValidadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setValidadoBackingList requires non-null property arguments");
        }

        this.validadoValueList = null;
        this.validadoLabelList = null;

        if (items != null)
        {
            this.validadoValueList = new java.lang.Object[items.size()];
            this.validadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.validadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.validadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setValidadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>contadorPropiedadesContenido</code>.
     */
    public void resetContadorPropiedadesContenido()
    {
        this.contadorPropiedadesContenido = null;
    }

    public void setContadorPropiedadesContenido(java.lang.String contadorPropiedadesContenido)
    {
        this.contadorPropiedadesContenido = contadorPropiedadesContenido;
    }

    /**
     * 
     */
    public java.lang.String getContadorPropiedadesContenido()
    {
        return this.contadorPropiedadesContenido;
    }
    
    public java.lang.Object[] getContadorPropiedadesContenidoBackingList()
    {
        java.lang.Object[] values = this.contadorPropiedadesContenidoValueList;
        java.lang.Object[] labels = this.contadorPropiedadesContenidoLabelList;

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

    public java.lang.Object[] getContadorPropiedadesContenidoValueList()
    {
        return this.contadorPropiedadesContenidoValueList;
    }

    public void setContadorPropiedadesContenidoValueList(java.lang.Object[] contadorPropiedadesContenidoValueList)
    {
        this.contadorPropiedadesContenidoValueList = contadorPropiedadesContenidoValueList;
    }

    public java.lang.Object[] getContadorPropiedadesContenidoLabelList()
    {
        return this.contadorPropiedadesContenidoLabelList;
    }

    public void setContadorPropiedadesContenidoLabelList(java.lang.Object[] contadorPropiedadesContenidoLabelList)
    {
        this.contadorPropiedadesContenidoLabelList = contadorPropiedadesContenidoLabelList;
    }

    public void setContadorPropiedadesContenidoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setContadorPropiedadesContenidoBackingList requires non-null property arguments");
        }

        this.contadorPropiedadesContenidoValueList = null;
        this.contadorPropiedadesContenidoLabelList = null;

        if (items != null)
        {
            this.contadorPropiedadesContenidoValueList = new java.lang.Object[items.size()];
            this.contadorPropiedadesContenidoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.contadorPropiedadesContenidoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.contadorPropiedadesContenidoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setContadorPropiedadesContenidoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setEdadBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setEdadBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setC_s_secuenciaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setC_s_secuenciaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setEnlaceComunidadesSeleccionadasBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setEnlaceComunidadesSeleccionadasBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setDiaPublicacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setDiaPublicacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setRecursoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setRecursoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>areaCurricularTexto</code>.
     */
    public void resetAreaCurricularTexto()
    {
        this.areaCurricularTexto = null;
    }

    public void setAreaCurricularTexto(java.lang.String areaCurricularTexto)
    {
        this.areaCurricularTexto = areaCurricularTexto;
    }

    /**
     * 
     */
    public java.lang.String getAreaCurricularTexto()
    {
        return this.areaCurricularTexto;
    }
    
    public java.lang.Object[] getAreaCurricularTextoBackingList()
    {
        java.lang.Object[] values = this.areaCurricularTextoValueList;
        java.lang.Object[] labels = this.areaCurricularTextoLabelList;

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

    public java.lang.Object[] getAreaCurricularTextoValueList()
    {
        return this.areaCurricularTextoValueList;
    }

    public void setAreaCurricularTextoValueList(java.lang.Object[] areaCurricularTextoValueList)
    {
        this.areaCurricularTextoValueList = areaCurricularTextoValueList;
    }

    public java.lang.Object[] getAreaCurricularTextoLabelList()
    {
        return this.areaCurricularTextoLabelList;
    }

    public void setAreaCurricularTextoLabelList(java.lang.Object[] areaCurricularTextoLabelList)
    {
        this.areaCurricularTextoLabelList = areaCurricularTextoLabelList;
    }

    public void setAreaCurricularTextoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setAreaCurricularTextoBackingList requires non-null property arguments");
        }

        this.areaCurricularTextoValueList = null;
        this.areaCurricularTextoLabelList = null;

        if (items != null)
        {
            this.areaCurricularTextoValueList = new java.lang.Object[items.size()];
            this.areaCurricularTextoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.areaCurricularTextoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.areaCurricularTextoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setAreaCurricularTextoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setContextoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setContextoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setDestinatariosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setDestinatariosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setAutorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setAutorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setDescripcionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setDescripcionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setNivelAgregacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setNivelAgregacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>horaPublicacion</code>.
     */
    public void resetHoraPublicacion()
    {
        this.horaPublicacion = null;
    }

    public void setHoraPublicacion(java.lang.String horaPublicacion)
    {
        this.horaPublicacion = horaPublicacion;
    }

    /**
     * <p>
     * hora en que ha sido publicado el ODE
     * </p>
     */
    public java.lang.String getHoraPublicacion()
    {
        return this.horaPublicacion;
    }
    
    public java.lang.Object[] getHoraPublicacionBackingList()
    {
        java.lang.Object[] values = this.horaPublicacionValueList;
        java.lang.Object[] labels = this.horaPublicacionLabelList;

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

    public java.lang.Object[] getHoraPublicacionValueList()
    {
        return this.horaPublicacionValueList;
    }

    public void setHoraPublicacionValueList(java.lang.Object[] horaPublicacionValueList)
    {
        this.horaPublicacionValueList = horaPublicacionValueList;
    }

    public java.lang.Object[] getHoraPublicacionLabelList()
    {
        return this.horaPublicacionLabelList;
    }

    public void setHoraPublicacionLabelList(java.lang.Object[] horaPublicacionLabelList)
    {
        this.horaPublicacionLabelList = horaPublicacionLabelList;
    }

    public void setHoraPublicacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setHoraPublicacionBackingList requires non-null property arguments");
        }

        this.horaPublicacionValueList = null;
        this.horaPublicacionLabelList = null;

        if (items != null)
        {
            this.horaPublicacionValueList = new java.lang.Object[items.size()];
            this.horaPublicacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.horaPublicacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.horaPublicacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setHoraPublicacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setProcesoCognitivoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setProcesoCognitivoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setMostrarAmbitoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setMostrarAmbitoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setTituloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setTituloBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>contadorAreasCurriculares</code>.
     */
    public void resetContadorAreasCurriculares()
    {
        this.contadorAreasCurriculares = null;
    }

    public void setContadorAreasCurriculares(java.lang.String contadorAreasCurriculares)
    {
        this.contadorAreasCurriculares = contadorAreasCurriculares;
    }

    /**
     * 
     */
    public java.lang.String getContadorAreasCurriculares()
    {
        return this.contadorAreasCurriculares;
    }
    
    public java.lang.Object[] getContadorAreasCurricularesBackingList()
    {
        java.lang.Object[] values = this.contadorAreasCurricularesValueList;
        java.lang.Object[] labels = this.contadorAreasCurricularesLabelList;

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

    public java.lang.Object[] getContadorAreasCurricularesValueList()
    {
        return this.contadorAreasCurricularesValueList;
    }

    public void setContadorAreasCurricularesValueList(java.lang.Object[] contadorAreasCurricularesValueList)
    {
        this.contadorAreasCurricularesValueList = contadorAreasCurricularesValueList;
    }

    public java.lang.Object[] getContadorAreasCurricularesLabelList()
    {
        return this.contadorAreasCurricularesLabelList;
    }

    public void setContadorAreasCurricularesLabelList(java.lang.Object[] contadorAreasCurricularesLabelList)
    {
        this.contadorAreasCurricularesLabelList = contadorAreasCurricularesLabelList;
    }

    public void setContadorAreasCurricularesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setContadorAreasCurricularesBackingList requires non-null property arguments");
        }

        this.contadorAreasCurricularesValueList = null;
        this.contadorAreasCurricularesLabelList = null;

        if (items != null)
        {
            this.contadorAreasCurricularesValueList = new java.lang.Object[items.size()];
            this.contadorAreasCurricularesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.contadorAreasCurricularesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.contadorAreasCurricularesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setContadorAreasCurricularesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setEnlaceTodoAgregaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setEnlaceTodoAgregaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setMesPublicacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setMesPublicacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comunidades</code>.
     */
    public void resetComunidades()
    {
        this.comunidades = null;
    }

    public void setComunidades(java.util.List comunidades)
    {
        this.comunidades = comunidades;
    }

    /**
     * 
     */
    public java.util.List getComunidades()
    {
        return this.comunidades;
    }

    public void setComunidadesAsArray(Object[] comunidades)
    {
        this.comunidades = (comunidades == null) ? null : java.util.Arrays.asList(comunidades);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl#getComunidades
     */
    public java.lang.Object[] getComunidadesAsArray()
    {
        return (comunidades == null) ? null : comunidades.toArray();
    }
    
    public java.lang.Object[] getComunidadesBackingList()
    {
        java.lang.Object[] values = this.comunidadesValueList;
        java.lang.Object[] labels = this.comunidadesLabelList;

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

    public java.lang.Object[] getComunidadesValueList()
    {
        return this.comunidadesValueList;
    }

    public void setComunidadesValueList(java.lang.Object[] comunidadesValueList)
    {
        this.comunidadesValueList = comunidadesValueList;
    }

    public java.lang.Object[] getComunidadesLabelList()
    {
        return this.comunidadesLabelList;
    }

    public void setComunidadesLabelList(java.lang.Object[] comunidadesLabelList)
    {
        this.comunidadesLabelList = comunidadesLabelList;
    }

    public void setComunidadesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setComunidadesBackingList requires non-null property arguments");
        }

        this.comunidadesValueList = null;
        this.comunidadesLabelList = null;

        if (items != null)
        {
            this.comunidadesValueList = new java.lang.Object[items.size()];
            this.comunidadesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comunidadesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comunidadesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setComunidadesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>sinResultados</code>.
     */
    public void resetSinResultados()
    {
        this.sinResultados = false;
    }

    public void setSinResultados(boolean sinResultados)
    {
        this.sinResultados = sinResultados;
    }

    /**
     * 
     */
    public boolean isSinResultados()
    {
        return this.sinResultados;
    }
    
    public java.lang.Object[] getSinResultadosBackingList()
    {
        java.lang.Object[] values = this.sinResultadosValueList;
        java.lang.Object[] labels = this.sinResultadosLabelList;

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

    public java.lang.Object[] getSinResultadosValueList()
    {
        return this.sinResultadosValueList;
    }

    public void setSinResultadosValueList(java.lang.Object[] sinResultadosValueList)
    {
        this.sinResultadosValueList = sinResultadosValueList;
    }

    public java.lang.Object[] getSinResultadosLabelList()
    {
        return this.sinResultadosLabelList;
    }

    public void setSinResultadosLabelList(java.lang.Object[] sinResultadosLabelList)
    {
        this.sinResultadosLabelList = sinResultadosLabelList;
    }

    public void setSinResultadosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setSinResultadosBackingList requires non-null property arguments");
        }

        this.sinResultadosValueList = null;
        this.sinResultadosLabelList = null;

        if (items != null)
        {
            this.sinResultadosValueList = new java.lang.Object[items.size()];
            this.sinResultadosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.sinResultadosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.sinResultadosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosImagenesMostrarAvanzadoResultadosFormImpl.setSinResultadosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.formato = null;
        this.valoracion = null;
        this.comunidadesSeleccionadas = null;
        this.comunidadesSeleccionadasValueList = new java.lang.Object[0];
        this.comunidadesSeleccionadasLabelList = new java.lang.Object[0];
        this.c_s_secuencia = null;
        this.recurso = null;
        this.contexto = null;
        this.destinatarios = null;
        this.nivelAgregacion = null;
        this.idiomaBuscador = null;
        this.procesoCognitivo = null;
        this.mostrarAmbito = null;
        this.sinResultados = false;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("nomTesauros", this.nomTesauros);
        builder.append("buscadorContenido", this.buscadorContenido);
        builder.append("contadorAmbito", this.contadorAmbito);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        builder.append("formato", this.formato);
        builder.append("contadorTesauros", this.contadorTesauros);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("idTesauro", this.idTesauro);
        builder.append("anyoPublicacion", this.anyoPublicacion);
        builder.append("areaCurricular", this.areaCurricular);
        builder.append("anterior", this.anterior);
        builder.append("valoracion", this.valoracion);
        builder.append("comunidadesSeleccionadas", this.comunidadesSeleccionadas);
        builder.append("validado", this.validado);
        builder.append("contadorPropiedadesContenido", this.contadorPropiedadesContenido);
        builder.append("edad", this.edad);
        builder.append("c_s_secuencia", this.c_s_secuencia);
        builder.append("enlaceComunidadesSeleccionadas", this.enlaceComunidadesSeleccionadas);
        builder.append("diaPublicacion", this.diaPublicacion);
        builder.append("recurso", this.recurso);
        builder.append("areaCurricularTexto", this.areaCurricularTexto);
        builder.append("contexto", this.contexto);
        builder.append("destinatarios", this.destinatarios);
        builder.append("autor", this.autor);
        builder.append("descripcion", this.descripcion);
        builder.append("nivelAgregacion", this.nivelAgregacion);
        builder.append("horaPublicacion", this.horaPublicacion);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        builder.append("procesoCognitivo", this.procesoCognitivo);
        builder.append("mostrarAmbito", this.mostrarAmbito);
        builder.append("titulo", this.titulo);
        builder.append("contadorAreasCurriculares", this.contadorAreasCurriculares);
        builder.append("enlaceTodoAgrega", this.enlaceTodoAgrega);
        builder.append("mesPublicacion", this.mesPublicacion);
        builder.append("comunidades", this.comunidades);
        builder.append("sinResultados", this.sinResultados);
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
        this.contadorAmbito = null;
        this.contadorAmbitoValueList = null;
        this.contadorAmbitoLabelList = null;
        this.tipoLayoutBuscador = null;
        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;
        this.formato = null;
        this.formatoValueList = null;
        this.formatoLabelList = null;
        this.contadorTesauros = null;
        this.contadorTesaurosValueList = null;
        this.contadorTesaurosLabelList = null;
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
        this.anterior = null;
        this.anteriorValueList = null;
        this.anteriorLabelList = null;
        this.valoracion = null;
        this.valoracionValueList = null;
        this.valoracionLabelList = null;
        this.comunidadesSeleccionadas = null;
        this.comunidadesSeleccionadasValueList = null;
        this.comunidadesSeleccionadasLabelList = null;
        this.validado = null;
        this.validadoValueList = null;
        this.validadoLabelList = null;
        this.contadorPropiedadesContenido = null;
        this.contadorPropiedadesContenidoValueList = null;
        this.contadorPropiedadesContenidoLabelList = null;
        this.edad = null;
        this.edadValueList = null;
        this.edadLabelList = null;
        this.c_s_secuencia = null;
        this.c_s_secuenciaValueList = null;
        this.c_s_secuenciaLabelList = null;
        this.enlaceComunidadesSeleccionadas = null;
        this.enlaceComunidadesSeleccionadasValueList = null;
        this.enlaceComunidadesSeleccionadasLabelList = null;
        this.diaPublicacion = null;
        this.diaPublicacionValueList = null;
        this.diaPublicacionLabelList = null;
        this.recurso = null;
        this.recursoValueList = null;
        this.recursoLabelList = null;
        this.areaCurricularTexto = null;
        this.areaCurricularTextoValueList = null;
        this.areaCurricularTextoLabelList = null;
        this.contexto = null;
        this.contextoValueList = null;
        this.contextoLabelList = null;
        this.destinatarios = null;
        this.destinatariosValueList = null;
        this.destinatariosLabelList = null;
        this.autor = null;
        this.autorValueList = null;
        this.autorLabelList = null;
        this.descripcion = null;
        this.descripcionValueList = null;
        this.descripcionLabelList = null;
        this.nivelAgregacion = null;
        this.nivelAgregacionValueList = null;
        this.nivelAgregacionLabelList = null;
        this.horaPublicacion = null;
        this.horaPublicacionValueList = null;
        this.horaPublicacionLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
        this.procesoCognitivo = null;
        this.procesoCognitivoValueList = null;
        this.procesoCognitivoLabelList = null;
        this.mostrarAmbito = null;
        this.mostrarAmbitoValueList = null;
        this.mostrarAmbitoLabelList = null;
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.contadorAreasCurriculares = null;
        this.contadorAreasCurricularesValueList = null;
        this.contadorAreasCurricularesLabelList = null;
        this.enlaceTodoAgrega = null;
        this.enlaceTodoAgregaValueList = null;
        this.enlaceTodoAgregaLabelList = null;
        this.mesPublicacion = null;
        this.mesPublicacionValueList = null;
        this.mesPublicacionLabelList = null;
        this.comunidades = null;
        this.comunidadesValueList = null;
        this.comunidadesLabelList = null;
        this.sinResultados = false;
        this.sinResultadosValueList = null;
        this.sinResultadosLabelList = null;
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
// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

public class MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.buscador.presentacion.avanzado.buscarAvanzado.ValidarFormularioForm
        , es.pode.buscador.presentacion.avanzado.buscarAvanzado.CargaFormularioBusquedaAvanzadaForm
        , es.pode.buscador.presentacion.avanzado.buscarAvanzado.CargarFormularioQuisoDecirForm
        , es.pode.buscador.presentacion.avanzado.buscarAvanzado.EjecutarBusquedaAvanzadaForm
        , es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaTipoBusquedaForm
        , es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaResultadosForm
        , es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizarVisualizacionForm
        , es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaValidacionForm
{
    private java.lang.String buscadorContenido;
    private java.lang.Object[] buscadorContenidoValueList;
    private java.lang.Object[] buscadorContenidoLabelList;
    private java.lang.String tipoVisualizacion;
    private java.lang.Object[] tipoVisualizacionValueList;
    private java.lang.Object[] tipoVisualizacionLabelList;
    private java.lang.String contadorAmbito;
    private java.lang.Object[] contadorAmbitoValueList;
    private java.lang.Object[] contadorAmbitoLabelList;
    private java.lang.String formato;
    private java.lang.Object[] formatoValueList;
    private java.lang.Object[] formatoLabelList;
    private java.lang.String tipoLayoutBuscador;
    private java.lang.Object[] tipoLayoutBuscadorValueList;
    private java.lang.Object[] tipoLayoutBuscadorLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.String idTesauro;
    private java.lang.Object[] idTesauroValueList;
    private java.lang.Object[] idTesauroLabelList;
    private java.lang.String pagina;
    private java.lang.Object[] paginaValueList;
    private java.lang.Object[] paginaLabelList;
    private java.lang.String[] comunidadesSeleccionadas;
    private java.lang.Object[] comunidadesSeleccionadasValueList;
    private java.lang.Object[] comunidadesSeleccionadasLabelList;
    private java.lang.String identificadorODE;
    private java.lang.Object[] identificadorODEValueList;
    private java.lang.Object[] identificadorODELabelList;
    private java.lang.String buscadorContenidoEnlace;
    private java.lang.Object[] buscadorContenidoEnlaceValueList;
    private java.lang.Object[] buscadorContenidoEnlaceLabelList;
    private java.lang.String diaPublicacion;
    private java.lang.Object[] diaPublicacionValueList;
    private java.lang.Object[] diaPublicacionLabelList;
    private java.lang.String recurso;
    private java.lang.Object[] recursoValueList;
    private java.lang.Object[] recursoLabelList;
    private java.util.Collection paginas;
    private java.lang.Object[] paginasValueList;
    private java.lang.Object[] paginasLabelList;
    private java.lang.String contexto;
    private java.lang.Object[] contextoValueList;
    private java.lang.Object[] contextoLabelList;
    private java.lang.String areaCurricularTexto;
    private java.lang.Object[] areaCurricularTextoValueList;
    private java.lang.Object[] areaCurricularTextoLabelList;
    private java.lang.String resultadosDesde;
    private java.lang.Object[] resultadosDesdeValueList;
    private java.lang.Object[] resultadosDesdeLabelList;
    private java.lang.String listaIds;
    private java.lang.Object[] listaIdsValueList;
    private java.lang.Object[] listaIdsLabelList;
    private java.lang.String autor;
    private java.lang.Object[] autorValueList;
    private java.lang.Object[] autorLabelList;
    private java.lang.String destinatarios;
    private java.lang.Object[] destinatariosValueList;
    private java.lang.Object[] destinatariosLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private java.lang.Boolean mostrarAmbito;
    private java.lang.Object[] mostrarAmbitoValueList;
    private java.lang.Object[] mostrarAmbitoLabelList;
    private java.lang.String mesPublicacion;
    private java.lang.Object[] mesPublicacionValueList;
    private java.lang.Object[] mesPublicacionLabelList;
    private java.util.List comunidades;
    private java.lang.Object[] comunidadesValueList;
    private java.lang.Object[] comunidadesLabelList;
    private boolean sinResultados;
    private java.lang.Object[] sinResultadosValueList;
    private java.lang.Object[] sinResultadosLabelList;
    private java.lang.Boolean buscadorEmpaquetador;
    private java.lang.Object[] buscadorEmpaquetadorValueList;
    private java.lang.Object[] buscadorEmpaquetadorLabelList;
    private java.lang.String nomTesauros;
    private java.lang.Object[] nomTesaurosValueList;
    private java.lang.Object[] nomTesaurosLabelList;
    private java.lang.String siguiente;
    private java.lang.Object[] siguienteValueList;
    private java.lang.Object[] siguienteLabelList;
    private java.lang.String contadorTesauros;
    private java.lang.Object[] contadorTesaurosValueList;
    private java.lang.Object[] contadorTesaurosLabelList;
    private java.lang.String anyoPublicacion;
    private java.lang.Object[] anyoPublicacionValueList;
    private java.lang.Object[] anyoPublicacionLabelList;
    private java.util.List idRowSelection = null;
    private java.lang.Object[] idValueList;
    private java.lang.Object[] idLabelList;
    private java.lang.String areaCurricular;
    private java.lang.Object[] areaCurricularValueList;
    private java.lang.Object[] areaCurricularLabelList;
    private java.lang.String anterior;
    private java.lang.Object[] anteriorValueList;
    private java.lang.Object[] anteriorLabelList;
    private java.lang.String valoracion;
    private java.lang.Object[] valoracionValueList;
    private java.lang.Object[] valoracionLabelList;
    private java.lang.String edad;
    private java.lang.Object[] edadValueList;
    private java.lang.Object[] edadLabelList;
    private java.lang.String contadorPropiedadesContenido;
    private java.lang.Object[] contadorPropiedadesContenidoValueList;
    private java.lang.Object[] contadorPropiedadesContenidoLabelList;
    private java.lang.String validado;
    private java.lang.Object[] validadoValueList;
    private java.lang.Object[] validadoLabelList;
    private java.lang.String nodoDestino;
    private java.lang.Object[] nodoDestinoValueList;
    private java.lang.Object[] nodoDestinoLabelList;
    private java.lang.String resultadosHasta;
    private java.lang.Object[] resultadosHastaValueList;
    private java.lang.Object[] resultadosHastaLabelList;
    private java.lang.String contadorODE;
    private java.lang.Object[] contadorODEValueList;
    private java.lang.Object[] contadorODELabelList;
    private java.lang.String c_s_secuencia;
    private java.lang.Object[] c_s_secuenciaValueList;
    private java.lang.Object[] c_s_secuenciaLabelList;
    private java.lang.String enlaceComunidadesSeleccionadas;
    private java.lang.Object[] enlaceComunidadesSeleccionadasValueList;
    private java.lang.Object[] enlaceComunidadesSeleccionadasLabelList;
    private java.lang.String idTesauroSugerencia;
    private java.lang.Object[] idTesauroSugerenciaValueList;
    private java.lang.Object[] idTesauroSugerenciaLabelList;
    private java.lang.String busquedaSimpleAvanzada;
    private java.lang.Object[] busquedaSimpleAvanzadaValueList;
    private java.lang.Object[] busquedaSimpleAvanzadaLabelList;
    private java.lang.String buscadorContenidoSolo;
    private java.lang.Object[] buscadorContenidoSoloValueList;
    private java.lang.Object[] buscadorContenidoSoloLabelList;
    private java.lang.String keyword;
    private java.lang.Object[] keywordValueList;
    private java.lang.Object[] keywordLabelList;
    private java.lang.String pulsacion;
    private java.lang.Object[] pulsacionValueList;
    private java.lang.Object[] pulsacionLabelList;
    private java.lang.String descripcion;
    private java.lang.Object[] descripcionValueList;
    private java.lang.Object[] descripcionLabelList;
    private java.lang.String nivelAgregacion;
    private java.lang.Object[] nivelAgregacionValueList;
    private java.lang.Object[] nivelAgregacionLabelList;
    private java.util.Collection resultadosVO = null;
    private java.lang.Object[] resultadosVOValueList;
    private java.lang.Object[] resultadosVOLabelList;
    private java.lang.String procesoCognitivo;
    private java.lang.Object[] procesoCognitivoValueList;
    private java.lang.Object[] procesoCognitivoLabelList;
    private java.lang.String horaPublicacion;
    private java.lang.Object[] horaPublicacionValueList;
    private java.lang.Object[] horaPublicacionLabelList;
    private java.lang.Boolean usuarioAdministrador;
    private java.lang.Object[] usuarioAdministradorValueList;
    private java.lang.Object[] usuarioAdministradorLabelList;
    private java.lang.String titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.lang.String contadorAreasCurriculares;
    private java.lang.Object[] contadorAreasCurricularesValueList;
    private java.lang.Object[] contadorAreasCurricularesLabelList;
    private java.lang.String numMaxRes;
    private java.lang.Object[] numMaxResValueList;
    private java.lang.Object[] numMaxResLabelList;
    private java.lang.String[] quisoDecir;
    private java.lang.Object[] quisoDecirValueList;
    private java.lang.Object[] quisoDecirLabelList;
    private java.lang.String enlaceTodoAgrega;
    private java.lang.Object[] enlaceTodoAgregaValueList;
    private java.lang.Object[] enlaceTodoAgregaLabelList;
    private java.lang.String numeroResultados;
    private java.lang.Object[] numeroResultadosValueList;
    private java.lang.Object[] numeroResultadosLabelList;
    private java.lang.Boolean nodosSQI;
    private java.lang.Object[] nodosSQIValueList;
    private java.lang.Object[] nodosSQILabelList;
    private es.pode.buscar.negocio.buscar.servicios.ResultadosTaxonVO[] tesauros;
    private java.lang.Object[] tesaurosValueList;
    private java.lang.Object[] tesaurosLabelList;

    /*
     * Search filters
     */
    private java.lang.String subjectSearchFilter;
    private java.lang.String keystageSearchFilter;
    private java.lang.String learningTimeSearchFilter;
    private java.lang.String intendedEndUserRoleSearchFilter;
    //19/10/2010    Fernando Garcia
    //              Adding a new filter for file mime types
    private java.lang.String intendedFMTSearchFilter;
    
    
    public MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl()
    {
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setBuscadorContenidoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setBuscadorContenidoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setTipoVisualizacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setTipoVisualizacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setContadorAmbitoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setContadorAmbitoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setFormatoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setFormatoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setIdTesauroBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setIdTesauroBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setPaginaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setPaginaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setComunidadesSeleccionadasBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setComunidadesSeleccionadasBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setIdentificadorODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setIdentificadorODEBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setBuscadorContenidoEnlaceBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setBuscadorContenidoEnlaceBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setDiaPublicacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setDiaPublicacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setRecursoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setRecursoBackingList encountered an exception", ex);
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
     * @see es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl#getPaginas
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setPaginasBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setPaginasBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setContextoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setContextoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setAreaCurricularTextoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setAreaCurricularTextoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setResultadosDesdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setResultadosDesdeBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setListaIdsBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setListaIdsBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setAutorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setAutorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setDestinatariosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setDestinatariosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setIdiomaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setMostrarAmbitoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setMostrarAmbitoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setMesPublicacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setMesPublicacionBackingList encountered an exception", ex);
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
     * @see es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl#getComunidades
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setComunidadesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setComunidadesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setSinResultadosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setSinResultadosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>buscadorEmpaquetador</code>.
     */
    public void resetBuscadorEmpaquetador()
    {
        this.buscadorEmpaquetador = null;
    }

    public void setBuscadorEmpaquetador(java.lang.Boolean buscadorEmpaquetador)
    {
        this.buscadorEmpaquetador = buscadorEmpaquetador;
    }

    /**
     * 
     */
    public java.lang.Boolean getBuscadorEmpaquetador()
    {
        return this.buscadorEmpaquetador;
    }
    
    public java.lang.Object[] getBuscadorEmpaquetadorBackingList()
    {
        java.lang.Object[] values = this.buscadorEmpaquetadorValueList;
        java.lang.Object[] labels = this.buscadorEmpaquetadorLabelList;

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

    public java.lang.Object[] getBuscadorEmpaquetadorValueList()
    {
        return this.buscadorEmpaquetadorValueList;
    }

    public void setBuscadorEmpaquetadorValueList(java.lang.Object[] buscadorEmpaquetadorValueList)
    {
        this.buscadorEmpaquetadorValueList = buscadorEmpaquetadorValueList;
    }

    public java.lang.Object[] getBuscadorEmpaquetadorLabelList()
    {
        return this.buscadorEmpaquetadorLabelList;
    }

    public void setBuscadorEmpaquetadorLabelList(java.lang.Object[] buscadorEmpaquetadorLabelList)
    {
        this.buscadorEmpaquetadorLabelList = buscadorEmpaquetadorLabelList;
    }

    public void setBuscadorEmpaquetadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setBuscadorEmpaquetadorBackingList requires non-null property arguments");
        }

        this.buscadorEmpaquetadorValueList = null;
        this.buscadorEmpaquetadorLabelList = null;

        if (items != null)
        {
            this.buscadorEmpaquetadorValueList = new java.lang.Object[items.size()];
            this.buscadorEmpaquetadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.buscadorEmpaquetadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.buscadorEmpaquetadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setBuscadorEmpaquetadorBackingList encountered an exception", ex);
            }
        }
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setNomTesaurosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setNomTesaurosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setSiguienteBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setSiguienteBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setContadorTesaurosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setContadorTesaurosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setAnyoPublicacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setAnyoPublicacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idRowSelection</code>.
     */
    public void resetId()
    {
        this.idRowSelection = null;
    }

    public void setIdRowSelection(java.util.List idRowSelection)
    {
        this.idRowSelection = idRowSelection;
    }

    public java.util.List getIdRowSelection()
    {
        return this.idRowSelection;
    }

    public void setIdRowSelectionAsArray(java.lang.String[] idRowSelection)
    {
        this.idRowSelection = (idRowSelection == null) ? null : java.util.Arrays.asList(idRowSelection);
    }

    public java.lang.String[] getIdRowSelectionAsArray()
    {
        return (idRowSelection == null) ? null : (java.lang.String[])idRowSelection.toArray(new java.lang.String[idRowSelection.size()]);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setIdBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setIdBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setAreaCurricularBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setAreaCurricularBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setAnteriorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setAnteriorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setValoracionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setValoracionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setEdadBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setEdadBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setContadorPropiedadesContenidoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setContadorPropiedadesContenidoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setValidadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setValidadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setNodoDestinoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setNodoDestinoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setResultadosHastaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setResultadosHastaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>contadorODE</code>.
     */
    public void resetContadorODE()
    {
        this.contadorODE = null;
    }

    public void setContadorODE(java.lang.String contadorODE)
    {
        this.contadorODE = contadorODE;
    }

    /**
     * 
     */
    public java.lang.String getContadorODE()
    {
        return this.contadorODE;
    }
    
    public java.lang.Object[] getContadorODEBackingList()
    {
        java.lang.Object[] values = this.contadorODEValueList;
        java.lang.Object[] labels = this.contadorODELabelList;

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

    public java.lang.Object[] getContadorODEValueList()
    {
        return this.contadorODEValueList;
    }

    public void setContadorODEValueList(java.lang.Object[] contadorODEValueList)
    {
        this.contadorODEValueList = contadorODEValueList;
    }

    public java.lang.Object[] getContadorODELabelList()
    {
        return this.contadorODELabelList;
    }

    public void setContadorODELabelList(java.lang.Object[] contadorODELabelList)
    {
        this.contadorODELabelList = contadorODELabelList;
    }

    public void setContadorODEBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setContadorODEBackingList requires non-null property arguments");
        }

        this.contadorODEValueList = null;
        this.contadorODELabelList = null;

        if (items != null)
        {
            this.contadorODEValueList = new java.lang.Object[items.size()];
            this.contadorODELabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.contadorODEValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.contadorODELabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setContadorODEBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setC_s_secuenciaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setC_s_secuenciaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setEnlaceComunidadesSeleccionadasBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setEnlaceComunidadesSeleccionadasBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setIdTesauroSugerenciaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setIdTesauroSugerenciaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setBusquedaSimpleAvanzadaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setBusquedaSimpleAvanzadaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setBuscadorContenidoSoloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setBuscadorContenidoSoloBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setKeywordBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setKeywordBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>pulsacion</code>.
     */
    public void resetPulsacion()
    {
        this.pulsacion = null;
    }

    public void setPulsacion(java.lang.String pulsacion)
    {
        this.pulsacion = pulsacion;
    }

    /**
     * 
     */
    public java.lang.String getPulsacion()
    {
        return this.pulsacion;
    }
    
    public java.lang.Object[] getPulsacionBackingList()
    {
        java.lang.Object[] values = this.pulsacionValueList;
        java.lang.Object[] labels = this.pulsacionLabelList;

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

    public java.lang.Object[] getPulsacionValueList()
    {
        return this.pulsacionValueList;
    }

    public void setPulsacionValueList(java.lang.Object[] pulsacionValueList)
    {
        this.pulsacionValueList = pulsacionValueList;
    }

    public java.lang.Object[] getPulsacionLabelList()
    {
        return this.pulsacionLabelList;
    }

    public void setPulsacionLabelList(java.lang.Object[] pulsacionLabelList)
    {
        this.pulsacionLabelList = pulsacionLabelList;
    }

    public void setPulsacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setPulsacionBackingList requires non-null property arguments");
        }

        this.pulsacionValueList = null;
        this.pulsacionLabelList = null;

        if (items != null)
        {
            this.pulsacionValueList = new java.lang.Object[items.size()];
            this.pulsacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.pulsacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.pulsacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setPulsacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setDescripcionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setDescripcionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setNivelAgregacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setNivelAgregacionBackingList encountered an exception", ex);
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

    public void setResultadosVO(java.util.Collection resultadosVO)
    {
        this.resultadosVO = resultadosVO;
    }

    /**
     * 
     */
    public java.util.Collection getResultadosVO()
    {
        return this.resultadosVO;
    }

    public void setResultadosVOAsArray(Object[] resultadosVO)
    {
        this.resultadosVO = (resultadosVO == null) ? null : java.util.Arrays.asList(resultadosVO);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl#getResultadosVO
     */
    public java.lang.Object[] getResultadosVOAsArray()
    {
        return (resultadosVO == null) ? null : resultadosVO.toArray();
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setResultadosVOBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setResultadosVOBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setProcesoCognitivoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setProcesoCognitivoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setHoraPublicacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setHoraPublicacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setUsuarioAdministradorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setUsuarioAdministradorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setTituloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setTituloBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setContadorAreasCurricularesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setContadorAreasCurricularesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setNumMaxResBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setNumMaxResBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>quisoDecir</code>.
     */
    public void resetQuisoDecir()
    {
        this.quisoDecir = null;
    }

    public void setQuisoDecir(java.lang.String[] quisoDecir)
    {
        this.quisoDecir = quisoDecir;
    }

    /**
     * 
     */
    public java.lang.String[] getQuisoDecir()
    {
        return this.quisoDecir;
    }
    
    public java.lang.Object[] getQuisoDecirBackingList()
    {
        java.lang.Object[] values = this.quisoDecirValueList;
        java.lang.Object[] labels = this.quisoDecirLabelList;

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

    public java.lang.Object[] getQuisoDecirValueList()
    {
        return this.quisoDecirValueList;
    }

    public void setQuisoDecirValueList(java.lang.Object[] quisoDecirValueList)
    {
        this.quisoDecirValueList = quisoDecirValueList;
    }

    public java.lang.Object[] getQuisoDecirLabelList()
    {
        return this.quisoDecirLabelList;
    }

    public void setQuisoDecirLabelList(java.lang.Object[] quisoDecirLabelList)
    {
        this.quisoDecirLabelList = quisoDecirLabelList;
    }

    public void setQuisoDecirBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setQuisoDecirBackingList requires non-null property arguments");
        }

        this.quisoDecirValueList = null;
        this.quisoDecirLabelList = null;

        if (items != null)
        {
            this.quisoDecirValueList = new java.lang.Object[items.size()];
            this.quisoDecirLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.quisoDecirValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.quisoDecirLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setQuisoDecirBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setEnlaceTodoAgregaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setEnlaceTodoAgregaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setNumeroResultadosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setNumeroResultadosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nodosSQI</code>.
     */
    public void resetNodosSQI()
    {
        this.nodosSQI = null;
    }

    public void setNodosSQI(java.lang.Boolean nodosSQI)
    {
        this.nodosSQI = nodosSQI;
    }

    /**
     * <p>
     * indica si hay algún dato cargado en la tabla de nodos_SQI
     * </p>
     */
    public java.lang.Boolean getNodosSQI()
    {
        return this.nodosSQI;
    }
    
    public java.lang.Object[] getNodosSQIBackingList()
    {
        java.lang.Object[] values = this.nodosSQIValueList;
        java.lang.Object[] labels = this.nodosSQILabelList;

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

    public java.lang.Object[] getNodosSQIValueList()
    {
        return this.nodosSQIValueList;
    }

    public void setNodosSQIValueList(java.lang.Object[] nodosSQIValueList)
    {
        this.nodosSQIValueList = nodosSQIValueList;
    }

    public java.lang.Object[] getNodosSQILabelList()
    {
        return this.nodosSQILabelList;
    }

    public void setNodosSQILabelList(java.lang.Object[] nodosSQILabelList)
    {
        this.nodosSQILabelList = nodosSQILabelList;
    }

    public void setNodosSQIBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setNodosSQIBackingList requires non-null property arguments");
        }

        this.nodosSQIValueList = null;
        this.nodosSQILabelList = null;

        if (items != null)
        {
            this.nodosSQIValueList = new java.lang.Object[items.size()];
            this.nodosSQILabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nodosSQIValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nodosSQILabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setNodosSQIBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tesauros</code>.
     */
    public void resetTesauros()
    {
        this.tesauros = null;
    }

    public void setTesauros(es.pode.buscar.negocio.buscar.servicios.ResultadosTaxonVO[] tesauros)
    {
        this.tesauros = tesauros;
    }

    /**
     * 
     */
    public es.pode.buscar.negocio.buscar.servicios.ResultadosTaxonVO[] getTesauros()
    {
        return this.tesauros;
    }
    
    public java.lang.Object[] getTesaurosBackingList()
    {
        java.lang.Object[] values = this.tesaurosValueList;
        java.lang.Object[] labels = this.tesaurosLabelList;

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

    public java.lang.Object[] getTesaurosValueList()
    {
        return this.tesaurosValueList;
    }

    public void setTesaurosValueList(java.lang.Object[] tesaurosValueList)
    {
        this.tesaurosValueList = tesaurosValueList;
    }

    public java.lang.Object[] getTesaurosLabelList()
    {
        return this.tesaurosLabelList;
    }

    public void setTesaurosLabelList(java.lang.Object[] tesaurosLabelList)
    {
        this.tesaurosLabelList = tesaurosLabelList;
    }

    public void setTesaurosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setTesaurosBackingList requires non-null property arguments");
        }

        this.tesaurosValueList = null;
        this.tesaurosLabelList = null;

        if (items != null)
        {
            this.tesaurosValueList = new java.lang.Object[items.size()];
            this.tesaurosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tesaurosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tesaurosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl.setTesaurosBackingList encountered an exception", ex);
            }
        }
    }

    
    /*
     * Search filters
     */
    
    public void setSubjectSearchFilter(java.lang.String subjectSearchFilter)
    {
        this.subjectSearchFilter = subjectSearchFilter;
    }

    public java.lang.String getSubjectSearchFilter()
    {
        return this.subjectSearchFilter;
    }

    public void setKeystageSearchFilter(java.lang.String keystageSearchFilter)
    {
        this.keystageSearchFilter = keystageSearchFilter;
    }

    public java.lang.String getKeystageSearchFilter()
    {
        return this.keystageSearchFilter;
    }

    public void setLearningTimeSearchFilter(java.lang.String learningTimeSearchFilter)
    {
        this.learningTimeSearchFilter = learningTimeSearchFilter;
    }

    public java.lang.String getLearningTimeSearchFilter()
    {
        return this.learningTimeSearchFilter;
    }

    public void setIntendedEndUserRoleSearchFilter(java.lang.String intendedEndUserRoleSearchFilter)
    {
        this.intendedEndUserRoleSearchFilter = intendedEndUserRoleSearchFilter;
    }

    public java.lang.String getIntendedEndUserRoleSearchFilter()
    {
        return this.intendedEndUserRoleSearchFilter;
    }


    //19/10/2010    Fernando Garcia
    //              Adding a new filter for file mime types
    public String getIntendedFMTSearchFilter() {
        return intendedFMTSearchFilter;
    }

    public void setIntendedFMTSearchFilter(String intendedFMTSearchFilter) {
        this.intendedFMTSearchFilter = intendedFMTSearchFilter;
    }


    
    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.formato = null;
        this.comunidadesSeleccionadas = null;
        this.comunidadesSeleccionadasValueList = new java.lang.Object[0];
        this.comunidadesSeleccionadasLabelList = new java.lang.Object[0];
        this.recurso = null;
        this.contexto = null;
        this.destinatarios = null;
        this.idiomaBuscador = null;
        this.mostrarAmbito = null;
        this.sinResultados = false;
        this.buscadorEmpaquetador = null;
        this.idRowSelection = null;
        this.valoracion = null;
        this.c_s_secuencia = null;
        this.nivelAgregacion = null;
        this.procesoCognitivo = null;
        this.usuarioAdministrador = null;
        this.quisoDecir = null;
        this.numeroResultados = null;
        this.nodosSQI = null;
        this.tesauros = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("buscadorContenido", this.buscadorContenido);
        builder.append("tipoVisualizacion", this.tipoVisualizacion);
        builder.append("contadorAmbito", this.contadorAmbito);
        builder.append("formato", this.formato);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("idTesauro", this.idTesauro);
        builder.append("pagina", this.pagina);
        builder.append("comunidadesSeleccionadas", this.comunidadesSeleccionadas);
        builder.append("identificadorODE", this.identificadorODE);
        builder.append("buscadorContenidoEnlace", this.buscadorContenidoEnlace);
        builder.append("diaPublicacion", this.diaPublicacion);
        builder.append("recurso", this.recurso);
        builder.append("paginas", this.paginas);
        builder.append("contexto", this.contexto);
        builder.append("areaCurricularTexto", this.areaCurricularTexto);
        builder.append("resultadosDesde", this.resultadosDesde);
        builder.append("listaIds", this.listaIds);
        builder.append("autor", this.autor);
        builder.append("destinatarios", this.destinatarios);
        builder.append("idioma", this.idioma);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        builder.append("mostrarAmbito", this.mostrarAmbito);
        builder.append("mesPublicacion", this.mesPublicacion);
        builder.append("comunidades", this.comunidades);
        builder.append("sinResultados", this.sinResultados);
        builder.append("buscadorEmpaquetador", this.buscadorEmpaquetador);
        builder.append("nomTesauros", this.nomTesauros);
        builder.append("siguiente", this.siguiente);
        builder.append("contadorTesauros", this.contadorTesauros);
        builder.append("anyoPublicacion", this.anyoPublicacion);
        builder.append("idRowSelection", this.idRowSelection);
        builder.append("areaCurricular", this.areaCurricular);
        builder.append("anterior", this.anterior);
        builder.append("valoracion", this.valoracion);
        builder.append("edad", this.edad);
        builder.append("contadorPropiedadesContenido", this.contadorPropiedadesContenido);
        builder.append("validado", this.validado);
        builder.append("nodoDestino", this.nodoDestino);
        builder.append("resultadosHasta", this.resultadosHasta);
        builder.append("contadorODE", this.contadorODE);
        builder.append("c_s_secuencia", this.c_s_secuencia);
        builder.append("enlaceComunidadesSeleccionadas", this.enlaceComunidadesSeleccionadas);
        builder.append("idTesauroSugerencia", this.idTesauroSugerencia);
        builder.append("busquedaSimpleAvanzada", this.busquedaSimpleAvanzada);
        builder.append("buscadorContenidoSolo", this.buscadorContenidoSolo);
        builder.append("keyword", this.keyword);
        builder.append("pulsacion", this.pulsacion);
        builder.append("descripcion", this.descripcion);
        builder.append("nivelAgregacion", this.nivelAgregacion);
        builder.append("resultadosVO", this.resultadosVO);
        builder.append("procesoCognitivo", this.procesoCognitivo);
        builder.append("horaPublicacion", this.horaPublicacion);
        builder.append("usuarioAdministrador", this.usuarioAdministrador);
        builder.append("titulo", this.titulo);
        builder.append("contadorAreasCurriculares", this.contadorAreasCurriculares);
        builder.append("numMaxRes", this.numMaxRes);
        builder.append("quisoDecir", this.quisoDecir);
        builder.append("enlaceTodoAgrega", this.enlaceTodoAgrega);
        builder.append("numeroResultados", this.numeroResultados);
        builder.append("nodosSQI", this.nodosSQI);
        builder.append("tesauros", this.tesauros);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.buscadorContenido = null;
        this.buscadorContenidoValueList = null;
        this.buscadorContenidoLabelList = null;
        this.tipoVisualizacion = null;
        this.tipoVisualizacionValueList = null;
        this.tipoVisualizacionLabelList = null;
        this.contadorAmbito = null;
        this.contadorAmbitoValueList = null;
        this.contadorAmbitoLabelList = null;
        this.formato = null;
        this.formatoValueList = null;
        this.formatoLabelList = null;
        this.tipoLayoutBuscador = null;
        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.idTesauro = null;
        this.idTesauroValueList = null;
        this.idTesauroLabelList = null;
        this.pagina = null;
        this.paginaValueList = null;
        this.paginaLabelList = null;
        this.comunidadesSeleccionadas = null;
        this.comunidadesSeleccionadasValueList = null;
        this.comunidadesSeleccionadasLabelList = null;
        this.identificadorODE = null;
        this.identificadorODEValueList = null;
        this.identificadorODELabelList = null;
        this.buscadorContenidoEnlace = null;
        this.buscadorContenidoEnlaceValueList = null;
        this.buscadorContenidoEnlaceLabelList = null;
        this.diaPublicacion = null;
        this.diaPublicacionValueList = null;
        this.diaPublicacionLabelList = null;
        this.recurso = null;
        this.recursoValueList = null;
        this.recursoLabelList = null;
        this.paginas = null;
        this.paginasValueList = null;
        this.paginasLabelList = null;
        this.contexto = null;
        this.contextoValueList = null;
        this.contextoLabelList = null;
        this.areaCurricularTexto = null;
        this.areaCurricularTextoValueList = null;
        this.areaCurricularTextoLabelList = null;
        this.resultadosDesde = null;
        this.resultadosDesdeValueList = null;
        this.resultadosDesdeLabelList = null;
        this.listaIds = null;
        this.listaIdsValueList = null;
        this.listaIdsLabelList = null;
        this.autor = null;
        this.autorValueList = null;
        this.autorLabelList = null;
        this.destinatarios = null;
        this.destinatariosValueList = null;
        this.destinatariosLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
        this.mostrarAmbito = null;
        this.mostrarAmbitoValueList = null;
        this.mostrarAmbitoLabelList = null;
        this.mesPublicacion = null;
        this.mesPublicacionValueList = null;
        this.mesPublicacionLabelList = null;
        this.comunidades = null;
        this.comunidadesValueList = null;
        this.comunidadesLabelList = null;
        this.sinResultados = false;
        this.sinResultadosValueList = null;
        this.sinResultadosLabelList = null;
        this.buscadorEmpaquetador = null;
        this.buscadorEmpaquetadorValueList = null;
        this.buscadorEmpaquetadorLabelList = null;
        this.nomTesauros = null;
        this.nomTesaurosValueList = null;
        this.nomTesaurosLabelList = null;
        this.siguiente = null;
        this.siguienteValueList = null;
        this.siguienteLabelList = null;
        this.contadorTesauros = null;
        this.contadorTesaurosValueList = null;
        this.contadorTesaurosLabelList = null;
        this.anyoPublicacion = null;
        this.anyoPublicacionValueList = null;
        this.anyoPublicacionLabelList = null;
        this.idRowSelection = null;
        this.areaCurricular = null;
        this.areaCurricularValueList = null;
        this.areaCurricularLabelList = null;
        this.anterior = null;
        this.anteriorValueList = null;
        this.anteriorLabelList = null;
        this.valoracion = null;
        this.valoracionValueList = null;
        this.valoracionLabelList = null;
        this.edad = null;
        this.edadValueList = null;
        this.edadLabelList = null;
        this.contadorPropiedadesContenido = null;
        this.contadorPropiedadesContenidoValueList = null;
        this.contadorPropiedadesContenidoLabelList = null;
        this.validado = null;
        this.validadoValueList = null;
        this.validadoLabelList = null;
        this.nodoDestino = null;
        this.nodoDestinoValueList = null;
        this.nodoDestinoLabelList = null;
        this.resultadosHasta = null;
        this.resultadosHastaValueList = null;
        this.resultadosHastaLabelList = null;
        this.contadorODE = null;
        this.contadorODEValueList = null;
        this.contadorODELabelList = null;
        this.c_s_secuencia = null;
        this.c_s_secuenciaValueList = null;
        this.c_s_secuenciaLabelList = null;
        this.enlaceComunidadesSeleccionadas = null;
        this.enlaceComunidadesSeleccionadasValueList = null;
        this.enlaceComunidadesSeleccionadasLabelList = null;
        this.idTesauroSugerencia = null;
        this.idTesauroSugerenciaValueList = null;
        this.idTesauroSugerenciaLabelList = null;
        this.busquedaSimpleAvanzada = null;
        this.busquedaSimpleAvanzadaValueList = null;
        this.busquedaSimpleAvanzadaLabelList = null;
        this.buscadorContenidoSolo = null;
        this.buscadorContenidoSoloValueList = null;
        this.buscadorContenidoSoloLabelList = null;
        this.keyword = null;
        this.keywordValueList = null;
        this.keywordLabelList = null;
        this.pulsacion = null;
        this.pulsacionValueList = null;
        this.pulsacionLabelList = null;
        this.descripcion = null;
        this.descripcionValueList = null;
        this.descripcionLabelList = null;
        this.nivelAgregacion = null;
        this.nivelAgregacionValueList = null;
        this.nivelAgregacionLabelList = null;
        this.resultadosVO = null;
        this.resultadosVOValueList = null;
        this.resultadosVOLabelList = null;
        this.procesoCognitivo = null;
        this.procesoCognitivoValueList = null;
        this.procesoCognitivoLabelList = null;
        this.horaPublicacion = null;
        this.horaPublicacionValueList = null;
        this.horaPublicacionLabelList = null;
        this.usuarioAdministrador = null;
        this.usuarioAdministradorValueList = null;
        this.usuarioAdministradorLabelList = null;
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.contadorAreasCurriculares = null;
        this.contadorAreasCurricularesValueList = null;
        this.contadorAreasCurricularesLabelList = null;
        this.numMaxRes = null;
        this.numMaxResValueList = null;
        this.numMaxResLabelList = null;
        this.quisoDecir = null;
        this.quisoDecirValueList = null;
        this.quisoDecirLabelList = null;
        this.enlaceTodoAgrega = null;
        this.enlaceTodoAgregaValueList = null;
        this.enlaceTodoAgregaLabelList = null;
        this.numeroResultados = null;
        this.numeroResultadosValueList = null;
        this.numeroResultadosLabelList = null;
        this.nodosSQI = null;
        this.nodosSQIValueList = null;
        this.nodosSQILabelList = null;
        this.tesauros = null;
        this.tesaurosValueList = null;
        this.tesaurosLabelList = null;
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
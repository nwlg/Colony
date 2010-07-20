// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

public class SeleccionaCSSecuenciaCancelarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.buscador.presentacion.basico.detallar.BuscarDetalleODEForm
        , es.pode.buscador.presentacion.basico.detallar.AgregarODEFederadoForm
        , es.pode.buscador.presentacion.basico.detallar.GestionarBotoneraForm
        , es.pode.buscador.presentacion.basico.detallar.GestionarPosicionamientoForm
        , es.pode.buscador.presentacion.basico.detallar.GestionarBusquedaForm
        , es.pode.buscador.presentacion.basico.detallar.AnalizaPosicionamientoForm
        , es.pode.buscador.presentacion.basico.detallar.AnalizaEntradaForm
{
    private java.lang.String licencias;
    private java.lang.Object[] licenciasValueList;
    private java.lang.Object[] licenciasLabelList;
    private java.lang.String size;
    private java.lang.Object[] sizeValueList;
    private java.lang.Object[] sizeLabelList;
    private java.lang.String learningResourceType;
    private java.lang.Object[] learningResourceTypeValueList;
    private java.lang.Object[] learningResourceTypeLabelList;
    private java.lang.String annotation;
    private java.lang.Object[] annotationValueList;
    private java.lang.Object[] annotationLabelList;
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
    private java.lang.Boolean agregarFederado;
    private java.lang.Object[] agregarFederadoValueList;
    private java.lang.Object[] agregarFederadoLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.String numVecesDescargado;
    private java.lang.Object[] numVecesDescargadoValueList;
    private java.lang.Object[] numVecesDescargadoLabelList;
    private java.lang.Boolean mostrarVuelta;
    private java.lang.Object[] mostrarVueltaValueList;
    private java.lang.Object[] mostrarVueltaLabelList;
    private java.lang.String pagina;
    private java.lang.Object[] paginaValueList;
    private java.lang.Object[] paginaLabelList;
    private java.lang.String identificadorODE;
    private java.lang.Object[] identificadorODEValueList;
    private java.lang.Object[] identificadorODELabelList;
    private java.lang.String idiomaODE;
    private java.lang.Object[] idiomaODEValueList;
    private java.lang.Object[] idiomaODELabelList;
    private java.lang.Boolean seleccionarSecuencia;
    private java.lang.Object[] seleccionarSecuenciaValueList;
    private java.lang.Object[] seleccionarSecuenciaLabelList;
    private java.lang.String diaPublicacion;
    private java.lang.Object[] diaPublicacionValueList;
    private java.lang.Object[] diaPublicacionLabelList;
    private java.lang.String recurso;
    private java.lang.Object[] recursoValueList;
    private java.lang.Object[] recursoLabelList;
    private java.lang.String contexto;
    private java.lang.Object[] contextoValueList;
    private java.lang.Object[] contextoLabelList;
    private java.lang.String destinatarios;
    private java.lang.Object[] destinatariosValueList;
    private java.lang.Object[] destinatariosLabelList;
    private java.lang.String autor;
    private java.lang.Object[] autorValueList;
    private java.lang.Object[] autorLabelList;
    private String nrComentarios;
    private java.lang.Object[] nrComentariosValueList;
    private java.lang.Object[] nrComentariosLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private java.lang.Boolean existenEtiquetas;
    private java.lang.Object[] existenEtiquetasValueList;
    private java.lang.Object[] existenEtiquetasLabelList;
    private java.lang.String imagen;
    private java.lang.Object[] imagenValueList;
    private java.lang.Object[] imagenLabelList;
    private java.lang.String fechaPublicacion;
    private java.lang.Object[] fechaPublicacionValueList;
    private java.lang.Object[] fechaPublicacionLabelList;
    private java.lang.String urlEntregar;
    private java.lang.Object[] urlEntregarValueList;
    private java.lang.Object[] urlEntregarLabelList;
    private java.lang.String numVecesPrevisualizado;
    private java.lang.Object[] numVecesPrevisualizadoValueList;
    private java.lang.Object[] numVecesPrevisualizadoLabelList;
    private java.lang.String tipoBusquedaArbol;
    private java.lang.Object[] tipoBusquedaArbolValueList;
    private java.lang.Object[] tipoBusquedaArbolLabelList;
    private java.lang.String[] etiquetas;
    private java.lang.Object[] etiquetasValueList;
    private java.lang.Object[] etiquetasLabelList;
    private java.lang.String mesPublicacion;
    private java.lang.Object[] mesPublicacionValueList;
    private java.lang.Object[] mesPublicacionLabelList;
    private es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaVO resultados;
    private java.lang.Object[] resultadosValueList;
    private java.lang.Object[] resultadosLabelList;
    private java.lang.String urlODE;
    private java.lang.Object[] urlODEValueList;
    private java.lang.Object[] urlODELabelList;
    private java.lang.String idLocalizador;
    private java.lang.Object[] idLocalizadorValueList;
    private java.lang.Object[] idLocalizadorLabelList;
    private java.lang.String identificadorODEFederado;
    private java.lang.Object[] identificadorODEFederadoValueList;
    private java.lang.Object[] identificadorODEFederadoLabelList;
    private java.lang.String posicionamientoAnterior;
    private java.lang.Object[] posicionamientoAnteriorValueList;
    private java.lang.Object[] posicionamientoAnteriorLabelList;
    private java.lang.String posicionamiento;
    private java.lang.Object[] posicionamientoValueList;
    private java.lang.Object[] posicionamientoLabelList;
    private java.lang.String tituloODE;
    private java.lang.Object[] tituloODEValueList;
    private java.lang.Object[] tituloODELabelList;
    private java.lang.String tipoAgregacion;
    private java.lang.Object[] tipoAgregacionValueList;
    private java.lang.Object[] tipoAgregacionLabelList;
    private java.lang.String areaCurricularBusqueda;
    private java.lang.Object[] areaCurricularBusquedaValueList;
    private java.lang.Object[] areaCurricularBusquedaLabelList;
    private java.lang.String posicionamientoSiguiente;
    private java.lang.Object[] posicionamientoSiguienteValueList;
    private java.lang.Object[] posicionamientoSiguienteLabelList;
    private java.lang.String numVecesVisto;
    private java.lang.Object[] numVecesVistoValueList;
    private java.lang.Object[] numVecesVistoLabelList;
    private java.lang.String anyoPublicacion;
    private java.lang.Object[] anyoPublicacionValueList;
    private java.lang.Object[] anyoPublicacionLabelList;
    private java.lang.String tesauroBusqueda;
    private java.lang.Object[] tesauroBusquedaValueList;
    private java.lang.Object[] tesauroBusquedaLabelList;
    private java.lang.String areaCurricular;
    private java.lang.Object[] areaCurricularValueList;
    private java.lang.Object[] areaCurricularLabelList;
    private java.lang.String valoracion;
    private java.lang.Object[] valoracionValueList;
    private java.lang.Object[] valoracionLabelList;
    private java.lang.String idODE;
    private java.lang.Object[] idODEValueList;
    private java.lang.Object[] idODELabelList;
    private java.lang.String edad;
    private java.lang.Object[] edadValueList;
    private java.lang.Object[] edadLabelList;
    private java.lang.String tamanio;
    private java.lang.Object[] tamanioValueList;
    private java.lang.Object[] tamanioLabelList;
    private java.lang.String nodoDestino;
    private java.lang.Object[] nodoDestinoValueList;
    private java.lang.Object[] nodoDestinoLabelList;
    private java.lang.Boolean existeSesion;
    private java.lang.Object[] existeSesionValueList;
    private java.lang.Object[] existeSesionLabelList;
    private java.lang.String c_s_secuencia;
    private java.lang.Object[] c_s_secuenciaValueList;
    private java.lang.Object[] c_s_secuenciaLabelList;
    private java.lang.String imagenAmpliada;
    private java.lang.Object[] imagenAmpliadaValueList;
    private java.lang.Object[] imagenAmpliadaLabelList;
    private java.lang.String numVecesEnviado;
    private java.lang.Object[] numVecesEnviadoValueList;
    private java.lang.Object[] numVecesEnviadoLabelList;
    private java.lang.String nodoOrigen;
    private java.lang.Object[] nodoOrigenValueList;
    private java.lang.Object[] nodoOrigenLabelList;
    private java.lang.String busquedaSimpleAvanzada;
    private java.lang.Object[] busquedaSimpleAvanzadaValueList;
    private java.lang.Object[] busquedaSimpleAvanzadaLabelList;
    private java.lang.String descripcion;
    private java.lang.Object[] descripcionValueList;
    private java.lang.Object[] descripcionLabelList;
    private java.lang.String ambito;
    private java.lang.Object[] ambitoValueList;
    private java.lang.Object[] ambitoLabelList;
    private java.lang.String procesoCognitivo;
    private java.lang.Object[] procesoCognitivoValueList;
    private java.lang.Object[] procesoCognitivoLabelList;
    private java.lang.Boolean usuarioLogado;
    private java.lang.Object[] usuarioLogadoValueList;
    private java.lang.Object[] usuarioLogadoLabelList;
    private java.lang.String titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.lang.String localizadorODE;
    private java.lang.Object[] localizadorODEValueList;
    private java.lang.Object[] localizadorODELabelList;
    private java.lang.Boolean agregacionCorrecta;
    private java.lang.Object[] agregacionCorrectaValueList;
    private java.lang.Object[] agregacionCorrectaLabelList;

    public SeleccionaCSSecuenciaCancelarFormImpl()
    {
    }

    /**
     * Resets the given <code>licencias</code>.
     */
    public void resetLicencias()
    {
        this.licencias = null;
    }

    public void setLicencias(java.lang.String licencias)
    {
        this.licencias = licencias;
    }

    /**
     * 
     */
    public java.lang.String getLicencias()
    {
        return this.licencias;
    }
    
    public java.lang.Object[] getLicenciasBackingList()
    {
        java.lang.Object[] values = this.licenciasValueList;
        java.lang.Object[] labels = this.licenciasLabelList;

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

    public java.lang.Object[] getLicenciasValueList()
    {
        return this.licenciasValueList;
    }

    public void setLicenciasValueList(java.lang.Object[] licenciasValueList)
    {
        this.licenciasValueList = licenciasValueList;
    }

    public java.lang.Object[] getLicenciasLabelList()
    {
        return this.licenciasLabelList;
    }

    public void setLicenciasLabelList(java.lang.Object[] licenciasLabelList)
    {
        this.licenciasLabelList = licenciasLabelList;
    }

    public void setLicenciasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setLicenciasBackingList requires non-null property arguments");
        }

        this.licenciasValueList = null;
        this.licenciasLabelList = null;

        if (items != null)
        {
            this.licenciasValueList = new java.lang.Object[items.size()];
            this.licenciasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.licenciasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.licenciasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setLicenciasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>size</code>.
     */
    public void resetSize()
    {
        this.size = null;
    }

    public void setSize(java.lang.String size)
    {
        this.size = size;
    }

    /**
     * 
     */
    public java.lang.String getSize()
    {
        return this.size;
    }
    
    public java.lang.Object[] getSizeBackingList()
    {
        java.lang.Object[] values = this.sizeValueList;
        java.lang.Object[] labels = this.sizeLabelList;

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

    public java.lang.Object[] getSizeValueList()
    {
        return this.sizeValueList;
    }

    public void setSizeValueList(java.lang.Object[] sizeValueList)
    {
        this.sizeValueList = sizeValueList;
    }

    public java.lang.Object[] getSizeLabelList()
    {
        return this.sizeLabelList;
    }

    public void setSizeLabelList(java.lang.Object[] sizeLabelList)
    {
        this.sizeLabelList = sizeLabelList;
    }

    public void setSizeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setSizeBackingList requires non-null property arguments");
        }

        this.sizeValueList = null;
        this.sizeLabelList = null;

        if (items != null)
        {
            this.sizeValueList = new java.lang.Object[items.size()];
            this.sizeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.sizeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.sizeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setSizeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>annotation</code>.
     */
    public void resetAnnotation()
    {
        this.annotation = null;
    }

    public void setAnnotation(java.lang.String annotation)
    {
        this.annotation = annotation;
    }

    /**
     * 
     */
    public java.lang.String getAnnotation()
    {
        return this.annotation;
    }
    
    public java.lang.Object[] getAnnotationBackingList()
    {
        java.lang.Object[] values = this.annotationValueList;
        java.lang.Object[] labels = this.annotationLabelList;

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

    public java.lang.Object[] getAnnotationValueList()
    {
        return this.annotationValueList;
    }

    public void setAnnotationValueList(java.lang.Object[] annotationValueList)
    {
        this.annotationValueList = annotationValueList;
    }

    public java.lang.Object[] getAnnotationLabelList()
    {
        return this.annotationLabelList;
    }

    public void setAnnotationLabelList(java.lang.Object[] annotationLabelList)
    {
        this.annotationLabelList = annotationLabelList;
    }

    public void setAnnotationBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetallarODECUFormImpl.setAnnotationBackingList requires non-null property arguments");
        }

        this.annotationValueList = null;
        this.annotationLabelList = null;

        if (items != null)
        {
            this.annotationValueList = new java.lang.Object[items.size()];
            this.annotationLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.annotationValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.annotationLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetallarODECUFormImpl.setAnnotationBackingList encountered an exception", ex);
            }
        }
    }


    /**
     * Resets the given <code>learningResourceType</code>.
     */
    public void resetLearningResourceType()
    {
        this.learningResourceType = null;
    }

    public void setLearningResourceType(java.lang.String learningResourceType)
    {
        this.learningResourceType = learningResourceType;
    }

    /**
     * 
     */
    public java.lang.String getLearningResourceType()
    {
        return this.learningResourceType;
    }
    
    public java.lang.Object[] getLearningResourceTypeBackingList()
    {
        java.lang.Object[] values = this.learningResourceTypeValueList;
        java.lang.Object[] labels = this.learningResourceTypeLabelList;

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

    public java.lang.Object[] getLearningResourceTypeValueList()
    {
        return this.learningResourceTypeValueList;
    }

    public void setLearningResourceTypeValueList(java.lang.Object[] learningResourceTypeValueList)
    {
        this.learningResourceTypeValueList = learningResourceTypeValueList;
    }

    public java.lang.Object[] getLearningResourceTypeLabelList()
    {
        return this.learningResourceTypeLabelList;
    }

    public void setLearningResourceTypeLabelList(java.lang.Object[] learningResourceTypeLabelList)
    {
        this.learningResourceTypeLabelList = learningResourceTypeLabelList;
    }

    public void setLearningResourceTypeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("DetallarODECUFormImpl.setLearningResourceTypeBackingList requires non-null property arguments");
        }

        this.learningResourceTypeValueList = null;
        this.learningResourceTypeLabelList = null;

        if (items != null)
        {
            this.learningResourceTypeValueList = new java.lang.Object[items.size()];
            this.learningResourceTypeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.learningResourceTypeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.learningResourceTypeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("DetallarODECUFormImpl.setLearningResourceTypeBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setBuscadorContenidoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setBuscadorContenidoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setTipoVisualizacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setTipoVisualizacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setFormatoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setFormatoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>agregarFederado</code>.
     */
    public void resetAgregarFederado()
    {
        this.agregarFederado = null;
    }

    public void setAgregarFederado(java.lang.Boolean agregarFederado)
    {
        this.agregarFederado = agregarFederado;
    }

    /**
     * 
     */
    public java.lang.Boolean getAgregarFederado()
    {
        return this.agregarFederado;
    }
    
    public java.lang.Object[] getAgregarFederadoBackingList()
    {
        java.lang.Object[] values = this.agregarFederadoValueList;
        java.lang.Object[] labels = this.agregarFederadoLabelList;

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

    public java.lang.Object[] getAgregarFederadoValueList()
    {
        return this.agregarFederadoValueList;
    }

    public void setAgregarFederadoValueList(java.lang.Object[] agregarFederadoValueList)
    {
        this.agregarFederadoValueList = agregarFederadoValueList;
    }

    public java.lang.Object[] getAgregarFederadoLabelList()
    {
        return this.agregarFederadoLabelList;
    }

    public void setAgregarFederadoLabelList(java.lang.Object[] agregarFederadoLabelList)
    {
        this.agregarFederadoLabelList = agregarFederadoLabelList;
    }

    public void setAgregarFederadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setAgregarFederadoBackingList requires non-null property arguments");
        }

        this.agregarFederadoValueList = null;
        this.agregarFederadoLabelList = null;

        if (items != null)
        {
            this.agregarFederadoValueList = new java.lang.Object[items.size()];
            this.agregarFederadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.agregarFederadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.agregarFederadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setAgregarFederadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>numVecesDescargado</code>.
     */
    public void resetNumVecesDescargado()
    {
        this.numVecesDescargado = null;
    }

    public void setNumVecesDescargado(java.lang.String numVecesDescargado)
    {
        this.numVecesDescargado = numVecesDescargado;
    }

    /**
     * 
     */
    public java.lang.String getNumVecesDescargado()
    {
        return this.numVecesDescargado;
    }
    
    public java.lang.Object[] getNumVecesDescargadoBackingList()
    {
        java.lang.Object[] values = this.numVecesDescargadoValueList;
        java.lang.Object[] labels = this.numVecesDescargadoLabelList;

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

    public java.lang.Object[] getNumVecesDescargadoValueList()
    {
        return this.numVecesDescargadoValueList;
    }

    public void setNumVecesDescargadoValueList(java.lang.Object[] numVecesDescargadoValueList)
    {
        this.numVecesDescargadoValueList = numVecesDescargadoValueList;
    }

    public java.lang.Object[] getNumVecesDescargadoLabelList()
    {
        return this.numVecesDescargadoLabelList;
    }

    public void setNumVecesDescargadoLabelList(java.lang.Object[] numVecesDescargadoLabelList)
    {
        this.numVecesDescargadoLabelList = numVecesDescargadoLabelList;
    }

    public void setNumVecesDescargadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setNumVecesDescargadoBackingList requires non-null property arguments");
        }

        this.numVecesDescargadoValueList = null;
        this.numVecesDescargadoLabelList = null;

        if (items != null)
        {
            this.numVecesDescargadoValueList = new java.lang.Object[items.size()];
            this.numVecesDescargadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.numVecesDescargadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.numVecesDescargadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setNumVecesDescargadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setMostrarVueltaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setMostrarVueltaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setPaginaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setPaginaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setIdentificadorODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setIdentificadorODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomaODE</code>.
     */
    public void resetIdiomaODE()
    {
        this.idiomaODE = null;
    }

    public void setIdiomaODE(java.lang.String idiomaODE)
    {
        this.idiomaODE = idiomaODE;
    }

    /**
     * 
     */
    public java.lang.String getIdiomaODE()
    {
        return this.idiomaODE;
    }
    
    public java.lang.Object[] getIdiomaODEBackingList()
    {
        java.lang.Object[] values = this.idiomaODEValueList;
        java.lang.Object[] labels = this.idiomaODELabelList;

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

    public java.lang.Object[] getIdiomaODEValueList()
    {
        return this.idiomaODEValueList;
    }

    public void setIdiomaODEValueList(java.lang.Object[] idiomaODEValueList)
    {
        this.idiomaODEValueList = idiomaODEValueList;
    }

    public java.lang.Object[] getIdiomaODELabelList()
    {
        return this.idiomaODELabelList;
    }

    public void setIdiomaODELabelList(java.lang.Object[] idiomaODELabelList)
    {
        this.idiomaODELabelList = idiomaODELabelList;
    }

    public void setIdiomaODEBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setIdiomaODEBackingList requires non-null property arguments");
        }

        this.idiomaODEValueList = null;
        this.idiomaODELabelList = null;

        if (items != null)
        {
            this.idiomaODEValueList = new java.lang.Object[items.size()];
            this.idiomaODELabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomaODEValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomaODELabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setIdiomaODEBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setSeleccionarSecuenciaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setSeleccionarSecuenciaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setDiaPublicacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setDiaPublicacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setRecursoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setRecursoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setContextoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setContextoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setDestinatariosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setDestinatariosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setAutorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setAutorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nrComentarios</code>.
     */
    public void resetNrComentarios()
    {
        this.nrComentarios = null;
    }

    public void setNrComentarios(String nrComentarios)
    {
        this.nrComentarios = nrComentarios;
    }

    /**
     * 
     */
    public String getNrComentarios()
    {
        return this.nrComentarios;
    }
    
    public java.lang.Object[] getNrComentariosBackingList()
    {
        java.lang.Object[] values = this.nrComentariosValueList;
        java.lang.Object[] labels = this.nrComentariosLabelList;

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

    public java.lang.Object[] getNrComentariosValueList()
    {
        return this.nrComentariosValueList;
    }

    public void setNrComentariosValueList(java.lang.Object[] nrComentariosValueList)
    {
        this.nrComentariosValueList = nrComentariosValueList;
    }

    public java.lang.Object[] getNrComentariosLabelList()
    {
        return this.nrComentariosLabelList;
    }

    public void setNrComentariosLabelList(java.lang.Object[] nrComentariosLabelList)
    {
        this.nrComentariosLabelList = nrComentariosLabelList;
    }

    public void setNrComentariosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setNrComentariosBackingList requires non-null property arguments");
        }

        this.nrComentariosValueList = null;
        this.nrComentariosLabelList = null;

        if (items != null)
        {
            this.nrComentariosValueList = new java.lang.Object[items.size()];
            this.nrComentariosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nrComentariosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nrComentariosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setNrComentariosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setIdiomaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>existenEtiquetas</code>.
     */
    public void resetExistenEtiquetas()
    {
        this.existenEtiquetas = null;
    }

    public void setExistenEtiquetas(java.lang.Boolean existenEtiquetas)
    {
        this.existenEtiquetas = existenEtiquetas;
    }

    /**
     * <p>
     * indica si existen etiquetas sociales asociadas al ODE
     * </p>
     */
    public java.lang.Boolean getExistenEtiquetas()
    {
        return this.existenEtiquetas;
    }
    
    public java.lang.Object[] getExistenEtiquetasBackingList()
    {
        java.lang.Object[] values = this.existenEtiquetasValueList;
        java.lang.Object[] labels = this.existenEtiquetasLabelList;

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

    public java.lang.Object[] getExistenEtiquetasValueList()
    {
        return this.existenEtiquetasValueList;
    }

    public void setExistenEtiquetasValueList(java.lang.Object[] existenEtiquetasValueList)
    {
        this.existenEtiquetasValueList = existenEtiquetasValueList;
    }

    public java.lang.Object[] getExistenEtiquetasLabelList()
    {
        return this.existenEtiquetasLabelList;
    }

    public void setExistenEtiquetasLabelList(java.lang.Object[] existenEtiquetasLabelList)
    {
        this.existenEtiquetasLabelList = existenEtiquetasLabelList;
    }

    public void setExistenEtiquetasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setExistenEtiquetasBackingList requires non-null property arguments");
        }

        this.existenEtiquetasValueList = null;
        this.existenEtiquetasLabelList = null;

        if (items != null)
        {
            this.existenEtiquetasValueList = new java.lang.Object[items.size()];
            this.existenEtiquetasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.existenEtiquetasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.existenEtiquetasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setExistenEtiquetasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>imagen</code>.
     */
    public void resetImagen()
    {
        this.imagen = null;
    }

    public void setImagen(java.lang.String imagen)
    {
        this.imagen = imagen;
    }

    /**
     * 
     */
    public java.lang.String getImagen()
    {
        return this.imagen;
    }
    
    public java.lang.Object[] getImagenBackingList()
    {
        java.lang.Object[] values = this.imagenValueList;
        java.lang.Object[] labels = this.imagenLabelList;

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

    public java.lang.Object[] getImagenValueList()
    {
        return this.imagenValueList;
    }

    public void setImagenValueList(java.lang.Object[] imagenValueList)
    {
        this.imagenValueList = imagenValueList;
    }

    public java.lang.Object[] getImagenLabelList()
    {
        return this.imagenLabelList;
    }

    public void setImagenLabelList(java.lang.Object[] imagenLabelList)
    {
        this.imagenLabelList = imagenLabelList;
    }

    public void setImagenBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setImagenBackingList requires non-null property arguments");
        }

        this.imagenValueList = null;
        this.imagenLabelList = null;

        if (items != null)
        {
            this.imagenValueList = new java.lang.Object[items.size()];
            this.imagenLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.imagenValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.imagenLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setImagenBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>fechaPublicacion</code>.
     */
    public void resetFechaPublicacion()
    {
        this.fechaPublicacion = null;
    }

    public void setFechaPublicacion(java.lang.String fechaPublicacion)
    {
        this.fechaPublicacion = fechaPublicacion;
    }

    /**
     * 
     */
    public java.lang.String getFechaPublicacion()
    {
        return this.fechaPublicacion;
    }
    
    public java.lang.Object[] getFechaPublicacionBackingList()
    {
        java.lang.Object[] values = this.fechaPublicacionValueList;
        java.lang.Object[] labels = this.fechaPublicacionLabelList;

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

    public java.lang.Object[] getFechaPublicacionValueList()
    {
        return this.fechaPublicacionValueList;
    }

    public void setFechaPublicacionValueList(java.lang.Object[] fechaPublicacionValueList)
    {
        this.fechaPublicacionValueList = fechaPublicacionValueList;
    }

    public java.lang.Object[] getFechaPublicacionLabelList()
    {
        return this.fechaPublicacionLabelList;
    }

    public void setFechaPublicacionLabelList(java.lang.Object[] fechaPublicacionLabelList)
    {
        this.fechaPublicacionLabelList = fechaPublicacionLabelList;
    }

    public void setFechaPublicacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setFechaPublicacionBackingList requires non-null property arguments");
        }

        this.fechaPublicacionValueList = null;
        this.fechaPublicacionLabelList = null;

        if (items != null)
        {
            this.fechaPublicacionValueList = new java.lang.Object[items.size()];
            this.fechaPublicacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.fechaPublicacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.fechaPublicacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setFechaPublicacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>urlEntregar</code>.
     */
    public void resetUrlEntregar()
    {
        this.urlEntregar = null;
    }

    public void setUrlEntregar(java.lang.String urlEntregar)
    {
        this.urlEntregar = urlEntregar;
    }

    /**
     * 
     */
    public java.lang.String getUrlEntregar()
    {
        return this.urlEntregar;
    }
    
    public java.lang.Object[] getUrlEntregarBackingList()
    {
        java.lang.Object[] values = this.urlEntregarValueList;
        java.lang.Object[] labels = this.urlEntregarLabelList;

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

    public java.lang.Object[] getUrlEntregarValueList()
    {
        return this.urlEntregarValueList;
    }

    public void setUrlEntregarValueList(java.lang.Object[] urlEntregarValueList)
    {
        this.urlEntregarValueList = urlEntregarValueList;
    }

    public java.lang.Object[] getUrlEntregarLabelList()
    {
        return this.urlEntregarLabelList;
    }

    public void setUrlEntregarLabelList(java.lang.Object[] urlEntregarLabelList)
    {
        this.urlEntregarLabelList = urlEntregarLabelList;
    }

    public void setUrlEntregarBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setUrlEntregarBackingList requires non-null property arguments");
        }

        this.urlEntregarValueList = null;
        this.urlEntregarLabelList = null;

        if (items != null)
        {
            this.urlEntregarValueList = new java.lang.Object[items.size()];
            this.urlEntregarLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.urlEntregarValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.urlEntregarLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setUrlEntregarBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>numVecesPrevisualizado</code>.
     */
    public void resetNumVecesPrevisualizado()
    {
        this.numVecesPrevisualizado = null;
    }

    public void setNumVecesPrevisualizado(java.lang.String numVecesPrevisualizado)
    {
        this.numVecesPrevisualizado = numVecesPrevisualizado;
    }

    /**
     * 
     */
    public java.lang.String getNumVecesPrevisualizado()
    {
        return this.numVecesPrevisualizado;
    }
    
    public java.lang.Object[] getNumVecesPrevisualizadoBackingList()
    {
        java.lang.Object[] values = this.numVecesPrevisualizadoValueList;
        java.lang.Object[] labels = this.numVecesPrevisualizadoLabelList;

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

    public java.lang.Object[] getNumVecesPrevisualizadoValueList()
    {
        return this.numVecesPrevisualizadoValueList;
    }

    public void setNumVecesPrevisualizadoValueList(java.lang.Object[] numVecesPrevisualizadoValueList)
    {
        this.numVecesPrevisualizadoValueList = numVecesPrevisualizadoValueList;
    }

    public java.lang.Object[] getNumVecesPrevisualizadoLabelList()
    {
        return this.numVecesPrevisualizadoLabelList;
    }

    public void setNumVecesPrevisualizadoLabelList(java.lang.Object[] numVecesPrevisualizadoLabelList)
    {
        this.numVecesPrevisualizadoLabelList = numVecesPrevisualizadoLabelList;
    }

    public void setNumVecesPrevisualizadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setNumVecesPrevisualizadoBackingList requires non-null property arguments");
        }

        this.numVecesPrevisualizadoValueList = null;
        this.numVecesPrevisualizadoLabelList = null;

        if (items != null)
        {
            this.numVecesPrevisualizadoValueList = new java.lang.Object[items.size()];
            this.numVecesPrevisualizadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.numVecesPrevisualizadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.numVecesPrevisualizadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setNumVecesPrevisualizadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setTipoBusquedaArbolBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setTipoBusquedaArbolBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>etiquetas</code>.
     */
    public void resetEtiquetas()
    {
        this.etiquetas = null;
    }

    public void setEtiquetas(java.lang.String[] etiquetas)
    {
        this.etiquetas = etiquetas;
    }

    /**
     * <p>
     * etiquetas sociales asociadas al ODE
     * </p>
     */
    public java.lang.String[] getEtiquetas()
    {
        return this.etiquetas;
    }
    
    public java.lang.Object[] getEtiquetasBackingList()
    {
        java.lang.Object[] values = this.etiquetasValueList;
        java.lang.Object[] labels = this.etiquetasLabelList;

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

    public java.lang.Object[] getEtiquetasValueList()
    {
        return this.etiquetasValueList;
    }

    public void setEtiquetasValueList(java.lang.Object[] etiquetasValueList)
    {
        this.etiquetasValueList = etiquetasValueList;
    }

    public java.lang.Object[] getEtiquetasLabelList()
    {
        return this.etiquetasLabelList;
    }

    public void setEtiquetasLabelList(java.lang.Object[] etiquetasLabelList)
    {
        this.etiquetasLabelList = etiquetasLabelList;
    }

    public void setEtiquetasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setEtiquetasBackingList requires non-null property arguments");
        }

        this.etiquetasValueList = null;
        this.etiquetasLabelList = null;

        if (items != null)
        {
            this.etiquetasValueList = new java.lang.Object[items.size()];
            this.etiquetasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.etiquetasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.etiquetasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setEtiquetasBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setMesPublicacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setMesPublicacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>resultados</code>.
     */
    public void resetResultados()
    {
        this.resultados = null;
    }

    public void setResultados(es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaVO resultados)
    {
        this.resultados = resultados;
    }

    /**
     * 
     */
    public es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaVO getResultados()
    {
        return this.resultados;
    }
    
    public java.lang.Object[] getResultadosBackingList()
    {
        java.lang.Object[] values = this.resultadosValueList;
        java.lang.Object[] labels = this.resultadosLabelList;

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

    public java.lang.Object[] getResultadosValueList()
    {
        return this.resultadosValueList;
    }

    public void setResultadosValueList(java.lang.Object[] resultadosValueList)
    {
        this.resultadosValueList = resultadosValueList;
    }

    public java.lang.Object[] getResultadosLabelList()
    {
        return this.resultadosLabelList;
    }

    public void setResultadosLabelList(java.lang.Object[] resultadosLabelList)
    {
        this.resultadosLabelList = resultadosLabelList;
    }

    public void setResultadosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setResultadosBackingList requires non-null property arguments");
        }

        this.resultadosValueList = null;
        this.resultadosLabelList = null;

        if (items != null)
        {
            this.resultadosValueList = new java.lang.Object[items.size()];
            this.resultadosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resultadosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resultadosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setResultadosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>urlODE</code>.
     */
    public void resetUrlODE()
    {
        this.urlODE = null;
    }

    public void setUrlODE(java.lang.String urlODE)
    {
        this.urlODE = urlODE;
    }

    /**
     * 
     */
    public java.lang.String getUrlODE()
    {
        return this.urlODE;
    }
    
    public java.lang.Object[] getUrlODEBackingList()
    {
        java.lang.Object[] values = this.urlODEValueList;
        java.lang.Object[] labels = this.urlODELabelList;

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

    public java.lang.Object[] getUrlODEValueList()
    {
        return this.urlODEValueList;
    }

    public void setUrlODEValueList(java.lang.Object[] urlODEValueList)
    {
        this.urlODEValueList = urlODEValueList;
    }

    public java.lang.Object[] getUrlODELabelList()
    {
        return this.urlODELabelList;
    }

    public void setUrlODELabelList(java.lang.Object[] urlODELabelList)
    {
        this.urlODELabelList = urlODELabelList;
    }

    public void setUrlODEBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setUrlODEBackingList requires non-null property arguments");
        }

        this.urlODEValueList = null;
        this.urlODELabelList = null;

        if (items != null)
        {
            this.urlODEValueList = new java.lang.Object[items.size()];
            this.urlODELabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.urlODEValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.urlODELabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setUrlODEBackingList encountered an exception", ex);
            }
        }
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setIdLocalizadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setIdLocalizadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificadorODEFederado</code>.
     */
    public void resetIdentificadorODEFederado()
    {
        this.identificadorODEFederado = null;
    }

    public void setIdentificadorODEFederado(java.lang.String identificadorODEFederado)
    {
        this.identificadorODEFederado = identificadorODEFederado;
    }

    /**
     * 
     */
    public java.lang.String getIdentificadorODEFederado()
    {
        return this.identificadorODEFederado;
    }
    
    public java.lang.Object[] getIdentificadorODEFederadoBackingList()
    {
        java.lang.Object[] values = this.identificadorODEFederadoValueList;
        java.lang.Object[] labels = this.identificadorODEFederadoLabelList;

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

    public java.lang.Object[] getIdentificadorODEFederadoValueList()
    {
        return this.identificadorODEFederadoValueList;
    }

    public void setIdentificadorODEFederadoValueList(java.lang.Object[] identificadorODEFederadoValueList)
    {
        this.identificadorODEFederadoValueList = identificadorODEFederadoValueList;
    }

    public java.lang.Object[] getIdentificadorODEFederadoLabelList()
    {
        return this.identificadorODEFederadoLabelList;
    }

    public void setIdentificadorODEFederadoLabelList(java.lang.Object[] identificadorODEFederadoLabelList)
    {
        this.identificadorODEFederadoLabelList = identificadorODEFederadoLabelList;
    }

    public void setIdentificadorODEFederadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setIdentificadorODEFederadoBackingList requires non-null property arguments");
        }

        this.identificadorODEFederadoValueList = null;
        this.identificadorODEFederadoLabelList = null;

        if (items != null)
        {
            this.identificadorODEFederadoValueList = new java.lang.Object[items.size()];
            this.identificadorODEFederadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadorODEFederadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadorODEFederadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setIdentificadorODEFederadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>posicionamientoAnterior</code>.
     */
    public void resetPosicionamientoAnterior()
    {
        this.posicionamientoAnterior = null;
    }

    public void setPosicionamientoAnterior(java.lang.String posicionamientoAnterior)
    {
        this.posicionamientoAnterior = posicionamientoAnterior;
    }

    /**
     * 
     */
    public java.lang.String getPosicionamientoAnterior()
    {
        return this.posicionamientoAnterior;
    }
    
    public java.lang.Object[] getPosicionamientoAnteriorBackingList()
    {
        java.lang.Object[] values = this.posicionamientoAnteriorValueList;
        java.lang.Object[] labels = this.posicionamientoAnteriorLabelList;

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

    public java.lang.Object[] getPosicionamientoAnteriorValueList()
    {
        return this.posicionamientoAnteriorValueList;
    }

    public void setPosicionamientoAnteriorValueList(java.lang.Object[] posicionamientoAnteriorValueList)
    {
        this.posicionamientoAnteriorValueList = posicionamientoAnteriorValueList;
    }

    public java.lang.Object[] getPosicionamientoAnteriorLabelList()
    {
        return this.posicionamientoAnteriorLabelList;
    }

    public void setPosicionamientoAnteriorLabelList(java.lang.Object[] posicionamientoAnteriorLabelList)
    {
        this.posicionamientoAnteriorLabelList = posicionamientoAnteriorLabelList;
    }

    public void setPosicionamientoAnteriorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setPosicionamientoAnteriorBackingList requires non-null property arguments");
        }

        this.posicionamientoAnteriorValueList = null;
        this.posicionamientoAnteriorLabelList = null;

        if (items != null)
        {
            this.posicionamientoAnteriorValueList = new java.lang.Object[items.size()];
            this.posicionamientoAnteriorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.posicionamientoAnteriorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.posicionamientoAnteriorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setPosicionamientoAnteriorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>posicionamiento</code>.
     */
    public void resetPosicionamiento()
    {
        this.posicionamiento = null;
    }

    public void setPosicionamiento(java.lang.String posicionamiento)
    {
        this.posicionamiento = posicionamiento;
    }

    /**
     * 
     */
    public java.lang.String getPosicionamiento()
    {
        return this.posicionamiento;
    }
    
    public java.lang.Object[] getPosicionamientoBackingList()
    {
        java.lang.Object[] values = this.posicionamientoValueList;
        java.lang.Object[] labels = this.posicionamientoLabelList;

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

    public java.lang.Object[] getPosicionamientoValueList()
    {
        return this.posicionamientoValueList;
    }

    public void setPosicionamientoValueList(java.lang.Object[] posicionamientoValueList)
    {
        this.posicionamientoValueList = posicionamientoValueList;
    }

    public java.lang.Object[] getPosicionamientoLabelList()
    {
        return this.posicionamientoLabelList;
    }

    public void setPosicionamientoLabelList(java.lang.Object[] posicionamientoLabelList)
    {
        this.posicionamientoLabelList = posicionamientoLabelList;
    }

    public void setPosicionamientoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setPosicionamientoBackingList requires non-null property arguments");
        }

        this.posicionamientoValueList = null;
        this.posicionamientoLabelList = null;

        if (items != null)
        {
            this.posicionamientoValueList = new java.lang.Object[items.size()];
            this.posicionamientoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.posicionamientoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.posicionamientoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setPosicionamientoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tituloODE</code>.
     */
    public void resetTituloODE()
    {
        this.tituloODE = null;
    }

    public void setTituloODE(java.lang.String tituloODE)
    {
        this.tituloODE = tituloODE;
    }

    /**
     * 
     */
    public java.lang.String getTituloODE()
    {
        return this.tituloODE;
    }
    
    public java.lang.Object[] getTituloODEBackingList()
    {
        java.lang.Object[] values = this.tituloODEValueList;
        java.lang.Object[] labels = this.tituloODELabelList;

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

    public java.lang.Object[] getTituloODEValueList()
    {
        return this.tituloODEValueList;
    }

    public void setTituloODEValueList(java.lang.Object[] tituloODEValueList)
    {
        this.tituloODEValueList = tituloODEValueList;
    }

    public java.lang.Object[] getTituloODELabelList()
    {
        return this.tituloODELabelList;
    }

    public void setTituloODELabelList(java.lang.Object[] tituloODELabelList)
    {
        this.tituloODELabelList = tituloODELabelList;
    }

    public void setTituloODEBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setTituloODEBackingList requires non-null property arguments");
        }

        this.tituloODEValueList = null;
        this.tituloODELabelList = null;

        if (items != null)
        {
            this.tituloODEValueList = new java.lang.Object[items.size()];
            this.tituloODELabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tituloODEValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tituloODELabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setTituloODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoAgregacion</code>.
     */
    public void resetTipoAgregacion()
    {
        this.tipoAgregacion = null;
    }

    public void setTipoAgregacion(java.lang.String tipoAgregacion)
    {
        this.tipoAgregacion = tipoAgregacion;
    }

    /**
     * 
     */
    public java.lang.String getTipoAgregacion()
    {
        return this.tipoAgregacion;
    }
    
    public java.lang.Object[] getTipoAgregacionBackingList()
    {
        java.lang.Object[] values = this.tipoAgregacionValueList;
        java.lang.Object[] labels = this.tipoAgregacionLabelList;

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

    public java.lang.Object[] getTipoAgregacionValueList()
    {
        return this.tipoAgregacionValueList;
    }

    public void setTipoAgregacionValueList(java.lang.Object[] tipoAgregacionValueList)
    {
        this.tipoAgregacionValueList = tipoAgregacionValueList;
    }

    public java.lang.Object[] getTipoAgregacionLabelList()
    {
        return this.tipoAgregacionLabelList;
    }

    public void setTipoAgregacionLabelList(java.lang.Object[] tipoAgregacionLabelList)
    {
        this.tipoAgregacionLabelList = tipoAgregacionLabelList;
    }

    public void setTipoAgregacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setTipoAgregacionBackingList requires non-null property arguments");
        }

        this.tipoAgregacionValueList = null;
        this.tipoAgregacionLabelList = null;

        if (items != null)
        {
            this.tipoAgregacionValueList = new java.lang.Object[items.size()];
            this.tipoAgregacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoAgregacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoAgregacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setTipoAgregacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setAreaCurricularBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setAreaCurricularBusquedaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>posicionamientoSiguiente</code>.
     */
    public void resetPosicionamientoSiguiente()
    {
        this.posicionamientoSiguiente = null;
    }

    public void setPosicionamientoSiguiente(java.lang.String posicionamientoSiguiente)
    {
        this.posicionamientoSiguiente = posicionamientoSiguiente;
    }

    /**
     * 
     */
    public java.lang.String getPosicionamientoSiguiente()
    {
        return this.posicionamientoSiguiente;
    }
    
    public java.lang.Object[] getPosicionamientoSiguienteBackingList()
    {
        java.lang.Object[] values = this.posicionamientoSiguienteValueList;
        java.lang.Object[] labels = this.posicionamientoSiguienteLabelList;

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

    public java.lang.Object[] getPosicionamientoSiguienteValueList()
    {
        return this.posicionamientoSiguienteValueList;
    }

    public void setPosicionamientoSiguienteValueList(java.lang.Object[] posicionamientoSiguienteValueList)
    {
        this.posicionamientoSiguienteValueList = posicionamientoSiguienteValueList;
    }

    public java.lang.Object[] getPosicionamientoSiguienteLabelList()
    {
        return this.posicionamientoSiguienteLabelList;
    }

    public void setPosicionamientoSiguienteLabelList(java.lang.Object[] posicionamientoSiguienteLabelList)
    {
        this.posicionamientoSiguienteLabelList = posicionamientoSiguienteLabelList;
    }

    public void setPosicionamientoSiguienteBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setPosicionamientoSiguienteBackingList requires non-null property arguments");
        }

        this.posicionamientoSiguienteValueList = null;
        this.posicionamientoSiguienteLabelList = null;

        if (items != null)
        {
            this.posicionamientoSiguienteValueList = new java.lang.Object[items.size()];
            this.posicionamientoSiguienteLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.posicionamientoSiguienteValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.posicionamientoSiguienteLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setPosicionamientoSiguienteBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>numVecesVisto</code>.
     */
    public void resetNumVecesVisto()
    {
        this.numVecesVisto = null;
    }

    public void setNumVecesVisto(java.lang.String numVecesVisto)
    {
        this.numVecesVisto = numVecesVisto;
    }

    /**
     * 
     */
    public java.lang.String getNumVecesVisto()
    {
        return this.numVecesVisto;
    }
    
    public java.lang.Object[] getNumVecesVistoBackingList()
    {
        java.lang.Object[] values = this.numVecesVistoValueList;
        java.lang.Object[] labels = this.numVecesVistoLabelList;

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

    public java.lang.Object[] getNumVecesVistoValueList()
    {
        return this.numVecesVistoValueList;
    }

    public void setNumVecesVistoValueList(java.lang.Object[] numVecesVistoValueList)
    {
        this.numVecesVistoValueList = numVecesVistoValueList;
    }

    public java.lang.Object[] getNumVecesVistoLabelList()
    {
        return this.numVecesVistoLabelList;
    }

    public void setNumVecesVistoLabelList(java.lang.Object[] numVecesVistoLabelList)
    {
        this.numVecesVistoLabelList = numVecesVistoLabelList;
    }

    public void setNumVecesVistoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setNumVecesVistoBackingList requires non-null property arguments");
        }

        this.numVecesVistoValueList = null;
        this.numVecesVistoLabelList = null;

        if (items != null)
        {
            this.numVecesVistoValueList = new java.lang.Object[items.size()];
            this.numVecesVistoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.numVecesVistoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.numVecesVistoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setNumVecesVistoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setAnyoPublicacionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setAnyoPublicacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setTesauroBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setTesauroBusquedaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setAreaCurricularBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setAreaCurricularBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setValoracionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setValoracionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idODE</code>.
     */
    public void resetIdODE()
    {
        this.idODE = null;
    }

    public void setIdODE(java.lang.String idODE)
    {
        this.idODE = idODE;
    }

    /**
     * 
     */
    public java.lang.String getIdODE()
    {
        return this.idODE;
    }
    
    public java.lang.Object[] getIdODEBackingList()
    {
        java.lang.Object[] values = this.idODEValueList;
        java.lang.Object[] labels = this.idODELabelList;

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

    public java.lang.Object[] getIdODEValueList()
    {
        return this.idODEValueList;
    }

    public void setIdODEValueList(java.lang.Object[] idODEValueList)
    {
        this.idODEValueList = idODEValueList;
    }

    public java.lang.Object[] getIdODELabelList()
    {
        return this.idODELabelList;
    }

    public void setIdODELabelList(java.lang.Object[] idODELabelList)
    {
        this.idODELabelList = idODELabelList;
    }

    public void setIdODEBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setIdODEBackingList requires non-null property arguments");
        }

        this.idODEValueList = null;
        this.idODELabelList = null;

        if (items != null)
        {
            this.idODEValueList = new java.lang.Object[items.size()];
            this.idODELabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idODEValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idODELabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setIdODEBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setEdadBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setEdadBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tamanio</code>.
     */
    public void resetTamanio()
    {
        this.tamanio = null;
    }

    public void setTamanio(java.lang.String tamanio)
    {
        this.tamanio = tamanio;
    }

    /**
     * 
     */
    public java.lang.String getTamanio()
    {
        return this.tamanio;
    }
    
    public java.lang.Object[] getTamanioBackingList()
    {
        java.lang.Object[] values = this.tamanioValueList;
        java.lang.Object[] labels = this.tamanioLabelList;

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

    public java.lang.Object[] getTamanioValueList()
    {
        return this.tamanioValueList;
    }

    public void setTamanioValueList(java.lang.Object[] tamanioValueList)
    {
        this.tamanioValueList = tamanioValueList;
    }

    public java.lang.Object[] getTamanioLabelList()
    {
        return this.tamanioLabelList;
    }

    public void setTamanioLabelList(java.lang.Object[] tamanioLabelList)
    {
        this.tamanioLabelList = tamanioLabelList;
    }

    public void setTamanioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setTamanioBackingList requires non-null property arguments");
        }

        this.tamanioValueList = null;
        this.tamanioLabelList = null;

        if (items != null)
        {
            this.tamanioValueList = new java.lang.Object[items.size()];
            this.tamanioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tamanioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tamanioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setTamanioBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setNodoDestinoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setNodoDestinoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>existeSesion</code>.
     */
    public void resetExisteSesion()
    {
        this.existeSesion = null;
    }

    public void setExisteSesion(java.lang.Boolean existeSesion)
    {
        this.existeSesion = existeSesion;
    }

    /**
     * 
     */
    public java.lang.Boolean getExisteSesion()
    {
        return this.existeSesion;
    }
    
    public java.lang.Object[] getExisteSesionBackingList()
    {
        java.lang.Object[] values = this.existeSesionValueList;
        java.lang.Object[] labels = this.existeSesionLabelList;

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

    public java.lang.Object[] getExisteSesionValueList()
    {
        return this.existeSesionValueList;
    }

    public void setExisteSesionValueList(java.lang.Object[] existeSesionValueList)
    {
        this.existeSesionValueList = existeSesionValueList;
    }

    public java.lang.Object[] getExisteSesionLabelList()
    {
        return this.existeSesionLabelList;
    }

    public void setExisteSesionLabelList(java.lang.Object[] existeSesionLabelList)
    {
        this.existeSesionLabelList = existeSesionLabelList;
    }

    public void setExisteSesionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setExisteSesionBackingList requires non-null property arguments");
        }

        this.existeSesionValueList = null;
        this.existeSesionLabelList = null;

        if (items != null)
        {
            this.existeSesionValueList = new java.lang.Object[items.size()];
            this.existeSesionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.existeSesionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.existeSesionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setExisteSesionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setC_s_secuenciaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setC_s_secuenciaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>imagenAmpliada</code>.
     */
    public void resetImagenAmpliada()
    {
        this.imagenAmpliada = null;
    }

    public void setImagenAmpliada(java.lang.String imagenAmpliada)
    {
        this.imagenAmpliada = imagenAmpliada;
    }

    /**
     * 
     */
    public java.lang.String getImagenAmpliada()
    {
        return this.imagenAmpliada;
    }
    
    public java.lang.Object[] getImagenAmpliadaBackingList()
    {
        java.lang.Object[] values = this.imagenAmpliadaValueList;
        java.lang.Object[] labels = this.imagenAmpliadaLabelList;

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

    public java.lang.Object[] getImagenAmpliadaValueList()
    {
        return this.imagenAmpliadaValueList;
    }

    public void setImagenAmpliadaValueList(java.lang.Object[] imagenAmpliadaValueList)
    {
        this.imagenAmpliadaValueList = imagenAmpliadaValueList;
    }

    public java.lang.Object[] getImagenAmpliadaLabelList()
    {
        return this.imagenAmpliadaLabelList;
    }

    public void setImagenAmpliadaLabelList(java.lang.Object[] imagenAmpliadaLabelList)
    {
        this.imagenAmpliadaLabelList = imagenAmpliadaLabelList;
    }

    public void setImagenAmpliadaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setImagenAmpliadaBackingList requires non-null property arguments");
        }

        this.imagenAmpliadaValueList = null;
        this.imagenAmpliadaLabelList = null;

        if (items != null)
        {
            this.imagenAmpliadaValueList = new java.lang.Object[items.size()];
            this.imagenAmpliadaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.imagenAmpliadaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.imagenAmpliadaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setImagenAmpliadaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>numVecesEnviado</code>.
     */
    public void resetNumVecesEnviado()
    {
        this.numVecesEnviado = null;
    }

    public void setNumVecesEnviado(java.lang.String numVecesEnviado)
    {
        this.numVecesEnviado = numVecesEnviado;
    }

    /**
     * 
     */
    public java.lang.String getNumVecesEnviado()
    {
        return this.numVecesEnviado;
    }
    
    public java.lang.Object[] getNumVecesEnviadoBackingList()
    {
        java.lang.Object[] values = this.numVecesEnviadoValueList;
        java.lang.Object[] labels = this.numVecesEnviadoLabelList;

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

    public java.lang.Object[] getNumVecesEnviadoValueList()
    {
        return this.numVecesEnviadoValueList;
    }

    public void setNumVecesEnviadoValueList(java.lang.Object[] numVecesEnviadoValueList)
    {
        this.numVecesEnviadoValueList = numVecesEnviadoValueList;
    }

    public java.lang.Object[] getNumVecesEnviadoLabelList()
    {
        return this.numVecesEnviadoLabelList;
    }

    public void setNumVecesEnviadoLabelList(java.lang.Object[] numVecesEnviadoLabelList)
    {
        this.numVecesEnviadoLabelList = numVecesEnviadoLabelList;
    }

    public void setNumVecesEnviadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setNumVecesEnviadoBackingList requires non-null property arguments");
        }

        this.numVecesEnviadoValueList = null;
        this.numVecesEnviadoLabelList = null;

        if (items != null)
        {
            this.numVecesEnviadoValueList = new java.lang.Object[items.size()];
            this.numVecesEnviadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.numVecesEnviadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.numVecesEnviadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setNumVecesEnviadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setNodoOrigenBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setNodoOrigenBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setBusquedaSimpleAvanzadaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setBusquedaSimpleAvanzadaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setDescripcionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setDescripcionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ambito</code>.
     */
    public void resetAmbito()
    {
        this.ambito = null;
    }

    public void setAmbito(java.lang.String ambito)
    {
        this.ambito = ambito;
    }

    /**
     * 
     */
    public java.lang.String getAmbito()
    {
        return this.ambito;
    }
    
    public java.lang.Object[] getAmbitoBackingList()
    {
        java.lang.Object[] values = this.ambitoValueList;
        java.lang.Object[] labels = this.ambitoLabelList;

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

    public java.lang.Object[] getAmbitoValueList()
    {
        return this.ambitoValueList;
    }

    public void setAmbitoValueList(java.lang.Object[] ambitoValueList)
    {
        this.ambitoValueList = ambitoValueList;
    }

    public java.lang.Object[] getAmbitoLabelList()
    {
        return this.ambitoLabelList;
    }

    public void setAmbitoLabelList(java.lang.Object[] ambitoLabelList)
    {
        this.ambitoLabelList = ambitoLabelList;
    }

    public void setAmbitoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setAmbitoBackingList requires non-null property arguments");
        }

        this.ambitoValueList = null;
        this.ambitoLabelList = null;

        if (items != null)
        {
            this.ambitoValueList = new java.lang.Object[items.size()];
            this.ambitoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.ambitoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.ambitoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setAmbitoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setProcesoCognitivoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setProcesoCognitivoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>usuarioLogado</code>.
     */
    public void resetUsuarioLogado()
    {
        this.usuarioLogado = null;
    }

    public void setUsuarioLogado(java.lang.Boolean usuarioLogado)
    {
        this.usuarioLogado = usuarioLogado;
    }

    /**
     * <p>
     * Devuelve true/false en función de si el usuario LDAP está
     * conectado.
     * </p>
     */
    public java.lang.Boolean getUsuarioLogado()
    {
        return this.usuarioLogado;
    }
    
    public java.lang.Object[] getUsuarioLogadoBackingList()
    {
        java.lang.Object[] values = this.usuarioLogadoValueList;
        java.lang.Object[] labels = this.usuarioLogadoLabelList;

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

    public java.lang.Object[] getUsuarioLogadoValueList()
    {
        return this.usuarioLogadoValueList;
    }

    public void setUsuarioLogadoValueList(java.lang.Object[] usuarioLogadoValueList)
    {
        this.usuarioLogadoValueList = usuarioLogadoValueList;
    }

    public java.lang.Object[] getUsuarioLogadoLabelList()
    {
        return this.usuarioLogadoLabelList;
    }

    public void setUsuarioLogadoLabelList(java.lang.Object[] usuarioLogadoLabelList)
    {
        this.usuarioLogadoLabelList = usuarioLogadoLabelList;
    }

    public void setUsuarioLogadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setUsuarioLogadoBackingList requires non-null property arguments");
        }

        this.usuarioLogadoValueList = null;
        this.usuarioLogadoLabelList = null;

        if (items != null)
        {
            this.usuarioLogadoValueList = new java.lang.Object[items.size()];
            this.usuarioLogadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.usuarioLogadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.usuarioLogadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setUsuarioLogadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setTituloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setTituloBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setLocalizadorODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setLocalizadorODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>agregacionCorrecta</code>.
     */
    public void resetAgregacionCorrecta()
    {
        this.agregacionCorrecta = null;
    }

    public void setAgregacionCorrecta(java.lang.Boolean agregacionCorrecta)
    {
        this.agregacionCorrecta = agregacionCorrecta;
    }

    /**
     * 
     */
    public java.lang.Boolean getAgregacionCorrecta()
    {
        return this.agregacionCorrecta;
    }
    
    public java.lang.Object[] getAgregacionCorrectaBackingList()
    {
        java.lang.Object[] values = this.agregacionCorrectaValueList;
        java.lang.Object[] labels = this.agregacionCorrectaLabelList;

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

    public java.lang.Object[] getAgregacionCorrectaValueList()
    {
        return this.agregacionCorrectaValueList;
    }

    public void setAgregacionCorrectaValueList(java.lang.Object[] agregacionCorrectaValueList)
    {
        this.agregacionCorrectaValueList = agregacionCorrectaValueList;
    }

    public java.lang.Object[] getAgregacionCorrectaLabelList()
    {
        return this.agregacionCorrectaLabelList;
    }

    public void setAgregacionCorrectaLabelList(java.lang.Object[] agregacionCorrectaLabelList)
    {
        this.agregacionCorrectaLabelList = agregacionCorrectaLabelList;
    }

    public void setAgregacionCorrectaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("SeleccionaCSSecuenciaCancelarFormImpl.setAgregacionCorrectaBackingList requires non-null property arguments");
        }

        this.agregacionCorrectaValueList = null;
        this.agregacionCorrectaLabelList = null;

        if (items != null)
        {
            this.agregacionCorrectaValueList = new java.lang.Object[items.size()];
            this.agregacionCorrectaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.agregacionCorrectaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.agregacionCorrectaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("SeleccionaCSSecuenciaCancelarFormImpl.setAgregacionCorrectaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.agregarFederado = null;
        this.mostrarVuelta = null;
        this.seleccionarSecuencia = null;
        this.idiomaBuscador = null;
        this.existenEtiquetas = null;
        this.etiquetas = null;
        this.existeSesion = null;
        this.usuarioLogado = null;
        this.agregacionCorrecta = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("licencias", this.licencias);
        builder.append("buscadorContenido", this.buscadorContenido);
        builder.append("tipoVisualizacion", this.tipoVisualizacion);
        builder.append("size", this.size);
        builder.append("learningResourceType", this.learningResourceType);
        builder.append("annotation", this.annotation);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        builder.append("formato", this.formato);
        builder.append("agregarFederado", this.agregarFederado);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("numVecesDescargado", this.numVecesDescargado);
        builder.append("mostrarVuelta", this.mostrarVuelta);
        builder.append("pagina", this.pagina);
        builder.append("identificadorODE", this.identificadorODE);
        builder.append("idiomaODE", this.idiomaODE);
        builder.append("seleccionarSecuencia", this.seleccionarSecuencia);
        builder.append("diaPublicacion", this.diaPublicacion);
        builder.append("recurso", this.recurso);
        builder.append("contexto", this.contexto);
        builder.append("destinatarios", this.destinatarios);
        builder.append("autor", this.autor);
        builder.append("nrComentarios", this.nrComentarios);
        builder.append("idioma", this.idioma);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        builder.append("existenEtiquetas", this.existenEtiquetas);
        builder.append("imagen", this.imagen);
        builder.append("fechaPublicacion", this.fechaPublicacion);
        builder.append("urlEntregar", this.urlEntregar);
        builder.append("numVecesPrevisualizado", this.numVecesPrevisualizado);
        builder.append("tipoBusquedaArbol", this.tipoBusquedaArbol);
        builder.append("etiquetas", this.etiquetas);
        builder.append("mesPublicacion", this.mesPublicacion);
        builder.append("resultados", this.resultados);
        builder.append("urlODE", this.urlODE);
        builder.append("idLocalizador", this.idLocalizador);
        builder.append("identificadorODEFederado", this.identificadorODEFederado);
        builder.append("posicionamientoAnterior", this.posicionamientoAnterior);
        builder.append("posicionamiento", this.posicionamiento);
        builder.append("tituloODE", this.tituloODE);
        builder.append("tipoAgregacion", this.tipoAgregacion);
        builder.append("areaCurricularBusqueda", this.areaCurricularBusqueda);
        builder.append("posicionamientoSiguiente", this.posicionamientoSiguiente);
        builder.append("numVecesVisto", this.numVecesVisto);
        builder.append("anyoPublicacion", this.anyoPublicacion);
        builder.append("tesauroBusqueda", this.tesauroBusqueda);
        builder.append("areaCurricular", this.areaCurricular);
        builder.append("valoracion", this.valoracion);
        builder.append("idODE", this.idODE);
        builder.append("edad", this.edad);
        builder.append("tamanio", this.tamanio);
        builder.append("nodoDestino", this.nodoDestino);
        builder.append("existeSesion", this.existeSesion);
        builder.append("c_s_secuencia", this.c_s_secuencia);
        builder.append("imagenAmpliada", this.imagenAmpliada);
        builder.append("numVecesEnviado", this.numVecesEnviado);
        builder.append("nodoOrigen", this.nodoOrigen);
        builder.append("busquedaSimpleAvanzada", this.busquedaSimpleAvanzada);
        builder.append("descripcion", this.descripcion);
        builder.append("ambito", this.ambito);
        builder.append("procesoCognitivo", this.procesoCognitivo);
        builder.append("usuarioLogado", this.usuarioLogado);
        builder.append("titulo", this.titulo);
        builder.append("localizadorODE", this.localizadorODE);
        builder.append("agregacionCorrecta", this.agregacionCorrecta);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.licencias = null;
        this.licenciasValueList = null;
        this.licenciasLabelList = null;
        this.size = null;
        this.sizeValueList = null;
        this.sizeLabelList = null;
        this.learningResourceType = null;
        this.learningResourceTypeValueList = null;
        this.learningResourceTypeLabelList = null;
        this.annotation = null;
        this.annotationValueList = null;
        this.annotationLabelList = null;
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
        this.agregarFederado = null;
        this.agregarFederadoValueList = null;
        this.agregarFederadoLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.numVecesDescargado = null;
        this.numVecesDescargadoValueList = null;
        this.numVecesDescargadoLabelList = null;
        this.mostrarVuelta = null;
        this.mostrarVueltaValueList = null;
        this.mostrarVueltaLabelList = null;
        this.pagina = null;
        this.paginaValueList = null;
        this.paginaLabelList = null;
        this.identificadorODE = null;
        this.identificadorODEValueList = null;
        this.identificadorODELabelList = null;
        this.idiomaODE = null;
        this.idiomaODEValueList = null;
        this.idiomaODELabelList = null;
        this.seleccionarSecuencia = null;
        this.seleccionarSecuenciaValueList = null;
        this.seleccionarSecuenciaLabelList = null;
        this.diaPublicacion = null;
        this.diaPublicacionValueList = null;
        this.diaPublicacionLabelList = null;
        this.recurso = null;
        this.recursoValueList = null;
        this.recursoLabelList = null;
        this.contexto = null;
        this.contextoValueList = null;
        this.contextoLabelList = null;
        this.destinatarios = null;
        this.destinatariosValueList = null;
        this.destinatariosLabelList = null;
        this.autor = null;
        this.autorValueList = null;
        this.autorLabelList = null;
        this.nrComentarios = null;
        this.nrComentariosValueList = null;
        this.nrComentariosLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
        this.existenEtiquetas = null;
        this.existenEtiquetasValueList = null;
        this.existenEtiquetasLabelList = null;
        this.imagen = null;
        this.imagenValueList = null;
        this.imagenLabelList = null;
        this.fechaPublicacion = null;
        this.fechaPublicacionValueList = null;
        this.fechaPublicacionLabelList = null;
        this.urlEntregar = null;
        this.urlEntregarValueList = null;
        this.urlEntregarLabelList = null;
        this.numVecesPrevisualizado = null;
        this.numVecesPrevisualizadoValueList = null;
        this.numVecesPrevisualizadoLabelList = null;
        this.tipoBusquedaArbol = null;
        this.tipoBusquedaArbolValueList = null;
        this.tipoBusquedaArbolLabelList = null;
        this.etiquetas = null;
        this.etiquetasValueList = null;
        this.etiquetasLabelList = null;
        this.mesPublicacion = null;
        this.mesPublicacionValueList = null;
        this.mesPublicacionLabelList = null;
        this.resultados = null;
        this.resultadosValueList = null;
        this.resultadosLabelList = null;
        this.urlODE = null;
        this.urlODEValueList = null;
        this.urlODELabelList = null;
        this.idLocalizador = null;
        this.idLocalizadorValueList = null;
        this.idLocalizadorLabelList = null;
        this.identificadorODEFederado = null;
        this.identificadorODEFederadoValueList = null;
        this.identificadorODEFederadoLabelList = null;
        this.posicionamientoAnterior = null;
        this.posicionamientoAnteriorValueList = null;
        this.posicionamientoAnteriorLabelList = null;
        this.posicionamiento = null;
        this.posicionamientoValueList = null;
        this.posicionamientoLabelList = null;
        this.tituloODE = null;
        this.tituloODEValueList = null;
        this.tituloODELabelList = null;
        this.tipoAgregacion = null;
        this.tipoAgregacionValueList = null;
        this.tipoAgregacionLabelList = null;
        this.areaCurricularBusqueda = null;
        this.areaCurricularBusquedaValueList = null;
        this.areaCurricularBusquedaLabelList = null;
        this.posicionamientoSiguiente = null;
        this.posicionamientoSiguienteValueList = null;
        this.posicionamientoSiguienteLabelList = null;
        this.numVecesVisto = null;
        this.numVecesVistoValueList = null;
        this.numVecesVistoLabelList = null;
        this.anyoPublicacion = null;
        this.anyoPublicacionValueList = null;
        this.anyoPublicacionLabelList = null;
        this.tesauroBusqueda = null;
        this.tesauroBusquedaValueList = null;
        this.tesauroBusquedaLabelList = null;
        this.areaCurricular = null;
        this.areaCurricularValueList = null;
        this.areaCurricularLabelList = null;
        this.valoracion = null;
        this.valoracionValueList = null;
        this.valoracionLabelList = null;
        this.idODE = null;
        this.idODEValueList = null;
        this.idODELabelList = null;
        this.edad = null;
        this.edadValueList = null;
        this.edadLabelList = null;
        this.tamanio = null;
        this.tamanioValueList = null;
        this.tamanioLabelList = null;
        this.nodoDestino = null;
        this.nodoDestinoValueList = null;
        this.nodoDestinoLabelList = null;
        this.existeSesion = null;
        this.existeSesionValueList = null;
        this.existeSesionLabelList = null;
        this.c_s_secuencia = null;
        this.c_s_secuenciaValueList = null;
        this.c_s_secuenciaLabelList = null;
        this.imagenAmpliada = null;
        this.imagenAmpliadaValueList = null;
        this.imagenAmpliadaLabelList = null;
        this.numVecesEnviado = null;
        this.numVecesEnviadoValueList = null;
        this.numVecesEnviadoLabelList = null;
        this.nodoOrigen = null;
        this.nodoOrigenValueList = null;
        this.nodoOrigenLabelList = null;
        this.busquedaSimpleAvanzada = null;
        this.busquedaSimpleAvanzadaValueList = null;
        this.busquedaSimpleAvanzadaLabelList = null;
        this.descripcion = null;
        this.descripcionValueList = null;
        this.descripcionLabelList = null;
        this.ambito = null;
        this.ambitoValueList = null;
        this.ambitoLabelList = null;
        this.procesoCognitivo = null;
        this.procesoCognitivoValueList = null;
        this.procesoCognitivoLabelList = null;
        this.usuarioLogado = null;
        this.usuarioLogadoValueList = null;
        this.usuarioLogadoLabelList = null;
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.localizadorODE = null;
        this.localizadorODEValueList = null;
        this.localizadorODELabelList = null;
        this.agregacionCorrecta = null;
        this.agregacionCorrectaValueList = null;
        this.agregacionCorrectaLabelList = null;
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
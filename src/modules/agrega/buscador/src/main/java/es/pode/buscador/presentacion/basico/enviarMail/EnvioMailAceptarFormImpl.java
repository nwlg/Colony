// license-header java merge-point
package es.pode.buscador.presentacion.basico.enviarMail;

public class EnvioMailAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.buscador.presentacion.basico.enviarMail.PrepararEnvioForm
        , es.pode.buscador.presentacion.basico.enviarMail.EnviarMailForm
        , es.pode.buscador.presentacion.basico.enviarMail.AnalizaValidacionForm
{
    private java.lang.String urlODE;
    private java.lang.Object[] urlODEValueList;
    private java.lang.Object[] urlODELabelList;
    private java.lang.String urlImagen;
    private java.lang.Object[] urlImagenValueList;
    private java.lang.Object[] urlImagenLabelList;
    private java.lang.Boolean enviarRemitente;
    private java.lang.Object[] enviarRemitenteValueList;
    private java.lang.Object[] enviarRemitenteLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.lang.String tipoLayoutBuscador;
    private java.lang.Object[] tipoLayoutBuscadorValueList;
    private java.lang.Object[] tipoLayoutBuscadorLabelList;
    private java.lang.String correosHasta;
    private java.lang.Object[] correosHastaValueList;
    private java.lang.Object[] correosHastaLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.String resumen;
    private java.lang.Object[] resumenValueList;
    private java.lang.Object[] resumenLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private java.lang.String nombresHasta;
    private java.lang.Object[] nombresHastaValueList;
    private java.lang.Object[] nombresHastaLabelList;
    private java.lang.String correoDesde;
    private java.lang.Object[] correoDesdeValueList;
    private java.lang.Object[] correoDesdeLabelList;
    private java.lang.String titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.lang.Boolean mostrarVuelta;
    private java.lang.Object[] mostrarVueltaValueList;
    private java.lang.Object[] mostrarVueltaLabelList;
    private java.lang.String nombreDesde;
    private java.lang.Object[] nombreDesdeValueList;
    private java.lang.Object[] nombreDesdeLabelList;
    private java.lang.String resultadoValidacion;
    private java.lang.Object[] resultadoValidacionValueList;
    private java.lang.Object[] resultadoValidacionLabelList;
    private java.lang.String identificadorODE;
    private java.lang.Object[] identificadorODEValueList;
    private java.lang.Object[] identificadorODELabelList;

    public EnvioMailAceptarFormImpl()
    {
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
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setUrlODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setUrlODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>urlImagen</code>.
     */
    public void resetUrlImagen()
    {
        this.urlImagen = null;
    }

    public void setUrlImagen(java.lang.String urlImagen)
    {
        this.urlImagen = urlImagen;
    }

    /**
     * 
     */
    public java.lang.String getUrlImagen()
    {
        return this.urlImagen;
    }
    
    public java.lang.Object[] getUrlImagenBackingList()
    {
        java.lang.Object[] values = this.urlImagenValueList;
        java.lang.Object[] labels = this.urlImagenLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getUrlImagenValueList()
    {
        return this.urlImagenValueList;
    }

    public void setUrlImagenValueList(java.lang.Object[] urlImagenValueList)
    {
        this.urlImagenValueList = urlImagenValueList;
    }

    public java.lang.Object[] getUrlImagenLabelList()
    {
        return this.urlImagenLabelList;
    }

    public void setUrlImagenLabelList(java.lang.Object[] urlImagenLabelList)
    {
        this.urlImagenLabelList = urlImagenLabelList;
    }

    public void setUrlImagenBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setUrlImagenBackingList requires non-null property arguments");
        }

        this.urlImagenValueList = null;
        this.urlImagenLabelList = null;

        if (items != null)
        {
            this.urlImagenValueList = new java.lang.Object[items.size()];
            this.urlImagenLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.urlImagenValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.urlImagenLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setUrlImagenBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>enviarRemitente</code>.
     */
    public void resetEnviarRemitente()
    {
        this.enviarRemitente = null;
    }

    public void setEnviarRemitente(java.lang.Boolean enviarRemitente)
    {
        this.enviarRemitente = enviarRemitente;
    }

    /**
     * 
     */
    public java.lang.Boolean getEnviarRemitente()
    {
        return this.enviarRemitente;
    }
    
    public java.lang.Object[] getEnviarRemitenteBackingList()
    {
        java.lang.Object[] values = this.enviarRemitenteValueList;
        java.lang.Object[] labels = this.enviarRemitenteLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getEnviarRemitenteValueList()
    {
        return this.enviarRemitenteValueList;
    }

    public void setEnviarRemitenteValueList(java.lang.Object[] enviarRemitenteValueList)
    {
        this.enviarRemitenteValueList = enviarRemitenteValueList;
    }

    public java.lang.Object[] getEnviarRemitenteLabelList()
    {
        return this.enviarRemitenteLabelList;
    }

    public void setEnviarRemitenteLabelList(java.lang.Object[] enviarRemitenteLabelList)
    {
        this.enviarRemitenteLabelList = enviarRemitenteLabelList;
    }

    public void setEnviarRemitenteBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setEnviarRemitenteBackingList requires non-null property arguments");
        }

        this.enviarRemitenteValueList = null;
        this.enviarRemitenteLabelList = null;

        if (items != null)
        {
            this.enviarRemitenteValueList = new java.lang.Object[items.size()];
            this.enviarRemitenteLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.enviarRemitenteValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.enviarRemitenteLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setEnviarRemitenteBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setIdiomaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>correosHasta</code>.
     */
    public void resetCorreosHasta()
    {
        this.correosHasta = null;
    }

    public void setCorreosHasta(java.lang.String correosHasta)
    {
        this.correosHasta = correosHasta;
    }

    /**
     * 
     */
    public java.lang.String getCorreosHasta()
    {
        return this.correosHasta;
    }
    
    public java.lang.Object[] getCorreosHastaBackingList()
    {
        java.lang.Object[] values = this.correosHastaValueList;
        java.lang.Object[] labels = this.correosHastaLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getCorreosHastaValueList()
    {
        return this.correosHastaValueList;
    }

    public void setCorreosHastaValueList(java.lang.Object[] correosHastaValueList)
    {
        this.correosHastaValueList = correosHastaValueList;
    }

    public java.lang.Object[] getCorreosHastaLabelList()
    {
        return this.correosHastaLabelList;
    }

    public void setCorreosHastaLabelList(java.lang.Object[] correosHastaLabelList)
    {
        this.correosHastaLabelList = correosHastaLabelList;
    }

    public void setCorreosHastaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setCorreosHastaBackingList requires non-null property arguments");
        }

        this.correosHastaValueList = null;
        this.correosHastaLabelList = null;

        if (items != null)
        {
            this.correosHastaValueList = new java.lang.Object[items.size()];
            this.correosHastaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.correosHastaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.correosHastaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setCorreosHastaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>resumen</code>.
     */
    public void resetResumen()
    {
        this.resumen = null;
    }

    public void setResumen(java.lang.String resumen)
    {
        this.resumen = resumen;
    }

    /**
     * 
     */
    public java.lang.String getResumen()
    {
        return this.resumen;
    }
    
    public java.lang.Object[] getResumenBackingList()
    {
        java.lang.Object[] values = this.resumenValueList;
        java.lang.Object[] labels = this.resumenLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getResumenValueList()
    {
        return this.resumenValueList;
    }

    public void setResumenValueList(java.lang.Object[] resumenValueList)
    {
        this.resumenValueList = resumenValueList;
    }

    public java.lang.Object[] getResumenLabelList()
    {
        return this.resumenLabelList;
    }

    public void setResumenLabelList(java.lang.Object[] resumenLabelList)
    {
        this.resumenLabelList = resumenLabelList;
    }

    public void setResumenBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setResumenBackingList requires non-null property arguments");
        }

        this.resumenValueList = null;
        this.resumenLabelList = null;

        if (items != null)
        {
            this.resumenValueList = new java.lang.Object[items.size()];
            this.resumenLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resumenValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resumenLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setResumenBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nombresHasta</code>.
     */
    public void resetNombresHasta()
    {
        this.nombresHasta = null;
    }

    public void setNombresHasta(java.lang.String nombresHasta)
    {
        this.nombresHasta = nombresHasta;
    }

    /**
     * 
     */
    public java.lang.String getNombresHasta()
    {
        return this.nombresHasta;
    }
    
    public java.lang.Object[] getNombresHastaBackingList()
    {
        java.lang.Object[] values = this.nombresHastaValueList;
        java.lang.Object[] labels = this.nombresHastaLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getNombresHastaValueList()
    {
        return this.nombresHastaValueList;
    }

    public void setNombresHastaValueList(java.lang.Object[] nombresHastaValueList)
    {
        this.nombresHastaValueList = nombresHastaValueList;
    }

    public java.lang.Object[] getNombresHastaLabelList()
    {
        return this.nombresHastaLabelList;
    }

    public void setNombresHastaLabelList(java.lang.Object[] nombresHastaLabelList)
    {
        this.nombresHastaLabelList = nombresHastaLabelList;
    }

    public void setNombresHastaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setNombresHastaBackingList requires non-null property arguments");
        }

        this.nombresHastaValueList = null;
        this.nombresHastaLabelList = null;

        if (items != null)
        {
            this.nombresHastaValueList = new java.lang.Object[items.size()];
            this.nombresHastaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nombresHastaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nombresHastaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setNombresHastaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>correoDesde</code>.
     */
    public void resetCorreoDesde()
    {
        this.correoDesde = null;
    }

    public void setCorreoDesde(java.lang.String correoDesde)
    {
        this.correoDesde = correoDesde;
    }

    /**
     * 
     */
    public java.lang.String getCorreoDesde()
    {
        return this.correoDesde;
    }
    
    public java.lang.Object[] getCorreoDesdeBackingList()
    {
        java.lang.Object[] values = this.correoDesdeValueList;
        java.lang.Object[] labels = this.correoDesdeLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getCorreoDesdeValueList()
    {
        return this.correoDesdeValueList;
    }

    public void setCorreoDesdeValueList(java.lang.Object[] correoDesdeValueList)
    {
        this.correoDesdeValueList = correoDesdeValueList;
    }

    public java.lang.Object[] getCorreoDesdeLabelList()
    {
        return this.correoDesdeLabelList;
    }

    public void setCorreoDesdeLabelList(java.lang.Object[] correoDesdeLabelList)
    {
        this.correoDesdeLabelList = correoDesdeLabelList;
    }

    public void setCorreoDesdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setCorreoDesdeBackingList requires non-null property arguments");
        }

        this.correoDesdeValueList = null;
        this.correoDesdeLabelList = null;

        if (items != null)
        {
            this.correoDesdeValueList = new java.lang.Object[items.size()];
            this.correoDesdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.correoDesdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.correoDesdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setCorreoDesdeBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setTituloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setTituloBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setMostrarVueltaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setMostrarVueltaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nombreDesde</code>.
     */
    public void resetNombreDesde()
    {
        this.nombreDesde = null;
    }

    public void setNombreDesde(java.lang.String nombreDesde)
    {
        this.nombreDesde = nombreDesde;
    }

    /**
     * 
     */
    public java.lang.String getNombreDesde()
    {
        return this.nombreDesde;
    }
    
    public java.lang.Object[] getNombreDesdeBackingList()
    {
        java.lang.Object[] values = this.nombreDesdeValueList;
        java.lang.Object[] labels = this.nombreDesdeLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getNombreDesdeValueList()
    {
        return this.nombreDesdeValueList;
    }

    public void setNombreDesdeValueList(java.lang.Object[] nombreDesdeValueList)
    {
        this.nombreDesdeValueList = nombreDesdeValueList;
    }

    public java.lang.Object[] getNombreDesdeLabelList()
    {
        return this.nombreDesdeLabelList;
    }

    public void setNombreDesdeLabelList(java.lang.Object[] nombreDesdeLabelList)
    {
        this.nombreDesdeLabelList = nombreDesdeLabelList;
    }

    public void setNombreDesdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setNombreDesdeBackingList requires non-null property arguments");
        }

        this.nombreDesdeValueList = null;
        this.nombreDesdeLabelList = null;

        if (items != null)
        {
            this.nombreDesdeValueList = new java.lang.Object[items.size()];
            this.nombreDesdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nombreDesdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nombreDesdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setNombreDesdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>resultadoValidacion</code>.
     */
    public void resetResultadoValidacion()
    {
        this.resultadoValidacion = null;
    }

    public void setResultadoValidacion(java.lang.String resultadoValidacion)
    {
        this.resultadoValidacion = resultadoValidacion;
    }

    /**
     * 
     */
    public java.lang.String getResultadoValidacion()
    {
        return this.resultadoValidacion;
    }
    
    public java.lang.Object[] getResultadoValidacionBackingList()
    {
        java.lang.Object[] values = this.resultadoValidacionValueList;
        java.lang.Object[] labels = this.resultadoValidacionLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getResultadoValidacionValueList()
    {
        return this.resultadoValidacionValueList;
    }

    public void setResultadoValidacionValueList(java.lang.Object[] resultadoValidacionValueList)
    {
        this.resultadoValidacionValueList = resultadoValidacionValueList;
    }

    public java.lang.Object[] getResultadoValidacionLabelList()
    {
        return this.resultadoValidacionLabelList;
    }

    public void setResultadoValidacionLabelList(java.lang.Object[] resultadoValidacionLabelList)
    {
        this.resultadoValidacionLabelList = resultadoValidacionLabelList;
    }

    public void setResultadoValidacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setResultadoValidacionBackingList requires non-null property arguments");
        }

        this.resultadoValidacionValueList = null;
        this.resultadoValidacionLabelList = null;

        if (items != null)
        {
            this.resultadoValidacionValueList = new java.lang.Object[items.size()];
            this.resultadoValidacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resultadoValidacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resultadoValidacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setResultadoValidacionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("EnvioMailAceptarFormImpl.setIdentificadorODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("EnvioMailAceptarFormImpl.setIdentificadorODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.enviarRemitente = null;
        this.idiomaBuscador = null;
        this.mostrarVuelta = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("urlODE", this.urlODE);
        builder.append("urlImagen", this.urlImagen);
        builder.append("enviarRemitente", this.enviarRemitente);
        builder.append("idioma", this.idioma);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        builder.append("correosHasta", this.correosHasta);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("resumen", this.resumen);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        builder.append("nombresHasta", this.nombresHasta);
        builder.append("correoDesde", this.correoDesde);
        builder.append("titulo", this.titulo);
        builder.append("mostrarVuelta", this.mostrarVuelta);
        builder.append("nombreDesde", this.nombreDesde);
        builder.append("resultadoValidacion", this.resultadoValidacion);
        builder.append("identificadorODE", this.identificadorODE);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.urlODE = null;
        this.urlODEValueList = null;
        this.urlODELabelList = null;
        this.urlImagen = null;
        this.urlImagenValueList = null;
        this.urlImagenLabelList = null;
        this.enviarRemitente = null;
        this.enviarRemitenteValueList = null;
        this.enviarRemitenteLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.tipoLayoutBuscador = null;
        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;
        this.correosHasta = null;
        this.correosHastaValueList = null;
        this.correosHastaLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.resumen = null;
        this.resumenValueList = null;
        this.resumenLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
        this.nombresHasta = null;
        this.nombresHastaValueList = null;
        this.nombresHastaLabelList = null;
        this.correoDesde = null;
        this.correoDesdeValueList = null;
        this.correoDesdeLabelList = null;
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.mostrarVuelta = null;
        this.mostrarVueltaValueList = null;
        this.mostrarVueltaLabelList = null;
        this.nombreDesde = null;
        this.nombreDesdeValueList = null;
        this.nombreDesdeLabelList = null;
        this.resultadoValidacion = null;
        this.resultadoValidacionValueList = null;
        this.resultadoValidacionLabelList = null;
        this.identificadorODE = null;
        this.identificadorODEValueList = null;
        this.identificadorODELabelList = null;
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
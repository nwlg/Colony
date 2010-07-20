// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar;

public class PublicarCUFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.CargaFormularioPublicarForm
{
    private java.lang.String tipoLicencia;
    private java.lang.Object[] tipoLicenciaValueList;
    private java.lang.Object[] tipoLicenciaLabelList;
    private java.lang.String titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.lang.String idUsuario;
    private java.lang.Object[] idUsuarioValueList;
    private java.lang.Object[] idUsuarioLabelList;
    private java.lang.String comunidadesSeleccionadas;
    private java.lang.Object[] comunidadesSeleccionadasValueList;
    private java.lang.Object[] comunidadesSeleccionadasLabelList;
    private java.lang.String[] comunidadesMostrar;
    private java.lang.Object[] comunidadesMostrarValueList;
    private java.lang.Object[] comunidadesMostrarLabelList;
    private java.lang.String comentarios;
    private java.lang.Object[] comentariosValueList;
    private java.lang.Object[] comentariosLabelList;
    private java.lang.String idODE;
    private java.lang.Object[] idODEValueList;
    private java.lang.Object[] idODELabelList;
    private java.lang.String universal;
    private java.lang.Object[] universalValueList;
    private java.lang.Object[] universalLabelList;
    private java.lang.String tipoLicenciaSeleccionada;
    private java.lang.Object[] tipoLicenciaSeleccionadaValueList;
    private java.lang.Object[] tipoLicenciaSeleccionadaLabelList;
    private java.lang.String comunidades;
    private java.lang.Object[] comunidadesValueList;
    private java.lang.Object[] comunidadesLabelList;
    private java.lang.Boolean esDespublicado;
    private java.lang.Object[] esDespublicadoValueList;
    private java.lang.Object[] esDespublicadoLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;

    public PublicarCUFormImpl()
    {
    }

    /**
     * Resets the given <code>tipoLicencia</code>.
     */
    public void resetTipoLicencia()
    {
        this.tipoLicencia = null;
    }

    public void setTipoLicencia(java.lang.String tipoLicencia)
    {
        this.tipoLicencia = tipoLicencia;
    }

    /**
     * 
     */
    public java.lang.String getTipoLicencia()
    {
        return this.tipoLicencia;
    }
    
    public java.lang.Object[] getTipoLicenciaBackingList()
    {
        java.lang.Object[] values = this.tipoLicenciaValueList;
        java.lang.Object[] labels = this.tipoLicenciaLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getTipoLicenciaValueList()
    {
        return this.tipoLicenciaValueList;
    }

    public void setTipoLicenciaValueList(java.lang.Object[] tipoLicenciaValueList)
    {
        this.tipoLicenciaValueList = tipoLicenciaValueList;
    }

    public java.lang.Object[] getTipoLicenciaLabelList()
    {
        return this.tipoLicenciaLabelList;
    }

    public void setTipoLicenciaLabelList(java.lang.Object[] tipoLicenciaLabelList)
    {
        this.tipoLicenciaLabelList = tipoLicenciaLabelList;
    }

    public void setTipoLicenciaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarCUFormImpl.setTipoLicenciaBackingList requires non-null property arguments");
        }

        this.tipoLicenciaValueList = null;
        this.tipoLicenciaLabelList = null;

        if (items != null)
        {
            this.tipoLicenciaValueList = new java.lang.Object[items.size()];
            this.tipoLicenciaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoLicenciaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoLicenciaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarCUFormImpl.setTipoLicenciaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("PublicarCUFormImpl.setTituloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PublicarCUFormImpl.setTituloBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idUsuario</code>.
     */
    public void resetIdUsuario()
    {
        this.idUsuario = null;
    }

    public void setIdUsuario(java.lang.String idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    /**
     * 
     */
    public java.lang.String getIdUsuario()
    {
        return this.idUsuario;
    }
    
    public java.lang.Object[] getIdUsuarioBackingList()
    {
        java.lang.Object[] values = this.idUsuarioValueList;
        java.lang.Object[] labels = this.idUsuarioLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getIdUsuarioValueList()
    {
        return this.idUsuarioValueList;
    }

    public void setIdUsuarioValueList(java.lang.Object[] idUsuarioValueList)
    {
        this.idUsuarioValueList = idUsuarioValueList;
    }

    public java.lang.Object[] getIdUsuarioLabelList()
    {
        return this.idUsuarioLabelList;
    }

    public void setIdUsuarioLabelList(java.lang.Object[] idUsuarioLabelList)
    {
        this.idUsuarioLabelList = idUsuarioLabelList;
    }

    public void setIdUsuarioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarCUFormImpl.setIdUsuarioBackingList requires non-null property arguments");
        }

        this.idUsuarioValueList = null;
        this.idUsuarioLabelList = null;

        if (items != null)
        {
            this.idUsuarioValueList = new java.lang.Object[items.size()];
            this.idUsuarioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idUsuarioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idUsuarioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarCUFormImpl.setIdUsuarioBackingList encountered an exception", ex);
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

    public void setComunidadesSeleccionadas(java.lang.String comunidadesSeleccionadas)
    {
        this.comunidadesSeleccionadas = comunidadesSeleccionadas;
    }

    /**
     * 
     */
    public java.lang.String getComunidadesSeleccionadas()
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
            throw new IllegalArgumentException("PublicarCUFormImpl.setComunidadesSeleccionadasBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PublicarCUFormImpl.setComunidadesSeleccionadasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comunidadesMostrar</code>.
     */
    public void resetComunidadesMostrar()
    {
        this.comunidadesMostrar = null;
    }

    public void setComunidadesMostrar(java.lang.String[] comunidadesMostrar)
    {
        this.comunidadesMostrar = comunidadesMostrar;
    }

    /**
     * 
     */
    public java.lang.String[] getComunidadesMostrar()
    {
        return this.comunidadesMostrar;
    }
    
    public java.lang.Object[] getComunidadesMostrarBackingList()
    {
        java.lang.Object[] values = this.comunidadesMostrarValueList;
        java.lang.Object[] labels = this.comunidadesMostrarLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getComunidadesMostrarValueList()
    {
        return this.comunidadesMostrarValueList;
    }

    public void setComunidadesMostrarValueList(java.lang.Object[] comunidadesMostrarValueList)
    {
        this.comunidadesMostrarValueList = comunidadesMostrarValueList;
    }

    public java.lang.Object[] getComunidadesMostrarLabelList()
    {
        return this.comunidadesMostrarLabelList;
    }

    public void setComunidadesMostrarLabelList(java.lang.Object[] comunidadesMostrarLabelList)
    {
        this.comunidadesMostrarLabelList = comunidadesMostrarLabelList;
    }

    public void setComunidadesMostrarBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarCUFormImpl.setComunidadesMostrarBackingList requires non-null property arguments");
        }

        this.comunidadesMostrarValueList = null;
        this.comunidadesMostrarLabelList = null;

        if (items != null)
        {
            this.comunidadesMostrarValueList = new java.lang.Object[items.size()];
            this.comunidadesMostrarLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comunidadesMostrarValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comunidadesMostrarLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarCUFormImpl.setComunidadesMostrarBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comentarios</code>.
     */
    public void resetComentarios()
    {
        this.comentarios = null;
    }

    public void setComentarios(java.lang.String comentarios)
    {
        this.comentarios = comentarios;
    }

    /**
     * 
     */
    public java.lang.String getComentarios()
    {
        return this.comentarios;
    }
    
    public java.lang.Object[] getComentariosBackingList()
    {
        java.lang.Object[] values = this.comentariosValueList;
        java.lang.Object[] labels = this.comentariosLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getComentariosValueList()
    {
        return this.comentariosValueList;
    }

    public void setComentariosValueList(java.lang.Object[] comentariosValueList)
    {
        this.comentariosValueList = comentariosValueList;
    }

    public java.lang.Object[] getComentariosLabelList()
    {
        return this.comentariosLabelList;
    }

    public void setComentariosLabelList(java.lang.Object[] comentariosLabelList)
    {
        this.comentariosLabelList = comentariosLabelList;
    }

    public void setComentariosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarCUFormImpl.setComentariosBackingList requires non-null property arguments");
        }

        this.comentariosValueList = null;
        this.comentariosLabelList = null;

        if (items != null)
        {
            this.comentariosValueList = new java.lang.Object[items.size()];
            this.comentariosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comentariosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comentariosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarCUFormImpl.setComentariosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("PublicarCUFormImpl.setIdODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PublicarCUFormImpl.setIdODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>universal</code>.
     */
    public void resetUniversal()
    {
        this.universal = null;
    }

    public void setUniversal(java.lang.String universal)
    {
        this.universal = universal;
    }

    /**
     * 
     */
    public java.lang.String getUniversal()
    {
        return this.universal;
    }
    
    public java.lang.Object[] getUniversalBackingList()
    {
        java.lang.Object[] values = this.universalValueList;
        java.lang.Object[] labels = this.universalLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getUniversalValueList()
    {
        return this.universalValueList;
    }

    public void setUniversalValueList(java.lang.Object[] universalValueList)
    {
        this.universalValueList = universalValueList;
    }

    public java.lang.Object[] getUniversalLabelList()
    {
        return this.universalLabelList;
    }

    public void setUniversalLabelList(java.lang.Object[] universalLabelList)
    {
        this.universalLabelList = universalLabelList;
    }

    public void setUniversalBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarCUFormImpl.setUniversalBackingList requires non-null property arguments");
        }

        this.universalValueList = null;
        this.universalLabelList = null;

        if (items != null)
        {
            this.universalValueList = new java.lang.Object[items.size()];
            this.universalLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.universalValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.universalLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarCUFormImpl.setUniversalBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoLicenciaSeleccionada</code>.
     */
    public void resetTipoLicenciaSeleccionada()
    {
        this.tipoLicenciaSeleccionada = null;
    }

    public void setTipoLicenciaSeleccionada(java.lang.String tipoLicenciaSeleccionada)
    {
        this.tipoLicenciaSeleccionada = tipoLicenciaSeleccionada;
    }

    /**
     * 
     */
    public java.lang.String getTipoLicenciaSeleccionada()
    {
        return this.tipoLicenciaSeleccionada;
    }
    
    public java.lang.Object[] getTipoLicenciaSeleccionadaBackingList()
    {
        java.lang.Object[] values = this.tipoLicenciaSeleccionadaValueList;
        java.lang.Object[] labels = this.tipoLicenciaSeleccionadaLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getTipoLicenciaSeleccionadaValueList()
    {
        return this.tipoLicenciaSeleccionadaValueList;
    }

    public void setTipoLicenciaSeleccionadaValueList(java.lang.Object[] tipoLicenciaSeleccionadaValueList)
    {
        this.tipoLicenciaSeleccionadaValueList = tipoLicenciaSeleccionadaValueList;
    }

    public java.lang.Object[] getTipoLicenciaSeleccionadaLabelList()
    {
        return this.tipoLicenciaSeleccionadaLabelList;
    }

    public void setTipoLicenciaSeleccionadaLabelList(java.lang.Object[] tipoLicenciaSeleccionadaLabelList)
    {
        this.tipoLicenciaSeleccionadaLabelList = tipoLicenciaSeleccionadaLabelList;
    }

    public void setTipoLicenciaSeleccionadaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarCUFormImpl.setTipoLicenciaSeleccionadaBackingList requires non-null property arguments");
        }

        this.tipoLicenciaSeleccionadaValueList = null;
        this.tipoLicenciaSeleccionadaLabelList = null;

        if (items != null)
        {
            this.tipoLicenciaSeleccionadaValueList = new java.lang.Object[items.size()];
            this.tipoLicenciaSeleccionadaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoLicenciaSeleccionadaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoLicenciaSeleccionadaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarCUFormImpl.setTipoLicenciaSeleccionadaBackingList encountered an exception", ex);
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

    public void setComunidades(java.lang.String comunidades)
    {
        this.comunidades = comunidades;
    }

    /**
     * 
     */
    public java.lang.String getComunidades()
    {
        return this.comunidades;
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
            throw new IllegalArgumentException("PublicarCUFormImpl.setComunidadesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PublicarCUFormImpl.setComunidadesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>esDespublicado</code>.
     */
    public void resetEsDespublicado()
    {
        this.esDespublicado = null;
    }

    public void setEsDespublicado(java.lang.Boolean esDespublicado)
    {
        this.esDespublicado = esDespublicado;
    }

    /**
     * 
     */
    public java.lang.Boolean getEsDespublicado()
    {
        return this.esDespublicado;
    }
    
    public java.lang.Object[] getEsDespublicadoBackingList()
    {
        java.lang.Object[] values = this.esDespublicadoValueList;
        java.lang.Object[] labels = this.esDespublicadoLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getEsDespublicadoValueList()
    {
        return this.esDespublicadoValueList;
    }

    public void setEsDespublicadoValueList(java.lang.Object[] esDespublicadoValueList)
    {
        this.esDespublicadoValueList = esDespublicadoValueList;
    }

    public java.lang.Object[] getEsDespublicadoLabelList()
    {
        return this.esDespublicadoLabelList;
    }

    public void setEsDespublicadoLabelList(java.lang.Object[] esDespublicadoLabelList)
    {
        this.esDespublicadoLabelList = esDespublicadoLabelList;
    }

    public void setEsDespublicadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarCUFormImpl.setEsDespublicadoBackingList requires non-null property arguments");
        }

        this.esDespublicadoValueList = null;
        this.esDespublicadoLabelList = null;

        if (items != null)
        {
            this.esDespublicadoValueList = new java.lang.Object[items.size()];
            this.esDespublicadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.esDespublicadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.esDespublicadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarCUFormImpl.setEsDespublicadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("PublicarCUFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PublicarCUFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.comunidadesMostrar = null;
        this.esDespublicado = null;
        this.idiomaBuscador = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("tipoLicencia", this.tipoLicencia);
        builder.append("titulo", this.titulo);
        builder.append("idUsuario", this.idUsuario);
        builder.append("comunidadesSeleccionadas", this.comunidadesSeleccionadas);
        builder.append("comunidadesMostrar", this.comunidadesMostrar);
        builder.append("comentarios", this.comentarios);
        builder.append("idODE", this.idODE);
        builder.append("universal", this.universal);
        builder.append("tipoLicenciaSeleccionada", this.tipoLicenciaSeleccionada);
        builder.append("comunidades", this.comunidades);
        builder.append("esDespublicado", this.esDespublicado);
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
        this.tipoLicencia = null;
        this.tipoLicenciaValueList = null;
        this.tipoLicenciaLabelList = null;
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.idUsuario = null;
        this.idUsuarioValueList = null;
        this.idUsuarioLabelList = null;
        this.comunidadesSeleccionadas = null;
        this.comunidadesSeleccionadasValueList = null;
        this.comunidadesSeleccionadasLabelList = null;
        this.comunidadesMostrar = null;
        this.comunidadesMostrarValueList = null;
        this.comunidadesMostrarLabelList = null;
        this.comentarios = null;
        this.comentariosValueList = null;
        this.comentariosLabelList = null;
        this.idODE = null;
        this.idODEValueList = null;
        this.idODELabelList = null;
        this.universal = null;
        this.universalValueList = null;
        this.universalLabelList = null;
        this.tipoLicenciaSeleccionada = null;
        this.tipoLicenciaSeleccionadaValueList = null;
        this.tipoLicenciaSeleccionadaLabelList = null;
        this.comunidades = null;
        this.comunidadesValueList = null;
        this.comunidadesLabelList = null;
        this.esDespublicado = null;
        this.esDespublicadoValueList = null;
        this.esDespublicadoLabelList = null;
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
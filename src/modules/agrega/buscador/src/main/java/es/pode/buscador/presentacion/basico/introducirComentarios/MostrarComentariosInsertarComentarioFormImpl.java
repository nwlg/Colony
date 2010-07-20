// license-header java merge-point
package es.pode.buscador.presentacion.basico.introducirComentarios;

public class MostrarComentariosInsertarComentarioFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.buscador.presentacion.basico.introducirComentarios.InsertarComentarioODEForm
        , es.pode.buscador.presentacion.basico.introducirComentarios.RecuperarComentariosODEForm
{
    private java.lang.String urlODE;
    private java.lang.Object[] urlODEValueList;
    private java.lang.Object[] urlODELabelList;
    private java.lang.Boolean conInaprop;
    private java.lang.Object[] conInapropValueList;
    private java.lang.Object[] conInapropLabelList;
    private java.lang.String busquedaSimpleAvanzada;
    private java.lang.Object[] busquedaSimpleAvanzadaValueList;
    private java.lang.Object[] busquedaSimpleAvanzadaLabelList;
    private java.util.Collection comentarios = null;
    private java.lang.Object[] comentariosValueList;
    private java.lang.Object[] comentariosLabelList;
    private java.lang.String tituloODE;
    private java.lang.Object[] tituloODEValueList;
    private java.lang.Object[] tituloODELabelList;
    private java.lang.String tipoLayoutBuscador;
    private java.lang.Object[] tipoLayoutBuscadorValueList;
    private java.lang.Object[] tipoLayoutBuscadorLabelList;
    private java.lang.String comentario;
    private java.lang.Object[] comentarioValueList;
    private java.lang.Object[] comentarioLabelList;
    private java.util.List idRowSelection = null;
    private java.lang.Object[] idValueList;
    private java.lang.Object[] idLabelList;
    private java.lang.Boolean usuarioAdministrador;
    private java.lang.Object[] usuarioAdministradorValueList;
    private java.lang.Object[] usuarioAdministradorLabelList;
    private java.lang.String titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.lang.String imagen;
    private java.lang.Object[] imagenValueList;
    private java.lang.Object[] imagenLabelList;
    private java.lang.Boolean mostrarVuelta;
    private java.lang.Object[] mostrarVueltaValueList;
    private java.lang.Object[] mostrarVueltaLabelList;
    private java.lang.String valoracion;
    private java.lang.Object[] valoracionValueList;
    private java.lang.Object[] valoracionLabelList;
    private java.lang.String idODE;
    private java.lang.Object[] idODEValueList;
    private java.lang.Object[] idODELabelList;
    private java.lang.Boolean listaVacia;
    private java.lang.Object[] listaVaciaValueList;
    private java.lang.Object[] listaVaciaLabelList;
    private java.lang.String idiomaODE;
    private java.lang.Object[] idiomaODEValueList;
    private java.lang.Object[] idiomaODELabelList;

    public MostrarComentariosInsertarComentarioFormImpl()
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
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setUrlODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setUrlODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>conInaprop</code>.
     */
    public void resetConInaprop()
    {
        this.conInaprop = null;
    }

    public void setConInaprop(java.lang.Boolean conInaprop)
    {
        this.conInaprop = conInaprop;
    }

    /**
     * 
     */
    public java.lang.Boolean getConInaprop()
    {
        return this.conInaprop;
    }
    
    public java.lang.Object[] getConInapropBackingList()
    {
        java.lang.Object[] values = this.conInapropValueList;
        java.lang.Object[] labels = this.conInapropLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getConInapropValueList()
    {
        return this.conInapropValueList;
    }

    public void setConInapropValueList(java.lang.Object[] conInapropValueList)
    {
        this.conInapropValueList = conInapropValueList;
    }

    public java.lang.Object[] getConInapropLabelList()
    {
        return this.conInapropLabelList;
    }

    public void setConInapropLabelList(java.lang.Object[] conInapropLabelList)
    {
        this.conInapropLabelList = conInapropLabelList;
    }

    public void setConInapropBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setConInapropBackingList requires non-null property arguments");
        }

        this.conInapropValueList = null;
        this.conInapropLabelList = null;

        if (items != null)
        {
            this.conInapropValueList = new java.lang.Object[items.size()];
            this.conInapropLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.conInapropValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.conInapropLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setConInapropBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setBusquedaSimpleAvanzadaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setBusquedaSimpleAvanzadaBackingList encountered an exception", ex);
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

    public void setComentarios(java.util.Collection comentarios)
    {
        this.comentarios = comentarios;
    }

    /**
     * 
     */
    public java.util.Collection getComentarios()
    {
        return this.comentarios;
    }

    public void setComentariosAsArray(Object[] comentarios)
    {
        this.comentarios = (comentarios == null) ? null : java.util.Arrays.asList(comentarios);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.buscador.presentacion.basico.introducirComentarios.MostrarComentariosInsertarComentarioFormImpl#getComentarios
     */
    public java.lang.Object[] getComentariosAsArray()
    {
        return (comentarios == null) ? null : comentarios.toArray();
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
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setComentariosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setComentariosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setTituloODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setTituloODEBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comentario</code>.
     */
    public void resetComentario()
    {
        this.comentario = null;
    }

    public void setComentario(java.lang.String comentario)
    {
        this.comentario = comentario;
    }

    /**
     * 
     */
    public java.lang.String getComentario()
    {
        return this.comentario;
    }
    
    public java.lang.Object[] getComentarioBackingList()
    {
        java.lang.Object[] values = this.comentarioValueList;
        java.lang.Object[] labels = this.comentarioLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getComentarioValueList()
    {
        return this.comentarioValueList;
    }

    public void setComentarioValueList(java.lang.Object[] comentarioValueList)
    {
        this.comentarioValueList = comentarioValueList;
    }

    public java.lang.Object[] getComentarioLabelList()
    {
        return this.comentarioLabelList;
    }

    public void setComentarioLabelList(java.lang.Object[] comentarioLabelList)
    {
        this.comentarioLabelList = comentarioLabelList;
    }

    public void setComentarioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setComentarioBackingList requires non-null property arguments");
        }

        this.comentarioValueList = null;
        this.comentarioLabelList = null;

        if (items != null)
        {
            this.comentarioValueList = new java.lang.Object[items.size()];
            this.comentarioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comentarioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comentarioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setComentarioBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setIdBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setIdBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setUsuarioAdministradorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setUsuarioAdministradorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setTituloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setTituloBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setImagenBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setImagenBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setMostrarVueltaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setMostrarVueltaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setValoracionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setValoracionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setIdODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setIdODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listaVacia</code>.
     */
    public void resetListaVacia()
    {
        this.listaVacia = null;
    }

    public void setListaVacia(java.lang.Boolean listaVacia)
    {
        this.listaVacia = listaVacia;
    }

    /**
     * 
     */
    public java.lang.Boolean getListaVacia()
    {
        return this.listaVacia;
    }
    
    public java.lang.Object[] getListaVaciaBackingList()
    {
        java.lang.Object[] values = this.listaVaciaValueList;
        java.lang.Object[] labels = this.listaVaciaLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getListaVaciaValueList()
    {
        return this.listaVaciaValueList;
    }

    public void setListaVaciaValueList(java.lang.Object[] listaVaciaValueList)
    {
        this.listaVaciaValueList = listaVaciaValueList;
    }

    public java.lang.Object[] getListaVaciaLabelList()
    {
        return this.listaVaciaLabelList;
    }

    public void setListaVaciaLabelList(java.lang.Object[] listaVaciaLabelList)
    {
        this.listaVaciaLabelList = listaVaciaLabelList;
    }

    public void setListaVaciaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setListaVaciaBackingList requires non-null property arguments");
        }

        this.listaVaciaValueList = null;
        this.listaVaciaLabelList = null;

        if (items != null)
        {
            this.listaVaciaValueList = new java.lang.Object[items.size()];
            this.listaVaciaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listaVaciaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listaVaciaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setListaVaciaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarComentariosInsertarComentarioFormImpl.setIdiomaODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarComentariosInsertarComentarioFormImpl.setIdiomaODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.conInaprop = null;
        this.idRowSelection = null;
        this.usuarioAdministrador = null;
        this.mostrarVuelta = null;
        this.valoracion = null;
        this.listaVacia = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("urlODE", this.urlODE);
        builder.append("conInaprop", this.conInaprop);
        builder.append("busquedaSimpleAvanzada", this.busquedaSimpleAvanzada);
        builder.append("comentarios", this.comentarios);
        builder.append("tituloODE", this.tituloODE);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        builder.append("comentario", this.comentario);
        builder.append("idRowSelection", this.idRowSelection);
        builder.append("usuarioAdministrador", this.usuarioAdministrador);
        builder.append("titulo", this.titulo);
        builder.append("imagen", this.imagen);
        builder.append("mostrarVuelta", this.mostrarVuelta);
        builder.append("valoracion", this.valoracion);
        builder.append("idODE", this.idODE);
        builder.append("listaVacia", this.listaVacia);
        builder.append("idiomaODE", this.idiomaODE);
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
        this.conInaprop = null;
        this.conInapropValueList = null;
        this.conInapropLabelList = null;
        this.busquedaSimpleAvanzada = null;
        this.busquedaSimpleAvanzadaValueList = null;
        this.busquedaSimpleAvanzadaLabelList = null;
        this.comentarios = null;
        this.comentariosValueList = null;
        this.comentariosLabelList = null;
        this.tituloODE = null;
        this.tituloODEValueList = null;
        this.tituloODELabelList = null;
        this.tipoLayoutBuscador = null;
        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;
        this.comentario = null;
        this.comentarioValueList = null;
        this.comentarioLabelList = null;
        this.idRowSelection = null;
        this.usuarioAdministrador = null;
        this.usuarioAdministradorValueList = null;
        this.usuarioAdministradorLabelList = null;
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.imagen = null;
        this.imagenValueList = null;
        this.imagenLabelList = null;
        this.mostrarVuelta = null;
        this.mostrarVueltaValueList = null;
        this.mostrarVueltaLabelList = null;
        this.valoracion = null;
        this.valoracionValueList = null;
        this.valoracionLabelList = null;
        this.idODE = null;
        this.idODEValueList = null;
        this.idODELabelList = null;
        this.listaVacia = null;
        this.listaVaciaValueList = null;
        this.listaVaciaLabelList = null;
        this.idiomaODE = null;
        this.idiomaODEValueList = null;
        this.idiomaODELabelList = null;
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
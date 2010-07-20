// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar;

public class PublicarODEAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarODEForm
{
    private java.lang.String titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.lang.String[] mensajes;
    private java.lang.Object[] mensajesValueList;
    private java.lang.Object[] mensajesLabelList;
    private java.lang.String comunidadesSeleccionadas;
    private java.lang.Object[] comunidadesSeleccionadasValueList;
    private java.lang.Object[] comunidadesSeleccionadasLabelList;
    private java.lang.String comentarios;
    private java.lang.Object[] comentariosValueList;
    private java.lang.Object[] comentariosLabelList;
    private java.lang.String idODE;
    private java.lang.Object[] idODEValueList;
    private java.lang.Object[] idODELabelList;
    private java.lang.String tipoLicenciaSeleccionada;
    private java.lang.Object[] tipoLicenciaSeleccionadaValueList;
    private java.lang.Object[] tipoLicenciaSeleccionadaLabelList;

    public PublicarODEAceptarFormImpl()
    {
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
            throw new IllegalArgumentException("PublicarODEAceptarFormImpl.setTituloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PublicarODEAceptarFormImpl.setTituloBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>mensajes</code>.
     */
    public void resetMensajes()
    {
        this.mensajes = null;
    }

    public void setMensajes(java.lang.String[] mensajes)
    {
        this.mensajes = mensajes;
    }

    /**
     * 
     */
    public java.lang.String[] getMensajes()
    {
        return this.mensajes;
    }
    
    public java.lang.Object[] getMensajesBackingList()
    {
        java.lang.Object[] values = this.mensajesValueList;
        java.lang.Object[] labels = this.mensajesLabelList;

        if (values == null || values.length == 0)
        {
            return values;
        }

        if (labels == null || labels.length == 0)
        {
            labels = values;
        }

        final int length = java.lang.Math.min(labels.length, values.length);
        java.lang.Object[] backingList = new java.lang.Object[length];

        for (int i=0; i<length; i++)
        {
            backingList[i] = new LabelValue(labels[i], values[i]);
        }

        return backingList;
    }

    public java.lang.Object[] getMensajesValueList()
    {
        return this.mensajesValueList;
    }

    public void setMensajesValueList(java.lang.Object[] mensajesValueList)
    {
        this.mensajesValueList = mensajesValueList;
    }

    public java.lang.Object[] getMensajesLabelList()
    {
        return this.mensajesLabelList;
    }

    public void setMensajesLabelList(java.lang.Object[] mensajesLabelList)
    {
        this.mensajesLabelList = mensajesLabelList;
    }

    public void setMensajesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarODEAceptarFormImpl.setMensajesBackingList requires non-null property arguments");
        }

        this.mensajesValueList = null;
        this.mensajesLabelList = null;

        if (items != null)
        {
            this.mensajesValueList = new java.lang.Object[items.size()];
            this.mensajesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mensajesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mensajesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarODEAceptarFormImpl.setMensajesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("PublicarODEAceptarFormImpl.setComunidadesSeleccionadasBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PublicarODEAceptarFormImpl.setComunidadesSeleccionadasBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("PublicarODEAceptarFormImpl.setComentariosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PublicarODEAceptarFormImpl.setComentariosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("PublicarODEAceptarFormImpl.setIdODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PublicarODEAceptarFormImpl.setIdODEBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("PublicarODEAceptarFormImpl.setTipoLicenciaSeleccionadaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PublicarODEAceptarFormImpl.setTipoLicenciaSeleccionadaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.mensajes = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("titulo", this.titulo);
        builder.append("mensajes", this.mensajes);
        builder.append("comunidadesSeleccionadas", this.comunidadesSeleccionadas);
        builder.append("comentarios", this.comentarios);
        builder.append("idODE", this.idODE);
        builder.append("tipoLicenciaSeleccionada", this.tipoLicenciaSeleccionada);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.mensajes = null;
        this.mensajesValueList = null;
        this.mensajesLabelList = null;
        this.comunidadesSeleccionadas = null;
        this.comunidadesSeleccionadasValueList = null;
        this.comunidadesSeleccionadasLabelList = null;
        this.comentarios = null;
        this.comentariosValueList = null;
        this.comentariosLabelList = null;
        this.idODE = null;
        this.idODEValueList = null;
        this.idODELabelList = null;
        this.tipoLicenciaSeleccionada = null;
        this.tipoLicenciaSeleccionadaValueList = null;
        this.tipoLicenciaSeleccionadaLabelList = null;
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
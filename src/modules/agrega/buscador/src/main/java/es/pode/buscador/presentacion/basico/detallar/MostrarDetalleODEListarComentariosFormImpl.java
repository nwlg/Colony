// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

public class MostrarDetalleODEListarComentariosFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
    private java.lang.String imagen;
    private java.lang.Object[] imagenValueList;
    private java.lang.Object[] imagenLabelList;
    private java.lang.String idODE;
    private java.lang.Object[] idODEValueList;
    private java.lang.Object[] idODELabelList;
    private java.lang.String idiomaODE;
    private java.lang.Object[] idiomaODEValueList;
    private java.lang.Object[] idiomaODELabelList;
    private java.lang.String tituloODE;
    private java.lang.Object[] tituloODEValueList;
    private java.lang.Object[] tituloODELabelList;
    private java.lang.String tipoLayoutBuscador;
    private java.lang.Object[] tipoLayoutBuscadorValueList;
    private java.lang.Object[] tipoLayoutBuscadorLabelList;

    public MostrarDetalleODEListarComentariosFormImpl()
    {
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
            throw new IllegalArgumentException("MostrarDetalleODEListarComentariosFormImpl.setImagenBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEListarComentariosFormImpl.setImagenBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEListarComentariosFormImpl.setIdODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEListarComentariosFormImpl.setIdODEBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEListarComentariosFormImpl.setIdiomaODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEListarComentariosFormImpl.setIdiomaODEBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEListarComentariosFormImpl.setTituloODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEListarComentariosFormImpl.setTituloODEBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("MostrarDetalleODEListarComentariosFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarDetalleODEListarComentariosFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("imagen", this.imagen);
        builder.append("idODE", this.idODE);
        builder.append("idiomaODE", this.idiomaODE);
        builder.append("tituloODE", this.tituloODE);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.imagen = null;
        this.imagenValueList = null;
        this.imagenLabelList = null;
        this.idODE = null;
        this.idODEValueList = null;
        this.idODELabelList = null;
        this.idiomaODE = null;
        this.idiomaODEValueList = null;
        this.idiomaODELabelList = null;
        this.tituloODE = null;
        this.tituloODEValueList = null;
        this.tituloODELabelList = null;
        this.tipoLayoutBuscador = null;
        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;
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
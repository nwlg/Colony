// license-header java merge-point
package es.pode.administracion.presentacion.noticias.modificar;

public class ModificarNoticiaFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.noticias.modificar.ObtenerIdentificadorForm
{
    private java.lang.Long categoria;
    private java.lang.Object[] categoriaValueList;
    private java.lang.Object[] categoriaLabelList;
    private java.lang.Integer alineamiento;
    private java.lang.Object[] alineamientoValueList;
    private java.lang.Object[] alineamientoLabelList;
    private org.apache.struts.upload.FormFile imagen = null;
    private java.lang.Object[] imagenValueList;
    private java.lang.Object[] imagenLabelList;
    private java.lang.Boolean estado;
    private java.lang.Object[] estadoValueList;
    private java.lang.Object[] estadoLabelList;
    private java.lang.Long idNoticia;
    private java.lang.Object[] idNoticiaValueList;
    private java.lang.Object[] idNoticiaLabelList;
    private java.lang.String nombreImagen;
    private java.lang.Object[] nombreImagenValueList;
    private java.lang.Object[] nombreImagenLabelList;
    private java.lang.Integer activarImagen;
    private java.lang.Object[] activarImagenValueList;
    private java.lang.Object[] activarImagenLabelList;
    private java.lang.String nombreImagenVO;
    private java.lang.Object[] nombreImagenVOValueList;
    private java.lang.Object[] nombreImagenVOLabelList;

    public ModificarNoticiaFormImpl()
    {
    }

    /**
     * Resets the given <code>categoria</code>.
     */
    public void resetCategoria()
    {
        this.categoria = null;
    }

    public void setCategoria(java.lang.Long categoria)
    {
        this.categoria = categoria;
    }

    /**
     * 
     */
    public java.lang.Long getCategoria()
    {
        return this.categoria;
    }
    
    public java.lang.Object[] getCategoriaBackingList()
    {
        java.lang.Object[] values = this.categoriaValueList;
        java.lang.Object[] labels = this.categoriaLabelList;

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

    public java.lang.Object[] getCategoriaValueList()
    {
        return this.categoriaValueList;
    }

    public void setCategoriaValueList(java.lang.Object[] categoriaValueList)
    {
        this.categoriaValueList = categoriaValueList;
    }

    public java.lang.Object[] getCategoriaLabelList()
    {
        return this.categoriaLabelList;
    }

    public void setCategoriaLabelList(java.lang.Object[] categoriaLabelList)
    {
        this.categoriaLabelList = categoriaLabelList;
    }

    public void setCategoriaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarNoticiaFormImpl.setCategoriaBackingList requires non-null property arguments");
        }

        this.categoriaValueList = null;
        this.categoriaLabelList = null;

        if (items != null)
        {
            this.categoriaValueList = new java.lang.Object[items.size()];
            this.categoriaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.categoriaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.categoriaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarNoticiaFormImpl.setCategoriaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>alineamiento</code>.
     */
    public void resetAlineamiento()
    {
        this.alineamiento = null;
    }

    public void setAlineamiento(java.lang.Integer alineamiento)
    {
        this.alineamiento = alineamiento;
    }

    /**
     * 
     */
    public java.lang.Integer getAlineamiento()
    {
        return this.alineamiento;
    }
    
    public java.lang.Object[] getAlineamientoBackingList()
    {
        java.lang.Object[] values = this.alineamientoValueList;
        java.lang.Object[] labels = this.alineamientoLabelList;

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

    public java.lang.Object[] getAlineamientoValueList()
    {
        return this.alineamientoValueList;
    }

    public void setAlineamientoValueList(java.lang.Object[] alineamientoValueList)
    {
        this.alineamientoValueList = alineamientoValueList;
    }

    public java.lang.Object[] getAlineamientoLabelList()
    {
        return this.alineamientoLabelList;
    }

    public void setAlineamientoLabelList(java.lang.Object[] alineamientoLabelList)
    {
        this.alineamientoLabelList = alineamientoLabelList;
    }

    public void setAlineamientoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarNoticiaFormImpl.setAlineamientoBackingList requires non-null property arguments");
        }

        this.alineamientoValueList = null;
        this.alineamientoLabelList = null;

        if (items != null)
        {
            this.alineamientoValueList = new java.lang.Object[items.size()];
            this.alineamientoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.alineamientoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.alineamientoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarNoticiaFormImpl.setAlineamientoBackingList encountered an exception", ex);
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

    public void setImagen(org.apache.struts.upload.FormFile imagen)
    {
        this.imagen = imagen;
    }

    /**
     * 
     */
    public org.apache.struts.upload.FormFile getImagen()
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
            throw new IllegalArgumentException("ModificarNoticiaFormImpl.setImagenBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ModificarNoticiaFormImpl.setImagenBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>estado</code>.
     */
    public void resetEstado()
    {
        this.estado = null;
    }

    public void setEstado(java.lang.Boolean estado)
    {
        this.estado = estado;
    }

    /**
     * 
     */
    public java.lang.Boolean getEstado()
    {
        return this.estado;
    }
    
    public java.lang.Object[] getEstadoBackingList()
    {
        java.lang.Object[] values = this.estadoValueList;
        java.lang.Object[] labels = this.estadoLabelList;

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

    public java.lang.Object[] getEstadoValueList()
    {
        return this.estadoValueList;
    }

    public void setEstadoValueList(java.lang.Object[] estadoValueList)
    {
        this.estadoValueList = estadoValueList;
    }

    public java.lang.Object[] getEstadoLabelList()
    {
        return this.estadoLabelList;
    }

    public void setEstadoLabelList(java.lang.Object[] estadoLabelList)
    {
        this.estadoLabelList = estadoLabelList;
    }

    public void setEstadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarNoticiaFormImpl.setEstadoBackingList requires non-null property arguments");
        }

        this.estadoValueList = null;
        this.estadoLabelList = null;

        if (items != null)
        {
            this.estadoValueList = new java.lang.Object[items.size()];
            this.estadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.estadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.estadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarNoticiaFormImpl.setEstadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idNoticia</code>.
     */
    public void resetIdNoticia()
    {
        this.idNoticia = null;
    }

    public void setIdNoticia(java.lang.Long idNoticia)
    {
        this.idNoticia = idNoticia;
    }

    /**
     * 
     */
    public java.lang.Long getIdNoticia()
    {
        return this.idNoticia;
    }
    
    public java.lang.Object[] getIdNoticiaBackingList()
    {
        java.lang.Object[] values = this.idNoticiaValueList;
        java.lang.Object[] labels = this.idNoticiaLabelList;

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

    public java.lang.Object[] getIdNoticiaValueList()
    {
        return this.idNoticiaValueList;
    }

    public void setIdNoticiaValueList(java.lang.Object[] idNoticiaValueList)
    {
        this.idNoticiaValueList = idNoticiaValueList;
    }

    public java.lang.Object[] getIdNoticiaLabelList()
    {
        return this.idNoticiaLabelList;
    }

    public void setIdNoticiaLabelList(java.lang.Object[] idNoticiaLabelList)
    {
        this.idNoticiaLabelList = idNoticiaLabelList;
    }

    public void setIdNoticiaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarNoticiaFormImpl.setIdNoticiaBackingList requires non-null property arguments");
        }

        this.idNoticiaValueList = null;
        this.idNoticiaLabelList = null;

        if (items != null)
        {
            this.idNoticiaValueList = new java.lang.Object[items.size()];
            this.idNoticiaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idNoticiaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idNoticiaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarNoticiaFormImpl.setIdNoticiaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nombreImagen</code>.
     */
    public void resetNombreImagen()
    {
        this.nombreImagen = null;
    }

    public void setNombreImagen(java.lang.String nombreImagen)
    {
        this.nombreImagen = nombreImagen;
    }

    /**
     * 
     */
    public java.lang.String getNombreImagen()
    {
        return this.nombreImagen;
    }
    
    public java.lang.Object[] getNombreImagenBackingList()
    {
        java.lang.Object[] values = this.nombreImagenValueList;
        java.lang.Object[] labels = this.nombreImagenLabelList;

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

    public java.lang.Object[] getNombreImagenValueList()
    {
        return this.nombreImagenValueList;
    }

    public void setNombreImagenValueList(java.lang.Object[] nombreImagenValueList)
    {
        this.nombreImagenValueList = nombreImagenValueList;
    }

    public java.lang.Object[] getNombreImagenLabelList()
    {
        return this.nombreImagenLabelList;
    }

    public void setNombreImagenLabelList(java.lang.Object[] nombreImagenLabelList)
    {
        this.nombreImagenLabelList = nombreImagenLabelList;
    }

    public void setNombreImagenBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarNoticiaFormImpl.setNombreImagenBackingList requires non-null property arguments");
        }

        this.nombreImagenValueList = null;
        this.nombreImagenLabelList = null;

        if (items != null)
        {
            this.nombreImagenValueList = new java.lang.Object[items.size()];
            this.nombreImagenLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nombreImagenValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nombreImagenLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarNoticiaFormImpl.setNombreImagenBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>activarImagen</code>.
     */
    public void resetActivarImagen()
    {
        this.activarImagen = null;
    }

    public void setActivarImagen(java.lang.Integer activarImagen)
    {
        this.activarImagen = activarImagen;
    }

    /**
     * 
     */
    public java.lang.Integer getActivarImagen()
    {
        return this.activarImagen;
    }
    
    public java.lang.Object[] getActivarImagenBackingList()
    {
        java.lang.Object[] values = this.activarImagenValueList;
        java.lang.Object[] labels = this.activarImagenLabelList;

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

    public java.lang.Object[] getActivarImagenValueList()
    {
        return this.activarImagenValueList;
    }

    public void setActivarImagenValueList(java.lang.Object[] activarImagenValueList)
    {
        this.activarImagenValueList = activarImagenValueList;
    }

    public java.lang.Object[] getActivarImagenLabelList()
    {
        return this.activarImagenLabelList;
    }

    public void setActivarImagenLabelList(java.lang.Object[] activarImagenLabelList)
    {
        this.activarImagenLabelList = activarImagenLabelList;
    }

    public void setActivarImagenBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarNoticiaFormImpl.setActivarImagenBackingList requires non-null property arguments");
        }

        this.activarImagenValueList = null;
        this.activarImagenLabelList = null;

        if (items != null)
        {
            this.activarImagenValueList = new java.lang.Object[items.size()];
            this.activarImagenLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.activarImagenValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.activarImagenLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarNoticiaFormImpl.setActivarImagenBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nombreImagenVO</code>.
     */
    public void resetNombreImagenVO()
    {
        this.nombreImagenVO = null;
    }

    public void setNombreImagenVO(java.lang.String nombreImagenVO)
    {
        this.nombreImagenVO = nombreImagenVO;
    }

    /**
     * 
     */
    public java.lang.String getNombreImagenVO()
    {
        return this.nombreImagenVO;
    }
    
    public java.lang.Object[] getNombreImagenVOBackingList()
    {
        java.lang.Object[] values = this.nombreImagenVOValueList;
        java.lang.Object[] labels = this.nombreImagenVOLabelList;

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

    public java.lang.Object[] getNombreImagenVOValueList()
    {
        return this.nombreImagenVOValueList;
    }

    public void setNombreImagenVOValueList(java.lang.Object[] nombreImagenVOValueList)
    {
        this.nombreImagenVOValueList = nombreImagenVOValueList;
    }

    public java.lang.Object[] getNombreImagenVOLabelList()
    {
        return this.nombreImagenVOLabelList;
    }

    public void setNombreImagenVOLabelList(java.lang.Object[] nombreImagenVOLabelList)
    {
        this.nombreImagenVOLabelList = nombreImagenVOLabelList;
    }

    public void setNombreImagenVOBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarNoticiaFormImpl.setNombreImagenVOBackingList requires non-null property arguments");
        }

        this.nombreImagenVOValueList = null;
        this.nombreImagenVOLabelList = null;

        if (items != null)
        {
            this.nombreImagenVOValueList = new java.lang.Object[items.size()];
            this.nombreImagenVOLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nombreImagenVOValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nombreImagenVOLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarNoticiaFormImpl.setNombreImagenVOBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.categoria = null;
        this.imagen = null;
        this.estado = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("categoria", this.categoria);
        builder.append("alineamiento", this.alineamiento);
        builder.append("imagen", this.imagen);
        builder.append("estado", this.estado);
        builder.append("idNoticia", this.idNoticia);
        builder.append("nombreImagen", this.nombreImagen);
        builder.append("activarImagen", this.activarImagen);
        builder.append("nombreImagenVO", this.nombreImagenVO);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.categoria = null;
        this.categoriaValueList = null;
        this.categoriaLabelList = null;
        this.alineamiento = null;
        this.alineamientoValueList = null;
        this.alineamientoLabelList = null;
        this.imagen = null;
        this.imagenValueList = null;
        this.imagenLabelList = null;
        this.estado = null;
        this.estadoValueList = null;
        this.estadoLabelList = null;
        this.idNoticia = null;
        this.idNoticiaValueList = null;
        this.idNoticiaLabelList = null;
        this.nombreImagen = null;
        this.nombreImagenValueList = null;
        this.nombreImagenLabelList = null;
        this.activarImagen = null;
        this.activarImagenValueList = null;
        this.activarImagenLabelList = null;
        this.nombreImagenVO = null;
        this.nombreImagenVOValueList = null;
        this.nombreImagenVOLabelList = null;
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
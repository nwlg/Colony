// license-header java merge-point
package es.pode.administracion.presentacion.noticias.modificar;

public class ModificarPaso1AceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.noticias.modificar.ModificarNoticiaUnoForm
{
    private java.lang.Integer alineamiento;
    private java.lang.Object[] alineamientoValueList;
    private java.lang.Object[] alineamientoLabelList;
    private java.util.Collection idiomasAlta;
    private java.lang.Object[] idiomasAltaValueList;
    private java.lang.Object[] idiomasAltaLabelList;
    private java.lang.Long idNoticia;
    private java.lang.Object[] idNoticiaValueList;
    private java.lang.Object[] idNoticiaLabelList;
    private java.util.Collection idiomasCategoriasBBDD;
    private java.lang.Object[] idiomasCategoriasBBDDValueList;
    private java.lang.Object[] idiomasCategoriasBBDDLabelList;
    private java.lang.String[] catalan;
    private java.lang.Object[] catalanValueList;
    private java.lang.Object[] catalanLabelList;
    private java.lang.String[] gallego;
    private java.lang.Object[] gallegoValueList;
    private java.lang.Object[] gallegoLabelList;
    private java.lang.Integer activarImagen;
    private java.lang.Object[] activarImagenValueList;
    private java.lang.Object[] activarImagenLabelList;
    private java.util.Collection resumen;
    private java.lang.Object[] resumenValueList;
    private java.lang.Object[] resumenLabelList;
    private java.lang.String nombreImagenVO;
    private java.lang.Object[] nombreImagenVOValueList;
    private java.lang.Object[] nombreImagenVOLabelList;
    private java.lang.Long categoria;
    private java.lang.Object[] categoriaValueList;
    private java.lang.Object[] categoriaLabelList;
    private java.util.Collection nombreCategoria;
    private java.lang.Object[] nombreCategoriaValueList;
    private java.lang.Object[] nombreCategoriaLabelList;
    private java.lang.String[] ingles;
    private java.lang.Object[] inglesValueList;
    private java.lang.Object[] inglesLabelList;
    private org.apache.struts.upload.FormFile imagen = null;
    private java.lang.Object[] imagenValueList;
    private java.lang.Object[] imagenLabelList;
    private java.util.Collection titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.lang.String[] castellano;
    private java.lang.Object[] castellanoValueList;
    private java.lang.Object[] castellanoLabelList;
    private java.lang.Boolean estado;
    private java.lang.Object[] estadoValueList;
    private java.lang.Object[] estadoLabelList;
    private java.util.Collection idiomas;
    private java.lang.Object[] idiomasValueList;
    private java.lang.Object[] idiomasLabelList;
    private java.lang.String[] valenciano;
    private java.lang.Object[] valencianoValueList;
    private java.lang.Object[] valencianoLabelList;
    private java.lang.String[] euskera;
    private java.lang.Object[] euskeraValueList;
    private java.lang.Object[] euskeraLabelList;
    private java.lang.String nombreImagen;
    private java.lang.Object[] nombreImagenValueList;
    private java.lang.Object[] nombreImagenLabelList;
    private java.util.Collection cuerpo;
    private java.lang.Object[] cuerpoValueList;
    private java.lang.Object[] cuerpoLabelList;

    public ModificarPaso1AceptarFormImpl()
    {
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
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setAlineamientoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setAlineamientoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomasAlta</code>.
     */
    public void resetIdiomasAlta()
    {
        this.idiomasAlta = null;
    }

    public void setIdiomasAlta(java.util.Collection idiomasAlta)
    {
        this.idiomasAlta = idiomasAlta;
    }

    /**
     * 
     */
    public java.util.Collection getIdiomasAlta()
    {
        return this.idiomasAlta;
    }

    public void setIdiomasAltaAsArray(Object[] idiomasAlta)
    {
        this.idiomasAlta = (idiomasAlta == null) ? null : java.util.Arrays.asList(idiomasAlta);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.noticias.modificar.ModificarPaso1AceptarFormImpl#getIdiomasAlta
     */
    public java.lang.Object[] getIdiomasAltaAsArray()
    {
        return (idiomasAlta == null) ? null : idiomasAlta.toArray();
    }
    
    public java.lang.Object[] getIdiomasAltaBackingList()
    {
        java.lang.Object[] values = this.idiomasAltaValueList;
        java.lang.Object[] labels = this.idiomasAltaLabelList;

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

    public java.lang.Object[] getIdiomasAltaValueList()
    {
        return this.idiomasAltaValueList;
    }

    public void setIdiomasAltaValueList(java.lang.Object[] idiomasAltaValueList)
    {
        this.idiomasAltaValueList = idiomasAltaValueList;
    }

    public java.lang.Object[] getIdiomasAltaLabelList()
    {
        return this.idiomasAltaLabelList;
    }

    public void setIdiomasAltaLabelList(java.lang.Object[] idiomasAltaLabelList)
    {
        this.idiomasAltaLabelList = idiomasAltaLabelList;
    }

    public void setIdiomasAltaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setIdiomasAltaBackingList requires non-null property arguments");
        }

        this.idiomasAltaValueList = null;
        this.idiomasAltaLabelList = null;

        if (items != null)
        {
            this.idiomasAltaValueList = new java.lang.Object[items.size()];
            this.idiomasAltaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomasAltaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomasAltaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setIdiomasAltaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setIdNoticiaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setIdNoticiaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomasCategoriasBBDD</code>.
     */
    public void resetIdiomasCategoriasBBDD()
    {
        this.idiomasCategoriasBBDD = null;
    }

    public void setIdiomasCategoriasBBDD(java.util.Collection idiomasCategoriasBBDD)
    {
        this.idiomasCategoriasBBDD = idiomasCategoriasBBDD;
    }

    /**
     * 
     */
    public java.util.Collection getIdiomasCategoriasBBDD()
    {
        return this.idiomasCategoriasBBDD;
    }

    public void setIdiomasCategoriasBBDDAsArray(Object[] idiomasCategoriasBBDD)
    {
        this.idiomasCategoriasBBDD = (idiomasCategoriasBBDD == null) ? null : java.util.Arrays.asList(idiomasCategoriasBBDD);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.noticias.modificar.ModificarPaso1AceptarFormImpl#getIdiomasCategoriasBBDD
     */
    public java.lang.Object[] getIdiomasCategoriasBBDDAsArray()
    {
        return (idiomasCategoriasBBDD == null) ? null : idiomasCategoriasBBDD.toArray();
    }
    
    public java.lang.Object[] getIdiomasCategoriasBBDDBackingList()
    {
        java.lang.Object[] values = this.idiomasCategoriasBBDDValueList;
        java.lang.Object[] labels = this.idiomasCategoriasBBDDLabelList;

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

    public java.lang.Object[] getIdiomasCategoriasBBDDValueList()
    {
        return this.idiomasCategoriasBBDDValueList;
    }

    public void setIdiomasCategoriasBBDDValueList(java.lang.Object[] idiomasCategoriasBBDDValueList)
    {
        this.idiomasCategoriasBBDDValueList = idiomasCategoriasBBDDValueList;
    }

    public java.lang.Object[] getIdiomasCategoriasBBDDLabelList()
    {
        return this.idiomasCategoriasBBDDLabelList;
    }

    public void setIdiomasCategoriasBBDDLabelList(java.lang.Object[] idiomasCategoriasBBDDLabelList)
    {
        this.idiomasCategoriasBBDDLabelList = idiomasCategoriasBBDDLabelList;
    }

    public void setIdiomasCategoriasBBDDBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setIdiomasCategoriasBBDDBackingList requires non-null property arguments");
        }

        this.idiomasCategoriasBBDDValueList = null;
        this.idiomasCategoriasBBDDLabelList = null;

        if (items != null)
        {
            this.idiomasCategoriasBBDDValueList = new java.lang.Object[items.size()];
            this.idiomasCategoriasBBDDLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomasCategoriasBBDDValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomasCategoriasBBDDLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setIdiomasCategoriasBBDDBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>catalan</code>.
     */
    public void resetCatalan()
    {
        this.catalan = null;
    }

    public void setCatalan(java.lang.String[] catalan)
    {
        this.catalan = catalan;
    }

    /**
     * 
     */
    public java.lang.String[] getCatalan()
    {
        return this.catalan;
    }
    
    public java.lang.Object[] getCatalanBackingList()
    {
        java.lang.Object[] values = this.catalanValueList;
        java.lang.Object[] labels = this.catalanLabelList;

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

    public java.lang.Object[] getCatalanValueList()
    {
        return this.catalanValueList;
    }

    public void setCatalanValueList(java.lang.Object[] catalanValueList)
    {
        this.catalanValueList = catalanValueList;
    }

    public java.lang.Object[] getCatalanLabelList()
    {
        return this.catalanLabelList;
    }

    public void setCatalanLabelList(java.lang.Object[] catalanLabelList)
    {
        this.catalanLabelList = catalanLabelList;
    }

    public void setCatalanBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setCatalanBackingList requires non-null property arguments");
        }

        this.catalanValueList = null;
        this.catalanLabelList = null;

        if (items != null)
        {
            this.catalanValueList = new java.lang.Object[items.size()];
            this.catalanLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.catalanValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.catalanLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setCatalanBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>gallego</code>.
     */
    public void resetGallego()
    {
        this.gallego = null;
    }

    public void setGallego(java.lang.String[] gallego)
    {
        this.gallego = gallego;
    }

    /**
     * 
     */
    public java.lang.String[] getGallego()
    {
        return this.gallego;
    }
    
    public java.lang.Object[] getGallegoBackingList()
    {
        java.lang.Object[] values = this.gallegoValueList;
        java.lang.Object[] labels = this.gallegoLabelList;

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

    public java.lang.Object[] getGallegoValueList()
    {
        return this.gallegoValueList;
    }

    public void setGallegoValueList(java.lang.Object[] gallegoValueList)
    {
        this.gallegoValueList = gallegoValueList;
    }

    public java.lang.Object[] getGallegoLabelList()
    {
        return this.gallegoLabelList;
    }

    public void setGallegoLabelList(java.lang.Object[] gallegoLabelList)
    {
        this.gallegoLabelList = gallegoLabelList;
    }

    public void setGallegoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setGallegoBackingList requires non-null property arguments");
        }

        this.gallegoValueList = null;
        this.gallegoLabelList = null;

        if (items != null)
        {
            this.gallegoValueList = new java.lang.Object[items.size()];
            this.gallegoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.gallegoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.gallegoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setGallegoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setActivarImagenBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setActivarImagenBackingList encountered an exception", ex);
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

    public void setResumen(java.util.Collection resumen)
    {
        this.resumen = resumen;
    }

    /**
     * 
     */
    public java.util.Collection getResumen()
    {
        return this.resumen;
    }

    public void setResumenAsArray(Object[] resumen)
    {
        this.resumen = (resumen == null) ? null : java.util.Arrays.asList(resumen);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.noticias.modificar.ModificarPaso1AceptarFormImpl#getResumen
     */
    public java.lang.Object[] getResumenAsArray()
    {
        return (resumen == null) ? null : resumen.toArray();
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
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setResumenBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setResumenBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setNombreImagenVOBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setNombreImagenVOBackingList encountered an exception", ex);
            }
        }
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
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setCategoriaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setCategoriaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nombreCategoria</code>.
     */
    public void resetNombreCategoria()
    {
        this.nombreCategoria = null;
    }

    public void setNombreCategoria(java.util.Collection nombreCategoria)
    {
        this.nombreCategoria = nombreCategoria;
    }

    /**
     * 
     */
    public java.util.Collection getNombreCategoria()
    {
        return this.nombreCategoria;
    }

    public void setNombreCategoriaAsArray(Object[] nombreCategoria)
    {
        this.nombreCategoria = (nombreCategoria == null) ? null : java.util.Arrays.asList(nombreCategoria);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.noticias.modificar.ModificarPaso1AceptarFormImpl#getNombreCategoria
     */
    public java.lang.Object[] getNombreCategoriaAsArray()
    {
        return (nombreCategoria == null) ? null : nombreCategoria.toArray();
    }
    
    public java.lang.Object[] getNombreCategoriaBackingList()
    {
        java.lang.Object[] values = this.nombreCategoriaValueList;
        java.lang.Object[] labels = this.nombreCategoriaLabelList;

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

    public java.lang.Object[] getNombreCategoriaValueList()
    {
        return this.nombreCategoriaValueList;
    }

    public void setNombreCategoriaValueList(java.lang.Object[] nombreCategoriaValueList)
    {
        this.nombreCategoriaValueList = nombreCategoriaValueList;
    }

    public java.lang.Object[] getNombreCategoriaLabelList()
    {
        return this.nombreCategoriaLabelList;
    }

    public void setNombreCategoriaLabelList(java.lang.Object[] nombreCategoriaLabelList)
    {
        this.nombreCategoriaLabelList = nombreCategoriaLabelList;
    }

    public void setNombreCategoriaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setNombreCategoriaBackingList requires non-null property arguments");
        }

        this.nombreCategoriaValueList = null;
        this.nombreCategoriaLabelList = null;

        if (items != null)
        {
            this.nombreCategoriaValueList = new java.lang.Object[items.size()];
            this.nombreCategoriaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nombreCategoriaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nombreCategoriaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setNombreCategoriaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ingles</code>.
     */
    public void resetIngles()
    {
        this.ingles = null;
    }

    public void setIngles(java.lang.String[] ingles)
    {
        this.ingles = ingles;
    }

    /**
     * 
     */
    public java.lang.String[] getIngles()
    {
        return this.ingles;
    }
    
    public java.lang.Object[] getInglesBackingList()
    {
        java.lang.Object[] values = this.inglesValueList;
        java.lang.Object[] labels = this.inglesLabelList;

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

    public java.lang.Object[] getInglesValueList()
    {
        return this.inglesValueList;
    }

    public void setInglesValueList(java.lang.Object[] inglesValueList)
    {
        this.inglesValueList = inglesValueList;
    }

    public java.lang.Object[] getInglesLabelList()
    {
        return this.inglesLabelList;
    }

    public void setInglesLabelList(java.lang.Object[] inglesLabelList)
    {
        this.inglesLabelList = inglesLabelList;
    }

    public void setInglesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setInglesBackingList requires non-null property arguments");
        }

        this.inglesValueList = null;
        this.inglesLabelList = null;

        if (items != null)
        {
            this.inglesValueList = new java.lang.Object[items.size()];
            this.inglesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.inglesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.inglesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setInglesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setImagenBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setImagenBackingList encountered an exception", ex);
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

    public void setTitulo(java.util.Collection titulo)
    {
        this.titulo = titulo;
    }

    /**
     * 
     */
    public java.util.Collection getTitulo()
    {
        return this.titulo;
    }

    public void setTituloAsArray(Object[] titulo)
    {
        this.titulo = (titulo == null) ? null : java.util.Arrays.asList(titulo);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.noticias.modificar.ModificarPaso1AceptarFormImpl#getTitulo
     */
    public java.lang.Object[] getTituloAsArray()
    {
        return (titulo == null) ? null : titulo.toArray();
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
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setTituloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setTituloBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>castellano</code>.
     */
    public void resetCastellano()
    {
        this.castellano = null;
    }

    public void setCastellano(java.lang.String[] castellano)
    {
        this.castellano = castellano;
    }

    /**
     * 
     */
    public java.lang.String[] getCastellano()
    {
        return this.castellano;
    }
    
    public java.lang.Object[] getCastellanoBackingList()
    {
        java.lang.Object[] values = this.castellanoValueList;
        java.lang.Object[] labels = this.castellanoLabelList;

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

    public java.lang.Object[] getCastellanoValueList()
    {
        return this.castellanoValueList;
    }

    public void setCastellanoValueList(java.lang.Object[] castellanoValueList)
    {
        this.castellanoValueList = castellanoValueList;
    }

    public java.lang.Object[] getCastellanoLabelList()
    {
        return this.castellanoLabelList;
    }

    public void setCastellanoLabelList(java.lang.Object[] castellanoLabelList)
    {
        this.castellanoLabelList = castellanoLabelList;
    }

    public void setCastellanoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setCastellanoBackingList requires non-null property arguments");
        }

        this.castellanoValueList = null;
        this.castellanoLabelList = null;

        if (items != null)
        {
            this.castellanoValueList = new java.lang.Object[items.size()];
            this.castellanoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.castellanoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.castellanoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setCastellanoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setEstadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setEstadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomas</code>.
     */
    public void resetIdiomas()
    {
        this.idiomas = null;
    }

    public void setIdiomas(java.util.Collection idiomas)
    {
        this.idiomas = idiomas;
    }

    /**
     * 
     */
    public java.util.Collection getIdiomas()
    {
        return this.idiomas;
    }

    public void setIdiomasAsArray(Object[] idiomas)
    {
        this.idiomas = (idiomas == null) ? null : java.util.Arrays.asList(idiomas);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.noticias.modificar.ModificarPaso1AceptarFormImpl#getIdiomas
     */
    public java.lang.Object[] getIdiomasAsArray()
    {
        return (idiomas == null) ? null : idiomas.toArray();
    }
    
    public java.lang.Object[] getIdiomasBackingList()
    {
        java.lang.Object[] values = this.idiomasValueList;
        java.lang.Object[] labels = this.idiomasLabelList;

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

    public java.lang.Object[] getIdiomasValueList()
    {
        return this.idiomasValueList;
    }

    public void setIdiomasValueList(java.lang.Object[] idiomasValueList)
    {
        this.idiomasValueList = idiomasValueList;
    }

    public java.lang.Object[] getIdiomasLabelList()
    {
        return this.idiomasLabelList;
    }

    public void setIdiomasLabelList(java.lang.Object[] idiomasLabelList)
    {
        this.idiomasLabelList = idiomasLabelList;
    }

    public void setIdiomasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setIdiomasBackingList requires non-null property arguments");
        }

        this.idiomasValueList = null;
        this.idiomasLabelList = null;

        if (items != null)
        {
            this.idiomasValueList = new java.lang.Object[items.size()];
            this.idiomasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setIdiomasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>valenciano</code>.
     */
    public void resetValenciano()
    {
        this.valenciano = null;
    }

    public void setValenciano(java.lang.String[] valenciano)
    {
        this.valenciano = valenciano;
    }

    /**
     * 
     */
    public java.lang.String[] getValenciano()
    {
        return this.valenciano;
    }
    
    public java.lang.Object[] getValencianoBackingList()
    {
        java.lang.Object[] values = this.valencianoValueList;
        java.lang.Object[] labels = this.valencianoLabelList;

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

    public java.lang.Object[] getValencianoValueList()
    {
        return this.valencianoValueList;
    }

    public void setValencianoValueList(java.lang.Object[] valencianoValueList)
    {
        this.valencianoValueList = valencianoValueList;
    }

    public java.lang.Object[] getValencianoLabelList()
    {
        return this.valencianoLabelList;
    }

    public void setValencianoLabelList(java.lang.Object[] valencianoLabelList)
    {
        this.valencianoLabelList = valencianoLabelList;
    }

    public void setValencianoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setValencianoBackingList requires non-null property arguments");
        }

        this.valencianoValueList = null;
        this.valencianoLabelList = null;

        if (items != null)
        {
            this.valencianoValueList = new java.lang.Object[items.size()];
            this.valencianoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.valencianoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.valencianoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setValencianoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>euskera</code>.
     */
    public void resetEuskera()
    {
        this.euskera = null;
    }

    public void setEuskera(java.lang.String[] euskera)
    {
        this.euskera = euskera;
    }

    /**
     * 
     */
    public java.lang.String[] getEuskera()
    {
        return this.euskera;
    }
    
    public java.lang.Object[] getEuskeraBackingList()
    {
        java.lang.Object[] values = this.euskeraValueList;
        java.lang.Object[] labels = this.euskeraLabelList;

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

    public java.lang.Object[] getEuskeraValueList()
    {
        return this.euskeraValueList;
    }

    public void setEuskeraValueList(java.lang.Object[] euskeraValueList)
    {
        this.euskeraValueList = euskeraValueList;
    }

    public java.lang.Object[] getEuskeraLabelList()
    {
        return this.euskeraLabelList;
    }

    public void setEuskeraLabelList(java.lang.Object[] euskeraLabelList)
    {
        this.euskeraLabelList = euskeraLabelList;
    }

    public void setEuskeraBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setEuskeraBackingList requires non-null property arguments");
        }

        this.euskeraValueList = null;
        this.euskeraLabelList = null;

        if (items != null)
        {
            this.euskeraValueList = new java.lang.Object[items.size()];
            this.euskeraLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.euskeraValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.euskeraLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setEuskeraBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setNombreImagenBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setNombreImagenBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>cuerpo</code>.
     */
    public void resetCuerpo()
    {
        this.cuerpo = null;
    }

    public void setCuerpo(java.util.Collection cuerpo)
    {
        this.cuerpo = cuerpo;
    }

    /**
     * 
     */
    public java.util.Collection getCuerpo()
    {
        return this.cuerpo;
    }

    public void setCuerpoAsArray(Object[] cuerpo)
    {
        this.cuerpo = (cuerpo == null) ? null : java.util.Arrays.asList(cuerpo);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.noticias.modificar.ModificarPaso1AceptarFormImpl#getCuerpo
     */
    public java.lang.Object[] getCuerpoAsArray()
    {
        return (cuerpo == null) ? null : cuerpo.toArray();
    }
    
    public java.lang.Object[] getCuerpoBackingList()
    {
        java.lang.Object[] values = this.cuerpoValueList;
        java.lang.Object[] labels = this.cuerpoLabelList;

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

    public java.lang.Object[] getCuerpoValueList()
    {
        return this.cuerpoValueList;
    }

    public void setCuerpoValueList(java.lang.Object[] cuerpoValueList)
    {
        this.cuerpoValueList = cuerpoValueList;
    }

    public java.lang.Object[] getCuerpoLabelList()
    {
        return this.cuerpoLabelList;
    }

    public void setCuerpoLabelList(java.lang.Object[] cuerpoLabelList)
    {
        this.cuerpoLabelList = cuerpoLabelList;
    }

    public void setCuerpoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ModificarPaso1AceptarFormImpl.setCuerpoBackingList requires non-null property arguments");
        }

        this.cuerpoValueList = null;
        this.cuerpoLabelList = null;

        if (items != null)
        {
            this.cuerpoValueList = new java.lang.Object[items.size()];
            this.cuerpoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.cuerpoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.cuerpoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ModificarPaso1AceptarFormImpl.setCuerpoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.catalan = null;
        this.catalanValueList = new java.lang.Object[0];
        this.catalanLabelList = new java.lang.Object[0];
        this.gallego = null;
        this.gallegoValueList = new java.lang.Object[0];
        this.gallegoLabelList = new java.lang.Object[0];
        this.categoria = null;
        this.ingles = null;
        this.inglesValueList = new java.lang.Object[0];
        this.inglesLabelList = new java.lang.Object[0];
        this.imagen = null;
        this.castellano = null;
        this.castellanoValueList = new java.lang.Object[0];
        this.castellanoLabelList = new java.lang.Object[0];
        this.estado = null;
        this.valenciano = null;
        this.valencianoValueList = new java.lang.Object[0];
        this.valencianoLabelList = new java.lang.Object[0];
        this.euskera = null;
        this.euskeraValueList = new java.lang.Object[0];
        this.euskeraLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("alineamiento", this.alineamiento);
        builder.append("idiomasAlta", this.idiomasAlta);
        builder.append("idNoticia", this.idNoticia);
        builder.append("idiomasCategoriasBBDD", this.idiomasCategoriasBBDD);
        builder.append("catalan", this.catalan);
        builder.append("gallego", this.gallego);
        builder.append("activarImagen", this.activarImagen);
        builder.append("resumen", this.resumen);
        builder.append("nombreImagenVO", this.nombreImagenVO);
        builder.append("categoria", this.categoria);
        builder.append("nombreCategoria", this.nombreCategoria);
        builder.append("ingles", this.ingles);
        builder.append("imagen", this.imagen);
        builder.append("titulo", this.titulo);
        builder.append("castellano", this.castellano);
        builder.append("estado", this.estado);
        builder.append("idiomas", this.idiomas);
        builder.append("valenciano", this.valenciano);
        builder.append("euskera", this.euskera);
        builder.append("nombreImagen", this.nombreImagen);
        builder.append("cuerpo", this.cuerpo);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.alineamiento = null;
        this.alineamientoValueList = null;
        this.alineamientoLabelList = null;
        this.idiomasAlta = null;
        this.idiomasAltaValueList = null;
        this.idiomasAltaLabelList = null;
        this.idNoticia = null;
        this.idNoticiaValueList = null;
        this.idNoticiaLabelList = null;
        this.idiomasCategoriasBBDD = null;
        this.idiomasCategoriasBBDDValueList = null;
        this.idiomasCategoriasBBDDLabelList = null;
        this.catalan = null;
        this.catalanValueList = null;
        this.catalanLabelList = null;
        this.gallego = null;
        this.gallegoValueList = null;
        this.gallegoLabelList = null;
        this.activarImagen = null;
        this.activarImagenValueList = null;
        this.activarImagenLabelList = null;
        this.resumen = null;
        this.resumenValueList = null;
        this.resumenLabelList = null;
        this.nombreImagenVO = null;
        this.nombreImagenVOValueList = null;
        this.nombreImagenVOLabelList = null;
        this.categoria = null;
        this.categoriaValueList = null;
        this.categoriaLabelList = null;
        this.nombreCategoria = null;
        this.nombreCategoriaValueList = null;
        this.nombreCategoriaLabelList = null;
        this.ingles = null;
        this.inglesValueList = null;
        this.inglesLabelList = null;
        this.imagen = null;
        this.imagenValueList = null;
        this.imagenLabelList = null;
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.castellano = null;
        this.castellanoValueList = null;
        this.castellanoLabelList = null;
        this.estado = null;
        this.estadoValueList = null;
        this.estadoLabelList = null;
        this.idiomas = null;
        this.idiomasValueList = null;
        this.idiomasLabelList = null;
        this.valenciano = null;
        this.valencianoValueList = null;
        this.valencianoLabelList = null;
        this.euskera = null;
        this.euskeraValueList = null;
        this.euskeraLabelList = null;
        this.nombreImagen = null;
        this.nombreImagenValueList = null;
        this.nombreImagenLabelList = null;
        this.cuerpo = null;
        this.cuerpoValueList = null;
        this.cuerpoLabelList = null;
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
// license-header java merge-point
package es.pode.visualizador.presentacion.noticia;

public class NoticiaFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.visualizador.presentacion.noticia.CargaNoticiaForm
{
    private java.lang.Long idCategoria;
    private java.lang.Object[] idCategoriaValueList;
    private java.lang.Object[] idCategoriaLabelList;
    private java.lang.Long id;
    private java.lang.Object[] idValueList;
    private java.lang.Object[] idLabelList;
    private es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO noticiavo;
    private java.lang.Object[] noticiavoValueList;
    private java.lang.Object[] noticiavoLabelList;
    private java.lang.String categoria;
    private java.lang.Object[] categoriaValueList;
    private java.lang.Object[] categoriaLabelList;
    private java.lang.String titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.lang.String nombreCategoriaCodex;
    private java.lang.Object[] nombreCategoriaCodexValueList;
    private java.lang.Object[] nombreCategoriaCodexLabelList;
    private java.lang.Integer alineamientoImg;
    private java.lang.Object[] alineamientoImgValueList;
    private java.lang.Object[] alineamientoImgLabelList;
    private java.lang.String cuerpo;
    private java.lang.Object[] cuerpoValueList;
    private java.lang.Object[] cuerpoLabelList;
    private java.lang.String resumen;
    private java.lang.Object[] resumenValueList;
    private java.lang.Object[] resumenLabelList;
    private java.lang.String URLImagen;
    private java.lang.Object[] URLImagenValueList;
    private java.lang.Object[] URLImagenLabelList;

    public NoticiaFormImpl()
    {
    }

    /**
     * Resets the given <code>idCategoria</code>.
     */
    public void resetIdCategoria()
    {
        this.idCategoria = null;
    }

    public void setIdCategoria(java.lang.Long idCategoria)
    {
        this.idCategoria = idCategoria;
    }

    /**
     * 
     */
    public java.lang.Long getIdCategoria()
    {
        return this.idCategoria;
    }
    
    public java.lang.Object[] getIdCategoriaBackingList()
    {
        java.lang.Object[] values = this.idCategoriaValueList;
        java.lang.Object[] labels = this.idCategoriaLabelList;

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

    public java.lang.Object[] getIdCategoriaValueList()
    {
        return this.idCategoriaValueList;
    }

    public void setIdCategoriaValueList(java.lang.Object[] idCategoriaValueList)
    {
        this.idCategoriaValueList = idCategoriaValueList;
    }

    public java.lang.Object[] getIdCategoriaLabelList()
    {
        return this.idCategoriaLabelList;
    }

    public void setIdCategoriaLabelList(java.lang.Object[] idCategoriaLabelList)
    {
        this.idCategoriaLabelList = idCategoriaLabelList;
    }

    public void setIdCategoriaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NoticiaFormImpl.setIdCategoriaBackingList requires non-null property arguments");
        }

        this.idCategoriaValueList = null;
        this.idCategoriaLabelList = null;

        if (items != null)
        {
            this.idCategoriaValueList = new java.lang.Object[items.size()];
            this.idCategoriaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idCategoriaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idCategoriaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NoticiaFormImpl.setIdCategoriaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>id</code>.
     */
    public void resetId()
    {
        this.id = null;
    }

    public void setId(java.lang.Long id)
    {
        this.id = id;
    }

    /**
     * 
     */
    public java.lang.Long getId()
    {
        return this.id;
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
            throw new IllegalArgumentException("NoticiaFormImpl.setIdBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("NoticiaFormImpl.setIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>noticiavo</code>.
     */
    public void resetNoticiavo()
    {
        this.noticiavo = null;
    }

    public void setNoticiavo(es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO noticiavo)
    {
        this.noticiavo = noticiavo;
    }

    /**
     * 
     */
    public es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO getNoticiavo()
    {
        return this.noticiavo;
    }
    
    public java.lang.Object[] getNoticiavoBackingList()
    {
        java.lang.Object[] values = this.noticiavoValueList;
        java.lang.Object[] labels = this.noticiavoLabelList;

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

    public java.lang.Object[] getNoticiavoValueList()
    {
        return this.noticiavoValueList;
    }

    public void setNoticiavoValueList(java.lang.Object[] noticiavoValueList)
    {
        this.noticiavoValueList = noticiavoValueList;
    }

    public java.lang.Object[] getNoticiavoLabelList()
    {
        return this.noticiavoLabelList;
    }

    public void setNoticiavoLabelList(java.lang.Object[] noticiavoLabelList)
    {
        this.noticiavoLabelList = noticiavoLabelList;
    }

    public void setNoticiavoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NoticiaFormImpl.setNoticiavoBackingList requires non-null property arguments");
        }

        this.noticiavoValueList = null;
        this.noticiavoLabelList = null;

        if (items != null)
        {
            this.noticiavoValueList = new java.lang.Object[items.size()];
            this.noticiavoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.noticiavoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.noticiavoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NoticiaFormImpl.setNoticiavoBackingList encountered an exception", ex);
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

    public void setCategoria(java.lang.String categoria)
    {
        this.categoria = categoria;
    }

    /**
     * 
     */
    public java.lang.String getCategoria()
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
            throw new IllegalArgumentException("NoticiaFormImpl.setCategoriaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("NoticiaFormImpl.setCategoriaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("NoticiaFormImpl.setTituloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("NoticiaFormImpl.setTituloBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nombreCategoriaCodex</code>.
     */
    public void resetNombreCategoriaCodex()
    {
        this.nombreCategoriaCodex = null;
    }

    public void setNombreCategoriaCodex(java.lang.String nombreCategoriaCodex)
    {
        this.nombreCategoriaCodex = nombreCategoriaCodex;
    }

    /**
     * 
     */
    public java.lang.String getNombreCategoriaCodex()
    {
        return this.nombreCategoriaCodex;
    }
    
    public java.lang.Object[] getNombreCategoriaCodexBackingList()
    {
        java.lang.Object[] values = this.nombreCategoriaCodexValueList;
        java.lang.Object[] labels = this.nombreCategoriaCodexLabelList;

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

    public java.lang.Object[] getNombreCategoriaCodexValueList()
    {
        return this.nombreCategoriaCodexValueList;
    }

    public void setNombreCategoriaCodexValueList(java.lang.Object[] nombreCategoriaCodexValueList)
    {
        this.nombreCategoriaCodexValueList = nombreCategoriaCodexValueList;
    }

    public java.lang.Object[] getNombreCategoriaCodexLabelList()
    {
        return this.nombreCategoriaCodexLabelList;
    }

    public void setNombreCategoriaCodexLabelList(java.lang.Object[] nombreCategoriaCodexLabelList)
    {
        this.nombreCategoriaCodexLabelList = nombreCategoriaCodexLabelList;
    }

    public void setNombreCategoriaCodexBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NoticiaFormImpl.setNombreCategoriaCodexBackingList requires non-null property arguments");
        }

        this.nombreCategoriaCodexValueList = null;
        this.nombreCategoriaCodexLabelList = null;

        if (items != null)
        {
            this.nombreCategoriaCodexValueList = new java.lang.Object[items.size()];
            this.nombreCategoriaCodexLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nombreCategoriaCodexValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nombreCategoriaCodexLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NoticiaFormImpl.setNombreCategoriaCodexBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>alineamientoImg</code>.
     */
    public void resetAlineamientoImg()
    {
        this.alineamientoImg = null;
    }

    public void setAlineamientoImg(java.lang.Integer alineamientoImg)
    {
        this.alineamientoImg = alineamientoImg;
    }

    /**
     * 
     */
    public java.lang.Integer getAlineamientoImg()
    {
        return this.alineamientoImg;
    }
    
    public java.lang.Object[] getAlineamientoImgBackingList()
    {
        java.lang.Object[] values = this.alineamientoImgValueList;
        java.lang.Object[] labels = this.alineamientoImgLabelList;

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

    public java.lang.Object[] getAlineamientoImgValueList()
    {
        return this.alineamientoImgValueList;
    }

    public void setAlineamientoImgValueList(java.lang.Object[] alineamientoImgValueList)
    {
        this.alineamientoImgValueList = alineamientoImgValueList;
    }

    public java.lang.Object[] getAlineamientoImgLabelList()
    {
        return this.alineamientoImgLabelList;
    }

    public void setAlineamientoImgLabelList(java.lang.Object[] alineamientoImgLabelList)
    {
        this.alineamientoImgLabelList = alineamientoImgLabelList;
    }

    public void setAlineamientoImgBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NoticiaFormImpl.setAlineamientoImgBackingList requires non-null property arguments");
        }

        this.alineamientoImgValueList = null;
        this.alineamientoImgLabelList = null;

        if (items != null)
        {
            this.alineamientoImgValueList = new java.lang.Object[items.size()];
            this.alineamientoImgLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.alineamientoImgValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.alineamientoImgLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NoticiaFormImpl.setAlineamientoImgBackingList encountered an exception", ex);
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

    public void setCuerpo(java.lang.String cuerpo)
    {
        this.cuerpo = cuerpo;
    }

    /**
     * 
     */
    public java.lang.String getCuerpo()
    {
        return this.cuerpo;
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
            throw new IllegalArgumentException("NoticiaFormImpl.setCuerpoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("NoticiaFormImpl.setCuerpoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("NoticiaFormImpl.setResumenBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("NoticiaFormImpl.setResumenBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>URLImagen</code>.
     */
    public void resetURLImagen()
    {
        this.URLImagen = null;
    }

    public void setURLImagen(java.lang.String URLImagen)
    {
        this.URLImagen = URLImagen;
    }

    /**
     * 
     */
    public java.lang.String getURLImagen()
    {
        return this.URLImagen;
    }
    
    public java.lang.Object[] getURLImagenBackingList()
    {
        java.lang.Object[] values = this.URLImagenValueList;
        java.lang.Object[] labels = this.URLImagenLabelList;

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

    public java.lang.Object[] getURLImagenValueList()
    {
        return this.URLImagenValueList;
    }

    public void setURLImagenValueList(java.lang.Object[] URLImagenValueList)
    {
        this.URLImagenValueList = URLImagenValueList;
    }

    public java.lang.Object[] getURLImagenLabelList()
    {
        return this.URLImagenLabelList;
    }

    public void setURLImagenLabelList(java.lang.Object[] URLImagenLabelList)
    {
        this.URLImagenLabelList = URLImagenLabelList;
    }

    public void setURLImagenBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NoticiaFormImpl.setURLImagenBackingList requires non-null property arguments");
        }

        this.URLImagenValueList = null;
        this.URLImagenLabelList = null;

        if (items != null)
        {
            this.URLImagenValueList = new java.lang.Object[items.size()];
            this.URLImagenLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.URLImagenValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.URLImagenLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NoticiaFormImpl.setURLImagenBackingList encountered an exception", ex);
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
        builder.append("idCategoria", this.idCategoria);
        builder.append("id", this.id);
        builder.append("noticiavo", this.noticiavo);
        builder.append("categoria", this.categoria);
        builder.append("titulo", this.titulo);
        builder.append("nombreCategoriaCodex", this.nombreCategoriaCodex);
        builder.append("alineamientoImg", this.alineamientoImg);
        builder.append("cuerpo", this.cuerpo);
        builder.append("resumen", this.resumen);
        builder.append("URLImagen", this.URLImagen);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.idCategoria = null;
        this.idCategoriaValueList = null;
        this.idCategoriaLabelList = null;
        this.id = null;
        this.idValueList = null;
        this.idLabelList = null;
        this.noticiavo = null;
        this.noticiavoValueList = null;
        this.noticiavoLabelList = null;
        this.categoria = null;
        this.categoriaValueList = null;
        this.categoriaLabelList = null;
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.nombreCategoriaCodex = null;
        this.nombreCategoriaCodexValueList = null;
        this.nombreCategoriaCodexLabelList = null;
        this.alineamientoImg = null;
        this.alineamientoImgValueList = null;
        this.alineamientoImgLabelList = null;
        this.cuerpo = null;
        this.cuerpoValueList = null;
        this.cuerpoLabelList = null;
        this.resumen = null;
        this.resumenValueList = null;
        this.resumenLabelList = null;
        this.URLImagen = null;
        this.URLImagenValueList = null;
        this.URLImagenLabelList = null;
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
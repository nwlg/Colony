// license-header java merge-point
package es.pode.administracion.presentacion.noticias.verNoticia;

public class FormularioUnoSiguienteFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.noticias.verNoticia.VerPasoDosForm
{
    private java.lang.Long categoria;
    private java.lang.Object[] categoriaValueList;
    private java.lang.Object[] categoriaLabelList;
    private java.util.Collection nombreCategoria;
    private java.lang.Object[] nombreCategoriaValueList;
    private java.lang.Object[] nombreCategoriaLabelList;
    private java.util.Collection titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.util.Collection idiomas;
    private java.lang.Object[] idiomasValueList;
    private java.lang.Object[] idiomasLabelList;
    private java.util.Collection idiomasAlta;
    private java.lang.Object[] idiomasAltaValueList;
    private java.lang.Object[] idiomasAltaLabelList;
    private java.lang.Long idNoticia;
    private java.lang.Object[] idNoticiaValueList;
    private java.lang.Object[] idNoticiaLabelList;
    private java.util.Collection cuerpo;
    private java.lang.Object[] cuerpoValueList;
    private java.lang.Object[] cuerpoLabelList;
    private java.util.Collection resumen;
    private java.lang.Object[] resumenValueList;
    private java.lang.Object[] resumenLabelList;

    public FormularioUnoSiguienteFormImpl()
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
            throw new IllegalArgumentException("FormularioUnoSiguienteFormImpl.setCategoriaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioUnoSiguienteFormImpl.setCategoriaBackingList encountered an exception", ex);
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
     * @see es.pode.administracion.presentacion.noticias.verNoticia.FormularioUnoSiguienteFormImpl#getNombreCategoria
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
            throw new IllegalArgumentException("FormularioUnoSiguienteFormImpl.setNombreCategoriaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioUnoSiguienteFormImpl.setNombreCategoriaBackingList encountered an exception", ex);
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
     * @see es.pode.administracion.presentacion.noticias.verNoticia.FormularioUnoSiguienteFormImpl#getTitulo
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
            throw new IllegalArgumentException("FormularioUnoSiguienteFormImpl.setTituloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioUnoSiguienteFormImpl.setTituloBackingList encountered an exception", ex);
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
     * @see es.pode.administracion.presentacion.noticias.verNoticia.FormularioUnoSiguienteFormImpl#getIdiomas
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
            throw new IllegalArgumentException("FormularioUnoSiguienteFormImpl.setIdiomasBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioUnoSiguienteFormImpl.setIdiomasBackingList encountered an exception", ex);
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
     * @see es.pode.administracion.presentacion.noticias.verNoticia.FormularioUnoSiguienteFormImpl#getIdiomasAlta
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
            throw new IllegalArgumentException("FormularioUnoSiguienteFormImpl.setIdiomasAltaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioUnoSiguienteFormImpl.setIdiomasAltaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioUnoSiguienteFormImpl.setIdNoticiaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioUnoSiguienteFormImpl.setIdNoticiaBackingList encountered an exception", ex);
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
     * @see es.pode.administracion.presentacion.noticias.verNoticia.FormularioUnoSiguienteFormImpl#getCuerpo
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
            throw new IllegalArgumentException("FormularioUnoSiguienteFormImpl.setCuerpoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioUnoSiguienteFormImpl.setCuerpoBackingList encountered an exception", ex);
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
     * @see es.pode.administracion.presentacion.noticias.verNoticia.FormularioUnoSiguienteFormImpl#getResumen
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
            throw new IllegalArgumentException("FormularioUnoSiguienteFormImpl.setResumenBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioUnoSiguienteFormImpl.setResumenBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.categoria = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("categoria", this.categoria);
        builder.append("nombreCategoria", this.nombreCategoria);
        builder.append("titulo", this.titulo);
        builder.append("idiomas", this.idiomas);
        builder.append("idiomasAlta", this.idiomasAlta);
        builder.append("idNoticia", this.idNoticia);
        builder.append("cuerpo", this.cuerpo);
        builder.append("resumen", this.resumen);
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
        this.nombreCategoria = null;
        this.nombreCategoriaValueList = null;
        this.nombreCategoriaLabelList = null;
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.idiomas = null;
        this.idiomasValueList = null;
        this.idiomasLabelList = null;
        this.idiomasAlta = null;
        this.idiomasAltaValueList = null;
        this.idiomasAltaLabelList = null;
        this.idNoticia = null;
        this.idNoticiaValueList = null;
        this.idNoticiaLabelList = null;
        this.cuerpo = null;
        this.cuerpoValueList = null;
        this.cuerpoLabelList = null;
        this.resumen = null;
        this.resumenValueList = null;
        this.resumenLabelList = null;
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
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.importarURL;

public class ImportarURLCUFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.gestorFlujo.presentacion.objetosPersonales.importarURL.CapturarURLForm
{
    private java.lang.String idiomaDestinatario;
    private java.lang.Object[] idiomaDestinatarioValueList;
    private java.lang.Object[] idiomaDestinatarioLabelList;
    private java.lang.String titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.util.Collection listaIdiomaDest;
    private java.lang.Object[] listaIdiomaDestValueList;
    private java.lang.Object[] listaIdiomaDestLabelList;
    private java.lang.String comentarios;
    private java.lang.Object[] comentariosValueList;
    private java.lang.Object[] comentariosLabelList;
    private java.lang.String tipo;
    private java.lang.Object[] tipoValueList;
    private java.lang.Object[] tipoLabelList;
    private java.util.Collection listaIdiomas;
    private java.lang.Object[] listaIdiomasValueList;
    private java.lang.Object[] listaIdiomasLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.util.Collection listaTipo;
    private java.lang.Object[] listaTipoValueList;
    private java.lang.Object[] listaTipoLabelList;
    private java.lang.String url;
    private java.lang.Object[] urlValueList;
    private java.lang.Object[] urlLabelList;

    public ImportarURLCUFormImpl()
    {
    }

    /**
     * Resets the given <code>idiomaDestinatario</code>.
     */
    public void resetIdiomaDestinatario()
    {
        this.idiomaDestinatario = null;
    }

    public void setIdiomaDestinatario(java.lang.String idiomaDestinatario)
    {
        this.idiomaDestinatario = idiomaDestinatario;
    }

    /**
     * 
     */
    public java.lang.String getIdiomaDestinatario()
    {
        return this.idiomaDestinatario;
    }
    
    public java.lang.Object[] getIdiomaDestinatarioBackingList()
    {
        java.lang.Object[] values = this.idiomaDestinatarioValueList;
        java.lang.Object[] labels = this.idiomaDestinatarioLabelList;

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

    public java.lang.Object[] getIdiomaDestinatarioValueList()
    {
        return this.idiomaDestinatarioValueList;
    }

    public void setIdiomaDestinatarioValueList(java.lang.Object[] idiomaDestinatarioValueList)
    {
        this.idiomaDestinatarioValueList = idiomaDestinatarioValueList;
    }

    public java.lang.Object[] getIdiomaDestinatarioLabelList()
    {
        return this.idiomaDestinatarioLabelList;
    }

    public void setIdiomaDestinatarioLabelList(java.lang.Object[] idiomaDestinatarioLabelList)
    {
        this.idiomaDestinatarioLabelList = idiomaDestinatarioLabelList;
    }

    public void setIdiomaDestinatarioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ImportarURLCUFormImpl.setIdiomaDestinatarioBackingList requires non-null property arguments");
        }

        this.idiomaDestinatarioValueList = null;
        this.idiomaDestinatarioLabelList = null;

        if (items != null)
        {
            this.idiomaDestinatarioValueList = new java.lang.Object[items.size()];
            this.idiomaDestinatarioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomaDestinatarioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomaDestinatarioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ImportarURLCUFormImpl.setIdiomaDestinatarioBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ImportarURLCUFormImpl.setTituloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ImportarURLCUFormImpl.setTituloBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listaIdiomaDest</code>.
     */
    public void resetListaIdiomaDest()
    {
        this.listaIdiomaDest = null;
    }

    public void setListaIdiomaDest(java.util.Collection listaIdiomaDest)
    {
        this.listaIdiomaDest = listaIdiomaDest;
    }

    /**
     * 
     */
    public java.util.Collection getListaIdiomaDest()
    {
        return this.listaIdiomaDest;
    }

    public void setListaIdiomaDestAsArray(Object[] listaIdiomaDest)
    {
        this.listaIdiomaDest = (listaIdiomaDest == null) ? null : java.util.Arrays.asList(listaIdiomaDest);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.gestorFlujo.presentacion.objetosPersonales.importarURL.ImportarURLCUFormImpl#getListaIdiomaDest
     */
    public java.lang.Object[] getListaIdiomaDestAsArray()
    {
        return (listaIdiomaDest == null) ? null : listaIdiomaDest.toArray();
    }
    
    public java.lang.Object[] getListaIdiomaDestBackingList()
    {
        java.lang.Object[] values = this.listaIdiomaDestValueList;
        java.lang.Object[] labels = this.listaIdiomaDestLabelList;

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

    public java.lang.Object[] getListaIdiomaDestValueList()
    {
        return this.listaIdiomaDestValueList;
    }

    public void setListaIdiomaDestValueList(java.lang.Object[] listaIdiomaDestValueList)
    {
        this.listaIdiomaDestValueList = listaIdiomaDestValueList;
    }

    public java.lang.Object[] getListaIdiomaDestLabelList()
    {
        return this.listaIdiomaDestLabelList;
    }

    public void setListaIdiomaDestLabelList(java.lang.Object[] listaIdiomaDestLabelList)
    {
        this.listaIdiomaDestLabelList = listaIdiomaDestLabelList;
    }

    public void setListaIdiomaDestBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ImportarURLCUFormImpl.setListaIdiomaDestBackingList requires non-null property arguments");
        }

        this.listaIdiomaDestValueList = null;
        this.listaIdiomaDestLabelList = null;

        if (items != null)
        {
            this.listaIdiomaDestValueList = new java.lang.Object[items.size()];
            this.listaIdiomaDestLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listaIdiomaDestValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listaIdiomaDestLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ImportarURLCUFormImpl.setListaIdiomaDestBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ImportarURLCUFormImpl.setComentariosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ImportarURLCUFormImpl.setComentariosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipo</code>.
     */
    public void resetTipo()
    {
        this.tipo = null;
    }

    public void setTipo(java.lang.String tipo)
    {
        this.tipo = tipo;
    }

    /**
     * 
     */
    public java.lang.String getTipo()
    {
        return this.tipo;
    }
    
    public java.lang.Object[] getTipoBackingList()
    {
        java.lang.Object[] values = this.tipoValueList;
        java.lang.Object[] labels = this.tipoLabelList;

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

    public java.lang.Object[] getTipoValueList()
    {
        return this.tipoValueList;
    }

    public void setTipoValueList(java.lang.Object[] tipoValueList)
    {
        this.tipoValueList = tipoValueList;
    }

    public java.lang.Object[] getTipoLabelList()
    {
        return this.tipoLabelList;
    }

    public void setTipoLabelList(java.lang.Object[] tipoLabelList)
    {
        this.tipoLabelList = tipoLabelList;
    }

    public void setTipoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ImportarURLCUFormImpl.setTipoBackingList requires non-null property arguments");
        }

        this.tipoValueList = null;
        this.tipoLabelList = null;

        if (items != null)
        {
            this.tipoValueList = new java.lang.Object[items.size()];
            this.tipoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ImportarURLCUFormImpl.setTipoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listaIdiomas</code>.
     */
    public void resetListaIdiomas()
    {
        this.listaIdiomas = null;
    }

    public void setListaIdiomas(java.util.Collection listaIdiomas)
    {
        this.listaIdiomas = listaIdiomas;
    }

    /**
     * 
     */
    public java.util.Collection getListaIdiomas()
    {
        return this.listaIdiomas;
    }

    public void setListaIdiomasAsArray(Object[] listaIdiomas)
    {
        this.listaIdiomas = (listaIdiomas == null) ? null : java.util.Arrays.asList(listaIdiomas);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.gestorFlujo.presentacion.objetosPersonales.importarURL.ImportarURLCUFormImpl#getListaIdiomas
     */
    public java.lang.Object[] getListaIdiomasAsArray()
    {
        return (listaIdiomas == null) ? null : listaIdiomas.toArray();
    }
    
    public java.lang.Object[] getListaIdiomasBackingList()
    {
        java.lang.Object[] values = this.listaIdiomasValueList;
        java.lang.Object[] labels = this.listaIdiomasLabelList;

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

    public java.lang.Object[] getListaIdiomasValueList()
    {
        return this.listaIdiomasValueList;
    }

    public void setListaIdiomasValueList(java.lang.Object[] listaIdiomasValueList)
    {
        this.listaIdiomasValueList = listaIdiomasValueList;
    }

    public java.lang.Object[] getListaIdiomasLabelList()
    {
        return this.listaIdiomasLabelList;
    }

    public void setListaIdiomasLabelList(java.lang.Object[] listaIdiomasLabelList)
    {
        this.listaIdiomasLabelList = listaIdiomasLabelList;
    }

    public void setListaIdiomasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ImportarURLCUFormImpl.setListaIdiomasBackingList requires non-null property arguments");
        }

        this.listaIdiomasValueList = null;
        this.listaIdiomasLabelList = null;

        if (items != null)
        {
            this.listaIdiomasValueList = new java.lang.Object[items.size()];
            this.listaIdiomasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listaIdiomasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listaIdiomasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ImportarURLCUFormImpl.setListaIdiomasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>action</code>.
     */
    public void resetAction()
    {
        this.action = null;
    }

    public void setAction(java.lang.String action)
    {
        this.action = action;
    }

    /**
     * 
     */
    public java.lang.String getAction()
    {
        return this.action;
    }
    
    public java.lang.Object[] getActionBackingList()
    {
        java.lang.Object[] values = this.actionValueList;
        java.lang.Object[] labels = this.actionLabelList;

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

    public java.lang.Object[] getActionValueList()
    {
        return this.actionValueList;
    }

    public void setActionValueList(java.lang.Object[] actionValueList)
    {
        this.actionValueList = actionValueList;
    }

    public java.lang.Object[] getActionLabelList()
    {
        return this.actionLabelList;
    }

    public void setActionLabelList(java.lang.Object[] actionLabelList)
    {
        this.actionLabelList = actionLabelList;
    }

    public void setActionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ImportarURLCUFormImpl.setActionBackingList requires non-null property arguments");
        }

        this.actionValueList = null;
        this.actionLabelList = null;

        if (items != null)
        {
            this.actionValueList = new java.lang.Object[items.size()];
            this.actionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.actionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.actionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ImportarURLCUFormImpl.setActionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ImportarURLCUFormImpl.setIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ImportarURLCUFormImpl.setIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listaTipo</code>.
     */
    public void resetListaTipo()
    {
        this.listaTipo = null;
    }

    public void setListaTipo(java.util.Collection listaTipo)
    {
        this.listaTipo = listaTipo;
    }

    /**
     * 
     */
    public java.util.Collection getListaTipo()
    {
        return this.listaTipo;
    }

    public void setListaTipoAsArray(Object[] listaTipo)
    {
        this.listaTipo = (listaTipo == null) ? null : java.util.Arrays.asList(listaTipo);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.gestorFlujo.presentacion.objetosPersonales.importarURL.ImportarURLCUFormImpl#getListaTipo
     */
    public java.lang.Object[] getListaTipoAsArray()
    {
        return (listaTipo == null) ? null : listaTipo.toArray();
    }
    
    public java.lang.Object[] getListaTipoBackingList()
    {
        java.lang.Object[] values = this.listaTipoValueList;
        java.lang.Object[] labels = this.listaTipoLabelList;

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

    public java.lang.Object[] getListaTipoValueList()
    {
        return this.listaTipoValueList;
    }

    public void setListaTipoValueList(java.lang.Object[] listaTipoValueList)
    {
        this.listaTipoValueList = listaTipoValueList;
    }

    public java.lang.Object[] getListaTipoLabelList()
    {
        return this.listaTipoLabelList;
    }

    public void setListaTipoLabelList(java.lang.Object[] listaTipoLabelList)
    {
        this.listaTipoLabelList = listaTipoLabelList;
    }

    public void setListaTipoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ImportarURLCUFormImpl.setListaTipoBackingList requires non-null property arguments");
        }

        this.listaTipoValueList = null;
        this.listaTipoLabelList = null;

        if (items != null)
        {
            this.listaTipoValueList = new java.lang.Object[items.size()];
            this.listaTipoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listaTipoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listaTipoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ImportarURLCUFormImpl.setListaTipoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>url</code>.
     */
    public void resetUrl()
    {
        this.url = null;
    }

    public void setUrl(java.lang.String url)
    {
        this.url = url;
    }

    /**
     * 
     */
    public java.lang.String getUrl()
    {
        return this.url;
    }
    
    public java.lang.Object[] getUrlBackingList()
    {
        java.lang.Object[] values = this.urlValueList;
        java.lang.Object[] labels = this.urlLabelList;

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

    public java.lang.Object[] getUrlValueList()
    {
        return this.urlValueList;
    }

    public void setUrlValueList(java.lang.Object[] urlValueList)
    {
        this.urlValueList = urlValueList;
    }

    public java.lang.Object[] getUrlLabelList()
    {
        return this.urlLabelList;
    }

    public void setUrlLabelList(java.lang.Object[] urlLabelList)
    {
        this.urlLabelList = urlLabelList;
    }

    public void setUrlBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ImportarURLCUFormImpl.setUrlBackingList requires non-null property arguments");
        }

        this.urlValueList = null;
        this.urlLabelList = null;

        if (items != null)
        {
            this.urlValueList = new java.lang.Object[items.size()];
            this.urlLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.urlValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.urlLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ImportarURLCUFormImpl.setUrlBackingList encountered an exception", ex);
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
        builder.append("idiomaDestinatario", this.idiomaDestinatario);
        builder.append("titulo", this.titulo);
        builder.append("listaIdiomaDest", this.listaIdiomaDest);
        builder.append("comentarios", this.comentarios);
        builder.append("tipo", this.tipo);
        builder.append("listaIdiomas", this.listaIdiomas);
        builder.append("action", this.action);
        builder.append("idioma", this.idioma);
        builder.append("listaTipo", this.listaTipo);
        builder.append("url", this.url);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.idiomaDestinatario = null;
        this.idiomaDestinatarioValueList = null;
        this.idiomaDestinatarioLabelList = null;
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.listaIdiomaDest = null;
        this.listaIdiomaDestValueList = null;
        this.listaIdiomaDestLabelList = null;
        this.comentarios = null;
        this.comentariosValueList = null;
        this.comentariosLabelList = null;
        this.tipo = null;
        this.tipoValueList = null;
        this.tipoLabelList = null;
        this.listaIdiomas = null;
        this.listaIdiomasValueList = null;
        this.listaIdiomasLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.listaTipo = null;
        this.listaTipoValueList = null;
        this.listaTipoLabelList = null;
        this.url = null;
        this.urlValueList = null;
        this.urlLabelList = null;
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
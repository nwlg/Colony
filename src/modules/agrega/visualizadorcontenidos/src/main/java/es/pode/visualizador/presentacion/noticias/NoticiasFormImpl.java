// license-header java merge-point
package es.pode.visualizador.presentacion.noticias;

public class NoticiasFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.visualizador.presentacion.noticias.ObtenerNoticiasForm
{
    private java.lang.Long id;
    private java.lang.Object[] idValueList;
    private java.lang.Object[] idLabelList;
    private java.lang.Long idCategoria;
    private java.lang.Object[] idCategoriaValueList;
    private java.lang.Object[] idCategoriaLabelList;
    private java.lang.String categoria;
    private java.lang.Object[] categoriaValueList;
    private java.lang.Object[] categoriaLabelList;
    private es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO categoriaVO;
    private java.lang.Object[] categoriaVOValueList;
    private java.lang.Object[] categoriaVOLabelList;
    private java.util.Collection noticias = null;
    private java.lang.Object[] noticiasValueList;
    private java.lang.Object[] noticiasLabelList;

    public NoticiasFormImpl()
    {
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
            throw new IllegalArgumentException("NoticiasFormImpl.setIdBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("NoticiasFormImpl.setIdBackingList encountered an exception", ex);
            }
        }
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
            throw new IllegalArgumentException("NoticiasFormImpl.setIdCategoriaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("NoticiasFormImpl.setIdCategoriaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("NoticiasFormImpl.setCategoriaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("NoticiasFormImpl.setCategoriaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>categoriaVO</code>.
     */
    public void resetCategoriaVO()
    {
        this.categoriaVO = null;
    }

    public void setCategoriaVO(es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO categoriaVO)
    {
        this.categoriaVO = categoriaVO;
    }

    /**
     * 
     */
    public es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO getCategoriaVO()
    {
        return this.categoriaVO;
    }
    
    public java.lang.Object[] getCategoriaVOBackingList()
    {
        java.lang.Object[] values = this.categoriaVOValueList;
        java.lang.Object[] labels = this.categoriaVOLabelList;

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

    public java.lang.Object[] getCategoriaVOValueList()
    {
        return this.categoriaVOValueList;
    }

    public void setCategoriaVOValueList(java.lang.Object[] categoriaVOValueList)
    {
        this.categoriaVOValueList = categoriaVOValueList;
    }

    public java.lang.Object[] getCategoriaVOLabelList()
    {
        return this.categoriaVOLabelList;
    }

    public void setCategoriaVOLabelList(java.lang.Object[] categoriaVOLabelList)
    {
        this.categoriaVOLabelList = categoriaVOLabelList;
    }

    public void setCategoriaVOBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NoticiasFormImpl.setCategoriaVOBackingList requires non-null property arguments");
        }

        this.categoriaVOValueList = null;
        this.categoriaVOLabelList = null;

        if (items != null)
        {
            this.categoriaVOValueList = new java.lang.Object[items.size()];
            this.categoriaVOLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.categoriaVOValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.categoriaVOLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NoticiasFormImpl.setCategoriaVOBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>noticias</code>.
     */
    public void resetNoticias()
    {
        this.noticias = null;
    }

    public void setNoticias(java.util.Collection noticias)
    {
        this.noticias = noticias;
    }

    /**
     * 
     */
    public java.util.Collection getNoticias()
    {
        return this.noticias;
    }

    public void setNoticiasAsArray(Object[] noticias)
    {
        this.noticias = (noticias == null) ? null : java.util.Arrays.asList(noticias);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.visualizador.presentacion.noticias.NoticiasFormImpl#getNoticias
     */
    public java.lang.Object[] getNoticiasAsArray()
    {
        return (noticias == null) ? null : noticias.toArray();
    }
    
    public java.lang.Object[] getNoticiasBackingList()
    {
        java.lang.Object[] values = this.noticiasValueList;
        java.lang.Object[] labels = this.noticiasLabelList;

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

    public java.lang.Object[] getNoticiasValueList()
    {
        return this.noticiasValueList;
    }

    public void setNoticiasValueList(java.lang.Object[] noticiasValueList)
    {
        this.noticiasValueList = noticiasValueList;
    }

    public java.lang.Object[] getNoticiasLabelList()
    {
        return this.noticiasLabelList;
    }

    public void setNoticiasLabelList(java.lang.Object[] noticiasLabelList)
    {
        this.noticiasLabelList = noticiasLabelList;
    }

    public void setNoticiasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("NoticiasFormImpl.setNoticiasBackingList requires non-null property arguments");
        }

        this.noticiasValueList = null;
        this.noticiasLabelList = null;

        if (items != null)
        {
            this.noticiasValueList = new java.lang.Object[items.size()];
            this.noticiasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.noticiasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.noticiasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("NoticiasFormImpl.setNoticiasBackingList encountered an exception", ex);
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
        builder.append("id", this.id);
        builder.append("idCategoria", this.idCategoria);
        builder.append("categoria", this.categoria);
        builder.append("categoriaVO", this.categoriaVO);
        builder.append("noticias", this.noticias);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.id = null;
        this.idValueList = null;
        this.idLabelList = null;
        this.idCategoria = null;
        this.idCategoriaValueList = null;
        this.idCategoriaLabelList = null;
        this.categoria = null;
        this.categoriaValueList = null;
        this.categoriaLabelList = null;
        this.categoriaVO = null;
        this.categoriaVOValueList = null;
        this.categoriaVOLabelList = null;
        this.noticias = null;
        this.noticiasValueList = null;
        this.noticiasLabelList = null;
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
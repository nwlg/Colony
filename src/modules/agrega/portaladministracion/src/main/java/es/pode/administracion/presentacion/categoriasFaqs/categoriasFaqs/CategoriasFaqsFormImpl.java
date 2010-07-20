// license-header java merge-point
package es.pode.administracion.presentacion.categoriasFaqs.categoriasFaqs;

public class CategoriasFaqsFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.categoriasFaqs.categoriasFaqs.ObtenerCategoriasFaqsForm
{
    private java.lang.Long id;
    private java.lang.Object[] idValueList;
    private java.lang.Object[] idLabelList;
    private java.lang.Long idModificado;
    private java.lang.Object[] idModificadoValueList;
    private java.lang.Object[] idModificadoLabelList;
    private java.util.Collection categorias = null;
    private java.lang.Object[] categoriasValueList;
    private java.lang.Object[] categoriasLabelList;

    public CategoriasFaqsFormImpl()
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
            throw new IllegalArgumentException("CategoriasFaqsFormImpl.setIdBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CategoriasFaqsFormImpl.setIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idModificado</code>.
     */
    public void resetIdModificado()
    {
        this.idModificado = null;
    }

    public void setIdModificado(java.lang.Long idModificado)
    {
        this.idModificado = idModificado;
    }

    /**
     * 
     */
    public java.lang.Long getIdModificado()
    {
        return this.idModificado;
    }
    
    public java.lang.Object[] getIdModificadoBackingList()
    {
        java.lang.Object[] values = this.idModificadoValueList;
        java.lang.Object[] labels = this.idModificadoLabelList;

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

    public java.lang.Object[] getIdModificadoValueList()
    {
        return this.idModificadoValueList;
    }

    public void setIdModificadoValueList(java.lang.Object[] idModificadoValueList)
    {
        this.idModificadoValueList = idModificadoValueList;
    }

    public java.lang.Object[] getIdModificadoLabelList()
    {
        return this.idModificadoLabelList;
    }

    public void setIdModificadoLabelList(java.lang.Object[] idModificadoLabelList)
    {
        this.idModificadoLabelList = idModificadoLabelList;
    }

    public void setIdModificadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFaqsFormImpl.setIdModificadoBackingList requires non-null property arguments");
        }

        this.idModificadoValueList = null;
        this.idModificadoLabelList = null;

        if (items != null)
        {
            this.idModificadoValueList = new java.lang.Object[items.size()];
            this.idModificadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idModificadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idModificadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFaqsFormImpl.setIdModificadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>categorias</code>.
     */
    public void resetCategorias()
    {
        this.categorias = null;
    }

    public void setCategorias(java.util.Collection categorias)
    {
        this.categorias = categorias;
    }

    /**
     * 
     */
    public java.util.Collection getCategorias()
    {
        return this.categorias;
    }

    public void setCategoriasAsArray(Object[] categorias)
    {
        this.categorias = (categorias == null) ? null : java.util.Arrays.asList(categorias);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.categoriasFaqs.categoriasFaqs.CategoriasFaqsFormImpl#getCategorias
     */
    public java.lang.Object[] getCategoriasAsArray()
    {
        return (categorias == null) ? null : categorias.toArray();
    }
    
    public java.lang.Object[] getCategoriasBackingList()
    {
        java.lang.Object[] values = this.categoriasValueList;
        java.lang.Object[] labels = this.categoriasLabelList;

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

    public java.lang.Object[] getCategoriasValueList()
    {
        return this.categoriasValueList;
    }

    public void setCategoriasValueList(java.lang.Object[] categoriasValueList)
    {
        this.categoriasValueList = categoriasValueList;
    }

    public java.lang.Object[] getCategoriasLabelList()
    {
        return this.categoriasLabelList;
    }

    public void setCategoriasLabelList(java.lang.Object[] categoriasLabelList)
    {
        this.categoriasLabelList = categoriasLabelList;
    }

    public void setCategoriasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasFaqsFormImpl.setCategoriasBackingList requires non-null property arguments");
        }

        this.categoriasValueList = null;
        this.categoriasLabelList = null;

        if (items != null)
        {
            this.categoriasValueList = new java.lang.Object[items.size()];
            this.categoriasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.categoriasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.categoriasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasFaqsFormImpl.setCategoriasBackingList encountered an exception", ex);
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
        builder.append("idModificado", this.idModificado);
        builder.append("categorias", this.categorias);
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
        this.idModificado = null;
        this.idModificadoValueList = null;
        this.idModificadoLabelList = null;
        this.categorias = null;
        this.categoriasValueList = null;
        this.categoriasLabelList = null;
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
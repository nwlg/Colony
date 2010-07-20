// license-header java merge-point
package es.pode.administracion.presentacion.categorias.categorias;

public class CategoriasNoticiasCUFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.categorias.categorias.ObtenerCategoriasNoticiasForm
{
    private java.util.List idCategoriaNoticiaRowSelection = null;
    private java.lang.Object[] idCategoriaNoticiaValueList;
    private java.lang.Object[] idCategoriaNoticiaLabelList;
    private java.lang.Long idModificado;
    private java.lang.Object[] idModificadoValueList;
    private java.lang.Object[] idModificadoLabelList;
    private java.util.Collection categoriasNoticias = null;
    private java.lang.Object[] categoriasNoticiasValueList;
    private java.lang.Object[] categoriasNoticiasLabelList;

    public CategoriasNoticiasCUFormImpl()
    {
    }

    /**
     * Resets the given <code>idCategoriaNoticiaRowSelection</code>.
     */
    public void resetIdCategoriaNoticia()
    {
        this.idCategoriaNoticiaRowSelection = null;
    }

    public void setIdCategoriaNoticiaRowSelection(java.util.List idCategoriaNoticiaRowSelection)
    {
        this.idCategoriaNoticiaRowSelection = idCategoriaNoticiaRowSelection;
    }

    public java.util.List getIdCategoriaNoticiaRowSelection()
    {
        return this.idCategoriaNoticiaRowSelection;
    }

    public void setIdCategoriaNoticiaRowSelectionAsArray(java.lang.String[] idCategoriaNoticiaRowSelection)
    {
        this.idCategoriaNoticiaRowSelection = (idCategoriaNoticiaRowSelection == null) ? null : java.util.Arrays.asList(idCategoriaNoticiaRowSelection);
    }

    public java.lang.String[] getIdCategoriaNoticiaRowSelectionAsArray()
    {
        return (idCategoriaNoticiaRowSelection == null) ? null : (java.lang.String[])idCategoriaNoticiaRowSelection.toArray(new java.lang.String[idCategoriaNoticiaRowSelection.size()]);
    }

    public java.lang.Object[] getIdCategoriaNoticiaBackingList()
    {
        java.lang.Object[] values = this.idCategoriaNoticiaValueList;
        java.lang.Object[] labels = this.idCategoriaNoticiaLabelList;

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

    public java.lang.Object[] getIdCategoriaNoticiaValueList()
    {
        return this.idCategoriaNoticiaValueList;
    }

    public void setIdCategoriaNoticiaValueList(java.lang.Object[] idCategoriaNoticiaValueList)
    {
        this.idCategoriaNoticiaValueList = idCategoriaNoticiaValueList;
    }

    public java.lang.Object[] getIdCategoriaNoticiaLabelList()
    {
        return this.idCategoriaNoticiaLabelList;
    }

    public void setIdCategoriaNoticiaLabelList(java.lang.Object[] idCategoriaNoticiaLabelList)
    {
        this.idCategoriaNoticiaLabelList = idCategoriaNoticiaLabelList;
    }

    public void setIdCategoriaNoticiaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasNoticiasCUFormImpl.setIdCategoriaNoticiaBackingList requires non-null property arguments");
        }

        this.idCategoriaNoticiaValueList = null;
        this.idCategoriaNoticiaLabelList = null;

        if (items != null)
        {
            this.idCategoriaNoticiaValueList = new java.lang.Object[items.size()];
            this.idCategoriaNoticiaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idCategoriaNoticiaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idCategoriaNoticiaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasNoticiasCUFormImpl.setIdCategoriaNoticiaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CategoriasNoticiasCUFormImpl.setIdModificadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CategoriasNoticiasCUFormImpl.setIdModificadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>categoriasNoticias</code>.
     */
    public void resetCategoriasNoticias()
    {
        this.categoriasNoticias = null;
    }

    public void setCategoriasNoticias(java.util.Collection categoriasNoticias)
    {
        this.categoriasNoticias = categoriasNoticias;
    }

    /**
     * 
     */
    public java.util.Collection getCategoriasNoticias()
    {
        return this.categoriasNoticias;
    }

    public void setCategoriasNoticiasAsArray(Object[] categoriasNoticias)
    {
        this.categoriasNoticias = (categoriasNoticias == null) ? null : java.util.Arrays.asList(categoriasNoticias);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.categorias.categorias.CategoriasNoticiasCUFormImpl#getCategoriasNoticias
     */
    public java.lang.Object[] getCategoriasNoticiasAsArray()
    {
        return (categoriasNoticias == null) ? null : categoriasNoticias.toArray();
    }
    
    public java.lang.Object[] getCategoriasNoticiasBackingList()
    {
        java.lang.Object[] values = this.categoriasNoticiasValueList;
        java.lang.Object[] labels = this.categoriasNoticiasLabelList;

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

    public java.lang.Object[] getCategoriasNoticiasValueList()
    {
        return this.categoriasNoticiasValueList;
    }

    public void setCategoriasNoticiasValueList(java.lang.Object[] categoriasNoticiasValueList)
    {
        this.categoriasNoticiasValueList = categoriasNoticiasValueList;
    }

    public java.lang.Object[] getCategoriasNoticiasLabelList()
    {
        return this.categoriasNoticiasLabelList;
    }

    public void setCategoriasNoticiasLabelList(java.lang.Object[] categoriasNoticiasLabelList)
    {
        this.categoriasNoticiasLabelList = categoriasNoticiasLabelList;
    }

    public void setCategoriasNoticiasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CategoriasNoticiasCUFormImpl.setCategoriasNoticiasBackingList requires non-null property arguments");
        }

        this.categoriasNoticiasValueList = null;
        this.categoriasNoticiasLabelList = null;

        if (items != null)
        {
            this.categoriasNoticiasValueList = new java.lang.Object[items.size()];
            this.categoriasNoticiasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.categoriasNoticiasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.categoriasNoticiasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CategoriasNoticiasCUFormImpl.setCategoriasNoticiasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.idCategoriaNoticiaRowSelection = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("idCategoriaNoticiaRowSelection", this.idCategoriaNoticiaRowSelection);
        builder.append("idModificado", this.idModificado);
        builder.append("categoriasNoticias", this.categoriasNoticias);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.idCategoriaNoticiaRowSelection = null;
        this.idModificado = null;
        this.idModificadoValueList = null;
        this.idModificadoLabelList = null;
        this.categoriasNoticias = null;
        this.categoriasNoticiasValueList = null;
        this.categoriasNoticiasLabelList = null;
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
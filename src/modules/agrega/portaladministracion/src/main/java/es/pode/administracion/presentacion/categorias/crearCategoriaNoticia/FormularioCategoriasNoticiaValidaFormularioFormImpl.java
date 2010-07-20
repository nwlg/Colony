// license-header java merge-point
package es.pode.administracion.presentacion.categorias.crearCategoriaNoticia;

public class FormularioCategoriasNoticiaValidaFormularioFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.GuardarCategoriaNoticiaForm
        , es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.RecuperarDatosForm
        , es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.ValidarFormularioForm
        , es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.AnalizaValidacionForm
{
    private java.util.Collection nombreCategoria;
    private java.lang.Object[] nombreCategoriaValueList;
    private java.lang.Object[] nombreCategoriaLabelList;
    private java.util.Collection idiomas;
    private java.lang.Object[] idiomasValueList;
    private java.lang.Object[] idiomasLabelList;
    private java.lang.String valido;
    private java.lang.Object[] validoValueList;
    private java.lang.Object[] validoLabelList;
    private java.lang.Long idModificado;
    private java.lang.Object[] idModificadoValueList;
    private java.lang.Object[] idModificadoLabelList;

    public FormularioCategoriasNoticiaValidaFormularioFormImpl()
    {
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
     * @see es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.FormularioCategoriasNoticiaValidaFormularioFormImpl#getNombreCategoria
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
            throw new IllegalArgumentException("FormularioCategoriasNoticiaValidaFormularioFormImpl.setNombreCategoriaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioCategoriasNoticiaValidaFormularioFormImpl.setNombreCategoriaBackingList encountered an exception", ex);
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
     * @see es.pode.administracion.presentacion.categorias.crearCategoriaNoticia.FormularioCategoriasNoticiaValidaFormularioFormImpl#getIdiomas
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
            throw new IllegalArgumentException("FormularioCategoriasNoticiaValidaFormularioFormImpl.setIdiomasBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioCategoriasNoticiaValidaFormularioFormImpl.setIdiomasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>valido</code>.
     */
    public void resetValido()
    {
        this.valido = null;
    }

    public void setValido(java.lang.String valido)
    {
        this.valido = valido;
    }

    /**
     * 
     */
    public java.lang.String getValido()
    {
        return this.valido;
    }
    
    public java.lang.Object[] getValidoBackingList()
    {
        java.lang.Object[] values = this.validoValueList;
        java.lang.Object[] labels = this.validoLabelList;

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

    public java.lang.Object[] getValidoValueList()
    {
        return this.validoValueList;
    }

    public void setValidoValueList(java.lang.Object[] validoValueList)
    {
        this.validoValueList = validoValueList;
    }

    public java.lang.Object[] getValidoLabelList()
    {
        return this.validoLabelList;
    }

    public void setValidoLabelList(java.lang.Object[] validoLabelList)
    {
        this.validoLabelList = validoLabelList;
    }

    public void setValidoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioCategoriasNoticiaValidaFormularioFormImpl.setValidoBackingList requires non-null property arguments");
        }

        this.validoValueList = null;
        this.validoLabelList = null;

        if (items != null)
        {
            this.validoValueList = new java.lang.Object[items.size()];
            this.validoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.validoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.validoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioCategoriasNoticiaValidaFormularioFormImpl.setValidoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioCategoriasNoticiaValidaFormularioFormImpl.setIdModificadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioCategoriasNoticiaValidaFormularioFormImpl.setIdModificadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.nombreCategoria = null;
        this.nombreCategoriaValueList = new java.lang.Object[0];
        this.nombreCategoriaLabelList = new java.lang.Object[0];
        this.idiomas = null;
        this.idiomasValueList = new java.lang.Object[0];
        this.idiomasLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("nombreCategoria", this.nombreCategoria);
        builder.append("idiomas", this.idiomas);
        builder.append("valido", this.valido);
        builder.append("idModificado", this.idModificado);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.nombreCategoria = null;
        this.nombreCategoriaValueList = null;
        this.nombreCategoriaLabelList = null;
        this.idiomas = null;
        this.idiomasValueList = null;
        this.idiomasLabelList = null;
        this.valido = null;
        this.validoValueList = null;
        this.validoLabelList = null;
        this.idModificado = null;
        this.idModificadoValueList = null;
        this.idModificadoLabelList = null;
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
// license-header java merge-point
package es.pode.visualizador.presentacion.faqs;

public class FaqsFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.visualizador.presentacion.faqs.CargaFaqsForm
{
    private java.lang.Long categoriaSeleccionada;
    private java.lang.Object[] categoriaSeleccionadaValueList;
    private java.lang.Object[] categoriaSeleccionadaLabelList;
    private es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaVO[] faqs;
    private java.lang.Object[] faqsValueList;
    private java.lang.Object[] faqsLabelList;
    private java.util.Collection categorias;
    private java.lang.Object[] categoriasValueList;
    private java.lang.Object[] categoriasLabelList;

    public FaqsFormImpl()
    {
    }

    /**
     * Resets the given <code>categoriaSeleccionada</code>.
     */
    public void resetCategoriaSeleccionada()
    {
        this.categoriaSeleccionada = null;
    }

    public void setCategoriaSeleccionada(java.lang.Long categoriaSeleccionada)
    {
        this.categoriaSeleccionada = categoriaSeleccionada;
    }

    /**
     * <p>
     * el indice en la coleccion categorias de lla categoria que
     * estamos viendo
     * </p>
     */
    public java.lang.Long getCategoriaSeleccionada()
    {
        return this.categoriaSeleccionada;
    }
    
    public java.lang.Object[] getCategoriaSeleccionadaBackingList()
    {
        java.lang.Object[] values = this.categoriaSeleccionadaValueList;
        java.lang.Object[] labels = this.categoriaSeleccionadaLabelList;

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

    public java.lang.Object[] getCategoriaSeleccionadaValueList()
    {
        return this.categoriaSeleccionadaValueList;
    }

    public void setCategoriaSeleccionadaValueList(java.lang.Object[] categoriaSeleccionadaValueList)
    {
        this.categoriaSeleccionadaValueList = categoriaSeleccionadaValueList;
    }

    public java.lang.Object[] getCategoriaSeleccionadaLabelList()
    {
        return this.categoriaSeleccionadaLabelList;
    }

    public void setCategoriaSeleccionadaLabelList(java.lang.Object[] categoriaSeleccionadaLabelList)
    {
        this.categoriaSeleccionadaLabelList = categoriaSeleccionadaLabelList;
    }

    public void setCategoriaSeleccionadaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FaqsFormImpl.setCategoriaSeleccionadaBackingList requires non-null property arguments");
        }

        this.categoriaSeleccionadaValueList = null;
        this.categoriaSeleccionadaLabelList = null;

        if (items != null)
        {
            this.categoriaSeleccionadaValueList = new java.lang.Object[items.size()];
            this.categoriaSeleccionadaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.categoriaSeleccionadaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.categoriaSeleccionadaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FaqsFormImpl.setCategoriaSeleccionadaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>faqs</code>.
     */
    public void resetFaqs()
    {
        this.faqs = null;
    }

    public void setFaqs(es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaVO[] faqs)
    {
        this.faqs = faqs;
    }

    /**
     * 
     */
    public es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaVO[] getFaqs()
    {
        return this.faqs;
    }
    
    public java.lang.Object[] getFaqsBackingList()
    {
        java.lang.Object[] values = this.faqsValueList;
        java.lang.Object[] labels = this.faqsLabelList;

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

    public java.lang.Object[] getFaqsValueList()
    {
        return this.faqsValueList;
    }

    public void setFaqsValueList(java.lang.Object[] faqsValueList)
    {
        this.faqsValueList = faqsValueList;
    }

    public java.lang.Object[] getFaqsLabelList()
    {
        return this.faqsLabelList;
    }

    public void setFaqsLabelList(java.lang.Object[] faqsLabelList)
    {
        this.faqsLabelList = faqsLabelList;
    }

    public void setFaqsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FaqsFormImpl.setFaqsBackingList requires non-null property arguments");
        }

        this.faqsValueList = null;
        this.faqsLabelList = null;

        if (items != null)
        {
            this.faqsValueList = new java.lang.Object[items.size()];
            this.faqsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.faqsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.faqsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FaqsFormImpl.setFaqsBackingList encountered an exception", ex);
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
     * <p>
     * las categorias disponibles que hay
     * </p>
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
     * @see es.pode.visualizador.presentacion.faqs.FaqsFormImpl#getCategorias
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
            throw new IllegalArgumentException("FaqsFormImpl.setCategoriasBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FaqsFormImpl.setCategoriasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.faqs = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("categoriaSeleccionada", this.categoriaSeleccionada);
        builder.append("faqs", this.faqs);
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
        this.categoriaSeleccionada = null;
        this.categoriaSeleccionadaValueList = null;
        this.categoriaSeleccionadaLabelList = null;
        this.faqs = null;
        this.faqsValueList = null;
        this.faqsLabelList = null;
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
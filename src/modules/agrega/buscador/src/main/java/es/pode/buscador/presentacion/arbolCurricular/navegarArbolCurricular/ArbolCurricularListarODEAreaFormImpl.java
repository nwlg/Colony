// license-header java merge-point
package es.pode.buscador.presentacion.arbolCurricular.navegarArbolCurricular;

public class ArbolCurricularListarODEAreaFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
    private java.lang.Integer numMaxResultados;
    private java.lang.Object[] numMaxResultadosValueList;
    private java.lang.Object[] numMaxResultadosLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.lang.String areaCurricularBusqueda;
    private java.lang.Object[] areaCurricularBusquedaValueList;
    private java.lang.Object[] areaCurricularBusquedaLabelList;
    private java.util.Collection rutaArbol;
    private java.lang.Object[] rutaArbolValueList;
    private java.lang.Object[] rutaArbolLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;

    public ArbolCurricularListarODEAreaFormImpl()
    {
    }

    /**
     * Resets the given <code>numMaxResultados</code>.
     */
    public void resetNumMaxResultados()
    {
        this.numMaxResultados = null;
    }

    public void setNumMaxResultados(java.lang.Integer numMaxResultados)
    {
        this.numMaxResultados = numMaxResultados;
    }

    /**
     * 
     */
    public java.lang.Integer getNumMaxResultados()
    {
        return this.numMaxResultados;
    }
    
    public java.lang.Object[] getNumMaxResultadosBackingList()
    {
        java.lang.Object[] values = this.numMaxResultadosValueList;
        java.lang.Object[] labels = this.numMaxResultadosLabelList;

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

    public java.lang.Object[] getNumMaxResultadosValueList()
    {
        return this.numMaxResultadosValueList;
    }

    public void setNumMaxResultadosValueList(java.lang.Object[] numMaxResultadosValueList)
    {
        this.numMaxResultadosValueList = numMaxResultadosValueList;
    }

    public java.lang.Object[] getNumMaxResultadosLabelList()
    {
        return this.numMaxResultadosLabelList;
    }

    public void setNumMaxResultadosLabelList(java.lang.Object[] numMaxResultadosLabelList)
    {
        this.numMaxResultadosLabelList = numMaxResultadosLabelList;
    }

    public void setNumMaxResultadosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ArbolCurricularListarODEAreaFormImpl.setNumMaxResultadosBackingList requires non-null property arguments");
        }

        this.numMaxResultadosValueList = null;
        this.numMaxResultadosLabelList = null;

        if (items != null)
        {
            this.numMaxResultadosValueList = new java.lang.Object[items.size()];
            this.numMaxResultadosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.numMaxResultadosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.numMaxResultadosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ArbolCurricularListarODEAreaFormImpl.setNumMaxResultadosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ArbolCurricularListarODEAreaFormImpl.setIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ArbolCurricularListarODEAreaFormImpl.setIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>areaCurricularBusqueda</code>.
     */
    public void resetAreaCurricularBusqueda()
    {
        this.areaCurricularBusqueda = null;
    }

    public void setAreaCurricularBusqueda(java.lang.String areaCurricularBusqueda)
    {
        this.areaCurricularBusqueda = areaCurricularBusqueda;
    }

    /**
     * 
     */
    public java.lang.String getAreaCurricularBusqueda()
    {
        return this.areaCurricularBusqueda;
    }
    
    public java.lang.Object[] getAreaCurricularBusquedaBackingList()
    {
        java.lang.Object[] values = this.areaCurricularBusquedaValueList;
        java.lang.Object[] labels = this.areaCurricularBusquedaLabelList;

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

    public java.lang.Object[] getAreaCurricularBusquedaValueList()
    {
        return this.areaCurricularBusquedaValueList;
    }

    public void setAreaCurricularBusquedaValueList(java.lang.Object[] areaCurricularBusquedaValueList)
    {
        this.areaCurricularBusquedaValueList = areaCurricularBusquedaValueList;
    }

    public java.lang.Object[] getAreaCurricularBusquedaLabelList()
    {
        return this.areaCurricularBusquedaLabelList;
    }

    public void setAreaCurricularBusquedaLabelList(java.lang.Object[] areaCurricularBusquedaLabelList)
    {
        this.areaCurricularBusquedaLabelList = areaCurricularBusquedaLabelList;
    }

    public void setAreaCurricularBusquedaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ArbolCurricularListarODEAreaFormImpl.setAreaCurricularBusquedaBackingList requires non-null property arguments");
        }

        this.areaCurricularBusquedaValueList = null;
        this.areaCurricularBusquedaLabelList = null;

        if (items != null)
        {
            this.areaCurricularBusquedaValueList = new java.lang.Object[items.size()];
            this.areaCurricularBusquedaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.areaCurricularBusquedaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.areaCurricularBusquedaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ArbolCurricularListarODEAreaFormImpl.setAreaCurricularBusquedaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>rutaArbol</code>.
     */
    public void resetRutaArbol()
    {
        this.rutaArbol = null;
    }

    public void setRutaArbol(java.util.Collection rutaArbol)
    {
        this.rutaArbol = rutaArbol;
    }

    /**
     * 
     */
    public java.util.Collection getRutaArbol()
    {
        return this.rutaArbol;
    }

    public void setRutaArbolAsArray(Object[] rutaArbol)
    {
        this.rutaArbol = (rutaArbol == null) ? null : java.util.Arrays.asList(rutaArbol);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.buscador.presentacion.arbolCurricular.navegarArbolCurricular.ArbolCurricularListarODEAreaFormImpl#getRutaArbol
     */
    public java.lang.Object[] getRutaArbolAsArray()
    {
        return (rutaArbol == null) ? null : rutaArbol.toArray();
    }
    
    public java.lang.Object[] getRutaArbolBackingList()
    {
        java.lang.Object[] values = this.rutaArbolValueList;
        java.lang.Object[] labels = this.rutaArbolLabelList;

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

    public java.lang.Object[] getRutaArbolValueList()
    {
        return this.rutaArbolValueList;
    }

    public void setRutaArbolValueList(java.lang.Object[] rutaArbolValueList)
    {
        this.rutaArbolValueList = rutaArbolValueList;
    }

    public java.lang.Object[] getRutaArbolLabelList()
    {
        return this.rutaArbolLabelList;
    }

    public void setRutaArbolLabelList(java.lang.Object[] rutaArbolLabelList)
    {
        this.rutaArbolLabelList = rutaArbolLabelList;
    }

    public void setRutaArbolBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ArbolCurricularListarODEAreaFormImpl.setRutaArbolBackingList requires non-null property arguments");
        }

        this.rutaArbolValueList = null;
        this.rutaArbolLabelList = null;

        if (items != null)
        {
            this.rutaArbolValueList = new java.lang.Object[items.size()];
            this.rutaArbolLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.rutaArbolValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.rutaArbolLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ArbolCurricularListarODEAreaFormImpl.setRutaArbolBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomaBuscador</code>.
     */
    public void resetIdiomaBuscador()
    {
        this.idiomaBuscador = null;
    }

    public void setIdiomaBuscador(java.lang.String idiomaBuscador)
    {
        this.idiomaBuscador = idiomaBuscador;
    }

    /**
     * 
     */
    public java.lang.String getIdiomaBuscador()
    {
        return this.idiomaBuscador;
    }
    
    public java.lang.Object[] getIdiomaBuscadorBackingList()
    {
        java.lang.Object[] values = this.idiomaBuscadorValueList;
        java.lang.Object[] labels = this.idiomaBuscadorLabelList;

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

    public java.lang.Object[] getIdiomaBuscadorValueList()
    {
        return this.idiomaBuscadorValueList;
    }

    public void setIdiomaBuscadorValueList(java.lang.Object[] idiomaBuscadorValueList)
    {
        this.idiomaBuscadorValueList = idiomaBuscadorValueList;
    }

    public java.lang.Object[] getIdiomaBuscadorLabelList()
    {
        return this.idiomaBuscadorLabelList;
    }

    public void setIdiomaBuscadorLabelList(java.lang.Object[] idiomaBuscadorLabelList)
    {
        this.idiomaBuscadorLabelList = idiomaBuscadorLabelList;
    }

    public void setIdiomaBuscadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ArbolCurricularListarODEAreaFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
        }

        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;

        if (items != null)
        {
            this.idiomaBuscadorValueList = new java.lang.Object[items.size()];
            this.idiomaBuscadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomaBuscadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomaBuscadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ArbolCurricularListarODEAreaFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.rutaArbol = null;
        this.rutaArbolValueList = new java.lang.Object[0];
        this.rutaArbolLabelList = new java.lang.Object[0];
        this.idiomaBuscador = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("numMaxResultados", this.numMaxResultados);
        builder.append("idioma", this.idioma);
        builder.append("areaCurricularBusqueda", this.areaCurricularBusqueda);
        builder.append("rutaArbol", this.rutaArbol);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.numMaxResultados = null;
        this.numMaxResultadosValueList = null;
        this.numMaxResultadosLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.areaCurricularBusqueda = null;
        this.areaCurricularBusquedaValueList = null;
        this.areaCurricularBusquedaLabelList = null;
        this.rutaArbol = null;
        this.rutaArbolValueList = null;
        this.rutaArbolLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
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
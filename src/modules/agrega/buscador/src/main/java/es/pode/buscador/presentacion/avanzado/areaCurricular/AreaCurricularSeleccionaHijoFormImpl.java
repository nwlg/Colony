// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.areaCurricular;

public class AreaCurricularSeleccionaHijoFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.buscador.presentacion.avanzado.areaCurricular.ObtenerAreasCurricularesForm
{
    private java.lang.String areaCurricular;
    private java.lang.Object[] areaCurricularValueList;
    private java.lang.Object[] areaCurricularLabelList;
    private java.lang.String id;
    private java.lang.Object[] idValueList;
    private java.lang.Object[] idLabelList;
    private java.util.Collection nodos;
    private java.lang.Object[] nodosValueList;
    private java.lang.Object[] nodosLabelList;
    private java.util.Collection rutaArbol;
    private java.lang.Object[] rutaArbolValueList;
    private java.lang.Object[] rutaArbolLabelList;
    private java.lang.String tipoLayoutBuscador;
    private java.lang.Object[] tipoLayoutBuscadorValueList;
    private java.lang.Object[] tipoLayoutBuscadorLabelList;
    private java.lang.Boolean buscadorEmpaquetador;
    private java.lang.Object[] buscadorEmpaquetadorValueList;
    private java.lang.Object[] buscadorEmpaquetadorLabelList;

    public AreaCurricularSeleccionaHijoFormImpl()
    {
    }

    /**
     * Resets the given <code>areaCurricular</code>.
     */
    public void resetAreaCurricular()
    {
        this.areaCurricular = null;
    }

    public void setAreaCurricular(java.lang.String areaCurricular)
    {
        this.areaCurricular = areaCurricular;
    }

    /**
     * <p>
     * Se trata de la cadena de indices dentro de una rama de area
     * curricular que se ha seleccionado desde la pantalla.
     * </p>
     */
    public java.lang.String getAreaCurricular()
    {
        return this.areaCurricular;
    }
    
    public java.lang.Object[] getAreaCurricularBackingList()
    {
        java.lang.Object[] values = this.areaCurricularValueList;
        java.lang.Object[] labels = this.areaCurricularLabelList;

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

    public java.lang.Object[] getAreaCurricularValueList()
    {
        return this.areaCurricularValueList;
    }

    public void setAreaCurricularValueList(java.lang.Object[] areaCurricularValueList)
    {
        this.areaCurricularValueList = areaCurricularValueList;
    }

    public java.lang.Object[] getAreaCurricularLabelList()
    {
        return this.areaCurricularLabelList;
    }

    public void setAreaCurricularLabelList(java.lang.Object[] areaCurricularLabelList)
    {
        this.areaCurricularLabelList = areaCurricularLabelList;
    }

    public void setAreaCurricularBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AreaCurricularSeleccionaHijoFormImpl.setAreaCurricularBackingList requires non-null property arguments");
        }

        this.areaCurricularValueList = null;
        this.areaCurricularLabelList = null;

        if (items != null)
        {
            this.areaCurricularValueList = new java.lang.Object[items.size()];
            this.areaCurricularLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.areaCurricularValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.areaCurricularLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AreaCurricularSeleccionaHijoFormImpl.setAreaCurricularBackingList encountered an exception", ex);
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

    public void setId(java.lang.String id)
    {
        this.id = id;
    }

    /**
     * <p>
     * Identificador del nodo hijo de Nivel Educativo que se ha
     * selecionado.
     * </p>
     */
    public java.lang.String getId()
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
            throw new IllegalArgumentException("AreaCurricularSeleccionaHijoFormImpl.setIdBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AreaCurricularSeleccionaHijoFormImpl.setIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nodos</code>.
     */
    public void resetNodos()
    {
        this.nodos = null;
    }

    public void setNodos(java.util.Collection nodos)
    {
        this.nodos = nodos;
    }

    /**
     * <p>
     * Son los nodos que cuelgan del nivel del arbol de Nivel Educativo
     * que se ha seleccionado.
     * </p>
     */
    public java.util.Collection getNodos()
    {
        return this.nodos;
    }

    public void setNodosAsArray(Object[] nodos)
    {
        this.nodos = (nodos == null) ? null : java.util.Arrays.asList(nodos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularSeleccionaHijoFormImpl#getNodos
     */
    public java.lang.Object[] getNodosAsArray()
    {
        return (nodos == null) ? null : nodos.toArray();
    }
    
    public java.lang.Object[] getNodosBackingList()
    {
        java.lang.Object[] values = this.nodosValueList;
        java.lang.Object[] labels = this.nodosLabelList;

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

    public java.lang.Object[] getNodosValueList()
    {
        return this.nodosValueList;
    }

    public void setNodosValueList(java.lang.Object[] nodosValueList)
    {
        this.nodosValueList = nodosValueList;
    }

    public java.lang.Object[] getNodosLabelList()
    {
        return this.nodosLabelList;
    }

    public void setNodosLabelList(java.lang.Object[] nodosLabelList)
    {
        this.nodosLabelList = nodosLabelList;
    }

    public void setNodosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AreaCurricularSeleccionaHijoFormImpl.setNodosBackingList requires non-null property arguments");
        }

        this.nodosValueList = null;
        this.nodosLabelList = null;

        if (items != null)
        {
            this.nodosValueList = new java.lang.Object[items.size()];
            this.nodosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nodosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nodosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AreaCurricularSeleccionaHijoFormImpl.setNodosBackingList encountered an exception", ex);
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
     * <p>
     * Se trata de la ruta del arbol de Niveles Educativos hasta llegar
     * al Nivel Educativo que se ha seleccionado.
     * </p>
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
     * @see es.pode.buscador.presentacion.avanzado.areaCurricular.AreaCurricularSeleccionaHijoFormImpl#getRutaArbol
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
            throw new IllegalArgumentException("AreaCurricularSeleccionaHijoFormImpl.setRutaArbolBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AreaCurricularSeleccionaHijoFormImpl.setRutaArbolBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoLayoutBuscador</code>.
     */
    public void resetTipoLayoutBuscador()
    {
        this.tipoLayoutBuscador = null;
    }

    public void setTipoLayoutBuscador(java.lang.String tipoLayoutBuscador)
    {
        this.tipoLayoutBuscador = tipoLayoutBuscador;
    }

    /**
     * 
     */
    public java.lang.String getTipoLayoutBuscador()
    {
        return this.tipoLayoutBuscador;
    }
    
    public java.lang.Object[] getTipoLayoutBuscadorBackingList()
    {
        java.lang.Object[] values = this.tipoLayoutBuscadorValueList;
        java.lang.Object[] labels = this.tipoLayoutBuscadorLabelList;

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

    public java.lang.Object[] getTipoLayoutBuscadorValueList()
    {
        return this.tipoLayoutBuscadorValueList;
    }

    public void setTipoLayoutBuscadorValueList(java.lang.Object[] tipoLayoutBuscadorValueList)
    {
        this.tipoLayoutBuscadorValueList = tipoLayoutBuscadorValueList;
    }

    public java.lang.Object[] getTipoLayoutBuscadorLabelList()
    {
        return this.tipoLayoutBuscadorLabelList;
    }

    public void setTipoLayoutBuscadorLabelList(java.lang.Object[] tipoLayoutBuscadorLabelList)
    {
        this.tipoLayoutBuscadorLabelList = tipoLayoutBuscadorLabelList;
    }

    public void setTipoLayoutBuscadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AreaCurricularSeleccionaHijoFormImpl.setTipoLayoutBuscadorBackingList requires non-null property arguments");
        }

        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;

        if (items != null)
        {
            this.tipoLayoutBuscadorValueList = new java.lang.Object[items.size()];
            this.tipoLayoutBuscadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoLayoutBuscadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoLayoutBuscadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AreaCurricularSeleccionaHijoFormImpl.setTipoLayoutBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>buscadorEmpaquetador</code>.
     */
    public void resetBuscadorEmpaquetador()
    {
        this.buscadorEmpaquetador = null;
    }

    public void setBuscadorEmpaquetador(java.lang.Boolean buscadorEmpaquetador)
    {
        this.buscadorEmpaquetador = buscadorEmpaquetador;
    }

    /**
     * 
     */
    public java.lang.Boolean getBuscadorEmpaquetador()
    {
        return this.buscadorEmpaquetador;
    }
    
    public java.lang.Object[] getBuscadorEmpaquetadorBackingList()
    {
        java.lang.Object[] values = this.buscadorEmpaquetadorValueList;
        java.lang.Object[] labels = this.buscadorEmpaquetadorLabelList;

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

    public java.lang.Object[] getBuscadorEmpaquetadorValueList()
    {
        return this.buscadorEmpaquetadorValueList;
    }

    public void setBuscadorEmpaquetadorValueList(java.lang.Object[] buscadorEmpaquetadorValueList)
    {
        this.buscadorEmpaquetadorValueList = buscadorEmpaquetadorValueList;
    }

    public java.lang.Object[] getBuscadorEmpaquetadorLabelList()
    {
        return this.buscadorEmpaquetadorLabelList;
    }

    public void setBuscadorEmpaquetadorLabelList(java.lang.Object[] buscadorEmpaquetadorLabelList)
    {
        this.buscadorEmpaquetadorLabelList = buscadorEmpaquetadorLabelList;
    }

    public void setBuscadorEmpaquetadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AreaCurricularSeleccionaHijoFormImpl.setBuscadorEmpaquetadorBackingList requires non-null property arguments");
        }

        this.buscadorEmpaquetadorValueList = null;
        this.buscadorEmpaquetadorLabelList = null;

        if (items != null)
        {
            this.buscadorEmpaquetadorValueList = new java.lang.Object[items.size()];
            this.buscadorEmpaquetadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.buscadorEmpaquetadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.buscadorEmpaquetadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AreaCurricularSeleccionaHijoFormImpl.setBuscadorEmpaquetadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.buscadorEmpaquetador = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("areaCurricular", this.areaCurricular);
        builder.append("id", this.id);
        builder.append("nodos", this.nodos);
        builder.append("rutaArbol", this.rutaArbol);
        builder.append("tipoLayoutBuscador", this.tipoLayoutBuscador);
        builder.append("buscadorEmpaquetador", this.buscadorEmpaquetador);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.areaCurricular = null;
        this.areaCurricularValueList = null;
        this.areaCurricularLabelList = null;
        this.id = null;
        this.idValueList = null;
        this.idLabelList = null;
        this.nodos = null;
        this.nodosValueList = null;
        this.nodosLabelList = null;
        this.rutaArbol = null;
        this.rutaArbolValueList = null;
        this.rutaArbolLabelList = null;
        this.tipoLayoutBuscador = null;
        this.tipoLayoutBuscadorValueList = null;
        this.tipoLayoutBuscadorLabelList = null;
        this.buscadorEmpaquetador = null;
        this.buscadorEmpaquetadorValueList = null;
        this.buscadorEmpaquetadorLabelList = null;
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
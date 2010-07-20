// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos;

public class RecursoSubmitPrincipalFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.RecuperarDatosForm
        , es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.SeleccionarPrincipalForm
        , es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.RecuperarURLForm
        , es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.RecuperarArchivosForm
        , es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.SubmitArchivoPrincipalForm
        , es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.EsUnArchivoForm
{
    private java.util.List archivos = null;
    private java.lang.Object[] archivosValueList;
    private java.lang.Object[] archivosLabelList;
    private java.lang.String principal;
    private java.lang.Object[] principalValueList;
    private java.lang.Object[] principalLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.util.List dependencias = null;
    private java.lang.Object[] dependenciasValueList;
    private java.lang.Object[] dependenciasLabelList;
    private java.lang.String href;
    private java.lang.Object[] hrefValueList;
    private java.lang.Object[] hrefLabelList;
    private java.util.List identifierRowSelection = null;
    private java.lang.Object[] identifierValueList;
    private java.lang.Object[] identifierLabelList;
    private java.lang.String url;
    private java.lang.Object[] urlValueList;
    private java.lang.Object[] urlLabelList;

    public RecursoSubmitPrincipalFormImpl()
    {
    }

    /**
     * Resets the given <code>archivos</code>.
     */
    public void resetArchivos()
    {
        this.archivos = null;
    }

    public void setArchivos(java.util.List archivos)
    {
        this.archivos = archivos;
    }

    /**
     * 
     */
    public java.util.List getArchivos()
    {
        return this.archivos;
    }

    public void setArchivosAsArray(Object[] archivos)
    {
        this.archivos = (archivos == null) ? null : java.util.Arrays.asList(archivos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.RecursoSubmitPrincipalFormImpl#getArchivos
     */
    public java.lang.Object[] getArchivosAsArray()
    {
        return (archivos == null) ? null : archivos.toArray();
    }
    
    public java.lang.Object[] getArchivosBackingList()
    {
        java.lang.Object[] values = this.archivosValueList;
        java.lang.Object[] labels = this.archivosLabelList;

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

    public java.lang.Object[] getArchivosValueList()
    {
        return this.archivosValueList;
    }

    public void setArchivosValueList(java.lang.Object[] archivosValueList)
    {
        this.archivosValueList = archivosValueList;
    }

    public java.lang.Object[] getArchivosLabelList()
    {
        return this.archivosLabelList;
    }

    public void setArchivosLabelList(java.lang.Object[] archivosLabelList)
    {
        this.archivosLabelList = archivosLabelList;
    }

    public void setArchivosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RecursoSubmitPrincipalFormImpl.setArchivosBackingList requires non-null property arguments");
        }

        this.archivosValueList = null;
        this.archivosLabelList = null;

        if (items != null)
        {
            this.archivosValueList = new java.lang.Object[items.size()];
            this.archivosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.archivosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.archivosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RecursoSubmitPrincipalFormImpl.setArchivosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>principal</code>.
     */
    public void resetPrincipal()
    {
        this.principal = null;
    }

    public void setPrincipal(java.lang.String principal)
    {
        this.principal = principal;
    }

    /**
     * 
     */
    public java.lang.String getPrincipal()
    {
        return this.principal;
    }
    
    public java.lang.Object[] getPrincipalBackingList()
    {
        java.lang.Object[] values = this.principalValueList;
        java.lang.Object[] labels = this.principalLabelList;

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

    public java.lang.Object[] getPrincipalValueList()
    {
        return this.principalValueList;
    }

    public void setPrincipalValueList(java.lang.Object[] principalValueList)
    {
        this.principalValueList = principalValueList;
    }

    public java.lang.Object[] getPrincipalLabelList()
    {
        return this.principalLabelList;
    }

    public void setPrincipalLabelList(java.lang.Object[] principalLabelList)
    {
        this.principalLabelList = principalLabelList;
    }

    public void setPrincipalBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RecursoSubmitPrincipalFormImpl.setPrincipalBackingList requires non-null property arguments");
        }

        this.principalValueList = null;
        this.principalLabelList = null;

        if (items != null)
        {
            this.principalValueList = new java.lang.Object[items.size()];
            this.principalLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.principalValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.principalLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RecursoSubmitPrincipalFormImpl.setPrincipalBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("RecursoSubmitPrincipalFormImpl.setActionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("RecursoSubmitPrincipalFormImpl.setActionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>dependencias</code>.
     */
    public void resetDependencias()
    {
        this.dependencias = null;
    }

    public void setDependencias(java.util.List dependencias)
    {
        this.dependencias = dependencias;
    }

    /**
     * 
     */
    public java.util.List getDependencias()
    {
        return this.dependencias;
    }

    public void setDependenciasAsArray(Object[] dependencias)
    {
        this.dependencias = (dependencias == null) ? null : java.util.Arrays.asList(dependencias);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.RecursoSubmitPrincipalFormImpl#getDependencias
     */
    public java.lang.Object[] getDependenciasAsArray()
    {
        return (dependencias == null) ? null : dependencias.toArray();
    }
    
    public java.lang.Object[] getDependenciasBackingList()
    {
        java.lang.Object[] values = this.dependenciasValueList;
        java.lang.Object[] labels = this.dependenciasLabelList;

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

    public java.lang.Object[] getDependenciasValueList()
    {
        return this.dependenciasValueList;
    }

    public void setDependenciasValueList(java.lang.Object[] dependenciasValueList)
    {
        this.dependenciasValueList = dependenciasValueList;
    }

    public java.lang.Object[] getDependenciasLabelList()
    {
        return this.dependenciasLabelList;
    }

    public void setDependenciasLabelList(java.lang.Object[] dependenciasLabelList)
    {
        this.dependenciasLabelList = dependenciasLabelList;
    }

    public void setDependenciasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RecursoSubmitPrincipalFormImpl.setDependenciasBackingList requires non-null property arguments");
        }

        this.dependenciasValueList = null;
        this.dependenciasLabelList = null;

        if (items != null)
        {
            this.dependenciasValueList = new java.lang.Object[items.size()];
            this.dependenciasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.dependenciasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.dependenciasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RecursoSubmitPrincipalFormImpl.setDependenciasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>href</code>.
     */
    public void resetHref()
    {
        this.href = null;
    }

    public void setHref(java.lang.String href)
    {
        this.href = href;
    }

    /**
     * 
     */
    public java.lang.String getHref()
    {
        return this.href;
    }
    
    public java.lang.Object[] getHrefBackingList()
    {
        java.lang.Object[] values = this.hrefValueList;
        java.lang.Object[] labels = this.hrefLabelList;

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

    public java.lang.Object[] getHrefValueList()
    {
        return this.hrefValueList;
    }

    public void setHrefValueList(java.lang.Object[] hrefValueList)
    {
        this.hrefValueList = hrefValueList;
    }

    public java.lang.Object[] getHrefLabelList()
    {
        return this.hrefLabelList;
    }

    public void setHrefLabelList(java.lang.Object[] hrefLabelList)
    {
        this.hrefLabelList = hrefLabelList;
    }

    public void setHrefBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RecursoSubmitPrincipalFormImpl.setHrefBackingList requires non-null property arguments");
        }

        this.hrefValueList = null;
        this.hrefLabelList = null;

        if (items != null)
        {
            this.hrefValueList = new java.lang.Object[items.size()];
            this.hrefLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.hrefValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.hrefLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RecursoSubmitPrincipalFormImpl.setHrefBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identifierRowSelection</code>.
     */
    public void resetIdentifier()
    {
        this.identifierRowSelection = null;
    }

    public void setIdentifierRowSelection(java.util.List identifierRowSelection)
    {
        this.identifierRowSelection = identifierRowSelection;
    }

    public java.util.List getIdentifierRowSelection()
    {
        return this.identifierRowSelection;
    }

    public void setIdentifierRowSelectionAsArray(java.lang.String[] identifierRowSelection)
    {
        this.identifierRowSelection = (identifierRowSelection == null) ? null : java.util.Arrays.asList(identifierRowSelection);
    }

    public java.lang.String[] getIdentifierRowSelectionAsArray()
    {
        return (identifierRowSelection == null) ? null : (java.lang.String[])identifierRowSelection.toArray(new java.lang.String[identifierRowSelection.size()]);
    }

    public java.lang.Object[] getIdentifierBackingList()
    {
        java.lang.Object[] values = this.identifierValueList;
        java.lang.Object[] labels = this.identifierLabelList;

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

    public java.lang.Object[] getIdentifierValueList()
    {
        return this.identifierValueList;
    }

    public void setIdentifierValueList(java.lang.Object[] identifierValueList)
    {
        this.identifierValueList = identifierValueList;
    }

    public java.lang.Object[] getIdentifierLabelList()
    {
        return this.identifierLabelList;
    }

    public void setIdentifierLabelList(java.lang.Object[] identifierLabelList)
    {
        this.identifierLabelList = identifierLabelList;
    }

    public void setIdentifierBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("RecursoSubmitPrincipalFormImpl.setIdentifierBackingList requires non-null property arguments");
        }

        this.identifierValueList = null;
        this.identifierLabelList = null;

        if (items != null)
        {
            this.identifierValueList = new java.lang.Object[items.size()];
            this.identifierLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identifierValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identifierLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("RecursoSubmitPrincipalFormImpl.setIdentifierBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("RecursoSubmitPrincipalFormImpl.setUrlBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("RecursoSubmitPrincipalFormImpl.setUrlBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.identifierRowSelection = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("archivos", this.archivos);
        builder.append("principal", this.principal);
        builder.append("action", this.action);
        builder.append("dependencias", this.dependencias);
        builder.append("href", this.href);
        builder.append("identifierRowSelection", this.identifierRowSelection);
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
        this.archivos = null;
        this.archivosValueList = null;
        this.archivosLabelList = null;
        this.principal = null;
        this.principalValueList = null;
        this.principalLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.dependencias = null;
        this.dependenciasValueList = null;
        this.dependenciasLabelList = null;
        this.href = null;
        this.hrefValueList = null;
        this.hrefLabelList = null;
        this.identifierRowSelection = null;
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
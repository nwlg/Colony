// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.altaUsuario;

public class FormularioAltaUsuarioAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.adminusuarios.altaUsuario.AsignarGruposTrabajoForm
        , es.pode.administracion.presentacion.adminusuarios.altaUsuario.RecuperarGruposTrabajoForm
        , es.pode.administracion.presentacion.adminusuarios.altaUsuario.RolParaGruposTrabajoForm
        , es.pode.administracion.presentacion.adminusuarios.altaUsuario.SubmitForm
        , es.pode.administracion.presentacion.adminusuarios.altaUsuario.AltaUsuarioForm
{
    private java.util.List idRowSelection = null;
    private java.lang.Object[] idValueList;
    private java.lang.Object[] idLabelList;
    private java.util.List identificadorRowSelection = null;
    private java.lang.Object[] identificadorValueList;
    private java.lang.Object[] identificadorLabelList;
    private java.lang.Long idModificado;
    private java.lang.Object[] idModificadoValueList;
    private java.lang.Object[] idModificadoLabelList;
    private java.lang.String resultado;
    private java.lang.Object[] resultadoValueList;
    private java.lang.Object[] resultadoLabelList;
    private java.util.Collection gruposTrabajo = null;
    private java.lang.Object[] gruposTrabajoValueList;
    private java.lang.Object[] gruposTrabajoLabelList;

    public FormularioAltaUsuarioAceptarFormImpl()
    {
    }

    /**
     * Resets the given <code>idRowSelection</code>.
     */
    public void resetId()
    {
        this.idRowSelection = null;
    }

    public void setIdRowSelection(java.util.List idRowSelection)
    {
        this.idRowSelection = idRowSelection;
    }

    public java.util.List getIdRowSelection()
    {
        return this.idRowSelection;
    }

    public void setIdRowSelectionAsArray(java.lang.String[] idRowSelection)
    {
        this.idRowSelection = (idRowSelection == null) ? null : java.util.Arrays.asList(idRowSelection);
    }

    public java.lang.String[] getIdRowSelectionAsArray()
    {
        return (idRowSelection == null) ? null : (java.lang.String[])idRowSelection.toArray(new java.lang.String[idRowSelection.size()]);
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
            throw new IllegalArgumentException("FormularioAltaUsuarioAceptarFormImpl.setIdBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioAltaUsuarioAceptarFormImpl.setIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificadorRowSelection</code>.
     */
    public void resetIdentificador()
    {
        this.identificadorRowSelection = null;
    }

    public void setIdentificadorRowSelection(java.util.List identificadorRowSelection)
    {
        this.identificadorRowSelection = identificadorRowSelection;
    }

    public java.util.List getIdentificadorRowSelection()
    {
        return this.identificadorRowSelection;
    }

    public void setIdentificadorRowSelectionAsArray(java.lang.String[] identificadorRowSelection)
    {
        this.identificadorRowSelection = (identificadorRowSelection == null) ? null : java.util.Arrays.asList(identificadorRowSelection);
    }

    public java.lang.String[] getIdentificadorRowSelectionAsArray()
    {
        return (identificadorRowSelection == null) ? null : (java.lang.String[])identificadorRowSelection.toArray(new java.lang.String[identificadorRowSelection.size()]);
    }

    public java.lang.Object[] getIdentificadorBackingList()
    {
        java.lang.Object[] values = this.identificadorValueList;
        java.lang.Object[] labels = this.identificadorLabelList;

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

    public java.lang.Object[] getIdentificadorValueList()
    {
        return this.identificadorValueList;
    }

    public void setIdentificadorValueList(java.lang.Object[] identificadorValueList)
    {
        this.identificadorValueList = identificadorValueList;
    }

    public java.lang.Object[] getIdentificadorLabelList()
    {
        return this.identificadorLabelList;
    }

    public void setIdentificadorLabelList(java.lang.Object[] identificadorLabelList)
    {
        this.identificadorLabelList = identificadorLabelList;
    }

    public void setIdentificadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioAltaUsuarioAceptarFormImpl.setIdentificadorBackingList requires non-null property arguments");
        }

        this.identificadorValueList = null;
        this.identificadorLabelList = null;

        if (items != null)
        {
            this.identificadorValueList = new java.lang.Object[items.size()];
            this.identificadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioAltaUsuarioAceptarFormImpl.setIdentificadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioAltaUsuarioAceptarFormImpl.setIdModificadoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioAltaUsuarioAceptarFormImpl.setIdModificadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>resultado</code>.
     */
    public void resetResultado()
    {
        this.resultado = null;
    }

    public void setResultado(java.lang.String resultado)
    {
        this.resultado = resultado;
    }

    /**
     * 
     */
    public java.lang.String getResultado()
    {
        return this.resultado;
    }
    
    public java.lang.Object[] getResultadoBackingList()
    {
        java.lang.Object[] values = this.resultadoValueList;
        java.lang.Object[] labels = this.resultadoLabelList;

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

    public java.lang.Object[] getResultadoValueList()
    {
        return this.resultadoValueList;
    }

    public void setResultadoValueList(java.lang.Object[] resultadoValueList)
    {
        this.resultadoValueList = resultadoValueList;
    }

    public java.lang.Object[] getResultadoLabelList()
    {
        return this.resultadoLabelList;
    }

    public void setResultadoLabelList(java.lang.Object[] resultadoLabelList)
    {
        this.resultadoLabelList = resultadoLabelList;
    }

    public void setResultadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioAltaUsuarioAceptarFormImpl.setResultadoBackingList requires non-null property arguments");
        }

        this.resultadoValueList = null;
        this.resultadoLabelList = null;

        if (items != null)
        {
            this.resultadoValueList = new java.lang.Object[items.size()];
            this.resultadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resultadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resultadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioAltaUsuarioAceptarFormImpl.setResultadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>gruposTrabajo</code>.
     */
    public void resetGruposTrabajo()
    {
        this.gruposTrabajo = null;
    }

    public void setGruposTrabajo(java.util.Collection gruposTrabajo)
    {
        this.gruposTrabajo = gruposTrabajo;
    }

    /**
     * 
     */
    public java.util.Collection getGruposTrabajo()
    {
        return this.gruposTrabajo;
    }

    public void setGruposTrabajoAsArray(Object[] gruposTrabajo)
    {
        this.gruposTrabajo = (gruposTrabajo == null) ? null : java.util.Arrays.asList(gruposTrabajo);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.administracion.presentacion.adminusuarios.altaUsuario.FormularioAltaUsuarioAceptarFormImpl#getGruposTrabajo
     */
    public java.lang.Object[] getGruposTrabajoAsArray()
    {
        return (gruposTrabajo == null) ? null : gruposTrabajo.toArray();
    }
    
    public java.lang.Object[] getGruposTrabajoBackingList()
    {
        java.lang.Object[] values = this.gruposTrabajoValueList;
        java.lang.Object[] labels = this.gruposTrabajoLabelList;

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

    public java.lang.Object[] getGruposTrabajoValueList()
    {
        return this.gruposTrabajoValueList;
    }

    public void setGruposTrabajoValueList(java.lang.Object[] gruposTrabajoValueList)
    {
        this.gruposTrabajoValueList = gruposTrabajoValueList;
    }

    public java.lang.Object[] getGruposTrabajoLabelList()
    {
        return this.gruposTrabajoLabelList;
    }

    public void setGruposTrabajoLabelList(java.lang.Object[] gruposTrabajoLabelList)
    {
        this.gruposTrabajoLabelList = gruposTrabajoLabelList;
    }

    public void setGruposTrabajoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioAltaUsuarioAceptarFormImpl.setGruposTrabajoBackingList requires non-null property arguments");
        }

        this.gruposTrabajoValueList = null;
        this.gruposTrabajoLabelList = null;

        if (items != null)
        {
            this.gruposTrabajoValueList = new java.lang.Object[items.size()];
            this.gruposTrabajoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.gruposTrabajoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.gruposTrabajoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioAltaUsuarioAceptarFormImpl.setGruposTrabajoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.idRowSelection = null;
        this.identificadorRowSelection = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("idRowSelection", this.idRowSelection);
        builder.append("identificadorRowSelection", this.identificadorRowSelection);
        builder.append("idModificado", this.idModificado);
        builder.append("resultado", this.resultado);
        builder.append("gruposTrabajo", this.gruposTrabajo);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.idRowSelection = null;
        this.identificadorRowSelection = null;
        this.idModificado = null;
        this.idModificadoValueList = null;
        this.idModificadoLabelList = null;
        this.resultado = null;
        this.resultadoValueList = null;
        this.resultadoLabelList = null;
        this.gruposTrabajo = null;
        this.gruposTrabajoValueList = null;
        this.gruposTrabajoLabelList = null;
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
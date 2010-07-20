// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales;

public class MostrarODESPersonalesImportarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
{
    private java.lang.String idUsuario;
    private java.lang.Object[] idUsuarioValueList;
    private java.lang.Object[] idUsuarioLabelList;
    private java.lang.Long espacioLibre;
    private java.lang.Object[] espacioLibreValueList;
    private java.lang.Object[] espacioLibreLabelList;

    public MostrarODESPersonalesImportarFormImpl()
    {
    }

    /**
     * Resets the given <code>idUsuario</code>.
     */
    public void resetIdUsuario()
    {
        this.idUsuario = null;
    }

    public void setIdUsuario(java.lang.String idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    /**
     * <p>
     * Identificador del usuario que importa el ODE.
     * </p>
     */
    public java.lang.String getIdUsuario()
    {
        return this.idUsuario;
    }
    
    public java.lang.Object[] getIdUsuarioBackingList()
    {
        java.lang.Object[] values = this.idUsuarioValueList;
        java.lang.Object[] labels = this.idUsuarioLabelList;

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

    public java.lang.Object[] getIdUsuarioValueList()
    {
        return this.idUsuarioValueList;
    }

    public void setIdUsuarioValueList(java.lang.Object[] idUsuarioValueList)
    {
        this.idUsuarioValueList = idUsuarioValueList;
    }

    public java.lang.Object[] getIdUsuarioLabelList()
    {
        return this.idUsuarioLabelList;
    }

    public void setIdUsuarioLabelList(java.lang.Object[] idUsuarioLabelList)
    {
        this.idUsuarioLabelList = idUsuarioLabelList;
    }

    public void setIdUsuarioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarODESPersonalesImportarFormImpl.setIdUsuarioBackingList requires non-null property arguments");
        }

        this.idUsuarioValueList = null;
        this.idUsuarioLabelList = null;

        if (items != null)
        {
            this.idUsuarioValueList = new java.lang.Object[items.size()];
            this.idUsuarioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idUsuarioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idUsuarioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarODESPersonalesImportarFormImpl.setIdUsuarioBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>espacioLibre</code>.
     */
    public void resetEspacioLibre()
    {
        this.espacioLibre = null;
    }

    public void setEspacioLibre(java.lang.Long espacioLibre)
    {
        this.espacioLibre = espacioLibre;
    }

    /**
     * <p>
     * El espacio libre del que dispone el usuario
     * </p>
     */
    public java.lang.Long getEspacioLibre()
    {
        return this.espacioLibre;
    }
    
    public java.lang.Object[] getEspacioLibreBackingList()
    {
        java.lang.Object[] values = this.espacioLibreValueList;
        java.lang.Object[] labels = this.espacioLibreLabelList;

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

    public java.lang.Object[] getEspacioLibreValueList()
    {
        return this.espacioLibreValueList;
    }

    public void setEspacioLibreValueList(java.lang.Object[] espacioLibreValueList)
    {
        this.espacioLibreValueList = espacioLibreValueList;
    }

    public java.lang.Object[] getEspacioLibreLabelList()
    {
        return this.espacioLibreLabelList;
    }

    public void setEspacioLibreLabelList(java.lang.Object[] espacioLibreLabelList)
    {
        this.espacioLibreLabelList = espacioLibreLabelList;
    }

    public void setEspacioLibreBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarODESPersonalesImportarFormImpl.setEspacioLibreBackingList requires non-null property arguments");
        }

        this.espacioLibreValueList = null;
        this.espacioLibreLabelList = null;

        if (items != null)
        {
            this.espacioLibreValueList = new java.lang.Object[items.size()];
            this.espacioLibreLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.espacioLibreValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.espacioLibreLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarODESPersonalesImportarFormImpl.setEspacioLibreBackingList encountered an exception", ex);
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
        builder.append("idUsuario", this.idUsuario);
        builder.append("espacioLibre", this.espacioLibre);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.idUsuario = null;
        this.idUsuarioValueList = null;
        this.idUsuarioLabelList = null;
        this.espacioLibre = null;
        this.espacioLibreValueList = null;
        this.espacioLibreLabelList = null;
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
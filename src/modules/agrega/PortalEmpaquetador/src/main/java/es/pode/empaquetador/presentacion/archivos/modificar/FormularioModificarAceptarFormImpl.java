// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.modificar;

public class FormularioModificarAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.archivos.modificar.ModificarForm
{
    private java.lang.String extension;
    private java.lang.Object[] extensionValueList;
    private java.lang.Object[] extensionLabelList;
    private es.pode.empaquetador.negocio.servicio.ArchivoVO archivoVO;
    private java.lang.Object[] archivoVOValueList;
    private java.lang.Object[] archivoVOLabelList;
    private java.lang.String nuevoNombre;
    private java.lang.Object[] nuevoNombreValueList;
    private java.lang.Object[] nuevoNombreLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;

    public FormularioModificarAceptarFormImpl()
    {
    }

    /**
     * Resets the given <code>extension</code>.
     */
    public void resetExtension()
    {
        this.extension = null;
    }

    public void setExtension(java.lang.String extension)
    {
        this.extension = extension;
    }

    /**
     * 
     */
    public java.lang.String getExtension()
    {
        return this.extension;
    }
    
    public java.lang.Object[] getExtensionBackingList()
    {
        java.lang.Object[] values = this.extensionValueList;
        java.lang.Object[] labels = this.extensionLabelList;

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

    public java.lang.Object[] getExtensionValueList()
    {
        return this.extensionValueList;
    }

    public void setExtensionValueList(java.lang.Object[] extensionValueList)
    {
        this.extensionValueList = extensionValueList;
    }

    public java.lang.Object[] getExtensionLabelList()
    {
        return this.extensionLabelList;
    }

    public void setExtensionLabelList(java.lang.Object[] extensionLabelList)
    {
        this.extensionLabelList = extensionLabelList;
    }

    public void setExtensionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioModificarAceptarFormImpl.setExtensionBackingList requires non-null property arguments");
        }

        this.extensionValueList = null;
        this.extensionLabelList = null;

        if (items != null)
        {
            this.extensionValueList = new java.lang.Object[items.size()];
            this.extensionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.extensionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.extensionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioModificarAceptarFormImpl.setExtensionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>archivoVO</code>.
     */
    public void resetArchivoVO()
    {
        this.archivoVO = null;
    }

    public void setArchivoVO(es.pode.empaquetador.negocio.servicio.ArchivoVO archivoVO)
    {
        this.archivoVO = archivoVO;
    }

    /**
     * 
     */
    public es.pode.empaquetador.negocio.servicio.ArchivoVO getArchivoVO()
    {
        return this.archivoVO;
    }
    
    public java.lang.Object[] getArchivoVOBackingList()
    {
        java.lang.Object[] values = this.archivoVOValueList;
        java.lang.Object[] labels = this.archivoVOLabelList;

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

    public java.lang.Object[] getArchivoVOValueList()
    {
        return this.archivoVOValueList;
    }

    public void setArchivoVOValueList(java.lang.Object[] archivoVOValueList)
    {
        this.archivoVOValueList = archivoVOValueList;
    }

    public java.lang.Object[] getArchivoVOLabelList()
    {
        return this.archivoVOLabelList;
    }

    public void setArchivoVOLabelList(java.lang.Object[] archivoVOLabelList)
    {
        this.archivoVOLabelList = archivoVOLabelList;
    }

    public void setArchivoVOBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioModificarAceptarFormImpl.setArchivoVOBackingList requires non-null property arguments");
        }

        this.archivoVOValueList = null;
        this.archivoVOLabelList = null;

        if (items != null)
        {
            this.archivoVOValueList = new java.lang.Object[items.size()];
            this.archivoVOLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.archivoVOValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.archivoVOLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioModificarAceptarFormImpl.setArchivoVOBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nuevoNombre</code>.
     */
    public void resetNuevoNombre()
    {
        this.nuevoNombre = null;
    }

    public void setNuevoNombre(java.lang.String nuevoNombre)
    {
        this.nuevoNombre = nuevoNombre;
    }

    /**
     * 
     */
    public java.lang.String getNuevoNombre()
    {
        return this.nuevoNombre;
    }
    
    public java.lang.Object[] getNuevoNombreBackingList()
    {
        java.lang.Object[] values = this.nuevoNombreValueList;
        java.lang.Object[] labels = this.nuevoNombreLabelList;

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

    public java.lang.Object[] getNuevoNombreValueList()
    {
        return this.nuevoNombreValueList;
    }

    public void setNuevoNombreValueList(java.lang.Object[] nuevoNombreValueList)
    {
        this.nuevoNombreValueList = nuevoNombreValueList;
    }

    public java.lang.Object[] getNuevoNombreLabelList()
    {
        return this.nuevoNombreLabelList;
    }

    public void setNuevoNombreLabelList(java.lang.Object[] nuevoNombreLabelList)
    {
        this.nuevoNombreLabelList = nuevoNombreLabelList;
    }

    public void setNuevoNombreBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioModificarAceptarFormImpl.setNuevoNombreBackingList requires non-null property arguments");
        }

        this.nuevoNombreValueList = null;
        this.nuevoNombreLabelList = null;

        if (items != null)
        {
            this.nuevoNombreValueList = new java.lang.Object[items.size()];
            this.nuevoNombreLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nuevoNombreValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nuevoNombreLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioModificarAceptarFormImpl.setNuevoNombreBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("FormularioModificarAceptarFormImpl.setActionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioModificarAceptarFormImpl.setActionBackingList encountered an exception", ex);
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
        builder.append("extension", this.extension);
        builder.append("archivoVO", this.archivoVO);
        builder.append("nuevoNombre", this.nuevoNombre);
        builder.append("action", this.action);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.extension = null;
        this.extensionValueList = null;
        this.extensionLabelList = null;
        this.archivoVO = null;
        this.archivoVOValueList = null;
        this.archivoVOLabelList = null;
        this.nuevoNombre = null;
        this.nuevoNombreValueList = null;
        this.nuevoNombreLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
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
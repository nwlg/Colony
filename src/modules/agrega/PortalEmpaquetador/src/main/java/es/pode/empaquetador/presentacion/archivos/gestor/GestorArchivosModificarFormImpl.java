// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.gestor;

public class GestorArchivosModificarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.archivos.gestor.RecuperaVOForm
{
    private java.lang.String nombre;
    private java.lang.Object[] nombreValueList;
    private java.lang.Object[] nombreLabelList;
    private java.lang.String extension;
    private java.lang.Object[] extensionValueList;
    private java.lang.Object[] extensionLabelList;
    private es.pode.empaquetador.negocio.servicio.ArchivoVO archivoVO;
    private java.lang.Object[] archivoVOValueList;
    private java.lang.Object[] archivoVOLabelList;

    public GestorArchivosModificarFormImpl()
    {
    }

    /**
     * Resets the given <code>nombre</code>.
     */
    public void resetNombre()
    {
        this.nombre = null;
    }

    public void setNombre(java.lang.String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * <p>
     * Nombre del archivo o carpeta seleccionado.
     * </p>
     */
    public java.lang.String getNombre()
    {
        return this.nombre;
    }
    
    public java.lang.Object[] getNombreBackingList()
    {
        java.lang.Object[] values = this.nombreValueList;
        java.lang.Object[] labels = this.nombreLabelList;

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

    public java.lang.Object[] getNombreValueList()
    {
        return this.nombreValueList;
    }

    public void setNombreValueList(java.lang.Object[] nombreValueList)
    {
        this.nombreValueList = nombreValueList;
    }

    public java.lang.Object[] getNombreLabelList()
    {
        return this.nombreLabelList;
    }

    public void setNombreLabelList(java.lang.Object[] nombreLabelList)
    {
        this.nombreLabelList = nombreLabelList;
    }

    public void setNombreBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorArchivosModificarFormImpl.setNombreBackingList requires non-null property arguments");
        }

        this.nombreValueList = null;
        this.nombreLabelList = null;

        if (items != null)
        {
            this.nombreValueList = new java.lang.Object[items.size()];
            this.nombreLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nombreValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nombreLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorArchivosModificarFormImpl.setNombreBackingList encountered an exception", ex);
            }
        }
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
            throw new IllegalArgumentException("GestorArchivosModificarFormImpl.setExtensionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("GestorArchivosModificarFormImpl.setExtensionBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("GestorArchivosModificarFormImpl.setArchivoVOBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("GestorArchivosModificarFormImpl.setArchivoVOBackingList encountered an exception", ex);
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
        builder.append("nombre", this.nombre);
        builder.append("extension", this.extension);
        builder.append("archivoVO", this.archivoVO);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.nombre = null;
        this.nombreValueList = null;
        this.nombreLabelList = null;
        this.extension = null;
        this.extensionValueList = null;
        this.extensionLabelList = null;
        this.archivoVO = null;
        this.archivoVOValueList = null;
        this.archivoVOLabelList = null;
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
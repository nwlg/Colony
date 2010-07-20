// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.bajaUsuario;

public class ConfirmacionAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.adminusuarios.bajaUsuario.BajaUsuarioForm
{
    private java.lang.String listaId;
    private java.lang.Object[] listaIdValueList;
    private java.lang.Object[] listaIdLabelList;
    private es.pode.adminusuarios.negocio.servicios.UsuarioVO[] usuariosDeleted;
    private java.lang.Object[] usuariosDeletedValueList;
    private java.lang.Object[] usuariosDeletedLabelList;
    private es.pode.adminusuarios.negocio.servicios.UsuarioVO[] usuarios;
    private java.lang.Object[] usuariosValueList;
    private java.lang.Object[] usuariosLabelList;
    private java.lang.String descripcionBaja;
    private java.lang.Object[] descripcionBajaValueList;
    private java.lang.Object[] descripcionBajaLabelList;

    public ConfirmacionAceptarFormImpl()
    {
    }

    /**
     * Resets the given <code>listaId</code>.
     */
    public void resetListaId()
    {
        this.listaId = null;
    }

    public void setListaId(java.lang.String listaId)
    {
        this.listaId = listaId;
    }

    /**
     * 
     */
    public java.lang.String getListaId()
    {
        return this.listaId;
    }
    
    public java.lang.Object[] getListaIdBackingList()
    {
        java.lang.Object[] values = this.listaIdValueList;
        java.lang.Object[] labels = this.listaIdLabelList;

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

    public java.lang.Object[] getListaIdValueList()
    {
        return this.listaIdValueList;
    }

    public void setListaIdValueList(java.lang.Object[] listaIdValueList)
    {
        this.listaIdValueList = listaIdValueList;
    }

    public java.lang.Object[] getListaIdLabelList()
    {
        return this.listaIdLabelList;
    }

    public void setListaIdLabelList(java.lang.Object[] listaIdLabelList)
    {
        this.listaIdLabelList = listaIdLabelList;
    }

    public void setListaIdBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionAceptarFormImpl.setListaIdBackingList requires non-null property arguments");
        }

        this.listaIdValueList = null;
        this.listaIdLabelList = null;

        if (items != null)
        {
            this.listaIdValueList = new java.lang.Object[items.size()];
            this.listaIdLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listaIdValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listaIdLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionAceptarFormImpl.setListaIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>usuariosDeleted</code>.
     */
    public void resetUsuariosDeleted()
    {
        this.usuariosDeleted = null;
    }

    public void setUsuariosDeleted(es.pode.adminusuarios.negocio.servicios.UsuarioVO[] usuariosDeleted)
    {
        this.usuariosDeleted = usuariosDeleted;
    }

    /**
     * 
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioVO[] getUsuariosDeleted()
    {
        return this.usuariosDeleted;
    }
    
    public java.lang.Object[] getUsuariosDeletedBackingList()
    {
        java.lang.Object[] values = this.usuariosDeletedValueList;
        java.lang.Object[] labels = this.usuariosDeletedLabelList;

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

    public java.lang.Object[] getUsuariosDeletedValueList()
    {
        return this.usuariosDeletedValueList;
    }

    public void setUsuariosDeletedValueList(java.lang.Object[] usuariosDeletedValueList)
    {
        this.usuariosDeletedValueList = usuariosDeletedValueList;
    }

    public java.lang.Object[] getUsuariosDeletedLabelList()
    {
        return this.usuariosDeletedLabelList;
    }

    public void setUsuariosDeletedLabelList(java.lang.Object[] usuariosDeletedLabelList)
    {
        this.usuariosDeletedLabelList = usuariosDeletedLabelList;
    }

    public void setUsuariosDeletedBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionAceptarFormImpl.setUsuariosDeletedBackingList requires non-null property arguments");
        }

        this.usuariosDeletedValueList = null;
        this.usuariosDeletedLabelList = null;

        if (items != null)
        {
            this.usuariosDeletedValueList = new java.lang.Object[items.size()];
            this.usuariosDeletedLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.usuariosDeletedValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.usuariosDeletedLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionAceptarFormImpl.setUsuariosDeletedBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>usuarios</code>.
     */
    public void resetUsuarios()
    {
        this.usuarios = null;
    }

    public void setUsuarios(es.pode.adminusuarios.negocio.servicios.UsuarioVO[] usuarios)
    {
        this.usuarios = usuarios;
    }

    /**
     * 
     */
    public es.pode.adminusuarios.negocio.servicios.UsuarioVO[] getUsuarios()
    {
        return this.usuarios;
    }
    
    public java.lang.Object[] getUsuariosBackingList()
    {
        java.lang.Object[] values = this.usuariosValueList;
        java.lang.Object[] labels = this.usuariosLabelList;

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

    public java.lang.Object[] getUsuariosValueList()
    {
        return this.usuariosValueList;
    }

    public void setUsuariosValueList(java.lang.Object[] usuariosValueList)
    {
        this.usuariosValueList = usuariosValueList;
    }

    public java.lang.Object[] getUsuariosLabelList()
    {
        return this.usuariosLabelList;
    }

    public void setUsuariosLabelList(java.lang.Object[] usuariosLabelList)
    {
        this.usuariosLabelList = usuariosLabelList;
    }

    public void setUsuariosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionAceptarFormImpl.setUsuariosBackingList requires non-null property arguments");
        }

        this.usuariosValueList = null;
        this.usuariosLabelList = null;

        if (items != null)
        {
            this.usuariosValueList = new java.lang.Object[items.size()];
            this.usuariosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.usuariosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.usuariosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionAceptarFormImpl.setUsuariosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcionBaja</code>.
     */
    public void resetDescripcionBaja()
    {
        this.descripcionBaja = null;
    }

    public void setDescripcionBaja(java.lang.String descripcionBaja)
    {
        this.descripcionBaja = descripcionBaja;
    }

    /**
     * 
     */
    public java.lang.String getDescripcionBaja()
    {
        return this.descripcionBaja;
    }
    
    public java.lang.Object[] getDescripcionBajaBackingList()
    {
        java.lang.Object[] values = this.descripcionBajaValueList;
        java.lang.Object[] labels = this.descripcionBajaLabelList;

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

    public java.lang.Object[] getDescripcionBajaValueList()
    {
        return this.descripcionBajaValueList;
    }

    public void setDescripcionBajaValueList(java.lang.Object[] descripcionBajaValueList)
    {
        this.descripcionBajaValueList = descripcionBajaValueList;
    }

    public java.lang.Object[] getDescripcionBajaLabelList()
    {
        return this.descripcionBajaLabelList;
    }

    public void setDescripcionBajaLabelList(java.lang.Object[] descripcionBajaLabelList)
    {
        this.descripcionBajaLabelList = descripcionBajaLabelList;
    }

    public void setDescripcionBajaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionAceptarFormImpl.setDescripcionBajaBackingList requires non-null property arguments");
        }

        this.descripcionBajaValueList = null;
        this.descripcionBajaLabelList = null;

        if (items != null)
        {
            this.descripcionBajaValueList = new java.lang.Object[items.size()];
            this.descripcionBajaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionBajaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionBajaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionAceptarFormImpl.setDescripcionBajaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.usuariosDeleted = null;
        this.usuarios = null;
        this.usuariosValueList = new java.lang.Object[0];
        this.usuariosLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("listaId", this.listaId);
        builder.append("usuariosDeleted", this.usuariosDeleted);
        builder.append("usuarios", this.usuarios);
        builder.append("descripcionBaja", this.descripcionBaja);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.listaId = null;
        this.listaIdValueList = null;
        this.listaIdLabelList = null;
        this.usuariosDeleted = null;
        this.usuariosDeletedValueList = null;
        this.usuariosDeletedLabelList = null;
        this.usuarios = null;
        this.usuariosValueList = null;
        this.usuariosLabelList = null;
        this.descripcionBaja = null;
        this.descripcionBajaValueList = null;
        this.descripcionBajaLabelList = null;
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
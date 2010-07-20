// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar.personales;

public class AgregarPersonalesFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.agregar.personales.RecuperarDatosForm
{
    private java.util.List personales = null;
    private java.lang.Object[] personalesValueList;
    private java.lang.Object[] personalesLabelList;
    private java.lang.String idODE;
    private java.lang.Object[] idODEValueList;
    private java.lang.Object[] idODELabelList;
    private java.lang.String compartidos;
    private java.lang.Object[] compartidosValueList;
    private java.lang.Object[] compartidosLabelList;

    public AgregarPersonalesFormImpl()
    {
    }

    /**
     * Resets the given <code>personales</code>.
     */
    public void resetPersonales()
    {
        this.personales = null;
    }

    public void setPersonales(java.util.List personales)
    {
        this.personales = personales;
    }

    /**
     * 
     */
    public java.util.List getPersonales()
    {
        return this.personales;
    }

    public void setPersonalesAsArray(Object[] personales)
    {
        this.personales = (personales == null) ? null : java.util.Arrays.asList(personales);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.agregar.personales.AgregarPersonalesFormImpl#getPersonales
     */
    public java.lang.Object[] getPersonalesAsArray()
    {
        return (personales == null) ? null : personales.toArray();
    }
    
    public java.lang.Object[] getPersonalesBackingList()
    {
        java.lang.Object[] values = this.personalesValueList;
        java.lang.Object[] labels = this.personalesLabelList;

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

    public java.lang.Object[] getPersonalesValueList()
    {
        return this.personalesValueList;
    }

    public void setPersonalesValueList(java.lang.Object[] personalesValueList)
    {
        this.personalesValueList = personalesValueList;
    }

    public java.lang.Object[] getPersonalesLabelList()
    {
        return this.personalesLabelList;
    }

    public void setPersonalesLabelList(java.lang.Object[] personalesLabelList)
    {
        this.personalesLabelList = personalesLabelList;
    }

    public void setPersonalesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AgregarPersonalesFormImpl.setPersonalesBackingList requires non-null property arguments");
        }

        this.personalesValueList = null;
        this.personalesLabelList = null;

        if (items != null)
        {
            this.personalesValueList = new java.lang.Object[items.size()];
            this.personalesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.personalesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.personalesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AgregarPersonalesFormImpl.setPersonalesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idODE</code>.
     */
    public void resetIdODE()
    {
        this.idODE = null;
    }

    public void setIdODE(java.lang.String idODE)
    {
        this.idODE = idODE;
    }

    /**
     * 
     */
    public java.lang.String getIdODE()
    {
        return this.idODE;
    }
    
    public java.lang.Object[] getIdODEBackingList()
    {
        java.lang.Object[] values = this.idODEValueList;
        java.lang.Object[] labels = this.idODELabelList;

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

    public java.lang.Object[] getIdODEValueList()
    {
        return this.idODEValueList;
    }

    public void setIdODEValueList(java.lang.Object[] idODEValueList)
    {
        this.idODEValueList = idODEValueList;
    }

    public java.lang.Object[] getIdODELabelList()
    {
        return this.idODELabelList;
    }

    public void setIdODELabelList(java.lang.Object[] idODELabelList)
    {
        this.idODELabelList = idODELabelList;
    }

    public void setIdODEBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AgregarPersonalesFormImpl.setIdODEBackingList requires non-null property arguments");
        }

        this.idODEValueList = null;
        this.idODELabelList = null;

        if (items != null)
        {
            this.idODEValueList = new java.lang.Object[items.size()];
            this.idODELabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idODEValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idODELabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AgregarPersonalesFormImpl.setIdODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>compartidos</code>.
     */
    public void resetCompartidos()
    {
        this.compartidos = null;
    }

    public void setCompartidos(java.lang.String compartidos)
    {
        this.compartidos = compartidos;
    }

    /**
     * 
     */
    public java.lang.String getCompartidos()
    {
        return this.compartidos;
    }
    
    public java.lang.Object[] getCompartidosBackingList()
    {
        java.lang.Object[] values = this.compartidosValueList;
        java.lang.Object[] labels = this.compartidosLabelList;

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

    public java.lang.Object[] getCompartidosValueList()
    {
        return this.compartidosValueList;
    }

    public void setCompartidosValueList(java.lang.Object[] compartidosValueList)
    {
        this.compartidosValueList = compartidosValueList;
    }

    public java.lang.Object[] getCompartidosLabelList()
    {
        return this.compartidosLabelList;
    }

    public void setCompartidosLabelList(java.lang.Object[] compartidosLabelList)
    {
        this.compartidosLabelList = compartidosLabelList;
    }

    public void setCompartidosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AgregarPersonalesFormImpl.setCompartidosBackingList requires non-null property arguments");
        }

        this.compartidosValueList = null;
        this.compartidosLabelList = null;

        if (items != null)
        {
            this.compartidosValueList = new java.lang.Object[items.size()];
            this.compartidosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.compartidosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.compartidosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AgregarPersonalesFormImpl.setCompartidosBackingList encountered an exception", ex);
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
        builder.append("personales", this.personales);
        builder.append("idODE", this.idODE);
        builder.append("compartidos", this.compartidos);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.personales = null;
        this.personalesValueList = null;
        this.personalesLabelList = null;
        this.idODE = null;
        this.idODEValueList = null;
        this.idODELabelList = null;
        this.compartidos = null;
        this.compartidosValueList = null;
        this.compartidosLabelList = null;
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
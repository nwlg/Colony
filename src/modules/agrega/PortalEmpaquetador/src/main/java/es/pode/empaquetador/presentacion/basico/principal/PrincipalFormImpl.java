// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.principal;

public class PrincipalFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.basico.principal.RecuperarDatosForm
{
    private java.lang.String principal;
    private java.lang.Object[] principalValueList;
    private java.lang.Object[] principalLabelList;
    private java.util.List ficheros = null;
    private java.lang.Object[] ficherosValueList;
    private java.lang.Object[] ficherosLabelList;
    private java.lang.String idRecurso;
    private java.lang.Object[] idRecursoValueList;
    private java.lang.Object[] idRecursoLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.lang.String identifier;
    private java.lang.Object[] identifierValueList;
    private java.lang.Object[] identifierLabelList;

    public PrincipalFormImpl()
    {
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
    
    /**
     * Converts the selected option index to the corresponding value as it was modeled.
     */
    public java.lang.String getPrincipalOptionValue(int optionIndex)
    {
        switch(optionIndex)
        {
            case 0 : return "0";
            case 1 : return "1";
            case 2 : return "2";
            default:
                throw new java.lang.ArrayIndexOutOfBoundsException(
                    "Cannot access option "+optionIndex+", please specify a value in the range [0-2]");
        }
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
            throw new IllegalArgumentException("PrincipalFormImpl.setPrincipalBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PrincipalFormImpl.setPrincipalBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ficheros</code>.
     */
    public void resetFicheros()
    {
        this.ficheros = null;
    }

    public void setFicheros(java.util.List ficheros)
    {
        this.ficheros = ficheros;
    }

    /**
     * <p>
     * Lista de FileVO
     * </p>
     */
    public java.util.List getFicheros()
    {
        return this.ficheros;
    }

    public void setFicherosAsArray(Object[] ficheros)
    {
        this.ficheros = (ficheros == null) ? null : java.util.Arrays.asList(ficheros);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.basico.principal.PrincipalFormImpl#getFicheros
     */
    public java.lang.Object[] getFicherosAsArray()
    {
        return (ficheros == null) ? null : ficheros.toArray();
    }
    
    public java.lang.Object[] getFicherosBackingList()
    {
        java.lang.Object[] values = this.ficherosValueList;
        java.lang.Object[] labels = this.ficherosLabelList;

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

    public java.lang.Object[] getFicherosValueList()
    {
        return this.ficherosValueList;
    }

    public void setFicherosValueList(java.lang.Object[] ficherosValueList)
    {
        this.ficherosValueList = ficherosValueList;
    }

    public java.lang.Object[] getFicherosLabelList()
    {
        return this.ficherosLabelList;
    }

    public void setFicherosLabelList(java.lang.Object[] ficherosLabelList)
    {
        this.ficherosLabelList = ficherosLabelList;
    }

    public void setFicherosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PrincipalFormImpl.setFicherosBackingList requires non-null property arguments");
        }

        this.ficherosValueList = null;
        this.ficherosLabelList = null;

        if (items != null)
        {
            this.ficherosValueList = new java.lang.Object[items.size()];
            this.ficherosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.ficherosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.ficherosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PrincipalFormImpl.setFicherosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idRecurso</code>.
     */
    public void resetIdRecurso()
    {
        this.idRecurso = null;
    }

    public void setIdRecurso(java.lang.String idRecurso)
    {
        this.idRecurso = idRecurso;
    }

    /**
     * 
     */
    public java.lang.String getIdRecurso()
    {
        return this.idRecurso;
    }
    
    public java.lang.Object[] getIdRecursoBackingList()
    {
        java.lang.Object[] values = this.idRecursoValueList;
        java.lang.Object[] labels = this.idRecursoLabelList;

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

    public java.lang.Object[] getIdRecursoValueList()
    {
        return this.idRecursoValueList;
    }

    public void setIdRecursoValueList(java.lang.Object[] idRecursoValueList)
    {
        this.idRecursoValueList = idRecursoValueList;
    }

    public java.lang.Object[] getIdRecursoLabelList()
    {
        return this.idRecursoLabelList;
    }

    public void setIdRecursoLabelList(java.lang.Object[] idRecursoLabelList)
    {
        this.idRecursoLabelList = idRecursoLabelList;
    }

    public void setIdRecursoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PrincipalFormImpl.setIdRecursoBackingList requires non-null property arguments");
        }

        this.idRecursoValueList = null;
        this.idRecursoLabelList = null;

        if (items != null)
        {
            this.idRecursoValueList = new java.lang.Object[items.size()];
            this.idRecursoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idRecursoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idRecursoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PrincipalFormImpl.setIdRecursoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("PrincipalFormImpl.setActionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PrincipalFormImpl.setActionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identifier</code>.
     */
    public void resetIdentifier()
    {
        this.identifier = null;
    }

    public void setIdentifier(java.lang.String identifier)
    {
        this.identifier = identifier;
    }

    /**
     * 
     */
    public java.lang.String getIdentifier()
    {
        return this.identifier;
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
            throw new IllegalArgumentException("PrincipalFormImpl.setIdentifierBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PrincipalFormImpl.setIdentifierBackingList encountered an exception", ex);
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
        builder.append("principal", this.principal);
        builder.append("ficheros", this.ficheros);
        builder.append("idRecurso", this.idRecurso);
        builder.append("action", this.action);
        builder.append("identifier", this.identifier);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.principal = null;
        this.principalValueList = null;
        this.principalLabelList = null;
        this.ficheros = null;
        this.ficherosValueList = null;
        this.ficherosLabelList = null;
        this.idRecurso = null;
        this.idRecursoValueList = null;
        this.idRecursoLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.identifier = null;
        this.identifierValueList = null;
        this.identifierLabelList = null;
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
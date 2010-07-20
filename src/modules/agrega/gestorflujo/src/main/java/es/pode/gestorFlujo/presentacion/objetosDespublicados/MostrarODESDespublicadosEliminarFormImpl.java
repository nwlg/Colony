// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosDespublicados;

public class MostrarODESDespublicadosEliminarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.gestorFlujo.presentacion.objetosDespublicados.SubmitArchivosForm
{
    private java.util.List idODERowSelection = null;
    private java.lang.Object[] idODEValueList;
    private java.lang.Object[] idODELabelList;
    private java.lang.String[] listODEs;
    private java.lang.Object[] listODEsValueList;
    private java.lang.Object[] listODEsLabelList;
    private java.lang.String origen;
    private java.lang.Object[] origenValueList;
    private java.lang.Object[] origenLabelList;

    public MostrarODESDespublicadosEliminarFormImpl()
    {
    }

    /**
     * Resets the given <code>idODERowSelection</code>.
     */
    public void resetIdODE()
    {
        this.idODERowSelection = null;
    }

    public void setIdODERowSelection(java.util.List idODERowSelection)
    {
        this.idODERowSelection = idODERowSelection;
    }

    public java.util.List getIdODERowSelection()
    {
        return this.idODERowSelection;
    }

    public void setIdODERowSelectionAsArray(java.lang.String[] idODERowSelection)
    {
        this.idODERowSelection = (idODERowSelection == null) ? null : java.util.Arrays.asList(idODERowSelection);
    }

    public java.lang.String[] getIdODERowSelectionAsArray()
    {
        return (idODERowSelection == null) ? null : (java.lang.String[])idODERowSelection.toArray(new java.lang.String[idODERowSelection.size()]);
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
            throw new IllegalArgumentException("MostrarODESDespublicadosEliminarFormImpl.setIdODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("MostrarODESDespublicadosEliminarFormImpl.setIdODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listODEs</code>.
     */
    public void resetListODEs()
    {
        this.listODEs = null;
    }

    public void setListODEs(java.lang.String[] listODEs)
    {
        this.listODEs = listODEs;
    }

    /**
     * 
     */
    public java.lang.String[] getListODEs()
    {
        return this.listODEs;
    }
    
    public java.lang.Object[] getListODEsBackingList()
    {
        java.lang.Object[] values = this.listODEsValueList;
        java.lang.Object[] labels = this.listODEsLabelList;

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

    public java.lang.Object[] getListODEsValueList()
    {
        return this.listODEsValueList;
    }

    public void setListODEsValueList(java.lang.Object[] listODEsValueList)
    {
        this.listODEsValueList = listODEsValueList;
    }

    public java.lang.Object[] getListODEsLabelList()
    {
        return this.listODEsLabelList;
    }

    public void setListODEsLabelList(java.lang.Object[] listODEsLabelList)
    {
        this.listODEsLabelList = listODEsLabelList;
    }

    public void setListODEsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarODESDespublicadosEliminarFormImpl.setListODEsBackingList requires non-null property arguments");
        }

        this.listODEsValueList = null;
        this.listODEsLabelList = null;

        if (items != null)
        {
            this.listODEsValueList = new java.lang.Object[items.size()];
            this.listODEsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listODEsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listODEsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarODESDespublicadosEliminarFormImpl.setListODEsBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>origen</code>.
     */
    public void resetOrigen()
    {
        this.origen = null;
    }

    public void setOrigen(java.lang.String origen)
    {
        this.origen = origen;
    }

    /**
     * 
     */
    public java.lang.String getOrigen()
    {
        return this.origen;
    }
    
    public java.lang.Object[] getOrigenBackingList()
    {
        java.lang.Object[] values = this.origenValueList;
        java.lang.Object[] labels = this.origenLabelList;

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

    public java.lang.Object[] getOrigenValueList()
    {
        return this.origenValueList;
    }

    public void setOrigenValueList(java.lang.Object[] origenValueList)
    {
        this.origenValueList = origenValueList;
    }

    public java.lang.Object[] getOrigenLabelList()
    {
        return this.origenLabelList;
    }

    public void setOrigenLabelList(java.lang.Object[] origenLabelList)
    {
        this.origenLabelList = origenLabelList;
    }

    public void setOrigenBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("MostrarODESDespublicadosEliminarFormImpl.setOrigenBackingList requires non-null property arguments");
        }

        this.origenValueList = null;
        this.origenLabelList = null;

        if (items != null)
        {
            this.origenValueList = new java.lang.Object[items.size()];
            this.origenLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.origenValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.origenLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("MostrarODESDespublicadosEliminarFormImpl.setOrigenBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.idODERowSelection = null;
        this.listODEs = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("idODERowSelection", this.idODERowSelection);
        builder.append("listODEs", this.listODEs);
        builder.append("origen", this.origen);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.idODERowSelection = null;
        this.listODEs = null;
        this.listODEsValueList = null;
        this.listODEsLabelList = null;
        this.origen = null;
        this.origenValueList = null;
        this.origenLabelList = null;
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
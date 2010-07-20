// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo;

public class UsosEducativosFormCancelarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.CancelarForm
{
    private java.util.Collection listadoUsosEdu;
    private java.lang.Object[] listadoUsosEduValueList;
    private java.lang.Object[] listadoUsosEduLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;

    public UsosEducativosFormCancelarFormImpl()
    {
    }

    /**
     * Resets the given <code>listadoUsosEdu</code>.
     */
    public void resetListadoUsosEdu()
    {
        this.listadoUsosEdu = null;
    }

    public void setListadoUsosEdu(java.util.Collection listadoUsosEdu)
    {
        this.listadoUsosEdu = listadoUsosEdu;
    }

    /**
     * 
     */
    public java.util.Collection getListadoUsosEdu()
    {
        return this.listadoUsosEdu;
    }

    public void setListadoUsosEduAsArray(Object[] listadoUsosEdu)
    {
        this.listadoUsosEdu = (listadoUsosEdu == null) ? null : java.util.Arrays.asList(listadoUsosEdu);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.usoeducativo.UsosEducativosFormCancelarFormImpl#getListadoUsosEdu
     */
    public java.lang.Object[] getListadoUsosEduAsArray()
    {
        return (listadoUsosEdu == null) ? null : listadoUsosEdu.toArray();
    }
    
    public java.lang.Object[] getListadoUsosEduBackingList()
    {
        java.lang.Object[] values = this.listadoUsosEduValueList;
        java.lang.Object[] labels = this.listadoUsosEduLabelList;

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

    public java.lang.Object[] getListadoUsosEduValueList()
    {
        return this.listadoUsosEduValueList;
    }

    public void setListadoUsosEduValueList(java.lang.Object[] listadoUsosEduValueList)
    {
        this.listadoUsosEduValueList = listadoUsosEduValueList;
    }

    public java.lang.Object[] getListadoUsosEduLabelList()
    {
        return this.listadoUsosEduLabelList;
    }

    public void setListadoUsosEduLabelList(java.lang.Object[] listadoUsosEduLabelList)
    {
        this.listadoUsosEduLabelList = listadoUsosEduLabelList;
    }

    public void setListadoUsosEduBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("UsosEducativosFormCancelarFormImpl.setListadoUsosEduBackingList requires non-null property arguments");
        }

        this.listadoUsosEduValueList = null;
        this.listadoUsosEduLabelList = null;

        if (items != null)
        {
            this.listadoUsosEduValueList = new java.lang.Object[items.size()];
            this.listadoUsosEduLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listadoUsosEduValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listadoUsosEduLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("UsosEducativosFormCancelarFormImpl.setListadoUsosEduBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificadorOde</code>.
     */
    public void resetIdentificadorOde()
    {
        this.identificadorOde = null;
    }

    public void setIdentificadorOde(java.lang.String identificadorOde)
    {
        this.identificadorOde = identificadorOde;
    }

    /**
     * 
     */
    public java.lang.String getIdentificadorOde()
    {
        return this.identificadorOde;
    }
    
    public java.lang.Object[] getIdentificadorOdeBackingList()
    {
        java.lang.Object[] values = this.identificadorOdeValueList;
        java.lang.Object[] labels = this.identificadorOdeLabelList;

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

    public java.lang.Object[] getIdentificadorOdeValueList()
    {
        return this.identificadorOdeValueList;
    }

    public void setIdentificadorOdeValueList(java.lang.Object[] identificadorOdeValueList)
    {
        this.identificadorOdeValueList = identificadorOdeValueList;
    }

    public java.lang.Object[] getIdentificadorOdeLabelList()
    {
        return this.identificadorOdeLabelList;
    }

    public void setIdentificadorOdeLabelList(java.lang.Object[] identificadorOdeLabelList)
    {
        this.identificadorOdeLabelList = identificadorOdeLabelList;
    }

    public void setIdentificadorOdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("UsosEducativosFormCancelarFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
        }

        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;

        if (items != null)
        {
            this.identificadorOdeValueList = new java.lang.Object[items.size()];
            this.identificadorOdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadorOdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadorOdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("UsosEducativosFormCancelarFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.listadoUsosEdu = null;
        this.listadoUsosEduValueList = new java.lang.Object[0];
        this.listadoUsosEduLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("listadoUsosEdu", this.listadoUsosEdu);
        builder.append("identificadorOde", this.identificadorOde);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.listadoUsosEdu = null;
        this.listadoUsosEduValueList = null;
        this.listadoUsosEduLabelList = null;
        this.identificadorOde = null;
        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;
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
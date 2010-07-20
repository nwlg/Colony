// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion;

public class ListadoAnotacionesFormInicioAvanzadoFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.CancelarForm
{
    private java.lang.String tituloAnotacion;
    private java.lang.Object[] tituloAnotacionValueList;
    private java.lang.Object[] tituloAnotacionLabelList;
    private java.util.Collection listadoAnotaciones;
    private java.lang.Object[] listadoAnotacionesValueList;
    private java.lang.Object[] listadoAnotacionesLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;

    public ListadoAnotacionesFormInicioAvanzadoFormImpl()
    {
    }

    /**
     * Resets the given <code>tituloAnotacion</code>.
     */
    public void resetTituloAnotacion()
    {
        this.tituloAnotacion = null;
    }

    public void setTituloAnotacion(java.lang.String tituloAnotacion)
    {
        this.tituloAnotacion = tituloAnotacion;
    }

    /**
     * 
     */
    public java.lang.String getTituloAnotacion()
    {
        return this.tituloAnotacion;
    }
    
    public java.lang.Object[] getTituloAnotacionBackingList()
    {
        java.lang.Object[] values = this.tituloAnotacionValueList;
        java.lang.Object[] labels = this.tituloAnotacionLabelList;

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

    public java.lang.Object[] getTituloAnotacionValueList()
    {
        return this.tituloAnotacionValueList;
    }

    public void setTituloAnotacionValueList(java.lang.Object[] tituloAnotacionValueList)
    {
        this.tituloAnotacionValueList = tituloAnotacionValueList;
    }

    public java.lang.Object[] getTituloAnotacionLabelList()
    {
        return this.tituloAnotacionLabelList;
    }

    public void setTituloAnotacionLabelList(java.lang.Object[] tituloAnotacionLabelList)
    {
        this.tituloAnotacionLabelList = tituloAnotacionLabelList;
    }

    public void setTituloAnotacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoAnotacionesFormInicioAvanzadoFormImpl.setTituloAnotacionBackingList requires non-null property arguments");
        }

        this.tituloAnotacionValueList = null;
        this.tituloAnotacionLabelList = null;

        if (items != null)
        {
            this.tituloAnotacionValueList = new java.lang.Object[items.size()];
            this.tituloAnotacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tituloAnotacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tituloAnotacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoAnotacionesFormInicioAvanzadoFormImpl.setTituloAnotacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listadoAnotaciones</code>.
     */
    public void resetListadoAnotaciones()
    {
        this.listadoAnotaciones = null;
    }

    public void setListadoAnotaciones(java.util.Collection listadoAnotaciones)
    {
        this.listadoAnotaciones = listadoAnotaciones;
    }

    /**
     * 
     */
    public java.util.Collection getListadoAnotaciones()
    {
        return this.listadoAnotaciones;
    }

    public void setListadoAnotacionesAsArray(Object[] listadoAnotaciones)
    {
        this.listadoAnotaciones = (listadoAnotaciones == null) ? null : java.util.Arrays.asList(listadoAnotaciones);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion.ListadoAnotacionesFormInicioAvanzadoFormImpl#getListadoAnotaciones
     */
    public java.lang.Object[] getListadoAnotacionesAsArray()
    {
        return (listadoAnotaciones == null) ? null : listadoAnotaciones.toArray();
    }
    
    public java.lang.Object[] getListadoAnotacionesBackingList()
    {
        java.lang.Object[] values = this.listadoAnotacionesValueList;
        java.lang.Object[] labels = this.listadoAnotacionesLabelList;

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

    public java.lang.Object[] getListadoAnotacionesValueList()
    {
        return this.listadoAnotacionesValueList;
    }

    public void setListadoAnotacionesValueList(java.lang.Object[] listadoAnotacionesValueList)
    {
        this.listadoAnotacionesValueList = listadoAnotacionesValueList;
    }

    public java.lang.Object[] getListadoAnotacionesLabelList()
    {
        return this.listadoAnotacionesLabelList;
    }

    public void setListadoAnotacionesLabelList(java.lang.Object[] listadoAnotacionesLabelList)
    {
        this.listadoAnotacionesLabelList = listadoAnotacionesLabelList;
    }

    public void setListadoAnotacionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ListadoAnotacionesFormInicioAvanzadoFormImpl.setListadoAnotacionesBackingList requires non-null property arguments");
        }

        this.listadoAnotacionesValueList = null;
        this.listadoAnotacionesLabelList = null;

        if (items != null)
        {
            this.listadoAnotacionesValueList = new java.lang.Object[items.size()];
            this.listadoAnotacionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listadoAnotacionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listadoAnotacionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ListadoAnotacionesFormInicioAvanzadoFormImpl.setListadoAnotacionesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ListadoAnotacionesFormInicioAvanzadoFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ListadoAnotacionesFormInicioAvanzadoFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.listadoAnotaciones = null;
        this.listadoAnotacionesValueList = new java.lang.Object[0];
        this.listadoAnotacionesLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("tituloAnotacion", this.tituloAnotacion);
        builder.append("listadoAnotaciones", this.listadoAnotaciones);
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
        this.tituloAnotacion = null;
        this.tituloAnotacionValueList = null;
        this.tituloAnotacionLabelList = null;
        this.listadoAnotaciones = null;
        this.listadoAnotacionesValueList = null;
        this.listadoAnotacionesLabelList = null;
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
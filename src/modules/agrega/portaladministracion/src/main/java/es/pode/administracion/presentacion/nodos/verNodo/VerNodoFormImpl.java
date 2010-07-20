// license-header java merge-point
package es.pode.administracion.presentacion.nodos.verNodo;

public class VerNodoFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.nodos.verNodo.CargarNodoForm
{
    private java.lang.Long id;
    private java.lang.Object[] idValueList;
    private java.lang.Object[] idLabelList;
    private java.lang.String idNodo;
    private java.lang.Object[] idNodoValueList;
    private java.lang.Object[] idNodoLabelList;
    private java.lang.Long ccaa;
    private java.lang.Object[] ccaaValueList;
    private java.lang.Object[] ccaaLabelList;
    private java.lang.String puerto;
    private java.lang.Object[] puertoValueList;
    private java.lang.Object[] puertoLabelList;
    private java.lang.String nodo;
    private java.lang.Object[] nodoValueList;
    private java.lang.Object[] nodoLabelList;
    private java.lang.String comunidad;
    private java.lang.Object[] comunidadValueList;
    private java.lang.Object[] comunidadLabelList;
    private java.lang.String url;
    private java.lang.Object[] urlValueList;
    private java.lang.Object[] urlLabelList;
    private java.lang.String urlWS;
    private java.lang.Object[] urlWSValueList;
    private java.lang.Object[] urlWSLabelList;

    public VerNodoFormImpl()
    {
    }

    /**
     * Resets the given <code>id</code>.
     */
    public void resetId()
    {
        this.id = null;
    }

    public void setId(java.lang.Long id)
    {
        this.id = id;
    }

    /**
     * 
     */
    public java.lang.Long getId()
    {
        return this.id;
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
            throw new IllegalArgumentException("VerNodoFormImpl.setIdBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("VerNodoFormImpl.setIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idNodo</code>.
     */
    public void resetIdNodo()
    {
        this.idNodo = null;
    }

    public void setIdNodo(java.lang.String idNodo)
    {
        this.idNodo = idNodo;
    }

    /**
     * 
     */
    public java.lang.String getIdNodo()
    {
        return this.idNodo;
    }
    
    public java.lang.Object[] getIdNodoBackingList()
    {
        java.lang.Object[] values = this.idNodoValueList;
        java.lang.Object[] labels = this.idNodoLabelList;

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

    public java.lang.Object[] getIdNodoValueList()
    {
        return this.idNodoValueList;
    }

    public void setIdNodoValueList(java.lang.Object[] idNodoValueList)
    {
        this.idNodoValueList = idNodoValueList;
    }

    public java.lang.Object[] getIdNodoLabelList()
    {
        return this.idNodoLabelList;
    }

    public void setIdNodoLabelList(java.lang.Object[] idNodoLabelList)
    {
        this.idNodoLabelList = idNodoLabelList;
    }

    public void setIdNodoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("VerNodoFormImpl.setIdNodoBackingList requires non-null property arguments");
        }

        this.idNodoValueList = null;
        this.idNodoLabelList = null;

        if (items != null)
        {
            this.idNodoValueList = new java.lang.Object[items.size()];
            this.idNodoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idNodoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idNodoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("VerNodoFormImpl.setIdNodoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ccaa</code>.
     */
    public void resetCcaa()
    {
        this.ccaa = null;
    }

    public void setCcaa(java.lang.Long ccaa)
    {
        this.ccaa = ccaa;
    }

    /**
     * 
     */
    public java.lang.Long getCcaa()
    {
        return this.ccaa;
    }
    
    public java.lang.Object[] getCcaaBackingList()
    {
        java.lang.Object[] values = this.ccaaValueList;
        java.lang.Object[] labels = this.ccaaLabelList;

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

    public java.lang.Object[] getCcaaValueList()
    {
        return this.ccaaValueList;
    }

    public void setCcaaValueList(java.lang.Object[] ccaaValueList)
    {
        this.ccaaValueList = ccaaValueList;
    }

    public java.lang.Object[] getCcaaLabelList()
    {
        return this.ccaaLabelList;
    }

    public void setCcaaLabelList(java.lang.Object[] ccaaLabelList)
    {
        this.ccaaLabelList = ccaaLabelList;
    }

    public void setCcaaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("VerNodoFormImpl.setCcaaBackingList requires non-null property arguments");
        }

        this.ccaaValueList = null;
        this.ccaaLabelList = null;

        if (items != null)
        {
            this.ccaaValueList = new java.lang.Object[items.size()];
            this.ccaaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.ccaaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.ccaaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("VerNodoFormImpl.setCcaaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>puerto</code>.
     */
    public void resetPuerto()
    {
        this.puerto = null;
    }

    public void setPuerto(java.lang.String puerto)
    {
        this.puerto = puerto;
    }

    /**
     * 
     */
    public java.lang.String getPuerto()
    {
        return this.puerto;
    }
    
    public java.lang.Object[] getPuertoBackingList()
    {
        java.lang.Object[] values = this.puertoValueList;
        java.lang.Object[] labels = this.puertoLabelList;

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

    public java.lang.Object[] getPuertoValueList()
    {
        return this.puertoValueList;
    }

    public void setPuertoValueList(java.lang.Object[] puertoValueList)
    {
        this.puertoValueList = puertoValueList;
    }

    public java.lang.Object[] getPuertoLabelList()
    {
        return this.puertoLabelList;
    }

    public void setPuertoLabelList(java.lang.Object[] puertoLabelList)
    {
        this.puertoLabelList = puertoLabelList;
    }

    public void setPuertoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("VerNodoFormImpl.setPuertoBackingList requires non-null property arguments");
        }

        this.puertoValueList = null;
        this.puertoLabelList = null;

        if (items != null)
        {
            this.puertoValueList = new java.lang.Object[items.size()];
            this.puertoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.puertoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.puertoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("VerNodoFormImpl.setPuertoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nodo</code>.
     */
    public void resetNodo()
    {
        this.nodo = null;
    }

    public void setNodo(java.lang.String nodo)
    {
        this.nodo = nodo;
    }

    /**
     * 
     */
    public java.lang.String getNodo()
    {
        return this.nodo;
    }
    
    public java.lang.Object[] getNodoBackingList()
    {
        java.lang.Object[] values = this.nodoValueList;
        java.lang.Object[] labels = this.nodoLabelList;

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

    public java.lang.Object[] getNodoValueList()
    {
        return this.nodoValueList;
    }

    public void setNodoValueList(java.lang.Object[] nodoValueList)
    {
        this.nodoValueList = nodoValueList;
    }

    public java.lang.Object[] getNodoLabelList()
    {
        return this.nodoLabelList;
    }

    public void setNodoLabelList(java.lang.Object[] nodoLabelList)
    {
        this.nodoLabelList = nodoLabelList;
    }

    public void setNodoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("VerNodoFormImpl.setNodoBackingList requires non-null property arguments");
        }

        this.nodoValueList = null;
        this.nodoLabelList = null;

        if (items != null)
        {
            this.nodoValueList = new java.lang.Object[items.size()];
            this.nodoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nodoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nodoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("VerNodoFormImpl.setNodoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comunidad</code>.
     */
    public void resetComunidad()
    {
        this.comunidad = null;
    }

    public void setComunidad(java.lang.String comunidad)
    {
        this.comunidad = comunidad;
    }

    /**
     * 
     */
    public java.lang.String getComunidad()
    {
        return this.comunidad;
    }
    
    public java.lang.Object[] getComunidadBackingList()
    {
        java.lang.Object[] values = this.comunidadValueList;
        java.lang.Object[] labels = this.comunidadLabelList;

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

    public java.lang.Object[] getComunidadValueList()
    {
        return this.comunidadValueList;
    }

    public void setComunidadValueList(java.lang.Object[] comunidadValueList)
    {
        this.comunidadValueList = comunidadValueList;
    }

    public java.lang.Object[] getComunidadLabelList()
    {
        return this.comunidadLabelList;
    }

    public void setComunidadLabelList(java.lang.Object[] comunidadLabelList)
    {
        this.comunidadLabelList = comunidadLabelList;
    }

    public void setComunidadBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("VerNodoFormImpl.setComunidadBackingList requires non-null property arguments");
        }

        this.comunidadValueList = null;
        this.comunidadLabelList = null;

        if (items != null)
        {
            this.comunidadValueList = new java.lang.Object[items.size()];
            this.comunidadLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comunidadValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comunidadLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("VerNodoFormImpl.setComunidadBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>url</code>.
     */
    public void resetUrl()
    {
        this.url = null;
    }

    public void setUrl(java.lang.String url)
    {
        this.url = url;
    }

    /**
     * 
     */
    public java.lang.String getUrl()
    {
        return this.url;
    }
    
    public java.lang.Object[] getUrlBackingList()
    {
        java.lang.Object[] values = this.urlValueList;
        java.lang.Object[] labels = this.urlLabelList;

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

    public java.lang.Object[] getUrlValueList()
    {
        return this.urlValueList;
    }

    public void setUrlValueList(java.lang.Object[] urlValueList)
    {
        this.urlValueList = urlValueList;
    }

    public java.lang.Object[] getUrlLabelList()
    {
        return this.urlLabelList;
    }

    public void setUrlLabelList(java.lang.Object[] urlLabelList)
    {
        this.urlLabelList = urlLabelList;
    }

    public void setUrlBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("VerNodoFormImpl.setUrlBackingList requires non-null property arguments");
        }

        this.urlValueList = null;
        this.urlLabelList = null;

        if (items != null)
        {
            this.urlValueList = new java.lang.Object[items.size()];
            this.urlLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.urlValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.urlLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("VerNodoFormImpl.setUrlBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>urlWS</code>.
     */
    public void resetUrlWS()
    {
        this.urlWS = null;
    }

    public void setUrlWS(java.lang.String urlWS)
    {
        this.urlWS = urlWS;
    }

    /**
     * 
     */
    public java.lang.String getUrlWS()
    {
        return this.urlWS;
    }
    
    public java.lang.Object[] getUrlWSBackingList()
    {
        java.lang.Object[] values = this.urlWSValueList;
        java.lang.Object[] labels = this.urlWSLabelList;

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

    public java.lang.Object[] getUrlWSValueList()
    {
        return this.urlWSValueList;
    }

    public void setUrlWSValueList(java.lang.Object[] urlWSValueList)
    {
        this.urlWSValueList = urlWSValueList;
    }

    public java.lang.Object[] getUrlWSLabelList()
    {
        return this.urlWSLabelList;
    }

    public void setUrlWSLabelList(java.lang.Object[] urlWSLabelList)
    {
        this.urlWSLabelList = urlWSLabelList;
    }

    public void setUrlWSBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("VerNodoFormImpl.setUrlWSBackingList requires non-null property arguments");
        }

        this.urlWSValueList = null;
        this.urlWSLabelList = null;

        if (items != null)
        {
            this.urlWSValueList = new java.lang.Object[items.size()];
            this.urlWSLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.urlWSValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.urlWSLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("VerNodoFormImpl.setUrlWSBackingList encountered an exception", ex);
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
        builder.append("id", this.id);
        builder.append("idNodo", this.idNodo);
        builder.append("ccaa", this.ccaa);
        builder.append("puerto", this.puerto);
        builder.append("nodo", this.nodo);
        builder.append("comunidad", this.comunidad);
        builder.append("url", this.url);
        builder.append("urlWS", this.urlWS);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.id = null;
        this.idValueList = null;
        this.idLabelList = null;
        this.idNodo = null;
        this.idNodoValueList = null;
        this.idNodoLabelList = null;
        this.ccaa = null;
        this.ccaaValueList = null;
        this.ccaaLabelList = null;
        this.puerto = null;
        this.puertoValueList = null;
        this.puertoLabelList = null;
        this.nodo = null;
        this.nodoValueList = null;
        this.nodoLabelList = null;
        this.comunidad = null;
        this.comunidadValueList = null;
        this.comunidadLabelList = null;
        this.url = null;
        this.urlValueList = null;
        this.urlLabelList = null;
        this.urlWS = null;
        this.urlWSValueList = null;
        this.urlWSLabelList = null;
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
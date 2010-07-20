// license-header java merge-point
package es.pode.oaipmh.presentacion.pmhServer;

public class OaiPmhRequestFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.oaipmh.presentacion.pmhServer.ObtenerResultadoOAIRequestForm
        , es.pode.oaipmh.presentacion.pmhServer.ObtenerParametrosForm
        , es.pode.oaipmh.presentacion.pmhServer.IdentifyForm
        , es.pode.oaipmh.presentacion.pmhServer.GetRecordForm
        , es.pode.oaipmh.presentacion.pmhServer.ListMetadataFormatForm
        , es.pode.oaipmh.presentacion.pmhServer.ListIdentifiersForm
        , es.pode.oaipmh.presentacion.pmhServer.ListSetsForm
        , es.pode.oaipmh.presentacion.pmhServer.ListRecordsForm
        , es.pode.oaipmh.presentacion.pmhServer.ObtenerRespuestaProtocoloForm
        , es.pode.oaipmh.presentacion.pmhServer.AnalizaPeticionForm
{
    private es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest resultadoOAIRequest;
    private java.lang.Object[] resultadoOAIRequestValueList;
    private java.lang.Object[] resultadoOAIRequestLabelList;
    private java.lang.String errorCode;
    private java.lang.Object[] errorCodeValueList;
    private java.lang.Object[] errorCodeLabelList;
    private es.pode.oaipmh.presentacion.pmhServer.ParametrosRequestVO parametrosRequestVO;
    private java.lang.Object[] parametrosRequestVOValueList;
    private java.lang.Object[] parametrosRequestVOLabelList;

    public OaiPmhRequestFormImpl()
    {
    }

    /**
     * Resets the given <code>resultadoOAIRequest</code>.
     */
    public void resetResultadoOAIRequest()
    {
        this.resultadoOAIRequest = null;
    }

    public void setResultadoOAIRequest(es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest resultadoOAIRequest)
    {
        this.resultadoOAIRequest = resultadoOAIRequest;
    }

    /**
     * 
     */
    public es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest getResultadoOAIRequest()
    {
        return this.resultadoOAIRequest;
    }
    
    public java.lang.Object[] getResultadoOAIRequestBackingList()
    {
        java.lang.Object[] values = this.resultadoOAIRequestValueList;
        java.lang.Object[] labels = this.resultadoOAIRequestLabelList;

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

    public java.lang.Object[] getResultadoOAIRequestValueList()
    {
        return this.resultadoOAIRequestValueList;
    }

    public void setResultadoOAIRequestValueList(java.lang.Object[] resultadoOAIRequestValueList)
    {
        this.resultadoOAIRequestValueList = resultadoOAIRequestValueList;
    }

    public java.lang.Object[] getResultadoOAIRequestLabelList()
    {
        return this.resultadoOAIRequestLabelList;
    }

    public void setResultadoOAIRequestLabelList(java.lang.Object[] resultadoOAIRequestLabelList)
    {
        this.resultadoOAIRequestLabelList = resultadoOAIRequestLabelList;
    }

    public void setResultadoOAIRequestBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("OaiPmhRequestFormImpl.setResultadoOAIRequestBackingList requires non-null property arguments");
        }

        this.resultadoOAIRequestValueList = null;
        this.resultadoOAIRequestLabelList = null;

        if (items != null)
        {
            this.resultadoOAIRequestValueList = new java.lang.Object[items.size()];
            this.resultadoOAIRequestLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resultadoOAIRequestValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resultadoOAIRequestLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("OaiPmhRequestFormImpl.setResultadoOAIRequestBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>errorCode</code>.
     */
    public void resetErrorCode()
    {
        this.errorCode = null;
    }

    public void setErrorCode(java.lang.String errorCode)
    {
        this.errorCode = errorCode;
    }

    /**
     * 
     */
    public java.lang.String getErrorCode()
    {
        return this.errorCode;
    }
    
    public java.lang.Object[] getErrorCodeBackingList()
    {
        java.lang.Object[] values = this.errorCodeValueList;
        java.lang.Object[] labels = this.errorCodeLabelList;

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

    public java.lang.Object[] getErrorCodeValueList()
    {
        return this.errorCodeValueList;
    }

    public void setErrorCodeValueList(java.lang.Object[] errorCodeValueList)
    {
        this.errorCodeValueList = errorCodeValueList;
    }

    public java.lang.Object[] getErrorCodeLabelList()
    {
        return this.errorCodeLabelList;
    }

    public void setErrorCodeLabelList(java.lang.Object[] errorCodeLabelList)
    {
        this.errorCodeLabelList = errorCodeLabelList;
    }

    public void setErrorCodeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("OaiPmhRequestFormImpl.setErrorCodeBackingList requires non-null property arguments");
        }

        this.errorCodeValueList = null;
        this.errorCodeLabelList = null;

        if (items != null)
        {
            this.errorCodeValueList = new java.lang.Object[items.size()];
            this.errorCodeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.errorCodeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.errorCodeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("OaiPmhRequestFormImpl.setErrorCodeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>parametrosRequestVO</code>.
     */
    public void resetParametrosRequestVO()
    {
        this.parametrosRequestVO = null;
    }

    public void setParametrosRequestVO(es.pode.oaipmh.presentacion.pmhServer.ParametrosRequestVO parametrosRequestVO)
    {
        this.parametrosRequestVO = parametrosRequestVO;
    }

    /**
     * 
     */
    public es.pode.oaipmh.presentacion.pmhServer.ParametrosRequestVO getParametrosRequestVO()
    {
        return this.parametrosRequestVO;
    }
    
    public java.lang.Object[] getParametrosRequestVOBackingList()
    {
        java.lang.Object[] values = this.parametrosRequestVOValueList;
        java.lang.Object[] labels = this.parametrosRequestVOLabelList;

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

    public java.lang.Object[] getParametrosRequestVOValueList()
    {
        return this.parametrosRequestVOValueList;
    }

    public void setParametrosRequestVOValueList(java.lang.Object[] parametrosRequestVOValueList)
    {
        this.parametrosRequestVOValueList = parametrosRequestVOValueList;
    }

    public java.lang.Object[] getParametrosRequestVOLabelList()
    {
        return this.parametrosRequestVOLabelList;
    }

    public void setParametrosRequestVOLabelList(java.lang.Object[] parametrosRequestVOLabelList)
    {
        this.parametrosRequestVOLabelList = parametrosRequestVOLabelList;
    }

    public void setParametrosRequestVOBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("OaiPmhRequestFormImpl.setParametrosRequestVOBackingList requires non-null property arguments");
        }

        this.parametrosRequestVOValueList = null;
        this.parametrosRequestVOLabelList = null;

        if (items != null)
        {
            this.parametrosRequestVOValueList = new java.lang.Object[items.size()];
            this.parametrosRequestVOLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.parametrosRequestVOValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.parametrosRequestVOLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("OaiPmhRequestFormImpl.setParametrosRequestVOBackingList encountered an exception", ex);
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
        builder.append("resultadoOAIRequest", this.resultadoOAIRequest);
        builder.append("errorCode", this.errorCode);
        builder.append("parametrosRequestVO", this.parametrosRequestVO);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.resultadoOAIRequest = null;
        this.resultadoOAIRequestValueList = null;
        this.resultadoOAIRequestLabelList = null;
        this.errorCode = null;
        this.errorCodeValueList = null;
        this.errorCodeLabelList = null;
        this.parametrosRequestVO = null;
        this.parametrosRequestVOValueList = null;
        this.parametrosRequestVOLabelList = null;
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
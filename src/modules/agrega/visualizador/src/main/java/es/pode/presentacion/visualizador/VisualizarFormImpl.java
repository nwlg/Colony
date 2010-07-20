// license-header java merge-point
package es.pode.presentacion.visualizador;

public class VisualizarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.presentacion.visualizador.CargarDatosForm
        , es.pode.presentacion.visualizador.CargarDatosNavForm
        , es.pode.presentacion.visualizador.FinSessionForm
        , es.pode.presentacion.visualizador.CargarTipoVisForm
{
    private int contador;
    private java.lang.Object[] contadorValueList;
    private java.lang.Object[] contadorLabelList;
    private java.lang.String idNodo;
    private java.lang.Object[] idNodoValueList;
    private java.lang.Object[] idNodoLabelList;
    private java.lang.Boolean secuencia;
    private java.lang.Object[] secuenciaValueList;
    private java.lang.Object[] secuenciaLabelList;
    private java.lang.String usuario;
    private java.lang.Object[] usuarioValueList;
    private java.lang.Object[] usuarioLabelList;
    private java.lang.String identificador;
    private java.lang.Object[] identificadorValueList;
    private java.lang.Object[] identificadorLabelList;
    private java.util.Collection datosSalida = null;
    private java.lang.Object[] datosSalidaValueList;
    private java.lang.Object[] datosSalidaLabelList;
    private java.lang.String localizacion;
    private java.lang.Object[] localizacionValueList;
    private java.lang.Object[] localizacionLabelList;

    public VisualizarFormImpl()
    {
    }

    /**
     * Resets the given <code>contador</code>.
     */
    public void resetContador()
    {
        this.contador = 0;
    }

    public void setContador(int contador)
    {
        this.contador = contador;
    }

    /**
     * 
     */
    public int getContador()
    {
        return this.contador;
    }
    
    public java.lang.Object[] getContadorBackingList()
    {
        java.lang.Object[] values = this.contadorValueList;
        java.lang.Object[] labels = this.contadorLabelList;

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

    public java.lang.Object[] getContadorValueList()
    {
        return this.contadorValueList;
    }

    public void setContadorValueList(java.lang.Object[] contadorValueList)
    {
        this.contadorValueList = contadorValueList;
    }

    public java.lang.Object[] getContadorLabelList()
    {
        return this.contadorLabelList;
    }

    public void setContadorLabelList(java.lang.Object[] contadorLabelList)
    {
        this.contadorLabelList = contadorLabelList;
    }

    public void setContadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("VisualizarFormImpl.setContadorBackingList requires non-null property arguments");
        }

        this.contadorValueList = null;
        this.contadorLabelList = null;

        if (items != null)
        {
            this.contadorValueList = new java.lang.Object[items.size()];
            this.contadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.contadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.contadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("VisualizarFormImpl.setContadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("VisualizarFormImpl.setIdNodoBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("VisualizarFormImpl.setIdNodoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>secuencia</code>.
     */
    public void resetSecuencia()
    {
        this.secuencia = null;
    }

    public void setSecuencia(java.lang.Boolean secuencia)
    {
        this.secuencia = secuencia;
    }

    /**
     * 
     */
    public java.lang.Boolean getSecuencia()
    {
        return this.secuencia;
    }
    
    public java.lang.Object[] getSecuenciaBackingList()
    {
        java.lang.Object[] values = this.secuenciaValueList;
        java.lang.Object[] labels = this.secuenciaLabelList;

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

    public java.lang.Object[] getSecuenciaValueList()
    {
        return this.secuenciaValueList;
    }

    public void setSecuenciaValueList(java.lang.Object[] secuenciaValueList)
    {
        this.secuenciaValueList = secuenciaValueList;
    }

    public java.lang.Object[] getSecuenciaLabelList()
    {
        return this.secuenciaLabelList;
    }

    public void setSecuenciaLabelList(java.lang.Object[] secuenciaLabelList)
    {
        this.secuenciaLabelList = secuenciaLabelList;
    }

    public void setSecuenciaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("VisualizarFormImpl.setSecuenciaBackingList requires non-null property arguments");
        }

        this.secuenciaValueList = null;
        this.secuenciaLabelList = null;

        if (items != null)
        {
            this.secuenciaValueList = new java.lang.Object[items.size()];
            this.secuenciaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.secuenciaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.secuenciaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("VisualizarFormImpl.setSecuenciaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>usuario</code>.
     */
    public void resetUsuario()
    {
        this.usuario = null;
    }

    public void setUsuario(java.lang.String usuario)
    {
        this.usuario = usuario;
    }

    /**
     * 
     */
    public java.lang.String getUsuario()
    {
        return this.usuario;
    }
    
    public java.lang.Object[] getUsuarioBackingList()
    {
        java.lang.Object[] values = this.usuarioValueList;
        java.lang.Object[] labels = this.usuarioLabelList;

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

    public java.lang.Object[] getUsuarioValueList()
    {
        return this.usuarioValueList;
    }

    public void setUsuarioValueList(java.lang.Object[] usuarioValueList)
    {
        this.usuarioValueList = usuarioValueList;
    }

    public java.lang.Object[] getUsuarioLabelList()
    {
        return this.usuarioLabelList;
    }

    public void setUsuarioLabelList(java.lang.Object[] usuarioLabelList)
    {
        this.usuarioLabelList = usuarioLabelList;
    }

    public void setUsuarioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("VisualizarFormImpl.setUsuarioBackingList requires non-null property arguments");
        }

        this.usuarioValueList = null;
        this.usuarioLabelList = null;

        if (items != null)
        {
            this.usuarioValueList = new java.lang.Object[items.size()];
            this.usuarioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.usuarioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.usuarioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("VisualizarFormImpl.setUsuarioBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificador</code>.
     */
    public void resetIdentificador()
    {
        this.identificador = null;
    }

    public void setIdentificador(java.lang.String identificador)
    {
        this.identificador = identificador;
    }

    /**
     * 
     */
    public java.lang.String getIdentificador()
    {
        return this.identificador;
    }
    
    public java.lang.Object[] getIdentificadorBackingList()
    {
        java.lang.Object[] values = this.identificadorValueList;
        java.lang.Object[] labels = this.identificadorLabelList;

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

    public java.lang.Object[] getIdentificadorValueList()
    {
        return this.identificadorValueList;
    }

    public void setIdentificadorValueList(java.lang.Object[] identificadorValueList)
    {
        this.identificadorValueList = identificadorValueList;
    }

    public java.lang.Object[] getIdentificadorLabelList()
    {
        return this.identificadorLabelList;
    }

    public void setIdentificadorLabelList(java.lang.Object[] identificadorLabelList)
    {
        this.identificadorLabelList = identificadorLabelList;
    }

    public void setIdentificadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("VisualizarFormImpl.setIdentificadorBackingList requires non-null property arguments");
        }

        this.identificadorValueList = null;
        this.identificadorLabelList = null;

        if (items != null)
        {
            this.identificadorValueList = new java.lang.Object[items.size()];
            this.identificadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("VisualizarFormImpl.setIdentificadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>datosSalida</code>.
     */
    public void resetDatosSalida()
    {
        this.datosSalida = null;
    }

    public void setDatosSalida(java.util.Collection datosSalida)
    {
        this.datosSalida = datosSalida;
    }

    /**
     * 
     */
    public java.util.Collection getDatosSalida()
    {
        return this.datosSalida;
    }

    public void setDatosSalidaAsArray(Object[] datosSalida)
    {
        this.datosSalida = (datosSalida == null) ? null : java.util.Arrays.asList(datosSalida);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.presentacion.visualizador.VisualizarFormImpl#getDatosSalida
     */
    public java.lang.Object[] getDatosSalidaAsArray()
    {
        return (datosSalida == null) ? null : datosSalida.toArray();
    }
    
    public java.lang.Object[] getDatosSalidaBackingList()
    {
        java.lang.Object[] values = this.datosSalidaValueList;
        java.lang.Object[] labels = this.datosSalidaLabelList;

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

    public java.lang.Object[] getDatosSalidaValueList()
    {
        return this.datosSalidaValueList;
    }

    public void setDatosSalidaValueList(java.lang.Object[] datosSalidaValueList)
    {
        this.datosSalidaValueList = datosSalidaValueList;
    }

    public java.lang.Object[] getDatosSalidaLabelList()
    {
        return this.datosSalidaLabelList;
    }

    public void setDatosSalidaLabelList(java.lang.Object[] datosSalidaLabelList)
    {
        this.datosSalidaLabelList = datosSalidaLabelList;
    }

    public void setDatosSalidaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("VisualizarFormImpl.setDatosSalidaBackingList requires non-null property arguments");
        }

        this.datosSalidaValueList = null;
        this.datosSalidaLabelList = null;

        if (items != null)
        {
            this.datosSalidaValueList = new java.lang.Object[items.size()];
            this.datosSalidaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.datosSalidaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.datosSalidaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("VisualizarFormImpl.setDatosSalidaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>localizacion</code>.
     */
    public void resetLocalizacion()
    {
        this.localizacion = null;
    }

    public void setLocalizacion(java.lang.String localizacion)
    {
        this.localizacion = localizacion;
    }

    /**
     * 
     */
    public java.lang.String getLocalizacion()
    {
        return this.localizacion;
    }
    
    public java.lang.Object[] getLocalizacionBackingList()
    {
        java.lang.Object[] values = this.localizacionValueList;
        java.lang.Object[] labels = this.localizacionLabelList;

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

    public java.lang.Object[] getLocalizacionValueList()
    {
        return this.localizacionValueList;
    }

    public void setLocalizacionValueList(java.lang.Object[] localizacionValueList)
    {
        this.localizacionValueList = localizacionValueList;
    }

    public java.lang.Object[] getLocalizacionLabelList()
    {
        return this.localizacionLabelList;
    }

    public void setLocalizacionLabelList(java.lang.Object[] localizacionLabelList)
    {
        this.localizacionLabelList = localizacionLabelList;
    }

    public void setLocalizacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("VisualizarFormImpl.setLocalizacionBackingList requires non-null property arguments");
        }

        this.localizacionValueList = null;
        this.localizacionLabelList = null;

        if (items != null)
        {
            this.localizacionValueList = new java.lang.Object[items.size()];
            this.localizacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.localizacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.localizacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("VisualizarFormImpl.setLocalizacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.secuencia = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("contador", this.contador);
        builder.append("idNodo", this.idNodo);
        builder.append("secuencia", this.secuencia);
        builder.append("usuario", this.usuario);
        builder.append("identificador", this.identificador);
        builder.append("datosSalida", this.datosSalida);
        builder.append("localizacion", this.localizacion);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.contador = 0;
        this.contadorValueList = null;
        this.contadorLabelList = null;
        this.idNodo = null;
        this.idNodoValueList = null;
        this.idNodoLabelList = null;
        this.secuencia = null;
        this.secuenciaValueList = null;
        this.secuenciaLabelList = null;
        this.usuario = null;
        this.usuarioValueList = null;
        this.usuarioLabelList = null;
        this.identificador = null;
        this.identificadorValueList = null;
        this.identificadorLabelList = null;
        this.datosSalida = null;
        this.datosSalidaValueList = null;
        this.datosSalidaLabelList = null;
        this.localizacion = null;
        this.localizacionValueList = null;
        this.localizacionLabelList = null;
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
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar;

public class PublicarODEModificarLicenciaFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.CargaFormularoLicenciasForm
{
    private java.util.Collection licencias;
    private java.lang.Object[] licenciasValueList;
    private java.lang.Object[] licenciasLabelList;
    private java.util.Collection comunidadesSeleccionadas;
    private java.lang.Object[] comunidadesSeleccionadasValueList;
    private java.lang.Object[] comunidadesSeleccionadasLabelList;
    private java.lang.String universal;
    private java.lang.Object[] universalValueList;
    private java.lang.Object[] universalLabelList;
    private java.lang.String ambito_todas;
    private java.lang.Object[] ambito_todasValueList;
    private java.lang.Object[] ambito_todasLabelList;
    private java.lang.String tipoLicenciaSeleccionada;
    private java.lang.Object[] tipoLicenciaSeleccionadaValueList;
    private java.lang.Object[] tipoLicenciaSeleccionadaLabelList;
    private java.lang.String tipo_licencia;
    private java.lang.Object[] tipo_licenciaValueList;
    private java.lang.Object[] tipo_licenciaLabelList;
    private java.util.Collection comunidades;
    private java.lang.Object[] comunidadesValueList;
    private java.lang.Object[] comunidadesLabelList;

    public PublicarODEModificarLicenciaFormImpl()
    {
    }

    /**
     * Resets the given <code>licencias</code>.
     */
    public void resetLicencias()
    {
        this.licencias = null;
    }

    public void setLicencias(java.util.Collection licencias)
    {
        this.licencias = licencias;
    }

    /**
     * 
     */
    public java.util.Collection getLicencias()
    {
        return this.licencias;
    }

    public void setLicenciasAsArray(Object[] licencias)
    {
        this.licencias = (licencias == null) ? null : java.util.Arrays.asList(licencias);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarODEModificarLicenciaFormImpl#getLicencias
     */
    public java.lang.Object[] getLicenciasAsArray()
    {
        return (licencias == null) ? null : licencias.toArray();
    }
    
    public java.lang.Object[] getLicenciasBackingList()
    {
        java.lang.Object[] values = this.licenciasValueList;
        java.lang.Object[] labels = this.licenciasLabelList;

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

    public java.lang.Object[] getLicenciasValueList()
    {
        return this.licenciasValueList;
    }

    public void setLicenciasValueList(java.lang.Object[] licenciasValueList)
    {
        this.licenciasValueList = licenciasValueList;
    }

    public java.lang.Object[] getLicenciasLabelList()
    {
        return this.licenciasLabelList;
    }

    public void setLicenciasLabelList(java.lang.Object[] licenciasLabelList)
    {
        this.licenciasLabelList = licenciasLabelList;
    }

    public void setLicenciasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarODEModificarLicenciaFormImpl.setLicenciasBackingList requires non-null property arguments");
        }

        this.licenciasValueList = null;
        this.licenciasLabelList = null;

        if (items != null)
        {
            this.licenciasValueList = new java.lang.Object[items.size()];
            this.licenciasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.licenciasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.licenciasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarODEModificarLicenciaFormImpl.setLicenciasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comunidadesSeleccionadas</code>.
     */
    public void resetComunidadesSeleccionadas()
    {
        this.comunidadesSeleccionadas = null;
    }

    public void setComunidadesSeleccionadas(java.util.Collection comunidadesSeleccionadas)
    {
        this.comunidadesSeleccionadas = comunidadesSeleccionadas;
    }

    /**
     * 
     */
    public java.util.Collection getComunidadesSeleccionadas()
    {
        return this.comunidadesSeleccionadas;
    }

    public void setComunidadesSeleccionadasAsArray(Object[] comunidadesSeleccionadas)
    {
        this.comunidadesSeleccionadas = (comunidadesSeleccionadas == null) ? null : java.util.Arrays.asList(comunidadesSeleccionadas);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarODEModificarLicenciaFormImpl#getComunidadesSeleccionadas
     */
    public java.lang.Object[] getComunidadesSeleccionadasAsArray()
    {
        return (comunidadesSeleccionadas == null) ? null : comunidadesSeleccionadas.toArray();
    }
    
    public java.lang.Object[] getComunidadesSeleccionadasBackingList()
    {
        java.lang.Object[] values = this.comunidadesSeleccionadasValueList;
        java.lang.Object[] labels = this.comunidadesSeleccionadasLabelList;

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

    public java.lang.Object[] getComunidadesSeleccionadasValueList()
    {
        return this.comunidadesSeleccionadasValueList;
    }

    public void setComunidadesSeleccionadasValueList(java.lang.Object[] comunidadesSeleccionadasValueList)
    {
        this.comunidadesSeleccionadasValueList = comunidadesSeleccionadasValueList;
    }

    public java.lang.Object[] getComunidadesSeleccionadasLabelList()
    {
        return this.comunidadesSeleccionadasLabelList;
    }

    public void setComunidadesSeleccionadasLabelList(java.lang.Object[] comunidadesSeleccionadasLabelList)
    {
        this.comunidadesSeleccionadasLabelList = comunidadesSeleccionadasLabelList;
    }

    public void setComunidadesSeleccionadasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarODEModificarLicenciaFormImpl.setComunidadesSeleccionadasBackingList requires non-null property arguments");
        }

        this.comunidadesSeleccionadasValueList = null;
        this.comunidadesSeleccionadasLabelList = null;

        if (items != null)
        {
            this.comunidadesSeleccionadasValueList = new java.lang.Object[items.size()];
            this.comunidadesSeleccionadasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comunidadesSeleccionadasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comunidadesSeleccionadasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarODEModificarLicenciaFormImpl.setComunidadesSeleccionadasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>universal</code>.
     */
    public void resetUniversal()
    {
        this.universal = null;
    }

    public void setUniversal(java.lang.String universal)
    {
        this.universal = universal;
    }

    /**
     * 
     */
    public java.lang.String getUniversal()
    {
        return this.universal;
    }
    
    public java.lang.Object[] getUniversalBackingList()
    {
        java.lang.Object[] values = this.universalValueList;
        java.lang.Object[] labels = this.universalLabelList;

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

    public java.lang.Object[] getUniversalValueList()
    {
        return this.universalValueList;
    }

    public void setUniversalValueList(java.lang.Object[] universalValueList)
    {
        this.universalValueList = universalValueList;
    }

    public java.lang.Object[] getUniversalLabelList()
    {
        return this.universalLabelList;
    }

    public void setUniversalLabelList(java.lang.Object[] universalLabelList)
    {
        this.universalLabelList = universalLabelList;
    }

    public void setUniversalBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarODEModificarLicenciaFormImpl.setUniversalBackingList requires non-null property arguments");
        }

        this.universalValueList = null;
        this.universalLabelList = null;

        if (items != null)
        {
            this.universalValueList = new java.lang.Object[items.size()];
            this.universalLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.universalValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.universalLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarODEModificarLicenciaFormImpl.setUniversalBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ambito_todas</code>.
     */
    public void resetAmbito_todas()
    {
        this.ambito_todas = null;
    }

    public void setAmbito_todas(java.lang.String ambito_todas)
    {
        this.ambito_todas = ambito_todas;
    }

    /**
     * 
     */
    public java.lang.String getAmbito_todas()
    {
        return this.ambito_todas;
    }
    
    public java.lang.Object[] getAmbito_todasBackingList()
    {
        java.lang.Object[] values = this.ambito_todasValueList;
        java.lang.Object[] labels = this.ambito_todasLabelList;

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

    public java.lang.Object[] getAmbito_todasValueList()
    {
        return this.ambito_todasValueList;
    }

    public void setAmbito_todasValueList(java.lang.Object[] ambito_todasValueList)
    {
        this.ambito_todasValueList = ambito_todasValueList;
    }

    public java.lang.Object[] getAmbito_todasLabelList()
    {
        return this.ambito_todasLabelList;
    }

    public void setAmbito_todasLabelList(java.lang.Object[] ambito_todasLabelList)
    {
        this.ambito_todasLabelList = ambito_todasLabelList;
    }

    public void setAmbito_todasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarODEModificarLicenciaFormImpl.setAmbito_todasBackingList requires non-null property arguments");
        }

        this.ambito_todasValueList = null;
        this.ambito_todasLabelList = null;

        if (items != null)
        {
            this.ambito_todasValueList = new java.lang.Object[items.size()];
            this.ambito_todasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.ambito_todasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.ambito_todasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarODEModificarLicenciaFormImpl.setAmbito_todasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoLicenciaSeleccionada</code>.
     */
    public void resetTipoLicenciaSeleccionada()
    {
        this.tipoLicenciaSeleccionada = null;
    }

    public void setTipoLicenciaSeleccionada(java.lang.String tipoLicenciaSeleccionada)
    {
        this.tipoLicenciaSeleccionada = tipoLicenciaSeleccionada;
    }

    /**
     * 
     */
    public java.lang.String getTipoLicenciaSeleccionada()
    {
        return this.tipoLicenciaSeleccionada;
    }
    
    public java.lang.Object[] getTipoLicenciaSeleccionadaBackingList()
    {
        java.lang.Object[] values = this.tipoLicenciaSeleccionadaValueList;
        java.lang.Object[] labels = this.tipoLicenciaSeleccionadaLabelList;

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

    public java.lang.Object[] getTipoLicenciaSeleccionadaValueList()
    {
        return this.tipoLicenciaSeleccionadaValueList;
    }

    public void setTipoLicenciaSeleccionadaValueList(java.lang.Object[] tipoLicenciaSeleccionadaValueList)
    {
        this.tipoLicenciaSeleccionadaValueList = tipoLicenciaSeleccionadaValueList;
    }

    public java.lang.Object[] getTipoLicenciaSeleccionadaLabelList()
    {
        return this.tipoLicenciaSeleccionadaLabelList;
    }

    public void setTipoLicenciaSeleccionadaLabelList(java.lang.Object[] tipoLicenciaSeleccionadaLabelList)
    {
        this.tipoLicenciaSeleccionadaLabelList = tipoLicenciaSeleccionadaLabelList;
    }

    public void setTipoLicenciaSeleccionadaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarODEModificarLicenciaFormImpl.setTipoLicenciaSeleccionadaBackingList requires non-null property arguments");
        }

        this.tipoLicenciaSeleccionadaValueList = null;
        this.tipoLicenciaSeleccionadaLabelList = null;

        if (items != null)
        {
            this.tipoLicenciaSeleccionadaValueList = new java.lang.Object[items.size()];
            this.tipoLicenciaSeleccionadaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoLicenciaSeleccionadaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoLicenciaSeleccionadaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarODEModificarLicenciaFormImpl.setTipoLicenciaSeleccionadaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipo_licencia</code>.
     */
    public void resetTipo_licencia()
    {
        this.tipo_licencia = null;
    }

    public void setTipo_licencia(java.lang.String tipo_licencia)
    {
        this.tipo_licencia = tipo_licencia;
    }

    /**
     * 
     */
    public java.lang.String getTipo_licencia()
    {
        return this.tipo_licencia;
    }
    
    public java.lang.Object[] getTipo_licenciaBackingList()
    {
        java.lang.Object[] values = this.tipo_licenciaValueList;
        java.lang.Object[] labels = this.tipo_licenciaLabelList;

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

    public java.lang.Object[] getTipo_licenciaValueList()
    {
        return this.tipo_licenciaValueList;
    }

    public void setTipo_licenciaValueList(java.lang.Object[] tipo_licenciaValueList)
    {
        this.tipo_licenciaValueList = tipo_licenciaValueList;
    }

    public java.lang.Object[] getTipo_licenciaLabelList()
    {
        return this.tipo_licenciaLabelList;
    }

    public void setTipo_licenciaLabelList(java.lang.Object[] tipo_licenciaLabelList)
    {
        this.tipo_licenciaLabelList = tipo_licenciaLabelList;
    }

    public void setTipo_licenciaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarODEModificarLicenciaFormImpl.setTipo_licenciaBackingList requires non-null property arguments");
        }

        this.tipo_licenciaValueList = null;
        this.tipo_licenciaLabelList = null;

        if (items != null)
        {
            this.tipo_licenciaValueList = new java.lang.Object[items.size()];
            this.tipo_licenciaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipo_licenciaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipo_licenciaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarODEModificarLicenciaFormImpl.setTipo_licenciaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comunidades</code>.
     */
    public void resetComunidades()
    {
        this.comunidades = null;
    }

    public void setComunidades(java.util.Collection comunidades)
    {
        this.comunidades = comunidades;
    }

    /**
     * 
     */
    public java.util.Collection getComunidades()
    {
        return this.comunidades;
    }

    public void setComunidadesAsArray(Object[] comunidades)
    {
        this.comunidades = (comunidades == null) ? null : java.util.Arrays.asList(comunidades);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarODEModificarLicenciaFormImpl#getComunidades
     */
    public java.lang.Object[] getComunidadesAsArray()
    {
        return (comunidades == null) ? null : comunidades.toArray();
    }
    
    public java.lang.Object[] getComunidadesBackingList()
    {
        java.lang.Object[] values = this.comunidadesValueList;
        java.lang.Object[] labels = this.comunidadesLabelList;

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

    public java.lang.Object[] getComunidadesValueList()
    {
        return this.comunidadesValueList;
    }

    public void setComunidadesValueList(java.lang.Object[] comunidadesValueList)
    {
        this.comunidadesValueList = comunidadesValueList;
    }

    public java.lang.Object[] getComunidadesLabelList()
    {
        return this.comunidadesLabelList;
    }

    public void setComunidadesLabelList(java.lang.Object[] comunidadesLabelList)
    {
        this.comunidadesLabelList = comunidadesLabelList;
    }

    public void setComunidadesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PublicarODEModificarLicenciaFormImpl.setComunidadesBackingList requires non-null property arguments");
        }

        this.comunidadesValueList = null;
        this.comunidadesLabelList = null;

        if (items != null)
        {
            this.comunidadesValueList = new java.lang.Object[items.size()];
            this.comunidadesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comunidadesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comunidadesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PublicarODEModificarLicenciaFormImpl.setComunidadesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.comunidadesSeleccionadas = null;
        this.comunidadesSeleccionadasValueList = new java.lang.Object[0];
        this.comunidadesSeleccionadasLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("licencias", this.licencias);
        builder.append("comunidadesSeleccionadas", this.comunidadesSeleccionadas);
        builder.append("universal", this.universal);
        builder.append("ambito_todas", this.ambito_todas);
        builder.append("tipoLicenciaSeleccionada", this.tipoLicenciaSeleccionada);
        builder.append("tipo_licencia", this.tipo_licencia);
        builder.append("comunidades", this.comunidades);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.licencias = null;
        this.licenciasValueList = null;
        this.licenciasLabelList = null;
        this.comunidadesSeleccionadas = null;
        this.comunidadesSeleccionadasValueList = null;
        this.comunidadesSeleccionadasLabelList = null;
        this.universal = null;
        this.universalValueList = null;
        this.universalLabelList = null;
        this.ambito_todas = null;
        this.ambito_todasValueList = null;
        this.ambito_todasLabelList = null;
        this.tipoLicenciaSeleccionada = null;
        this.tipoLicenciaSeleccionadaValueList = null;
        this.tipoLicenciaSeleccionadaLabelList = null;
        this.tipo_licencia = null;
        this.tipo_licenciaValueList = null;
        this.tipo_licenciaLabelList = null;
        this.comunidades = null;
        this.comunidadesValueList = null;
        this.comunidadesLabelList = null;
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
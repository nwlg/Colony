// license-header java merge-point
package es.pode.visualizador.presentacion.modificarPerfil;

public class FormularioIniciaAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.visualizador.presentacion.modificarPerfil.ModificarUsuarioMismoForm
{
    private java.lang.String apellido2;
    private java.lang.Object[] apellido2ValueList;
    private java.lang.Object[] apellido2LabelList;
    private java.lang.String openIdUrl;
    private java.lang.Object[] openIdUrlValueList;
    private java.lang.Object[] openIdUrlLabelList;
    private java.lang.String resultadoModificacion;
    private java.lang.Object[] resultadoModificacionValueList;
    private java.lang.Object[] resultadoModificacionLabelList;
    private java.lang.String tipoCatalogador;
    private java.lang.Object[] tipoCatalogadorValueList;
    private java.lang.Object[] tipoCatalogadorLabelList;
    private java.lang.String apellido1;
    private java.lang.Object[] apellido1ValueList;
    private java.lang.Object[] apellido1LabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private long cuota;
    private java.lang.Object[] cuotaValueList;
    private java.lang.Object[] cuotaLabelList;
    private java.lang.Long id;
    private java.lang.Object[] idValueList;
    private java.lang.Object[] idLabelList;
    private java.lang.String nombre;
    private java.lang.Object[] nombreValueList;
    private java.lang.Object[] nombreLabelList;
    private java.lang.String tipoEmpaquetador;
    private java.lang.Object[] tipoEmpaquetadorValueList;
    private java.lang.Object[] tipoEmpaquetadorLabelList;
    private java.lang.String email;
    private java.lang.Object[] emailValueList;
    private java.lang.Object[] emailLabelList;
    private java.lang.String clave;
    private java.lang.Object[] claveValueList;
    private java.lang.Object[] claveLabelList;
    private java.lang.String idiomaBusqueda;
    private java.lang.Object[] idiomaBusquedaValueList;
    private java.lang.Object[] idiomaBusquedaLabelList;
    private java.lang.String NIF;
    private java.lang.Object[] NIFValueList;
    private java.lang.Object[] NIFLabelList;
    private java.lang.String repitaClave;
    private java.lang.Object[] repitaClaveValueList;
    private java.lang.Object[] repitaClaveLabelList;

    public FormularioIniciaAceptarFormImpl()
    {
    }

    /**
     * Resets the given <code>apellido2</code>.
     */
    public void resetApellido2()
    {
        this.apellido2 = null;
    }

    public void setApellido2(java.lang.String apellido2)
    {
        this.apellido2 = apellido2;
    }

    /**
     * 
     */
    public java.lang.String getApellido2()
    {
        return this.apellido2;
    }
    
    public java.lang.Object[] getApellido2BackingList()
    {
        java.lang.Object[] values = this.apellido2ValueList;
        java.lang.Object[] labels = this.apellido2LabelList;

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

    public java.lang.Object[] getApellido2ValueList()
    {
        return this.apellido2ValueList;
    }

    public void setApellido2ValueList(java.lang.Object[] apellido2ValueList)
    {
        this.apellido2ValueList = apellido2ValueList;
    }

    public java.lang.Object[] getApellido2LabelList()
    {
        return this.apellido2LabelList;
    }

    public void setApellido2LabelList(java.lang.Object[] apellido2LabelList)
    {
        this.apellido2LabelList = apellido2LabelList;
    }

    public void setApellido2BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setApellido2BackingList requires non-null property arguments");
        }

        this.apellido2ValueList = null;
        this.apellido2LabelList = null;

        if (items != null)
        {
            this.apellido2ValueList = new java.lang.Object[items.size()];
            this.apellido2LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.apellido2ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.apellido2LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setApellido2BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>openIdUrl</code>.
     */
    public void resetOpenIdUrl()
    {
        this.openIdUrl = null;
    }

    public void setOpenIdUrl(java.lang.String openIdUrl)
    {
        this.openIdUrl = openIdUrl;
    }

    /**
     * 
     */
    public java.lang.String getOpenIdUrl()
    {
        return this.openIdUrl;
    }
    
    public java.lang.Object[] getOpenIdUrlBackingList()
    {
        java.lang.Object[] values = this.openIdUrlValueList;
        java.lang.Object[] labels = this.openIdUrlLabelList;

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

    public java.lang.Object[] getOpenIdUrlValueList()
    {
        return this.openIdUrlValueList;
    }

    public void setOpenIdUrlValueList(java.lang.Object[] openIdUrlValueList)
    {
        this.openIdUrlValueList = openIdUrlValueList;
    }

    public java.lang.Object[] getOpenIdUrlLabelList()
    {
        return this.openIdUrlLabelList;
    }

    public void setOpenIdUrlLabelList(java.lang.Object[] openIdUrlLabelList)
    {
        this.openIdUrlLabelList = openIdUrlLabelList;
    }

    public void setOpenIdUrlBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setOpenIdUrlBackingList requires non-null property arguments");
        }

        this.openIdUrlValueList = null;
        this.openIdUrlLabelList = null;

        if (items != null)
        {
            this.openIdUrlValueList = new java.lang.Object[items.size()];
            this.openIdUrlLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.openIdUrlValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.openIdUrlLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setOpenIdUrlBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>resultadoModificacion</code>.
     */
    public void resetResultadoModificacion()
    {
        this.resultadoModificacion = null;
    }

    public void setResultadoModificacion(java.lang.String resultadoModificacion)
    {
        this.resultadoModificacion = resultadoModificacion;
    }

    /**
     * 
     */
    public java.lang.String getResultadoModificacion()
    {
        return this.resultadoModificacion;
    }
    
    public java.lang.Object[] getResultadoModificacionBackingList()
    {
        java.lang.Object[] values = this.resultadoModificacionValueList;
        java.lang.Object[] labels = this.resultadoModificacionLabelList;

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

    public java.lang.Object[] getResultadoModificacionValueList()
    {
        return this.resultadoModificacionValueList;
    }

    public void setResultadoModificacionValueList(java.lang.Object[] resultadoModificacionValueList)
    {
        this.resultadoModificacionValueList = resultadoModificacionValueList;
    }

    public java.lang.Object[] getResultadoModificacionLabelList()
    {
        return this.resultadoModificacionLabelList;
    }

    public void setResultadoModificacionLabelList(java.lang.Object[] resultadoModificacionLabelList)
    {
        this.resultadoModificacionLabelList = resultadoModificacionLabelList;
    }

    public void setResultadoModificacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setResultadoModificacionBackingList requires non-null property arguments");
        }

        this.resultadoModificacionValueList = null;
        this.resultadoModificacionLabelList = null;

        if (items != null)
        {
            this.resultadoModificacionValueList = new java.lang.Object[items.size()];
            this.resultadoModificacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.resultadoModificacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.resultadoModificacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setResultadoModificacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoCatalogador</code>.
     */
    public void resetTipoCatalogador()
    {
        this.tipoCatalogador = null;
    }

    public void setTipoCatalogador(java.lang.String tipoCatalogador)
    {
        this.tipoCatalogador = tipoCatalogador;
    }

    /**
     * 
     */
    public java.lang.String getTipoCatalogador()
    {
        return this.tipoCatalogador;
    }
    
    public java.lang.Object[] getTipoCatalogadorBackingList()
    {
        java.lang.Object[] values = this.tipoCatalogadorValueList;
        java.lang.Object[] labels = this.tipoCatalogadorLabelList;

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

    public java.lang.Object[] getTipoCatalogadorValueList()
    {
        return this.tipoCatalogadorValueList;
    }

    public void setTipoCatalogadorValueList(java.lang.Object[] tipoCatalogadorValueList)
    {
        this.tipoCatalogadorValueList = tipoCatalogadorValueList;
    }

    public java.lang.Object[] getTipoCatalogadorLabelList()
    {
        return this.tipoCatalogadorLabelList;
    }

    public void setTipoCatalogadorLabelList(java.lang.Object[] tipoCatalogadorLabelList)
    {
        this.tipoCatalogadorLabelList = tipoCatalogadorLabelList;
    }

    public void setTipoCatalogadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setTipoCatalogadorBackingList requires non-null property arguments");
        }

        this.tipoCatalogadorValueList = null;
        this.tipoCatalogadorLabelList = null;

        if (items != null)
        {
            this.tipoCatalogadorValueList = new java.lang.Object[items.size()];
            this.tipoCatalogadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoCatalogadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoCatalogadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setTipoCatalogadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>apellido1</code>.
     */
    public void resetApellido1()
    {
        this.apellido1 = null;
    }

    public void setApellido1(java.lang.String apellido1)
    {
        this.apellido1 = apellido1;
    }

    /**
     * 
     */
    public java.lang.String getApellido1()
    {
        return this.apellido1;
    }
    
    public java.lang.Object[] getApellido1BackingList()
    {
        java.lang.Object[] values = this.apellido1ValueList;
        java.lang.Object[] labels = this.apellido1LabelList;

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

    public java.lang.Object[] getApellido1ValueList()
    {
        return this.apellido1ValueList;
    }

    public void setApellido1ValueList(java.lang.Object[] apellido1ValueList)
    {
        this.apellido1ValueList = apellido1ValueList;
    }

    public java.lang.Object[] getApellido1LabelList()
    {
        return this.apellido1LabelList;
    }

    public void setApellido1LabelList(java.lang.Object[] apellido1LabelList)
    {
        this.apellido1LabelList = apellido1LabelList;
    }

    public void setApellido1BackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setApellido1BackingList requires non-null property arguments");
        }

        this.apellido1ValueList = null;
        this.apellido1LabelList = null;

        if (items != null)
        {
            this.apellido1ValueList = new java.lang.Object[items.size()];
            this.apellido1LabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.apellido1ValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.apellido1LabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setApellido1BackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idioma</code>.
     */
    public void resetIdioma()
    {
        this.idioma = null;
    }

    public void setIdioma(java.lang.String idioma)
    {
        this.idioma = idioma;
    }

    /**
     * 
     */
    public java.lang.String getIdioma()
    {
        return this.idioma;
    }
    
    public java.lang.Object[] getIdiomaBackingList()
    {
        java.lang.Object[] values = this.idiomaValueList;
        java.lang.Object[] labels = this.idiomaLabelList;

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

    public java.lang.Object[] getIdiomaValueList()
    {
        return this.idiomaValueList;
    }

    public void setIdiomaValueList(java.lang.Object[] idiomaValueList)
    {
        this.idiomaValueList = idiomaValueList;
    }

    public java.lang.Object[] getIdiomaLabelList()
    {
        return this.idiomaLabelList;
    }

    public void setIdiomaLabelList(java.lang.Object[] idiomaLabelList)
    {
        this.idiomaLabelList = idiomaLabelList;
    }

    public void setIdiomaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setIdiomaBackingList requires non-null property arguments");
        }

        this.idiomaValueList = null;
        this.idiomaLabelList = null;

        if (items != null)
        {
            this.idiomaValueList = new java.lang.Object[items.size()];
            this.idiomaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>cuota</code>.
     */
    public void resetCuota()
    {
        this.cuota = 0;
    }

    public void setCuota(long cuota)
    {
        this.cuota = cuota;
    }

    /**
     * 
     */
    public long getCuota()
    {
        return this.cuota;
    }
    
    public java.lang.Object[] getCuotaBackingList()
    {
        java.lang.Object[] values = this.cuotaValueList;
        java.lang.Object[] labels = this.cuotaLabelList;

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

    public java.lang.Object[] getCuotaValueList()
    {
        return this.cuotaValueList;
    }

    public void setCuotaValueList(java.lang.Object[] cuotaValueList)
    {
        this.cuotaValueList = cuotaValueList;
    }

    public java.lang.Object[] getCuotaLabelList()
    {
        return this.cuotaLabelList;
    }

    public void setCuotaLabelList(java.lang.Object[] cuotaLabelList)
    {
        this.cuotaLabelList = cuotaLabelList;
    }

    public void setCuotaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setCuotaBackingList requires non-null property arguments");
        }

        this.cuotaValueList = null;
        this.cuotaLabelList = null;

        if (items != null)
        {
            this.cuotaValueList = new java.lang.Object[items.size()];
            this.cuotaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.cuotaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.cuotaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setCuotaBackingList encountered an exception", ex);
            }
        }
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
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setIdBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nombre</code>.
     */
    public void resetNombre()
    {
        this.nombre = null;
    }

    public void setNombre(java.lang.String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * 
     */
    public java.lang.String getNombre()
    {
        return this.nombre;
    }
    
    public java.lang.Object[] getNombreBackingList()
    {
        java.lang.Object[] values = this.nombreValueList;
        java.lang.Object[] labels = this.nombreLabelList;

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

    public java.lang.Object[] getNombreValueList()
    {
        return this.nombreValueList;
    }

    public void setNombreValueList(java.lang.Object[] nombreValueList)
    {
        this.nombreValueList = nombreValueList;
    }

    public java.lang.Object[] getNombreLabelList()
    {
        return this.nombreLabelList;
    }

    public void setNombreLabelList(java.lang.Object[] nombreLabelList)
    {
        this.nombreLabelList = nombreLabelList;
    }

    public void setNombreBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setNombreBackingList requires non-null property arguments");
        }

        this.nombreValueList = null;
        this.nombreLabelList = null;

        if (items != null)
        {
            this.nombreValueList = new java.lang.Object[items.size()];
            this.nombreLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nombreValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nombreLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setNombreBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoEmpaquetador</code>.
     */
    public void resetTipoEmpaquetador()
    {
        this.tipoEmpaquetador = null;
    }

    public void setTipoEmpaquetador(java.lang.String tipoEmpaquetador)
    {
        this.tipoEmpaquetador = tipoEmpaquetador;
    }

    /**
     * 
     */
    public java.lang.String getTipoEmpaquetador()
    {
        return this.tipoEmpaquetador;
    }
    
    public java.lang.Object[] getTipoEmpaquetadorBackingList()
    {
        java.lang.Object[] values = this.tipoEmpaquetadorValueList;
        java.lang.Object[] labels = this.tipoEmpaquetadorLabelList;

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

    public java.lang.Object[] getTipoEmpaquetadorValueList()
    {
        return this.tipoEmpaquetadorValueList;
    }

    public void setTipoEmpaquetadorValueList(java.lang.Object[] tipoEmpaquetadorValueList)
    {
        this.tipoEmpaquetadorValueList = tipoEmpaquetadorValueList;
    }

    public java.lang.Object[] getTipoEmpaquetadorLabelList()
    {
        return this.tipoEmpaquetadorLabelList;
    }

    public void setTipoEmpaquetadorLabelList(java.lang.Object[] tipoEmpaquetadorLabelList)
    {
        this.tipoEmpaquetadorLabelList = tipoEmpaquetadorLabelList;
    }

    public void setTipoEmpaquetadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setTipoEmpaquetadorBackingList requires non-null property arguments");
        }

        this.tipoEmpaquetadorValueList = null;
        this.tipoEmpaquetadorLabelList = null;

        if (items != null)
        {
            this.tipoEmpaquetadorValueList = new java.lang.Object[items.size()];
            this.tipoEmpaquetadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoEmpaquetadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoEmpaquetadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setTipoEmpaquetadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>email</code>.
     */
    public void resetEmail()
    {
        this.email = null;
    }

    public void setEmail(java.lang.String email)
    {
        this.email = email;
    }

    /**
     * 
     */
    public java.lang.String getEmail()
    {
        return this.email;
    }
    
    public java.lang.Object[] getEmailBackingList()
    {
        java.lang.Object[] values = this.emailValueList;
        java.lang.Object[] labels = this.emailLabelList;

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

    public java.lang.Object[] getEmailValueList()
    {
        return this.emailValueList;
    }

    public void setEmailValueList(java.lang.Object[] emailValueList)
    {
        this.emailValueList = emailValueList;
    }

    public java.lang.Object[] getEmailLabelList()
    {
        return this.emailLabelList;
    }

    public void setEmailLabelList(java.lang.Object[] emailLabelList)
    {
        this.emailLabelList = emailLabelList;
    }

    public void setEmailBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setEmailBackingList requires non-null property arguments");
        }

        this.emailValueList = null;
        this.emailLabelList = null;

        if (items != null)
        {
            this.emailValueList = new java.lang.Object[items.size()];
            this.emailLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.emailValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.emailLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setEmailBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>clave</code>.
     */
    public void resetClave()
    {
        this.clave = null;
    }

    public void setClave(java.lang.String clave)
    {
        this.clave = clave;
    }

    /**
     * 
     */
    public java.lang.String getClave()
    {
        return this.clave;
    }
    
    public java.lang.Object[] getClaveBackingList()
    {
        java.lang.Object[] values = this.claveValueList;
        java.lang.Object[] labels = this.claveLabelList;

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

    public java.lang.Object[] getClaveValueList()
    {
        return this.claveValueList;
    }

    public void setClaveValueList(java.lang.Object[] claveValueList)
    {
        this.claveValueList = claveValueList;
    }

    public java.lang.Object[] getClaveLabelList()
    {
        return this.claveLabelList;
    }

    public void setClaveLabelList(java.lang.Object[] claveLabelList)
    {
        this.claveLabelList = claveLabelList;
    }

    public void setClaveBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setClaveBackingList requires non-null property arguments");
        }

        this.claveValueList = null;
        this.claveLabelList = null;

        if (items != null)
        {
            this.claveValueList = new java.lang.Object[items.size()];
            this.claveLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.claveValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.claveLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setClaveBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomaBusqueda</code>.
     */
    public void resetIdiomaBusqueda()
    {
        this.idiomaBusqueda = null;
    }

    public void setIdiomaBusqueda(java.lang.String idiomaBusqueda)
    {
        this.idiomaBusqueda = idiomaBusqueda;
    }

    /**
     * 
     */
    public java.lang.String getIdiomaBusqueda()
    {
        return this.idiomaBusqueda;
    }
    
    public java.lang.Object[] getIdiomaBusquedaBackingList()
    {
        java.lang.Object[] values = this.idiomaBusquedaValueList;
        java.lang.Object[] labels = this.idiomaBusquedaLabelList;

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

    public java.lang.Object[] getIdiomaBusquedaValueList()
    {
        return this.idiomaBusquedaValueList;
    }

    public void setIdiomaBusquedaValueList(java.lang.Object[] idiomaBusquedaValueList)
    {
        this.idiomaBusquedaValueList = idiomaBusquedaValueList;
    }

    public java.lang.Object[] getIdiomaBusquedaLabelList()
    {
        return this.idiomaBusquedaLabelList;
    }

    public void setIdiomaBusquedaLabelList(java.lang.Object[] idiomaBusquedaLabelList)
    {
        this.idiomaBusquedaLabelList = idiomaBusquedaLabelList;
    }

    public void setIdiomaBusquedaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setIdiomaBusquedaBackingList requires non-null property arguments");
        }

        this.idiomaBusquedaValueList = null;
        this.idiomaBusquedaLabelList = null;

        if (items != null)
        {
            this.idiomaBusquedaValueList = new java.lang.Object[items.size()];
            this.idiomaBusquedaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomaBusquedaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomaBusquedaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setIdiomaBusquedaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>NIF</code>.
     */
    public void resetNIF()
    {
        this.NIF = null;
    }

    public void setNIF(java.lang.String NIF)
    {
        this.NIF = NIF;
    }

    /**
     * 
     */
    public java.lang.String getNIF()
    {
        return this.NIF;
    }
    
    public java.lang.Object[] getNIFBackingList()
    {
        java.lang.Object[] values = this.NIFValueList;
        java.lang.Object[] labels = this.NIFLabelList;

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

    public java.lang.Object[] getNIFValueList()
    {
        return this.NIFValueList;
    }

    public void setNIFValueList(java.lang.Object[] NIFValueList)
    {
        this.NIFValueList = NIFValueList;
    }

    public java.lang.Object[] getNIFLabelList()
    {
        return this.NIFLabelList;
    }

    public void setNIFLabelList(java.lang.Object[] NIFLabelList)
    {
        this.NIFLabelList = NIFLabelList;
    }

    public void setNIFBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setNIFBackingList requires non-null property arguments");
        }

        this.NIFValueList = null;
        this.NIFLabelList = null;

        if (items != null)
        {
            this.NIFValueList = new java.lang.Object[items.size()];
            this.NIFLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.NIFValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.NIFLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setNIFBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>repitaClave</code>.
     */
    public void resetRepitaClave()
    {
        this.repitaClave = null;
    }

    public void setRepitaClave(java.lang.String repitaClave)
    {
        this.repitaClave = repitaClave;
    }

    /**
     * 
     */
    public java.lang.String getRepitaClave()
    {
        return this.repitaClave;
    }
    
    public java.lang.Object[] getRepitaClaveBackingList()
    {
        java.lang.Object[] values = this.repitaClaveValueList;
        java.lang.Object[] labels = this.repitaClaveLabelList;

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

    public java.lang.Object[] getRepitaClaveValueList()
    {
        return this.repitaClaveValueList;
    }

    public void setRepitaClaveValueList(java.lang.Object[] repitaClaveValueList)
    {
        this.repitaClaveValueList = repitaClaveValueList;
    }

    public java.lang.Object[] getRepitaClaveLabelList()
    {
        return this.repitaClaveLabelList;
    }

    public void setRepitaClaveLabelList(java.lang.Object[] repitaClaveLabelList)
    {
        this.repitaClaveLabelList = repitaClaveLabelList;
    }

    public void setRepitaClaveBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioIniciaAceptarFormImpl.setRepitaClaveBackingList requires non-null property arguments");
        }

        this.repitaClaveValueList = null;
        this.repitaClaveLabelList = null;

        if (items != null)
        {
            this.repitaClaveValueList = new java.lang.Object[items.size()];
            this.repitaClaveLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.repitaClaveValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.repitaClaveLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioIniciaAceptarFormImpl.setRepitaClaveBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.idioma = null;
        this.tipoEmpaquetador = null;
        this.idiomaBusqueda = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("apellido2", this.apellido2);
        builder.append("openIdUrl", this.openIdUrl);
        builder.append("resultadoModificacion", this.resultadoModificacion);
        builder.append("tipoCatalogador", this.tipoCatalogador);
        builder.append("apellido1", this.apellido1);
        builder.append("idioma", this.idioma);
        builder.append("cuota", this.cuota);
        builder.append("id", this.id);
        builder.append("nombre", this.nombre);
        builder.append("tipoEmpaquetador", this.tipoEmpaquetador);
        builder.append("email", this.email);
        builder.append("clave", this.clave);
        builder.append("idiomaBusqueda", this.idiomaBusqueda);
        builder.append("NIF", this.NIF);
        builder.append("repitaClave", this.repitaClave);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.apellido2 = null;
        this.apellido2ValueList = null;
        this.apellido2LabelList = null;
        this.openIdUrl = null;
        this.openIdUrlValueList = null;
        this.openIdUrlLabelList = null;
        this.resultadoModificacion = null;
        this.resultadoModificacionValueList = null;
        this.resultadoModificacionLabelList = null;
        this.tipoCatalogador = null;
        this.tipoCatalogadorValueList = null;
        this.tipoCatalogadorLabelList = null;
        this.apellido1 = null;
        this.apellido1ValueList = null;
        this.apellido1LabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.cuota = 0;
        this.cuotaValueList = null;
        this.cuotaLabelList = null;
        this.id = null;
        this.idValueList = null;
        this.idLabelList = null;
        this.nombre = null;
        this.nombreValueList = null;
        this.nombreLabelList = null;
        this.tipoEmpaquetador = null;
        this.tipoEmpaquetadorValueList = null;
        this.tipoEmpaquetadorLabelList = null;
        this.email = null;
        this.emailValueList = null;
        this.emailLabelList = null;
        this.clave = null;
        this.claveValueList = null;
        this.claveLabelList = null;
        this.idiomaBusqueda = null;
        this.idiomaBusquedaValueList = null;
        this.idiomaBusquedaLabelList = null;
        this.NIF = null;
        this.NIFValueList = null;
        this.NIFLabelList = null;
        this.repitaClave = null;
        this.repitaClaveValueList = null;
        this.repitaClaveLabelList = null;
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
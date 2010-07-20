// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.altaRepositoriosExternos;

public class FormularioAltaNodoSQIAceptarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.repositoriosExternos.altaRepositoriosExternos.AltaNodoSQIForm
{
    private java.lang.String urlServicio;
    private java.lang.Object[] urlServicioValueList;
    private java.lang.Object[] urlServicioLabelList;
    private java.lang.Long id;
    private java.lang.Object[] idValueList;
    private java.lang.Object[] idLabelList;
    private java.lang.String gestorSesion;
    private java.lang.Object[] gestorSesionValueList;
    private java.lang.Object[] gestorSesionLabelList;
    private java.lang.String usuario;
    private java.lang.Object[] usuarioValueList;
    private java.lang.Object[] usuarioLabelList;
    private java.lang.String descripcionNodo;
    private java.lang.Object[] descripcionNodoValueList;
    private java.lang.Object[] descripcionNodoLabelList;
    private java.lang.String nombreNodo;
    private java.lang.Object[] nombreNodoValueList;
    private java.lang.Object[] nombreNodoLabelList;
    private java.lang.Long idModificado;
    private java.lang.Object[] idModificadoValueList;
    private java.lang.Object[] idModificadoLabelList;
    private java.lang.String clave;
    private java.lang.Object[] claveValueList;
    private java.lang.Object[] claveLabelList;
    private java.lang.String lenguajeConsulta;
    private java.lang.Object[] lenguajeConsultaValueList;
    private java.lang.Object[] lenguajeConsultaLabelList;
    private java.lang.String lenguajeRespuesta;
    private java.lang.Object[] lenguajeRespuestaValueList;
    private java.lang.Object[] lenguajeRespuestaLabelList;
    private java.lang.String identificadorSesion;
    private java.lang.Object[] identificadorSesionValueList;
    private java.lang.Object[] identificadorSesionLabelList;

    public FormularioAltaNodoSQIAceptarFormImpl()
    {
    }

    /**
     * Resets the given <code>urlServicio</code>.
     */
    public void resetUrlServicio()
    {
        this.urlServicio = null;
    }

    public void setUrlServicio(java.lang.String urlServicio)
    {
        this.urlServicio = urlServicio;
    }

    /**
     * <p>
     * La URL del servicio
     * </p>
     */
    public java.lang.String getUrlServicio()
    {
        return this.urlServicio;
    }
    
    public java.lang.Object[] getUrlServicioBackingList()
    {
        java.lang.Object[] values = this.urlServicioValueList;
        java.lang.Object[] labels = this.urlServicioLabelList;

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

    public java.lang.Object[] getUrlServicioValueList()
    {
        return this.urlServicioValueList;
    }

    public void setUrlServicioValueList(java.lang.Object[] urlServicioValueList)
    {
        this.urlServicioValueList = urlServicioValueList;
    }

    public java.lang.Object[] getUrlServicioLabelList()
    {
        return this.urlServicioLabelList;
    }

    public void setUrlServicioLabelList(java.lang.Object[] urlServicioLabelList)
    {
        this.urlServicioLabelList = urlServicioLabelList;
    }

    public void setUrlServicioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioAltaNodoSQIAceptarFormImpl.setUrlServicioBackingList requires non-null property arguments");
        }

        this.urlServicioValueList = null;
        this.urlServicioLabelList = null;

        if (items != null)
        {
            this.urlServicioValueList = new java.lang.Object[items.size()];
            this.urlServicioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.urlServicioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.urlServicioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioAltaNodoSQIAceptarFormImpl.setUrlServicioBackingList encountered an exception", ex);
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
     * <p>
     * El identificador del nodo SQI
     * </p>
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
            throw new IllegalArgumentException("FormularioAltaNodoSQIAceptarFormImpl.setIdBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioAltaNodoSQIAceptarFormImpl.setIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>gestorSesion</code>.
     */
    public void resetGestorSesion()
    {
        this.gestorSesion = null;
    }

    public void setGestorSesion(java.lang.String gestorSesion)
    {
        this.gestorSesion = gestorSesion;
    }

    /**
     * <p>
     * El gestor de sesiones
     * </p>
     */
    public java.lang.String getGestorSesion()
    {
        return this.gestorSesion;
    }
    
    public java.lang.Object[] getGestorSesionBackingList()
    {
        java.lang.Object[] values = this.gestorSesionValueList;
        java.lang.Object[] labels = this.gestorSesionLabelList;

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

    public java.lang.Object[] getGestorSesionValueList()
    {
        return this.gestorSesionValueList;
    }

    public void setGestorSesionValueList(java.lang.Object[] gestorSesionValueList)
    {
        this.gestorSesionValueList = gestorSesionValueList;
    }

    public java.lang.Object[] getGestorSesionLabelList()
    {
        return this.gestorSesionLabelList;
    }

    public void setGestorSesionLabelList(java.lang.Object[] gestorSesionLabelList)
    {
        this.gestorSesionLabelList = gestorSesionLabelList;
    }

    public void setGestorSesionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioAltaNodoSQIAceptarFormImpl.setGestorSesionBackingList requires non-null property arguments");
        }

        this.gestorSesionValueList = null;
        this.gestorSesionLabelList = null;

        if (items != null)
        {
            this.gestorSesionValueList = new java.lang.Object[items.size()];
            this.gestorSesionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.gestorSesionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.gestorSesionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioAltaNodoSQIAceptarFormImpl.setGestorSesionBackingList encountered an exception", ex);
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
     * <p>
     * El usuario
     * </p>
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
            throw new IllegalArgumentException("FormularioAltaNodoSQIAceptarFormImpl.setUsuarioBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioAltaNodoSQIAceptarFormImpl.setUsuarioBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcionNodo</code>.
     */
    public void resetDescripcionNodo()
    {
        this.descripcionNodo = null;
    }

    public void setDescripcionNodo(java.lang.String descripcionNodo)
    {
        this.descripcionNodo = descripcionNodo;
    }

    /**
     * <p>
     * La descripcion del nodo SQI
     * </p>
     */
    public java.lang.String getDescripcionNodo()
    {
        return this.descripcionNodo;
    }
    
    public java.lang.Object[] getDescripcionNodoBackingList()
    {
        java.lang.Object[] values = this.descripcionNodoValueList;
        java.lang.Object[] labels = this.descripcionNodoLabelList;

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

    public java.lang.Object[] getDescripcionNodoValueList()
    {
        return this.descripcionNodoValueList;
    }

    public void setDescripcionNodoValueList(java.lang.Object[] descripcionNodoValueList)
    {
        this.descripcionNodoValueList = descripcionNodoValueList;
    }

    public java.lang.Object[] getDescripcionNodoLabelList()
    {
        return this.descripcionNodoLabelList;
    }

    public void setDescripcionNodoLabelList(java.lang.Object[] descripcionNodoLabelList)
    {
        this.descripcionNodoLabelList = descripcionNodoLabelList;
    }

    public void setDescripcionNodoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioAltaNodoSQIAceptarFormImpl.setDescripcionNodoBackingList requires non-null property arguments");
        }

        this.descripcionNodoValueList = null;
        this.descripcionNodoLabelList = null;

        if (items != null)
        {
            this.descripcionNodoValueList = new java.lang.Object[items.size()];
            this.descripcionNodoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionNodoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionNodoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioAltaNodoSQIAceptarFormImpl.setDescripcionNodoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nombreNodo</code>.
     */
    public void resetNombreNodo()
    {
        this.nombreNodo = null;
    }

    public void setNombreNodo(java.lang.String nombreNodo)
    {
        this.nombreNodo = nombreNodo;
    }

    /**
     * <p>
     * El nombre del nodo
     * </p>
     */
    public java.lang.String getNombreNodo()
    {
        return this.nombreNodo;
    }
    
    public java.lang.Object[] getNombreNodoBackingList()
    {
        java.lang.Object[] values = this.nombreNodoValueList;
        java.lang.Object[] labels = this.nombreNodoLabelList;

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

    public java.lang.Object[] getNombreNodoValueList()
    {
        return this.nombreNodoValueList;
    }

    public void setNombreNodoValueList(java.lang.Object[] nombreNodoValueList)
    {
        this.nombreNodoValueList = nombreNodoValueList;
    }

    public java.lang.Object[] getNombreNodoLabelList()
    {
        return this.nombreNodoLabelList;
    }

    public void setNombreNodoLabelList(java.lang.Object[] nombreNodoLabelList)
    {
        this.nombreNodoLabelList = nombreNodoLabelList;
    }

    public void setNombreNodoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioAltaNodoSQIAceptarFormImpl.setNombreNodoBackingList requires non-null property arguments");
        }

        this.nombreNodoValueList = null;
        this.nombreNodoLabelList = null;

        if (items != null)
        {
            this.nombreNodoValueList = new java.lang.Object[items.size()];
            this.nombreNodoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nombreNodoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nombreNodoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioAltaNodoSQIAceptarFormImpl.setNombreNodoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idModificado</code>.
     */
    public void resetIdModificado()
    {
        this.idModificado = null;
    }

    public void setIdModificado(java.lang.Long idModificado)
    {
        this.idModificado = idModificado;
    }

    /**
     * 
     */
    public java.lang.Long getIdModificado()
    {
        return this.idModificado;
    }
    
    public java.lang.Object[] getIdModificadoBackingList()
    {
        java.lang.Object[] values = this.idModificadoValueList;
        java.lang.Object[] labels = this.idModificadoLabelList;

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

    public java.lang.Object[] getIdModificadoValueList()
    {
        return this.idModificadoValueList;
    }

    public void setIdModificadoValueList(java.lang.Object[] idModificadoValueList)
    {
        this.idModificadoValueList = idModificadoValueList;
    }

    public java.lang.Object[] getIdModificadoLabelList()
    {
        return this.idModificadoLabelList;
    }

    public void setIdModificadoLabelList(java.lang.Object[] idModificadoLabelList)
    {
        this.idModificadoLabelList = idModificadoLabelList;
    }

    public void setIdModificadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioAltaNodoSQIAceptarFormImpl.setIdModificadoBackingList requires non-null property arguments");
        }

        this.idModificadoValueList = null;
        this.idModificadoLabelList = null;

        if (items != null)
        {
            this.idModificadoValueList = new java.lang.Object[items.size()];
            this.idModificadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idModificadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idModificadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioAltaNodoSQIAceptarFormImpl.setIdModificadoBackingList encountered an exception", ex);
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
     * <p>
     * La clave del usuario
     * </p>
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
            throw new IllegalArgumentException("FormularioAltaNodoSQIAceptarFormImpl.setClaveBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("FormularioAltaNodoSQIAceptarFormImpl.setClaveBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>lenguajeConsulta</code>.
     */
    public void resetLenguajeConsulta()
    {
        this.lenguajeConsulta = null;
    }

    public void setLenguajeConsulta(java.lang.String lenguajeConsulta)
    {
        this.lenguajeConsulta = lenguajeConsulta;
    }

    /**
     * <p>
     * El lenguaje que se va a utilizar para hacer la consulta
     * </p>
     */
    public java.lang.String getLenguajeConsulta()
    {
        return this.lenguajeConsulta;
    }
    
    public java.lang.Object[] getLenguajeConsultaBackingList()
    {
        java.lang.Object[] values = this.lenguajeConsultaValueList;
        java.lang.Object[] labels = this.lenguajeConsultaLabelList;

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

    public java.lang.Object[] getLenguajeConsultaValueList()
    {
        return this.lenguajeConsultaValueList;
    }

    public void setLenguajeConsultaValueList(java.lang.Object[] lenguajeConsultaValueList)
    {
        this.lenguajeConsultaValueList = lenguajeConsultaValueList;
    }

    public java.lang.Object[] getLenguajeConsultaLabelList()
    {
        return this.lenguajeConsultaLabelList;
    }

    public void setLenguajeConsultaLabelList(java.lang.Object[] lenguajeConsultaLabelList)
    {
        this.lenguajeConsultaLabelList = lenguajeConsultaLabelList;
    }

    public void setLenguajeConsultaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioAltaNodoSQIAceptarFormImpl.setLenguajeConsultaBackingList requires non-null property arguments");
        }

        this.lenguajeConsultaValueList = null;
        this.lenguajeConsultaLabelList = null;

        if (items != null)
        {
            this.lenguajeConsultaValueList = new java.lang.Object[items.size()];
            this.lenguajeConsultaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.lenguajeConsultaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.lenguajeConsultaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioAltaNodoSQIAceptarFormImpl.setLenguajeConsultaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>lenguajeRespuesta</code>.
     */
    public void resetLenguajeRespuesta()
    {
        this.lenguajeRespuesta = null;
    }

    public void setLenguajeRespuesta(java.lang.String lenguajeRespuesta)
    {
        this.lenguajeRespuesta = lenguajeRespuesta;
    }

    /**
     * <p>
     * El lenguaje en el que nos devolveran la respuesta
     * </p>
     */
    public java.lang.String getLenguajeRespuesta()
    {
        return this.lenguajeRespuesta;
    }
    
    public java.lang.Object[] getLenguajeRespuestaBackingList()
    {
        java.lang.Object[] values = this.lenguajeRespuestaValueList;
        java.lang.Object[] labels = this.lenguajeRespuestaLabelList;

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

    public java.lang.Object[] getLenguajeRespuestaValueList()
    {
        return this.lenguajeRespuestaValueList;
    }

    public void setLenguajeRespuestaValueList(java.lang.Object[] lenguajeRespuestaValueList)
    {
        this.lenguajeRespuestaValueList = lenguajeRespuestaValueList;
    }

    public java.lang.Object[] getLenguajeRespuestaLabelList()
    {
        return this.lenguajeRespuestaLabelList;
    }

    public void setLenguajeRespuestaLabelList(java.lang.Object[] lenguajeRespuestaLabelList)
    {
        this.lenguajeRespuestaLabelList = lenguajeRespuestaLabelList;
    }

    public void setLenguajeRespuestaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioAltaNodoSQIAceptarFormImpl.setLenguajeRespuestaBackingList requires non-null property arguments");
        }

        this.lenguajeRespuestaValueList = null;
        this.lenguajeRespuestaLabelList = null;

        if (items != null)
        {
            this.lenguajeRespuestaValueList = new java.lang.Object[items.size()];
            this.lenguajeRespuestaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.lenguajeRespuestaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.lenguajeRespuestaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioAltaNodoSQIAceptarFormImpl.setLenguajeRespuestaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificadorSesion</code>.
     */
    public void resetIdentificadorSesion()
    {
        this.identificadorSesion = null;
    }

    public void setIdentificadorSesion(java.lang.String identificadorSesion)
    {
        this.identificadorSesion = identificadorSesion;
    }

    /**
     * <p>
     * El identificador de sesiones
     * </p>
     */
    public java.lang.String getIdentificadorSesion()
    {
        return this.identificadorSesion;
    }
    
    public java.lang.Object[] getIdentificadorSesionBackingList()
    {
        java.lang.Object[] values = this.identificadorSesionValueList;
        java.lang.Object[] labels = this.identificadorSesionLabelList;

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

    public java.lang.Object[] getIdentificadorSesionValueList()
    {
        return this.identificadorSesionValueList;
    }

    public void setIdentificadorSesionValueList(java.lang.Object[] identificadorSesionValueList)
    {
        this.identificadorSesionValueList = identificadorSesionValueList;
    }

    public java.lang.Object[] getIdentificadorSesionLabelList()
    {
        return this.identificadorSesionLabelList;
    }

    public void setIdentificadorSesionLabelList(java.lang.Object[] identificadorSesionLabelList)
    {
        this.identificadorSesionLabelList = identificadorSesionLabelList;
    }

    public void setIdentificadorSesionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("FormularioAltaNodoSQIAceptarFormImpl.setIdentificadorSesionBackingList requires non-null property arguments");
        }

        this.identificadorSesionValueList = null;
        this.identificadorSesionLabelList = null;

        if (items != null)
        {
            this.identificadorSesionValueList = new java.lang.Object[items.size()];
            this.identificadorSesionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadorSesionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadorSesionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("FormularioAltaNodoSQIAceptarFormImpl.setIdentificadorSesionBackingList encountered an exception", ex);
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
        builder.append("urlServicio", this.urlServicio);
        builder.append("id", this.id);
        builder.append("gestorSesion", this.gestorSesion);
        builder.append("usuario", this.usuario);
        builder.append("descripcionNodo", this.descripcionNodo);
        builder.append("nombreNodo", this.nombreNodo);
        builder.append("idModificado", this.idModificado);
        builder.append("clave", this.clave);
        builder.append("lenguajeConsulta", this.lenguajeConsulta);
        builder.append("lenguajeRespuesta", this.lenguajeRespuesta);
        builder.append("identificadorSesion", this.identificadorSesion);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.urlServicio = null;
        this.urlServicioValueList = null;
        this.urlServicioLabelList = null;
        this.id = null;
        this.idValueList = null;
        this.idLabelList = null;
        this.gestorSesion = null;
        this.gestorSesionValueList = null;
        this.gestorSesionLabelList = null;
        this.usuario = null;
        this.usuarioValueList = null;
        this.usuarioLabelList = null;
        this.descripcionNodo = null;
        this.descripcionNodoValueList = null;
        this.descripcionNodoLabelList = null;
        this.nombreNodo = null;
        this.nombreNodoValueList = null;
        this.nombreNodoLabelList = null;
        this.idModificado = null;
        this.idModificadoValueList = null;
        this.idModificadoLabelList = null;
        this.clave = null;
        this.claveValueList = null;
        this.claveLabelList = null;
        this.lenguajeConsulta = null;
        this.lenguajeConsultaValueList = null;
        this.lenguajeConsultaLabelList = null;
        this.lenguajeRespuesta = null;
        this.lenguajeRespuestaValueList = null;
        this.lenguajeRespuestaLabelList = null;
        this.identificadorSesion = null;
        this.identificadorSesionValueList = null;
        this.identificadorSesionLabelList = null;
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
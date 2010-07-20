// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor;

public class GestorElementosNavegarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.RecuperarDatosForm
        , es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.NavegarForm
{
    private es.pode.empaquetador.negocio.servicio.ControlModeVO secuencia;
    private java.lang.Object[] secuenciaValueList;
    private java.lang.Object[] secuenciaLabelList;
    private es.pode.empaquetador.negocio.servicio.OrganizacionVO organizacion;
    private java.lang.Object[] organizacionValueList;
    private java.lang.Object[] organizacionLabelList;
    private java.util.List portapapeles = null;
    private java.lang.Object[] portapapelesValueList;
    private java.lang.Object[] portapapelesLabelList;
    private java.lang.String identifier;
    private java.lang.Object[] identifierValueList;
    private java.lang.Object[] identifierLabelList;
    private java.util.List idCollection;
    private java.lang.Object[] idCollectionValueList;
    private java.lang.Object[] idCollectionLabelList;
    private boolean vistaArbol;
    private java.lang.Object[] vistaArbolValueList;
    private java.lang.Object[] vistaArbolLabelList;
    private java.util.List grupos = null;
    private java.lang.Object[] gruposValueList;
    private java.lang.Object[] gruposLabelList;
    private java.lang.String returnURL;
    private java.lang.Object[] returnURLValueList;
    private java.lang.Object[] returnURLLabelList;

    public GestorElementosNavegarFormImpl()
    {
    }

    /**
     * Resets the given <code>secuencia</code>.
     */
    public void resetSecuencia()
    {
        this.secuencia = null;
    }

    public void setSecuencia(es.pode.empaquetador.negocio.servicio.ControlModeVO secuencia)
    {
        this.secuencia = secuencia;
    }

    /**
     * <p>
     * Secuencia asociada al grupo / organizacion en edicion (puede ser
     * null).
     * </p>
     */
    public es.pode.empaquetador.negocio.servicio.ControlModeVO getSecuencia()
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
            throw new IllegalArgumentException("GestorElementosNavegarFormImpl.setSecuenciaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("GestorElementosNavegarFormImpl.setSecuenciaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>organizacion</code>.
     */
    public void resetOrganizacion()
    {
        this.organizacion = null;
    }

    public void setOrganizacion(es.pode.empaquetador.negocio.servicio.OrganizacionVO organizacion)
    {
        this.organizacion = organizacion;
    }

    /**
     * 
     */
    public es.pode.empaquetador.negocio.servicio.OrganizacionVO getOrganizacion()
    {
        return this.organizacion;
    }
    
    public java.lang.Object[] getOrganizacionBackingList()
    {
        java.lang.Object[] values = this.organizacionValueList;
        java.lang.Object[] labels = this.organizacionLabelList;

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

    public java.lang.Object[] getOrganizacionValueList()
    {
        return this.organizacionValueList;
    }

    public void setOrganizacionValueList(java.lang.Object[] organizacionValueList)
    {
        this.organizacionValueList = organizacionValueList;
    }

    public java.lang.Object[] getOrganizacionLabelList()
    {
        return this.organizacionLabelList;
    }

    public void setOrganizacionLabelList(java.lang.Object[] organizacionLabelList)
    {
        this.organizacionLabelList = organizacionLabelList;
    }

    public void setOrganizacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorElementosNavegarFormImpl.setOrganizacionBackingList requires non-null property arguments");
        }

        this.organizacionValueList = null;
        this.organizacionLabelList = null;

        if (items != null)
        {
            this.organizacionValueList = new java.lang.Object[items.size()];
            this.organizacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.organizacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.organizacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorElementosNavegarFormImpl.setOrganizacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>portapapeles</code>.
     */
    public void resetPortapapeles()
    {
        this.portapapeles = null;
    }

    public void setPortapapeles(java.util.List portapapeles)
    {
        this.portapapeles = portapapeles;
    }

    /**
     * <p>
     * Elementos copiados / cortados listos para pegar.
     * </p>
     */
    public java.util.List getPortapapeles()
    {
        return this.portapapeles;
    }

    public void setPortapapelesAsArray(Object[] portapapeles)
    {
        this.portapapeles = (portapapeles == null) ? null : java.util.Arrays.asList(portapapeles);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosNavegarFormImpl#getPortapapeles
     */
    public java.lang.Object[] getPortapapelesAsArray()
    {
        return (portapapeles == null) ? null : portapapeles.toArray();
    }
    
    public java.lang.Object[] getPortapapelesBackingList()
    {
        java.lang.Object[] values = this.portapapelesValueList;
        java.lang.Object[] labels = this.portapapelesLabelList;

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

    public java.lang.Object[] getPortapapelesValueList()
    {
        return this.portapapelesValueList;
    }

    public void setPortapapelesValueList(java.lang.Object[] portapapelesValueList)
    {
        this.portapapelesValueList = portapapelesValueList;
    }

    public java.lang.Object[] getPortapapelesLabelList()
    {
        return this.portapapelesLabelList;
    }

    public void setPortapapelesLabelList(java.lang.Object[] portapapelesLabelList)
    {
        this.portapapelesLabelList = portapapelesLabelList;
    }

    public void setPortapapelesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorElementosNavegarFormImpl.setPortapapelesBackingList requires non-null property arguments");
        }

        this.portapapelesValueList = null;
        this.portapapelesLabelList = null;

        if (items != null)
        {
            this.portapapelesValueList = new java.lang.Object[items.size()];
            this.portapapelesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.portapapelesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.portapapelesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorElementosNavegarFormImpl.setPortapapelesBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("GestorElementosNavegarFormImpl.setIdentifierBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("GestorElementosNavegarFormImpl.setIdentifierBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idCollection</code>.
     */
    public void resetIdCollection()
    {
        this.idCollection = null;
    }

    public void setIdCollection(java.util.List idCollection)
    {
        this.idCollection = idCollection;
    }

    /**
     * <p>
     * Lista de carpetas en las que se esta navegando (ver Gestor
     * Basico)
     * </p>
     */
    public java.util.List getIdCollection()
    {
        return this.idCollection;
    }

    public void setIdCollectionAsArray(Object[] idCollection)
    {
        this.idCollection = (idCollection == null) ? null : java.util.Arrays.asList(idCollection);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosNavegarFormImpl#getIdCollection
     */
    public java.lang.Object[] getIdCollectionAsArray()
    {
        return (idCollection == null) ? null : idCollection.toArray();
    }
    
    public java.lang.Object[] getIdCollectionBackingList()
    {
        java.lang.Object[] values = this.idCollectionValueList;
        java.lang.Object[] labels = this.idCollectionLabelList;

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

    public java.lang.Object[] getIdCollectionValueList()
    {
        return this.idCollectionValueList;
    }

    public void setIdCollectionValueList(java.lang.Object[] idCollectionValueList)
    {
        this.idCollectionValueList = idCollectionValueList;
    }

    public java.lang.Object[] getIdCollectionLabelList()
    {
        return this.idCollectionLabelList;
    }

    public void setIdCollectionLabelList(java.lang.Object[] idCollectionLabelList)
    {
        this.idCollectionLabelList = idCollectionLabelList;
    }

    public void setIdCollectionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorElementosNavegarFormImpl.setIdCollectionBackingList requires non-null property arguments");
        }

        this.idCollectionValueList = null;
        this.idCollectionLabelList = null;

        if (items != null)
        {
            this.idCollectionValueList = new java.lang.Object[items.size()];
            this.idCollectionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idCollectionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idCollectionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorElementosNavegarFormImpl.setIdCollectionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>vistaArbol</code>.
     */
    public void resetVistaArbol()
    {
        this.vistaArbol = false;
    }

    public void setVistaArbol(boolean vistaArbol)
    {
        this.vistaArbol = vistaArbol;
    }

    /**
     * 
     */
    public boolean isVistaArbol()
    {
        return this.vistaArbol;
    }
    
    public java.lang.Object[] getVistaArbolBackingList()
    {
        java.lang.Object[] values = this.vistaArbolValueList;
        java.lang.Object[] labels = this.vistaArbolLabelList;

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

    public java.lang.Object[] getVistaArbolValueList()
    {
        return this.vistaArbolValueList;
    }

    public void setVistaArbolValueList(java.lang.Object[] vistaArbolValueList)
    {
        this.vistaArbolValueList = vistaArbolValueList;
    }

    public java.lang.Object[] getVistaArbolLabelList()
    {
        return this.vistaArbolLabelList;
    }

    public void setVistaArbolLabelList(java.lang.Object[] vistaArbolLabelList)
    {
        this.vistaArbolLabelList = vistaArbolLabelList;
    }

    public void setVistaArbolBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorElementosNavegarFormImpl.setVistaArbolBackingList requires non-null property arguments");
        }

        this.vistaArbolValueList = null;
        this.vistaArbolLabelList = null;

        if (items != null)
        {
            this.vistaArbolValueList = new java.lang.Object[items.size()];
            this.vistaArbolLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.vistaArbolValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.vistaArbolLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorElementosNavegarFormImpl.setVistaArbolBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>grupos</code>.
     */
    public void resetGrupos()
    {
        this.grupos = null;
    }

    public void setGrupos(java.util.List grupos)
    {
        this.grupos = grupos;
    }

    /**
     * <p>
     * Lista de grupos y elementos para la vista por carpeta.
     * </p>
     */
    public java.util.List getGrupos()
    {
        return this.grupos;
    }

    public void setGruposAsArray(Object[] grupos)
    {
        this.grupos = (grupos == null) ? null : java.util.Arrays.asList(grupos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosNavegarFormImpl#getGrupos
     */
    public java.lang.Object[] getGruposAsArray()
    {
        return (grupos == null) ? null : grupos.toArray();
    }
    
    public java.lang.Object[] getGruposBackingList()
    {
        java.lang.Object[] values = this.gruposValueList;
        java.lang.Object[] labels = this.gruposLabelList;

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

    public java.lang.Object[] getGruposValueList()
    {
        return this.gruposValueList;
    }

    public void setGruposValueList(java.lang.Object[] gruposValueList)
    {
        this.gruposValueList = gruposValueList;
    }

    public java.lang.Object[] getGruposLabelList()
    {
        return this.gruposLabelList;
    }

    public void setGruposLabelList(java.lang.Object[] gruposLabelList)
    {
        this.gruposLabelList = gruposLabelList;
    }

    public void setGruposBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorElementosNavegarFormImpl.setGruposBackingList requires non-null property arguments");
        }

        this.gruposValueList = null;
        this.gruposLabelList = null;

        if (items != null)
        {
            this.gruposValueList = new java.lang.Object[items.size()];
            this.gruposLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.gruposValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.gruposLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorElementosNavegarFormImpl.setGruposBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>returnURL</code>.
     */
    public void resetReturnURL()
    {
        this.returnURL = null;
    }

    public void setReturnURL(java.lang.String returnURL)
    {
        this.returnURL = returnURL;
    }

    /**
     * 
     */
    public java.lang.String getReturnURL()
    {
        return this.returnURL;
    }
    
    public java.lang.Object[] getReturnURLBackingList()
    {
        java.lang.Object[] values = this.returnURLValueList;
        java.lang.Object[] labels = this.returnURLLabelList;

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

    public java.lang.Object[] getReturnURLValueList()
    {
        return this.returnURLValueList;
    }

    public void setReturnURLValueList(java.lang.Object[] returnURLValueList)
    {
        this.returnURLValueList = returnURLValueList;
    }

    public java.lang.Object[] getReturnURLLabelList()
    {
        return this.returnURLLabelList;
    }

    public void setReturnURLLabelList(java.lang.Object[] returnURLLabelList)
    {
        this.returnURLLabelList = returnURLLabelList;
    }

    public void setReturnURLBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GestorElementosNavegarFormImpl.setReturnURLBackingList requires non-null property arguments");
        }

        this.returnURLValueList = null;
        this.returnURLLabelList = null;

        if (items != null)
        {
            this.returnURLValueList = new java.lang.Object[items.size()];
            this.returnURLLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.returnURLValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.returnURLLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GestorElementosNavegarFormImpl.setReturnURLBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.vistaArbol = false;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("secuencia", this.secuencia);
        builder.append("organizacion", this.organizacion);
        builder.append("portapapeles", this.portapapeles);
        builder.append("identifier", this.identifier);
        builder.append("idCollection", this.idCollection);
        builder.append("vistaArbol", this.vistaArbol);
        builder.append("grupos", this.grupos);
        builder.append("returnURL", this.returnURL);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.secuencia = null;
        this.secuenciaValueList = null;
        this.secuenciaLabelList = null;
        this.organizacion = null;
        this.organizacionValueList = null;
        this.organizacionLabelList = null;
        this.portapapeles = null;
        this.portapapelesValueList = null;
        this.portapapelesLabelList = null;
        this.identifier = null;
        this.identifierValueList = null;
        this.identifierLabelList = null;
        this.idCollection = null;
        this.idCollectionValueList = null;
        this.idCollectionLabelList = null;
        this.vistaArbol = false;
        this.vistaArbolValueList = null;
        this.vistaArbolLabelList = null;
        this.grupos = null;
        this.gruposValueList = null;
        this.gruposLabelList = null;
        this.returnURL = null;
        this.returnURLValueList = null;
        this.returnURLLabelList = null;
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
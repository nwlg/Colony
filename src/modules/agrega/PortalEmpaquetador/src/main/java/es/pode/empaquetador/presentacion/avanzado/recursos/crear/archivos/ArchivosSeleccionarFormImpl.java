// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos;

public class ArchivosSeleccionarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.SubmitForm
        , es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.SumarArchivosForm
        , es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CancelarForm
        , es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.RecuperarDatosForm
        , es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.SelectActionForm
{
    private java.util.List archivos = null;
    private java.lang.Object[] archivosValueList;
    private java.lang.Object[] archivosLabelList;
    private java.util.List nombreRowSelection = null;
    private java.lang.Object[] nombreValueList;
    private java.lang.Object[] nombreLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.util.List pathArchivos;
    private java.lang.Object[] pathArchivosValueList;
    private java.lang.Object[] pathArchivosLabelList;
    private es.pode.empaquetador.negocio.servicio.ArchivoVO arbol;
    private java.lang.Object[] arbolValueList;
    private java.lang.Object[] arbolLabelList;
    private java.lang.String href;
    private java.lang.Object[] hrefValueList;
    private java.lang.Object[] hrefLabelList;
    private boolean vistaArbol;
    private java.lang.Object[] vistaArbolValueList;
    private java.lang.Object[] vistaArbolLabelList;
    private java.util.List archivosSeleccionados = null;
    private java.lang.Object[] archivosSeleccionadosValueList;
    private java.lang.Object[] archivosSeleccionadosLabelList;

    public ArchivosSeleccionarFormImpl()
    {
    }

    /**
     * Resets the given <code>archivos</code>.
     */
    public void resetArchivos()
    {
        this.archivos = null;
    }

    public void setArchivos(java.util.List archivos)
    {
        this.archivos = archivos;
    }

    /**
     * 
     */
    public java.util.List getArchivos()
    {
        return this.archivos;
    }

    public void setArchivosAsArray(Object[] archivos)
    {
        this.archivos = (archivos == null) ? null : java.util.Arrays.asList(archivos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.ArchivosSeleccionarFormImpl#getArchivos
     */
    public java.lang.Object[] getArchivosAsArray()
    {
        return (archivos == null) ? null : archivos.toArray();
    }
    
    public java.lang.Object[] getArchivosBackingList()
    {
        java.lang.Object[] values = this.archivosValueList;
        java.lang.Object[] labels = this.archivosLabelList;

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

    public java.lang.Object[] getArchivosValueList()
    {
        return this.archivosValueList;
    }

    public void setArchivosValueList(java.lang.Object[] archivosValueList)
    {
        this.archivosValueList = archivosValueList;
    }

    public java.lang.Object[] getArchivosLabelList()
    {
        return this.archivosLabelList;
    }

    public void setArchivosLabelList(java.lang.Object[] archivosLabelList)
    {
        this.archivosLabelList = archivosLabelList;
    }

    public void setArchivosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ArchivosSeleccionarFormImpl.setArchivosBackingList requires non-null property arguments");
        }

        this.archivosValueList = null;
        this.archivosLabelList = null;

        if (items != null)
        {
            this.archivosValueList = new java.lang.Object[items.size()];
            this.archivosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.archivosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.archivosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ArchivosSeleccionarFormImpl.setArchivosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nombreRowSelection</code>.
     */
    public void resetNombre()
    {
        this.nombreRowSelection = null;
    }

    public void setNombreRowSelection(java.util.List nombreRowSelection)
    {
        this.nombreRowSelection = nombreRowSelection;
    }

    public java.util.List getNombreRowSelection()
    {
        return this.nombreRowSelection;
    }

    public void setNombreRowSelectionAsArray(java.lang.String[] nombreRowSelection)
    {
        this.nombreRowSelection = (nombreRowSelection == null) ? null : java.util.Arrays.asList(nombreRowSelection);
    }

    public java.lang.String[] getNombreRowSelectionAsArray()
    {
        return (nombreRowSelection == null) ? null : (java.lang.String[])nombreRowSelection.toArray(new java.lang.String[nombreRowSelection.size()]);
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
            throw new IllegalArgumentException("ArchivosSeleccionarFormImpl.setNombreBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ArchivosSeleccionarFormImpl.setNombreBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>action</code>.
     */
    public void resetAction()
    {
        this.action = null;
    }

    public void setAction(java.lang.String action)
    {
        this.action = action;
    }

    /**
     * 
     */
    public java.lang.String getAction()
    {
        return this.action;
    }
    
    public java.lang.Object[] getActionBackingList()
    {
        java.lang.Object[] values = this.actionValueList;
        java.lang.Object[] labels = this.actionLabelList;

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

    public java.lang.Object[] getActionValueList()
    {
        return this.actionValueList;
    }

    public void setActionValueList(java.lang.Object[] actionValueList)
    {
        this.actionValueList = actionValueList;
    }

    public java.lang.Object[] getActionLabelList()
    {
        return this.actionLabelList;
    }

    public void setActionLabelList(java.lang.Object[] actionLabelList)
    {
        this.actionLabelList = actionLabelList;
    }

    public void setActionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ArchivosSeleccionarFormImpl.setActionBackingList requires non-null property arguments");
        }

        this.actionValueList = null;
        this.actionLabelList = null;

        if (items != null)
        {
            this.actionValueList = new java.lang.Object[items.size()];
            this.actionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.actionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.actionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ArchivosSeleccionarFormImpl.setActionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>pathArchivos</code>.
     */
    public void resetPathArchivos()
    {
        this.pathArchivos = null;
    }

    public void setPathArchivos(java.util.List pathArchivos)
    {
        this.pathArchivos = pathArchivos;
    }

    /**
     * <p>
     * Se almacena en sesion en el objeto CrearRecursoSession.
     * </p>
     */
    public java.util.List getPathArchivos()
    {
        return this.pathArchivos;
    }

    public void setPathArchivosAsArray(Object[] pathArchivos)
    {
        this.pathArchivos = (pathArchivos == null) ? null : java.util.Arrays.asList(pathArchivos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.ArchivosSeleccionarFormImpl#getPathArchivos
     */
    public java.lang.Object[] getPathArchivosAsArray()
    {
        return (pathArchivos == null) ? null : pathArchivos.toArray();
    }
    
    public java.lang.Object[] getPathArchivosBackingList()
    {
        java.lang.Object[] values = this.pathArchivosValueList;
        java.lang.Object[] labels = this.pathArchivosLabelList;

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

    public java.lang.Object[] getPathArchivosValueList()
    {
        return this.pathArchivosValueList;
    }

    public void setPathArchivosValueList(java.lang.Object[] pathArchivosValueList)
    {
        this.pathArchivosValueList = pathArchivosValueList;
    }

    public java.lang.Object[] getPathArchivosLabelList()
    {
        return this.pathArchivosLabelList;
    }

    public void setPathArchivosLabelList(java.lang.Object[] pathArchivosLabelList)
    {
        this.pathArchivosLabelList = pathArchivosLabelList;
    }

    public void setPathArchivosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ArchivosSeleccionarFormImpl.setPathArchivosBackingList requires non-null property arguments");
        }

        this.pathArchivosValueList = null;
        this.pathArchivosLabelList = null;

        if (items != null)
        {
            this.pathArchivosValueList = new java.lang.Object[items.size()];
            this.pathArchivosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.pathArchivosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.pathArchivosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ArchivosSeleccionarFormImpl.setPathArchivosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>arbol</code>.
     */
    public void resetArbol()
    {
        this.arbol = null;
    }

    public void setArbol(es.pode.empaquetador.negocio.servicio.ArchivoVO arbol)
    {
        this.arbol = arbol;
    }

    /**
     * 
     */
    public es.pode.empaquetador.negocio.servicio.ArchivoVO getArbol()
    {
        return this.arbol;
    }
    
    public java.lang.Object[] getArbolBackingList()
    {
        java.lang.Object[] values = this.arbolValueList;
        java.lang.Object[] labels = this.arbolLabelList;

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

    public java.lang.Object[] getArbolValueList()
    {
        return this.arbolValueList;
    }

    public void setArbolValueList(java.lang.Object[] arbolValueList)
    {
        this.arbolValueList = arbolValueList;
    }

    public java.lang.Object[] getArbolLabelList()
    {
        return this.arbolLabelList;
    }

    public void setArbolLabelList(java.lang.Object[] arbolLabelList)
    {
        this.arbolLabelList = arbolLabelList;
    }

    public void setArbolBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ArchivosSeleccionarFormImpl.setArbolBackingList requires non-null property arguments");
        }

        this.arbolValueList = null;
        this.arbolLabelList = null;

        if (items != null)
        {
            this.arbolValueList = new java.lang.Object[items.size()];
            this.arbolLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.arbolValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.arbolLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ArchivosSeleccionarFormImpl.setArbolBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>href</code>.
     */
    public void resetHref()
    {
        this.href = null;
    }

    public void setHref(java.lang.String href)
    {
        this.href = href;
    }

    /**
     * 
     */
    public java.lang.String getHref()
    {
        return this.href;
    }
    
    public java.lang.Object[] getHrefBackingList()
    {
        java.lang.Object[] values = this.hrefValueList;
        java.lang.Object[] labels = this.hrefLabelList;

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

    public java.lang.Object[] getHrefValueList()
    {
        return this.hrefValueList;
    }

    public void setHrefValueList(java.lang.Object[] hrefValueList)
    {
        this.hrefValueList = hrefValueList;
    }

    public java.lang.Object[] getHrefLabelList()
    {
        return this.hrefLabelList;
    }

    public void setHrefLabelList(java.lang.Object[] hrefLabelList)
    {
        this.hrefLabelList = hrefLabelList;
    }

    public void setHrefBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ArchivosSeleccionarFormImpl.setHrefBackingList requires non-null property arguments");
        }

        this.hrefValueList = null;
        this.hrefLabelList = null;

        if (items != null)
        {
            this.hrefValueList = new java.lang.Object[items.size()];
            this.hrefLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.hrefValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.hrefLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ArchivosSeleccionarFormImpl.setHrefBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ArchivosSeleccionarFormImpl.setVistaArbolBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ArchivosSeleccionarFormImpl.setVistaArbolBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>archivosSeleccionados</code>.
     */
    public void resetArchivosSeleccionados()
    {
        this.archivosSeleccionados = null;
    }

    public void setArchivosSeleccionados(java.util.List archivosSeleccionados)
    {
        this.archivosSeleccionados = archivosSeleccionados;
    }

    /**
     * 
     */
    public java.util.List getArchivosSeleccionados()
    {
        return this.archivosSeleccionados;
    }

    public void setArchivosSeleccionadosAsArray(Object[] archivosSeleccionados)
    {
        this.archivosSeleccionados = (archivosSeleccionados == null) ? null : java.util.Arrays.asList(archivosSeleccionados);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.ArchivosSeleccionarFormImpl#getArchivosSeleccionados
     */
    public java.lang.Object[] getArchivosSeleccionadosAsArray()
    {
        return (archivosSeleccionados == null) ? null : archivosSeleccionados.toArray();
    }
    
    public java.lang.Object[] getArchivosSeleccionadosBackingList()
    {
        java.lang.Object[] values = this.archivosSeleccionadosValueList;
        java.lang.Object[] labels = this.archivosSeleccionadosLabelList;

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

    public java.lang.Object[] getArchivosSeleccionadosValueList()
    {
        return this.archivosSeleccionadosValueList;
    }

    public void setArchivosSeleccionadosValueList(java.lang.Object[] archivosSeleccionadosValueList)
    {
        this.archivosSeleccionadosValueList = archivosSeleccionadosValueList;
    }

    public java.lang.Object[] getArchivosSeleccionadosLabelList()
    {
        return this.archivosSeleccionadosLabelList;
    }

    public void setArchivosSeleccionadosLabelList(java.lang.Object[] archivosSeleccionadosLabelList)
    {
        this.archivosSeleccionadosLabelList = archivosSeleccionadosLabelList;
    }

    public void setArchivosSeleccionadosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ArchivosSeleccionarFormImpl.setArchivosSeleccionadosBackingList requires non-null property arguments");
        }

        this.archivosSeleccionadosValueList = null;
        this.archivosSeleccionadosLabelList = null;

        if (items != null)
        {
            this.archivosSeleccionadosValueList = new java.lang.Object[items.size()];
            this.archivosSeleccionadosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.archivosSeleccionadosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.archivosSeleccionadosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ArchivosSeleccionarFormImpl.setArchivosSeleccionadosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.nombreRowSelection = null;
        this.vistaArbol = false;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("archivos", this.archivos);
        builder.append("nombreRowSelection", this.nombreRowSelection);
        builder.append("action", this.action);
        builder.append("pathArchivos", this.pathArchivos);
        builder.append("arbol", this.arbol);
        builder.append("href", this.href);
        builder.append("vistaArbol", this.vistaArbol);
        builder.append("archivosSeleccionados", this.archivosSeleccionados);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.archivos = null;
        this.archivosValueList = null;
        this.archivosLabelList = null;
        this.nombreRowSelection = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.pathArchivos = null;
        this.pathArchivosValueList = null;
        this.pathArchivosLabelList = null;
        this.arbol = null;
        this.arbolValueList = null;
        this.arbolLabelList = null;
        this.href = null;
        this.hrefValueList = null;
        this.hrefLabelList = null;
        this.vistaArbol = false;
        this.vistaArbolValueList = null;
        this.vistaArbolLabelList = null;
        this.archivosSeleccionados = null;
        this.archivosSeleccionadosValueList = null;
        this.archivosSeleccionadosLabelList = null;
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
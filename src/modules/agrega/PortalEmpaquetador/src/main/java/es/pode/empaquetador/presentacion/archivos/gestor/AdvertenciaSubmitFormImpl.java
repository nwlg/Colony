// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.gestor;

public class AdvertenciaSubmitFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.archivos.gestor.CargarDatosForm
        , es.pode.empaquetador.presentacion.archivos.gestor.EliminarForm
        , es.pode.empaquetador.presentacion.archivos.gestor.AdvertenciaSubmitForm
{
    private java.lang.String nombre;
    private java.lang.Object[] nombreValueList;
    private java.lang.Object[] nombreLabelList;
    private java.util.List listado = null;
    private java.lang.Object[] listadoValueList;
    private java.lang.Object[] listadoLabelList;
    private java.lang.String identificador;
    private java.lang.Object[] identificadorValueList;
    private java.lang.Object[] identificadorLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.util.List path;
    private java.lang.Object[] pathValueList;
    private java.lang.Object[] pathLabelList;
    private es.pode.empaquetador.negocio.servicio.ArchivoVO arbol;
    private java.lang.Object[] arbolValueList;
    private java.lang.Object[] arbolLabelList;
    private java.util.List portapapeles = null;
    private java.lang.Object[] portapapelesValueList;
    private java.lang.Object[] portapapelesLabelList;
    private java.util.List archivosVO;
    private java.lang.Object[] archivosVOValueList;
    private java.lang.Object[] archivosVOLabelList;
    private boolean vistaCarpeta;
    private java.lang.Object[] vistaCarpetaValueList;
    private java.lang.Object[] vistaCarpetaLabelList;
    private java.lang.String href;
    private java.lang.Object[] hrefValueList;
    private java.lang.Object[] hrefLabelList;
    private java.lang.String returnURL;
    private java.lang.Object[] returnURLValueList;
    private java.lang.Object[] returnURLLabelList;

    public AdvertenciaSubmitFormImpl()
    {
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
     * <p>
     * Nombre del archivo o carpeta seleccionado.
     * </p>
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
            throw new IllegalArgumentException("AdvertenciaSubmitFormImpl.setNombreBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AdvertenciaSubmitFormImpl.setNombreBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listado</code>.
     */
    public void resetListado()
    {
        this.listado = null;
    }

    public void setListado(java.util.List listado)
    {
        this.listado = listado;
    }

    /**
     * <p>
     * Lista de ArchivosVO contenidos en la carpeta actual.
     * </p>
     */
    public java.util.List getListado()
    {
        return this.listado;
    }

    public void setListadoAsArray(Object[] listado)
    {
        this.listado = (listado == null) ? null : java.util.Arrays.asList(listado);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.archivos.gestor.AdvertenciaSubmitFormImpl#getListado
     */
    public java.lang.Object[] getListadoAsArray()
    {
        return (listado == null) ? null : listado.toArray();
    }
    
    public java.lang.Object[] getListadoBackingList()
    {
        java.lang.Object[] values = this.listadoValueList;
        java.lang.Object[] labels = this.listadoLabelList;

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

    public java.lang.Object[] getListadoValueList()
    {
        return this.listadoValueList;
    }

    public void setListadoValueList(java.lang.Object[] listadoValueList)
    {
        this.listadoValueList = listadoValueList;
    }

    public java.lang.Object[] getListadoLabelList()
    {
        return this.listadoLabelList;
    }

    public void setListadoLabelList(java.lang.Object[] listadoLabelList)
    {
        this.listadoLabelList = listadoLabelList;
    }

    public void setListadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AdvertenciaSubmitFormImpl.setListadoBackingList requires non-null property arguments");
        }

        this.listadoValueList = null;
        this.listadoLabelList = null;

        if (items != null)
        {
            this.listadoValueList = new java.lang.Object[items.size()];
            this.listadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AdvertenciaSubmitFormImpl.setListadoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("AdvertenciaSubmitFormImpl.setIdentificadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AdvertenciaSubmitFormImpl.setIdentificadorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("AdvertenciaSubmitFormImpl.setActionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AdvertenciaSubmitFormImpl.setActionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>path</code>.
     */
    public void resetPath()
    {
        this.path = null;
    }

    public void setPath(java.util.List path)
    {
        this.path = path;
    }

    /**
     * <p>
     * Lista de ArchivosVO donde en la primera posicion esta la carpeta
     * principal del ODE (nombrada con el identificador) y en las
     * siguientes los ArchivosVO de las carpetas que componen el path
     * hasta la carpeta actual.
     * </p>
     */
    public java.util.List getPath()
    {
        return this.path;
    }

    public void setPathAsArray(Object[] path)
    {
        this.path = (path == null) ? null : java.util.Arrays.asList(path);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.archivos.gestor.AdvertenciaSubmitFormImpl#getPath
     */
    public java.lang.Object[] getPathAsArray()
    {
        return (path == null) ? null : path.toArray();
    }
    
    public java.lang.Object[] getPathBackingList()
    {
        java.lang.Object[] values = this.pathValueList;
        java.lang.Object[] labels = this.pathLabelList;

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

    public java.lang.Object[] getPathValueList()
    {
        return this.pathValueList;
    }

    public void setPathValueList(java.lang.Object[] pathValueList)
    {
        this.pathValueList = pathValueList;
    }

    public java.lang.Object[] getPathLabelList()
    {
        return this.pathLabelList;
    }

    public void setPathLabelList(java.lang.Object[] pathLabelList)
    {
        this.pathLabelList = pathLabelList;
    }

    public void setPathBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AdvertenciaSubmitFormImpl.setPathBackingList requires non-null property arguments");
        }

        this.pathValueList = null;
        this.pathLabelList = null;

        if (items != null)
        {
            this.pathValueList = new java.lang.Object[items.size()];
            this.pathLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.pathValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.pathLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AdvertenciaSubmitFormImpl.setPathBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("AdvertenciaSubmitFormImpl.setArbolBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AdvertenciaSubmitFormImpl.setArbolBackingList encountered an exception", ex);
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
     * Lista de ArchivoVO disponibles para copiar/mover.
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
     * @see es.pode.empaquetador.presentacion.archivos.gestor.AdvertenciaSubmitFormImpl#getPortapapeles
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
            throw new IllegalArgumentException("AdvertenciaSubmitFormImpl.setPortapapelesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AdvertenciaSubmitFormImpl.setPortapapelesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>archivosVO</code>.
     */
    public void resetArchivosVO()
    {
        this.archivosVO = null;
    }

    public void setArchivosVO(java.util.List archivosVO)
    {
        this.archivosVO = archivosVO;
    }

    /**
     * 
     */
    public java.util.List getArchivosVO()
    {
        return this.archivosVO;
    }

    public void setArchivosVOAsArray(Object[] archivosVO)
    {
        this.archivosVO = (archivosVO == null) ? null : java.util.Arrays.asList(archivosVO);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.archivos.gestor.AdvertenciaSubmitFormImpl#getArchivosVO
     */
    public java.lang.Object[] getArchivosVOAsArray()
    {
        return (archivosVO == null) ? null : archivosVO.toArray();
    }
    
    public java.lang.Object[] getArchivosVOBackingList()
    {
        java.lang.Object[] values = this.archivosVOValueList;
        java.lang.Object[] labels = this.archivosVOLabelList;

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

    public java.lang.Object[] getArchivosVOValueList()
    {
        return this.archivosVOValueList;
    }

    public void setArchivosVOValueList(java.lang.Object[] archivosVOValueList)
    {
        this.archivosVOValueList = archivosVOValueList;
    }

    public java.lang.Object[] getArchivosVOLabelList()
    {
        return this.archivosVOLabelList;
    }

    public void setArchivosVOLabelList(java.lang.Object[] archivosVOLabelList)
    {
        this.archivosVOLabelList = archivosVOLabelList;
    }

    public void setArchivosVOBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AdvertenciaSubmitFormImpl.setArchivosVOBackingList requires non-null property arguments");
        }

        this.archivosVOValueList = null;
        this.archivosVOLabelList = null;

        if (items != null)
        {
            this.archivosVOValueList = new java.lang.Object[items.size()];
            this.archivosVOLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.archivosVOValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.archivosVOLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AdvertenciaSubmitFormImpl.setArchivosVOBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>vistaCarpeta</code>.
     */
    public void resetVistaCarpeta()
    {
        this.vistaCarpeta = false;
    }

    public void setVistaCarpeta(boolean vistaCarpeta)
    {
        this.vistaCarpeta = vistaCarpeta;
    }

    /**
     * <p>
     * Permite alternar entre vista por arbol y vista por carpeta.
     * </p>
     */
    public boolean isVistaCarpeta()
    {
        return this.vistaCarpeta;
    }
    
    public java.lang.Object[] getVistaCarpetaBackingList()
    {
        java.lang.Object[] values = this.vistaCarpetaValueList;
        java.lang.Object[] labels = this.vistaCarpetaLabelList;

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

    public java.lang.Object[] getVistaCarpetaValueList()
    {
        return this.vistaCarpetaValueList;
    }

    public void setVistaCarpetaValueList(java.lang.Object[] vistaCarpetaValueList)
    {
        this.vistaCarpetaValueList = vistaCarpetaValueList;
    }

    public java.lang.Object[] getVistaCarpetaLabelList()
    {
        return this.vistaCarpetaLabelList;
    }

    public void setVistaCarpetaLabelList(java.lang.Object[] vistaCarpetaLabelList)
    {
        this.vistaCarpetaLabelList = vistaCarpetaLabelList;
    }

    public void setVistaCarpetaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("AdvertenciaSubmitFormImpl.setVistaCarpetaBackingList requires non-null property arguments");
        }

        this.vistaCarpetaValueList = null;
        this.vistaCarpetaLabelList = null;

        if (items != null)
        {
            this.vistaCarpetaValueList = new java.lang.Object[items.size()];
            this.vistaCarpetaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.vistaCarpetaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.vistaCarpetaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("AdvertenciaSubmitFormImpl.setVistaCarpetaBackingList encountered an exception", ex);
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
     * <p>
     * HREF único que identifica a la carpeta
     * </p>
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
            throw new IllegalArgumentException("AdvertenciaSubmitFormImpl.setHrefBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AdvertenciaSubmitFormImpl.setHrefBackingList encountered an exception", ex);
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
     * <p>
     * URL a la que el CU Guardar debe volver tras haber guardado los
     * cambios.
     * </p>
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
            throw new IllegalArgumentException("AdvertenciaSubmitFormImpl.setReturnURLBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("AdvertenciaSubmitFormImpl.setReturnURLBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.archivosVO = null;
        this.archivosVOValueList = new java.lang.Object[0];
        this.archivosVOLabelList = new java.lang.Object[0];
        this.vistaCarpeta = false;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("nombre", this.nombre);
        builder.append("listado", this.listado);
        builder.append("identificador", this.identificador);
        builder.append("action", this.action);
        builder.append("path", this.path);
        builder.append("arbol", this.arbol);
        builder.append("portapapeles", this.portapapeles);
        builder.append("archivosVO", this.archivosVO);
        builder.append("vistaCarpeta", this.vistaCarpeta);
        builder.append("href", this.href);
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
        this.nombre = null;
        this.nombreValueList = null;
        this.nombreLabelList = null;
        this.listado = null;
        this.listadoValueList = null;
        this.listadoLabelList = null;
        this.identificador = null;
        this.identificadorValueList = null;
        this.identificadorLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.path = null;
        this.pathValueList = null;
        this.pathLabelList = null;
        this.arbol = null;
        this.arbolValueList = null;
        this.arbolLabelList = null;
        this.portapapeles = null;
        this.portapapelesValueList = null;
        this.portapapelesLabelList = null;
        this.archivosVO = null;
        this.archivosVOValueList = null;
        this.archivosVOLabelList = null;
        this.vistaCarpeta = false;
        this.vistaCarpetaValueList = null;
        this.vistaCarpetaLabelList = null;
        this.href = null;
        this.hrefValueList = null;
        this.hrefLabelList = null;
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
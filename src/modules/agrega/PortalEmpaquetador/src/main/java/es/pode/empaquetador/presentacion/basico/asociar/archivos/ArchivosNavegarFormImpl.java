// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar.archivos;

public class ArchivosNavegarFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.empaquetador.presentacion.basico.asociar.archivos.NavegarForm
        , es.pode.empaquetador.presentacion.basico.asociar.archivos.RecuperarDatosForm
{
    private java.lang.String nombre;
    private java.lang.Object[] nombreValueList;
    private java.lang.Object[] nombreLabelList;
    private java.util.List ficherosSeleccionados;
    private java.lang.Object[] ficherosSeleccionadosValueList;
    private java.lang.Object[] ficherosSeleccionadosLabelList;
    private java.util.List ficheros = null;
    private java.lang.Object[] ficherosValueList;
    private java.lang.Object[] ficherosLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.util.List path;
    private java.lang.Object[] pathValueList;
    private java.lang.Object[] pathLabelList;
    private es.pode.empaquetador.negocio.servicio.ArchivoVO arbol;
    private java.lang.Object[] arbolValueList;
    private java.lang.Object[] arbolLabelList;
    private java.lang.String identifier;
    private java.lang.Object[] identifierValueList;
    private java.lang.Object[] identifierLabelList;
    private java.lang.String href;
    private java.lang.Object[] hrefValueList;
    private java.lang.Object[] hrefLabelList;

    public ArchivosNavegarFormImpl()
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
            throw new IllegalArgumentException("ArchivosNavegarFormImpl.setNombreBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ArchivosNavegarFormImpl.setNombreBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ficherosSeleccionados</code>.
     */
    public void resetFicherosSeleccionados()
    {
        this.ficherosSeleccionados = null;
    }

    public void setFicherosSeleccionados(java.util.List ficherosSeleccionados)
    {
        this.ficherosSeleccionados = ficherosSeleccionados;
    }

    /**
     * <p>
     * Lista de ficheros que estan asociados al Grupo (Recurso). Se
     * usaran para dibujar correctamente cada fila de la tabla.
     * </p>
     */
    public java.util.List getFicherosSeleccionados()
    {
        return this.ficherosSeleccionados;
    }

    public void setFicherosSeleccionadosAsArray(Object[] ficherosSeleccionados)
    {
        this.ficherosSeleccionados = (ficherosSeleccionados == null) ? null : java.util.Arrays.asList(ficherosSeleccionados);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.ArchivosNavegarFormImpl#getFicherosSeleccionados
     */
    public java.lang.Object[] getFicherosSeleccionadosAsArray()
    {
        return (ficherosSeleccionados == null) ? null : ficherosSeleccionados.toArray();
    }
    
    public java.lang.Object[] getFicherosSeleccionadosBackingList()
    {
        java.lang.Object[] values = this.ficherosSeleccionadosValueList;
        java.lang.Object[] labels = this.ficherosSeleccionadosLabelList;

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

    public java.lang.Object[] getFicherosSeleccionadosValueList()
    {
        return this.ficherosSeleccionadosValueList;
    }

    public void setFicherosSeleccionadosValueList(java.lang.Object[] ficherosSeleccionadosValueList)
    {
        this.ficherosSeleccionadosValueList = ficherosSeleccionadosValueList;
    }

    public java.lang.Object[] getFicherosSeleccionadosLabelList()
    {
        return this.ficherosSeleccionadosLabelList;
    }

    public void setFicherosSeleccionadosLabelList(java.lang.Object[] ficherosSeleccionadosLabelList)
    {
        this.ficherosSeleccionadosLabelList = ficherosSeleccionadosLabelList;
    }

    public void setFicherosSeleccionadosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ArchivosNavegarFormImpl.setFicherosSeleccionadosBackingList requires non-null property arguments");
        }

        this.ficherosSeleccionadosValueList = null;
        this.ficherosSeleccionadosLabelList = null;

        if (items != null)
        {
            this.ficherosSeleccionadosValueList = new java.lang.Object[items.size()];
            this.ficherosSeleccionadosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.ficherosSeleccionadosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.ficherosSeleccionadosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ArchivosNavegarFormImpl.setFicherosSeleccionadosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ficheros</code>.
     */
    public void resetFicheros()
    {
        this.ficheros = null;
    }

    public void setFicheros(java.util.List ficheros)
    {
        this.ficheros = ficheros;
    }

    /**
     * <p>
     * Listado de ficheros hijos de la ruta en que se está navegando.
     * </p>
     */
    public java.util.List getFicheros()
    {
        return this.ficheros;
    }

    public void setFicherosAsArray(Object[] ficheros)
    {
        this.ficheros = (ficheros == null) ? null : java.util.Arrays.asList(ficheros);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.ArchivosNavegarFormImpl#getFicheros
     */
    public java.lang.Object[] getFicherosAsArray()
    {
        return (ficheros == null) ? null : ficheros.toArray();
    }
    
    public java.lang.Object[] getFicherosBackingList()
    {
        java.lang.Object[] values = this.ficherosValueList;
        java.lang.Object[] labels = this.ficherosLabelList;

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

    public java.lang.Object[] getFicherosValueList()
    {
        return this.ficherosValueList;
    }

    public void setFicherosValueList(java.lang.Object[] ficherosValueList)
    {
        this.ficherosValueList = ficherosValueList;
    }

    public java.lang.Object[] getFicherosLabelList()
    {
        return this.ficherosLabelList;
    }

    public void setFicherosLabelList(java.lang.Object[] ficherosLabelList)
    {
        this.ficherosLabelList = ficherosLabelList;
    }

    public void setFicherosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ArchivosNavegarFormImpl.setFicherosBackingList requires non-null property arguments");
        }

        this.ficherosValueList = null;
        this.ficherosLabelList = null;

        if (items != null)
        {
            this.ficherosValueList = new java.lang.Object[items.size()];
            this.ficherosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.ficherosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.ficherosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ArchivosNavegarFormImpl.setFicherosBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ArchivosNavegarFormImpl.setActionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ArchivosNavegarFormImpl.setActionBackingList encountered an exception", ex);
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
     * Barra de navegacion (breadcrumb)
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
     * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.ArchivosNavegarFormImpl#getPath
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
            throw new IllegalArgumentException("ArchivosNavegarFormImpl.setPathBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ArchivosNavegarFormImpl.setPathBackingList encountered an exception", ex);
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
     * <p>
     * Solo para el caso en que se implemente la vista por arbol en
     * este caso de uso.
     * </p>
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
            throw new IllegalArgumentException("ArchivosNavegarFormImpl.setArbolBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ArchivosNavegarFormImpl.setArbolBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ArchivosNavegarFormImpl.setIdentifierBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ArchivosNavegarFormImpl.setIdentifierBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ArchivosNavegarFormImpl.setHrefBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ArchivosNavegarFormImpl.setHrefBackingList encountered an exception", ex);
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
        builder.append("nombre", this.nombre);
        builder.append("ficherosSeleccionados", this.ficherosSeleccionados);
        builder.append("ficheros", this.ficheros);
        builder.append("action", this.action);
        builder.append("path", this.path);
        builder.append("arbol", this.arbol);
        builder.append("identifier", this.identifier);
        builder.append("href", this.href);
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
        this.ficherosSeleccionados = null;
        this.ficherosSeleccionadosValueList = null;
        this.ficherosSeleccionadosLabelList = null;
        this.ficheros = null;
        this.ficherosValueList = null;
        this.ficherosLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.path = null;
        this.pathValueList = null;
        this.pathLabelList = null;
        this.arbol = null;
        this.arbolValueList = null;
        this.arbolLabelList = null;
        this.identifier = null;
        this.identifierValueList = null;
        this.identifierLabelList = null;
        this.href = null;
        this.hrefValueList = null;
        this.hrefLabelList = null;
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
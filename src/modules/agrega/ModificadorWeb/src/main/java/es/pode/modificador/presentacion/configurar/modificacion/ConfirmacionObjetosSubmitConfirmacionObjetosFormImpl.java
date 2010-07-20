// license-header java merge-point
package es.pode.modificador.presentacion.configurar.modificacion;

public class ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.modificador.presentacion.configurar.modificacion.ObtenerDatosForm
        , es.pode.modificador.presentacion.configurar.modificacion.EliminarObjetosForm
        , es.pode.modificador.presentacion.configurar.modificacion.SubmitConfirmacionForm
{
    private java.util.List paths;
    private java.lang.Object[] pathsValueList;
    private java.lang.Object[] pathsLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.util.List pathRowSelection = null;
    private java.lang.Object[] pathValueList;
    private java.lang.Object[] pathLabelList;
    private int[] posiciones;
    private java.lang.Object[] posicionesValueList;
    private java.lang.Object[] posicionesLabelList;
    private java.lang.String tipoBusqueda;
    private java.lang.Object[] tipoBusquedaValueList;
    private java.lang.Object[] tipoBusquedaLabelList;
    private java.lang.String posicion;
    private java.lang.Object[] posicionValueList;
    private java.lang.Object[] posicionLabelList;
    private java.lang.Long idModificacion;
    private java.lang.Object[] idModificacionValueList;
    private java.lang.Object[] idModificacionLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private java.util.List cambios = null;
    private java.lang.Object[] cambiosValueList;
    private java.lang.Object[] cambiosLabelList;
    private java.util.List objetos = null;
    private java.lang.Object[] objetosValueList;
    private java.lang.Object[] objetosLabelList;

    public ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl()
    {
    }

    /**
     * Resets the given <code>paths</code>.
     */
    public void resetPaths()
    {
        this.paths = null;
    }

    public void setPaths(java.util.List paths)
    {
        this.paths = paths;
    }

    /**
     * 
     */
    public java.util.List getPaths()
    {
        return this.paths;
    }

    public void setPathsAsArray(Object[] paths)
    {
        this.paths = (paths == null) ? null : java.util.Arrays.asList(paths);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.modificador.presentacion.configurar.modificacion.ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl#getPaths
     */
    public java.lang.Object[] getPathsAsArray()
    {
        return (paths == null) ? null : paths.toArray();
    }
    
    public java.lang.Object[] getPathsBackingList()
    {
        java.lang.Object[] values = this.pathsValueList;
        java.lang.Object[] labels = this.pathsLabelList;

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

    public java.lang.Object[] getPathsValueList()
    {
        return this.pathsValueList;
    }

    public void setPathsValueList(java.lang.Object[] pathsValueList)
    {
        this.pathsValueList = pathsValueList;
    }

    public java.lang.Object[] getPathsLabelList()
    {
        return this.pathsLabelList;
    }

    public void setPathsLabelList(java.lang.Object[] pathsLabelList)
    {
        this.pathsLabelList = pathsLabelList;
    }

    public void setPathsBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setPathsBackingList requires non-null property arguments");
        }

        this.pathsValueList = null;
        this.pathsLabelList = null;

        if (items != null)
        {
            this.pathsValueList = new java.lang.Object[items.size()];
            this.pathsLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.pathsValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.pathsLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setPathsBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setActionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setActionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>pathRowSelection</code>.
     */
    public void resetPath()
    {
        this.pathRowSelection = null;
    }

    public void setPathRowSelection(java.util.List pathRowSelection)
    {
        this.pathRowSelection = pathRowSelection;
    }

    public java.util.List getPathRowSelection()
    {
        return this.pathRowSelection;
    }

    public void setPathRowSelectionAsArray(java.lang.String[] pathRowSelection)
    {
        this.pathRowSelection = (pathRowSelection == null) ? null : java.util.Arrays.asList(pathRowSelection);
    }

    public java.lang.String[] getPathRowSelectionAsArray()
    {
        return (pathRowSelection == null) ? null : (java.lang.String[])pathRowSelection.toArray(new java.lang.String[pathRowSelection.size()]);
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
            throw new IllegalArgumentException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setPathBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setPathBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>posiciones</code>.
     */
    public void resetPosiciones()
    {
        this.posiciones = null;
    }

    public void setPosiciones(int[] posiciones)
    {
        this.posiciones = posiciones;
    }

    /**
     * 
     */
    public int[] getPosiciones()
    {
        return this.posiciones;
    }
    
    public java.lang.Object[] getPosicionesBackingList()
    {
        java.lang.Object[] values = this.posicionesValueList;
        java.lang.Object[] labels = this.posicionesLabelList;

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

    public java.lang.Object[] getPosicionesValueList()
    {
        return this.posicionesValueList;
    }

    public void setPosicionesValueList(java.lang.Object[] posicionesValueList)
    {
        this.posicionesValueList = posicionesValueList;
    }

    public java.lang.Object[] getPosicionesLabelList()
    {
        return this.posicionesLabelList;
    }

    public void setPosicionesLabelList(java.lang.Object[] posicionesLabelList)
    {
        this.posicionesLabelList = posicionesLabelList;
    }

    public void setPosicionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setPosicionesBackingList requires non-null property arguments");
        }

        this.posicionesValueList = null;
        this.posicionesLabelList = null;

        if (items != null)
        {
            this.posicionesValueList = new java.lang.Object[items.size()];
            this.posicionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.posicionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.posicionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setPosicionesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tipoBusqueda</code>.
     */
    public void resetTipoBusqueda()
    {
        this.tipoBusqueda = null;
    }

    public void setTipoBusqueda(java.lang.String tipoBusqueda)
    {
        this.tipoBusqueda = tipoBusqueda;
    }

    /**
     * 
     */
    public java.lang.String getTipoBusqueda()
    {
        return this.tipoBusqueda;
    }
    
    public java.lang.Object[] getTipoBusquedaBackingList()
    {
        java.lang.Object[] values = this.tipoBusquedaValueList;
        java.lang.Object[] labels = this.tipoBusquedaLabelList;

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

    public java.lang.Object[] getTipoBusquedaValueList()
    {
        return this.tipoBusquedaValueList;
    }

    public void setTipoBusquedaValueList(java.lang.Object[] tipoBusquedaValueList)
    {
        this.tipoBusquedaValueList = tipoBusquedaValueList;
    }

    public java.lang.Object[] getTipoBusquedaLabelList()
    {
        return this.tipoBusquedaLabelList;
    }

    public void setTipoBusquedaLabelList(java.lang.Object[] tipoBusquedaLabelList)
    {
        this.tipoBusquedaLabelList = tipoBusquedaLabelList;
    }

    public void setTipoBusquedaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setTipoBusquedaBackingList requires non-null property arguments");
        }

        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;

        if (items != null)
        {
            this.tipoBusquedaValueList = new java.lang.Object[items.size()];
            this.tipoBusquedaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tipoBusquedaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tipoBusquedaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setTipoBusquedaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>posicion</code>.
     */
    public void resetPosicion()
    {
        this.posicion = null;
    }

    public void setPosicion(java.lang.String posicion)
    {
        this.posicion = posicion;
    }

    /**
     * 
     */
    public java.lang.String getPosicion()
    {
        return this.posicion;
    }
    
    public java.lang.Object[] getPosicionBackingList()
    {
        java.lang.Object[] values = this.posicionValueList;
        java.lang.Object[] labels = this.posicionLabelList;

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

    public java.lang.Object[] getPosicionValueList()
    {
        return this.posicionValueList;
    }

    public void setPosicionValueList(java.lang.Object[] posicionValueList)
    {
        this.posicionValueList = posicionValueList;
    }

    public java.lang.Object[] getPosicionLabelList()
    {
        return this.posicionLabelList;
    }

    public void setPosicionLabelList(java.lang.Object[] posicionLabelList)
    {
        this.posicionLabelList = posicionLabelList;
    }

    public void setPosicionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setPosicionBackingList requires non-null property arguments");
        }

        this.posicionValueList = null;
        this.posicionLabelList = null;

        if (items != null)
        {
            this.posicionValueList = new java.lang.Object[items.size()];
            this.posicionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.posicionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.posicionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setPosicionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idModificacion</code>.
     */
    public void resetIdModificacion()
    {
        this.idModificacion = null;
    }

    public void setIdModificacion(java.lang.Long idModificacion)
    {
        this.idModificacion = idModificacion;
    }

    /**
     * 
     */
    public java.lang.Long getIdModificacion()
    {
        return this.idModificacion;
    }
    
    public java.lang.Object[] getIdModificacionBackingList()
    {
        java.lang.Object[] values = this.idModificacionValueList;
        java.lang.Object[] labels = this.idModificacionLabelList;

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

    public java.lang.Object[] getIdModificacionValueList()
    {
        return this.idModificacionValueList;
    }

    public void setIdModificacionValueList(java.lang.Object[] idModificacionValueList)
    {
        this.idModificacionValueList = idModificacionValueList;
    }

    public java.lang.Object[] getIdModificacionLabelList()
    {
        return this.idModificacionLabelList;
    }

    public void setIdModificacionLabelList(java.lang.Object[] idModificacionLabelList)
    {
        this.idModificacionLabelList = idModificacionLabelList;
    }

    public void setIdModificacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setIdModificacionBackingList requires non-null property arguments");
        }

        this.idModificacionValueList = null;
        this.idModificacionLabelList = null;

        if (items != null)
        {
            this.idModificacionValueList = new java.lang.Object[items.size()];
            this.idModificacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idModificacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idModificacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setIdModificacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomaBuscador</code>.
     */
    public void resetIdiomaBuscador()
    {
        this.idiomaBuscador = null;
    }

    public void setIdiomaBuscador(java.lang.String idiomaBuscador)
    {
        this.idiomaBuscador = idiomaBuscador;
    }

    /**
     * 
     */
    public java.lang.String getIdiomaBuscador()
    {
        return this.idiomaBuscador;
    }
    
    public java.lang.Object[] getIdiomaBuscadorBackingList()
    {
        java.lang.Object[] values = this.idiomaBuscadorValueList;
        java.lang.Object[] labels = this.idiomaBuscadorLabelList;

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

    public java.lang.Object[] getIdiomaBuscadorValueList()
    {
        return this.idiomaBuscadorValueList;
    }

    public void setIdiomaBuscadorValueList(java.lang.Object[] idiomaBuscadorValueList)
    {
        this.idiomaBuscadorValueList = idiomaBuscadorValueList;
    }

    public java.lang.Object[] getIdiomaBuscadorLabelList()
    {
        return this.idiomaBuscadorLabelList;
    }

    public void setIdiomaBuscadorLabelList(java.lang.Object[] idiomaBuscadorLabelList)
    {
        this.idiomaBuscadorLabelList = idiomaBuscadorLabelList;
    }

    public void setIdiomaBuscadorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
        }

        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;

        if (items != null)
        {
            this.idiomaBuscadorValueList = new java.lang.Object[items.size()];
            this.idiomaBuscadorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomaBuscadorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomaBuscadorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>cambios</code>.
     */
    public void resetCambios()
    {
        this.cambios = null;
    }

    public void setCambios(java.util.List cambios)
    {
        this.cambios = cambios;
    }

    /**
     * 
     */
    public java.util.List getCambios()
    {
        return this.cambios;
    }

    public void setCambiosAsArray(Object[] cambios)
    {
        this.cambios = (cambios == null) ? null : java.util.Arrays.asList(cambios);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.modificador.presentacion.configurar.modificacion.ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl#getCambios
     */
    public java.lang.Object[] getCambiosAsArray()
    {
        return (cambios == null) ? null : cambios.toArray();
    }
    
    public java.lang.Object[] getCambiosBackingList()
    {
        java.lang.Object[] values = this.cambiosValueList;
        java.lang.Object[] labels = this.cambiosLabelList;

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

    public java.lang.Object[] getCambiosValueList()
    {
        return this.cambiosValueList;
    }

    public void setCambiosValueList(java.lang.Object[] cambiosValueList)
    {
        this.cambiosValueList = cambiosValueList;
    }

    public java.lang.Object[] getCambiosLabelList()
    {
        return this.cambiosLabelList;
    }

    public void setCambiosLabelList(java.lang.Object[] cambiosLabelList)
    {
        this.cambiosLabelList = cambiosLabelList;
    }

    public void setCambiosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setCambiosBackingList requires non-null property arguments");
        }

        this.cambiosValueList = null;
        this.cambiosLabelList = null;

        if (items != null)
        {
            this.cambiosValueList = new java.lang.Object[items.size()];
            this.cambiosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.cambiosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.cambiosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setCambiosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>objetos</code>.
     */
    public void resetObjetos()
    {
        this.objetos = null;
    }

    public void setObjetos(java.util.List objetos)
    {
        this.objetos = objetos;
    }

    /**
     * 
     */
    public java.util.List getObjetos()
    {
        return this.objetos;
    }

    public void setObjetosAsArray(Object[] objetos)
    {
        this.objetos = (objetos == null) ? null : java.util.Arrays.asList(objetos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.modificador.presentacion.configurar.modificacion.ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl#getObjetos
     */
    public java.lang.Object[] getObjetosAsArray()
    {
        return (objetos == null) ? null : objetos.toArray();
    }
    
    public java.lang.Object[] getObjetosBackingList()
    {
        java.lang.Object[] values = this.objetosValueList;
        java.lang.Object[] labels = this.objetosLabelList;

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

    public java.lang.Object[] getObjetosValueList()
    {
        return this.objetosValueList;
    }

    public void setObjetosValueList(java.lang.Object[] objetosValueList)
    {
        this.objetosValueList = objetosValueList;
    }

    public java.lang.Object[] getObjetosLabelList()
    {
        return this.objetosLabelList;
    }

    public void setObjetosLabelList(java.lang.Object[] objetosLabelList)
    {
        this.objetosLabelList = objetosLabelList;
    }

    public void setObjetosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setObjetosBackingList requires non-null property arguments");
        }

        this.objetosValueList = null;
        this.objetosLabelList = null;

        if (items != null)
        {
            this.objetosValueList = new java.lang.Object[items.size()];
            this.objetosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.objetosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.objetosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ConfirmacionObjetosSubmitConfirmacionObjetosFormImpl.setObjetosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.paths = null;
        this.pathsValueList = new java.lang.Object[0];
        this.pathsLabelList = new java.lang.Object[0];
        this.pathRowSelection = null;
        this.posiciones = null;
        this.posicionesValueList = new java.lang.Object[0];
        this.posicionesLabelList = new java.lang.Object[0];
        this.idiomaBuscador = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("paths", this.paths);
        builder.append("action", this.action);
        builder.append("pathRowSelection", this.pathRowSelection);
        builder.append("posiciones", this.posiciones);
        builder.append("tipoBusqueda", this.tipoBusqueda);
        builder.append("posicion", this.posicion);
        builder.append("idModificacion", this.idModificacion);
        builder.append("idiomaBuscador", this.idiomaBuscador);
        builder.append("cambios", this.cambios);
        builder.append("objetos", this.objetos);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.paths = null;
        this.pathsValueList = null;
        this.pathsLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.pathRowSelection = null;
        this.posiciones = null;
        this.posicionesValueList = null;
        this.posicionesLabelList = null;
        this.tipoBusqueda = null;
        this.tipoBusquedaValueList = null;
        this.tipoBusquedaLabelList = null;
        this.posicion = null;
        this.posicionValueList = null;
        this.posicionLabelList = null;
        this.idModificacion = null;
        this.idModificacionValueList = null;
        this.idModificacionLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
        this.cambios = null;
        this.cambiosValueList = null;
        this.cambiosLabelList = null;
        this.objetos = null;
        this.objetosValueList = null;
        this.objetosLabelList = null;
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
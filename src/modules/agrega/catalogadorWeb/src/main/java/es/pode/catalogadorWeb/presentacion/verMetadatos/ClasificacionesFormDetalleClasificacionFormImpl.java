// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

public class ClasificacionesFormDetalleClasificacionFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDetalleClasificacionForm
{
    private java.lang.String botonPulsado;
    private java.lang.Object[] botonPulsadoValueList;
    private java.lang.Object[] botonPulsadoLabelList;
    private java.util.Collection descripciones;
    private java.lang.Object[] descripcionesValueList;
    private java.lang.Object[] descripcionesLabelList;
    private java.lang.String source;
    private java.lang.Object[] sourceValueList;
    private java.lang.Object[] sourceLabelList;
    private java.util.Collection listadoClasificaciones;
    private java.lang.Object[] listadoClasificacionesValueList;
    private java.lang.Object[] listadoClasificacionesLabelList;
    private java.util.Collection palabrasClave;
    private java.lang.Object[] palabrasClaveValueList;
    private java.lang.Object[] palabrasClaveLabelList;
    private java.lang.String comboIdioma;
    private java.lang.Object[] comboIdiomaValueList;
    private java.lang.Object[] comboIdiomaLabelList;
    private java.lang.String tituloClasificacion;
    private java.lang.Object[] tituloClasificacionValueList;
    private java.lang.Object[] tituloClasificacionLabelList;
    private java.util.Collection rutaTaxonomica;
    private java.lang.Object[] rutaTaxonomicaValueList;
    private java.lang.Object[] rutaTaxonomicaLabelList;
    private java.lang.String proposito;
    private java.lang.Object[] propositoValueList;
    private java.lang.Object[] propositoLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;

    public ClasificacionesFormDetalleClasificacionFormImpl()
    {
    }

    /**
     * Resets the given <code>botonPulsado</code>.
     */
    public void resetBotonPulsado()
    {
        this.botonPulsado = null;
    }

    public void setBotonPulsado(java.lang.String botonPulsado)
    {
        this.botonPulsado = botonPulsado;
    }

    /**
     * 
     */
    public java.lang.String getBotonPulsado()
    {
        return this.botonPulsado;
    }
    
    public java.lang.Object[] getBotonPulsadoBackingList()
    {
        java.lang.Object[] values = this.botonPulsadoValueList;
        java.lang.Object[] labels = this.botonPulsadoLabelList;

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

    public java.lang.Object[] getBotonPulsadoValueList()
    {
        return this.botonPulsadoValueList;
    }

    public void setBotonPulsadoValueList(java.lang.Object[] botonPulsadoValueList)
    {
        this.botonPulsadoValueList = botonPulsadoValueList;
    }

    public java.lang.Object[] getBotonPulsadoLabelList()
    {
        return this.botonPulsadoLabelList;
    }

    public void setBotonPulsadoLabelList(java.lang.Object[] botonPulsadoLabelList)
    {
        this.botonPulsadoLabelList = botonPulsadoLabelList;
    }

    public void setBotonPulsadoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ClasificacionesFormDetalleClasificacionFormImpl.setBotonPulsadoBackingList requires non-null property arguments");
        }

        this.botonPulsadoValueList = null;
        this.botonPulsadoLabelList = null;

        if (items != null)
        {
            this.botonPulsadoValueList = new java.lang.Object[items.size()];
            this.botonPulsadoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.botonPulsadoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.botonPulsadoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ClasificacionesFormDetalleClasificacionFormImpl.setBotonPulsadoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripciones</code>.
     */
    public void resetDescripciones()
    {
        this.descripciones = null;
    }

    public void setDescripciones(java.util.Collection descripciones)
    {
        this.descripciones = descripciones;
    }

    /**
     * 
     */
    public java.util.Collection getDescripciones()
    {
        return this.descripciones;
    }

    public void setDescripcionesAsArray(Object[] descripciones)
    {
        this.descripciones = (descripciones == null) ? null : java.util.Arrays.asList(descripciones);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.ClasificacionesFormDetalleClasificacionFormImpl#getDescripciones
     */
    public java.lang.Object[] getDescripcionesAsArray()
    {
        return (descripciones == null) ? null : descripciones.toArray();
    }
    
    public java.lang.Object[] getDescripcionesBackingList()
    {
        java.lang.Object[] values = this.descripcionesValueList;
        java.lang.Object[] labels = this.descripcionesLabelList;

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

    public java.lang.Object[] getDescripcionesValueList()
    {
        return this.descripcionesValueList;
    }

    public void setDescripcionesValueList(java.lang.Object[] descripcionesValueList)
    {
        this.descripcionesValueList = descripcionesValueList;
    }

    public java.lang.Object[] getDescripcionesLabelList()
    {
        return this.descripcionesLabelList;
    }

    public void setDescripcionesLabelList(java.lang.Object[] descripcionesLabelList)
    {
        this.descripcionesLabelList = descripcionesLabelList;
    }

    public void setDescripcionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ClasificacionesFormDetalleClasificacionFormImpl.setDescripcionesBackingList requires non-null property arguments");
        }

        this.descripcionesValueList = null;
        this.descripcionesLabelList = null;

        if (items != null)
        {
            this.descripcionesValueList = new java.lang.Object[items.size()];
            this.descripcionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ClasificacionesFormDetalleClasificacionFormImpl.setDescripcionesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>source</code>.
     */
    public void resetSource()
    {
        this.source = null;
    }

    public void setSource(java.lang.String source)
    {
        this.source = source;
    }

    /**
     * 
     */
    public java.lang.String getSource()
    {
        return this.source;
    }
    
    public java.lang.Object[] getSourceBackingList()
    {
        java.lang.Object[] values = this.sourceValueList;
        java.lang.Object[] labels = this.sourceLabelList;

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

    public java.lang.Object[] getSourceValueList()
    {
        return this.sourceValueList;
    }

    public void setSourceValueList(java.lang.Object[] sourceValueList)
    {
        this.sourceValueList = sourceValueList;
    }

    public java.lang.Object[] getSourceLabelList()
    {
        return this.sourceLabelList;
    }

    public void setSourceLabelList(java.lang.Object[] sourceLabelList)
    {
        this.sourceLabelList = sourceLabelList;
    }

    public void setSourceBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ClasificacionesFormDetalleClasificacionFormImpl.setSourceBackingList requires non-null property arguments");
        }

        this.sourceValueList = null;
        this.sourceLabelList = null;

        if (items != null)
        {
            this.sourceValueList = new java.lang.Object[items.size()];
            this.sourceLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.sourceValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.sourceLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ClasificacionesFormDetalleClasificacionFormImpl.setSourceBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listadoClasificaciones</code>.
     */
    public void resetListadoClasificaciones()
    {
        this.listadoClasificaciones = null;
    }

    public void setListadoClasificaciones(java.util.Collection listadoClasificaciones)
    {
        this.listadoClasificaciones = listadoClasificaciones;
    }

    /**
     * 
     */
    public java.util.Collection getListadoClasificaciones()
    {
        return this.listadoClasificaciones;
    }

    public void setListadoClasificacionesAsArray(Object[] listadoClasificaciones)
    {
        this.listadoClasificaciones = (listadoClasificaciones == null) ? null : java.util.Arrays.asList(listadoClasificaciones);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.ClasificacionesFormDetalleClasificacionFormImpl#getListadoClasificaciones
     */
    public java.lang.Object[] getListadoClasificacionesAsArray()
    {
        return (listadoClasificaciones == null) ? null : listadoClasificaciones.toArray();
    }
    
    public java.lang.Object[] getListadoClasificacionesBackingList()
    {
        java.lang.Object[] values = this.listadoClasificacionesValueList;
        java.lang.Object[] labels = this.listadoClasificacionesLabelList;

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

    public java.lang.Object[] getListadoClasificacionesValueList()
    {
        return this.listadoClasificacionesValueList;
    }

    public void setListadoClasificacionesValueList(java.lang.Object[] listadoClasificacionesValueList)
    {
        this.listadoClasificacionesValueList = listadoClasificacionesValueList;
    }

    public java.lang.Object[] getListadoClasificacionesLabelList()
    {
        return this.listadoClasificacionesLabelList;
    }

    public void setListadoClasificacionesLabelList(java.lang.Object[] listadoClasificacionesLabelList)
    {
        this.listadoClasificacionesLabelList = listadoClasificacionesLabelList;
    }

    public void setListadoClasificacionesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ClasificacionesFormDetalleClasificacionFormImpl.setListadoClasificacionesBackingList requires non-null property arguments");
        }

        this.listadoClasificacionesValueList = null;
        this.listadoClasificacionesLabelList = null;

        if (items != null)
        {
            this.listadoClasificacionesValueList = new java.lang.Object[items.size()];
            this.listadoClasificacionesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listadoClasificacionesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listadoClasificacionesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ClasificacionesFormDetalleClasificacionFormImpl.setListadoClasificacionesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>palabrasClave</code>.
     */
    public void resetPalabrasClave()
    {
        this.palabrasClave = null;
    }

    public void setPalabrasClave(java.util.Collection palabrasClave)
    {
        this.palabrasClave = palabrasClave;
    }

    /**
     * 
     */
    public java.util.Collection getPalabrasClave()
    {
        return this.palabrasClave;
    }

    public void setPalabrasClaveAsArray(Object[] palabrasClave)
    {
        this.palabrasClave = (palabrasClave == null) ? null : java.util.Arrays.asList(palabrasClave);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.ClasificacionesFormDetalleClasificacionFormImpl#getPalabrasClave
     */
    public java.lang.Object[] getPalabrasClaveAsArray()
    {
        return (palabrasClave == null) ? null : palabrasClave.toArray();
    }
    
    public java.lang.Object[] getPalabrasClaveBackingList()
    {
        java.lang.Object[] values = this.palabrasClaveValueList;
        java.lang.Object[] labels = this.palabrasClaveLabelList;

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

    public java.lang.Object[] getPalabrasClaveValueList()
    {
        return this.palabrasClaveValueList;
    }

    public void setPalabrasClaveValueList(java.lang.Object[] palabrasClaveValueList)
    {
        this.palabrasClaveValueList = palabrasClaveValueList;
    }

    public java.lang.Object[] getPalabrasClaveLabelList()
    {
        return this.palabrasClaveLabelList;
    }

    public void setPalabrasClaveLabelList(java.lang.Object[] palabrasClaveLabelList)
    {
        this.palabrasClaveLabelList = palabrasClaveLabelList;
    }

    public void setPalabrasClaveBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ClasificacionesFormDetalleClasificacionFormImpl.setPalabrasClaveBackingList requires non-null property arguments");
        }

        this.palabrasClaveValueList = null;
        this.palabrasClaveLabelList = null;

        if (items != null)
        {
            this.palabrasClaveValueList = new java.lang.Object[items.size()];
            this.palabrasClaveLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.palabrasClaveValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.palabrasClaveLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ClasificacionesFormDetalleClasificacionFormImpl.setPalabrasClaveBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboIdioma</code>.
     */
    public void resetComboIdioma()
    {
        this.comboIdioma = null;
    }

    public void setComboIdioma(java.lang.String comboIdioma)
    {
        this.comboIdioma = comboIdioma;
    }

    /**
     * 
     */
    public java.lang.String getComboIdioma()
    {
        return this.comboIdioma;
    }
    
    public java.lang.Object[] getComboIdiomaBackingList()
    {
        java.lang.Object[] values = this.comboIdiomaValueList;
        java.lang.Object[] labels = this.comboIdiomaLabelList;

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

    public java.lang.Object[] getComboIdiomaValueList()
    {
        return this.comboIdiomaValueList;
    }

    public void setComboIdiomaValueList(java.lang.Object[] comboIdiomaValueList)
    {
        this.comboIdiomaValueList = comboIdiomaValueList;
    }

    public java.lang.Object[] getComboIdiomaLabelList()
    {
        return this.comboIdiomaLabelList;
    }

    public void setComboIdiomaLabelList(java.lang.Object[] comboIdiomaLabelList)
    {
        this.comboIdiomaLabelList = comboIdiomaLabelList;
    }

    public void setComboIdiomaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ClasificacionesFormDetalleClasificacionFormImpl.setComboIdiomaBackingList requires non-null property arguments");
        }

        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;

        if (items != null)
        {
            this.comboIdiomaValueList = new java.lang.Object[items.size()];
            this.comboIdiomaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboIdiomaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboIdiomaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ClasificacionesFormDetalleClasificacionFormImpl.setComboIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tituloClasificacion</code>.
     */
    public void resetTituloClasificacion()
    {
        this.tituloClasificacion = null;
    }

    public void setTituloClasificacion(java.lang.String tituloClasificacion)
    {
        this.tituloClasificacion = tituloClasificacion;
    }

    /**
     * 
     */
    public java.lang.String getTituloClasificacion()
    {
        return this.tituloClasificacion;
    }
    
    public java.lang.Object[] getTituloClasificacionBackingList()
    {
        java.lang.Object[] values = this.tituloClasificacionValueList;
        java.lang.Object[] labels = this.tituloClasificacionLabelList;

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

    public java.lang.Object[] getTituloClasificacionValueList()
    {
        return this.tituloClasificacionValueList;
    }

    public void setTituloClasificacionValueList(java.lang.Object[] tituloClasificacionValueList)
    {
        this.tituloClasificacionValueList = tituloClasificacionValueList;
    }

    public java.lang.Object[] getTituloClasificacionLabelList()
    {
        return this.tituloClasificacionLabelList;
    }

    public void setTituloClasificacionLabelList(java.lang.Object[] tituloClasificacionLabelList)
    {
        this.tituloClasificacionLabelList = tituloClasificacionLabelList;
    }

    public void setTituloClasificacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ClasificacionesFormDetalleClasificacionFormImpl.setTituloClasificacionBackingList requires non-null property arguments");
        }

        this.tituloClasificacionValueList = null;
        this.tituloClasificacionLabelList = null;

        if (items != null)
        {
            this.tituloClasificacionValueList = new java.lang.Object[items.size()];
            this.tituloClasificacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tituloClasificacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tituloClasificacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ClasificacionesFormDetalleClasificacionFormImpl.setTituloClasificacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>rutaTaxonomica</code>.
     */
    public void resetRutaTaxonomica()
    {
        this.rutaTaxonomica = null;
    }

    public void setRutaTaxonomica(java.util.Collection rutaTaxonomica)
    {
        this.rutaTaxonomica = rutaTaxonomica;
    }

    /**
     * 
     */
    public java.util.Collection getRutaTaxonomica()
    {
        return this.rutaTaxonomica;
    }

    public void setRutaTaxonomicaAsArray(Object[] rutaTaxonomica)
    {
        this.rutaTaxonomica = (rutaTaxonomica == null) ? null : java.util.Arrays.asList(rutaTaxonomica);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.verMetadatos.ClasificacionesFormDetalleClasificacionFormImpl#getRutaTaxonomica
     */
    public java.lang.Object[] getRutaTaxonomicaAsArray()
    {
        return (rutaTaxonomica == null) ? null : rutaTaxonomica.toArray();
    }
    
    public java.lang.Object[] getRutaTaxonomicaBackingList()
    {
        java.lang.Object[] values = this.rutaTaxonomicaValueList;
        java.lang.Object[] labels = this.rutaTaxonomicaLabelList;

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

    public java.lang.Object[] getRutaTaxonomicaValueList()
    {
        return this.rutaTaxonomicaValueList;
    }

    public void setRutaTaxonomicaValueList(java.lang.Object[] rutaTaxonomicaValueList)
    {
        this.rutaTaxonomicaValueList = rutaTaxonomicaValueList;
    }

    public java.lang.Object[] getRutaTaxonomicaLabelList()
    {
        return this.rutaTaxonomicaLabelList;
    }

    public void setRutaTaxonomicaLabelList(java.lang.Object[] rutaTaxonomicaLabelList)
    {
        this.rutaTaxonomicaLabelList = rutaTaxonomicaLabelList;
    }

    public void setRutaTaxonomicaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ClasificacionesFormDetalleClasificacionFormImpl.setRutaTaxonomicaBackingList requires non-null property arguments");
        }

        this.rutaTaxonomicaValueList = null;
        this.rutaTaxonomicaLabelList = null;

        if (items != null)
        {
            this.rutaTaxonomicaValueList = new java.lang.Object[items.size()];
            this.rutaTaxonomicaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.rutaTaxonomicaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.rutaTaxonomicaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ClasificacionesFormDetalleClasificacionFormImpl.setRutaTaxonomicaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>proposito</code>.
     */
    public void resetProposito()
    {
        this.proposito = null;
    }

    public void setProposito(java.lang.String proposito)
    {
        this.proposito = proposito;
    }

    /**
     * 
     */
    public java.lang.String getProposito()
    {
        return this.proposito;
    }
    
    public java.lang.Object[] getPropositoBackingList()
    {
        java.lang.Object[] values = this.propositoValueList;
        java.lang.Object[] labels = this.propositoLabelList;

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

    public java.lang.Object[] getPropositoValueList()
    {
        return this.propositoValueList;
    }

    public void setPropositoValueList(java.lang.Object[] propositoValueList)
    {
        this.propositoValueList = propositoValueList;
    }

    public java.lang.Object[] getPropositoLabelList()
    {
        return this.propositoLabelList;
    }

    public void setPropositoLabelList(java.lang.Object[] propositoLabelList)
    {
        this.propositoLabelList = propositoLabelList;
    }

    public void setPropositoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ClasificacionesFormDetalleClasificacionFormImpl.setPropositoBackingList requires non-null property arguments");
        }

        this.propositoValueList = null;
        this.propositoLabelList = null;

        if (items != null)
        {
            this.propositoValueList = new java.lang.Object[items.size()];
            this.propositoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.propositoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.propositoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ClasificacionesFormDetalleClasificacionFormImpl.setPropositoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificadorOde</code>.
     */
    public void resetIdentificadorOde()
    {
        this.identificadorOde = null;
    }

    public void setIdentificadorOde(java.lang.String identificadorOde)
    {
        this.identificadorOde = identificadorOde;
    }

    /**
     * 
     */
    public java.lang.String getIdentificadorOde()
    {
        return this.identificadorOde;
    }
    
    public java.lang.Object[] getIdentificadorOdeBackingList()
    {
        java.lang.Object[] values = this.identificadorOdeValueList;
        java.lang.Object[] labels = this.identificadorOdeLabelList;

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

    public java.lang.Object[] getIdentificadorOdeValueList()
    {
        return this.identificadorOdeValueList;
    }

    public void setIdentificadorOdeValueList(java.lang.Object[] identificadorOdeValueList)
    {
        this.identificadorOdeValueList = identificadorOdeValueList;
    }

    public java.lang.Object[] getIdentificadorOdeLabelList()
    {
        return this.identificadorOdeLabelList;
    }

    public void setIdentificadorOdeLabelList(java.lang.Object[] identificadorOdeLabelList)
    {
        this.identificadorOdeLabelList = identificadorOdeLabelList;
    }

    public void setIdentificadorOdeBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ClasificacionesFormDetalleClasificacionFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
        }

        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;

        if (items != null)
        {
            this.identificadorOdeValueList = new java.lang.Object[items.size()];
            this.identificadorOdeLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadorOdeValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadorOdeLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ClasificacionesFormDetalleClasificacionFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.source = null;
        this.listadoClasificaciones = null;
        this.listadoClasificacionesValueList = new java.lang.Object[0];
        this.listadoClasificacionesLabelList = new java.lang.Object[0];
        this.comboIdioma = null;
        this.proposito = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("botonPulsado", this.botonPulsado);
        builder.append("descripciones", this.descripciones);
        builder.append("source", this.source);
        builder.append("listadoClasificaciones", this.listadoClasificaciones);
        builder.append("palabrasClave", this.palabrasClave);
        builder.append("comboIdioma", this.comboIdioma);
        builder.append("tituloClasificacion", this.tituloClasificacion);
        builder.append("rutaTaxonomica", this.rutaTaxonomica);
        builder.append("proposito", this.proposito);
        builder.append("identificadorOde", this.identificadorOde);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.botonPulsado = null;
        this.botonPulsadoValueList = null;
        this.botonPulsadoLabelList = null;
        this.descripciones = null;
        this.descripcionesValueList = null;
        this.descripcionesLabelList = null;
        this.source = null;
        this.sourceValueList = null;
        this.sourceLabelList = null;
        this.listadoClasificaciones = null;
        this.listadoClasificacionesValueList = null;
        this.listadoClasificacionesLabelList = null;
        this.palabrasClave = null;
        this.palabrasClaveValueList = null;
        this.palabrasClaveLabelList = null;
        this.comboIdioma = null;
        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;
        this.tituloClasificacion = null;
        this.tituloClasificacionValueList = null;
        this.tituloClasificacionLabelList = null;
        this.rutaTaxonomica = null;
        this.rutaTaxonomicaValueList = null;
        this.rutaTaxonomicaLabelList = null;
        this.proposito = null;
        this.propositoValueList = null;
        this.propositoLabelList = null;
        this.identificadorOde = null;
        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;
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
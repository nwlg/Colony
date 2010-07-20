// license-header java merge-point
package es.pode.administracion.presentacion.descargas.crear;

public class CrearDescargaFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.administracion.presentacion.descargas.crear.ObtenerDatosForm
{
    private java.lang.String descripcion_en;
    private java.lang.Object[] descripcion_enValueList;
    private java.lang.Object[] descripcion_enLabelList;
    private java.util.List descripciones;
    private java.lang.Object[] descripcionesValueList;
    private java.lang.Object[] descripcionesLabelList;
    private java.lang.String descripcion_gl;
    private java.lang.Object[] descripcion_glValueList;
    private java.lang.Object[] descripcion_glLabelList;
    private java.lang.String descripcion_va;
    private java.lang.Object[] descripcion_vaValueList;
    private java.lang.Object[] descripcion_vaLabelList;
    private java.lang.String titulo_es;
    private java.lang.Object[] titulo_esValueList;
    private java.lang.Object[] titulo_esLabelList;
    private java.lang.String titulo_gl;
    private java.lang.Object[] titulo_glValueList;
    private java.lang.Object[] titulo_glLabelList;
    private java.lang.String titulo_eu;
    private java.lang.Object[] titulo_euValueList;
    private java.lang.Object[] titulo_euLabelList;
    private java.lang.String descripcion_ca;
    private java.lang.Object[] descripcion_caValueList;
    private java.lang.Object[] descripcion_caLabelList;
    private java.lang.String titulo_ca;
    private java.lang.Object[] titulo_caValueList;
    private java.lang.Object[] titulo_caLabelList;
    private java.lang.String descripcion_es;
    private java.lang.Object[] descripcion_esValueList;
    private java.lang.Object[] descripcion_esLabelList;
    private java.lang.String descripcion_eu;
    private java.lang.Object[] descripcion_euValueList;
    private java.lang.Object[] descripcion_euLabelList;
    private java.lang.String path;
    private java.lang.Object[] pathValueList;
    private java.lang.Object[] pathLabelList;
    private java.lang.String action;
    private java.lang.Object[] actionValueList;
    private java.lang.Object[] actionLabelList;
    private java.lang.String titulo_va;
    private java.lang.Object[] titulo_vaValueList;
    private java.lang.Object[] titulo_vaLabelList;
    private java.lang.String titulo_en;
    private java.lang.Object[] titulo_enValueList;
    private java.lang.Object[] titulo_enLabelList;

    public CrearDescargaFormImpl()
    {
    }

    /**
     * Resets the given <code>descripcion_en</code>.
     */
    public void resetDescripcion_en()
    {
        this.descripcion_en = null;
    }

    public void setDescripcion_en(java.lang.String descripcion_en)
    {
        this.descripcion_en = descripcion_en;
    }

    /**
     * 
     */
    public java.lang.String getDescripcion_en()
    {
        return this.descripcion_en;
    }
    
    public java.lang.Object[] getDescripcion_enBackingList()
    {
        java.lang.Object[] values = this.descripcion_enValueList;
        java.lang.Object[] labels = this.descripcion_enLabelList;

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

    public java.lang.Object[] getDescripcion_enValueList()
    {
        return this.descripcion_enValueList;
    }

    public void setDescripcion_enValueList(java.lang.Object[] descripcion_enValueList)
    {
        this.descripcion_enValueList = descripcion_enValueList;
    }

    public java.lang.Object[] getDescripcion_enLabelList()
    {
        return this.descripcion_enLabelList;
    }

    public void setDescripcion_enLabelList(java.lang.Object[] descripcion_enLabelList)
    {
        this.descripcion_enLabelList = descripcion_enLabelList;
    }

    public void setDescripcion_enBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearDescargaFormImpl.setDescripcion_enBackingList requires non-null property arguments");
        }

        this.descripcion_enValueList = null;
        this.descripcion_enLabelList = null;

        if (items != null)
        {
            this.descripcion_enValueList = new java.lang.Object[items.size()];
            this.descripcion_enLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcion_enValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcion_enLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setDescripcion_enBackingList encountered an exception", ex);
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

    public void setDescripciones(java.util.List descripciones)
    {
        this.descripciones = descripciones;
    }

    /**
     * 
     */
    public java.util.List getDescripciones()
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
     * @see es.pode.administracion.presentacion.descargas.crear.CrearDescargaFormImpl#getDescripciones
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
            throw new IllegalArgumentException("CrearDescargaFormImpl.setDescripcionesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setDescripcionesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcion_gl</code>.
     */
    public void resetDescripcion_gl()
    {
        this.descripcion_gl = null;
    }

    public void setDescripcion_gl(java.lang.String descripcion_gl)
    {
        this.descripcion_gl = descripcion_gl;
    }

    /**
     * 
     */
    public java.lang.String getDescripcion_gl()
    {
        return this.descripcion_gl;
    }
    
    public java.lang.Object[] getDescripcion_glBackingList()
    {
        java.lang.Object[] values = this.descripcion_glValueList;
        java.lang.Object[] labels = this.descripcion_glLabelList;

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

    public java.lang.Object[] getDescripcion_glValueList()
    {
        return this.descripcion_glValueList;
    }

    public void setDescripcion_glValueList(java.lang.Object[] descripcion_glValueList)
    {
        this.descripcion_glValueList = descripcion_glValueList;
    }

    public java.lang.Object[] getDescripcion_glLabelList()
    {
        return this.descripcion_glLabelList;
    }

    public void setDescripcion_glLabelList(java.lang.Object[] descripcion_glLabelList)
    {
        this.descripcion_glLabelList = descripcion_glLabelList;
    }

    public void setDescripcion_glBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearDescargaFormImpl.setDescripcion_glBackingList requires non-null property arguments");
        }

        this.descripcion_glValueList = null;
        this.descripcion_glLabelList = null;

        if (items != null)
        {
            this.descripcion_glValueList = new java.lang.Object[items.size()];
            this.descripcion_glLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcion_glValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcion_glLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setDescripcion_glBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcion_va</code>.
     */
    public void resetDescripcion_va()
    {
        this.descripcion_va = null;
    }

    public void setDescripcion_va(java.lang.String descripcion_va)
    {
        this.descripcion_va = descripcion_va;
    }

    /**
     * 
     */
    public java.lang.String getDescripcion_va()
    {
        return this.descripcion_va;
    }
    
    public java.lang.Object[] getDescripcion_vaBackingList()
    {
        java.lang.Object[] values = this.descripcion_vaValueList;
        java.lang.Object[] labels = this.descripcion_vaLabelList;

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

    public java.lang.Object[] getDescripcion_vaValueList()
    {
        return this.descripcion_vaValueList;
    }

    public void setDescripcion_vaValueList(java.lang.Object[] descripcion_vaValueList)
    {
        this.descripcion_vaValueList = descripcion_vaValueList;
    }

    public java.lang.Object[] getDescripcion_vaLabelList()
    {
        return this.descripcion_vaLabelList;
    }

    public void setDescripcion_vaLabelList(java.lang.Object[] descripcion_vaLabelList)
    {
        this.descripcion_vaLabelList = descripcion_vaLabelList;
    }

    public void setDescripcion_vaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearDescargaFormImpl.setDescripcion_vaBackingList requires non-null property arguments");
        }

        this.descripcion_vaValueList = null;
        this.descripcion_vaLabelList = null;

        if (items != null)
        {
            this.descripcion_vaValueList = new java.lang.Object[items.size()];
            this.descripcion_vaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcion_vaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcion_vaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setDescripcion_vaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>titulo_es</code>.
     */
    public void resetTitulo_es()
    {
        this.titulo_es = null;
    }

    public void setTitulo_es(java.lang.String titulo_es)
    {
        this.titulo_es = titulo_es;
    }

    /**
     * 
     */
    public java.lang.String getTitulo_es()
    {
        return this.titulo_es;
    }
    
    public java.lang.Object[] getTitulo_esBackingList()
    {
        java.lang.Object[] values = this.titulo_esValueList;
        java.lang.Object[] labels = this.titulo_esLabelList;

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

    public java.lang.Object[] getTitulo_esValueList()
    {
        return this.titulo_esValueList;
    }

    public void setTitulo_esValueList(java.lang.Object[] titulo_esValueList)
    {
        this.titulo_esValueList = titulo_esValueList;
    }

    public java.lang.Object[] getTitulo_esLabelList()
    {
        return this.titulo_esLabelList;
    }

    public void setTitulo_esLabelList(java.lang.Object[] titulo_esLabelList)
    {
        this.titulo_esLabelList = titulo_esLabelList;
    }

    public void setTitulo_esBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearDescargaFormImpl.setTitulo_esBackingList requires non-null property arguments");
        }

        this.titulo_esValueList = null;
        this.titulo_esLabelList = null;

        if (items != null)
        {
            this.titulo_esValueList = new java.lang.Object[items.size()];
            this.titulo_esLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.titulo_esValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.titulo_esLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setTitulo_esBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>titulo_gl</code>.
     */
    public void resetTitulo_gl()
    {
        this.titulo_gl = null;
    }

    public void setTitulo_gl(java.lang.String titulo_gl)
    {
        this.titulo_gl = titulo_gl;
    }

    /**
     * 
     */
    public java.lang.String getTitulo_gl()
    {
        return this.titulo_gl;
    }
    
    public java.lang.Object[] getTitulo_glBackingList()
    {
        java.lang.Object[] values = this.titulo_glValueList;
        java.lang.Object[] labels = this.titulo_glLabelList;

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

    public java.lang.Object[] getTitulo_glValueList()
    {
        return this.titulo_glValueList;
    }

    public void setTitulo_glValueList(java.lang.Object[] titulo_glValueList)
    {
        this.titulo_glValueList = titulo_glValueList;
    }

    public java.lang.Object[] getTitulo_glLabelList()
    {
        return this.titulo_glLabelList;
    }

    public void setTitulo_glLabelList(java.lang.Object[] titulo_glLabelList)
    {
        this.titulo_glLabelList = titulo_glLabelList;
    }

    public void setTitulo_glBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearDescargaFormImpl.setTitulo_glBackingList requires non-null property arguments");
        }

        this.titulo_glValueList = null;
        this.titulo_glLabelList = null;

        if (items != null)
        {
            this.titulo_glValueList = new java.lang.Object[items.size()];
            this.titulo_glLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.titulo_glValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.titulo_glLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setTitulo_glBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>titulo_eu</code>.
     */
    public void resetTitulo_eu()
    {
        this.titulo_eu = null;
    }

    public void setTitulo_eu(java.lang.String titulo_eu)
    {
        this.titulo_eu = titulo_eu;
    }

    /**
     * 
     */
    public java.lang.String getTitulo_eu()
    {
        return this.titulo_eu;
    }
    
    public java.lang.Object[] getTitulo_euBackingList()
    {
        java.lang.Object[] values = this.titulo_euValueList;
        java.lang.Object[] labels = this.titulo_euLabelList;

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

    public java.lang.Object[] getTitulo_euValueList()
    {
        return this.titulo_euValueList;
    }

    public void setTitulo_euValueList(java.lang.Object[] titulo_euValueList)
    {
        this.titulo_euValueList = titulo_euValueList;
    }

    public java.lang.Object[] getTitulo_euLabelList()
    {
        return this.titulo_euLabelList;
    }

    public void setTitulo_euLabelList(java.lang.Object[] titulo_euLabelList)
    {
        this.titulo_euLabelList = titulo_euLabelList;
    }

    public void setTitulo_euBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearDescargaFormImpl.setTitulo_euBackingList requires non-null property arguments");
        }

        this.titulo_euValueList = null;
        this.titulo_euLabelList = null;

        if (items != null)
        {
            this.titulo_euValueList = new java.lang.Object[items.size()];
            this.titulo_euLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.titulo_euValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.titulo_euLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setTitulo_euBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcion_ca</code>.
     */
    public void resetDescripcion_ca()
    {
        this.descripcion_ca = null;
    }

    public void setDescripcion_ca(java.lang.String descripcion_ca)
    {
        this.descripcion_ca = descripcion_ca;
    }

    /**
     * 
     */
    public java.lang.String getDescripcion_ca()
    {
        return this.descripcion_ca;
    }
    
    public java.lang.Object[] getDescripcion_caBackingList()
    {
        java.lang.Object[] values = this.descripcion_caValueList;
        java.lang.Object[] labels = this.descripcion_caLabelList;

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

    public java.lang.Object[] getDescripcion_caValueList()
    {
        return this.descripcion_caValueList;
    }

    public void setDescripcion_caValueList(java.lang.Object[] descripcion_caValueList)
    {
        this.descripcion_caValueList = descripcion_caValueList;
    }

    public java.lang.Object[] getDescripcion_caLabelList()
    {
        return this.descripcion_caLabelList;
    }

    public void setDescripcion_caLabelList(java.lang.Object[] descripcion_caLabelList)
    {
        this.descripcion_caLabelList = descripcion_caLabelList;
    }

    public void setDescripcion_caBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearDescargaFormImpl.setDescripcion_caBackingList requires non-null property arguments");
        }

        this.descripcion_caValueList = null;
        this.descripcion_caLabelList = null;

        if (items != null)
        {
            this.descripcion_caValueList = new java.lang.Object[items.size()];
            this.descripcion_caLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcion_caValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcion_caLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setDescripcion_caBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>titulo_ca</code>.
     */
    public void resetTitulo_ca()
    {
        this.titulo_ca = null;
    }

    public void setTitulo_ca(java.lang.String titulo_ca)
    {
        this.titulo_ca = titulo_ca;
    }

    /**
     * 
     */
    public java.lang.String getTitulo_ca()
    {
        return this.titulo_ca;
    }
    
    public java.lang.Object[] getTitulo_caBackingList()
    {
        java.lang.Object[] values = this.titulo_caValueList;
        java.lang.Object[] labels = this.titulo_caLabelList;

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

    public java.lang.Object[] getTitulo_caValueList()
    {
        return this.titulo_caValueList;
    }

    public void setTitulo_caValueList(java.lang.Object[] titulo_caValueList)
    {
        this.titulo_caValueList = titulo_caValueList;
    }

    public java.lang.Object[] getTitulo_caLabelList()
    {
        return this.titulo_caLabelList;
    }

    public void setTitulo_caLabelList(java.lang.Object[] titulo_caLabelList)
    {
        this.titulo_caLabelList = titulo_caLabelList;
    }

    public void setTitulo_caBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearDescargaFormImpl.setTitulo_caBackingList requires non-null property arguments");
        }

        this.titulo_caValueList = null;
        this.titulo_caLabelList = null;

        if (items != null)
        {
            this.titulo_caValueList = new java.lang.Object[items.size()];
            this.titulo_caLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.titulo_caValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.titulo_caLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setTitulo_caBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcion_es</code>.
     */
    public void resetDescripcion_es()
    {
        this.descripcion_es = null;
    }

    public void setDescripcion_es(java.lang.String descripcion_es)
    {
        this.descripcion_es = descripcion_es;
    }

    /**
     * 
     */
    public java.lang.String getDescripcion_es()
    {
        return this.descripcion_es;
    }
    
    public java.lang.Object[] getDescripcion_esBackingList()
    {
        java.lang.Object[] values = this.descripcion_esValueList;
        java.lang.Object[] labels = this.descripcion_esLabelList;

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

    public java.lang.Object[] getDescripcion_esValueList()
    {
        return this.descripcion_esValueList;
    }

    public void setDescripcion_esValueList(java.lang.Object[] descripcion_esValueList)
    {
        this.descripcion_esValueList = descripcion_esValueList;
    }

    public java.lang.Object[] getDescripcion_esLabelList()
    {
        return this.descripcion_esLabelList;
    }

    public void setDescripcion_esLabelList(java.lang.Object[] descripcion_esLabelList)
    {
        this.descripcion_esLabelList = descripcion_esLabelList;
    }

    public void setDescripcion_esBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearDescargaFormImpl.setDescripcion_esBackingList requires non-null property arguments");
        }

        this.descripcion_esValueList = null;
        this.descripcion_esLabelList = null;

        if (items != null)
        {
            this.descripcion_esValueList = new java.lang.Object[items.size()];
            this.descripcion_esLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcion_esValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcion_esLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setDescripcion_esBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>descripcion_eu</code>.
     */
    public void resetDescripcion_eu()
    {
        this.descripcion_eu = null;
    }

    public void setDescripcion_eu(java.lang.String descripcion_eu)
    {
        this.descripcion_eu = descripcion_eu;
    }

    /**
     * 
     */
    public java.lang.String getDescripcion_eu()
    {
        return this.descripcion_eu;
    }
    
    public java.lang.Object[] getDescripcion_euBackingList()
    {
        java.lang.Object[] values = this.descripcion_euValueList;
        java.lang.Object[] labels = this.descripcion_euLabelList;

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

    public java.lang.Object[] getDescripcion_euValueList()
    {
        return this.descripcion_euValueList;
    }

    public void setDescripcion_euValueList(java.lang.Object[] descripcion_euValueList)
    {
        this.descripcion_euValueList = descripcion_euValueList;
    }

    public java.lang.Object[] getDescripcion_euLabelList()
    {
        return this.descripcion_euLabelList;
    }

    public void setDescripcion_euLabelList(java.lang.Object[] descripcion_euLabelList)
    {
        this.descripcion_euLabelList = descripcion_euLabelList;
    }

    public void setDescripcion_euBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearDescargaFormImpl.setDescripcion_euBackingList requires non-null property arguments");
        }

        this.descripcion_euValueList = null;
        this.descripcion_euLabelList = null;

        if (items != null)
        {
            this.descripcion_euValueList = new java.lang.Object[items.size()];
            this.descripcion_euLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.descripcion_euValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.descripcion_euLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setDescripcion_euBackingList encountered an exception", ex);
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

    public void setPath(java.lang.String path)
    {
        this.path = path;
    }

    /**
     * 
     */
    public java.lang.String getPath()
    {
        return this.path;
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
            throw new IllegalArgumentException("CrearDescargaFormImpl.setPathBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setPathBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("CrearDescargaFormImpl.setActionBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setActionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>titulo_va</code>.
     */
    public void resetTitulo_va()
    {
        this.titulo_va = null;
    }

    public void setTitulo_va(java.lang.String titulo_va)
    {
        this.titulo_va = titulo_va;
    }

    /**
     * 
     */
    public java.lang.String getTitulo_va()
    {
        return this.titulo_va;
    }
    
    public java.lang.Object[] getTitulo_vaBackingList()
    {
        java.lang.Object[] values = this.titulo_vaValueList;
        java.lang.Object[] labels = this.titulo_vaLabelList;

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

    public java.lang.Object[] getTitulo_vaValueList()
    {
        return this.titulo_vaValueList;
    }

    public void setTitulo_vaValueList(java.lang.Object[] titulo_vaValueList)
    {
        this.titulo_vaValueList = titulo_vaValueList;
    }

    public java.lang.Object[] getTitulo_vaLabelList()
    {
        return this.titulo_vaLabelList;
    }

    public void setTitulo_vaLabelList(java.lang.Object[] titulo_vaLabelList)
    {
        this.titulo_vaLabelList = titulo_vaLabelList;
    }

    public void setTitulo_vaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearDescargaFormImpl.setTitulo_vaBackingList requires non-null property arguments");
        }

        this.titulo_vaValueList = null;
        this.titulo_vaLabelList = null;

        if (items != null)
        {
            this.titulo_vaValueList = new java.lang.Object[items.size()];
            this.titulo_vaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.titulo_vaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.titulo_vaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setTitulo_vaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>titulo_en</code>.
     */
    public void resetTitulo_en()
    {
        this.titulo_en = null;
    }

    public void setTitulo_en(java.lang.String titulo_en)
    {
        this.titulo_en = titulo_en;
    }

    /**
     * 
     */
    public java.lang.String getTitulo_en()
    {
        return this.titulo_en;
    }
    
    public java.lang.Object[] getTitulo_enBackingList()
    {
        java.lang.Object[] values = this.titulo_enValueList;
        java.lang.Object[] labels = this.titulo_enLabelList;

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

    public java.lang.Object[] getTitulo_enValueList()
    {
        return this.titulo_enValueList;
    }

    public void setTitulo_enValueList(java.lang.Object[] titulo_enValueList)
    {
        this.titulo_enValueList = titulo_enValueList;
    }

    public java.lang.Object[] getTitulo_enLabelList()
    {
        return this.titulo_enLabelList;
    }

    public void setTitulo_enLabelList(java.lang.Object[] titulo_enLabelList)
    {
        this.titulo_enLabelList = titulo_enLabelList;
    }

    public void setTitulo_enBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CrearDescargaFormImpl.setTitulo_enBackingList requires non-null property arguments");
        }

        this.titulo_enValueList = null;
        this.titulo_enLabelList = null;

        if (items != null)
        {
            this.titulo_enValueList = new java.lang.Object[items.size()];
            this.titulo_enLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.titulo_enValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.titulo_enLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CrearDescargaFormImpl.setTitulo_enBackingList encountered an exception", ex);
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
        builder.append("descripcion_en", this.descripcion_en);
        builder.append("descripciones", this.descripciones);
        builder.append("descripcion_gl", this.descripcion_gl);
        builder.append("descripcion_va", this.descripcion_va);
        builder.append("titulo_es", this.titulo_es);
        builder.append("titulo_gl", this.titulo_gl);
        builder.append("titulo_eu", this.titulo_eu);
        builder.append("descripcion_ca", this.descripcion_ca);
        builder.append("titulo_ca", this.titulo_ca);
        builder.append("descripcion_es", this.descripcion_es);
        builder.append("descripcion_eu", this.descripcion_eu);
        builder.append("path", this.path);
        builder.append("action", this.action);
        builder.append("titulo_va", this.titulo_va);
        builder.append("titulo_en", this.titulo_en);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.descripcion_en = null;
        this.descripcion_enValueList = null;
        this.descripcion_enLabelList = null;
        this.descripciones = null;
        this.descripcionesValueList = null;
        this.descripcionesLabelList = null;
        this.descripcion_gl = null;
        this.descripcion_glValueList = null;
        this.descripcion_glLabelList = null;
        this.descripcion_va = null;
        this.descripcion_vaValueList = null;
        this.descripcion_vaLabelList = null;
        this.titulo_es = null;
        this.titulo_esValueList = null;
        this.titulo_esLabelList = null;
        this.titulo_gl = null;
        this.titulo_glValueList = null;
        this.titulo_glLabelList = null;
        this.titulo_eu = null;
        this.titulo_euValueList = null;
        this.titulo_euLabelList = null;
        this.descripcion_ca = null;
        this.descripcion_caValueList = null;
        this.descripcion_caLabelList = null;
        this.titulo_ca = null;
        this.titulo_caValueList = null;
        this.titulo_caLabelList = null;
        this.descripcion_es = null;
        this.descripcion_esValueList = null;
        this.descripcion_esLabelList = null;
        this.descripcion_eu = null;
        this.descripcion_euValueList = null;
        this.descripcion_euLabelList = null;
        this.path = null;
        this.pathValueList = null;
        this.pathLabelList = null;
        this.action = null;
        this.actionValueList = null;
        this.actionLabelList = null;
        this.titulo_va = null;
        this.titulo_vaValueList = null;
        this.titulo_vaLabelList = null;
        this.titulo_en = null;
        this.titulo_enValueList = null;
        this.titulo_enLabelList = null;
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
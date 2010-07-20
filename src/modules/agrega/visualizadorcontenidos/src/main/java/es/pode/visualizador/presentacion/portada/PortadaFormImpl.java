// license-header java merge-point
package es.pode.visualizador.presentacion.portada;

public class PortadaFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.visualizador.presentacion.portada.ObtenerNoticiasForm
{
    private java.lang.String nombre;
    private java.lang.Object[] nombreValueList;
    private java.lang.Object[] nombreLabelList;
    private java.lang.Long idCategoria;
    private java.lang.Object[] idCategoriaValueList;
    private java.lang.Object[] idCategoriaLabelList;
    private java.lang.Long id;
    private java.lang.Object[] idValueList;
    private java.lang.Object[] idLabelList;
    private java.util.Collection noticias = null;
    private java.lang.Object[] noticiasValueList;
    private java.lang.Object[] noticiasLabelList;
    private int numNoticias;
    private java.lang.Object[] numNoticiasValueList;
    private java.lang.Object[] numNoticiasLabelList;
    private int objetos;
    private java.lang.Object[] objetosValueList;
    private java.lang.Object[] objetosLabelList;
    private int usuarios;
    private java.lang.Object[] usuariosValueList;
    private java.lang.Object[] usuariosLabelList;

    // Search filters
    private String subjectSearchFilter;
    private java.lang.Object[] subjectSearchFilterValueList;
    private java.lang.Object[] subjectSearchFilterLabelList;    
    private String keystageSearchFilter;
    private java.lang.Object[] keystageSearchFilterValueList;
    private java.lang.Object[] keystageSearchFilterLabelList;    
    private String learningTimeSearchFilter;
    private java.lang.Object[] learningTimeSearchFilterValueList;
    private java.lang.Object[] learningTimeSearchFilterLabelList; 
    private String intendedEndUserRoleSearchFilter;
    private java.lang.Object[] intendedEndUserRoleSearchFilterValueList;
    private java.lang.Object[] intendedEndUserRoleSearchFilterLabelList;
    
    
    public PortadaFormImpl()
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
            throw new IllegalArgumentException("PortadaFormImpl.setNombreBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PortadaFormImpl.setNombreBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idCategoria</code>.
     */
    public void resetIdCategoria()
    {
        this.idCategoria = null;
    }

    public void setIdCategoria(java.lang.Long idCategoria)
    {
        this.idCategoria = idCategoria;
    }

    /**
     * 
     */
    public java.lang.Long getIdCategoria()
    {
        return this.idCategoria;
    }
    
    public java.lang.Object[] getIdCategoriaBackingList()
    {
        java.lang.Object[] values = this.idCategoriaValueList;
        java.lang.Object[] labels = this.idCategoriaLabelList;

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

    public java.lang.Object[] getIdCategoriaValueList()
    {
        return this.idCategoriaValueList;
    }

    public void setIdCategoriaValueList(java.lang.Object[] idCategoriaValueList)
    {
        this.idCategoriaValueList = idCategoriaValueList;
    }

    public java.lang.Object[] getIdCategoriaLabelList()
    {
        return this.idCategoriaLabelList;
    }

    public void setIdCategoriaLabelList(java.lang.Object[] idCategoriaLabelList)
    {
        this.idCategoriaLabelList = idCategoriaLabelList;
    }

    public void setIdCategoriaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PortadaFormImpl.setIdCategoriaBackingList requires non-null property arguments");
        }

        this.idCategoriaValueList = null;
        this.idCategoriaLabelList = null;

        if (items != null)
        {
            this.idCategoriaValueList = new java.lang.Object[items.size()];
            this.idCategoriaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idCategoriaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idCategoriaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PortadaFormImpl.setIdCategoriaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("PortadaFormImpl.setIdBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PortadaFormImpl.setIdBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>noticias</code>.
     */
    public void resetNoticias()
    {
        this.noticias = null;
    }

    public void setNoticias(java.util.Collection noticias)
    {
        this.noticias = noticias;
    }

    /**
     * 
     */
    public java.util.Collection getNoticias()
    {
        return this.noticias;
    }

    public void setNoticiasAsArray(Object[] noticias)
    {
        this.noticias = (noticias == null) ? null : java.util.Arrays.asList(noticias);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.visualizador.presentacion.portada.PortadaFormImpl#getNoticias
     */
    public java.lang.Object[] getNoticiasAsArray()
    {
        return (noticias == null) ? null : noticias.toArray();
    }
    
    public java.lang.Object[] getNoticiasBackingList()
    {
        java.lang.Object[] values = this.noticiasValueList;
        java.lang.Object[] labels = this.noticiasLabelList;

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

    public java.lang.Object[] getNoticiasValueList()
    {
        return this.noticiasValueList;
    }

    public void setNoticiasValueList(java.lang.Object[] noticiasValueList)
    {
        this.noticiasValueList = noticiasValueList;
    }

    public java.lang.Object[] getNoticiasLabelList()
    {
        return this.noticiasLabelList;
    }

    public void setNoticiasLabelList(java.lang.Object[] noticiasLabelList)
    {
        this.noticiasLabelList = noticiasLabelList;
    }

    public void setNoticiasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PortadaFormImpl.setNoticiasBackingList requires non-null property arguments");
        }

        this.noticiasValueList = null;
        this.noticiasLabelList = null;

        if (items != null)
        {
            this.noticiasValueList = new java.lang.Object[items.size()];
            this.noticiasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.noticiasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.noticiasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PortadaFormImpl.setNoticiasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>numNoticias</code>.
     */
    public void resetNumNoticias()
    {
        this.numNoticias = 0;
    }

    public void setNumNoticias(int numNoticias)
    {
        this.numNoticias = numNoticias;
    }

    /**
     * <p>
     * Numero de noticias por pagina en la portada.
     * </p>
     */
    public int getNumNoticias()
    {
        return this.numNoticias;
    }
    
    public java.lang.Object[] getNumNoticiasBackingList()
    {
        java.lang.Object[] values = this.numNoticiasValueList;
        java.lang.Object[] labels = this.numNoticiasLabelList;

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

    public java.lang.Object[] getNumNoticiasValueList()
    {
        return this.numNoticiasValueList;
    }

    public void setNumNoticiasValueList(java.lang.Object[] numNoticiasValueList)
    {
        this.numNoticiasValueList = numNoticiasValueList;
    }

    public java.lang.Object[] getNumNoticiasLabelList()
    {
        return this.numNoticiasLabelList;
    }

    public void setNumNoticiasLabelList(java.lang.Object[] numNoticiasLabelList)
    {
        this.numNoticiasLabelList = numNoticiasLabelList;
    }

    public void setNumNoticiasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PortadaFormImpl.setNumNoticiasBackingList requires non-null property arguments");
        }

        this.numNoticiasValueList = null;
        this.numNoticiasLabelList = null;

        if (items != null)
        {
            this.numNoticiasValueList = new java.lang.Object[items.size()];
            this.numNoticiasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.numNoticiasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.numNoticiasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PortadaFormImpl.setNumNoticiasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>objetos</code>.
     */
    public void resetObjetos()
    {
        this.objetos = 0;
    }

    public void setObjetos(int objetos)
    {
        this.objetos = objetos;
    }

    /**
     * 
     */
    public int getObjetos()
    {
        return this.objetos;
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
            throw new IllegalArgumentException("PortadaFormImpl.setObjetosBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("PortadaFormImpl.setObjetosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>usuarios</code>.
     */
    public void resetUsuarios()
    {
        this.usuarios = 0;
    }

    public void setUsuarios(int usuarios)
    {
        this.usuarios = usuarios;
    }

    /**
     * 
     */
    public int getUsuarios()
    {
        return this.usuarios;
    }
    
    public java.lang.Object[] getUsuariosBackingList()
    {
        java.lang.Object[] values = this.usuariosValueList;
        java.lang.Object[] labels = this.usuariosLabelList;

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

    public java.lang.Object[] getUsuariosValueList()
    {
        return this.usuariosValueList;
    }

    public void setUsuariosValueList(java.lang.Object[] usuariosValueList)
    {
        this.usuariosValueList = usuariosValueList;
    }

    public java.lang.Object[] getUsuariosLabelList()
    {
        return this.usuariosLabelList;
    }

    public void setUsuariosLabelList(java.lang.Object[] usuariosLabelList)
    {
        this.usuariosLabelList = usuariosLabelList;
    }

    public void setUsuariosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("PortadaFormImpl.setUsuariosBackingList requires non-null property arguments");
        }

        this.usuariosValueList = null;
        this.usuariosLabelList = null;

        if (items != null)
        {
            this.usuariosValueList = new java.lang.Object[items.size()];
            this.usuariosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.usuariosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.usuariosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("PortadaFormImpl.setUsuariosBackingList encountered an exception", ex);
            }
        }
    }

    
    /*
     * Subject search filters
     */
    
    public void setSubjectSearchFilter(java.lang.String subjectSearchFilter)
    {
        this.subjectSearchFilter = subjectSearchFilter;
    }

    public java.lang.String getSubjectSearchFilter()
    {
        return this.subjectSearchFilter;
    }
    
    public java.lang.Object[] getSubjectSearchFilterValueList()
    {
        return this.subjectSearchFilterValueList;
    }

    public void setSubjectSearchFilterValueList(java.lang.Object[] subjectSearchFilterValueList)
    {
        this.subjectSearchFilterValueList = subjectSearchFilterValueList;
    }

    public java.lang.Object[] getSubjectSearchFilterLabelList()
    {
        return this.subjectSearchFilterLabelList;
    }
    
    public void setSubjectSearchFilterLabelList(java.lang.Object[] subjectSearchFilterLabelList)
    {
        this.subjectSearchFilterLabelList = subjectSearchFilterLabelList;
    }
        
    public java.lang.Object[] getSubjectSearchFilterBackingList()
    {
        java.lang.Object[] values = this.subjectSearchFilterValueList;
        java.lang.Object[] labels = this.subjectSearchFilterLabelList;

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


    /*
     * Keystage search filters
     */
        
    public void setKeystageSearchFilter(java.lang.String keystageSearchFilter)
    {
        this.keystageSearchFilter = keystageSearchFilter;
    }

    public java.lang.String getKeystageSearchFilter()
    {
        return this.keystageSearchFilter;
    }
    
    public java.lang.Object[] getKeystageSearchFilterValueList()
    {
        return this.keystageSearchFilterValueList;
    }

    public void setKeystageSearchFilterValueList(java.lang.Object[] keystageSearchFilterValueList)
    {
        this.keystageSearchFilterValueList = keystageSearchFilterValueList;
    }

    public java.lang.Object[] getKeystageSearchFilterLabelList()
    {
        return this.keystageSearchFilterLabelList;
    }
    
    public void setKeystageSearchFilterLabelList(java.lang.Object[] keystageSearchFilterLabelList)
    {
        this.keystageSearchFilterLabelList = keystageSearchFilterLabelList;
    }
        
    public java.lang.Object[] getKeystageSearchFilterBackingList()
    {
        java.lang.Object[] values = this.keystageSearchFilterValueList;
        java.lang.Object[] labels = this.keystageSearchFilterLabelList;

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

    
    /*
     * Learning Time search filters
     */
        
    public void setLearningTimeSearchFilter(java.lang.String learningTimeSearchFilter)
    {
        this.learningTimeSearchFilter = learningTimeSearchFilter;
    }

    public java.lang.String getLearningTimeSearchFilter()
    {
        return this.learningTimeSearchFilter;
    }
    
    public java.lang.Object[] getLearningTimeSearchFilterValueList()
    {
        return this.learningTimeSearchFilterValueList;
    }

    public void setLearningTimeSearchFilterValueList(java.lang.Object[] learningTimeSearchFilterValueList)
    {
        this.learningTimeSearchFilterValueList = learningTimeSearchFilterValueList;
    }

    public java.lang.Object[] getLearningTimeSearchFilterLabelList()
    {
        return this.learningTimeSearchFilterLabelList;
    }
    
    public void setLearningTimeSearchFilterLabelList(java.lang.Object[] learningTimeSearchFilterLabelList)
    {
        this.learningTimeSearchFilterLabelList = learningTimeSearchFilterLabelList;
    }
        
    public java.lang.Object[] getLearningTimeSearchFilterBackingList()
    {
        java.lang.Object[] values = this.learningTimeSearchFilterValueList;
        java.lang.Object[] labels = this.learningTimeSearchFilterLabelList;

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
    

    /*
     * Intended end user role search filters
     */
        
    public void setIntendedEndUserRoleSearchFilter(java.lang.String intendedEndUserRoleSearchFilter)
    {
        this.intendedEndUserRoleSearchFilter = intendedEndUserRoleSearchFilter;
    }

    public java.lang.String getIntendedEndUserRoleSearchFilter()
    {
        return this.intendedEndUserRoleSearchFilter;
    }
    
    public java.lang.Object[] getIntendedEndUserRoleSearchFilterValueList()
    {
        return this.intendedEndUserRoleSearchFilterValueList;
    }

    public void setIntendedEndUserRoleSearchFilterValueList(java.lang.Object[] intendedEndUserRoleSearchFilterValueList)
    {
        this.intendedEndUserRoleSearchFilterValueList = intendedEndUserRoleSearchFilterValueList;
    }

    public java.lang.Object[] getIntendedEndUserRoleSearchFilterLabelList()
    {
        return this.intendedEndUserRoleSearchFilterLabelList;
    }
    
    public void setIntendedEndUserRoleSearchFilterLabelList(java.lang.Object[] intendedEndUserRoleSearchFilterLabelList)
    {
        this.intendedEndUserRoleSearchFilterLabelList = intendedEndUserRoleSearchFilterLabelList;
    }
        
    public java.lang.Object[] getIntendedEndUserRoleSearchFilterBackingList()
    {
        java.lang.Object[] values = this.intendedEndUserRoleSearchFilterValueList;
        java.lang.Object[] labels = this.intendedEndUserRoleSearchFilterLabelList;

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
        builder.append("idCategoria", this.idCategoria);
        builder.append("id", this.id);
        builder.append("noticias", this.noticias);
        builder.append("numNoticias", this.numNoticias);
        builder.append("objetos", this.objetos);
        builder.append("usuarios", this.usuarios);
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
        this.idCategoria = null;
        this.idCategoriaValueList = null;
        this.idCategoriaLabelList = null;
        this.id = null;
        this.idValueList = null;
        this.idLabelList = null;
        this.noticias = null;
        this.noticiasValueList = null;
        this.noticiasLabelList = null;
        this.numNoticias = 0;
        this.numNoticiasValueList = null;
        this.numNoticiasLabelList = null;
        this.objetos = 0;
        this.objetosValueList = null;
        this.objetosLabelList = null;
        this.usuarios = 0;
        this.usuariosValueList = null;
        this.usuariosLabelList = null;
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
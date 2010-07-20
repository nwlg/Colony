// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosCompartidos;

public class ObjetosCompartidosCUFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.gestorFlujo.presentacion.objetosCompartidos.CargarODESCompartidosForm
{
    private java.lang.String titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.lang.String idODE;
    private java.lang.Object[] idODEValueList;
    private java.lang.Object[] idODELabelList;
    private java.lang.Long[] tamainoODES;
    private java.lang.Object[] tamainoODESValueList;
    private java.lang.Object[] tamainoODESLabelList;
    private java.util.Collection listaODES = null;
    private java.lang.Object[] listaODESValueList;
    private java.lang.Object[] listaODESLabelList;

    public ObjetosCompartidosCUFormImpl()
    {
    }

    /**
     * Resets the given <code>titulo</code>.
     */
    public void resetTitulo()
    {
        this.titulo = null;
    }

    public void setTitulo(java.lang.String titulo)
    {
        this.titulo = titulo;
    }

    /**
     * <p>
     * El titulo del ODE
     * </p>
     */
    public java.lang.String getTitulo()
    {
        return this.titulo;
    }
    
    public java.lang.Object[] getTituloBackingList()
    {
        java.lang.Object[] values = this.tituloValueList;
        java.lang.Object[] labels = this.tituloLabelList;

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

    public java.lang.Object[] getTituloValueList()
    {
        return this.tituloValueList;
    }

    public void setTituloValueList(java.lang.Object[] tituloValueList)
    {
        this.tituloValueList = tituloValueList;
    }

    public java.lang.Object[] getTituloLabelList()
    {
        return this.tituloLabelList;
    }

    public void setTituloLabelList(java.lang.Object[] tituloLabelList)
    {
        this.tituloLabelList = tituloLabelList;
    }

    public void setTituloBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObjetosCompartidosCUFormImpl.setTituloBackingList requires non-null property arguments");
        }

        this.tituloValueList = null;
        this.tituloLabelList = null;

        if (items != null)
        {
            this.tituloValueList = new java.lang.Object[items.size()];
            this.tituloLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tituloValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tituloLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObjetosCompartidosCUFormImpl.setTituloBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idODE</code>.
     */
    public void resetIdODE()
    {
        this.idODE = null;
    }

    public void setIdODE(java.lang.String idODE)
    {
        this.idODE = idODE;
    }

    /**
     * <p>
     * El identificador del ODE que vamos a importar
     * </p>
     */
    public java.lang.String getIdODE()
    {
        return this.idODE;
    }
    
    public java.lang.Object[] getIdODEBackingList()
    {
        java.lang.Object[] values = this.idODEValueList;
        java.lang.Object[] labels = this.idODELabelList;

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

    public java.lang.Object[] getIdODEValueList()
    {
        return this.idODEValueList;
    }

    public void setIdODEValueList(java.lang.Object[] idODEValueList)
    {
        this.idODEValueList = idODEValueList;
    }

    public java.lang.Object[] getIdODELabelList()
    {
        return this.idODELabelList;
    }

    public void setIdODELabelList(java.lang.Object[] idODELabelList)
    {
        this.idODELabelList = idODELabelList;
    }

    public void setIdODEBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObjetosCompartidosCUFormImpl.setIdODEBackingList requires non-null property arguments");
        }

        this.idODEValueList = null;
        this.idODELabelList = null;

        if (items != null)
        {
            this.idODEValueList = new java.lang.Object[items.size()];
            this.idODELabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idODEValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idODELabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObjetosCompartidosCUFormImpl.setIdODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tamainoODES</code>.
     */
    public void resetTamainoODES()
    {
        this.tamainoODES = null;
    }

    public void setTamainoODES(java.lang.Long[] tamainoODES)
    {
        this.tamainoODES = tamainoODES;
    }

    /**
     * 
     */
    public java.lang.Long[] getTamainoODES()
    {
        return this.tamainoODES;
    }
    
    public java.lang.Object[] getTamainoODESBackingList()
    {
        java.lang.Object[] values = this.tamainoODESValueList;
        java.lang.Object[] labels = this.tamainoODESLabelList;

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

    public java.lang.Object[] getTamainoODESValueList()
    {
        return this.tamainoODESValueList;
    }

    public void setTamainoODESValueList(java.lang.Object[] tamainoODESValueList)
    {
        this.tamainoODESValueList = tamainoODESValueList;
    }

    public java.lang.Object[] getTamainoODESLabelList()
    {
        return this.tamainoODESLabelList;
    }

    public void setTamainoODESLabelList(java.lang.Object[] tamainoODESLabelList)
    {
        this.tamainoODESLabelList = tamainoODESLabelList;
    }

    public void setTamainoODESBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObjetosCompartidosCUFormImpl.setTamainoODESBackingList requires non-null property arguments");
        }

        this.tamainoODESValueList = null;
        this.tamainoODESLabelList = null;

        if (items != null)
        {
            this.tamainoODESValueList = new java.lang.Object[items.size()];
            this.tamainoODESLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tamainoODESValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tamainoODESLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObjetosCompartidosCUFormImpl.setTamainoODESBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>listaODES</code>.
     */
    public void resetListaODES()
    {
        this.listaODES = null;
    }

    public void setListaODES(java.util.Collection listaODES)
    {
        this.listaODES = listaODES;
    }

    /**
     * 
     */
    public java.util.Collection getListaODES()
    {
        return this.listaODES;
    }

    public void setListaODESAsArray(Object[] listaODES)
    {
        this.listaODES = (listaODES == null) ? null : java.util.Arrays.asList(listaODES);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.gestorFlujo.presentacion.objetosCompartidos.ObjetosCompartidosCUFormImpl#getListaODES
     */
    public java.lang.Object[] getListaODESAsArray()
    {
        return (listaODES == null) ? null : listaODES.toArray();
    }
    
    public java.lang.Object[] getListaODESBackingList()
    {
        java.lang.Object[] values = this.listaODESValueList;
        java.lang.Object[] labels = this.listaODESLabelList;

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

    public java.lang.Object[] getListaODESValueList()
    {
        return this.listaODESValueList;
    }

    public void setListaODESValueList(java.lang.Object[] listaODESValueList)
    {
        this.listaODESValueList = listaODESValueList;
    }

    public java.lang.Object[] getListaODESLabelList()
    {
        return this.listaODESLabelList;
    }

    public void setListaODESLabelList(java.lang.Object[] listaODESLabelList)
    {
        this.listaODESLabelList = listaODESLabelList;
    }

    public void setListaODESBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObjetosCompartidosCUFormImpl.setListaODESBackingList requires non-null property arguments");
        }

        this.listaODESValueList = null;
        this.listaODESLabelList = null;

        if (items != null)
        {
            this.listaODESValueList = new java.lang.Object[items.size()];
            this.listaODESLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.listaODESValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.listaODESLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObjetosCompartidosCUFormImpl.setListaODESBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.tamainoODES = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("titulo", this.titulo);
        builder.append("idODE", this.idODE);
        builder.append("tamainoODES", this.tamainoODES);
        builder.append("listaODES", this.listaODES);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.titulo = null;
        this.tituloValueList = null;
        this.tituloLabelList = null;
        this.idODE = null;
        this.idODEValueList = null;
        this.idODELabelList = null;
        this.tamainoODES = null;
        this.tamainoODESValueList = null;
        this.tamainoODESLabelList = null;
        this.listaODES = null;
        this.listaODESValueList = null;
        this.listaODESLabelList = null;
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
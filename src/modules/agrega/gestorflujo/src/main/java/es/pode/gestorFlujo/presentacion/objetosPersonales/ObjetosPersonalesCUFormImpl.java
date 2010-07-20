// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales;

public class ObjetosPersonalesCUFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.gestorFlujo.presentacion.objetosPersonales.CargarODESPersonalesForm
{
    private java.lang.String titulo;
    private java.lang.Object[] tituloValueList;
    private java.lang.Object[] tituloLabelList;
    private java.lang.Long cuotaUsuario;
    private java.lang.Object[] cuotaUsuarioValueList;
    private java.lang.Object[] cuotaUsuarioLabelList;
    private int porcentajeMemoriaCubierta;
    private java.lang.Object[] porcentajeMemoriaCubiertaValueList;
    private java.lang.Object[] porcentajeMemoriaCubiertaLabelList;
    private java.lang.String idUsuario;
    private java.lang.Object[] idUsuarioValueList;
    private java.lang.Object[] idUsuarioLabelList;
    private java.lang.Long espacioLibre;
    private java.lang.Object[] espacioLibreValueList;
    private java.lang.Object[] espacioLibreLabelList;
    private java.lang.String idODE;
    private java.lang.Object[] idODEValueList;
    private java.lang.Object[] idODELabelList;
    private java.lang.String compartidoSN;
    private java.lang.Object[] compartidoSNValueList;
    private java.lang.Object[] compartidoSNLabelList;
    private java.lang.Long[] tamainoOdes;
    private java.lang.Object[] tamainoOdesValueList;
    private java.lang.Object[] tamainoOdesLabelList;
    private java.lang.Long totalSuma;
    private java.lang.Object[] totalSumaValueList;
    private java.lang.Object[] totalSumaLabelList;
    private java.lang.String idiomaBuscador;
    private java.lang.Object[] idiomaBuscadorValueList;
    private java.lang.Object[] idiomaBuscadorLabelList;
    private java.util.Collection listaODES = null;
    private java.lang.Object[] listaODESValueList;
    private java.lang.Object[] listaODESLabelList;

    public ObjetosPersonalesCUFormImpl()
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
     * Titulo del ODE.
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
            throw new IllegalArgumentException("ObjetosPersonalesCUFormImpl.setTituloBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObjetosPersonalesCUFormImpl.setTituloBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>cuotaUsuario</code>.
     */
    public void resetCuotaUsuario()
    {
        this.cuotaUsuario = null;
    }

    public void setCuotaUsuario(java.lang.Long cuotaUsuario)
    {
        this.cuotaUsuario = cuotaUsuario;
    }

    /**
     * <p>
     * La cuota total de la que dispone el usuario
     * </p>
     */
    public java.lang.Long getCuotaUsuario()
    {
        return this.cuotaUsuario;
    }
    
    public java.lang.Object[] getCuotaUsuarioBackingList()
    {
        java.lang.Object[] values = this.cuotaUsuarioValueList;
        java.lang.Object[] labels = this.cuotaUsuarioLabelList;

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

    public java.lang.Object[] getCuotaUsuarioValueList()
    {
        return this.cuotaUsuarioValueList;
    }

    public void setCuotaUsuarioValueList(java.lang.Object[] cuotaUsuarioValueList)
    {
        this.cuotaUsuarioValueList = cuotaUsuarioValueList;
    }

    public java.lang.Object[] getCuotaUsuarioLabelList()
    {
        return this.cuotaUsuarioLabelList;
    }

    public void setCuotaUsuarioLabelList(java.lang.Object[] cuotaUsuarioLabelList)
    {
        this.cuotaUsuarioLabelList = cuotaUsuarioLabelList;
    }

    public void setCuotaUsuarioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObjetosPersonalesCUFormImpl.setCuotaUsuarioBackingList requires non-null property arguments");
        }

        this.cuotaUsuarioValueList = null;
        this.cuotaUsuarioLabelList = null;

        if (items != null)
        {
            this.cuotaUsuarioValueList = new java.lang.Object[items.size()];
            this.cuotaUsuarioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.cuotaUsuarioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.cuotaUsuarioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObjetosPersonalesCUFormImpl.setCuotaUsuarioBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>porcentajeMemoriaCubierta</code>.
     */
    public void resetPorcentajeMemoriaCubierta()
    {
        this.porcentajeMemoriaCubierta = 0;
    }

    public void setPorcentajeMemoriaCubierta(int porcentajeMemoriaCubierta)
    {
        this.porcentajeMemoriaCubierta = porcentajeMemoriaCubierta;
    }

    /**
     * <p>
     * La memoria restante de la que dispone el usuario
     * </p>
     */
    public int getPorcentajeMemoriaCubierta()
    {
        return this.porcentajeMemoriaCubierta;
    }
    
    public java.lang.Object[] getPorcentajeMemoriaCubiertaBackingList()
    {
        java.lang.Object[] values = this.porcentajeMemoriaCubiertaValueList;
        java.lang.Object[] labels = this.porcentajeMemoriaCubiertaLabelList;

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

    public java.lang.Object[] getPorcentajeMemoriaCubiertaValueList()
    {
        return this.porcentajeMemoriaCubiertaValueList;
    }

    public void setPorcentajeMemoriaCubiertaValueList(java.lang.Object[] porcentajeMemoriaCubiertaValueList)
    {
        this.porcentajeMemoriaCubiertaValueList = porcentajeMemoriaCubiertaValueList;
    }

    public java.lang.Object[] getPorcentajeMemoriaCubiertaLabelList()
    {
        return this.porcentajeMemoriaCubiertaLabelList;
    }

    public void setPorcentajeMemoriaCubiertaLabelList(java.lang.Object[] porcentajeMemoriaCubiertaLabelList)
    {
        this.porcentajeMemoriaCubiertaLabelList = porcentajeMemoriaCubiertaLabelList;
    }

    public void setPorcentajeMemoriaCubiertaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObjetosPersonalesCUFormImpl.setPorcentajeMemoriaCubiertaBackingList requires non-null property arguments");
        }

        this.porcentajeMemoriaCubiertaValueList = null;
        this.porcentajeMemoriaCubiertaLabelList = null;

        if (items != null)
        {
            this.porcentajeMemoriaCubiertaValueList = new java.lang.Object[items.size()];
            this.porcentajeMemoriaCubiertaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.porcentajeMemoriaCubiertaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.porcentajeMemoriaCubiertaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObjetosPersonalesCUFormImpl.setPorcentajeMemoriaCubiertaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idUsuario</code>.
     */
    public void resetIdUsuario()
    {
        this.idUsuario = null;
    }

    public void setIdUsuario(java.lang.String idUsuario)
    {
        this.idUsuario = idUsuario;
    }

    /**
     * <p>
     * Identificador del usuario que quiere proponer el ODE para
     * publicacion.
     * </p>
     */
    public java.lang.String getIdUsuario()
    {
        return this.idUsuario;
    }
    
    public java.lang.Object[] getIdUsuarioBackingList()
    {
        java.lang.Object[] values = this.idUsuarioValueList;
        java.lang.Object[] labels = this.idUsuarioLabelList;

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

    public java.lang.Object[] getIdUsuarioValueList()
    {
        return this.idUsuarioValueList;
    }

    public void setIdUsuarioValueList(java.lang.Object[] idUsuarioValueList)
    {
        this.idUsuarioValueList = idUsuarioValueList;
    }

    public java.lang.Object[] getIdUsuarioLabelList()
    {
        return this.idUsuarioLabelList;
    }

    public void setIdUsuarioLabelList(java.lang.Object[] idUsuarioLabelList)
    {
        this.idUsuarioLabelList = idUsuarioLabelList;
    }

    public void setIdUsuarioBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObjetosPersonalesCUFormImpl.setIdUsuarioBackingList requires non-null property arguments");
        }

        this.idUsuarioValueList = null;
        this.idUsuarioLabelList = null;

        if (items != null)
        {
            this.idUsuarioValueList = new java.lang.Object[items.size()];
            this.idUsuarioLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idUsuarioValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idUsuarioLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObjetosPersonalesCUFormImpl.setIdUsuarioBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>espacioLibre</code>.
     */
    public void resetEspacioLibre()
    {
        this.espacioLibre = null;
    }

    public void setEspacioLibre(java.lang.Long espacioLibre)
    {
        this.espacioLibre = espacioLibre;
    }

    /**
     * <p>
     * El espacio libre del que dispone el usuario
     * </p>
     */
    public java.lang.Long getEspacioLibre()
    {
        return this.espacioLibre;
    }
    
    public java.lang.Object[] getEspacioLibreBackingList()
    {
        java.lang.Object[] values = this.espacioLibreValueList;
        java.lang.Object[] labels = this.espacioLibreLabelList;

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

    public java.lang.Object[] getEspacioLibreValueList()
    {
        return this.espacioLibreValueList;
    }

    public void setEspacioLibreValueList(java.lang.Object[] espacioLibreValueList)
    {
        this.espacioLibreValueList = espacioLibreValueList;
    }

    public java.lang.Object[] getEspacioLibreLabelList()
    {
        return this.espacioLibreLabelList;
    }

    public void setEspacioLibreLabelList(java.lang.Object[] espacioLibreLabelList)
    {
        this.espacioLibreLabelList = espacioLibreLabelList;
    }

    public void setEspacioLibreBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObjetosPersonalesCUFormImpl.setEspacioLibreBackingList requires non-null property arguments");
        }

        this.espacioLibreValueList = null;
        this.espacioLibreLabelList = null;

        if (items != null)
        {
            this.espacioLibreValueList = new java.lang.Object[items.size()];
            this.espacioLibreLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.espacioLibreValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.espacioLibreLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObjetosPersonalesCUFormImpl.setEspacioLibreBackingList encountered an exception", ex);
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
     * 
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
            throw new IllegalArgumentException("ObjetosPersonalesCUFormImpl.setIdODEBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObjetosPersonalesCUFormImpl.setIdODEBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>compartidoSN</code>.
     */
    public void resetCompartidoSN()
    {
        this.compartidoSN = null;
    }

    public void setCompartidoSN(java.lang.String compartidoSN)
    {
        this.compartidoSN = compartidoSN;
    }

    /**
     * 
     */
    public java.lang.String getCompartidoSN()
    {
        return this.compartidoSN;
    }
    
    public java.lang.Object[] getCompartidoSNBackingList()
    {
        java.lang.Object[] values = this.compartidoSNValueList;
        java.lang.Object[] labels = this.compartidoSNLabelList;

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

    public java.lang.Object[] getCompartidoSNValueList()
    {
        return this.compartidoSNValueList;
    }

    public void setCompartidoSNValueList(java.lang.Object[] compartidoSNValueList)
    {
        this.compartidoSNValueList = compartidoSNValueList;
    }

    public java.lang.Object[] getCompartidoSNLabelList()
    {
        return this.compartidoSNLabelList;
    }

    public void setCompartidoSNLabelList(java.lang.Object[] compartidoSNLabelList)
    {
        this.compartidoSNLabelList = compartidoSNLabelList;
    }

    public void setCompartidoSNBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObjetosPersonalesCUFormImpl.setCompartidoSNBackingList requires non-null property arguments");
        }

        this.compartidoSNValueList = null;
        this.compartidoSNLabelList = null;

        if (items != null)
        {
            this.compartidoSNValueList = new java.lang.Object[items.size()];
            this.compartidoSNLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.compartidoSNValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.compartidoSNLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObjetosPersonalesCUFormImpl.setCompartidoSNBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>tamainoOdes</code>.
     */
    public void resetTamainoOdes()
    {
        this.tamainoOdes = null;
    }

    public void setTamainoOdes(java.lang.Long[] tamainoOdes)
    {
        this.tamainoOdes = tamainoOdes;
    }

    /**
     * <p>
     * Tamaino de los ODES
     * </p>
     */
    public java.lang.Long[] getTamainoOdes()
    {
        return this.tamainoOdes;
    }
    
    public java.lang.Object[] getTamainoOdesBackingList()
    {
        java.lang.Object[] values = this.tamainoOdesValueList;
        java.lang.Object[] labels = this.tamainoOdesLabelList;

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

    public java.lang.Object[] getTamainoOdesValueList()
    {
        return this.tamainoOdesValueList;
    }

    public void setTamainoOdesValueList(java.lang.Object[] tamainoOdesValueList)
    {
        this.tamainoOdesValueList = tamainoOdesValueList;
    }

    public java.lang.Object[] getTamainoOdesLabelList()
    {
        return this.tamainoOdesLabelList;
    }

    public void setTamainoOdesLabelList(java.lang.Object[] tamainoOdesLabelList)
    {
        this.tamainoOdesLabelList = tamainoOdesLabelList;
    }

    public void setTamainoOdesBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObjetosPersonalesCUFormImpl.setTamainoOdesBackingList requires non-null property arguments");
        }

        this.tamainoOdesValueList = null;
        this.tamainoOdesLabelList = null;

        if (items != null)
        {
            this.tamainoOdesValueList = new java.lang.Object[items.size()];
            this.tamainoOdesLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.tamainoOdesValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.tamainoOdesLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObjetosPersonalesCUFormImpl.setTamainoOdesBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>totalSuma</code>.
     */
    public void resetTotalSuma()
    {
        this.totalSuma = null;
    }

    public void setTotalSuma(java.lang.Long totalSuma)
    {
        this.totalSuma = totalSuma;
    }

    /**
     * <p>
     * La suma total de los Odes
     * </p>
     */
    public java.lang.Long getTotalSuma()
    {
        return this.totalSuma;
    }
    
    public java.lang.Object[] getTotalSumaBackingList()
    {
        java.lang.Object[] values = this.totalSumaValueList;
        java.lang.Object[] labels = this.totalSumaLabelList;

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

    public java.lang.Object[] getTotalSumaValueList()
    {
        return this.totalSumaValueList;
    }

    public void setTotalSumaValueList(java.lang.Object[] totalSumaValueList)
    {
        this.totalSumaValueList = totalSumaValueList;
    }

    public java.lang.Object[] getTotalSumaLabelList()
    {
        return this.totalSumaLabelList;
    }

    public void setTotalSumaLabelList(java.lang.Object[] totalSumaLabelList)
    {
        this.totalSumaLabelList = totalSumaLabelList;
    }

    public void setTotalSumaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("ObjetosPersonalesCUFormImpl.setTotalSumaBackingList requires non-null property arguments");
        }

        this.totalSumaValueList = null;
        this.totalSumaLabelList = null;

        if (items != null)
        {
            this.totalSumaValueList = new java.lang.Object[items.size()];
            this.totalSumaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.totalSumaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.totalSumaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("ObjetosPersonalesCUFormImpl.setTotalSumaBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("ObjetosPersonalesCUFormImpl.setIdiomaBuscadorBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObjetosPersonalesCUFormImpl.setIdiomaBuscadorBackingList encountered an exception", ex);
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
     * <p>
     * Se trata de la lista de ODES de Objetos Personales que tiene
     * asociado el usuario.
     * </p>
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
     * @see es.pode.gestorFlujo.presentacion.objetosPersonales.ObjetosPersonalesCUFormImpl#getListaODES
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
            throw new IllegalArgumentException("ObjetosPersonalesCUFormImpl.setListaODESBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("ObjetosPersonalesCUFormImpl.setListaODESBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.tamainoOdes = null;
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("titulo", this.titulo);
        builder.append("cuotaUsuario", this.cuotaUsuario);
        builder.append("porcentajeMemoriaCubierta", this.porcentajeMemoriaCubierta);
        builder.append("idUsuario", this.idUsuario);
        builder.append("espacioLibre", this.espacioLibre);
        builder.append("idODE", this.idODE);
        builder.append("compartidoSN", this.compartidoSN);
        builder.append("tamainoOdes", this.tamainoOdes);
        builder.append("totalSuma", this.totalSuma);
        builder.append("idiomaBuscador", this.idiomaBuscador);
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
        this.cuotaUsuario = null;
        this.cuotaUsuarioValueList = null;
        this.cuotaUsuarioLabelList = null;
        this.porcentajeMemoriaCubierta = 0;
        this.porcentajeMemoriaCubiertaValueList = null;
        this.porcentajeMemoriaCubiertaLabelList = null;
        this.idUsuario = null;
        this.idUsuarioValueList = null;
        this.idUsuarioLabelList = null;
        this.espacioLibre = null;
        this.espacioLibreValueList = null;
        this.espacioLibreLabelList = null;
        this.idODE = null;
        this.idODEValueList = null;
        this.idODELabelList = null;
        this.compartidoSN = null;
        this.compartidoSNValueList = null;
        this.compartidoSNLabelList = null;
        this.tamainoOdes = null;
        this.tamainoOdesValueList = null;
        this.tamainoOdesLabelList = null;
        this.totalSuma = null;
        this.totalSumaValueList = null;
        this.totalSumaLabelList = null;
        this.idiomaBuscador = null;
        this.idiomaBuscadorValueList = null;
        this.idiomaBuscadorLabelList = null;
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
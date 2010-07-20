// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general;

public class GeneralFormSubmitFormImpl
    extends org.apache.struts.validator.ValidatorForm
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarCaracteristicaForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirCaracteristicaForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarDescripcionForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirContenidoDescripcionForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarContenidoDescripcionForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirPalabrasClaveForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarAmbitosForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirContenidoAmbitoForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarContenidoAmbitoForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirDescripcionForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirIdiomaForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarIdiomaForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirAmbitosForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GuardarGeneralForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.ResetForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.CancelarForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirTituloForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarIdentificadorForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarTituloForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirContenidoPalabraClaveForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarPalabrasClaveForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AnadirIdentificadorForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EliminarContenidoPalabraClaveForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.EsValidoGeneralForm
        , es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.AccionSubmitForm
{
    private java.util.Collection descripciones;
    private java.lang.Object[] descripcionesValueList;
    private java.lang.Object[] descripcionesLabelList;
    private java.util.Collection palabrasClave;
    private java.lang.Object[] palabrasClaveValueList;
    private java.lang.Object[] palabrasClaveLabelList;
    private java.lang.String comboCaractTipoPlano;
    private java.lang.Object[] comboCaractTipoPlanoValueList;
    private java.lang.Object[] comboCaractTipoPlanoLabelList;
    private java.lang.String comboCaractBandaSonora;
    private java.lang.Object[] comboCaractBandaSonoraValueList;
    private java.lang.Object[] comboCaractBandaSonoraLabelList;
    private java.lang.String comboCaractLuz;
    private java.lang.Object[] comboCaractLuzValueList;
    private java.lang.Object[] comboCaractLuzLabelList;
    private java.util.Collection idiomas;
    private java.lang.Object[] idiomasValueList;
    private java.lang.Object[] idiomasLabelList;
    private java.lang.String comboCaractFormato;
    private java.lang.Object[] comboCaractFormatoValueList;
    private java.lang.Object[] comboCaractFormatoLabelList;
    private java.lang.String comboIdioma;
    private java.lang.Object[] comboIdiomaValueList;
    private java.lang.Object[] comboIdiomaLabelList;
    private java.util.Collection caracteristicas;
    private java.lang.Object[] caracteristicasValueList;
    private java.lang.Object[] caracteristicasLabelList;
    private java.lang.String comboCaractColor;
    private java.lang.Object[] comboCaractColorValueList;
    private java.lang.Object[] comboCaractColorLabelList;
    private java.lang.String identificadorOde;
    private java.lang.Object[] identificadorOdeValueList;
    private java.lang.Object[] identificadorOdeLabelList;
    private java.lang.String comboCaractEstructuraFormal;
    private java.lang.Object[] comboCaractEstructuraFormalValueList;
    private java.lang.Object[] comboCaractEstructuraFormalLabelList;
    private java.lang.String texto;
    private java.lang.Object[] textoValueList;
    private java.lang.Object[] textoLabelList;
    private java.util.Collection ambitos;
    private java.lang.Object[] ambitosValueList;
    private java.lang.Object[] ambitosLabelList;
    private java.util.Collection identificadores;
    private java.lang.Object[] identificadoresValueList;
    private java.lang.Object[] identificadoresLabelList;
    private java.lang.String textos;
    private java.lang.Object[] textosValueList;
    private java.lang.Object[] textosLabelList;
    private java.lang.String estructura;
    private java.lang.Object[] estructuraValueList;
    private java.lang.Object[] estructuraLabelList;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.lang.String comboCaractAngulacion;
    private java.lang.Object[] comboCaractAngulacionValueList;
    private java.lang.Object[] comboCaractAngulacionLabelList;
    private java.lang.String nivelAgregacion;
    private java.lang.Object[] nivelAgregacionValueList;
    private java.lang.Object[] nivelAgregacionLabelList;
    private java.lang.String accion;
    private java.lang.Object[] accionValueList;
    private java.lang.Object[] accionLabelList;
    private java.lang.String catalogo;
    private java.lang.Object[] catalogoValueList;
    private java.lang.Object[] catalogoLabelList;
    private java.lang.String entrada;
    private java.lang.Object[] entradaValueList;
    private java.lang.Object[] entradaLabelList;
    private java.lang.String comboCaractDimension;
    private java.lang.Object[] comboCaractDimensionValueList;
    private java.lang.Object[] comboCaractDimensionLabelList;
    private java.util.Collection titulos;
    private java.lang.Object[] titulosValueList;
    private java.lang.Object[] titulosLabelList;
    private java.util.Collection mensajesError;
    private java.lang.Object[] mensajesErrorValueList;
    private java.lang.Object[] mensajesErrorLabelList;

    public GeneralFormSubmitFormImpl()
    {
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralFormSubmitFormImpl#getDescripciones
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
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setDescripcionesBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setDescripcionesBackingList encountered an exception", ex);
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
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralFormSubmitFormImpl#getPalabrasClave
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
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setPalabrasClaveBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setPalabrasClaveBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboCaractTipoPlano</code>.
     */
    public void resetComboCaractTipoPlano()
    {
        this.comboCaractTipoPlano = null;
    }

    public void setComboCaractTipoPlano(java.lang.String comboCaractTipoPlano)
    {
        this.comboCaractTipoPlano = comboCaractTipoPlano;
    }

    /**
     * 
     */
    public java.lang.String getComboCaractTipoPlano()
    {
        return this.comboCaractTipoPlano;
    }
    
    public java.lang.Object[] getComboCaractTipoPlanoBackingList()
    {
        java.lang.Object[] values = this.comboCaractTipoPlanoValueList;
        java.lang.Object[] labels = this.comboCaractTipoPlanoLabelList;

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

    public java.lang.Object[] getComboCaractTipoPlanoValueList()
    {
        return this.comboCaractTipoPlanoValueList;
    }

    public void setComboCaractTipoPlanoValueList(java.lang.Object[] comboCaractTipoPlanoValueList)
    {
        this.comboCaractTipoPlanoValueList = comboCaractTipoPlanoValueList;
    }

    public java.lang.Object[] getComboCaractTipoPlanoLabelList()
    {
        return this.comboCaractTipoPlanoLabelList;
    }

    public void setComboCaractTipoPlanoLabelList(java.lang.Object[] comboCaractTipoPlanoLabelList)
    {
        this.comboCaractTipoPlanoLabelList = comboCaractTipoPlanoLabelList;
    }

    public void setComboCaractTipoPlanoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setComboCaractTipoPlanoBackingList requires non-null property arguments");
        }

        this.comboCaractTipoPlanoValueList = null;
        this.comboCaractTipoPlanoLabelList = null;

        if (items != null)
        {
            this.comboCaractTipoPlanoValueList = new java.lang.Object[items.size()];
            this.comboCaractTipoPlanoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboCaractTipoPlanoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboCaractTipoPlanoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setComboCaractTipoPlanoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboCaractBandaSonora</code>.
     */
    public void resetComboCaractBandaSonora()
    {
        this.comboCaractBandaSonora = null;
    }

    public void setComboCaractBandaSonora(java.lang.String comboCaractBandaSonora)
    {
        this.comboCaractBandaSonora = comboCaractBandaSonora;
    }

    /**
     * 
     */
    public java.lang.String getComboCaractBandaSonora()
    {
        return this.comboCaractBandaSonora;
    }
    
    public java.lang.Object[] getComboCaractBandaSonoraBackingList()
    {
        java.lang.Object[] values = this.comboCaractBandaSonoraValueList;
        java.lang.Object[] labels = this.comboCaractBandaSonoraLabelList;

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

    public java.lang.Object[] getComboCaractBandaSonoraValueList()
    {
        return this.comboCaractBandaSonoraValueList;
    }

    public void setComboCaractBandaSonoraValueList(java.lang.Object[] comboCaractBandaSonoraValueList)
    {
        this.comboCaractBandaSonoraValueList = comboCaractBandaSonoraValueList;
    }

    public java.lang.Object[] getComboCaractBandaSonoraLabelList()
    {
        return this.comboCaractBandaSonoraLabelList;
    }

    public void setComboCaractBandaSonoraLabelList(java.lang.Object[] comboCaractBandaSonoraLabelList)
    {
        this.comboCaractBandaSonoraLabelList = comboCaractBandaSonoraLabelList;
    }

    public void setComboCaractBandaSonoraBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setComboCaractBandaSonoraBackingList requires non-null property arguments");
        }

        this.comboCaractBandaSonoraValueList = null;
        this.comboCaractBandaSonoraLabelList = null;

        if (items != null)
        {
            this.comboCaractBandaSonoraValueList = new java.lang.Object[items.size()];
            this.comboCaractBandaSonoraLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboCaractBandaSonoraValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboCaractBandaSonoraLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setComboCaractBandaSonoraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboCaractLuz</code>.
     */
    public void resetComboCaractLuz()
    {
        this.comboCaractLuz = null;
    }

    public void setComboCaractLuz(java.lang.String comboCaractLuz)
    {
        this.comboCaractLuz = comboCaractLuz;
    }

    /**
     * 
     */
    public java.lang.String getComboCaractLuz()
    {
        return this.comboCaractLuz;
    }
    
    public java.lang.Object[] getComboCaractLuzBackingList()
    {
        java.lang.Object[] values = this.comboCaractLuzValueList;
        java.lang.Object[] labels = this.comboCaractLuzLabelList;

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

    public java.lang.Object[] getComboCaractLuzValueList()
    {
        return this.comboCaractLuzValueList;
    }

    public void setComboCaractLuzValueList(java.lang.Object[] comboCaractLuzValueList)
    {
        this.comboCaractLuzValueList = comboCaractLuzValueList;
    }

    public java.lang.Object[] getComboCaractLuzLabelList()
    {
        return this.comboCaractLuzLabelList;
    }

    public void setComboCaractLuzLabelList(java.lang.Object[] comboCaractLuzLabelList)
    {
        this.comboCaractLuzLabelList = comboCaractLuzLabelList;
    }

    public void setComboCaractLuzBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setComboCaractLuzBackingList requires non-null property arguments");
        }

        this.comboCaractLuzValueList = null;
        this.comboCaractLuzLabelList = null;

        if (items != null)
        {
            this.comboCaractLuzValueList = new java.lang.Object[items.size()];
            this.comboCaractLuzLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboCaractLuzValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboCaractLuzLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setComboCaractLuzBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idiomas</code>.
     */
    public void resetIdiomas()
    {
        this.idiomas = null;
    }

    public void setIdiomas(java.util.Collection idiomas)
    {
        this.idiomas = idiomas;
    }

    /**
     * 
     */
    public java.util.Collection getIdiomas()
    {
        return this.idiomas;
    }

    public void setIdiomasAsArray(Object[] idiomas)
    {
        this.idiomas = (idiomas == null) ? null : java.util.Arrays.asList(idiomas);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralFormSubmitFormImpl#getIdiomas
     */
    public java.lang.Object[] getIdiomasAsArray()
    {
        return (idiomas == null) ? null : idiomas.toArray();
    }
    
    public java.lang.Object[] getIdiomasBackingList()
    {
        java.lang.Object[] values = this.idiomasValueList;
        java.lang.Object[] labels = this.idiomasLabelList;

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

    public java.lang.Object[] getIdiomasValueList()
    {
        return this.idiomasValueList;
    }

    public void setIdiomasValueList(java.lang.Object[] idiomasValueList)
    {
        this.idiomasValueList = idiomasValueList;
    }

    public java.lang.Object[] getIdiomasLabelList()
    {
        return this.idiomasLabelList;
    }

    public void setIdiomasLabelList(java.lang.Object[] idiomasLabelList)
    {
        this.idiomasLabelList = idiomasLabelList;
    }

    public void setIdiomasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setIdiomasBackingList requires non-null property arguments");
        }

        this.idiomasValueList = null;
        this.idiomasLabelList = null;

        if (items != null)
        {
            this.idiomasValueList = new java.lang.Object[items.size()];
            this.idiomasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setIdiomasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboCaractFormato</code>.
     */
    public void resetComboCaractFormato()
    {
        this.comboCaractFormato = null;
    }

    public void setComboCaractFormato(java.lang.String comboCaractFormato)
    {
        this.comboCaractFormato = comboCaractFormato;
    }

    /**
     * 
     */
    public java.lang.String getComboCaractFormato()
    {
        return this.comboCaractFormato;
    }
    
    public java.lang.Object[] getComboCaractFormatoBackingList()
    {
        java.lang.Object[] values = this.comboCaractFormatoValueList;
        java.lang.Object[] labels = this.comboCaractFormatoLabelList;

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

    public java.lang.Object[] getComboCaractFormatoValueList()
    {
        return this.comboCaractFormatoValueList;
    }

    public void setComboCaractFormatoValueList(java.lang.Object[] comboCaractFormatoValueList)
    {
        this.comboCaractFormatoValueList = comboCaractFormatoValueList;
    }

    public java.lang.Object[] getComboCaractFormatoLabelList()
    {
        return this.comboCaractFormatoLabelList;
    }

    public void setComboCaractFormatoLabelList(java.lang.Object[] comboCaractFormatoLabelList)
    {
        this.comboCaractFormatoLabelList = comboCaractFormatoLabelList;
    }

    public void setComboCaractFormatoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setComboCaractFormatoBackingList requires non-null property arguments");
        }

        this.comboCaractFormatoValueList = null;
        this.comboCaractFormatoLabelList = null;

        if (items != null)
        {
            this.comboCaractFormatoValueList = new java.lang.Object[items.size()];
            this.comboCaractFormatoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboCaractFormatoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboCaractFormatoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setComboCaractFormatoBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setComboIdiomaBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setComboIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>caracteristicas</code>.
     */
    public void resetCaracteristicas()
    {
        this.caracteristicas = null;
    }

    public void setCaracteristicas(java.util.Collection caracteristicas)
    {
        this.caracteristicas = caracteristicas;
    }

    /**
     * 
     */
    public java.util.Collection getCaracteristicas()
    {
        return this.caracteristicas;
    }

    public void setCaracteristicasAsArray(Object[] caracteristicas)
    {
        this.caracteristicas = (caracteristicas == null) ? null : java.util.Arrays.asList(caracteristicas);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralFormSubmitFormImpl#getCaracteristicas
     */
    public java.lang.Object[] getCaracteristicasAsArray()
    {
        return (caracteristicas == null) ? null : caracteristicas.toArray();
    }
    
    public java.lang.Object[] getCaracteristicasBackingList()
    {
        java.lang.Object[] values = this.caracteristicasValueList;
        java.lang.Object[] labels = this.caracteristicasLabelList;

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

    public java.lang.Object[] getCaracteristicasValueList()
    {
        return this.caracteristicasValueList;
    }

    public void setCaracteristicasValueList(java.lang.Object[] caracteristicasValueList)
    {
        this.caracteristicasValueList = caracteristicasValueList;
    }

    public java.lang.Object[] getCaracteristicasLabelList()
    {
        return this.caracteristicasLabelList;
    }

    public void setCaracteristicasLabelList(java.lang.Object[] caracteristicasLabelList)
    {
        this.caracteristicasLabelList = caracteristicasLabelList;
    }

    public void setCaracteristicasBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setCaracteristicasBackingList requires non-null property arguments");
        }

        this.caracteristicasValueList = null;
        this.caracteristicasLabelList = null;

        if (items != null)
        {
            this.caracteristicasValueList = new java.lang.Object[items.size()];
            this.caracteristicasLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.caracteristicasValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.caracteristicasLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setCaracteristicasBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboCaractColor</code>.
     */
    public void resetComboCaractColor()
    {
        this.comboCaractColor = null;
    }

    public void setComboCaractColor(java.lang.String comboCaractColor)
    {
        this.comboCaractColor = comboCaractColor;
    }

    /**
     * 
     */
    public java.lang.String getComboCaractColor()
    {
        return this.comboCaractColor;
    }
    
    public java.lang.Object[] getComboCaractColorBackingList()
    {
        java.lang.Object[] values = this.comboCaractColorValueList;
        java.lang.Object[] labels = this.comboCaractColorLabelList;

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

    public java.lang.Object[] getComboCaractColorValueList()
    {
        return this.comboCaractColorValueList;
    }

    public void setComboCaractColorValueList(java.lang.Object[] comboCaractColorValueList)
    {
        this.comboCaractColorValueList = comboCaractColorValueList;
    }

    public java.lang.Object[] getComboCaractColorLabelList()
    {
        return this.comboCaractColorLabelList;
    }

    public void setComboCaractColorLabelList(java.lang.Object[] comboCaractColorLabelList)
    {
        this.comboCaractColorLabelList = comboCaractColorLabelList;
    }

    public void setComboCaractColorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setComboCaractColorBackingList requires non-null property arguments");
        }

        this.comboCaractColorValueList = null;
        this.comboCaractColorLabelList = null;

        if (items != null)
        {
            this.comboCaractColorValueList = new java.lang.Object[items.size()];
            this.comboCaractColorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboCaractColorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboCaractColorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setComboCaractColorBackingList encountered an exception", ex);
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
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setIdentificadorOdeBackingList requires non-null property arguments");
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
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setIdentificadorOdeBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboCaractEstructuraFormal</code>.
     */
    public void resetComboCaractEstructuraFormal()
    {
        this.comboCaractEstructuraFormal = null;
    }

    public void setComboCaractEstructuraFormal(java.lang.String comboCaractEstructuraFormal)
    {
        this.comboCaractEstructuraFormal = comboCaractEstructuraFormal;
    }

    /**
     * 
     */
    public java.lang.String getComboCaractEstructuraFormal()
    {
        return this.comboCaractEstructuraFormal;
    }
    
    public java.lang.Object[] getComboCaractEstructuraFormalBackingList()
    {
        java.lang.Object[] values = this.comboCaractEstructuraFormalValueList;
        java.lang.Object[] labels = this.comboCaractEstructuraFormalLabelList;

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

    public java.lang.Object[] getComboCaractEstructuraFormalValueList()
    {
        return this.comboCaractEstructuraFormalValueList;
    }

    public void setComboCaractEstructuraFormalValueList(java.lang.Object[] comboCaractEstructuraFormalValueList)
    {
        this.comboCaractEstructuraFormalValueList = comboCaractEstructuraFormalValueList;
    }

    public java.lang.Object[] getComboCaractEstructuraFormalLabelList()
    {
        return this.comboCaractEstructuraFormalLabelList;
    }

    public void setComboCaractEstructuraFormalLabelList(java.lang.Object[] comboCaractEstructuraFormalLabelList)
    {
        this.comboCaractEstructuraFormalLabelList = comboCaractEstructuraFormalLabelList;
    }

    public void setComboCaractEstructuraFormalBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setComboCaractEstructuraFormalBackingList requires non-null property arguments");
        }

        this.comboCaractEstructuraFormalValueList = null;
        this.comboCaractEstructuraFormalLabelList = null;

        if (items != null)
        {
            this.comboCaractEstructuraFormalValueList = new java.lang.Object[items.size()];
            this.comboCaractEstructuraFormalLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboCaractEstructuraFormalValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboCaractEstructuraFormalLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setComboCaractEstructuraFormalBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>texto</code>.
     */
    public void resetTexto()
    {
        this.texto = null;
    }

    public void setTexto(java.lang.String texto)
    {
        this.texto = texto;
    }

    /**
     * 
     */
    public java.lang.String getTexto()
    {
        return this.texto;
    }
    
    public java.lang.Object[] getTextoBackingList()
    {
        java.lang.Object[] values = this.textoValueList;
        java.lang.Object[] labels = this.textoLabelList;

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

    public java.lang.Object[] getTextoValueList()
    {
        return this.textoValueList;
    }

    public void setTextoValueList(java.lang.Object[] textoValueList)
    {
        this.textoValueList = textoValueList;
    }

    public java.lang.Object[] getTextoLabelList()
    {
        return this.textoLabelList;
    }

    public void setTextoLabelList(java.lang.Object[] textoLabelList)
    {
        this.textoLabelList = textoLabelList;
    }

    public void setTextoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setTextoBackingList requires non-null property arguments");
        }

        this.textoValueList = null;
        this.textoLabelList = null;

        if (items != null)
        {
            this.textoValueList = new java.lang.Object[items.size()];
            this.textoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.textoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.textoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setTextoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>ambitos</code>.
     */
    public void resetAmbitos()
    {
        this.ambitos = null;
    }

    public void setAmbitos(java.util.Collection ambitos)
    {
        this.ambitos = ambitos;
    }

    /**
     * 
     */
    public java.util.Collection getAmbitos()
    {
        return this.ambitos;
    }

    public void setAmbitosAsArray(Object[] ambitos)
    {
        this.ambitos = (ambitos == null) ? null : java.util.Arrays.asList(ambitos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralFormSubmitFormImpl#getAmbitos
     */
    public java.lang.Object[] getAmbitosAsArray()
    {
        return (ambitos == null) ? null : ambitos.toArray();
    }
    
    public java.lang.Object[] getAmbitosBackingList()
    {
        java.lang.Object[] values = this.ambitosValueList;
        java.lang.Object[] labels = this.ambitosLabelList;

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

    public java.lang.Object[] getAmbitosValueList()
    {
        return this.ambitosValueList;
    }

    public void setAmbitosValueList(java.lang.Object[] ambitosValueList)
    {
        this.ambitosValueList = ambitosValueList;
    }

    public java.lang.Object[] getAmbitosLabelList()
    {
        return this.ambitosLabelList;
    }

    public void setAmbitosLabelList(java.lang.Object[] ambitosLabelList)
    {
        this.ambitosLabelList = ambitosLabelList;
    }

    public void setAmbitosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setAmbitosBackingList requires non-null property arguments");
        }

        this.ambitosValueList = null;
        this.ambitosLabelList = null;

        if (items != null)
        {
            this.ambitosValueList = new java.lang.Object[items.size()];
            this.ambitosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.ambitosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.ambitosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setAmbitosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>identificadores</code>.
     */
    public void resetIdentificadores()
    {
        this.identificadores = null;
    }

    public void setIdentificadores(java.util.Collection identificadores)
    {
        this.identificadores = identificadores;
    }

    /**
     * 
     */
    public java.util.Collection getIdentificadores()
    {
        return this.identificadores;
    }

    public void setIdentificadoresAsArray(Object[] identificadores)
    {
        this.identificadores = (identificadores == null) ? null : java.util.Arrays.asList(identificadores);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralFormSubmitFormImpl#getIdentificadores
     */
    public java.lang.Object[] getIdentificadoresAsArray()
    {
        return (identificadores == null) ? null : identificadores.toArray();
    }
    
    public java.lang.Object[] getIdentificadoresBackingList()
    {
        java.lang.Object[] values = this.identificadoresValueList;
        java.lang.Object[] labels = this.identificadoresLabelList;

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

    public java.lang.Object[] getIdentificadoresValueList()
    {
        return this.identificadoresValueList;
    }

    public void setIdentificadoresValueList(java.lang.Object[] identificadoresValueList)
    {
        this.identificadoresValueList = identificadoresValueList;
    }

    public java.lang.Object[] getIdentificadoresLabelList()
    {
        return this.identificadoresLabelList;
    }

    public void setIdentificadoresLabelList(java.lang.Object[] identificadoresLabelList)
    {
        this.identificadoresLabelList = identificadoresLabelList;
    }

    public void setIdentificadoresBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setIdentificadoresBackingList requires non-null property arguments");
        }

        this.identificadoresValueList = null;
        this.identificadoresLabelList = null;

        if (items != null)
        {
            this.identificadoresValueList = new java.lang.Object[items.size()];
            this.identificadoresLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.identificadoresValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.identificadoresLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setIdentificadoresBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>textos</code>.
     */
    public void resetTextos()
    {
        this.textos = null;
    }

    public void setTextos(java.lang.String textos)
    {
        this.textos = textos;
    }

    /**
     * 
     */
    public java.lang.String getTextos()
    {
        return this.textos;
    }
    
    public java.lang.Object[] getTextosBackingList()
    {
        java.lang.Object[] values = this.textosValueList;
        java.lang.Object[] labels = this.textosLabelList;

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

    public java.lang.Object[] getTextosValueList()
    {
        return this.textosValueList;
    }

    public void setTextosValueList(java.lang.Object[] textosValueList)
    {
        this.textosValueList = textosValueList;
    }

    public java.lang.Object[] getTextosLabelList()
    {
        return this.textosLabelList;
    }

    public void setTextosLabelList(java.lang.Object[] textosLabelList)
    {
        this.textosLabelList = textosLabelList;
    }

    public void setTextosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setTextosBackingList requires non-null property arguments");
        }

        this.textosValueList = null;
        this.textosLabelList = null;

        if (items != null)
        {
            this.textosValueList = new java.lang.Object[items.size()];
            this.textosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.textosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.textosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setTextosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>estructura</code>.
     */
    public void resetEstructura()
    {
        this.estructura = null;
    }

    public void setEstructura(java.lang.String estructura)
    {
        this.estructura = estructura;
    }

    /**
     * 
     */
    public java.lang.String getEstructura()
    {
        return this.estructura;
    }
    
    public java.lang.Object[] getEstructuraBackingList()
    {
        java.lang.Object[] values = this.estructuraValueList;
        java.lang.Object[] labels = this.estructuraLabelList;

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

    public java.lang.Object[] getEstructuraValueList()
    {
        return this.estructuraValueList;
    }

    public void setEstructuraValueList(java.lang.Object[] estructuraValueList)
    {
        this.estructuraValueList = estructuraValueList;
    }

    public java.lang.Object[] getEstructuraLabelList()
    {
        return this.estructuraLabelList;
    }

    public void setEstructuraLabelList(java.lang.Object[] estructuraLabelList)
    {
        this.estructuraLabelList = estructuraLabelList;
    }

    public void setEstructuraBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setEstructuraBackingList requires non-null property arguments");
        }

        this.estructuraValueList = null;
        this.estructuraLabelList = null;

        if (items != null)
        {
            this.estructuraValueList = new java.lang.Object[items.size()];
            this.estructuraLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.estructuraValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.estructuraLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setEstructuraBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>idioma</code>.
     */
    public void resetIdioma()
    {
        this.idioma = null;
    }

    public void setIdioma(java.lang.String idioma)
    {
        this.idioma = idioma;
    }

    /**
     * 
     */
    public java.lang.String getIdioma()
    {
        return this.idioma;
    }
    
    public java.lang.Object[] getIdiomaBackingList()
    {
        java.lang.Object[] values = this.idiomaValueList;
        java.lang.Object[] labels = this.idiomaLabelList;

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

    public java.lang.Object[] getIdiomaValueList()
    {
        return this.idiomaValueList;
    }

    public void setIdiomaValueList(java.lang.Object[] idiomaValueList)
    {
        this.idiomaValueList = idiomaValueList;
    }

    public java.lang.Object[] getIdiomaLabelList()
    {
        return this.idiomaLabelList;
    }

    public void setIdiomaLabelList(java.lang.Object[] idiomaLabelList)
    {
        this.idiomaLabelList = idiomaLabelList;
    }

    public void setIdiomaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setIdiomaBackingList requires non-null property arguments");
        }

        this.idiomaValueList = null;
        this.idiomaLabelList = null;

        if (items != null)
        {
            this.idiomaValueList = new java.lang.Object[items.size()];
            this.idiomaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.idiomaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.idiomaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setIdiomaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboCaractAngulacion</code>.
     */
    public void resetComboCaractAngulacion()
    {
        this.comboCaractAngulacion = null;
    }

    public void setComboCaractAngulacion(java.lang.String comboCaractAngulacion)
    {
        this.comboCaractAngulacion = comboCaractAngulacion;
    }

    /**
     * 
     */
    public java.lang.String getComboCaractAngulacion()
    {
        return this.comboCaractAngulacion;
    }
    
    public java.lang.Object[] getComboCaractAngulacionBackingList()
    {
        java.lang.Object[] values = this.comboCaractAngulacionValueList;
        java.lang.Object[] labels = this.comboCaractAngulacionLabelList;

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

    public java.lang.Object[] getComboCaractAngulacionValueList()
    {
        return this.comboCaractAngulacionValueList;
    }

    public void setComboCaractAngulacionValueList(java.lang.Object[] comboCaractAngulacionValueList)
    {
        this.comboCaractAngulacionValueList = comboCaractAngulacionValueList;
    }

    public java.lang.Object[] getComboCaractAngulacionLabelList()
    {
        return this.comboCaractAngulacionLabelList;
    }

    public void setComboCaractAngulacionLabelList(java.lang.Object[] comboCaractAngulacionLabelList)
    {
        this.comboCaractAngulacionLabelList = comboCaractAngulacionLabelList;
    }

    public void setComboCaractAngulacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setComboCaractAngulacionBackingList requires non-null property arguments");
        }

        this.comboCaractAngulacionValueList = null;
        this.comboCaractAngulacionLabelList = null;

        if (items != null)
        {
            this.comboCaractAngulacionValueList = new java.lang.Object[items.size()];
            this.comboCaractAngulacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboCaractAngulacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboCaractAngulacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setComboCaractAngulacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>nivelAgregacion</code>.
     */
    public void resetNivelAgregacion()
    {
        this.nivelAgregacion = null;
    }

    public void setNivelAgregacion(java.lang.String nivelAgregacion)
    {
        this.nivelAgregacion = nivelAgregacion;
    }

    /**
     * 
     */
    public java.lang.String getNivelAgregacion()
    {
        return this.nivelAgregacion;
    }
    
    public java.lang.Object[] getNivelAgregacionBackingList()
    {
        java.lang.Object[] values = this.nivelAgregacionValueList;
        java.lang.Object[] labels = this.nivelAgregacionLabelList;

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

    public java.lang.Object[] getNivelAgregacionValueList()
    {
        return this.nivelAgregacionValueList;
    }

    public void setNivelAgregacionValueList(java.lang.Object[] nivelAgregacionValueList)
    {
        this.nivelAgregacionValueList = nivelAgregacionValueList;
    }

    public java.lang.Object[] getNivelAgregacionLabelList()
    {
        return this.nivelAgregacionLabelList;
    }

    public void setNivelAgregacionLabelList(java.lang.Object[] nivelAgregacionLabelList)
    {
        this.nivelAgregacionLabelList = nivelAgregacionLabelList;
    }

    public void setNivelAgregacionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setNivelAgregacionBackingList requires non-null property arguments");
        }

        this.nivelAgregacionValueList = null;
        this.nivelAgregacionLabelList = null;

        if (items != null)
        {
            this.nivelAgregacionValueList = new java.lang.Object[items.size()];
            this.nivelAgregacionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.nivelAgregacionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.nivelAgregacionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setNivelAgregacionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>accion</code>.
     */
    public void resetAccion()
    {
        this.accion = null;
    }

    public void setAccion(java.lang.String accion)
    {
        this.accion = accion;
    }

    /**
     * 
     */
    public java.lang.String getAccion()
    {
        return this.accion;
    }
    
    public java.lang.Object[] getAccionBackingList()
    {
        java.lang.Object[] values = this.accionValueList;
        java.lang.Object[] labels = this.accionLabelList;

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

    public java.lang.Object[] getAccionValueList()
    {
        return this.accionValueList;
    }

    public void setAccionValueList(java.lang.Object[] accionValueList)
    {
        this.accionValueList = accionValueList;
    }

    public java.lang.Object[] getAccionLabelList()
    {
        return this.accionLabelList;
    }

    public void setAccionLabelList(java.lang.Object[] accionLabelList)
    {
        this.accionLabelList = accionLabelList;
    }

    public void setAccionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setAccionBackingList requires non-null property arguments");
        }

        this.accionValueList = null;
        this.accionLabelList = null;

        if (items != null)
        {
            this.accionValueList = new java.lang.Object[items.size()];
            this.accionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.accionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.accionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setAccionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>catalogo</code>.
     */
    public void resetCatalogo()
    {
        this.catalogo = null;
    }

    public void setCatalogo(java.lang.String catalogo)
    {
        this.catalogo = catalogo;
    }

    /**
     * 
     */
    public java.lang.String getCatalogo()
    {
        return this.catalogo;
    }
    
    public java.lang.Object[] getCatalogoBackingList()
    {
        java.lang.Object[] values = this.catalogoValueList;
        java.lang.Object[] labels = this.catalogoLabelList;

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

    public java.lang.Object[] getCatalogoValueList()
    {
        return this.catalogoValueList;
    }

    public void setCatalogoValueList(java.lang.Object[] catalogoValueList)
    {
        this.catalogoValueList = catalogoValueList;
    }

    public java.lang.Object[] getCatalogoLabelList()
    {
        return this.catalogoLabelList;
    }

    public void setCatalogoLabelList(java.lang.Object[] catalogoLabelList)
    {
        this.catalogoLabelList = catalogoLabelList;
    }

    public void setCatalogoBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setCatalogoBackingList requires non-null property arguments");
        }

        this.catalogoValueList = null;
        this.catalogoLabelList = null;

        if (items != null)
        {
            this.catalogoValueList = new java.lang.Object[items.size()];
            this.catalogoLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.catalogoValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.catalogoLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setCatalogoBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>entrada</code>.
     */
    public void resetEntrada()
    {
        this.entrada = null;
    }

    public void setEntrada(java.lang.String entrada)
    {
        this.entrada = entrada;
    }

    /**
     * 
     */
    public java.lang.String getEntrada()
    {
        return this.entrada;
    }
    
    public java.lang.Object[] getEntradaBackingList()
    {
        java.lang.Object[] values = this.entradaValueList;
        java.lang.Object[] labels = this.entradaLabelList;

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

    public java.lang.Object[] getEntradaValueList()
    {
        return this.entradaValueList;
    }

    public void setEntradaValueList(java.lang.Object[] entradaValueList)
    {
        this.entradaValueList = entradaValueList;
    }

    public java.lang.Object[] getEntradaLabelList()
    {
        return this.entradaLabelList;
    }

    public void setEntradaLabelList(java.lang.Object[] entradaLabelList)
    {
        this.entradaLabelList = entradaLabelList;
    }

    public void setEntradaBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setEntradaBackingList requires non-null property arguments");
        }

        this.entradaValueList = null;
        this.entradaLabelList = null;

        if (items != null)
        {
            this.entradaValueList = new java.lang.Object[items.size()];
            this.entradaLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.entradaValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.entradaLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setEntradaBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>comboCaractDimension</code>.
     */
    public void resetComboCaractDimension()
    {
        this.comboCaractDimension = null;
    }

    public void setComboCaractDimension(java.lang.String comboCaractDimension)
    {
        this.comboCaractDimension = comboCaractDimension;
    }

    /**
     * 
     */
    public java.lang.String getComboCaractDimension()
    {
        return this.comboCaractDimension;
    }
    
    public java.lang.Object[] getComboCaractDimensionBackingList()
    {
        java.lang.Object[] values = this.comboCaractDimensionValueList;
        java.lang.Object[] labels = this.comboCaractDimensionLabelList;

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

    public java.lang.Object[] getComboCaractDimensionValueList()
    {
        return this.comboCaractDimensionValueList;
    }

    public void setComboCaractDimensionValueList(java.lang.Object[] comboCaractDimensionValueList)
    {
        this.comboCaractDimensionValueList = comboCaractDimensionValueList;
    }

    public java.lang.Object[] getComboCaractDimensionLabelList()
    {
        return this.comboCaractDimensionLabelList;
    }

    public void setComboCaractDimensionLabelList(java.lang.Object[] comboCaractDimensionLabelList)
    {
        this.comboCaractDimensionLabelList = comboCaractDimensionLabelList;
    }

    public void setComboCaractDimensionBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setComboCaractDimensionBackingList requires non-null property arguments");
        }

        this.comboCaractDimensionValueList = null;
        this.comboCaractDimensionLabelList = null;

        if (items != null)
        {
            this.comboCaractDimensionValueList = new java.lang.Object[items.size()];
            this.comboCaractDimensionLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.comboCaractDimensionValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.comboCaractDimensionLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setComboCaractDimensionBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>titulos</code>.
     */
    public void resetTitulos()
    {
        this.titulos = null;
    }

    public void setTitulos(java.util.Collection titulos)
    {
        this.titulos = titulos;
    }

    /**
     * 
     */
    public java.util.Collection getTitulos()
    {
        return this.titulos;
    }

    public void setTitulosAsArray(Object[] titulos)
    {
        this.titulos = (titulos == null) ? null : java.util.Arrays.asList(titulos);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralFormSubmitFormImpl#getTitulos
     */
    public java.lang.Object[] getTitulosAsArray()
    {
        return (titulos == null) ? null : titulos.toArray();
    }
    
    public java.lang.Object[] getTitulosBackingList()
    {
        java.lang.Object[] values = this.titulosValueList;
        java.lang.Object[] labels = this.titulosLabelList;

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

    public java.lang.Object[] getTitulosValueList()
    {
        return this.titulosValueList;
    }

    public void setTitulosValueList(java.lang.Object[] titulosValueList)
    {
        this.titulosValueList = titulosValueList;
    }

    public java.lang.Object[] getTitulosLabelList()
    {
        return this.titulosLabelList;
    }

    public void setTitulosLabelList(java.lang.Object[] titulosLabelList)
    {
        this.titulosLabelList = titulosLabelList;
    }

    public void setTitulosBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setTitulosBackingList requires non-null property arguments");
        }

        this.titulosValueList = null;
        this.titulosLabelList = null;

        if (items != null)
        {
            this.titulosValueList = new java.lang.Object[items.size()];
            this.titulosLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.titulosValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.titulosLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setTitulosBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * Resets the given <code>mensajesError</code>.
     */
    public void resetMensajesError()
    {
        this.mensajesError = null;
    }

    public void setMensajesError(java.util.Collection mensajesError)
    {
        this.mensajesError = mensajesError;
    }

    /**
     * 
     */
    public java.util.Collection getMensajesError()
    {
        return this.mensajesError;
    }

    public void setMensajesErrorAsArray(Object[] mensajesError)
    {
        this.mensajesError = (mensajesError == null) ? null : java.util.Arrays.asList(mensajesError);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general.GeneralFormSubmitFormImpl#getMensajesError
     */
    public java.lang.Object[] getMensajesErrorAsArray()
    {
        return (mensajesError == null) ? null : mensajesError.toArray();
    }
    
    public java.lang.Object[] getMensajesErrorBackingList()
    {
        java.lang.Object[] values = this.mensajesErrorValueList;
        java.lang.Object[] labels = this.mensajesErrorLabelList;

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

    public java.lang.Object[] getMensajesErrorValueList()
    {
        return this.mensajesErrorValueList;
    }

    public void setMensajesErrorValueList(java.lang.Object[] mensajesErrorValueList)
    {
        this.mensajesErrorValueList = mensajesErrorValueList;
    }

    public java.lang.Object[] getMensajesErrorLabelList()
    {
        return this.mensajesErrorLabelList;
    }

    public void setMensajesErrorLabelList(java.lang.Object[] mensajesErrorLabelList)
    {
        this.mensajesErrorLabelList = mensajesErrorLabelList;
    }

    public void setMensajesErrorBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("GeneralFormSubmitFormImpl.setMensajesErrorBackingList requires non-null property arguments");
        }

        this.mensajesErrorValueList = null;
        this.mensajesErrorLabelList = null;

        if (items != null)
        {
            this.mensajesErrorValueList = new java.lang.Object[items.size()];
            this.mensajesErrorLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.mensajesErrorValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.mensajesErrorLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("GeneralFormSubmitFormImpl.setMensajesErrorBackingList encountered an exception", ex);
            }
        }
    }

    /**
     * @see org.apache.struts.validator.ValidatorForm#reset(org.apache.struts.action.ActionMapping,javax.servlet.http.HttpServletRequest)
     */
    public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request)
    {
        this.descripciones = null;
        this.descripcionesValueList = new java.lang.Object[0];
        this.descripcionesLabelList = new java.lang.Object[0];
        this.palabrasClave = null;
        this.palabrasClaveValueList = new java.lang.Object[0];
        this.palabrasClaveLabelList = new java.lang.Object[0];
        this.comboCaractTipoPlano = null;
        this.comboCaractBandaSonora = null;
        this.comboCaractLuz = null;
        this.idiomas = null;
        this.idiomasValueList = new java.lang.Object[0];
        this.idiomasLabelList = new java.lang.Object[0];
        this.comboCaractFormato = null;
        this.comboIdioma = null;
        this.caracteristicas = null;
        this.caracteristicasValueList = new java.lang.Object[0];
        this.caracteristicasLabelList = new java.lang.Object[0];
        this.comboCaractColor = null;
        this.comboCaractEstructuraFormal = null;
        this.ambitos = null;
        this.ambitosValueList = new java.lang.Object[0];
        this.ambitosLabelList = new java.lang.Object[0];
        this.identificadores = null;
        this.identificadoresValueList = new java.lang.Object[0];
        this.identificadoresLabelList = new java.lang.Object[0];
        this.estructura = null;
        this.idioma = null;
        this.comboCaractAngulacion = null;
        this.nivelAgregacion = null;
        this.comboCaractDimension = null;
        this.titulos = null;
        this.titulosValueList = new java.lang.Object[0];
        this.titulosLabelList = new java.lang.Object[0];
    }

    public java.lang.String toString()
    {
        org.apache.commons.lang.builder.ToStringBuilder builder =
            new org.apache.commons.lang.builder.ToStringBuilder(this);
        builder.append("descripciones", this.descripciones);
        builder.append("palabrasClave", this.palabrasClave);
        builder.append("comboCaractTipoPlano", this.comboCaractTipoPlano);
        builder.append("comboCaractBandaSonora", this.comboCaractBandaSonora);
        builder.append("comboCaractLuz", this.comboCaractLuz);
        builder.append("idiomas", this.idiomas);
        builder.append("comboCaractFormato", this.comboCaractFormato);
        builder.append("comboIdioma", this.comboIdioma);
        builder.append("caracteristicas", this.caracteristicas);
        builder.append("comboCaractColor", this.comboCaractColor);
        builder.append("identificadorOde", this.identificadorOde);
        builder.append("comboCaractEstructuraFormal", this.comboCaractEstructuraFormal);
        builder.append("texto", this.texto);
        builder.append("ambitos", this.ambitos);
        builder.append("identificadores", this.identificadores);
        builder.append("textos", this.textos);
        builder.append("estructura", this.estructura);
        builder.append("idioma", this.idioma);
        builder.append("comboCaractAngulacion", this.comboCaractAngulacion);
        builder.append("nivelAgregacion", this.nivelAgregacion);
        builder.append("accion", this.accion);
        builder.append("catalogo", this.catalogo);
        builder.append("entrada", this.entrada);
        builder.append("comboCaractDimension", this.comboCaractDimension);
        builder.append("titulos", this.titulos);
        builder.append("mensajesError", this.mensajesError);
        return builder.toString();
    }

    /**
     * Allows you to clean all values from this form. Objects will be set to <code>null</code>, numeric values will be
     * set to zero and boolean values will be set to <code>false</code>. Backinglists for selectable fields will
     * also be set to <code>null</code>.
     */
    public void clean()
    {
        this.descripciones = null;
        this.descripcionesValueList = null;
        this.descripcionesLabelList = null;
        this.palabrasClave = null;
        this.palabrasClaveValueList = null;
        this.palabrasClaveLabelList = null;
        this.comboCaractTipoPlano = null;
        this.comboCaractTipoPlanoValueList = null;
        this.comboCaractTipoPlanoLabelList = null;
        this.comboCaractBandaSonora = null;
        this.comboCaractBandaSonoraValueList = null;
        this.comboCaractBandaSonoraLabelList = null;
        this.comboCaractLuz = null;
        this.comboCaractLuzValueList = null;
        this.comboCaractLuzLabelList = null;
        this.idiomas = null;
        this.idiomasValueList = null;
        this.idiomasLabelList = null;
        this.comboCaractFormato = null;
        this.comboCaractFormatoValueList = null;
        this.comboCaractFormatoLabelList = null;
        this.comboIdioma = null;
        this.comboIdiomaValueList = null;
        this.comboIdiomaLabelList = null;
        this.caracteristicas = null;
        this.caracteristicasValueList = null;
        this.caracteristicasLabelList = null;
        this.comboCaractColor = null;
        this.comboCaractColorValueList = null;
        this.comboCaractColorLabelList = null;
        this.identificadorOde = null;
        this.identificadorOdeValueList = null;
        this.identificadorOdeLabelList = null;
        this.comboCaractEstructuraFormal = null;
        this.comboCaractEstructuraFormalValueList = null;
        this.comboCaractEstructuraFormalLabelList = null;
        this.texto = null;
        this.textoValueList = null;
        this.textoLabelList = null;
        this.ambitos = null;
        this.ambitosValueList = null;
        this.ambitosLabelList = null;
        this.identificadores = null;
        this.identificadoresValueList = null;
        this.identificadoresLabelList = null;
        this.textos = null;
        this.textosValueList = null;
        this.textosLabelList = null;
        this.estructura = null;
        this.estructuraValueList = null;
        this.estructuraLabelList = null;
        this.idioma = null;
        this.idiomaValueList = null;
        this.idiomaLabelList = null;
        this.comboCaractAngulacion = null;
        this.comboCaractAngulacionValueList = null;
        this.comboCaractAngulacionLabelList = null;
        this.nivelAgregacion = null;
        this.nivelAgregacionValueList = null;
        this.nivelAgregacionLabelList = null;
        this.accion = null;
        this.accionValueList = null;
        this.accionLabelList = null;
        this.catalogo = null;
        this.catalogoValueList = null;
        this.catalogoLabelList = null;
        this.entrada = null;
        this.entradaValueList = null;
        this.entradaLabelList = null;
        this.comboCaractDimension = null;
        this.comboCaractDimensionValueList = null;
        this.comboCaractDimensionLabelList = null;
        this.titulos = null;
        this.titulosValueList = null;
        this.titulosLabelList = null;
        this.mensajesError = null;
        this.mensajesErrorValueList = null;
        this.mensajesErrorLabelList = null;
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
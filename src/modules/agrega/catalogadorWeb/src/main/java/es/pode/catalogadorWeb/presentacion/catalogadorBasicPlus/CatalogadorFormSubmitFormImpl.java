// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

import java.util.Collection;

import es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatalogadorBasicPlusFormImpl.LabelValue;

/*
 *         , es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.VolverAEmpaquetadorForm
        , es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.RealizarSubmitForm
        ////, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CargarDatosGuardarForm
        //, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.EliminarArbolForm
        ////, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CargarDatosSesionForm
        //, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ValidarMetadatosForm
        //, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ChequearDatosForm
        //, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ExportarLomesForm
        ////, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CargarDatosForm
        //, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ValidarExportarForm
        //, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SonValidosMDBOForm
        //XX, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.RecogeAccionForm
        //, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SonValidosExportarForm
        //, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ActualizadosForm
 */

public class CatalogadorFormSubmitFormImpl
    extends es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatalogadorBasicPlusFormImpl
    implements 
    	es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.VolverAEmpaquetadorForm
    	, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.RealizarSubmitForm
    	, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CargarDatosGuardarForm
    	, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CargarDatosSesionForm
    	, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CargarDatosForm
    	, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.RecogeAccionForm
    	, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ValidarMetadatosForm
    	, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SonValidosMDBOForm
    	, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ChequearDatosForm
    	, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ActualizadosForm
    {

	/*
	 * Fields from CargarDatosSesionForm
	 */
	private java.util.Collection arboles;
	
	/*
	 * Fields from RealizarSubmitForm/RecogeAccionForm
	 */
    private java.lang.String accionSubmit;
    private java.lang.Object[] accionSubmitValueList;
    private java.lang.Object[] accionSubmitLabelList;
	
    /*
     * Fields from ValidarMetadatosForm
     */
    private boolean isvalid;
    
    /*
     * Fields from SonValidosMDBOForm
     */
    private java.util.Collection mensajesError;
    
    /*
     * Fields from ChequearDatosForm
     */
    private boolean actualizados;
    
    
	/*
	 * Fields from CargarDatosForm/CargarDatosGuardarForm
	 */
    /*
    private java.lang.String titulo;
    private java.lang.String idioma;
    private java.lang.Object[] idiomaValueList;
    private java.lang.Object[] idiomaLabelList;
    private java.lang.String description;
    private java.lang.String keyword;
    private java.lang.String aggregationLevel;
    private java.lang.Object[] aggregationLevelValueList;
    private java.lang.Object[] aggregationLevelLabelList;
    private java.lang.String authorFullName;
    private java.lang.String authorOrganisation;
    private java.lang.String providerFullName;
    private java.lang.String resourceMIMEType;
    private java.lang.Object[] resourceMIMETypeValueList;
    private java.lang.Object[] resourceMIMETypeLabelList;
    private java.lang.String installationNotes;
    private java.lang.String platformRequirements;
    private java.lang.String durationYears;
    private java.lang.String durationMonths;
    private java.lang.String durationDays;
    private java.lang.String durationHours;
    private java.lang.String durationMinutes;
    private java.lang.String durationSeconds;    
    private java.lang.String tipoRecurso;
    private java.lang.Object[] tipoRecursoValueList;
    private java.lang.Object[] tipoRecursoLabelList;
    private java.lang.String intendedEndUserRole;
    private java.lang.Object[] intendedEndUserRoleValueList;
    private java.lang.Object[] intendedEndUserRoleLabelList;
    private java.lang.String typicalLearningTimeYears;
    private java.lang.String typicalLearningTimeMonths;
    private java.lang.String typicalLearningTimeDays;
    private java.lang.String typicalLearningTimeHours;
    private java.lang.String typicalLearningTimeMinutes;    
    private java.lang.String relationKind;
    private java.lang.Object[] relationKindValueList;
    private java.lang.Object[] relationKindLabelList;
    private java.lang.String relationKindDescription;
	*/
    
    public CatalogadorFormSubmitFormImpl()
    {
    }

  
    /*
     * Methods from CargarDatosSesionForm
     */
    
    public void setArboles(java.util.Collection arboles)
    {
        this.arboles = arboles;
    }

    /**
     * 
     */
    public java.util.Collection getArboles()
    {
        return this.arboles;
    }

    public void setArbolesAsArray(Object[] arboles)
    {
        this.arboles = (arboles == null) ? null : java.util.Arrays.asList(arboles);
    }

    /**
     * Returns this collection as an array, if the collection itself would be <code>null</code> this method
     * will also return <code>null</code>.
     *
     * @see es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatalogadorFormSubmitFormImpl#getArboles
     */
    public java.lang.Object[] getArbolesAsArray()
    {
        return (arboles == null) ? null : arboles.toArray();
    }
    
    
    /*
     * Methods from RealizarSubmitForm
     */
    
    /**
     * Resets the given <code>accionSubmit</code>.
     */
    public void resetAccionSubmit()
    {
        this.accionSubmit = null;
    }

    public void setAccionSubmit(java.lang.String accionSubmit)
    {
        this.accionSubmit = accionSubmit;
    }

    /**
     * 
     */
    public java.lang.String getAccionSubmit()
    {
        return this.accionSubmit;
    }
    
    public java.lang.Object[] getAccionSubmitBackingList()
    {
        java.lang.Object[] values = this.accionSubmitValueList;
        java.lang.Object[] labels = this.accionSubmitLabelList;

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

    public java.lang.Object[] getAccionSubmitValueList()
    {
        return this.accionSubmitValueList;
    }

    public void setAccionSubmitValueList(java.lang.Object[] accionSubmitValueList)
    {
        this.accionSubmitValueList = accionSubmitValueList;
    }

    public java.lang.Object[] getAccionSubmitLabelList()
    {
        return this.accionSubmitLabelList;
    }

    public void setAccionSubmitLabelList(java.lang.Object[] accionSubmitLabelList)
    {
        this.accionSubmitLabelList = accionSubmitLabelList;
    }

    public void setAccionSubmitBackingList(java.util.Collection items, java.lang.String valueProperty, java.lang.String labelProperty)
    {
        if (valueProperty == null || labelProperty == null)
        {
            throw new IllegalArgumentException("CatalogadorFormSubmitFormImpl.setAccionSubmitBackingList requires non-null property arguments");
        }

        this.accionSubmitValueList = null;
        this.accionSubmitLabelList = null;

        if (items != null)
        {
            this.accionSubmitValueList = new java.lang.Object[items.size()];
            this.accionSubmitLabelList = new java.lang.Object[items.size()];

            try
            {
                int i = 0;
                for (java.util.Iterator iterator = items.iterator(); iterator.hasNext(); i++)
                {
                    final java.lang.Object item = iterator.next();

                    this.accionSubmitValueList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, valueProperty);
                    this.accionSubmitLabelList[i] = org.apache.commons.beanutils.PropertyUtils.getProperty(item, labelProperty);
                }
            }
            catch (Exception ex)
            {
                throw new java.lang.RuntimeException("CatalogadorFormSubmitFormImpl.setAccionSubmitBackingList encountered an exception", ex);
            }
        }
    }
    

    /*
     * Methods from ValidarMetadatosForm
     */
    public void setIsValid(boolean isValid)
    {
        this.isvalid = isValid;
    }

    public boolean getIsValid()
    {
        return this.isvalid;
    }
    
    
    public void setMensajesError(java.util.Collection mensajesError)
    {
        this.mensajesError = mensajesError;
    }

    
    /*
     * Methods from SonValidosMDBOForm 
     */
    public java.util.Collection getMensajesError()
    {
        return this.mensajesError;
    }

    
    /*
     * Methods from ChequerDatosForm
     */

    public void setActualizados(boolean actualizados)
    {
        this.actualizados = actualizados;
    }

    public boolean isActualizados()
    {
        return this.actualizados;
    }

    
}
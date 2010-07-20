// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

public class GuardarpresGuardarDatosFormImpl
    extends es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatalogadorBasicPlusFormImpl
    implements java.io.Serializable
        , es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.VolverAEmpaquetadorForm
        , es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.GuardarMetadatosForm
        , es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.GuardarDatosForm
{
	
	private java.lang.String accion;
	
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
	
}
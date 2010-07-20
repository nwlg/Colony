// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>guardarDatos</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusController#guardarDatos
 */
public interface GuardarDatosForm extends es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatalogadorBasicPlusForm
{
    /**
     * Sets the <code>accion</code> field.
     *
     * 
     */
    public abstract void setAccion(java.lang.String accion);

    /**
     * Gets the <code>accion</code> field.
     *
     * 
     */
    public abstract java.lang.String getAccion();
    
}

// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasico;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>realizarSubmit</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatBasicoController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatBasicoController#realizarSubmit
 */
public interface RealizarSubmitForm
{
    /**
     * Sets the <code>accionSubmit</code> field.
     *
     * 
     */
    public void setAccionSubmit(java.lang.String accionSubmit);

    /**
     * Gets the <code>accionSubmit</code> field.
     *
     * 
     */
    public java.lang.String getAccionSubmit();
    
    /**
     * Resets the <code>accionSubmit</code> field.
     */
    public void resetAccionSubmit();

}

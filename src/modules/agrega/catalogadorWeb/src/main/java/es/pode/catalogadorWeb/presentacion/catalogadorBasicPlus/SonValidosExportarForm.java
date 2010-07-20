// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>sonValidosExportar</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusController#sonValidosExportar
 */
public interface SonValidosExportarForm
{
	
    /**
     * Sets the <code>isvalid</code> field.
     *
     * 
     */
    public void setIsValid(boolean isValid);

    /**
     * Gets the <code>valida</code> field.
     *
     * 
     */
    public boolean getIsValid();
    
    /**
     * Sets the <code>mensajesError (Error messages)</code> field.
     *
     * 
     */
	public void setMensajesError(java.util.Collection mensajesError);

    /**
     * Gets the <code>mensajesError (Error messages)</code> field.
     *
     * 
     */
	public java.util.Collection getMensajesError();
}

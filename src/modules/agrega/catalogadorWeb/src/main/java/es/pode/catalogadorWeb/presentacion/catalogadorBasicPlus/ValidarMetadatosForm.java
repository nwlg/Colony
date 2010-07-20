// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>validarMetadatos</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusController</code> controller.
 *
 * <p>
 * Valida si los valores que son obligatorios en un metadato de
 * tipo LOM-ES estan vacios.
 * </p>
 * <p>
 * Recibe como entrada los datos recogidos desde el formulario, y
 * hace una llamada al metodo validarMDBasicos.
 * </p>
 *
 * @see es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatBasicPlusController#validarMetadatos
 */
public interface ValidarMetadatosForm extends es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CatalogadorBasicPlusForm
{

	// Additional fields for the validation object
	
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
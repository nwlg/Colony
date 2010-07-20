// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasico;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submitImportar</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatBasicoController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.catalogadorBasico.CatBasicoController#submitImportar
 */
public interface SubmitImportarForm
{
    /**
     * Sets the <code>fichero</code> Struts FormFile field to the specified value.
     *
     * 
     */
    public void setFichero(org.apache.struts.upload.FormFile fichero);


    /**
     * Gets the <code>fichero</code> Struts FormFile field value.
     *
     * 
     */
    public org.apache.struts.upload.FormFile getFichero();

    /**
     * Resets the <code>fichero</code> field.
     */
    public void resetFichero();

    /**
     * Sets the <code>accion</code> field.
     *
     * 
     */
    public void setAccion(java.lang.String accion);

    /**
     * Gets the <code>accion</code> field.
     *
     * 
     */
    public java.lang.String getAccion();
    
    /**
     * Resets the <code>accion</code> field.
     */
    public void resetAccion();

}

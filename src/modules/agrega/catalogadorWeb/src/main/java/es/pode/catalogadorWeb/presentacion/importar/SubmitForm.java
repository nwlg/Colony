// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.importar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submit</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.importar.ImportarController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.importar.ImportarController#submit
 */
public interface SubmitForm
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

// license-header java merge-point
package es.pode.modificador.presentacion.importar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>selectAction</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.importar.ImportarModificacionController</code> controller.
 *
 * 
 *
 * @see es.pode.modificador.presentacion.importar.ImportarModificacionController#selectAction
 */
public interface SelectActionForm
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
     * Sets the <code>action</code> field.
     *
     * 
     */
    public void setAction(java.lang.String action);

    /**
     * Gets the <code>action</code> field.
     *
     * 
     */
    public java.lang.String getAction();
    
    /**
     * Resets the <code>action</code> field.
     */
    public void resetAction();

}

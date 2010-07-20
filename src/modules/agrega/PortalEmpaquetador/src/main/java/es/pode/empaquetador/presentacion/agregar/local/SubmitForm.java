// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar.local;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submit</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.agregar.local.AgregarLocalController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.agregar.local.AgregarLocalController#submit
 */
public interface SubmitForm
{
    /**
     * Sets the <code>archivo</code> Struts FormFile field to the specified value.
     *
     * 
     */
    public void setArchivo(org.apache.struts.upload.FormFile archivo);


    /**
     * Gets the <code>archivo</code> Struts FormFile field value.
     *
     * 
     */
    public org.apache.struts.upload.FormFile getArchivo();

    /**
     * Resets the <code>archivo</code> field.
     */
    public void resetArchivo();

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

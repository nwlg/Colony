// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar.local;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>agregar</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.agregar.local.AgregarLocalController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.agregar.local.AgregarLocalController#agregar
 */
public interface AgregarForm
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

}

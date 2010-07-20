// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.importar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>importarZIP</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.recursos.importar.ImportarRecursosController</code> controller.
 *
 * <p>
 * Valida los datos procedentes del formulario de importar recurso
 * local.
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.avanzado.recursos.importar.ImportarRecursosController#importarZIP
 */
public interface ImportarZIPForm
{
    /**
     * Sets the <code>fichero</code> Struts FormFile field to the specified value.
     *
     * <p>
     * Archivo ZIP subido desde el portal
     * </p>
     */
    public void setFichero(org.apache.struts.upload.FormFile fichero);


    /**
     * Gets the <code>fichero</code> Struts FormFile field value.
     *
     * <p>
     * Archivo ZIP subido desde el portal
     * </p>
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

// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar.archivos;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submitPrincipal</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController</code> controller.
 *
 * <p>
 * Comprueba que se ha elegido un archivo principal y, si el action
 * es Aceptar, lo almacena en el objeto de sesión.
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.basico.asociar.archivos.AsociacionArchivosController#submitPrincipal
 */
public interface SubmitPrincipalForm
{
    /**
     * Sets the <code>principal</code> field.
     *
     * 
     */
    public void setPrincipal(java.lang.String principal);

    /**
     * Gets the <code>principal</code> field.
     *
     * 
     */
    public java.lang.String getPrincipal();
    
    /**
     * Resets the <code>principal</code> field.
     */
    public void resetPrincipal();

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

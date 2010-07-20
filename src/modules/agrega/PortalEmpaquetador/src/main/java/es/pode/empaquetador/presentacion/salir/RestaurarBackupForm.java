// license-header java merge-point
package es.pode.empaquetador.presentacion.salir;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>restaurarBackup</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.salir.SalirController</code> controller.
 *
 * <p>
 * Si se sale sin guardar, no se va a poder recuperar el ODE
 * (limitacion de la fase I). Si no se guarda, el ODE debera
 * borrarse del espacio del usuario.
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.salir.SalirController#restaurarBackup
 */
public interface RestaurarBackupForm
{
    /**
     * Sets the <code>guardar</code> field.
     *
     * 
     */
    public void setGuardar(java.lang.String guardar);

    /**
     * Gets the <code>guardar</code> field.
     *
     * 
     */
    public java.lang.String getGuardar();
    
    /**
     * Resets the <code>guardar</code> field.
     */
    public void resetGuardar();

}

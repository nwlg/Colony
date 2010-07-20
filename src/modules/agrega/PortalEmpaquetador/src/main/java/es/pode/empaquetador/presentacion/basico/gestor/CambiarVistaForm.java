// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.gestor;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cambiarVista</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoController#cambiarVista
 */
public interface CambiarVistaForm
{
    /**
     * Sets the <code>vistaCarpeta</code> field.
     *
     * 
     */
    public void setVistaCarpeta(boolean vistaCarpeta);

    /**
     * Gets the <code>vistaCarpeta</code> field.
     *
     * 
     */
    public boolean isVistaCarpeta();
    
    /**
     * Resets the <code>vistaCarpeta</code> field.
     */
    public void resetVistaCarpeta();

}

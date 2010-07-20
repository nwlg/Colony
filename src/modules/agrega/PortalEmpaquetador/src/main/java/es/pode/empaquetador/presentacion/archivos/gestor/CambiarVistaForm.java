// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.gestor;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cambiarVista</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosController#cambiarVista
 */
public interface CambiarVistaForm
{
    /**
     * Sets the <code>vistaCarpeta</code> field.
     *
     * <p>
     * Permite alternar entre vista por arbol y vista por carpeta.
     * </p>
     */
    public void setVistaCarpeta(boolean vistaCarpeta);

    /**
     * Gets the <code>vistaCarpeta</code> field.
     *
     * <p>
     * Permite alternar entre vista por arbol y vista por carpeta.
     * </p>
     */
    public boolean isVistaCarpeta();
    
    /**
     * Resets the <code>vistaCarpeta</code> field.
     */
    public void resetVistaCarpeta();

}

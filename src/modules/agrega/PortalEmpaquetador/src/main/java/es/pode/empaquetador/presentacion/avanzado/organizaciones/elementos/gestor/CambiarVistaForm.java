// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cambiarVista</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor.GestorElementosController#cambiarVista
 */
public interface CambiarVistaForm
{
    /**
     * Sets the <code>vistaArbol</code> field.
     *
     * 
     */
    public void setVistaArbol(boolean vistaArbol);

    /**
     * Gets the <code>vistaArbol</code> field.
     *
     * 
     */
    public boolean isVistaArbol();
    
    /**
     * Resets the <code>vistaArbol</code> field.
     */
    public void resetVistaArbol();

}

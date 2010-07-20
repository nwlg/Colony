// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>analizaSeleccionEliminacion</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController</code> controller.
 *
 * <p>
 * Método que se encarga de comprobar que cuando se selecciona el
 * botón eliminar existe algún ode seleccionado.
 * </p>
 * <p>
 * Devuelve un String que indica si la acción seleccionada de
 * eliminar puede tener lugar o no.
 * </p>
 *
 * @see es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController#analizaSeleccionEliminacion
 */
public interface AnalizaSeleccionEliminacionForm
{
    /**
     * Sets the <code>eliminados</code> field.
     *
     * 
     */
    public void setEliminados(java.lang.String eliminados);

    /**
     * Gets the <code>eliminados</code> field.
     *
     * 
     */
    public java.lang.String getEliminados();
    
    /**
     * Resets the <code>eliminados</code> field.
     */
    public void resetEliminados();

}

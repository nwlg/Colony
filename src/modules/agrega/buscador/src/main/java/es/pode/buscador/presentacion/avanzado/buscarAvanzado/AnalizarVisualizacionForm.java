// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>analizarVisualizacion</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController</code> controller.
 *
 * <p>
 * Este método determina la pulsación que se ha realizado en el
 * formulario y envía al usuario a la página adecuada.
 * </p>
 * <p>
 * Devuelve un String con el tipo de visualización seleccionada
 * </p>
 *
 * @see es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController#analizarVisualizacion
 */
public interface AnalizarVisualizacionForm
{
    /**
     * Sets the <code>tipoVisualizacion</code> field.
     *
     * 
     */
    public void setTipoVisualizacion(java.lang.String tipoVisualizacion);

    /**
     * Gets the <code>tipoVisualizacion</code> field.
     *
     * 
     */
    public java.lang.String getTipoVisualizacion();
    
    /**
     * Resets the <code>tipoVisualizacion</code> field.
     */
    public void resetTipoVisualizacion();

}

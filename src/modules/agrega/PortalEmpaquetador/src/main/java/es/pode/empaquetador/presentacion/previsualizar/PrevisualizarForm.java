// license-header java merge-point
package es.pode.empaquetador.presentacion.previsualizar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>previsualizar</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.previsualizar.PrevisualizarController</code> controller.
 *
 * <p>
 * Los pasos que tiene que dar el metodo previsualizar son:
 * </p>
 * <p>
 * 1.- Guardar el ODE.
 * </p>
 * <p>
 * 2.-Llamar al servicio de Empaquetacion, que a su vez llamara a
 * entregar. El resultado sera un identificador String.
 * </p>
 * <p>
 * 3.-Redirigir la pagina al Visualizador pasandole el
 * identificador por GET. La URL del Visualizador estara almacenada
 * como un ContextParam del web.xml.
 * </p>
 *
 * @see es.pode.empaquetador.presentacion.previsualizar.PrevisualizarController#previsualizar
 */
public interface PrevisualizarForm
{
    /**
     * Sets the <code>tipoVisualizador</code> field.
     *
     * 
     */
    public void setTipoVisualizador(java.lang.String tipoVisualizador);

    /**
     * Gets the <code>tipoVisualizador</code> field.
     *
     * 
     */
    public java.lang.String getTipoVisualizador();
    
    /**
     * Resets the <code>tipoVisualizador</code> field.
     */
    public void resetTipoVisualizador();

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

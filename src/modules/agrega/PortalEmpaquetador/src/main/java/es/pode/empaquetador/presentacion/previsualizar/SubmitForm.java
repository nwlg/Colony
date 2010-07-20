// license-header java merge-point
package es.pode.empaquetador.presentacion.previsualizar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>submit</code> method, which is located on the
 * <code>es.pode.empaquetador.presentacion.previsualizar.PrevisualizarController</code> controller.
 *
 * 
 *
 * @see es.pode.empaquetador.presentacion.previsualizar.PrevisualizarController#submit
 */
public interface SubmitForm
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

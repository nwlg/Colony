// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>analizaPulsacion</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController</code> controller.
 *
 * <p>
 * En función de la pulsación de la pantalla de configuración se
 * elige alguna de las tres salidas posibles.
 * </p>
 * <p>
 * Devuelve un String con la pulsación
 * </p>
 *
 * @see es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController#analizaPulsacion
 */
public interface AnalizaPulsacionForm
{
    /**
     * Sets the <code>pulsacion</code> field.
     *
     * 
     */
    public void setPulsacion(java.lang.String pulsacion);

    /**
     * Gets the <code>pulsacion</code> field.
     *
     * 
     */
    public java.lang.String getPulsacion();
    
    /**
     * Resets the <code>pulsacion</code> field.
     */
    public void resetPulsacion();

}

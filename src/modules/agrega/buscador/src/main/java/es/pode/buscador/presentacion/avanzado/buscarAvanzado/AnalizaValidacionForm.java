// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>analizaValidacion</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController</code> controller.
 *
 * <p>
 * En función del valor del parametro validado, se decide en el
 * punto de decisión si se debe de recargar el formulario
 * mostrando un mensaje de aviso, o si se debe realizar la
 * búsqueda.
 * </p>
 * <p>
 * Devuelve si la validación es correcta o no
 * </p>
 *
 * @see es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoController#analizaValidacion
 */
public interface AnalizaValidacionForm
{
    /**
     * Sets the <code>validado</code> field.
     *
     * 
     */
    public void setValidado(java.lang.String validado);

    /**
     * Gets the <code>validado</code> field.
     *
     * 
     */
    public java.lang.String getValidado();
    
    /**
     * Resets the <code>validado</code> field.
     */
    public void resetValidado();

}

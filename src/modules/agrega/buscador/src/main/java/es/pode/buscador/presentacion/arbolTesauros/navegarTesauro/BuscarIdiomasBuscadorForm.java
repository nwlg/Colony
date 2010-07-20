// license-header java merge-point
package es.pode.buscador.presentacion.arbolTesauros.navegarTesauro;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>buscarIdiomasBuscador</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.NavegarTesauroController</code> controller.
 *
 * <p>
 * En esta actividad buscamos los idiomas que mostraremos en el
 * combo de busqueda del layout.
 * </p>
 *
 * @see es.pode.buscador.presentacion.arbolTesauros.navegarTesauro.NavegarTesauroController#buscarIdiomasBuscador
 */
public interface BuscarIdiomasBuscadorForm
{
    /**
     * Sets the <code>tipoBusquedaArbol</code> field.
     *
     * <p>
     * Determina si la búsqueda es federada o local.
     * </p>
     */
    public void setTipoBusquedaArbol(java.lang.String tipoBusquedaArbol);

    /**
     * Gets the <code>tipoBusquedaArbol</code> field.
     *
     * <p>
     * Determina si la búsqueda es federada o local.
     * </p>
     */
    public java.lang.String getTipoBusquedaArbol();
    
    /**
     * Resets the <code>tipoBusquedaArbol</code> field.
     */
    public void resetTipoBusquedaArbol();

    /**
     * Sets the <code>tipoLayoutBuscador</code> field.
     *
     * <p>
     * Indica el tipo de layout que se debe aplicar a la página.
     * Buscador, buscadorEmpaquetador o federado
     * </p>
     */
    public void setTipoLayoutBuscador(java.lang.String tipoLayoutBuscador);

    /**
     * Gets the <code>tipoLayoutBuscador</code> field.
     *
     * <p>
     * Indica el tipo de layout que se debe aplicar a la página.
     * Buscador, buscadorEmpaquetador o federado
     * </p>
     */
    public java.lang.String getTipoLayoutBuscador();
    
    /**
     * Resets the <code>tipoLayoutBuscador</code> field.
     */
    public void resetTipoLayoutBuscador();

}

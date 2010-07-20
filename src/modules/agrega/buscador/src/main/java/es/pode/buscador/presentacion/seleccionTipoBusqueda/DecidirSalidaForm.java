// license-header java merge-point
package es.pode.buscador.presentacion.seleccionTipoBusqueda;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>decidirSalida</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.seleccionTipoBusqueda.seleccionTipoBusquedaController</code> controller.
 *
 * <p>
 * Método que controla el tipo de búsqueda que se va a realizar.
 * Tanto si va a ser por tesauro o por árbol curricular, como si
 * va a tener lugar en el nodo local o va a ser federada (Todo
 * Agrega). Devuelve si el tipo de búsqueda va a ser por arbol o
 * por tesauro
 * </p>
 *
 * @see es.pode.buscador.presentacion.seleccionTipoBusqueda.seleccionTipoBusquedaController#decidirSalida
 */
public interface DecidirSalidaForm
{
    /**
     * Sets the <code>tipoNavegacion</code> field.
     *
     * 
     */
    public void setTipoNavegacion(java.lang.String tipoNavegacion);

    /**
     * Gets the <code>tipoNavegacion</code> field.
     *
     * 
     */
    public java.lang.String getTipoNavegacion();
    
    /**
     * Resets the <code>tipoNavegacion</code> field.
     */
    public void resetTipoNavegacion();

    /**
     * Sets the <code>tituloTesauro</code> field.
     *
     * 
     */
    public void setTituloTesauro(java.lang.String tituloTesauro);

    /**
     * Gets the <code>tituloTesauro</code> field.
     *
     * 
     */
    public java.lang.String getTituloTesauro();
    
    /**
     * Resets the <code>tituloTesauro</code> field.
     */
    public void resetTituloTesauro();

    /**
     * Sets the <code>tipoBusquedaArbol</code> field.
     *
     * 
     */
    public void setTipoBusquedaArbol(java.lang.String tipoBusquedaArbol);

    /**
     * Gets the <code>tipoBusquedaArbol</code> field.
     *
     * 
     */
    public java.lang.String getTipoBusquedaArbol();
    
    /**
     * Resets the <code>tipoBusquedaArbol</code> field.
     */
    public void resetTipoBusquedaArbol();

    /**
     * Sets the <code>tipoLayoutBuscador</code> field.
     *
     * 
     */
    public void setTipoLayoutBuscador(java.lang.String tipoLayoutBuscador);

    /**
     * Gets the <code>tipoLayoutBuscador</code> field.
     *
     * 
     */
    public java.lang.String getTipoLayoutBuscador();
    
    /**
     * Resets the <code>tipoLayoutBuscador</code> field.
     */
    public void resetTipoLayoutBuscador();

}

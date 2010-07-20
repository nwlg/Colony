// license-header java merge-point
package es.pode.buscador.presentacion.arbolCurricular.navegarArbolCurricular;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>buscarIdiomasBuscador</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.arbolCurricular.navegarArbolCurricular.NavegarArbolCurricularController</code> controller.
 *
 * <p>
 * En esta actividad buscamos los idiomas que mostraremos en el
 * combo de busqueda del layout.
 * </p>
 *
 * @see es.pode.buscador.presentacion.arbolCurricular.navegarArbolCurricular.NavegarArbolCurricularController#buscarIdiomasBuscador
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
     * Buscador, buscadorEmpaquetador o federado.
     * </p>
     */
    public void setTipoLayoutBuscador(java.lang.String tipoLayoutBuscador);

    /**
     * Gets the <code>tipoLayoutBuscador</code> field.
     *
     * <p>
     * Indica el tipo de layout que se debe aplicar a la página.
     * Buscador, buscadorEmpaquetador o federado.
     * </p>
     */
    public java.lang.String getTipoLayoutBuscador();
    
    /**
     * Resets the <code>tipoLayoutBuscador</code> field.
     */
    public void resetTipoLayoutBuscador();

    /**
     * Sets the <code>tipoBusqueda</code> field.
     *
     * <p>
     * Contiene el identificador de búsqueda local o federada.
     * </p>
     */
    public void setTipoBusqueda(java.lang.String tipoBusqueda);

    /**
     * Gets the <code>tipoBusqueda</code> field.
     *
     * <p>
     * Contiene el identificador de búsqueda local o federada.
     * </p>
     */
    public java.lang.String getTipoBusqueda();
    
    /**
     * Resets the <code>tipoBusqueda</code> field.
     */
    public void resetTipoBusqueda();

    /**
     * Sets the <code>idiomaBuscador</code> field.
     *
     * <p>
     * Idioma seleccionable del combo para realizar la búsqueda.
     * </p>
     */
    public void setIdiomaBuscador(java.lang.String idiomaBuscador);

    /**
     * Gets the <code>idiomaBuscador</code> field.
     *
     * <p>
     * Idioma seleccionable del combo para realizar la búsqueda.
     * </p>
     */
    public java.lang.String getIdiomaBuscador();
    
    /**
     * Resets the <code>idiomaBuscador</code> field.
     */
    public void resetIdiomaBuscador();

}

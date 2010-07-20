// license-header java merge-point
package es.pode.buscador.presentacion.seleccionTipoBusqueda;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>prepararConsulta</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.seleccionTipoBusqueda.seleccionTipoBusquedaController</code> controller.
 *
 * <p>
 * Esta acción inicializa el formulario de seleccionar el tipo de
 * búsqueda con unos valores por defecto que son la búsqueda
 * federada en “Todo Agrega�? y la búsqueda por “�?rbol
 * Curricular�?.
 * </p>
 *
 * @see es.pode.buscador.presentacion.seleccionTipoBusqueda.seleccionTipoBusquedaController#prepararConsulta
 */
public interface PrepararConsultaForm
{
    /**
     * Sets the <code>mostrarAmbito</code> field.
     *
     * 
     */
    public void setMostrarAmbito(java.lang.Boolean mostrarAmbito);

    /**
     * Gets the <code>mostrarAmbito</code> field.
     *
     * 
     */
    public java.lang.Boolean getMostrarAmbito();
    
    /**
     * Resets the <code>mostrarAmbito</code> field.
     */
    public void resetMostrarAmbito();

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

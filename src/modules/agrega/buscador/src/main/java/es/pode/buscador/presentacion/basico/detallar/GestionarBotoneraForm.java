// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>gestionarBotonera</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.detallar.DetallarController</code> controller.
 *
 * <p>
 * Este método gestiona los botones que deben aparecer en cada
 * momento en la ficha del ODE.
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#gestionarBotonera
 */
public interface GestionarBotoneraForm
{
    /**
     * Sets the <code>resultados</code> field.
     *
     * 
     */
    public void setResultados(es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaVO resultados);

    /**
     * Gets the <code>resultados</code> field.
     *
     * 
     */
    public es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaVO getResultados();
    
    /**
     * Resets the <code>resultados</code> field.
     */
    public void resetResultados();

    /**
     * Sets the <code>posicionamientoAnterior</code> field.
     *
     * 
     */
    public void setPosicionamientoAnterior(java.lang.String posicionamientoAnterior);

    /**
     * Gets the <code>posicionamientoAnterior</code> field.
     *
     * 
     */
    public java.lang.String getPosicionamientoAnterior();
    
    /**
     * Resets the <code>posicionamientoAnterior</code> field.
     */
    public void resetPosicionamientoAnterior();

    /**
     * Sets the <code>nodoDestino</code> field.
     *
     * 
     */
    public void setNodoDestino(java.lang.String nodoDestino);

    /**
     * Gets the <code>nodoDestino</code> field.
     *
     * 
     */
    public java.lang.String getNodoDestino();
    
    /**
     * Resets the <code>nodoDestino</code> field.
     */
    public void resetNodoDestino();

    /**
     * Sets the <code>identificadorODE</code> field.
     *
     * 
     */
    public void setIdentificadorODE(java.lang.String identificadorODE);

    /**
     * Gets the <code>identificadorODE</code> field.
     *
     * 
     */
    public java.lang.String getIdentificadorODE();
    
    /**
     * Resets the <code>identificadorODE</code> field.
     */
    public void resetIdentificadorODE();

    /**
     * Sets the <code>posicionamientoSiguiente</code> field.
     *
     * 
     */
    public void setPosicionamientoSiguiente(java.lang.String posicionamientoSiguiente);

    /**
     * Gets the <code>posicionamientoSiguiente</code> field.
     *
     * 
     */
    public java.lang.String getPosicionamientoSiguiente();
    
    /**
     * Resets the <code>posicionamientoSiguiente</code> field.
     */
    public void resetPosicionamientoSiguiente();

}

// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>analizaPosicionamiento</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.detallar.DetallarController</code> controller.
 *
 * <p>
 * Este método redirecciona al servidor en el que reside el ODE
 * del que se va a mostrar el detalle.
 * </p>
 * <p>
 * El valor que devuelve indica si se va a mostrar el detalle de un
 * ode federado o local
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#analizaPosicionamiento
 */
public interface AnalizaPosicionamientoForm
{
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
     * Sets the <code>idioma</code> field.
     *
     * 
     */
    public void setIdioma(java.lang.String idioma);

    /**
     * Gets the <code>idioma</code> field.
     *
     * 
     */
    public java.lang.String getIdioma();
    
    /**
     * Resets the <code>idioma</code> field.
     */
    public void resetIdioma();

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

// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>analizaEntrada</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.detallar.DetallarController</code> controller.
 *
 * <p>
 * Analiza si se entra desde el servidor local o desde el detalle
 * de un ode federado.
 * </p>
 * <p>
 * Devuelve el valor del lugar desde el que se realiza la entrada
 * al detalle (Detalle federado, Detalle local, con/sin
 * posicionamiento).
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#analizaEntrada
 */
public interface AnalizaEntradaForm
{
    /**
     * Sets the <code>identificadorODEFederado</code> field.
     *
     * 
     */
    public void setIdentificadorODEFederado(java.lang.String identificadorODEFederado);

    /**
     * Gets the <code>identificadorODEFederado</code> field.
     *
     * 
     */
    public java.lang.String getIdentificadorODEFederado();
    
    /**
     * Resets the <code>identificadorODEFederado</code> field.
     */
    public void resetIdentificadorODEFederado();

    /**
     * Sets the <code>nodoOrigen</code> field.
     *
     * 
     */
    public void setNodoOrigen(java.lang.String nodoOrigen);

    /**
     * Gets the <code>nodoOrigen</code> field.
     *
     * 
     */
    public java.lang.String getNodoOrigen();
    
    /**
     * Resets the <code>nodoOrigen</code> field.
     */
    public void resetNodoOrigen();

    /**
     * Sets the <code>posicionamiento</code> field.
     *
     * 
     */
    public void setPosicionamiento(java.lang.String posicionamiento);

    /**
     * Gets the <code>posicionamiento</code> field.
     *
     * 
     */
    public java.lang.String getPosicionamiento();
    
    /**
     * Resets the <code>posicionamiento</code> field.
     */
    public void resetPosicionamiento();

    /**
     * Sets the <code>urlEntregar</code> field.
     *
     * 
     */
    public void setUrlEntregar(java.lang.String urlEntregar);

    /**
     * Gets the <code>urlEntregar</code> field.
     *
     * 
     */
    public java.lang.String getUrlEntregar();
    
    /**
     * Resets the <code>urlEntregar</code> field.
     */
    public void resetUrlEntregar();

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

}

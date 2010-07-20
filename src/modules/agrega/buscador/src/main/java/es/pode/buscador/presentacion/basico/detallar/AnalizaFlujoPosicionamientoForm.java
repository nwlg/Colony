// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>analizaFlujoPosicionamiento</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.detallar.DetallarController</code> controller.
 *
 * <p>
 * Este método analiza si se va a mostrar el detalle de un ode
 * residente en el servidor local o en uno federado.
 * </p>
 * <p>
 * El valor que devuelve indica si se va a mostrar un ode federado
 * o local
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#analizaFlujoPosicionamiento
 */
public interface AnalizaFlujoPosicionamientoForm
{
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

}

// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>agregarODEFederado</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.detallar.DetallarController</code> controller.
 *
 * <p>
 * Solicita a entregar de un nodo federado un ODE que se enviará a
 * el empaquetador local
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#agregarODEFederado
 */
public interface AgregarODEFederadoForm
{
    /**
     * Sets the <code>titulo</code> field.
     *
     * 
     */
    public void setTitulo(java.lang.String titulo);

    /**
     * Gets the <code>titulo</code> field.
     *
     * 
     */
    public java.lang.String getTitulo();
    
    /**
     * Resets the <code>titulo</code> field.
     */
    public void resetTitulo();

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
     * Sets the <code>agregacionCorrecta</code> field.
     *
     * 
     */
    public void setAgregacionCorrecta(java.lang.Boolean agregacionCorrecta);

    /**
     * Gets the <code>agregacionCorrecta</code> field.
     *
     * 
     */
    public java.lang.Boolean getAgregacionCorrecta();
    
    /**
     * Resets the <code>agregacionCorrecta</code> field.
     */
    public void resetAgregacionCorrecta();

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

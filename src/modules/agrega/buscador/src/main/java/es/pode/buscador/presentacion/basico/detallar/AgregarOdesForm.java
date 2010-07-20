// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>agregarOdes</code> method, which is located on the
 * <code>es.pode.buscador.presentacion.basico.detallar.DetallarController</code> controller.
 *
 * <p>
 * Envía al empaquetador el identificador del ODE que se
 * agregará.
 * </p>
 *
 * @see es.pode.buscador.presentacion.basico.detallar.DetallarController#agregarOdes
 */
public interface AgregarOdesForm
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
     * Sets the <code>tipoAgregacion</code> field.
     *
     * 
     */
    public void setTipoAgregacion(java.lang.String tipoAgregacion);

    /**
     * Gets the <code>tipoAgregacion</code> field.
     *
     * 
     */
    public java.lang.String getTipoAgregacion();
    
    /**
     * Resets the <code>tipoAgregacion</code> field.
     */
    public void resetTipoAgregacion();

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

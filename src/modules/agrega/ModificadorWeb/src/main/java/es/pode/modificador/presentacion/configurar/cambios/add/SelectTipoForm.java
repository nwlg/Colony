// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.add;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>selectTipo</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.configurar.cambios.add.TipoAnadirController</code> controller.
 *
 * <p>
 * Ojo! Guarda tipo en sesión
 * </p>
 *
 * @see es.pode.modificador.presentacion.configurar.cambios.add.TipoAnadirController#selectTipo
 */
public interface SelectTipoForm
{
    /**
     * Sets the <code>alcance</code> field.
     *
     * 
     */
    public void setAlcance(java.lang.Boolean alcance);

    /**
     * Gets the <code>alcance</code> field.
     *
     * 
     */
    public java.lang.Boolean getAlcance();
    
    /**
     * Resets the <code>alcance</code> field.
     */
    public void resetAlcance();

    /**
     * Sets the <code>tipoAniadir</code> field.
     *
     * 
     */
    public void setTipoAniadir(java.lang.String tipoAniadir);

    /**
     * Gets the <code>tipoAniadir</code> field.
     *
     * 
     */
    public java.lang.String getTipoAniadir();
    
    /**
     * Resets the <code>tipoAniadir</code> field.
     */
    public void resetTipoAniadir();

    /**
     * Sets the <code>idTermino</code> field.
     *
     * 
     */
    public void setIdTermino(java.lang.String idTermino);

    /**
     * Gets the <code>idTermino</code> field.
     *
     * 
     */
    public java.lang.String getIdTermino();
    
    /**
     * Resets the <code>idTermino</code> field.
     */
    public void resetIdTermino();

}

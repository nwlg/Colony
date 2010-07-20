// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>selectAction</code> method, which is located on the
 * <code>es.pode.modificador.presentacion.configurar.cambios.ConfigurarCambiosController</code> controller.
 *
 * <p>
 * Guarda selección de tipo en sesión
 * </p>
 *
 * @see es.pode.modificador.presentacion.configurar.cambios.ConfigurarCambiosController#selectAction
 */
public interface SelectActionForm
{
    /**
     * Sets the <code>action</code> field.
     *
     * 
     */
    public void setAction(java.lang.String action);

    /**
     * Gets the <code>action</code> field.
     *
     * 
     */
    public java.lang.String getAction();
    
    /**
     * Resets the <code>action</code> field.
     */
    public void resetAction();

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

    /**
     * Sets the <code>option</code> field.
     *
     * 
     */
    public void setOption(java.lang.String option);

    /**
     * Gets the <code>option</code> field.
     *
     * 
     */
    public java.lang.String getOption();
    
    /**
     * Resets the <code>option</code> field.
     */
    public void resetOption();

}

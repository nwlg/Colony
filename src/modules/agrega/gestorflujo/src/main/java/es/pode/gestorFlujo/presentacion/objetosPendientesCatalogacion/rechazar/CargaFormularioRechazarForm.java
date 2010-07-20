// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargaFormularioRechazar</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar.rechazarPendCatalogacionController</code> controller.
 *
 * <p>
 * Carga los datos necesarios para la pantalla de rechazar un ODE.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar.rechazarPendCatalogacionController#cargaFormularioRechazar
 */
public interface CargaFormularioRechazarForm
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
     * Sets the <code>idUsuario</code> field.
     *
     * 
     */
    public void setIdUsuario(java.lang.String idUsuario);

    /**
     * Gets the <code>idUsuario</code> field.
     *
     * 
     */
    public java.lang.String getIdUsuario();
    
    /**
     * Resets the <code>idUsuario</code> field.
     */
    public void resetIdUsuario();

    /**
     * Sets the <code>idODE</code> field.
     *
     * 
     */
    public void setIdODE(java.lang.String idODE);

    /**
     * Gets the <code>idODE</code> field.
     *
     * 
     */
    public java.lang.String getIdODE();
    
    /**
     * Resets the <code>idODE</code> field.
     */
    public void resetIdODE();

}

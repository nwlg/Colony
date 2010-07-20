// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargaFormularioProponerCatalogacion</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion.ProponerCatalogacionController</code> controller.
 *
 * <p>
 * Este metodo carga todo lo necesario en el formulario de la
 * pantalla de proponer ode para su catalogacion.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion.ProponerCatalogacionController#cargaFormularioProponerCatalogacion
 */
public interface CargaFormularioProponerCatalogacionForm
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

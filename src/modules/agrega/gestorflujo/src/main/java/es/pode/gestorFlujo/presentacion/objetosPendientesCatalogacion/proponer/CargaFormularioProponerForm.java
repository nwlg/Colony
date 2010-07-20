// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargaFormularioProponer</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer.ProponerController</code> controller.
 *
 * <p>
 * Este metodo carga todo lo necesario en el formulario de la
 * pantalla de proponer.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer.ProponerController#cargaFormularioProponer
 */
public interface CargaFormularioProponerForm
{
    /**
     * Sets the <code>titulo</code> field.
     *
     * <p>
     * Titulo del ODE.
     * </p>
     */
    public void setTitulo(java.lang.String titulo);

    /**
     * Gets the <code>titulo</code> field.
     *
     * <p>
     * Titulo del ODE.
     * </p>
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
     * <p>
     * Identificador alfanumerico del ODE.
     * </p>
     */
    public void setIdODE(java.lang.String idODE);

    /**
     * Gets the <code>idODE</code> field.
     *
     * <p>
     * Identificador alfanumerico del ODE.
     * </p>
     */
    public java.lang.String getIdODE();
    
    /**
     * Resets the <code>idODE</code> field.
     */
    public void resetIdODE();

}

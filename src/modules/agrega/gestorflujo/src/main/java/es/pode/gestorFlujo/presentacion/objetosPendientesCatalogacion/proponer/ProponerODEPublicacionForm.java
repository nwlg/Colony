// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>proponerODEPublicacion</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer.ProponerController</code> controller.
 *
 * <p>
 * Este metodo propone para publicacion un ODE determinado. Se
 * valida el ODE antes de pasarlo a propuesto.
 * </p>
 * <p>
 * Si la proposicion a publicacion se realiza correctamente.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.proponer.ProponerController#proponerODEPublicacion
 */
public interface ProponerODEPublicacionForm
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
     * Sets the <code>mensajes</code> field.
     *
     * 
     */
    public void setMensajes(java.lang.String[] mensajes);

    /**
     * Gets the <code>mensajes</code> field.
     *
     * 
     */
    public java.lang.String[] getMensajes();
    
    /**
     * Resets the <code>mensajes</code> field.
     */
    public void resetMensajes();

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

    /**
     * Sets the <code>comentarios</code> field.
     *
     * 
     */
    public void setComentarios(java.lang.String comentarios);

    /**
     * Gets the <code>comentarios</code> field.
     *
     * 
     */
    public java.lang.String getComentarios();
    
    /**
     * Resets the <code>comentarios</code> field.
     */
    public void resetComentarios();

}

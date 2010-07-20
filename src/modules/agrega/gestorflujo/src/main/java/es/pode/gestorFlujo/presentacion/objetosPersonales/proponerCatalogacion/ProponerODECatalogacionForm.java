// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>proponerODECatalogacion</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion.ProponerCatalogacionController</code> controller.
 *
 * <p>
 * Este metodo propone para catalogacion un ODE determinado. Se
 * valida el ODE antes de pasarlo a propuesto para catalogacion.
 * </p>
 * <p>
 * Si todo sale correctamente el ode queda propuesto para
 * catalogación.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPersonales.proponerCatalogacion.ProponerCatalogacionController#proponerODECatalogacion
 */
public interface ProponerODECatalogacionForm
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
     * Sets the <code>mensajes</code> field.
     *
     * <p>
     * Los mensajes de erro que nos pueden llegar
     * </p>
     */
    public void setMensajes(java.lang.String[] mensajes);

    /**
     * Gets the <code>mensajes</code> field.
     *
     * <p>
     * Los mensajes de erro que nos pueden llegar
     * </p>
     */
    public java.lang.String[] getMensajes();
    
    /**
     * Resets the <code>mensajes</code> field.
     */
    public void resetMensajes();

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

    /**
     * Sets the <code>seleccion</code> field.
     *
     * <p>
     * Para que acepte las condiciones legales
     * </p>
     */
    public void setSeleccion(java.lang.String seleccion);

    /**
     * Gets the <code>seleccion</code> field.
     *
     * <p>
     * Para que acepte las condiciones legales
     * </p>
     */
    public java.lang.String getSeleccion();
    
    /**
     * Resets the <code>seleccion</code> field.
     */
    public void resetSeleccion();

}

// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>rechazarODE</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar.rechazarPendCatalogacionController</code> controller.
 *
 * <p>
 * Se realiza una validacion cargaODE(fuerte), si la pasa el ODe se
 * publica: se le dara un mec y se indexara, con lo que se podra
 * buscar desde el portal.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPendientesCatalogacion.rechazar.rechazarPendCatalogacionController#rechazarODE
 */
public interface RechazarODEForm
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

}

// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>publicarODE</code> method, which is located on the
 * <code>es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarController</code> controller.
 *
 * <p>
 * Se realiza una validacion cargaODE(fuerte), si la pasa el ODe se
 * publica: se le dara un mec y se indexara, con lo que se podra
 * buscar desde el portal.
 * </p>
 *
 * @see es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar.PublicarController#publicarODE
 */
public interface PublicarODEForm
{
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

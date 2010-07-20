// license-header java merge-point
package es.pode.presentacion.contenidoInapropiado;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>enviarMensaje</code> method, which is located on the
 * <code>es.pode.presentacion.contenidoInapropiado.ContenidoInapropiadoController</code> controller.
 *
 * 
 *
 * @see es.pode.presentacion.contenidoInapropiado.ContenidoInapropiadoController#enviarMensaje
 */
public interface EnviarMensajeForm
{
    /**
     * Sets the <code>comentario</code> field.
     *
     * 
     */
    public void setComentario(java.lang.String comentario);

    /**
     * Gets the <code>comentario</code> field.
     *
     * 
     */
    public java.lang.String getComentario();
    
    /**
     * Resets the <code>comentario</code> field.
     */
    public void resetComentario();

}

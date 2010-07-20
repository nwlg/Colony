// license-header java merge-point
package es.pode.tagging.presentacion.inicioTagging;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>estaAutenticado</code> method, which is located on the
 * <code>es.pode.tagging.presentacion.inicioTagging.InicioTaggingController</code> controller.
 *
 * 
 *
 * @see es.pode.tagging.presentacion.inicioTagging.InicioTaggingController#estaAutenticado
 */
public interface EstaAutenticadoForm
{
    /**
     * Sets the <code>usuario</code> field.
     *
     * 
     */
    public void setUsuario(java.lang.String usuario);

    /**
     * Gets the <code>usuario</code> field.
     *
     * 
     */
    public java.lang.String getUsuario();
    
    /**
     * Resets the <code>usuario</code> field.
     */
    public void resetUsuario();

}

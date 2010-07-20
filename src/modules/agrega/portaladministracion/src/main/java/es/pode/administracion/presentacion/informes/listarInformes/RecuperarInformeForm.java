// license-header java merge-point
package es.pode.administracion.presentacion.informes.listarInformes;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>recuperarInforme</code> method, which is located on the
 * <code>es.pode.administracion.presentacion.informes.listarInformes.ListarInformesController</code> controller.
 *
 * 
 *
 * @see es.pode.administracion.presentacion.informes.listarInformes.ListarInformesController#recuperarInforme
 */
public interface RecuperarInformeForm
{
    /**
     * Sets the <code>nombre</code> field.
     *
     * 
     */
    public void setNombre(java.lang.String nombre);

    /**
     * Gets the <code>nombre</code> field.
     *
     * 
     */
    public java.lang.String getNombre();
    
    /**
     * Resets the <code>nombre</code> field.
     */
    public void resetNombre();

}

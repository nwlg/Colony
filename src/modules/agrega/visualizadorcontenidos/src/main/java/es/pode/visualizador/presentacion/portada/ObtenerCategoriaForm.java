// license-header java merge-point
package es.pode.visualizador.presentacion.portada;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerCategoria</code> method, which is located on the
 * <code>es.pode.visualizador.presentacion.portada.PortadaController</code> controller.
 *
 * 
 *
 * @see es.pode.visualizador.presentacion.portada.PortadaController#obtenerCategoria
 */
public interface ObtenerCategoriaForm
{
    /**
     * Sets the <code>idCategoria</code> field.
     *
     * 
     */
    public void setIdCategoria(java.lang.Long idCategoria);

    /**
     * Gets the <code>idCategoria</code> field.
     *
     * 
     */
    public java.lang.Long getIdCategoria();
    
    /**
     * Resets the <code>idCategoria</code> field.
     */
    public void resetIdCategoria();

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

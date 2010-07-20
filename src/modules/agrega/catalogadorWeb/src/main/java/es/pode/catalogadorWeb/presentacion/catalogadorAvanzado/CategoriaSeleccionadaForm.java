// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorAvanzado;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>categoriaSeleccionada</code> method, which is located on the
 * <code>es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CatAvanzadoController</code> controller.
 *
 * 
 *
 * @see es.pode.catalogadorWeb.presentacion.catalogadorAvanzado.CatAvanzadoController#categoriaSeleccionada
 */
public interface CategoriaSeleccionadaForm
{
    /**
     * Sets the <code>categoria</code> field.
     *
     * 
     */
    public void setCategoria(java.lang.String categoria);

    /**
     * Gets the <code>categoria</code> field.
     *
     * 
     */
    public java.lang.String getCategoria();
    
    /**
     * Resets the <code>categoria</code> field.
     */
    public void resetCategoria();

}

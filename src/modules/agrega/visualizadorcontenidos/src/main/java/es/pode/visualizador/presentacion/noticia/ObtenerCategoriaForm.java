// license-header java merge-point
package es.pode.visualizador.presentacion.noticia;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerCategoria</code> method, which is located on the
 * <code>es.pode.visualizador.presentacion.noticia.NoticiaController</code> controller.
 *
 * 
 *
 * @see es.pode.visualizador.presentacion.noticia.NoticiaController#obtenerCategoria
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
     * Sets the <code>categoriaVO</code> field.
     *
     * 
     */
    public void setCategoriaVO(es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO categoriaVO);

    /**
     * Gets the <code>categoriaVO</code> field.
     *
     * 
     */
    public es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO getCategoriaVO();
    
    /**
     * Resets the <code>categoriaVO</code> field.
     */
    public void resetCategoriaVO();

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

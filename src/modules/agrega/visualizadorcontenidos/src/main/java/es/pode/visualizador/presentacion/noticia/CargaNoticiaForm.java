// license-header java merge-point
package es.pode.visualizador.presentacion.noticia;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>cargaNoticia</code> method, which is located on the
 * <code>es.pode.visualizador.presentacion.noticia.NoticiaController</code> controller.
 *
 * 
 *
 * @see es.pode.visualizador.presentacion.noticia.NoticiaController#cargaNoticia
 */
public interface CargaNoticiaForm
{
    /**
     * Sets the <code>id</code> field.
     *
     * 
     */
    public void setId(java.lang.Long id);

    /**
     * Gets the <code>id</code> field.
     *
     * 
     */
    public java.lang.Long getId();
    
    /**
     * Resets the <code>id</code> field.
     */
    public void resetId();

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

    /**
     * Sets the <code>noticiavo</code> field.
     *
     * 
     */
    public void setNoticiavo(es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO noticiavo);

    /**
     * Gets the <code>noticiavo</code> field.
     *
     * 
     */
    public es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO getNoticiavo();
    
    /**
     * Resets the <code>noticiavo</code> field.
     */
    public void resetNoticiavo();

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
     * Sets the <code>nombreCategoriaCodex</code> field.
     *
     * 
     */
    public void setNombreCategoriaCodex(java.lang.String nombreCategoriaCodex);

    /**
     * Gets the <code>nombreCategoriaCodex</code> field.
     *
     * 
     */
    public java.lang.String getNombreCategoriaCodex();
    
    /**
     * Resets the <code>nombreCategoriaCodex</code> field.
     */
    public void resetNombreCategoriaCodex();

    /**
     * Sets the <code>alineamientoImg</code> field.
     *
     * 
     */
    public void setAlineamientoImg(java.lang.Integer alineamientoImg);

    /**
     * Gets the <code>alineamientoImg</code> field.
     *
     * 
     */
    public java.lang.Integer getAlineamientoImg();
    
    /**
     * Resets the <code>alineamientoImg</code> field.
     */
    public void resetAlineamientoImg();

    /**
     * Sets the <code>cuerpo</code> field.
     *
     * 
     */
    public void setCuerpo(java.lang.String cuerpo);

    /**
     * Gets the <code>cuerpo</code> field.
     *
     * 
     */
    public java.lang.String getCuerpo();
    
    /**
     * Resets the <code>cuerpo</code> field.
     */
    public void resetCuerpo();

    /**
     * Sets the <code>resumen</code> field.
     *
     * 
     */
    public void setResumen(java.lang.String resumen);

    /**
     * Gets the <code>resumen</code> field.
     *
     * 
     */
    public java.lang.String getResumen();
    
    /**
     * Resets the <code>resumen</code> field.
     */
    public void resetResumen();

    /**
     * Sets the <code>URLImagen</code> field.
     *
     * 
     */
    public void setURLImagen(java.lang.String URLImagen);

    /**
     * Gets the <code>URLImagen</code> field.
     *
     * 
     */
    public java.lang.String getURLImagen();
    
    /**
     * Resets the <code>URLImagen</code> field.
     */
    public void resetURLImagen();

}

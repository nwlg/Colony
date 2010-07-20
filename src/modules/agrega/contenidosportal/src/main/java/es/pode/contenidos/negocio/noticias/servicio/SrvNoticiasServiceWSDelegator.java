// license-header java merge-point
package es.pode.contenidos.negocio.noticias.servicio;

/**
 * Web service delegator for {@link es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService}.
 *
 * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService
 */
public class SrvNoticiasServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService}
     */
    private final es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService getSrvNoticiasService()
    {
        return es.pode.contenidos.negocio.ServiceLocator.instance().getSrvNoticiasService();
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#crearNoticia(es.pode.contenidos.negocio.noticias.servicio.NoticiaVO)
     */
    public java.lang.Long crearNoticia(es.pode.contenidos.negocio.noticias.servicio.NoticiaVO noticia)
    {
        return getSrvNoticiasService().crearNoticia(noticia);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#modificarNoticia(es.pode.contenidos.negocio.noticias.servicio.NoticiaVO)
     */
    public void modificarNoticia(es.pode.contenidos.negocio.noticias.servicio.NoticiaVO noticia)
    {
        getSrvNoticiasService().modificarNoticia(noticia);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#obtenerNoticias()
     */
    public es.pode.contenidos.negocio.noticias.servicio.NoticiaVO[] obtenerNoticias()
    {
        return getSrvNoticiasService().obtenerNoticias();
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#obtenerNoticia(java.lang.Long)
     */
    public es.pode.contenidos.negocio.noticias.servicio.NoticiaVO obtenerNoticia(java.lang.Long id)
    {
        return getSrvNoticiasService().obtenerNoticia(id);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#eliminarNoticia(java.lang.Long)
     */
    public void eliminarNoticia(java.lang.Long id)
    {
        getSrvNoticiasService().eliminarNoticia(id);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#obtenerCategoria(java.lang.Long)
     */
    public es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO obtenerCategoria(java.lang.Long id)
    {
        return getSrvNoticiasService().obtenerCategoria(id);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#obtenerCategorias()
     */
    public es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO[] obtenerCategorias()
    {
        return getSrvNoticiasService().obtenerCategorias();
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#eliminarNoticias(java.lang.Long[])
     */
    public void eliminarNoticias(java.lang.Long[] idList)
    {
        getSrvNoticiasService().eliminarNoticias(idList);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#obtenerNoticiasActivasPorIdiomayCategoria(java.lang.String, java.lang.Long)
     */
    public es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO[] obtenerNoticiasActivasPorIdiomayCategoria(java.lang.String idioma, java.lang.Long id)
    {
        return getSrvNoticiasService().obtenerNoticiasActivasPorIdiomayCategoria(idioma, id);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#almacenarImagenNoticia(es.pode.contenidos.negocio.noticias.servicio.ImagenVO)
     */
    public java.lang.String almacenarImagenNoticia(es.pode.contenidos.negocio.noticias.servicio.ImagenVO imagen)
    {
        return getSrvNoticiasService().almacenarImagenNoticia(imagen);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#listarNoticiasActivasPorIdioma(java.lang.String)
     */
    public es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO[] listarNoticiasActivasPorIdioma(java.lang.String idioma)
    {
        return getSrvNoticiasService().listarNoticiasActivasPorIdioma(idioma);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#obtenerNoticiasActivas(java.lang.Integer)
     */
    public es.pode.contenidos.negocio.noticias.servicio.NoticiaVO[] obtenerNoticiasActivas(java.lang.Integer numResultados)
    {
        return getSrvNoticiasService().obtenerNoticiasActivas(numResultados);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#crearCategoria(es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO)
     */
    public java.lang.Long crearCategoria(es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO categoria)
    {
        return getSrvNoticiasService().crearCategoria(categoria);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#eliminarCategoria(java.lang.Long)
     */
    public void eliminarCategoria(java.lang.Long id)
    {
        getSrvNoticiasService().eliminarCategoria(id);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#eliminarCategorias(java.lang.Long[])
     */
    public void eliminarCategorias(java.lang.Long[] idList)
    {
        getSrvNoticiasService().eliminarCategorias(idList);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#modificarCategoria(es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO)
     */
    public void modificarCategoria(es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaVO categoria)
    {
        getSrvNoticiasService().modificarCategoria(categoria);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#limpiarCategoria(java.lang.Long)
     */
    public void limpiarCategoria(java.lang.Long id)
    {
        getSrvNoticiasService().limpiarCategoria(id);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#limpiarNoticia(java.lang.Long)
     */
    public void limpiarNoticia(java.lang.Long id)
    {
        getSrvNoticiasService().limpiarNoticia(id);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#obtenerNoticiaTraducida(java.lang.Long, java.lang.String)
     */
    public es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO obtenerNoticiaTraducida(java.lang.Long id, java.lang.String idioma)
    {
        return getSrvNoticiasService().obtenerNoticiaTraducida(id, idioma);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#obtenerNoticiasTraducidas(java.lang.String[])
     */
    public es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO[] obtenerNoticiasTraducidas(java.lang.String[] idiomasTraducibles)
    {
        return getSrvNoticiasService().obtenerNoticiasTraducidas(idiomasTraducibles);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#obtenerCategoriasTraducidas(java.lang.String[])
     */
    public es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaTraducidaVO[] obtenerCategoriasTraducidas(java.lang.String[] idiomasTraducibles)
    {
        return getSrvNoticiasService().obtenerCategoriasTraducidas(idiomasTraducibles);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#obtenerCategoriaTraducida(java.lang.Long, java.lang.String)
     */
    public es.pode.contenidos.negocio.noticias.servicio.CategoriaNoticiaTraducidaVO obtenerCategoriaTraducida(java.lang.Long id, java.lang.String idioma)
    {
        return getSrvNoticiasService().obtenerCategoriaTraducida(id, idioma);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#obtenerNoticiasFromIdCategoria(java.lang.Long, java.lang.String[])
     */
    public es.pode.contenidos.negocio.noticias.servicio.NoticiaTraducidaVO[] obtenerNoticiasFromIdCategoria(java.lang.Long idCategoria, java.lang.String[] idiomasTraducibles)
    {
        return getSrvNoticiasService().obtenerNoticiasFromIdCategoria(idCategoria, idiomasTraducibles);
    }

    /**
     * @see es.pode.contenidos.negocio.noticias.servicio.SrvNoticiasService#eliminarImagenNoticia(java.lang.String)
     */
    public java.lang.Boolean eliminarImagenNoticia(java.lang.String imagenEliminarSt)
    {
        return getSrvNoticiasService().eliminarImagenNoticia(imagenEliminarSt);
    }

}
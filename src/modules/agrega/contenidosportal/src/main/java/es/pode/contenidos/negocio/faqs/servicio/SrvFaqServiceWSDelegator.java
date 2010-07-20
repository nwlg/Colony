// license-header java merge-point
package es.pode.contenidos.negocio.faqs.servicio;

/**
 * Web service delegator for {@link es.pode.contenidos.negocio.faqs.servicio.SrvFaqService}.
 *
 * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService
 */
public class SrvFaqServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.contenidos.negocio.faqs.servicio.SrvFaqService}
     */
    private final es.pode.contenidos.negocio.faqs.servicio.SrvFaqService getSrvFaqService()
    {
        return es.pode.contenidos.negocio.ServiceLocator.instance().getSrvFaqService();
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#obtenerFaqs()
     */
    public es.pode.contenidos.negocio.faqs.servicio.FaqVO[] obtenerFaqs()
    {
        return getSrvFaqService().obtenerFaqs();
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#crearFaq(es.pode.contenidos.negocio.faqs.servicio.FaqVO)
     */
    public es.pode.contenidos.negocio.faqs.servicio.FaqVO crearFaq(es.pode.contenidos.negocio.faqs.servicio.FaqVO faq)
    {
        return getSrvFaqService().crearFaq(faq);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#modificarFaq(es.pode.contenidos.negocio.faqs.servicio.FaqVO)
     */
    public es.pode.contenidos.negocio.faqs.servicio.FaqVO modificarFaq(es.pode.contenidos.negocio.faqs.servicio.FaqVO faq)
    {
        return getSrvFaqService().modificarFaq(faq);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#eliminarFaqs(java.lang.Long[])
     */
    public void eliminarFaqs(java.lang.Long[] faqIDs)
    {
        getSrvFaqService().eliminarFaqs(faqIDs);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#consultaFaq(java.lang.Long)
     */
    public es.pode.contenidos.negocio.faqs.servicio.FaqVO consultaFaq(java.lang.Long id)
    {
        return getSrvFaqService().consultaFaq(id);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#obtenerFaqsPorIdioma(java.lang.String)
     */
    public es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaVO[] obtenerFaqsPorIdioma(java.lang.String idioma)
    {
        return getSrvFaqService().obtenerFaqsPorIdioma(idioma);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#obtenCategoriasFaqs(java.lang.String)
     */
    public es.pode.contenidos.negocio.faqs.servicio.CategoriaTraducidaVO[] obtenCategoriasFaqs(java.lang.String idioma)
    {
        return getSrvFaqService().obtenCategoriasFaqs(idioma);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#obtenFaqsPorIdiomaCategoria(java.lang.String, java.lang.Long)
     */
    public es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaVO[] obtenFaqsPorIdiomaCategoria(java.lang.String idioma, java.lang.Long categoria)
    {
        return getSrvFaqService().obtenFaqsPorIdiomaCategoria(idioma, categoria);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#obtenerFaqTraducida(java.lang.Long, java.lang.String)
     */
    public es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaVO obtenerFaqTraducida(java.lang.Long id, java.lang.String idioma)
    {
        return getSrvFaqService().obtenerFaqTraducida(id, idioma);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#crearCategoria(es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO)
     */
    public java.lang.Long crearCategoria(es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO categoria)
    {
        return getSrvFaqService().crearCategoria(categoria);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#modificarCategoria(es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO)
     */
    public void modificarCategoria(es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO categoria)
    {
        getSrvFaqService().modificarCategoria(categoria);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#eliminarCategoria(java.lang.Long)
     */
    public void eliminarCategoria(java.lang.Long id)
    {
        getSrvFaqService().eliminarCategoria(id);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#eliminarCategorias(java.lang.Long[])
     */
    public void eliminarCategorias(java.lang.Long[] ids)
    {
        getSrvFaqService().eliminarCategorias(ids);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#listarCategorias()
     */
    public es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO[] listarCategorias()
    {
        return getSrvFaqService().listarCategorias();
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#obtenerCategoria(java.lang.Long)
     */
    public es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO obtenerCategoria(java.lang.Long id)
    {
        return getSrvFaqService().obtenerCategoria(id);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#limpiarCategoria(java.lang.Long)
     */
    public void limpiarCategoria(java.lang.Long id)
    {
        getSrvFaqService().limpiarCategoria(id);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#limpiarFaq(java.lang.Long)
     */
    public void limpiarFaq(java.lang.Long id)
    {
        getSrvFaqService().limpiarFaq(id);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#obtenerCategorias()
     */
    public es.pode.contenidos.negocio.faqs.servicio.CategoriaFaqVO[] obtenerCategorias()
    {
        return getSrvFaqService().obtenerCategorias();
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#obtenerCategoriasTraducidas(java.lang.String[])
     */
    public es.pode.contenidos.negocio.faqs.servicio.CategoriaTraducidaVO[] obtenerCategoriasTraducidas(java.lang.String[] idiomasTraducibles)
    {
        return getSrvFaqService().obtenerCategoriasTraducidas(idiomasTraducibles);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#obtenerFaqsFromIdCategoria(java.lang.Long, java.lang.String[])
     */
    public es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaVO[] obtenerFaqsFromIdCategoria(java.lang.Long idCategoria, java.lang.String[] idiomasTraducibles)
    {
        return getSrvFaqService().obtenerFaqsFromIdCategoria(idCategoria, idiomasTraducibles);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#obtenerFaqsTraducidas(java.lang.String[])
     */
    public es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaVO[] obtenerFaqsTraducidas(java.lang.String[] idiomasTraducibles)
    {
        return getSrvFaqService().obtenerFaqsTraducidas(idiomasTraducibles);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#eliminarFaq(java.lang.Long)
     */
    public void eliminarFaq(java.lang.Long id)
    {
        getSrvFaqService().eliminarFaq(id);
    }

    /**
     * @see es.pode.contenidos.negocio.faqs.servicio.SrvFaqService#obtenerFaqsBloquesIdiomas(java.lang.String[])
     */
    public es.pode.contenidos.negocio.faqs.servicio.FaqTraducidaIdiomaVO[] obtenerFaqsBloquesIdiomas(java.lang.String[] idiomasTraducibles)
    {
        return getSrvFaqService().obtenerFaqsBloquesIdiomas(idiomasTraducibles);
    }

}
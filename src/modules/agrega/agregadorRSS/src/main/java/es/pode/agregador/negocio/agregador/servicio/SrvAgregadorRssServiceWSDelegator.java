// license-header java merge-point
package es.pode.agregador.negocio.agregador.servicio;

/**
 * Web service delegator for {@link es.pode.agregador.negocio.agregador.servicio.SrvAgregadorRssService}.
 *
 * @see es.pode.agregador.negocio.agregador.servicio.SrvAgregadorRssService
 */
public class SrvAgregadorRssServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.agregador.negocio.agregador.servicio.SrvAgregadorRssService}
     */
    private final es.pode.agregador.negocio.agregador.servicio.SrvAgregadorRssService getSrvAgregadorRssService()
    {
        return es.pode.agregadorRSS.ServiceLocator.instance().getSrvAgregadorRssService();
    }

    /**
     * @see es.pode.agregador.negocio.agregador.servicio.SrvAgregadorRssService#crearXML()
     */
    public void crearXML()
    {
        getSrvAgregadorRssService().crearXML();
    }

    /**
     * @see es.pode.agregador.negocio.agregador.servicio.SrvAgregadorRssService#devuelveFeeds()
     */
    public es.pode.agregador.negocio.agregador.servicio.FeedVO[] devuelveFeeds()
    {
        return getSrvAgregadorRssService().devuelveFeeds();
    }

    /**
     * @see es.pode.agregador.negocio.agregador.servicio.SrvAgregadorRssService#devuelveRssBusqueda(es.pode.agregador.negocio.agregador.servicio.ParametrosBusquedaAgregadorVO)
     */
    public javax.activation.DataHandler devuelveRssBusqueda(es.pode.agregador.negocio.agregador.servicio.ParametrosBusquedaAgregadorVO parametrosBusqueda)
    {
        return getSrvAgregadorRssService().devuelveRssBusqueda(parametrosBusqueda);
    }

    /**
     * @see es.pode.agregador.negocio.agregador.servicio.SrvAgregadorRssService#eliminarFichero(es.pode.agregador.negocio.agregador.servicio.ParametrosBusquedaAgregadorVO)
     */
    public void eliminarFichero(es.pode.agregador.negocio.agregador.servicio.ParametrosBusquedaAgregadorVO param)
    {
        getSrvAgregadorRssService().eliminarFichero(param);
    }

}
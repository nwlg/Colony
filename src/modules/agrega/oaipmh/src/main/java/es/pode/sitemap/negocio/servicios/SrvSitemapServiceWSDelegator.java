// license-header java merge-point
package es.pode.sitemap.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.sitemap.negocio.servicios.SrvSitemapService}.
 *
 * @see es.pode.sitemap.negocio.servicios.SrvSitemapService
 */
public class SrvSitemapServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.sitemap.negocio.servicios.SrvSitemapService}
     */
    private final es.pode.sitemap.negocio.servicios.SrvSitemapService getSrvSitemapService()
    {
        return es.pode.ServiceLocator.instance().getSrvSitemapService();
    }

    /**
     * @see es.pode.sitemap.negocio.servicios.SrvSitemapService#generarSitemapXml()
     */
    public void generarSitemapXml()
    {
        getSrvSitemapService().generarSitemapXml();
    }

}
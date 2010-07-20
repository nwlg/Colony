// license-header java merge-point
package es.pode.validador.negocio.servicio;

/**
 * Web service delegator for {@link es.pode.validador.negocio.servicio.SrvValidadorVDEXService}.
 *
 * @see es.pode.validador.negocio.servicio.SrvValidadorVDEXService
 */
public class SrvValidadorVDEXServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.validador.negocio.servicio.SrvValidadorVDEXService}
     */
    private final es.pode.validador.negocio.servicio.SrvValidadorVDEXService getSrvValidadorVDEXService()
    {
        return es.pode.validador.negocio.ServiceLocator.instance().getSrvValidadorVDEXService();
    }

    /**
     * @see es.pode.validador.negocio.servicio.SrvValidadorVDEXService#obtenerValidacionTesauro(java.lang.String)
     */
    public es.pode.validador.negocio.servicio.ValidaVdexVO obtenerValidacionTesauro(java.lang.String rutaVdex)
    {
        return getSrvValidadorVDEXService().obtenerValidacionTesauro(rutaVdex);
    }

    /**
     * @see es.pode.validador.negocio.servicio.SrvValidadorVDEXService#obtenerValidacionTaxonomia(java.lang.String)
     */
    public es.pode.validador.negocio.servicio.ValidaVdexVO obtenerValidacionTaxonomia(java.lang.String rutaVdex)
    {
        return getSrvValidadorVDEXService().obtenerValidacionTaxonomia(rutaVdex);
    }

    /**
     * @see es.pode.validador.negocio.servicio.SrvValidadorVDEXService#obtenerValidacionVdex(java.lang.String)
     */
    public es.pode.validador.negocio.servicio.ValidaVdexVO obtenerValidacionVdex(java.lang.String rutaVdex)
    {
        return getSrvValidadorVDEXService().obtenerValidacionVdex(rutaVdex);
    }

}
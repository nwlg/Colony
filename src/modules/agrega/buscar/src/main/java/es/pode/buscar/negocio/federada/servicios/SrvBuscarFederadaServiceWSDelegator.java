// license-header java merge-point
package es.pode.buscar.negocio.federada.servicios;

/**
 * Web service delegator for {@link es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService}.
 *
 * @see es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService
 */
public class SrvBuscarFederadaServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService}
     */
    private final es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService getSrvBuscarFederadaService()
    {
        return es.pode.buscar.negocio.ServiceLocator.instance().getSrvBuscarFederadaService();
    }

    /**
     * @see es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService#busquedaFederada(es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO)
     */
    public es.pode.indexador.negocio.servicios.busqueda.DocumentosVO busquedaFederada(es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO parametros)
    {
        return getSrvBuscarFederadaService().busquedaFederada(parametros);
    }

    /**
     * @see es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService#solicitarDocsCountArbolCurricular(es.pode.buscar.negocio.buscar.servicios.ParametrosDocsCountVO)
     */
    public es.pode.buscar.negocio.buscar.servicios.ResultadosNodoCountVO solicitarDocsCountArbolCurricular(es.pode.buscar.negocio.buscar.servicios.ParametrosDocsCountVO parametros)
    {
        return getSrvBuscarFederadaService().solicitarDocsCountArbolCurricular(parametros);
    }

    /**
     * @see es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService#buscarDocsNodoArbolCurricular(es.pode.buscar.negocio.buscar.servicios.ParametrosNodoArbolCurricularVO)
     */
    public es.pode.indexador.negocio.servicios.busqueda.DocumentosVO buscarDocsNodoArbolCurricular(es.pode.buscar.negocio.buscar.servicios.ParametrosNodoArbolCurricularVO parametros)
    {
        return getSrvBuscarFederadaService().buscarDocsNodoArbolCurricular(parametros);
    }

    /**
     * @see es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService#estoyActivo()
     */
    public boolean estoyActivo()
    {
        return getSrvBuscarFederadaService().estoyActivo();
    }

    /**
     * @see es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaService#obtenerIdentificadorNodo()
     */
    public java.lang.String obtenerIdentificadorNodo()
    {
        return getSrvBuscarFederadaService().obtenerIdentificadorNodo();
    }

}
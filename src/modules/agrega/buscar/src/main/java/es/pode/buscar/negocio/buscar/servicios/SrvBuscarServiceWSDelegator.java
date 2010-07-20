// license-header java merge-point
package es.pode.buscar.negocio.buscar.servicios;

/**
 * Web service delegator for {@link es.pode.buscar.negocio.buscar.servicios.SrvBuscarService}.
 *
 * @see es.pode.buscar.negocio.buscar.servicios.SrvBuscarService
 */
public class SrvBuscarServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.buscar.negocio.buscar.servicios.SrvBuscarService}
     */
    private final es.pode.buscar.negocio.buscar.servicios.SrvBuscarService getSrvBuscarService()
    {
        return es.pode.buscar.negocio.ServiceLocator.instance().getSrvBuscarService();
    }

    /**
     * @see es.pode.buscar.negocio.buscar.servicios.SrvBuscarService#buscarLomEs(es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaSQIVO)
     */
    public es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaSQIVO buscarLomEs(es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaSQIVO parametros)
    {
        return getSrvBuscarService().buscarLomEs(parametros);
    }

    /**
     * @see es.pode.buscar.negocio.buscar.servicios.SrvBuscarService#buscarAvanzado(es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO)
     */
    public es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaVO buscarAvanzado(es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO parametros)
    {
        return getSrvBuscarService().buscarAvanzado(parametros);
    }

    /**
     * @see es.pode.buscar.negocio.buscar.servicios.SrvBuscarService#solicitarMetadato(es.pode.buscar.negocio.buscar.servicios.ParametroMetadatoVO)
     */
    public es.pode.buscar.negocio.buscar.servicios.MetadatoBasicoVO solicitarMetadato(es.pode.buscar.negocio.buscar.servicios.ParametroMetadatoVO parametros)
    {
        return getSrvBuscarService().solicitarMetadato(parametros);
    }

    /**
     * @see es.pode.buscar.negocio.buscar.servicios.SrvBuscarService#generadorIdentificadorAvanzado(es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO)
     */
    public java.lang.String generadorIdentificadorAvanzado(es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO parametrosAvanzada)
    {
        return getSrvBuscarService().generadorIdentificadorAvanzado(parametrosAvanzada);
    }

    /**
     * @see es.pode.buscar.negocio.buscar.servicios.SrvBuscarService#solicitarDocsCount(es.pode.buscar.negocio.buscar.servicios.ParametrosDocsCountVO)
     */
    public es.pode.buscar.negocio.buscar.servicios.ResultadosNodoCountVO solicitarDocsCount(es.pode.buscar.negocio.buscar.servicios.ParametrosDocsCountVO parametros)
    {
        return getSrvBuscarService().solicitarDocsCount(parametros);
    }

    /**
     * @see es.pode.buscar.negocio.buscar.servicios.SrvBuscarService#borrarHitCache(java.lang.String)
     */
    public boolean borrarHitCache(java.lang.String hit)
    {
        return getSrvBuscarService().borrarHitCache(hit);
    }

    /**
     * @see es.pode.buscar.negocio.buscar.servicios.SrvBuscarService#buscarSQI(es.pode.buscar.negocio.buscar.servicios.ParamBusquedaSQIVO)
     */
    public es.pode.buscar.negocio.buscar.servicios.ResultadoBusquedaSQIVO buscarSQI(es.pode.buscar.negocio.buscar.servicios.ParamBusquedaSQIVO consulta)
    {
        return getSrvBuscarService().buscarSQI(consulta);
    }

}
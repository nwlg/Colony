// license-header java merge-point
package es.pode.indexador.negocio.servicios.busqueda;

/**
 * Web service delegator for {@link es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService}.
 *
 * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService
 */
public class SrvBuscadorServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService}
     */
    private final es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService getSrvBuscadorService()
    {
        return es.pode.indexador.ServiceLocator.instance().getSrvBuscadorService();
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#busquedaAvanzada(es.pode.indexador.negocio.servicios.busqueda.ParamAvanzadoVO)
     */
    public es.pode.indexador.negocio.servicios.busqueda.DocumentosVO busquedaAvanzada(es.pode.indexador.negocio.servicios.busqueda.ParamAvanzadoVO paramBusq)
    {
        return getSrvBuscadorService().busquedaAvanzada(paramBusq);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#busquedaSimple(es.pode.indexador.negocio.servicios.busqueda.ParamSimpleVO)
     */
    public es.pode.indexador.negocio.servicios.busqueda.DocumentosVO busquedaSimple(es.pode.indexador.negocio.servicios.busqueda.ParamSimpleVO paramBusq)
    {
        return getSrvBuscadorService().busquedaSimple(paramBusq);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#busquedaLOM_ES(es.pode.indexador.negocio.servicios.busqueda.QuerySimpleVO)
     */
    public es.pode.indexador.negocio.servicios.busqueda.DocumentosLOM_ESVO busquedaLOM_ES(es.pode.indexador.negocio.servicios.busqueda.QuerySimpleVO paramBusq)
    {
        return getSrvBuscadorService().busquedaLOM_ES(paramBusq);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#busquedaMEC(java.lang.String, java.lang.String)
     */
    public es.pode.indexador.negocio.servicios.busqueda.DocVO busquedaMEC(java.lang.String identificadorMEC, java.lang.String idiomaBusqueda)
    {
        return getSrvBuscadorService().busquedaMEC(identificadorMEC, idiomaBusqueda);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#solicitudDocsCount(es.pode.indexador.negocio.servicios.busqueda.ParamDocsCountVO)
     */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO solicitudDocsCount(es.pode.indexador.negocio.servicios.busqueda.ParamDocsCountVO paramBusq)
    {
        return getSrvBuscadorService().solicitudDocsCount(paramBusq);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#busquedaDocsNodoArbolCurricular(es.pode.indexador.negocio.servicios.busqueda.ParamNodoArbolCurricularVO)
     */
    public es.pode.indexador.negocio.servicios.busqueda.DocumentosVO busquedaDocsNodoArbolCurricular(es.pode.indexador.negocio.servicios.busqueda.ParamNodoArbolCurricularVO paramBusq)
    {
        return getSrvBuscadorService().busquedaDocsNodoArbolCurricular(paramBusq);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#obtenerPalabrasClave(es.pode.indexador.negocio.servicios.busqueda.ParamPalabrasClave)
     */
    public es.pode.indexador.negocio.servicios.busqueda.PrioridadPalabrasClaveVO obtenerPalabrasClave(es.pode.indexador.negocio.servicios.busqueda.ParamPalabrasClave paramBusq)
    {
        return getSrvBuscadorService().obtenerPalabrasClave(paramBusq);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#busquedaMECRepositorio(java.lang.String)
     */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO busquedaMECRepositorio(java.lang.String idMEC)
    {
        return getSrvBuscadorService().busquedaMECRepositorio(idMEC);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#busquedaHeadersRepositorio(es.pode.indexador.negocio.servicios.busqueda.ParamPeriodoRepositorioVO)
     */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadoHeaderVO[] busquedaHeadersRepositorio(es.pode.indexador.negocio.servicios.busqueda.ParamPeriodoRepositorioVO paramBusq)
    {
        return getSrvBuscadorService().busquedaHeadersRepositorio(paramBusq);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#busquedaRepositorio(es.pode.indexador.negocio.servicios.busqueda.ParamPeriodoRepositorioVO)
     */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadoRecordVO[] busquedaRepositorio(es.pode.indexador.negocio.servicios.busqueda.ParamPeriodoRepositorioVO paramBusq)
    {
        return getSrvBuscadorService().busquedaRepositorio(paramBusq);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#fechaInicioRepositorio()
     */
    public java.util.Calendar fechaInicioRepositorio()
    {
        return getSrvBuscadorService().fechaInicioRepositorio();
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#obtenerODERandom()
     */
    public es.pode.indexador.negocio.servicios.busqueda.DocVO obtenerODERandom()
    {
        return getSrvBuscadorService().obtenerODERandom();
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#obtenerRepositorio()
     */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadoRepositorioVO[] obtenerRepositorio()
    {
        return getSrvBuscadorService().obtenerRepositorio();
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#obtenerCatalogoRepositorioParam(java.lang.Integer)
     */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadoRepositorioVO[] obtenerCatalogoRepositorioParam(java.lang.Integer nivelAgregacion)
    {
        return getSrvBuscadorService().obtenerCatalogoRepositorioParam(nivelAgregacion);
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#obtenerTotalesRepositorio()
     */
    public es.pode.indexador.negocio.servicios.busqueda.ResultadosCountVO obtenerTotalesRepositorio()
    {
        return getSrvBuscadorService().obtenerTotalesRepositorio();
    }

    /**
     * @see es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService#busquedaLOM_ESVSQL(es.pode.indexador.negocio.servicios.busqueda.QuerySimpleVO)
     */
    public es.pode.indexador.negocio.servicios.busqueda.DocumentosLOM_ESVO busquedaLOM_ESVSQL(es.pode.indexador.negocio.servicios.busqueda.QuerySimpleVO paramBusqueda)
    {
        return getSrvBuscadorService().busquedaLOM_ESVSQL(paramBusqueda);
    }

}
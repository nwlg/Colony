// license-header java merge-point
package es.pode.oaipmh.negocio.servicios;

/**
 * Web service delegator for {@link es.pode.oaipmh.negocio.servicios.SrvOaiPmhService}.
 *
 * @see es.pode.oaipmh.negocio.servicios.SrvOaiPmhService
 */
public class SrvOaiPmhServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.oaipmh.negocio.servicios.SrvOaiPmhService}
     */
    private final es.pode.oaipmh.negocio.servicios.SrvOaiPmhService getSrvOaiPmhService()
    {
        return es.pode.ServiceLocator.instance().getSrvOaiPmhService();
    }

    /**
     * @see es.pode.oaipmh.negocio.servicios.SrvOaiPmhService#identify()
     */
    public es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest identify()
    {
        return getSrvOaiPmhService().identify();
    }

    /**
     * @see es.pode.oaipmh.negocio.servicios.SrvOaiPmhService#listIdentifiers(es.pode.oaipmh.negocio.servicios.ParametrosOaiPmhVO)
     */
    public es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest listIdentifiers(es.pode.oaipmh.negocio.servicios.ParametrosOaiPmhVO parametroLlamada)
    {
        return getSrvOaiPmhService().listIdentifiers(parametroLlamada);
    }

    /**
     * @see es.pode.oaipmh.negocio.servicios.SrvOaiPmhService#listMetadataFormat(es.pode.oaipmh.negocio.servicios.ParametrosOaiPmhVO)
     */
    public es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest listMetadataFormat(es.pode.oaipmh.negocio.servicios.ParametrosOaiPmhVO parametrosLlamada)
    {
        return getSrvOaiPmhService().listMetadataFormat(parametrosLlamada);
    }

    /**
     * @see es.pode.oaipmh.negocio.servicios.SrvOaiPmhService#listSets()
     */
    public es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest listSets()
    {
        return getSrvOaiPmhService().listSets();
    }

    /**
     * @see es.pode.oaipmh.negocio.servicios.SrvOaiPmhService#listRecords(es.pode.oaipmh.negocio.servicios.ParametrosOaiPmhVO)
     */
    public es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest listRecords(es.pode.oaipmh.negocio.servicios.ParametrosOaiPmhVO parametrosLlamada)
    {
        return getSrvOaiPmhService().listRecords(parametrosLlamada);
    }

    /**
     * @see es.pode.oaipmh.negocio.servicios.SrvOaiPmhService#getRecord(es.pode.oaipmh.negocio.servicios.ParametrosOaiPmhVO)
     */
    public es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest getRecord(es.pode.oaipmh.negocio.servicios.ParametrosOaiPmhVO parametroLlamada)
    {
        return getSrvOaiPmhService().getRecord(parametroLlamada);
    }

    /**
     * @see es.pode.oaipmh.negocio.servicios.SrvOaiPmhService#estasActivo()
     */
    public java.lang.Boolean estasActivo()
    {
        return getSrvOaiPmhService().estasActivo();
    }

}
// license-header java merge-point
package es.pode.dri.negocio.servicios.SQI;

/**
 * Web service delegator for {@link es.pode.dri.negocio.servicios.SQI.SrvSQIService}.
 *
 * @see es.pode.dri.negocio.servicios.SQI.SrvSQIService
 */
public class SrvSQIServiceWSDelegator
{

    /**
     * Gets an instance of {@link es.pode.dri.negocio.servicios.SQI.SrvSQIService}
     */
    private final es.pode.dri.negocio.servicios.SQI.SrvSQIService getSrvSQIService()
    {
        return es.pode.dri.negocio.ServiceLocator.instance().getSrvSQIService();
    }

    /**
     * @see es.pode.dri.negocio.servicios.SQI.SrvSQIService#getTotalResultsCount(java.lang.String, java.lang.String)
     */
    public java.lang.Integer getTotalResultsCount(java.lang.String targetSessionID, java.lang.String queryStatement)
        throws es.pode.dri.negocio.servicios.SQI.NoQuerySubmittedException, es.pode.dri.negocio.servicios.SQI.NoSuchSessionException, es.pode.dri.negocio.servicios.SQI.QueryModeNotSupportedException
    {
        return getSrvSQIService().getTotalResultsCount(targetSessionID, queryStatement);
    }

    /**
     * @see es.pode.dri.negocio.servicios.SQI.SrvSQIService#setMaxDuration(java.lang.String, java.lang.Integer)
     */
    public void setMaxDuration(java.lang.String targetSessionID, java.lang.Integer maxDuration)
        throws es.pode.dri.negocio.servicios.SQI.NoValidMaxDurationException, es.pode.dri.negocio.servicios.SQI.NoSuchSessionException
    {
        getSrvSQIService().setMaxDuration(targetSessionID, maxDuration);
    }

    /**
     * @see es.pode.dri.negocio.servicios.SQI.SrvSQIService#setResultsFormat(java.lang.String, java.lang.String)
     */
    public void setResultsFormat(java.lang.String targetSessionID, java.lang.String resultsFormat)
        throws es.pode.dri.negocio.servicios.SQI.ResultsFormatNotSupportedException, es.pode.dri.negocio.servicios.SQI.NoSuchSessionException
    {
        getSrvSQIService().setResultsFormat(targetSessionID, resultsFormat);
    }

    /**
     * @see es.pode.dri.negocio.servicios.SQI.SrvSQIService#setResultsSetSize(java.lang.String, java.lang.Integer)
     */
    public void setResultsSetSize(java.lang.String targetSessionID, java.lang.Integer resultsSetSize)
        throws es.pode.dri.negocio.servicios.SQI.NoSuchSessionException, es.pode.dri.negocio.servicios.SQI.QueryModeNotSupportedException, es.pode.dri.negocio.servicios.SQI.NoValidResultsSetSizeException
    {
        getSrvSQIService().setResultsSetSize(targetSessionID, resultsSetSize);
    }

    /**
     * @see es.pode.dri.negocio.servicios.SQI.SrvSQIService#setSourceLocation(java.lang.String, java.lang.String)
     */
    public void setSourceLocation(java.lang.String targetSessionID, java.lang.String sourceLocation)
        throws es.pode.dri.negocio.servicios.SQI.NoSuchSessionException, es.pode.dri.negocio.servicios.SQI.QueryModeNotSupportedException, es.pode.dri.negocio.servicios.SQI.NoValidLocationException
    {
        getSrvSQIService().setSourceLocation(targetSessionID, sourceLocation);
    }

    /**
     * @see es.pode.dri.negocio.servicios.SQI.SrvSQIService#setQueryLanguage(java.lang.String, java.lang.String)
     */
    public void setQueryLanguage(java.lang.String targetSessionID, java.lang.String queryLanguageID)
        throws es.pode.dri.negocio.servicios.SQI.QueryLanguageNotSupportedException, es.pode.dri.negocio.servicios.SQI.NoSuchSessionException
    {
        getSrvSQIService().setQueryLanguage(targetSessionID, queryLanguageID);
    }

    /**
     * @see es.pode.dri.negocio.servicios.SQI.SrvSQIService#setMaxQueryResults(java.lang.String, java.lang.Integer)
     */
    public void setMaxQueryResults(java.lang.String targetSessionID, java.lang.Integer maxQueryResults)
        throws es.pode.dri.negocio.servicios.SQI.NoValidMaxQueryResultsException, es.pode.dri.negocio.servicios.SQI.NoSuchSessionException
    {
        getSrvSQIService().setMaxQueryResults(targetSessionID, maxQueryResults);
    }

    /**
     * @see es.pode.dri.negocio.servicios.SQI.SrvSQIService#asynchronousQuery(java.lang.String, java.lang.String, java.lang.String)
     */
    public void asynchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.String queryID)
        throws es.pode.dri.negocio.servicios.SQI.NoValidQueryStatementException, es.pode.dri.negocio.servicios.SQI.NoSourceLocationException, es.pode.dri.negocio.servicios.SQI.NoSuchSessionException, es.pode.dri.negocio.servicios.SQI.QueryModeNotSupportedException
    {
        getSrvSQIService().asynchronousQuery(targetSessionID, queryStatement, queryID);
    }

    /**
     * @see es.pode.dri.negocio.servicios.SQI.SrvSQIService#synchronousQuery(java.lang.String, java.lang.String, java.lang.Integer)
     */
    public java.lang.String synchronousQuery(java.lang.String targetSessionID, java.lang.String queryStatement, java.lang.Integer startResult)
        throws es.pode.dri.negocio.servicios.SQI.NoValidQueryStatementException, es.pode.dri.negocio.servicios.SQI.NoValidStartResultException, es.pode.dri.negocio.servicios.SQI.NoSuchSessionException, es.pode.dri.negocio.servicios.SQI.QueryModeNotSupportedException
    {
        return getSrvSQIService().synchronousQuery(targetSessionID, queryStatement, startResult);
    }

    /**
     * @see es.pode.dri.negocio.servicios.SQI.SrvSQIService#estasActivo()
     */
    public java.lang.Boolean estasActivo()
        throws es.pode.dri.negocio.servicios.SQI.NoSuchSessionException
    {
        return getSrvSQIService().estasActivo();
    }

}
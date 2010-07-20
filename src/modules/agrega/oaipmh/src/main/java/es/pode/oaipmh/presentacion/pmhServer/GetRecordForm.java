// license-header java merge-point
package es.pode.oaipmh.presentacion.pmhServer;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>getRecord</code> method, which is located on the
 * <code>es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerController</code> controller.
 *
 * <p>
 * Devuelve toda la información de un registro del repositorio
 * </p>
 *
 * @see es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerController#getRecord
 */
public interface GetRecordForm
{
    /**
     * Sets the <code>resultadoOAIRequest</code> field.
     *
     * 
     */
    public void setResultadoOAIRequest(es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest resultadoOAIRequest);

    /**
     * Gets the <code>resultadoOAIRequest</code> field.
     *
     * 
     */
    public es.pode.oaipmh.negocio.servicios.ResultadoOAIRequest getResultadoOAIRequest();
    
    /**
     * Resets the <code>resultadoOAIRequest</code> field.
     */
    public void resetResultadoOAIRequest();

    /**
     * Sets the <code>parametrosRequestVO</code> field.
     *
     * 
     */
    public void setParametrosRequestVO(es.pode.oaipmh.presentacion.pmhServer.ParametrosRequestVO parametrosRequestVO);

    /**
     * Gets the <code>parametrosRequestVO</code> field.
     *
     * 
     */
    public es.pode.oaipmh.presentacion.pmhServer.ParametrosRequestVO getParametrosRequestVO();
    
    /**
     * Resets the <code>parametrosRequestVO</code> field.
     */
    public void resetParametrosRequestVO();

}

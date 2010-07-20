// license-header java merge-point
package es.pode.oaipmh.presentacion.pmhServer;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerResultadoOAIRequest</code> method, which is located on the
 * <code>es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerController</code> controller.
 *
 * <p>
 * Obtiene el VO con el resultado de la llamada al m�todo del
 * protocolo. Recibe como par�metro el errorCode que se mostrar� en
 * la salida y el VO con los par�metros de la petici�n.
 * </p>
 *
 * @see es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerController#obtenerResultadoOAIRequest
 */
public interface ObtenerResultadoOAIRequestForm
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

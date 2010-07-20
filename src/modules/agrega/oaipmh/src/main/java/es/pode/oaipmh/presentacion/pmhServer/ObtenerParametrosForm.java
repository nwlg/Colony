// license-header java merge-point
package es.pode.oaipmh.presentacion.pmhServer;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerParametros</code> method, which is located on the
 * <code>es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerController</code> controller.
 *
 * 
 *
 * @see es.pode.oaipmh.presentacion.pmhServer.OaiPmhServerController#obtenerParametros
 */
public interface ObtenerParametrosForm
{
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

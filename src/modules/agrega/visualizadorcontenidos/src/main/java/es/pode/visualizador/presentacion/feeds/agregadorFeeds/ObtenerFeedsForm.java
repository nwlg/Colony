// license-header java merge-point
package es.pode.visualizador.presentacion.feeds.agregadorFeeds;

/**
 * This form encapsulates the fields that are used in the execution of the
 * <code>obtenerFeeds</code> method, which is located on the
 * <code>es.pode.visualizador.presentacion.feeds.agregadorFeeds.AgregadorFeedsController</code> controller.
 *
 * 
 *
 * @see es.pode.visualizador.presentacion.feeds.agregadorFeeds.AgregadorFeedsController#obtenerFeeds
 */
public interface ObtenerFeedsForm
{
    /**
     * Sets the <code>feeds</code> field.
     *
     * 
     */
    public void setFeeds(es.pode.agregador.negocio.agregador.servicio.FeedVO[] feeds);

    /**
     * Gets the <code>feeds</code> field.
     *
     * 
     */
    public es.pode.agregador.negocio.agregador.servicio.FeedVO[] getFeeds();
    
    /**
     * Resets the <code>feeds</code> field.
     */
    public void resetFeeds();

}

// license-header java merge-point
package es.pode.visualizador.presentacion.feeds.agregadorFeeds;

public class AgregadorFeedsControllerFactory
{
    private final static AgregadorFeedsController INSTANCE = new AgregadorFeedsControllerImpl();

    public final static AgregadorFeedsController getAgregadorFeedsControllerInstance()
    {
        return INSTANCE;
    }
}
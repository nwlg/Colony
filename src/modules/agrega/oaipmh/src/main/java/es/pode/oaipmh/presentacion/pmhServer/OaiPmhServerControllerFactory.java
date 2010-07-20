// license-header java merge-point
package es.pode.oaipmh.presentacion.pmhServer;

public class OaiPmhServerControllerFactory
{
    private final static OaiPmhServerController INSTANCE = new OaiPmhServerControllerImpl();

    public final static OaiPmhServerController getOaiPmhServerControllerInstance()
    {
        return INSTANCE;
    }
}
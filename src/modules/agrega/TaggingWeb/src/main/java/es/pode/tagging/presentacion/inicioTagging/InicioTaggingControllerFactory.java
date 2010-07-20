// license-header java merge-point
package es.pode.tagging.presentacion.inicioTagging;

public class InicioTaggingControllerFactory
{
    private final static InicioTaggingController INSTANCE = new InicioTaggingControllerImpl();

    public final static InicioTaggingController getInicioTaggingControllerInstance()
    {
        return INSTANCE;
    }
}
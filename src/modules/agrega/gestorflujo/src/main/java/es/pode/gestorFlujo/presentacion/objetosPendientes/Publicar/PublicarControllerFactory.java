// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes.Publicar;

public class PublicarControllerFactory
{
    private final static PublicarController INSTANCE = new PublicarControllerImpl();

    public final static PublicarController getPublicarControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.inicioPortal;

public class InicioPortalControllerFactory
{
    private final static InicioPortalController INSTANCE = new InicioPortalControllerImpl();

    public final static InicioPortalController getInicioPortalControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.inicioCatalogador;

public class InicioControllerFactory
{
    private final static InicioController INSTANCE = new InicioControllerImpl();

    public final static InicioController getInicioControllerInstance()
    {
        return INSTANCE;
    }
}
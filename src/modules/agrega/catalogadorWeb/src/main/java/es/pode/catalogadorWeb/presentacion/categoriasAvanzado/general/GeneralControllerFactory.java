// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.general;

public class GeneralControllerFactory
{
    private final static GeneralController INSTANCE = new GeneralControllerImpl();

    public final static GeneralController getGeneralControllerInstance()
    {
        return INSTANCE;
    }
}
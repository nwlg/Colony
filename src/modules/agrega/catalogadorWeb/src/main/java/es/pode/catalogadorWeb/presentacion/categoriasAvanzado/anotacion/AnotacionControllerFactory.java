// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.anotacion;

public class AnotacionControllerFactory
{
    private final static AnotacionController INSTANCE = new AnotacionControllerImpl();

    public final static AnotacionController getAnotacionControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.faqs.crear;

public class CrearControllerFactory
{
    private final static CrearController INSTANCE = new CrearControllerImpl();

    public final static CrearController getCrearControllerInstance()
    {
        return INSTANCE;
    }
}
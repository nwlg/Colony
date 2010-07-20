// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar;

public class DesagregarSubmanifiestoControllerFactory
{
    private final static DesagregarSubmanifiestoController INSTANCE = new DesagregarSubmanifiestoControllerImpl();

    public final static DesagregarSubmanifiestoController getDesagregarSubmanifiestoControllerInstance()
    {
        return INSTANCE;
    }
}
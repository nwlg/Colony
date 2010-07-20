// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor;

public class GestorSubmanifiestosControllerFactory
{
    private final static GestorSubmanifiestosController INSTANCE = new GestorSubmanifiestosControllerImpl();

    public final static GestorSubmanifiestosController getGestorSubmanifiestosControllerInstance()
    {
        return INSTANCE;
    }
}
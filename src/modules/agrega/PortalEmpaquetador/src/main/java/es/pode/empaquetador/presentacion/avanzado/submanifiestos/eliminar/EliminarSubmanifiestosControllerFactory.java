// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.eliminar;

public class EliminarSubmanifiestosControllerFactory
{
    private final static EliminarSubmanifiestosController INSTANCE = new EliminarSubmanifiestosControllerImpl();

    public final static EliminarSubmanifiestosController getEliminarSubmanifiestosControllerInstance()
    {
        return INSTANCE;
    }
}
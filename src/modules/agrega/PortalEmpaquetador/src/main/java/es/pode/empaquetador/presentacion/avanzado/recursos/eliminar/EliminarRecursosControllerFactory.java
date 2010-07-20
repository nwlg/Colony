// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.eliminar;

public class EliminarRecursosControllerFactory
{
    private final static EliminarRecursosController INSTANCE = new EliminarRecursosControllerImpl();

    public final static EliminarRecursosController getEliminarRecursosControllerInstance()
    {
        return INSTANCE;
    }
}
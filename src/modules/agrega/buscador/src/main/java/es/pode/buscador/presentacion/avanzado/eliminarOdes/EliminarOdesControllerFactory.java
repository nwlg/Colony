// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.eliminarOdes;

public class EliminarOdesControllerFactory
{
    private final static EliminarOdesController INSTANCE = new EliminarOdesControllerImpl();

    public final static EliminarOdesController getEliminarOdesControllerInstance()
    {
        return INSTANCE;
    }
}
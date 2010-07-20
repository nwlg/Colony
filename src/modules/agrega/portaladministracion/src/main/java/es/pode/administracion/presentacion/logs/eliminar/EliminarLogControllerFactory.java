// license-header java merge-point
package es.pode.administracion.presentacion.logs.eliminar;

public class EliminarLogControllerFactory
{
    private final static EliminarLogController INSTANCE = new EliminarLogControllerImpl();

    public final static EliminarLogController getEliminarLogControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.planificador.eliminarTarea;

public class EliminarTareasControllerFactory
{
    private final static EliminarTareasController INSTANCE = new EliminarTareasControllerImpl();

    public final static EliminarTareasController getEliminarTareasControllerInstance()
    {
        return INSTANCE;
    }
}
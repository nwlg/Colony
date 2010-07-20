// license-header java merge-point
package es.pode.administracion.presentacion.planificador.eliminarTrabajoEjecutado;

public class EliminarTrabajoControllerFactory
{
    private final static EliminarTrabajoController INSTANCE = new EliminarTrabajoControllerImpl();

    public final static EliminarTrabajoController getEliminarTrabajoControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.planificador.listarTareasEnEjecucion;

public class TareasEnEjecucionControllerFactory
{
    private final static TareasEnEjecucionController INSTANCE = new TareasEnEjecucionControllerImpl();

    public final static TareasEnEjecucionController getTareasEnEjecucionControllerInstance()
    {
        return INSTANCE;
    }
}
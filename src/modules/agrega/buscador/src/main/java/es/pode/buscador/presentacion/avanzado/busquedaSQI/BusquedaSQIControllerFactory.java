// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.busquedaSQI;

public class BusquedaSQIControllerFactory
{
    private final static BusquedaSQIController INSTANCE = new BusquedaSQIControllerImpl();

    public final static BusquedaSQIController getBusquedaSQIControllerInstance()
    {
        return INSTANCE;
    }
}
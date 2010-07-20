// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

public class BuscarAvanzadoControllerFactory
{
    private final static BuscarAvanzadoController INSTANCE = new BuscarAvanzadoControllerImpl();

    public final static BuscarAvanzadoController getBuscarAvanzadoControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos.buscar;

public class BuscarObjetoControllerFactory
{
    private final static BuscarObjetoController INSTANCE = new BuscarObjetoControllerImpl();

    public final static BuscarObjetoController getBuscarObjetoControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.buscador.presentacion.basico.listar;

public class ListarControllerFactory
{
    private final static ListarController INSTANCE = new ListarControllerImpl();

    public final static ListarController getListarControllerInstance()
    {
        return INSTANCE;
    }
}
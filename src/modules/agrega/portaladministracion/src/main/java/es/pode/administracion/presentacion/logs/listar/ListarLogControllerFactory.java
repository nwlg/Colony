// license-header java merge-point
package es.pode.administracion.presentacion.logs.listar;

public class ListarLogControllerFactory
{
    private final static ListarLogController INSTANCE = new ListarLogControllerImpl();

    public final static ListarLogController getListarLogControllerInstance()
    {
        return INSTANCE;
    }
}
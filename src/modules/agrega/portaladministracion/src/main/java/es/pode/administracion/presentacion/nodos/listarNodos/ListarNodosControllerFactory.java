// license-header java merge-point
package es.pode.administracion.presentacion.nodos.listarNodos;

public class ListarNodosControllerFactory
{
    private final static ListarNodosController INSTANCE = new ListarNodosControllerImpl();

    public final static ListarNodosController getListarNodosControllerInstance()
    {
        return INSTANCE;
    }
}
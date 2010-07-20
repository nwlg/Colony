// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.arboles.listar;

public class ListarArbolesControllerFactory
{
    private final static ListarArbolesController INSTANCE = new ListarArbolesControllerImpl();

    public final static ListarArbolesController getListarArbolesControllerInstance()
    {
        return INSTANCE;
    }
}
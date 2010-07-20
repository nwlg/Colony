// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.listarRepositoriosExternos;

public class ListarNodosSQIControllerFactory
{
    private final static ListarNodosSQIController INSTANCE = new ListarNodosSQIControllerImpl();

    public final static ListarNodosSQIController getListarNodosSQIControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.informes.listarInformes;

public class ListarInformesControllerFactory
{
    private final static ListarInformesController INSTANCE = new ListarInformesControllerImpl();

    public final static ListarInformesController getListarInformesControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.informes.listarInformesFederados;

public class ListarInformesFederadosControllerFactory
{
    private final static ListarInformesFederadosController INSTANCE = new ListarInformesFederadosControllerImpl();

    public final static ListarInformesFederadosController getListarInformesFederadosControllerInstance()
    {
        return INSTANCE;
    }
}
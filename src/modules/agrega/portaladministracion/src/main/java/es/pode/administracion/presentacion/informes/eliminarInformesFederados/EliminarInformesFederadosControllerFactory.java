// license-header java merge-point
package es.pode.administracion.presentacion.informes.eliminarInformesFederados;

public class EliminarInformesFederadosControllerFactory
{
    private final static EliminarInformesFederadosController INSTANCE = new EliminarInformesFederadosControllerImpl();

    public final static EliminarInformesFederadosController getEliminarInformesFederadosControllerInstance()
    {
        return INSTANCE;
    }
}
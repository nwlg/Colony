// license-header java merge-point
package es.pode.administracion.presentacion.monitorizarnodos.monitorizar;

public class MonitorizarNodosControllerFactory
{
    private final static MonitorizarNodosController INSTANCE = new MonitorizarNodosControllerImpl();

    public final static MonitorizarNodosController getMonitorizarNodosControllerInstance()
    {
        return INSTANCE;
    }
}
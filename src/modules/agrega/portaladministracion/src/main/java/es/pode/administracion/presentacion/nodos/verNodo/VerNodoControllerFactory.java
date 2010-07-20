// license-header java merge-point
package es.pode.administracion.presentacion.nodos.verNodo;

public class VerNodoControllerFactory
{
    private final static VerNodoController INSTANCE = new VerNodoControllerImpl();

    public final static VerNodoController getVerNodoControllerInstance()
    {
        return INSTANCE;
    }
}
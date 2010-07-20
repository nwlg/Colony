// license-header java merge-point
package es.pode.administracion.presentacion.nodos.bajaNodo;

public class BajaNodoControllerFactory
{
    private final static BajaNodoController INSTANCE = new BajaNodoControllerImpl();

    public final static BajaNodoController getBajaNodoControllerInstance()
    {
        return INSTANCE;
    }
}
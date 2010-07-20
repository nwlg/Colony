// license-header java merge-point
package es.pode.administracion.presentacion.nodos.altaNodo;

public class AltaNodoControllerFactory
{
    private final static AltaNodoController INSTANCE = new AltaNodoControllerImpl();

    public final static AltaNodoController getAltaNodoControllerInstance()
    {
        return INSTANCE;
    }
}
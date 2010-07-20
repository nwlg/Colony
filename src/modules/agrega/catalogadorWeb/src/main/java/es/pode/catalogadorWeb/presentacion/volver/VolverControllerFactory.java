// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.volver;

public class VolverControllerFactory
{
    private final static VolverController INSTANCE = new VolverControllerImpl();

    public final static VolverController getVolverControllerInstance()
    {
        return INSTANCE;
    }
}
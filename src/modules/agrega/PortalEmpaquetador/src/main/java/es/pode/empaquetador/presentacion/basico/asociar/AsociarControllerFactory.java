// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar;

public class AsociarControllerFactory
{
    private final static AsociarController INSTANCE = new AsociarControllerImpl();

    public final static AsociarController getAsociarControllerInstance()
    {
        return INSTANCE;
    }
}
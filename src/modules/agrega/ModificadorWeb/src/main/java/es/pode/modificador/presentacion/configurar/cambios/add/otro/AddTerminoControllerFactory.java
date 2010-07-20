// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.add.otro;

public class AddTerminoControllerFactory
{
    private final static AddTerminoController INSTANCE = new AddTerminoControllerImpl();

    public final static AddTerminoController getAddTerminoControllerInstance()
    {
        return INSTANCE;
    }
}
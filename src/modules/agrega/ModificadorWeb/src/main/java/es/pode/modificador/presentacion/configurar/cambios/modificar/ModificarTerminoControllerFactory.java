// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.modificar;

public class ModificarTerminoControllerFactory
{
    private final static ModificarTerminoController INSTANCE = new ModificarTerminoControllerImpl();

    public final static ModificarTerminoController getModificarTerminoControllerInstance()
    {
        return INSTANCE;
    }
}
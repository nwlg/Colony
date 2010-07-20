// license-header java merge-point
package es.pode.empaquetador.presentacion.guardar;

public class GuardarControllerFactory
{
    private final static GuardarController INSTANCE = new GuardarControllerImpl();

    public final static GuardarController getGuardarControllerInstance()
    {
        return INSTANCE;
    }
}
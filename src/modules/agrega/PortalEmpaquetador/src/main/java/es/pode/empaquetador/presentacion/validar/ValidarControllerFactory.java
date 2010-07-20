// license-header java merge-point
package es.pode.empaquetador.presentacion.validar;

public class ValidarControllerFactory
{
    private final static ValidarController INSTANCE = new ValidarControllerImpl();

    public final static ValidarController getValidarControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.comprobar;

public class ComprobarTerminoControllerFactory
{
    private final static ComprobarTerminoController INSTANCE = new ComprobarTerminoControllerImpl();

    public final static ComprobarTerminoController getComprobarTerminoControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.gestor;

public class GestorBasicoControllerFactory
{
    private final static GestorBasicoController INSTANCE = new GestorBasicoControllerImpl();

    public final static GestorBasicoController getGestorBasicoControllerInstance()
    {
        return INSTANCE;
    }
}
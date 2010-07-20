// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.desagregar;

public class DesagregarBasicoControllerFactory
{
    private final static DesagregarBasicoController INSTANCE = new DesagregarBasicoControllerImpl();

    public final static DesagregarBasicoController getDesagregarBasicoControllerInstance()
    {
        return INSTANCE;
    }
}
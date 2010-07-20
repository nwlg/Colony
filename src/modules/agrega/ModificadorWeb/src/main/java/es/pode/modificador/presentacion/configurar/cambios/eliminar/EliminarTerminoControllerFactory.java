// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.eliminar;

public class EliminarTerminoControllerFactory
{
    private final static EliminarTerminoController INSTANCE = new EliminarTerminoControllerImpl();

    public final static EliminarTerminoController getEliminarTerminoControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.verHistorial;

public class VerHistorialControllerFactory
{
    private final static VerHistorialController INSTANCE = new VerHistorialControllerImpl();

    public final static VerHistorialController getVerHistorialControllerInstance()
    {
        return INSTANCE;
    }
}
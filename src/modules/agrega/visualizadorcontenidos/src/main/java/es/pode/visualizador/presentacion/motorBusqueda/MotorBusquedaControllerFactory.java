// license-header java merge-point
package es.pode.visualizador.presentacion.motorBusqueda;

public class MotorBusquedaControllerFactory
{
    private final static MotorBusquedaController INSTANCE = new MotorBusquedaControllerImpl();

    public final static MotorBusquedaController getMotorBusquedaControllerInstance()
    {
        return INSTANCE;
    }
}
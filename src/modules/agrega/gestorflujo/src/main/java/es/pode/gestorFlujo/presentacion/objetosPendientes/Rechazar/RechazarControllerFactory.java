// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes.Rechazar;

public class RechazarControllerFactory
{
    private final static RechazarController INSTANCE = new RechazarControllerImpl();

    public final static RechazarController getRechazarControllerInstance()
    {
        return INSTANCE;
    }
}
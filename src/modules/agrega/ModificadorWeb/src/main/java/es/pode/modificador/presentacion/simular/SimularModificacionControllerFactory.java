// license-header java merge-point
package es.pode.modificador.presentacion.simular;

public class SimularModificacionControllerFactory
{
    private final static SimularModificacionController INSTANCE = new SimularModificacionControllerImpl();

    public final static SimularModificacionController getSimularModificacionControllerInstance()
    {
        return INSTANCE;
    }
}
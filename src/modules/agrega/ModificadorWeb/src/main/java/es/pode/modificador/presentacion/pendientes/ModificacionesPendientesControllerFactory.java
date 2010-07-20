// license-header java merge-point
package es.pode.modificador.presentacion.pendientes;

public class ModificacionesPendientesControllerFactory
{
    private final static ModificacionesPendientesController INSTANCE = new ModificacionesPendientesControllerImpl();

    public final static ModificacionesPendientesController getModificacionesPendientesControllerInstance()
    {
        return INSTANCE;
    }
}
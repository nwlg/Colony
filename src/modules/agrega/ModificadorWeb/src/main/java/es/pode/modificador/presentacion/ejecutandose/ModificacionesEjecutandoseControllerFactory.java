// license-header java merge-point
package es.pode.modificador.presentacion.ejecutandose;

public class ModificacionesEjecutandoseControllerFactory
{
    private final static ModificacionesEjecutandoseController INSTANCE = new ModificacionesEjecutandoseControllerImpl();

    public final static ModificacionesEjecutandoseController getModificacionesEjecutandoseControllerInstance()
    {
        return INSTANCE;
    }
}
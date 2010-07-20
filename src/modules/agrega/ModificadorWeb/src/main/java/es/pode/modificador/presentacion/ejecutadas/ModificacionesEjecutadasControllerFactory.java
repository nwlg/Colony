// license-header java merge-point
package es.pode.modificador.presentacion.ejecutadas;

public class ModificacionesEjecutadasControllerFactory
{
    private final static ModificacionesEjecutadasController INSTANCE = new ModificacionesEjecutadasControllerImpl();

    public final static ModificacionesEjecutadasController getModificacionesEjecutadasControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.planificador.modificarTarea;

public class ObtenerTareaControllerFactory
{
    private final static ObtenerTareaController INSTANCE = new ObtenerTareaControllerImpl();

    public final static ObtenerTareaController getObtenerTareaControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.planificador.ejecutarTarea;

public class EjecutarTareaControllerFactory
{
    private final static EjecutarTareaController INSTANCE = new EjecutarTareaControllerImpl();

    public final static EjecutarTareaController getEjecutarTareaControllerInstance()
    {
        return INSTANCE;
    }
}
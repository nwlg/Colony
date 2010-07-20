// license-header java merge-point
package es.pode.administracion.presentacion.planificador.crearTarea;

public class CrearTareaControllerFactory
{
    private final static CrearTareaController INSTANCE = new CrearTareaControllerImpl();

    public final static CrearTareaController getCrearTareaControllerInstance()
    {
        return INSTANCE;
    }
}
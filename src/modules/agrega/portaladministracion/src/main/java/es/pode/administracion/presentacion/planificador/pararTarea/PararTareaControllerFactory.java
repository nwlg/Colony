// license-header java merge-point
package es.pode.administracion.presentacion.planificador.pararTarea;

public class PararTareaControllerFactory
{
    private final static PararTareaController INSTANCE = new PararTareaControllerImpl();

    public final static PararTareaController getPararTareaControllerInstance()
    {
        return INSTANCE;
    }
}
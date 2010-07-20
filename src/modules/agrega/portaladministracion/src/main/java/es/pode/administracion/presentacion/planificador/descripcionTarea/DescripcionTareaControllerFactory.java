// license-header java merge-point
package es.pode.administracion.presentacion.planificador.descripcionTarea;

public class DescripcionTareaControllerFactory
{
    private final static DescripcionTareaController INSTANCE = new DescripcionTareaControllerImpl();

    public final static DescripcionTareaController getDescripcionTareaControllerInstance()
    {
        return INSTANCE;
    }
}
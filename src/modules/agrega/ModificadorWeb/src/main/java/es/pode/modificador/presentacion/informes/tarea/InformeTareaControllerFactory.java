// license-header java merge-point
package es.pode.modificador.presentacion.informes.tarea;

public class InformeTareaControllerFactory
{
    private final static InformeTareaController INSTANCE = new InformeTareaControllerImpl();

    public final static InformeTareaController getInformeTareaControllerInstance()
    {
        return INSTANCE;
    }
}
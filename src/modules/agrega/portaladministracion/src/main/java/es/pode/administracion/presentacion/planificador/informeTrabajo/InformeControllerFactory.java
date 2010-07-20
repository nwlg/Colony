// license-header java merge-point
package es.pode.administracion.presentacion.planificador.informeTrabajo;

public class InformeControllerFactory
{
    private final static InformeController INSTANCE = new InformeControllerImpl();

    public final static InformeController getInformeControllerInstance()
    {
        return INSTANCE;
    }
}
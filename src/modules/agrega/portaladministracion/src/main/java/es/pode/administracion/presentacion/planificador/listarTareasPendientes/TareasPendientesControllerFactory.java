// license-header java merge-point
package es.pode.administracion.presentacion.planificador.listarTareasPendientes;

public class TareasPendientesControllerFactory
{
    private final static TareasPendientesController INSTANCE = new TareasPendientesControllerImpl();

    public final static TareasPendientesController getTareasPendientesControllerInstance()
    {
        return INSTANCE;
    }
}
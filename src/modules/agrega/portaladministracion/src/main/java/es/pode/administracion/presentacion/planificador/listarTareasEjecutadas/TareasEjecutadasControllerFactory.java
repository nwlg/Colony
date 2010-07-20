// license-header java merge-point
package es.pode.administracion.presentacion.planificador.listarTareasEjecutadas;

public class TareasEjecutadasControllerFactory
{
    private final static TareasEjecutadasController INSTANCE = new TareasEjecutadasControllerImpl();

    public final static TareasEjecutadasController getTareasEjecutadasControllerInstance()
    {
        return INSTANCE;
    }
}
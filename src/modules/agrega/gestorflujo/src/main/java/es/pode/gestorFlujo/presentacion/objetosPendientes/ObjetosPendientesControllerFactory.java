// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes;

public class ObjetosPendientesControllerFactory
{
    private final static ObjetosPendientesController INSTANCE = new ObjetosPendientesControllerImpl();

    public final static ObjetosPendientesController getObjetosPendientesControllerInstance()
    {
        return INSTANCE;
    }
}
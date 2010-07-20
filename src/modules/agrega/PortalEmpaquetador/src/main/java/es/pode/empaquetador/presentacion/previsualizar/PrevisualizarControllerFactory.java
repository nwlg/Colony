// license-header java merge-point
package es.pode.empaquetador.presentacion.previsualizar;

public class PrevisualizarControllerFactory
{
    private final static PrevisualizarController INSTANCE = new PrevisualizarControllerImpl();

    public final static PrevisualizarController getPrevisualizarControllerInstance()
    {
        return INSTANCE;
    }
}
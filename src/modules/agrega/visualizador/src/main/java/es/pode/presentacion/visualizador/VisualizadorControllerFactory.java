// license-header java merge-point
package es.pode.presentacion.visualizador;

public class VisualizadorControllerFactory
{
    private final static VisualizadorController INSTANCE = new VisualizadorControllerImpl();

    public final static VisualizadorController getVisualizadorControllerInstance()
    {
        return INSTANCE;
    }
}
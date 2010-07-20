// license-header java merge-point
package es.pode.presentacion.visualizadorAdl;

public class VisualizadorAdlControllerFactory
{
    private final static VisualizadorAdlController INSTANCE = new VisualizadorAdlControllerImpl();

    public final static VisualizadorAdlController getVisualizadorAdlControllerInstance()
    {
        return INSTANCE;
    }
}
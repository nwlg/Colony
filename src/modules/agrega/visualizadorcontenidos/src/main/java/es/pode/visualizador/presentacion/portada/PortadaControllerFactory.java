// license-header java merge-point
package es.pode.visualizador.presentacion.portada;

public class PortadaControllerFactory
{
    private final static PortadaController INSTANCE = new PortadaControllerImpl();

    public final static PortadaController getPortadaControllerInstance()
    {
        return INSTANCE;
    }
}
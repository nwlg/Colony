// license-header java merge-point
package es.pode.visualizador.presentacion.descargas;

public class DescargasControllerFactory
{
    private final static DescargasController INSTANCE = new DescargasControllerImpl();

    public final static DescargasController getDescargasControllerInstance()
    {
        return INSTANCE;
    }
}
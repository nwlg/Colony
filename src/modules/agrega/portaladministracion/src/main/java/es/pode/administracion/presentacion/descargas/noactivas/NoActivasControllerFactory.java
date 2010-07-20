// license-header java merge-point
package es.pode.administracion.presentacion.descargas.noactivas;

public class NoActivasControllerFactory
{
    private final static NoActivasController INSTANCE = new NoActivasControllerImpl();

    public final static NoActivasController getNoActivasControllerInstance()
    {
        return INSTANCE;
    }
}
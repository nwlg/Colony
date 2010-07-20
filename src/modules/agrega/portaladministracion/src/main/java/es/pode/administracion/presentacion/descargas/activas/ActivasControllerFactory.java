// license-header java merge-point
package es.pode.administracion.presentacion.descargas.activas;

public class ActivasControllerFactory
{
    private final static ActivasController INSTANCE = new ActivasControllerImpl();

    public final static ActivasController getActivasControllerInstance()
    {
        return INSTANCE;
    }
}
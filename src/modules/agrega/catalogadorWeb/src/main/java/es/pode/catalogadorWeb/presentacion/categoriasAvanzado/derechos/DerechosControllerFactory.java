// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos;

public class DerechosControllerFactory
{
    private final static DerechosController INSTANCE = new DerechosControllerImpl();

    public final static DerechosController getDerechosControllerInstance()
    {
        return INSTANCE;
    }
}
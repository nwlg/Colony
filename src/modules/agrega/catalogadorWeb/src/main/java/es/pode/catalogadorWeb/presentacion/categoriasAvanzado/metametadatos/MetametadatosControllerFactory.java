// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.metametadatos;

public class MetametadatosControllerFactory
{
    private final static MetametadatosController INSTANCE = new MetametadatosControllerImpl();

    public final static MetametadatosController getMetametadatosControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

public class VerMetadatosControllerFactory
{
    private final static VerMetadatosController INSTANCE = new VerMetadatosControllerImpl();

    public final static VerMetadatosController getVerMetadatosControllerInstance()
    {
        return INSTANCE;
    }
}
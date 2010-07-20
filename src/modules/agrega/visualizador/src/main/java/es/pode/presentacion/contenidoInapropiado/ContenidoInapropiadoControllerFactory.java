// license-header java merge-point
package es.pode.presentacion.contenidoInapropiado;

public class ContenidoInapropiadoControllerFactory
{
    private final static ContenidoInapropiadoController INSTANCE = new ContenidoInapropiadoControllerImpl();

    public final static ContenidoInapropiadoController getContenidoInapropiadoControllerInstance()
    {
        return INSTANCE;
    }
}
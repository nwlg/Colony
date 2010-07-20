// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar.archivos;

public class AsociacionArchivosControllerFactory
{
    private final static AsociacionArchivosController INSTANCE = new AsociacionArchivosControllerImpl();

    public final static AsociacionArchivosController getAsociacionArchivosControllerInstance()
    {
        return INSTANCE;
    }
}
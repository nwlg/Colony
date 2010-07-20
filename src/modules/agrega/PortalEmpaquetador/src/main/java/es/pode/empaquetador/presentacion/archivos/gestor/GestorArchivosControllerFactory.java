// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.gestor;

public class GestorArchivosControllerFactory
{
    private final static GestorArchivosController INSTANCE = new GestorArchivosControllerImpl();

    public final static GestorArchivosController getGestorArchivosControllerInstance()
    {
        return INSTANCE;
    }
}
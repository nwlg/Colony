// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.creararchivo;

public class CrearArchivoControllerFactory
{
    private final static CrearArchivoController INSTANCE = new CrearArchivoControllerImpl();

    public final static CrearArchivoController getCrearArchivoControllerInstance()
    {
        return INSTANCE;
    }
}
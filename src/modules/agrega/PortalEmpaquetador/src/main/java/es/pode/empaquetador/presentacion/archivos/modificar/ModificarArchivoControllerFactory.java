// license-header java merge-point
package es.pode.empaquetador.presentacion.archivos.modificar;

public class ModificarArchivoControllerFactory
{
    private final static ModificarArchivoController INSTANCE = new ModificarArchivoControllerImpl();

    public final static ModificarArchivoController getModificarArchivoControllerInstance()
    {
        return INSTANCE;
    }
}
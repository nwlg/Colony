// license-header java merge-point
package es.pode.tagging.presentacion.adminTag.mostrarOdes;

public class MostrarOdesControllerFactory
{
    private final static MostrarOdesController INSTANCE = new MostrarOdesControllerImpl();

    public final static MostrarOdesController getMostrarOdesControllerInstance()
    {
        return INSTANCE;
    }
}
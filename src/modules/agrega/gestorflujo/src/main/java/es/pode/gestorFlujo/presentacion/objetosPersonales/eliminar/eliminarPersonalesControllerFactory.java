// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales.eliminar;

public class eliminarPersonalesControllerFactory
{
    private final static eliminarPersonalesController INSTANCE = new eliminarPersonalesControllerImpl();

    public final static eliminarPersonalesController geteliminarPersonalesControllerInstance()
    {
        return INSTANCE;
    }
}
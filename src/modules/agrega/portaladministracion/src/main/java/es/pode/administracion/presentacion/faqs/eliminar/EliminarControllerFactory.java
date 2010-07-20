// license-header java merge-point
package es.pode.administracion.presentacion.faqs.eliminar;

public class EliminarControllerFactory
{
    private final static EliminarController INSTANCE = new EliminarControllerImpl();

    public final static EliminarController getEliminarControllerInstance()
    {
        return INSTANCE;
    }
}
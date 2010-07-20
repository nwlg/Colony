// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPendientes.Eliminar;

public class EliminarControllerFactory
{
    private final static EliminarController INSTANCE = new EliminarControllerImpl();

    public final static EliminarController getEliminarControllerInstance()
    {
        return INSTANCE;
    }
}
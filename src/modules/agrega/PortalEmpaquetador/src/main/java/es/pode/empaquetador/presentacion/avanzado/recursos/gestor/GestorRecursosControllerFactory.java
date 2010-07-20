// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.gestor;

public class GestorRecursosControllerFactory
{
    private final static GestorRecursosController INSTANCE = new GestorRecursosControllerImpl();

    public final static GestorRecursosController getGestorRecursosControllerInstance()
    {
        return INSTANCE;
    }
}
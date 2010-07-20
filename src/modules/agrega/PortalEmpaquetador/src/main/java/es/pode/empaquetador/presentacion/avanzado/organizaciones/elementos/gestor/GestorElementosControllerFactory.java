// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.gestor;

public class GestorElementosControllerFactory
{
    private final static GestorElementosController INSTANCE = new GestorElementosControllerImpl();

    public final static GestorElementosController getGestorElementosControllerInstance()
    {
        return INSTANCE;
    }
}
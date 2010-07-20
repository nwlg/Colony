// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar.repositorio;

public class AbrirBuscadorControllerFactory
{
    private final static AbrirBuscadorController INSTANCE = new AbrirBuscadorControllerImpl();

    public final static AbrirBuscadorController getAbrirBuscadorControllerInstance()
    {
        return INSTANCE;
    }
}
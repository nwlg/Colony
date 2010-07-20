// license-header java merge-point
package es.pode.empaquetador.presentacion.salir;

public class SalirControllerFactory
{
    private final static SalirController INSTANCE = new SalirControllerImpl();

    public final static SalirController getSalirControllerInstance()
    {
        return INSTANCE;
    }
}
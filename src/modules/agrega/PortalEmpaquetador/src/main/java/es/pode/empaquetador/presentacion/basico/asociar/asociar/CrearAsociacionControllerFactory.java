// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar.asociar;

public class CrearAsociacionControllerFactory
{
    private final static CrearAsociacionController INSTANCE = new CrearAsociacionControllerImpl();

    public final static CrearAsociacionController getCrearAsociacionControllerInstance()
    {
        return INSTANCE;
    }
}
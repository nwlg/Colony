// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar.local;

public class AgregarLocalControllerFactory
{
    private final static AgregarLocalController INSTANCE = new AgregarLocalControllerImpl();

    public final static AgregarLocalController getAgregarLocalControllerInstance()
    {
        return INSTANCE;
    }
}
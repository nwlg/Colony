// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar;

public class AgregarSubmanifiestoControllerFactory
{
    private final static AgregarSubmanifiestoController INSTANCE = new AgregarSubmanifiestoControllerImpl();

    public final static AgregarSubmanifiestoController getAgregarSubmanifiestoControllerInstance()
    {
        return INSTANCE;
    }
}
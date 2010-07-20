// license-header java merge-point
package es.pode.empaquetador.presentacion.agregar.personales;

public class AgregarPersonalesControllerFactory
{
    private final static AgregarPersonalesController INSTANCE = new AgregarPersonalesControllerImpl();

    public final static AgregarPersonalesController getAgregarPersonalesControllerInstance()
    {
        return INSTANCE;
    }
}
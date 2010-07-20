// license-header java merge-point
package es.pode.empaquetador.presentacion.iniciarEmpaquetador;

public class InicioEmpaquetadorControllerFactory
{
    private final static InicioEmpaquetadorController INSTANCE = new InicioEmpaquetadorControllerImpl();

    public final static InicioEmpaquetadorController getInicioEmpaquetadorControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.verUsuarioPendiente;

public class VerUsuarioPendienteControllerFactory
{
    private final static VerUsuarioPendienteController INSTANCE = new VerUsuarioPendienteControllerImpl();

    public final static VerUsuarioPendienteController getVerUsuarioPendienteControllerInstance()
    {
        return INSTANCE;
    }
}
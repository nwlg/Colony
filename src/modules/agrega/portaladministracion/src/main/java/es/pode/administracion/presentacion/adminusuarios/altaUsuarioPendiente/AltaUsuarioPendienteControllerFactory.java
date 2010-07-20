// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.altaUsuarioPendiente;

public class AltaUsuarioPendienteControllerFactory
{
    private final static AltaUsuarioPendienteController INSTANCE = new AltaUsuarioPendienteControllerImpl();

    public final static AltaUsuarioPendienteController getAltaUsuarioPendienteControllerInstance()
    {
        return INSTANCE;
    }
}
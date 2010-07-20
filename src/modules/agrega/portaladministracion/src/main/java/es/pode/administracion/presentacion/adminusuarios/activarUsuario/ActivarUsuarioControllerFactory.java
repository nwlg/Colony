// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.activarUsuario;

public class ActivarUsuarioControllerFactory
{
    private final static ActivarUsuarioController INSTANCE = new ActivarUsuarioControllerImpl();

    public final static ActivarUsuarioController getActivarUsuarioControllerInstance()
    {
        return INSTANCE;
    }
}
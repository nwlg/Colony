// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.desactivarUsuario;

public class DesactivarUsuarioControllerFactory
{
    private final static DesactivarUsuarioController INSTANCE = new DesactivarUsuarioControllerImpl();

    public final static DesactivarUsuarioController getDesactivarUsuarioControllerInstance()
    {
        return INSTANCE;
    }
}
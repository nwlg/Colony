// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.altaUsuario;

public class AltaUsuarioControllerFactory
{
    private final static AltaUsuarioController INSTANCE = new AltaUsuarioControllerImpl();

    public final static AltaUsuarioController getAltaUsuarioControllerInstance()
    {
        return INSTANCE;
    }
}
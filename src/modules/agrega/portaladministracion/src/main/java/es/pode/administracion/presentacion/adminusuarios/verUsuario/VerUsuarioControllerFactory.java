// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.verUsuario;

public class VerUsuarioControllerFactory
{
    private final static VerUsuarioController INSTANCE = new VerUsuarioControllerImpl();

    public final static VerUsuarioController getVerUsuarioControllerInstance()
    {
        return INSTANCE;
    }
}
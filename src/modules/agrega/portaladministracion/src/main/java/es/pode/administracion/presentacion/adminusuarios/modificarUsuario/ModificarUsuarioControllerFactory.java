// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.modificarUsuario;

public class ModificarUsuarioControllerFactory
{
    private final static ModificarUsuarioController INSTANCE = new ModificarUsuarioControllerImpl();

    public final static ModificarUsuarioController getModificarUsuarioControllerInstance()
    {
        return INSTANCE;
    }
}
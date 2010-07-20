// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.bajaUsuario;

public class BajaUsuarioControllerFactory
{
    private final static BajaUsuarioController INSTANCE = new BajaUsuarioControllerImpl();

    public final static BajaUsuarioController getBajaUsuarioControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.listarUsuariosInactivos;

public class ListarUsuariosInactivosControllerFactory
{
    private final static ListarUsuariosInactivosController INSTANCE = new ListarUsuariosInactivosControllerImpl();

    public final static ListarUsuariosInactivosController getListarUsuariosInactivosControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.listarUsuarios;

public class ListarUsuariosControllerFactory
{
    private final static ListarUsuariosController INSTANCE = new ListarUsuariosControllerImpl();

    public final static ListarUsuariosController getListarUsuariosControllerInstance()
    {
        return INSTANCE;
    }
}
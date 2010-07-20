// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.listarUsuariosPendientes;

public class ListarUsuariosPendientesControllerFactory
{
    private final static ListarUsuariosPendientesController INSTANCE = new ListarUsuariosPendientesControllerImpl();

    public final static ListarUsuariosPendientesController getListarUsuariosPendientesControllerInstance()
    {
        return INSTANCE;
    }
}
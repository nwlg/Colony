// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.listarGrupos;

public class ListarGruposControllerFactory
{
    private final static ListarGruposController INSTANCE = new ListarGruposControllerImpl();

    public final static ListarGruposController getListarGruposControllerInstance()
    {
        return INSTANCE;
    }
}
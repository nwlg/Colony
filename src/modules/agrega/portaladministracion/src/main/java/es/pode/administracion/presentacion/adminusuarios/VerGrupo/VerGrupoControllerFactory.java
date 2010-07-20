// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.VerGrupo;

public class VerGrupoControllerFactory
{
    private final static VerGrupoController INSTANCE = new VerGrupoControllerImpl();

    public final static VerGrupoController getVerGrupoControllerInstance()
    {
        return INSTANCE;
    }
}
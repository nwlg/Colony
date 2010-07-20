// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.altaGrupo;

public class AltaGrupoControllerFactory
{
    private final static AltaGrupoController INSTANCE = new AltaGrupoControllerImpl();

    public final static AltaGrupoController getAltaGrupoControllerInstance()
    {
        return INSTANCE;
    }
}
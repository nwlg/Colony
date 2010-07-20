// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.modificarGrupo;

public class ModificarGruposControllerFactory
{
    private final static ModificarGruposController INSTANCE = new ModificarGruposControllerImpl();

    public final static ModificarGruposController getModificarGruposControllerInstance()
    {
        return INSTANCE;
    }
}
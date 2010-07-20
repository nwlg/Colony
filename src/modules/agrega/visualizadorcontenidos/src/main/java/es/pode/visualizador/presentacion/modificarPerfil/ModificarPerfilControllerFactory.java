// license-header java merge-point
package es.pode.visualizador.presentacion.modificarPerfil;

public class ModificarPerfilControllerFactory
{
    private final static ModificarPerfilController INSTANCE = new ModificarPerfilControllerImpl();

    public final static ModificarPerfilController getModificarPerfilControllerInstance()
    {
        return INSTANCE;
    }
}
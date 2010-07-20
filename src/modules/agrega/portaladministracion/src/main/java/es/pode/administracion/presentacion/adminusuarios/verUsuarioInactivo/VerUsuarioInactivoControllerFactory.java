// license-header java merge-point
package es.pode.administracion.presentacion.adminusuarios.verUsuarioInactivo;

public class VerUsuarioInactivoControllerFactory
{
    private final static VerUsuarioInactivoController INSTANCE = new VerUsuarioInactivoControllerImpl();

    public final static VerUsuarioInactivoController getVerUsuarioInactivoControllerInstance()
    {
        return INSTANCE;
    }
}
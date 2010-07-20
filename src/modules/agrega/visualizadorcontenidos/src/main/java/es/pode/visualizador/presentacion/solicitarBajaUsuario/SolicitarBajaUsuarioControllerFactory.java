// license-header java merge-point
package es.pode.visualizador.presentacion.solicitarBajaUsuario;

public class SolicitarBajaUsuarioControllerFactory
{
    private final static SolicitarBajaUsuarioController INSTANCE = new SolicitarBajaUsuarioControllerImpl();

    public final static SolicitarBajaUsuarioController getSolicitarBajaUsuarioControllerInstance()
    {
        return INSTANCE;
    }
}
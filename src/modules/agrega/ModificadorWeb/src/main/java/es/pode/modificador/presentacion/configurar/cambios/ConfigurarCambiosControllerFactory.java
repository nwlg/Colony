// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios;

public class ConfigurarCambiosControllerFactory
{
    private final static ConfigurarCambiosController INSTANCE = new ConfigurarCambiosControllerImpl();

    public final static ConfigurarCambiosController getConfigurarCambiosControllerInstance()
    {
        return INSTANCE;
    }
}
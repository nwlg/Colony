// license-header java merge-point
package es.pode.modificador.presentacion.configurar.modificacion;

public class ConfigurarModificacionControllerFactory
{
    private final static ConfigurarModificacionController INSTANCE = new ConfigurarModificacionControllerImpl();

    public final static ConfigurarModificacionController getConfigurarModificacionControllerInstance()
    {
        return INSTANCE;
    }
}
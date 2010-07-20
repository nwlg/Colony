// license-header java merge-point
package es.pode.modificador.presentacion.configurar.nombre;

public class ConfigurarNombreControllerFactory
{
    private final static ConfigurarNombreController INSTANCE = new ConfigurarNombreControllerImpl();

    public final static ConfigurarNombreController getConfigurarNombreControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos;

public class ConfigurarObjetosControllerFactory
{
    private final static ConfigurarObjetosController INSTANCE = new ConfigurarObjetosControllerImpl();

    public final static ConfigurarObjetosController getConfigurarObjetosControllerInstance()
    {
        return INSTANCE;
    }
}
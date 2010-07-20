// license-header java merge-point
package es.pode.buscador.presentacion.basico.enviarMail;

public class EnviarMailControllerFactory
{
    private final static EnviarMailController INSTANCE = new EnviarMailControllerImpl();

    public final static EnviarMailController getEnviarMailControllerInstance()
    {
        return INSTANCE;
    }
}
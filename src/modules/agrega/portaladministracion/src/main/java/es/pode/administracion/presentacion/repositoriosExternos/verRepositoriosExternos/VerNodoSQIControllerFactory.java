// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.verRepositoriosExternos;

public class VerNodoSQIControllerFactory
{
    private final static VerNodoSQIController INSTANCE = new VerNodoSQIControllerImpl();

    public final static VerNodoSQIController getVerNodoSQIControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.altaRepositoriosExternos;

public class AltaNodoSQIControllerFactory
{
    private final static AltaNodoSQIController INSTANCE = new AltaNodoSQIControllerImpl();

    public final static AltaNodoSQIController getAltaNodoSQIControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.bajaRepositoriosExternos;

public class BajaNodoSQIControllerFactory
{
    private final static BajaNodoSQIController INSTANCE = new BajaNodoSQIControllerImpl();

    public final static BajaNodoSQIController getBajaNodoSQIControllerInstance()
    {
        return INSTANCE;
    }
}
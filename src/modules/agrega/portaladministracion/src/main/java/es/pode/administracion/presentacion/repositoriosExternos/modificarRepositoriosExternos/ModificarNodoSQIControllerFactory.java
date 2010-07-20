// license-header java merge-point
package es.pode.administracion.presentacion.repositoriosExternos.modificarRepositoriosExternos;

public class ModificarNodoSQIControllerFactory
{
    private final static ModificarNodoSQIController INSTANCE = new ModificarNodoSQIControllerImpl();

    public final static ModificarNodoSQIController getModificarNodoSQIControllerInstance()
    {
        return INSTANCE;
    }
}
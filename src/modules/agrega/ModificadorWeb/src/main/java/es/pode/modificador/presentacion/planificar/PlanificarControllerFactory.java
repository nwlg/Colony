// license-header java merge-point
package es.pode.modificador.presentacion.planificar;

public class PlanificarControllerFactory
{
    private final static PlanificarController INSTANCE = new PlanificarControllerImpl();

    public final static PlanificarController getPlanificarControllerInstance()
    {
        return INSTANCE;
    }
}
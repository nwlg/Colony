// license-header java merge-point
package es.pode.modificador.presentacion.informes.ode;

public class InformeODEControllerFactory
{
    private final static InformeODEController INSTANCE = new InformeODEControllerImpl();

    public final static InformeODEController getInformeODEControllerInstance()
    {
        return INSTANCE;
    }
}
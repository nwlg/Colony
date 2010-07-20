// license-header java merge-point
package es.pode.empaquetador.presentacion.session;

public class SesionCaducadaControllerFactory
{
    private final static SesionCaducadaController INSTANCE = new SesionCaducadaControllerImpl();

    public final static SesionCaducadaController getSesionCaducadaControllerInstance()
    {
        return INSTANCE;
    }
}
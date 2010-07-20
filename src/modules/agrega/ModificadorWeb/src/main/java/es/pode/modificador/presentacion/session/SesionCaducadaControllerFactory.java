// license-header java merge-point
package es.pode.modificador.presentacion.session;

public class SesionCaducadaControllerFactory
{
    private final static SesionCaducadaController INSTANCE = new SesionCaducadaControllerImpl();

    public final static SesionCaducadaController getSesionCaducadaControllerInstance()
    {
        return INSTANCE;
    }
}
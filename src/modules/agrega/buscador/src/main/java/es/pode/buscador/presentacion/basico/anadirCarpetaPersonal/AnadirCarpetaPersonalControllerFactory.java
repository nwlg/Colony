// license-header java merge-point
package es.pode.buscador.presentacion.basico.anadirCarpetaPersonal;

public class AnadirCarpetaPersonalControllerFactory
{
    private final static AnadirCarpetaPersonalController INSTANCE = new AnadirCarpetaPersonalControllerImpl();

    public final static AnadirCarpetaPersonalController getAnadirCarpetaPersonalControllerInstance()
    {
        return INSTANCE;
    }
}
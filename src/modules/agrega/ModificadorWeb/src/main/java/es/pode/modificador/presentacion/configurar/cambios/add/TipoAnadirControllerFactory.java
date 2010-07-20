// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.add;

public class TipoAnadirControllerFactory
{
    private final static TipoAnadirController INSTANCE = new TipoAnadirControllerImpl();

    public final static TipoAnadirController getTipoAnadirControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.navegarLom;

public class NavegarLomControllerFactory
{
    private final static NavegarLomController INSTANCE = new NavegarLomControllerImpl();

    public final static NavegarLomController getNavegarLomControllerInstance()
    {
        return INSTANCE;
    }
}
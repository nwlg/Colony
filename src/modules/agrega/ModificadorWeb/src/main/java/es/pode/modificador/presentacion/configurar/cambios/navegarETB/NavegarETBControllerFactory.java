// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.navegarETB;

public class NavegarETBControllerFactory
{
    private final static NavegarETBController INSTANCE = new NavegarETBControllerImpl();

    public final static NavegarETBController getNavegarETBControllerInstance()
    {
        return INSTANCE;
    }
}
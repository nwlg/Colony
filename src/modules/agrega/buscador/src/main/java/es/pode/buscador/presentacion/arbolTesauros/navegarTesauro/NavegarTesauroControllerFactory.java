// license-header java merge-point
package es.pode.buscador.presentacion.arbolTesauros.navegarTesauro;

public class NavegarTesauroControllerFactory
{
    private final static NavegarTesauroController INSTANCE = new NavegarTesauroControllerImpl();

    public final static NavegarTesauroController getNavegarTesauroControllerInstance()
    {
        return INSTANCE;
    }
}
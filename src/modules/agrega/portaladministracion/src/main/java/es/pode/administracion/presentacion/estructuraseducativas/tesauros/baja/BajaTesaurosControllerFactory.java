// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.tesauros.baja;

public class BajaTesaurosControllerFactory
{
    private final static BajaTesaurosController INSTANCE = new BajaTesaurosControllerImpl();

    public final static BajaTesaurosController getBajaTesaurosControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.tesauros.alta;

public class AltaTesaurosControllerFactory
{
    private final static AltaTesaurosController INSTANCE = new AltaTesaurosControllerImpl();

    public final static AltaTesaurosController getAltaTesaurosControllerInstance()
    {
        return INSTANCE;
    }
}
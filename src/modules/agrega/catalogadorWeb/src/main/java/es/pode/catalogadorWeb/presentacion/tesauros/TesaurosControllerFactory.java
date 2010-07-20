// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.tesauros;

public class TesaurosControllerFactory
{
    private final static TesaurosController INSTANCE = new TesaurosControllerImpl();

    public final static TesaurosController getTesaurosControllerInstance()
    {
        return INSTANCE;
    }
}
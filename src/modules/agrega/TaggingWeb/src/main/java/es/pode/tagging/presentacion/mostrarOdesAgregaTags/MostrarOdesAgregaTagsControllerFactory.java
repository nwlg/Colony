// license-header java merge-point
package es.pode.tagging.presentacion.mostrarOdesAgregaTags;

public class MostrarOdesAgregaTagsControllerFactory
{
    private final static MostrarOdesAgregaTagsController INSTANCE = new MostrarOdesAgregaTagsControllerImpl();

    public final static MostrarOdesAgregaTagsController getMostrarOdesAgregaTagsControllerInstance()
    {
        return INSTANCE;
    }
}
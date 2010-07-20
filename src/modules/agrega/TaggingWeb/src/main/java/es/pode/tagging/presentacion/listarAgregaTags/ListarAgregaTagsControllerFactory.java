// license-header java merge-point
package es.pode.tagging.presentacion.listarAgregaTags;

public class ListarAgregaTagsControllerFactory
{
    private final static ListarAgregaTagsController INSTANCE = new ListarAgregaTagsControllerImpl();

    public final static ListarAgregaTagsController getListarAgregaTagsControllerInstance()
    {
        return INSTANCE;
    }
}
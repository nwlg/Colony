// license-header java merge-point
package es.pode.tagging.presentacion.listarMisTags;

public class ListarMisTagsControllerFactory
{
    private final static ListarMisTagsController INSTANCE = new ListarMisTagsControllerImpl();

    public final static ListarMisTagsController getListarMisTagsControllerInstance()
    {
        return INSTANCE;
    }
}
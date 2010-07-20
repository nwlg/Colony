// license-header java merge-point
package es.pode.tagging.presentacion.mostrarOdesMisTags;

public class MostrarOdesMisTagsControllerFactory
{
    private final static MostrarOdesMisTagsController INSTANCE = new MostrarOdesMisTagsControllerImpl();

    public final static MostrarOdesMisTagsController getMostrarOdesMisTagsControllerInstance()
    {
        return INSTANCE;
    }
}
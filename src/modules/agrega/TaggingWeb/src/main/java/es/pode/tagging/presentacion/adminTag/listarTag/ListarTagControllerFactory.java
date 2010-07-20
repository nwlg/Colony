// license-header java merge-point
package es.pode.tagging.presentacion.adminTag.listarTag;

public class ListarTagControllerFactory
{
    private final static ListarTagController INSTANCE = new ListarTagControllerImpl();

    public final static ListarTagController getListarTagControllerInstance()
    {
        return INSTANCE;
    }
}
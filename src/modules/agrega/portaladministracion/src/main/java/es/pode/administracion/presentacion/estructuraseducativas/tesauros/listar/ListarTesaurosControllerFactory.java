// license-header java merge-point
package es.pode.administracion.presentacion.estructuraseducativas.tesauros.listar;

public class ListarTesaurosControllerFactory
{
    private final static ListarTesaurosController INSTANCE = new ListarTesaurosControllerImpl();

    public final static ListarTesaurosController getListarTesaurosControllerInstance()
    {
        return INSTANCE;
    }
}
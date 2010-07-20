// license-header java merge-point
package es.pode.buscador.presentacion.basico.listarComentarios;

public class ListarComentariosControllerFactory
{
    private final static ListarComentariosController INSTANCE = new ListarComentariosControllerImpl();

    public final static ListarComentariosController getListarComentariosControllerInstance()
    {
        return INSTANCE;
    }
}
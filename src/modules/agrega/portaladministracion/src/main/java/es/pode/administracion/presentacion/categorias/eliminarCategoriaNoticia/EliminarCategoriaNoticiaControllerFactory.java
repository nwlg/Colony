// license-header java merge-point
package es.pode.administracion.presentacion.categorias.eliminarCategoriaNoticia;

public class EliminarCategoriaNoticiaControllerFactory
{
    private final static EliminarCategoriaNoticiaController INSTANCE = new EliminarCategoriaNoticiaControllerImpl();

    public final static EliminarCategoriaNoticiaController getEliminarCategoriaNoticiaControllerInstance()
    {
        return INSTANCE;
    }
}
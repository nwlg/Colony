// license-header java merge-point
package es.pode.administracion.presentacion.categorias.crearCategoriaNoticia;

public class CrearCategoriaNoticiaControllerFactory
{
    private final static CrearCategoriaNoticiaController INSTANCE = new CrearCategoriaNoticiaControllerImpl();

    public final static CrearCategoriaNoticiaController getCrearCategoriaNoticiaControllerInstance()
    {
        return INSTANCE;
    }
}
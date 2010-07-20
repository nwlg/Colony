// license-header java merge-point
package es.pode.administracion.presentacion.categorias.modificarCategoriaNoticia;

public class ModificarCategoriaNoticiaControllerFactory
{
    private final static ModificarCategoriaNoticiaController INSTANCE = new ModificarCategoriaNoticiaControllerImpl();

    public final static ModificarCategoriaNoticiaController getModificarCategoriaNoticiaControllerInstance()
    {
        return INSTANCE;
    }
}
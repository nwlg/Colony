// license-header java merge-point
package es.pode.administracion.presentacion.categorias.categorias;

public class CategoriasControllerFactory
{
    private final static CategoriasController INSTANCE = new CategoriasControllerImpl();

    public final static CategoriasController getCategoriasControllerInstance()
    {
        return INSTANCE;
    }
}
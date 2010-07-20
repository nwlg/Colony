// license-header java merge-point
package es.pode.administracion.presentacion.categorias.verCategoria;

public class ObtenerCategoriaControllerFactory
{
    private final static ObtenerCategoriaController INSTANCE = new ObtenerCategoriaControllerImpl();

    public final static ObtenerCategoriaController getObtenerCategoriaControllerInstance()
    {
        return INSTANCE;
    }
}
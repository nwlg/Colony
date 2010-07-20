// license-header java merge-point
package es.pode.administracion.presentacion.categoriasFaqs.categoriasFaqs;

public class CategoriasFaqControllerFactory
{
    private final static CategoriasFaqController INSTANCE = new CategoriasFaqControllerImpl();

    public final static CategoriasFaqController getCategoriasFaqControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.categoriasFaqs.eliminarCategoriaFaq;

public class EliminarCategoriaFaqControllerFactory
{
    private final static EliminarCategoriaFaqController INSTANCE = new EliminarCategoriaFaqControllerImpl();

    public final static EliminarCategoriaFaqController getEliminarCategoriaFaqControllerInstance()
    {
        return INSTANCE;
    }
}
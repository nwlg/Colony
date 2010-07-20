// license-header java merge-point
package es.pode.administracion.presentacion.categoriasFaqs.verCategoriaFaq;

public class VerCategoriaFaqControllerFactory
{
    private final static VerCategoriaFaqController INSTANCE = new VerCategoriaFaqControllerImpl();

    public final static VerCategoriaFaqController getVerCategoriaFaqControllerInstance()
    {
        return INSTANCE;
    }
}
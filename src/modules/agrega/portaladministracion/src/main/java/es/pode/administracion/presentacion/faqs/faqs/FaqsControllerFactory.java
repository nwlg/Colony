// license-header java merge-point
package es.pode.administracion.presentacion.faqs.faqs;

public class FaqsControllerFactory
{
    private final static FaqsController INSTANCE = new FaqsControllerImpl();

    public final static FaqsController getFaqsControllerInstance()
    {
        return INSTANCE;
    }
}
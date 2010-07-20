// license-header java merge-point
package es.pode.administracion.presentacion.faqs.verFaq;

public class VerFaqControllerFactory
{
    private final static VerFaqController INSTANCE = new VerFaqControllerImpl();

    public final static VerFaqController getVerFaqControllerInstance()
    {
        return INSTANCE;
    }
}
// license-header java merge-point
package es.pode.administracion.presentacion.categoriasFaqs.crearCategoriaFaq;

public class CrearCategoriaFaqControllerFactory
{
    private final static CrearCategoriaFaqController INSTANCE = new CrearCategoriaFaqControllerImpl();

    public final static CrearCategoriaFaqController getCrearCategoriaFaqControllerInstance()
    {
        return INSTANCE;
    }
}
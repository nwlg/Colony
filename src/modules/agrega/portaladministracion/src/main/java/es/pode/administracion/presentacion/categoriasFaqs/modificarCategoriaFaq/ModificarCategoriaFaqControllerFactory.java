// license-header java merge-point
package es.pode.administracion.presentacion.categoriasFaqs.modificarCategoriaFaq;

public class ModificarCategoriaFaqControllerFactory
{
    private final static ModificarCategoriaFaqController INSTANCE = new ModificarCategoriaFaqControllerImpl();

    public final static ModificarCategoriaFaqController getModificarCategoriaFaqControllerInstance()
    {
        return INSTANCE;
    }
}